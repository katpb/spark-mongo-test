/*
 * IRegisterEntityPK.java
 *
 * Created on May 6, 2003, 10:30 AM
 */

package com.verifone.isd.vsms2.sys.db.pres;

/**
 * Primary key for register-specific entities is a composite
 * key consisting of register id and the entity's id.
 * @version 1.0 Copyright(c) 2000-2007 Verifone, All Rights Reserved.
 */
public interface IRegisterEntityPK extends IEntityPK {
    /**
     * Set the register id for the entity.
     * @param regId Register assigned for the entity.
     */
    public void setRegisterId(int regId);
    
    /** 
     * Get the register id for the entity.
     * @return Register assigned for the entity.
     */
    public int getRegisterId();    
}
