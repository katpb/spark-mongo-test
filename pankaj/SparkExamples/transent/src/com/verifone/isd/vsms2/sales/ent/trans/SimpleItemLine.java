package com.verifone.isd.vsms2.sales.ent.trans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.verifone.isd.vsms2.sales.ent.prodcode.NacsProdCodeConstants;
import com.verifone.isd.vsms2.sales.ent.prodcode.ProdCode;
import com.verifone.isd.vsms2.sales.ent.softkey.SoftKeyType;
import com.verifone.isd.vsms2.sales.ent.tax.Tax;
import com.verifone.isd.vsms2.sales.ent.tax.TaxPK;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import com.verifone.isd.vsms2.sys.util.Quantity;

/** Class to represent a simple item line in the transaction.
 * This is the base class and provides info that are generic 
 * to all item lines. This can be used as is for department
 * item. All other item (fuel and non-fuel) sales would
 * need a specific subclass.
 * Note that to reduce the object overhead involved, only the
 * primary key's raw form and any information required to reprint
 * are stored in this class. It is assumed that the corresponding
 * controller will query for those entities, if required.
 * @author Bhanu_N2
 */
public class SimpleItemLine implements ItemLine {
	private static final long serialVersionUID = -6998944025579255270L;
	protected static final MoneyAmount ZERO_AMOUNT = new MoneyAmount(0);
    protected static final Quantity ZERO_QTY = new Quantity(0, "");
	/** Holds value of property sellingBasePrice. */
	private MoneyAmount sellingBasePrice;

	/** Holds value of property amount. */
	private MoneyAmount amount;

	/** Hold the value paid by non tax coupon */
	private MoneyAmount nonTaxCouponPaidAmount;
	
	/** Hold the value paid by food stamp*/
	private MoneyAmount fsPaidAmount;
	
	protected Quantity quantity;

	private Quantity at4qty;

	/** Holds value of property categoryNum.  */
	private int categoryNum;

	/** Holds value of property description.  */
	private String description;

	/** Holds value of property prodCode.  */
	private ProdCode prodCode;

	/** Holds value of property taxIndicator.  */
	private String taxIndicator;

	/** Holds the collection of tax PKs applied to this item */
	private List<TaxPK>	taxpks;

	/** Holds value of property originalPrice. */
	private MoneyAmount originalPrice;

	/** Holds value of FoodStampable field from original entity object */
	private boolean foodStampable;

	/** Indicates item was sold with FS MOP */
	private boolean	allowFS;

	/** Indicates set of exempt taxes used to sell item */
	private TaxPK[] exemptTaxes;


	/** Indicates item was sold as money order */
	private boolean	moneyOrderSale;
	
	/** Indicates serial num prompt is required for the Item */
	private boolean	serialNumPromptReqd;

	/** Indicates item was sold as manual fuel department */
	private boolean	manualFuelSale;

	/** Indicates item was sold with PUMP TEST MOP */
	private boolean	pumpTestSale;

	/** Holds value of property taxableAmounts. */
	private Map<Integer, TaxableAmount> taxableAmounts;

	/** Holds value of property txnLineIndex. */
	private transient int txnLineIndex;

	/** Holds value of property voidedLineIndex. */
	private int voidedLineIndex;

	/** Holds value of property voidedItemLine. */
	private ItemLine voidedItemLine;

	/** Holds value of property taxReversed. */
	private boolean taxReversed;

	private Map<SoftKeyType, CashierID> overridenCashierIDMap;

	/** Holds value of property ageValidnRequired. */
	private boolean ageValidnRequired;
	
	/** indicates minimum age to purchase item */
	private int minimumAge;
	
	/** indicates latest birthday of customer to purchase item */
	private Date eligibleDOB;

	/** Holds value of property specialDiscEligible. */
	private boolean specialDiscEligible;

    /** Holds value of property manualDiscountProhibited. */
	private boolean manualDiscountProhibited;

	/** Holds value of property discountInfoList. */
	private List<DiscountInfo> discountInfoList;
	
	/** Holds value of property voided. */
	private boolean voided;


	/** Holds value of property svcActRecharge */
	private int svcActRecharge;

	/** Holds value of property svcActLines */
	private List<SvcActInfo> svcActLines;


	/** Holds value of property voidLine. */
	private boolean voidLine;

	/** Holds value of property moneyTransferInfo */
	private MoneyTransferInfo moneyTransferInfo;

	/** Holds value of property kitchenPrinterName */
	private String kitchenPrinterName = "";
	
    /** Holds value of property duplicate */
    private boolean duplicate;
	private boolean modificationAllowed = true;

	private List<FeeInfo> feeInfoList;
	
	private MoneyAmount basePriceBeforeIncTax;

	/** Holds the serial number entered for the Item*/
	private String serialNum;

	private boolean	featureValidationPromptSkipped;

	private boolean recalled;

    private transient int ocsItemCode = -1;
    
    /** Holds value of property tpppVoucherLines */
	private List<TpppVoucherInfo> tpppVoucherLines;
    
    private boolean tpppVoucherItem = false;
    
    private boolean stickyLabelNeeded = false;

    /**
	 * This parameter records the index of the item line
	 * to keep track of the order of items sent by external POS
	 * 
	 * The value will default to 0, when not used. 
	 * For normal usage(currently from the extPos component), the indices would start from 1
	 */
	private int externalItemID;
	private String categoryName;
	private DepartmentInfo deptInfo;

	private boolean restrictive;

