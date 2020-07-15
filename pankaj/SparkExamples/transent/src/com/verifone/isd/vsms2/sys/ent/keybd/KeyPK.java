/*
 * KeyPK.java
 *
 * Created on April 1, 2003, 5:39 PM
 */

package com.verifone.isd.vsms2.sys.ent.keybd;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPersistAdmin;
import com.verifone.isd.vsms2.sys.db.pres.IRegisterEntityPK;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/** Primary key class for Key entity
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class KeyPK implements IRegisterEntityPK {
    static final long serialVersionUID = -1359542468552278601L;
    private int columnId;
    private int rowId;
    private int registerId;
    
    /** No-args constructor
     */
    public KeyPK() {
    }
    
    public KeyPK(int columnId, int rowId, int registerId) {
        this.columnId = columnId;
        this.rowId = rowId;      
        if(registerId == IEntityPersistAdmin.OLD_CONTROLLER_ID)
        {
        	this.registerId = IEntityPersistAdmin.CONTROLLER_ID;
        }else{
        	this.registerId = registerId;
        }
    }
 
    
    /** Compares two KeyPK objects for equality
     * @param obj primary key to be compared with
     * @return true if both PK values are the same
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof KeyPK) {
            KeyPK aObj = (KeyPK)obj;
            return (this.registerId == aObj.registerId && this.columnId == aObj.columnId &&
            this.rowId == aObj.rowId);
        }
        return false;
    }
    
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof IEntityPK) {
            return this.equals((IEntityPK) obj);
        }
        return false;
    }
    
    /** Validator for the id value
     * @return true if the id value is valid
     */    
    public boolean isValid() {
        return ((this.registerId >= IEntityPersistAdmin.CONTROLLER_ID) && 
        (this.columnId >= 0) && (this.columnId < Key.MAX_COLUMNS) && 
        (this.rowId >= 0) && (this.rowId < Key.MAX_ROWS));
    }   

    /*
     * Helper method to convert the primary key to a string
     */
    public String toString() {
        return String.valueOf(this.registerId +"-" +this.columnId +":" +this.rowId);
    }        
    
    /**
     * Get the register id for the entity
     * @return regId register assigned for the entity
     */
    public int getRegisterId() {
        return this.registerId;
    }
    
    /**
     * Set the register id for the entity
     * @param regId register assigned for the entity
     */
    public void setRegisterId(int regId) {
    	if(regId == IEntityPersistAdmin.OLD_CONTROLLER_ID)
        {
        	this.registerId = IEntityPersistAdmin.CONTROLLER_ID;
        }else{
        	this.registerId = regId;
        }
    }
    
    /** Getter for property columnId.
     * @return Value of property columnId.
     */
    public int getColumnId() {
        return columnId;
    }
    
    /** Setter for property columnId.
     * @param columnId New value of property columnId.
     */
    public void setColumnId(int columnId) {
        this.columnId = columnId;
    }
    
    /** Getter for property rowId.
     * @return Value of property rowId.
     */
    public int getRowId() {
        return rowId;
    }
    
    /** Setter for property rowId.
     * @param rowId New value of property rowId.
     */
    public void setRowId(int rowId) {
        this.rowId = rowId;
    }
    
    /** 
     * Method override since equals() is implemented
     * @return hash code for the object
     */    
    public int hashCode() {
        int hc = 17;
        hc = 37 * hc + this.rowId;
        hc = 37 * hc + this.columnId;
        return hc;
    }  
}
