/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
*
* Created 10 Apr, 2006                                     Sudesh Srinivasan
*/
package com.verifone.isd.vsms2.sales.ent.trans;


/**
 * Represents a payment line tendered towards an in-house account.
 * @author sudesh_s1
 */
public class InHouseAcctPaymentLine extends PaymentLine {

	private static final long serialVersionUID = -4023004444930766131L;

	/** Holds value of property inHouseAcct. */
    private String inHouseAcct;
    
    /** Optional name for the in-house account */
    private String inHouseName;
    
    /** Hold value of sub account */
    private String subAccount;
    
    
    /**
     * 
     */
    public InHouseAcctPaymentLine() {
        super();
    }

    /**
     * @return Returns the inHouseAcct.
     */
    public String getInHouseAcct() {
        return inHouseAcct;
    }
    /**
     * @param inHouseAcct The inHouseAcct to set.
     */
    public void setInHouseAcct(String inHouseAcct) {
        this.inHouseAcct = inHouseAcct;
    }
    
    
	/**
	 * @return Returns the inHouseName.
	 */
	public String getInHouseName() {
		return inHouseName;
	}
	/**
	 * @param inHouseName The inHouseName to set.
	 */
	public void setInHouseName(String inHouseName) {
		this.inHouseName = inHouseName;
	}

	public String getSubAccount() {
		return subAccount;
	}

	public void setSubAccount(String subAccount) {
		this.subAccount = subAccount;
	}
}
