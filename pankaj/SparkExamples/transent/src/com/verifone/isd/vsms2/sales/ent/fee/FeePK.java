/*
 * CategoryPK.java
 *
 * Created on April 1, 2003, 5:39 PM
 */

package com.verifone.isd.vsms2.sales.ent.fee;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
/** Primary key for Fee
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class FeePK implements IEntityPK {
    static final long serialVersionUID = -4481539593684505096L;
    private int feeNr;
    
    /** Creates a new instance of FeePK */
    public FeePK() {
    }

    /** Constructor
     * @param feeNr fee number
     */    
    public FeePK(int feeNr) {
        this.feeNr = feeNr;
    }
    
    /** Getter for feeNr
     * @return fee number
     */    
    public int getValue() {
        return this.feeNr;
    }
    
    /** Method to compare this against another FeePK object for equality
     * @param obj object to compare with
     * @return true if object objects represent the same fee number
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof FeePK) {
            FeePK cObj = (FeePK)obj;
            return (this.feeNr == cObj.feeNr);
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
        return (hc + this.feeNr);
    }
    
    /** Method to get string representation of the fee number
     * @return String representation of the fee number
     */    
    public String toString() {
        return String.valueOf(this.feeNr);
    }
    
    /** Validator method for the primary key
     * @return true if the fee number is valid
     */    
    public boolean isValid() {
        return ((this.feeNr > 0) && (this.feeNr <= Fee.MAX_FEES));
    }    
}
