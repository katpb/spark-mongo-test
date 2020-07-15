/*
 * SecurityLevel.java
 *
 * Created on April 29, 2003, 5:40 PM
 */

package com.verifone.isd.vsms2.sys.ent.securityctrl;

/**
 * TO DO: Convert all the strings here to support i18n. Is some behavior
 * to be supported by providing methods in this class?
 * Serializable typesafe enum class to represent message mode types
 * @author  Bhanu_N2
 */
public class SecurityLevel implements java.io.Serializable {
    static final long serialVersionUID = -2394203753918276444L;    
    private transient String name;
    
    /** Private constructor - do not allow subclassing
     * @param name transaction type's name
     */
    private SecurityLevel(String name) {
        this.name = name;
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

    public static SecurityLevel LEVEL_0  = new SecurityLevel("LEVEL_0");
    public static SecurityLevel LEVEL_1  = new SecurityLevel("LEVEL_1");
    public static SecurityLevel LEVEL_2  = new SecurityLevel("LEVEL_2");
    public static SecurityLevel LEVEL_3  = new SecurityLevel("LEVEL_3");
    public static SecurityLevel LEVEL_4  = new SecurityLevel("LEVEL_4");
    public static SecurityLevel LEVEL_5  = new SecurityLevel("LEVEL_5");
    public static SecurityLevel LEVEL_6  = new SecurityLevel("LEVEL_6");
    public static SecurityLevel LEVEL_7  = new SecurityLevel("LEVEL_7");
    public static SecurityLevel LEVEL_8  = new SecurityLevel("LEVEL_8");
    public static SecurityLevel LEVEL_9  = new SecurityLevel("LEVEL_9");
    public static SecurityLevel BACKDOOR  = new SecurityLevel("BACKDOOR");
    
    // The 4 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++; //security level type; auto-incremented
    private static final SecurityLevel[] VALUES = {
        LEVEL_0, LEVEL_1, LEVEL_2, LEVEL_3, LEVEL_4, LEVEL_5, LEVEL_6, LEVEL_7, LEVEL_8, 
        LEVEL_9,BACKDOOR
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
    
    /** Method to get the SecurityLevel object for a specified ordinal. 
     * Used to get the object given a gempro's #define value
     * @param ordinal the #define value represented by the object
     * @return SecurityLevel object representing the ordinal
     */
    public static final SecurityLevel getObject(int ordinal) {
        if (ordinal >= 0 && ordinal < VALUES.length)
            return VALUES[ordinal];
        return null;
    }   
    public static final SecurityLevel MINIMUM = LEVEL_0;
    public static final SecurityLevel MAXIMUM = LEVEL_9;
}
