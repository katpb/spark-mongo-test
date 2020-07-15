/*
 * AgeValidnPK.java
 *
 * Created on April 1, 2003, 5:39 PM
 */

package com.verifone.isd.vsms2.sales.ent.agevalidn;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
/** Primary key class for AgeValidn entity
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class AgeValidnPK implements IEntityPK {
    static final long serialVersionUID = 6744117611389526130L;
    private int avNr;
    
    /** No-args constructor
     */
    public AgeValidnPK() {
    }

    /** Constructor
     * @param avNr age validation entity ID
     */    
    public AgeValidnPK(int avNr) {
        this.avNr = avNr;
    }
    
    /** Gets the age validation id value
     * @return id value
     */    
    public int getValue() {
        return this.avNr;
    }
    
    /** Compares two AgeValidnPK objects for equality
     * @param obj primary key to be compared with
     * @return true if both PK values are the same
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof AgeValidnPK) {
            AgeValidnPK aObj = (AgeValidnPK)obj;
            return (this.avNr == aObj.avNr);
        }
        return false;
    }

    /** Compares an object passed in as paramter for equality.
     * @return true if the parameter is an equivalent instance of AgeValidnPK
     * @param obj object to be compared
     */    
    public boolean equals(Object obj) {
        if (obj instanceof AgeValidnPK) {
            AgeValidnPK aObj = (AgeValidnPK)obj;
            return (this.avNr == aObj.avNr);
        }
        return false;
    }
    
    /** Method override since equals() is implemented
     * @return hash code for the object
     */
    public int hashCode() {
        int hc = 37 * 17;
        return (hc + this.avNr);
    }
    
    /** Validator for the id value
     * @return true if the id value is valid
     */    
    public boolean isValid() {
        return ((this.avNr > 0) && (this.avNr <= AgeValidn.MAX_AGE_VALIDNS));
    }   

    /*
     * Helper method to convert the primary key to a string
     */
    /** String representation of the entity PK.
     * @return string representation of the PK
     */    
    public String toString() {
        return String.valueOf(this.avNr);
    }        
}
