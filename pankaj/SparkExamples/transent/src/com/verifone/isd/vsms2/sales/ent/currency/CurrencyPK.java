/*
 * CurrencyPK.java
 *
 * Created on April 1, 2003, 5:39 PM
 */

package com.verifone.isd.vsms2.sales.ent.currency;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
/** Primary key class for Currency
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class CurrencyPK implements IEntityPK {
    static final long serialVersionUID = -8924536266083728787L;    
    private int currencyNr;
    
    /** Creates a new instance of CurrencyPK */
    public CurrencyPK() {
    }

    /** Constructor
     * @param currencyNr currency number
     */    
    public CurrencyPK(int currencyNr) {
        this.currencyNr = currencyNr;
    }
    
    /** Getter for the currency number
     * @return currency number
     */    
    public int getValue() {
        return this.currencyNr;
    }
    
    /** Method to compare to CurrencyPK objects for equality
     * @param obj CurrencyPK object to be compared against
     * @return true if both primary keys represent the same currency
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof CurrencyPK) {
            CurrencyPK cObj = (CurrencyPK)obj;
            return (this.currencyNr == cObj.currencyNr);
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
        return (hc + this.currencyNr);
    }
    
    /** Validator for the currency number
     * @return true if the currency number is valid
     */    
    public boolean isValid() {
        return ((this.currencyNr > 0) && (this.currencyNr <= Currency.MAX_CURRENCIES));
    }    
    
    /*
     * Helper method to convert the primary key to a string
     */
    /** Getter for string representation of the currency PK
     * @return string representation of the currency PK
     */    
    public String toString() {
        return String.valueOf(this.currencyNr);
    }    
}
