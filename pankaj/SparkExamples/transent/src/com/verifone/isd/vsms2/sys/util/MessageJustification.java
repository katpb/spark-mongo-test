/*
 * MessageJustification.java
 *
 * Created on April 29, 2003, 5:40 PM
 */

package com.verifone.isd.vsms2.sys.util;

/**
 * Serializable typesafe enum class to represent message justification types 
 * 
 * TO DO: Convert all the strings here to support i18n. Is some behavior
 * to be supported by providing methods in this class?
 * @author Bhanu_N2
 */
public class MessageJustification implements java.io.Serializable {
    private transient String name;
    
    /** Private constructor - do not allow subclassing
     * @param name justification type's name
     */
    private MessageJustification(String name) {
        this.name = name;
    }
    
//    public abstract String justify(String message, int length);
    
    /**
     * Overridden method to provide the justification type's name
     * @return justification type's name
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
     * 'Center' Justification type
     */
    public static MessageJustification CENTER = new MessageJustification("CENTER");/*{
        public String justify(String message, int length) {
            StringBuffer result = new StringBuffer();
            result.append(message.trim());
      //      TBD: fill the buffer with spaces/ truncate the buffer for the reqd length?
            return result.toString();
        }
    };*/    
    /**
     * 'Left' Justification type
     */
    public static final MessageJustification LEFT = new MessageJustification("LEFT");/* {
        public String justify (String message, int length) {
            StringBuffer result = new StringBuffer();
            result.append(message.trim());
            //TBD: fill the buffer with spaces/ truncate the buffer for the reqd length?
            return result.toString();
        }
    };*/
    
    /**
     * 'Right' Justification type
     */
    public static MessageJustification RIGHT = new MessageJustification("RIGHT");/*{
        public String justify(String message, int length) {
            StringBuffer result = new StringBuffer();
            result.append(message.trim());
     //       TBD: fill the buffer with spaces/ truncate the buffer for the reqd length?
            return result.toString();
        }
    };*/

    /* Do we need this type? - If yes, a word of caution: ruby does not know this type
     */
    /**
     * 'As-is' Justification type
     */
    public static MessageJustification NONE = new MessageJustification("NONE");/*{
        public String justify(String message, int length) {
            StringBuffer result = new StringBuffer();
            result.append(message.trim());
       //     TBD: fill the buffer with spaces/ truncate the buffer for the reqd length?
            return result.toString();
        }
    };*/
    
    // The 4 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++; //justification type; auto-incremented
    private static final MessageJustification[] VALUES = {
        CENTER, LEFT, RIGHT//, NONE
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
    
    /** Method to get the MessageJustification object for a specified ordinal. 
     * Used to get the object given a gempro's #define value
     * @param ordinal the #define value represented by the object
     * @return MessageJustification object representing the ordinal
     */
    public static final MessageJustification getObject(int ordinal) {
        return VALUES[ordinal];
    }    
}
