/*-
 * Created March 30, 2003										David C. Brown
 *
 * Copyright (C) VeriFone, Inc. 							ALL RIGHTS RESERVED
 *
 * Collect the strings distributed throughout the application into a resource
 * bundle for localization (L10N)..
 *
 */

package com.verifone.isd.vsms2.sys.l10n;

import java.util.ListResourceBundle;

/**
 * Strings here have constants that reference the string key used for lookup.
 * This looks redundant, but allows compile-time checking that we have at least
 * a valid key to index.
 *
 * @author	David C. Brown IV
 * @version 0.1
 */

public class SalesConfigRes extends ListResourceBundle {
    public final static String PLU_NOT_FND_DEPT     = "PLU_NOT_FND_DEPT";
    public final static String MAXIMUM_QTY          = "MAXIMUM_QTY";
    public final static String MAXIMUM_AMT          = "MAXIMUM_AMT";
    public final static String MINIMUM_AMT          = "MINIMUM_AMT";
    public final static String MAXIMUM_DISC         = "MAXIMUM_DISC";
    public final static String MINIMUM_DISC         = "MINIMUM_DISC";
    public final static String REFER_DISC           = "REFER_DISC";
    public final static String DISCOUNT_TYPE        = "DISCOUNT_TYPE";
    public final static String IS_FIXED_DISC        = "IS_FIXED_DISC";
    public final static String FIXED_DISC_RATE      = "FIXED_DISC_RATE";
    public final static String NUM_CASH_DRWS        = "NUM_CASH_DRWS";
    public final static String CSR_PROMPT_SALE      = "CSR_PROMPT_SALE";
    public final static String SUBTOTAL_REQD        = "SUBTOTAL_REQD";
    public static final String TOTAL_IN_DBL         = "TOTAL_IN_DBL";
    public static final String PRINT_RCPT           = "PRINT_RCPT";
    public static final String VOID_LINE_PRINT      = "VOID_LINE_PRINT";
    public static final String VOID_TXN_PRINT       = "VOID_TXN_PRINT";
    public static final String NO_SALE_PRINT        = "NO_SALE_PRINT";
    public static final String REFUND_PRINT         = "REFUND_PRINT";
    public static final String DUE_SALES_PROMPT     = "DUE_SALES_PROMPT";
    public static final String DRW_OPEN_SALE        = "DRW_OPEN_SALE";
    public static final String RESET_DISP_DRWC      = "RESET_DISP_DRWC";
    public static final String RESET_DISP_ON_TO     = "RESET_DISP_ON_TO";
    public static final String RESET_DISP_TIME      = "RESET_DISP_TIME";
    public static final String IS_GST               = "IS_GST";
    public static final String IS_VAT               = "IS_VAT";
    public static final String STORE_NUMBER         = "STORE_NUMBER";
    public static final String ENABLE_FAST_CRED     = "ENABLE_FAST_CRED";
    public static final String ENABLE_AUTO_REFUND   = "ENABLE_AUTO_REFUND";
    public static final String CASH_AUTO_REFUND   	= "CASH_AUTO_REFUND";
    public static final String ENABLE_AUTO_SETTLE_OVERRUN   = "ENABLE_AUTO_SETTLE_OVERRUN";
    public static final String CHECK_DRWAMT_SD      = "CHECK_DRWAMT_SD";
    public static final String MONEY_ORDER_LOW      = "MONEY_ORDER_LOW";
    public static final String ONE_CSR_PER_DRW      = "ONE_CSR_PER_DRW";
    public static final String FORCE_DOB_CHECK      = "FORCE_DOB_CHECK";
    public static final String ERR_PROMPT_TIME      = "ERR_PROMPT_TIME";
    public static final String REG_TIMEOUT          = "REG_TIMEOUT";
    public static final String NO_MODIF_CYCLE       = "NO_MODIF_CYCLE";
    public static final String DRAWER_ALARM_TIMER   = "DRAWER_ALARM_TIMER";
    public final static String PPD_ACTIVATE_DEPT    = "PPD_ACTIVATE_DEPT";
    public final static String PPD_RECHARGE_DEPT    = "PPD_RECHARGE_DEPT";
    public final static String PLU_NOT_FOUND_ERROR  = "PLU_NOT_FOUND_ERROR";
    public final static String PLU_NOT_FOUND_IN_DEPT_ERROR  = "PLU_NOT_FOUND_IN_DEPT_ERROR";
    public final static String RELEASE_TERMINAL_DURING_CLOSE  = "RELEASE_TERMINAL_DURING_CLOSE";
    public final static String FUEL_DISCOUNT_TITLE = "FUEL_DISCOUNT_TITLE";
    public final static String NO_DISCOUNT_ALLOWED = "NO_DISCOUNT_ALLOWED";
    public final static String DISABLE_ERROR_CORRECT_KEY = "DISABLE_ERROR_CORRECT_KEY";
    
