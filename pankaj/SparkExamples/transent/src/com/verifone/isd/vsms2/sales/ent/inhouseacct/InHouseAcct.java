/*
 * Created on Feb 2, 2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.verifone.isd.vsms2.sales.ent.inhouseacct;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * @author Anindya_D1
 *
 * This class represents a single inhouse account record
 */
public class InHouseAcct implements IEntityObject, ISalesEntityVisitable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6092314903453090780L;
	private InHouseAcctPK ID;
	private String name;
	private boolean enabled = true;
	private boolean promptForSubAcct = false;
	private boolean inHouseMOP = true;
	private boolean payIN = true;
	private boolean payOUT = true;
	
	
	public boolean isInHouseMOPAccount() {
		return inHouseMOP;
	}

	public void setInHouseMOP(boolean inHouseMOP) {
		this.inHouseMOP = inHouseMOP;
	}

	public boolean isPayINAccount() {
		return payIN;
	}

	public void setPayIN(boolean payIN) {
		this.payIN = payIN;
	}

	public boolean isPayOUTAccount() {
		return payOUT;
	}

	public void setPayOUT(boolean payOUT) {
		this.payOUT = payOUT;
	}
	
	public InHouseAcct() {
	}

	/**
	 * @param id
	 */
	public InHouseAcct(InHouseAcctPK id) {
		this.ID = id;
	}
	
	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sys.db.pres.IEntityObject#getPK()
	 */
	public IEntityPK getPK() {
		return this.ID;
	}
	
	public String getAcctNum() {
		return this.ID.getAcctNum();
	}
	
	public void setAcctNum(String acctNum) {
		this.ID = new InHouseAcctPK(acctNum);
	}

	/**
	 * @return Returns the enabled.
	 */
	public boolean isEnabled() {
		return enabled;
	}
	/**
	 * @param enabled The enabled to set.
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	public boolean isPromptForSubAcct() {
		return promptForSubAcct;
	}

	public void setPromptForSubAcct(boolean promptForSubAcct) {
		this.promptForSubAcct = promptForSubAcct;
	}

	
	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sys.db.pres.IEntityObject#setPK(com.verifone.isd.vsms2.sys.db.pres.IEntityPK)
	 */
	public void setPK(IEntityPK pk) {
		this.ID = (InHouseAcctPK) pk;
	}

	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sys.db.pres.IEntityObject#setAttributes(com.verifone.isd.vsms2.sys.db.pres.IEntityObject)
	 */
	public void setAttributes(IEntityObject obj) {
		InHouseAcct pObj = (InHouseAcct) obj;
        pObj.setPK(this.getPK());
        pObj.setName(this.getName());
        pObj.setEnabled(this.isEnabled()); 
        pObj.setPromptForSubAcct(this.isPromptForSubAcct());
        pObj.setInHouseMOP(this.isInHouseMOPAccount());
        pObj.setPayOUT(this.isPayOUTAccount());
        pObj.setPayIN(this.isPayINAccount());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verifone.isd.vsms2.sys.db.pres.IEntityObject#validate()
	 */
	public void validate() throws Exception {
		if (!isPKValid()) {
			throw new Exception("Invalid In-house account: " + this.ID);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verifone.isd.vsms2.sys.db.pres.IEntityObject#isPKValid()
	 */
	public boolean isPKValid() {
		return (this.ID == null) ? false : this.ID.isValid(); 
	}

	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable#accept(com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor)
	 */
	public void accept(SalesEntityVisitor v) throws Exception {
		v.visit(this);
	}

}
