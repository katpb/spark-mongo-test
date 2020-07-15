/*
 * NetDealerConfigPK.java
 *
 * Created on Dec 3, 2004, 4:20 PM
 */
package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/** Primary key class for NetDealerConfig
 *  @author linda_t1
 *  ADS network version
*/
public class NetDealerConfigPK implements IEntityPK {

    static final long serialVersionUID = -6222824992364381267L;
    private short recordNr;
    
    private static int MAX_VALUE;
    /** Creates a new instance of CategoryPK */
    public NetDealerConfigPK() {
    }

    /** Constructor
     * @param recordNr record number number
     */    
    public NetDealerConfigPK(short recordNr) {
        this.recordNr = recordNr;
    }
    
    /** Getter for primary key record number
     * @return recordNr the data set key 
     */    
    public short getValue() {
        return this.recordNr;
    }
    
    /** Method to compare two NetDealerConfigPK objects for equality
     * @param obj object to compare with
     * @return true if the current and compared objects represent the same record number
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof NetDealerConfigPK) {
            NetDealerConfigPK dObj = (NetDealerConfigPK)obj;
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
