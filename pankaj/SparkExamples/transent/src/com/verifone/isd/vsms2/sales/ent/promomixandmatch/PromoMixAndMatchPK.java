/*
 * PromoMixAndMatchPK.java
 *
 * Created on June 29, 2005, 9:51 AM
 */

package com.verifone.isd.vsms2.sales.ent.promomixandmatch;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/** This is the primary key class for the Verifone NAXML based mix and match feature.
 * @author tom_s5
 */
public class PromoMixAndMatchPK implements IEntityPK {
	private String promotionID;

	/**
	 * This is a no-argument constructor.
	 */
	public PromoMixAndMatchPK() {
	}

	/**
	 * This is a constructor.
	 * @param id The ID number.
	 */
	public PromoMixAndMatchPK(String id) {
		this.promotionID = id;
	}

	/** This method compares two PromoMixAndMatchPK objects for equality.
	 * @param obj promoMixAndMatchPK The Object to be compared against.
	 * @return true if both primary keys represent the same promotion item list.
	 */
	public boolean equals(IEntityPK obj) {
		if (obj instanceof PromoMixAndMatchPK) {
			PromoMixAndMatchPK lObj = (PromoMixAndMatchPK) obj;
			return (this.promotionID.equals(lObj.promotionID));
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
        return (hc + this.promotionID.hashCode());
    }    

	/** This method is the validator for the mix and match ID.
	 * @return true if the ID is valid
	 */
	public boolean isValid() {
		return ( (this.promotionID != null) &&
                         (this.promotionID.trim().length() > 0) );
	}

	/** This method gets the mix and match's ID number.
	 * @return ID number
	 */
	public String getValue() {
		return this.promotionID;
	}
}
