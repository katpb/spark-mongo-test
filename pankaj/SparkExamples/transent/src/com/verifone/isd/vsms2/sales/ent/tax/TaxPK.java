/*
 * TaxPK.java
 *
 * Created on April 1, 2003, 5:39 PM
 */

package com.verifone.isd.vsms2.sales.ent.tax;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
/** Primary key for Tax
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class TaxPK implements IEntityPK {
    static final long serialVersionUID = -2912302463462880239L;
    private int taxNr;

    /** Creates a new instance of TaxPK */
    public TaxPK() {
    }

    /** Constructor
     * @param taxNr tax number
     */    
    public TaxPK(int taxNr) {
        this.taxNr = taxNr;
    }
    
    /** Getter for tax number
     * @return tax number
     */    
    public int getValue() {
        return this.taxNr;
    }
    
    /** Method to compare two TaxPK objects for equality
     * @param obj TaxPK object to compare with
     * @return true if both objects represent the same tax PK object
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof TaxPK) {
            TaxPK tObj = (TaxPK)obj;
            return (this.taxNr == tObj.taxNr);
        }
        return false;
    }

    /** Method to compare two TaxPK objects for equality
     * @param obj object to compare with
     * @return true if both objects represent the same tax PK object
     */    
    public boolean equals(Object obj) {
        if (obj instanceof TaxPK) {
            TaxPK tObj = (TaxPK)obj;
            return (this.taxNr == tObj.taxNr);
        }
        return false;
    }

    /** Method override since equals() is implemented
     * @return hash code for the object
     */   
    public int hashCode() {
        int hc = 37 * 17;
        return (hc + this.taxNr);
    }
    
    /** Validator for the primary key value
     * @return true is tax number is valid
     */    
    public boolean isValid() {
        return ((this.taxNr >= 0) && (this.taxNr <= Tax.MAX_TAXES));
    }        
    
    /*
     * Helper method to convert the primary key to a string
     */
    /** Provides string representation of the entity PK
     * @return string representation of the entity PK
     */    
    public String toString() {
        return String.valueOf(this.taxNr);
    }    
}
