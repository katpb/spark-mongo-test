/*
 * FuelItemLine.java
 *
 * Created on April 30, 2003, 4:27 PM
 */

package com.verifone.isd.vsms2.sales.ent.trans;

import java.util.HashMap;
import java.util.Map;

import com.verifone.isd.vsms2.sales.ent.fiscalreceipt.FuelFlatTaxDetailConfig;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import com.verifone.isd.vsms2.sys.util.Quantity;
import java.util.List;
/**
 * Class to represent a fuel item line in the transaction.
 * @author  Bhanu_N2
 */
public class FuelItemLine extends SimpleItemLine {
	

	private static final long serialVersionUID = 2900431235787579787L;

	protected static final Quantity ZERO_VOLUME = new Quantity(0, 3, ""); 

    /** Holds the value of fuel name. */
    private String fuelName ;
    
    /** Holds value of property serviceLevelNum. */
    private int serviceLevelNum;
    
    /** Holds value of property serviceLevelName. */
    private String serviceLevelName;
    
    /** Holds value of property mopNum. */
    private int mopNum;
    
    /** Holds value of mopName */
    private String mopName;
    
    /** Holds value of property fuelProductNum. */
    private int fuelProductNum;
    
    /** Holds value of property fuelingPositionNum. */
    private int fuelingPositionNum;
    
    /** Holds value of property fuelDeposit. */
    private MoneyAmount fuelDeposit;
    
    /**
	 * Holds the value of fuel auth amount - only used for fast credit with
	 * merchandise completion
	 */
	private MoneyAmount fuelAuthAmount;
    
    /** Holds value of property fuelSequenceNum. */
    private long fuelSequenceNum;
    
    /** Holds value of property additionalDesc. */
    private String additionalDesc;
    
	/**
	 * Holds Discount basis as key and POP discount number as value
	 */
    private Map<DiscountBasis, Integer> popDiscountNumbers;
	/**
	 * Holds Discount basis as key and POP fuel definition as value
	 */
    private Map<DiscountBasis, Integer> popDiscountDefinitions;
    
    /** Holds value of property popMemberId. */
    private String popMemberId;

    /** Holds value of property popCodeRedeemed. */
    private boolean popCodeRedeemed;
    
    /** Holds value of property popDiscountDesc. */
    private String popDiscountDesc;
    
    /** Holds value of property autoCollect. */
    private boolean autoCollect;
    
    /** Holds value of property fuelUnsettled. */
    private boolean fuelUnsettled = true;
    
    /* Normally fuel totals are updated when sale is tendered */
    private boolean totalSettledWithTender = true;
    
    /** Holds value of property fuelTaxExemption. */
    private FuelTaxInfo fuelTaxExemption;
    
    /** Holds value of property fuelTaxAddition. */
    private FuelTaxInfo fuelTaxAddition;
    
    /** Holds value of property fuelTaxAddition. */
    private FuelTaxInfo fuelTaxAdditionByDept;   
    
    /** Holds value of originalTicketNum */
    private String originalTicketNum;    
    
    /** The naxml fuel grade id. */
    private String naxmlFuelGradeID;

    /** Determines if customer had an underrun transaction **/
    private boolean underrunCustomer = false;

    /** Holds value of property mopConvAdjustment. */
    private MoneyAmount mopConvAdjustment;
    
    /** Holds Fiscal Receipt flat tax details if assigned */
	private List<FuelFlatTaxDetailConfig> fuelFlatTaxDetailConfigs;
    
    private static enum FuelTransTypes{
    	PREPAY,POSTPAY,OVERRUN,DCR,UNDERRUN,COMPL;
    }
    
    /** Creates a new instance of FuelItemLine */
    public FuelItemLine() {
    	this.popDiscountNumbers = new HashMap<DiscountBasis, Integer>();
    	this.popDiscountDefinitions = new HashMap<DiscountBasis, Integer>();
    }
    
    /** Getter for property serviceLevelNum.
     * @return Value of property serviceLevelNum.
     */
    public int getServiceLevelNum() {
        return this.serviceLevelNum;
    }
    
    /** Setter for property serviceLevelNum.
     * @param serviceLevelNum New value of property serviceLevelNum.
     */
    public void setServiceLevelNum(int serviceLevelNum) {
        this.serviceLevelNum = serviceLevelNum;
    }
    
