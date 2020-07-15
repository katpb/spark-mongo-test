/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 2 July, 2007                                     Anindya Datta
 */
package com.verifone.isd.vsms2.net.ent;

import java.io.Serializable;

/**
 * EncryptReceiptInfo will hold encrypted credit card information that is
 * required for receipt printing. After receiving approval from the host,
 * sensitive credit card information is encrypted and stored in this object.
 * Before storing the transaction into the database, corresponding fields are
 * nulled out in <code>NetPayInfo</code>. When the transaction is retrieved
 * for receipt reprint, the fields are decrypted from this object and populated
 * back in <code>NetPayInfo</code>.
 * 
 * @author Anindya_D1
 * 
 */
public class EncryptReceiptInfo implements Serializable {

	static final long serialVersionUID = -5788825024733405459L;

	private String encAccountNum; // Encrypted account number

	private String encExpiryDate; // Encrypted expiration date

	private String encCardHolderName; // Encrypted card holder name

	/**
	 * @return the encAccountNum
	 */
	public String getEncAccountNum() {
		return encAccountNum;
	}

	/**
	 * @param encAccountNum
	 *            the encAccountNum to set
	 */
	public void setEncAccountNum(String encAccountNum) {
		this.encAccountNum = encAccountNum;
	}

	/**
	 * @return the encCardHolderName
	 */
	public String getEncCardHolderName() {
		return encCardHolderName;
	}

	/**
	 * @param encCardHolderName
	 *            the encCardHolderName to set
	 */
	public void setEncCardHolderName(String encCardHolderName) {
		this.encCardHolderName = encCardHolderName;
	}

	/**
	 * @return the encExpiryDate
	 */
	public String getEncExpiryDate() {
		return encExpiryDate;
	}

	/**
	 * @param encExpiryDate
	 *            the encExpiryDate to set
	 */
	public void setEncExpiryDate(String encExpiryDate) {
		this.encExpiryDate = encExpiryDate;
	}
}
