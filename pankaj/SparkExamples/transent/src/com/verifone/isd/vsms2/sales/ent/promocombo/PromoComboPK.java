/*
 * PromoComboPK.java
 *
 * Created on June 23, 2005, 9:28 AM
 */

package com.verifone.isd.vsms2.sales.ent.promocombo;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/** This is the primary key class for the Verifone NAXML based combo feature.
 * @author tom_s5
 */
public class PromoComboPK implements IEntityPK {
	private String promotionID;

	/**
	 * This is a no-argument constructor.
	 */
	public PromoComboPK() {
	}

	/**
	 * This is a constructor.
	 * @param id The ID number.
	 */
	public PromoComboPK(String id) {
		this.promotionID = id;
	}

	/** This method compares two PromoComboPK objects for equality.
	 * @param obj promoComboPK object to be compared against.
	 * @return true if both primary keys represent the same promotion item list.
	 */
	public boolean equals(IEntityPK obj) {
            boolean result = false;
		if (obj instanceof PromoComboPK) {
			PromoComboPK lObj = (PromoComboPK) obj;
			if(this.promotionID.equals(lObj.promotionID)) {
                            result = true;
                        }
		}
		return result;
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
        return (hc + this.promotionID.hashCode());
    }    

	/** This method is the validator for the combo ID.
	 * @return true if the ID is valid
	 */
	public boolean isValid() {
		return ( (this.promotionID != null) &&
                         (this.promotionID.trim().length() > 0) );
	}

	/** This method gets the combo's ID number.
	 * @return ID number
	 */
	public String getValue() {
		return this.promotionID;
	}
}
