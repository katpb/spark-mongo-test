/*
 * CatTrackingPK.java
 *
 * Created on Feb 27, 2006
 */

package com.verifone.isd.vsms2.sales.ent.cashiertracking;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
/** Primary key class for CatTracking
 * @author "mailto:linda_t1@verifone.com"
 */
public class CatTrackingPK implements IEntityPK {

    private int catNr;
    
    /** Creates a new instance of CategoryPK */
    public CatTrackingPK() {
    }

    /** Constructor
     * @param catNr category number
     */    
    public CatTrackingPK(int catNr) {
        this.catNr = catNr;
    }
    
    /** Getter for the category number
     * @return category number
     */    
    public int getValue() {
        return this.catNr;
    }
    
    /** Method to compare to CategoryPK objects for equality
     * @param obj CategoryPK object to be compared against
     * @return true if both primary keys represent the same category
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof CatTrackingPK) {
            CatTrackingPK cObj = (CatTrackingPK)obj;
            return (this.catNr == cObj.catNr);
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
        return (hc + this.catNr);
    }
    
    /** Validator for the category number
     * @return true if the category number is valid
     */    
    public boolean isValid() {
        return ((this.catNr > 0) && (this.catNr <= CatTracking.MAX_CATEGORIES));
    }    
    
    /*
     * Helper method to convert the primary key to a string
     */
    /** Getter for string representation of the PK
     * @return string representation of the PK
     */    
    public String toString() {
        return String.valueOf(this.catNr);
    }    
}
