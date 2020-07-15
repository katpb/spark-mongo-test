/*
 * Created on Feb 22, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.verifone.isd.vsms2.sales.ent.menu;

import java.io.Serializable;

/**
 * @author Anindya_D1
 * 
 * This class represents a single submenu within a menu chain. It's a composite
 * consisting of the specific location within a menu chain and the sub menu id
 * at this location.
 */
public class MenuChainElement extends MenuItem implements Serializable {
	
	static final long serialVersionUID = -6998356410872574431L;
	
	public static final int MAX_CHAIN_LOCATION = 10;
	private MenuPK subMenu;

	/**
	 * 
	 */
	public MenuChainElement() {
	}
	/**
	 * @param location
	 * @param subMenu
	 */
	public MenuChainElement(int location, MenuPK subMenu) {
		super(location, null);
		this.subMenu = subMenu;
	}
	
	public MenuChainElement(int location) {
		this(location, null);
	}
	/**
	 * @return Returns the location.
	 */
	public int getLocation() {
		return ID;
	}
	/**
	 * @param location The location to set.
	 */
	public void setLocation(int location) {
		this.ID = location;
	}
	/**
	 * @return Returns the subMenu.
	 */
	public MenuPK getSubMenu() {
		return subMenu;
	}
	/**
	 * @param subMenu The subMenu to set.
	 */
	public void setSubMenu(MenuPK subMenu) {
		this.subMenu = subMenu;
	}
	
    /**
	 * Method to validate the primary key of the entity object
	 * 
	 * @throws Exception
	 *             on invalid data
	 */
	public void validate() throws Exception {
		if ((this.ID < 0) || (this.ID >= MAX_CHAIN_LOCATION))
			throw new Exception("Invalid Menu Chain Location: " + this.ID);
		if ((this.subMenu == null) || (!this.subMenu.isValid()))
			throw new Exception("Invalid sub menu for Menu Chain Location: "
					+ this.ID);
	}
}
