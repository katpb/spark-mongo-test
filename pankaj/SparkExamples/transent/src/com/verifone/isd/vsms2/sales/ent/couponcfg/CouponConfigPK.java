/**
 * 
 */
package com.verifone.isd.vsms2.sales.ent.couponcfg;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * @author ashutosh_b1
 *
 */
public class CouponConfigPK  implements IEntityPK {

    private static final long serialVersionUID = 8173987120143219326L;

	/** Creates a new instance of CouponConfigPK */
    public CouponConfigPK() {
    }
    
	/** Method to compare two CouponConfigPK objects for equality
	 * @param obj CouponConfigPK object to compared with
	 * @return true if both objects represent the same product code value
	 */ 
	public boolean equals(IEntityPK pk) {
		if (pk instanceof CouponConfigPK) {
			return true;
		}
		return false;
	}
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof CouponConfigPK) {
			return true;
		}
		return false;
	}
	/** 
	 * Method override since equals() is implemented
	 * @return hash code for the object
	 */   
	public int hashCode() {
		return 148 * 17;
	} 

	/**
	 * Checks to see if the entity is valid.
	 * @return true if the entity is valid, false otherwise.
	 */	
	public boolean isValid() {
		return  true;
	}

}
