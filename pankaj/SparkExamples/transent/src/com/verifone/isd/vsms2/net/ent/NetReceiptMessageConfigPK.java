package com.verifone.isd.vsms2.net.ent;



import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/** Primary key class for NetRecieptMessageConfig
 * @author shanavas_p1
 */
public class NetReceiptMessageConfigPK implements IEntityPK {

    private static final long serialVersionUID = 2941733067044577015L;
    private short recordNr;
    private static int MAX_VALUE = 99;

    /** Creates a new instance of CategoryPK */
    public NetReceiptMessageConfigPK() {
    }

    /** Constructor
     * @param recordNr record number number
     */
    public NetReceiptMessageConfigPK(short recordNr) {
        this.recordNr = recordNr;
    }

    /** Getter for primary key record number
     * @return recordNr the data set key
     */
    public short getValue() {
        return this.recordNr;
    }

    /** Method to compare two NetReceiptMessageConfigPK objects for equality
     * @param obj IEntityPK object to compare with
     * @return true if the current and compared objects represent the same record number
     */
    public boolean equals(IEntityPK obj) {
        if (obj instanceof NetReceiptMessageConfigPK) {
            NetReceiptMessageConfigPK dObj = (NetReceiptMessageConfigPK)obj;
            return (this.recordNr == dObj.recordNr);
        }
        return false;
    }
    
    /** Method to compare two NetReceiptMessageConfigPK objects for equality
     * @param obj Object to compare with
     * @return true if the IEntityPK Objects are equal
     */
    public boolean equals(Object obj) {
        if (obj instanceof IEntityPK) {
            return this.equals((IEntityPK)obj);
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
