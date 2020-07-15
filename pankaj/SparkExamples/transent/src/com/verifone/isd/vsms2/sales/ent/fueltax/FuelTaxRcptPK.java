/*
 * FuelTaxRcptPK.java
 *
 * Created on February 17, 2005, 10:32 AM
 */

package com.verifone.isd.vsms2.sales.ent.fueltax;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Primary key for fuel tax receipt lines
 * @author  tom_s5
 */
public class FuelTaxRcptPK implements IEntityPK {
	private int id;

	/**
	 * No argument constructor
	 */
	public FuelTaxRcptPK() {
	}

	/**
	 * Constructor
	 * @param id ID number
	 */
	public FuelTaxRcptPK(int id) {
		this.id = id;
	}

	/**
	 * Method to compare two FuelTaxRcptPK objects for equality
	 * @param obj FuelTaxRcptPK object to be compared against
	 * @return true if both primary keys represent the same fuel tax receipt
	 */
	public boolean equals(IEntityPK obj) {
		if (obj instanceof FuelTaxRcptPK) {
			FuelTaxRcptPK lObj = (FuelTaxRcptPK) obj;
			return (this.id == lObj.id);
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
     * @return hash code for the object
     */   
    public int hashCode() {
        int hc = 37 * 17;
        return (hc + this.id);
    }    

	/**
	 * Validator for the fuel tax exemption receipt ID
	 * @return true if the fuel tax exemption is valid
	 */
	public boolean isValid() {
		return (this.id > 0);
	}

	/**
	 * Getter for fuel tax exemption receipt number
	 * @return fuel tax exemption number
	 */
	public int getValue() {
		return this.id;
	}
}
