/*
 * INetDefFactory.java
 *
 * Created on Jan 19, 2005
 */

package com.verifone.isd.vsms2.net.ent;

/**
 *
 * @author  Bhanu_N2
 */
public interface INetDefFactory {
    public NetDef[] getNetDefs();
    public NetDef getNetDef(int ordinal);
}
