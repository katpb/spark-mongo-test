/*
 * IEntryMethodFactory.java
 *
 * Created on Mar 3, 2005
 */

package com.verifone.isd.vsms2.net.ent;

/**
 *
 * @author  Brian_r1
 */
public interface IEntryMethodDefFactory {
    public EntryMethodDef[] getEntryMethodDefs();
    public EntryMethodDef getEntryMethodDef(int ordinal);
}
