/*
 * MopCodeFactory.java
 *
 * Created on December 20, 2004, 12:53 PM
 */

package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.log4j.*;
/**
 * Proxy for app specific MOPCodeFactory. Default implementation is 
 * provided if app specific MOPCodeFactory is not specified in the 
 * property file or if there is an error in creating the factory instance.
 * @author  Bhanu_N2
 */
public class NetTransactionTypeFactory implements INetTransactionTypeFactory {

    private static final INetTransactionTypeFactory FACTORY;
    
    static {
        INetTransactionTypeFactory tempFactory = null;
        try {
            String clzName = SysPropertyFactory.getProperty("nettransactiontype.factory");
            LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.NetTransactionTypeFactory.class)
			                .debug( "NetTransactionType Factory name from prop file = " +clzName);
            if (clzName != null && clzName.length() > 4) {
                tempFactory = (INetTransactionTypeFactory) Class.forName(clzName).newInstance();
            }
        }
        catch (Exception e) {
            LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.NetTransactionTypeFactory.class)
			               .error("Error instantiating NetTransactionType: " +e +". Using default factory");
        }
        finally {
            if (tempFactory == null) {
                tempFactory = new DefaultNetTransactionTypeFactory();
            }
            FACTORY = tempFactory;
        }
    }
    
    /** Creates a new instance of Main */
    public NetTransactionTypeFactory() {
    }
    
    /** Getter for the Net Transaction Type collection
     * @return array of NetTransactionTypesBase
     */    
    public NetTransactionTypesBase[] getNetTransactionTypes() {
        return FACTORY.getNetTransactionTypes();
    }
    
    /** Getter for NetTransactionType given on its ordinal
     * @param number NetTransactionType's number
     * @return requested NetTransactionTypesBase
     */    
    public NetTransactionTypesBase getNetTransactionType(int number) {
        return FACTORY.getNetTransactionType(number);
    }
    
    public static void main(String[] args) {
        NetTransactionTypeFactory factory = new NetTransactionTypeFactory();
        NetTransactionTypesBase[] types = factory.getNetTransactionTypes();
        for (int i = 0; i < types.length; i++) {
            System.out.println("Network Transaction Types: " + types[i].getNumber() +" name = " + types[i].toString());
        }
    }    
}

class DefaultNetTransactionTypeFactory implements INetTransactionTypeFactory {

    public NetTransactionTypesBase[] getNetTransactionTypes() {
        return NetTransactionTypesBase.getObjects();
    }
    
    public NetTransactionTypesBase getNetTransactionType(int number) {
        return NetTransactionTypesBase.getObject(number);
    }
}
