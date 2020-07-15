/*
 * PromoItemListPLUPK.java
 *
 * Created on June 6, 2005, 4:28 PM
 */

package com.verifone.isd.vsms2.sales.ent.promoitemlistplu;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/** This is the primary key class for promotion item lists for PLUs.
 * @author tom_s5
 */
public class PromoItemListPLUPK implements IEntityPK {

	private static final long serialVersionUID = 1439501138475945468L;
	private String pluItemListID; // list id

	/** This is the no argument constructor. */
	public PromoItemListPLUPK() {
	}

	/** This is the constructor.
	 * @param id ID number
	 */
	public PromoItemListPLUPK(String id) {
		this.pluItemListID = id;
	}

	/** This method compares two PromoItemListPLUPK objects for equality.
	 * @param obj promoItemListPLUPK object to be compared against
	 * @return true if both primary keys represent the same promotion item list
	 */
	public boolean equals(IEntityPK obj) {
		if (obj instanceof PromoItemListPLUPK) {
			PromoItemListPLUPK lObj = (PromoItemListPLUPK) obj;
			return (this.pluItemListID.equals(lObj.pluItemListID));
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
        return (hc + this.pluItemListID.hashCode());
    }    

	/** This method is the validator for the promotion item list for PLUs ID.
	 * @return true if the ID is valid
	 */
	public boolean isValid() {
		return (this.pluItemListID != null && this.pluItemListID.trim().length() > 0);
	}

	/** This method gets the promotion item list for PLUs ID number.
	 * @return ID number
	 */
	public String getValue() {
		return this.pluItemListID;
	}
}
