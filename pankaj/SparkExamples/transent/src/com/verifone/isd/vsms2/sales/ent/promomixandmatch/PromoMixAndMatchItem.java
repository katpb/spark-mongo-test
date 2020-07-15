/*
 * promoMixAndMatchItem.java
 *
 * Created on June 29, 2005, 9:51 AM
 */

package com.verifone.isd.vsms2.sales.ent.promomixandmatch;

import java.io.Serializable;
import com.verifone.isd.vsms2.sys.util.Quantity;

/** Entity to represent the items assigned to a Verifone NAXML based mix and
 * match.
 * @author tom_s5
 */
public class PromoMixAndMatchItem implements Serializable {

	private int mixAndMatchSubIndex;
	private int mixAndMatchUnits;
	private DiscountType discountType;
	private Quantity mixAndMatchPriceAmountPercent;

	/**
	 * This is the no-arguments constructor.
	 */
	public PromoMixAndMatchItem() {
	}

	/**
	 * This is a constructor.
	 * @param mixAndMatchSubIndex The mix and match sub-index.
	 * @param mixAndMatchUnits The mix and match units value.
	 * @param discountType The price, amount, or percent
	 * type indicator ('P'=price, 'A'=amount, 'E'=percent).
	 * @param mixAndMatchPriceAmountPercent The price, amount, or percent value.
	 */
	public PromoMixAndMatchItem(int mixAndMatchSubIndex, int mixAndMatchUnits,
			DiscountType discountType,
			Quantity mixAndMatchPriceAmountPercent) {
		this.mixAndMatchSubIndex = mixAndMatchSubIndex;
		this.mixAndMatchUnits = mixAndMatchUnits;
		this.discountType = discountType;
		this.mixAndMatchPriceAmountPercent = mixAndMatchPriceAmountPercent;
	}

	/** This method gets the sub-index of the mix and match.
	 * @return The sub-index of the mix and match.
	 */
	public int getMixAndMatchSubIndex() {
		return this.mixAndMatchSubIndex;
	}

	/** This method sets the sub-index of the mix and match.
	 * @param mixAndMatchSubIndex The sub-index of the mix and match.
	 */
	public void setMixAndMatchSubIndex(int mixAndMatchSubIndex) {
		this.mixAndMatchSubIndex = mixAndMatchSubIndex;
	}

	/** This method gets the units of the mix and match item.
	 * @return The units of the mix and match item.
	 */
	public int getMixAndMatchUnits() {
		return this.mixAndMatchUnits;
	}

	/**
	 * This method sets the units of the mix and match item.
	 * @param mixAndMatchUnits The units of the mix and match item.
	 */
	public void setMixAndMatchUnits(int mixAndMatchUnits) {
		this.mixAndMatchUnits = mixAndMatchUnits;
	}

	/**
	 * This method gets the mix and match price, amount, percent type.
	 * @return The mix and match price, amount, percent type.
	 * 'P'=price, 'A'=amount, 'E'=percent.
	 */
	public DiscountType getDiscountType() {
		return this.discountType;
	}

	/**
	 * This method sets the mix and match price, amount, percent type.
	 * @param discountType The mix and match price, amount,
	 * or percent type ('P'=price, 'A'=amount, 'E'=percent).
	 */
	public void setDiscountType(
			DiscountType discountType) {
		this.discountType =
				discountType;
	}
	
	/** This method gets the price, amount, or percent of the mix and match
	 * item.
	 * @return The unit price, amount, or percent of the mix and match item.
	 */
	public Quantity getMixAndMatchPriceAmountPercent() {
		return this.mixAndMatchPriceAmountPercent;
	}

	/**
	 * This method sets the price, amount, or percent of the mix and match item.
	 * @param mixAndMatchPriceAmountPercent The mix and match price, amount, or
	 * percent value.
	 */
	public void setMixAndMatchPriceAmountPercent(
	Quantity mixAndMatchPriceAmountPercent) {
		this.mixAndMatchPriceAmountPercent = mixAndMatchPriceAmountPercent;
	}

	/** This method validates the primary key of the entity object.
	 * @throws Exception On invalid data.
	 */
	public void validate() throws Exception {
		if (this.mixAndMatchSubIndex <= 0)
			throw new Exception("Invalid mix and match sub-index: " +
					this.mixAndMatchSubIndex);
	}

	/** This method returns the String representation of the entity.
	 * @return String representation of the entity.
	 */
	public String toString() {
		return "mixAndMatchSubIndex:" + this.mixAndMatchSubIndex +
		"; mixAndMatchUnits" + this.mixAndMatchUnits +
		"; discountType" +
		this.discountType +
		"; mixAndMatchPriceAmountPercent" + this.mixAndMatchPriceAmountPercent;
	}
}