    public final static String RECEIPT_PRINT_PROGRAM_NAME_TYPE   = "RECEIPT_PRINT_PROGRAM_NAME_TYPE";
    //code added by paul 14 may 2007
    /**
     * "Force Imprinter" is "Reminder to use Imprinter"
     */
    public static final String FORCE_IMPRINTER="FORCE_IMPRINTER";

    //code added to add property Maximum Till Transaction Amount in sales config
	public static final String MAX_TILL_TRANS_AMT = "MAX_TILL_TRANS_AMT";
    public final static String DISP_PNF_DEP_LIST="DISP_PNF_DEP_LIST";
    public final static String PROMPT_LOY_PLU_NF = "PROMPT_LOY_PLU_NF";

    // DOB masking changes CR6477
    public final static String PRINT_DOB_RECEIPT = "PRINT_DOB_RECEIPT";
    public final static String PRINT_DOB_JOURNAL = "PRINT_DOB_JOURNAL";
    public final static String PRINT_UPC_RECEIPT = "PRINT_UPC_RECEIPT";

    /**
     * Accessor for the actual strings that have been internationalized.
     */
    public final static String CARDLOAD_RECHARGE_DEPT="CARDLOAD_RECHARGE_DEPT";

	//CR6668 Open Cash Drawer on cashier close
	public final static String OPEN_DRW_CSR_CLOSE = "OPEN_DRW_CSR_CLOSE";
	public final static String ENABLE_RECEIPT_TAX_DETAIL = "ENABLE_RECEIPT_TAX_DETAIL";
    
    // Discount Denomination CR0768.01
    public final static String ENABLE_DISC_DENOMINATION = "ENABLE_DISC_DENOMINATION";
    // Discount Denomination CR0768.02
    public final static String ENABLE_STACK_MANUAL_DISC = "ENABLE_STACK_MANUAL_DISC";

    public final static String ENABLE_MANAGED_UPDATE = "ENABLE_MANAGED_UPDATE";
    public final static String COUNT_UNDERRUN_CUSTS = "COUNT_UNDERRUN_CUSTS";
    public final static String ALLOW_AMOUNT_ENTRY_FOR_REFUND = "ALLOW_AMOUNT_ENTRY_FOR_REFUND";
	//CR1045.01 Food Service Prompt for dine in
	public static final String PROMPT_DINE_IN = "PROMPT_DINE_IN";
	//CR1670.01 Name and Phone Number on Food Order
	public static final String PROMPT_FOOD_ORDER_NAME = "PROMPT_FOOD_ORDER_NAME";
	public static final String PROMPT_FOOD_ORDER_PHONE_NUMBER = "PROMPT_FOOD_ORDER_PHONE_NUMBER";

	//TransactionTypes enum localized string
	public static final String SALE="SALE";
	public static final String REFUND="REFUND";
	public static final String NOSALE="NOSALE";
	public static final String SAFEDROP="SAFEDROP";
	public static final String SAFELOAN="SAFELOAN";
	public static final String PAYOUT="PAYOUT";
	public static final String PAYIN="PAYIN";
	public static final String CLOCKOUT="CLOCKOUT";
	public static final String CLOCKIN="CLOCKIN";
	public static final String FREEPOPCODE="FREEPOPCODE";
	public static final String FREEAUTOPOPCODE="FREEAUTOPOPCODE";
	public static final String FREEPOPCOUPON="FREEPOPCOUPON";
	public static final String KIOSKORDER="KIOSKORDER";
	public static final String SAFEDROP_CORRECTION="SAFEDROP_CORRECTION";

    public Object[][] getContents() {
        return contents;
    }

