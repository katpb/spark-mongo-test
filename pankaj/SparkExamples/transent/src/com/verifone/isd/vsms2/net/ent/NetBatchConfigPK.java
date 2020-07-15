/*
 * NetBatchConfigPK.java
 *
 * Created on June 10, 2003, 4:40 PM
 */
package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/** Primary key class for NetBatchConfig
 * @author "mailto:aaron_s1@verifone.com"
 */
public class NetBatchConfigPK implements IEntityPK {

    static final long serialVersionUID = 3483488643670224448L;
    private short recordNr;

    /**
     * Holds value of property MAX_VALUE.
     */
    private static int MAX_VALUE;
    
    /** Creates a new instance of CategoryPK */
    public NetBatchConfigPK() {
    }

    /** Constructor
     * @param recordNr record number number
     */
    public NetBatchConfigPK(short recordNr) {
        this.recordNr = recordNr;
    }

    /** Getter for primary key record number
     * @return recordNr the data set key
     */
    public short getValue() {
        return this.recordNr;
    }

    /** Method to compare two NetBatchConfigPK objects for equality
     * @param obj object to compare with
     * @return true if the current and compared objects represent the same record number
     */
    public boolean equals(IEntityPK obj) {
        if (obj instanceof NetBatchConfigPK) {
            NetBatchConfigPK dObj = (NetBatchConfigPK)obj;
            return (this.recordNr == dObj.recordNr);
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
    
    /** Method override since equals() is implemented
     * @return hash code for the object
     */   
    public int hashCode() {
        int hc = 37 * 17;
        return (hc + (int)this.recordNr);
    }
}
