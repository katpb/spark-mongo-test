/*
 * NetPrepaidConfigPK.java
 *
 * Created on December 06, 2004, 9:40 AM
 */
package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/** Primary key class for NetPrepaidConfig
 * @author "mailto:aaron_s1@verifone.com"
 */
public class NetPrepaidConfigPK implements IEntityPK {

    static final long serialVersionUID = -3609952601021442167L;
    private short recordNr;
    
    /**
     * Holds value of property MAX_VALUE.
     */
    private static int MAX_VALUE;
    
    /** Creates a new instance of CategoryPK */
    public NetPrepaidConfigPK() {
    }

    /** Constructor
     * @param recordNr record number number
     */    
    public NetPrepaidConfigPK(short recordNr) {
        this.recordNr = recordNr;
    }
    
    /** Getter for primary key record number
     * @return recordNr the data set key 
     */    
    public short getValue() {
        return this.recordNr;
    }
    
    /** Method to compare two NetPrepaidConfigPK objects for equality
     * @param obj object to compare with
     * @return true if the current and compared objects represent the same record number
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof NetPrepaidConfigPK) {
            NetPrepaidConfigPK dObj = (NetPrepaidConfigPK)obj;
            return (this.recordNr == dObj.recordNr);
        }
        return false;
    }
    
    /** Returns the objects string representation
     * @return string representation of the record number
     */    
    public String toString() {
        return String.valueOf(this.recordNr);
    }
    
    /** Method to valiate the record number
     * @return true if the record number is valid
     */    
    public boolean isValid() {
        return ((this.recordNr > 0) && (this.recordNr <= MAX_VALUE));
    }
    
    /**
     * Getter for property MAX_VALUE.
     * @return Value of property MAX_VALUE.
     */
    public static int getMaximumValue() {
        return MAX_VALUE;
    }
    
    /**
     * Setter for property MAX_VALUE.
     * @param val New value of property MAX_VALUE.
     */
    public static void setMaximumValue(int val) {
        MAX_VALUE = val;
    }
}
