package com.verifone.isd.vsms2.sys.util;

/**
 * Serializable typesafe enum class to represent membership card types 
 * 
 * TO DO: Convert all the strings here to support i18n. Is some behavior
 * to be supported by providing methods in this class?
 * @author Bhanu_N2
 */
public class MemberCardType implements java.io.Serializable {
    private transient String name;
    
    /**
     * Private constructor - do not allow subclassing
     * @param name member card type's name
     */
    private MemberCardType(String name) {
        this.name = name;
    }
    
    /**
     * Overridden method to provide the enumeration element details as a string
     * @return enumeration element details
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
     * Element in the enumeration to represent no member card type
     */
    public static MemberCardType NONE     = new MemberCardType("None");
    /**
     * Element in the enumeration to represent any member card type
     */
    public static MemberCardType ANY_CARD = new MemberCardType("Any Card");    
    
    // The 3 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++; //Member card type; auto-incremented
    private static final MemberCardType[] VALUES = {
        NONE, ANY_CARD
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
    
    /** Method to get the PopAwardType object for a specified ordinal. 
     * Used to get the object given a gempro's #define value
     * @param ordinal the #define value represented by the object
     * @return PopAwardType object representing the ordinal
     */
    public static final MemberCardType getObject(int ordinal) {
        return VALUES[ordinal];
    }     
}
