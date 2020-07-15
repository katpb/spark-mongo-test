/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
*
* Created 18 June, 2009                                     Ganesh Kumar
*/

package com.verifone.isd.vsms2.sys.ent.dispenser;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Primary key class for Dispenser.
 * @author  ganesh_k1
 * @version 1.0
 */
public class DispenserPK implements IEntityPK {

    private static final long serialVersionUID = -9158531899454111215L;
    private String dispenserID;
    
    /** Creates a new instance of DispenserInterfacePK */
    public DispenserPK() {
    }

    /** Constructor
     * @param menuNum menu number
     */    
    public DispenserPK(String dispenserID) {
        this.dispenserID = dispenserID;
    }

    /**
     * @return the interfaceID
     */
    public String getValue() {
        return dispenserID;
    }

    /**
     * @param dispenserID the dispenserID to set
     */
    public void setValue(String dispenserID) {
        this.dispenserID = dispenserID;
    }

    /** Method to compare two DispenserInterfacePK objects for equality
     * @param obj DispenserInterfacePK object to be compared against
     * @return true if both primary keys represent the same Dispenser
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof DispenserPK) {
            DispenserPK lObj = (DispenserPK)obj;
            return (this.dispenserID.equals(lObj.dispenserID));
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
        hc = 37 * hc + this.dispenserID.hashCode();
        return hc;
    }
    
    /** Validator for the dispenserID
     * @return true if the dispenserID
     */    
    public boolean isValid() {
        return (this.dispenserID != null && this.dispenserID.trim().length() > 0
		&& this.dispenserID.trim().length() <= 10);
    }    
    
    /*
     * Helper method to convert the primary key to a string
     */
    /** String representation of the entity PK
     * @return String representation of the entity PK
     */    
    public String toString() {
        return String.valueOf(dispenserID);
    }
}

