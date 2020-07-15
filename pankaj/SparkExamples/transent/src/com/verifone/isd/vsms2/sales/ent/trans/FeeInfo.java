package com.verifone.isd.vsms2.sales.ent.trans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.verifone.isd.vsms2.sales.ent.prodcode.ProdCodePK;
import com.verifone.isd.vsms2.sales.ent.tax.TaxPK;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
/**
 * Helper class to maintain Fee related info.
 * 
 * @author SarathK1
 *
 */
public class FeeInfo implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -422426983918725541L;
	/** Holds value of Fee value */
	private MoneyAmount fee;
	/** Holds value of Fee sys Id */
	private int feeSysId;
	/** Holds value of Fee Name */
	private String feeName;
	/** Holds value of Fee Department sys Id */
	private int depNbr;
	/** Holds value of Fee type. It depends on its Department whether its positive or negative*/
	private boolean isNegativeFee = false;
	/** Holds value of Fee Category Nbr*/
	private int categoryNbr;
	/** Holds value of Fee Identifier*/
	private String feeIdentifier;
	/** Is food stample fee*/
	private boolean foodStampable;
	/** Taxes on Fee*/
	private List<TaxPK>	taxpks;
	/** baseFeeAmount */
	private MoneyAmount baseFeeAmount;
	/** Hold the value paid by non tax coupon */
	private MoneyAmount nonTaxCouponPaidAmount;
	/** Hold the value paid by food stamp*/
	private MoneyAmount fsPaidAmount;
	/** Hold the value of Per Unit Fee*/
	private MoneyAmount perUnitFeeAmount;
	
	private String categoryName;
	private ProdCodePK feeDepartmentProdCodePK;
	private String deptName;
	
	/** Creates the new Instance of FeeInfo*/
	public FeeInfo(){
		taxpks = new ArrayList<TaxPK>();
	}
	
	public FeeInfo(MoneyAmount fee, int feeNbr,String feeName, int depNbr,int categoryNbr,boolean negative){
		this.fee = fee;
		this.feeName = feeName;
		this.feeSysId = feeNbr;
		this.depNbr = depNbr;
		this.categoryNbr = categoryNbr;
		this.isNegativeFee = negative;
		this.taxpks = new ArrayList<TaxPK>();
	}
	/**
	 * Getter for fee value
	 * @return fee
	 */
	public MoneyAmount getFee() {
		return fee;
	}
	/**
	 * Setter for Fee value
	 * @param fee
	 */
	public void setFee(MoneyAmount fee) {
		this.fee = fee;
	}
	/**
	 * Getter for Fee Department Nbr
	 * @return
	 */
	public int getDepNbr() {
		return depNbr;
	}
	/**
	 * Setter for fee Department Nbr
	 * @param depNbr
	 */
	public void setDepNbr(int depNbr) {
		this.depNbr = depNbr;
	}
	/**
	 * Getter for Fee Category Nbr
	 * @return
	 */
	public int getCategoryNbr() {
		return categoryNbr;
	}
	/**
	 * setter for Fee Category Nbr
	 * @param categoryNbr
	 */
	public void setCategoryNbr(int categoryNbr) {
		this.categoryNbr = categoryNbr;
	}
	
	public void deepCopy(FeeInfo clone) {
        try {
            if (this.fee != null) {
                clone.fee = (MoneyAmount)this.fee.clone();
            }
            if (this.feeSysId > 0) {
                clone.feeSysId = this.feeSysId;
            }
			if (this.depNbr > 0 ) {
				clone.depNbr = this.depNbr;
			}
			if (this.categoryNbr > 0) {
				clone.categoryNbr = this.categoryNbr;
			}
			clone.foodStampable = this.foodStampable;
                        clone.isNegativeFee = this.isNegativeFee;
			clone.taxpks.clear();
			if (this.taxpks != null) {
				clone.taxpks.addAll(this.taxpks);
			}
			if(this.perUnitFeeAmount != null){
				clone.perUnitFeeAmount = new MoneyAmount(this.perUnitFeeAmount);
			}
			if(this.feeDepartmentProdCodePK != null){
				clone.feeDepartmentProdCodePK = new ProdCodePK(this.feeDepartmentProdCodePK.getValue());
			}
			
			if (this.categoryName != null) {
				clone.categoryName = this.categoryName;				
			}
			if (this.deptName != null) {
				clone.deptName = this.deptName;				
			}
        }
        catch (Exception e) {}
    }
	/**
	 * Getter for Fee sys Id
	 * @return
	 */
	public int getFeeSysId() {
		return feeSysId;
	}
	/**
	 * Setter for Fee sys Id
	 * @param feeSysId
	 */
	public void setFeeSysId(int feeSysId) {
		this.feeSysId = feeSysId;
	}

	public String getFeeName() {
		return feeName;
	}

	public void setFeeName(String feeName) {
		this.feeName = feeName;
	}
	/**
	 * returns if fee is negative or not. It depends on whether Department is positive or not.
	 * @return
	 */
	public boolean isNegativeFee() {
		return isNegativeFee;
	}
	/**
	 * sets whether fee is negative or not. It depends on whether Department is positive or not.
	 * @param isNegativeFee
	 */
	public void setNegativeFee(boolean isNegativeFee) {
		this.isNegativeFee = isNegativeFee;
	}

	public String getFeeIdentifier() {
		return feeIdentifier;
	}

	public void setFeeIdentifier(String feeIdentifier) {
		this.feeIdentifier = feeIdentifier;
	}

	public boolean isFoodStampable() {
		return foodStampable;
	}

	public void setFoodStampable(boolean foodStampable) {
		this.foodStampable = foodStampable;
	}
	
	/** Add tax
     * @param tax TaxPK to be applied to this department
     */    
    public void addTax(TaxPK tax) {
        this.taxpks.add(tax);
    }
    
    /** Add tax
     * @param tax TaxPK to be applied to this department
     */    
    public void addAllTax(Iterator<TaxPK> taxIter) {
    	while(taxIter.hasNext()){
    		this.taxpks.add(taxIter.next());
    	}
    }
    
    /** Remove tax
     * @param tax tax be be removed from this department
     */    
    public void removeTax(TaxPK tax) {
        this.taxpks.remove(tax);
    }
    
    /** Get all applicable taxes
     * @return iterator of TaxPK objects assigned to this department
     */    
    public Iterator<TaxPK> getTaxes() {
        return this.taxpks.iterator();
    }

	public MoneyAmount getBaseFeeAmount() {
		return baseFeeAmount;
	}

	public void setBaseFeeAmount(MoneyAmount baseFeeAmount) {
		this.baseFeeAmount = baseFeeAmount;
	}
	
	/**
     * Return due amount if partially paid by some MOP.
     * @return due amount
     */
    public MoneyAmount getDueAmount(){
    	MoneyAmount amount = (MoneyAmount) fee.clone();
    	if(nonTaxCouponPaidAmount != null){
    		amount.sub(nonTaxCouponPaidAmount);
    	}
    	if(fsPaidAmount != null){
    		amount.sub(fsPaidAmount);
    	}
    	return amount;
    }

	public MoneyAmount getNonTaxCouponPaidAmount() {
		return nonTaxCouponPaidAmount;
	}

	public void setNonTaxCouponPaidAmount(MoneyAmount nonTaxPaidAmount) {
		this.nonTaxCouponPaidAmount = nonTaxPaidAmount;
	}

	public MoneyAmount getFsPaidAmount() {
		return fsPaidAmount;
	}

	public void setFsPaidAmount(MoneyAmount fsPaidAmount) {
		this.fsPaidAmount = fsPaidAmount;
	}

	public MoneyAmount getPerUnitFeeAmount() {
		return perUnitFeeAmount;
	}

	public void setPerUnitFeeAmount(MoneyAmount perUnitFeeAmount) {
		this.perUnitFeeAmount = perUnitFeeAmount;
	}

	public ProdCodePK getFeeDepartmentProdCodePK() {
		return feeDepartmentProdCodePK;
	}

	public void setFeeDepartmentProdCodePK(ProdCodePK feeDepartmentProdCodePK) {
		this.feeDepartmentProdCodePK = feeDepartmentProdCodePK;
	}
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
