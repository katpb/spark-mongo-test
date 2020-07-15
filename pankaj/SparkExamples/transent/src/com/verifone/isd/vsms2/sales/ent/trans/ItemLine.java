package com.verifone.isd.vsms2.sales.ent.trans;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import com.verifone.isd.vsms2.sales.ent.prodcode.ProdCode;
import com.verifone.isd.vsms2.sales.ent.softkey.SoftKeyType;
import com.verifone.isd.vsms2.sales.ent.tax.TaxPK;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import com.verifone.isd.vsms2.sys.util.Quantity;

/**
 * Represents an item line in the transaction. This interface provides
 * information that is generic to all item lines. An ItemLine is created for
 * every item that is sold as part of a transaction and also when an item is
 * voided.
 * <p>
 * Notes 1. To reduce the object overhead involved, only the primary key's raw
 * form and any information required to reprint are stored in this class. It is
 * assumed that the corresponding controller will query for those entities, if
 * required.
 * </p>
 * <p>
 * 2. The setter methods on this interface just set the corresponding instance
 * variables in the implementation class. It is the responsibility of the
 * invoking class to perform any computations that are required.
 * </p>
 */
public interface ItemLine extends java.io.Serializable {
  
    static final int MAX_FEES = 5;
    
    /** 
     * Gets the selling base price of this item.
     * @return the current selling base price
     */
    public MoneyAmount getSellingBasePrice();
    
    /** Sets the selling base price of this item.
     * @param sellingBasePrice the new selling base price
     */
    public void setSellingBasePrice(MoneyAmount sellingBasePrice);
    
    /**
     * Gets the amount of this item. The returned value excludes Fee(s) and/or
     * Discounts associated to this item.
     * @return the current amount
     */
    public MoneyAmount getAmount();
    
    /** Sets the amount of this item.
     * @param amount the new amount
     */
    public void setAmount(MoneyAmount amount);
    
    /**
     * Getter method of nonTaxPaidAmount
     * @return
     */
    public MoneyAmount getNonTaxCouponPaidAmount();

    /**
     * Set amount paid by food stamp or non tax coupon
     * @param nonTaxPaidAmount
     */
	public void setNonTaxCouponPaidAmount(MoneyAmount nonTaxPaidAmount);
	
	/**
     * Getter method of nonTaxPaidAmount
     * @return
     */
    public MoneyAmount getFsPaidAmount();

    /**
     * Set amount paid by food stamp or non tax coupon
     * @param nonTaxPaidAmount
     */
	public void setFsPaidAmount(MoneyAmount nonTaxPaidAmount);
	
    /** 
     * Gets the amount of this item after discounts.
     * @return the amount of this item after discounts
     */
    public MoneyAmount getAmountAfterDiscounts();
    
    /**
     * Return due amount if partially paid by some MOP.
     * @return due amount
     */
    public MoneyAmount getDueAmount();
    
    /** 
     * Gets the quantity of this item that was sold.
     * @return the current quantity of this item that was sold
     */
    public Quantity getQuantity();
    
    /** Sets the quantity of this item that was sold.
     * @param quantity the new quantity.
     */
    public void setQuantity(Quantity quantity);

    /**
     * Gets the quantity for which this item is priced using At-For Pricing
     * method.
     * @return the quantity for which this item is priced
	 */
	public Quantity getAt4Qty();
    
    /** Sets the At-For pricing quantity of this item.
     * @param at4qty  the new quantity.
	 */
	public void setAt4Qty(Quantity at4qty);

	/** 
     * Gets the Category number of this item.
     * @return the Category number
     */
    public int getCategoryNum();
    
    /**
     * Gets the description of this item.
     * @return the description
     */
    public String getDescription();
   
	/** 
     * Gets the Product Code of this item.
     * @return the ProdCode entity
     */
    public ProdCode getProdCode();
    
    /**
     * Sets the serial number entered for an Item
     * @param serialNum
     */
    public void setSerialNum(String serialNum);
    
    /**
     * Returns the serial number entered for the Item
     * @return
     */
    public String getSerialNum();
    
    /**
     * Gets the string that indicates the Taxes that are applicable for this
     * item. Each character in this String represents an individual Tax.
     * @return the taxIndicator string.
     */
    public String getTaxIndicator();
    
    /** Sets the Category number of this item.
     * @param categoryNum the new category number
     */
    public void setCategoryNum(int categoryNum);
    
