/*
 * promoComboItem.java
 *
 * Created on June 23, 2005, 9:51 AM
 */

package com.verifone.isd.vsms2.sales.ent.promocombo;

import java.io.Serializable;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.Quantity;

/** Entity to represent the items assigned to a Verifone NAXML based combo.
 * @author tom_s5
 */
public class PromoComboItem implements Serializable {

	private static final Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sales.ent.promocombo.PromoComboItem.class);
	private static final long serialVersionUID = 249158405170766197L;

	private int comboSubIndex;
	private String itemListID;
	private byte itemListType;
	private int comboItemQuantity;
	private MoneyAmount comboItemUnitPrice;
	private DiscountAllocationType comboItemDiscountAllocationType;
	private Quantity comboItemDiscountAllocation;
	private byte usePluPrice;

	/**
	 * This is the no-arguments constructor.
	 */
	public PromoComboItem() {
	}

	/**
	 * This is the multi-arguments constructor.
	 * @param comboSubIndex The combo sub-index number.
	 * @param itemListID The item list to be used with the combo.
	 * @param itemListType The item list type for this combo.
	 * 0 = PLU Item list
	 * 1 = Department item list.
	 * @param comboItemQuantity The item quantity required to qualify for a combo.
	 * @param comboItemUnitPrice The item unit price.
	 * @param comboItemDiscountAllocationType The item discount allocation type.
	 * 'A' = amount (not currently supported)
	 * 'P' = percentage
	 * @param comboItemDiscountAllocation The item discount allocation amount.
	 * @param usePluPrice The use PLU price flag.
	 * 1 = use PLU price.
	 */
	public PromoComboItem(int comboSubIndex,
			String itemListID, byte itemListType, int comboItemQuantity,
			MoneyAmount comboItemUnitPrice, DiscountAllocationType comboItemDiscountAllocationType,
			Quantity comboItemDiscountAllocation, byte usePluPrice) {
		this.comboSubIndex = comboSubIndex;
		this.itemListID = itemListID;
		this.itemListType = itemListType;
		this.comboItemQuantity = comboItemQuantity;
		this.comboItemUnitPrice = comboItemUnitPrice;
		this.comboItemDiscountAllocationType = comboItemDiscountAllocationType;
		this.comboItemDiscountAllocation = comboItemDiscountAllocation;
		this.usePluPrice = usePluPrice;
	}


	/** This method gets the sub-index of the combo.
	 * @return The sub-index of the combo.
	 */
	public int getComboSubIndex() {
		return this.comboSubIndex;
	}

	/** This method sets the sub-index of the combo.
	 * @param comboSubIndex The sub-index of the combo.
	 */
	public void setComboSubIndex(int comboSubIndex) {
		this.comboSubIndex = comboSubIndex;
	}

	/** This method gets the item list ID for the combo.
	 * @return The item list ID for the combo.
	 */
	public String getItemListID() {
		return this.itemListID;
	}

	/** This method sets the item list ID for the combo.
	 * @param itemListID The item list ID for the combo.
	 */
	public void setItemListID(String itemListID) {
		this.itemListID = itemListID;
	}

	/** This method gets the item list type for the combo.  The valid values are
	 * 0 for PLU item list and 1 for department item list.
	 * @return The item list index for the combo.
	 */
	public byte getItemListType() {
		return this.itemListType;
	}

	/** This method sets the item list type for the combo.  The valid values are
	 * 0 for PLU item list and 1 for department item list.
	 * @param itemListType The item list index for the combo.
	 */
	public void setItemListType(byte itemListType) {
		this.itemListType = itemListType;
	}

	/** This method gets the quantity of the combo item.
	 * @return The quantity of the combo item.
	 */
	public int getComboItemQuantity() {
		return this.comboItemQuantity;
	}

	/** This method sets the quantity of the combo item.
	 * @param comboItemQuantity The quantity of the combo item.
	 */
	public void setComboItemQuantity(int comboItemQuantity) {
		this.comboItemQuantity = comboItemQuantity;
	}

	/** This method gets the unit price of the combo item.
	 * @return The unit price of the combo item.
	 */
	public MoneyAmount getComboItemUnitPrice() {
		return this.comboItemUnitPrice;
	}

	/** This method sets the unit price of the combo item.
	 * @param comboItemUnitPrice The unit price of the combo item.
	 */
	public void setComboItemUnitPrice(MoneyAmount comboItemUnitPrice) {
		this.comboItemUnitPrice = comboItemUnitPrice;
	}

	/**
	 * This method gets the combo item discount allocation type.
	 * @return The combo item discount allocation type.
	 * 'A' = amount (not currently supported).
	 * 'P' = percentage.
	 */
	public DiscountAllocationType getComboItemDiscountAllocationType() {
		return this.comboItemDiscountAllocationType;
	}

	/** This method sets the combo item discount allocation type.
	 * @param comboItemDiscountAllocationType The combo item discount allocation
	 * type.
	 */
	public void setComboItemDiscountAllocationType(
			DiscountAllocationType comboItemDiscountAllocationType) {
		this.comboItemDiscountAllocationType = comboItemDiscountAllocationType;
	}

	/** This method gets the combo item discount allocation amount.
	 * @return The combo item discount allocation amount.
	 */
	public Quantity getComboItemDiscountAllocation() {
		return this.comboItemDiscountAllocation;
	}

	/** This method sets the combo item discount allocation amount.
	 * @param comboItemDiscountAllocation The combo item discount allocation
	 * amount.
	 */
	public void setComboItemDiscountAllocation(
	Quantity comboItemDiscountAllocation) {
		this.comboItemDiscountAllocation = comboItemDiscountAllocation;
	}

	/** This method gets the use PLU price setting. 
	 * @return The use PLU price setting.
	 */
	public byte getUsePluPrice() {
		return this.usePluPrice;
	}

	/** This method sets the use PLU price setting.
	 * @param usePluPrice The use PLU price setting.
	 */
	public void setUsePluPrice(byte usePluPrice) {
		this.usePluPrice = usePluPrice;
	}

	/** This method validates the primary key of the entity object.
	 * @throws Exception On invalid data.
	 */
	public void validate() throws Exception {
		if (this.comboSubIndex <= 0) {
            throw new Exception("Invalid combo sub-index: " + this.comboSubIndex);
        }
		if (this.itemListID == null) {
            throw new Exception("Invalid item list ID for combo: " + this.itemListID);
        }
	}

	/** This method returns the String representation of the entity.
	 * @return String representation of the entity.
	 */
	public String toString() {
		return "comboSubIndex:" +
		this.comboSubIndex + "; comboItemQuantity:" + this.comboItemQuantity +
		"; comboItemUnitPrice:" + this.comboItemUnitPrice +
		"; comboItemDiscountAllocationType:" +
		this.comboItemDiscountAllocationType +
		"; comboItemDiscountAllocation:" + this.comboItemDiscountAllocation +
		"; usePluPrice:" + this.usePluPrice;
	}
}
