/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 30 Sep, 2004                                     Sudesh Srinivasan
 */
package com.verifone.isd.vsms2.sales.ent.menu;

import java.io.Serializable;
import java.util.Comparator;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/** Entity class for menu.
 * @author sudesh_s1
 * @version 1.0
 */
public class Menu implements IEntityObject, ISalesEntityVisitable {

	private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sales.ent.menu.Menu.class);
    static final long serialVersionUID = 5014353290387871143L;

    /** Maximum menus */    
    public static final int MAX_MENUS = 200;
    /** Maximum menus allowed by ruby */    
    public static final int MAX_RUBY_MENUS = 100;

    private MenuPK pk;

    private String name;
    private TreeSet elements;
    private boolean parked;
    private MenuType type;

    /**
     * default constructor
     */
    public Menu() {
        this(null);
    }

    /**
     * Constructor
     * 
     * @param pk
     *            Primary key for the entity
     */
    public Menu(MenuPK pk) {
		this.pk = pk;
		this.name = "";
		this.elements = new TreeSet(new MenuItemComparator());
	}

    /**
	 * Setter for property name
	 * 
	 * @param name
	 *            name of the entity
	 */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for property name
     * 
     * @return name of the entity
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * @return Returns the type.
     */
    public MenuType getType() {
        return type;
    }
    /**
     * @param type The type to set.
     */
    public void setType(MenuType type) {
        this.type = type;
    }
    /**
     * Getter of the entity object's primary key
     * 
     * @return the ID of the entity object
     */
    public IEntityPK getPK() {
        return this.pk;
    }
    
	/**
	 * @return Returns the elements.
	 */
	public TreeSet getElements() {
		return elements;
	}

	/**
	 * @param elements The elements to set.
	 */
	public void setElements(TreeSet elements) {
		this.elements = elements;
	}
    /**
	 * Method to clone another entity with this enity's attributes
	 * 
	 * @param obj
	 *            entity to copy to
	 */
	public void setAttributes(IEntityObject obj) {
		Menu mObj = (Menu) obj;
		mObj.pk = this.pk;
		mObj.name = this.name;
		mObj.parked = this.parked;
		if (this.type == MenuType.MENU_CHAIN || this.type == MenuType.ORDER_MENU) {
			mObj.setChainElements(this.getChainElements());
		} else {
			mObj.setMenuItems(this.getMenuItems());
		}
	}

    /**
	 * Method to validate the primary key of the entity object
	 * 
	 * @return true if the primary key of the entity object is valid
	 */
    public boolean isPKValid() {
        return (this.pk == null) ? false : this.pk.isValid();
    }
    
    /**
	 * Convenience method to determine if this is a menu chain
	 * 
	 * @return true if menu chain, false otherwise
	 */
	public boolean isMenuChain() {
		boolean chain = false;
		if (this.type == MenuType.MENU_CHAIN) {
			chain = true;
		}
		return chain;
	}

    /**
	 * Set the primary key of the entity object
	 * 
	 * @param pk
	 *            primary key for the entity object
	 */
    public void setPK(IEntityPK pk) {
        this.pk = (MenuPK) pk;
    }

    /**
	 * Method to validate an entity object's attributes.
	 * 
	 * @throws Exception
	 *             if validation fails
	 */
    public void validate() throws Exception {
        if (!isPKValid()) {
            throw new Exception("Invalid menuKey: " + this.pk);
        }
        /* Allow a blank name but not a deleted record */
        if ((this.name != null) && (this.name.trim().equals("*"))) {
            throw new Exception("Invalid name for menuKey: " + pk);
        }
        
        /* Do not allow invalid type */
        if( this.type == null )
        	throw new Exception("MenuType is null");
        
        /* Do not allow items more number of items than allowed by this menu type*/
        if( !this.type.isAllowedItemCount(this.elements.size()) ){ 
            throw new Exception("Max menu items exceeded for menu: " + pk + " of type " + this.type);        	
        }

        if (this.type == MenuType.MENU_CHAIN) {
        	this.validateChainElements();
        } else {
        	this.validateMenuItems();
        }
    }

    protected void validateMenuItems() {
        MenuItem[] elems = this.getMenuItems();
        int len = elems.length;
        for (int i = 0; i < len; i++) {
            MenuItem item = elems[i];
            try {
                item.validate();
            } catch (Exception e) {
                logger.error("Menu: " + this.pk + " validation error - "
                        + e.getMessage());
            }
        }
    }
    
	/**
	 * Method to the validate the sub menus within a menu chain
	 *  
	 */
    private void validateChainElements() {
        MenuChainElement[] elems = this.getChainElements();
        for (int i = 0; i < elems.length; i++) {
            try {
                elems[i].validate();
            } catch (Exception e) {
                logger.error("MenuChain: " + this.pk + " validation error - "
                        + e.getMessage());
            }
        }
    }

    /**
     * Getter for a specific menu key item
     * 
     * @param itemID
     *            item number
     * @return requested menu key item
     */
    public MenuItem getMenuItem(int itemID) {
        MenuItem[] elems = this.getMenuItems();
        int len = elems.length;
        MenuItem reqdElem = null;
        for (int i = 0; i < len; i++) {
            if (elems[i].getID() == itemID) {
                reqdElem = elems[i];
                break;
            }
        }
        return reqdElem;
    }

    /**
     * Add a menu item
     * 
     * @param item
     *            menu key item to be added to the menu key
     */
    public void addMenuItem(MenuItem item) {
        this.removeMenuItem(item.getID()); //Add does not add if elem already
                                           // present; remove and add always
        elements.add(item);
    }

    /**
     * Remove a menu item
     * 
     * @param itemID
     *            ID of the menu key item to be removed
     */
    public void removeMenuItem(int itemID) {
        MenuItem mk = this.getMenuItem(itemID);
        if (mk != null) {
            elements.remove(mk);
        }
    }

    /**
     * Returns the list of menu key items for the menu key
     * 
     * @return list of menu key items for the menu key
     */
    public MenuItem[] getMenuItems() {
        return (MenuItem[]) this.elements.toArray(new MenuItem[0]);
    }

    /** Sets the list of menu key items for the menu key. Clears the existing
     * menu key items and adds the new items.
     * @param menuItems list of menu key items for the menu key
     */
    public void setMenuItems(MenuItem[] menuItems) {
        this.elements.clear();
        if (menuItems != null) {
            int numEl = menuItems.length;
            for (int i = 0; i < numEl; i++) {
                this.elements.add(menuItems[i]);
            }
        }
    }
    
    /**
	 * Get the next sub menu within the menu chain based on the current location
	 * 
	 * @param curLocation
	 * @return MenuChainElement
	 */
	public MenuChainElement getNextMenuChainElement(int curLocation) {
		MenuChainElement nextElement = null;
		try {
			nextElement = (MenuChainElement) this.elements.tailSet(
					new MenuChainElement(curLocation + 1)).first();
		} catch (Exception e) {
		}

		return nextElement;
	}
	
    /**
	 * Get the previous sub menu within the menu chain based on the current
	 * location
	 * 
	 * @param curLocation
	 * @return MenuChainElement
	 */
	public MenuChainElement getPrevMenuChainElement(int curLocation) {
		MenuChainElement prevElement = null;
		try {
			prevElement = (MenuChainElement) this.elements.headSet(
					new MenuChainElement(curLocation)).last();
		} catch (Exception e) {
		}

		return prevElement;
	}
    
    /**
	 * Getter for the chain element at a specific location id
	 * 
	 * @param location
	 *            location id
	 * @return requested menu chain element
	 */
    public MenuChainElement getMenuChainElement(int location) {
        MenuChainElement[] elems = this.getChainElements();
        MenuChainElement reqdElem = null;
        for (int i = 0; i < elems.length; i++) {
            if (elems[i].getLocation() == location) {
                reqdElem = elems[i];
                break;
            }
        }
        return reqdElem;
    }
    
    /**
     * Add a menu chain element
     * 
     * @param elem
     *            chain element to be added to the menu chain
     */
    public void addMenuChainElement(MenuChainElement elem) {
        this.removeMenuChainElement(elem.getLocation()); 
        /**
         * Add does not add if elem already present; remove and add always
         */
        elements.add(elem);
    }

    /**
     * Remove a menu chain element
     * 
     * @param location
     *            location of the chain element to be removed
     */
    public void removeMenuChainElement(int location) {
        MenuChainElement mElem = this.getMenuChainElement(location);
        if (mElem != null) {
            elements.remove(mElem);
        }
    }
    
    /**
     * Returns the list of chain elements for the menu chain
     * 
     * @return list of menu chain elements for the menu chain
     */
    public MenuChainElement[] getChainElements() {
        return (MenuChainElement[]) this.elements.toArray(new MenuChainElement[0]);
    }

    /** Sets the list of menu key items for the menu key. Clears the existing
     * menu key items and adds the new items.
     * @param chainElements list of menu key items for the menu key
     */
    public void setChainElements(MenuChainElement[] chainElements) {
        this.elements.clear();
        if (chainElements != null) {
            int numEl = chainElements.length;
            for (int i = 0; i < numEl; i++) {
                this.elements.add(chainElements[i]);
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

    private class MenuItemComparator implements Comparator, Serializable {
        public int compare(Object o1, Object o2) {
            /* Arrays.sort calls compare when o1 and o2 are equal. */
            if (o1.equals(o2))
                return 0;

            MenuItem c1 = (MenuItem) o1;
            MenuItem c2 = (MenuItem) o2;
            return (c1.getID() - c2.getID());
        }
    }

    /*
     * public static void main(String[] args) { MenuKey m = new MenuKey(new
     * MenuKeyPK(1)); Vector v = new Vector(); v.add(new MenuKeyItem(6, new
     * PluPK("000000000121000"))); v.add(new MenuKeyItem(5, new
     * PluPK("000000000122000"))); v.add(new MenuKeyItem(3, new
     * PluPK("000000000123000"))); v.add(new MenuKeyItem(4, new
     * PluPK("000000000124000"))); v.add(new MenuKeyItem(1, new
     * PluPK("000000000125000"))); v.add(new MenuKeyItem(2, new
     * PluPK("000000000126000"))); m.setMenuItems((MenuKeyItem[]) (v.toArray(new
     * MenuKeyItem[0]))); MenuKeyItem[] r = m.getMenuItems(); for (int i = 0; i <
     * r.length; i++) { System.out.println("#: " +r[i].getID() +" plu: "
     * +r[i].getPlu()); } MenuKeyItem mi = m.getMenuItem(3);
     * System.out.println("#: " +mi.getID() +" plu: " +mi.getPlu());
     * m.removeMenuItem(3); r = m.getMenuItems(); for (int i = 0; i < r.length;
     * i++) { System.out.println("#: " +r[i].getID() +" plu: " +r[i].getPlu()); }
     * mi = new MenuKeyItem(3, new PluPK("000000000567000")); m.addMenuItem(mi);
     * r = m.getMenuItems(); for (int i = 0; i < r.length; i++) {
     * System.out.println("#: " +r[i].getID() +" plu: " +r[i].getPlu()); } mi =
     * new MenuKeyItem(3, new PluPK("000000000666000")); m.addMenuItem(mi); r =
     * m.getMenuItems(); for (int i = 0; i < r.length; i++) {
     * System.out.println("#: " +r[i].getID() +" plu: " +r[i].getPlu()); } }
     */
    /** Getter for parked property
     * @return Returns the parked.
     */
    public boolean getParked() {
        return parked;
    }

    /** Setter for parked property
     * @param parked The parked to set.
     */
    public void setParked(boolean parked) {
        this.parked = parked;
    }

    /** String representation of the entity
     * @return String representation of the entity
     */    
    public String toString() {
        String strType = "";
        if(this.type != null)
            strType = this.type.toString();
        return "ID:" + pk.getValue() + ";name:" + name + ";type:" + strType + ";parked:" + parked + ";items:" + (elements != null ? elements : null);
    }
}