    /** Sets the description of this item.
     * @param description the new description
     */
    public void setDescription(String description);
    
    /** Sets the Product Code of this item.
     * @param prodCode the new Product Code
     */
    public void setProdCode(ProdCode prodCode);
    
    /** Sets the taxIndicator string for this item.
     * @param taxIndicator the new taxIndicator string.
     */
    public void setTaxIndicator(String taxIndicator);
    
    
    /** Gets the original price of this item.
     * @return the current original price.
     */
    public MoneyAmount getOriginalPrice();
    
    /** Sets the original price of this item.
     * @param originalPrice the new original price
     */
    public void setOriginalPrice(MoneyAmount originalPrice);

	/** 
	 * Tests the foodStampable attribute of this item.
	 * @return true if the item is foodStamp eligible and false otherwise
	 */
	public boolean isFoodStampable();

	/** Sets the foodStampable attribute of this item.
	 * @param foodStampable true item is foodStamp eligible;false item is foodStamp ineligible
	 */
	public void setFoodStampable(boolean foodStampable);

	/**
     * Use this method to inform receiving systems that the item was sold with
     * the specified taxes exempt, so the tax calculations, memo counts, etc can
     * be updated.
     * 
     * @param taxes
     */
	public void setExemptTaxes(TaxPK[] taxes);


	/**
	 * Returns the set of exempt taxes on this item in sale.
	 *
	 * @return	TaxPK[]
	 */

	public TaxPK[] getExemptTaxes();

	/**
     * Sets the soldAsMoneyOrder attribute of this item.
     * @param isTrue true item is sold as money order;false item is not sold as money
     *        order
     */
	public void setSoldAsMoneyOrder(boolean isTrue);
	/**
	 * sets if serial Number prompt is required for the Item
	 * @param isTrue
	 */
	public void setSerialNumPromptReqd(boolean isTrue);
	
	/**
	 * Returns if serial Number prompt is required for the Item
	 * @return
	 */
	public boolean isSerialNumPromptReqd();

	/**
	 * Returns true if feature validation prompt is skipped, otherwise returns
	 * false
	 * 
	 * @return
	 */
	public boolean isFeatureValidationPromptSkipped();
	
	/**
	 * sets if feature validation prompt is skipped 
	 * @param isTrue
	 */
	public void setFeatureValidationPromptSkipped(boolean isTrue);
	
	/**
     * Returns the soldAsMoneyOrder attribute of this item. Receiving system can
     * query this method rather than retrieve the defining entity from the
     * primary key to see if this was a money order sale.
     * @return true if the item is sold as Money Order and false otherwise
     */
	public boolean getSoldAsMoneyOrder();

	/**
     * Sets the soldAsManualFuel attribute of this item. Manual fuel department
     * sales should set this flag so the receiving system doesn't have to
     * reconstitute the entity to see if a manual fuel sale was involved.
	 *
     * @param isTrue true item is sold as manual fuel;false item is not sold as
     *        manual fuel
     */
	public void setSoldAsManualFuel(boolean isTrue);

	/**
     * Returns the soldAsManualFuel attribute of this item.
     * @return true if the item is sold as manual fuel and false otherwise
     */
	public boolean getSoldAsManualFuel();

	/**
     * Sets the soldAsPumpTest attribute of this item.
     * @param isTrue true item is sold as pump test;false item is not sold as
     *        pump test
     */
	public void setSoldAsPumpTest(boolean isTrue);

	/**
     * Returns the soldAsPumpTest attribute of this item. Receiving system can
     * determine if the item was part of the Pump Test MOP without having to
     * reconstitute the entity.
     * 
     * @return true if the item is sold as pump test and false otherwise
     */
	public boolean getSoldAsPumpTest();

	/**
     * Allows for an abstract visitor class to visit the implementation of this
     * item. This method makes operations across all entities in a
     * transaction polymorphic with the abstract visitor class -- all we do is
     * call it's visit() method and pass a reference to our actual type. The
     * visitor will have a method with a signature that matches our type and
     * automatically use it. Different visitor implementations can be created
     * any time to generate new results against all the known entities in a
     * transaction.
     * 
     * <B>NOTE </B> that adding a new data type as an argument to the visit()
     * method means the abstract class (TransactionVisitor) and all the visitor
     * implementations must be updated. We don't expect to be doing this much.
     * 
     * @param v the abstract visitor class
     * @exception Exception if there is any error while visiting the implementation
     */
	public void acceptVisitor(TransactionVisitor v) throws Exception;
        
