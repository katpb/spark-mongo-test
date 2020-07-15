package com.verifone.isd.vsms2.sales.ent.policy;

import java.io.Serializable;

/**
 * 
 * This class is a Value Object for AddItem action.
 * 
 */

public class AddItemInfo implements Serializable{

	private static final long serialVersionUID = 6213247165941678494L;

	private int quanity;
	private int menuId;

	/**
	 * getter for quantity
	 * 
	 * @return
	 */
	public int getQuanity() {
		return quanity;
	}

	/**
	 * setter for quantity
	 * 
	 * @param quanity
	 */
	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

	/**
	 * getter for menu id
	 * 
	 * @return
	 */
	public int getMenuId() {
		return menuId;
	}

	/**
	 * setter for menu id
	 * 
	 * @param menuId
	 */
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

}