	/** Creates a new instance of ItemLine */
	public SimpleItemLine() {
		this.feeInfoList = Collections.synchronizedList(new ArrayList<FeeInfo>());
		this.taxableAmounts = new HashMap<Integer, TaxableAmount>();
		this.discountInfoList = Collections.synchronizedList(new ArrayList<DiscountInfo>());
		this.taxpks = new ArrayList<TaxPK>(0);
		this.svcActLines = new ArrayList<SvcActInfo>();
		this.tpppVoucherLines = new ArrayList<TpppVoucherInfo>();
		this.overridenCashierIDMap = new HashMap<>();
	}

    @Override
	public void deepCopy(ItemLine param) {
		SimpleItemLine clone = (SimpleItemLine) param;
		clone.ageValidnRequired = this.ageValidnRequired;
		clone.minimumAge = this.minimumAge;
		clone.eligibleDOB = this.eligibleDOB;
		clone.allowFS = this.allowFS;
		clone.foodStampable = this.foodStampable;
		clone.manualFuelSale = this.manualFuelSale;
		clone.moneyOrderSale = this.moneyOrderSale;
		clone.serialNumPromptReqd = this.serialNumPromptReqd;
		clone.pumpTestSale = this.pumpTestSale;
		clone.specialDiscEligible = this.specialDiscEligible;
        clone.manualDiscountProhibited = this.manualDiscountProhibited;
		if (this.exemptTaxes != null) {
                    TaxPK[] clonedExemptTaxes = new TaxPK[this.exemptTaxes.length];
                    for (int i = 0; i < this.exemptTaxes.length; i++) {
                        clonedExemptTaxes[i] = new TaxPK(this.exemptTaxes[i].getValue());
                    }
                    clone.setExemptTaxes(clonedExemptTaxes);
		}

		clone.taxReversed = this.taxReversed;
		clone.voided = this.voided;
		clone.categoryNum = this.categoryNum;		
		clone.deptInfo = (DepartmentInfo) this.deptInfo.clone();
		clone.categoryName = this.categoryName;
		if(this.prodCode != null){
			clone.prodCode = new ProdCode();
			this.prodCode.setAttributes(clone.prodCode);
		}
		clone.txnLineIndex = this.txnLineIndex;
		clone.voidedLineIndex = this.voidedLineIndex;
		clone.voidedItemLine = this.voidedItemLine;
		clone.description = this.description;
		clone.taxIndicator = this.taxIndicator;
		clone.duplicate = this.duplicate;
		//TBD: Make changes to deep copy these 2 props		
		clone.overridenCashierIDMap.clear();
		clone.serialNum = this.serialNum;
		clone.featureValidationPromptSkipped = this.featureValidationPromptSkipped;
		clone.taxableAmounts.clear();
		clone.externalItemID = this.externalItemID;
		clone.ocsItemCode = ocsItemCode;
		clone.stickyLabelNeeded=this.stickyLabelNeeded;
		clone.restrictive = this.restrictive;

		for (final Map.Entry<SoftKeyType, CashierID> entry : this.overridenCashierIDMap.entrySet()) {
			CashierID cashierID = entry.getValue();
			if (cashierID != null) {
				clone.addOverrideCashierID(entry.getKey(), (CashierID) cashierID.clone());
			}
		}
        
		try {
			Set<Entry<Integer, TaxableAmount>> entrySet = taxableAmounts.entrySet();
			
			for( Entry<Integer, TaxableAmount> entry : entrySet){
				MoneyAmount amt = entry.getValue().getAmount();
				MoneyAmount cloneAmt = (MoneyAmount)amt.clone();
				clone.addTaxableAmount(entry.getKey(), new TaxableAmount(cloneAmt, entry.getValue().isExempt()));
			}
		}
		catch (Exception e) {}
		//End TBD

		/*- Subclasses MUST override deepCopy() and init this field first */

		if (0 == clone.discountInfoList.size()) {
			DiscountInfo[] discs = this.getAllDiscountInfo();

			for (int i = 0; i < discs.length; i++) {
				DiscountInfo clonedDisc = new DiscountInfo();

				discs[i].deepCopy(clonedDisc);
				clone.addDiscountInfo(clonedDisc);
			}
		}
		if (0 == clone.feeInfoList.size()) {
			FeeInfo[] fees = this.getAllFeeInfo();

			for (int i = 0; i < fees.length; i++) {
				FeeInfo clonedFee = new FeeInfo();

				fees[i].deepCopy(clonedFee);
				clone.addFeeInfo(clonedFee);
			}
		}
		clone.taxpks.clear();
		if (this.taxpks != null) {				// Transient field restored?
			clone.taxpks.addAll(this.taxpks);	// else clone has empty vector
		}
		try {
			clone.amount = (this.amount == null || this.amount == ZERO_AMOUNT) ?
					this.amount : (MoneyAmount)this.amount.clone();
			clone.originalPrice = (this.originalPrice == null || this.originalPrice == ZERO_AMOUNT) ?
					this.originalPrice : (MoneyAmount)this.originalPrice.clone();
			clone.sellingBasePrice = (this.sellingBasePrice == null ||
					this.sellingBasePrice == ZERO_AMOUNT) ? this.sellingBasePrice :
						(MoneyAmount)this.sellingBasePrice.clone();
			clone.quantity = (this.quantity == null || this.quantity == ZERO_QTY) ? this.quantity :
				(Quantity)this.quantity.clone();
			clone.at4qty = (this.at4qty == null || this.at4qty == ZERO_QTY) ? this.at4qty :
				(Quantity)this.at4qty.clone();
		}
		catch (Exception e) {}
	}

