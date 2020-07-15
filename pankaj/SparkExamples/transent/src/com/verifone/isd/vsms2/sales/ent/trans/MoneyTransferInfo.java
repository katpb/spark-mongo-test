/*
 * MoneyTransferInfo.java
 *
 * Created on Nov 22, 2005
 * Verifone Inc, Copyright (c) All rights reserved
 */
package com.verifone.isd.vsms2.sales.ent.trans;

import java.util.Date;

import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/** 
 * Entity containing all the information needed to report a money transfer.  
 * This property will be set by the money transfer service after successfully 
 * completing a money transfer.
 *
 * @author Allison_H1
 */
public class MoneyTransferInfo implements java.io.Serializable {

    static final long serialVersionUID = -6407986484701770249L;

    private MoneyAmount amount;
    private String accountNumber;
    private String approvalCode;
    private String transactionID;
    private MoneyAmount fee;  
    private boolean feeAdded;
    private String beneficiaryName;
    private String beneficiaryNumber;
    private String referenceNumber;
    private Date time;

    /** 
     * Creates a new instance of Class. 
     * The property methods will have to be used to set properties.
     */
    public MoneyTransferInfo() {
    	this.setAmount(new MoneyAmount(0));
	    this.setAccountNumber("");
	    this.setApprovalCode("");
	    this.setTransactionID("");
	    this.setFee(new MoneyAmount(0));    
	    this.setBeneficiaryName("");
	    this.setBeneficiaryNumber("");
	    this.setReferenceNumber("");
    }
 
    /** 
     * Get the total amount of the money transfer.  This may contain a fee.
     * @return MoneyAmount  money transfer amount
     */    
    public MoneyAmount getAmount() {
        return amount;
    }

    /** 
     * Set the total amount of the money transfer.  This may contain a fee.
     * @param amount Amount of money transfer
     */    
    public void setAmount(MoneyAmount amount) {
        this.amount = amount;
    }

    /** 
     * Get the time of money transfer authorization
     * @return money transfer authorization time
     */    
    public Date getTime() {
        return this.time;
    }

    /** 
     * Get the time of money transfer authorization
     * @param time money transfer authorization time
     */    
    public void setTime(Date time) {
        this.time = time;
    }

    /** 
     * Get fee amount charged to customer for money transfer.
     * Initial value upon object creation is 0.00
     * @return fee charged to customer
     */
    public MoneyAmount getFee() {
        return fee;
    }
    
    /** 
     * Set fee amount charged to customer for money transfer.  If this fee
     * is included in the total amount field, the feeAdded flag should be set.
     * @param fee charged to customer
     */
    public void setFee(MoneyAmount fee) {
        this.fee = fee;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }
    
	/**
	 * @return Returns the beneficiaryName.
	 */
	public String getBeneficiaryName() {
		return beneficiaryName;
	}
	
	/**
	 * @param beneficiaryName The beneficiaryName to set.
	 */
	public void setBeneficiaryName(String beneficiaryName) {
		this.beneficiaryName = beneficiaryName;
	}
	
	/**
	 * @return Returns the beneficiaryNumber.
	 */
	public String getBeneficiaryNumber() {
		return beneficiaryNumber;
	}
	
	/**
	 * @param beneficiaryNumber The beneficiaryNumber to set.
	 */
	public void setBeneficiaryNumber(String beneficiaryNumber) {
		this.beneficiaryNumber = beneficiaryNumber;
	}
	
	/**
	 * @return Returns the referenceNumber.
	 */
	public String getReferenceNumber() {
		return referenceNumber;
	}
	
	/**
	 * @param referenceNumber The referenceNumber to set.
	 */
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	
	/**
	 * @return Returns the feeAdded.
	 */
	public boolean isFeeAdded() {
		return feeAdded;
	}
	
	/**
	 * @param feeAdded The feeAdded to set.
	 */
	public void setFeeAdded(boolean feeAdded) {
		this.feeAdded = feeAdded;
	}
}
