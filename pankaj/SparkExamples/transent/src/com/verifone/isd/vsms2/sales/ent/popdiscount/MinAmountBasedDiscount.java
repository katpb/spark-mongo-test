package com.verifone.isd.vsms2.sales.ent.popdiscount;

import com.verifone.isd.vsms2.sys.util.MemberCardType;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/**
 * Entity for minimum amount based discount
 */
public class MinAmountBasedDiscount implements IPopDiscountType
{
    static final long serialVersionUID = 7812971240056691062L;
    /**
     * Maximum minimum purchase amount
     */    
    public static final int MAX_PURCH_AMOUNT = 999;

    private MoneyAmount amount;
    private MemberCardType memberCardRequired;
    
    /**
     * Constructor
     */    
    public MinAmountBasedDiscount() {
    }

    /**
     * Setter for amount property
     * @param amount Minimum amount qualifier
     */    
    public void setAmount(MoneyAmount amount) {
        this.amount = amount;
    }
    
    /**
     * Getter for amount property
     * @return Minimum amount
     */    
    public MoneyAmount getAmount() {
        if (this.amount == null) {
            this.amount = new MoneyAmount(0);
        }
        return this.amount;
    }

    /**
     * Getter for memberCardRequired property
     * @return If true, a membership card is required
     */    
    public MemberCardType getMemberCardRequired() {
        return this.memberCardRequired;
    }

    /**
     * Setter for memberCardRequired property
     * @param memberCardRequired If true, a membership card is required
     */    
    public void setMemberCardRequired(MemberCardType memberCardRequired) {
        this.memberCardRequired = memberCardRequired;
    }

    /** Validator for the entity attributes
     * @throws Exception if validation fails
     */    
    public void validate() throws Exception {
        long amt = amount.getLongValue();
        if ((amt < 0) || (amt > MinAmountBasedDiscount.MAX_PURCH_AMOUNT)) {
            throw new Exception("Invalid Min. Purchase Amt: " + amt + " for POP Discount");
        }
    }
    
    /**
     * Getter to identify this discount type
     * @return Discount type
     */    
    public PopQualifierType getPopQualifierType() {
        return PopQualifierType.TXN_AMOUNT_BASED;
    }
    
	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sales.ent.popdiscount.IPopDiscountType#additionalCredentialRequired()
	 */
	public boolean additionalCredentialRequired() {
		return (memberCardRequired == MemberCardType.ANY_CARD);
	}
}