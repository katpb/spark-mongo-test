/*
 * promoItemListDept.java
 *
 * Created on June 6, 2005, 4:27 PM
 */

package com.verifone.isd.vsms2.sales.ent.promoitemlistdept;

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

/** This class is the entity for promotions item list for departments.
 * @author tom_s5
 */
public class PromoItemListDept implements IEntityObject, ISalesEntityVisitable {

	private static final long serialVersionUID = -4751428189346051007L;
	private transient Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sales.ent.promoitemlistdept.PromoItemListDept.class);
	private PromoItemListDeptPK pk; /* AKA List ID  or deptItemListID */
	private String deptItemListID;
	private String itemListDescription;
	private TreeSet items;

	/** This is the no-args constructor. */
	public PromoItemListDept() {
		this(null);
	}

	/** This is the constructor.
	 * @param pk TaxPK for the object
	 */
	public PromoItemListDept(PromoItemListDeptPK pk) {
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

	/** This method gets the entity objects primary key.
	 * @return The primary key of the entity object.
	 */
	public IEntityPK getPK() {
		return this.pk;
	}

	/** This method validates the primary key of the entity object.
	 * @return True if the primary key of the entity object is valid.
	 */
	public boolean isPKValid() {
		return (this.pk == null) ? false : this.pk.isValid();
	}

	/** This method clones another entity with this enity's attributes.
	 * @param obj The entity to copy to.
	 */
	public void setAttributes(IEntityObject obj) {
		PromoItemListDept pObj = (PromoItemListDept) obj;
		pObj.pk = this.pk;
		pObj.deptItemListID = this.deptItemListID;
		pObj.setItems(this.getItems());
	}

	/** This method sets the primary key of the entity object.
	 * @param pk The primary key for the entity object.
	 */
	public void setPK(IEntityPK pk) {
		this.pk = (PromoItemListDeptPK) pk;
	}

	/** This method validates the entity object's attributes.
	 * @throws Exception If validation fails.
	 */
	public void validate() throws Exception {
		if (!isPKValid()) {
			throw new Exception("Invalid PromoItemListDept: " + this.pk);
		}
		this.validateItems();
	}

	private void validateItems() {
		PromoItemListDeptItem[] elems = this.getItems();
		int len = elems.length;
		for (int i = 0; i < len; i++) {
			PromoItemListDeptItem item = elems[i];
			try {
				item.validate();
			} catch (Exception e) {
				logger.error("Menu: " + this.pk + " validation error - " +
						e.getMessage());
			}
		}
	}

	/** Implementation method for visitable in visitor pattern
	 * @param v The visitor.
	 * @throws Exception On exception in visitor's visit method.
	 */
	public void accept(SalesEntityVisitor v) throws Exception {
		v.visit(this);
	}

	/** This method sets the list of items for the promotions item list.  It
	 * clears the existing items and adds the new items.
	 * @param items List of items for the promotion.
	 */
	public void setItems(PromoItemListDeptItem[] items) {
		this.items.clear();
		if (items != null) {
			int numEl = items.length;
			for (int i = 0; i < numEl; i++) {
				this.items.add(items[i]);
			}
		}
	}

	/** This method is the getter for a specific item list item
	 * @param deptItemListSubIndex The item sub-index.
	 * @return The requested item list item.
	 */
	public PromoItemListDeptItem getItem(int deptItemListSubIndex) {
		PromoItemListDeptItem[] elems = this.getItems();
		int len = elems.length;
		PromoItemListDeptItem reqdElem = null;
		for (int i = 0; i < len; i++) {
			if (elems[i].getDeptItemListSubIndex() == deptItemListSubIndex) {
				reqdElem = elems[i];
				break;
			}
		}
		return reqdElem;
	}

	/** This method returns the list of item list items for the promotion.
	 * @return The list of item list items for the promotion.
	 */
	public PromoItemListDeptItem[] getItems() {
		return (PromoItemListDeptItem[]) this.items.toArray(
				new PromoItemListDeptItem[0]);
	}

	/** The method adds an item to the item list.
	 * @param item The item to be added to the item list.
	 */
	public void addItem(PromoItemListDeptItem item) {
		this.removeItem(item.getDeptItemListSubIndex());
		items.add(item);
	}

	/** This method removes an item from the item list.
	 * @param deptItemListSubIndex The sub-index of the item to be removed from
	 * the item list.
	 */
	public void removeItem(int deptItemListSubIndex) {
		PromoItemListDeptItem item = this.getItem(deptItemListSubIndex);
		if (item != null) {
			items.remove(item);
		}
	}



	public String getDeptItemListID() {
		return deptItemListID;
	}

	public void setDeptItemListID(String deptItemListID) {
		this.deptItemListID = deptItemListID;
	}



	private class ItemComparator implements Comparator, Serializable {
		public int compare(Object o1, Object o2) {
			/*
			 * Arrays.sort calls compare when o1 and o2 are equal
			 */
			if (o1 == o2)
				return 0;
			PromoItemListDeptItem c1 = (PromoItemListDeptItem) o1;
			PromoItemListDeptItem c2 = (PromoItemListDeptItem) o2;
			return (c1.getDeptItemListSubIndex() -
					c2.getDeptItemListSubIndex());
		}
	}

	/** This method returns the string representation of the entity
	 * @return String representation of the entity
	 */
	public String toString() {
		return "ID:" + pk.getValue() ;
	}
}
