package com.verifone.isd.vsms2.sales.ent.popdiscount;

import com.verifone.isd.vsms2.sales.ent.mop.MopPK;
import com.verifone.isd.vsms2.sys.util.MemberCardType;

/**
 * Entity for MOP based discount
 */
public class MopBasedDiscount implements IPopDiscountType
{
    static final long serialVersionUID = -693988186510302783L;;
    private MopPK mop;
    private MemberCardType memberCardRequired;
    
    /**
     * No-args constructor
     * @throws Exception if failure creating object
     */    
    public MopBasedDiscount() throws Exception {
    }

    /**
     * Setter for MOP property
     * @param mop method of payment
     */    
    public void setMOP(MopPK mop) {
        this.mop = mop;
    }
    
    /**
     * Getter for MOP property
     * @return method of payment
     */    
    public MopPK getMOP() {
        return this.mop;
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
        if (!(mop.isValid())) {
            throw new Exception("Invalid MOP: " + mop + " for POP Discount");
        }
    }
    
    /**
     * Getter to identify this discount type
     * @return Discount type
     */    
    public PopQualifierType getPopQualifierType() {
        return PopQualifierType.MOP_BASED;
    }    
    
	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sales.ent.popdiscount.IPopDiscountType#additionalCredentialRequired()
	 */
	public boolean additionalCredentialRequired() {
		return (memberCardRequired == MemberCardType.ANY_CARD);
	}
}