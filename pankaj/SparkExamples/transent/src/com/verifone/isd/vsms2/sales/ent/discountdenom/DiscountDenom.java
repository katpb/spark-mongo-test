/*
 * DiscountDenom.java
 *
 * Created on November 2, 2015, 3:33 PM
 */

package com.verifone.isd.vsms2.sales.ent.discountdenom;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The entity object for discount denomination configuration processing.
 * @author T_JoswillP1 <t_joswillp1@verifone.com>
 * @author knicolas_b1
 */
public class DiscountDenom implements IEntityObject, ISalesEntityVisitable {

	private static final long serialVersionUID = 554285511433707278L;
	/** Maximum number of discounts */
	public static final int MAX_ID = 16;
	
	private DiscountDenomPK pk;
	private int id;
	private String description;
	private String dType;
	private long amount;

	public DiscountDenom() {
	}

	public DiscountDenom(int id, String description, String dType, long amount) {
		this.pk = new DiscountDenomPK(id);
		this.id = id;
		this.description = description;
		this.dType = dType;
		this.amount = amount;
	}

	public boolean isPKValid() {
		if (this.pk == null) {
			this.pk = new DiscountDenomPK();
		}
		return this.pk.isValid();
	}

	public void setAttributes(IEntityObject obj) {
		DiscountDenom lObj = (DiscountDenom) obj;
		lObj.pk = this.pk;
		lObj.id = this.id;
		lObj.description = this.description;
		lObj.dType = this.dType;
		lObj.amount = this.amount;
	}

	/**
	 * Validates an entity object's attributes.
	 * @throws Exception If validation fails.
	 */
	public void validate() throws Exception {
		if (!isPKValid()) {
			throw new Exception("Invalid DiscountDenom: " + this.pk);
		}
	}

	public void accept(SalesEntityVisitor v) throws Exception {
		v.visit(this);
	}

	/**
	 * Return a reference to the IEntityPk.
	 * @return A reference to the IEntityPK.
	 */
	public IEntityPK getPK() {
		return this.pk;
	}

	/**
	 * Set the primary key.
	 * @param pk The primary key value.
	 */
	public void setPK(IEntityPK pk) {
		this.pk = (DiscountDenomPK) pk;
	}

	public void setID(int id) {
		this.id = id;
	}
	public int getID() {
		return this.id;
	}

	/**
	 * Sets the discount description for this instance.
	 * @param discount description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return this.description;
	}

	/**
	 * Sets the discount type for this instance.
	 * @param discount type (% - 'P' or Amt - 'A')
	 */
	 public void setDiscountType(String dType) {
		this.dType = dType;
	 }
	 public String getDiscountType() {
		return this.dType;
	 }

	/**
	 * Sets the discount amount for this instance.
	 * @param discount amount
	 */
	 public void setAmount(long amount) {
		this.amount = amount;
	 }
	 public long getAmount() {
		return this.amount;
	 }
}
