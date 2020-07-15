/*
 * PrepayItemLine.java
 *
 * Created on September 7, 2003, 9:51 PM
 */

package com.verifone.isd.vsms2.sales.ent.trans;

import java.util.HashMap;

import com.verifone.isd.vsms2.fuel.ent.util.PpgDiscDetails;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import com.verifone.isd.vsms2.sys.util.Quantity;
import com.verifone.isd.vsms2.sys.util.Volume;

/**
 *
 * @author  BHANU NARAYANAN
 */
public class PrepayItemLine extends FuelItemLine {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4211617026561736090L;
	/** Holds value of property limit. */
    private Quantity limit;
    /** Holds details of finalized multi-grade PPG discounts after stacking */
    private PpgDiscDetails finalizedPpgDiscounts;
    
    /** Holds value of property loyaltyInfo.     */
    private LoyaltyInfo loyaltyInfo;    
    
    /** resolve volume limit */
    private boolean resolveVolumeLimit;
    
    /** Creates a new instance of PrepayItemLine */
    public PrepayItemLine() {
    }
    
    /** Getter for property limit.
     * @return Value of property limit.
     */
    public Quantity getLimit() {
        return this.limit;
    }
    
    /** Setter for property limit.
     * @param limit New value of property limit.
     */
    public void setLimit(Quantity limit) {
        this.limit = limit;
    }
    
    /**
     * Make operations across all entities in a transaction polymorphic with
     * the abstract visitor class -- all we do is call it's visit() method
     * and pass a reference to our actual type.  The visitor will have a
     * method with a signature that matches our type and automatically use it.
     * Different visitor implementations can be created any time to generate
     * new results against all the known entities in a transaction.
     *
     * <B>NOTE</B> that adding a new data type as an argument to the visit()
     * method means the abstract class (TransactionVisitor) and all the
     * visitor implementations must be updated.  We don't expect to be doing
     * this much.
     *
     * @param		v
    * @exception	Exception
     */
    public void acceptVisitor(TransactionVisitor v) throws Exception {
        v.visit(this);
    }  
    
    /** Getter for property popAlreadyApplied. This field does NOT apply for PrepayItemLine.
     * However, to avoid creating a new PostpayItemLine just for this one difference, it
     * is added to the base class.
     * @return Value of property popAlreadyApplied.
     */
    @Override
    public boolean isPopPpgApplied() {
        return false;
    }
    
    
    
    /* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sales.ent.trans.FuelItemLine#isPopPpgApplied(com.verifone.isd.vsms2.sales.ent.trans.DiscountBasis)
	 */
	@Override
	public boolean isPopPpgApplied(DiscountBasis discountBasis) {
		/*
		 * PPG discounts are not finalized for prepay item lines until after fueling
		 */
		return false;
	}

	/** Setter for property popAlreadyApplied. This field does NOT apply for PrepayItemLine.
     * However, to avoid creating a new PostpayItemLine just for this one difference, it
     * is added to the base class.
     * @param popAlreadyApplied New value of property popAlreadyApplied.
     */
    public void setPopAlreadyApplied(boolean popAlreadyApplied) {
    }    
    
    public void deepCopy(SimpleItemLine fclone) {
        PrepayItemLine clone = (PrepayItemLine) fclone;
        super.deepCopy(clone);
        try {
            clone.limit = (this.limit == null) ? this.limit : 
                (Quantity)this.limit.clone();             
        }
        catch (Exception e){}
    }
    
    /** Getter for property autoCollect. Always returns false.
     * @return Value of property autoCollect.
     *
     */
    public boolean isAutoCollect() {
        return false;
    }
    
    /** No-op method. Prepay and Autocollect are mutially exclusive.
     * @param autoCollect New value of property autoCollect.
     *
     */
    public void setAutoCollect(boolean autoCollect) {
    }

	/**
	 * @return the finalizedPpgDiscounts
	 */
	public PpgDiscDetails getFinalizedPpgDiscounts() {
		return finalizedPpgDiscounts;
	}

	/**
	 * @param finalizedPpgDiscounts the finalizedPpgDiscounts to set
	 */
	public void setFinalizedPpgDiscounts(PpgDiscDetails finalizedPpgDiscounts) {
		this.finalizedPpgDiscounts = finalizedPpgDiscounts;
	}

	/**
	 * Determine if PPG discount has been applied on the prepay item line
	 * 
	 * @return true if PPG discount has been applied
	 */
	public boolean isPpgDiscountApplied() {
		boolean ppg = false;
		if ((finalizedPpgDiscounts != null) && (finalizedPpgDiscounts.getNumDiscounts() > 0)) {
			ppg = true;
		}
		return ppg;
	}
	
	/**
	 * Set the finalized PPG discount for a specific grade
	 * 
	 * @param prodNum
	 * @param nacsCode
	 * @param unitDiscount
	 */
	public void setFinalizedGradeDiscount(int prodNum, int nacsCode, MoneyAmount unitDiscount) {
		if (finalizedPpgDiscounts == null) {
			finalizedPpgDiscounts = new PpgDiscDetails();
		}
		finalizedPpgDiscounts.addDiscForGrade(prodNum, nacsCode, unitDiscount);
	}
	
    public ItemLine createDeepCopy(){
    	ItemLine origLine = new PrepayItemLine();
    	((PrepayItemLine) this).deepCopy(origLine);
    	return origLine;
    }
    
	/**
	 * @return the resolveVolumeLimit
	 */
	public boolean isResolveVolumeLimit() {
		return resolveVolumeLimit;
	}

	/**
	 * @param resolveVolumeLimit the resolveVolumeLimit to set
	 */
	public void setResolveVolumeLimit(boolean resolveVolumeLimit) {
		this.resolveVolumeLimit = resolveVolumeLimit;
	}
}
