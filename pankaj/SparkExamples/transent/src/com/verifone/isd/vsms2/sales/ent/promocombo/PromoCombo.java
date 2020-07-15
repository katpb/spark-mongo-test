/*
 * PromoCombo.java
 *
 * Created on June 22, 2005, 2:59 PM
 */

package com.verifone.isd.vsms2.sales.ent.promocombo;

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

/** This class is the entity for Verifone NAXML based combos.
 * @author tom_s5
 */
public class PromoCombo extends TaxableRebate implements IEntityObjectWithWeekSchedule, ISalesEntityVisitable {

	private static final long serialVersionUID = -668817350055771263L;
	public static final int NUM_DECIMALS = 2;
    private transient Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sales.ent.promocombo.PromoCombo.class);
	private PromoComboPK pk; /* AKA Promotion ID */
	private String comboDescription;
	private MoneyAmount comboPrice;
	private String startDate;
	private String stopDate;
	private byte comboPricingScheme;
	private TreeSet items;
	private PromoWeekSchedule[] promoWeekItems;
	private String priority;
	/**
	 * This is the no-args constructor.
	 */
	public PromoCombo() {
		this(null);
	}

	/**
	 * This is the constructor.
	 * @param pk Reference to the PromoComboPK for the object.
	 */
	public PromoCombo(PromoComboPK pk) {
		super();
		this.pk = pk;
		this.items = new TreeSet(new ItemComparator());
		this.promoWeekItems = new PromoWeekSchedule[7];
	}


	/** This method sets for the combo description.
	 * @param comboDescription The description of the combo.
	 */
	public void setComboDescription(String comboDescription) {
		this.comboDescription = comboDescription;
	}

	/** This method gets the combo description String.
	 * @return The combo description String.
	 */
	public String getComboDescription() {
		return this.comboDescription;
	}

	/** This method sets for the combo price.
	 * @param comboPrice The price of the combo.
	 */
	public void setComboPrice(MoneyAmount comboPrice) {
		this.comboPrice = comboPrice;
	}

	/** This method gets the combo price.
	 * @return The price of the combo.
	 */
	public MoneyAmount getComboPrice() {
		return this.comboPrice;
	}

	/**
	 * This method sets the start date of the combo.
	 * @param startDate The start date for the combo.
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/** This method gets the combo start date String.
	 * @return The combo start date String.
	 */
	public String getStartDate() {
		return this.startDate;
	}

	/**
	 * This method sets the stop date for the combo.
	 * @param stopDate The stop date for the combo.
	 */
	public void setStopDate(String stopDate) {
		this.stopDate = stopDate;
	}

	/** This method gets the combo stop date String.
	 * @return The combo stop date String.
	 */
	public String getStopDate() {
		return this.stopDate;
	}

	/**
	 * This method sets for the combo pricing scheme.
	 * @param comboPricingScheme The pricing scheme of the combo.
	 * 0 = use combo item unit price.
	 * 1 = use combo price.
	 */
	public void setComboPricingScheme(byte comboPricingScheme) {
		this.comboPricingScheme = comboPricingScheme;
	}

	/**
	 * This method gets the combo pricing scheme.
	 * @return The pricing scheme of the combo.
	 * 0 = use combo item unit price.
	 * 1 = use combo price.
	 */
	public byte getComboPricingScheme() {
		return this.comboPricingScheme;
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
		PromoCombo pObj = (PromoCombo) obj;
		pObj.pk = this.pk;
		pObj.comboDescription = this.comboDescription;
		pObj.comboPrice = this.comboPrice;
		pObj.startDate = this.startDate;
		pObj.stopDate = this.stopDate;
		pObj.comboPricingScheme = this.comboPricingScheme;
		pObj.setItems(this.getItems());
		pObj.setWeeklyItems(this.getWeeklyItems());
		pObj.setPriority(this.getPriority());
	}

	/** This method sets the primary key of the entity object
	 * @param pk The primary key for the entity object.
	 */
	public void setPK(IEntityPK pk) {
		this.pk = (PromoComboPK) pk;
	}

	/** This method validates an entity object's attributes.
	 * @throws Exception If validation fails.
	 */
	public void validate() throws Exception {
		if (!isPKValid()) {
			throw new Exception("Invalid PromoCombo: " + this.pk);
		}
		super.validateTaxableRebatesTaxes();
		this.validateItems();
	}

	private void validateItems() {
		PromoComboItem[] elems = this.getItems();
		int len = elems.length;
		for (int i = 0; i < len; i++) {
			PromoComboItem item = elems[i];
			try {
				item.validate();
			} catch (Exception e) {
				logger.error("Combo: " + this.pk + " validation error - " +
						e.getMessage());
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
	 * This method sets the list of items for the combo item list.  It
	 * clears the existing items and adds the new items.
	 * @param items list of items for the promotion
	 */
	public void setItems(PromoComboItem[] items) {
		this.items.clear();
		if (items != null) {
			int numEl = items.length;
			for (int i = 0; i < numEl; i++) {
				this.items.add(items[i]);
			}
		}
	}

	/**
	 * This method gets a specific combo item list item
	 * @param comboItemListSubIndex The combo item list sub-index
	 * @return requested combo item list item
	 */
	public PromoComboItem getItem(int comboItemListSubIndex) {
		PromoComboItem[] elems = this.getItems();
		int len = elems.length;
		PromoComboItem reqdElem = null;
		for (int i = 0; i < len; i++) {
			if ( elems[i].getComboSubIndex() == comboItemListSubIndex) {
				reqdElem = elems[i];
				break;
			}
		}
		return reqdElem;
	}

	/** This method returns the list of combo item list items.
	 * @return The list of combo items.
	 */
	public PromoComboItem[] getItems() {
		return (PromoComboItem[]) this.items.toArray(
				new PromoComboItem[0]);
	}

	/** This method adds an item to the combo item list.
	 * @param item The item to be added to the combo item list.
	 */
	public void addItem(PromoComboItem item) {

		this.removeItem(item.getComboSubIndex());
		items.add(item);
	}

	/** Ths method removes a combo item from the item list.
	 * @param comboItemListSubIndex The sub-index of the item to be removed from
	 * the combo item list.
	 */
	public void removeItem(int comboItemListSubIndex) {
		PromoComboItem item = this.getItem(comboItemListSubIndex);
		if (item != null) {
			items.remove(item);
		}
	}

	private class ItemComparator implements Comparator, Serializable {
		public int compare(Object o1, Object o2) {
			/*
			 * Arrays.sort calls compare when o1 and o2 are equal
			 */
			if (o1 == o2)
				return 0;
			PromoComboItem c1 = (PromoComboItem) o1;
			PromoComboItem c2 = (PromoComboItem) o2;
			return (c1.getComboSubIndex() -
					c2.getComboSubIndex());
		}
	}

	/** This method returns the string representation of the entity.
	 * @return The String representation of the entity.
	 */
	public String toString() {
		return "promotionID:" + pk.getValue();
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
	 * @param int dayOfWeek
	 * @return PromoWeekSchedule
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

	/**
	 * @param int dayOfWeek
	 * @param PromoWeekSchedule item
	 */
	public void addItem(int dayOfWeek, PromoWeekSchedule item) {
		if(dayOfWeek > 0 && dayOfWeek <= 7 && item!=null && item.isValid())
			this.promoWeekItems[dayOfWeek-1] = item;
		else
			logger.error("Error while adding PromoWeekSchedule record : "+item);
	}

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
	
	public boolean equals(Object obj) {
		if (obj != null) {
			return this.equals((PromoCombo)obj);
		}
		return false;
	}

	/** This method compares two PromoComboPK objects for equality.
	 * @param obj PromoCombo object to be compared against
	 * @return true if both primary keys represent the same promotion combo
	 */
	public boolean equals(PromoCombo obj) {
		if (obj instanceof PromoCombo) {
			PromoCombo lObj = (PromoCombo) obj;
			return (((PromoComboPK)this.getPK()).equals(lObj.getPK()));
		}
		return false;
	}
}
