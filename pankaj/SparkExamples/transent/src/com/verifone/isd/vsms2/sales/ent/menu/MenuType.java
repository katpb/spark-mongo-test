/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
*
* Created 13 Mar, 2007                                     Sudesh Srinivasan
*/
package com.verifone.isd.vsms2.sales.ent.menu;

/**
 * Type-safe enumeration of menu types available in the system
 */
public class MenuType implements java.io.Serializable {
    static final long serialVersionUID = 7826619210133070911L;
    
    /** Maximum items allowed by Ruby in a menu */    
    private static final int MAX_RUBY_MENU_ITEMS = 6;
    /** Maximum items allowed for an expanded menu */    
    private static final int MAX_EXPANDED_MENU_ITEMS = 96;
    /** Maximum items(number of menus) allowed for a menu chain */  
    private static final int MAX_MENU_CHAIN_ITEMS = 50;

    private transient String name;
    private transient int maxItems;
    
    /** Private constructor - do not allow subclassing
     * @param name menu type's name
     */
    private MenuType(String name) {
        this.name = name;
        this.maxItems = -1; //to mark that this menu type has no maxItems limit
    }

    /** Private constructor - do not allow subclassing
     * @param name menu type's name
     * @param maxItems maximum number of items allowed for this menu type
     */
    private MenuType(String name, int maxItems) {
        this.name = name;
        this.maxItems = maxItems;
    }
    
    /** 
     * @return menu type's name
     */    
    public String getName() {
        return this.name;
    }
    
    /**
     * @return the maxItems allowed for this menu type
     * returns -1 if there is no max limit for this menu type 
     */
    public int getMaxItems() {
        return maxItems;
    }

    /** 
     * Not required since constructor is private. Just in case.. 
     * Prevent subclasses from overriding Object.hashCode() to ensure
     * the following contract of typesafe enum:
     * "All equal objects of the enumerated type are also
     * identical i.e., a.equals(b) iff a==b".
     * Thus, it is enough to do an == instead of the expensive
     * Object.equals method
     * @return Value returned by super class's hashCode() method
     */    
    public final int hashCode() {
        return super.hashCode();
    }
    
    /** 
     * Not required since constructor is private. Just in case.. 
     * Prevent subclasses from overriding Object.equals to ensure
     * the following contract of typesafe enum:
     * "All equal objects of the enumerated type are also
     * identical i.e., a.equals(b) iff a==b".
     * Thus, it is enough to do an == instead of the expensive
     * Object.equals method
     * @param obj Object to be compared for equality
     * @return true if the compared instance satisfies == test
     */    
    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static MenuType RUBY_COMPATIBLE  = new MenuType("RUBY_COMPATIBLE", MAX_RUBY_MENU_ITEMS);
    public static MenuType EXPANDED   = new MenuType("EXPANDED", MAX_EXPANDED_MENU_ITEMS);    
    public static MenuType EXPANDED_MULTISELECT   = new MenuType("EXPANDED_MULTISELECT", MAX_EXPANDED_MENU_ITEMS);    
    public static MenuType MENU_CHAIN   = new MenuType("MENU_CHAIN", MAX_MENU_CHAIN_ITEMS);    
    public static MenuType ORDER_MENU   = new MenuType("ORDER_MENU", MAX_MENU_CHAIN_ITEMS);    
    
    // The 4 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++; //discount type; auto-incremented
    private static final MenuType[] VALUES = {
            RUBY_COMPATIBLE, EXPANDED, EXPANDED_MULTISELECT, MENU_CHAIN, ORDER_MENU
    };
    
    /** Method to prevent duplicate constants from coexisting as a
     * result of deserialization (ensures that only a single object
     * represents each enum constant. This method is automatically
     * invoked by the serialization mechanism. Without this method,
     * Object.equals() method would be more involved and not a
     * straightforward super.equals() which does just a == check.
     * @throws java.io.ObjectStreamException on serialization system issues
     * @return the enum array
     */
    Object readResolve() throws java.io.ObjectStreamException {
        return VALUES[ordinal]; // Canonicalize
    }     
    
    /** Getter for property ordinal.
     * @return Value of property ordinal.
     */
    public int getOrdinal() {
        return this.ordinal;
    }    
    
    /** Method to get the MenuType object for a specified ordinal. 
     * Used to get the object given a gempro's #define value
     * @param ordinal the #define value represented by the object
     * @return MenuType object representing the ordinal
     */
    public static final MenuType getObject(int ordinal) {
        return VALUES[ordinal];
    }
    
    /**
     * @param itemCnt - number of items
     * @return true if this menu can hold the given number of items 
     * 		or false otherwise
     */
    public boolean isAllowedItemCount(int itemCnt) {
    	if( this.maxItems >= 0 && this.maxItems < itemCnt)
    		return false;
    	return true;
    }    
    
    public static void main(String[] args) {
        for (int i = 0; i < VALUES.length; i++) {
            System.out.println("Method: " +VALUES[i].getOrdinal() +" name = " +VALUES[i].toString() + " ordinal = " + VALUES[i].getOrdinal());
        }
    }    
}
