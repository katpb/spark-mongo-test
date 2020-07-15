/*
 * IRegisterIdFactory.java
 *
 * Created on August 25, 2003, 11:43 AM
 */

package com.verifone.isd.vsms2.sys.util;

/**
 * Factory method interface to get the register id.
 * @author  Bhanu_N2
 */
public interface IRegisterIdFactory {
    /** Returns the register's Id
     * @return int register id
     */
    public int getRegisterId();    
}
