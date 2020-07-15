/*
 * CardDefFactory.java
 *
 * Created on December 20, 2004, 12:53 PM
 */

package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.log4j.*;
/**
 * Proxy for app specific CardDefFactory. Default implementation is 
 * provided if app specific CardDefFactory is not specified in the 
 * property file or if there is an error in creating the factory instance.
 * @author  Bhanu_N2
 */
public class AcctValidationIndexDefFactory implements IAcctValidationIndexDefFactory {
    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.AcctValidationIndexDefFactory.class);
    private static final IAcctValidationIndexDefFactory FACTORY;
    
    static {
        IAcctValidationIndexDefFactory tempFactory = null;
        try {
            String clzName = SysPropertyFactory.getProperty("acctvalidationindexdef.factory");
            LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.AcctValidationIndexDefFactory.class)
                            .debug( "AcctValidationIndexDef Factory name from prop file = " +clzName);
            if (clzName != null && clzName.length() > 4) {
                tempFactory = (IAcctValidationIndexDefFactory) Class.forName(clzName).newInstance();
            }
        }
        catch (Exception e) {
            LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.AcctValidationIndexDefFactory.class)
                            .error("Error instantiating AcctValidationIndexDefFactory: " +e +". Using default factory");
        }
        finally {
            if (tempFactory == null) {
                tempFactory = new DefaultAcctValidationIndexDefFactory();
            }
            FACTORY = tempFactory;
        }
    }
    
    /** Creates a new instance of Main */
    public AcctValidationIndexDefFactory() {
    }
    
    /** Getter for the Card Def collection
     * @return array of CardDefs 
     */    
    public AcctValidationIndexDef[] getAcctValidationIndexDefs() {
        return FACTORY.getAcctValidationIndexDefs();
    }
    
    /** Getter for CardDef given on its ordinal
     * @param ordinal CardDef's ordinal
     * @return requested CardDef
     */    
    public AcctValidationIndexDef getAcctValidationIndexDef(int ordinal) {
        return FACTORY.getAcctValidationIndexDef(ordinal);
    }
    
    public AcctValidationIndexDef getFromName(String name) throws Exception {
        return FACTORY.getFromName(name);
    }
    
    public AcctValidationIndexDef getFromValue(int value) throws Exception {
        return FACTORY.getFromValue(value);
    }
    
    public static void main(String[] args) {
        AcctValidationIndexDefFactory factory = new AcctValidationIndexDefFactory();
        AcctValidationIndexDef[] defs = factory.getAcctValidationIndexDefs();
        for (int i = 0; i < defs.length; i++) {
            System.out.println("CardDef: " +defs[i].getOrdinal() +" name = " +defs[i].toString());
        }
    }    
}

class DefaultAcctValidationIndexDefFactory implements IAcctValidationIndexDefFactory {
    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.DefaultAcctValidationIndexDefFactory.class);
    public AcctValidationIndexDef[] getAcctValidationIndexDefs() {
        return AcctValidationIndexDef.getObjects();
    }
    
    public AcctValidationIndexDef getAcctValidationIndexDef(int ordinal) {
        return AcctValidationIndexDef.getObject(ordinal);
    }
    
    public AcctValidationIndexDef getFromName(String name) throws Exception {
        return AcctValidationIndexDef.getFromName(name);
    }
    
    public AcctValidationIndexDef getFromValue(int value) throws Exception {
        return AcctValidationIndexDef.getFromValue(value);
    }    
}
