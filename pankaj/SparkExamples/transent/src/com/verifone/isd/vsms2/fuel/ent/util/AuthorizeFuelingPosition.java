/*
 * AuthorizeFuelingPosition.java
 *
 * Created on April 6, 2003, 10:19 AM
 */

package com.verifone.isd.vsms2.fuel.ent.util;


import java.io.Serializable;

import com.verifone.isd.vsms2.sys.util.Quantity;

/**
 *
 * @author  D. Michael Barton
 * Maintained by Satish_R1
 */
public class AuthorizeFuelingPosition implements Serializable {

	private static final long serialVersionUID = -7998772807049704481L;
    
    private short fuelingPosition = 0;
	private int productNumber = 0;
	private int MOP = 0;
	private Quantity quantity = null;
	private short terminalID = 0;
	private long receiptNumber = 0;
	private int tranType = 0;
    private int presetType = 0;
   /* Price per gallon discount amounts for various grades */
    private PpgDiscDetails ppgDiscDetails;
    

	/*
	 * preset Type definiitions
	 */
    public static final int CURRENCY_PRESET = 0;
    public static final int VOLUME_PRESET = 1;

	/*
	 * Auth Type definitions
	 */
	public static final int AUTH_POSTPAY = 0;
	public static final int AUTH_PREPAY_RESERVE = 1;
	public static final int AUTH_PREPAY_ARM = 2;

	/*
	 * Transaction Type definitions
	 */  
	public static final int TRAN_POSTPAY = 0;
	public static final int TRAN_PREPAY = 1;
	public static final int TRAN_PREPAY_APPROVE = 2;
    public static final int TRAN_DCR = 3;
	public static final int TRAN_PRESET_POSTPAY = 4;
	public static final int TRAN_PAMPOS = 5;
	/*
	 * Mode definitions
	 */
	public static final int POSTPAY_CURRENCY = 0;
	public static final int POSTPAY_VOLUME = 1;
	public static final int PREPAY_CURRENCY = 2;
	public static final int PREPAY_VOLUME = 3;

	/*
	 * MOP definitions
	 */
	public static final int MOP_CASH = 1;
	public static final int MOP_CREDIT = 2;
	public static final int MOP_DEBIT = 3;
	public static final int MOP_SPEEDPASS = 4;
	public static final int MOP_MOBILE = 5;

        
    /** Creates a new instance of AuthorizeFuelingPosition */
    public AuthorizeFuelingPosition(short aFuelingPosition,
    								int aProductNumber,
    								int aMOP,
									Quantity aQuantity,
									long aReceiptNumber,
									short aTerminalID,
									int aTranType,
									int aPresetType,
									PpgDiscDetails aDiscDetails) {

        setFuelingPosition(aFuelingPosition);
        setProductNumber(aProductNumber);
        setMOP(aMOP);
	    setQuantity(aQuantity);
	    setReceiptNumber(aReceiptNumber);
	    setTerminalID(aTerminalID);
	    setTranType(aTranType);
	    setPresetType(aPresetType);
	    setPpgDiscDetails(aDiscDetails);

    }
    
    
	/** Creates a new instance of AuthorizeFuelingPosition */
    public AuthorizeFuelingPosition(short fuelingPosition,
    								int productNumber,
    								int MOP,
									Quantity quantity,
									long receiptNumber,
									short terminalID,
									int tranType) {

        setFuelingPosition(fuelingPosition);
        setProductNumber(productNumber);
        setMOP(MOP);
		setQuantity(quantity);
		setReceiptNumber(receiptNumber);
        setTerminalID(terminalID);
	    setTranType(tranType);
      
    }

   
    
    
    /**
     * Getter for fueling position
     * @return short
     */
    public short getFuelingPosition() {
        return fuelingPosition;
    }
    
    /**
     * Setter for fueling position
     * @param fuelingPosition
     */
    public void setFuelingPosition(short fuelingPosition) {
        this.fuelingPosition = fuelingPosition;
    }

    /**
     * Getter for "Product number"
     * @return int
     */
    public int getProductNumber() {
		return(productNumber);
	}
    
    /**
     * Setter for "Product number"
     * @param productNumber
     */
    public void setProductNumber(int productNumber) {
		this.productNumber = productNumber;
	}

    /**
     * Getter for "MOP"
     * @return int
     */
    public int getMOP() {
		return(MOP);
	}
    
    /**
     * Setter for "MOP"
     * @param MOP
     */
    public void setMOP(int MOP) {
		this.MOP = MOP;
	}

    /**
     * Setter for "Transaction Type"
     * @param tranType
     */
	public void setTranType(int tranType) {
		this.tranType = tranType;
	}

	/**
	 * Getter for "Transaction Type"
	 * @return int
	 */
	public int getTranType() {
		return(tranType);
	}

	/**
	 * Getter for "Quantity"
	 * @return Quantity
	 */
    public Quantity getQuantity() {
		return(quantity);
	}
    
    /**
     * Setter for "Quantity"
     * @param quantity
     */
    public void setQuantity(Quantity quantity) {
		this.quantity = quantity;
	}

    /**
     * Getter for "Receipt Number"
     * @return long
     */
    public long getReceiptNumber() {
		return(receiptNumber);
	}
    
    /**
     * Setter for "Receipt Number"
     * @param receiptNumber
     */
    public void setReceiptNumber(long receiptNumber) {
		this.receiptNumber = receiptNumber;
	}

    /**
     * Getter for "Terminal ID"
     * @return short
     */
    public short getTerminalID() {
		return(terminalID);
	}
    
    /**
     * Setter for "Terminal ID"
     * @param terminalID
     */
    public void setTerminalID(short terminalID) {
		this.terminalID = terminalID;
	}

    /**
     * @return the presetType
     */
    public int getPresetType() {
        return presetType;
    }

    /**
     * @param presetType the presetType to set
     */
    public void setPresetType(int presetType) {
        this.presetType = presetType;
    }

    /**
     * 
     * @return the PPG discount details
     */
	public PpgDiscDetails getPpgDiscDetails() {
		return ppgDiscDetails;
	}
	/**
	 * @param ppgDiscDetails the ppgDiscDetails to set
	 */
	public void setPpgDiscDetails(PpgDiscDetails ppgDiscDetails) {
		this.ppgDiscDetails = ppgDiscDetails;
	}
}
