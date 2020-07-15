/*
 * PosID.java
 *
 * Created on February 12, 2003, 2:35 PM
 */

package com.verifone.isd.vsms2.sales.ent.trans;

/**
 * Class to identify a POS Workstation
 *
 * @author  mailto:david_e3@verifone.com
 * @version 1.0
 */
public class PosID implements java.io.Serializable {
    static final long serialVersionUID = -1880187781378081716L;
    private long id = 0L;
    
    /** Creates a new instance of PosID */
    public PosID() {
    }
    
    /**
     * @param id a long identifying the POS workstation
     */
    public void setId(long id) {
        this.id = id;
    }
    
    /**
     * @return a long identifying the workstation, or 0L if the value has not been set.
     */
    public long getId() {
        return this.id;
    }
}
