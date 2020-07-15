/*
 * PromoItemListDeptPK.java
 *
 * Created on June 6, 2005, 4:28 PM
 */

package com.verifone.isd.vsms2.sales.ent.promoitemlistdept;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/** Primary key class for promotions item list for departments.
 * @author tom_s5
 */
public class PromoItemListDeptPK implements IEntityPK {

	private static final long serialVersionUID = 3400231475019471640L;
	private String deptItemListID; // list id

	/** This is the no argument constructor. */
	public PromoItemListDeptPK() {
	}

	/** This is the constructor.
	 * @param id ID number
	 */
	public PromoItemListDeptPK(String id) {
		this.deptItemListID = id;
	}

	/** This method compares two PromoItemListDeptPK objects for equality.
	 * @param obj promoItemListDeptPK object to be compared against.
	 * @return true if both primary keys represent the same promotion item list.
	 */
	public boolean equals(IEntityPK obj) {
		if (obj instanceof PromoItemListDeptPK) {
			PromoItemListDeptPK lObj = (PromoItemListDeptPK) obj;
			return (this.deptItemListID.equals(lObj.deptItemListID));
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
        return (hc + this.deptItemListID.hashCode());
    }        
        
	/** This method validates the promotion item list for the departments ID.
	 * @return true if the ID is valid.
	 */
	public boolean isValid() {
		return ((this.deptItemListID != null) && (this.deptItemListID.trim().length() > 0));
	}

	/** This method gets the promotion item list for the departments ID number.
	 * @return ID number.
	 */
	public String getValue() {
		return this.deptItemListID;
	}
}
