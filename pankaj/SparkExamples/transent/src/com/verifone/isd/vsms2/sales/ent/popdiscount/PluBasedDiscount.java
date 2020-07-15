package com.verifone.isd.vsms2.sales.ent.popdiscount;

import com.verifone.isd.vsms2.sales.ent.plu.PluPK;
import com.verifone.isd.vsms2.sys.util.MemberCardType;
import com.verifone.isd.vsms2.sys.util.Volume;

/**
 * Entity for PLU based discount
 */
public class PluBasedDiscount implements IPopDiscountType
{    
    static final long serialVersionUID = 6424041775218042863L;
    
    private PluPK plu;
    private int pluQuantity;
    private Volume fuelLimit;
    private MemberCardType memberCardRequired;
    
    /**
     * No-args constructor
     */    
    public PluBasedDiscount() {
    }

    /**
     * Getter for PLU property
     * @return PLU
     */    
    public PluPK getPLU() {
        return plu;
    }
    
    /**
     * Setter for PLU property
     * @param plu PLU
     */    
    public void setPLU(PluPK plu) {
        this.plu = plu;
    }

    /**
     * Getter for pluQuantity
     * @return Minimum quantity qualifier for this PLU
     */    
    public int getPluQuantity() {
        return pluQuantity;
    }
        
    /**
     * Setter for pluQuantity
     * @param qty Minimum quantity qualifier for this PLU
     */    
    public void setPluQuantity(int qty) {
        this.pluQuantity = qty;
    }

    /**
     * Getter for fuel limit
     * @return fuel limit
     */    
    public Volume getFuelLimit() {
        return fuelLimit;
    }

    /**
     * Setter for fuel limit
     * @param fuelLimit fuel limit
     */    
    public void setFuelLimit(Volume fuelLimit) {
        this.fuelLimit = fuelLimit;
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

    /**
     * Validator for the entity attributes
     * @return True if valid
     */    
    public boolean isValid() {
        if ((this.plu != null) && (this.plu.isValid())) {
            return true;
        }
        return false;
    }

    /** Validator for the entity attributes
     * @throws Exception if validation fails
     */    
    public void validate() throws Exception {
        if (!this.isValid()) {
            throw new Exception("Invalid PLU for PluBasedDiscount: " +this.plu);
        }
    }
    
    /**
     * Getter to identify this discount type
     * @return Discount type
     */    
    public PopQualifierType getPopQualifierType() {
        return PopQualifierType.PLU_BASED;
    }    
    
	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sales.ent.popdiscount.IPopDiscountType#additionalCredentialRequired()
	 */
	public boolean additionalCredentialRequired() {
		return (memberCardRequired == MemberCardType.ANY_CARD);
	}
}