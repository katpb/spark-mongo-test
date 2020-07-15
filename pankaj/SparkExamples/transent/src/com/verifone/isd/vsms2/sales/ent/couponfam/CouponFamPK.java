/*
 * CouponFamPK.java
 *
 * Created on September 19, 2005, 3:33 PM
 */

package com.verifone.isd.vsms2.sales.ent.couponfam;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * This is the primary key class for the CouponFam entity.
 * @author tom_s5
 */
public class CouponFamPK implements IEntityPK {
	static final long serialVersionUID = 4723557426583243599L;
	private String famCode;
	
	/**
	 * Creates a new instance of CouponFamPK
	 */
	public CouponFamPK() {
	}
	
	/**
	 * Creates a new instance of CouponFamPK setting the family code.
	 * @param famCode The family code value for this entity.
	 */
	public CouponFamPK(String famCode) {
		this.famCode = famCode;
	}
	
	/**
	 * Gets the coupon family code value.
	 * @return Coupon family code value.
	 */
	public String getFamCode() {
		return this.famCode;
	}
	
	/**
	 * Compares this entity with another and returns true if they are the same.
	 * @param obj  The object to compare to.
	 * @return true if the objects match, false otherwise.
	 */
	public boolean equals(IEntityPK obj) {
		if (obj instanceof CouponFamPK) {
			CouponFamPK cmObj = (CouponFamPK) obj;
			return (this.famCode.equals(cmObj.famCode));
		}
		return false;
	}
        
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof IEntityPK) {
            return this.equals((IEntityPK) obj);
        }
        return false;
    }  
    
    /** Method override since equals() is implemented
     * @return hash code for the object
     */
    public int hashCode() {
        int hc = 37 * 17;
        return hc + ((this.famCode == null) ? 0 : this.famCode.hashCode());
    }    
	
	/**
	 * Checks to see if the entity is valid.
	 * @return true if the entity is valid, false otherwise.
	 */	
	public boolean isValid() {
		return this.famCode == null ? false : true;
	}
	
	/**
	 * Provides string representation of the entity ID.
	 * @return string representation of the entity ID.
	 */
	public String toString() {
		return this.famCode;
	}
}
