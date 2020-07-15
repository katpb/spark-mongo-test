/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
*
* Created 30 Sep, 2004                                     Sudesh Srinivasan
*/

package com.verifone.isd.vsms2.sales.ent.menu;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Primary key class for menu.
 * @author  sudesh_s1
 * @version 1.0
 */
public class MenuPK implements IEntityPK {
    static final long serialVersionUID =  -7790525839861923674L;
    
    private int menuNum;
    
    
    /** Creates a new instance of MenuPK */
    public MenuPK() {
    }

    /** Constructor
     * @param menuNum menu number
     */    
    public MenuPK(int menuNum) {
        this.menuNum = menuNum;
    }

    /** Getter for the menu number
     * @return menuKey number
     */    
    public int getValue() {
        return this.menuNum;
    }

    /** Setter for property value.
     * @param value New value of property value.
     */
    public void setValue(int value) {
        this.menuNum = value;
    }
    
    /** Method to compare two MenuPK objects for equality
     * @param obj MenuPK object to be compared against
     * @return true if both primary keys represent the same menu
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof MenuPK) {
            MenuPK lObj = (MenuPK)obj;
            return (this.menuNum == lObj.menuNum);
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
        hc = 37 * hc + this.menuNum;
        return hc;
    }
    
    /** Validator for the menu number
     * @return true if the menu number is valid
     */    
    public boolean isValid() {
        return ((this.menuNum > 0) && (this.menuNum <= Menu.MAX_MENUS));
    }    
    
    /*
     * Helper method to convert the primary key to a string
     */
    /** String representation of the entity PK
     * @return String representation of the entity PK
     */    
    public String toString() {
        return String.valueOf(this.menuNum);
    }
}