	/**
     * Gets the taxable amount of this item corresponding to the type of tax
     * specified. The returned value includes the price and/or the associated
     * fee of this item that is subject to the specified tax.
     * @param taxNum the Tax number
     * @return the current amount
     */
    public TaxableAmount getTaxableAmount(int taxNum);
    
	/**
     * Add to the taxable amount of this item corresponding to the type of tax
     * specified. 
     * @param taxNum the Tax number
     * @param taxable the taxable amount to be added
     */
    public void addTaxableAmount(int taxNum, TaxableAmount taxable);
    
	/**
     * Subtract from the taxable amount of this item corresponding to the type of tax
     * specified. 
     * @param taxNum the Tax number
     * @param taxable the taxable amount to be subtracted
     */
    public void removeTaxableAmount(int taxNum, TaxableAmount taxable);
    
    /**
     * Gets the index of this item in the collection of ItemLines maintained in
     * the Transaction entity.
     * @return the index of this item in the collection of ItemLines maintained
     *         in the Transaction
     */
    public int getTxnLineIndex();
    
    /**
     * Sets the index of this item in the collection of ItemLines maintained in
     * the Transaction entity.
     * @param txnLineIndex the index of this item in the collection of ItemLines
     *        maintained in the Transaction
     */
    public void setTxnLineIndex(int txnLineIndex);
    
    /** Gets the index of the item in the Transaction that this item voids.
     * @return the index of the voided item
     */
    public int getVoidedLineIndex();
    
    /** Sets the index of the item in the Transaction that this item voids.
     * @param voidedLineIndex the index of the voided item
     */
    public void setVoidedLineIndex(int voidedLineIndex);
    
    /** Gets the item in the Transaction that this item voids.
     * @return the voided item
     */
    public ItemLine getVoidedItemLine();
    
    /** Sets the item in the Transaction that this item voids.
     * @param voidedItemLine the voided item
     */
    public void setVoidedItemLine(ItemLine voidedItemLine);
    
	/** Returns a collection of Taxes that are applicable for this item.
	 * @return A collection of TaxPKs
	 */
	public Iterator<TaxPK> getTaxPKs();

	/** Add the specified tax to the collection of Taxes that are applicable for this item.
	 * @param intax the Tax primary key
	 */
	public void addTaxPK(TaxPK intax);

	/** Remove the specified tax from the collection of Taxes that are applicable for this item.
	 * @param outtax the Tax primary key
	 */
	public void removeTaxPK(TaxPK outtax);

	/** 
	 * Tests the taxReversed attribute of this item.
	 * @return true if the tax on this item is reversed and false otherwise
	 * @deprecated
     */
    public boolean isTaxReversed();
    
	/** Sets the taxReversed attribute of this item.
	 * @param taxReversed true if the tax on this item should be reversed;false if not
     * @deprecated
     */
    public void setTaxReversed(boolean taxReversed);
    
    
    /** 
	 * Tests the ageValidnRequired attribute of this item.
	 * @return true if age validation is required for this item and false otherwise
     */
    public boolean isAgeValidnRequired();
    
	/** Sets the ageValidnRequired attribute of this item.
	 * @param ageValidnRequired true if age validation is required for this item ;false if not
     */
    public void setAgeValidnRequired(boolean ageValidnRequired);
    
    /** 
	 * Tests the specialDiscEligible attribute of this item.
	 * @return true if this item is eligible for special discount and false otherwise
     */
    public boolean isSpecialDiscEligible();
    
	/** Sets the specialDiscEligible attribute of this item.
	 * @param specialDiscEligible true if this item is eligible for special discount;false if not
     */
    public void setSpecialDiscEligible(boolean specialDiscEligible);

    /** 
	 * Tests the manualDiscountProhibited attribute of this item.
	 * @return true if this item is eligible for manual discount (%, $, fixed) and false otherwise
     */
    public boolean isManualDiscountProhibited();

    /** Sets the manualDiscountProhibited attribute of this item.
	 * @param manualDiscountProhibited true if this item is eligible for 
	 * manual discount (%, $, fixed) false if not
     */
    public void setManualDiscountProhibited(boolean manualDiscountProhibited);
    
    /** Returns a collection of discounts that are applicable for this item.
	 * @return An array of DiscountInfo objects
     */
    public DiscountInfo[] getAllDiscountInfo();
    
