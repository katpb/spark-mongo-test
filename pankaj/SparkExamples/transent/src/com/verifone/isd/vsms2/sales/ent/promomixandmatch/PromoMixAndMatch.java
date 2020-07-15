/*
 * PromoMixAndMatch.java
 *
 * Created on June 29, 2005, 9:51 AM
 */

package com.verifone.isd.vsms2.sales.ent.promomixandmatch;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sales.ent.promoweekschedule.PromoWeekSchedule;
import com.verifone.isd.vsms2.sales.ent.promoweekschedule.IEntityObjectWithWeekSchedule;
import com.verifone.isd.vsms2.sales.ent.tax.TaxPK;
import com.verifone.isd.vsms2.sales.ent.taxablerebate.TaxableRebate;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/** This class is the entity for Verifone NAXML based mix and match.
 * @author tom_s5
 */
public class PromoMixAndMatch extends TaxableRebate implements IEntityObjectWithWeekSchedule, ISalesEntityVisitable {

	private static final long serialVersionUID = -5460226240760234099L;
	public static final int NUM_DECIMALS = 3;
	private PromoMixAndMatchPK pk; /* AKA Promotion ID */
	private String mixMatchDescription;
	private String itemListID;
	private String startDate;
	private String stopDate;
	private byte flags;
	private TreeSet items;
	private PromoWeekSchedule[] promoWeekItems;
	private String priority;
	
	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/**
	 * This is the no-args constructor.
	 */
	public PromoMixAndMatch() {
		this(null);
	}

	/**
	 * This is the constructor.
	 * @param pk Reference to the PromoMixAndMatchPK for the object.
	 */
	public PromoMixAndMatch(PromoMixAndMatchPK pk) {
		super();
		this.pk = pk;
		this.items = new TreeSet(new ItemComparator());
		this.promoWeekItems = new PromoWeekSchedule[7];
	}

	/** This method sets for the mix and match description.
	 * @param mixMatchDescription The description of the mix and match.
	 */
	public void setMixAndMatchDescription(String mixMatchDescription) {
		this.mixMatchDescription = mixMatchDescription;
	}

	/** This method gets the mix and match description String.
	 * @return The mix and match description String.
	 */
	public String getMixAndMatchDescription() {
		return this.mixMatchDescription;
	}

	/** This method gets the item list ID for the mix and match.
	 * @return The item list ID for the mix and match.
	 */
	public String getItemListID() {
		return this.itemListID;
	}

	/** This method sets the item list ID for the mix and match.
	 * @param itemListID The item list ID for the mix and match.
	 */
	public void setItemListID(String itemListID) {
		this.itemListID = itemListID;
	}

	/**
	 * This method sets the start date of the mix and match.
	 * @param startDate The start date for the mix and match.
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/** This method gets the mix and match start date String.
	 * @return The mix and match start date String.
	 */
	public String getStartDate() {
		return this.startDate;
	}

	/**
	 * This method sets the stop date for the mix and match.
	 * @param stopDate The stop date for the mix and match.
	 */
	public void setStopDate(String stopDate) {
		this.stopDate = stopDate;
	}

	/** This method gets the mix and match stop date String.
	 * @return The mix and match stop date String.
	 */
	public String getStopDate() {
		return this.stopDate;
	}

	/**
	 * This method sets the flags for the mix and match.
	 * @param flags The flags for the mix and match.
	 */
	public void setFlags(byte flags) {
		this.flags = flags;
	}

	/** This method gets the mix and match flags byte.
	 * @return The mix and match flags byte.
	 */
	public byte getFlags() {
		return this.flags;
	}

	/** This method gets the entity object's primary key.
	 * @return The primary key of the entity object.
	 */
	public IEntityPK getPK() {
		return this.pk;
	}

	/** This method validates the primary key of the entity object.
	 * @return Returns true if the primary key of the entity object is valid.
	 */
	public boolean isPKValid() {
		return (this.pk == null) ? false : this.pk.isValid();
	}

	/** This method clones another entity with this entity's attributes.
	 * @param obj The entity to copy to.
	 */
	public void setAttributes(IEntityObject obj) {
		super.setAttribute((TaxableRebate)obj);
		PromoMixAndMatch pObj = (PromoMixAndMatch) obj;
		pObj.pk = this.pk;
		pObj.mixMatchDescription = this.mixMatchDescription;
		pObj.itemListID = this.itemListID;
		pObj.startDate = this.startDate;
		pObj.stopDate = this.stopDate;
		pObj.flags = this.flags;
		pObj.setItems(this.getItems());
		pObj.setWeeklyItems(this.getWeeklyItems());
	}

	/** This method sets the primary key of the entity object
	 * @param pk The primary key for the entity object.
	 */
	public void setPK(IEntityPK pk) {
		this.pk = (PromoMixAndMatchPK) pk;
	}

	/** This method validates an entity object's attributes.
	 * @throws Exception If validation fails.
	 */
	public void validate() throws Exception {
		if (!isPKValid()) {
			throw new Exception("Invalid PromoMixAndMatch: " + this.pk);
		}
		this.validateItems();
		super.validateTaxableRebatesTaxes();
	}

	/** This method validates the mix and match items associated with this mix
	 * and match
	 */
	private void validateItems() {
		PromoMixAndMatchItem[] elems = this.getItems();
		int len = elems.length;
		for (int i = 0; i < len; i++) {
			PromoMixAndMatchItem item = elems[i];
			try {
				item.validate();
			} catch (Exception e) {
				LoggerFactory.getLogger("PromoMixAndMatch").error("MixAndMatch: " + this.pk +
						" validation error - " + e.getMessage());
			}
		}
	}

