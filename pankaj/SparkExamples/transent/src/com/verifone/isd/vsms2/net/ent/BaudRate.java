/*
 * BaudRate.java
 *
 * Created on April 29, 2003, 5:40 PM
 */

package com.verifone.isd.vsms2.net.ent;

/** Type-safe enumeration of Baud rates
 * TO DO: Convert all the strings here to support i18n, Uncomment (and
 * change the method name?) the abstract method and provide concrete
 * control classes for each Baud rate processing. Provide a
 * vanilla control class and subclass it as we add support for each Baud rate?
 * @author Bhanu_N2
 */
public class BaudRate implements java.io.Serializable {
    static final long serialVersionUID = -572611815409042873L;
    private transient int baudRate;
    private transient String name;
    
    /** Constructor to allow subclassing
     * @param baudRate baud rate
     * @param name Baud rate's name
     */
    protected BaudRate(int baudRate, String name) {
        this.baudRate = baudRate;
        this.name = name;
    }
    
    public int getValue() {
        return this.baudRate;
    }
    
//    protected abstract Object getProcessor();
    
    /** Override toString() method to provide the Baud rate's name
     * @return Baud rate's name
     */    
    public String toString() {
        return this.name;
    }
    
    /** Prevent subclasses from overriding Object.hashCode() to ensure
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
    
    /** Prevent subclasses from overriding Object.equals to ensure
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

    public static BaudRate BAUD_0           = new BaudRate(0,  "BAUD_0");
    public static BaudRate BAUD_300         = new BaudRate(300,  "BAUD_300");
    public static BaudRate BAUD_1200        = new BaudRate(1200, "BAUD_1200");
    public static BaudRate BAUD_2400    	  = new BaudRate(2400, "BAUD_2400");
    public static BaudRate BAUD_9600    	  = new BaudRate(9600, "BAUD_9600");

    
    // The 4 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++; //auto-incremented
    private static final BaudRate[] VALUES = {
        BAUD_0, BAUD_300, BAUD_1200, BAUD_2400, BAUD_9600
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
    
    /** Getter for property ordinal. Used to get the gempro's #define value
     * @return Value of property ordinal.
     */
    public int getOrdinal() {
        return this.ordinal;
    }
    
    /** Method to get the BaudRate object for a specified ordinal. 
     * Used to get the object given a gempro's #define value
     * @param ordinal the #define value represented by the object
     * @return BaudRate object representing the ordinal
     */
    protected static BaudRate getObject(int ordinal) {
        return VALUES[ordinal];
    }
    
    /** Getter for all the BaudRate objects
     * @return array of BaudRates
     */    
    protected static BaudRate[] getObjects() {
        BaudRate[] codes = new BaudRate[VALUES.length];
        System.arraycopy(VALUES, 0, codes, 0, VALUES.length);
        return codes;
    }
    
    /** Test method
     * @param args params to the test
     */    
    public static void main(String[] args) {
        BaudRate[] values = BaudRate.getObjects();
        for (int i = 0; i < values.length; i++) {
            System.out.println("BaudRate: " +values[i].getOrdinal() +" name = " +values[i].toString());
        }
    }
}
