package com.verifone.isd.vsms2.sales.ent.popdiscount;

import com.verifone.isd.vsms2.sales.ent.dept.DepartmentPK;
import com.verifone.isd.vsms2.sys.util.MemberCardType;
import com.verifone.isd.vsms2.sys.util.Quantity;
import com.verifone.isd.vsms2.sys.util.Volume;

/**
 * Entity for minimum department purchase based discount
 */
public class MinDeptPurchBasedDiscount implements IPopDiscountType
{
    static final long serialVersionUID = -9201302494180886985L;
    /**
     * Maximum minimum purchase amount
     */    
    public static final int MAX_PURCH_AMOUNT = 999;

    private DepartmentPK department;
    private Quantity minPurchase;
    private Volume fuelLimit;
    private MemberCardType memberCardRequired;
    
    /**
     * Constructor
     */    
    public MinDeptPurchBasedDiscount() {
    }

    /**
     * Setter for department number
     * @param department department number
     */    
    public void setDepartment(DepartmentPK department) {
        this.department = department;
    }
    
    /**
     * Getter for department number
     * @return department number
     */    
    public DepartmentPK getDepartment() {
        return this.department;
    }

    /**
     * Setter for minimum purchase amount
     * @param minPurchase minimum purchase amount
     */    
    public void setMinPurchase(Quantity minPurchase) {
        this.minPurchase = minPurchase;
    }
    
    /**
     * Getter for minimum purchase amount
     * @return minimum purchase amount
     */    
    public Quantity getMinPurchase() {
        return this.minPurchase;
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

    /** Validator for the entity attributes
     * @throws Exception if validation fails
     */    
    public void validate() throws Exception {
        if (!(department.isValid())) {
            throw new Exception("Invalid Department: " + department + " for POP Discount");
        }
        long amount = minPurchase.getLongValue();
        if ((amount < 0) || (amount > MinDeptPurchBasedDiscount.MAX_PURCH_AMOUNT)) {
            throw new Exception("Invalid Min. Purchase Amt: " + amount + " for POP Discount");
        }
    }
    
    /**
     * Getter to identify this discount type
     * @return Discount type
     */    
    public PopQualifierType getPopQualifierType() {
        return PopQualifierType.DEPARTMENT_BASED;
    }
    
	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sales.ent.popdiscount.IPopDiscountType#additionalCredentialRequired()
	 */
	public boolean additionalCredentialRequired() {
		return (memberCardRequired == MemberCardType.ANY_CARD);
	}
}