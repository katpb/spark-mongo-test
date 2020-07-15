/*
 * CarWashConfigPK.java
 *
 * Created on April 1, 2003, 5:39 PM
 */

package com.verifone.isd.vsms2.sales.ent.cwcfg;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
/**
 * Primary key class for CarWashConfig entity
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class CarWashConfigPK implements IEntityPK {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 806700669988066050L;

	/** Creates a new instance of CarWashConfigPK */
    public CarWashConfigPK() {
    }
    
    /** Method to compare two CarWashConfigPK objects for equality
     * @param obj CarWashConfigPK object to compared with
     * @return true if both objects represent the same product code value
     */    
    public boolean equals(IEntityPK obj) {
         if (obj instanceof CarWashConfigPK) {
            return true;
        }
        return false;
    }
    
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof IEntityPK) {
            return this.equals((IEntityPK) obj);
        }
        return false;
    }
    
    /** 
     * Method override since equals() is implemented
     * No significance in numbers 37 and 17.
     * They are randomly picked.
     * 
     * @return hash code for the object
     */   
    public int hashCode() {
        return 37 * 17;
    }    
    
    /** Validator for the product code value
     * @return true if the product code is valid
     */    
    public boolean isValid() {
        return true;
    } 
}
