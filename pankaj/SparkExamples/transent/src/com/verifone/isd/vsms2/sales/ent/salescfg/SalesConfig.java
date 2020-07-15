package com.verifone.isd.vsms2.sales.ent.salescfg;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.util.Quantity;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import com.verifone.isd.vsms2.sales.ent.dept.DepartmentPK;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;

/**
 *  entity class for sales cfg (no separate IEntityPersistState object)
 *
 *  @author "mailto:bhanu_narayanan@hp.com"
 *  @version 1.0 Copyright(c) 2000 Hewlett-Packard Company, All Rights Reserved
 */
public class SalesConfig implements IEntityObject, ISalesEntityVisitable, Cloneable {
	
	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 3469260452612309540L;
	
	private static final String EMPTY_STR = "";
	public static final int MAX_CASHDRAWERS = 2;
    public static final int MIN_QUANTITY = 1;
    public static final int MAX_QUANTITY = 9999;
    public static final int MAX_DISCOUNT_VALUE = 9999;
    public static final int MAX_AMOUNT_VALUE = 999999;
    public static final int MIN_STORENUM_LEN = 1;
    public static final int MAX_STORENUM_LEN = 5;
    public static final int MAX_TIMEOUT_VALUE = 3600;
    public static final int MAX_MONEY_ORDER_LOW = 99;
    public static final int MIN_ERR_PROMPT = 2;
    public static final int MAX_ERR_PROMPT = 30;
    public static final int MAX_REG_TIMEOUT = 999;
    public static final int MAX_DRAWER_ALARM_TIMER = 99;
    public static final int DELAY_MAX_VALUE = 10;
    public static final int DELAY_MIN_VALUE = 3;
    public static final int DELAY_DEFAULT_VALUE = 5;
    
    /** Holds value of property pluNotFoundDept. */
    private DepartmentPK pluNotFoundDept;

    /** Holds value of property maximumQuantity. */
    private Quantity maximumQuantity;

    /** Holds value of property maximumAmount. */
    private MoneyAmount maximumAmount;

    /** Holds value of property minimumAmount. */
    private MoneyAmount minimumAmount;

    /** Holds value of property maximumDiscount. */
    private Quantity maximumDiscount;

    /** Holds value of property minimumDiscount. */
    private Quantity minimumDiscount;

    /** Holds value of property referDiscount. */
    private Quantity referDiscount;

    /** Holds value of property discountType. */
    private DiscountType discountType;

	/** Holds value of property receiptPrintProgramNameType. */
	private ReceiptPrintProgramNameType receiptPrintProgramNameType;

    /** Holds value of property fixedDiscount. */
    private boolean fixedDiscount;

    /** Holds value of property fixedDiscountRate. */
    private Quantity fixedDiscountRate;

    /** Holds value of property enableManagedPLUUpdate. */
    private boolean enableManagedUpdate;

    /** Holds value of property cashDrawers. */
    private int cashDrawers;

    /** Holds value of property cashierNumForEachSale. */
    private boolean cashierNumForEachSale;

    /** Holds value of property subTotalRequired. */
    private boolean subTotalRequired;

    /** Holds value of property totalInDouble. */
    private boolean totalInDouble;

    /** Holds value of property printReceipt. */
    private boolean printReceipt;

    /** Holds value of property voidLinePrintForced. */
    private boolean voidLinePrintForced;

    /** Holds value of property voidTicketPrintForced. */
    private boolean voidTicketPrintForced;

    /** Holds value of property noSalePrintForced. */
    private boolean noSalePrintForced;

    /** Holds value of property refundPrintForced. */
    private boolean refundPrintForced;

    /** Holds value of property dueSalesPrompt. */
    private boolean dueSalesPrompt;

    /** Holds value of property drawOpenInSaleAllowed. */
    private boolean drawOpenInSaleAllowed;

    /** Holds value of property resetDisplayOnDrawClose. */
    private boolean resetDisplayOnDrawClose;

    /** Holds value of property resetDisplayOnTimeout. */
    private boolean resetDisplayOnTimeout;

    /** Holds value of property canadianGST. */
    private boolean canadianGST;

    /** Holds value of property valueAddedTax. */
    private boolean valueAddedTax;

    /** Holds value of property storeNumber. */
    private String storeNumber;

    /** Holds value of property cashUnderRunAutoRefund. */
    private boolean cashUnderRunAutoRefund;
    
     /** Holds value of property autoSettleOverrun. */
    private boolean autoSettleOverrunEnabled;
    
    /**Holds value of property disable error correct key */
    private boolean disableErrorCorrectKey;

    /** Holds value of property amountCheckedOnSafeDrop. */
    private boolean amountCheckedOnSafeDrop;

    /** Holds value of property moneyOrderLow. */
    private int moneyOrderLow;

    /** Holds value of property oneCSRPerDrawerForced. */
    private boolean oneCSRPerDrawerForced;

    /** Holds value of property dobCheckForced. */
    private boolean dobCheckForced;

    /** Holds value of property errorMsgPromptTimer. */
    private int errorMsgPromptTimer;

    /** Holds value of property registerTimeout. */
    private int registerTimeout;

