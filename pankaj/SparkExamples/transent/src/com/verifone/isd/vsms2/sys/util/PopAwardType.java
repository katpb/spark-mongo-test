/*
 * PopAwardType.java
 *
 * Created on September 3, 2003, 10:30 AM
 */

package com.verifone.isd.vsms2.sys.util;

/**
 * Serializable typesafe enum class to represent pop award types
 * TO DO: Convert all the strings here to support i18n. Is some behavior
 * to be supported by providing methods in this class?
 * @author  Bhanu_N2
 */
public class PopAwardType implements java.io.Serializable {
    private transient String name;
    
    /** Private constructor - do not allow subclassing
     * @param name pop award type's name
     */
    private PopAwardType(String name) {
        this.name = name;
    }
    
    /** Overridden method to provide the pop award type's name
     * @return pop award type's name
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
     * 'Discount only' award type
     */
    public static PopAwardType DISCOUNT_ONLY    = new PopAwardType("DISCOUNT_ONLY");
    /**
     * 'Discount or Coupon' award type
     */
    public static PopAwardType DISCOUNT_OR_CODE = new PopAwardType("DISCOUNT_OR_CODE");    
    /**
     * 'Coupon only' award type
     */
    public static PopAwardType COUPON_ONLY      = new PopAwardType("COUPON_ONLY");
    
    // The 4 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = ++nextOrdinal; //Award type; auto-incremented; pre-increment to skip 0
    private static final PopAwardType[] VALUES = {
        DISCOUNT_ONLY, DISCOUNT_OR_CODE, COUPON_ONLY
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
        return VALUES[ordinal-1];  // Canonicalize 
    }     

    /** Getter for property ordinal.
     * @return Value of property ordinal.
     */
    public int getOrdinal() {
        return this.ordinal;
    }    
    
    /** Method to get the PopAwardType object for a specified ordinal. 
     * Used to get the object given a gempro's #define value
     * @param ordinal the #define value represented by the object
     * @return PopAwardType object representing the ordinal
     */
    public static final PopAwardType getObject(int ordinal) {
        if (ordinal > 0 && ordinal <= VALUES.length) 
            return VALUES[ordinal-1];
        return null;
    }   
    
    /*
    public static void main(String[] args) {
        System.out.println(PopAwardType.DISCOUNT_ONLY.getOrdinal());
        System.out.println(PopAwardType.DISCOUNT_OR_CODE.getOrdinal());      
        System.out.println(PopAwardType.COUPON_ONLY.getOrdinal());   
        System.out.println(PopAwardType.getObject(1).toString());
        System.out.println(PopAwardType.getObject(2).toString());      
        System.out.println(PopAwardType.getObject(3).toString());        
    }*/
}
