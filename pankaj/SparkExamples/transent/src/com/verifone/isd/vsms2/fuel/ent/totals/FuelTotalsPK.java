/*
 * FuelTotalsPK.java
 *
 * Created on April 1, 2003, 5:39 PM
 */

package com.verifone.isd.vsms2.fuel.ent.totals;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
/** Primary key class for FuelTotals entity
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class FuelTotalsPK implements IEntityPK {
    public static final String EDISP_DATA = "edispt";
    public static final String CONV_DATA = "fconvt";    
    
    static final long serialVersionUID = -6925865159253308026L;
    private String name;
    
    /** No-args constructor
     */
    public FuelTotalsPK() {
    }

    /** Constructor
     * @param name fuel totals name
     */    
    public FuelTotalsPK(String name) {
        this.name = name;
    }
    
    /** Gets the age validation id value
     * @return id value
     */    
    public String getValue() {
        return this.name;
    }
    
    /** Compares two FuelTotalsPK objects for equality
     * @param obj primary key to be compared with
     * @return true if both PK values are the same
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof FuelTotalsPK) {
            FuelTotalsPK aObj = (FuelTotalsPK)obj;
            return (this.name.equals(aObj.name));
        }
        return false;
    }
    
    /** Validator for the id value
     * @return true if the id value is valid
     */    
    public boolean isValid() {
        return ((this.name != null) && (this.name.equals(EDISP_DATA) || this.name.equals(CONV_DATA)));
    }   

    /*
     * Helper method to convert the primary key to a string
     */
    public String toString() {
        return this.name;
    }        
}
