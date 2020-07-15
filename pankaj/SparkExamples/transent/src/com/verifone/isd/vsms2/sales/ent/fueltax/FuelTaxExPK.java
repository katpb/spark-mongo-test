/*
 * FuelTaxExPK.java
 *
 * Created on February 17, 2005, 10:32 AM
 */

package com.verifone.isd.vsms2.sales.ent.fueltax;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Primary key for fuel tax exemptions
 * @author  tom_s5
 */
public class FuelTaxExPK implements IEntityPK {
	private int id;

	/**
	 * No argument constructor
	 */
	public FuelTaxExPK() {
	}

	/**
	 * Constructor
	 * @param id ID number
	 */
	public FuelTaxExPK(int id) {
		this.id = id;
	}

	/**
	 * Method to compare two FuelTaxExPK objects for equality
	 * @param obj FuelTaxExPK object to be compared against
	 * @return true if both primary keys represent the same fuel tax exemption
	 */
	@Override
	public boolean equals(IEntityPK obj) {
		if (obj instanceof FuelTaxExPK) {
			FuelTaxExPK lObj = (FuelTaxExPK) obj;
			return (this.id == lObj.id);
		}
		return false;
	}
        
    @Override
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
    @Override
	public int hashCode() {
        int hc = 37 * 17;
        return (hc + this.id);
    }    

	/**
	 * Validator for the fuel tax exemption ID
	 * @return true if the fuel tax exemption is valid
	 */
	@Override
	public boolean isValid() {
		return ((this.id > 0) && (this.id <= FuelTaxEx.MAX_FUELTAXEX));
	}

	/**
	 * Getter for fuel tax exemption number
	 * @return fuel tax exemption number
	 */
	public int getValue() {
		return this.id;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FuelTaxExPK [id=" + id + "]";
	}
}
