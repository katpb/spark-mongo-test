/*
 * DiscountDenomPK.java
 *
 * Created on October 26, 2015 3:33 PM
 */

package com.verifone.isd.vsms2.sales.ent.discountdenom;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * This is the primary key class for the DiscountDenom entity.
 * @author T_JoswillP1 <t_joswillp1@verifone.com>
 * @author knicolas_b1
 */
public class DiscountDenomPK  implements IEntityPK {

	private static final long serialVersionUID = -2893497771780231825L;
	private int id;

	public DiscountDenomPK() {
	}

	public DiscountDenomPK(int id) {
		this.id=id;
	}

	public int getValue() {
		return this.id;
	}

	/** Method to compare two DiscountDenomPK objects for equality
	 * @param obj DiscountDenomPK object to compared with
	 * @return true if both objects represent the same product code value
	 */ 
	public boolean equals(IEntityPK pk) {
		if (pk instanceof DiscountDenomPK) {
			return this.id==((DiscountDenomPK)pk).id;
		}
		return false;
	}

	public boolean equals(Object obj) {
		if (obj != null && obj instanceof DiscountDenomPK) {
			return this.equals((IEntityPK)obj);
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 73 * hash + this.id;
		return hash;
	}

	/**
	 * Checks to see if the entity is valid.
	 * @return true if the entity is valid, false otherwise.
	 */	
	public boolean isValid() {
		return ((this.id > 0) && (this.id <= DiscountDenom.MAX_ID));
	}
}
