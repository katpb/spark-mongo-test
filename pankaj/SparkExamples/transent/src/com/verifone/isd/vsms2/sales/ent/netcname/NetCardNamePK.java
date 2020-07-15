/*
 * NetCardNamePK.java
 *
 * Created on April 1, 2003, 5:39 PM
 */

package com.verifone.isd.vsms2.sales.ent.netcname;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
/** Primary key class for NetCardName entity
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class NetCardNamePK implements IEntityPK {
    static final long serialVersionUID = 4287721010608626006L;
    private int cardType;
    
    /** No-args constructor
     */
    public NetCardNamePK() {
    }

    /** Constructor
     * @param cardType age validation entity ID
     */    
    public NetCardNamePK(int cardType) {
        this.cardType = cardType;
    }
    
    /** Gets the age validation id value
     * @return id value
     */    
    public int getValue() {
        return this.cardType;
    }
    
    /** Compares two NetCardNamePK objects for equality
     * @param obj primary key to be compared with
     * @return true if both PK values are the same
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof NetCardNamePK) {
            NetCardNamePK aObj = (NetCardNamePK)obj;
            return (this.cardType == aObj.cardType);
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
        return (hc + this.cardType);
    }
    
    /** Validator for the id value
     * @return true if the id value is valid
     */    
    public boolean isValid() {
        return ((this.cardType > 0) && (this.cardType <= NetCardName.MAX_CARDTYPE));
    }   

    /**
     * Helper method to convert the primary key to a string
     * @return String representing the primary key
     */    
    public String toString() {
        return String.valueOf(this.cardType);
    }        
}
