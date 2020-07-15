/*
 * DCRReceipt.java
 *
 * Created on September 10, 2003
 */

package com.verifone.isd.vsms2.fuel.ent.util;

import java.io.Serializable;

import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/**
 * Aggregates all data related to a Fuel Sale
 * @author  D. Michael Barton
 */
public class DCRReceipt implements Serializable {
    
    static final long VersionUID = -3778071828700235962L;
    
    private MoneyAmount moneyAmount = null;
	private int numLines = 0;
	private String receiptString = "";

    /**
     * Creates a new instance of DCRReceipt.
     */
    public DCRReceipt() {
	}
	
	/**
     * Creates a new instance of DCRReceipt.
     */
    public DCRReceipt(long money, String receiptString) {
		this.moneyAmount = new MoneyAmount(money);
		setReceiptString(receiptString);
    }

	/**
     * Creates a new instance of DCRReceipt.
     */
    public DCRReceipt(long money, int numLines, String receiptString) {
		this.moneyAmount = new MoneyAmount(money);
		this.numLines = numLines;
		setReceiptString(receiptString);
    }

    /**
     * Getter method for "Money Amount"
     * @return MoneyAmount
     */
    public MoneyAmount getMoneyAmount() {
		return(moneyAmount);
    }
    
    /**
     * Setter method for "Money Amount"
     * @param moneyAmount
     */
    public void setMoneyAmount(MoneyAmount moneyAmount) {
		this.moneyAmount = moneyAmount;
    }

    /**
     * Getter method for "Number of Lines in Receipt"
     * @return int
     */
    public int getNumLines() {
		return(numLines);
    }
    
    /**
     * Setter method for "Number of Lines in Receipt"
     * @param numLines
     */
    public void setNumLines(int numLines) {
		this.numLines = numLines;
    }

    /**
     * Getter method for "Receipt String"
     * @return String
     */
    public String getReceiptString() {
		return(receiptString);
    }
    
    /**
     * Setter method for "Receipt String"
     * @param receiptString
     */
    public void setReceiptString(String receiptString) {
		if(receiptString != null) {
			this.receiptString = receiptString;
		}
    }
}
