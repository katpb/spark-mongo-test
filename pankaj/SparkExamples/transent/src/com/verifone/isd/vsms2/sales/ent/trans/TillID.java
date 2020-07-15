/*
 * TillID.java
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

public class TillID implements java.io.Serializable {
    static final long serialVersionUID = 2920086854508137018L;
    
    private String id = null;
    
    /** Creates a new instance of TillID */
    public TillID() {
    }
    
    /**
     * @return a string digest identifying the till, or null if the value has not been set.
     */
    public String getId() {
        return this.id;
    }
    
    /**
     * @param id a String identifying the till
     */
    public void setId(String id) {
        this.id = id;
    }
}
