/*
 * INetTransactionTypeFactory.java
 *
 * Created on January 21, 2005, 12:56 PM
 */

package com.verifone.isd.vsms2.net.ent;

/**
 *
 * @author  Anindya_D1
 */
public interface ICardCompare {
    public boolean matchCardEntry(CardData initialParse, INetCCardConfig cardEntry);
    public boolean compareIsoRec(CardData parsedCard, INetCCardConfig isoRecord);
    public void checkCatchAllISOEntry(NetCCardConfigSet theSet);
    public boolean isCatchAllISOEntry(INetCCardConfig cardEntry);
}
