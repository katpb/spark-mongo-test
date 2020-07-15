/*
 * PeriodDurationType.java
 *
 * Created on April 29, 2003, 5:40 PM
 */

package com.verifone.isd.vsms2.sys.ent.report;

/**
 * TO DO: Convert all the strings here to support i18n. Is some behavior
 * to be supported by providing methods in this class?
 * Serializable typesafe enum class to represent message mode types
 * @author  Bhanu_N2
 */
public class PeriodDurationType implements java.io.Serializable {
    static final long serialVersionUID = -2394203753918276444L;    
    private transient String name;
    private transient int hourMultiplier;
    
    /** Private constructor - do not allow subclassing
     * @param name transaction type's name
     */
    private PeriodDurationType(String name, int hourMultiplier) {
        this.name = name;
        this.hourMultiplier = hourMultiplier;
    }
    
    /** Override toString() method to provide the transaction type's name
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

    public static PeriodDurationType HOUR  = new PeriodDurationType("HOUR", 1);
    public static PeriodDurationType DAY  = new PeriodDurationType("DAY", 24);
    
    // The 4 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++; //security level type; auto-incremented
    private static final PeriodDurationType[] VALUES = {
        HOUR, DAY
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
    
    /** Method to get the PeriodDurationType object for a specified ordinal. 
     * Used to get the object given a gempro's #define value
     * @param ordinal the #define value represented by the object
     * @return PeriodDurationType object representing the ordinal
     */
    public static final PeriodDurationType getObject(int ordinal) {
        return VALUES[ordinal];
    }   
    
    /**
     * Getter for property hourMultiplier.
     * @return Value of property hourMultiplier.
     */
    public int getHourMultiplier() {
        return hourMultiplier;
    }
}
