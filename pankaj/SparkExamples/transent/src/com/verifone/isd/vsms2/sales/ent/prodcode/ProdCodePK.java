/*
 * ProdCodePK.java
 *
 * Created on April 1, 2003, 5:39 PM
 */

package com.verifone.isd.vsms2.sales.ent.prodcode;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
/**
 * Primary key class for ProductCode entity
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class ProdCodePK implements IEntityPK {
    static final long serialVersionUID = -3495980916949265862L;
    private int prodcode;
    
    /** Creates a new instance of ProdCodePK */
    public ProdCodePK() {
    }

    /** Constructor
     * @param prodcode product code
     */    
    public ProdCodePK(int prodcode) {
        this.prodcode = prodcode;
    }
    
    /** Getter for prodcode value
     * @return product code value
     */    
    public int getValue() {
        return this.prodcode;
    }
    
    /** Method to compare two ProdCodePK objects for equality
     * @param obj ProdCodePK object to compared with
     * @return true if both objects represent the same product code value
     */    
    public boolean equals(IEntityPK obj) {
         if (obj instanceof ProdCodePK) {
            ProdCodePK cObj = (ProdCodePK)obj;
            return (this.prodcode == cObj.prodcode);
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
        return (hc + this.prodcode);
    }
    
    /** Validator for the product code value
     * @return true if the product code is valid
     */    
    public boolean isValid() {
        return ((this.prodcode >= 0) && (this.prodcode <= ProdCode.MAX_PRODUCT_CODES));
    } 

        
    /*
     * Helper method to convert the primary key to a string
     */
    public String toString() {
        return String.valueOf(this.prodcode);
    }
}
