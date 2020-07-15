/*
 * promoItemListDeptItem.java
 *
 * Created on June 6, 2005, 4:28 PM
 */

package com.verifone.isd.vsms2.sales.ent.promoitemlistdept;

import java.io.Serializable;

/**
 * Entity to represent the items assigned to a promotion item list for
 * departments
 * @author  tom_s5
 */
public class PromoItemListDeptItem implements Serializable {

	private int deptItemListSubIndex;
	private int dept;

	/** This constructor to creates a new instance of promotion item list item
	 * for departments.
	 * @param deptItemListSubIndex The department item list sub-index.
	 * @param dept The department associated with the promotion item list.
	 */
	public PromoItemListDeptItem(int deptItemListSubIndex, int dept) {
		this.deptItemListSubIndex = deptItemListSubIndex;
		this.dept = dept;
	}

	/** This constructor creates a new instance of promotion item list item for
	 * departments.
	 * @param deptItemListSubIndex The department item list sub-index.
	 */
	public PromoItemListDeptItem(int deptItemListSubIndex) {
		this(deptItemListSubIndex, 0);
	}

	/** This no-arguments constructor creates a new instance of promotion item
	 * list item for departments.
	 */
	public PromoItemListDeptItem() {
	}


	/** This method gets the department item list sub-index.
	 * @return Department item list sub-index.
	 */
	public int getDeptItemListSubIndex() {
		return this.deptItemListSubIndex;
	}

	/** This method sets the department item list sub-index.
	 * @param deptItemListSubIndex The department item list sub-index.
	 */
	public void setDeptItemListSubIndex(int deptItemListSubIndex) {
		this.deptItemListSubIndex = deptItemListSubIndex;
	}

	/** This method gets the department associated with the promotion.
	 * @return The department for the promotion item.
	 */
	public int getDept() {
		return dept;
	}

	/** This method sets the department associated with the promotion.
	 * @param dept The department for the promotion item.
	 */
	public void setDept(int dept) {
	this.dept = dept;
	}

	/** This method validates the primary key of the entity object.
	 * @throws Exception On invalid data.
	 */
	public void validate() throws Exception {
		if (this.deptItemListSubIndex <= 0)
			throw new Exception("Invalid deptItemListSubIndex: " +
					this.deptItemListSubIndex);
		if (this.dept <= 0 || this.dept > 9999)
			throw new Exception("Invalid promo item list department: " +
					this.dept);
	}

	/** This method returns the String representation of the entity.
	 * @return String representation of the entity.
	 */
	public String toString() {
		return "deptItemListSubIndex:" + deptItemListSubIndex + "; dept:" + dept;
	}
}