    /** Holds value of property modifyKeyCyclingDisabled. */
    private boolean modifyKeyCyclingDisabled;
    /** Holds value of property resetDisplayTimeout. */
    private int resetDisplayTimeout;

    /** Holds value of property drawerAlarmTimer. */
    private int drawerAlarmTimer;

    /** Holds value of property enforceGradePromptInside. */
    private boolean enforceGradePromptInside;

    /**
     * Holds value of property releaseTerminalDuringClose.
     */
    private boolean releaseTerminalDuringClose;

    /** Holds value of property prepaidActivateDept. */
    private DepartmentPK prepaidActivateDept;

    /** Holds value of property prepaidRechargeDept. */
    private DepartmentPK prepaidRechargeDept;

    private SalesConfigPK pk;
    //code added by tattu 14th may 2007 for imprinter feature
    /** Holds value of property forceImprinterEnable. */
     private boolean forceImprinterEnable;
    private String fuelDiscountTitle;


    //CR6477 DOB masking changes
    private boolean printDOBonReceipt;
    private boolean printDOBonJournal;
    
      /** Holds value of property Maximum Till Transaction Amount. */
    private MoneyAmount maximumTillTransAmount = new MoneyAmount(999999L);
    /** Holds value of property cardLoadRechargeDept. */
    private DepartmentPK cardLoadRechargeDept;

    private boolean DisplayPLUNotFoundDeptList;

    // Determines whether to prompt loyalty confirmation for PLU not found
    private boolean promptLoyaltyForPluNF;
    
    //Determines whether the SWB regulation should be applied
    private boolean swbRegulationRequired;
    
	//CR6668 Open Cash Drawer on cashier close
	private boolean openDrawerCashierClose;
	
	private boolean receiptTaxDetailEnabled;

    private boolean discountDenomEnabled;
    private boolean upcDetailEnabled;
    private boolean stackManualDiscount;

    private boolean cntUnderrunCustsEnabled = false;
    
    private boolean allowAmountEntryForRefund = true;

	// CR1045.01 Determines whether to prompt Dine In or not for food order service
    private boolean promptDineIn = false;
    
    // CR1670.01 Determines whether to prompt for customer name or not for food order service
    private boolean foodOrderCustomerNameprompt = false;
    // CR1670.01 Determines whether to prompt for customer phone number or not for food order service
    private boolean foodOrderCustomerPhoneNumberprompt = false;   
    
    /** Method to validate the primary key of the entity object
     * @return true if the primary key of the entity object is valid
     */
    public boolean isPKValid() {
        if (this.pk == null) {
            this.pk = new SalesConfigPK();
        }
        return this.pk.isValid();
    }

