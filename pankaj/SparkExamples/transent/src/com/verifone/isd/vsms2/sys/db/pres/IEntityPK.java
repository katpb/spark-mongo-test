/*
 * IEntityPK.java
 *
 * Created on March 13, 2003, 10:38 AM
 */

package com.verifone.isd.vsms2.sys.db.pres;

/**
 * Interface for entity object primary key.
 * @version 1.0 Copyright(c) 2000-2007 Verifone, All Rights Reserved.
 */
public interface IEntityPK extends java.io.Serializable {
    /**
     * Compares another primary key for equality.
     * @param obj Primary key to be compared for equality.
     * @return True if both objects are equal.
     */
    public boolean equals(IEntityPK obj);
    
    /**
     * Method to validate a primary key.
     * @return True if the primary key is valid.
     */    
    public boolean isValid();    
}
