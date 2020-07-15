/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
*
* Created 27 Jun, 2005                                     Sudesh Srinivasan
*/
package com.verifone.isd.vsms2.net.ent;

import java.io.Serializable;

/**
 * AcctPrintInfo is a Helper entity that holds printing related information for
 * a network transaction.
 * 
 * @author Sudesh_s1
 *  
 */
public class AcctPrintInfo implements Serializable {
    
	static final long serialVersionUID = 1667202442646620476L;
	
	protected boolean maskAcctStoreCopy;
    protected boolean maskAcctCustCopy;
    protected String maskString;
    protected boolean hideExpDateStoreCopy;
    protected boolean hideExpDateCustCopy;
    protected boolean prepaidCard;
    protected boolean propCard;
    protected boolean debitCard;
    protected boolean fastCredit;
    protected boolean fcDcrReceipt;
    protected boolean printSignatureImage;
    
    /** Creates a new instance of AcctPrintInfo */
	public AcctPrintInfo() {
	}
    
    /**
     * @return Returns the hideExpDateCustCopy.
     */
    public boolean isHideExpDateCustCopy() {
        return hideExpDateCustCopy;
    }
    /**
     * @param hideExpDateCustCopy The hideExpDateCustCopy to set.
     */
    public void setHideExpDateCustCopy(boolean hideExpDateCustCopy) {
        this.hideExpDateCustCopy = hideExpDateCustCopy;
    }
    /**
     * @return Returns the hideExpDateStoreCopy.
     */
    public boolean isHideExpDateStoreCopy() {
        return hideExpDateStoreCopy;
    }
    /**
     * @param hideExpDateStoreCopy The hideExpDateStoreCopy to set.
     */
    public void setHideExpDateStoreCopy(boolean hideExpDateStoreCopy) {
        this.hideExpDateStoreCopy = hideExpDateStoreCopy;
    }
    /**
     * @return Returns the maskAcctCustCopy.
     */
    public boolean isMaskAcctCustCopy() {
        return maskAcctCustCopy;
    }
    /**
     * @param maskAcctCustCopy The maskAcctCustCopy to set.
     */
    public void setMaskAcctCustCopy(boolean maskAcctCustCopy) {
        this.maskAcctCustCopy = maskAcctCustCopy;
    }
    /**
     * @return Returns the maskAcctStoreCopy.
     */
    public boolean isMaskAcctStoreCopy() {
        return maskAcctStoreCopy;
    }
    /**
     * @param maskAcctStoreCopy The maskAcctStoreCopy to set.
     */
    public void setMaskAcctStoreCopy(boolean maskAcctStoreCopy) {
        this.maskAcctStoreCopy = maskAcctStoreCopy;
    }
    /**
     * @return Returns the maskString.
     */
    public String getMaskString() {
        return maskString;
    }
    /**
     * @param maskString The maskString to set.
     */
    public void setMaskString(String maskString) {
        this.maskString = maskString;
    }
    
	/**
	 * @return Returns the prepaidCard.
	 */
	public boolean isPrepaidCard() {
		return prepaidCard;
	}
	/**
	 * @param prepaidCard The prepaidCard to set.
	 */
	public void setPrepaidCard(boolean prepaidCard) {
		this.prepaidCard = prepaidCard;
	}
	/**
	 * @return Returns the propCard.
	 */
	public boolean isPropCard() {
		return propCard;
	}
	/**
	 * @param propCard The propCard to set.
	 */
	public void setPropCard(boolean propCard) {
		this.propCard = propCard;
    }
	
	/**
	 * @return Returns the debitCard.
	 */
	public boolean isDebitCard() {
		return debitCard;
	}
	/**
	 * @param debitCard The debitCard to set.
	 */
	public void setDebitCard(boolean debitCard) {
		this.debitCard = debitCard;
	}
	
	/**
	 * @return Returns the fastCredit.
	 */
	public boolean isFastCredit() {
		return fastCredit;
	}
	/**
	 * @param fastCredit The fastCredit to set.
	 */
	public void setFastCredit(boolean fastCredit) {
		this.fastCredit = fastCredit;
	}
	
	/**
	 * @return Returns the fcDcrReceipt.
	 */
	public boolean isFcDcrReceipt() {
		return fcDcrReceipt;
	}
	/**
	 * @param fcDcrReceipt The fcDcrReceipt to set.
	 */
	public void setFcDcrReceipt(boolean fcDcrReceipt) {
		this.fcDcrReceipt = fcDcrReceipt;
	}

	/**
	 * @return the boolean value for print signature image
	 */
	public boolean isPrintSignatureImage() {
		return printSignatureImage;
	}

	/**
	 * @param printSignatureImage the print Signature Image boolean value to set
	 */
	public void setPrintSignatureImage(boolean printSignatureImage) {
		this.printSignatureImage = printSignatureImage;
	}
}