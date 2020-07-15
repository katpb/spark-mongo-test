/*
 * SoftKeyPK.java
 *
 * Created on April 1, 2003, 5:39 PM
 */

package com.verifone.isd.vsms2.sales.ent.softkey;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPersistAdmin;
import com.verifone.isd.vsms2.sys.db.pres.IRegisterEntityPK;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
/** Primary key class for SoftKey
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class SoftKeyPK implements IRegisterEntityPK {
    static final long serialVersionUID = 2212493216196697796L;
    private int registerNum;
    private int skNum;
    
    /** Creates a new instance of SoftKeyPK */
    public SoftKeyPK() {
    }

    /** Constructor
     * @param registerNum register id
     * @param skNum soft key number
     */    
    public SoftKeyPK(int skNum, int registerNum) {
        this.skNum = skNum;
        if(registerNum == IEntityPersistAdmin.OLD_CONTROLLER_ID)
        {
        	this.registerNum = IEntityPersistAdmin.CONTROLLER_ID;
        }else{
        	this.registerNum = registerNum;
        }
    }

    /** Constructor
     * @param skNum logo number
     */    
    public SoftKeyPK(int skNum) {
        this.skNum = skNum;
    }
    
    /** Getter for the logo number
     * @return logo number
     */    
    public int getValue() {
        return this.skNum;
    }
    
    /** Method to compare to SoftKeyPK objects for equality
     * @param obj SoftKeyPK object to be compared against
     * @return true if both primary keys represent the same logo
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof SoftKeyPK) {
            SoftKeyPK sObj = (SoftKeyPK)obj;
            return (this.registerNum == sObj.registerNum &&
            this.skNum == sObj.skNum);
        }
        return false;
    }
    
    public boolean equals(Object obj) {
        if (obj instanceof SoftKeyPK) {
            return this.equals((IEntityPK)obj);
        }
        return false;
    }
    
    /** 
     * Method override since equals() is implemented
     * @return hash code for the object
     */    
    public int hashCode() {
        int hc = 17;
        hc = 37 * hc + this.skNum;
        hc = 37 * hc + this.registerNum;
        return hc;
    }
    
    /** Validator for the logo number
     * @return true if the logo number is valid
     */    
    public boolean isValid() {
        return ((this.registerNum >= IEntityPersistAdmin.CONTROLLER_ID) && 
        (this.skNum > 0) && (this.skNum <= SoftKey.MAX_SOFTKEYS));
    }    
    
    /*
     * Helper method to convert the primary key to a string
     */
    /** Provides string representaion of the entity PK
     * @return string representaion of the entity PK
     */    
    public String toString() {
        return String.valueOf(this.registerNum +"-" +this.skNum);
    }    
    
    /**
     * Get the register id for the entity
     * @return regId register assigned for the entity
     */
    public int getRegisterId() {
        return this.registerNum;
    }
    
    /**
     * Set the register id for the entity
     * @param regId register assigned for the entity
     */
    public void setRegisterId(int regId) {
    	if(regId == IEntityPersistAdmin.OLD_CONTROLLER_ID)
        {
        	this.registerNum = IEntityPersistAdmin.CONTROLLER_ID;
        }else{
        	this.registerNum = regId;
        }
    }
    
}
