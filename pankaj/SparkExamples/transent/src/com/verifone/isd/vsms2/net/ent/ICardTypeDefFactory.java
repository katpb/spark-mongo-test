/*
 * ICardDefFactory.java
 *
 * Created on Jan 19, 2005
 */

package com.verifone.isd.vsms2.net.ent;

/**
 *
 * @author  Bhanu_N2
 */
public interface ICardTypeDefFactory {
    public CardTypeDef[] getCardTypeDefs();
    public CardTypeDef getCardTypeDef(int ordinal);
    public CardTypeDef getObjectByName(String name) throws Exception;
}
