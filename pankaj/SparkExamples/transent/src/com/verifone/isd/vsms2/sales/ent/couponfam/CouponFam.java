/*
 * CouponFam.java
 *
 * Created on September 19, 2005, 3:33 PM
 */

package com.verifone.isd.vsms2.sales.ent.couponfam;

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

/**
 * The entity object for scanned coupon configuration processing.
 * @author tom_s5
 */
public class CouponFam implements IEntityObject, ISalesEntityVisitable {
    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sales.ent.couponfam.CouponFam.class);
	static final long serialVersionUID = -62005417095054652L;
	private CouponFamPK ID;
	private String description;
	private TreeSet items;
	
	/**
	 * Creates a new instance of the CouponFam class.
	 * @param ID The primary key.
	 */
	public CouponFam(CouponFamPK ID) {
		this.ID = ID;
		this.items = new TreeSet(new ItemComparator());
	}
	
	/**
	 * Return a reference to the description String.
	 * @return The description String.
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * Sets the description String.
	 * @param description The description String to be set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Clones another entity with this enity's attributes.
	 * @param obj A reference to the entity to copy to.
	 */
	public void setAttributes(IEntityObject obj) {
		CouponFam lObj = (CouponFam) obj;
		lObj.setPK(this.getPK());
		lObj.setDescription(this.getDescription());
		CouponFamItem[] cfis = this.getItems();
		for (int i = 0; i < cfis.length; i++)
			lObj.addItem(cfis[i]);
	}
	
	/**
	 * Validates the primary key of the entity object.
	 * @return true if the primary key of the entity object is valid
	 */
	public boolean isPKValid() {
		return this.ID.isValid();
	}
	
	/**
	 * Validates an entity object's attributes.
	 * @throws Exception If validation fails.
	 */
	public void validate() throws Exception {
		if (!isPKValid()) {
			logger.error("CouponFam ERROR invalid CouponFam");
			throw new Exception("Invalid CouponFam: " + this.ID);
		}
	}
	
	/**
	 * Accept the visit request.
	 * @param v The visitor.
	 * @throws Exception Upon exception in visitor's visit method.
	 */
	public void accept(SalesEntityVisitor v) throws Exception {
		v.visit(this);
	}
	
	/**
	 * Return a reference to the IEntityPk.
	 * @return A reference to the IEntityPK.
	 */
	public IEntityPK getPK() {
		return this.ID;
	}
	
	/**
	 * Set the primary key.
	 * @param pk The primary key value.
	 */
	public void setPK(IEntityPK pk) {
		this.ID = (CouponFamPK) pk;
	}

	/**
	 * Get a specific coupon family item list item.
	 * @param famCode  The code of the item to get.
	 * @param pluNum  The PLU number of the item to get.
	 * @return requested coupon family item list item
	 */
	public CouponFamItem getItem(String famCode, String pluNum) {
		CouponFamItem[] elems = this.getItems();
		int len = elems.length;
		CouponFamItem reqdElem = null;
		for (int i = 0; i < len; i++) {
			if (   elems[i].getFamCode().equals(famCode)
				&& elems[i].getPLUNum().equals(pluNum)) {
				reqdElem = elems[i];
				break;
			}
		}
		return reqdElem;
	}

	/**
	 * Returns the list of coupon family item list items.
	 * @return The list of coupon family item list items.
	 */
	public CouponFamItem[] getItems() {
		return (CouponFamItem[]) this.items.toArray(new CouponFamItem[0]);
	}

	/**
	 * Add an item to the coupon family item list.
	 * @param item The item to be added to the coupon family item list.
	 */
	public void addItem(CouponFamItem item) {
		this.removeItem(item.getFamCode(), item.getPLUNum());
		items.add(item);
	}

	/** 
	 * Remove a coupon family item from the item list.
	 * @param famCode  The family code for the item
	 * @param pluNum  The PLU number for the item to be removed.
	 */
	public void removeItem(String famCode, String pluNum) {
		CouponFamItem item = this.getItem(famCode, pluNum);
		if (item != null) {
			items.remove(item);
		}
	}

	/*
	 * This class is the comparator used for managing the object TreeSet.
	 */
	private class ItemComparator implements Comparator, Serializable {
		static final long serialVersionUID = -1751025416479419260L;
		/*
		 * Compares two item objects lexicographically.
		 * @return The value 0 if object 1 is equal to object 2; a value less than 0 if
		 * this object 1 is lexicographically less than object 2; and a value greater
		 * than 0 if object 1 is lexicographically greater than object 2.
		 */
		public int compare(Object o1, Object o2) {
			/*
			 * Arrays.sort calls compare when o1 and o2 are equal
			 */
			if (o1 == o2)
				return 0;
			CouponFamItem cfi1 = (CouponFamItem) o1;
			CouponFamItem cfi2 = (CouponFamItem) o2;
			int rc;
			if ((rc = cfi1.getFamCode().compareTo(cfi2.getFamCode())) == 0)
				rc = cfi1.getPLUNum().compareTo(cfi2.getPLUNum());
			return rc;
		}
	}
}
