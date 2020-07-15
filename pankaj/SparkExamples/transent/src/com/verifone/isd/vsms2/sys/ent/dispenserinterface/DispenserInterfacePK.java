/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
*
* Created 18 June, 2009                                     Ganesh Kumar
*/

package com.verifone.isd.vsms2.sys.ent.dispenserinterface;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Primary key class for DispenserInterface.
 * @author  ganesh_k1
 * @version 1.0
 */
public class DispenserInterfacePK implements IEntityPK {

    private static final long serialVersionUID = -9158531899454111215L;
    private int interfaceID;
    
    /** Creates a new instance of DispenserInterfacePK */
    public DispenserInterfacePK() {
    }

    /** Constructor
     * @param menuNum menu number
     */    
    public DispenserInterfacePK(int interfaceID) {
        this.interfaceID = interfaceID;
    }

    /**
     * @return the interfaceID
     */
    public int getValue() {
        return interfaceID;
    }

    /**
     * @param interfaceID the interfaceID to set
     */
    public void setValue(int interfaceID) {
        this.interfaceID = interfaceID;
    }

    /** Method to compare two DispenserInterfacePK objects for equality
     * @param obj DispenserInterfacePK object to be compared against
     * @return true if both primary keys represent the same DispenserInterface
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof DispenserInterfacePK) {
            DispenserInterfacePK lObj = (DispenserInterfacePK)obj;
            return (this.interfaceID == lObj.interfaceID);
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
        hc = 37 * hc + this.interfaceID;
        return hc;
    }
    
    /** Validator for the interfaceID
     * @return true if the interfaceID
     */    
    public boolean isValid() {
        return (this.interfaceID > 0);
    }    
    
    /*
     * Helper method to convert the primary key to a string
     */
    /** String representation of the entity PK
     * @return String representation of the entity PK
     */    
    public String toString() {
        return String.valueOf(interfaceID);
    }
}

