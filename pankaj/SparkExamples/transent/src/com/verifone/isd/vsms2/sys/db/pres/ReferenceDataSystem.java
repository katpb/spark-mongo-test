package com.verifone.isd.vsms2.sys.db.pres;

import com.verifone.isd.vsms2.sys.util.sax.SAXFilter;
import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.xerces.parsers.SAXParser;
import org.xml.sax.InputSource;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import com.verifone.isd.viper.eps.core.util.ViperPathResolver;

/**
 * Implementation class for IReferenceDataSystem. Reads the
 * entity class mappings from a file (configurable using the
 * property 'sys.db.persistClassMap') and creates the
 * IEntityPersistAdmin class using its getInstance() singleton
 * accessor static method.
 * @see IReferenceDataSystem
 * @version 1.0 Copyright(c) 2000-2007 Verifone, All Rights Reserved.
 */
public class ReferenceDataSystem implements IReferenceDataSystem {
    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.db.pres.ReferenceDataSystem.class);
    // Fallback filename; try from the properties file first
    private static final String COMMON_CLASSMAP_FILE = "persistClassMap.xml";
    private static final String APP_CLASSMAP_FILE = "persistClassMap.xml";
    private static ReferenceDataSystem theInstance;
    private HashMap <String, IEntityPersistAdmin> persistAdminsHash;
    private HashMap <String, PersistenceClassMap> classMaps;

    /**
     * Constructor that creates hash tables and loads the class mappings.
     * @param filename The location of the class mapping data.
     * @param appFileName The application file name.
     */
    private ReferenceDataSystem(String filename, String appFileName) {
        persistAdminsHash = new HashMap <String, IEntityPersistAdmin> ();
        classMaps =  new HashMap <String, PersistenceClassMap> ();
        loadClassMappings(filename, appFileName);
    }
    
    /**
     * Singleton accessor method.
     * @return The singleton ReferenceDataSystem object.
     * @throws Exception On error in getting the singleton object.
     */
    public static synchronized ReferenceDataSystem getInstance() throws Exception {
        if (theInstance == null) {
        	String commonFilename = null;
			if (ViperPathResolver.isViperPlatform()) {
				commonFilename = SysPropertyFactory
						.makeAbsoluteConfigPath(COMMON_CLASSMAP_FILE);
			} else {
				commonFilename = SysPropertyFactory
						.makeAbsoluteCommonConfigPath(COMMON_CLASSMAP_FILE);
			}
           String prop = SysPropertyFactory.getProperty("sys.db.persistClassMap", APP_CLASSMAP_FILE);
           String appFileName = SysPropertyFactory.makeAbsoluteConfigPath(prop);        

           theInstance = new ReferenceDataSystem(commonFilename, appFileName);
        }
        return theInstance;
    }
    
    /**
     * Returns the IEntityPersistAdmin for the requested entity dataset ID.
     * @param entityId Entity dataset ID (this should be in sync with Gempro's
     * rubyinfo.ldm dataset ID definition in rubyvar.c).
     * @throws DBException On error in creating the IEntityPersistAdmin class singleton.
     * @return IEntityPersistAdmin Object for the requested entity.
     */
    public IEntityPersistAdmin getPersistAdmin(int entityId) throws DBException {
        IEntityPersistAdmin admin = persistAdminsHash.get(String.valueOf(entityId));
        if (admin == null) {
            PersistenceClassMap reqdMap = this.getClassMap(entityId);
            if (reqdMap == null) {
                throw new DBException("No class map definition for dataset: " +entityId);
            }
            else {
                this.createPersistAdmins(entityId, reqdMap);
                admin = (IEntityPersistAdmin)persistAdminsHash.get(String.valueOf(entityId));
            }
        }
        return admin;
    }
    
    /**
     * Returns the IEntityPersistAdmin for the requested entity object.
     * @param domObj Entity object whose IEntityPersistAdmin is required.
     * @throws DBException On error in creating the IEntityPersistAdmin class singleton.
     * @return IEntityPersistAdmin Object for the requested entity.
     */
    public IEntityPersistAdmin getPersistAdmin(IEntityObject domObj) throws DBException {
        int entityId = this.getEntityId(domObj);
        return this.getPersistAdmin(entityId);
    }

    /**
     * Returns the entity ID for the given entity object.
     * @param domObj The entity object from which the ID will be taken.
     * @return The entity ID of the provided entity object.
     * @throws DBException It the entity object is missing its persistence class map.
     */
    private int getEntityId (IEntityObject domObj) throws DBException {
        String entClz = domObj.getClass().getName();
        PersistenceClassMap reqdMap = (PersistenceClassMap)classMaps.get(entClz);
        if (reqdMap == null) {
            throw new DBException("No class map definition for entity: " +entClz);
        }
        else {
            return reqdMap.getEntityId();
        }
    }

    /**
     * Returns the persistence class map for a given entity ID.
     * @param entityId The entity ID to be used.
     * @return The persistence class map or null.
     */
    private PersistenceClassMap getClassMap(int entityId) {
        Iterator <PersistenceClassMap> maps = this.classMaps.values().iterator();
        while (maps.hasNext()) {
            PersistenceClassMap curMap = maps.next();
            if (curMap.getEntityId() == entityId) {
                return curMap;
            }
        }
        return null;
    }

    /**
     * Creates persist admin objects for a given entity and persistence class map.
     * @param entityId The entity ID to be used.
     * @param reqdMap The persistence class map to be used.
     * @throws DBException On error.
     */
    private void createPersistAdmins(int entityId, PersistenceClassMap reqdMap) throws DBException {
        try {
            String key = String.valueOf(entityId);
            String pyPAClzName = reqdMap.getPrimaryPAClassName();
            if (pyPAClzName == null) {
                throw new DBException("Error creating persist admin: Class map not complete for entity " +entityId);                
            }
            else {
                IEntityPersistAdmin priAdm = null;
                synchronized(this) {
                    priAdm = persistAdminsHash.get(key);
                }
                /* Non-NULL check in place to make sure that some other thread had not called this method while the 
                 * current thread was waiting for the semaphore. Since PA addition to the hash tables is synchronized, 
                 * it is sufficient to check if primary PA is non-NULL within a synchronized block. 
                 * It is still possible for two threads to get beyond the above synchronized block back to back and 
                 * end up invoking the  getInstance of the PA thro' reflection, but this de-synchronization is to 
                 * protect threads that need to get a PA for a different dataset and were unable to (due to imporper
                 * implementation of the persist admin classes) until some other PA creation was completed. 
                 */
                if (priAdm != null) {
                    return;
                }
                Class priAdmClz = Class.forName(pyPAClzName);
                Class[] params = new Class[1];
                params[0] = reqdMap.getClass();
                Method singletonMethod = priAdmClz.getMethod("getInstance", params);
                Object[] methodParams = new Object[1];
                methodParams[0] = reqdMap;
                priAdm = (IEntityPersistAdmin)singletonMethod.invoke(null, methodParams);
                priAdm.setPreloadRequired(reqdMap.isPreloadPrimaryPA());
                int timeout = reqdMap.getPrimaryPATimeOut();
                if (timeout > 100) { //Ignore timeouts < 100 mSecs
                    priAdm.setTimeOut(timeout); 
                }
                String syPAClzName = reqdMap.getSecondaryPAClassName();
                if (syPAClzName != null) {
                    Class secAdmClz = Class.forName(syPAClzName);
                    params = new Class[1];
                    params[0] = reqdMap.getClass();
                    singletonMethod = secAdmClz.getMethod("getInstance", params);
                    methodParams = new Object[1];
                    methodParams[0] = reqdMap;
                    IEntityPersistAdmin secAdm = (IEntityPersistAdmin)singletonMethod.invoke(null, methodParams);
                    timeout = reqdMap.getSecondaryPATimeOut();
                    if (timeout > 100) { //Ignore timeouts < 100 mSecs
                        secAdm.setTimeOut(timeout);
                    }
                    if (priAdm instanceof IChainedEntityPersistAdmin) {
                        ((IChainedEntityPersistAdmin)priAdm).setSecondaryPersistAdmin(secAdm);
                    }
                    if (secAdm instanceof IChainedEntityPersistAdmin) {
                        ((IChainedEntityPersistAdmin)secAdm).setPrimaryPersistAdmin(priAdm);
                    }
                }
                synchronized(this) {
                    this.persistAdminsHash.put(key,priAdm);
                }
            }
     //       classMaps.remove(reqdMap.getEntityClass());
        }
        catch (Exception e) {
            if (e instanceof InvocationTargetException) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invocation target exception creating persist admin: ");
                sb.append(entityId);
                sb.append(" ");
                sb.append(reqdMap.getPrimaryPAClassName());
                logger.error(sb.toString(), e);
                sb.append(((InvocationTargetException)e).getTargetException().toString());
                throw new DBException(sb.toString());
            }
            else {
                throw new DBException("Error creating persist admin: " +entityId +" "
                +reqdMap.getPrimaryPAClassName() +" " +e.toString());
            }
        }
    }

    /**
     * Load the class mappings from the given file.
     * @param file The name of the file containing the class mappings.
     * @param appFileName
     */
    private void loadClassMappings(String file, String appFileName) {
        FileReader fr = null;
        FileReader afr = null;
        try {
            PersistenceClassMapHandler ch = new PersistenceClassMapHandler();
            fr = new FileReader(file);
            SAXFilter msf = new SAXFilter(new SAXParser(), ch);
            msf.parse(new InputSource(fr));
            
            File appFile = new File(appFileName);
            if (appFile.exists()) {
                afr = new FileReader(appFile);
                msf = new SAXFilter(new SAXParser(), ch);
                msf.parse(new InputSource(afr));
            }
            classMaps.putAll(ch.getClassMaps());
        }
        catch (Exception e) {
            logger.error("Error loading class maps from file " +file +": " +e);
        }
        finally {
            if (null != fr) {
                try {
                    fr.close();
                }
                catch (IOException ioe) {}
            }
            if (null != afr) {
                try {
                    afr.close();
                }
                catch (IOException ioe) {}
            }
        }
    }

    /**
     * Returns an array of entity IDs.
     * @return An array of entity IDs.
     */
    @Override
    public int[] getEntityIds() {
        java.util.ArrayList list = new ArrayList();
        Iterator <PersistenceClassMap> maps = this.classMaps.values().iterator();
        while (maps.hasNext()) {
            PersistenceClassMap curMap = (PersistenceClassMap) maps.next();
            list.add(new Integer(curMap.getEntityId()));
        }
        Collections.sort(list);
        int cnt = list.size();
        int[] idArray = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            idArray[i] = ((Integer)list.get(i)).intValue();
        }
        return idArray;
    }
 
    /*
     * Used for testing.
     */
    public static void main(String[] args) throws Exception {
        System.setProperty("home.common.dir", System.getProperty("user.dir"));
        System.out.println(System.getProperty("home.common.dir"));
        ReferenceDataSystem rd = ReferenceDataSystem.getInstance();
        Iterator <PersistenceClassMap> maps = rd.classMaps.values().iterator();
        int cnt = 0;
        while (maps.hasNext()) {
            PersistenceClassMap curMap = (PersistenceClassMap)maps.next();
            System.out.println("Entity " +curMap.getEntityId() +" " +curMap.getEntityClassName());
            System.out.println("\tPK: " +curMap.getEntityPKClassName());  
            System.out.println("\tPri PA: " +curMap.getPrimaryPAClassName() +" preload ? " 
            +curMap.isPreloadPrimaryPA() +" timeout: " +curMap.getPrimaryPATimeOut());
            System.out.println("\tSec PA: " +curMap.getSecondaryPAClassName() +" timeout: " +curMap.getSecondaryPATimeOut());    
            System.out.println("===========================");
            cnt++;
        }
        int[] ids = rd.getEntityIds();
        System.out.println("Total: " +cnt +" entity IDs: " +ids.length);        
        for (int i = 0; i < ids.length; i++) {
            System.out.print(ids[i] +",");
        }
    }    
}
