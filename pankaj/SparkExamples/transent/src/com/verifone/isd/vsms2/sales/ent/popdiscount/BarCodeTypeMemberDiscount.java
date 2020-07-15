package com.verifone.isd.vsms2.sales.ent.popdiscount;


/**
 * Entity for bar code type membership discounts
 */
public class BarCodeTypeMemberDiscount implements IPopDiscountType
{
    static final long serialVersionUID = -5704529439915398236L;
    private String mask;
    private boolean isAllowManualEntry;

    /**
     * No-args constructor
     */    
    public BarCodeTypeMemberDiscount() {
    }

    /**
     * Setter for mask property
     * @param mask Digits that will start or end each Membership
     * Card (example:123********* or *********123 for UPCs)
     */    
    public void setMask(String mask) {
        this.mask = mask;
    }

    /**
     * Getter for mask property
     * @return Mask for the membership card account
     */    
    public String getMask() {
        return this.mask;
    }

    /**
     * Setter for allowManualEntry property
     * @param isAllowManualEntry If true, allow the cashier to manually enter the card number
     */    
    public void setAllowManualEntry(boolean isAllowManualEntry) {
        this.isAllowManualEntry = isAllowManualEntry;
    }
    
    /**
     * Getter for allowManualEntry property
     * @return If true, allow the cashier to manually enter the card number
     */    
    public boolean isAllowManualEntry() {
        return this.isAllowManualEntry;
    }

    /**
     * Stub function
     */    
    public void validate() {
    }
    
    /**
     * Getter to identify this discount type
     * @return Discount type
     */    
    public PopQualifierType getPopQualifierType() {
        return PopQualifierType.MEMBERSHIP_BASED;
    }    
    
	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sales.ent.popdiscount.IPopDiscountType#additionalCredentialRequired()
	 */
	public boolean additionalCredentialRequired() {
		return false;
	}
}