    /** Getter for property mopNum.
     * @return Value of property mopNum.
     */
    public int getMopNum() {
        return this.mopNum;
    }
    
    /** Setter for property mopNum.
     * @param mopNum New value of property mopNum.
     */
    public void setMopNum(int mopNum) {
        this.mopNum = mopNum;
    }
    
    /** Getter for property fuelProductNum.
     * @return Value of property fuelProductNum.
     */
    public int getFuelProductNum() {
        return this.fuelProductNum;
    }
    
    /** Setter for property fuelProductNum.
     * @param fuelProductNum New value of property fuelProductNum.
     */
    public void setFuelProductNum(int fuelProductNum) {
        this.fuelProductNum = fuelProductNum;
    }
    
    /** Getter for property fuelingPositionNum.
     * @return Value of property fuelingPositionNum.
     */
    public int getFuelingPositionNum() {
        return this.fuelingPositionNum;
    }
    
    /** Setter for property fuelingPositionNum.
     * @param fuelingPositionNum New value of property fuelingPositionNum.
     */
    public void setFuelingPositionNum(int fuelingPositionNum) {
        this.fuelingPositionNum = fuelingPositionNum;
    }
    
    /** Getter for property fuelDeposit.
     * @return Value of property fuelDeposit.
     */
    public MoneyAmount getFuelDeposit() {
        return (this.fuelDeposit == null ? ZERO_AMOUNT : this.fuelDeposit);
    }
    
    /** Setter for property fuelDeposit.
     * @param fuelDeposit New value of property fuelDeposit.
     */
    public void setFuelDeposit(MoneyAmount fuelDeposit) {
        this.fuelDeposit = fuelDeposit;
    }

	/**
	 * @return Returns the fuelAuthAmount.
	 */
	public MoneyAmount getFuelAuthAmount() {
		return (this.fuelAuthAmount == null ? ZERO_AMOUNT : this.fuelAuthAmount);
	}
	/**
	 * @param fuelAuthAmount The fuelAuthAmount to set.
	 */
	public void setFuelAuthAmount(MoneyAmount fuelAuthAmount) {
		this.fuelAuthAmount = fuelAuthAmount;
	}
    /** Getter for property fuelSequenceNum.
     * @return Value of property fuelSequenceNum.
     */
    public long getFuelSequenceNum() {
        return this.fuelSequenceNum;
    }
    
