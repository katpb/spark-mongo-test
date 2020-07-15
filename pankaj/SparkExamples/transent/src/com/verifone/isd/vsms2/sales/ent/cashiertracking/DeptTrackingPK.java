/*
 * DeptTrackingPK.java
 *
 * Created on Feb 27, 2006
 */

package com.verifone.isd.vsms2.sales.ent.cashiertracking;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
/** Primary key class for DeptTracking
 * @author "mailto:linda_t1@verifone.com"
 */
public class DeptTrackingPK implements IEntityPK {

    private int deptNr;
    
    /** Creates a new instance of DeptTrackingPK */
    public DeptTrackingPK() {
    }

    /** Constructor
     * @param deptNr department number
     */    
    public DeptTrackingPK(int deptNr) {
        this.deptNr = deptNr;
    }
    
    /** Getter for the department number
     * @return department number
     */    
    public int getValue() {
        return this.deptNr;
    }
    
    /** Method to compare to DeptTrackingPK objects for equality
     * @param obj DeptTrackingPK object to be compared against
     * @return true if both primary keys represent the same DeptTracking
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof DeptTrackingPK) {
            DeptTrackingPK dObj = (DeptTrackingPK)obj;
            return (this.deptNr == dObj.deptNr);
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
        return (hc + this.deptNr);
    }    
    
    /** Validator for the department number
     * @return true if the department number is valid
     */    
    public boolean isValid() {
        return ((this.deptNr > 0) && (this.deptNr <= DeptTracking.MAX_DEPARTMENTS));
    }    
    
    /*
     * Helper method to convert the primary key to a string
     */
    /** Getter for string representation of the PK
     * @return string representation of the PK
     */    
    public String toString() {
        return String.valueOf(this.deptNr);
    }    
}