	/** Add the specified discount to the collection of discounts that are applicable for this item.
	 * @param discountInfo the DiscountInfo object to be added
     */
    public void addDiscountInfo(DiscountInfo discountInfo);
    
	/** Remove the specified discount from the collection of discounts that are applicable for this item.
	 * @param discountInfo the DiscountInfo object to be removed
     */
    public void removeDiscountInfo(DiscountInfo discountInfo);
    
    public void removeAllDiscountInfo();
    
    public DiscountInfo getDiscountInfo(DiscountMode type);

    
    /**
     * Return the discount on this item with the given discount mode and discount basis
     * 
     * @param type
     * @param basis
     * @return
     */
    public DiscountInfo getDiscountInfo(DiscountMode type, DiscountBasis basis);
    
    /** Removes the discount on this item that corresponds to the DiscountMode specified.
     * @param type the type of Discount as a DiscountMode object
	 */
    public void removeDiscountInfo(DiscountMode type);
    
    /**
     * Remove the discount with the given discount mode and discount basis
     * @param type
     * @param basis
     */
    public void removeDiscountInfo(DiscountMode type, DiscountBasis basis);
    
    /** Returns the total of all discounts that are applicable for this item.
	 * @return the total of all discounts
     */
    public MoneyAmount getAllDiscountTotal();
    
    /** 
	 * Tests the voided attribute of this item.
	 * @return true if this item is voided and false otherwise
     */
    public boolean isVoided();
    
    /** Sets the voided attribute of this item.
	 * @param voided true if this item is voided;false if not
     */
    public void setVoided(boolean voided);

    
    /** 
	 * Tests if this item is for a Stored Value Card(SVC) or Prepaid card activation/recharge.
	 * @return true if this item is for an SVC card activation/recharge
	 */
    public boolean isSvcItem();
    
    /** 
	 * Tests if this item is for an SVC card activation.
	 * @return true if this item is for an SVC card activation
	 */
    public boolean isSvcActivation();
    
    /** 
	 * Tests if this item is for an SVC card recharge.
	 * @return true if this item is for an SVC card recharge
	 */
    public boolean isSvcRecharge();
    
    /**
     * Returns the type of SVC operation this item corresponds to.
     * @return SvcActInfo.SVC_ACTIVATION_ITEM for SVC activation and
     *         SvcActInfo.SVC_RECHARGE_ITEM for SVC recharge
     */
    public int getSvcActRecharge();
    
    /**
     * Sets the type of SVC operation this item corresponds to.
     * @param svcActRecharge the possible values are
     *        SvcActInfo.SVC_ACTIVATION_ITEM for SVC activation and
     *        SvcActInfo.SVC_RECHARGE_ITEM for SVC recharge
     */
    public void setSvcActRecharge(int svcActRecharge);
    
    /**
     * Add to the collection of SVC activations sold as part of this item.
     * @param svcInfo the SvcActInfo object
     */
    public void addSvcActInfo(SvcActInfo svcInfo);
    
    /**
     * Removes from the collection of SVC activations sold as part of this item.
     * @param svcInfo the SvcActInfo object
     */
    public void removeSvcActInfo(SvcActInfo svcInfo);
    
    /**
     * Returns the number of SVC activations sold as part of this item.
     * @return the number of SVC activations sold
     */
    public int getSvcActCount();
    
    /**
     * Returns a collection of SVC activations sold as part of this item.
     * @return the collection of SvcActInfo objects
     */
    public Iterator<SvcActInfo> getSvcActLines();
    
    
    
    /**
     * Tests the voidLine attribute of this item.
     * @return true if this item is for voiding an earlier item in the
     *         transaction and false otherwise
     */
    public boolean isVoidLine();
    
    /**
     * Sets the voidLine attribute of this item.
     * @param voidLine true if this item is for voiding an earlier item in the
     *        transaction;false if not
     */
    public void setVoidLine(boolean voidLine);

    /** 
     * Copies this object to the ItemLine that is passed as parameter.
     * @param clone the object to be copied to 
     */
    public void deepCopy(ItemLine clone);
    
    /**
     * Sets the MoneyTransferInfo object if this item is associated with Money transfer.
     * @param moneyTransferInfo the MoneyTransferInfo object
     */
    public void setMoneyTransferInfo(MoneyTransferInfo moneyTransferInfo);
    
    /**
     * Returns a MoneyTransferInfo object if this item is associated with Money transfer.
     * @return the MoneyTransferInfo objectif this item is associated with Money transfer; null otherwise
     */
    public MoneyTransferInfo getMoneyTranferInfo();  
    
