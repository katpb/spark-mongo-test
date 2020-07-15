/*
 * PricingSchemeType.java
 *
 * Created on December 11, 2003, 3:00 PM
 */

package com.verifone.isd.vsms2.sys.util;

/**
 * Serializable typesafe enum class to represent pricing scheme types
 * TO DO: Convert all the strings here to support i18n. Is some behavior
 * to be supported by providing methods in this class?
 * @author  Bhanu_N2
 */
public class PricingSchemeType implements java.io.Serializable {
    private transient String name;
    
    /** Private constructor - do not allow subclassing
     * @param name pricing scheme type's name
     */
    private PricingSchemeType(String name) {
        this.name = name;
    }
    
    /** Override toString() method to provide the pricing scheme type's name
     * @return pricing scheme type's name
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

    /**
     * 'Mix price' type
     */
    public static PricingSchemeType PRICE_EACH_MIX = new PricingSchemeType("PRICE_EACH_MIX");    
    /**
     * 'Match price' type
     */
    public static PricingSchemeType PRICE_MATCH    = new PricingSchemeType("PRICE_MATCH");
    
    // The 4 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++; //Award type; auto-incremented
    private static final PricingSchemeType[] VALUES = {
        PRICE_EACH_MIX, PRICE_MATCH
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
    
    /** Method to get the PricingSchemeType object for a specified ordinal. 
     * Used to get the object given a gempro's #define value
     * @param ordinal the #define value represented by the object
     * @return PricingSchemeType object representing the ordinal
     */
    public static final PricingSchemeType getObject(int ordinal) {
        return VALUES[ordinal];
    }     
}
