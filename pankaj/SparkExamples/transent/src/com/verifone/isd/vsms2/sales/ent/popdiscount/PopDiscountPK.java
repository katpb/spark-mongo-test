/*
 * PopDiscountPK.java
 *
 * Created on August 28, 2003, 6:42 PM
 */

package com.verifone.isd.vsms2.sales.ent.popdiscount;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/** Primary key class for PopDiscount entity
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class PopDiscountPK implements IEntityPK {
    static final long serialVersionUID = -7944311088804463506L;
    private int ID;
    
    /** No-args constructor
     */
    public PopDiscountPK() {
    }

    /** Constructor
     * @param ID pop discount entity ID
     */    
    public PopDiscountPK(int ID) {
        this.ID = ID;
    }
    
    /** Gets the pop discount id value
     * @return id value
     */    
    public int getValue() {
        return this.ID;
    }
    
    /** Compares two PopDiscountPK objects for equality
     * @param obj primary key to be compared with
     * @return true if both PK values are the same
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof PopDiscountPK) {
            PopDiscountPK pdObj = (PopDiscountPK)obj;
            return (this.ID == pdObj.ID);
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
        return (hc + this.ID);
    }
    
    /** Validator for the id value
     * @return true if the id value is valid
     */    
    public boolean isValid() {
        return ((this.ID > 0) && (this.ID <= PopDiscount.MAX_POPDISCOUNT_ID));
    }   

    /**
     * Helper method to convert the primary key to a string
     * @return String representation of this ID
     */    
    public String toString() {
        return String.valueOf(this.ID);
    }        
}
