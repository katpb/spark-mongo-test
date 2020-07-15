/*
 * CouponMsgPK.java
 *
 * Created on September15, 2003, 3:10 PM
 */

package com.verifone.isd.vsms2.sales.ent.couponmsg;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/** Primary key class for CouponMsg entity
 * @author "mailto:mike_r3@verifone.com"
 */
public class CouponMsgPK implements IEntityPK {
    static final long serialVersionUID = 8415553703639522906L;
    
    private int ID;
    
    /** No-args constructor
     */
    public CouponMsgPK() {
    }

    /** Constructor
     * @param ID entity ID
     */    
    public CouponMsgPK(int ID) {
        this.ID = ID;
    }
    
    /** Gets the coupon msg id value
     * @return id value
     */    
    public int getValue() {
        return this.ID;
    }
    
    /** Compares two CouponMsgPK objects for equality
     * @param obj primary key to be compared with
     * @return true if both PK values are the same
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof CouponMsgPK) {
            CouponMsgPK cmObj = (CouponMsgPK)obj;
            return (this.ID == cmObj.ID);
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
        return (hc + this.ID);
    }
    
    /** Validator for the id value
     * @return true if the id value is valid
     */    
    public boolean isValid() {
        return ((this.ID > 0) && (this.ID <= CouponMsg.MAX_MSGS));
    }   

    /*
     * Helper method to convert the primary key to a string
     */
    /** Provides string representation of the entity ID
     * @return string representation of the entity ID
     */    
    public String toString() {
        return String.valueOf(this.ID);
    }        
}
