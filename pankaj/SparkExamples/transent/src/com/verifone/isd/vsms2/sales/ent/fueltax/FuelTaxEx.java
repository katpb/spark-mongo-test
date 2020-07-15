/*
 * FuelTaxEx.java
 *
 * Created on February 17, 2005, 10:30 AM
 */

package com.verifone.isd.vsms2.sales.ent.fueltax;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/**
 * Entity class for fuel tax exemptions
 * @author tom_s5
 */
public class FuelTaxEx implements IEntityObject, ISalesEntityVisitable {
	static final long serialVersionUID = 5076686927520484918L;
	public static final int MAX_FUELTAXEX = 5;
	public static final int ADJ_AMT_DECIMALS = 3;
	
	private FuelTaxExPK ID;
	private String name;
	private MoneyAmount adjAmt;
	private short adjType;
	private int taxnr;
	private short signLine;

	/**
	 * No-args constructor
	 */
	public FuelTaxEx() {
	}

	/**
	 * Constructor
	 * @param pk TaxPK for the object
	 */
	public FuelTaxEx(FuelTaxExPK pk) {
	this.ID = pk;
	}

	/**
	 * Setter for property name
	 * @param name name of the entity
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for property name
	 * @return name of the entity
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Setter for property adjAmt
	 * @param adjAmt  name of the entity
	 */
	public void setAdjAmt(MoneyAmount adjAmt) {
		this.adjAmt = adjAmt;
	}

	/**
	 * Getter for property name
	 * @return name of the entity
	 */
	public MoneyAmount getAdjAmt() {
		return this.adjAmt;
	}

	/**
	 * Setter for property adjustment type
	 * @param adjType adjustment type of the entity
	 */
	public void setAdjType(short adjType) {
		this.adjType = adjType;
	}

	/**
	 * Getter for property adjType
	 * @return the adjustment type
	 */
	public short getAdjType() {
		return this.adjType;
	}

	/**
	 * Setter for property tax number
	 * @param taxnr tax number for the entity
	 */
	public void setTaxnr(int taxnr) {
		this.taxnr = taxnr;
	}

	/**
	 * Getter for property tax number
	 * @return tax nuymber for the entity
	 */
	public int getTaxnr() {
		return this.taxnr;
	}

	/**
	 * Setter for property signature line flag
	 * @param signLine signature line flag for the entity
	 */
	public void setSignLineFlag(short signLine) {
		this.signLine = signLine;
	}

	/**
	 * Getter for property signature line flag
	 * @return signature line flag for the entity
	 */
	public short getSignLineFlag() {
		return this.signLine;
	}

	/**
	 * Getter of the entity object's primary key
	 * @return the ID of the entity object
	 */
	@Override
	public IEntityPK getPK() {
	return ID;
	}

	/**
	 * Method to validate the primary key of the entity object
	 * @return true if the primary key of the entity object is valid
	 */
	@Override
	public boolean isPKValid() {
		return this.ID == null ? false : this.ID.isValid();
	}

	/**
	 * Method to clone this entity's attribute to another
	 * @param obj object to copy to
	 */
	@Override
	public void setAttributes(IEntityObject obj) {
	FuelTaxEx fteObj = (FuelTaxEx) obj;
	fteObj.ID = this.ID;
	fteObj.name = this.name;
	fteObj.adjAmt = this.adjAmt;
	fteObj.adjType = this.adjType;
	fteObj.taxnr = this.taxnr;
	fteObj.signLine = this.signLine;
	}

	/**
	 * Set the primary key of the entity object
	 * @param pk primary key for the entity object
	 */
	@Override
	public void setPK(IEntityPK pk) {
	this.ID = (FuelTaxExPK) pk;
	}

	/**
	 * Method to validate an entity object's attributes.
	 * @throws Exception if validation fails
	 */
	@Override
	public void validate() throws Exception {
	if (!isPKValid()) {
			throw new Exception("Invalid FuelTaxEx: " + this.ID);
		}
		if (   this.name == null
			|| this.name.trim().equals("")
			|| this.name.trim().equals("*")) {
			throw new Exception("Invalid name for FuelTaxEx: " + ID);
		}
	}

	/**
	 * Implementation method for visitable in visitor pattern
	 * @param v visitor
	 * @throws Exception on exception in visitor's visit method
	 */
	@Override
	public void accept(SalesEntityVisitor v) throws Exception {
		v.visit(this);
	}

	@Override
	public String toString() {
		return "FuelTaxEx [ID=" + ID + ", name=" + name + ", adjAmt=" + adjAmt
				+ ", adjType=" + adjType + ", taxnr=" + taxnr + ", signLine="
				+ signLine + "]";
	}
}
