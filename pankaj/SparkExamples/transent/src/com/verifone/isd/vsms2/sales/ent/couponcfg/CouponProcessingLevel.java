/**
 * 
 */
package com.verifone.isd.vsms2.sales.ent.couponcfg;


/**
 * The CouponProcessingLevel class provides an enumeration of the various
 * processing levels for scanned coupons in a Topaz\Sapphire environment.
 * 
 * @author Sudesh_s1
 * 
 */
public class CouponProcessingLevel {

    private static final long serialVersionUID = -6443962828042704928L;

    private transient String name;

    protected CouponProcessingLevel(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    /**
     * Prevent subclasses from overriding Object.hashCode() to ensure the
     * following contract of typesafe enum: "All equal objects of the enumerated
     * type are also identical i.e., a.equals(b) iff a==b". Thus, it is enough
     * to do an == instead of the expensive Object.equals method
     * @return Value returned by super class's hashCode() method
     */
    public final int hashCode() {
        return super.hashCode();
    }

    /**
     * Prevent subclasses from overriding Object.equals to ensure the following
     * contract of typesafe enum: "All equal objects of the enumerated type are
     * also identical i.e., a.equals(b) iff a==b". Thus, it is enough to do an
     * == instead of the expensive Object.equals method
     * @param obj Object to be compared for equality
     * @return true if the compared instance satisfies == test
     */
    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static CouponProcessingLevel NOT_SUPPORTED = new CouponProcessingLevel(
            "Not Supported");
    public static CouponProcessingLevel TRANSACTION = new CouponProcessingLevel(
            "Transaction");

    // The 4 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++;
    private static final CouponProcessingLevel[] VALUES = { NOT_SUPPORTED,
            TRANSACTION};

    /**
     * Method to prevent duplicate constants from coexisting as a result of
     * deserialization (ensures that only a single object represents each enum
     * constant. This method is automatically invoked by the serialization
     * mechanism. Without this method, Object.equals() method would be more
     * involved and not a straightforward super.equals() which does just a ==
     * check.
     * @throws java.io.ObjectStreamException on serialization system issues
     * @return the enum array
     */
    Object readResolve() throws java.io.ObjectStreamException {
        return VALUES[ordinal]; // Canonicalize
    }

    /**
     * Getter for property ordinal. Used to get the gempro's #define value
     * @return Value of property ordinal.
     */
    public int getOrdinal() {
        return this.ordinal;
    }

    /**
     * Method to get the NWPromptStateConstants object for a specified ordinal.
     * Used to get the object given a gempro's #define value
     * @param ordinal the #define value represented by the object
     * @return NWPromptStateConstants object representing the ordinal
     */
    public static final CouponProcessingLevel getObject(int ordinal) {
        return VALUES[ordinal];
    }

    /**
     * Getter for all the NWPromptStateConstants objects
     * @return array of NWPromptStateConstantss
     */
    public static final CouponProcessingLevel[] getObjects() {
        CouponProcessingLevel[] codes = new CouponProcessingLevel[VALUES.length];
        System.arraycopy(VALUES, 0, codes, 0, VALUES.length);
        return codes;
    }
    
    public static final CouponProcessingLevel getObjectFromStr(String str) {
        CouponProcessingLevel level = CouponProcessingLevel.NOT_SUPPORTED;
        for(int i=0; i < VALUES.length; i++) {
            if(VALUES[i].getName().equalsIgnoreCase(str)) {
                level = VALUES[i];
                break;
            }
        }
        return level;
    }
}