	/** Getter for property sellingBasePrice.
	 * @return Value of property sellingBasePrice.
	 */
    @Override
	public MoneyAmount getSellingBasePrice() {
		return (this.sellingBasePrice == null ? ZERO_AMOUNT
				: this.sellingBasePrice);
	}

	/** Setter for property sellingBasePrice.
	 * @param sellingBasePrice New value of property sellingBasePrice.
	 */
    @Override
	public void setSellingBasePrice(MoneyAmount sellingBasePrice) {
		this.sellingBasePrice = sellingBasePrice;
	}

	/** Getter for property amount.
	 * @return Value of property amount.
	 */
    @Override
	public MoneyAmount getAmount() {
		return (this.amount == null ? ZERO_AMOUNT : this.amount);
	}

	/** Setter for property amount.
	 * @param amount New value of property amount.
	 */
    @Override
	public void setAmount(MoneyAmount amount) {
		this.amount = amount;
	}

	/** Return Amount after all discounts
	 * @return after discount line item amount
	 */
    @Override
	public MoneyAmount getAmountAfterDiscounts() {
    	
		MoneyAmount amt = new MoneyAmount(0); 
		
		if(this.amount != null) {
			amt = (MoneyAmount)this.amount.clone();
		}

		/** Add all discounts except POP  **/
		DiscountInfo[] discArray = this.getAllDiscountInfo();
		if(discArray != null){
			for (int i = 0; i < discArray.length; ++i) {
				if (!discArray[i].getDiscountMode().isDiscIncludedInItemAmount()) {
					amt.add(discArray[i].getDiscountAmount());
				}
			}
		}

		return amt;
	}
    
    /**
     * Return due amount if partially paid by some MOP.
     * @return due amount
     */
    @Override
	public MoneyAmount getDueAmount(){
    	MoneyAmount amount = getAmountAfterDiscounts();
    	if(nonTaxCouponPaidAmount != null){
    		amount.sub(nonTaxCouponPaidAmount);
    	}
    	if(fsPaidAmount != null){
    		amount.sub(fsPaidAmount);
    	}
    	return amount;
    }

	@Override
	public MoneyAmount getNonTaxCouponPaidAmount() {
		return nonTaxCouponPaidAmount;
	}

	@Override
	public void setNonTaxCouponPaidAmount(MoneyAmount nonTaxPaidAmount) {
		this.nonTaxCouponPaidAmount = nonTaxPaidAmount;
	}

	@Override
	public MoneyAmount getFsPaidAmount() {
		return fsPaidAmount;
	}

	@Override
	public void setFsPaidAmount(MoneyAmount fsPaidAmount) {
		this.fsPaidAmount = fsPaidAmount;
	}
	
	/** Getter for property quantity.
	 * @return Value of property quantity.
	 */
    @Override
	public Quantity getQuantity() {
		return (this.quantity  == null ? ZERO_QTY : this.quantity);
	}

	/** Setter for property quantity.
	 * @param quantity New value of property quantity.
	 */
    @Override
	public void setQuantity(Quantity quantity) {
		this.quantity = quantity;
	}

	/** Getter for property at4qty.
	 * @return Value of property at4qty.
	 */
    @Override
	public Quantity getAt4Qty() {
		return (this.at4qty  == null ? ZERO_QTY : this.at4qty);
	}

	/** Setter for property at4qty.
	 * @param at4qty New value of property at4qty.
	 */
    @Override
	public void setAt4Qty(Quantity at4qty) {
		this.at4qty = at4qty;
	}

	/** Getter for property categoryNum.
	 * @return Value of property categoryNum.
	 */
    @Override
	public int getCategoryNum() {
		return this.categoryNum;
	}

	/** Getter for property description.
	 * @return Value of property description.
	 */
    @Override
	public String getDescription() {
		return this.description;
	}

	/** Getter for property prodCode.
	 * @return Value of property prodCode.
	 */
    @Override
	public ProdCode getProdCode() {
		return this.prodCode;
	}

	/** Getter for property taxIndicator.
	 * @return Value of property taxIndicator.
	 */
    @Override
	public String getTaxIndicator() {
		return (this.taxIndicator == null ? "" : this.taxIndicator);
	}

