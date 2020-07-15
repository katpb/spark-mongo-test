package com.verifone.isd.vsms2.sales.ent.trans;

/**
 * TO DO: Convert all the strings here to support i18n. Is some behavior
 * to be supported by providing methods in this class?
 * @author  Bhanu_N2
 */
public class EntryMethod implements java.io.Serializable {
    static final long serialVersionUID = -4084949520523320682L;
    private transient String name;
    
    /** Private constructor - do not allow subclassing
     * @param name transaction type's name
     */
    private EntryMethod(String name) {
        this.name = name;
    }
    
    //    protected abstract Object getProcessor();
    
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
    
	public static EntryMethod SCANNER    = new EntryMethod("SCANNER");
    public static EntryMethod SCAN_UPCA    = new EntryMethod("SCAN_UPCA");
	public static EntryMethod SCAN_EXTENDED    = new EntryMethod("SCAN_EXTENDED");
	public static EntryMethod SCAN_GS1    = new EntryMethod("SCAN_GS1");//code added for GS1 Coupon
    public static EntryMethod MANUAL     = new EntryMethod("MANUAL");
    public static EntryMethod SWIPED     = new EntryMethod("SWIPED");
    public static EntryMethod PINPAD     = new EntryMethod("PINPAD");
	public static EntryMethod SCAN_CHECKER = new EntryMethod("SCAN_CHECKER");
	public static EntryMethod KEY = new EntryMethod("KEY");
	public static EntryMethod UNKNOWN = new EntryMethod("UNKNOWN");
    
    // The 4 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = ++nextOrdinal; //Pop membership entry method; auto-incremented; exclude 0
    private static final EntryMethod[] VALUES = {
		SCANNER, SCAN_UPCA, SCAN_EXTENDED, SCAN_GS1, MANUAL, SWIPED, PINPAD, SCAN_CHECKER, KEY, UNKNOWN
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
        return VALUES[ordinal-1]; // Canonicalize; index is 0 based, but ordinal is 1 based
    }
    
    /** Getter for property ordinal.
     * @return Value of property ordinal.
     */
    public int getOrdinal() {
        return this.ordinal;
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < VALUES.length; i++) {
            System.out.println("Method: " +VALUES[i].getOrdinal() +" name = " +VALUES[i].toString());
        }
    }    
}
