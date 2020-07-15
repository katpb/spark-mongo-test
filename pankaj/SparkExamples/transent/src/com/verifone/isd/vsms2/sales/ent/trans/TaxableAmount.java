/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
*
* Created 13 Nov, 2006                                     Sudesh Srinivasan
*/
package com.verifone.isd.vsms2.sales.ent.trans;

import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/**
 * Value object for storing taxable amount information
 * @author  sudesh_s1
 * @version 1.0
 */
public class TaxableAmount implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1238517345126066170L;

	/** Holds value of property taxable. */
    private MoneyAmount amount;
    
    /** Holds value of property exempt. */
    private boolean exempt;
    
    /** Hold inclusive tax*/
    private boolean inclusive;
    
    /**
     * @param amount
     * @param exempt
     */
    public TaxableAmount(MoneyAmount amount, boolean exempt) {
        super();
        this.amount = amount;
        this.exempt = exempt;
    }
    
    /**
     * Constructor with three argument.
     * @param amount
     * @param exempt
     * @param inclusive
     */
    public TaxableAmount(MoneyAmount amount, boolean exempt, boolean inclusive) {
        super();
        this.amount = amount;
        this.exempt = exempt;
        this.inclusive = inclusive;
    }
    
    /**
     * @return Returns the exempt.
     */
    public boolean isExempt() {
        return exempt;
    }
    /**
     * @param exempt The exempt to set.
     */
    public void setExempt(boolean exempt) {
        this.exempt = exempt;
    }
    /**
     * @return Returns the taxable.
     */
    public MoneyAmount getAmount() {
        return amount;
    }
    /**
     * @param amount The taxable amount to set.
     */
    public void setAmount(MoneyAmount amount) {
        this.amount = amount;
    }
    
    /**
     * @return Returns the inclusive 
     */
	public boolean isInclusive() {
		return inclusive;
	}
	/**
	 * @param inclusive The inclusive status of the tax.
	 */
	public void setInclusive(boolean inclusive) {
		this.inclusive = inclusive;
	}
}
