/*
 * FuelTaxRcpt.java
 *
 * Created on February 17, 2005, 10:31 AM
 */

package com.verifone.isd.vsms2.sales.ent.fueltax;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 *
 * @author  tom_s5
 */
public class FuelTaxRcpt implements IEntityObject, ISalesEntityVisitable {
	private FuelTaxRcptPK ID;
	private static final int MAXLINES = 4;
	private String lines[];

	/**
	 * No-args constructor
	 */
	public FuelTaxRcpt() {
	}

	/**
	 * Constructor
	 * @param pk TaxPK for the object
	 */
	public FuelTaxRcpt(FuelTaxRcptPK pk) {
		this.ID = pk;
		lines = new String[MAXLINES];
	}

	/**
	 * Setter for property line
	 * @param linenum Number of line to update
	 * @param linetext Line text of the entity
	 */
	public void setLine(int linenum, String linetext) {
		if (lines == null)
			lines = new String[MAXLINES];
		this.lines[linenum] = linetext;
	}

	/**
	 * Getter for property line
	 * @param linenum Number of line to retrieve text from
	 * @return line data of the entity
	 */
	public String getLine(int linenum) {
		return this.lines[linenum];
	}

	/**
	 * Getter of the entity object's primary key
	 * @return the ID of the entity object
	 */
	public IEntityPK getPK() {
		return ID;
	}

	/**
	 * Method to validate the primary key of the entity object
	 * @return true if the primary key of the entity object is valid
	 */
	public boolean isPKValid() {
		return this.ID == null ? false : this.ID.isValid();
	}

	/** Method to clone this entity's attribute to another
	 * @param obj object to copy to
	 */
	public void setAttributes(IEntityObject obj) {
		FuelTaxRcpt ftrObj = (FuelTaxRcpt) obj;
		ftrObj.ID = this.ID;
		for (int i = 0; i < 4; i++)
			ftrObj.lines[i] = this.lines[i];
	}

	/** Set the primary key of the entity object
	 * @param pk primary key for the entity object
	 */
	public void setPK(IEntityPK pk) {
		this.ID = (FuelTaxRcptPK) pk;
	}

	/**
	 * Method to validate an entity object's attributes.
	 * @throws Exception if validation fails
	 */
	public void validate() throws Exception {
	if (!isPKValid())
		throw new Exception("Invalid FuelTaxRcpt: " + this.ID);
	}

	/** Implementation method for visitable in visitor pattern
	 * @param v visitor
	 * @throws Exception on exception in visitor's visit method
	 */
	public void accept(SalesEntityVisitor v) throws Exception {
		v.visit(this);
	}
}
