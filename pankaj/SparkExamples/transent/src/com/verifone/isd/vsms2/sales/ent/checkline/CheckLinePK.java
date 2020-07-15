/*
 * CheckLinePK.java
 *
 * Created on August 28, 2003, 6:42 PM
 */

package com.verifone.isd.vsms2.sales.ent.checkline;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPersistAdmin;
import com.verifone.isd.vsms2.sys.db.pres.IRegisterEntityPK;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/** Primary key class for CheckLine entity
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class CheckLinePK implements IRegisterEntityPK {
    static final long serialVersionUID = 7061336245263164974L;   
    private int ID;
    private int registerNum;
    
    /** No-args constructor
     */
    public CheckLinePK() {
    }

    /** Constructor
     * @param ID entity ID
     */    
    public CheckLinePK(int ID) {
        this.ID = ID;
    }

    /** Constructor
     * @param ID check line entity ID
     * @param registerNum Register Number
     */    
    public CheckLinePK(int ID, int registerNum) {
        this.ID = ID;
        if(registerNum == IEntityPersistAdmin.OLD_CONTROLLER_ID)
        {
        	this.registerNum = IEntityPersistAdmin.CONTROLLER_ID;
        }else{
        	this.registerNum = registerNum;
        }
    }

    /** Gets the check line id value
     * @return id value
     */    
    public int getValue() {
        return this.ID;
    }
    
    /** Compares two CheckLinePK objects for equality
     * @param obj primary key to be compared with
     * @return true if both PK values are the same
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof CheckLinePK) {
            CheckLinePK pdObj = (CheckLinePK)obj;
            return (this.ID == pdObj.ID);
        }
        return false;
    }
    
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof IEntityPK) {
            return this.equals((IEntityPK) obj);
        }
        return false;
    }     
    
    /** Method override since equals() is implemented
     * @return hash code for the object
     */    
    public int hashCode() {
        int hc = 17;
        hc = 37 * hc + this.ID;
        hc = 37 * hc + this.registerNum;
        return hc;
    }
    
    /** Validator for the id value
     * @return true if the id value is valid
     */    
    public boolean isValid() {
        return ((this.registerNum >= IEntityPersistAdmin.CONTROLLER_ID) && 
        		(this.ID > 0) && (this.ID <= CheckLine.MAX_CHECK_LINES));
    }   

    /*
     * Helper method to convert the primary key to a string
     */
    /** Getter for string representation of the entity ID
     * @return string representation of the entity ID
     */    
    public String toString() {
        return String.valueOf(this.ID);
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
