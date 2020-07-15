/*
 * SalesConfigPK.java
 *
 * Created on April 1, 2003, 5:39 PM
 */

package com.verifone.isd.vsms2.sales.ent.salescfg;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
/** Primary key class for SalesConfig entity (SalesConfig
 * is a singleton; implemented only because of interface
 * requirements)
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class SalesConfigPK implements IEntityPK {
    static final long serialVersionUID = -3502698475118774065L;
    
    /** Creates a new instance of SalesConfigPK */
    public SalesConfigPK() {
    }
    
    /** Method to compare two SalesConfigPK objects for equality
     * @param obj SalesConfigPK object to compared with
     * @return true if both objects represent the same product code value
     */    
    public boolean equals(IEntityPK obj) {
         if (obj instanceof SalesConfigPK) {
            return true;
        }
        return false;
    }
    
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof SalesConfigPK) {
            return true;
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
    
    /** Validator for the sales config PK
     * @return true always
     */    
    public boolean isValid() {
        return true;
    } 
}
