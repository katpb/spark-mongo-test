/*
 * LogInOutPK.java
 *
 * Created on April 1, 2003, 5:39 PM
 */

package com.verifone.isd.vsms2.sales.ent.loginout;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
/**
 * Primary key class for LogInOut entity
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class LogInOutPK implements IEntityPK {
    
    /** Creates a new instance of LogInOutPK */
    public LogInOutPK() {
    }
    
    /** Method to compare two SalesConfigPK objects for equality
     * @param obj SalesConfigPK object to compared with
     * @return true if both objects represent the same product code value
     */    
    public boolean equals(IEntityPK obj) {
         if (obj instanceof LogInOutPK) {
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
    
    /** Validator for the LogInOut value
     * @return true if the LogInOutPK is valid
     */    
    public boolean isValid() {
        return true;
    } 
}
