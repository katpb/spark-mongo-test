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
public interface INetTransactionTypeFactory {
    public NetTransactionTypesBase[] getNetTransactionTypes();
    public NetTransactionTypesBase getNetTransactionType(int tranType);
}
