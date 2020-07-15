/*
 * SalesConfigPK.java
 *
 * Created on April 1, 2003, 5:39 PM
 */

package com.verifone.isd.vsms2.sales.ent.popsiteinfo;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
/**
 * Primary key class for ProductCode entity
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class PopSiteInfoPK implements IEntityPK {
    
    /** Creates a new instance of SalesConfigPK */
    public PopSiteInfoPK() {
    }
    
    /** Method to compare two SalesConfigPK objects for equality
     * @param obj SalesConfigPK object to compared with
     * @return true if both objects represent the same product code value
     */    
    public boolean equals(IEntityPK obj) {
         if (obj instanceof PopSiteInfoPK) {
            return true;
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
        return 37 * 17;
    }    
    
    /** Validator for the product code value
     * @return true if the product code is valid
     */    
    public boolean isValid() {
        return true;
    } 
}