    /** Setter for property fuelSequenceNum.
     * @param fuelSequenceNum New value of property fuelSequenceNum.
     */
    public void setFuelSequenceNum(long fuelSequenceNum) {
        this.fuelSequenceNum = fuelSequenceNum;
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
     * @param		v the transactionVisitor object 
      * @exception	Exception
     */
    
    @Override
	public void acceptVisitor(TransactionVisitor v) throws Exception {
        v.visit(this);
    }
    
    /** Getter for property additionalDesc.
     * @return Value of property additionalDesc.
     */
    public String getAdditionalDesc() {
        return this.additionalDesc;
    }
    
    /** Setter for property additionalDesc.
     * @param additionalDesc New value of property additionalDesc.
     */
    public void setAdditionalDesc(String additionalDesc) {
        this.additionalDesc = additionalDesc;
    }
    
    public Map<DiscountBasis, Integer> getPopDiscountNumbers() {
    	return this.popDiscountNumbers;
    }
    
    public void setPopDiscountNum(DiscountBasis basis, int popDiscountNum) {
    	if (basis != null) {
    		this.popDiscountNumbers.put(basis, popDiscountNum);
    	}
    }
    
    public void clearPopDiscountNum(DiscountBasis basis) {
    	if (basis != null) {
    		this.popDiscountNumbers.remove(basis);
    	}
    }
    
	public int getPopDiscountNum(DiscountBasis basis) {
		int popDiscountNum = 0;
		if (basis != null) {
			Integer entry = this.popDiscountNumbers.get(basis);
			if (entry != null) {
				popDiscountNum = entry.intValue();
			}
		}
		return popDiscountNum;
	}
    
    public void setPopDiscountDef(DiscountBasis basis, int popDiscountDef) {
    	if (basis != null) {
    		this.popDiscountDefinitions.put(basis, popDiscountDef);
    	}
    }
    
    public void clearPopDiscountDef(DiscountBasis basis) {
    	if (basis != null) {
    		this.popDiscountDefinitions.remove(basis);
    	}
    }
    
    public int getPopDiscountDef(DiscountBasis basis) {
        int popDiscountDef = 0;
        if (basis != null) {
			Integer entry = this.popDiscountDefinitions.get(basis);
			if (entry != null) {
				popDiscountDef = entry.intValue();
			}
        }
        return popDiscountDef;
    }
    
    public Map<DiscountBasis, Integer> getPopDiscountDefinitions() {
    	return this.popDiscountDefinitions;
    }
    
    /** Getter for property popMemberId.
     * @return Value of property popMemberId.
     */
    public String getPopMemberId() {
        return this.popMemberId;
    }
    
    /** Setter for property popMemberId.
     * @param popMemberId New value of property popMemberId.
     */
    public void setPopMemberId(String popMemberId) {
        this.popMemberId = popMemberId;
    }
    
	/**
	 * Determine if POP discount was already applied as a PPG discount
	 * 
	 * @return true if POP PPG discount was applied durinr fuel prepay
	 */
	public boolean isPopPpgApplied() {
		return isPopPpgApplied(null);
	}  
	
	/**
	 * Determine if a specific kind of POP PPG discount was applied before
	 * fueling. This method is invoked only after fueling to determine if same
	 * kind of discount (item, payment, code or membership) can be applied on a
	 * post fueling basis. If no discount basis is provided, the method returns
	 * true for any kind of POP PPG discount that was applied on the fuel item
	 * line.
	 * 
	 * @param discountBasis
	 *            discount basis (item, payment, code or membership)
	 * @return true if POP PPG discount of same type was applied before fueling
	 */
	public boolean isPopPpgApplied(DiscountBasis discountBasis) {
		boolean popPpgApplied = false;
		if (fuelProductNum > 0) {
			for (DiscountInfo discount : getAllDiscountInfo()) {
				if ((discount != null)
						&& (discount.getDiscountMode() == DiscountMode.POP)
						&& (discount instanceof LoyaltyInfo)) {
					/*
					 * Presence of LoyaltyInfo object with discount mode POP
					 * indicates POP PPG discount was applied before fueling
					 */
					LoyaltyInfo loyaltyInfo = (LoyaltyInfo) discount;
					MoneyAmount amt = loyaltyInfo.getPpgDiscByGrade(fuelProductNum);
					if ((amt != null) && (amt.getLongValue() != 0)) {
						/*
						 * If a discount basis (item, payment, code or
						 * membership based) was provided, indicate if PPG
						 * discount of same kind was applied.
						 */
						if (discountBasis != null) {
							if (discountBasis == loyaltyInfo.getDiscountBasis()) {
								popPpgApplied = true;
							}
						} else {
							popPpgApplied = true;
						}
					}
				}
			}
		}
		
		return popPpgApplied;
	}
    
    /** Getter for property popCodeRedeemed.
     * @return Value of property popCodeRedeemed.
     *
     */
    public boolean isPopCodeRedeemed() {
        return this.popCodeRedeemed;
    }
    
    /** Setter for property popCodeRedeemed.
     * @param popCodeRedeemed New value of property popCodeRedeemed.
     *
     */
    public void setPopCodeRedeemed(boolean popCodeRedeemed) {
        this.popCodeRedeemed = popCodeRedeemed;
    }
    
    /** Getter for property popDiscountDesc.
     * @return Value of property popDiscountDesc.
     *
     */
    public String getPopDiscountDesc() {
        return this.popDiscountDesc;
    }
    
    /** Setter for property popDiscountDesc.
     * @param popDiscountDesc New value of property popDiscountDesc.
     *
     */
    public void setPopDiscountDesc(String popDiscountDesc) {
        this.popDiscountDesc = popDiscountDesc;
    }
    
    @Override
	public void deepCopy(ItemLine param) {
        FuelItemLine clone = (FuelItemLine) param;
        super.deepCopy(param);
        clone.serviceLevelNum = this.serviceLevelNum;
        clone.serviceLevelName = this.serviceLevelName;
        clone.mopNum = this.mopNum;
        clone.mopName = this.mopName;
        clone.fuelProductNum = this.fuelProductNum;
        clone.fuelingPositionNum = this.fuelingPositionNum;
        clone.fuelSequenceNum = this.fuelSequenceNum;
        clone.additionalDesc = this.additionalDesc;
        clone.popCodeRedeemed = this.popCodeRedeemed;
        clone.popDiscountDesc = this.popDiscountDesc;
        clone.popMemberId = this.popMemberId;
        clone.autoCollect = this.autoCollect;
        clone.fuelUnsettled = this.fuelUnsettled;
        clone.originalTicketNum = this.originalTicketNum;
        clone.naxmlFuelGradeID = this.naxmlFuelGradeID;
        clone.underrunCustomer = this.underrunCustomer;
        clone.totalSettledWithTender = this.totalSettledWithTender;
        try {
            clone.fuelDeposit = (this.fuelDeposit == null || 
            this.fuelDeposit == ZERO_AMOUNT) ? this.fuelDeposit 
            : (MoneyAmount)this.fuelDeposit.clone();
        }
        catch (Exception e) {
        }
        try {
			clone.fuelAuthAmount = (this.fuelAuthAmount == null || 
			this.fuelAuthAmount == ZERO_AMOUNT) ? this.fuelAuthAmount
			: (MoneyAmount) this.fuelAuthAmount.clone();
		} catch (Exception e) {
		}
		try {
			clone.mopConvAdjustment = (this.mopConvAdjustment == null || this.mopConvAdjustment == ZERO_AMOUNT) ? this.mopConvAdjustment
					: new MoneyAmount(this.mopConvAdjustment);
		} catch (Exception e) {
		}
        for (Map.Entry<DiscountBasis, Integer> entry : this.popDiscountDefinitions.entrySet()) {
        	clone.popDiscountDefinitions.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<DiscountBasis, Integer> entry : this.popDiscountNumbers.entrySet()) {
        	clone.popDiscountNumbers.put(entry.getKey(), entry.getValue());
        }
    }
    
    /** Getter for property autoCollect.
     * @return Value of property autoCollect.
     *
     */
    public boolean isAutoCollect() {
        return this.autoCollect;
    }
    
    /** Setter for property autoCollect.
     * @param autoCollect New value of property autoCollect.
     *
     */
    public void setAutoCollect(boolean autoCollect) {
        this.autoCollect = autoCollect;
    }
    
    /**
     * Getter for property fuelUnsettled
     * @return		Returns the tled.
     */
    public boolean isFuelUnsettled() {
    	return this.fuelUnsettled;
    }
    
    /**
     * Setter for property fuelFuelUnsettled.
     * @param		fuelUnsettled a boolean true for Unsettled, false for Settled
     */
    public void setFuelUnsettled(boolean fuelUnsettled) {
    	this.fuelUnsettled = fuelUnsettled;
    }
    
    /**
     * @return Returns the fuelTaxAddition.
     */
    public FuelTaxInfo getFuelTaxAddition() {
        return this.fuelTaxAddition;
    }
    /**
     * @param fuelTaxAddition The fuelTaxAddition to set.
     */
    public void setFuelTaxAddition(FuelTaxInfo fuelTaxAddition) {
        this.fuelTaxAddition = fuelTaxAddition;
    }
    /**
     * @return Returns the fuelTaxExemption.
     */
    public FuelTaxInfo getFuelTaxExemption() {
        return this.fuelTaxExemption;
    }
    /**
     * @param fuelTaxExemption The fuelTaxExemption to set.
     */
    public void setFuelTaxExemption(FuelTaxInfo fuelTaxExemption) {
        this.fuelTaxExemption = fuelTaxExemption;
    }
    
    /**
     * @return Returns the fuelTaxAdditionByDept.
     */
    public FuelTaxInfo getFuelTaxAdditionByDept() {
        return this.fuelTaxAdditionByDept;
    }
    /**
     * @param fuelTaxAdditionByDept The fuelTaxAdditionByDept to set.
     */
    public void setFuelTaxAdditionByDept(FuelTaxInfo fuelTaxAdditionByDept) {
        this.fuelTaxAdditionByDept = fuelTaxAdditionByDept;
    }
    
    /**
     * @return the fuelName
     */
    public String getFuelName() {
        return this.fuelName;
    }

    /**
     * @param fuelName the fuelName to set
     */
    public void setFuelName(String fuelName) {
        this.fuelName = fuelName;
    }

	/**
	 * @return the originalTicketNum
	 */
	public String getOriginalTicketNum() {
		return this.originalTicketNum;
	}

	/**
	 * @param originalTicketNum the originalTicketNum to set
	 */
	public void setOriginalTicketNum(String originalTicketNum) {
		this.originalTicketNum = originalTicketNum;
	}

	/**
	 * Gets the naxml fuel grade id.
	 * 
	 * @return the naxmlFuelGradeID
	 */
	public String getNaxmlFuelGradeID() {
		return this.naxmlFuelGradeID;
	}

	/**
	 * Sets the naxml fuel grade id.
	 * 
	 * @param naxmlFuelGradeID
	 *            the naxmlFuelGradeID to set
	 */
	public void setNaxmlFuelGradeID(String naxmlFuelGradeID) {
		this.naxmlFuelGradeID = naxmlFuelGradeID;
	}
	
	@Override
	public Quantity getQuantity(){
		return (this.quantity == null ? ZERO_VOLUME : quantity);
	}
	
    public ItemLine createDeepCopy(){
    	ItemLine origLine = new FuelItemLine();
    	((FuelItemLine) this).deepCopy(origLine);
    	return origLine;
    }

    public boolean isUnderrunCustomer() {
        return underrunCustomer;
    }

    public void setUnderrunCustomer(boolean underrunCustomer) {
        this.underrunCustomer = underrunCustomer;
    }
    
    public boolean isTotalSettledWithTender() {
		return totalSettledWithTender;
    }
    
	public void setTotalSettledWithTender(boolean totalSettledWithTender) {
		this.totalSettledWithTender = totalSettledWithTender;
	}
    
    public MoneyAmount getMopConvAdjustment() {
		return (this.mopConvAdjustment == null ? ZERO_AMOUNT : mopConvAdjustment);
	}
	
	public void setMopConvAdjustment(MoneyAmount mopConvAdjustment) {
		this.mopConvAdjustment = mopConvAdjustment;
	}

	public String getServiceLevelName() {
		return serviceLevelName;
	}

	public void setServiceLevelName(String serviceLevelName) {
		this.serviceLevelName = serviceLevelName;
	}

	public String getMopName() {
		return mopName;
	}

	public void setMopName(String mopName) {
		this.mopName = mopName;
	}

	public List<FuelFlatTaxDetailConfig> getFuelFlatTaxDetailConfigs() {
		return fuelFlatTaxDetailConfigs;
	}

	public void setFuelFlatTaxDetailConfigs(List<FuelFlatTaxDetailConfig> fuelFlatTaxDetailConfigs) {
		this.fuelFlatTaxDetailConfigs = fuelFlatTaxDetailConfigs;
	}

	/**
	 * Overriding SimpleItemLine's originalPrice to return selling base price
	 * when original price is zero.
	 */
    @Override
	public MoneyAmount getOriginalPrice() {
		return (super.getOriginalPrice().compareWithZero() == 0 ? this.getSellingBasePrice() :
			super.getOriginalPrice());
	}

	/**
     * Returns the additional info that specifies the 
     * the type of fuel sale 
     * 
     * @param isOutDoor
     * @return PREPAY,POSTPAY,OVERRUN,UNDERRUN,COMPL
     */
    public String getAddInfoForFuelSales(boolean isOutDoor) {
    	FuelTransTypes addInfo;
    	if(this instanceof PrepayItemLine){
    		addInfo = FuelTransTypes.PREPAY;
    	}else if (this instanceof OverrunItemLine){
    		addInfo = FuelTransTypes.OVERRUN;
    	}else if(isOutDoor && (this.getFuelDeposit().compare(new MoneyAmount(0))==0) ){
    		addInfo = FuelTransTypes.DCR;
    	}else if(!isOutDoor && this.getAmount().compare(this.getFuelDeposit())<0){
    		addInfo = FuelTransTypes.UNDERRUN;
    	}else if((this.getFuelDeposit().compare(new MoneyAmount(0))>0) && 
    			(this.getAmount().compare(this.getFuelDeposit())<=0 )){
    		addInfo = FuelTransTypes.COMPL;
    	}else{
    		addInfo = FuelTransTypes.POSTPAY;
    	}
    	
    	return addInfo.toString();
    }
}