    /** sets the attributes of the new object; this operation is similar to deep
     * cloning
     * @param obj the target object to be written into
     */
    public void setAttributes(IEntityObject obj) {
        SalesConfig newCfg = (SalesConfig)obj;
        newCfg.amountCheckedOnSafeDrop = this.amountCheckedOnSafeDrop;
        newCfg.canadianGST = this.canadianGST;
        newCfg.cashierNumForEachSale = this.cashierNumForEachSale;
        newCfg.dobCheckForced = this.dobCheckForced;
        newCfg.drawOpenInSaleAllowed = this.drawOpenInSaleAllowed;
        newCfg.dueSalesPrompt = this.dueSalesPrompt;
        newCfg.cashUnderRunAutoRefund = this.cashUnderRunAutoRefund;
        newCfg.disableErrorCorrectKey = this.disableErrorCorrectKey;
        newCfg.autoSettleOverrunEnabled = this.autoSettleOverrunEnabled;
        newCfg.fixedDiscount = this.fixedDiscount;
        newCfg.modifyKeyCyclingDisabled = this.modifyKeyCyclingDisabled;
        newCfg.noSalePrintForced = this.noSalePrintForced;
        newCfg.oneCSRPerDrawerForced = this.oneCSRPerDrawerForced;
        newCfg.printReceipt = this.printReceipt;
        newCfg.refundPrintForced = this.refundPrintForced;
        newCfg.resetDisplayOnDrawClose = this.resetDisplayOnDrawClose;
        newCfg.resetDisplayOnTimeout = this.resetDisplayOnTimeout;
        newCfg.subTotalRequired = this.subTotalRequired;
        newCfg.totalInDouble = this.totalInDouble;
        newCfg.valueAddedTax = this.valueAddedTax;
        newCfg.voidLinePrintForced = this.voidLinePrintForced;
        newCfg.voidTicketPrintForced = this.voidTicketPrintForced;
        newCfg.cashDrawers = this.cashDrawers;
        newCfg.errorMsgPromptTimer = this.errorMsgPromptTimer;
        newCfg.moneyOrderLow = this.moneyOrderLow;
        newCfg.registerTimeout = this.registerTimeout;
        newCfg.resetDisplayTimeout = this.resetDisplayTimeout;
        newCfg.pluNotFoundDept = this.pluNotFoundDept;
        newCfg.discountType = this.discountType;
        newCfg.pk = this.pk;
        newCfg.maximumAmount = this.maximumAmount;
        newCfg.minimumAmount = this.minimumAmount;
        newCfg.fixedDiscountRate = this.fixedDiscountRate;
        newCfg.maximumDiscount = this.maximumDiscount;
        newCfg.maximumQuantity = this.maximumQuantity;
        newCfg.minimumDiscount = this.minimumDiscount;
        newCfg.referDiscount = this.referDiscount;
        newCfg.storeNumber = this.storeNumber;
        newCfg.drawerAlarmTimer = this.drawerAlarmTimer;
        newCfg.enforceGradePromptInside = this.enforceGradePromptInside;
        newCfg.prepaidActivateDept = this.prepaidActivateDept;
        newCfg.prepaidRechargeDept = this.prepaidRechargeDept;
        newCfg.enableManagedUpdate=this.enableManagedUpdate;
        newCfg.releaseTerminalDuringClose = this.releaseTerminalDuringClose;
        newCfg.fuelDiscountTitle = this.fuelDiscountTitle;
//      code added by tattu 14th may 2007 for imprinter feature
        newCfg.forceImprinterEnable=this.forceImprinterEnable;
        
        //DOB masking changes CR6477
        newCfg.printDOBonReceipt = this.printDOBonReceipt;
        newCfg.printDOBonJournal =	this.printDOBonJournal;
        
         newCfg.cardLoadRechargeDept=this.cardLoadRechargeDept;
        newCfg.DisplayPLUNotFoundDeptList = this.DisplayPLUNotFoundDeptList;
        newCfg.maximumTillTransAmount = this.maximumTillTransAmount;
        newCfg.promptLoyaltyForPluNF = this.promptLoyaltyForPluNF;
        
        //Changes for CR6677.01 Money order enhancements SWB regulations
        newCfg.swbRegulationRequired = this.swbRegulationRequired;
        
        newCfg.openDrawerCashierClose = this.openDrawerCashierClose;
        newCfg.receiptTaxDetailEnabled = this.receiptTaxDetailEnabled;

        newCfg.discountDenomEnabled = this.discountDenomEnabled;
        newCfg.upcDetailEnabled = this.upcDetailEnabled;
        newCfg.stackManualDiscount = this.stackManualDiscount;
        newCfg.cntUnderrunCustsEnabled = this.cntUnderrunCustsEnabled;
        newCfg.allowAmountEntryForRefund = this.allowAmountEntryForRefund;
		newCfg.promptDineIn = this.promptDineIn;
		newCfg.receiptPrintProgramNameType = this.receiptPrintProgramNameType;
		newCfg.foodOrderCustomerNameprompt = this.foodOrderCustomerNameprompt;
		newCfg.foodOrderCustomerPhoneNumberprompt = this.foodOrderCustomerPhoneNumberprompt;
    }

    /** Set the primary key of the entity object
     * @param pk primary key for the entity object
     */
    public void setPK(IEntityPK pk) {
        this.pk = (SalesConfigPK)pk;
    }

    /** Getter of the entity object's primary key
     * @return the ID of the entity object
     */
    public IEntityPK getPK() {
        return this.pk;
    }

    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {
    }

    /** Getter for property pluNotFoundDept.
     * @return Value of property pluNotFoundDept.
     */
    public DepartmentPK getPluNotFoundDept() {
        return (this.pluNotFoundDept == null) ? new DepartmentPK(0) : this.pluNotFoundDept;
    }

    /** Setter for property pluNotFoundDept.
     * @param pluNotFoundDept New value of property pluNotFoundDept.
     */
    public void setPluNotFoundDept(DepartmentPK pluNotFoundDept) {
        this.pluNotFoundDept = pluNotFoundDept;
    }

    /** Getter for property maximumQuantity.
     * @return Value of property maximumQuantity.
     */
    public Quantity getMaximumQuantity() {
        return (this.maximumQuantity == null) ? new Quantity(0, "EA") : this.maximumQuantity;
    }

    /** Setter for property maximumQuantity.
     * @param maximumQuantity New value of property maximumQuantity.
     */
    public void setMaximumQuantity(Quantity maximumQuantity) {
        this.maximumQuantity = maximumQuantity;
    }

    /** Getter for property maximumAmount.
     * @return Value of property maximumAmount.
     */
    public MoneyAmount getMaximumAmount() {
        return (this.maximumAmount == null) ? new MoneyAmount(0) : this.maximumAmount;
    }

