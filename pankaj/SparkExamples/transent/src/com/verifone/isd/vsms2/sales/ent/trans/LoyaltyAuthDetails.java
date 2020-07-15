/**
 * 
 */
package com.verifone.isd.vsms2.sales.ent.trans;

import java.io.Serializable;

/**
 * @author anindya_d1
 *
 */
public class LoyaltyAuthDetails implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5764713849702513999L;
	
	private String programID = "";
	private String programName = "";
	private String accountNum;
	private String entryMethod;
	private String approvalCode;
	private String customer;
	private String accountType;
	
	
	
	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}
	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	/**
	 * @return the programID
	 */
	public String getProgramID() {
		return programID;
	}
	/**
	 * @param programID the programID to set
	 */
	public void setProgramID(String programID) {
		this.programID = programID;
	}
	/**
	 * @return the accountNum
	 */
	public String getAccountNum() {
		return accountNum;
	}
	/**
	 * @param accountNum the accountNum to set
	 */
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	/**
	 * @return the entryMethod
	 */
	public String getEntryMethod() {
		return entryMethod;
	}
	/**
	 * @param entryMethod the entryMethod to set
	 */
	public void setEntryMethod(String entryMethod) {
		this.entryMethod = entryMethod;
	}
	/**
	 * @return the approvalCode
	 */
	public String getApprovalCode() {
		return approvalCode;
	}
	/**
	 * @param approvalCode the approvalCode to set
	 */
	public void setApprovalCode(String approvalCode) {
		this.approvalCode = approvalCode;
	}
	
	/**
	 * If program name is not present return the program ID (acquirer ID)
	 * 
	 * @return loyalty program name
	 */
	public String getProgramName() {
		if ((programName == null) || programName.isEmpty()) {
			return programID;
		}
		return programName;
	}
	
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LoyaltyAuthDetails) {
			LoyaltyAuthDetails auth = (LoyaltyAuthDetails)obj;
			return (auth.programID.equals(this.programID));
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hc = 37 * 17;
		return (hc + programID.hashCode());
	}
	
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getCustomer() {
		return customer;
	}
}
