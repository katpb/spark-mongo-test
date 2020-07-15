/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
*
* Created 08 June, 2009                                     Ganesh Kumar
*/

package com.verifone.isd.vsms2.sys.ent.posterminalcfg;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Primary key class for POSTerminal.
 * @author  ganesh_k1
 * @version 1.0
 */
public class POSTerminalPK implements IEntityPK {

    private static final long serialVersionUID = 7191129375728405254L;
    private String terminalID;
    
    /** Creates a new instance of POSTerminalPK */
    public POSTerminalPK() {
    }

    /** Constructor
     * @param menuNum menu number
     */    
    public POSTerminalPK(String terminalID) {
        this.terminalID = terminalID;
    }

    /**
     * @return the terminalID
     */
    public String getValue() {
        return terminalID;
    }

    /**
     * @param terminalID the terminalID to set
     */
    public void setValue(String terminalID) {
        this.terminalID = terminalID;
    }

    /** Method to compare two POSTerminalPK objects for equality
     * @param obj POSTerminalPK object to be compared against
     * @return true if both primary keys represent the same POSTerminal
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof POSTerminalPK) {
            POSTerminalPK lObj = (POSTerminalPK)obj;
            return (this.terminalID.equals(lObj.terminalID));
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
        hc = 37 * hc + this.terminalID.hashCode();
        return hc;
    }
    
    /** Validator for the terminalID and versionInfoID
     * @return true if the terminalID and versionInfoID are valid
     */    
    public boolean isValid() {
        return (this.terminalID != null && this.terminalID.trim().length() > 0
		&& this.terminalID.trim().length() <= 10);
    }    
    
    /*
     * Helper method to convert the primary key to a string
     */
    /** String representation of the entity PK
     * @return String representation of the entity PK
     */    
    public String toString() {
        return String.valueOf(terminalID);
    }
}

