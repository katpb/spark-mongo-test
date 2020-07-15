/*
 * TaxLine.java
 *
 * Created on April 7, 2003, 2:54 PM
 */

package com.verifone.isd.vsms2.sales.ent.trans;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import com.verifone.isd.vsms2.sys.util.Quantity;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/** Class that holds information about a tax line in the transaction
 * @author Bhanu_N2
 */
public class TaxLine implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2790897027226862309L;

	/** Holds value of property taxable */
    private MoneyAmount taxable;
    
    /** Holds value of property totalTax. */
    private MoneyAmount totalTax;
    
    /** Holds value of property netTax. */
    private MoneyAmount netTax;
    
    /** Holds value of property negativeTaxable */
    private MoneyAmount negativeTaxable;
    
    /** Holds value of property totalNegativeTax. */
    private MoneyAmount totalNegativeTax;
    
    /** Holds value of property netNegativeTax. */
    private MoneyAmount netNegativeTax;
    
    /** Holds value of property netDiscTax. */
    private MoneyAmount netDiscTax;
    
    /** Holds value of property fsDiscTax. */
    private MoneyAmount fsDiscTax;
    
    /** Holds value of property fsAppliedAgainst. */
    private MoneyAmount fsAppliedAgainst;
    
    /** Holds value of property nonTaxCouponDiscTax. */
    private MoneyAmount nonTaxCouponDiscTax;
    
    /** Holds value of property fsAppliedAgainst. */
    private MoneyAmount nonTaxCouponDiscAppliedAgainst;
    
    /** Holds value of property description.  */
    private String description;
    
    /** Holds value of property indicator.  */
    private String indicator;
    
    /** Holds value of property taxNum.  */
    private int taxNum;
    
    /** Holds value of property taxRate.  */
    private Quantity taxRate;

    /** Holds value of property priceIncludesTax.  */
    private boolean priceIncludesTax;
    
    /** Holds value of property canadianGST.  */
    private boolean canadianGST;
    
    /** Holds value of property canadianGSTRegistrationNumber.  */
    private String canadianGSTRegistrationNumber;
    
    /** The tax exempt. */
    private MoneyAmount taxExempt;

    /** The tax exempt against. */
    private MoneyAmount taxExemptAgainst;
    
    /** Holds value of property taxableRebate */
    private MoneyAmount taxableRebateAmount;
    
    private Map<String, MoneyAmount> promoTaxRebateMap = new Hashtable<String, MoneyAmount>();

    /** Creates a new instance of TaxLine */
    public TaxLine() {
    }
    
    public MoneyAmount getTaxable() {
        return this.taxable;
    }
    
    public void setTaxable(MoneyAmount taxable) {
        this.taxable = taxable;
    }
    
    /** Getter for property totalTax.
     * @return Value of property totalTax.
     */
    public MoneyAmount getTotalTax() {
        return this.totalTax;
    }
    
    /** Setter for property totalTax.
     * @param totalTax New value of property totalTax.
     */
    public void setTotalTax(MoneyAmount totalTax) {
        this.totalTax = totalTax;
    }
    
    /** Getter for property netTax.
     * @return Value of property netTax.
     */
    public MoneyAmount getNetTax() {
        return this.netTax;
    }
    
    /** Setter for property netTax.
     * @param netTax New value of property netTax.
     */
    public void setNetTax(MoneyAmount netTax) {
        this.netTax = netTax;
    }
    
    public MoneyAmount getNegativeTaxable() {
        return this.negativeTaxable;
    }
    
    public void setNegativeTaxable(MoneyAmount negativeTaxable) {
        this.negativeTaxable = negativeTaxable;
    }
    
    /** Getter for property totalNegativeTax.
     * @return Value of property totalNegativeTax.
     */
    public MoneyAmount getTotalNegativeTax() {
        return this.totalNegativeTax;
    }
    
    /** Setter for property totalNegativeTax.
     * @param totalNegativeTax New value of property totalNegativeTax.
     */
    public void setTotalNegativeTax(MoneyAmount totalNegativeTax) {
        this.totalNegativeTax = totalNegativeTax;
    }
    
    /** Getter for property netNegativeTax.
     * @return Value of property netNegativeTax.
     */
    public MoneyAmount getNetNegativeTax() {
        return this.netNegativeTax;
    }
    
    /** Setter for property netNegativeTax.
     * @param netNegativeTax New value of property netNegativeTax.
     */
    public void setNetNegativeTax(MoneyAmount netNegativeTax) {
        this.netNegativeTax = netNegativeTax;
    }
    
    /** Getter for property netDiscTax.
     * @return Value of property netDiscTax.
     */
    public MoneyAmount getNetDiscTax() {
        return this.netDiscTax;
    }
    
    /** Setter for property netDiscTax.
     * @param netDiscTax New value of property netDiscTax.
     */
    public void setNetDiscTax(MoneyAmount netDiscTax) {
    	if(netDiscTax == null){
    		this.fsDiscTax = null;
    		this.nonTaxCouponDiscTax = null;
    	}
        this.netDiscTax = netDiscTax;
    }
    
    /** Getter for property fsDiscTax.
     * @return Value of property fsDiscTax.
     */
    public MoneyAmount getFsDiscTax() {
        return this.fsDiscTax;
    }
    
    /** Setter for property fsDiscTax.
     * @param fsDiscTax New value of property fsDiscTax.
     */
    public void setFsDiscTax(MoneyAmount fsDiscTax) {
    	this.fsDiscTax = fsDiscTax;
    	this.netDiscTax = new MoneyAmount(0);
    	
    	if(this.fsDiscTax != null){
    		this.netDiscTax.add(fsDiscTax);
    	}
    	if(this.nonTaxCouponDiscTax != null){
    		this.netDiscTax.add(nonTaxCouponDiscTax);
    	}
    }
    
    public MoneyAmount getFsAppliedAgainst() {
		return fsAppliedAgainst;
	}

	public void setFsAppliedAgainst(MoneyAmount fsAppliedAgainst) {
		this.fsAppliedAgainst = fsAppliedAgainst;
	}

	/** Getter for property nonTaxCouponDiscTax.
     * @return Value of property nonTaxCouponDiscTax.
     */
    public MoneyAmount getNonTaxCouponDiscTax() {
        return this.nonTaxCouponDiscTax;
    }
    
    /** Setter for property nonTaxCouponDiscTax.
     * @param nonTaxCouponDiscTax New value of property nonTaxCouponDiscTax.
     */
    public void setNonTaxCouponDiscTax(MoneyAmount nonTaxCouponDiscTax) {
        this.nonTaxCouponDiscTax = nonTaxCouponDiscTax;
        
        this.netDiscTax = new MoneyAmount(0);
    	
    	if(this.fsDiscTax != null){
    		this.netDiscTax.add(fsDiscTax);
    	}
    	
    	if(this.nonTaxCouponDiscTax != null){
    		this.netDiscTax.add(nonTaxCouponDiscTax);
    	}
    }
    
    public void setNonTaxCouponDiscAppliedAgainst(
			MoneyAmount nonTaxCouponDiscAppliedAgainst) {
		this.nonTaxCouponDiscAppliedAgainst = nonTaxCouponDiscAppliedAgainst;
	}

	public MoneyAmount getNonTaxCouponDiscAppliedAgainst() {
		return nonTaxCouponDiscAppliedAgainst;
	}

	public MoneyAmount getTaxableRebateAmount() {
		return taxableRebateAmount;
	}

	public void setTaxableRebateAmount(MoneyAmount taxableRebateAmount) {
		this.taxableRebateAmount = taxableRebateAmount;
	}
    
    void add(TaxLine newLine) {
        //Update the totals
        long curTot = (this.taxable == null) ? 0 : this.taxable.getLongValue();
        long newTot = (newLine.taxable == null) ? 0 : newLine.taxable.getLongValue();
        this.taxable = new MoneyAmount(curTot + newTot);
        
        curTot = (this.negativeTaxable == null) ? 0 : this.negativeTaxable.getLongValue();
        newTot = (newLine.negativeTaxable == null) ? 0 : newLine.negativeTaxable.getLongValue();
        this.negativeTaxable = new MoneyAmount(curTot + newTot);
        
        curTot = (this.totalTax == null) ? 0 : this.totalTax.getLongValue();
        newTot = (newLine.totalTax == null) ? 0 : newLine.totalTax.getLongValue();
        this.totalTax = new MoneyAmount(curTot + newTot);
        
        curTot = (this.totalNegativeTax == null) ? 0 : this.totalNegativeTax.getLongValue();
        newTot = (newLine.totalNegativeTax == null) ? 0 : newLine.totalNegativeTax.getLongValue();
        this.totalNegativeTax = new MoneyAmount(curTot + newTot);       
        
        curTot = (this.netTax == null) ? 0 : this.netTax.getLongValue();
        newTot = (newLine.netTax == null) ? 0 : newLine.netTax.getLongValue();
        this.netTax = new MoneyAmount(curTot + newTot);            
        
        curTot = (this.netNegativeTax == null) ? 0 : this.netNegativeTax.getLongValue();
        newTot = (newLine.netNegativeTax == null) ? 0 : newLine.netNegativeTax.getLongValue();
        this.netNegativeTax = new MoneyAmount(curTot + newTot);     

		curTot = (this.netDiscTax == null) ? 0 : this.netDiscTax.getLongValue();
		newTot = (newLine.netDiscTax == null) ? 0 : newLine.netDiscTax.getLongValue();
		this.netDiscTax = new MoneyAmount(curTot + newTot);
    }
    
    void remove(TaxLine newLine) {
        //Update the totals
        long curTot = (this.taxable == null) ? 0 : this.taxable.getLongValue();
        long newTot = (newLine.taxable == null) ? 0 : newLine.taxable.getLongValue();
        this.taxable = new MoneyAmount(curTot - newTot);
        
        curTot = (this.negativeTaxable == null) ? 0 : this.negativeTaxable.getLongValue();
        newTot = (newLine.negativeTaxable == null) ? 0 : newLine.negativeTaxable.getLongValue();
        this.negativeTaxable = new MoneyAmount(curTot - newTot); 
        
        curTot = (this.totalTax == null) ? 0 : this.totalTax.getLongValue();
        newTot = (newLine.totalTax == null) ? 0 : newLine.totalTax.getLongValue();
        this.totalTax = new MoneyAmount(curTot - newTot);
        
        curTot = (this.totalNegativeTax == null) ? 0 : this.totalNegativeTax.getLongValue();
        newTot = (newLine.totalNegativeTax == null) ? 0 : newLine.totalNegativeTax.getLongValue();
        this.totalNegativeTax = new MoneyAmount(curTot - newTot);       
        
        curTot = (this.netTax == null) ? 0 : this.netTax.getLongValue();
        newTot = (newLine.netTax == null) ? 0 : newLine.netTax.getLongValue();
        this.netTax = new MoneyAmount(curTot - newTot);            
        
        curTot = (this.netNegativeTax == null) ? 0 : this.netNegativeTax.getLongValue();
        newTot = (newLine.netNegativeTax == null) ? 0 : newLine.netNegativeTax.getLongValue();
        this.netNegativeTax = new MoneyAmount(curTot - newTot);            

		curTot = (this.netDiscTax == null) ? 0 : this.netDiscTax.getLongValue();
		newTot = (newLine.netDiscTax == null) ? 0 : newLine.netDiscTax.getLongValue();
		this.netDiscTax = new MoneyAmount(curTot - newTot);
    }
    
    boolean isEmpty() {
        boolean empty = true;
        long tot = (this.totalTax == null) ? 0 : this.totalTax.getLongValue();
        if (tot != 0) {
            empty = false;
        }
        else {
            tot = (this.totalNegativeTax == null) ? 0 : this.totalNegativeTax.getLongValue();   
            if (tot != 0) {
                empty = false;
            }
            else {
                tot = (this.netTax == null) ? 0 : this.netTax.getLongValue(); 
                if (tot != 0) {
                    empty = false;
                } 
                else {
                    tot = (this.netNegativeTax == null) ? 0 : this.netNegativeTax.getLongValue(); 
                    if (tot != 0) {
                        empty = false;
                    }                     
					else {
                    	tot = (this.netDiscTax == null) ? 0 : this.netDiscTax.getLongValue(); 
                    	if (tot != 0) {
                    	    empty = false;
                    	}                     
					}
                }
            }
        }
        return empty;
    }
    
    /** Getter for property description.
     * @return Value of property description.
     */
    public String getDescription() {
        return this.description;
    }
    
    /** Getter for property indicator.
     * @return Value of property indicator.
     */
    public String getIndicator() {
        return this.indicator;
    }
    
    /** Getter for property taxNum.
     * @return Value of property taxNum.
     */
    public int getTaxNum() {
        return this.taxNum;
    }
    
    /** Setter for property description.
     * @param description New value of property description.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /** Setter for property indicator.
     * @param indicator New value of property indicator.
     */
    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }
    
    /** Setter for property taxNum.
     * @param taxNum New value of property taxNum.
     */
    public void setTaxNum(int taxNum) {
        this.taxNum = taxNum;
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

	/**
	 * @return Returns the taxRate.
	 */
	public Quantity getTaxRate() {
		return taxRate;
	}

	/**
	 * @param taxRate The taxRate to set.
	 */
	public void setTaxRate(Quantity taxRate) {
		this.taxRate = taxRate;
	}

	/**
	 * @return Returns the priceIncludesTax.
	 */
	public boolean isPriceIncludesTax() {
		return priceIncludesTax;
	}
	
	/**
	 * @param priceIncludesTax The priceIncludesTax to set.
	 */
	public void setPriceIncludesTax(boolean priceIncludesTax) {
		this.priceIncludesTax = priceIncludesTax;
	}

	/**
	 * @return Returns the canadianGST.
	 */
	public boolean isCanadianGST() {
		return canadianGST;
	}

	/**
	 * @param canadianGST The canadianGST to set.
	 */
	public void setCanadianGST(boolean canadianGST) {
		this.canadianGST = canadianGST;
	}

	/**
	 * @return Returns the canadianGSTRegistrationNumber.
	 */
	public String getCanadianGSTRegistrationNumber() {
		return canadianGSTRegistrationNumber;
	}
	
	/**
	 * @param canadianGSTRegistrationNumber The canadianGSTRegistrationNumber to set.
	 */
	public void setCanadianGSTRegistrationNumber(String canadianGSTRegistrationNumber) {
		this.canadianGSTRegistrationNumber = canadianGSTRegistrationNumber;
	}
	
    /**
     * @return Returns the taxForgiven.
     */
    public MoneyAmount getTaxExempt() {
        return this.taxExempt;
    }
    /**
     * @param taxForgiven The taxForgiven to set.
     */
    public void setTaxExempt(MoneyAmount taxForgiven) {
        this.taxExempt = taxForgiven;
    }
    /**
     * @return Returns the taxForgivenAgainst.
     */
    public MoneyAmount getTaxExemptAgainst() {
        return this.taxExemptAgainst;
    }
    /**
     * @param taxForgivenAgainst The taxForgivenAgainst to set.
     */
    public void setTaxExemptAgainst(MoneyAmount taxForgivenAgainst) {
        this.taxExemptAgainst = taxForgivenAgainst;
    }
    public void setPromoTaxRebateMap(Map<String, MoneyAmount> promoTaxRebateMap){
    	this.promoTaxRebateMap = promoTaxRebateMap;
    }
    public void addPromoTaxableRebate(String promotionID, MoneyAmount taxableRebateAmount){
    	promoTaxRebateMap.put(promotionID, taxableRebateAmount);
    }
    
    public void removePromoTaxableRebate(String promotionID){
    	promoTaxRebateMap.remove(promotionID);
    }
    
    public MoneyAmount getPromoTaxableRebateAmount(String promotionID){
    	MoneyAmount taxableRebateAmount = null;
    	if(promoTaxRebateMap.get(promotionID) != null){
    		taxableRebateAmount = promoTaxRebateMap.get(promotionID);
    	}
    	return taxableRebateAmount;
    }
    
    public Set<String> getTaxableRebatePromoIDSet(){
    	return promoTaxRebateMap.keySet();
    }
    
    @Override
	public String toString() {
    	
    	return "TaxNum [" + taxNum + "," + description + "," +taxRate +  "] taxable [" + taxable +  "] totalTax [" + totalTax +"] netTax [" + netTax + "] priceIncludesTax [" 
    	+ priceIncludesTax + "] netDiscTax [" + netDiscTax +  "] taxableRebateAmount [" + taxableRebateAmount + "]";
    }

}
