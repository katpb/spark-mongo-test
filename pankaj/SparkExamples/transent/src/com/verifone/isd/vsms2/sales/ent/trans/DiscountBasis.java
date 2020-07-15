package com.verifone.isd.vsms2.sales.ent.trans;


/**
 * TO DO: Convert all the strings here to support i18n. Is some behavior
 * to be supported by providing methods in this class?
 * @author  Bhanu_N2
 */
public class DiscountBasis implements java.io.Serializable {
    static final long serialVersionUID = 6855737090685283310L;    
    private transient String name;
    
    /** Private constructor - do not allow subclassing
     * @param name transaction type's name
     */
    private DiscountBasis(String name) {
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

    public static DiscountBasis ITEM_BASED        = new DiscountBasis("ITEM_BASED");
    public static DiscountBasis PAYMENT_BASED        = new DiscountBasis("PAYMENT_BASED");
    public static DiscountBasis OLD_CODE_BASED   = new DiscountBasis("OLD_CODE_BASED");
    public static DiscountBasis MEMBERSHIP_BASED = new DiscountBasis("MEMBERSHIP_BASED");    
    
    // The 4 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++; //Plu entry method; auto-incremented
    private static final DiscountBasis[] VALUES = {
        ITEM_BASED, PAYMENT_BASED, OLD_CODE_BASED, MEMBERSHIP_BASED
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
}
