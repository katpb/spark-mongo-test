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
public class CardTypeDefFactory implements ICardTypeDefFactory {
    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.CardTypeDefFactory.class);
    private static final ICardTypeDefFactory FACTORY;
    
    static {
        ICardTypeDefFactory tempFactory = null;
        try {
            String clzName = SysPropertyFactory.getProperty("carddef.factory");
            LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.CardTypeDefFactory.class)
			               .debug( "CardDef Factory name from prop file = " +clzName);
            if (clzName != null && clzName.length() > 4) {
                tempFactory = (ICardTypeDefFactory) Class.forName(clzName).newInstance();
            }
        }
        catch (Exception e) {
            LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.CardTypeDefFactory.class)
			               .error("Error instantiating CardDefFactory: " +e +". Using default factory");
        }
        finally {
            if (tempFactory == null) {
                tempFactory = new DefaultCardDefFactory();
            }
            FACTORY = tempFactory;
        }
    }
    
    /** Creates a new instance of Main */
    public CardTypeDefFactory() {
    }
    
    /** Getter for the Card Def collection
     * @return array of CardDefs 
     */    
    public CardTypeDef[] getCardTypeDefs() {
        return FACTORY.getCardTypeDefs();
    }
    
    /** Getter for CardDef given on its ordinal
     * @param ordinal CardDef's ordinal
     * @return requested CardDef
     */    
    public CardTypeDef getCardTypeDef(int ordinal) {
        return FACTORY.getCardTypeDef(ordinal);
    }
    
    public static void main(String[] args) {
        CardTypeDefFactory factory = new CardTypeDefFactory();
        CardTypeDef[] defs = factory.getCardTypeDefs();
        for (int i = 0; i < defs.length; i++) {
            System.out.println("CardDef: " +defs[i].getOrdinal() +" name = " +defs[i].toString());
        }
    }    
    
    public CardTypeDef getObjectByName(String name) throws Exception {
        return FACTORY.getObjectByName(name);
    }
    
}

class DefaultCardDefFactory implements ICardTypeDefFactory {
    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.DefaultCardDefFactory.class);
    public CardTypeDef[] getCardTypeDefs() {
        return CardTypeDef.getObjects();
    }
    
    public CardTypeDef getCardTypeDef(int ordinal) {
        return CardTypeDef.getObject(ordinal);
    }
    
    public CardTypeDef getObjectByName(String name) throws Exception {
        return CardTypeDef.getObjectByName(name);
    }    
}
