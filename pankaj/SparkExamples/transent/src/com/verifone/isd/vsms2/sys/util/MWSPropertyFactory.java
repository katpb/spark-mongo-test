package com.verifone.isd.vsms2.sys.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Factory class for Manager Workstation properties
 * @author T_ShailendraP1
 *
 */
public class MWSPropertyFactory {
	 private static Properties mwsConfiguration = null;
	    static final String MWS_CONFIG_PATH = "managerworkstation.prop";
	 private static final Logger theLogger;
	 
	    static {
	        theLogger = LoggerFactory.getLogger(MWSPropertyFactory.class);
	        try {
	            getInstance();
	        }
	        catch (Exception e) {
	            theLogger.error("Error loading MWSPropertyFactory", e);
	        }
	    }
	    
	    /**  return the one instance of configurable application properties database.
	     * @return the configurable Properties object
	     * @see java.lang.System#getProperties()
	     * @see java.util.Properties
	     * @exception Exception thrown on error
	     */
	    public static synchronized Properties getInstance() throws Exception
	    {
	        try {
	            if (mwsConfiguration == null) {
	            	mwsConfiguration = new Properties();
	                Properties tmp = new Properties();
	                String path = SysPropertyFactory.makeAbsoluteCommonConfigPath(MWS_CONFIG_PATH);
	                loadPropsFromFile(path, tmp);
	                mwsConfiguration = trimPropertyValues(tmp);
	            }
	        }
	        catch(Exception e) {
	            theLogger.error("Error in MWSPropertyFactory#getInstance", e);
	            throw e;
	        }
	        return mwsConfiguration;
	    }
	    
	    private MWSPropertyFactory()    // can't create an instance, static only
	    {
	    }
	/** Sets configurable property value
     * @param propName property name
     * @param propValue property value
     */    
    public static synchronized void setProperty(String propName, String propValue) {
    	if( propValue != null ) propValue = propValue.trim();
        if ((null != mwsConfiguration)) {
            mwsConfiguration.setProperty(propName, propValue);
        } 
    }
    
    
    /** Transparently gets configurable/ private property value
     * @param propName property name
     * @return property value
     */    
    public synchronized static String getProperty(String propName) {
        String propValue = null;
        if (null != mwsConfiguration) {
            propValue = mwsConfiguration.getProperty(propName);
        }
        return propValue;
    }
    
    /** Transparently gets configurable/ private property value
     * @param propName property name
     * @param defaultValue default value to be returned, if the property does not exist
     * @return property value
     */    
    public synchronized static String getProperty(String propName, String defaultValue) {
        String propValue = MWSPropertyFactory.getProperty(propName);
        return (propValue != null) ? propValue : defaultValue;
    }
    
    
    /**  save the active configurable properties to the database
     * @exception Exception thrown on error
     */
    public static synchronized void saveInstance() throws Exception
    {
        if (mwsConfiguration != null) {
            String path = SysPropertyFactory.makeAbsoluteCommonConfigPath(MWS_CONFIG_PATH);
            savePropsToFile(path, mwsConfiguration, "Manager WorkStation Properties");
        }
    }
    
    
    private static void loadPropsFromFile(String absolutePath, Properties props) throws Exception {
        String path = SysPropertyFactory.correctSeparator(absolutePath);
        File propFile = new File(path);
        InputStream stream = null;
        if (propFile.exists()) {
            try {
                stream = new BufferedInputStream(new FileInputStream(propFile));
                props.load(stream);
            }
            finally {
                if (null != stream) {
                    try {
                        stream.close();
                    }
                    catch (Exception e) {}
                }
            }
        }
    }

    private static void savePropsToFile(String absolutePath, Properties props, String comment) throws Exception {
        String path = SysPropertyFactory.correctSeparator(absolutePath);
        FileOutputStream fout = new FileOutputStream(path);
        BufferedOutputStream out = new BufferedOutputStream(fout);
        try {
            props.store(out, comment);
            out.flush();
        } finally {
            try {
                out.close();
            } catch (IOException ioe) {
            }
            try {
                fout.close();
            } catch (IOException ioe) {
            }
        }

    }
    
    /**
 	 * Removes the white spaces around the property values
 	 * @param properties
 	 */
    private static Properties trimPropertyValues(Properties properties) {
    	
    	Properties newProps = new Properties();
    	if(properties != null) {
	    	Set<Map.Entry<Object, Object>> entrySet = properties.entrySet();
	    	Iterator<Map.Entry<Object, Object>> iterator = entrySet.iterator();
	    	String key = null, val = null;
	    	while(iterator.hasNext()) {
	    		Map.Entry<Object, Object> entry=iterator.next();
	    		key = (String)entry.getKey();
	    		val = ((String)entry.getValue()).trim();
	    		newProps.setProperty(key, val);
	    	}
	    }
    	
        return newProps;
    }
    
}