    /** Getter for property kitchenPrinterItem.
     * @return Value of property kitchenPrinterName.
     */    
    public String getKitchenPrinterName();

    /**
     * Setter for property kitchenPrintername
     * @param kitchenPrinterName  New value of property kitchenPrinterName
     */
    public void setKitchenPrinterName(String kitchenPrinterName);
    
    /**
     * Returns the list of sub-items as a collection of ItemLines. CompositeLine
     * returns an actual list of sub-items within it. Other implementations
     * return an empty collection.
     * @return an array of ItemLines
     */
    public ItemLine[] getSubItems();
    
    /**
     * Tests the duplicate attribute of this item. If an item is marked as
     * duplicate within a DCR-initiated transaction, any operation relating to
     * this item would not be notified to any of the salesengine-related
     * features.
     * @return true if the item is marked as duplicate and false otherwise
     */
    public boolean isDuplicate(); 

    /** Sets the duplicate attribute of this item.
     * @param duplicate true if features should not be notified;false otherwise
     */
    public void setDuplicate(boolean duplicate);
    /**
	  * This method will check the added item is an EPSPrepaid item or not.
	  * First it will check the EPSPrepaid product code match with item line and then with the department.
	  * @param itemLine: Need to be check is an EPSPrepaid item line.
	  * @return isEPSPrepaidItem : Item is an EPSPrepaid product or not.
	  */
    public boolean isEPSPrepaidItem();
    
    /**
	 * This method will identifies and return the product code associated with a department.
	 * @param deptNumber : Department number.
	 * @return Product code associated with the department.
	 */
    public int getDepartmentProdCode();
    
    /**
     * Method is to check whether the itemline in the receipt is can be modified or not.
     * @return: true if modification is allowed on this item, false otherwise.
     */
    public boolean isModificationAllowed();
    
    /**
	 * This method is used to indicate that the modification is allowed on this item.
	 * @param: boolean value to set modificationAllowed.
	 */
	public void setModificationAllowed(boolean modificationAllowed);
	
	 /** Returns a collection of fees that are applicable for this item.
	 * @return An array of FeeInfo objects
    */
   public FeeInfo[] getAllFeeInfo();
   
	/** Add the specified fee to the collection of fees that are applicable for this item.
	 * @param feeInfo the FeeIno object to be added
    */
   public void addFeeInfo(FeeInfo feeInfo);
   
	/** Remove the specified fee from the collection of fees that are applicable for this item.
	 * @param feeInfo the FeeInfo object to be removed
    */
   public void removeFeeInfo(FeeInfo feeInfo);
   
	/** Removes all the fees from the collection of fees that are applicable for this item.
    */
   public void removeAllFeeInfo();
   /**
    * Retrieves the FeeInfo object from the collection of fees that are applicable for this item
    * @param feeSysId the feeSysId of the FeeInfo
    * @return FeeInfo
    */
   public FeeInfo getFeeInfo(int feeSysId);
   
   /** Removes the fees on this item that corresponds to the feeSysId specified.
    * @param feeSysId the feeSysId of FeeInfo object 
	 */
   public void removeFeeInfo(int feeSysId);
   /** Returns the total of all Fees that are applicable for this item.
	 * @return the total of all fees
    */
   public MoneyAmount getAllFeeTotal();
    /** Returns the total of all food stampable Fees that are applicable for this item.
	 * @return the total of all food stampable fees
    */
	public MoneyAmount getAllFoodStampableFeeTotal();
   /**
    * Removes all the fees existing and set the specified fees
    */
	public void setFees(FeeInfo[] fees,boolean voided);
	/**
	 * Checks whether the specified item line and item line in have same fees .
	 * @param il
	 * @return
	 */
	public boolean equalFeesInItemLine(ItemLine il);

	/**
	 * API to create deep copy of the object reference
	 * @return ItemLine 
	 */
	public ItemLine createDeepCopy();
	
	/** Sets the base price of this item before inclusive tax.
     * @param amount the new amount
     */
	public MoneyAmount getBasePriceBeforeIncTax() ;
	/** 
     * Gets the base price of this item before inclusive tax.
     * @return the base price of this item before inclusive tax.
     */
	public void setBasePriceBeforeIncTax(MoneyAmount basePriceBeforeIncTax);
	/**
	 * Setter for recalled
	 * @return
	 */
	public boolean isRecalled();

