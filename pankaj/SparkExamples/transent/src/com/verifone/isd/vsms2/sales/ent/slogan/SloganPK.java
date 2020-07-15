/*
 * SloganPK.java
 *
 * Created on April 1, 2003, 5:39 PM
 */

package com.verifone.isd.vsms2.sales.ent.slogan;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPersistAdmin;
import com.verifone.isd.vsms2.sys.db.pres.IRegisterEntityPK;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
/** Primary key class for Slogan
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class SloganPK implements IRegisterEntityPK {
    static final long serialVersionUID = 5654744808096244618L;
    private int registerNum;
    private int lineNr;
    
    
    /** Creates a new instance of SloganPK */
    public SloganPK() {
    }

    /** Constructor
     * @param registerNum register ID
     * @param lineNr slogan number
     */    
    public SloganPK(int lineNr, int registerNum) {
        this.lineNr = lineNr;
        if(registerNum == IEntityPersistAdmin.OLD_CONTROLLER_ID)
        {
        	this.registerNum = IEntityPersistAdmin.CONTROLLER_ID;
        }else{
        	this.registerNum = registerNum;
        }
    }

    /** Constructor
     * @param lineNr slogan number
     */    
    public SloganPK(int lineNr) {
        this.lineNr = lineNr;
    }    

    /** Getter for the slogan number
     * @return slogan number
     */    
    public int getValue() {
        return this.lineNr;
    }
    
    /** Method to compare to SloganPK objects for equality
     * @param obj SloganPK object to be compared against
     * @return true if both primary keys represent the same slogan
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof SloganPK) {
            SloganPK lObj = (SloganPK)obj;
            return (this.registerNum == lObj.registerNum && this.lineNr == lObj.lineNr);
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
        int hc = 17;
        hc = 37 * hc + this.lineNr;
        hc = 37 * hc + this.registerNum;
        return hc;
    }
    
    /** Validator for the slogan number
     * @return true if the slogan number is valid
     */    
    public boolean isValid() {
        return ((this.registerNum >= IEntityPersistAdmin.CONTROLLER_ID) && 
        (this.lineNr > 0) && (this.lineNr <= Slogan.MAX_SLOGANS));
    }    
    
    /*
     * Helper method to convert the primary key to a string
     */
    /** Provides a string representation of the PK
     * @return string representation of the PK
     */    
    public String toString() {
        return String.valueOf(this.registerNum +"-" +this.lineNr);
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
