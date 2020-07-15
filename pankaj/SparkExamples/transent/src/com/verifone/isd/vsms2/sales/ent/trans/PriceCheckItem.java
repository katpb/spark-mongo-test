package com.verifone.isd.vsms2.sales.ent.trans;

import java.io.Serializable;
import com.verifone.isd.vsms2.sales.ent.plu.PluPK;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import com.verifone.isd.vsms2.sys.util.Quantity;

/**
 * Custom type for capturing journal log details from Price check utility
 * @author ManjunathaV1
 * 1:31:31 PM
 */
public class PriceCheckItem implements Serializable {

	private static final long	serialVersionUID	= -1265609944980556484L;
	private PluPK pluPK;
	private String description;
	private Quantity quantity;
	private MoneyAmount unitPrice;
	private MoneyAmount lineTotal;
	
	public PriceCheckItem(){}
	
	public PriceCheckItem(PluPK pluPK, String description, Quantity quantity, 
	                      MoneyAmount unitPrice, MoneyAmount lineTotal) {
		this.pluPK = pluPK;
		this.description = description;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.lineTotal = lineTotal;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if(obj instanceof PriceCheckItem){
			PriceCheckItem paramObj = (PriceCheckItem) obj;
			return this.getPluPK().getValue().equals(paramObj.getPluPK().getValue())
				&& this.getDescription().equals(paramObj.getDescription())
				&& this.getUnitPrice().equals(paramObj.getUnitPrice());
		} else {
			return false;
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return ( getPluPK().getValue() + getDescription() + getUnitPrice().toString()).hashCode();
	}

	/**
	 * @return the pluPK
	 */
	public PluPK getPluPK() {
		return pluPK;
	}

	/**
	 * @param pluPK the pluPK to set
	 */
	public void setPluPK(PluPK pluPK) {
		this.pluPK = pluPK;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the quantity
	 */
	public Quantity getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Quantity quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return The base price of the item
	 */
	public MoneyAmount getUnitPrice() {
		return unitPrice;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(MoneyAmount unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * @return the total txn amouont including tax.
	 */
	public MoneyAmount getLineTotal() {
		return lineTotal;
	}

	/**
	 * @param lineTotal the lineTotal to set
	 */
	public void setLineTotal(MoneyAmount lineTotal) {
		this.lineTotal = lineTotal;
	}
	
}