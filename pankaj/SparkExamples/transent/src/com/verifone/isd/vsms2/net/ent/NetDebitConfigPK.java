/*
 * NetDebitConfigPK.java
 *
 * Created on Dec 3, 4:20 PM
 */
package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/** Primary key class for NetDebitConfig
 *  @author linda_t1
 * 	ADS Network Version
*/
public class NetDebitConfigPK implements IEntityPK {

    static final long serialVersionUID = -1615623275490243390L;
    private short recordNr;
    
    /**
     * Holds value of property MAX_VALUE.
     */
    private static int MAX_VALUE;
    
    /** Creates a new instance of CategoryPK */
    public NetDebitConfigPK() {
    }

    /** Constructor
     * @param recordNr record number number
     */    
    public NetDebitConfigPK(short recordNr) {
        this.recordNr = recordNr;
    }
    
    /** Getter for primary key record number
     * @return recordNr the data set key 
     */    
    public short getValue() {
        return this.recordNr;
    }
    
    /** Method to compare two NetDebitConfigPK objects for equality
     * @param obj object to compare with
     * @return true if the current and compared objects represent the same record number
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof NetDebitConfigPK) {
            NetDebitConfigPK dObj = (NetDebitConfigPK)obj;
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