	/** Setter for property categoryNum.
	 * @param categoryNum New value of property categoryNum.
	 */
    @Override
	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}

	/** Setter for property description.
	 * @param description New value of property description.
	 */
    @Override
	public void setDescription(String description) {
		this.description = description;
	}

	/** Setter for property prodCode.
	 * @param prodCode New value of property prodCode.
	 */
    @Override
	public void setProdCode(ProdCode prodCode) {
		this.prodCode = prodCode;
	}

	/** Setter for property taxIndicator.
	 * @param taxIndicator New value of property taxIndicator.
	 */
    @Override
	public void setTaxIndicator(String taxIndicator) {
		this.taxIndicator = taxIndicator;
	}

	/** Getter for property originalPrice.
	 * @return Value of property originalPrice.
	 */
    @Override
	public MoneyAmount getOriginalPrice() {
		return (this.originalPrice == null ? this.getSellingBasePrice() :
			this.originalPrice);
	}

	/** Setter for property originalPrice.
	 * @param originalPrice New value of property originalPrice.
	 */
    @Override
	public void setOriginalPrice(MoneyAmount originalPrice) {
		this.originalPrice = originalPrice;
	}

	/** Getter for property foodStampable -- true if entity sells with fs
	 * @return Value of property foodStampable
	 */
    @Override
	public boolean isFoodStampable() {
		return this.foodStampable;
	}

	/** Setter for property foodStampable -- true if entity sells with fs
	 * @param foodStampable New value of property foodStampable
	 */
    @Override
	public void setFoodStampable(boolean foodStampable) {
		this.foodStampable = foodStampable;
	}

	/**
	 * Use this method to inform receiving systems that the item was sold with
	 * the specified taxes exempt, so the tax calculations, memo counts, etc can
	 * be updated.
	 * 
	 * @param taxes
	 */
    @Override
	public void setExemptTaxes(TaxPK[] taxes) {
		this.exemptTaxes = taxes;
	}

	/**
	 * Returns the set of exempt taxes on this item in sale.
	 *
	 * @return	TaxPK[]
	 */
    @Override
	public TaxPK[] getExemptTaxes() {
		return exemptTaxes;
	}

	/**
	 * If item was sold as Money Order, set this flag so receiving systems
	 * don't have to query db against dept key to figure it out.
	 *
	 * @param	moneyOrderSale
	 */

    @Override
	public void setSoldAsMoneyOrder(boolean moneyOrderSale) {
		this.moneyOrderSale = moneyOrderSale;
	}

	/**
	 * Receiving system can query this method rather than retrieve the
	 * defining entity from the primary key to see if this was a money
	 * order sale.
	 *
	 *
	 * @return	boolean
	 */

    @Override
	public boolean getSoldAsMoneyOrder() {
		return moneyOrderSale;
	}

	/**
	 * Manual fuel department sales should set this flag so the
	 * receiving system doesn't have to reconstitute the entity to
	 * see if a manual fuel sale was involved.
	 *
	 * @param	manualFuelSale
	 */

    @Override
	public void setSoldAsManualFuel(boolean manualFuelSale) {
		this.manualFuelSale = manualFuelSale;
	}

	/**
	 * Returns the status of manual fuel department flag
	 *
	 * @return	boolean
	 */

    @Override
	public boolean getSoldAsManualFuel() {
		return manualFuelSale;
	}

	/**
	 * Set this if a PumpTest MOP sale was involved.
	 *
	 * @param	pumpTestSale
	 */

    @Override
	public void setSoldAsPumpTest(boolean pumpTestSale) {
		this.pumpTestSale = pumpTestSale;
	}

	/**
	 * Receiving system can determine if the item was part of the Pump Test
	 * MOP without having to reconstitute the entity.
	 *
	 * @return	boolean
	 */

    @Override
	public boolean getSoldAsPumpTest() {
		return pumpTestSale;
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

    @Override
	public void acceptVisitor(TransactionVisitor v) throws Exception {
		v.visit(this);
	}

	/** Getter for property taxableAmounts for a given tax.
	 * taxNum the tax for which taxable value is requested
	 * *
	 * @param taxNum
	 * @return Value of property taxableAmounts for a given tax.
	 */
    @Override
	public TaxableAmount getTaxableAmount(int taxNum) {
		return (TaxableAmount) this.taxableAmounts.get(new Integer(taxNum));
	}

	/** Add taxable amount for a tax
	 *@param taxNum tax to be operated on
	 * @param taxable amount to be added
	 */
    @Override
	public void addTaxableAmount(int taxNum, TaxableAmount taxable) {
		Integer key = new Integer(taxNum);
		TaxableAmount curT = (TaxableAmount) this.taxableAmounts.get(key);
		if (curT == null) {
			this.taxableAmounts.put(key, taxable);
		}
		else {
			MoneyAmount amt = curT.getAmount();
			int numDecs = amt.getNumDecimals();
			this.taxableAmounts.put(key, new TaxableAmount(new MoneyAmount(amt.getLongValue()
					+ taxable.getAmount().getLongValue(), numDecs), taxable
					.isExempt(), taxable.isInclusive()));
		}
	}

	/** Remove taxable amount for a tax
	 * @param taxNum tax to be operated on
	 * @param taxable amount to be removed
	 */
    @Override
	public void removeTaxableAmount(int taxNum, TaxableAmount taxable) {
		Integer key = new Integer(taxNum);
		TaxableAmount curT = (TaxableAmount) this.taxableAmounts.get(key);
		if (curT != null) {
			MoneyAmount amt = curT.getAmount();
			int numDecs = amt.getNumDecimals();
			this.taxableAmounts.put(key, new TaxableAmount(new MoneyAmount(amt
					.getLongValue()
					- taxable.getAmount().getLongValue(), numDecs), curT
					.isExempt(), curT.isInclusive()));
		}
	}

	/** Getter for property txnLineIndex.
	 * @return Value of property txnLineIndex.
	 */
    @Override
	public int getTxnLineIndex() {
		return this.txnLineIndex;
	}

	/** Setter for property txnLineIndex.
	 * @param txnLineIndex New value of property txnLineIndex.
	 */
    @Override
	public void setTxnLineIndex(int txnLineIndex) {
		this.txnLineIndex = txnLineIndex;
	}

	/** Getter for property voidedLineIndex.
	 * @return Value of property voidedLineIndex.
	 */
    @Override
	public int getVoidedLineIndex() {
		return this.voidedLineIndex;
	}

	/** Setter for property voidedLineIndex.
	 * @param voidedLineIndex New value of property voidedLineIndex.
	 */
    @Override
	public void setVoidedLineIndex(int voidedLineIndex) {
		this.voidedLineIndex = voidedLineIndex;
	}

	/** Getter for property voidedItemLine.
	 * @return Value of property voidedItemLine.
	 */
    @Override
	public ItemLine getVoidedItemLine() {
		return this.voidedItemLine;
	}

	/** Setter for property voidedItemLine.
	 * @param voidedItemLine New value of property voidedItemLine.
	 */
    @Override
	public void setVoidedItemLine(ItemLine voidedItemLine) {
		this.voidedItemLine = voidedItemLine;
		if (voidedItemLine == null) {
			this.setVoidLine(false);
		}
		else {
			this.setVoidLine(true);
		}
	}

	/** Getter for property taxReversed.
	 * @return Value of property taxReversed.
	 */
    @Override
	public boolean isTaxReversed() {
		return this.taxReversed;
	}

	/** Setter for property taxReversed.
	 * @param taxReversed New value of property taxReversed.
	 */
    @Override
	public void setTaxReversed(boolean taxReversed) {
		this.taxReversed = taxReversed;
	}

	/** Add tax  NOTE: nothing prevents duplicate PK's.  The interface
	 * is just a convenience to pass tax info across components.  The
	 * components that create the ItemLine must enforce unique TaxPK entries.
	 * @param tax TaxPK to be applied to this department
	 */
    @Override
	public void addTaxPK(TaxPK tax) {
		if (null == this.taxpks) {
			this.taxpks = new ArrayList<TaxPK>(0);
		}
		this.taxpks.add(tax);
	}

	/** Remove tax
	 * @param tax tax be be removed from this department
	 */
    @Override
	public void removeTaxPK(TaxPK tax) {
		if (this.taxpks != null) {
			this.taxpks.remove(tax);
		}
	}

	/** Get all applicable taxes
	 * @return iterator of TaxPK objects assigned to this department
	 */
    @Override
	public Iterator<TaxPK> getTaxPKs() {
		if (null == this.taxpks) {
			this.taxpks = new ArrayList<TaxPK>(Tax.MAX_TAXES);
		}
		return this.taxpks.iterator();
	}


	/** Getter for property ageValidnRequired.
	 * @return Value of property ageValidnRequired.
	 */
    @Override
	public boolean isAgeValidnRequired() {
		return this.ageValidnRequired;
	}

	/** Setter for property ageValidnRequired.
	 * @param ageValidnRequired New value of property ageValidnRequired.
	 */
    @Override
	public void setAgeValidnRequired(boolean ageValidnRequired) {
		this.ageValidnRequired = ageValidnRequired;
	}

	/** Getter for property specialDiscEligible.
	 * @return Value of property specialDiscEligible.
	 */
    @Override
	public boolean isSpecialDiscEligible() {
		return this.specialDiscEligible;
	}

	/** Setter for property specialDiscEligible.
	 * @param specialDiscEligible New value of property specialDiscEligible.
	 */
    @Override
	public void setSpecialDiscEligible(boolean specialDiscEligible) {
		this.specialDiscEligible = specialDiscEligible;
	}

    /** Getter for property specialDiscEligible.
	 * @return Value of property manualDiscountProhibited.
	 */
    @Override
    public boolean isManualDiscountProhibited() {
        return this.manualDiscountProhibited;
    }

    /** Setter for property manualDiscountProhibited.
	 * @param manualDiscountProhibited New value of property manualDiscountProhibited.
	 */
    @Override
	public void setManualDiscountProhibited(boolean manualDiscountProhibited) {
        this.manualDiscountProhibited = manualDiscountProhibited;
    }

	/** Getter for property discountInfoList.
	 * @return Value of property discountInfoList.
	 */
    @Override
	public DiscountInfo[] getAllDiscountInfo() {
    	return discountInfoList.toArray(new DiscountInfo[0]);
	}

	/** Setter for property discountInfo.
	 * @param discountInfo New value of property discountInfo.
	 */
    @Override
	public void addDiscountInfo(DiscountInfo discountInfo) {
		this.discountInfoList.add(discountInfo);
	}
    
	/** Setter for property discountInfo.
	 * @param discountInfo New value of property discountInfo.
	 */
    @Override
	public void removeDiscountInfo(DiscountInfo discountInfo) {
		this.discountInfoList.remove(discountInfo);
	}

	/**
     *
     */
    @Override
    public void removeAllDiscountInfo() {
		this.discountInfoList.clear();
	}
    
	/** Get all discount total
	 * @return total discounts applied to this line item
	 */
    @Override
	public MoneyAmount getAllDiscountTotal() {

		MoneyAmount allDiscTot = new MoneyAmount(0);
		DiscountInfo[] discArray = this.getAllDiscountInfo();
		for (int i = 0; i < discArray.length; ++i) {
			/** For POP negate the amount **/
			if (discArray[i].getDiscountMode() == DiscountMode.POP) {
				allDiscTot.add(((MoneyAmount) discArray[i].getDiscountAmount().clone()).neg());
			} else{
				allDiscTot.add(discArray[i].getDiscountAmount());
			}
		}
		return allDiscTot;
	}
	
	/** Getter for property voided.
	 * @return Value of property voided.
	 *
	 */
    @Override
	public boolean isVoided() {
		return this.voided;
	}

	/** Setter for property voided.
	 * @param voided New value of property voided.
	 *
	 */
    @Override
	public void setVoided(boolean voided) {
		this.voided = voided;
	}


	/**
     *
     * @param type
     * @return
     */
    @Override
    public DiscountInfo getDiscountInfo(DiscountMode type) {
		int cnt = this.discountInfoList.size();
		DiscountInfo reqdInfo = null;
		for (int i = 0; i < cnt; i++) {
			DiscountInfo di = (DiscountInfo)this.discountInfoList.get(i);
			if (di.getDiscountMode() == type) {
				reqdInfo = di;
				break;
			}
		}
		return reqdInfo;
	}
    
    @Override
    public DiscountInfo getDiscountInfo(DiscountMode type, DiscountBasis basis) {
    	DiscountInfo reqdInfo = null;
    	for (DiscountInfo di : discountInfoList) {
    		if ((di != null) && (di.getDiscountMode() == type) && (di.getDiscountBasis() == basis)) {
    			reqdInfo = di;
    			break;
    		}
    	}
    	return reqdInfo;
    }

    @Override
	public void removeDiscountInfo(DiscountMode type) {
		int cnt = this.discountInfoList.size();
		for (int i = 0; i < cnt; i++) {
			DiscountInfo di = (DiscountInfo)this.discountInfoList.get(i);
			if (di.getDiscountMode() == type) {
				this.discountInfoList.remove(di);
				break;
			}
		}
	}
    
    @Override
    public void removeDiscountInfo(DiscountMode type, DiscountBasis basis) {
    	DiscountInfo reqdInfo = getDiscountInfo(type, basis);
    	if (reqdInfo != null) {
    		discountInfoList.remove(reqdInfo);
    	}
    }

    @Override
	public boolean isSvcItem() {
		boolean svc = false;

		if ((this.isSvcActivation()) || (this.isSvcRecharge()) || this.isEPSPrepaidItem()) {
			svc = true;
		}

		return svc;
	}

    @Override
	public boolean isSvcActivation() {
		if (this.svcActRecharge == SvcActInfo.SVC_ACTIVATION_ITEM) {
			return true;
		}
		else {
			return false;
		}
	}

    @Override
	public boolean isSvcRecharge() {
		if (this.svcActRecharge == SvcActInfo.SVC_RECHARGE_ITEM) {
			return true;
		}
		else {
			return false;
		}
	}

    @Override
	public int getSvcActRecharge() {
		return this.svcActRecharge;
	}

    @Override
	public void setSvcActRecharge(int svcActRecharge) {
		this.svcActRecharge = svcActRecharge;
	}

    @Override
	public void addSvcActInfo(SvcActInfo svcInfo) {
		this.svcActLines.add(svcInfo);
	}

    @Override
	public void removeSvcActInfo(SvcActInfo svcInfo) {
		this.svcActLines.remove(svcInfo);
	}

    @Override
	public int getSvcActCount() {
		return this.svcActLines.size();
	}

    @Override
	public Iterator<SvcActInfo> getSvcActLines() {
		return  this.svcActLines.iterator();
	}


	/** Getter for property voidLine.
	 * @return Value of property voidLine.
	 */
    @Override
	 public boolean isVoidLine() {
		return this.voidLine;
	}

	/** Setter for property voidLine.
	 * @param voidLine New value of property voidLine.
	 */
    @Override
	 public void setVoidLine(boolean voidLine) {
		this.voidLine = voidLine;
	}

	/**
	 * Setter for property moneyTransferInfo
	 * @param moneyTransferInfo  New value of property moneyTransferInfo
	 */
    @Override
	 public void setMoneyTransferInfo(MoneyTransferInfo moneyTransferInfo) {
		 this.moneyTransferInfo = moneyTransferInfo;
	 }

	 /**
	  * Getter for property moneyTransferInfo.
	  * @return Value of property moneyTransferInfo.
	  */
    @Override
	 public MoneyTransferInfo getMoneyTranferInfo() {
		 return this.moneyTransferInfo;
	 }

	 /** Getter for property kitchenPrinterName.
	  * @return Value of property kitchenPrinterName.
	  */    
    @Override
	 public String getKitchenPrinterName() {
		 return this.kitchenPrinterName;
	 }
    /**
     * Returns true if serial number prompt is
     * required for the Item, otherwise false
     */
    @Override
	public boolean isSerialNumPromptReqd() {
		return serialNumPromptReqd;
	}
    /**
     * sets the configuration for prompt for serial number.
     */
	@Override
	public void setSerialNumPromptReqd(boolean serialNumPromptReqd) {
		this.serialNumPromptReqd = serialNumPromptReqd;
	}
	 /**
	  * Setter for property kitchenPrinterName.
	  * @param kitchenPrinterName  New value of property kitchenPrinterName.
	  */
    @Override
	 public void setKitchenPrinterName(String kitchenPrinterName) {
		 this.kitchenPrinterName = kitchenPrinterName;
	 }

	/**
	 * Returns true if feature validation prompt is skipped or otherwise returns
	 * false
	 */
    @Override
	public boolean isFeatureValidationPromptSkipped() {
		return featureValidationPromptSkipped;
	}

    /**
     * sets if feature validation prompt is skipped 
     * @param featureValidationPromptSkipped
     */
	@Override
	public void setFeatureValidationPromptSkipped(boolean featureValidationPromptSkipped) {
		this.featureValidationPromptSkipped = featureValidationPromptSkipped;
	}

	/**
	  * This method will check the added item is an EPSPrepaid item or not.
	  * First it will check the EPSPrepaid product code match with item line and then with the department.
	  * @return isEPSPrepaidItem : Item is an EPSPrepaid product or not.
	  */
    @Override
	   public boolean isEPSPrepaidItem(){
		   boolean isEPSPrepaidItem = false;
		   int deptProductCode = getDepartmentProdCode();
		   
		   //Checking the item line's department product code has a match in EPSPrepaid product codes.
		   if(NacsProdCodeConstants.isEpsPrepaidDept(deptProductCode)){
			   isEPSPrepaidItem = true;
		   }
		   
		   return isEPSPrepaidItem;
	   }

    /**
	 * This method will identifies and return the product code associated with a department.
	 * @return Product code associated with the department.
	 */
		
    @Override
	public int getDepartmentProdCode(){
		  int deptProductCode = 0;
		  try{
			  if (deptInfo != null) {
				 deptProductCode = deptInfo.getDeptProductCode();
			  }
		  }catch(Exception e){
		  }
          
          return deptProductCode;
	 }
    @Override
	public ItemLine[] getSubItems() {
		 return (new SimpleItemLine[0]);
	 }

    /**
     * @return the duplicate
     */
    @Override
    public boolean isDuplicate() {
        return duplicate;
    }

    /**
     * @param duplicate the duplicate to set
     */
    @Override
    public void setDuplicate(boolean duplicate) {
        this.duplicate = duplicate;
    }
 
  /**
   * Method is to check whether the itemline in the receipt is can be modified or not.
   * @return: true if modification is allowed on this item, false otherwise.
   * @return 
   */	  
    @Override
	public boolean isModificationAllowed() {
		return modificationAllowed;
	}
   
	/**
	 * This method is used to indicate that the modification is allowed on this item.
         * 
         * @param modificationAllowed 
         */
    @Override
	public void setModificationAllowed(boolean modificationAllowed) {
		this.modificationAllowed = modificationAllowed;
        }
    
    /** Getter for property feeInfoList.
	 * @return Value of property feeInfoList.
	 */
	@Override
	public FeeInfo[] getAllFeeInfo() {
		return this.feeInfoList.toArray(new FeeInfo[0]);
	}
	
	/** Setter for property feeInfo.
	 * @param feeInfo New value of property feeInfo.
	 */
	@Override
	public void addFeeInfo(FeeInfo feeInfo) {
		this.feeInfoList.add(feeInfo);
	}
    /**
     * Retrieves the FeeInfo object from the collection of fees that are applicable for this item
     * @param feeSysId the feeSysId of the FeeInfo
     * @return FeeInfo
     */
	@Override
	public FeeInfo getFeeInfo(int feeSysId) {
		int cnt = this.feeInfoList.size();
		FeeInfo reqdInfo = null;
		for (int i = 0; i < cnt; i++) {
			FeeInfo fi = this.feeInfoList.get(i);
			if (fi.getFeeSysId() == feeSysId) {
				reqdInfo = fi;
				break;
			}
		}
		return reqdInfo;
	}
	
	/** Removes the specified fee from the collection of fees that are applicable for this item.
	 * @param feeInfo the FeeInfo object to be removed
     */
	@Override
	public void removeFeeInfo(FeeInfo feeInfo) {
		this.feeInfoList.remove(feeInfo);
	}
	
	/** Removes all the fees from the collection of fees that are applicable for this item.
     */
	@Override
	public void removeAllFeeInfo() {
		while( this.feeInfoList.size() > 0) {
			FeeInfo fi = this.feeInfoList.get(0);
			this.feeInfoList.remove(fi);
		}
	}
    /** Removes the fees on this item that corresponds to the feeSysId specified.
     * @param feeSysId the feeSysId of FeeInfo object 
	 */
	@Override
	public void removeFeeInfo(int feeSysId) {
		int cnt = this.feeInfoList.size();
		for (int i = 0; i < cnt; i++) {
			FeeInfo fi = this.feeInfoList.get(i);
			if (fi.getFeeSysId() == feeSysId) {
				this.feeInfoList.remove(fi);
				break;
			}
		}
	}
    /** Returns the total of all Fees that are applicable for this item.
	 * @return the total of all fees
     */
	@Override
	public MoneyAmount getAllFeeTotal() {
		MoneyAmount allFeeTot = new MoneyAmount(0);
		for(FeeInfo feeInfo : getAllFeeInfo()){
			allFeeTot.add(feeInfo.getFee());
		}
		return allFeeTot;
	}
	
	/** Returns the total of all food stampable Fees that are applicable for this item.
	 * @return the total of all food stampable fees
     */
	@Override
	public MoneyAmount getAllFoodStampableFeeTotal() {
		MoneyAmount allFeeTot = new MoneyAmount(0);
		for(FeeInfo feeInfo : getAllFeeInfo()){
			if(feeInfo.isFoodStampable()){
				allFeeTot.add(feeInfo.getFee());
			}
		}
		return allFeeTot;
	}
	
    /**
     * Removes all the fees existing and set the specified fees
     */
	@Override
	public void setFees(FeeInfo[] fees,boolean voided) {
		removeAllFeeInfo();
		if(!voided){
			this.feeInfoList = Collections.synchronizedList(Arrays.asList(fees));
		}else{
			for(int i=0;i<fees.length;i++){
				if(fees[i].getFee()!=null && fees[i].getFee().getLongValue()!=0){
					MoneyAmount amt = (MoneyAmount)(fees[i].getFee()).neg();
					fees[i].setFee(amt);
					this.feeInfoList.add(fees[i]);
				}
			}
		}
	}
	
	/**
	 * Checks whether the specified item line and item line in have same fees .
	 * 
	 * @param il
	 * @return
	 */
	
	@Override
	public boolean equalFeesInItemLine(ItemLine il){
		boolean result = true;
		FeeInfo[] feeInfo1 = this.getAllFeeInfo();
		if(feeInfo1.length != il.getAllFeeInfo().length){
			result = false;
			return result;
		}
		for(int i=0;i<feeInfo1.length;i++){
			FeeInfo fee = il.getFeeInfo(feeInfo1[i].getFeeSysId());
			if(fee == null){
				result = false;
				break;
			}
		}
		
		return result;
	}

    @Override
	public ItemLine createDeepCopy(){
    	ItemLine origLine = new SimpleItemLine();
    	((SimpleItemLine) this).deepCopy(origLine);
    	return origLine;
    }

	@Override
	public MoneyAmount getBasePriceBeforeIncTax() {
		return basePriceBeforeIncTax;
	}

	@Override
	public void setBasePriceBeforeIncTax(MoneyAmount basePriceBeforeIncTax) {
		this.basePriceBeforeIncTax = basePriceBeforeIncTax;
	}
	/**
	 * returns the serialNumber for the Item
	 */
	@Override
	public String getSerialNum() {
		return serialNum;
	}

	/**
	 * Sets the serialNumber for the Item
	 */
	@Override
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	/**
	 * Setter for recalled
	 * @return
	 */
	@Override
	public boolean isRecalled() {
		return recalled;
	}

	/**
	 * Getter for recalled.
	 * @param recalled
	 */
	@Override
	public void setRecalled(boolean recalled) {
		this.recalled = recalled;
	}

	public int getExternalItemID() {
		return externalItemID;
	}

	public void setExternalItemID(int externalItemID) {
		this.externalItemID = externalItemID;
	}

	@Override
	public boolean isDiscountModePresent(DiscountMode discountMode) {
		boolean discountModePresent = false;
		
		DiscountInfo[] discInfo = this.getAllDiscountInfo();
		
		if(discInfo != null){
			for(DiscountInfo discountInfo : discInfo){
				if (discountInfo.getDiscountMode() == discountMode) {
					discountModePresent = true;
					break;
				}
			}
		}
		return discountModePresent;
	}
	
    @Override
    public int getOCSItemCode()
    {
        return ocsItemCode;
    }

    @Override
    public void setOCSItemCode(int ocsItemCode)
    {
        if ((ocsItemCode >= 1) && (ocsItemCode <= 2000))
        {
            this.ocsItemCode = ocsItemCode;
        }
    }
    
    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        ocsItemCode = -1;
    }
    
    @Override
	public void setTpppVoucherItem(boolean tpppVoucherItem) {
    	this.tpppVoucherItem = tpppVoucherItem;
	}
    
    @Override
	public boolean isTpppVoucherItem() {
		return tpppVoucherItem;
	}
    
    @Override
	public void addTpppVoucherInfo(TpppVoucherInfo tpppVoucherInfo) {
		this.tpppVoucherLines.add(tpppVoucherInfo);
	}

    @Override
	public void removeTpppVoucherInfo(TpppVoucherInfo tpppVoucherInfo) {
		this.tpppVoucherLines.remove(tpppVoucherInfo);
	}
    
    @Override
	public int getTpppVoucherCount() {
		return this.tpppVoucherLines.size();
	}

    @Override
	public Iterator<TpppVoucherInfo> getTpppVoucherLines() {
		return  this.tpppVoucherLines.iterator();
	}

	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sales.ent.trans.ItemLine#getCategoryName()
	 */
	@Override
	public String getCategoryName() {
		return (this.categoryName != null ? this.categoryName : "");
	}

	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sales.ent.trans.ItemLine#setCategoryName(java.lang.String)
	 */
	@Override
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public DepartmentInfo getDepartmentInfo() {
		
		if (this.deptInfo == null) {
			this.deptInfo = new DepartmentInfo();		
		}
		return this.deptInfo;
	}


	@Override
	public void setDepartmentInfo(DepartmentInfo deptInfo) {
		this.deptInfo = deptInfo;
	}

	public int getMinimumAge() {
		return minimumAge;
	}

	public void setMinimumAge(int minimumAge) {
		this.minimumAge = minimumAge;
	}

	public Date getEligibleDOB() {
		return eligibleDOB;
	}

	public void setEligibleDOB(Date eligibleDOB) {
		this.eligibleDOB = eligibleDOB;
	}
	
	@Override
	public boolean isStickyLabelNeeded() {
		return stickyLabelNeeded;
	}
	
	@Override
	public void setStickyLabelNeeded(boolean stickyLabelNeeded) {
		this.stickyLabelNeeded = stickyLabelNeeded;
	}

	@Override
	public Map<SoftKeyType, CashierID> getOverrideCashierIDs() {
		return overridenCashierIDMap;
	}

	@Override
	public void addOverrideCashierID(SoftKeyType key, CashierID overrideCashierID) {
		this.overridenCashierIDMap.put(key, overrideCashierID);
	}

	/**
	 * 
	 * @return 
	 */
	@Override
	public boolean isRestrictiveItem() {
		return restrictive;
	}

	/**
	 * 
	 * @param restrictive 
	 */
	@Override
	public void setRestrictiveItem(boolean restrictive) {
		this.restrictive = restrictive;
	}
}
