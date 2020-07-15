/*
 * promoItemListPLUItem.java
 *
 * Created on June 6, 2005, 4:28 PM
 */

package com.verifone.isd.vsms2.sales.ent.promoitemlistplu;

import com.verifone.isd.vsms2.sales.ent.plu.PluPK;
import java.io.Serializable;

/** Entity to represent the items assigned to a promotion item list for PLUs.
 * @author tom_s5
 */
public class PromoItemListPLUItem implements Serializable {

	private int pluItemListSubIndex;
	private PluPK plu;

	/** Creates a new instance of promotion item list item for PLUs
	 * @param pluItemListSubIndex The PLU item list sub-index for this item.
	 * @param plu plu associated with the promotion item list
	 */
	public PromoItemListPLUItem(int pluItemListSubIndex, PluPK plu) {
            this.pluItemListSubIndex = pluItemListSubIndex;
            this.plu = plu;
	}

	/** Creates a new instance of promotion item list sub-item for PLUs
	 * @param pluItemListSubIndex The PLU item list index for this item.
	 */
	public PromoItemListPLUItem(int pluItemListSubIndex) {
		this(pluItemListSubIndex, null);
	}

	/**
	 * Creates a new instance of promotion item list item for PLUs
	 */
	public PromoItemListPLUItem() {
	}


	/** This method gets the PLU item list sub-index.
	 * @return PLU item list sub-index
	 */
	public int getPLUItemListSubIndex() {
		return this.pluItemListSubIndex;
	}

	/** This method sets the PLU item list sub-index.
	 * @param pluItemListSubIndex The PLU item list sub-index for this item.
	 */
	public void setPLUItemListSubIndex(int pluItemListSubIndex) {
		this.pluItemListSubIndex = pluItemListSubIndex;
	}

	/** This method gets the PLU associated with the promotion.
	 * @return plu id for the promotion item
	 */
	public PluPK getPlu() {
		return plu;
	}

	/** This method sets the PLU associated with the promotion.
	 * @param plu plu id for the promotion item
	 */
	public void setPlu(PluPK plu) {
		this.plu = plu;
	}

	/** This method validates the primary key of the entity object.
	 * @throws Exception on invalid data
	 */
	public void validate() throws Exception {
		if (this.pluItemListSubIndex <= 0)
			throw new Exception("Invalid PLUItemListSubIndex: " +
					this.pluItemListSubIndex);
		if ((this.plu != null) && (!this.plu.isValid()))
			throw new Exception("Invalid plu: " +
					this.plu);
	}

	/** This method returns the String representation of the entity.
	 * @return String representation of the entity.
	 */
	public String toString() {
		return "pluItemListSubIndex:" + pluItemListSubIndex + ";  plu:" + plu;
	}
}
