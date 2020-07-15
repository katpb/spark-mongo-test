/*
 * IAcctValidationIndexFactory.java
 *
 * Created on Jan 19, 2005
 */

package com.verifone.isd.vsms2.net.ent;

/**
 *
 * @author  Bhanu_N2
 */
public interface IAcctValidationIndexDefFactory {
    public AcctValidationIndexDef[] getAcctValidationIndexDefs();
    public AcctValidationIndexDef getAcctValidationIndexDef(int ordinal);
    public AcctValidationIndexDef getFromName(String name) throws Exception;  
    public AcctValidationIndexDef getFromValue(int value) throws Exception;     
    
}
