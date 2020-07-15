/*
 * DrawerID.java
 *
 * Created on February 10, 2003, 12:34 PM
 */

package com.verifone.isd.vsms2.sales.ent.trans;

/**
 * Identifier for a specific Till session
 *
 * @author  mailto:David_E3@verifone.com
 * @version 1.0
 */

public class DrawerID implements java.io.Serializable {
    static final long serialVersionUID = -3223552834243490248L;
    private long id = 0L;
    
    /** Creates a new instance of DrawerID */
    public DrawerID() {
    }
    
    /** Get the drawer ID
     * @return a long identifying the drawer, or 0 if the value has not been set.
     */
    public long getId() {
        return this.id;
    }
    
    /** Set the drawer ID
     * @param id a long identifying the drawer
     */
    public void setId(long id) {
        this.id = id;
    }
}
