/*
 * EntryMethodDefFactory.java
 *
 * Created on December 20, 2004, 12:53 PM
 */

package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.log4j.*;
/**
 * Proxy for app specific EntryMethodDefFactory. Default implementation is 
 * provided if app specific EntryMethodDefFactory is not specified in the 
 * property file or if there is an error in creating the factory instance.
 * @author  Bhanu_N2
 */
public class EntryMethodDefFactory implements IEntryMethodDefFactory {
    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.EntryMethodDefFactory.class);
    private static final IEntryMethodDefFactory FACTORY;
    
    static {
        IEntryMethodDefFactory tempFactory = null;
        try {
            String clzName = SysPropertyFactory.getProperty("entrymethoddef.factory");
            LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.EntryMethodDefFactory.class)
			                .debug( "EntryMethodDef Factory name from prop file = " +clzName);
            if (clzName != null && clzName.length() > 4) {
                tempFactory = (IEntryMethodDefFactory) Class.forName(clzName).newInstance();
            }
        }
        catch (Exception e) {
            LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.EntryMethodDefFactory.class)
			               .error("Error instantiating EntryMethodDefFactory: " +e +". Using default factory");
        }
        finally {
            if (tempFactory == null) {
                tempFactory = new DefaultEntryMethodDefFactory();
            }
            FACTORY = tempFactory;
        }
    }
    
    /** Creates a new instance of Main */
    public EntryMethodDefFactory() {
    }
    
    /** Getter for the Card Def collection
     * @return array of EntryMethodDefs 
     */    
    public EntryMethodDef[] getEntryMethodDefs() {
        return FACTORY.getEntryMethodDefs();
    }
    
    /** Getter for EntryMethod given on its ordinal
     * @param ordinal EntryMethod's ordinal
     * @return requested EntryMethod
     */    
    public EntryMethodDef getEntryMethodDef(int ordinal) {
        return FACTORY.getEntryMethodDef(ordinal);
    }
    
    public static void main(String[] args) {
        EntryMethodDefFactory factory = new EntryMethodDefFactory();
        EntryMethodDef[] defs = factory.getEntryMethodDefs();
        for (int i = 0; i < defs.length; i++) {
            System.out.println("EntryMethod: " +defs[i].getOrdinal() +" name = " +defs[i].toString());
        }
    }    
}

class DefaultEntryMethodDefFactory implements IEntryMethodDefFactory {
    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.DefaultEntryMethodDefFactory.class);
    public EntryMethodDef[] getEntryMethodDefs() {
        return EntryMethodDef.getObjects();
    }
    
    public EntryMethodDef getEntryMethodDef(int ordinal) {
        return EntryMethodDef.getObject(ordinal);
    }
}
