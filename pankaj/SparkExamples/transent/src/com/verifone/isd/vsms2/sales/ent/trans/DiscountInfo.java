/*
 * DiscountInfo.java
 *
 * Created on December 13, 2003, 4:10 PM
 */

package com.verifone.isd.vsms2.sales.ent.trans;

import com.verifone.isd.vsms2.sys.util.MoneyAmount;
/**
 * Helper class to maintain discount details; to reduce explosion of classes,
 * this class provides id and name fields. These fields may not be available
 * for all discount types (e.g., % discount, fixed discount, promo etc)
 * @author  Bhanu_N2
 */
public class DiscountInfo implements java.io.Serializable {

    static final long serialVersionUID = 3355685660407295161L;
	protected static final MoneyAmount ZERO_AMOUNT = new MoneyAmount(0);

	/** Holds value of property discountType. */
    private DiscountMode discountType;
    
    /** Holds value of property discountAmount. */
    private MoneyAmount discountAmount;
    
    /** Holds value of property name. */
    private String name;

    /** Holds value of property reason. */
    private String reason;
    
    /** Holds value of property unitDiscount. */
    private MoneyAmount unitDiscount;
    
    //introduced for coupon entry method
    /** Holds value of property entryMethod. */
    private EntryMethod entryMethod;

    //introduced for coupon
    /** Holds value of property reducesTax. */
    private boolean reducesTax = true;

    //introduced for coupon data
    /** Holds value of property discountDetail. */
    private String discountDetail;

    /** Holds value of property duplicate */
    private boolean duplicate;
    
    /** Discount basis used by features */
    private DiscountBasis basis;
    
    // if discount evaluation is still pending
    private boolean evaluatePending;

    /** Creates a new instance of DiscountInfo */
    public DiscountInfo() {
    }
    
    public DiscountInfo(DiscountMode discountType, MoneyAmount amt, MoneyAmount unitDisc) {
        this.discountType = discountType;
        this.discountAmount = amt;
        this.unitDiscount = unitDisc;
    }  
    
    /** Creates a new instance of DiscountInfo */
    public DiscountInfo(DiscountMode discountType, MoneyAmount amt) {
        this.discountType = discountType;
        this.discountAmount = amt;
    }    
    /** Getter for property discountType.
     * @return Value of property discountType.
     */
    public DiscountMode getDiscountMode() {
        return this.discountType;
    }
    
    /** Setter for property discountType.
     * @param discountType New value of property discountType.
     */
    public void setDiscountMode(DiscountMode discountType) {
        this.discountType = discountType;
    }
    
    /** Getter for property discountAmount.
     * @return Value of property discountAmount.
     */
    public MoneyAmount getDiscountAmount() {
    	if (this.discountAmount == null) {
    		return ZERO_AMOUNT;
    	}
        return this.discountAmount;
    }
    
    /** Setter for property discountAmount.
     * @param discountAmount New value of property discountAmount.
     */
    public void setDiscountAmount(MoneyAmount discountAmount) {
        this.discountAmount = discountAmount;
    }
    
    /** Getter for property name. 
     * @return Value of property name. 
     */ 
    public String getName() { 
        if (name == null) { 
            return this.reason; 
        } 
        return this.name; 
    }
    
    /** Setter for property name.
     * @param name New value of property name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /** Getter for property name.
     * @return Value of property reason.
     */
    public String getReason() {
        return this.reason;
    }
    
    /** Setter for property name.
     * @param name New value of property reason.
     */
    public void setReason(String reason) {
        this.reason = reason;
    } 
    
    /** Getter for property unitDiscount. This field is applicable ONLY for discounts that are
     * applied on a per unit basis
     * @return Value of property unitDiscount.
     */
    public MoneyAmount getUnitDiscount() {
    	if (this.unitDiscount == null) {
    		return ZERO_AMOUNT;
    	}
        return this.unitDiscount;
    }
    
    /** Setter for property unitDiscount. This field is applicable ONLY for discounts that are
     * applied on a per unit basis
     * @param unitDiscount New value of property unitDiscount.
     */
    public void setUnitDiscount(MoneyAmount unitDiscount) {
        this.unitDiscount = unitDiscount;
    }
    
    /**
     * @return Returns the affectsTax.
     */
    public boolean isReducesTax() {
        return reducesTax;
    }
    /**
     * @param affectsTax The affectsTax to set.
     */
    public void setReducesTax(boolean reducesTax) {
        this.reducesTax = reducesTax;
    }
    /**
     * @return Returns the discountDetail.
     */
    public String getDiscountDetail() {
        return discountDetail;
    }
    /**
     * @param discountDetail The discountDetail to set.
     */
    public void setDiscountDetail(String discountDetail) {
        this.discountDetail = discountDetail;
    }
    /**
     * @return Returns the entryMethod.
     */
    public EntryMethod getEntryMethod() {
        return entryMethod;
    }
    /**
     * @param entryMethod The entryMethod to set.
     */
    public void setEntryMethod(EntryMethod entryMethod) {
        this.entryMethod = entryMethod;
    }
    
	public void deepCopy(DiscountInfo clone) {
        clone.discountType = this.discountType;
        try {
            if (this.discountAmount != null) {
                clone.discountAmount = (MoneyAmount)this.discountAmount.clone();
            }
            if (this.unitDiscount != null) {
                clone.unitDiscount = (MoneyAmount)this.unitDiscount.clone();
            }
			if (this.name != null) {
				clone.name = new String(this.name);
			}
			if (this.entryMethod != null) {
				clone.entryMethod = entryMethod;
			}
			
			clone.reducesTax = this.reducesTax;
			clone.duplicate = this.duplicate;
			clone.evaluatePending = this.evaluatePending;
			
			if (this.discountDetail != null) {
				clone.discountDetail = new String(this.discountDetail);
			}
			if (this.basis != null) {
				clone.basis = this.basis;
			}
        }
        catch (Exception e) {}
    }
    
    /**
     * Tests the duplicate attribute of this discountInfo. 
     * @return true if the discountInfo is marked as duplicate and false
     *         otherwise
     */
    public boolean isDuplicate() {
        return duplicate;
    }

    /**
     * Sets the duplicate attribute of this discountInfo.
     * @param duplicate true if salesengine should not re-calculate this
     *        discount;false otherwise
     */
    public void setDuplicate(boolean duplicate) {
        this.duplicate = duplicate;
    }

	/**
	 * @return the basis
	 */
	public DiscountBasis getDiscountBasis() {
		return basis;
	}

	/**
	 * @param basis the basis to set
	 */
	public void setDiscountBasis(DiscountBasis basis) {
		this.basis = basis;
	}

	public boolean isEvaluatePending() {
		return evaluatePending;
	}

	public void setEvaluatePending(boolean evaluatePending) {
		this.evaluatePending = evaluatePending;
	}
}
