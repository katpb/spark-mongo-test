/*
 * CategoryPK.java
 *
 * Created on April 1, 2003, 5:39 PM
 */

package com.verifone.isd.vsms2.sales.ent.category;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
/** Primary key class for Category
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class CategoryPK implements IEntityPK {
    static final long serialVersionUID = -5957782369531111408L;    
    private int catNr;
    
    /** Creates a new instance of CategoryPK */
    public CategoryPK() {
    }

    /** Constructor
     * @param catNr category number
     */    
    public CategoryPK(int catNr) {
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
        if (obj instanceof CategoryPK) {
            CategoryPK cObj = (CategoryPK)obj;
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
        return ((this.catNr > 0) && (this.catNr <= Category.MAX_CATEGORIES));
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
