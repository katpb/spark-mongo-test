/*
 * DepartmentPK.java
 *
 * Created on April 1, 2003, 5:39 PM
 */

package com.verifone.isd.vsms2.sales.ent.dept;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
/** Primary key class for Department
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class DepartmentPK implements IEntityPK {
    static final long serialVersionUID = 6552919970402044676L;
    private int deptNr;
    
    /** Creates a new instance of DepartmentPK */
    public DepartmentPK() {
    }

    /** Constructor
     * @param deptNr department number
     */    
    public DepartmentPK(int deptNr) {
        this.deptNr = deptNr;
    }
    
    /** Getter for department number
     * @return department number
     */    
    public int getValue() {
        return this.deptNr;
    }

    /** Setter for property value.
     * @param value New value of property value.
     */
    public void setValue(int value) {
        if (this != Department.getFuelDeposit()) {
            this.deptNr = value;
        }
    }
    
    /** Method to compare two DepartmentPK objects for equality
     * @param obj object to compare with
     * @return true if the current and compared objects represent the same department number
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof DepartmentPK) {
            DepartmentPK dObj = (DepartmentPK)obj;
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
    
    /** 
     * Method override since equals() is implemented
     * @return hash code for the object
     */   
    public int hashCode() {
        int hc = 37 * 17;
        return (hc + this.deptNr);
    }
    
    /** Returns the objects string representation
     * @return string representation of the department number
     */    
    public String toString() {
        return String.valueOf(this.deptNr);
    }
    
    /** Method to valiate the department number
     * @return true if the department number is valid
     */    
    public boolean isValid() {
        return ((this.deptNr >= 0) && (this.deptNr <= Department.MAX_DEPT_ID));
    }
}
