/*
 * IRegisterSpecificProcess.java
 *
 * Created on July 23, 2010, 3:34 PM
 */


package com.verifone.isd.vsms2.sales.ent.screencfg;

/**
 * Generic interface to be implemented by control objects that need to perform functions based
 * on the Register. 
 * @author  Ganesh_k1
 */
public interface IRegisterSpecificProcess {
    /** Set the register number
     * @param regNum register number
     * @exception Exception on invalid register number parameter
     */
    public void setRegNum(short regNum) throws Exception;    
}