	/**
	 * Getter for recalled.
	 * @param recalled
	 */
	public void setRecalled(boolean recalled);

	
	/**
	 * Method to check whether the discountMode is present in any DiscountInfo for this itemLine.
	 * @param discountMode
	 * @return true if discountMode is present otherwise false.
	 */
	public boolean isDiscountModePresent(DiscountMode discountMode);
	

    /**
     * Get the Order Confirmation System (OCS) item code for this item.
     * <p>
     * This value is used by the Order Confirmation System
     * to uniquely identify this item.
     * <p>
     * For all items in a transaction, this item code must be unique.
     * 
     * @return A value from 1 to 2000, inclusive. 
     *         A value less then or equal to 0 means
     *         the item code has not been assigned for this item.
     * 
     * @see #setOCSItemCode(int)
     */
    public int getOCSItemCode();
    
    /**
     * Set the Order Confirmation System (OCS) item code for this item.
     * <p>
     * For all items in a transaction, this item code must be unique.
     * 
     * @param ocsItemCode A value from 1 to 2000, inclusive.
     *                    Values outside of this range will ignored
     *                    by any implementation.
     * 
     * @see #getOCSItemCode()
     */
    public void setOCSItemCode(int ocsItemCode);
    
       
    /** 
     * Gets the Category number of this item.
     * @return the Category number
     */
    public String getCategoryName();
    
	 /* Set to true if this item is for a Third Party Product Item.
	 * @return true if this item is for an Third Party Product Item
	 */
    public void setTpppVoucherItem(boolean tpppVoucherItem);
    
    /**
     * Setting the category name.
     * @param categoryName
     */
    public void setCategoryName(String categoryName);
    /** 
	 * Tests if this item is for a Third Party Product Item.
	 * @return true if this item is for an Third Party Product Item
	 */
    public boolean isTpppVoucherItem();
    
    /**
     * getting deptinfo info object.     
     */
    public DepartmentInfo getDepartmentInfo();
    
    /* Add to the collection of Third Party Products sold as part of this item.
    * @param tpppVoucherInfo the TpppVoucherInfo object
    */
    public void addTpppVoucherInfo(TpppVoucherInfo tpppVoucherInfo);
    
    /**
     * Setting deptInfo info object
     * @param deptInfo
     */
    public void setDepartmentInfo(DepartmentInfo deptInfo);
    

    /* Removes from the collection of Third Party Products sold as part of this item.
    * @param tpppVoucherInfo the TpppVoucherInfo object
    */
    public void removeTpppVoucherInfo(TpppVoucherInfo tpppVoucherInfo);
    
        
    /**
     * Returns the number of Third Party Products sold as part of this item.
     * @return the number of Third Party Products sold
     */
    public int getTpppVoucherCount();
    
    /**
     * Returns a collection of Third Party Products sold as part of this item.
     * @return the collection of TpppVoucherInfo objects
     */
    public Iterator<TpppVoucherInfo> getTpppVoucherLines();
    
    /**
     * 
     * @return True if item is enabled for sticky label , 
     * false otherwise
     */
    public boolean isStickyLabelNeeded() ;	
    /**
     * Mark item for sticky label 
     * @param stickyLabelNeeded
     */
	public void setStickyLabelNeeded(boolean stickyLabelNeeded) ;
    
	/**
	 * Minimum age to purchase this item
	 * 
	 * @return minimum age to purchase item
	 */
    public int getMinimumAge();
    
	/**
	 * Set the minimum age to purchase item
	 * 
    
	 * @param minimumAge
	 */
    public void setMinimumAge(int minimumAge);
    
    /**
     * Indicates customer must be born before this date to purchase item
     * 
     * @return the latest birthday to purchase item
     */
    public Date getEligibleDOB();
    
	/**
	 * Set the latest birthday to purchase this item
	 * 
	 * @param eligibleDOB
	 */
    public void setEligibleDOB(Date eligibleDOB);
    
    /**
     * Add override cashier details for a SoftKeyType
     * @param key
     * @param overrideCashierID
     */
    
    public void addOverrideCashierID(SoftKeyType key, CashierID overrideCashierID) ;
    
    /**
     * Return override cashierID Map for the SoftKeyTypes
     * @return
     */
    public Map<SoftKeyType, CashierID> getOverrideCashierIDs();

    public boolean isRestrictiveItem();

    public void setRestrictiveItem(boolean restrictive);
}
