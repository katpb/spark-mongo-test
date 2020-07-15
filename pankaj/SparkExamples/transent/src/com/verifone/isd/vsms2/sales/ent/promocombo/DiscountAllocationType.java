/*
 * DiscountType.java
 *
 */

package com.verifone.isd.vsms2.sales.ent.promocombo;

import com.verifone.isd.vsms2.sales.ent.promomixandmatch.*;

/**
 * Serializable typesafe enum class to represent VIP discount scheme types
 * TO DO: Convert all the strings here to support i18n. Is some behavior
 * to be supported by providing methods in this class?
 * @author  Bhanu_N2
 */
public class DiscountAllocationType implements java.io.Serializable {
    private transient String name;
    private transient String gemproCode;
    private transient int gemproId;
    
    /** Private constructor - do not allow subclassing
     * @param name pricing scheme type's name
     */
    private DiscountAllocationType(String name, String gemproCode, int gemproId) {
        this.name = name;
        this.gemproCode = gemproCode;
        this.gemproId = gemproId;
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
        if (obj instanceof DiscountAllocationType) {
            return super.equals(obj);
        }
        return false;
    }

    /**
     * 'Unit price' type
     */
    public static DiscountAllocationType UNIT_PRICE = new DiscountAllocationType("UNIT_PRICE", "U", 0);
    /**
     * 'percent' type
     */
    public static DiscountAllocationType PERCENT    = new DiscountAllocationType("PERCENT", "P", 1);
    /**
     * 'amount' type
     */
    public static DiscountAllocationType AMOUNT    = new DiscountAllocationType("AMOUNT", "A", 2);

    
    // The 4 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++; //Award type; auto-incremented
    private static final DiscountAllocationType[] VALUES = {
        UNIT_PRICE, PERCENT, AMOUNT
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

    /**
     * @return the gemproCode
     */
    public String getGemproCode() {
        return gemproCode;
    }

    public int getGemproId() {
        return this.gemproId;
    }
    
    public static DiscountAllocationType getForGemproCode(String gemproCode) {
        for (int i = 0; i < VALUES.length; i++) {
            if (gemproCode.equals(VALUES[i].gemproCode)) {
                return VALUES[i];
            }
        }
        return null;
    }
}
