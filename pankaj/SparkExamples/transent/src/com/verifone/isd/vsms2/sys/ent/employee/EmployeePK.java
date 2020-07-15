/*
 * EmployeePK.java
 *
 * Created on April 1, 2003, 5:39 PM
 */

package com.verifone.isd.vsms2.sys.ent.employee;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/** Primary key class for employee
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class EmployeePK implements IEntityPK {
    static final long serialVersionUID = -7770911155072245503L;
    private int empNr;
    
    /** Creates a new instance of CategoryPK */
    public EmployeePK() {
    }
    
    /** Constructor
     * @param empNr employee number
     */
    public EmployeePK(int empNr) {
        this.empNr = empNr;
    }
    
    /** Getter for employee number
     * @return employee number
     */
    public int getValue() {
        return this.empNr;
    }
    
    /** Method to compare two EmployeePK objects for equality
     * @param obj object to compare with
     * @return true if the current and compared objects represent the same employee number
     */
    public boolean equals(IEntityPK obj) {
        if (obj instanceof EmployeePK) {
            EmployeePK eObj = (EmployeePK)obj;
            return (this.empNr == eObj.empNr);
        }
        return false;
    }
    
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof IEntityPK) {
            return this.equals((IEntityPK) obj);
        }
        return false;
    } 
    
    /** Returns the objects string representation
     * @return string representation of the employee number
     */
    public String toString() {
        return String.valueOf(this.empNr);
    }
    
    /** Method to valiate the employee number
     * @return true if the employee number is valid
     */
    public boolean isValid() {
        return ((this.empNr > 0) && (this.empNr <= Employee.MAX_EMPLOYEES));
    }
    
    /** 
     * Method override since equals() is implemented
     * @return hash code for the object
     */   
    public int hashCode() {
        int hc = 37 * 17;
        return (hc + this.empNr);
    }    
}
