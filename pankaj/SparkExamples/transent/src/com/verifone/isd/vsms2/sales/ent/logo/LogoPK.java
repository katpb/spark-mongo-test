/*
 * LogoPK.java
 *
 * Created on April 1, 2003, 5:39 PM
 */

package com.verifone.isd.vsms2.sales.ent.logo;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPersistAdmin;
import com.verifone.isd.vsms2.sys.db.pres.IRegisterEntityPK;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
/** Primary key class for Logo
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class LogoPK implements IRegisterEntityPK {
    static final long serialVersionUID = 7520425045014285441L;
    private int registerNum;
    private int lineNr;
    
    
    /** Creates a new instance of LogoPK */
    public LogoPK() {
    }

    /** Constructor
     * @param registerNum register number
     * @param lineNr logo number
     */    
    public LogoPK(int lineNr, int registerNum) {
        this.lineNr = lineNr;
        if(registerNum == IEntityPersistAdmin.OLD_CONTROLLER_ID)
        {
        	this.registerNum = IEntityPersistAdmin.CONTROLLER_ID;
        }else{
        	this.registerNum = registerNum;
        }      
    }

    /** Constructor
     * @param lineNr logo number
     */    
    public LogoPK(int lineNr) {
        this.lineNr = lineNr;
    }
    
    /** Getter for the logo number
     * @return logo number
     */    
    public int getValue() {
        return this.lineNr;
    }
    
    /** Method to compare to LogoPK objects for equality
     * @param obj LogoPK object to be compared against
     * @return true if both primary keys represent the same logo
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof LogoPK) {
            LogoPK lObj = (LogoPK)obj;
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
    
    /** Validator for the logo number
     * @return true if the logo number is valid
     */    
    public boolean isValid() {
        return ((this.registerNum >= IEntityPersistAdmin.CONTROLLER_ID) && 
        (this.lineNr > 0) && (this.lineNr <= Logo.MAX_LOGOS));
    }    
    
    /*
     * Helper method to convert the primary key to a string
     */
    /** Getter for string representation of the logo PK
     * @return string representation of the logo PK
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