    /** Setter for property maximumAmount.
     * @param maximumAmount New value of property maximumAmount.
     */
    public void setMaximumAmount(MoneyAmount maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    /** Getter for property minimumAmount.
     * @return Value of property minimumAmount.
     */
    public MoneyAmount getMinimumAmount() {
        return (this.minimumAmount == null) ? new MoneyAmount(0) : this.minimumAmount;
    }

    /** Setter for property minimumAmount.
     * @param minimumAmount New value of property minimumAmount.
     */
    public void setMinimumAmount(MoneyAmount minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    /** Getter for property maximumDiscount.
     * @return Value of property maximumDiscount.
     */
    public Quantity getMaximumDiscount() {
        return (this.maximumDiscount == null) ? new Quantity(0, EMPTY_STR) : this.maximumDiscount;
    }

    /** Setter for property maximumDiscount.
     * @param maximumDiscount New value of property maximumDiscount.
     */
    public void setMaximumDiscount(Quantity maximumDiscount) {
        this.maximumDiscount = maximumDiscount;
    }

    /** Getter for property minimumDiscount.
     * @return Value of property minimumDiscount.
     */
    public Quantity getMinimumDiscount() {
        return (this.minimumDiscount == null) ? new Quantity(0, EMPTY_STR) : this.minimumDiscount;
    }

    /** Setter for property minimumDiscount.
     * @param minimumDiscount New value of property minimumDiscount.
     */
    public void setMinimumDiscount(Quantity minimumDiscount) {
        this.minimumDiscount = minimumDiscount;
    }

    /** Getter for property referDiscount.
     * @return Value of property referDiscount.
     */
    public Quantity getReferDiscount() {
        return (this.referDiscount == null) ? new Quantity(0, EMPTY_STR) : this.referDiscount;
    }

    /** Setter for property referDiscount.
     * @param referDiscount New value of property referDiscount.
     */
    public void setReferDiscount(Quantity referDiscount) {
        this.referDiscount = referDiscount;
    }

    /** Getter for property discountType.
     * @return Value of property discountType.
     */
    public DiscountType getDiscountType() {
        return (this.discountType == null) ? DiscountType.AMOUNT : this.discountType;
    }

    /** Setter for property discountType.
     * @param discountType New value of property discountType.
     */
    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    /** Getter for property fixedDiscount.
     * @return Value of property fixedDiscount.
     */
    public boolean isFixedDiscount() {
        return this.fixedDiscount;
    }

    /** Setter for property fixedDiscount.
     * @param fixedDiscount New value of property fixedDiscount.
     */
    public void setFixedDiscount(boolean fixedDiscount) {
        this.fixedDiscount = fixedDiscount;
    }

    /** Getter for property fixedDiscountRate.
     * @return Value of property fixedDiscountRate.
     */
    public Quantity getFixedDiscountRate() {
        return (this.fixedDiscountRate == null) ? new Quantity(0, EMPTY_STR) : this.fixedDiscountRate;
    }

    /** Setter for property fixedDiscountRate.
     * @param fixedDiscountRate New value of property fixedDiscountRate.
     */
    public void setFixedDiscountRate(Quantity fixedDiscountRate) {
        this.fixedDiscountRate = fixedDiscountRate;
    }

    /** Getter for property enableManagedUpdate.
     * @return Value of property enableManagedUpdate.
     */
	public boolean isEnableManagedUpdate() {
		return enableManagedUpdate;
	}
    /** Setter for property enableManagedUpdate.
     * @param enableManagedUpdate New value of property enableManagedUpdate.
     */
	public void setEnableManagedUpdate(boolean enableManagedUpdate) {
		this.enableManagedUpdate = enableManagedUpdate;
	}

	/** Getter for property cashDrawers.
     * @return Value of property cashDrawers.
     */
    public int getCashDrawers() {
        return this.cashDrawers;
    }

    /** Setter for property cashDrawers.
     * @param cashDrawers New value of property cashDrawers.
     */
    public void setCashDrawers(int cashDrawers) {
        this.cashDrawers = cashDrawers;
    }

    /** Getter for property cashierNumForEachSale.
     * @return Value of property cashierNumForEachSale.
     */
    public boolean isCashierNumForEachSale() {
        return this.cashierNumForEachSale;
    }

    /** Setter for property cashierNumForEachSale.
     * @param cashierNumForEachSale New value of property cashierNumForEachSale.
     */
    public void setCashierNumForEachSale(boolean cashierNumForEachSale) {
        this.cashierNumForEachSale = cashierNumForEachSale;
    }

    /** Getter for property subTotalRequired.
     * @return Value of property subTotalRequired.
     */
    public boolean isSubTotalRequired() {
        return this.subTotalRequired;
    }

    /** Setter for property subTotalRequired.
     * @param subTotalRequired New value of property subTotalRequired.
     */
    public void setSubTotalRequired(boolean subTotalRequired) {
        this.subTotalRequired = subTotalRequired;
    }

    /** Getter for property totalInDouble.
     * @return Value of property totalInDouble.
     */
    public boolean isTotalInDouble() {
        return this.totalInDouble;
    }

    /** Setter for property totalInDouble.
     * @param totalInDouble New value of property totalInDouble.
     */
    public void setTotalInDouble(boolean totalInDouble) {
        this.totalInDouble = totalInDouble;
    }

    /** Getter for property printReceipt.
     * @return Value of property printReceipt.
     */
    public boolean isPrintReceipt() {
        return this.printReceipt;
    }

    /** Setter for property printReceipt.
     * @param printReceipt New value of property printReceipt.
     */
    public void setPrintReceipt(boolean printReceipt) {
        this.printReceipt = printReceipt;
    }

    /** Getter for property voidLinePrintForced.
     * @return Value of property voidLinePrintForced.
     */
    public boolean isVoidLinePrintForced() {
        return this.voidLinePrintForced;
    }

    /** Setter for property voidLinePrintForced.
     * @param voidLinePrintForced New value of property voidLinePrintForced.
     */
    public void setVoidLinePrintForced(boolean voidLinePrintForced) {
        this.voidLinePrintForced = voidLinePrintForced;
    }

    /** Getter for property voidTicketPrintForced.
     * @return Value of property voidTicketPrintForced.
     */
    public boolean isVoidTicketPrintForced() {
        return this.voidTicketPrintForced;
    }

    /** Setter for property voidTicketPrintForced.
     * @param voidTicketPrintForced New value of property voidTicketPrintForced.
     */
    public void setVoidTicketPrintForced(boolean voidTicketPrintForced) {
        this.voidTicketPrintForced = voidTicketPrintForced;
    }

    /** Getter for property noSalePrintForced.
     * @return Value of property noSalePrintForced.
     */
    public boolean isNoSalePrintForced() {
        return this.noSalePrintForced;
    }

    /** Setter for property noSalePrintForced.
     * @param noSalePrintForced New value of property noSalePrintForced.
     */
    public void setNoSalePrintForced(boolean noSalePrintForced) {
        this.noSalePrintForced = noSalePrintForced;
    }

    /** Getter for property refundPrintForced.
     * @return Value of property refundPrintForced.
     */
    public boolean isRefundPrintForced() {
        return this.refundPrintForced;
    }

    /** Setter for property refundPrintForced.
     * @param refundPrintForced New value of property refundPrintForced.
     */
    public void setRefundPrintForced(boolean refundPrintForced) {
        this.refundPrintForced = refundPrintForced;
    }

    /** Getter for property dueSalesPrompt.
     * @return Value of property dueSalesPrompt.
     */
    public boolean isDueSalesPrompt() {
        return this.dueSalesPrompt;
    }

    /** Setter for property dueSalesPrompt.
     * @param dueSalesPrompt New value of property dueSalesPrompt.
     */
    public void setDueSalesPrompt(boolean dueSalesPrompt) {
        this.dueSalesPrompt = dueSalesPrompt;
    }

    /** Getter for property drawOpenInSaleAllowed.
     * @return Value of property drawOpenInSaleAllowed.
     */
    public boolean isDrawOpenInSaleAllowed() {
        return this.drawOpenInSaleAllowed;
    }

    /** Setter for property drawOpenInSaleAllowed.
     * @param drawOpenInSaleAllowed New value of property drawOpenInSaleAllowed.
     */
    public void setDrawOpenInSaleAllowed(boolean drawOpenInSaleAllowed) {
        this.drawOpenInSaleAllowed = drawOpenInSaleAllowed;
    }

    /** Getter for property resetDisplayOnDrawClose.
     * @return Value of property resetDisplayOnDrawClose.
     */
    public boolean isResetDisplayOnDrawClose() {
        return this.resetDisplayOnDrawClose;
    }

    /** Setter for property resetDisplayOnDrawClose.
     * @param resetDisplayOnDrawClose New value of property resetDisplayOnDrawClose.
     */
    public void setResetDisplayOnDrawClose(boolean resetDisplayOnDrawClose) {
        this.resetDisplayOnDrawClose = resetDisplayOnDrawClose;
    }

    /** Getter for property resetDisplayOnTimeout.
     * @return Value of property resetDisplayOnTimeout.
     */
    public boolean isResetDisplayOnTimeout() {
        return this.resetDisplayOnTimeout;
    }

    /** Setter for property resetDisplayOnTimeout.
     * @param resetDisplayOnTimeout New value of property resetDisplayOnTimeout.
     */
    public void setResetDisplayOnTimeout(boolean resetDisplayOnTimeout) {
        this.resetDisplayOnTimeout = resetDisplayOnTimeout;
    }

    /** Getter for property canadianGST.
     * @return Value of property canadianGST.
     */
    public boolean isCanadianGST() {
        return this.canadianGST;
    }

    /** Setter for property canadianGST.
     * @param canadianGST New value of property canadianGST.
     */
    public void setCanadianGST(boolean canadianGST) {
        this.canadianGST = canadianGST;
    }

    /** Getter for property valueAddedTax.
     * @return Value of property valueAddedTax.
     */
    public boolean isValueAddedTax() {
        return this.valueAddedTax;
    }

    /** Setter for property valueAddedTax.
     * @param valueAddedTax New value of property valueAddedTax.
     */
    public void setValueAddedTax(boolean valueAddedTax) {
        this.valueAddedTax = valueAddedTax;
    }

    /** Getter for property storeNumber.
     * @return Value of property storeNumber.
     */
    public String getStoreNumber() {
        return (this.storeNumber == null) ? EMPTY_STR : this.storeNumber;
    }

    /** Setter for property storeNumber.
     * @param storeNumber New value of property storeNumber.
     */
    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber;
    }

    /** Getter for property cashUnderRunAutoRefund.
     * @return Value of property cashUnderRunAutoRefund.
     */
    public boolean isCashUnderRunAutoRefund() {
        return this.cashUnderRunAutoRefund;
    }

    /** Setter for property autoRefundEnabled.
     * @param cashUnderRunAutoRefund New value of property cashUnderRunAutoRefund.
     */
    public void setCashUnderRunAutoRefund(boolean cashUnderRunAutoRefund) {
        this.cashUnderRunAutoRefund = cashUnderRunAutoRefund;
    }

	/**
     * Getter for property autoSettleOverrunEnabled.
     *
     * @return Value of property autoSettleOverrunEnabled.
     */
    public boolean isAutoSettleOverrunEnabled() {
        return this.autoSettleOverrunEnabled;
    }
    
    
    /**
     * Setter for property autoRefundEnabled.
     *
     * @param autoSettleOverrunEnabled
     *            New value of property autoSettleOverrunEnabled.
     */
    public void setAutoSettleOverrunEnabled(boolean autoSettleOverrunEnabled) {
        this.autoSettleOverrunEnabled = autoSettleOverrunEnabled;
    }
    
    
    public void setDisableErrorCorrectKey(boolean disableErrorCorrectKey){
    	this.disableErrorCorrectKey = disableErrorCorrectKey;
    }

	public boolean isDisableErrorCorrectKey() {
		return disableErrorCorrectKey;
	}
    /** Getter for property amountCheckedOnSafeDrop.
     * @return Value of property amountCheckedOnSafeDrop.
     */
    public boolean isAmountCheckedOnSafeDrop() {
        return this.amountCheckedOnSafeDrop;
    }

    /** Setter for property amountCheckedOnSafeDrop.
     * @param amountCheckedOnSafeDrop New value of property amountCheckedOnSafeDrop.
     */
    public void setAmountCheckedOnSafeDrop(boolean amountCheckedOnSafeDrop) {
        this.amountCheckedOnSafeDrop = amountCheckedOnSafeDrop;
    }

    /** Getter for property moneyOrderLow.
     * @return Value of property moneyOrderLow.
     */
    public int getMoneyOrderLow() {
        return this.moneyOrderLow;
    }

    /** Setter for property moneyOrderLow.
     * @param moneyOrderLow New value of property moneyOrderLow.
     */
    public void setMoneyOrderLow(int moneyOrderLow) {
        this.moneyOrderLow = moneyOrderLow;
    }

    /** Getter for property oneCSRPerDrawerForced.
     * @return Value of property oneCSRPerDrawerForced.
     */
    public boolean isOneCSRPerDrawerForced() {
        return this.oneCSRPerDrawerForced;
    }

    /** Setter for property oneCSRPerDrawerForced.
     * @param oneCSRPerDrawerForced New value of property oneCSRPerDrawerForced.
     */
    public void setOneCSRPerDrawerForced(boolean oneCSRPerDrawerForced) {
        this.oneCSRPerDrawerForced = oneCSRPerDrawerForced;
    }

    /** Getter for property dobCheckForced.
     * @return Value of property dobCheckForced.
     */
    public boolean isDobCheckForced() {
        return this.dobCheckForced;
    }

    /** Setter for property dobCheckForced.
     * @param dobCheckForced New value of property dobCheckForced.
     */
    public void setDobCheckForced(boolean dobCheckForced) {
        this.dobCheckForced = dobCheckForced;
    }

    /** Getter for property errorMsgPromptTimer.
     * @return Value of property errorMsgPromptTimer.
     */
    public int getErrorMsgPromptTimer() {
        return this.errorMsgPromptTimer;
    }

    /** Setter for property errorMsgPromptTimer.
     * @param errorMsgPromptTimer New value of property errorMsgPromptTimer.
     */
    public void setErrorMsgPromptTimer(int errorMsgPromptTimer) {
        this.errorMsgPromptTimer = errorMsgPromptTimer;
    }

    /** Getter for property registerTimeout.
     * @return Value of property registerTimeout.
     */
    public int getRegisterTimeout() {
        return this.registerTimeout;
    }

    /** Setter for property registerTimeout.
     * @param registerTimeout New value of property registerTimeout.
     */
    public void setRegisterTimeout(int registerTimeout) {
        this.registerTimeout = registerTimeout;
    }

    /** Getter for property modifyKeyCyclingDisabled.
     * @return Value of property modifyKeyCyclingDisabled.
     */
    public boolean isModifyKeyCyclingDisabled() {
        return this.modifyKeyCyclingDisabled;
    }

    /** Setter for property modifyKeyCyclingDisabled.
     * @param modifyKeyCyclingDisabled New value of property modifyKeyCyclingDisabled.
     */
    public void setModifyKeyCyclingDisabled(boolean modifyKeyCyclingDisabled) {
        this.modifyKeyCyclingDisabled = modifyKeyCyclingDisabled;
    }

    /** Getter for property resetDisplayTimeout.
     * @return Value of property resetDisplayTimeout.
     */
    public int getResetDisplayTimeout() {
        return this.resetDisplayTimeout;
    }

    /** Setter for property resetDisplayTimeout.
     * @param resetDisplayTimeout New value of property resetDisplayTimeout.
     */
    public void setResetDisplayTimeout(int resetDisplayTimeout) {
        this.resetDisplayTimeout = resetDisplayTimeout;
    }

    /** Getter for property drawerAlarmTimer.
     * @return Value of property drawerAlarmTimer.
     *
     */
    public int getDrawerAlarmTimer() {
        return this.drawerAlarmTimer;
    }

    /** Setter for property drawerAlarmTimer.
     * @param drawerAlarmTimer New value of property drawerAlarmTimer.
     *
     */
    public void setDrawerAlarmTimer(int drawerAlarmTimer) {
        this.drawerAlarmTimer = drawerAlarmTimer;
    }

    /** Getter for property enforceGradePromptInside.
     * @return Value of property enforceGradePromptInside.
     */
    public boolean isEnforceGradePromptInside() {
        return this.enforceGradePromptInside;
    }

    /** Setter for property enforceGradePromptInside.
     * @param enforceGradePromptInside New value of property enforceGradePromptInside.
     */
    public void setEnforceGradePromptInside(boolean enforceGradePromptInside) {
        this.enforceGradePromptInside = enforceGradePromptInside;
    }

    /** Getter for property prepaidActivateDept.
     * @return Value of property prepaidActivateDept.
     */
    public DepartmentPK getPrepaidActivateDept() {
        return (this.prepaidActivateDept == null) ? new DepartmentPK(0) : this.prepaidActivateDept;
    }

    /** Setter for property prepaidActivateDept.
     * @param prepaidActivateDept New value of property prepaidActivateDept.
     */
    public void setPrepaidActivateDept(DepartmentPK prepaidActivateDept) {
        this.prepaidActivateDept = prepaidActivateDept;
    }

    /** Getter for property prepaidRechargeDept.
     * @return Value of property prepaidRechargeDept.
     */
    public DepartmentPK getPrepaidRechargeDept() {
        return (this.prepaidRechargeDept == null) ? new DepartmentPK(0) : this.prepaidRechargeDept;
    }

    /** Setter for property prepaidRechargeDept.
     * @param prepaidRechargeDept new prepaidRechargeDept
     */
    public void setPrepaidRechargeDept(DepartmentPK prepaidRechargeDept) {
        this.prepaidRechargeDept = prepaidRechargeDept;
    }

    /** Implementation method for visitable in visitor pattern
     * @param v visitor
     * @throws Exception on exception in visitor's visit method
     */
    public void accept(SalesEntityVisitor v) throws Exception {
        v.visit(this);
    }

    /**
     * Getter for property releaseTerminalDuringClose.
     * @return Value of property releaseTerminalDuringClose.
     */
    public boolean isReleaseTerminalDuringClose() {
        return this.releaseTerminalDuringClose;
    }

    /**
     * Setter for property releaseTerminalDuringClose.
     * @param releaseTerminalDuringClose New value of property releaseTerminalDuringClose.
     */
    public void setReleaseTerminalDuringClose(boolean releaseTerminalDuringClose) {
        this.releaseTerminalDuringClose = releaseTerminalDuringClose;
    }

    public String getFuelDiscountTitle() {
        return (fuelDiscountTitle == null) ? EMPTY_STR : fuelDiscountTitle;
    }

    public void setFuelDiscountTitle(String fuelDiscountTitle) {
        this.fuelDiscountTitle = fuelDiscountTitle;
    }
    
    /** Getter for property printDOBonReceipt.
     * @return Value of property printDOBonReceipt.
     */
    public boolean isPrintDOBonReceipt()
    {
    	return this.printDOBonReceipt;
    }
    
    /** Setter for property printDOBonReceipt.
     * @param printDOBonReceipt New value of property printDOBonReceipt.
     */
    public void setPrintDOBonReceipt(boolean PrintDOBReceiptVal)
    {
    	this.printDOBonReceipt = PrintDOBReceiptVal;
    }
    
    /** Getter for property printDOBJournalVal.
     * @return Value of property printDOBJournalVal.
     */
    public boolean isPrintDOBonJournal()
    {
    	return this.printDOBonJournal;
    }
    
    /** Setter for property printDOBJournalVal.
     * @param printDOBonJournal New value of property printDOBJournalVal.
     */
    public void setPrintDOBonJournal(boolean PrintDOBJournalVal)
    {
    	this.printDOBonJournal = PrintDOBJournalVal;
    }
    
//  line added by tattu 14 may 2007 for imprinter feature
    /** Getter for property forceImprinterEnable.
     * @return Value of property forceImprinterEnable.
     */
    public boolean isforceImprinterEnable()
    {
      //line added to check the imprinter feature working
        return this.forceImprinterEnable;
    }

    /** Setter for property forceImprinterEnable.
     * @param forceImprinterEnable New value of property forceImprinterEnable.
     */

    public void setforceImprinterEnable(boolean forceImprinterEnable) {
        this.forceImprinterEnable = forceImprinterEnable;
    }
    /**
     * @return the maximumTillTransAmount
     */
    public MoneyAmount getMaximumTillTransAmount() {
        return maximumTillTransAmount;
    }

    /**
     * @param newAmount the maximumTillTransAmount to set
     */
    public void setMaximumTillTransAmount(MoneyAmount newAmount) {
		if (newAmount != null) {
			this.maximumTillTransAmount = newAmount;
		}
    }

    /** Getter for property cardLoadRechargeDept.
     * @return Value of property cardLoadRechargeDept.
     */
    public DepartmentPK getCardLoadRechargeDept() {
        return (this.cardLoadRechargeDept == null) ? new DepartmentPK(0) : this.cardLoadRechargeDept;
    }
    /** Setter for property cardLoadRechargeDept.
     * @param cardLoadRechargeDept New value of property cardLoadRechargeDept.
     */
    public void setCardLoadRechargeDept(DepartmentPK cardLoadRechargeDept) {
        this.cardLoadRechargeDept = cardLoadRechargeDept;


    }
    
    public boolean isDisplayPLUNotFoundDeptList() {
        return DisplayPLUNotFoundDeptList;
    }

    public void setDisplayPLUNotFoundDeptList(boolean displayPLUNotFoundDeptList) {
        DisplayPLUNotFoundDeptList = displayPLUNotFoundDeptList;
	}

	/**
	 * Getter for property promptLoyaltyForPluNF
	 * 
	 * @return Value of property promptLoyaltyForPluNF
	 */
	public boolean isPromptLoyaltyForPluNF() {
		return promptLoyaltyForPluNF;
	}

	/**
	 * Setter for property promptLoyaltyForPluNF
	 * 
	 * @param promptLoyaltyForPluNF
	 *            New value of property promptLoyaltyForPluNF
	 */
	public void setPromptLoyaltyForPluNF(boolean promptLoyaltyForPluNF) {
		this.promptLoyaltyForPluNF = promptLoyaltyForPluNF;
    }

	/**
	 * @return the swbRegulationRequired
	 */
	public boolean isSwbRegulationRequired() {
		return swbRegulationRequired;
	}

	/**
	 * @param swbRegulationRequired the swbRegulationRequired to set
	 */
	public void setSwbRegulationRequired(boolean swbRegulationRequired) {
		this.swbRegulationRequired = swbRegulationRequired;
	}
	

	/** Getter for property openDrawerCashierClose. cr6668
	 * @return Value of property openDrawerCashierClose.
	 */
	public boolean isOpenDrawerCashierClose() {
		return this.openDrawerCashierClose;
	}

	/** Setter for property openDrawerCashierClose.	cr6668
	* @param openDrawerCashierClose New value of property openDraRwerCashierClose.
	*/
	public void setOpenDrawerCashierClose(boolean openDrawerCashierClose) {
		this.openDrawerCashierClose = openDrawerCashierClose;
	}
	
	public boolean isReceiptTaxDetailEnabled() {
		return receiptTaxDetailEnabled;
	}

	public void setReceiptTaxDetailEnabled(boolean receiptTaxDetailEnabled) {
		this.receiptTaxDetailEnabled = receiptTaxDetailEnabled;
	}

    public boolean isDiscountDenomEnabled() {
        return discountDenomEnabled;
    }
    public void setDiscountDenomEnabled(boolean discountDenomEnabled) {
        this.discountDenomEnabled = discountDenomEnabled;
    }

    public boolean isUPCDetailEnabled() {
		return upcDetailEnabled;
	}

	public void setUPCDetailEnabled(boolean upcDetailEnabled) {
		this.upcDetailEnabled = upcDetailEnabled;
	}

	public boolean isCntUnderrunCustsEnabled() {
	    return cntUnderrunCustsEnabled;
	}

	public void setCntUnderrunCustsEnabled(boolean cntUnderrunCustsEnabled) {
	    this.cntUnderrunCustsEnabled = cntUnderrunCustsEnabled;
	}

    public boolean isStackManualDiscountEnabled() {
        return stackManualDiscount;
    }
    public void setStackManualDiscountEnabled(boolean stackManualDiscount) {
        this.stackManualDiscount = stackManualDiscount;
    }

	public boolean isAllowAmountEntryForRefund() {
		return allowAmountEntryForRefund;
	}

	public void setAllowAmountEntryForRefund(boolean allowAmountEntryForRefund) {
		this.allowAmountEntryForRefund = allowAmountEntryForRefund;
	}

	/**
	 * Getter for property promptDineIn
	 * 
	 * @return Value of property promptDineIn
	 */
	public boolean isPromptDineIn() {
		return promptDineIn;
	}

	/**
	 * Setter for property promptDineIn
	 * 
	 * @param promptDineIn
	 *            New value of property promptDineIn
	 */
	public void setPromptDineIn(boolean promptDineIn) {
		this.promptDineIn = promptDineIn;
    }

	public ReceiptPrintProgramNameType getReceiptPrintProgramNameType() {
		return receiptPrintProgramNameType;
	}

	public void setReceiptPrintProgramNameType(ReceiptPrintProgramNameType receiptPrintProgramNameType) {
		this.receiptPrintProgramNameType = receiptPrintProgramNameType;
	}

	public boolean isFoodOrderCustomerNameprompt() {
		return foodOrderCustomerNameprompt;
	}

	public void setFoodOrderCustomerNameprompt(boolean foodOrderCustomerNameprompt) {
		this.foodOrderCustomerNameprompt = foodOrderCustomerNameprompt;
	}

	public boolean isFoodOrderCustomerPhoneNumberprompt() {
		return foodOrderCustomerPhoneNumberprompt;
	}
	
	public void setFoodOrderCustomerPhoneNumberprompt(boolean foodOrderCustomerPhoneNumberprompt) {
		this.foodOrderCustomerPhoneNumberprompt = foodOrderCustomerPhoneNumberprompt;
	}
	
}