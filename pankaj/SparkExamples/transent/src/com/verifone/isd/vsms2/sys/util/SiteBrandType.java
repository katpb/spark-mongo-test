/*
 * SiteBrandType.java
 *
 * Created on October 6, 2009, 12:30 PM
 */

package com.verifone.isd.vsms2.sys.util;

/**
 * Serializable typesafe enum class to represent message mode types.
 * 
 * TO DO: Convert all the strings to support i18n. Is some behavior
 * to be supported by providing methods in this class?
 * @author Ken_C3
 */
public class SiteBrandType implements java.io.Serializable {
    private transient String name;
    
    /** Private constructor - do not allow subclassing
     * @param name transaction type's name
     */
    private SiteBrandType(String name) {
        this.name = name;
    }
    
    /**
     * Overridden method to provide the transaction type's name
     * @return transaction type's name
     */    
    public String toString() {
        return this.name;
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

    // Enumeration members for Site Brand Selection
    public static SiteBrandType UNKNOWN		= new SiteBrandType("Unknown");
    public static SiteBrandType BP_OIL		= new SiteBrandType("BP Oil");
    public static SiteBrandType CHEVRON		= new SiteBrandType("Chevron");    
    public static SiteBrandType CONOCO		= new SiteBrandType("Conoco");
    public static SiteBrandType PHILLIPS_66	= new SiteBrandType("Phillips 66");
    public static SiteBrandType UNION_76	= new SiteBrandType("Union 76");
    public static SiteBrandType HPS			= new SiteBrandType("HPS");
	public static SiteBrandType GEN_BUYPASS = new SiteBrandType("Generic Buypass");
	public static SiteBrandType SUN_BUYPASS = new SiteBrandType("Sunoco Buypass");
	public static SiteBrandType VAL_BUYPASS = new SiteBrandType("Valero Buypass");
	public static SiteBrandType NBS			= new SiteBrandType("NBS");
	public static SiteBrandType WORLDPAY	= new SiteBrandType("WorldPay");
    
    // The 4 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++; //Display Order type; auto-incremented
    private static final SiteBrandType[] VALUES = {
        UNKNOWN, BP_OIL, CHEVRON, CONOCO, PHILLIPS_66, UNION_76, HPS, 
        GEN_BUYPASS, SUN_BUYPASS, VAL_BUYPASS, NBS, WORLDPAY 
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
        return VALUES[ordinal];  // Canonicalize 
    }     

    /** Getter for property ordinal.
     * @return Value of property ordinal.
     */
    public int getOrdinal() {
        return this.ordinal;
    }    
    
    /** Method to get the SiteBrandType object for a specified ordinal. 
     * Used to get the object given a gempro's #define value
     * @param ordinal the #define value represented by the object
     * @return SiteBrandType object representing the ordinal
     */
    public static final SiteBrandType getObject(int ordinal) {
    	if (ordinal > 0 && ordinal < VALUES.length) {
    		return VALUES[ordinal];
    	} else {
    		return VALUES[0];
    	}
    }     
}
