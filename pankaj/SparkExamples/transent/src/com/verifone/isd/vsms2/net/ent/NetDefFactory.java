/*
 * NetDefFactory.java
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
public class NetDefFactory implements INetDefFactory {
    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.NetDefFactory.class);
    private static final INetDefFactory FACTORY;
    
    static {
        INetDefFactory tempFactory = null;
        try {
            String clzName = SysPropertyFactory.getProperty("netdef.factory");
            LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.NetDefFactory.class)
			                .debug( "NetDef Factory name from prop file = " +clzName);
            if (clzName != null && clzName.length() > 4) {
                tempFactory = (INetDefFactory) Class.forName(clzName).newInstance();
            }
        }
        catch (Exception e) {
            LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.NetDefFactory.class)
			               .error("Error instantiating NetDefFactory: " +e +". Using default factory");
        }
        finally {
            if (tempFactory == null) {
                tempFactory = new DefaultNetDefFactory();
            }
            FACTORY = tempFactory;
        }
    }
    
    /** Creates a new instance of Main */
    public NetDefFactory() {
    }
    
    /** Getter for the Card Def collection
     * @return array of CardDefs 
     */    
    public NetDef[] getNetDefs() {
        return FACTORY.getNetDefs();
    }
    
    /** Getter for CardDef given on its ordinal
     * @param ordinal CardDef's ordinal
     * @return requested CardDef
     */    
    public NetDef getNetDef(int ordinal) {
        return FACTORY.getNetDef(ordinal);
    }
    
    public static void main(String[] args) {
        NetDefFactory factory = new NetDefFactory();
        NetDef[] defs = factory.getNetDefs();
        for (int i = 0; i < defs.length; i++) {
            System.out.println("CardDef: " +defs[i].getOrdinal() +" name = " +defs[i].toString());
        }
    }    
}

class DefaultNetDefFactory implements INetDefFactory {
    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.DefaultNetDefFactory.class);
    public NetDef[] getNetDefs() {
        return NetDef.getObjects();
    }
    
    public NetDef getNetDef(int ordinal) {
        return NetDef.getObject(ordinal);
    }
}
