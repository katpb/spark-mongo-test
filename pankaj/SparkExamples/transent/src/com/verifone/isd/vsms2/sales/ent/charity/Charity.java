package com.verifone.isd.vsms2.sales.ent.charity;

import java.util.ArrayList;
import java.util.List;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sales.ent.dept.DepartmentPK;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * 
 * @author T_LaxmanG1
 * @author BaishampayM1
 *
 */
public class Charity implements IEntityObject, ISalesEntityVisitable {

	private static final long serialVersionUID = -4380056762068605909L;
	private boolean enabled;
	private DepartmentPK department;	
	private boolean cashRoundUp;
	private boolean cashRestForCharity;
	private boolean networkRoundUp;
	private CharityPK pk;
	private List<CharityDenomination> denominations;
	public static final int MAX_CHARITY_PGMS = 1;

	/**
	 * Default constructor
	 */
	public Charity() {
		denominations = new ArrayList<CharityDenomination>();
	}
	
	/**
	 * 
	 * @param pk
	 */
	public Charity(CharityPK pk) {
		this.pk = pk;
		denominations = new ArrayList<CharityDenomination>();
	}
	
	/**
	 * Inside charity is enabled
	 * 
	 * @return
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * 
	 * Setter for Inside charity is enabled
	 * 
	 * @param enabled
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Charity department
	 * 
	 * @return
	 */
	public DepartmentPK getDepartment() {
		return department;
	}

	/**
	 * Setter for charity department
	 * 
	 * @param deptnr
	 */
	public void setDepartment(DepartmentPK department) {
		this.department = department;
	}

	/**
	 * Getter for cash round up 
	 *  
	 * @return
	 */
	public boolean isCashRoundUp() {
		return cashRoundUp;
	}

	/**
	 * Setter for cash round up
	 * 
	 * @param cashRoundUp
	 */
	public void setCashRoundUp(boolean cashRoundUp) {
		this.cashRoundUp = cashRoundUp;
	}

	/**
	 * Getter for Cash Rest for charity
	 * 
	 * @return
	 */
	public boolean isCashRestForCharity() {
		return cashRestForCharity;
	}

	/**
	 * Setter for Cash Rest for charity
	 * 
	 * @param cashRestForCharity
	 */
	public void setCashRestForCharity(boolean cashRestForCharity) {
		this.cashRestForCharity = cashRestForCharity;
	}

	/**
	 * Getter for Network Round Up
	 * 
	 * @return
	 */
	public boolean isNetworkRoundUp() {
		return networkRoundUp;
	}

	/**
	 * Setter for the Network Round Up
	 * 
	 * @param networkRoundUp
	 */
	public void setNetworkRoundUp(boolean networkRoundUp) {
		this.networkRoundUp = networkRoundUp;
	}

	@Override
	public void accept(SalesEntityVisitor v) throws Exception {
		v.visit(this);
	}

	@Override
	public IEntityPK getPK() {
		return this.pk;
	}

	@Override
	public void setPK(IEntityPK pk) {
		this.pk = (CharityPK) pk;
	}

	/**
	 * The charity denomination configurations
	 * 
	 * @return
	 */
	public List<CharityDenomination> getDenominations() {
		return denominations;
	}

	/**
	 * Sets the charity denomination configurations
	 * 
	 * @param denominations
	 */
	public void setDenominations(List<CharityDenomination> denominations) {
		this.denominations = denominations;
	}
	
	@Override
	public void setAttributes(IEntityObject obj) {
		Charity cObj = (Charity) obj;
		cObj.setPK(this.pk);
		cObj.setEnabled(this.enabled);
		cObj.setDepartment(this.department);
		cObj.setCashRoundUp(this.cashRoundUp);
		cObj.setCashRestForCharity(this.cashRestForCharity);
		cObj.setNetworkRoundUp(this.networkRoundUp);
		cObj.setDenominations(this.denominations);
	}

	@Override
	public void validate() throws Exception {
		if (!isPKValid()) {
			throw new Exception("Invalid charity: " + this.pk);
		}
		if (this.department == null) {
			throw new Exception("Invalid department for charity: " + this.department);
		}
	}

	@Override
	public boolean isPKValid() {
		return this.pk == null ? false : this.pk.isValid();
	}

}
