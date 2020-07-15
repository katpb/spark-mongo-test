/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
*
* Created 30 Sep, 2004                                     Sudesh Srinivasan
*/
package com.verifone.isd.vsms2.sales.ent.menu;

import com.verifone.isd.vsms2.sales.ent.plu.PluPK;

/**
 * Entity to represent the items assigned to a menu.
 * @author  sudesh_s1
 * @version 1.0
 */
public class MenuItem implements java.io.Serializable {
    
    static final long serialVersionUID = -2043334097281004156L;
    
    protected int ID;
    private PluPK plu;
    
    /** Creates a new instance of MenuKeyItem
     * @param ID item ID
     * @param plu plu associated with the menu item
     */
    public MenuItem(int ID, PluPK plu) {
        this.ID = ID;
        this.plu = plu;
    }
    
    /** Creates a new instance of MenuKeyItem
     * @param ID item ID
     */    
    public MenuItem(int ID) {
        this(ID, null);
    }
    
    /** Creates a new instance of MenuKeyItem
     */    
    public MenuItem() {
    }
    
    /** Getter for the menu key item's ID
     * @return menu key item's ID
     */    
    public int getID() {
        return this.ID;
    }
    
    /** Setter for the menu key item's ID
     * @param ID menu key item's ID
     */    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    /** Getter for plu associated with the menu key item
     * @return plu id for the menu item
     */    
    public PluPK getPlu() {
        return plu;
    }
    
    /** Setter for plu associated with the menu key item
     * @param plu plu id for the menu item
     */    
    public void setPlu(PluPK plu) {
        this.plu = plu;
    }
    
    /** Method to validate the primary key of the entity object
     * @throws Exception on invalid data
     */
    public void validate() throws Exception {
        if (this.ID <= 0)
            throw new Exception("Invalid Menu key item ID: " +this.ID);
        if ((this.plu != null) && (!this.plu.isValid()))
            throw new Exception("Invalid plu for Menu key item: " +this.ID);
    }
    
    /** String representation of the entity
     * @return String representation of the entity
     */    
    public String toString() {
        return "ID:" + ID + ";plu:" + plu;
    }
}
