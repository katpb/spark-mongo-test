/*
 * PopQualifierType.java
 *
 * Created on April 29, 2003, 5:40 PM
 */

package com.verifone.isd.vsms2.sales.ent.popdiscount;

/**
 * TO DO: Convert all the strings here to support i18n. Is some behavior
 * to be supported by providing methods in this class?
 * @author  Bhanu_N2
 */
public class PopQualifierType implements java.io.Serializable {
    static final long serialVersionUID = 5911607805048641466L;   
    private transient String name;
    
    /** Private constructor - do not allow subclassing
     * @param name transaction type's name
     */
    private PopQualifierType(String name) {
        this.name = name;
    }
    
//    protected abstract Object getProcessor();
    
    /**
     * Override toString() method to provide the transaction type's name
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

    /**
     * PLU based discount
     */    
    public static PopQualifierType PLU_BASED   = new PopQualifierType("PLU_BASED");
    /**
     * MOP based discount
     */    
    public static PopQualifierType MOP_BASED  = new PopQualifierType("MOP_BASED");
    /**
     * Card based discount
     */    
    public static PopQualifierType CARD_BASED = new PopQualifierType("CARD_BASED");
    /**
     * Transaction based discount
     */    
    public static PopQualifierType TXN_AMOUNT_BASED = new PopQualifierType("TXN_AMOUNT_BASED");
    /**
     * Department based discount
     */    
    public static PopQualifierType DEPARTMENT_BASED = new PopQualifierType("DEPARTMENT_BASED");
    /**
     * Membership based discount
     */    
    public static PopQualifierType MEMBERSHIP_BASED = new PopQualifierType("MEMBERSHIP_BASED");
  
    // The 4 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = ++nextOrdinal; //Discount type; auto-incremented; pre-incr to skip 0
    private static final PopQualifierType[] VALUES = {
        PLU_BASED, MOP_BASED, CARD_BASED, TXN_AMOUNT_BASED, DEPARTMENT_BASED, MEMBERSHIP_BASED
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
        return VALUES[ordinal-1]; // Canonicalize; -1 since ordinal is 1-based
    }   
    
    /** Getter for property ordinal.
     * @return Value of property ordinal.
     */
    public int getOrdinal() {
        return this.ordinal;
    }  
}
