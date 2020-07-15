/*
 * DiscountMode.java
 *
 * Created on April 29, 2003, 5:40 PM
 */

package com.verifone.isd.vsms2.sales.ent.trans;

/**
 * TO DO: Convert all the strings here to support i18n. Is some behavior to be
 * supported by providing methods in this class?
 * 
 * @author Bhanu_N2
 */
public class DiscountMode implements java.io.Serializable {
	static final long serialVersionUID = -2047486485832642382L;

	private transient String name;
	private transient boolean discIncludedInAmount;	/* discount reflected in line item amount */
    private transient boolean manualDiscountAllowed;
    private boolean priceOverrideAllowed = false; 

	/**
	 * Private constructor - do not allow subclassing
	 * 
	 * @param name
	 *            transaction type's name
	 */
    private DiscountMode(String name) {
        this(name, true);
    }

    /** Private constructor - do not allow subclassing
     * @param name transaction type's name
     * @param manDiscAllowed - true if manual discount can be applied on top of this discount
     *                         false otherwise
     */
    private DiscountMode(String name, boolean manDiscAllowed) {
	this(name, manDiscAllowed, false);
    }
    /** 
     * Builder method for DiscountMode
     * @param priceOverrideAllowed - true if price override can be applied on top of this discount
     *                         false otherwise
     * @return DiscountMode
     */
    public DiscountMode priceChangeAllowed(boolean priceOverrideAllowed){
    	this.priceOverrideAllowed = priceOverrideAllowed;
    	return this;
    }

    /** Private constructor - do not allow subclassing
     * @param name transaction type's name
     * @param manDiscAllowed - true if manual discount can be applied on top of this discount
     *                         false otherwise
     * @param discIncludedInAmount
     */
	public DiscountMode(String name, boolean manDiscAllowed, boolean discIncludedInAmount) {
            this.name = name;
            this.manualDiscountAllowed = manDiscAllowed;
            this.discIncludedInAmount = discIncludedInAmount;
	}

	// protected abstract Object getProcessor();

	/**
	 * Override toString() method to provide the transaction type's name
	 * 
	 * @return transaction type's name
	 */
	public String toString() {
		return this.name;
	}

	/**
	 * Not required since constructor is private. Just in case.. Prevent
	 * subclasses from overriding Object.hashCode() to ensure the following
	 * contract of typesafe enum: "All equal objects of the enumerated type are
	 * also identical i.e., a.equals(b) iff a==b". Thus, it is enough to do an
	 * == instead of the expensive Object.equals method
	 * 
	 * @return Value returned by super class's hashCode() method
	 */
	public final int hashCode() {
		return super.hashCode();
	}

	/**
	 * Not required since constructor is private. Just in case.. Prevent
	 * subclasses from overriding Object.equals to ensure the following contract
	 * of typesafe enum: "All equal objects of the enumerated type are also
	 * identical i.e., a.equals(b) iff a==b". Thus, it is enough to do an ==
	 * instead of the expensive Object.equals method
	 * 
	 * @param obj
	 *            Object to be compared for equality
	 * @return true if the compared instance satisfies == test
	 */
	public final boolean equals(Object obj) {
		return super.equals(obj);
	}

	public static DiscountMode FIXED_DISCOUNT = new DiscountMode(
			"FIXED_DISCOUNT");
	public static DiscountMode AMOUNT_DISCOUNT = new DiscountMode(
			"AMOUNT_DISCOUNT");
	public static DiscountMode PERCENT_DISCOUNT = new DiscountMode(
			"PERCENT_DISCOUNT");
	public static DiscountMode VFI_MATCH = new DiscountMode("VFI_MATCH");
	/**
	 * CR0992.02 - Now price override can be done for Promo applied items.
	 */
	public static DiscountMode AMOUNT_PROMO = new DiscountMode("AMOUNT_PROMO").priceChangeAllowed(true);
	public static DiscountMode PCT_PROMO = new DiscountMode("PCT_PROMO").priceChangeAllowed(true);
	public static DiscountMode AMOUNT_CWPROMO = new DiscountMode(
			"AMOUNT_CWPROMO");
	public static DiscountMode PCT_CWPROMO = new DiscountMode("PCT_CWPROMO");
	public static DiscountMode POP = new DiscountMode("POP", false, true);
	public static DiscountMode COUPON_DISCOUNT = new DiscountMode(
			"COUPON_DISCOUNT");
	public static DiscountMode REFER_DISCOUNT = new DiscountMode(
			"REFER_DISCOUNT");
	/**
	 * CR0992.02 - Now price override can be done for NAXML discounted items.
	 */
	public static DiscountMode NAX_COMBO = new DiscountMode("NAX_COMBO", false).priceChangeAllowed(true); 	
	public static DiscountMode NAX_MATCH = new DiscountMode("NAX_MATCH", false).priceChangeAllowed(true); 
	public static DiscountMode LOYALTY_AUTO = new DiscountMode("LOYALTY_AUTO");
	public static DiscountMode LOYALTY_CUSTOMER = new DiscountMode(
			"LOYALTY_CUSTOMER");
	public static DiscountMode LOYALTY_PPG_DISCOUNT = new DiscountMode(
			"LOYALTY_PPG_DISCOUNT", false, true);

	// The 4 declarations below are necessary for serialization
	private static int nextOrdinal = 0;
	private final int ordinal = nextOrdinal++; // Discount type;
												// auto-incremented
	private static final DiscountMode[] VALUES = { FIXED_DISCOUNT,
			AMOUNT_DISCOUNT, PERCENT_DISCOUNT, VFI_MATCH, AMOUNT_PROMO,
			PCT_PROMO, AMOUNT_CWPROMO, PCT_CWPROMO, POP, COUPON_DISCOUNT,
			REFER_DISCOUNT, NAX_COMBO, NAX_MATCH, LOYALTY_AUTO,
			LOYALTY_CUSTOMER, LOYALTY_PPG_DISCOUNT };

	/**
	 * Method to prevent duplicate constants from coexisting as a result of
	 * deserialization (ensures that only a single object represents each enum
	 * constant. This method is automatically invoked by the serialization
	 * mechanism. Without this method, Object.equals() method would be more
	 * involved and not a straightforward super.equals() which does just a ==
	 * check.
	 * 
	 * @throws java.io.ObjectStreamException
	 *             on serialization system issues
	 * @return the enum array
	 */
	Object readResolve() throws java.io.ObjectStreamException {
		return VALUES[ordinal]; // Canonicalize
	}

	/**
	 * Getter for property ordinal.
	 * 
	 * @return Value of property ordinal.
	 */
	public int getOrdinal() {
		return this.ordinal;
	}

    /**
     *
     * @return property manualDiscountAllowed
     */
    public boolean isManualDiscountAllowed() {
        return this.manualDiscountAllowed;
    }

	/**
	 * @return true if discounts are reflected in the amount on the item line
	 *         for the given DiscountMode. POP and Loyalty PPG discounts are
	 *         reflected in the amount on the item line
	 */
	public boolean isDiscIncludedInItemAmount() {
		return discIncludedInAmount;
	}
	/**
	 * Getter for property isPriceOverrideAllowed.
	 * 
	 * @return Value of property isPriceOverrideAllowed.
	 */
	public boolean isPriceOverrideAllowed() {
		return priceOverrideAllowed;
	}
	/**
    *
    * @return property priceOverrideAllowed
    */
	public void setPriceOverrideAllowed(boolean priceOverrideAllowed) {
		this.priceOverrideAllowed = priceOverrideAllowed;
	}
	
}
