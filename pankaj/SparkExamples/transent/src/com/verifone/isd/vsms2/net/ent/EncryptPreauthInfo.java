/*
 * Created on Jul 12, 2007
 *
 */
package com.verifone.isd.vsms2.net.ent;

import java.io.Serializable;

/**
 * @author Anindya_D1
 * 
 * EncryptPreauthInfo will hold encrypted credit card information that is
 * required to generate completion (collect / force post / financial advice) for
 * a fast credit merchandise transaction. The pre-auth information is stored in
 * netPendTxnTbl of Newpro txnDB. The pre-auth information contains the
 * transaction entity and the card information (NetECPRequest) associated with
 * it. Before storing the NetECPRequest to netPendTxnTbl, the sensitive fields
 * within CardData will be encrypted and stored in this value object. The value
 * object will be attached to NetECPRequest and the sensitive fields within
 * CardData will be cleared. When the pre-auth information is retrieved from the
 * database, the fields within this value object will be decrypted and the
 * corresponding fields of CardData will be populated with the decrypted values.
 */
public class EncryptPreauthInfo implements Serializable {
	
	static final long serialVersionUID = -4622360213929720070L;
	
	private String encTrack1Data;
	private String encTrack2Data;
	private String encAccountNum;
	private String encExpiryDate;
	private String encServiceCode;
	private String encAccountName;

	/**
	 * 
	 */
	public EncryptPreauthInfo() {
	}

	/**
	 * @return Returns the encAccountNum.
	 */
	public String getEncAccountNum() {
		return encAccountNum;
	}
	/**
	 * @param encAccountNum The encAccountNum to set.
	 */
	public void setEncAccountNum(String encAccountNum) {
		this.encAccountNum = encAccountNum;
	}
	/**
	 * @return Returns the encExpiryDate.
	 */
	public String getEncExpiryDate() {
		return encExpiryDate;
	}
	/**
	 * @param encExpiryDate The encExpiryDate to set.
	 */
	public void setEncExpiryDate(String encExpiryDate) {
		this.encExpiryDate = encExpiryDate;
	}
	/**
	 * @return Returns the encServiceCode.
	 */
	public String getEncServiceCode() {
		return encServiceCode;
	}
	/**
	 * @param encServiceCode The encServiceCode to set.
	 */
	public void setEncServiceCode(String encServiceCode) {
		this.encServiceCode = encServiceCode;
	}
	/**
	 * @return Returns the encTrack1Data.
	 */
	public String getEncTrack1Data() {
		return encTrack1Data;
	}
	/**
	 * @param encTrack1Data The encTrack1Data to set.
	 */
	public void setEncTrack1Data(String encTrack1Data) {
		this.encTrack1Data = encTrack1Data;
	}
	/**
	 * @return Returns the encTrack2Data.
	 */
	public String getEncTrack2Data() {
		return encTrack2Data;
	}
	/**
	 * @param encTrack2Data The encTrack2Data to set.
	 */
	public void setEncTrack2Data(String encTrack2Data) {
		this.encTrack2Data = encTrack2Data;
	}	
	/**
	 * @return Returns the encAccountName.
	 */
	public String getEncAccountName() {
		return encAccountName;
	}
	/**
	 * @param encAccountName The encAccountName to set.
	 */
	public void setEncAccountName(String encAccountName) {
		this.encAccountName = encAccountName;
	}
}