    static private final Object[][] contents = {
        {  PLU_NOT_FND_DEPT     , "PLU not found department"},
        {  MAXIMUM_QTY          , "Maximum quantity"},
        {  MAXIMUM_AMT          , "Maximum amount"},
        {  MINIMUM_AMT          , "Minimum amount"},
        {  MAXIMUM_DISC         , "Maximum discount"},
        {  MINIMUM_DISC         , "Minimum discount"},
        {  REFER_DISC           , "Fuel discount"},
        {  DISCOUNT_TYPE        , "Discount type - Pct or Amt"},
        {  IS_FIXED_DISC        , "Is fixed Discount"},
        {  FIXED_DISC_RATE      , "Fixed Discount rate"},
        {  NUM_CASH_DRWS        , "Cash drawers connected"},
        {  CSR_PROMPT_SALE      , "Is cashier # required for each sale"},
        {  SUBTOTAL_REQD        , "Is sub-total required"},
        {  TOTAL_IN_DBL         , "Is total in double"},
        {  PRINT_RCPT           , "Print receipt"},
        {  VOID_LINE_PRINT      , "Force void line print"},
        {  VOID_TXN_PRINT       , "Force void transaction print"},
        {  NO_SALE_PRINT        , "Force no sale print"},
        {  REFUND_PRINT         , "Force refund print"},
        {  DUE_SALES_PROMPT     , "Idle prompt displays due sale"},
        {  DRW_OPEN_SALE        , "Drawer open during sale"},
        {  RESET_DISP_DRWC      , "Reset display on drawer close"},
        {  RESET_DISP_ON_TO     , "Reset display on timeout"},
        {  RESET_DISP_TIME      , "Reset display timeout value"},
        {  IS_GST               , "Canadian GST"},
        {  IS_VAT               , "Value added tax (VAT)"},
        {  STORE_NUMBER         , "Store number"},
        {  ENABLE_FAST_CRED     , "Enable fast credit"},
        {  ENABLE_AUTO_REFUND   , "Enable auto refund"},
        {  CASH_AUTO_REFUND   	, "Cash under run auto refund"},
        {  ENABLE_AUTO_SETTLE_OVERRUN   , "Enable auto settle overrun"},
        {  CHECK_DRWAMT_SD      , "Check drawer amount on safe drop"},
        {  MONEY_ORDER_LOW      , "Money order low"},
        {  ONE_CSR_PER_DRW      , "One Cashier per Drawer"},
        {  FORCE_DOB_CHECK      , "Force DOB on ID Check"},
        {  ERR_PROMPT_TIME      , "Error Message Prompt Timer"},
        {  REG_TIMEOUT          , "Register Time-Out Timer"},
        {  NO_MODIF_CYCLE       , "Prevent Modify Key Cycling"},
        {  DRAWER_ALARM_TIMER   , "Drawer Alarm Timer"},
        {  PPD_ACTIVATE_DEPT    , "Prepaid Card Activate Department"},
        {  PPD_RECHARGE_DEPT    , "Prepaid Card Recharge Department"},
        {  PLU_NOT_FOUND_ERROR  , "PLU {0} not found"},
        {  PLU_NOT_FOUND_IN_DEPT_ERROR  , "PLU {0} of Dept {1} not found"},
        {  RELEASE_TERMINAL_DURING_CLOSE  , "Release Terminal During Close"},
        {  FUEL_DISCOUNT_TITLE , "Fuel Discount Title"},
        {  FORCE_IMPRINTER		,"Reminder to use Imprinter"},
        { MAX_TILL_TRANS_AMT,"Maximum Till Transaction Amount"},
        {  CARDLOAD_RECHARGE_DEPT , "Cardload Recharge Dept"},
        { DISP_PNF_DEP_LIST, "Display PLU not found Department List"},
        {  PRINT_DOB_RECEIPT    , "Print DOB on Receipt"},
        {  PRINT_DOB_JOURNAL    , "Print DOB on Journal"},
        { PRINT_UPC_RECEIPT	, "Print UPC on Receipt"}, 
        { PROMPT_LOY_PLU_NF, "Prompt Loyalty for PLU Not Found" },
		{  OPEN_DRW_CSR_CLOSE    , "Open Drawer Cashier Close"},
		{  ENABLE_RECEIPT_TAX_DETAIL    , "Enable Receipt Tax Detail"},
        {  ENABLE_DISC_DENOMINATION     , "Discount Denomination"},
        {  ENABLE_STACK_MANUAL_DISC, "Stack Manual Discount"},
		{  ENABLE_MANAGED_UPDATE    , "Enable Managed Update"},
        {  NO_DISCOUNT_ALLOWED    , "No Discount Allowed"},
        { DISABLE_ERROR_CORRECT_KEY , "Disable Error Correct Key"},
        {  COUNT_UNDERRUN_CUSTS    , "Count Underrun Customers"},
        {  ALLOW_AMOUNT_ENTRY_FOR_REFUND, "Allow amount entry for refund"},
		{  PROMPT_DINE_IN        , "Prompt Dine In"},
        {  RECEIPT_PRINT_PROGRAM_NAME_TYPE  , "Receipt Print Program Name"},
		{ PROMPT_FOOD_ORDER_NAME   , "Prompt Food Order Name"},
		{ PROMPT_FOOD_ORDER_PHONE_NUMBER, "Prompt Food Order Phone #"},
		{ SALE, "SALE"},
		{ REFUND, "REFUND"},
		{ NOSALE, "NOSALE"},
		{ SAFEDROP, "SAFEDROP"},
		{ SAFELOAN, "SAFELOAN"},
		{ PAYOUT, "PAYOUT"},
		{ PAYIN, "PAYIN"},
		{ CLOCKOUT, "CLOCKOUT"},
		{ CLOCKIN, "CLOCKIN"},
		{ FREEPOPCODE, "FREE POP CODE"},
		{ FREEAUTOPOPCODE, "FREE AUTO POP CODE"},
		{ FREEPOPCOUPON, "FREE POP COUPON"},
		{ KIOSKORDER, "KIOSK ORDER"},
		{ SAFEDROP_CORRECTION, "SDRP CORR"}
   };
}