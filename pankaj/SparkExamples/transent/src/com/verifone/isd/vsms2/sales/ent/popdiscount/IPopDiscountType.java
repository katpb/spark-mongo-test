package com.verifone.isd.vsms2.sales.ent.popdiscount;

/**
 *  Interface to be implemented by Pop Discount Types
 *
 *  @author "mailto:mike_reese@verifone.com"
 *  @version 1.0 Copyright(c) 2003 VeriFone, Inc., All Rights Reserved
 */
public interface IPopDiscountType extends java.io.Serializable {
    /** Validator for the entity attributes
     * @throws Exception if validation fails
     */    
    public void validate() throws Exception;
    /**
     * Getter to identify this discount type
     * @return Discount type
     */    
    public PopQualifierType getPopQualifierType();
    /**
	 * Indicate if additional credential (e.g. POP member ID) is required to
	 * qualify for this POP discount.
	 * 
	 * @return true if additional credentials required to qualify for this POP
	 *         criteria
	 */
    public boolean additionalCredentialRequired();
}