	/** Implementation method for visitable in visitor pattern
	 * @param v visitor
	 * @throws Exception on exception in visitor's visit method
	 */
	public void accept(SalesEntityVisitor v) throws Exception {
		v.visit(this);
	}

	/**
	 * This method sets the list of items for the mix and match item list.  It
	 * clears the existing items and adds the new items.
	 * @param items list of items for the promotion
	 */
	public void setItems(PromoMixAndMatchItem[] items) {
		this.items.clear();
		if (items != null) {
			int numEl = items.length;
			for (int i = 0; i < numEl; i++) {
				this.items.add(items[i]);
			}
		}
	}

	/**
	 * This method gets a specific mix and match item list item.
	 * @param mixAndMatchItemListSubIndex The mix and match item list sub-index.
	 * @return The Requested mix and match item list item.
	 */
	public PromoMixAndMatchItem getItem(int mixAndMatchItemListSubIndex) {
		PromoMixAndMatchItem[] elems = this.getItems();
		int len = elems.length;
		PromoMixAndMatchItem reqdElem = null;
		for (int i = 0; i < len; i++) {
			if (elems[i].getMixAndMatchSubIndex() == mixAndMatchItemListSubIndex) {
				reqdElem = elems[i];
				break;
			}
		}
		return reqdElem;
	}

	/** This method returns the list of mix and match item list items.
	 * @return The list of mix and match items.
	 */
	public PromoMixAndMatchItem[] getItems() {
		return (PromoMixAndMatchItem[]) this.items.toArray(
				new PromoMixAndMatchItem[0]);
	}

	/** This method adds an item to the mix and match item list.
	 * @param item The item to be added to the mix and match item list.
	 */
	public void addItem(PromoMixAndMatchItem item) {
		this.removeItem(item.getMixAndMatchSubIndex());
		items.add(item);
	}

	/** This method removes a mix and match item from the item list.
	 * @param mixAndMatchItemListSubIndex The sub-index of the item to be
	 * removed from the mix and match item list.
	 */
	public void removeItem(int mixAndMatchItemListSubIndex) {
		PromoMixAndMatchItem item = this.getItem(mixAndMatchItemListSubIndex);
		if (item != null) {
			items.remove(item);
		}
	}

   
	/** This class compares items
	 */
	private class ItemComparator implements Comparator, Serializable {
		/** This method does the comparing
		 */
		public int compare(Object o1, Object o2) {
			/*
			 * Arrays.sort calls compare when o1 and o2 are equal
			 */
			if (o1 == o2)
				return 0;
			PromoMixAndMatchItem c1 = (PromoMixAndMatchItem) o1;
			PromoMixAndMatchItem c2 = (PromoMixAndMatchItem) o2;
			return (c1.getMixAndMatchSubIndex() -
					c2.getMixAndMatchSubIndex());
		}
	}

	/** This method returns the string representation of the entity.
	 * @return The String representation of the entity.
	 */
	public String toString() {
		return " promotionID:" + pk.getValue();
	}
	
	/**
	 * This method sets the list of items for the combo item list.  It
	 * clears the existing items and adds the new items.
	 * @param items list of items for the promotion
	 */
	public void setWeeklyItems(PromoWeekSchedule[] promoWeekItems) {
		if (promoWeekItems != null && promoWeekItems.length == 7) {
			for (int i = 0; i < 7; i++) {
				this.promoWeekItems[i] = promoWeekItems[i];
			}
		}
	}

	/**
	 * This method ges a specific combo item list item
	 * @param comboItemListIndex The combo item list index
	 * @param comboItemListSubIndex The combo item list sub-index
	 * @return requested combo item list item
	 */
	public PromoWeekSchedule getWeeklyItem(int dayOfWeek) {
		if(this.promoWeekItems!=null)
			return this.promoWeekItems[dayOfWeek-1];
		return new PromoWeekSchedule();
	}

	/** This method returns the list of combo item list items.
	 * @return The list of combo items.
	 */
	public PromoWeekSchedule[] getWeeklyItems() {
		return this.promoWeekItems;
	}

	/** This method adds an item to the combo item list.
	 * @param item The item to be added to the combo item list.
	 */
	public void addItem(int dayOfWeek, PromoWeekSchedule item) {
		if(dayOfWeek > 0 && dayOfWeek <= 7 && item!=null && item.isValid())
			this.promoWeekItems[dayOfWeek-1] = item;
		else
			LoggerFactory.getLogger("PromoMixAndMatch").error("Error while adding PromoWeekSchedule record : "+item);
	}
	
	public boolean equals(Object obj) {
		if (obj != null) {
			return this.equals((PromoMixAndMatch)obj);
		}
		return false;
	}

	/** This method compares two PromoMixAndMatchPK objects for equality.
	 * @param obj PromoMixAndMatch object to be compared against
	 * @return true if both primary keys represent the same promotion mix and match
	 */
	public boolean equals(PromoMixAndMatch obj) {
		if (obj instanceof PromoMixAndMatch) {
			PromoMixAndMatch lObj = (PromoMixAndMatch) obj;
			return (((PromoMixAndMatchPK)this.getPK()).equals(lObj.getPK()));
		}
		return false;
	}
}
