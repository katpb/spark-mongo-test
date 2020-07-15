/*
 * promoItemListPLU.java
 *
 * Created on June 6, 2005, 4:27 PM
 */

package com.verifone.isd.vsms2.sales.ent.promoitemlistplu;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.log4j.*;
import java.io.Serializable;
import java.util.Comparator;
import java.util.TreeSet;

/** This class is the entity for promotions item list for PLUs.
 * @author tom_s5
 */
public class PromoItemListPLU implements IEntityObject, ISalesEntityVisitable {

	private static final long serialVersionUID = -2082229972815924996L;
	private transient Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sales.ent.promoitemlistplu.PromoItemListPLU.class);
	private PromoItemListPLUPK pk; /* AKA List ID  or pluItemListID */
	private String itemListDescription;
	private TreeSet items;
	private String pluItemListID;

	/** No-args constructor
	 */
	public PromoItemListPLU() {
		this(null);
	}

	/** Constructor
	 * @param pk Reference to the PromoItemListPLUPK for the object.
	 */
	public PromoItemListPLU(PromoItemListPLUPK pk) {
		this.pk = pk;
		this.items = new TreeSet(new ItemComparator());
	}


	/** This method sets the item list description.
	 * @param itemListDescription The description of the item list item.
	 */
	public void setItemListDescription(String itemListDescription) {
		this.itemListDescription = itemListDescription;
	}

	/** This method gets the item list description.
	 * @return The item list description.
	 */
	public String getItemListDescription() {
		return this.itemListDescription;
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

	/** This method clones another entity with this enity's attributes.
	 * @param obj The entity to copy to.
	 */
	public void setAttributes(IEntityObject obj) {
		PromoItemListPLU pObj = (PromoItemListPLU) obj;
		pObj.pk = this.pk;
		pObj.setItems(this.getItems());
		pObj.setPluItemListID(this.getPluItemListID());
	}

	/** This method sets the primary key of the entity object
	 * @param pk The primary key for the entity object.
	 */
	public void setPK(IEntityPK pk) {
		this.pk = (PromoItemListPLUPK) pk;
	}

	/** This method validates an entity object's attributes.
	 * @throws Exception If validation fails
	 */
	public void validate() throws Exception {
		if (!isPKValid()) {
			throw new Exception("Invalid PromoItemListPLU: " + this.pk);
		}
		this.validateItems();
	}

	private void validateItems() {
		PromoItemListPLUItem[] elems = this.getItems();
		int len = elems.length;
		for (int i = 0; i < len; i++) {
			PromoItemListPLUItem item = elems[i];
			try {
				item.validate();
			} catch (Exception e) {
				logger.error("Menu: " + this.pk + " validation error - " +
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
	 * This method sets the list of items for the promotions item list.  It
	 * clears the existing items and adds the new items.
	 * @param items list of items for the promotion
	 */
	public void setItems(PromoItemListPLUItem[] items) {
		this.items.clear();
		if (items != null) {
			int numEl = items.length;
			for (int i = 0; i < numEl; i++) {
				this.items.add(items[i]);
			}
		}
	}

	/**
	 * This method is the getter for a specific item list item
	 * @param pluItemListSubIndex item sub-index
	 * @return requested item list item
	 */
	public PromoItemListPLUItem getItem(int pluItemListSubIndex) {
		PromoItemListPLUItem[] elems = this.getItems();
		int len = elems.length;
		PromoItemListPLUItem reqdElem = null;
		for (int i = 0; i < len; i++) {
			if (   elems[i].getPLUItemListSubIndex() == pluItemListSubIndex) {
				reqdElem = elems[i];
				break;
			}
		}
		return reqdElem;
	}

	/** This method returns the list of item list items for the promotion.
	 * @return List of items for the promotion.
	 */
	public PromoItemListPLUItem[] getItems() {
		return (PromoItemListPLUItem[]) this.items.toArray(
				new PromoItemListPLUItem[0]);
	}

	/** This method adds an item to the item list.
	 * @param item Item to be added to the item list.
	 */
	public void addItem(PromoItemListPLUItem item) {
		this.removeItem(item.getPLUItemListSubIndex());
		items.add(item);
	}

	/** This method removes an item from the item list.
	 * @param pluItemListSubIndex sub-index of the item to be removed from the
	 * item list.
	 */
	public void removeItem(int pluItemListSubIndex) {
		PromoItemListPLUItem item = this.getItem(pluItemListSubIndex);
		if (item != null) {
			items.remove(item);
		}
	}




	public String getPluItemListID() {
		return pluItemListID;
	}

	public void setPluItemListID(String pluItemListID) {
		this.pluItemListID = pluItemListID;
	}




	private class ItemComparator implements Comparator, Serializable {
		public int compare(Object o1, Object o2) {
			/*
			 * Arrays.sort calls compare when o1 and o2 are equal
			 */
			if (o1 == o2)
				return 0;
			PromoItemListPLUItem c1 = (PromoItemListPLUItem) o1;
			PromoItemListPLUItem c2 = (PromoItemListPLUItem) o2;
			return (c1.getPLUItemListSubIndex() - c2.getPLUItemListSubIndex());
		}
	}

	/** This method returns the string representation of the entity
	 * @return String representation of the entity
	 */
	public String toString() {
		return "ID:" + pk.getValue() ;
	}
	
	public boolean equals(Object obj) {
	if (obj != null) {
        return this.equals((PromoItemListPLU)obj);
    }
    return false;
	}
	
	/** This method compares two PromoItemListPLUPK objects for equality.
	 * @param obj promoItemListPLUPK object to be compared against
	 * @return true if both primary keys represent the same promotion item list
	 */
	public boolean equals(PromoItemListPLU obj) {
		if (obj instanceof PromoItemListPLU) {
			PromoItemListPLU lObj = (PromoItemListPLU) obj;
			return (((PromoItemListPLUPK)this.getPK()).equals(lObj.getPK()));
		}
		return false;
	}
}
