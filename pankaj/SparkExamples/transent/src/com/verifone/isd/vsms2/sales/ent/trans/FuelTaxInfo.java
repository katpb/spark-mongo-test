/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
*
* Created 11 Mar, 2005                                     Sudesh Srinivasan
*/
package com.verifone.isd.vsms2.sales.ent.trans;

import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/**
 * Value object for storing fuel tax related information
 * @author  sudesh_s1
 * @version 1.0
 */
public class FuelTaxInfo implements java.io.Serializable {
    
    static final long serialVersionUID =  7494199593932195848L;
    
    /** Holds value of property sysId. */
    private int sysId;

    /** Holds value of property amt. */
    private MoneyAmount amt;
    
    /** Holds value of property desc. */
    private String desc;
    
    /** Creates a new instance of FuelTaxInfo */
    public FuelTaxInfo() {
    }

    /**
     * @return Returns the amt.
     */
    public MoneyAmount getAmt() {
        return amt;
    }
    /**
     * @param amt The amt to set.
     */
    public void setAmt(MoneyAmount amt) {
        this.amt = amt;
    }
    /**
     * @return Returns the desc.
     */
    public String getDesc() {
        return desc;
    }
    /**
     * @param desc The desc to set.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }
    /**
     * @return Returns the sysId.
     */
    public int getSysId() {
        return sysId;
    }
    /**
     * @param sysId The sysId to set.
     */
    public void setSysId(int sysId) {
        this.sysId = sysId;
    }
}
