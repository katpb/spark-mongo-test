/*
 * Created on Feb 2, 2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.verifone.isd.vsms2.sales.ent.inhouseacct;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * @author Anindya_D1
 *
 * Primary key class for In-house account
 */
public class InHouseAcctPK implements IEntityPK {
	
	static final long serialVersionUID = -4388218723252687131L;
	
	private String acctNum;

	public InHouseAcctPK() {
	}

	/**
	 * @param acctNum
	 */
	public InHouseAcctPK(String acctNum) {
		this.acctNum = acctNum;
	}
	/**
	 * @return Returns the acctNum.
	 */
	public String getAcctNum() {
		return acctNum;
	}
	/**
	 * @param acctNum The acctNum to set.
	 */
	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}
	
	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sys.db.pres.IEntityPK#equals(com.verifone.isd.vsms2.sys.db.pres.IEntityPK)
	 */
	public boolean equals(IEntityPK obj) {
		if (obj instanceof InHouseAcctPK) {
			InHouseAcctPK cObj = (InHouseAcctPK) obj;
			return this.acctNum.equals(cObj.acctNum);
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (obj instanceof InHouseAcctPK) {
			InHouseAcctPK cObj = (InHouseAcctPK) obj;
			return this.acctNum.equals(cObj.acctNum);
		}
		return false;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verifone.isd.vsms2.sys.db.pres.IEntityPK#isValid()
	 */
	public boolean isValid() {
		return ((this.acctNum != null) && (this.acctNum.length() > 0));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		int hc = 37 * 17;
		return hc + ((this.acctNum == null) ? 0 : this.acctNum.hashCode());
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.acctNum;
	}
}
