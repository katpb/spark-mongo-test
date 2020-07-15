/*-
 * Created March 30, 2003										David C. Brown
 *
 * Copyright (C) VeriFone, Inc. 							ALL RIGHTS RESERVED
 *
 * Collect the strings distributed throughout the application into a resource
 * bundle for localization (L10N). 
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
		

public class TopazRes extends ListResourceBundle {
	
	public final static String VOLUME_CONTROL_TITLE = "VOLUME_CONTROL_TITLE";
	public final static String BRIGHTNESS_CONTROL_TITLE = "BRIGHTNESS_CONTROL_TITLE";
	public final static String SCREEN_SAVER_CONTROL_TITLE = "SCREEN_SAVER_CONTROL_TITLE";
	public final static String	READY="READY";
	public final static String	DSP_REFUND="DSP_REFUND";
	public final static String	INVAL_AMT="INVAL_AMT";
	public final static String	INVAL_ACCT="INVAL_ACCT";
	public final static String	INVAL_SUB_ACCT="INVAL_SUB_ACCT";
	public final static String	INVAL_MOP="INVAL_MOP";
	public final static String	MOP_STICKY="MOP_STICKY";
	public final static String	STOT_REQD="STOT_REQD";
	public final static String	FINTICK="FINTICK";
	public final static String	SUBTOTAL="SUBTOTAL";
	public final static String	TAX="TAX";
	public final static String	TOTAL="TOTAL";
	public final static String	CASH="CASH";
	public final static String	PAID="PAID";
	public final static String	CHANGE="CHANGE";
	public final static String	AMT_DUE="AMT_DUE";
	public final static String	RCPT_HDR_DESCRIPTION = "RCPT_HDR_DESCRIPTION";
	public final static String	RCPT_HDR_QUANTITY = "RCPT_HDR_QUANTITY";
	public final static String	RCPT_HDR_AMOUNT = "RCPT_HDR_AMOUNT";
	public final static String	SYSTEM_MSGS="SYSTEM_MSGS";
	public final static String	EK_SYSTEM_MSGS="EK_SYSTEM_MSGS";    // moniker for express key
	public final static String	EK_DISMISS_SYSTEM_MSGS="EK_DISMISS_SYSTEM_MSGS";    // moniker for express key
	public final static String	OK="OK";
	public final static String	CANCEL="CANCEL";
	public final static String	Cancel="Cancel";
	public final static String	SAVE="Save";
	public final static String	ENABLED="Enabled";
	public final static String	DISABLED="Disabled";
	public final static String	YES="YES";
	public final static String	NO="NO";
	public final static String	QUIT_APPL="QUIT_APPL";
	public final static String	PRINT_TKT="PRINT_TKT";
	public final static String	HELP="HELP";
        public final static String	Help="Help";
	public final static String DISMISS_HELP="DISMISS_HELP";
	public final static String	CSR_FCT="CSR_FCT";
	public final static String	SUSPEND="SUSPEND";
	public final static String	RECALL="RECALL";
	public final static String	KEY_LBL_PCHECK="KEY_LBL_PCHECK";
	public final static String	CUSTOMER_LOGO = "CUSTOMER_LOGO";
	public final static String	VERIFONE_LOGO = "VERIFONE_LOGO";
	public final static String	MENU_SCREEN_BUTTON_IMAGE   = "MENU_SCREEN_BUTTON_IMAGE";
	public final static String	MENU_NORMAL_BUTTON_IMAGE   = "MENU_NORMAL_BUTTON_IMAGE";
	public final static String	MENU_DISABLED_BUTTON_IMAGE = "MENU_DISABLED_BUTTON_IMAGE";
	public final static String OK_BUTTON_IMAGE= "OK_BUTTON_IMAGE";
	public final static String CANCEL_BUTTON_IMAGE= "CANCEL_BUTTON_IMAGE";
	public final static String TOUCH_SCREEN_TO_LOGIN = "TOUCH_SCREEN_TO_LOGIN";
	public final static String PRESS_ENTER_OR_TOUCH_SCREEN_TO_LOGIN = "PRESS_ENTER_OR_TOUCH_SCREEN_TO_LOGIN";
	public final static String ENTER_ID_AND_PASSWORD = "ENTER_ID_AND_PASSWORD";
	public final static String ID = "ID";
	public final static String PASSWORD = "PASSWORD";

	public final static String LOGIN = "LOGIN";
	public final static String ENTER_ID = "ENTER_ID";
	public final static String ENTER_PASSWORD = "ENTER_PASSWORD";
	
	public final static String ENTER_DISC_AMOUNT = "ENTER_DISC_AMOUNT";
	public final static String ENTER_QTY = "ENTER_QTY";
	public final static String ENTER_PERCENT = "ENTER_PERCENT";
	public final static String ENTER_DISC_PERCENT = "ENTER_DISC_PERCENT";
	public final static String SLIP_HEADER = "SLIP_HEADER";
	public final static String IMAGE_PATH  = "IMAGE_PATH";
	public final static String DISMISS_REPORT="DISMISS_REPORT";
	public final static String PRINT_REPORT="PRINT_REPORT";
	public final static String SAVE_REPORT="SAVE_REPORT";
	public static final String CONFIRM_SELECTION="CONFIRM_SELECTION";
	public static final String SKIP_SELECTION="SKIP_SELECTION";

	public final static String	RDH_TPCR="RDH_TPCR";
	public final static String	HEADER_WITH_UNIT_PRICE="HEADER_WITH_UNIT_PRICE";
	public static final String	TKT_REFUND="TKT_REFUND";
	public static final String TKT_SUSPENDED="TKT_SUSPENDED";
	public static final String	TKT_CASHBACK="TKT_CASHBACK";
	public static final String	TKT_PMT_FEE="TKT_PMT_FEE";
	public static final String	TKT_SUBTOT="TKT_SUBTOT";
	public static final String	TKT_TAX="TKT_TAX";
	public static final String	TKT_ALL_TAX="TKT_ALL_TAX";
	public static final String	TKT_TAX_EXEMPT_HEADER="TKT_TAX_EXEMPT_HEADER";
	public static final String	TKT_TAX_EXEMPT_EMPTY="TKT_TAX_EXEMPT_EMPTY";
	public static final String	TKT_TAX_SUMMARY="TKT_TAX_SUMMARY";
	public static final String	TKT_TAX_EXEMPT="TKT_TAX_EXEMPT";
	public static final String	TKT_TOTAL="TKT_TOTAL";
	public static final String	TKT_BODY_SEP="TKT_BODY_SEP";
	public static final String	TKT_CUST_DOB_VERF="TKT_CUST_DOB_VERF";
	public static final String	TKT_VOID_TRAN="TKT_VOID_TRAN";
	public static final String	TKT_VOID_LINE="TKT_VOID_LINE";
	public static final String	TKT_REFUND_LINE="TKT_REFUND_LINE";
	public static final String	TKT_REPRNT_TRAN="TKT_REPRNT_TRAN";
	public static final String	TKT_REPRNT_FUEL="TKT_REPRNT_FUEL";
	public static final String	TKT_PRINT_DEAL_DISC="TKT_PRINT_DEAL_DISC";
	public static final String	TKT_DRIVE_OFF_1="TKT_DRIVE_OFF_1";
	public static final String	TKT_DRIVE_OFF_2="TKT_DRIVE_OFF_2";
	public static final String	TKT_DRIVE_OFF_3="TKT_DRIVE_OFF_3";
	public static final String	TKT_DRIVE_OFF_4="TKT_DRIVE_OFF_4";
	public static final String	TKT_NOPLU_HDR1="TKT_NOPLU_HDR1";
	public static final String	TKT_NOPLU_HDR2="TKT_NOPLU_HDR2";
	public static final String	TKT_NOPLU_HDR3="TKT_NOPLU_HDR3";
	public static final String	TKT_NOPLU_HDR4="TKT_NOPLU_HDR4";
	public static final String	FS_SUBTOT="FS_SUBTOT";
	public static final String	FS_TAX_CREDIT="FS_TAX_CREDIT";
	public static final String	FS_CHANGE="FS_CHANGE";
	public static final String	CHANGE_DUE="CHANGE_DUE";
	public static final String	POLE_DISP_TOTAL="POLE_DISP_TOTAL";
	public static final String	POLE_DISP_CHANGE="POLE_DISP_CHANGE";
	public static final String	POLE_DISP_PCHECK="POLE_DISP_PCHECK";
	public static final String	POLE_DISP_CLOSED="POLE_DISP_CLOSED";
	public static final String	POLE_DISP_DISC="POLE_DISP_DISC";
	public static final String	POLE_DISP_TOT="POLE_DISP_TOT";
	public static final String   DOB_SKIPPED="SKIPPED";
	public static final String   DOB_FAILED="FAILED";
	public static final String   PREPAY_PRODUCT = "PREPAY_PRODUCT";
	public static final String  PREPAID_RECEIPT_TEXT = "PREPAID_RECEIPT_TEXT";
	public static final String  PREAUTH_RECEIPT_TEXT = "PREAUTH_RECEIPT_TEXT";

	public static final String   PAYMENT_TIME = "PAYMENT_TIME";
	public static final String	CARD_TYPE = "CARD_TYPE";
	public static final String	CARD_NAME = "CARD_NAME";
	public static final String	ACCT_NUMBER = "ACCT_NUMBER";
	public static final String	EXP_DATE = "EXP_DATE";
	public static final String	TRANS_TYPE = "TRANS_TYPE";
	public static final String	APPROVAL = "APPROVAL";
	public static final String REFERENCE = "REFERENCE";
	public static final String AUTH_NO = "AUTH_NO";
	public static final String INVOICE = "INVOICE";
	public static final String ODOMETER = "ODOMETER";
	public static final String VEHICLE = "VEHICLE";
	public static final String JOB_NUMBER = "JOB_NUMBER";
	public static final String USER_DATA = "USER_DATA";
	public static final String SIGNATURE_FMT = "SIGNATURE_FMT";
	public static final String ASTERISK_FMT = "ASTERISK_FMT";
	public static final String CONTACTLESS_FMT = "CONTACTLESS_FMT";
	public static final String AGREEMENT_LINE1 = "AGREEMENT_LINE1";
	public static final String AGREEMENT_LINE2 = "AGREEMENT_LINE2";
	public static final String NO_SIGNATURE = "NO_SIGNATURE";
	public static final String TOP_COPY = "TOP_COPY";

	public static final String	 TKT_PLU_ADJ_HDR = "TKT_PLU_ADJ_HDR";
	public static final String	 TKT_PLU_ADJ_TXT = "TKT_PLU_ADJ_TXT";
	public static final String	 TKT_PLU_ADJ_DSC = "TKT_PLU_ADJ_DSC";

	public static final String  SYSTEM_INIT_MSG = "SYSTEM_INIT_MSG";
	public static final String REFERENCE_SMALL = "REFERENCE_SMALL";
    public static final String DSC = "DSC";
	public static final String SERIAL_NUMBER = "SERIAL_NUMBER";

	//Strings for menu captions - begin
    //The strings here should correspond with the values in the appropriate XML
    // files
    public static final String MAIN_MENU = "MainMenu";
    public static final String MENU_FN_REPORT = "ReportMgrMenu";
    public static final String MENU_FN_NETWORK = "NetworkMgrMenu";
    public static final String MENU_FN_FUEL = "FuelMgrMenu";
    public static final String MENU_FN_REG_MAINT = "RegMaintMenu";
    public static final String MENU_FN_CONFIGCLIENT = "ConfigClient";


    public static String ADVANCED_OPTIONS_MENU = "ADVANCED_OPTIONS_MENU";
    public static String ADVANCED_OPTIONS_IMAGE_FILE = "ADVANCED_OPTIONS_IMAGE_FILE";
    public static String ADVANCED_OPTIONS_HOURS_FILTER_ABBR = "ADVANCED_OPTIONS_HOURS_FILTER_ABBR";
    public static String ADVANCED_OPTIONS_DATE_TIME_FILTER_ABBR="ADVANCED_OPTIONS_DATE_TIME_FILTER_ABBR";
    public static String ADVANCED_OPTIONS_FUELLING_POSITION_FILTER_ABBR="ADVANCED_OPTIONS_FUELLING_POSITION_FILTER_ABBR";
    public static String ADVANCED_OPTIONS_MOP_FILTER_ABBR="ADVANCED_OPTIONS_MOP_FILTER_ABBR";
    public static String ADVANCED_OPTIONS_FUEL_ONLY_FILTER_ABBR="ADVANCED_OPTIONS_FUEL_ONLY_FILTER_ABBR";
    public static String ADVANCED_OPTIONS_MERCHANDISE_ONLY_FILTER_ABBR="ADVANCED_OPTIONS_MERCHANDISE_ONLY_FILTER_ABBR";
    public static String ADVANCED_OPTIONS_FUEL_PLUS_MERCHANDISE_FILTER_ABBR="ADVANCED_OPTIONS_FUEL_PLUS_MERCHANDISE_FILTER_ABBR";
    public static String ADVANCED_OPTIONS_CARD_TYPE_FILTER_ABBR="ADVANCED_OPTIONS_CARD_TYPE_FILTER_ABBR";
    public static String ADVANCED_OPTIONS_REGISTER_FILTER_ABBR="ADVANCED_OPTIONS_REGISTER_FILTER_ABBR";
    public static String ADVANCED_OPTIONS_SECONDARY_ORM_HEADER_MOP="ADVANCED_OPTIONS_SECONDARY_ORM_HEADER_MOP";
    public static String ADVANCED_OPTIONS_SECONDARY_HEADER_MOP = "ADVANCED_OPTIONS_SECONDARY_HEADER_MOP";
    public static String ADVANCED_OPTIONS_SECONDARY_ORM_HEADER_CARD="ADVANCED_OPTIONS_SECONDARY_ORM_HEADER_CARD";
    public static String ADVANCED_OPTIONS_SECONDARY_HEADER_CARD = "ADVANCED_OPTIONS_SECONDARY_HEADER_CARD";
    public static String ADVANCED_OPTIONS_PRIMARY_ORM_CHOOSE_A_TRANSACTION = "ADVANCED_OPTIONS_PRIMARY_ORM_CHOOSE_A_TRANSACTION";
    public static String ADVANCED_OPTIONS_ERROR_NO_PAID_TRANS = "ADVANCED_OPTIONS_ERROR_NO_PAID_TRANS";
    public static String ADVANCED_OPTIONS_ERROR_NO_CARD_TRANS = "ADVANCED_OPTIONS_ERROR_NO_CARD_TRANS";
    public static String ADVANCED_OPTIONS_ERROR_NO_TRANS_FOR_FILTER_CRITERIA = "ADVANCED_OPTIONS_ERROR_NO_TRANS_FOR_FILTER_CRITERIA";
    public static String ADVANCED_OPTIONS_ERROR_INVALID_SELECTION = "ADVANCED_OPTIONS_ERROR_INVALID_SELECTION";
    public static String ADVANCED_OPTIONS_ERROR_RECALL_NOT_POSSIBLE = "ADVANCED_OPTIONS_ERROR_RECALL_NOT_POSSIBLE";
    public static String ADVANCED_OPTIONS_FILTER_HEADER_PREFIX = "ADVANCED_OPTIONS_FILTER_HEADER_PREFIX";
    public static final String ADVANCED_OPTIONS_HOURS = "ADVANCED_OPTIONS_HOURS" ;
	public static final String ADVANCED_OPTIONS_DATE_TIME = "ADVANCED_OPTIONS_DATE_TIME" ;
	public static final String ADVANCED_OPTIONS_FUELLING_POSITION = "ADVANCED_OPTIONS_FUELLING_POSITION";
	public static final String ADVANCED_OPTIONS_MOP = "ADVANCED_OPTIONS_MOP";
	public static final String ADVANCED_OPTIONS_FUEL_ONLY = "ADVANCED_OPTIONS_FUEL_ONLY";
	public static final String ADVANCED_OPTIONS_FUEL_PLUS_MERCHANDISE = "ADVANCED_OPTIONS_FUEL_PLUS_MERCHANDISE";
	public static final String ADVANCED_OPTIONS_MERCHANDISE_ONLY = "ADVANCED_OPTIONS_MERCHANDISE_ONLY";
	public static final String ADVANCED_OPTIONS_CARD_TYPE = "ADVANCED_OPTIONS_CARD_TYPE";
	public static final String ADVANCED_OPTIONS_REGISTER = "ADVANCED_OPTIONS_REGISTER";
	public static final String ADVANCED_OPTIONS_DATE = "ADVANCED_OPTIONS_DATE";
	public static final String ADVANCED_OPTIONS_TIME = "ADVANCED_OPTIONS_TIME";
	public static final String CONFLICT_IN_TRANSACTION_TYPE = "CONFLICT_IN_TRANSACTION_TYPE";
	public static final String PAYMENT_PROCESSED = "PAYMENT_PROCESSED";
	
    public static final String REPORT_FUNCTIONS_MENU = "ReportMgrFunctionsMenu";
    public static final String REPORT_CLOSE_CASHIER = "CloseCashier";
    public static final String REPORT_PRINT_CASHIER = "PrintCashier";
    public static final String REPORT_PRINT_CURRENT_CASHIER = "REPORT_PRINT_CURRENT_CASHIER";
    public static final String REPORT_CASHIER_WORKSHEET = "CashierWorksheet";
    public static final String REPORT_CLOSE_ATTENDANT = "CloseAttendant";
    public static final String REPORT_PRINT_ATTENDANT = "PrintAttendant";

    public static final String REPORT_CLOSE = "CloseReport";
    public static final String REPORT_PRINT = "PrintReport";
    public static final String REPORT_PAYROLL_REPORTS = "PayrollReports";
    public static final String REPORT_FUNDS_AUDIT = "FundsAudit";
    public static final String REPORT_FLASH_REPORTS = "FlashReports";
    public static final String REPORT_FLASH_TITLE = "Flash";
    public static final String REPORT_CLOSE_TITLE = "Close";
    public static final String REPORT_RPT_TITLE = "ReportTitle";
    public static final String REPORT_WARNING_TITLE = "ReportWarningTitle";
    public static final String REPORT_WARNING_LEBEL1 = "ReportWarningLebel1";
    public static final String REPORT_WARNING_LEBEL2 = "ReportWarningLebel2";
    public static final String REPORT_WARNING_LEBEL3 = "ReportWarningLebel3";
    
    public static final String REPORT_WARNING_TITLE_ATTD = "ReportWarningTitleAttd";
    
    public static final String REPORT_WARNING_LEBEL1_ATTD = "ReportWarningLebelAttd1";
    public static final String REPORT_WARNING_LEBEL2_ATTD = "ReportWarningLebelAttd2";
    public static final String REPORT_WARNING_LEBEL3_ATTD = "ReportWarningLebelAttd3";
    public static final String ATTENDANT_AND_PERIOD_SEQUENCE = "AttendantAndPeriodSeq";
    
    public static final String REPORT_CWPAYPOINT_TITLE = "CarwashPaypoint";
    public static final String REPORT_RECONCILIATION_TITLE = "ReconciliationTitle";
    public static final String REPORT_CLOSE_CWPAYPOINT = "CloseCwPaypoint";
    public static final String REPORT_PRINT_CWPAYPOINT = "PrintCwPaypoint";


    public static final String FLASH_FUNCTIONS_MENU = "FlashReportsMenu";
    public static final String FLASH_CATEGORY = "PrintCategory";
    public static final String FLASH_DEPARTMENT = "PrintDepartment";
    public static final String FLASH_NETWORK = "PrintNetwork";
    public static final String FLASH_ASA_PAYMENT = "PrintMobilePayment";
    public static final String FLASH_NETWORK_TOTALS = "PrintNetworkTotals";
    public static final String FLASH_PLU = "PrintPLU";
    public static final String FLASH_SUMMARY = "PrintSummary";
    public static final String FLASH_TANK = "PrintTank";
    public static final String FLASH_TANKREC = "PrintTankReconciliation";
    public static final String FLASH_TIERPR = "PrintTierProd";
    public static final String FLASH_POPDEF = "PrintPopDefinition";
    public static final String FLASH_TAX = "PrintTax";
    public static final String FLASH_FP_HOSE = "PrintFPHose";
    public static final String FLASH_FP_HOSE_RUNNING = "PrintFPHoseRunning";
    public static final String FLASH_FPHOSETEST = "PrintFPHoseTest";
    public static final String FLASH_DEAL = "PrintDealRpt";
    public static final String FLASH_PLUPROMO = "PrintPluPromo";
    public static final String FLASH_POPDISC = "PrintPopDiscount";
    public static final String FLASH_POPDISCPRG = "PrintPopDiscPrgmRpt";
    public static final String FLASH_HOURLY = "PrintHourlyRpt";
    public static final String FLASH_SLPRICE = "PrintSlPriceLvlRpt";
    public static final String FLASH_PRPRICE = "PrintPrPriceLvlRpt";
    public static final String FLASH_AUTOCOLLECT = "PrintAutoCollectRpt";
    public static final String FLASH_DCRSTAT = "PrintDCRStatisticalRpt";
    public static final String FLASH_NETPROD = "PrintNetworkProductRpt";
    public static final String FLASH_ESAFECONTENT = "PrintEsafeContent";
    public static final String FLASH_ESAFEEOD = "PrintEsafeEod";
    public static final String FLASH_PROP_NETWORK_CARD = "PrintProprietaryNetworkCard";
    public static final String FLASH_PROP_NETWORK_PROD = "PrintProprietaryNetworkProduct";
    public static final String FLASH_LOYALTY = "PrintLoyaltyReport";
    public static final String FLASH_CW_PAYPOINT = "PrintCarwashPayPoint";
    public static final String FLASH_BLEND_PRODUCT = "PrintBlendProduct";
    public static final String FLASH_DISPENSER = "PrintFPDispenserRpt";
    public static final String FLASH_CASH_ACCEPTOR = "PrintCashAcceptorRpt";
    public static final String FLASH_FUEL_STREET_PRICE_CHANGE = "PrintFuelStreetPriceChangeRpt";

    //Title constants for Reports
    public static final String FLASH_CATEGORY_REPORT_TITLE = "category";
    public static final String FLASH_DEPARTMENT_REPORT_TITLE = "department";
    public static final String FLASH_NETWORK_REPORT_TITLE = "network";
    public static final String FLASH_ASA_MOBILE_REPORT_TITLE_LINE1 = "FLASH_ASA_MOBILE_REPORT_TITLE_LINE1";
    public static final String FLASH_ASA_MOBILE_REPORT_TITLE_LINE2 = "FLASH_ASA_MOBILE_REPORT_TITLE_LINE2";
    public static final String FLASH_PLU_REPORT_TITLE = "plu";
    public static final String FLASH_PROPCARD_REPORT_TITLE = "propCard";
    public static final String FLASH_PROPPROD_REPORT_TITLE = "propProd";
    public static final String FLASH_SUMMARY_REPORT_TITLE = "summary";
    public static final String FLASH_TANK_REPORT_TITLE = "tank";
    public static final String FLASH_CASH_ACCEPTOR_REPORT_TITLE = "cashAcc";
    public static final String FLASH_TANKREC_REPORT_TITLE = "tankRec";
    public static final String FLASH_TIERPRODUCT_REPORT_TITLE = "tierProduct";
    public static final String NETWORK_TOTAL_REPORT_TITLE = "networkTotals";
    public static final String CW_REPORT_TITLE = "cwTotals";
    public static final String ESAFE_REPORT_TITLE = "eSafeTotals";

    public static final String NETWORK_FUNCTIONS_MENU = "NetworkMgrFunctionsMenu";
    public static final String NET_PRE_AUTHORIZATION = "PreAuthorization";
    public static final String NET_GET_NETWORK_MAIL = "GetNetworkMail";
    public static final String NET_PARAMETER_DOWNLOAD = "ParameterDownload";
    public static final String NET_COMM_STATISTICS = "CommStatistics";
    public static final String NET_HOST_TOTALS = "HostTotalsReport";
    public static final String NET_PINPAD_CONFIGURATION = "PinpadConfiguration";
    public static final String NET_SVC_MENU = "SVCMenu";
    public static final String NET_SAF_MENU = "StoreAndForwardMenu";
    public static final String NET_BATCH_DETAILS_MENU = "BatchDetailsMenu";
    public static final String NET_PRINT_NETWORK_LOG = "PrintNetworkLog";
    public static final String NET_PREPAID_FUNCTIONS_MENU = "PrepaidFunctionsMenu";
    public static final String PROPRIETARY_NETWORK_FUNCTIONS_MENU = "ProprietaryNetworkMgrFunctionsMenu";

    public static final String SVC_FUNCTIONS_MENU = "StoredValueCardFunctionsMenu";
    public static final String SVC_CARD_ACTIVATION = "CardActivation";
    public static final String SVC_CARD_RECHARGE = "CardRecharge";
    public static final String SVC_BALANCE_INQUIRY = "BalanceInquiry";
    public static final String SVC_CARD_DEACTIVATION = "CardDeactivation";
    public static final String SVC_VOID_ACTIVATION = "VoidActivation";
    public static final String SVC_VOID_RECHARGE = "VoidRecharge";
    public static final String TYPES_OF_REFUND = "TYPES_OF_REFUND";
    public static final String CHOOSE_REFUND_TYPE = "ChooseRefundType";


    public static final String EBT_FUNCTIONS_MENU = "EbtFunctionsMenu";
    public static final String EBT_BALANCE_INQUIRY = "EbtBalanceInquiry";
    public static final String EBT_VOUCHER_CLEAR = "EbtVoucherClear";
    public static final String EBT_VOUCHER_PROMPT_FSCARD = "EbtVoucherPromptFSCard";
    public static final String EBT_VOUCHER_PROMPT_ACCT = "EbtVoucherPromptAcct";
    public static final String EBT_VOUCHER_INVALID_EXP = "EbtVoucherInvalidExp";
    public static final String EBT_VOUCHER_PROMPT_REFUND = "EbtVoucherPromptRefund";
    public static final String EBT_VOUCHER_PROMPT_DATE = "EBT_VOUCHER_PROMPT_DATE";
    public static final String EBT_VOUCHER_PROMPT_AMOUNT = "EbtVoucherPromptAmount";
    public static final String EBT_VOUCHER_PROMPT_APPROVAL = "EbtVoucherPromptApproval";
    public static final String EBT_VOUCHER_PROMPT_VOUCHNUM = "EbtVoucherPromptVouchnum";
    public static final String EBT_VOUCHER_NO_CASH = "EbtVoucherNoCash";
    public static final String EBT_VOUCHER_INVALID_ENTRY = "EbtVoucherInvalidEntry";

    public static final String QUICK_CREDIT = "QuickCredit";
    public static final String QUICKCREDIT_SSN = "QuickcreditSsn";
    public static final String QUICKCREDIT_BIRTH_DATE = "QUICKCREDIT_BIRTH_DATE";
    public static final String QUICKCREDIT_STREET_NUMBER = "QuickcreditStreetNumber";
    public static final String QUICKCREDIT_HOME_PHONE = "QuickcreditHomePhone";
    public static final String QUICKCREDIT_ZIP_CODE = "QuickcreditZipCode";
    public static final String QUICKCREDIT_LESS_6MO = "QuickcreditLess6Mo";
    public static final String QUICKCREDIT_YES_NO = "QuickcreditYesNo";
    public static final String QUICKCREDIT_PREVIOUS_STREET = "QuickcreditPreviousStreet";
    public static final String QUICKCREDIT_PREVIOUS_ZIP_CODE = "QuickcreditPreviousZipCode";
    public static final String QUICKCREDIT_FAILED = "QuickcreditFailed";
    public static final String QUICKCREDIT_INV_SSN_RETRY = "QuickcreditInvSsnRetry";
    public static final String QUICKCREDIT_INV_SSN = "QuickcreditInvSsn";
    public static final String QUICKCREDIT_INV_DOB = "QuickcreditInvDob";
    public static final String QUICKCREDIT_INV_DOB_RETRY = "QuickcreditInvDobRetry";
    public static final String QUICKCREDIT_INV_PHONE = "QuickcreditInvPhone";
    public static final String QUICKCREDIT_STREET_NOT_ENTERED = "QuickcreditStreetNotEntered";
    public static final String QUICKCREDIT_PREVIOUS_STREET_NOT_ENTERED = "QuickcreditPreviousStreetNotEntered";
    public static final String QUICKCREDIT_ZIP_TOO_SHORT = "QuickcreditZipTooShort";
    public static final String QUICKCREDIT_5_DIGIT_ZIP = "Quickcredit5DigitZip";

    public static final String LOYALTY_FUNCTIONS_MENU = "LoyaltyFunctionsMenu";
    public static final String LOYALTY_BALANCE_INQUIRY = "LoyaltyBalanceInquiry";
    public static final String LOYALTY_BALANCE_INQUIRY_PROMPT = "LoyaltyBalanceInquiryPrompt";

    public static final String SAF_FUNCTIONS_MENU = "StoreAndForwardManagementMenu";
    public static final String SAF_PRINT_DECLINED_SALES = "PrintDeclinedStoredSales";
    public static final String SAF_PRINT_UNSENT_SALES = "PrintUnsentStoredSales";
    public static final String SAF_DELETE_SINGLE_SALE = "DeleteSingleStoredSale";
    public static final String SAF_DELETE_ALL_SALES = "DeleteAllStoredSales";

    public static final String FUEL_FUNCTIONS_MENU = "FuelMgrFunctionsMenu";
    public static final String FUEL_INIT_FUEL = "InitializeFuel";
    public static final String FORCE_INIT_FUEL = "ForceInitializeFuel";
    public static final String FORCE_INIT_FUEL_PRICES = "ForceInitializeFuelPrices";
    public static final String FUEL_DOWNLOAD_FUEL_PRICES = "DownloadFuelPrices";
    public static final String FUEL_INIT_ESIGN_SITE = "InitializeESignSite";
    public static final String FUEL_CLEAR_PUMP_ON_HOLD = "ClearPumpOnHold";
    public static final String FUEL_RESET_CONTROLLER = "ResetController";
    public static final String FUEL_TOGGLE_FUEL_SITE_PAUSE = "ToggleFuelSitePause";
    public static final String FUEL_FUNCS_PRESS_ENTER_CONTINUE = "FuelFuncsPressEnterContinue";
	public static final String FUEL_DISABLE_FUEL_SITE_PAUSE = "DisableFuelSitePause";
    public static final String FUEL_ENABLE_FUEL_SITE_PAUSE = "EnableFuelSitePause";
    public static final String FUEL_FUEL_SITE_PAUSE_ENABLED = "FuelSitePauseEnabled";
    public static final String FUEL_FUEL_SITE_PAUSE_DISABLED = "FuelSitePauseDisabled";
    public static final String FUEL_INIT_FUEL_DRIVER = "InitializeFuelDriver";
    public static final String FUEL_INIT_SPI_CONFIG = "InitializeSPIConfiguration";
    
    public static final String DCR_DOWNLOAD_DCR = "DownloadToDCR";
    public static final String DCR_DOWNLOAD_ALL_DCR = "DownloadToAllDCRs";
    public static final String DCR_INIT_DCR_DRIVER = "InitializeDCRDriver";
    public static final String DCR_FORCE_INIT_ALL_DCR = "ForceInitializeAllDcrs";
    public static final String DCR_DOWNLOAD_DCR_NUM_ERROR = "DownloadToDcrNumError";

    public static final String REG_MAINT_FUNCTIONS_MENU = "RegMaintFunctionsMenu";
    public static final String REG_MAINT_OK = "RegMaintOk";
    public static final String REG_MAINT_ADJ_VOLUME = "AdjustVolume";
    public static final String REG_MAINT_ADJ_BRIGHTNESS = "AdjustBrightness";
    public static final String REG_MAINT_ADJ_SCREENSAVER = "AdjustScreenSaver";
    public static final String REG_MAINT_SYS_MSGS = "SystemMessages";
    public static final String REG_MAINT_DEVICE_CONTROL = "DeviceControl";
    public static final String REG_MAINT_ADJUST_BAUD = "SelectBaud";
    public static final String REG_MAINT_STORE_PHONE_NR = "StorePhoneNumber";
    public static final String REG_MAINT_POSTAL_CODE = "StorePostalCode";
    public static final String REG_MAINT_SYSTEM_DATE_TIME = "SetSystemDateTime";
    public static final String REG_MAINT_SYSTEM_DATE = "SetSystemDate";
    public static final String REG_MAINT_SYSTEM_TIME = "SetSystemTime";
    public static final String REG_MAINT_TIME_FORMAT = "HHMMSS";
    public static final String REG_MAINT_DEVICE_CONFIG = "DeviceConfiguration";
    public static final String REG_MAINT_DEVICE_CONFIG_MENU = "DeviceConfigurationMenu";
    public static final String REG_MAINT_PINPAD_CONFIG = "PinpadConfiguration";
    public static final String REG_MAINT_SELECT_LANGUAGE = "SelectLanguage";
    public static final String REG_MAINT_BACKUP_LOG = "BackupLog";
    public static final String REG_MAINT_RESET_MODEM = "ResetModem";
    public static final String REG_MAINT_RESET_SYSTEM = "ResetSystem";
    public static final String REG_MAINT_PRINT_INSTALL = "PrintInstallation";
    public static final String REG_MAINT_APPLY_UPGRADE = "ApplyUpgrade";
    public static final String REG_MAINT_PRINT_UPGRADE_SUMMARY = "PrintUpgradeSummary";
    public static final String REG_MAINT_CHECK_FOR_UPDATES = "CheckForUpdates";
    public static final String REG_MAINT_SHOW_UPGRADE_STATUS = "ShowUpgradeStatus";
    public static final String REG_MAINT_INIT_VRSD_UPDATE_CHECK = "InitializeVRSDUpdateCheck";
    public static final String REG_MAINT_REFRESH_CONFIG = "ApplyConfiguration";
    public static final String REG_MAINT_PING_TEST = "PingTest";
    public static final String REG_MAINT_SCREEN_LOCK_CLEAN = "ScreenLockCleanMode";
    
    

	//pci changes
	public static final String REG_MAINT_PWD_MANAGEMENT = "PasswordManagement";
    public static final String REG_MAINT_PWD_RESET = "ResetPassword";
    public static final String REG_MAINT_PWD_CHANGE = "ChangePassword";
    public static final String REG_MAINT_PWD_MANGEMENT_MENU = "PwdMgrFunctionsMenu";
    public static final String REG_MAINT_OLD_PASSWORD = "OldPassword";
    public static final String REG_MAINT_CONF_PASSWORD = "ConfirmPassword";
    public static final String REG_MAINT_NEW_PASSWORD = "NewPassword";
    public static final String REG_MAINT_SECURE_LOGIN_TITLE = "SECUREUSERLOGIN";
    public static final String REG_MAINT_SECURE_USERID= "SECUREUSERID";
    public static final String REG_MAINT_SECURE_PASSWORD = "SECUREPASSWORD";
    public static final String REG_MAINT_SECURE_USE_EXPIRE_MSG = "SECUREUSEREXPIREMSG";
    public static final String REG_MAINT_SECURE_LOCK_MSG = "SECUREUSERLOCKINGMSG";
    public static final String REG_MAINT_SECURE_INVALID_MSG = "SECUREUSERINVALIDMSG";
    public static final String REG_MAINT_SECURE_SESSION_EXPIRE ="SESSION_EXPIRED";
    public static final String REG_MAINT_SECURE_CHANGE_PWD_FAIL ="SECUREPASSWORDNOTCHANGED";
    public static final String REG_MAINT_SECURE_CHANGE_PWD_SUCCESS ="Successfullychangedthepassword";
    public static final String REG_MAINT_SECURE_PWD_MATCH_ERROR ="PASSWORDSDONOTMATCH";
	public static final String REG_MAINT_SECURE_PWD_CONTAINS_SPACES = "PASSWORDCONTAINTRAILINGSPACES";
    public static final String REG_MAINT_SECURE_PWD_ALLOWED_ERROR ="PASSWORDLLOWEDERROR";
    public static final String REG_MAINT_SECURE_OLD_PWD_ERROR ="WRONGOLDPASSWORD";
    public static final String REG_MAINT_SECURE_RESET_PWD_SUCCESS ="Successfullyresetthepassword";
    public static final String REG_MAINT_SECURE_RESET_PWD_FAIL ="SECUREPASSWORDNOTRESET";
    public static final String REG_MAINT_SECURE_ADMIN_REQUIRE="SECUREADMINREQUIRE";
    public static final String REG_MAINT_INVALID_USER = "INVALIDUSER";
    public static final String REG_MAINT_REFRESH_CONFIG_PROMPT = "APPLYCONFIGURATION";
    public static final String REG_MAINT_PING_TEST_PROMPT = "PingTestPrompt";
    public static final String REG_MAINT_PING_TEST_SUCCESS = "PingTestSuccess";
    public static final String REG_MAINT_PING_TEST_IP_ERROR = "PingTestIpError";
    
    // cr0913.01 - "Password expire message"
    public static final String REG_MAINT_SECURE_PWD_EXPIRE_WARNING = "REGMAINTSECUREPWDEXPIREWARNING";
    public static final String REG_MAINT_INVALID_OTP = "REGMAINTINVALIDOTP";
    
    // Order Confirmation Board assign/unassign prompting
    public static final String REG_MAINT_OCB_MENU_TITLE = "REG_MAINT_OCB_MENU_TITLE";
    public static final String REG_MAINT_OCB_ASSIGN_QUESTION = "REG_MAINT_OCB_ASSIGN_QUESTION";
    public static final String REG_MAINT_OCB_UNASSIGN_QUESTION = "REG_MAINT_OCB_UNASSIGN_QUESTION";
    public static final String REG_MAINT_OCB_ASSIGNED_TO = "REG_MAINT_OCB_ASSIGNED_TO";
    public static final String REG_MAINT_OCB_MENU_NOASSIGN = "REG_MAINT_OCB_MENU_NOASSIGN";
    public static final String REG_MAINT_OCB_MENU_OCBDENY = "REG_MAINT_OCB_MENU_OCBDENY";
    public static final String REG_MAINT_OCB_MENU_DENYREASON = "REG_MAINT_OCB_MENU_DENYREASON";

    // Configuration Manager
    
    public static final String  CONFIG_MANAGER_TITLE   	= "CONFIG_MANAGER_TITLE";
	public static final String  KBD_CONN 				= "KBD_CONN";	
	public static final String  KBD_NOT_CONN			= "KBD_NOT_CONN";
	public static final String  KBD_CONN_MESSAGE 		= "KBD_CONN_MESSAGE";
	public static final String  KBD_NOT_CONN_MESSAGE 	= "KBD_NOT_CONN_MESSAGE";
	public static final String  USER_PROMPT 			= "USER_PROMPT";

    //Strings for menu captions - end

	public static final String  MAIN_MENU_MSG = "MAIN_MENU_MSG";
	public static final String  MENU_FN_OTHER = "MENU_FN_OTHER";
	public static final String  MENU_FN_REVIEW = "MENU_FN_REVIEW";
	public static final String  MENU_FN_LOGOUT = "MENU_FN_LOGOUT";
	public static final String  MENU_FN_SALES = "MENU_FN_SALES";
	public static final String  MENU_PREVIOUS = "MENU_PREVIOUS";
	public static final String  FUEL_DISABLE_ENABLE_DCR = "FUEL_DISABLE_ENABLE_DCR";
	public static final String  MENU_PRICE_CHECK = "MENU_PRICE_CHECK";

	public static final String FN_CLOSE_CASHIER = "FN_CLOSE_CASHIER";
	public static final String FN_PRINT_CASHIER_REPORT = "FN_PRINT_CASHIER_REPORT";
	public static final String FN_CLOSE_ATTENDANT = "FN_CLOSE_ATTENDANT";
	public static final String FN_PRINT_ATTENDANT_REPORT = "FN_PRINT_ATTENDANT_REPORT";
	public static final String CLOSE_CASHIER_NUM_PROMPT = "CLOSE_CASHIER_NUM_PROMPT";
	public static final String CASHIER = "CASHIER";
	public static final String ATTENDANT = "ATTENDANT";
	public static final String REPORT = "REPORT";
	public static final String COMPLETED_SUCCESSFULLY = "COMPLETED_SUCCESSFULLY";
	public static final String FAILED = "FAILED";
	public static final String CSR_CLOSE_ERROR = "CSR_CLOSE_ERROR";
	public static final String CLOSE_ESAFE_FIRST = "CLOSE_ESAFE_FIRST";
	public static final String CONTINUE_CASHIER_CLOSE = "CONTINUE_CASHIER_CLOSE";
	public static final String CASHIER_WARNING = "CASHIER_WARNING";
	public static final String TIMEOUT_FAILURE = "TIMEOUT_FAILURE";

	public static final String FN_CLOSE_PD1 = "FN_CLOSE_PD1";
	public static final String FN_CLOSE_PD2 = "FN_CLOSE_PD2";
	public static final String FN_CLOSE_PD3 = "FN_CLOSE_PD3";
	public static final String FN_CLOSE_PD4 = "FN_CLOSE_PD4";
	public static final String FN_CLOSE_NAME = "FN_CLOSE_NAME";
	public static final String PERIOD_SEQUENCE = "PERIOD_SEQUENCE";
	public static final String PERIOD_BEGIN = "PERIOD_BEGIN";
	public static final String CLOSE_DISALLOWED_PDTYPE = "CLOSE_DISALLOWED_PDTYPE";
	public static final String CLOSE_DISALLOWED = "CLOSE_DISALLOWED";
	public static final String NO_SALES_PERIOD = "NO_SALES_PERIOD";
	public static final String FORCE_PERIOD_CLOSE = "FORCE_PERIOD_CLOSE";
	public static final String FORCE_CLOSE_RETRY = "FORCE_CLOSE_RETRY";
	public static final String CLOSE_TOO_SOON = "CLOSE_TOO_SOON";
	public static final String NEXT_ALLOWED_CLOSE = "NEXT_ALLOWED_CLOSE";
	public static final String SECURITY_INFO_REQD = "SECURITY_INFO_REQD";
	public static final String PERIOD_CLOSE_IN_PROG = "PERIOD_CLOSE_IN_PROG";
	public static final String EXIT_SALES_FOR_CLOSE = "EXIT_SALES_FOR_CLOSE";
	public static final String INVALID_STATE_FOR_CLOSE = "INVALID_STATE_FOR_CLOSE";
	public static final String PERIOD_CLOSE_FAILED = "PERIOD_CLOSE_FAILED";
	public static final String CLOSE_CSRS_FIRST = "CLOSE_CSRS_FIRST";
	public static final String PERIOD_CLOSE_CANCELED = "PERIOD_CLOSE_CANCELED";
	public static final String SETTLE_SUSPENDED_TXNS_FIRST = "SETTLE_SUSPENDED_TXNS_FIRST";
	public static final String PERIOD_CLOSE_PENDING_TXNS = "PERIOD_CLOSE_PENDING_TXNS";
	public static final String SETTLE_FUEL_PENDING_TXNS = "SETTLE_FUEL_PENDING_TXNS";
	public static final String REGISTERS_NOT_CLOSED = "REGISTERS_NOT_CLOSED";
	public static final String NETWORK_HOST_UNAVAILABLE = "NETWORK_HOST_UNAVAILABLE";
	public static final String NETWORK_HOST_FAILED = "NETWORK_HOST_FAILED";
	public static final String NETWORK_HOST_RETRY = "NETWORK_HOST_RETRY";
	public static final String LOCK_CLIENTS = "LOCK_CLIENTS";
	public static final String LOCK_SVCS = "LOCK_SERVICES";
	public static final String CLOSE_CSRS = "CLOSE_CASHIERS";
	public static final String DATA_COMMIT = "DATA_COMMIT";
	public static final String PRESS_ENTER = "PRESS_ENTER";

	public static final String FN_PRINT_SHIFT_REPORT = "FN_PRINT_SHIFT_REPORT";
	public static final String SELECT_SHIFT = "SELECT_SHIFT";

	public static final String SELECT_TILL = "SELECT_TILL";
	public static final String SCREEN_SELECT_TILL_HEADER = "SCREEN_SELECT_TILL_HEADER";
	public static final String REGISTER_NUMBER_ABBR = "REGISTER_NUMBER_ABBR";
	public static final String DRAWER_NUMBER_ABBR = "DRAWER_NUMBER_ABBR";
	public static final String OPEN_TILL_DRAWER_1 = "OPEN_TILL_DRAWER_1";
	public static final String OPEN_TILL_DRAWER_2 = "OPEN_TILL_DRAWER_2";
	public static final String SELECT_TILL_OTHER_FUNCTIONS = "SELECT_TILL_OTHER_FUNCTIONS";
	public static final String UNAVAILABLE_TILL_DRAWER_1 = "UNAVAILABLE_TILL_DRAWER_1";
	public static final String UNAVAILABLE_TILL_DRAWER_2 = "UNAVAILABLE_TILL_DRAWER_2";
	public static final String OPEN_ATTENDENT_SESSION = "OPEN_ATTENDENT_SESSION";
	public static final String INVALID_USER = "INVALID_USER";
	public static final String INVALID_USER_ID = "INVALID_USER_ID";
    public static final String SITE_PAUSE_ENABLED = "SITE_PAUSE_ENABLED";

	public static final String CSR_MSG_NOSALE = "CSR_MSG_NOSALE";
	public static final String CSR_MSG_CLOSE_DRW = "CSR_MSG_CLOSE_DRW";
	public static final String CSR_MSG_NO_RFND_ALLOWED = "CSR_MSG_NO_RFND_ALLOWED";
	public static final String CSR_MSG_NO_CHG_ALLOWED = "CSR_MSG_NO_CHG_ALLOWED";
	public static final String CSR_MSG_VOID_LN_MODE = "CSR_MSG_VOID_LN_MODE";
	public static final String CSR_SAFE_DROP_RQD = "CSR_SAFE_DROP_RQD";
	public static final String CSR_NO_SUSPEND = "CSR_NO_SUSPEND";

	public final static String UUID = "UUID";

	public static final String READY_FOR_DBSYNC = "READY_FOR_DBSYNC";
	public static final String DBSYNC_IN_PROGRESS = "DBSYNC_IN_PROGRESS";
	public static final String DBSYNC_COMPLETE = "DBSYNC_COMPLETE";
	public static final String DBSYNC_ERROR = "DBSYNC_ERROR";
	public static final String LOCK_POS = "LOCK_POS";
	public static final String CUSTOMER_COPY = "CUSTOMER_COPY";
	public static final String MANUAL_ENTRY = "MANUAL_ENTRY";
	public static final String VOID_TRAN = "VOID_TRAN";
	public static final String SALE_TRAN = "SALE_TRAN";
	public static final String REFUND_TRAN = "REFUND_TRAN";
	public static final String PREPAY = "PREPAY";
	public static final String FILL_UP = "FILL_UP";
	public static final String FUEL_AUTH = "FUEL_AUTH";
	public static final String SUSPEND_TRAN = "SUSPEND";
	public static final String PREAUTH = "PREAUTH";
	public static final String VOID_TCKT = "VOID_TCKT";
	public static final String SPLIT_TENDER = "SPLIT_TENDER";

	public static final String VOLUME = "VOLUME";
	public static final String TYPE = "TYPE";
	public static final String TICKET_NUM = "TICKET_NUM";
	public static final String TRAN_SEQ = "TRAN_SEQ";
	public static final String DETAILS = "DETAILS";
	
	

	public static final String SAFE_DROP_HDR = "SAFE_DROP_HDR";
	public static final String ESAFE_DROP_HDR = "ESAFE_DROP_HDR";
	public static final String SAFE_LOAN_HDR = "SAFE_LOAN_HDR";
	public static final String PAYOUT_HDR = "PAYOUT_HDR";
	public static final String PAYIN_HDR = "PAYIN_HDR";
	public static final String NO_SALE_HDR = "NO_SALE_HDR";

	public static final String CARWASH_CODES_PRFX = "CARWASH_CODES_PRFX";
	public static final String CARWASH_CODES = "CARWASH_CODES";
	public static final String CARWASH_DAYS_VAL = "CARWASH_DAYS_VAL";
	public static final String CARWASH_COMM_ERR = "CARWASH_COMM_ERR";
	public static final String CARWASH_SALE_ERR = "CARWASH_SALE_ERR";
	public static final String CARWASH_QTY_ERR = "CARWASH_QTY_ERR";

	public static final String PREPAID_CARD = "PREPAID_CARD";
	public static final String GIFT_CARD    = "GIFT_CARD";
	public static final String ACTIVATION = "ACTIVATION";
	public static final String DEACTIVATION = "DEACTIVATION";
	public static final String RECHARGE = "RECHARGE";
	public static final String BALQUERY = "BALQUERY";
	public static final String VOID_ACTIVATION = "VOID_ACTIVATION";
	public static final String VOID_RECHARGE = "VOID_RECHARGE";
	public static final String AMOUNT_STR = "AMOUNT_STR";
	public static final String CARD_BALANCE = "CARD_BALANCE";
	public static final String CARD_VALUE = "CARD_VALUE";
	public static final String REFUND_DUE_CARD = "REFUND_DUE";

	public static final String BASIC_POP = "BASIC_POP";
	public static final String BASIC_CODE_POP = "BASIC_CODE_POP";
	public static final String REDEEM_CODE = "REDEEM_CODE";
	public static final String PREPAID_FUEL = "PREPAID_FUEL";
	public static final String POP_DISCOUNT = "POP_DISCOUNT";
	public static final String SELECT_CSR_PERIOD = "SELECT_CSR_PERIOD";
	public static final String FREE_COUPON_TKT = "FREE_COUPON_TKT";
	public static final String FREE_CODE_TKT = "FREE_CODE_TKT";
	public static final String FREE_CODE = "FREE_CODE";
	public static final String CODE_GRADES = "CODE_GRADES";
	public static final String EXPIRES = "EXPIRES";
	public static final String YOU_RCVD = "YOU_RCVD";
	public static final String DISCOUNT = "DISCOUNT";
	public static final String DISCOUNTS = "DISCOUNTS";
	public static final String DISCOUNTS_N_REBATES = "DISCOUNTS_N_REBATES";
    public static final String GALLON = "GALLON";
    public static final String LITRE = "LITRE";
    public static final String GALLON_ABBV = "GALLON_ABBV";
    public static final String LITRE_ABBV = "LITRE_ABBV";
	public static final String DEPARTMENT = "DEPARTMENT";
	public static final String MOP = "MOP";
	public static final String QTY = "QUANTITY";
	public static final String PRICE_OVER = "PRICE_OVER";
	public static final String OLD_CODE_MSG = "OLD_CODE_MSG";
	public static final String YOU_SAVED = "YOU_SAVED";
	public static final String CODE_REJECTED = "CODE_REJECTED";
	public static final String CODE = "CODE";
	public static final String UNUSED_CODE = "UNUSED_CODE";
	public static final String SELECT_FLASH_REPORT = "SELECT_FLASH_REPORT";
	public static String SELECT_PAYROLL_FUNCTION = "SELECT_PAYROLL_FUNCTION";
	public static final String RECALL_TXN = "RECALL_TXN";
	public static final String REPRINT_TXN = "REPRINT_TXN";
	public static final String FUELONLY_REPRINT_TXN = "FUELONLY_REPRINT_TXN";
	public static final String PURGE_ORDER = "PURGE_ORDER";
	public static final String CLAIM_ORDER = "CLAIM_ORDER";
	public static final String CHOOSE_ORDER = "CHOOSE_ORDER";

	public static final String INCLUDES = "INCLUDES";
	public static final String AMOUNT = "AMOUNT";
	public static final String TAXABLE = "TAXABLE";

	public static final String VAT_INCLUDED = "VAT_INCLUDED";
	public static final String CONTINUE_OK = "CONTINUE_OK";
	public static final String QUARTS_OF_OIL = "QUARTS_OF_OIL";

	public static final String SD_ELIGIBLE = "ELIGIBLE_TOTAL";
	public static final String PAYROLL_FNS = "PAYROLL_FNS";
	public static final String COUPON_DISC_NAME = "COUPON_DISC_NAME";
	public static final String DATA_ERROR = "DATA_ERROR";

	public static final String PAYROLL_FNS_TITLE = "PAYROLL_FNS_TITLE";
	public static final String CLOCK_IN = "CLOCK_IN";
	public static final String CLOCK_OUT = "CLOCK_OUT";
	public static final String CHANGE_JOB_CODE = "CHANGE_JOB_CODE";
	public static final String ENTER_JOB_CODE = "ENTER_JOB_CODE";
	public static final String JOB_CODES = "JOB_CODES";
	public static final String JOB_CODE = "JOB_CODE";
	public static final String SELECT_JOB_CODE = "SELECT_JOB_CODE";
	public static final String PAYROLL_CASHIER_LINE = "PAYROLL_CASHIER_LINE";
	public static final String PAYROLL_TXN_FOOTER = "PAYROLL_TXN_FOOTER";
	public static final String STORE_NUM_FOOTER = "STORE_NUM_FOOTER";
	public static final String HOURS = "HOURS";
	public static final String TIME_IN = "TIME_IN";
	public static final String TIME_OUT = "TIME_OUT";
	public static final String ENDING = "ENDING";
	public static final String JOB = "JOB";
	public static final String TOTAL_HRS_LINE1 = "TOTAL_HRS_LINE1";

	public static final String PRINT_INSTALL_HEADING = "PRINT_INSTALL_HEADING";
	public static final String PRINT_INSTALL_MESSAGE = "PRINT_INSTALL_MESSAGE";

	public static final String FA_TITLE = "FA_TITLE";
	public static final String FA_CREATE_REPORT = "FA_CREATE_REPORT";
	public static final String FA_CREATING_REPORT_WAIT = "FA_CREATING_REPORT_WAIT";
	public static final String FA_SUCCESS = "FA_SUCCESS";
	public static final String FA_AUDIT_HOST_DOWN = "FA_AUDIT_HOST_DOWN";
	public static final String FA_OPERATION_ABORTED = "FA_OPERATION_ABORTED";
	//code added by tattu 14 may 2007
	public static final String USE_IMPRINTER="USE_IMPRINTER";
	public static final String REMINDER="REMINDER";
	public static final String HOUSE_ACCT_PROMPT_TITLE = "HOUSE_ACCT_PROMPT_TITLE";
	public static final String HOUSE_ACCT_NUM_PROMPT = "HOUSE_ACCT_NUM_PROMPT";
	public static final String HOUSE_SUB_ACCT_NUM_PROMPT = "HOUSE_SUB_ACCT_NUM_PROMPT";
	public static final String HOUSE_ACCT_RCPT_TITLE = "HOUSE_ACCT_RCPT_TITLE";
	public static final String HOUSE_ACCT_NUM = "HOUSE_ACCT_NUM";
	public static final String HOUSE_ACCT_NAME = "HOUSE_ACCT_NAME";
	public static final String HOUSE_SUB_ACCT_NUM = "HOUSE_SUB_ACCT_NUM";
	public static final String HOUSE_ACCT_SIGN_LINE1 = "HOUSE_ACCT_SIGN_LINE1";
	public static final String HOUSE_ACCT_SIGN_LINE2 = "HOUSE_ACCT_SIGN_LINE2";
	public static final String HOUSE_ACCT_SIGN_LINE3 = "HOUSE_ACCT_SIGN_LINE3";

	public static final String PUMP_OVERRUN = "PumpOverrun";
	public final static String	TAX_EXEMPT="TAX_EXEMPT";
	public final static String	BALANCE_INQUIRY="BALANCE_INQUIRY";


	//	code added by tattu for safe drop correction


	public static final String SAFE_DROP_CORR_ENTER_TICKET_NUM="SAFE_DROP_CORR_ENTER_TICKET_NUM";
	public static final String SAFE_DROP_CORR_ENTER_REVISED_AMOUNT ="SAFE_DROP_CORR_ENTER_REVISED_AMOUNT";
	public static final String SAFE_DROP_CORR="SAFE_DROP_CORR";
	public static final String SAFE_DROP_CORR_PRESS_ENTER="SAFE_DROP_CORR_PRESS_ENTER";
	public static final String SAFE_DROP_CORR_ENTER_AMOUNT="SAFE_DROP_CORR_ENTER_AMOUNT";
	public static final String SAFE_DROP_CORR_HDR = "SAFE_DROP_CORR_HDR";


	public static final String PMT_SAFE_ESAFE_DROP_HDR = "PMT_SAFE_ESAFE_DROP_HDR";
	public static final String PMT_SAFE_NO_VALID_MOP = "PMT_SAFE_NO_VALID_MOP";

	
	
	
	//code added for Visa Readylink Recharge
	public static final String READYLINK_RECHARGE = "READYLINK_RECHARGE";
	public static final String CARDLOAD_AMOUNT = "CARDLOAD_AMOUNT";
	public static final String CARD_LOADED = "CARD_LOADED";
	public static final String TRANSACTION_REJECTED = "TRANSACTION_REJECTED";
	public static final String AUTH = "AUTH";
	public static final String DOC_NO = "DOC_NO";
	public static final String REJECT_REASON = "REJECT_REASON";
	public static final String CARD_LOAD_ERROR = "CARD_LOAD_ERROR";

	/*-
	 * These are the codes from Ruby's st3sal.c file, since we support
	 * Ruby + Topaz installs, it is important the strings agree exactly.  The
	 * constants used to index them need to be defined.
	 */

	public static final String ERRM_1100 = "ruby-err-msg-E1100";
	public static final String ERRM_1101 = "ruby-err-msg-E1101";
	public static final String ERRM_1102 = "ruby-err-msg-E1102";
	public static final String ERRM_1103 = "ruby-err-msg-E1103";
	public static final String ERRM_1104 = "ruby-err-msg-E1104";
	public static final String ERRM_1105 = "ruby-err-msg-E1105";
	public static final String ERRM_1106 = "ruby-err-msg-E1106";
	public static final String ERRM_1107 = "ruby-err-msg-E1107";
	public static final String ERRM_1108 = "ruby-err-msg-E1108";
	public static final String ERRM_1109 = "ruby-err-msg-E1109";

	public static final String ERRM_1110 = "ruby-err-msg-E1110";
	public static final String ERRM_1111 = "ruby-err-msg-E1111";
	public static final String ERRM_1112 = "ruby-err-msg-E1112";
	public static final String ERRM_1113 = "ruby-err-msg-E1113";
	public static final String ERRM_1114 = "ruby-err-msg-E1114";
	public static final String ERRM_1115 = "ruby-err-msg-E1115";
	public static final String ERRM_1116 = "ruby-err-msg-E1116";
	public static final String ERRM_1117 = "ruby-err-msg-E1117";
	public static final String ERRM_1118 = "ruby-err-msg-E1118";
	public static final String ERRM_1119 = "ruby-err-msg-E1119";

	public static final String ERRM_1120 = "ruby-err-msg-E1120";
	public static final String ERRM_1121 = "ruby-err-msg-E1121";
	public static final String ERRM_1122 = "ruby-err-msg-E1122";
	public static final String ERRM_1123 = "ruby-err-msg-E1123";
	public static final String ERRM_1124 = "ruby-err-msg-E1124";
	public static final String ERRM_1125 = "ruby-err-msg-E1125";
	public static final String ERRM_1126 = "ruby-err-msg-E1126";
	public static final String ERRM_1127 = "ruby-err-msg-E1127";
	public static final String ERRM_1128 = "ruby-err-msg-E1128";
	public static final String ERRM_1129 = "ruby-err-msg-E1129";

	public static final String ERRM_1130 = "ruby-err-msg-E1130";
	public static final String ERRM_1131 = "ruby-err-msg-E1131";
	public static final String ERRM_1132 = "ruby-err-msg-E1132";
	public static final String ERRM_1134 = "ruby-err-msg-E1133";
	public static final String ERRM_1135 = "ruby-err-msg-E1135";
	public static final String ERRM_1136 = "ruby-err-msg-E1136";
	public static final String ERRM_1137 = "ruby-err-msg-E1137";
	public static final String ERRM_1138 = "ruby-err-msg-E1138";


	public static final String ERRM_1139 = "ruby-err-msg-E1139";

	public static final String ERRM_1140 = "ruby-err-msg-E1140";

	public static final String ERRM_1141 = "ruby-err-msg-E1141";
	public static final String ERRM_1142 = "ruby-err-msg-E1142";
	public static final String ERRM_1143 = "ruby-err-msg-E1143";
	public static final String ERRM_1144 = "ruby-err-msg-E1144";
	public static final String ERRM_1145 = "ruby-err-msg-E1145";

	// EXXON SPECIFIC
	public static final String ERRM_1146 = "ruby-err-msg-E1146";
	public static final String ERRM_1147 = "ruby-err-msg-E1147";
	public static final String ERRM_1148 = "ruby-err-msg-E1148";
	public static final String ERRM_1149 = "ruby-err-msg-E1149";


	// CITPAK and SHELL SPECIFIC
	public static final String ERRM_1150 = "ruby-err-msg-E1150";
	public static final String ERRM_1151 = "ruby-err-msg-E1151";
	public static final String ERRM_1152 = "ruby-err-msg-E1152";
	public static final String ERRM_1153 = "ruby-err-msg-E1153";
	public static final String ERRM_1154 = "ruby-err-msg-E1154";

	public static final String ERRM_1155 = "ruby-err-msg-E1155";
	public static final String ERRM_1156 = "ruby-err-msg-E1156";
	public static final String ERRM_1157 = "ruby-err-msg-E1157";
	public static final String ERRM_1158 = "ruby-err-msg-E1158";
	public static final String ERRM_1159 = "ruby-err-msg-E1159";
	public static final String ERRM_1160 = "ruby-err-msg-E1160";
	public static final String ERRM_1161 = "ruby-err-msg-E1161";
	public static final String ERRM_1162 = "ruby-err-msg-E1162";
	public static final String ERRM_1163 = "ruby-err-msg-E1163";
	public static final String ERRM_1164 = "ruby-err-msg-E1164";
	public static final String ERRM_1165 = "ruby-err-msg-E1165";
	public static final String ERRM_1166 = "ruby-err-msg-E1166";
	public static final String ERRM_1167 = "ruby-err-msg-E1167";
	public static final String ERRM_1168 = "ruby-err-msg-E1168";
	public static final String ERRM_1169 = "ruby-err-msg-E1169";
	public static final String ERRM_8003 = "ruby-err-msg-E8003";
	public static final String ERRM_8037 = "ruby-err-msg-E8037";
	public static final String ERRM_8038 = "ruby-err-msg-E8038";
	public static final String ERRM_8039 = "ruby-err-msg-E8039";
	public static final String ERRM_8040 = "ruby-err-msg-E8040";
	public static final String ERRM_8041 = "ruby-err-msg-E8041";
	public static final String ERRM_8XX1 = "ruby-err-msg-text";

	// CAR WASH SPECIFIC
	public static final String ERRM_1170 = "ruby-err-msg-E1170";
	public static final String ERRM_1171 = "ruby-err-msg-E1171";
	public static final String ERRM_1172 = "ruby-err-msg-E1172";
	public static final String ERRM_1173 = "ruby-err-msg-E1173";
	public static final String ERRM_1174 = "ruby-err-msg-E1174";
	public static final String ERRM_1175 = "ruby-err-msg-E1175";
	public static final String ERRM_1176 = "ruby-err-msg-E1176";
	public static final String ERRM_1177 = "ruby-err-msg-E1177";
	public static final String ERRM_1178 = "ruby-err-msg-E1178";
	public static final String ERRM_1179 = "ruby-err-msg-E1179";

	public static final String ERRM_1180 = "ruby-err-msg-E1180";
	public static final String ERRM_1181 = "ruby-err-msg-E1181";
	public static final String ERRM_1182 = "ruby-err-msg-E1182";
	public static final String ERRM_1183 = "ruby-err-msg-E1183";
	public static final String ERRM_1184 = "ruby-err-msg-E1184";
	public static final String ERRM_1185 = "ruby-err-msg-E1185";
	public static final String ERRM_1186 = "ruby-err-msg-E1186";
	public static final String ERRM_1187 = "ruby-err-msg-E1187";
	public static final String ERRM_1188 = "ruby-err-msg-E1188";
	public static final String ERRM_1189 = "ruby-err-msg-E1189";

	public static final String ERRM_1190 = "ruby-err-msg-E1190";
	public static final String ERRM_1191 = "ruby-err-msg-E1191";
	public static final String ERRM_1192 = "ruby-err-msg-E1192";
	public static final String ERRM_1193 = "ruby-err-msg-E1193";
	public static final String ERRM_1194 = "ruby-err-msg-E1194";
	public static final String ERRM_1195 = "ruby-err-msg-E1195";
	public static final String ERRM_1196 = "ruby-err-msg-E1196";
	public static final String ERRM_1197 = "ruby-err-msg-E1197";
	public static final String ERRM_1198 = "ruby-err-msg-E1198";
	public static final String ERRM_1268 = "ruby-err-msg-E1268";

	public static final String ERRM_1200 = "ruby-err-msg-E1200";
	public static final String ERRM_1201 = "ruby-err-msg-E1201";
	public static final String ERRM_1202 = "ruby-err-msg-E1202";

	public static final String ERRM_1203 = "ruby-err-msg-E1203";
	public static final String ERRM_1204 = "ruby-err-msg-E1204";
	public static final String ERRM_1205 = "ruby-err-msg-E1205";
	public static final String ERRM_1206 = "ruby-err-msg-E1206";
	public static final String ERRM_1207 = "ruby-err-msg-E1207";
	public static final String ERRM_1208 = "ruby-err-msg-E1208";
	public static final String ERRM_1209 = "ruby-err-msg-E1209";

	public static final String ERRM_1210 = "ruby-err-msg-E1210";
	public static final String ERRM_1211 = "ruby-err-msg-E1211";
	public static final String ERRM_1212 = "ruby-err-msg-E1212";
	public static final String ERRM_1213 = "ruby-err-msg-E1213";
	public static final String ERRM_1214 = "ruby-err-msg-E1214";
	public static final String ERRM_1215 = "ruby-err-msg-E1215";
	public static final String ERRM_1216 = "ruby-err-msg-E1216";
	public static final String ERRM_1217 = "ruby-err-msg-E1217";
	public static final String ERRM_1218 = "ruby-err-msg-E1218";
	public static final String ERRM_1219 = "ruby-err-msg-E1219";

	public static final String ERRM_1220 = "ruby-err-msg-E1220";
	public static final String ERRM_1221 = "ruby-err-msg-E1221";
	public static final String ERRM_1222 = "ruby-err-msg-E1222";
	public static final String ERRM_1223 = "ruby-err-msg-E1223";

	public static final String ERRM_1234 = "ruby-err-msg-E1234";
	public static final String ERRM_1235 = "ruby-err-msg-E1235";
	public static final String ERRM_1236 = "ruby-err-msg-E1236";
	public static final String ERRM_1237 = "ruby-err-msg-E1237";
	public static final String ERRM_1238 = "ruby-err-msg-E1238";
	public static final String ERRM_1239 = "ruby-err-msg-E1239";

	public static final String ERRM_1242 = "ruby-err-msg-E1242";
	public static final String ERRM_1243 = "ruby-err-msg-E1243";
	public static final String ERRM_1244 = "ruby-err-msg-E1244";
	public static final String ERRM_1245 = "ruby-err-msg-E1245";
	public static final String ERRM_1246 = "ruby-err-msg-E1246";

	public static final String ERRM_1249 = "ruby-err-msg-E1249";
	public static final String ERRM_1250 = "ruby-err-msg-E1250";
	public static final String ERRM_1251 = "ruby-err-msg-E1251";

	public static final String ERRM_1254 = "ruby-err-msg-E1254";
	public static final String ERRM_1255 = "ruby-err-msg-E1255";
	public static final String ERRM_1259 = "ruby-err-msg-E1259";

	// New error message for enhanced ID functionality

	public static final String ERRM_1260 = "ruby-err-msg-E1260";
	public static final String ERRM_1261 = "ruby-err-msg-E1261";
	public static final String ERRM_1262 = "ruby-err-msg-E1262";
	public static final String ERRM_1263 = "ruby-err-msg-E1263";
	public static final String ERRM_1264 = "ruby-err-msg-E1264";
	public static final String ERRM_1265 = "ruby-err-msg-E1265";
	public static final String ERRM_1266 = "ruby-err-msg-E1266";
	public static final String ERRM_1267 = "ruby-err-msg-E1267";

        public static final String ERRM_1270 = "ruby-err-msg-E1270";
	public static final String ERRM_1273 = "ruby-err-msg-E1273";
	public static final String ERRM_1283 = "ruby-err-msg-E1283";
	public static final String ERRM_1294 = "ruby-err-msg-E1294";
	public static final String ERRM_1295 = "ruby-err-msg-E1295";

	public static final String ERRM_7026 = "ruby-err-msg-E7026";
	public static final String ERRM_7027 = "ruby-err-msg-E7027";
	public static final String ERRM_7028 = "ruby-err-msg-E7028";
	public static final String ERRM_7041 = "ruby-err-msg-E7041";
	public static final String ERRM_7042 = "ruby-err-msg-E7042";

	//messages for coupon scanning
	public static final String ERRM_1300 = "ruby-err-msg-E1300";
	public static final String ERRM_1301 = "ruby-err-msg-E1301";
	public static final String ERRM_1302 = "ruby-err-msg-E1302";
	public static final String ERRM_1303 = "ruby-err-msg-E1303";

	//promo exceeds plu.
	public static final String ERRM_1304 = "ruby-err-msg-E1304";

	//newly added for scanned coupon
	public static final String SCANNED_COUPON_HDR = "SCANNED_COUPON_HDR";
	public static final String ENTER_COUPON_DISC_AMT = "ENTER_COUPON_DISC_AMT";
	public static final String ADDITIONAL_ITEM_CANT_BE_ADDED = "ADDITIONAL_ITEM_CANT_BE_ADDED";
	public static final String COUPON_SCANNING_DISABLED = "COUPON_SCANNING_DISABLED";
	//newly added for scanned coupon

	public static final String ERRM_1417 = "ruby-err-msg-E1417";
	public static final String ERRM_1419 = "ruby-err-msg-E1419";

	// Loyalty messages
	public static final String ERRM_1296 = "ruby-err-msg-E1296";
	public static final String ERRM_1297 = "ruby-err-msg-E1297";
	public static final String LOYALTY_UNDERRUN_OVERRUN = "LOYALTY_UNDERRUN_OVERRUN";
    public static final String ERRM_1312 = "ruby-err-msg-E1312";
    public static final String ERRM_9040 = "ruby-err-msg-E9040";

    //EPSPrepaid messages
    public static final String PRODUCT_CODE_MISMATCH = "PRODUCT_CODE_MISMATCH";
    public static final String PREPAID_DEP_NOT_AVAILABLE = "PREPAID_DEP_NOT_AVAILABLE";
    public static final String EVALUATION_FAILED = "EVALUATION_FAILED";
    public static final String REFUND_FAILED = "REFUND_FAILED";

    public static final String MUST_COMPLETE_REFUND = "MUST_COMPLETE_REFUND";
	// System Error Messages

	public static final String ERRM_1199 = "ruby-err-msg-E1199";
	public static final String SERVER_UNREACHABLE = "SERVER_DOWN";
	public static final String NO_PENDING_FOOD_ORDERS = "NO_PENDING_FOOD_ORDERS";
	public static final String PLEASE_WAIT = "PLEASE_WAIT";

	// added
	public static final String CHANGE_TOPAZ_IP = "CHANGE_TOPAZ_IP";
	public static final String CHANGE_TOPAZ_REGISTER_ID = "CHANGE_TOPAZ_REGISTER_ID";
	public static final String CHANGE_SAPPHIRE_IP = "CHANGE_SAPPHIRE_IP";
	public static final String CHANGE_GATEWAY = "CHANGE_GATEWAY";
	public static final String CHANGE_NETMASK = "CHANGE_NETMASK";
	public static final String CHANGE_HPV = "CHANGE_HPV_IP";
	public static final String CURRENT_VALUE = "CURRENT_VALUE";

	public static final String TOPAZ_REGISTER_ID = "TOPAZ_REGISTER_ID";
	public static final String TOPAZ_IP = "TOPAZ_IP";
	public static final String SAPPHIRE_IP = "SAPPHIRE_IP";
	public static final String GATEWAY = "Gateway";
	public static final String NETMASK = "Netmask";
	public static final String HPV = "HPV-20";
	public static final String RESTORE_VERIFONE_SETTINGS = "RESTORE_VERIFONE_SETTINGS";
	public static final String RESTORE_DEFAULT = "RESTORE_DEFAULT";
	public static final String RESTORE_VERIFONE_SETTINGS_CONFIRM = "RESTORE_VERIFONE_SETTINGS_CONFIRM";
	public static final String IP_CONFIG_CONFIRM1 = "IP_CONFIG_CONFIRM1";
	public static final String IP_CONFIG_CONFIRM2 = "IP_CONFIG_CONFIRM2";
	public static final String IP_CONFIG_CONFIRM_TITLE = "IP_CONFIG_CONFIRM_TITLE" ;
	public static final String REBOOT_POS_SHORT_MSG = "REBOOT_POS_SHORT_MSG";
	public static final String REBOOT_POS_DETAILED_MSG = "REBOOT_POS_DETAILED_MSG";
	
	public static final String INVALID_IP = "INVALID_IP";
	public static final String INVALID_REG_ID = "INVALID_REG_ID";
	public static final String IP_CONFIGURATION = "IP_CONFIGURATION";
	public static final String SELECT_PARAMETER_TO_MODIFY = "SELECT_PARAMETER_TO_MODIFY";

	public static final String TOPAZ_UPDATE_ERROR = "TOPAZ_UPDATE_ERROR";
	public static final String SAPPHIRE_UPDATE_ERROR = "SAPPHIRE_UPDATE_ERROR";
	public static final String SAPPHIRE_CONFIG_VIEW_ERROR = "SAPPHIRE_CONFIG_VIEW_ERROR";

	///////////////////////

	public static final String CODEBASE_CGI_ERROR = "CODEBASE_CGI_ERROR";

	public static final String SAFEDROP_REQUIRED = "SAFEDROP_REQUIRED" ;
	public static final String CONFIGURED_TO_ALLOWSAFEDROP = "CONFIGURED_TO_ALLOWSAFEDROP" ;

	public static final String SUSPENDED_ALARM = "SUSPENDED_ALARM";
	public static final String PENDING_KIOSK_ALARM = "PENDING_KIOSK_ALARM";
	public static final String PENDING_FC_ALARM = "PENDING_FC_ALARM";

	// Kitchen printer error messages
	public static final String KITCHENPRINTER_OFFLINE = "KITCHENPRINTER_OFFLINE" ;
	public static final String KITCHENPRINTER_NEAREMPTY = "KITCHENPRINTER_NEAREMPTY" ;
	public static final String KITCHENPRINTER_EMPTY = "KITCHENPRINTER_EMPTY" ;
	public static final String KITCHENPRINTER_COVEROPEN = "KITCHENPRINTER_COVEROPEN" ;
	public static final String KITCHENPRINTER_RMIDOWN = "KITCHENPRINTER_RMIDOWN" ;
	public static final String KITCHENPRINTER_RMIUP = "KITCHENPRINTER_RMIUP" ;


	// ESafe
        public static final String ESAFE_PROMPT_TITLE = "ESAFE_PROMPT_TITLE"; //esafe drop title.
        public static final String ESAFE_LOAN_PROMPT_TITLE = "ESAFE_LOAN_PROMPT_TITLE"; //esafe loan title.
	public static final String ESAFE_ELECTRONIC_PROMPT = "ESAFE_ELECTRONIC_PROMPT";
	public static final String ELECTRONIC_ESAFE_LOAN_PROMPT = "ELECTRONIC_ESAFE_LOAN_PROMPT";
	public static final String ESAFE_ID_PROMPT = "ESAFE_ID_PROMPT";
	public static final String ESAFE_INVALID_ID = "ESAFE_INVALID_ID";
	public static final String ESAFE_ID = "ESAFE_ID";
	public static final String NAME = "NAME";
	public static final String ESAFE_COMM_IN_PROG = "ESAFE_COMM_IN_PROG";


	//Tidel ESafe
	public static final String ESAFE_DROP_MENU = "ESAFE_DROP_MENU";
	public static final String ESAFE_LOAN_MENU = "ESAFE_LOAN_MENU";
	public static final String ESAFE_LOAN_COIN_DENOMINATION = "ESAFE_LOAN_COIN_DENOMINATION";
	public static final String ESAFE_LOAN_NOTE_DENOMINATION = "ESAFE_LOAN_NOTE_DENOMINATION";
	public static final String ESAFE_PROMPT_INSERT_BILLS = "ESAFE_PROMPT_INSERT_BILLS";
	public static final String ESAFE_PROMPT_VAULT_DROP = "ESAFE_PROMPT_VAULT_DROP";
	public static final String ESAFE_PROMPT_VEND_TUBE = "ESAFE_PROMPT_VEND_TUBE";
	//SafeDrop
	public static final String SAFE_DROP_INSERT_BILLS = "SAFE_DROP_INSERT_BILLS";
	public static final String SAFE_DROP_VAULT_DROP = "SAFE_DROP_VAULT_DROP";
	public static final String ENTER_AMOUNT= "ENTER_AMOUNT";
	public static final String SELECT_MOP_KEY = "SELECT_MOP_KEY";
	public static final String ENTER_MEDIA_COUNT = "ENTER_MEDIA_COUNT";
	public static final String ENTER_ENVELOP_NUMBER = "ENTER_ENVELOP_NUMBER";
	public static final String PROCEED_WITH_NON_ELECTRONIC_SAFEDROP = "PROCEED_WITH_NON_ELECTRONIC_SAFEDROP";
	public static final String PROCEED_WITH_NON_ELECTRONIC_SAFEDROP_YN = "PROCEED_WITH_NON_ELECTRONIC_SAFEDROP_YN";
	public static final String ENTER_AMOUNT_AGAIN = "ENTER_AMOUNT_AGAIN";
	public static final String CHOOSE_MOP = "CHOOSE_MOP";
	public static final String MAX_ENVELOP_NUMBER_LEN = "MAX_ENVELOP_NUMBER_LEN";


	//SafeLoan
	public static final String SAFE_LOAN_VEND_TUBE = "SAFE_LOAN_VEND_TUBE";
	public static final String SAFE_LOAN_DISPENSE_COINS = "SAFE_LOAN_DISPENSE_COINS";
	public static final String SAFE_LOAN_DISPENSE_NOTES = "SAFE_LOAN_DISPENSE_NOTES";
	public static final String SAFE_LOAN_DISPENSE_COMBO = "SAFE_LOAN_DISPENSE_COMBO";

	public static final String ENTER_DENOMINATION = "ENTER_DENOMINATION";
	public static final String ENTER_COUNT = "ENTER_COUNT";
	public static final String ENTER_ANOTHER_DENOMINATION = "ENTER_ANOTHER_DENOMINATION";
	public static final String PROCEED_WITH_NON_ELECTRONIC_SAFELOAN = "PROCEED_WITH_NON_ELECTRONIC_SAFELOAN";
	public static final String PROCEED_WITH_NON_ELECTRONIC_SAFELOAN_YN = "PROCEED_WITH_NON_ELECTRONIC_SAFELOAN_YN";

	//SafeDrop/SafeLoan Receipts
	public static final String SAFE_DROP_INSERT_BILLS_CMPLTED_SUCCESS = "SAFE_DROP_INSERT_BILLS_CMPLTED_SUCCESS";
	public static final String SAFE_DROP_VAULT_DROP_CMPLTED_SUCCESS = "SAFE_DROP_VAULT_DROP_CMPLTED_SUCCESS";
	public static final String SAFE_LOAN_VEND_TUBE_CMPLTED_SUCCESS = "SAFE_LOAN_VEND_TUBE_CMPLTED_SUCCESS";
	public static final String SAFE_LOAN_DISPENSE_COINS_CMPLTED_SUCCESS = "SAFE_LOAN_DISPENSE_COINS_CMPLTED_SUCCESS";
	public static final String SAFE_LOAN_DISPENSE_NOTES_CMPLTED_SUCCESS = "SAFE_LOAN_DISPENSE_NOTES_CMPLTED_SUCCESS";
	public static final String SAFE_LOAN_DISPENSE_COMBO_CMPLTED_SUCCESS = "SAFE_LOAN_DISPENSE_COMBO_CMPLTED_SUCCESS";

	//Esafe EOD and Cashier Report
	public static final String CASHIER_ESAFE_DATA_UNAVAILABLE = "CASHIER_ESAFE_DATA_UNAVAILABLE";
	public static final String CASHIER_ESAFE_REPORT = "CASHIER_ESAFE_REPORT";
	public static final String NO_CASHIER_TOTALS = "NO_CASHIER_TOTALS";
	public static final String E_SAFE_ID = "E_SAFE_ID";
	public static final String TOTALS = "TOTALS";
	public static final String CASHIER_TOTALS_FOR = "CASHIER_TOTALS_FOR";
	public static final String E_SAFE_DROPS ="E_SAFE_DROPS";
	public static final String ENVELOPE_DROPS ="ENVELOPE_DROPS";
	public static final String TOTAL_ENVELOPE_DROPS = "TOTAL_ENVELOPE_DROPS";
	public static final String TOTAL_ENV_DROPS = "TOTAL_ENV_DROPS";
	public static final String BILL_ACCEPTOR_DROPS = "BILL_ACCEPTOR_DROPS";
	public static final String TOTAL_ESAFE_DROPS = "TOTAL_ESAFE_DROPS";
	public static final String ESAFE_LOANS ="ESAFE_LOANS";
	public static final String TOTAL_TUBES_VENDED = "TOTAL_TUBES_VENDED";
	public static final String TOTAL_POS_DROPS = "TOTAL_POS_DROPS";
	public static final String POS_SAFE_DROPS = "POS_SAFE_DROPS";
	public static final String POS_SAFE_LOANS ="POS_SAFE_LOANS";
	public static final String TOTAL_COINS_DISPENSED = "TOTAL_COINS_DISPENSED";
	public static final String TOTAL_ESAFE_LOANS = "TOTAL_ESAFE_LOANS";
	public static final String UNRECOGNIZED_BILLS = "UNRECOGNIZED_BILLS";
	public static final String UNVERIFIED_CASH_RATIO = "UNVERIFIED_CASH_RATIO";
	public static final String TOTAL_POS_LOANS = "TOTAL_POS_LOANS";
	public static final String RECONCILIATION = "RECONCILIATION";
	public static final String ESAFE= "ESAFE";
	public static final String POS = "POS";
	public static final String DIFF = "DIFF";
	public static final String SAFE_DROPS = "SAFE_DROPS";
	public static final String SAFE_LOANS = "SAFE_LOANS";

	public static final String ESAFE_DATA_UNAVAILABLE = "ESAFE_DATA_UNAVAILABLE";
	public static final String ESAFE_DEVICE_DAY = "ESAFE_DEVICE_DAY";
	public static final String ESAFE_SHIFT_RANGE = "ESAFE_SHIFT_RANGE";
	public static final String ESAFE_MOP_NOT_SUPPORTED = "ESAFE_MOP_NOT_SUPPORTED";
	public static final String ESAFE_EOD_LOCK_FAIL = "ESAFE_EOD_LOCK_FAIL";
	public static final String ESAFE_EOD_COMM_FAIL = "ESAFE_EOD_COMM_FAIL";
	public static final String ESAFE_COMM_FAIL_ON_CURRENT_CONTENTS ="ESAFE_COMM_FAIL_ON_CURRENT_CONTENTS";
	public static final String ESAFE_OPRN_CANCELLED = "ESAFE_OPRN_CANCELLED";

	//Exception messages
	public static final String USER_UNKNOWN = "USER_UNKNOWN";
	public static final String DEVICE_UNAVAILABLE = "DEVICE_UNAVAILABLE";
	public static final String INTERNAL_ERROR = "INTERNAL_ERROR";
	public static final String REMOTE_SERVER_DOWN = "REMOTE_SERVER_DOWN";
	public static final String REMOTE_SERVER_INVALID_RESPONSE = "REMOTE_SERVER_INVALID_RESPONSE";
	public static final String ESAFE_NOT_INITIALIZED = "ESAFE_NOT_INITIALIZED";
	public static final String DEVICE_BUSY = "DEVICE_BUSY";
    public static final String LOCK_FAILED = "LOCK_FAILED";
    public static final String LOCK_EXPIRED = "LOCK_EXPIRED";
	public static final String CANNOT_PROCEED = "CANNOT_PROCEED";
	public static final String VAULT_DROP_TIMED_OUT = "VAULT_DROP_TIMED_OUT";
	public static final String INSERT_BILLS_TIMED_OUT = "INSERT_BILLS_TIMED_OUT";
	public static final String CANNOT_PROCEED_NO_HW = "CANNOT_PROCEED_NO_HW";
	public static final String CANNOT_PROCEED_CUP_NOT_EMPTY = "CANNOT_PROCEED_CUP_NOT_EMPTY";
	public static final String OPRN_CANCELLED_AT_ESAFE = "OPRN_CANCELLED_AT_ESAFE";
	public static final String MALFUNCTION_ON_VEND_TUBE = "MALFUNCTION_ON_VEND_TUBE";
	public static final String MALFUNCTION_ON_DISPENSE_COMBO = "MALFUNCTION_ON_DISPENSE_COMBO";
	public static final String  MALFUNCTION_ON_DISPENSE_COINS = "MALFUNCTION_ON_DISPENSE_COINS";
	public static final String MALFUNCTION_ON_DISPENSE_NOTES = "MALFUNCTION_ON_DISPENSE_NOTES";
	public static final String CANNOT_PROCEED_ON_EOD= "CANNOT_PROCEED_ON_EOD";
	public static final String EOS_FAILED= "EOS_FAILED";
	public static final String INVALID_INPUT = "INVALID_INPUT";
    public static final String PRICE_CHECK_EXCEPTION = "PRICE_CHECK_EXCEPTION";
    public static final String ESAFE_NOT_FOUND = "ESAFE_NOT_FOUND";
    public static final String MOBILE_PAYMENT_UNAVAILABLE = "MOBILE_PAYMENT_UNAVAILABLE";
    public static final String EXCEPTION_REPRINT = "EXCEPTION_REPRINT";

	// Device names used in Device Control
	public static final String COIN_DISPENSER_NAME = "CoinDispenserName";
	public static final String PINPAD_NAME = "PinPadName";
	public static final String POLE_DISPLAY_NAME = "PoleDisplayName";
	public static final String PRINTER_NAME = "PrinterName";
	public static final String SCANNER_NAME = "ScannerName";
	public static final String CHECK_SCANNER_NAME = "CheckScannerName";
	public static final String DVR_JOURNAL_NAME = "DvrJournalName";
	public static final String KITCHEN_PRINTER_NAME = "KitchenPrinterName";
	public static final String SECONDARY_SCANNER_NAME = "SecondaryScannerName";

	public static final String SERIAL_PORT_SETUP = "SerialPortSetup";
	public static final String AVAILABLE_DEVICES = "AvailableDevices";
	public static final String CASH_DRAWER_SETUP = "CashDrawerSetup";

	public static final String DEVICE_SAVE_BTN = "DeviceSaveButton";
	public static final String DEVICE_QUIT_BTN = "DeviceQuitButton";
	public static final String DEVICE_REBOOT_BTN = "DeviceRebootButton";
	public static final String DEVICE_BAUD_BTN = "DeviceBaudButton";
	public static final String DEVICE_PORT_BTN = "DevicePortButton";

	// As part of CR_4046

	public static final String MONEY_ORDER = "MONEY_ORDER";//MONEY ORDER
	public static final String MO_DEV_STATUS = "MO_DEV_STATUS";//Checking M.O. Device Status
	public static final String PREPAID = "PREPAID";//PREPAID
	public static final String STARTED_SUCCESSFULLY = "STARTED_SUCCESSFULLY";//Started Successfully
	public static final String TOGGLE_SUCCESSFUL = "TOGGLE_SUCCESSFUL";//Toggle Successful-new state=
	public static final String IN_PROGRESS = "IN_PROGRESS";//In Progress
	public static final String RMI_REQUEST_FAILED = "RMI_REQUEST_FAILED";//RMI Request failed
	public static final String ALERT = "ALERT";//ALERT
	public static final String ENTER_CASHBK_PINPAD = "ENTER_CASHBK_PINPAD";//Enter Cashback on PinPad
	public static final String CHOOSE_YES_NO_PINPAD = "CHOOSE_YES_NO_PINPAD";//Choose Y/N on PinPad
	public static final String DEBIT_CASHBACK = "DEBIT_CASHBACK";//For Debit Cashback
	public static final String CASHBACK_YES_NO = "CASHBACK_YES_NO";//CASHBACK YES/NO?
	public static final String CASHBACK_ENTER = "CASHBACK_ENTER";//ENTER CASHBACK
	public static final String MAX_CASHBACK = "MAX_CASHBACK";
	public static final String GET_BALANCE_INQUIRY = "GET_BALANCE_INQUIRY";//Get Balance Inquiry
	public static final String PRINTING_BALANCE_INQUIRY = "PRINTING_BALANCE_INQUIRY";//Printing Balance Inquiry...
	public static final String FAILED_BALANCE_INQUIRY = "FAILED_BALANCE_INQUIRY";//Balance Inquiry Failed
	public static final String DISCARD_FULE_PRICE_CHANGES = "DISCARD_FULE_PRICE_CHANGES";//Discard Fuel Price Changes ?
	public static final String SEQUENCE_NO = "SEQUENCE_NO";// Sequence #
	public static final String CLOSE_STATUS = "CLOSE_STATUS";//Close Status
	public static final String SYSTEM_RESET = "SYSTEM_RESET";//System Reset
	public static final String SAPPHIRE_RESET = "CONTROLLER_RESET";//Reset Sapphire (NewPro) System?
	public static final String COUPON_SCANNING = "COUPON_SCANNING";//Coupon Scanning
	public static final String ENTER_COUPON_VALUE = "ENTER_COUPON_VALUE";//Verify required purchases. Enter value of the Coupon
	public static final String ON_PINPAD = "ON_PINPAD";// on PinPad
	public static final String EXEMPT = "EXEMPT";//EXEMPT
	public static final String ASKED_TAX = "ASKED_TAX";// TAX?
	public static final String INITIALIZING_SALES_FUNCTION = "INITIALIZING_SALES_FUNCTION";//Sales functions initializing
	public static final String CASH_DRAWER_OPEN = "CASH_DRAWER_OPEN";//CASH DRAWER OPEN
	public static final String CANT_CONT_SALES = "CANT_CONT_SALES";//Cannot continue Sales
	public static final String CLOSE_CASH_DRAWER = "CLOSE_CASH_DRAWER";//Please Close Cash Drawer
	public static final String ID_CHECK_REQUIRED = "ID_CHECK_REQUIRED";//ID CHECK REQUIRED
	public static final String ENTER_DOB = "ENTER_DOB";//Enter Birth Date
	public static final String SCANNNED_COUPON = "SCANNNED_COUPON";//Scanned Coupon
	public static final String FUEL_TAX_EXEMPTION = "FUEL_TAX_EXEMPTION";//Fuel Tax Exemption
	public static final String INVALID_OPERATION = "INVALID_OPERATION";//Invalid Operation
	public static final String ENTER_PUMP_NO = "ENTER_PUMP_NO";//Enter pump number
	public static final String ENTER_DCR_NO = "ENTER_DCR_NO";//Enter DCR Number, 0 for all DCRs
	public static final String BACKUP_LOG = "BACKUP_LOG";//Backup Log
	public static final String BACKUP_SAPPHIRE_LOG = "BACKUP_CONTROLLER_LOG";//Backup Sapphire (GemPro & NewPro) Log?
	public static final String MODEM_RESET = "MODEM_RESET";//Modem Reset
	public static final String MODEM_SAPPHIRE_RESET = "MODEM_CONTROLLER_RESET";//Reset Sapphire (GemPro & NewPro) Modem?
	public static final String ENTER_CASHIER_NO = "ENTER_CASHIER_NO";//Enter Cashier Number
	public static final String POP_AWARD = "POP_AWARD";//POP Award
	public static final String ITEM_TEPM_DISABLED = "ITEM_TEPM_DISABLED";//Item Temporarily Disabled
	public static final String PINPAD = "PINPAD";//PINPAD
	public static final String BALANCE_PRINTED = "BALANCE_PRINTED";//Available balance is printed on receipt.
	public static final String APPROVED_NET = "APPROVED_NET";//Approved for Net 2
	public static final String APPROVAL_NO = "APPROVAL_NO";//Approval #
	public static final String CALL = "CALL";//Call
	public static final String VOICE_AUTH = "VOICE_AUTH";// for voice auth
	public static final String RESTRICTED_ITEM = "RESTRICTED_ITEM";//RESTRICTED ITEM
	public static final String CANNOT_PURCHASE_ITEM = "CANNOT_PURCHASE_ITEM";//CUSTOMER CANNOT PURCHASE THIS ITEM
	public static final String PAYROLL_REPORT_TITLE = "PAYROLL_REPORT_TITLE";//Payroll Report
	public static final String EMP_ID = "EMP_ID";//Employee ID (<ENTER> for ALL)
	public static final String PAYROLL_REPORT_CLOSED = "PAYROLL_REPORT_CLOSED";//Payroll period closed
	public static final String PAYROLL_REPORT_CLOSE_FAILED = "PAYROLL_REPORT_CLOSE_FAILED";//Payroll period close failed
	public static final String MANUAL_FUEL = "MANUAL_FUEL";//Manual Fuel
	public static final String SKIP_PUMP_NUMBER = "SKIP_PUMP_NUMBER";//Press OK/<ENTER> to skip pump number
	public static final String MUST_VOID_TICKET = "MUST_VOID_TICKET";
	
	

	public static final String PMT_SAFE_SAFE_DROP_HDR = "PMT_SAFE_SAFE_DROP_HDR";
	public static final String PMT_SAFE_PRESS_MOP = "PMT_SAFE_PRESS_MOP";
	public static final String PMT_SAFE_PAYOUT_HDR = "PMT_SAFE_PAYOUT_HDR";
	public static final String PMT_SAFE_SAFE_LOAN_HDR = "PMT_SAFE_SAFE_LOAN_HDR";
	public static final String PMT_SAFE_REF_NUM = "PMT_SAFE_REF_NUM";
	public static final String PMT_SAFE_PLEASE_CONFIRM = "PMT_SAFE_PLEASE_CONFIRM";
	public static final String PMT_SAFE_YES_KEY = "PMT_SAFE_YES_KEY";
	public static final String PMT_SAFE_NO_KEY = "PMT_SAFE_NO_KEY";
	public static final String PMT_SAFE_IS_MO = "PMT_SAFE_IS_MO";
	public static final String PMT_SAFE_VENDOR_ID = "PMT_SAFE_VENDOR_ID";
	public static final String PMT_SAFE_VENDOR_PAYEE = "PMT_SAFE_VENDOR_PAYEE";
	public static final String VP_AMOUNT_LARGE = "VP_AMOUNT_LARGE";
	public static final String VP_VENDORID_NOT_VALID = "VP_VENDORID_NOT_VALID";

	public static final String CLEAR = "CLEAR";
	public static final String PRESS_ENTER_MOP_KEY = "PRESS_ENTER_MOP_KEY";
	public static final String PMT_SAFE_NO_SALE_HDR = "PMT_SAFE_NO_SALE_HDR";
	public static final String PMT_SAFE_PAYIN_HDR = "PMT_SAFE_PAYIN_HDR";

	public static final String PMT_SAFE_IN_HOUSE_ACC_NUM = "PMT_SAFE_IN_HOUSE_ACC_NUM";
	public static final String PMT_SAFE_IN_HOUSE_SUB_ACC_NUM = "PMT_SAFE_IN_HOUSE_SUB_ACC_NUM";
	public static final String ERROR_RETRIEVING_TRANS = "ERROR_RETRIEVING_TRANS";
	public static final String INVALID_SAFE_DROP_TRANS = "INVALID_SAFE_DROP_TRANS";
	public static final String TRANSACTION = "TRANSACTION";
	public static final String ALREADY_CORRECTED = "ALREADY_CORRECTED";
	public static final String CANNT_CORRECT_CASHIER_ALREADY_CLOSED = "CANNT_CORRECT_CASHIER_ALREADY_CLOSED";
	public static final String TICKET_NUM_REQUIRED = "TICKET_NUM_REQUIRED";

	public static final String SELECT_OPTION = "SELECT_OPTION";
	// As part of CR_4046

	//added for journaling login/logout accessing manager menu events.
	public static final String ENTER 					= "ENTER";
	public static final String EXIT					= "EXIT";
	public static final String EMPLOYEE				= "EMPLOYEE";
	public static final String REGISTER			 	= "REGISTER";
	public static final String SALES					= "SALES";
	public static final String	REPORT_FUNCTIONS  		= "REPORT_FUNCTIONS";
	public static final String NETWORK_FUNCTIONS 		= "NETWORK_FUNCTIONS";
	public static final String FUEL_FUNCTIONS 			= "FUEL_FUNCTIONS";
	public static final String MAINTENANCE_FUNCTIONS 	= "MAINTENANCE_FUNCTIONS";

	public static final String VOID_LINE 	= "VOID_LINE";
	public static final String CHANGE_QTY 	= "CHANGE_QTY";
	public static final String CHANGE_PRICE 	= "CHANGE_PRICE";
	public static final String ADD_TAX_EXEMPT 	= "ADD_TAX_EXEMPT";
	public static final String FIXED_DISCOUNT 	= "FIXED_DISCOUNT";
	public static final String DOLLAR_DISCOUNT 	= "DOLLAR_DISCOUNT";
	public static final String PERCENT_DISCOUNT 	= "PERCENT_DISCOUNT";
    public static final String MANUAL_DISCOUNT  = "MANUAL_DISCOUNT";
	public static final String MODIFY 	= "MODIFY";
	// Strings for Receipt Printer and JPOS status alarms
	public static final String JPOS_PRINTER              = "JPOS_PRINTER";
	public static final String JPOS_RECEIPT_PRINTER_S    = "JPOS_RECEIPT_PRINTER_S";
	public static final String JPOS_RECEIPT_PRINTER_L    = "JPOS_RECEIPT_PRINTER_L";
	public static final String JPOS_JOURNAL_PRINTER_S    = "JPOS_JOURNAL_PRINTER_S";
	public static final String JPOS_JOURNAL_PRINTER_L    = "JPOS_JOURNAL_PRINTER_L";
	public static final String JPOS_SLIP_PRINTER_S         = "JPOS_SLIP_PRINTER_S";
	public static final String JPOS_SLIP_PRINTER_L         = "JPOS_SLIP_PRINTER_L";
	public static final String JPOS_ONLINE               = "JPOS_ONLINE";
	public static final String JPOS_OFFLINE              = "JPOS_OFFLINE";
	public static final String JPOS_PTR_NEAREMPTY      = "JPOS_PTR_NEAREMPTY";
	public static final String JPOS_PTR_EMPTY          = "JPOS_PTR_EMPTY";
	public static final String JPOS_PTR_COVEROPEN        = "JPOS_PTR_COVEROPEN";
	public static final String JOURNAL_PRINTER_DISABLED      = "JOURNAL_PRINTER_DISABLED";
	public static final String JOURNAL_PRINTER_OFFLINE       = "JOURNAL_PRINTER_OFFLINE";
	public static final String JOURNAL_PRINTER_PAPER_EMPTY   = "JOURNAL_PRINTER_PAPER_EMPTY";
	public static final String JOURNAL_PRINTER_PAPER_LOW     = "JOURNAL_PRINTER_PAPER_LOW";
	public static final String JPOS_PTR_UNAVAILABLE        = "JPOS_PTR_UNAVAILABLE";
	public static final String JPOS_PTR_UNAUTHORIZED        = "JPOS_PTR_UNAUTHORIZED";
	
	public static final String PRINTER_PAPER_OK = "PRINTER_PAPER_OK";
	public static final String PRINTER_COVER_CLOSED = "PRINTER_COVER_CLOSED";

     //CR6677 SWB Money Order enhancements
     public static final String ERRM_1271 					= "ruby-err-msg-E1271";
     public static final String MO_1234						= "MO_1234";

	//Added for TLS ResetTankAlarm Menu option in Topaz
	public static final String  RESET_EXTERNALINPUTALARM_FLAG = "RESET_EXTERNALINPUTALARM_FLAG";
	public static final String  RESET_TANKALARM_TANKNUMBER = "RESET_TANKALARM_TANKNUMBER";
	public static final String  RESET_TANKALARM = "RESET_TANKALARM";
	public static final String  ENTER_TLS_TANK_NO = "ENTER_TLS_TANK_NO";
	public static final String  ENTER_ALARM_FLAG = "ENTER_ALARM_FLAG";
	public static final String  RESET_EXTERNAL_FLAG = "RESET_EXTERNAL_FLAG";
	public static final String  CLEAR_EXTERNAL_INPUT = "CLEAR_EXTERNAL_INPUT";
	public static final String INVALID_TANK_SELECTION = "INVALID_TANK_SELECTION";

	public static final String BAD_SELLABLE = "BAD_SELLABLE";
    public static final String DEVICE_COMM_EXCEPTION = "DEVICE_COMM_EXCEPTION";
    public static final String NO_SALE_ALLOWED = "NO_SALE_ALLOWED";
    public static final String PLU_NOT_FOUND_EXCEPTION = "PLU_NOT_FOUND_EXCEPTION";

    public static final String AEOD_FAILED = "AEOD_FAILED";
    public static final String AEOD_INITIATE_AN_END_OF_DAY_MANUALLY = "AEOD_INITIATE_AN_END_OF_DAY_MANUALLY";

    //Carwash-related Menu Items
    public static final String ENABLE_CARWASH = "ENABLE_CARWASH";
    public static final String DISABLE_CARWASH = "DISABLE_CARWASH";
    
    //VTP-related Menu Items
    public static final String REGISTER_DCR = "RegisterDCR";
    public static final String INCREMENT_DCR_KEY = "IncrementDCRKey";
    public static final String UPDATE_DCR_SETTINGS = "UpdateDCRSettings";
    public static final String TAVE_DCR_SETTINGS = "TAVE_DCR_SETTINGS";
    public static final String ENTER_DCR_NUM = "ENTER_DCR_NUM";


    //Unattended-related Menu Items
    public static final String ENABLE_UNATTENDED = "ENABLE_UNATTENDED";
    public static final String DISABLE_UNATTENDED = "DISABLE_UNATTENDED";
    public static final String SCHEDULE_UNATTENDED = "SCHEDULE_UNATTENDED";
    public static final String UNATTENDED_MENU = "UNATTENDED_MENU";
    
    // Helpdesk/ESG Shell Login enable/disable items
    public static final String ENABLE_LOGIN = "ENABLE_LOGIN";
    public static final String DISABLE_LOGIN = "DISABLE_LOGIN";
    
	public static final String GENERATE_SECURE_OTP = "GENERATE_SECURE_OTP";
	public static final String DELETE_SECURE_OTP = "DELETE_SECURE_OTP";

    public static final String FOOD_SERVICE_HDR = "FOOD_SERVICE_HDR";
	public static final String KIOSK_UNAVAILABLE = "KIOSK_UNAVAILABLE";
	public static final String FALLBACK_WITH_KP = "FALLBACK_WITH_KP";
	public static final String PRINTING_FOOD_ORDER_FOR_KITCHEN_PREP = "PRINTING_FOOD_ORDER_FOR_KITCHEN_PREP";
	public static final String FEATURE_NOT_SUPPORTED ="FEATURE_NOT_SUPPORTED";
	public static final String KIOSK_COMM_FAILURE = "KIOSK_COMM_FAILURE";
	public static final String PRINT_FOOD_SVC_PMNT_TICKET = "PRINT_FOOD_SVC_PMNT_TICKET";
	public static final String FOOD_SVC_ORDER_PMNT_RECEIPT_HDR = "FOOD_SVC_ORDER_PMNT_RECEIPT_HDR";
	public static final String PAID_STATUS = "PAID_STATUS";
	public static final String DUE_STATUS = "DUE_STATUS";
	public static final String LISTEN_TICKET_NUMBER = "LISTEN_TICKET_NUMBER";
	public static final String PICKUP_TICKET_NUMBER = "PICKUP_TICKET_NUMBER";
	
    public static final String LOGIN_FUNC_FAILURE = "LOGIN_FUNC_FAILURE";
    public static final String LOGIN_TOKEN = "LOGIN_TOKEN";
	public static final String OTP_STR = "OTP_STR";
    public static final String UPLINK_VPN = "UPLINK_VPN";
    public static final String ENABLE_LOGIN_SUCCESS_MSG = "ENABLE_LOGIN_SUCCESS_MSG";
    public static final String DISABLE_LOGIN_SUCCESS_MSG = "DISABLE_LOGIN_SUCCESS_MSG";
	public static final String OTP_GENERATED_SUCCESS_MSG = "OTP_GENERATED_SUCCESS_MSG";
	public static final String OTP_DELETED_SUCCESS_MSG = "OTP_DELETED_SUCCESS_MSG";
	public static final String MNSP_VPN_NOT_ESTABLISHED = "MNSP_VPN_NOT_ESTABLISHED";
    public static final String FUEL_STREET_PRICE_TITLE1 = "FUEL_STREET_PRICE_TITLE1";
    public static final String FUEL_STREET_PRICE_TITLE2 = "FUEL_STREET_PRICE_TITLE2";
    public static final String NO_DATA_AVLBLE = "NO_DATA_AVLBLE";
    public static final String LOCATION_ID = "LOCATION_ID";
    public static final String STORE_NUMBER = "STORE_NUMBER";
    
    // Period close failure reasons
    public static final String PERIOD_CLOSE_CANCELED_BY = "PERIOD_CLOSE_CANCELED_BY";
    public static final String UNACKNOWLEDGED_CLOSE_BY = "UNACKNOWLEDGED_CLOSE_BY";
    public static final String FAILURE_REASON = "FAILURE_REASON";
    public static final String ADVANCED_OPTIONS_SELECTION_IMAGE_FILE = "ADVANCED_OPTIONS_SELECTION_IMAGE_FILE";

    
    

    public static final String ENTER_OPEN_DRAWER_AMOUNT = "ENTER_OPEN_DRAWER_AMOUNT";
    public static final String UPDATING_SCREEN_CONFIG = "UPDATING_SCREEN_CONFIG";
    
    public static final String INCLUDED_IN_PRICE             = "INCLUDED_IN_PRICE";    
    public static final String M_O_SERIAL_NUMBER             = "M_O_SERIAL_NUMBER";   
    public static final String TAX_ON_REBATE_OF              = "TAX_ON_REBATE_OF";  
    public static final String YOUR_PICKUP_IS                = "YOUR_PICKUP_IS"; 
    public static final String LANGUAGE_MENU                 = "LANGUAGE_MENU";
    public static final String SELECT_LANGUAGE               = "SELECT_LANGUAGE";
    public static final String PINPAD_CONFIGURATION          = "PINPAD_CONFIGURATION";
    public static final String SELECT_INSTALLED_PINPAD       = "SELECT_INSTALLED_PINPAD";
    public static final String CURRENTLY_CONFIGURED          = "CURRENTLY_CONFIGURED";
    // Free POP Award - Autogenerate
	public static final String SECURITY_CANCEL		= "SECURITY_CANCEL";
	public static final String AUTO_FREE_POP_TITLE	= "AUTO_FREE_POP_TITLE";
	public static final String AUTO_FREE_POP_DEF	= "AUTO_FREE_POP_DEF";
	public static final String AUTO_FREE_POP_SFD	= "AUTO_FREE_POP_SFD";
	public static final String AUTO_FREE_POP_PFDD	= "AUTO_FREE_POP_PFDD";
	public static final String AUTO_FREE_POP_QTY	= "AUTO_FREE_POP_QTY";
	public static final String AUTO_FREE_POP_FOR	= "AUTO_FREE_POP_FOR";
	public static final String AUTO_FREE_POP_GEN	= "AUTO_FREE_POP_GEN";
	public static final String AUTO_FREE_POP_GTING 	= "AUTO_FREE_POP_GTING";
	public static final String AUTO_FREE_POP_CODES	= "AUTO_FREE_POP_CODES";
	public static final String AUTO_FREE_POP_COMPL	= "AUTO_FREE_POP_COMPL";
	public static final String AUTO_FREE_POP_TLOG	= "AUTO_FREE_POP_TLOG";
	
    public static final String SCANNER_CONFIGURATION         = "SCANNER_CONFIGURATION";
    public static final String SELECT_INSTALLED_SCANNER      = "SELECT_INSTALLED_SCANNER";
    public static final String PRINT_CASHIER_REPORT          = "PRINT_CASHIER_REPORT";
    public static final String ENTER_END_DRAWER_AMOUNT_FOR   = "ENTER_END_DRAWER_AMOUNT_FOR";
    public static final String ENTER_PUMP_NUMBER             = "ENTER_PUMP_NUMBER";
    public static final String GROUPED_ITEM_MENU             = "GROUPED_ITEM_MENU";
    public static final String MODIFIER_MENU                 = "MODIFIER_MENU";
    public static final String OPER_NOT_ALLOWED              = "OPER_NOT_ALLOWED";
       
	//cr1116.01 Food Service
	public static final String EDIT_FOOD_ORDER = "EDIT_FOOD_ORDER";
	public static final String REM_KIOSK_ORDER = "REMOVE_KIOSK_ORDER";
	public static final String DINE_IN_QUESTION = "DINE_IN_QUESTION";
    // cr1151.01 - "Place Order" not allowed for a reason...
    public static final String ERRM_PLACE_ORDER_CANCELLED = "ERRM_PLACE_ORDER_CANCELLED";

    // cr1151.01 - "Void Line" not allowed for a reason...
    public static final String ERRM_VOID_LINE_CANCELLED = "ERRM_VOID_LINE_CANCELLED";
    
    public static final String SELECT_DIAG_TYPE = "SELECT_DIAG_TYPE";
    public static final String HELP_DIAGNOSTICS_MENU = "HELP_DIAGNOSTICS_MENU";
    public static final String HELP_DIAGNOSTICS = "HELP_DIAGNOSTICS";
    public static final String GENERAL="General";
    public static final String FORECOURT="Forecourt";
    public static final String PAYMENT="Payment";
    public static final String MNSP="MNSP";

    public static final String	TKT_NO_INFO="TKT_NO_INFO";
    public static final String	TKT_MO_SERIAL="TKT_MO_SERIAL";
    public static final String	TKT_IN_HOUSE_ACCT="TKT_IN_HOUSE_ACCT";
    public static final String	TKT_MONEY_ORDER="TKT_MONEY_ORDER";
    public static final String	TKT_SUB_ACCT="TKT_SUB_ACCT";
    public static final String	TKT_CSH="TKT_CSH";
    public static final String	TKT_SAFE_DROP_TRANS="TKT_SAFE_DROP_TRANS";
    public static final String	TKT_BOTTOM="TKT_BOTTOM";
    public static final String	TKT_ATT_BOTTOM="TKT_ATT_BOTTOM";
    public static final String	TKT_PAYMENT_DUE="TKT_PAYMENT_DUE";
    public static final String	TKT_TRAN="TKT_TRAN";
    public static final String	TKT_ADDT_LOYALTY_DISC="TKT_ADDT_LOYALTY_DISC";
    public static final String	TKT_REDEEM_LOYALTY_DISCOUNT="TKT_REDEEM_LOYALTY_DISCOUNT";    
    public static final String	TKT_TAX_ON="TKT_TAX_ON";
    public static final String	TKT_REBATE_OF="TKT_REBATE_OF";    
    public static final String	TKT_EA="TKT_EA";
    public static final String	TKT_FEE="TKT_FEE";
    public static final String	TKT_PRO="TKT_PRO";
    public static final String	TKT_GALLONS="TKT_GALLONS";
    public static final String	TKT_LITRES="TKT_LITRES";
    public static final String	TKT_FOR="TKT_FOR";
    public static final String	TKT_FUEL_DISCOUNT="TKT_FUEL_DISCOUNT";
    
    // OTP Related messages.
    public static final String OTP_REQUIRED= "OTP_REQUIRED";//"OTP REQUIRED";
    public static final String PLEASE_ENTER_OTP = "PLEASE_ENTER_OTP";//"Please enter OTP";
    public static final String GENERATE_OTP_MSG1 = "GENERATE_OTP1";//"Go to Maintenance menu to generate OTP";
    public static final String GENERATE_OTP_MSG2 = "GENERATE_OTP2";// "Maintenance -> Generate Config OTP";
    
    public static final String	GENERATE_CONFIG_OTP ="GENERATE_CONFIG_OTP";
    public static final String	DELETE_CONFIG_OTP="DELETE_CONFIG_OTP";
    
    // Rapid Change Fuel
	public static final String FUEL_RCF_CONFIGURATION = "FUEL_RCF_CONFIGURATION";
	public static final String SELECT_RCF_CONFIGURATION = "SELECT_RCF_CONFIGURATION";
	public static final String RCF_MENU_NAME = "RCF_MENU_NAME";
	public static final String RCF_NOT_CONFIGURED = "RCF_NOT_CONFIGURED";
	public static final String RCF_CURRENT_SELECTION = "RCF_CURRENT_SELECTION";
	public static final String RCF_SELECTED = "RCF_SELECTED";
	public static final String RCF_INIT_SUCCESS = "RCF_INIT_SUCCESS";
	public static final String RCF_FORCE_INIT = "RCF_FORCE_INIT";
	public static final String FUEL_INITIALIZATION_PENDING = "FUEL_INITIALIZATION_PENDING";
    public static final String	ENTER_CURRENT_DRAWER_AMOUNT             ="ENTER_CURRENT_DRAWER_AMOUNT";
    public static final String	ZERO_NOT_ALLOWED                        ="ZERO_NOT_ALLOWED";
    public static final String	CLOSED                                  ="CLOSED";
    public static final String  OPEN_DRAWER                             ="OPEN_DRAWER";
    public static final String  DO_YOU_WANT_TO_OPEN_CONNECTED_DRAWERS   ="DO_YOU_WANT_TO_OPEN_CONNECTED_DRAWERS";
          
    public static final String  INVALID_CASHIER_NUMBER_OR_NO_PERIOD_AVAILABLE_FOR="INVALID_CASHIER_NUMBER_OR_NO_PERIOD_AVAILABLE_FOR";
    public static final String  DISCOUNT_SELECTION                      ="DISCOUNT_SELECTION";
    public static final String  TOUCH_TO_MODIFY                         ="TOUCH_TO_MODIFY";
    public static final String  ENTER_NEW_PRICE                         ="ENTER_NEW_PRICE";
    public static final String  ENTER_NEW_QUANTITY                      ="ENTER_NEW_QUANTITY";
    public static final String  REMOTE_SERVER_IS_DOWN                   ="REMOTE_SERVER_IS_DOWN";
    public static final String  REMOTE_SERVICE_IS_DOWN                  ="REMOTE_SERVICE_IS_DOWN";
    public static final String  ERROR_IN_PROCESSING_REQUEST             = "ERROR_IN_PROCESSING_REQUEST";
    public static final String  PINPAD_1                                ="PINPAD_1";
    public static final String  CONFIGURED_1                            ="CONFIGURED_1";
    public static final String  SCANNER_1                               ="SCANNER_1";
    
    public static final String  TOPAZ_RPT_NAME_UNAVAILABLE              ="TOPAZ_RPT_NAME_UNAVAILABLE";
    
    public static final String  TOPAZ_RPT_CURRENT_PAYROLL_REPORT        ="TOPAZ_RPT_CURRENT_PAYROLL_REPORT";
    public static final String  TOPAZ_RPT_CLOSE_PAYROLL_REPORT          ="TOPAZ_RPT_CLOSE_PAYROLL_REPORT";
    public static final String  TOPAZ_RPT_PREVIOUS_PAYROLL_REPORT       ="TOPAZ_RPT_PREVIOUS_PAYROLL_REPORT";
    public static final String  TOPAZ_RPT_EMPLOYEE_SIGNATURE            ="TOPAZ_RPT_EMPLOYEE_SIGNATURE";
    public static final String  TOPAZ_RPT_MANAGER_SIGNATURE             ="TOPAZ_RPT_MANAGER_SIGNATURE";
    
    public static final String  TOPAZ_RPT_CASHIER                       ="TOPAZ_RPT_CASHIER";
    public static final String  TOPAZ_RPT_ATTENDANT                     ="TOPAZ_RPT_ATTENDANT";
    public static final String  TOPAZ_RPT_ATTENDANT_CARD                ="TOPAZ_RPT_ATTENDANT_CARD";
    public static final String  TOPAZ_RPT_CASHIER_WORKSHEET             ="TOPAZ_RPT_CASHIER_WORKSHEET";
    public static final String  TOPAZ_RPT_AMOUNTS_AT_CLOSE              ="TOPAZ_RPT_AMOUNTS_AT_CLOSE";
    
    public final static String TOPAZ_RPT_CASHIER_TRACKING                   ="TOPAZ_RPT_CASHIER_TRACKING";
    public final static String TOPAZ_RPT_CASHIER_TRACKING_DATA_UNAVAILABLE  ="TOPAZ_RPT_CASHIER_TRACKING_DATA_UNAVAILABLE";
    public final static String TOPAZ_RPT_PLU_TRACKING                       ="TOPAZ_RPT_PLU_TRACKING";
    public final static String TOPAZ_RPT_PLU_NUMBER_DESCRIPTION             ="TOPAZ_RPT_PLU_NUMBER_DESCRIPTION";
    public final static String TOPAZ_RPT_QTY_EXT_QTY_AMOUNT                 ="TOPAZ_RPT_QTY_EXT_QTY_AMOUNT";
    public final static String TOPAZ_RPT_TOTALS_WITH_DASH                   ="TOPAZ_RPT_TOTALS_WITH_DASH";
    public final static String TOPAZ_RPT_DEPARTMENT_TRACKING                ="TOPAZ_RPT_DEPARTMENT_TRACKING";
    public final static String TOPAZ_RPT_DEPT_DESCRIPTION_ITEMS             ="TOPAZ_RPT_DEPT_DESCRIPTION_ITEMS";
    public final static String TOPAZ_RPT_GROSS_REFUNDS_DISCOUNT_NET         ="TOPAZ_RPT_GROSS_REFUNDS_DISCOUNT_NET";
    public final static String TOPAZ_RPT_TOTALS                             ="TOPAZ_RPT_TOTALS";
    public final static String TOPAZ_RPT_CATEGORY_TRACKING                  ="TOPAZ_RPT_CATEGORY_TRACKING";
    public final static String TOPAZ_RPT_CAT_DESCRIPTION_ITEMS_NET_SALES    ="TOPAZ_RPT_CAT_DESCRIPTION_ITEMS_NET_SALES";

public final static String TOPAZ_RPT_SUMMARY_DASH="TOPAZ_RPT_SUMMARY_DASH";
public final static String TOPAZ_RPT_MOP_SALES="TOPAZ_RPT_MOP_SALES";
public final static String TOPAZ_RPT_MOP_CANCEL_REFUNDS="TOPAZ_RPT_MOP_CANCEL_REFUNDS";
public final static String TOPAZ_RPT_NET_SALES_TOTAL="TOPAZ_RPT_NET_SALES_TOTAL";
public final static String TOPAZ_RPT_PAYMENT_OUT="TOPAZ_RPT_PAYMENT_OUT";
public final static String TOPAZ_RPT_PAYMENT_IN="TOPAZ_RPT_PAYMENT_IN";
public final static String TOPAZ_RPT_TOTAL_TO_ACCOUNT_FOR="TOPAZ_RPT_TOTAL_TO_ACCOUNT_FOR";
public final static String TOPAZ_RPT_CASHIER_DETAILS_DASH="TOPAZ_RPT_CASHIER_DETAILS_DASH";

public final static String TOPAZ_RPT_CARD_BASED="TOPAZ_RPT_CARD_BASED";
public final static String TOPAZ_RPT_TOTAL_MOP_SALES="TOPAZ_RPT_TOTAL_MOP_SALES";

public final static String TOPAZ_RPT_TOTAL_MOP_CANCEL_REFUNDS="TOPAZ_RPT_TOTAL_MOP_CANCEL_REFUNDS";
public final static String TOPAZ_RPT_CASH_BACK="TOPAZ_RPT_CASH_BACK";
public final static String TOPAZ_RPT_TOTAL_CASHBACK="TOPAZ_RPT_TOTAL_CASHBACK";
public final static String TOPAZ_RPT_PAY_OUT="TOPAZ_RPT_PAY_OUT";
public final static String TOPAZ_RPT_CHANGE_CHECK="TOPAZ_RPT_CHANGE_CHECK";
public final static String TOPAZ_RPT_SAFE_DROP="TOPAZ_RPT_SAFE_DROP";
public final static String TOPAZ_RPT_TOTAL_SAFE_DROP="TOPAZ_RPT_TOTAL_SAFE_DROP";
public final static String TOPAZ_RPT_IN_HOUSE="TOPAZ_RPT_IN_HOUSE";
public final static String TOPAZ_RPT_TOTAL_PAYMENT_OUT="TOPAZ_RPT_TOTAL_PAYMENT_OUT";
public final static String TOPAZ_RPT_CASH_BACK_CANCEL="TOPAZ_RPT_CASH_BACK_CANCEL";
public final static String TOPAZ_RPT_TOTAL_CASHBACK_CANCEL="TOPAZ_RPT_TOTAL_CASHBACK_CANCEL";
public final static String TOPAZ_RPT_PAY_IN="TOPAZ_RPT_PAY_IN";
public final static String TOPAZ_RPT_SAFE_LOAN="TOPAZ_RPT_SAFE_LOAN";
public final static String TOPAZ_RPT_TOTAL_PAYMENT_IN="TOPAZ_RPT_TOTAL_PAYMENT_IN";
public final static String TOPAZ_RPT_MEMO_ITEMS_DASH="TOPAZ_RPT_MEMO_ITEMS_DASH";
public final static String TOPAZ_RPT_NO_ITEMS="TOPAZ_RPT_NO_ITEMS";
public final static String TOPAZ_RPT_NO_CUSTOMERS="TOPAZ_RPT_NO_CUSTOMERS";
public final static String TOPAZ_RPT_NO_NO_SALES="TOPAZ_RPT_NO_NO_SALES";
public final static String TOPAZ_RPT_DISCOUNTS="TOPAZ_RPT_DISCOUNTS";
public final static String TOPAZ_RPT_ERR_CORRECTS="TOPAZ_RPT_ERR_CORRECTS";
public final static String TOPAZ_RPT_VOID_LINES="TOPAZ_RPT_VOID_LINES";
public final static String TOPAZ_RPT_FUEL_CONVERTS="TOPAZ_RPT_FUEL_CONVERTS";
public final static String TOPAZ_RPT_VOID_TICKETS="TOPAZ_RPT_VOID_TICKETS";
public final static String TOPAZ_RPT_POSITIVE="TOPAZ_RPT_POSITIVE";
public final static String TOPAZ_RPT_NEGATIVE="TOPAZ_RPT_NEGATIVE";
public final static String TOPAZ_RPT_EZR_TICKET="TOPAZ_RPT_EZR_TICKET";
public final static String TOPAZ_RPT_EZR_INSIDE="TOPAZ_RPT_EZR_INSIDE";
public final static String TOPAZ_RPT_EZR_OUTSIDE="TOPAZ_RPT_EZR_OUTSIDE";
public final static String TOPAZ_RPT_SCANNED_COUPONS="TOPAZ_RPT_SCANNED_COUPONS";
public final static String TOPAZ_RPT_TICKET_LEVEL="TOPAZ_RPT_TICKET_LEVEL";
public final static String TOPAZ_RPT_SUSPENDED="TOPAZ_RPT_SUSPENDED";
public final static String TOPAZ_RPT_SUSPEND_VOID="TOPAZ_RPT_SUSPEND_VOID";
public final static String TOPAZ_RPT_UNSETTLED_SUSPENDS="TOPAZ_RPT_UNSETTLED_SUSPENDS";
public final static String TOPAZ_RPT_COIN_DISPENSER="TOPAZ_RPT_COIN_DISPENSER";
public final static String TOPAZ_RPT_VENDOR_PAYMENTS="TOPAZ_RPT_VENDOR_PAYMENTS";
public final static String TOPAZ_RPT_PREPAID_ACTIVATIONS="TOPAZ_RPT_PREPAID_ACTIVATIONS";
public final static String TOPAZ_RPT_PREPAID_RECHARGES="TOPAZ_RPT_PREPAID_RECHARGES";
public final static String TOPAZ_RPT_PUMP_OVERRUNS="TOPAZ_RPT_PUMP_OVERRUNS";
public final static String TOPAZ_RPT_CUST="TOPAZ_RPT_CUST";
public final static String TOPAZ_RPT_AMT="TOPAZ_RPT_AMT";
public final static String TOPAZ_RPT_VOL="TOPAZ_RPT_VOL";
public final static String TOPAZ_RPT_MANUAL_SETTLED="TOPAZ_RPT_MANUAL_SETTLED";
public final static String TOPAZ_RPT_POP_DISCOUNT_TOTALS_DASH="TOPAZ_RPT_POP_DISCOUNT_TOTALS_DASH";
public final static String TOPAZ_RPT_VOLUME="TOPAZ_RPT_VOLUME";
public final static String TOPAZ_RPT_DISC_AMT="TOPAZ_RPT_DISC_AMT";
public final static String TOPAZ_RPT_TOT_POST_DISP="TOPAZ_RPT_TOT_POST_DISP";
public final static String TOPAZ_RPT_TOT_PRE_DISP="TOPAZ_RPT_TOT_PRE_DISP";
public final static String TOPAZ_RPT_TOTAL_POP="TOPAZ_RPT_TOTAL_POP";
public final static String TOPAZ_RPT_TOTAL_COUPONS_EARNED="TOPAZ_RPT_TOTAL_COUPONS_EARNED";
public final static String TOPAZ_RPT_TOTAL_CODES_EARNED="TOPAZ_RPT_TOTAL_CODES_EARNED";
public final static String TOPAZ_RPT_TOTAL_CODES_REDEEMED="TOPAZ_RPT_TOTAL_CODES_REDEEMED";
public final static String TOPAZ_RPT_TOTAL_FREE_CODES="TOPAZ_RPT_TOTAL_FREE_CODES";
public final static String TOPAZ_RPT_TOTAL_FREE_COUPONS="TOPAZ_RPT_TOTAL_FREE_COUPONS";
public final static String TOPAZ_RPT_TRANSACTION_TIMINGS_DASH="TOPAZ_RPT_TRANSACTION_TIMINGS_DASH";
public final static String TOPAZ_RPT_in_seconds="TOPAZ_RPT_in_seconds";
public final static String TOPAZ_RPT_MAX_AVG="TOPAZ_RPT_MAX_AVG";
public final static String TOPAZ_RPT_MAX_AVG2="TOPAZ_RPT_MAX_AVG2";
public final static String TOPAZ_RPT_NETWORK_SUSPENDED="TOPAZ_RPT_NETWORK_SUSPENDED";
public final static String TOPAZ_RPT_END_OF_TICKET="TOPAZ_RPT_END_OF_TICKET";
public final static String TOPAZ_RPT_TOTALS_DASH="TOPAZ_RPT_TOTALS_DASH";
public final static String TOPAZ_RPT_CASH_BACK_FEE="TOPAZ_RPT_CASH_BACK_FEE";
public final static String TOPAZ_RPT_CANCEL_REFUND="TOPAZ_RPT_CANCEL_REFUND";
public final static String TOPAZ_RPT_DEBIT_FEE="TOPAZ_RPT_DEBIT_FEE";
public final static String TOPAZ_RPT_TOTAL_FUEL_SALES="TOPAZ_RPT_TOTAL_FUEL_SALES";
public final static String TOPAZ_RPT_TOTAL_MERCH_SALES="TOPAZ_RPT_TOTAL_MERCH_SALES";
public final static String TOPAZ_RPT_REFUND_TAXES="TOPAZ_RPT_REFUND_TAXES";
public final static String TOPAZ_RPT_SALES_TAXES="TOPAZ_RPT_SALES_TAXES";
public final static String TOPAZ_RPT_TOTAL_TAXES="TOPAZ_RPT_TOTAL_TAXES";
public final static String TOPAZ_RPT_TOTAL_INCLUDED_TAXES="TOPAZ_RPT_TOTAL_INCLUDED_TAXES";
public final static String TOPAZ_RPT_SALES_TOTALIZER="TOPAZ_RPT_SALES_TOTALIZER";
public final static String TOPAZ_RPT_GRAND_TOTALIZER="TOPAZ_RPT_GRAND_TOTALIZER";
public final static String TOPAZ_RPT_ENDING="TOPAZ_RPT_ENDING";
public final static String TOPAZ_RPT_BEGINNING="TOPAZ_RPT_BEGINNING";
public final static String TOPAZ_RPT_DIFFERENCE="TOPAZ_RPT_DIFFERENCE";
public final static String TOPAZ_RPT_CURRENT_CASHIER="TOPAZ_RPT_CURRENT_CASHIER";
public final static String TOPAZ_RPT_CASHIER_REPORT_NO="TOPAZ_RPT_CASHIER_REPORT_NO";
public final static String TOPAZ_RPT_ATTENDANT_REPORT_NO="TOPAZ_RPT_ATTENDANT_REPORT_NO";
public final static String TOPAZ_RPT_REG_NO="TOPAZ_RPT_REG_NO";
public final static String TOPAZ_RPT_REG_NO_NO="TOPAZ_RPT_REG_NO_NO";
public final static String TOPAZ_RPT_CASHIER_NO="TOPAZ_RPT_CASHIER_NO";
public final static String TOPAZ_RPT_RCPTS="TOPAZ_RPT_RCPTS";
public final static String TOPAZ_RPT_TOT="TOPAZ_RPT_TOT";
public final static String TOPAZ_RPT_ACT="TOPAZ_RPT_ACT";
public final static String TOPAZ_RPT_OPEN_CASHIER="TOPAZ_RPT_OPEN_CASHIER";
public final static String TOPAZ_RPT_OPEN_ATTENDANT="TOPAZ_RPT_OPEN_ATTENDANT";
public final static String TOPAZ_RPT_CLOSE_CASHIER="TOPAZ_RPT_CLOSE_CASHIER";
public final static String TOPAZ_RPT_CLOSE_ATTENDANT="TOPAZ_RPT_CLOSE_ATTENDANT";
public final static String TOPAZ_RPT_BEGINNING_CASH="TOPAZ_RPT_BEGINNING_CASH";
public final static String TOPAZ_RPT_BEGINNING_FOOD_STAMPS="TOPAZ_RPT_BEGINNING_FOOD_STAMPS";
public final static String TOPAZ_RPT_SUSPEND_SETTLE="TOPAZ_RPT_SUSPEND_SETTLE";
public final static String TOPAZ_RPT_UNSETTLED_SUSPEND="TOPAZ_RPT_UNSETTLED_SUSPEND";
public final static String TOPAZ_RPT_PUMP_OVERRUNS_CUST_AMT_VOL="TOPAZ_RPT_PUMP_OVERRUNS_CUST_AMT_VOL";
public final static String TOPAZ_RPT_GALLONS="TOPAZ_RPT_GALLONS";
public final static String TOPAZ_RPT_AUTO_SETTLED="TOPAZ_RPT_AUTO_SETTLED";
public final static String TOPAZ_RPT_NO_SAFE_DROP_CANCELS="TOPAZ_RPT_NO_SAFE_DROP_CANCELS";
public final static String TOPAZ_RPT_NO_DRAWER_VIOLATIONS="TOPAZ_RPT_NO_DRAWER_VIOLATIONS";
public final static String TOPAZ_RPT_CANCELREFUND="TOPAZ_RPT_CANCELREFUND";
public final static String TOPAZ_RPT_TOTAL_FUEL_DISCOUNT="TOPAZ_RPT_TOTAL_FUEL_DISCOUNT";
public final static String TOPAZ_RPT_TOTAL="TOPAZ_RPT_TOTAL";
public final static String TOPAZ_RPT_NETWORK="TOPAZ_RPT_NETWORK";
public final static String TOPAZ_RPT_CURRENT_AMOUNTS_DASH="TOPAZ_RPT_CURRENT_AMOUNTS_DASH";
public final static String TOPAZ_RPT_AMOUNTS_AT_CLOSE_DASH="TOPAZ_RPT_AMOUNTS_AT_CLOSE_DASH";
public final static String TOPAZ_RPT_ECR_ACTUAL_OVER_SHORT="TOPAZ_RPT_ECR_ACTUAL_OVER_SHORT";
public final static String TOPAZ_RPT_MISC_MOP="TOPAZ_RPT_MISC_MOP";
public final static String TOPAZ_RPT_GROSS="TOPAZ_RPT_GROSS";
public final static String TOPAZ_RPT_FOREIGN_CURRENCY_AT_CLOSE="TOPAZ_RPT_FOREIGN_CURRENCY_AT_CLOSE";
public final static String TOPAZ_RPT_CURRENCY_CONVERSION="TOPAZ_RPT_CURRENCY_CONVERSION";
public final static String TOPAZ_RPT_AMOUNT_RATE_VALUE="TOPAZ_RPT_AMOUNT_RATE_VALUE";
public final static String TOPAZ_RPT_CASH_PASSED_DASH="TOPAZ_RPT_CASH_PASSED_DASH";
public final static String TOPAZ_RPT_TO_X_DASH="TOPAZ_RPT_TO_X_DASH";
public final static String TOPAZ_RPT_CASHIER_SIGNATURE="TOPAZ_RPT_CASHIER_SIGNATURE";

public final static String TOPAZ_RPT_STORE_NO="TOPAZ_RPT_STORE_NO";
public final static String TOPAZ_RPT_REGISTER_NO="TOPAZ_RPT_REGISTER_NO";
public final static String TOPAZ_RPT_REGISTER_SPACE_NO="TOPAZ_RPT_REGISTER_SPACE_NO";
public final static String TOPAZ_RPT_Includes="TOPAZ_RPT_Includes";
public final static String TOPAZ_RPT_thru_NO="TOPAZ_RPT_thru_NO";
public final static String TOPAZ_RPT_Receipt_NO="TOPAZ_RPT_Receipt_NO";
public final static String TOPAZ_RPT_to_NO="TOPAZ_RPT_to_NO";
public final static String TOPAZ_RPT_ALL_DCRS="TOPAZ_RPT_ALL_DCRS";
public final static String TOPAZ_RPT_PENDING="TOPAZ_RPT_PENDING";
public final static String TOPAZ_RPT_OPEN="TOPAZ_RPT_OPEN";
public final static String TOPAZ_RPT_CLOSE="TOPAZ_RPT_CLOSE";
public final static String ALL_ATTENDANT_INDOOR_RPT="ALL_ATTENDANT_INDOOR_RPT";
public final static String ALL_ATTENDANT_OUTDOOR_RPT="ALL_ATTENDANT_OUTDOOR_RPT";
public final static String TOPAZ_RPT_CW="TOPAZ_RPT_CW";
public final static String TOPAZ_RPT_No_Data_Available="TOPAZ_RPT_No_Data_Available";
public final static String TOPAZ_RPT_PAY_POINT="TOPAZ_RPT_PAY_POINT";
public final static String TOPAZ_RPT_LAST_EVENT_DATE="TOPAZ_RPT_LAST_EVENT_DATE";
public final static String TOPAZ_RPT_IN_START="TOPAZ_RPT_IN_START";
public final static String TOPAZ_RPT_BILLS="TOPAZ_RPT_BILLS";
public final static String TOPAZ_RPT_COINS="TOPAZ_RPT_COINS";
public final static String TOPAZ_RPT_COUPONS="TOPAZ_RPT_COUPONS";
public final static String TOPAZ_RPT_TOKENS="TOPAZ_RPT_TOKENS";
public final static String TOPAZ_RPT_OUT_START="TOPAZ_RPT_OUT_START";

public final static String TOPAZ_RPT_PURE_PRODUCT=                                           "TOPAZ_RPT_PURE_PRODUCT";
public final static String TOPAZ_RPT_PERC_SALES=                                             "TOPAZ_RPT_PERC_SALES";
public final static String TOPAZ_RPT_PERC_SPACE_SALES=                                      "TOPAZ_RPT_PERC_SPACE_SALES";
public final static String TOPAZ_RPT_BLEND_PRODUCT=                                          "TOPAZ_RPT_BLEND_PRODUCT";
public final static String TOPAZ_RPT_NON_TAX_SALES=                                          "TOPAZ_RPT_NON_TAX_SALES";
public final static String TOPAZ_RPT_TAXABLE_SALES_TAXES=                                    "TOPAZ_RPT_TAXABLE_SALES_TAXES";
public final static String TOPAZ_RPT_SERIAL_NO_PAYEE=                                        "TOPAZ_RPT_SERIAL_NO_PAYEE";
public final static String TOPAZ_RPT_TOTAL_MO_SALES=                                         "TOPAZ_RPT_TOTAL_MO_SALES";
public final static String TOPAZ_RPT_TOTAL_VEND_P_O=                                         "TOPAZ_RPT_TOTAL_VEND_P_O";
public final static String TOPAZ_RPT_NO_CUST_NO_COMBOS_TOTAL_SALES=                          "TOPAZ_RPT_NO_CUST_NO_COMBOS_TOTAL_SALES";
public final static String TOPAZ_RPT_NO_CUST_NO_MATCHES_TOTAL_SALES=                         "TOPAZ_RPT_NO_CUST_NO_MATCHES_TOTAL_SALES";
public final static String TOPAZ_RPT_MO_OFFLINE=                                             "TOPAZ_RPT_MO_OFFLINE";
public final static String TOPAZ_RPT_MO_PRINTED=                                             "TOPAZ_RPT_MO_PRINTED";
public final static String TOPAZ_RPT_OFFLINE=                                                "TOPAZ_RPT_OFFLINE";
public final static String TOPAZ_RPT_TOTAL_OFFLINE=                                          "TOPAZ_RPT_TOTAL_OFFLINE";
public final static String TOPAZ_RPT_TOTAL_PRINTED=                                          "TOPAZ_RPT_TOTAL_PRINTED";
public final static String TOPAZ_RPT_TOTALS_NOT_SUPPORTED=                                   "TOPAZ_RPT_TOTALS_NOT_SUPPORTED";
public final static String TOPAZ_RPT_UNINITIALIZED_TOTALS=                                   "TOPAZ_RPT_UNINITIALIZED_TOTALS";
public final static String TOPAZ_RPT_VEND_P_O_OFFLINE=                                       "TOPAZ_RPT_VEND_P_O_OFFLINE";
public final static String TOPAZ_RPT_VEND_P_O_PRINTED=                                       "TOPAZ_RPT_VEND_P_O_PRINTED";
public final static String TOPAZ_RPT_Discount_Totals=                                        "TOPAZ_RPT_Discount_Totals";
public final static String TOPAZ_RPT_NO_OF_SALES=                                            "TOPAZ_RPT_NO_OF_SALES";
public final static String TOPAZ_RPT_PERC_LOYALTY_CUSTOMERS=                                 "TOPAZ_RPT_PERC_LOYALTY_CUSTOMERS";
public final static String TOPAZ_RPT_PERC_OF_TOTAL_SALES=                                    "TOPAZ_RPT_PERC_OF_TOTAL_SALES";
public final static String TOPAZ_RPT_PERC_SALES_ON_LOYALTY=                                  "TOPAZ_RPT_PERC_SALES_ON_LOYALTY";
public final static String TOPAZ_RPT_PERC_SALES_W_OUT_LOYALTY=                               "TOPAZ_RPT_PERC_SALES_W_OUT_LOYALTY";
public final static String TOPAZ_RPT_PERC_OF_SALES=                                          "TOPAZ_RPT_PERC_OF_SALES";
public final static String TOPAZ_RPT_PERC_TANK1=                                             "TOPAZ_RPT_PERC_TANK1";
public final static String TOPAZ_RPT_PERC_TANK2=                                             "TOPAZ_RPT_PERC_TANK2";
public final static String TOPAZ_RPT_ACCEPTED=                                               "TOPAZ_RPT_ACCEPTED";
public final static String TOPAZ_RPT_ACCEPTOR=                                               "TOPAZ_RPT_ACCEPTOR";
public final static String TOPAZ_RPT_ALL_FUELING_POINTS=                                     "TOPAZ_RPT_ALL_FUELING_POINTS";
public final static String TOPAZ_RPT_ALL_REGISTERS=                                          "TOPAZ_RPT_ALL_REGISTERS";
public final static String TOPAZ_RPT_AMOUNT=                                                 "TOPAZ_RPT_AMOUNT";
public final static String TOPAZ_RPT_AUTOCOLLECT=                                            "TOPAZ_RPT_AUTOCOLLECT";
public final static String TOPAZ_RPT_AUTOCOLLECT_REPORT=                                     "TOPAZ_RPT_AUTOCOLLECT_REPORT";
public final static String TOPAZ_RPT_Amount_Percentage=                                      "TOPAZ_RPT_Amount_Percentage";
public final static String TOPAZ_RPT_BLEND_PRODUCT_REPORT=                                   "TOPAZ_RPT_BLEND_PRODUCT_REPORT";
public final static String TOPAZ_RPT_CASH=                                                   "TOPAZ_RPT_CASH";
public final static String TOPAZ_RPT_CAT_NO=                                                 "TOPAZ_RPT_CAT_NO";
public final static String TOPAZ_RPT_COMBO_DEALS=                                            "TOPAZ_RPT_COMBO_DEALS";
public final static String TOPAZ_RPT_COUNT=                                                  "TOPAZ_RPT_COUNT";
public final static String TOPAZ_RPT_DATE_TIME_REG_NO_EMP_NO_AMOUNT=                         "TOPAZ_RPT_DATE_TIME_REG_NO_EMP_NO_AMOUNT";
public final static String TOPAZ_RPT_DCR_MERCHANDISE=                                        "TOPAZ_RPT_DCR_MERCHANDISE";
public final static String TOPAZ_RPT_DEAL_REPORT=                                            "TOPAZ_RPT_DEAL_REPORT";
public final static String TOPAZ_RPT_DEPT_NO=                                                "TOPAZ_RPT_DEPT_NO";
public final static String TOPAZ_RPT_DESCRIPTION=                                            "TOPAZ_RPT_DESCRIPTION";
public final static String TOPAZ_RPT_DOLLARS=                                                "TOPAZ_RPT_DOLLARS";
public final static String TOPAZ_RPT_Description=                                            "TOPAZ_RPT_Description";
public final static String TOPAZ_RPT_ECR_MO_TOTALS_COUNT_AMOUNT=                             "TOPAZ_RPT_ECR_MO_TOTALS_COUNT_AMOUNT";
public final static String TOPAZ_RPT_EPS_Network_Report=                                     "TOPAZ_RPT_EPS_Network_Report";
public final static String TOPAZ_RPT_Error_while_getting_report_data_from=                   "TOPAZ_RPT_Error_while_getting_report_data_from";
public final static String TOPAZ_RPT_FP_DISPENSER_REPORT=                                    "TOPAZ_RPT_FP_DISPENSER_REPORT";
public final static String TOPAZ_RPT_FP_HOSE_REPORT=                                         "TOPAZ_RPT_FP_HOSE_REPORT";
public final static String TOPAZ_RPT_FP_HOSE_RUNNING_RPT=                                    "TOPAZ_RPT_FP_HOSE_RUNNING_RPT";
public final static String TOPAZ_RPT_FUEL_ONLY=                                              "TOPAZ_RPT_FUEL_ONLY";
public final static String TOPAZ_RPT_FUELING_POINT=                                          "TOPAZ_RPT_FUELING_POINT";
public final static String TOPAZ_RPT_FUELING_POINT_NO=                                       "TOPAZ_RPT_FUELING_POINT_NO";
public final static String TOPAZ_RPT_HOUR_ITEMS_CUST_NET_SALES=                              "TOPAZ_RPT_HOUR_ITEMS_CUST_NET_SALES";
public final static String TOPAZ_RPT_HOURLY_REPORT=                                          "TOPAZ_RPT_HOURLY_REPORT";
public final static String TOPAZ_RPT_ITEMS=                                                  "TOPAZ_RPT_ITEMS";
public final static String TOPAZ_RPT_LOYALTY_REPORT=                                         "TOPAZ_RPT_LOYALTY_REPORT";
public final static String TOPAZ_RPT_LOYALTY_TRANSACTIONS_INSIDE=                            "TOPAZ_RPT_LOYALTY_TRANSACTIONS_INSIDE";
public final static String TOPAZ_RPT_LOYALTY_TRANSACTIONS_OUTSIDE=                           "TOPAZ_RPT_LOYALTY_TRANSACTIONS_OUTSIDE";
public final static String TOPAZ_RPT_MER_ONLY=                                               "TOPAZ_RPT_MER_ONLY";
public final static String TOPAZ_RPT_MER_FUEL=                                               "TOPAZ_RPT_MER_FUEL";
public final static String TOPAZ_RPT_MIX_N_MATCH_DEALS=                                      "TOPAZ_RPT_MIX_N_MATCH_DEALS";
public final static String TOPAZ_RPT_MONEY_ORDER_DETAILS=                                    "TOPAZ_RPT_MONEY_ORDER_DETAILS";
public final static String TOPAZ_RPT_NAME_TAX_RATE_ACT_RATE=                                 "TOPAZ_RPT_NAME_TAX_RATE_ACT_RATE";
public final static String TOPAZ_RPT_NEG_DEPTS=                                              "TOPAZ_RPT_NEG_DEPTS";
public final static String TOPAZ_RPT_NET_SALES=                                              "TOPAZ_RPT_NET_SALES";
public final static String TOPAZ_RPT_NO_DATA_AVAILABLE=                                      "TOPAZ_RPT_NO_DATA_AVAILABLE";
public final static String TOPAZ_RPT_OTHER_DEPTS=                                            "TOPAZ_RPT_OTHER_DEPTS";
public final static String TOPAZ_RPT_PLU_NUMBER=                                             "TOPAZ_RPT_PLU_NUMBER";
public final static String TOPAZ_RPT_PLU_PROMO_REPORT=                                       "TOPAZ_RPT_PLU_PROMO_REPORT";
public final static String TOPAZ_RPT_PRICE=                                                  "TOPAZ_RPT_PRICE";
public final static String TOPAZ_RPT_PROD=                                                   "TOPAZ_RPT_PROD";
public final static String TOPAZ_RPT_PRODUCT_TOTALS=                                         "TOPAZ_RPT_PRODUCT_TOTALS";
public final static String TOPAZ_RPT_PROMOTION_ID=                                           "TOPAZ_RPT_PROMOTION_ID";
public final static String TOPAZ_RPT_RC=                                                     "TOPAZ_RPT_RC";
public final static String TOPAZ_RPT_REFUNDS=                                                "TOPAZ_RPT_REFUNDS";
public final static String TOPAZ_RPT_SALES_Before_Ticket_Disc=                               "TOPAZ_RPT_SALES_Before_Ticket_Disc";
public final static String TOPAZ_RPT_SOLD=                                                   "TOPAZ_RPT_SOLD";
public final static String TOPAZ_RPT_STATION_TOTALS=                                         "TOPAZ_RPT_STATION_TOTALS";
public final static String TOPAZ_RPT_TANK=                                                   "TOPAZ_RPT_TANK";
public final static String TOPAZ_RPT_TANK1=                                                  "TOPAZ_RPT_TANK1";
public final static String TOPAZ_RPT_TANK2=                                                  "TOPAZ_RPT_TANK2";
public final static String TOPAZ_RPT_TAX_REPORT=                                             "TOPAZ_RPT_TAX_REPORT";
public final static String TOPAZ_RPT_TOT_SALES=                                              "TOPAZ_RPT_TOT_SALES";
public final static String TOPAZ_RPT_TOTAL_CUSTOMERS=                                        "TOPAZ_RPT_TOTAL_CUSTOMERS";
public final static String TOPAZ_RPT_TOTAL_DISCOUNT=                                         "TOPAZ_RPT_TOTAL_DISCOUNT";
public final static String TOPAZ_RPT_TOTAL_ITEMS_SOLD=                                       "TOPAZ_RPT_TOTAL_ITEMS_SOLD";
public final static String TOPAZ_RPT_TOTAL_LINE_ITEM_DISCOUNT=                               "TOPAZ_RPT_TOTAL_LINE_ITEM_DISCOUNT";
public final static String TOPAZ_RPT_TOTAL_LOYALTY_CUSTOMERS=                                "TOPAZ_RPT_TOTAL_LOYALTY_CUSTOMERS";
public final static String TOPAZ_RPT_TOTAL_LOYALTY_DISCOUNT=                                 "TOPAZ_RPT_TOTAL_LOYALTY_DISCOUNT";
public final static String TOPAZ_RPT_TOTAL_PPG_DISCOUNT=                                     "TOPAZ_RPT_TOTAL_PPG_DISCOUNT";
public final static String TOPAZ_RPT_TOTAL_SALES_TAX=                                        "TOPAZ_RPT_TOTAL_SALES_TAX";
public final static String TOPAZ_RPT_TOTAL_SALES=                                            "TOPAZ_RPT_TOTAL_SALES";
public final static String TOPAZ_RPT_TOTAL_TICKET_DISCOUNT=                                  "TOPAZ_RPT_TOTAL_TICKET_DISCOUNT";
public final static String TOPAZ_RPT_Total=                                                  "TOPAZ_RPT_Total";
public final static String TOPAZ_RPT_Found_0_records_to_print=                               "TOPAZ_RPT_Found_0_records_to_print";
    
public static final String TOPAZ_RPT_GRADE_NO_DISC_VOLUME_DISC_AMT=                       "TOPAZ_RPT_GRADE_NO_DISC_VOLUME_DISC_AMT";
public static final String TOPAZ_RPT_SPACES_TOTAL=                                        "TOPAZ_RPT_SPACES_TOTAL";
public static final String TOPAZ_RPT_SPACES_TOTALS=                                       "TOPAZ_RPT_SPACES_TOTALS";
public static final String TOPAZ_RPT_and_post_dispensed_amounts=                          "TOPAZ_RPT_and_post_dispensed_amounts";
public static final String TOPAZ_RPT_discount_applied_at_Ruby_when=                       "TOPAZ_RPT_discount_applied_at_Ruby_when";
public static final String TOPAZ_RPT_discount_price_amount_reported=                      "TOPAZ_RPT_discount_price_amount_reported";
public static final String TOPAZ_RPT_discounted_portion_of_the_fuel_sales=                "TOPAZ_RPT_discounted_portion_of_the_fuel_sales";
public static final String TOPAZ_RPT_includes_both_pre_dispensed=                         "TOPAZ_RPT_includes_both_pre_dispensed";
public static final String TOPAZ_RPT_payment_is_tendered=                                 "TOPAZ_RPT_payment_is_tendered";
public static final String TOPAZ_RPT_reflects_discount_from_street_price=                 "TOPAZ_RPT_reflects_discount_from_street_price";
public static final String TOPAZ_RPT_where_POP_was_applied_Each_entry=                    "TOPAZ_RPT_where_POP_was_applied_Each_entry";
public static final String TOPAZ_RPT_SPACES_AMOUNT=                                       "TOPAZ_RPT_SPACES_AMOUNT";
public static final String TOPAZ_RPT_CSH_NO_QTY_ORG_PRICE_OVER_PRICE=                     "TOPAZ_RPT_CSH_NO_QTY_ORG_PRICE_OVER_PRICE";
public static final String TOPAZ_RPT_Cash=                                                "TOPAZ_RPT_Cash";
public static final String TOPAZ_RPT_Check=                                               "TOPAZ_RPT_Check";
public static final String TOPAZ_RPT_Other=                                               "TOPAZ_RPT_Other";
public static final String TOPAZ_RPT_IN=                                                  "TOPAZ_RPT_IN";
public static final String TOPAZ_RPT_OUT=                                                 "TOPAZ_RPT_OUT";
public static final String TOPAZ_RPT_ASSOCIATED_PROGRAM_NAMES=                            "TOPAZ_RPT_ASSOCIATED_PROGRAM_NAMES";
public static final String TOPAZ_RPT_SPACES_CASH=                                         "TOPAZ_RPT_SPACES_CASH";
public static final String TOPAZ_RPT_DEF=                                                 "TOPAZ_RPT_DEF";
public static final String TOPAZ_RPT_DISCOUNT_DEFINITION=                                 "TOPAZ_RPT_DISCOUNT_DEFINITION";
public static final String TOPAZ_RPT_END=                                                 "TOPAZ_RPT_END";
public static final String TOPAZ_RPT_ENVELOPE_ITEMS=                                      "TOPAZ_RPT_ENVELOPE_ITEMS";
public static final String TOPAZ_RPT_ENVELOPE_VALUE=                                      "TOPAZ_RPT_ENVELOPE_VALUE";
public static final String TOPAZ_RPT_FROM=                                                "TOPAZ_RPT_FROM";
public static final String TOPAZ_RPT_RECOGNIZED_BILLS=                                    "TOPAZ_RPT_RECOGNIZED_BILLS";
public static final String TOPAZ_RPT_SEAL_NUMBER=                                         "TOPAZ_RPT_SEAL_NUMBER";
public static final String TOPAZ_RPT_START=                                               "TOPAZ_RPT_START";
public static final String TOPAZ_RPT_TOTAL_CASSETTE_CASH=                                 "TOPAZ_RPT_TOTAL_CASSETTE_CASH";
public static final String TOPAZ_RPT_UNRECOGNIZED_BILLS=                                  "TOPAZ_RPT_UNRECOGNIZED_BILLS";
public static final String TOPAZ_RPT_Fuel_Dispensed=                                      "TOPAZ_RPT_Fuel_Dispensed";
public static final String TOPAZ_RPT_TOTAL_ALL_DISCOUNT_DEFINITIONS=                      "TOPAZ_RPT_TOTAL_ALL_DISCOUNT_DEFINITIONS";
public static final String TOPAZ_RPT_TOTAL_ALL_DISCOUNT_PROGRAMS=                         "TOPAZ_RPT_TOTAL_ALL_DISCOUNT_PROGRAMS";
public static final String TOPAZ_RPT_Tier=                                                "TOPAZ_RPT_Tier";
public static final String TOPAZ_RPT_PERC_DCR=                                            "TOPAZ_RPT_PERC_DCR";
public static final String TOPAZ_RPT_PERC_FP=                                             "TOPAZ_RPT_PERC_FP";
public static final String TOPAZ_RPT_PERC_FUEL=                                           "TOPAZ_RPT_PERC_FUEL";
public static final String TOPAZ_RPT_E_SAFE_ID=                                           "TOPAZ_RPT_E_SAFE_ID";
public static final String TOPAZ_RPT_POST_DISP_eq_fuel_dispensed_at=                      "TOPAZ_RPT_POST_DISP_eq_fuel_dispensed_at";
public static final String TOPAZ_RPT_PRE_DISP_eq_fuel_dispensed_at=                       "TOPAZ_RPT_PRE_DISP_eq_fuel_dispensed_at";
public static final String TOPAZ_RPT_RECONCILIATION_SUMMARY=                              "TOPAZ_RPT_RECONCILIATION_SUMMARY";
public static final String TOPAZ_RPT_WASH_DETAILS_PAYPOINT=                               "TOPAZ_RPT_WASH_DETAILS_PAYPOINT";
public static final String TOPAZ_RPT_This_report_represents_the=                          "TOPAZ_RPT_This_report_represents_the";
public static final String TOPAZ_RPT_Deliveries=                                          "TOPAZ_RPT_Deliveries";
public static final String TOPAZ_RPT_Dispensed=                                           "TOPAZ_RPT_Dispensed";
public static final String TOPAZ_RPT_Ending_Inventory=                                    "TOPAZ_RPT_Ending_Inventory";
public static final String TOPAZ_RPT_ACTIVATIONS=                                         "TOPAZ_RPT_ACTIVATIONS";
public static final String TOPAZ_RPT_AUDIT_NUM=                                           "TOPAZ_RPT_AUDIT_NUM";
public static final String TOPAZ_RPT_Acct_Type=                                           "TOPAZ_RPT_Acct_Type";
public static final String TOPAZ_RPT_Amount=                                              "TOPAZ_RPT_Amount";
public static final String TOPAZ_RPT_Approval_Code=                                       "TOPAZ_RPT_Approval_Code";
public static final String TOPAZ_RPT_BAG_SEAL_NUMBERS=                                    "TOPAZ_RPT_BAG_SEAL_NUMBERS";
public static final String TOPAZ_RPT_BATCH_DAY_SEQ_NO=                                    "TOPAZ_RPT_BATCH_DAY_SEQ_NO";
public static final String TOPAZ_RPT_BILL_ACCEPTOR_CONTENTS=                              "TOPAZ_RPT_BILL_ACCEPTOR_CONTENTS";
public static final String TOPAZ_RPT_BUS=                                                 "TOPAZ_RPT_BUS";
public static final String TOPAZ_RPT_BY=                                                  "TOPAZ_RPT_BY";
public static final String TOPAZ_RPT_Bill_Acceptor=                                       "TOPAZ_RPT_Bill_Acceptor";
public static final String TOPAZ_RPT_BillValue=                                           "TOPAZ_RPT_BillValue";
public static final String TOPAZ_RPT_CASSETTE_SEAL_NUMBERS=                               "TOPAZ_RPT_CASSETTE_SEAL_NUMBERS";
public static final String TOPAZ_RPT_CNT=                                                 "TOPAZ_RPT_CNT";
public static final String TOPAZ_RPT_COIN_CONTENTS=                                       "TOPAZ_RPT_COIN_CONTENTS";
public static final String TOPAZ_RPT_COLUMN_CONTENTS=                                     "TOPAZ_RPT_COLUMN_CONTENTS";
public static final String TOPAZ_RPT_CONSOLE=                                             "TOPAZ_RPT_CONSOLE";
public static final String TOPAZ_RPT_CONTENT_REPORT_NUMBER=                               "TOPAZ_RPT_CONTENT_REPORT_NUMBER";
public static final String TOPAZ_RPT_CONTENT_REPORT=                                      "TOPAZ_RPT_CONTENT_REPORT";
public static final String TOPAZ_RPT_CREDIT=                                              "TOPAZ_RPT_CREDIT";
public static final String TOPAZ_RPT_Cassette_NO=                                         "TOPAZ_RPT_Cassette_NO";
public static final String TOPAZ_RPT_CoinValue=                                           "TOPAZ_RPT_CoinValue";
public static final String TOPAZ_RPT_Col_NO=                                              "TOPAZ_RPT_Col_NO";
public static final String TOPAZ_RPT_Count=                                               "TOPAZ_RPT_Count";
public static final String TOPAZ_RPT_Courier_Tray=                                        "TOPAZ_RPT_Courier_Tray";
public static final String TOPAZ_RPT_Created=                                             "TOPAZ_RPT_Created";
public static final String TOPAZ_RPT_DATE_TIME_REF_NO_C_NO_R_NO_AMOUNT_MOP=               "TOPAZ_RPT_DATE_TIME_REF_NO_C_NO_R_NO_AMOUNT_MOP";
public static final String TOPAZ_RPT_DATE=                                                "TOPAZ_RPT_DATE";
public static final String TOPAZ_RPT_DCR_NO=                                              "TOPAZ_RPT_DCR_NO";
public static final String TOPAZ_RPT_DCR_STATISTICAL_RPT=                                 "TOPAZ_RPT_DCR_STATISTICAL_RPT";
public static final String TOPAZ_RPT_DISPENSER_CONTENTS=                                  "TOPAZ_RPT_DISPENSER_CONTENTS";
public static final String TOPAZ_RPT_Date=                                                "TOPAZ_RPT_Date";
public static final String TOPAZ_RPT_Del=                                                 "TOPAZ_RPT_Del";
public static final String TOPAZ_RPT_Denomination=                                        "TOPAZ_RPT_Denomination";
public static final String TOPAZ_RPT_Discrepancy=                                         "TOPAZ_RPT_Discrepancy";
public static final String TOPAZ_RPT_E_SAFE_PERIOD=                                       "TOPAZ_RPT_E_SAFE_PERIOD";
public static final String TOPAZ_RPT_ENV=                                                 "TOPAZ_RPT_ENV";
public static final String TOPAZ_RPT_ENVELOPE_DETAIL=                                     "TOPAZ_RPT_ENVELOPE_DETAIL";
public static final String TOPAZ_RPT_EVENT_DATE=                                          "TOPAZ_RPT_EVENT_DATE";
public static final String TOPAZ_RPT_FP_HOSE_TEST_REPORT=                                 "TOPAZ_RPT_FP_HOSE_TEST_REPORT";
public static final String TOPAZ_RPT_FUEL_PRICE_CHANGE=                                   "TOPAZ_RPT_FUEL_PRICE_CHANGE";
public static final String TOPAZ_RPT_Hopper_NO=                                           "TOPAZ_RPT_Hopper_NO";
public static final String TOPAZ_RPT_ID=                                                  "TOPAZ_RPT_ID";
public static final String TOPAZ_RPT_ITEM=                                                "TOPAZ_RPT_ITEM";
public static final String TOPAZ_RPT_Inventory=                                           "TOPAZ_RPT_Inventory";
public static final String TOPAZ_RPT_Loyalty_Discount=                                    "TOPAZ_RPT_Loyalty_Discount";
public static final String TOPAZ_RPT_Loyalty_Reward_ID=                                   "TOPAZ_RPT_Loyalty_Reward_ID";
public static final String TOPAZ_RPT_Loyalty_Terminal_Batch=                              "TOPAZ_RPT_Loyalty_Terminal_Batch";
public static final String TOPAZ_RPT_MOP_No_AMOUNT=                                       "TOPAZ_RPT_MOP_No_AMOUNT";
public static final String TOPAZ_RPT_MOP=                                                 "TOPAZ_RPT_MOP";
public static final String TOPAZ_RPT_Masked_Acct_NO=                                      "TOPAZ_RPT_Masked_Acct_NO";
public static final String TOPAZ_RPT_Merchant=                                            "TOPAZ_RPT_Merchant";
public static final String TOPAZ_RPT_Msg_Type=                                            "TOPAZ_RPT_Msg_Type";
public static final String TOPAZ_RPT_NAME=                                                "TOPAZ_RPT_NAME";
public static final String TOPAZ_RPT_NETWORK_PRODUCT_RPT=                                 "TOPAZ_RPT_NETWORK_PRODUCT_RPT";
public static final String TOPAZ_RPT_NUM=                                                 "TOPAZ_RPT_NUM";
public static final String TOPAZ_RPT_NUMB=                                                "TOPAZ_RPT_NUMB";
public static final String TOPAZ_RPT_New=                                                 "TOPAZ_RPT_New";
public static final String TOPAZ_RPT_NoteCount=                                           "TOPAZ_RPT_NoteCount";
public static final String TOPAZ_RPT_Number_of_Bill_Acceptors=                            "TOPAZ_RPT_Number_of_Bill_Acceptors";
public static final String TOPAZ_RPT_Number_of_Cassettes=                                 "TOPAZ_RPT_Number_of_Cassettes";
public static final String TOPAZ_RPT_Number_of_Columns=                                   "TOPAZ_RPT_Number_of_Columns";
public static final String TOPAZ_RPT_Number_of_Hoppers=                                   "TOPAZ_RPT_Number_of_Hoppers";
public static final String TOPAZ_RPT_Number_of_Rejected_Notes=                            "TOPAZ_RPT_Number_of_Rejected_Notes";
public static final String TOPAZ_RPT_OTHER=                                               "TOPAZ_RPT_OTHER";
public static final String TOPAZ_RPT_OVER_LIMIT_EVENTS_DETAIL=                            "TOPAZ_RPT_OVER_LIMIT_EVENTS_DETAIL";
public static final String TOPAZ_RPT_Overall_Result=                                      "TOPAZ_RPT_Overall_Result";
public static final String TOPAZ_RPT_PLU_EXCEPTION_REPORT=                                "TOPAZ_RPT_PLU_EXCEPTION_REPORT";
public static final String TOPAZ_RPT_PLU_NUMBER_EXCEPTION_STATE=                          "TOPAZ_RPT_PLU_NUMBER_EXCEPTION_STATE";
public static final String TOPAZ_RPT_POP_DISCOUNT_DEF_RPT=                                "TOPAZ_RPT_POP_DISCOUNT_DEF_RPT";
public static final String TOPAZ_RPT_POP_DISCOUNT_RPT=                                    "TOPAZ_RPT_POP_DISCOUNT_RPT";
public static final String TOPAZ_RPT_POP_DISCOUNT=                                        "TOPAZ_RPT_POP_DISCOUNT";
public static final String TOPAZ_RPT_POS=                                                 "TOPAZ_RPT_POS";
public static final String TOPAZ_RPT_PR_PRICE_LEVEL_RPT=                                  "TOPAZ_RPT_PR_PRICE_LEVEL_RPT";
public static final String TOPAZ_RPT_PROD_DESC_QTY_CNT_TOTAL=                             "TOPAZ_RPT_PROD_DESC_QTY_CNT_TOTAL";
public static final String TOPAZ_RPT_PROD_DISC_TYPE_VOLUME_DISC_AMT=                      "TOPAZ_RPT_PROD_DISC_TYPE_VOLUME_DISC_AMT";
public static final String TOPAZ_RPT_PROGRAM_NAME=                                        "TOPAZ_RPT_PROGRAM_NAME";
public static final String TOPAZ_RPT_PROGRAM_REPORT=                                      "TOPAZ_RPT_PROGRAM_REPORT";
public static final String TOPAZ_RPT_Period_End=                                          "TOPAZ_RPT_Period_End";
public static final String TOPAZ_RPT_Period_Start=                                        "TOPAZ_RPT_Period_Start";
public static final String TOPAZ_RPT_Prev=                                                "TOPAZ_RPT_Prev";
public static final String TOPAZ_RPT_Prod=                                                "TOPAZ_RPT_Prod";
public static final String TOPAZ_RPT_REJECTS_CONTENTS=                                    "TOPAZ_RPT_REJECTS_CONTENTS";
public static final String TOPAZ_RPT_Ref_NO=                                              "TOPAZ_RPT_Ref_NO";
public static final String TOPAZ_RPT_Report=                                              "TOPAZ_RPT_Report";
public static final String TOPAZ_RPT_Reserve_Change_Fund=                                 "TOPAZ_RPT_Reserve_Change_Fund";
public static final String TOPAZ_RPT_SAFE_DROP_DETAIL=                                    "TOPAZ_RPT_SAFE_DROP_DETAIL";
public static final String TOPAZ_RPT_SALES=                                               "TOPAZ_RPT_SALES";
public static final String TOPAZ_RPT_SL=                                                  "TOPAZ_RPT_SL";
public static final String TOPAZ_RPT_SL_PRICE_LEVEL_RPT=                                  "TOPAZ_RPT_SL_PRICE_LEVEL_RPT";
public static final String TOPAZ_RPT_SUMMARY=                                             "TOPAZ_RPT_SUMMARY";
public static final String TOPAZ_RPT_Starting_Inventory=                                  "TOPAZ_RPT_Starting_Inventory";
public static final String TOPAZ_RPT_TIER_NO=                                             "TOPAZ_RPT_TIER_NO";
public static final String TOPAZ_RPT_TOTAL_NUM_CASSETTES=                                 "TOPAZ_RPT_TOTAL_NUM_CASSETTES";
public static final String TOPAZ_RPT_TOTAL_NUM_ENVELOPES=                                 "TOPAZ_RPT_TOTAL_NUM_ENVELOPES";
public static final String TOPAZ_RPT_TOTAL_VALUE=                                         "TOPAZ_RPT_TOTAL_VALUE";
public static final String TOPAZ_RPT_TYPE=                                                "TOPAZ_RPT_TYPE";
public static final String TOPAZ_RPT_Tank=                                                "TOPAZ_RPT_Tank";
public static final String TOPAZ_RPT_Terminal_Batch=                                      "TOPAZ_RPT_Terminal_Batch";
public static final String TOPAZ_RPT_Terminal_STAN=                                       "TOPAZ_RPT_Terminal_STAN";
public static final String TOPAZ_RPT_Time=                                                "TOPAZ_RPT_Time";
public static final String TOPAZ_RPT_TotAmt=                                              "TOPAZ_RPT_TotAmt";
public static final String TOPAZ_RPT_Total_Amount_In_Hoppers=                             "TOPAZ_RPT_Total_Amount_In_Hoppers";
public static final String TOPAZ_RPT_Total_Amount_in_BillAcceptors=                       "TOPAZ_RPT_Total_Amount_in_BillAcceptors";
public static final String TOPAZ_RPT_Total_Amount_in_Cassettes=                           "TOPAZ_RPT_Total_Amount_in_Cassettes";
public static final String TOPAZ_RPT_Total_Amount_in_Columns=                             "TOPAZ_RPT_Total_Amount_in_Columns";
public static final String TOPAZ_RPT_Total_Amount_in_Overflow_bin=                        "TOPAZ_RPT_Total_Amount_in_Overflow_bin";
public static final String TOPAZ_RPT_Total_Loyalty_Discount=                              "TOPAZ_RPT_Total_Loyalty_Discount";
public static final String TOPAZ_RPT_TotalAmt=                                            "TOPAZ_RPT_TotalAmt";
public static final String TOPAZ_RPT_Transaction=                                         "TOPAZ_RPT_Transaction";
public static final String TOPAZ_RPT_TubeCnt=                                             "TOPAZ_RPT_TubeCnt";
public static final String TOPAZ_RPT_TubeVal=                                             "TOPAZ_RPT_TubeVal";
public static final String TOPAZ_RPT_Txn_Amt=                                             "TOPAZ_RPT_Txn_Amt";
public static final String TOPAZ_RPT_UNVERIFIED_CASH_RATIO=                               "TOPAZ_RPT_UNVERIFIED_CASH_RATIO";
public static final String TOPAZ_RPT_UPGRADES=                                            "TOPAZ_RPT_UPGRADES";
public static final String TOPAZ_RPT_Unpaid_Transactions=                                 "TOPAZ_RPT_Unpaid_Transactions";
public static final String TOPAZ_RPT_VAULT_CONTENTS=                                      "TOPAZ_RPT_VAULT_CONTENTS";
public static final String TOPAZ_RPT_Value_of_Rejected_Notes=                             "TOPAZ_RPT_Value_of_Rejected_Notes";
public static final String TOPAZ_RPT_Vault_Courier_Tray_Total=                            "TOPAZ_RPT_Vault_Courier_Tray_Total";
public static final String TOPAZ_RPT_Vault_Drop_Total=                                    "TOPAZ_RPT_Vault_Drop_Total";
public static final String TOPAZ_RPT_Vault_Drop=                                          "TOPAZ_RPT_Vault_Drop";
public static final String TOPAZ_RPT_Vault_ReserveChangeFund_Total=                       "TOPAZ_RPT_Vault_ReserveChangeFund_Total";
public static final String TOPAZ_RPT_Volume=                                              "TOPAZ_RPT_Volume";
public static final String TOPAZ_RPT_WASH_ID=                                             "TOPAZ_RPT_WASH_ID";
public static final String TOPAZ_RPT_WASH=                                                "TOPAZ_RPT_WASH";

public static final String TOPAZ_RPT_ALL_CAR_WASH_PAYPOINTS=                              "TOPAZ_RPT_ALL_CAR_WASH_PAYPOINTS";    
public static final String TOPAZ_RPT_NO_LOGIN_OVERRIDES=                                  "TOPAZ_RPT_NO_LOGIN_OVERRIDES";    

public final static String TOPAZ_RPT_DISPENSER_REPORT=                                    "TOPAZ_RPT_DISPENSER_REPORT";
public final static String TOPAZ_RPT_report_lowercase=                                    "TOPAZ_RPT_report_lowercase";
public final static String TOPAZ_RPT_Sapphire=                                            "TOPAZ_RPT_Sapphire";

public final static String THIRD_PARTY_PRODUCT_KEY=										  "THIRD_PARTY_PRODUCT_KEY";
public final static String ENTER_VOUCHER_ID=											  "ENTER_VOUCHER_ID";
public static final String UNKNOWN = "UNKNOWN";
public static final String NETWORK_ERROR_IGNORED = "NETWORK_ERROR_IGNORED";
public static final String PERIOD_CLOSE = "PERIOD_CLOSE";
public static final String PERIOD_CLOSE_WARNING = "PERIOD_CLOSE_WARNING";
public static final String AEOD_CLOSE_ALARM_SHORT = "AEOD_CLOSE_ALARM_SHORT";
public static final String AEOD_CLOSE_ALARM_DETAIL = "AEOD_CLOSE_ALARM_DETAIL";
public static final String CASHIER_PERIOD_CLOSED = "CASHIER_PERIOD_CLOSED";
public static final String PERIODCLOSE_LOGOUT = "PERIODCLOSE_LOGOUT";

public final static String ENTER_NAME=													  "ENTER_NAME";
public final static String ENTER_PHONE_NUMBER=											  "ENTER_PHONE_NUMBER";
public final static String MAX_CHAR_NAME=												  "MAX_CHAR_NAME";
public final static String MAX_CHAR_PHONE_NUMBER=										  "MAX_CHAR_PHONE_NUMBER";
public static final String LISTEN_TICKET_NAME = 									      "LISTEN_TICKET_NAME";
public static final String STICKY_LABEL ="STICKY_LABEL";
public static final String CUSTOMER_NAME_REQUIRED ="CUSTOMER_NAME_REQUIRED";

public static final String CUSTOMER_NAME = 												  "CUSTOMER_NAME";
public static final String CUSTOMER_NUMBER = 											  "CUSTOMER_NUMBER";
public static final String SEQUENCE_RANGE = 											  "SEQUENCE_RANGE";
public static final String VENTA_AFECTA = 												  "VENTA_AFECTA";

public static final String RETRIEVING_EPS_REPORT =                                       "RETRIEVING_EPS_REPORT";
public static final String USB_DETECT_ERROR_TITLE = "USB_DETECT_ERROR_TITLE";
public static final String USB_DETECT_ERROR_MSG = "USB_DETECT_ERROR_MSG";
public static final String REPORT_SAVE_ERROR_TITLE = "REPORT_SAVE_ERROR_TITLE";
public static final String REPORT_SAVE_USB_ERROR_MSG = "REPORT_SAVE_USB_ERROR_MSG";
public static final String REPORT_SAVE_ERROR_MSG = "REPORT_SAVE_ERROR_MSG";
public static final String REPORT_SAVE_TITLE = "REPORT_SAVE_TITLE";
public static final String REPORT_SAVE_TITLE_MSG = "REPORT_SAVE_TITLE_MSG";
public static final String FISCAL_CF = "FISCAL_CF";
public static final String FISCAL_CUSTOMER_TAX_UPDATE = "FISCAL_CUSTOMER_TAX_UPDATE";
public static final String FISCAL_FINAL_CONSUMER = "FISCAL_FINAL_CONSUMER";
public static final String FSC_PRNT_STR_COLON_TAXID = "FSC_PRNT_STR_COLON_TAXID";
public static final String FSC_FORMAT_FC_OPTIONS = "FSC_FORMAT_FC_OPTIONS";
/*JUUL cr*/
public static final String SWIPE_SCAN_LICENSE = "SWIPE_SCAN_LICENSE";
public static final String CONFIRM = "CONFIRM";
public static final String DECLINE = "DECLINE";
public static final String CONFIRM_PHOTO_ID = "CONFIRM_PHOTO_ID";
public static final String ID_NUMBER = "ID_NUMBER";
public static final String MAN_ID_NOT_ALLOWED = "MAN_ID_NOT_ALLOWED";
public static final String MANUAL_CANCEL_TO_EXIT = "MANUAL_CANCEL_TO_EXIT";
public static final String MANUAL_ENTRY_OVERRIDE = "MANUAL_ENTRY_OVERRIDE";
public static final String SKIP = "SKIP";
public static final String OK_SKIP = "OK_SKIP";
public static final String BYPASS_ID = "BYPASS_ID";
public static final String IS_MILITARY_ID = "IS_MILITARY_ID";

public static final String TAX_EXEMPT_CONFIG_ERROR = "TAX_EXEMPT_CONFIG_ERROR";
public static final String OPERATION_NOT_ALLOWED = "OPERATION_NOT_ALLOWED";

public static final String ERROR_CORRECT_KEY = "ERROR_CORRECT_KEY";
public static final String PRICE_OVERRIDE_KEY = "PRICE_OVERRIDE_KEY" ;
public static final String NO_SALE_KEY =  "NO_SALE_KEY";
public static final String VOID_TICKET_KEY =  "VOID_TICKET_KEY";
public static final String REFUND_KEY = "REFUND_KEY";
public static final String MANAGED_UPDATE_KEY = "MANAGED_UPDATE_KEY";
public static final String PAY_OUT_KEY = "PAY_OUT_KEY";
public static final String INVALID_SOFTKEYTYPE = "INVALID_SOFTKEYTYPE";
public static final String INVALID_SECURITY_LEVEL = "INVALID_SECURITY_LEVEL";
public static final String ERROR_LOADING_PERSIST_ADMIN="ERROR_LOADING_PERSIST_ADMIN";
public static final String CARD_ALREADY_IN_USE="CARD_ALREADY_IN_USE";
public static final String CARD_IS_NOT_ACTIVATED="CARD_IS_NOT_ACTIVATED";
public static final String ATTENDANT_SESSION_OPEN_ERROR="ATTENDANT_SESSION_OPEN_ERROR";
public static final String ATTENDANT_SESSION_RETRIEVE_ERROR="ATTENDANT_SESSION_RETRIEVE_ERROR";
public static final String REGISTER_LOGGED_OUT_FOR_ATTENDANT = "REGISTER_LOGGED_OUT_FOR_ATTENDANT";
public static final String ERROR_INITIATING_TRANSACTION = "ERROR_INITIATING_TRANSACTION";

public static final String EMP_PREFS_TITLE = "EMP_PREFS_TITLE"; // Employee Preferences OverlayMsg title.
public static final String EMP_PREFS_OUT_OF_SYNC_WITH_SERVER = "EMP_PREFS_OUT_OF_SYNC_WITH_SERVER"; // Emp Prefs out of sync with server text line 1.
public static final String EMP_PREFS_CONFIG_NOT_SAVED = "EMP_PREFS_CONFIG_NOT_SAVED"; // Emp Prefs not save at commnder.

public static final String DEVICE_CONTROL_HELP_TEXT = "DEVICE_CONTROL_HELP_TEXT";

public static final String SCREEN_LOCK_CLEAN_TITLE = "SCREEN_LOCK_CLEAN_TITLE";
public static final String SCREEN_LOCK_CLEAN_INSTRUCTION = "SCREEN_LOCK_CLEAN_INSTRUCTION";
public static final String SCREEN_LOCK_CLEAN_HOLD_EXIT = "SCREEN_LOCK_CLEAN_HOLD_EXIT";
public static final String WHATS_NEW = "WHATS_NEW";


	/**
	 * Accessor for the actual strings that have been internationalized.
	 */

	@Override
	public Object[][] getContents() {
		return contents;
	}

	static private final Object[][] contents = {
		{READY, "Ready" },
		{INVAL_AMT, "Invalid Amount" },
		{SUBTOTAL, "Subtotal" },
		{TAX, "Tax" },
		{TOTAL, "TOTAL" },
		{CASH, "CASH" },
		{PAID, "PAID" },
		{CHANGE, "Change" },
		{SYSTEM_MSGS, "System Msgs" },
		{ EK_SYSTEM_MSGS, "System Msgs" },    // moniker for express key
		{ EK_DISMISS_SYSTEM_MSGS, "Dismiss Msgs" },    // moniker for express key
		{OK, "OK" },
		{CANCEL, "CANCEL"},
		{Cancel, "Cancel"},
		{SAVE, "Save" },
		{ENABLED, "Enabled" },
		{DISABLED, "Disabled" },
		{YES, "YES" },
		{NO, "NO" },
		{QUIT_APPL, "Quit Topaz Application?" },
		{PRINT_TKT, "Print Tkt" },
		{HELP, "Help" },
		{CSR_FCT, "CSR Func" },
		{SUSPEND, "Suspend" },
		{RECALL, "Recall" },
		{ADVANCED_OPTIONS_MENU, "Advanced Options - Multi Select Allowed"},
		{ADVANCED_OPTIONS_IMAGE_FILE, "GfxResources/WhiteIcon.jpg"},
		{ADVANCED_OPTIONS_HOURS_FILTER_ABBR, "Hours"},
		{ADVANCED_OPTIONS_DATE_TIME_FILTER_ABBR, "Dt/Tm"},
		{ADVANCED_OPTIONS_FUELLING_POSITION_FILTER_ABBR, "FP#"},
		{ADVANCED_OPTIONS_MOP_FILTER_ABBR, "MOP"},
		{ADVANCED_OPTIONS_FUEL_ONLY_FILTER_ABBR, "FuelOnly"},
		{ADVANCED_OPTIONS_MERCHANDISE_ONLY_FILTER_ABBR, "MerchOnly"},
		{ADVANCED_OPTIONS_FUEL_PLUS_MERCHANDISE_FILTER_ABBR, "Fuel+Merch"},
		{ADVANCED_OPTIONS_CARD_TYPE_FILTER_ABBR, "CrdType"},
		{ADVANCED_OPTIONS_REGISTER_FILTER_ABBR, "Reg#"},
		{ADVANCED_OPTIONS_SECONDARY_ORM_HEADER_MOP, "Method of Payment"},
		{ADVANCED_OPTIONS_SECONDARY_HEADER_MOP, "Select a Method of Payment"},
		{ADVANCED_OPTIONS_SECONDARY_ORM_HEADER_CARD, "Card Types"},
		{ADVANCED_OPTIONS_SECONDARY_HEADER_CARD, "Select a Card Type"},
		{ADVANCED_OPTIONS_PRIMARY_ORM_CHOOSE_A_TRANSACTION, "Choose a Transaction"},
		{ADVANCED_OPTIONS_ERROR_NO_PAID_TRANS, "There are no paid transactions"},
		{ADVANCED_OPTIONS_ERROR_NO_CARD_TRANS, "There are no card transactions"},
		{ADVANCED_OPTIONS_ERROR_NO_TRANS_FOR_FILTER_CRITERIA, "There are no transactions for given filter criteria"},
		{ADVANCED_OPTIONS_ERROR_INVALID_SELECTION, "This is an invalid selection"},
		{ADVANCED_OPTIONS_ERROR_RECALL_NOT_POSSIBLE, "Recall is not possible"},
		{ADVANCED_OPTIONS_FILTER_HEADER_PREFIX, "Filtered by "},
		{ADVANCED_OPTIONS_HOURS , "Hours"},
		{ADVANCED_OPTIONS_DATE_TIME, "Date/Time"},
		{ADVANCED_OPTIONS_FUELLING_POSITION, "Fueling Position #"},
		{ADVANCED_OPTIONS_MOP, "Mop"},
		{ADVANCED_OPTIONS_FUEL_ONLY, "Fuel Only"},
		{ADVANCED_OPTIONS_FUEL_PLUS_MERCHANDISE, "Fuel plus Merchandise"},
		{ADVANCED_OPTIONS_MERCHANDISE_ONLY, "Merchandise Only"},
		{ADVANCED_OPTIONS_CARD_TYPE, "Card Type"},
		{ADVANCED_OPTIONS_REGISTER, "Register #"},
		{ADVANCED_OPTIONS_DATE, "Date"},
		{ADVANCED_OPTIONS_TIME, "Time"},
		{CONFLICT_IN_TRANSACTION_TYPE, "Conflict in Transaction Type"},
		{PAYMENT_PROCESSED,"Payment Processed"},
		// added
		{PMT_SAFE_ESAFE_DROP_HDR, "E-SAFE DROP"},
		{PMT_SAFE_NO_VALID_MOP, "NO VALID MOP FOUND"},
		{ CHANGE_TOPAZ_IP, "CHANGE TOPAZ IP" },
		{ CHANGE_TOPAZ_REGISTER_ID, "CHANGE TOPAZ REGISTER ID" },
		{ CHANGE_SAPPHIRE_IP, "CHANGE CONTROLLER IP" },
		{ CHANGE_GATEWAY, "CHANGE GATEWAY" },
		{ CHANGE_NETMASK, "CHANGE NETMASK" },
		{ HPV, "HPV-20" },
		{ CHANGE_HPV, "CHANGE HPV-20 IP" },
		{ TOPAZ_REGISTER_ID, "Topaz Register ID" },
		{ TOPAZ_IP, "Topaz IP" },
		{ SAPPHIRE_IP, "Controller IP" },
		{ GATEWAY, "Gateway" },
		{ NETMASK, "Netmask" },
		{ RESTORE_VERIFONE_SETTINGS, "RESTORE VERIFONE SETTINGS " },
		{ RESTORE_DEFAULT, "Restore Verifone Settings" },
		{ RESTORE_VERIFONE_SETTINGS_CONFIRM, "Do you want to restore VeriFone Settings ? " },

		{ CURRENT_VALUE, "Current Value: " },
		{ IP_CONFIG_CONFIRM1, "SUCCESSFULLY UPDATED NEW VALUE TO DEVICE." },
		{ IP_CONFIG_CONFIRM2, "PLEASE REBOOT THE DEVICE(S) TO GET CHANGED EFFECT" },
		{ IP_CONFIG_CONFIRM_TITLE, "DEVICE CONFIG CHANGED" },

		{ INVALID_IP, "Error : Invalid IP " },
		{ INVALID_REG_ID, "Error : Invalid Register ID" },
		{ IP_CONFIGURATION, "IP Configuration" },
		{ SELECT_PARAMETER_TO_MODIFY, "Select Network Parameter To Modify" },

		{ TOPAZ_UPDATE_ERROR, "Error: Failed to update new value to Topaz " },
		{ SAPPHIRE_UPDATE_ERROR, "Error: Failed to update new value to Controller " },
		{ SAPPHIRE_CONFIG_VIEW_ERROR, "Error: Failed to fetch settings from Controller "},


		//////////////////////////////////
		// As part of CR_4046

		{CANNT_CORRECT_CASHIER_ALREADY_CLOSED, " Cannot Correct Cashier Already Close "},
		{ALREADY_CORRECTED, " Is Already Corrected "},
		{TRANSACTION, " Transaction  "},
		{INVALID_SAFE_DROP_TRANS, "Not a valid Safe Drop Transaction"},
		{ERROR_RETRIEVING_TRANS, "Error retrieving txn: "},
		{TICKET_NUM_REQUIRED, "Ticket number required"},

		{PMT_SAFE_IN_HOUSE_ACC_NUM, "Enter In-House Account #"},
		{PMT_SAFE_IN_HOUSE_SUB_ACC_NUM, "Enter In-House Sub Account #"},
		{PMT_SAFE_PAYIN_HDR, "PAY IN"},
		{PMT_SAFE_NO_SALE_HDR, "NO SALE"},
		{PRESS_ENTER_MOP_KEY, "Enter amount and press MOP Key"},
		{CLEAR, "CLEAR"},

		{PMT_SAFE_NO_KEY, "Select NO to modify amount"},
		{PMT_SAFE_YES_KEY, "Select YES to accept "},
		{PMT_SAFE_PLEASE_CONFIRM, "Please confirm "},
		{PMT_SAFE_REF_NUM, "Enter Reference #"},
		{PMT_SAFE_SAFE_LOAN_HDR, "SAFE LOAN"},
		{PMT_SAFE_PAYOUT_HDR, "PAY OUT"},
		{PMT_SAFE_PRESS_MOP, "And press MOP Key"},
		{PMT_SAFE_IS_MO, "Is this a money order payment?"},
		{PMT_SAFE_VENDOR_ID, "Enter Vendor ID"},
		{PMT_SAFE_VENDOR_PAYEE, "Enter Vendor Payee"},
		{ VP_AMOUNT_LARGE, "VENDOR PAYOUT: AMOUND IS TOO LARGE"},
		{ VP_VENDORID_NOT_VALID, "VENDOR PAYOUT: VENDOR ID IS NOT VALID"},
		{PMT_SAFE_SAFE_DROP_HDR, "SAFE DROP"},
		{SKIP_PUMP_NUMBER, "Press OK/<ENTER> to skip pump number"},
		{MUST_VOID_TICKET, "Voiding entire transaction"},
		{MANUAL_FUEL, "Manual Fuel"},
		{PAYROLL_REPORT_CLOSE_FAILED, "Payroll period close failed"},
		{PAYROLL_REPORT_CLOSED, "Payroll period closed"},
		{EMP_ID, "Employee ID (<ENTER> for ALL)"},
		{PAYROLL_REPORT_TITLE, "Payroll Report"},
		{CANNOT_PURCHASE_ITEM, "CUSTOMER CANNOT PURCHASE THIS ITEM"},
		{RESTRICTED_ITEM, "RESTRICTED ITEM"},
		{VOICE_AUTH, " for voice auth"},
		{CALL, "Call "},
		{APPROVAL_NO, "Approval # "},
		{APPROVED_NET, "Approved for Net 2"},
		{BALANCE_PRINTED, "Available balance is printed on receipt."},
		{PINPAD, "PINPAD"},
		{ITEM_TEPM_DISABLED, "Item Temporarily Disabled"},
		{POP_AWARD, "POP Award"},
		{ENTER_CASHIER_NO, "Enter Cashier Number"},
		{MODEM_SAPPHIRE_RESET, "Reset Controller Modem?"},
		{MODEM_RESET, "Modem Reset"},
		{BACKUP_SAPPHIRE_LOG, "Backup Controller Log?"},
		{BACKUP_LOG, "Backup Log"},
		{ENTER_DCR_NO, "Enter DCR Number, 0 for all DCRs"},
		{ENTER_PUMP_NO, "Enter pump number"},
		{INVALID_OPERATION, "Invalid Operation"},
		{FUEL_TAX_EXEMPTION, "Fuel Tax Exemption"},
		{SCANNNED_COUPON, "Scanned Coupon"},
		{ENTER_DOB, "Enter Birth Date"},
		{ID_CHECK_REQUIRED, "ID CHECK REQUIRED"},
		{CLOSE_CASH_DRAWER, "Please Close Cash Drawer"},
		{CANT_CONT_SALES, "Cannot continue Sales"},
		{CASH_DRAWER_OPEN, "CASH DRAWER OPEN"},
		{INITIALIZING_SALES_FUNCTION, "Sales functions initializing"},
		{ASKED_TAX, " TAX?"},
		{EXEMPT, "EXEMPT "},
		{ON_PINPAD, " on PinPad"},
		{ENTER_COUPON_VALUE, "Verify required purchases. Enter value of the Coupon"},
		{COUPON_SCANNING, "Coupon Scanning"},
		{SAPPHIRE_RESET, "Reset Controller System?"},
		//////////////////////////////////should move down
		{MONEY_ORDER, "MONEY ORDER"},
		{MO_DEV_STATUS, "Checking M.O. Device Status"},
		{PREPAID, "PREPAID"},
		{STARTED_SUCCESSFULLY, "Started Successfully"},
		{TOGGLE_SUCCESSFUL, "Toggle Successful-new state="},
		{IN_PROGRESS, "In Progress"},
		{RMI_REQUEST_FAILED, "RMI Request failed"},
		{ALERT, "ALERT"},
		{ENTER_CASHBK_PINPAD, "Enter Cashback on PinPad"},
		{CHOOSE_YES_NO_PINPAD, "Choose Y/N on PinPad"},
		{DEBIT_CASHBACK, "For Debit Cashback"},
		{CASHBACK_YES_NO, "CASHBACK YES/NO?"},
		{CASHBACK_ENTER, "CASHBACK AMOUNT"},
		{MAX_CASHBACK, "MAX " },
		{GET_BALANCE_INQUIRY, "Get Balance Inquiry"},
		{PRINTING_BALANCE_INQUIRY, "Printing Balance Inquiry..."},
		{FAILED_BALANCE_INQUIRY, "Balance Inquiry Failed"},
		{DISCARD_FULE_PRICE_CHANGES, "Discard Fuel Price Changes ?"},
		{SEQUENCE_NO, " Sequence #"},
		{CLOSE_STATUS, "Close Status"},
		{SYSTEM_RESET, "System Reset"},
		{ VOLUME_CONTROL_TITLE, "Adjust Volume" },
		{ BRIGHTNESS_CONTROL_TITLE, "Adjust Brightness" },
		{ SCREEN_SAVER_CONTROL_TITLE, "Adjust Screen Saver" },
		// As part of CR_4046

		{ READY, "Ready" },
		{ DSP_REFUND, "REFUND" },
		{ INVAL_AMT, "Invalid Amount" },
		{ INVAL_ACCT, "Invalid Account" },
		{ INVAL_SUB_ACCT, "Invalid Sub Account"},
		{ INVAL_MOP, "MOP Not Allowed" },
		{ STOT_REQD, "SUBTOTAL REQUIRED" },
		{ FINTICK, "FINISH TRANSACTION" },
		{ MOP_STICKY, "OPERATION NOT ALLOWED" },
		{ AMT_DUE, "Amt Due" },
		//{ RCPT_HDR, "   Descr.                qty      amount\n   -------               ---      ------\n" },
		//               	   "1234567890123456789012345678901234567890";
		//{ RCPT_HDR, " Description    Qty Amount"},
		{ RCPT_HDR_DESCRIPTION, "Description"},
		{ RCPT_HDR_QUANTITY, "Qty"},
		{ RCPT_HDR_AMOUNT, "Amount"},
		{ SYSTEM_MSGS, "System Messages" },
		{ EK_SYSTEM_MSGS, "System Msgs" },    // moniker for express key
		{ EK_DISMISS_SYSTEM_MSGS, "Dismiss Msgs" },    // moniker for express key

		{ OK, "OK" },
		{ CANCEL, "CANCEL"},
		{ Cancel, "Cancel"},
		{ YES, "YES" },
		{ NO, "NO" },
		{ QUIT_APPL, "Quit Topaz Application?" },
		{ PRINT_TKT, "Print Tkt" },
		{ HELP, "Help" },
		{ Help, "Help" },
		{ DISMISS_HELP, "Dismiss Help" },
		{ CSR_FCT, "CSR Func" },
		{ SUSPEND, "Suspend" },
		{ RECALL, "Recall" },
		{ KEY_LBL_PCHECK, "Price Check" },
		{ VERIFONE_LOGO, "verifonelogo.jpg"},
		{ CUSTOMER_LOGO, "customerlogo.jpg"},
		{ OK_BUTTON_IMAGE, "okbuttonimage.jpg"},
		{ CANCEL_BUTTON_IMAGE, "cancelbuttonimage.jpg"},
		{ MENU_SCREEN_BUTTON_IMAGE, "menuscreenbuttonimage.jpg"},
		{ MENU_NORMAL_BUTTON_IMAGE, "menunormalbutton.jpg"},
		{ MENU_DISABLED_BUTTON_IMAGE, "menudisabledbutton.jpg"},
		{ TOUCH_SCREEN_TO_LOGIN, "Touch screen to login"},
		{ PRESS_ENTER_OR_TOUCH_SCREEN_TO_LOGIN, "Press Enter or touch screen to login"},
		{ ENTER_ID_AND_PASSWORD, "Enter ID and Password"},
		{ ID, "ID"},
		{ PASSWORD, "Password"},
		{ LOGIN, "Login" },
		{ ENTER_ID, "Enter ID"},
		{ ENTER_AMOUNT, "Enter Amount" },
		{ ENTER_DISC_AMOUNT, "Enter Discount Amount" },
		{ ENTER_QTY, "Enter Quantity" },
		{ ENTER_PERCENT, "Enter Percentage" },
		{ ENTER_DISC_PERCENT, "Enter Discount Percentage" },
		{ ENTER_PASSWORD, "Enter Password For ID: "},
		{ SLIP_HEADER, "   item       qty  price\n------------- -- -------\n"},
		{ IMAGE_PATH, "GfxResources"},
		{ UUID, "UI#"},
		{ RDH_TPCR, "   Description           Qty      Amount\n   -----------           ---      ------\n" },
		{ HEADER_WITH_UNIT_PRICE, "   Description      Qty/P.Unit    Amount\n   -----------      ----------    ------\n" },
		{ TKT_REFUND, "R E F U N D" },
		{ TKT_SUSPENDED, "TRANSACTION SUSPENDED #" },
		{ TKT_CASHBACK, "Cash Back" },
		{ TKT_PMT_FEE, "Cash Back Fee" },
		{ TKT_SUBTOT, "Subtotal" },
		{ TKT_TAX, "Tax" },
		{ TKT_ALL_TAX, "Tax Type  Purchase Rebate  Taxable   Tax"},
		{ TKT_TAX_EXEMPT_HEADER, "** TAX EXEMPT **"},
		{ TKT_TAX_EXEMPT_EMPTY, ": ________________________________________"},
		{ TKT_TAX_SUMMARY, "Rate       Base      Tax        Total   "},
		{ TKT_TAX_EXEMPT, "Exempt" },
		{ TKT_TOTAL, "TOTAL" },				// Shorter for 2wide print
		{ TKT_BODY_SEP, "                              ----------\n" },
		{ TKT_CUST_DOB_VERF, "CUSTOMER ID VERIFIED " },
		{ TKT_VOID_TRAN, "VOID TICKET" },
		{ TKT_VOID_LINE, "V" },
		{ TKT_REFUND_LINE, "R" },
		{ TKT_REPRNT_TRAN, "< DUPLICATE RECEIPT >" },
		{ TKT_REPRNT_FUEL, "< FUEL ITEM(S) DUPLICATE RECEIPT >" },
		{ TKT_PRINT_DEAL_DISC, "DISCOUNT" },
		{ TKT_DRIVE_OFF_1, "AUTO TAG #______________________________" },
		{ TKT_DRIVE_OFF_2, "MAKE/MODEL _____________________________" },
		{ TKT_DRIVE_OFF_3, "AUTO COLOR _____________________________" },
		{ TKT_DRIVE_OFF_4, "OTHER __________________________________\n________________________________________" },
		{ TKT_NOPLU_HDR1, "MANUAL ADJUSTMENT\n" },
		{ TKT_NOPLU_HDR2, "PLU ITEM NOT FOUND\n" },
		{ TKT_NOPLU_HDR3, "ITEM DESCRIPTION\n" },
		{TKT_NOPLU_HDR4, "DEPT: "},
		{ FS_SUBTOT, "Sub Total FS" },
		{ FS_TAX_CREDIT, "Tax Credit" },
		{ FS_CHANGE, "Change due in FS" },
		{ CHANGE_DUE, "Change" },
		{ POLE_DISP_TOTAL, "     TOTAL" },
		{ POLE_DISP_CHANGE, "CHANGE    " },
		{ POLE_DISP_PCHECK, "*** PRICE CHECK  ***" },
		{ POLE_DISP_CLOSED, "* REGISTER CLOSED *" },
		{ POLE_DISP_DISC, "  Discount"},
		{ POLE_DISP_TOT, "TOT" },
		{ PAYMENT_TIME, "  PAYMENT TIME: "},
		{ CARD_TYPE, "  CARD TYPE: " },
		{ CARD_NAME, "  CARD NAME: " },
		{ ACCT_NUMBER, "  ACCT NUMBER: " },
		{ EXP_DATE, "  EXP. DATE: " },
		{ TRANS_TYPE, "  TRANS TYPE: " },
		{ APPROVAL, "  APPROVAL: " },
		{ REFERENCE, "  REFERENCE#: "},
		{ AUTH_NO, "  AUTH#: "},
		{ INVOICE, "  INVOICE: "},
		{ ODOMETER, "  ODOMETER: "},
		{ VEHICLE, "  VEHICLE#: "},
		{ JOB_NUMBER, "  JOB NUMBER: "},
		{ USER_DATA, "  USER DATA: "},
		{ SIGNATURE_FMT, "X______________________________________"},
		{ ASTERISK_FMT, "****************************************"},
		{ CONTACTLESS_FMT, "**            CONTACTLESS             **"},
		{ AGREEMENT_LINE1, "I AGREE TO PAY TOTAL AMOUNT ACCORDING TO"},
		{ AGREEMENT_LINE2, "CARD ISSUER AGREEMENT. _________INITIALS"},
		{ NO_SIGNATURE, " NO SIGNATURE NEEDED"},
		{ TOP_COPY, "TOP COPY - MERCHANT  2ND COPY - CUSTOMER"},
		{ TKT_PLU_ADJ_HDR, "MANUAL ADJUSTMENT" },
		{ TKT_PLU_ADJ_TXT, "PLU Item Not Found" },
		{ TKT_PLU_ADJ_DSC, "Item Decsription" },
		{ SYSTEM_INIT_MSG, "Starting up, please wait ..." },
		{ DSC, "Dsc"},
		{ REFERENCE_SMALL, "Ref#" },
		{ SERIAL_NUMBER, "SN. "},
		{ DISMISS_REPORT, "Dismiss Report"},
		{ PRINT_REPORT, "Print Report"},
		{ SAVE_REPORT, "Save Report"},
		{ CONFIRM_SELECTION, "Confirm"},
		{ SKIP_SELECTION, "Skip"},
		{ MAIN_MENU, "Main Menu" },
		{ MENU_FN_REPORT, "Reporting Menu" },
		{ MENU_FN_FUEL, "Fuel Manager Menu" },
		{ MENU_FN_NETWORK, "Network Menu" },
		{ MENU_FN_REG_MAINT, "Maintenance" },
		{ MENU_FN_CONFIGCLIENT, "Configuration Manager" },

		{ REPORT_FUNCTIONS_MENU, "Reporting Functions Menu" },
		{ REPORT_CLOSE_CASHIER, "Close Cashier Report" },
		{ REPORT_PRINT_CASHIER, "Print Cashier Report" },
		{ REPORT_PRINT_CURRENT_CASHIER, "Print Current Cashier Report" },
		{ REPORT_CASHIER_WORKSHEET, "Cashier Worksheet" },
		{ REPORT_CLOSE_ATTENDANT, "Close Attendant Report" },
		{REPORT_PRINT_ATTENDANT, "Print Attendant Report"},
		{ REPORT_CLOSE, "Close {0} Report" },
		{ REPORT_PRINT, "Print {0} Report" },
		{ REPORT_PAYROLL_REPORTS, "Payroll Reports" },
		{ REPORT_FUNDS_AUDIT, "Funds Audit Report" },
		{ REPORT_FLASH_REPORTS, "Flash Reports" },
		{ REPORT_FLASH_TITLE, "FLASH" },
		{ REPORT_CLOSE_TITLE, "CLOSE" },
		{ REPORT_RPT_TITLE, "{0} REPORT" },
		{ REPORT_WARNING_TITLE, "SENSITIVE DATA WARNING" },
		{ REPORT_WARNING_LEBEL1, "WARNING: Merchant is liable for these printed contents." },
		{ REPORT_WARNING_LEBEL2, "You must make every effort to secure the contents disclosed." },
		{ REPORT_WARNING_LEBEL3, "Press YES to print report with unmasked accounts or NO to exit." },
		{ REPORT_WARNING_TITLE_ATTD, "Warning: Finish pending sales" },
		{ REPORT_WARNING_LEBEL1_ATTD, "Confirm {0} is not working" },
		{ REPORT_WARNING_LEBEL2_ATTD, "at any register or at the pump " },
		{ ATTENDANT_AND_PERIOD_SEQUENCE, "Attendant {0}   Sequence #{1}"},
		
		{ REPORT_CWPAYPOINT_TITLE, "CARWASH PAY POINT" },
		{ REPORT_RECONCILIATION_TITLE, "RECONCILIATION REPORT" },
		{ REPORT_CLOSE_CWPAYPOINT, "Close Carwash Pay Point Period" },
		{ REPORT_PRINT_CWPAYPOINT, "Print Carwash Pay Point Period" },



		{ FLASH_FUNCTIONS_MENU, "Flash Reports Menu" },
		{ FLASH_SUMMARY, "Print Summary Report" },
		{ FLASH_CATEGORY, "Print Category Report" },
		{ FLASH_DEAL, "Print Deal Report"},
		{ FLASH_DEPARTMENT, "Print Department Report" },
		{ FLASH_HOURLY, "Print Hourly Report"},
		{ FLASH_LOYALTY, "Print Loyalty Report"},
		{ FLASH_PLU, "Print PLU Report" },
		{ FLASH_PLUPROMO, "Print PLU Promo Report"},
		{ FLASH_TAX, "Print Tax Report" },


		{ FLASH_AUTOCOLLECT, "Print Fuel Autocollect Report"},
		{ FLASH_BLEND_PRODUCT, "Print Fuel Blend Product Report"},
		{ FLASH_DISPENSER, "Print Fuel Dispenser Report"},
		{ FLASH_FP_HOSE, "Print Fuel FP/Hose Report" },
		{ FLASH_FP_HOSE_RUNNING, "Print Fuel FP/Hose Running Report" },
		{ FLASH_FPHOSETEST, "Print Fuel FP/Hose Test Report"},
		{ FLASH_PRPRICE, "Print Fuel PR/Price Level Report"},
		{ FLASH_SLPRICE, "Print Fuel SL/Price Level Report"},
		{ FLASH_TANK, "Print Fuel Tank Report" },
		{ FLASH_TIERPR, "Print Fuel Tier Product Report"},

		{ FLASH_DCRSTAT, "Print DCR Statistical Report"},
		{ FLASH_POPDISC, "Print POP Discount Report"},
		{ FLASH_POPDEF, "Print POP Discount Def Report"},
		{ FLASH_POPDISCPRG, "Print POP Discount Program Report"},
		{ FLASH_NETWORK, "Print Network Card Report" },
		{ FLASH_ASA_PAYMENT, "Print Mobile Payment (Collected by Host) Report" },
		{ FLASH_NETPROD, "Print Network Product Report"},

		{ FLASH_CW_PAYPOINT, "Print Carwash Pay Point Report"},
		{ FLASH_ESAFECONTENT, "Print E-Safe Content Report"},
		{ FLASH_ESAFEEOD, "Print E-Safe End Of Day Report"},
		{ FLASH_TANKREC, "Print Tank Reconciliation Report"},

		{ FLASH_PROP_NETWORK_CARD, "Print Proprietary N/W Card Report"},
		{ FLASH_PROP_NETWORK_PROD, "Print Proprietary N/W Product Report"},

		{ FLASH_NETWORK_TOTALS, "Print Network Card Report" },
		{ FLASH_CASH_ACCEPTOR, "Print Cash Acceptor Report"},
		{ FLASH_FUEL_STREET_PRICE_CHANGE, "Print Fuel Street Price Change Report"},



		{PROPRIETARY_NETWORK_FUNCTIONS_MENU, "Proprietary Network Menu"},
		{NETWORK_FUNCTIONS_MENU, "Network Menu" },
		{NET_PRE_AUTHORIZATION, "Pre-Authorization"},
		{NET_GET_NETWORK_MAIL, "Get Network Mail" },
		{NET_PARAMETER_DOWNLOAD, "Parameter Download" },
		{NET_COMM_STATISTICS, "Comm Statistics" },
		{NET_HOST_TOTALS, "Host Totals Report" },
		{NET_PINPAD_CONFIGURATION, "PINpad Configuration" },
		{NET_SVC_MENU, "SVC Functions Menu" },
		{NET_SAF_MENU, "Store and Forward Menu" },
		{NET_BATCH_DETAILS_MENU, "Batch Details Menu" },
		{NET_PRINT_NETWORK_LOG, "Print Network Log" },
		{NET_PREPAID_FUNCTIONS_MENU, "Prepaid Functions Menu" },

		{SVC_FUNCTIONS_MENU, "Stored Value Card Functions Menu" },
		{SVC_CARD_ACTIVATION, "Card Activation" },
		{SVC_CARD_RECHARGE, "Card Recharge" },
		{SVC_BALANCE_INQUIRY, "Balance Inquiry" },
		{SVC_CARD_DEACTIVATION, "Card Deactivation" },
		{SVC_VOID_ACTIVATION, "Void Activation" },
		{SVC_VOID_RECHARGE, "Void Recharge" },
		{TYPES_OF_REFUND, "Types Of Refund" },
		{CHOOSE_REFUND_TYPE, "Choose An Option" },

		{EBT_FUNCTIONS_MENU, "EBT Functions Menu" },
		{EBT_BALANCE_INQUIRY, "EBT Balance Inquiry" },
		{EBT_VOUCHER_CLEAR, "EBT Voucher Clear" },
		{EBT_VOUCHER_PROMPT_FSCARD, "Food Stamp Card?  (Y/N)" },
		{EBT_VOUCHER_PROMPT_ACCT, "Enter Account Number" },
		{EBT_VOUCHER_INVALID_EXP, "Invalid Expiration Date" },
		{EBT_VOUCHER_PROMPT_REFUND, "Refund?  (Y/N)" },
		{EBT_VOUCHER_PROMPT_DATE, "Enter Original Sale Date (DDMMYY)" },
		{EBT_VOUCHER_PROMPT_AMOUNT, "Enter Amount" },
		{EBT_VOUCHER_PROMPT_APPROVAL, "Enter Approval Number" },
		{EBT_VOUCHER_PROMPT_VOUCHNUM, "Enter Voucher Number" },
		{EBT_VOUCHER_NO_CASH, "No Cash Vouchers" },
		{EBT_VOUCHER_INVALID_ENTRY, "Invalid Entry" },

		{QUICK_CREDIT, "Quick Credit" },
		{QUICKCREDIT_SSN, "ENTER SOC SEC #" },
		{QUICKCREDIT_BIRTH_DATE, "ENTER DOB DDMMYY" },
		{QUICKCREDIT_STREET_NUMBER, "ENTER STREET #" },
		{QUICKCREDIT_HOME_PHONE, "ENTER PHONE #" },
		{QUICKCREDIT_ZIP_CODE, "ENTER ZIP CODE" },
		{QUICKCREDIT_LESS_6MO, "ADDRESS < 6 MOS" },
		{QUICKCREDIT_YES_NO, "ENTER=Y, CLEAR=N" },
		{QUICKCREDIT_PREVIOUS_STREET, "PREVIOUS STREET" },
		{QUICKCREDIT_PREVIOUS_ZIP_CODE, "PREVIOUS ZIPCODE" },
		{QUICKCREDIT_FAILED, "QUICK CREDIT TRANSACTION FAILED" },
		{QUICKCREDIT_INV_SSN, "INVALID SOCIAL SECURITY NUMBER" },
		{QUICKCREDIT_INV_SSN_RETRY, "INVALID SOC SEC #, RETRY" },
		{QUICKCREDIT_INV_DOB, "INVALID DATE OF BIRTH" },
		{QUICKCREDIT_INV_DOB_RETRY, "INVALID DATE OF BIRTH, RETRY" },
		{QUICKCREDIT_INV_PHONE, "INVALID PHONE NUMBER" },
		{QUICKCREDIT_STREET_NOT_ENTERED, "STREET NOT ENTERED" },
		{QUICKCREDIT_PREVIOUS_STREET_NOT_ENTERED, "PREVIOUS STREET NOT ENTERED" },
		{QUICKCREDIT_ZIP_TOO_SHORT, "ZIP CODE TOO SHORT" },
		{QUICKCREDIT_5_DIGIT_ZIP, "MUST ENTER NON ZERO 5 DIGIT ZIPCODE" },

		{LOYALTY_FUNCTIONS_MENU, "Loyalty Functions Menu" },
		{LOYALTY_BALANCE_INQUIRY, "Loyalty Balance Inquiry" },
		{LOYALTY_BALANCE_INQUIRY_PROMPT, "Please swipe Loyalty card" },

		{SAF_FUNCTIONS_MENU, "Store And Forward Management Menu" },
		{SAF_PRINT_DECLINED_SALES, "Print Declined Stored Sales" },
		{SAF_PRINT_UNSENT_SALES, "Print Unsent Stored Sales" },
		{SAF_DELETE_SINGLE_SALE, "Delete Single Stored Sale" },
		{SAF_DELETE_ALL_SALES, "Delete All Stored Sales" },

		{FUEL_FUNCTIONS_MENU, "Fuel Manager Menu" },
		{FUEL_INIT_FUEL, "Initialize Fuel" },
		{FORCE_INIT_FUEL, "Price Display Offline. Proceed with Fuel Initialization?"},
		{FORCE_INIT_FUEL_PRICES, "Price Display Offline. Proceed with Fuel Price Change?"},
		{FUEL_DOWNLOAD_FUEL_PRICES, "Download Fuel Prices" },
		{FUEL_INIT_ESIGN_SITE, "Initialize Site Sign" },
		{FUEL_CLEAR_PUMP_ON_HOLD, "Clear Pump On Hold" },
		{FUEL_RESET_CONTROLLER, "Reset Controller" },
		{FUEL_TOGGLE_FUEL_SITE_PAUSE, "Fuel Site Pause" },
		{FUEL_FUNCS_PRESS_ENTER_CONTINUE, "Press YES or <ENTER> to continue"},
		{FUEL_DISABLE_FUEL_SITE_PAUSE, "Do You Wish To Disable Fuel Site Pause?" },
		{FUEL_ENABLE_FUEL_SITE_PAUSE, "Do You Wish To Enable Fuel Site Pause?" },
		{FUEL_FUEL_SITE_PAUSE_ENABLED, "Fuel Site Pause Enabled" },
		{FUEL_FUEL_SITE_PAUSE_DISABLED, "Fuel Site Pause Disabled" },
		{FUEL_INIT_FUEL_DRIVER, "Intitalize Fuel Driver"},
		{FUEL_INIT_SPI_CONFIG, "Initialize SPI Configuration"},

		{DCR_DOWNLOAD_DCR, "Download To DCRs" },
		{DCR_DOWNLOAD_ALL_DCR, "Download To All DCRs" },
		{DCR_INIT_DCR_DRIVER, "Initialize DCR Driver" },
		{DCR_FORCE_INIT_ALL_DCR, "All DCRs Not Idle.  Do You Wish To Force Individual DCR Download?" },
		{DCR_DOWNLOAD_DCR_NUM_ERROR, "Error: DCR Number Entered Invalid! Please Enter a Valid DCR Number" },

		{REG_MAINT_FUNCTIONS_MENU, "Register Maintenance Functions Menu" },
		{REG_MAINT_OK, "Register Maintenance" },
		{REG_MAINT_ADJ_VOLUME, "Adjust Volume" },
		{REG_MAINT_ADJ_BRIGHTNESS, "Adjust Brightness" },
		{REG_MAINT_ADJ_SCREENSAVER, "Adjust Screen Saver" },
		{REG_MAINT_SYS_MSGS, "System Messages" },
		{REG_MAINT_DEVICE_CONTROL, "Device Control" },
		{REG_MAINT_ADJUST_BAUD, "Adjust Baudrate" },
		{REG_MAINT_STORE_PHONE_NR, "Store Phone Number" },
		{REG_MAINT_POSTAL_CODE, "Store Postal Code" },
		{REG_MAINT_SYSTEM_DATE_TIME, "Set System Date/Time" },
		{REG_MAINT_SYSTEM_DATE, "Set System Date" },
		{REG_MAINT_SYSTEM_TIME, "Set System Time" },
		{REG_MAINT_TIME_FORMAT, "{0} (24-hr format)" },
		{REG_MAINT_DEVICE_CONFIG, "Device Configuration" },
		{REG_MAINT_DEVICE_CONFIG_MENU, "Device Configuration Menu" },
		{REG_MAINT_PINPAD_CONFIG, "PINpad Configuration" },
		{REG_MAINT_SELECT_LANGUAGE, "Select Language" },
		{REG_MAINT_BACKUP_LOG, "Backup Log Files"},
		{REG_MAINT_RESET_MODEM, "Reset Modem"},
		{REG_MAINT_RESET_SYSTEM, "Reset System"},
		{REG_MAINT_PRINT_INSTALL, "Print Installation Information"},
		{REG_MAINT_APPLY_UPGRADE, "Apply Upgrade"},
		{REG_MAINT_PRINT_UPGRADE_SUMMARY, "Print Upgrade Summary"},


		{ REG_MAINT_CHECK_FOR_UPDATES , "Check for USB Updates" },
		{ REG_MAINT_SHOW_UPGRADE_STATUS , "Show Upgrade Status" },
		{ REG_MAINT_INIT_VRSD_UPDATE_CHECK , "Check for VRSD Updates" },


		{REG_MAINT_REFRESH_CONFIG, "Apply Configuration"},
		{REG_MAINT_PING_TEST, "Ping Test"},
		{REG_MAINT_SCREEN_LOCK_CLEAN, "Clean Screen"},

		{REG_MAINT_PWD_MANAGEMENT, "Secure User" },
		{REG_MAINT_PWD_RESET, "Reset Password" },
		{REG_MAINT_PWD_CHANGE, "Change Password" },
		{REG_MAINT_PWD_MANGEMENT_MENU, "Secure User Menu" },
		{REG_MAINT_OLD_PASSWORD , "Old Password" },
		{REG_MAINT_CONF_PASSWORD , "Confirm Password" },
		{REG_MAINT_NEW_PASSWORD , "New Password" },
		{REG_MAINT_SECURE_LOGIN_TITLE, "Secure User Login"},
		{REG_MAINT_SECURE_USERID, "USER ID"},
		{REG_MAINT_SECURE_PASSWORD, "PASSWORD"},
		{REG_MAINT_SECURE_USE_EXPIRE_MSG, "Your secure password has expired"},
		{REG_MAINT_SECURE_LOCK_MSG, "Your secure ID is locked"},
		{REG_MAINT_SECURE_INVALID_MSG, "Invalid Secure Id/Password"},
		{REG_MAINT_SECURE_SESSION_EXPIRE, "Session Expired"},
		{REG_MAINT_SECURE_CHANGE_PWD_FAIL, "Secure password not changed"},
		{REG_MAINT_SECURE_CHANGE_PWD_SUCCESS, "Secure password changed "},
		{REG_MAINT_SECURE_PWD_MATCH_ERROR, "Passwords do not match, please re-enter password"},
		{ REG_MAINT_SECURE_PWD_CONTAINS_SPACES, "Password must not contain leading or trailing space(s), please re-enter password" },
		{REG_MAINT_SECURE_PWD_ALLOWED_ERROR, "Previous 4 passwords not allowed"},
		{REG_MAINT_SECURE_OLD_PWD_ERROR, "Incorrect password please re-enter the password"},
		{REG_MAINT_SECURE_RESET_PWD_SUCCESS, "Reset password successful"},
		{REG_MAINT_SECURE_RESET_PWD_FAIL, "Reset password failed"},
		{REG_MAINT_SECURE_ADMIN_REQUIRE, " Login as administrator to reset password"},
		{REG_MAINT_INVALID_USER, "Invalid User "},
		{REG_MAINT_REFRESH_CONFIG_PROMPT, "Do You Wish To Apply Configuration Changes?"},
		{REG_MAINT_PING_TEST_PROMPT, "Enter IP address or host name to ping"},
		{REG_MAINT_PING_TEST_SUCCESS, "Ping successful"},
		{REG_MAINT_PING_TEST_IP_ERROR, "Error: IP Address Provided is invalid"},
		{REG_MAINT_SECURE_PWD_EXPIRE_WARNING, "Your secure password will expire in {0} days"},
		{REG_MAINT_INVALID_OTP, "Invalid OTP"},
		{REG_MAINT_OCB_MENU_TITLE, "Order Confirmation Board"},
		{REG_MAINT_OCB_ASSIGN_QUESTION, "Attach this POS to the Order Confirmation Board?"},
		{REG_MAINT_OCB_UNASSIGN_QUESTION, "De-attach this POS from the Order Confirmation Board?"},
		{REG_MAINT_OCB_ASSIGNED_TO, "Order Confirmation Board is currently assigned to Register {0}"},
		{REG_MAINT_OCB_MENU_NOASSIGN, "Assignment not allowed at this time!"},
		{REG_MAINT_OCB_MENU_OCBDENY, "Cannot attach to Order Confirmation Board"},
		{REG_MAINT_OCB_MENU_DENYREASON, "POS System is not configured for drive thru"},
		{ MENU_FN_OTHER, "Other Functions" },
		{ MENU_FN_REVIEW, "Review Settings" },
		{ MENU_FN_LOGOUT, "Log Out" },
		{ MENU_FN_SALES, "Sales Functions" },
		{ MENU_PREVIOUS, "Previous Menu" },
		{ MAIN_MENU_MSG, "Touch menu button or enter item# + <ENTER> on the Keyboard" },
		{ MENU_PRICE_CHECK, "Confirm Add / Cancel" },
		{ FUEL_DISABLE_ENABLE_DCR, "Disable/Enable DCR"},
		{ PAID, "      PAID " },
		{ FN_CLOSE_CASHIER, "Close Cashier"},
		{ FN_PRINT_CASHIER_REPORT, "Reconcile Cashier Report"},
		{FN_CLOSE_ATTENDANT, "Close Attendant"},
		{FN_PRINT_ATTENDANT_REPORT, "Reconcile Attendant Report"},
		{ CLOSE_CASHIER_NUM_PROMPT, "Enter Cashier Number to Close"},
		{ CASHIER, "Cashier"},
		{ATTENDANT, "Attendant"},
		{ REPORT, "Report"},
		{ COMPLETED_SUCCESSFULLY, "Completed Successfully"},
		{ CSR_CLOSE_ERROR, "No open report or Invalid Cashier Number"},
		{ CLOSE_ESAFE_FIRST, "Cashier still has Open Shift on Safe"},
		{ CONTINUE_CASHIER_CLOSE, "Do you want to continue cashier closing"},
		{ CASHIER_WARNING, "CASHIER WARNING"},

		{ FAILED, "Failed"},
		{ TIMEOUT_FAILURE, "Timeout failure"},
		{ FN_CLOSE_PD1, "Close Period 1"},
		{ FN_CLOSE_PD2, "Close Period 2"},
		{ FN_CLOSE_PD3, "Close Period 3"},
		{ FN_CLOSE_PD4, "Close Period 4"},
		{ FN_CLOSE_NAME, "Close"},
		{ PERIOD_SEQUENCE, "Sequence: "},
		{ PERIOD_BEGIN , "Begin time: "},
		{ CLOSE_DISALLOWED_PDTYPE, "Close not supported for period type"},
		{ CLOSE_DISALLOWED, "Period close not allowed"},
		{ NO_SALES_PERIOD, "No sales since last period close"},
		{ FORCE_PERIOD_CLOSE, "Do you wish to close period?"},
		{ FORCE_CLOSE_RETRY, "Retry Close?"},
		{ CLOSE_TOO_SOON, "Period close before allowed time"},
		{ NEXT_ALLOWED_CLOSE, "Next period close allowed at "},
		{ SECURITY_INFO_REQD, "SECURITY INFO REQUIRED"},
		{ PERIOD_CLOSE_IN_PROG, "Period Close in Progress"},
		{ EXIT_SALES_FOR_CLOSE, "Exit sales on all registers"},
		{ INVALID_STATE_FOR_CLOSE, "Invalid state - Exit reports on Ruby"},
		{ PERIOD_CLOSE_FAILED, "Period close failed"},
		{ CLOSE_CSRS_FIRST, "Close all cashiers before attempting period close"},
		{ PERIOD_CLOSE_CANCELED, "Period close was canceled"},
		{ SETTLE_SUSPENDED_TXNS_FIRST, "Settle suspended transactions before attempting period close"},
		{ PERIOD_CLOSE_PENDING_TXNS, "Pending transactions during period close"},
		{ SETTLE_FUEL_PENDING_TXNS, " Settle fuel due sale(s) before attempting period close"},
		{ REGISTERS_NOT_CLOSED, "One or more registers did not exit Sales"},
		{ NETWORK_HOST_UNAVAILABLE, "Network Host Unavailable"},
		{ NETWORK_HOST_FAILED, "Unable To Reconcile Network Totals"},
		{ NETWORK_HOST_RETRY, "Sales Transaction Pending"},
		{ LOCK_CLIENTS, "Exit Sales on registers"},
		{ LOCK_SVCS, "Locking services"},
		{ CLOSE_CSRS, "Closing Cashiers"},
		{ DATA_COMMIT, "Saving period data"},
		{ PRESS_ENTER, "Press Enter to Continue"},

		{ SELECT_TILL, "Select Till"},
		{ SCREEN_SELECT_TILL_HEADER, "     Date          Time       Reg#   Dr#      CSR Name"},
		{ DRAWER_NUMBER_ABBR, "Dr#"},
		{ REGISTER_NUMBER_ABBR, "Reg#"},
		{ OPEN_TILL_DRAWER_1, "1. OPEN TILL for Drawer 1"},
		{ OPEN_TILL_DRAWER_2, "2. OPEN TILL for Drawer 2"},
		{ UNAVAILABLE_TILL_DRAWER_1, "1. Unavailable - must close a till for Drawer 1"},
		{ UNAVAILABLE_TILL_DRAWER_2, "2. Unavailable - must close a till for Drawer 2"},
		{ SELECT_TILL_OTHER_FUNCTIONS, "3. NON-SALES FUNCTIONS ONLY"},
		{OPEN_ATTENDENT_SESSION, "4. OPEN ATTENDANT"},
		{ INVALID_USER, "Invalid UserID or Password"},
		{ INVALID_USER_ID, "Invalid User ID"},
		{ SITE_PAUSE_ENABLED, "SITE PAUSE ENABLED"},
		{ CSR_MSG_NOSALE, "NO SALE"},
		{ CSR_MSG_CLOSE_DRW, "CLOSE DRAWER"},
		{ CSR_MSG_NO_RFND_ALLOWED, "REFUND NOT ALLOWED"},
		{ CSR_MSG_NO_CHG_ALLOWED, "CHANGE NOT ALLOWED"},
		{ CSR_MSG_VOID_LN_MODE, "VOID"},
		{ CSR_SAFE_DROP_RQD, "DROP "},
		{ CSR_NO_SUSPEND, "SUSPEND NOT ALLOWED"},
		{ READY_FOR_DBSYNC, "Preparing to synchronize the database"},
		{ DBSYNC_IN_PROGRESS, "Database synchronization in progress"},
		{ DBSYNC_COMPLETE, "Database synchronization completed"},
		{ DBSYNC_ERROR, "Error: Database synchronization"},
		{ LOCK_POS, "POS Locked.DB cannot be synchronized"},
		{ CUSTOMER_COPY, " <CUSTOMER COPY>"},
		{ MANUAL_ENTRY, "*** MANUAL ***"},
		{ VOID_TRAN, "VOID"},
		{ SALE_TRAN, "SALE"},
		{ REFUND_TRAN, "REFUND"},
		{ PREPAY , "PREPAY"},
		{ FILL_UP , "FILL-UP"},
		{ SUSPEND_TRAN , "SUSPEND"},
		{ PREAUTH , "PREAUTH"},
		{ SPLIT_TENDER , "SPLT TNDR"},
		{ VOID_TCKT, "VOID TKT"},
		{ TICKET_NUM , "Ticket#"},
		{ TRAN_SEQ , "#"},
		{ DETAILS , "Details"},
		{ VOLUME , "Volume"},
		{ TYPE , "Type"},
		{ FUEL_AUTH, "FUEL AUTH" },
		{ FN_PRINT_SHIFT_REPORT, "Print Shift Report"},
		{ SELECT_SHIFT, "Select Period"}, //Same string used for all periods; make it generic
		{ SAFE_DROP_HDR, "S A F E   D R O P"},
		{ ESAFE_DROP_HDR, "E-S A F E  D R O P"},
		{ SAFE_LOAN_HDR, "S A F E   L O A N"},
		{ PAYOUT_HDR, "P A Y   O U T"},
		{ PAYIN_HDR, "P A Y   I N"},
		{ NO_SALE_HDR, "N O   S A L E"},
		{ CARWASH_CODES_PRFX, "Your "},
		{ CARWASH_CODES, " digit Car Wash code(s)"},
		{ CARWASH_DAYS_VAL, "Good thru "},
		{ CARWASH_COMM_ERR, "Error communicating with Carwash"},
		{ CARWASH_SALE_ERR, "Carwash sale not allowed"},
		{ CARWASH_QTY_ERR, "Carwash QTY sale not allowed"},
		{ PREPAID_CARD, "PREPAID CARD"},
		{ GIFT_CARD, "GIFT CARD"},
		{ ACTIVATION, "ACTIVATION"},
		{ DEACTIVATION, "DEACTIVATION"},
		{ RECHARGE, "RECHARGE"},
		{ BALQUERY, "BALANCE QUERY"},
		{ VOID_ACTIVATION, "VOID ACTIVATION"},
		{ VOID_RECHARGE, "VOID RECHARGE"},
		{ AMOUNT_STR, " AMOUNT  "},
		{ CARD_BALANCE, "CARD BALANCE  "},
		{ CARD_VALUE, "Enter Card Value:"},
		{ REFUND_DUE_CARD, "REFUND DUE"},
		{ BASIC_POP, "BASIC POP"},
		{ BASIC_CODE_POP, "BASIC+CODE POP"},
		{ REDEEM_CODE, "Pop Code Redemption"},
		{ PREPAID_FUEL, "Prepaid Fuel "},
		{ POP_DISCOUNT, "POP Discount "},
		{SELECT_CSR_PERIOD, "Select cashier period for printing report"},
		{ FREE_COUPON_TKT, "DISCRETIONARY POP DISCOUNT COUPON"},
		{ FREE_CODE_TKT, "DISCRETIONARY POP DISCOUNT CODE"},
		{ FREE_CODE, "FREE CODE = "},
		{ CODE_GRADES, "USE FOR DISCOUNT ON"},
		{ EXPIRES, "EXPIRES"},
		{ YOU_RCVD, "YOU RECEIVED"},
		{ DISCOUNT, "DISCOUNT" },
		{ DISCOUNTS, "DISCOUNTS" },
		{ DISCOUNTS_N_REBATES, "Discounts and Rebates" },
		{ GALLON, "GALLON" },
		{ LITRE, "LITRE" },
		{ GALLON_ABBV, "G" },
		{ LITRE_ABBV, "L" },
		{ DEPARTMENT, "DEPARTMENT" },
		{ MOP, "MOP" },
		{ QTY, "QUANTITY" },
		{ PRICE_OVER, "PRICE OVERRIDE" },
		{ OLD_CODE_MSG, "BY USING YOUR CODE"},
		{ YOU_SAVED, "YOU SAVED"},
		{ CODE_REJECTED, "POP CODE REJECTED"},
		{ CODE, "CODE"},
		{ UNUSED_CODE, "UNUSED"},
		{ SELECT_FLASH_REPORT, "Select Flash Report" },
		{ SELECT_PAYROLL_FUNCTION, "Select Payroll Function" },
		{ PRINT_INSTALL_HEADING, "Printing Installation Information"},
		{ PRINT_INSTALL_MESSAGE, "Printing installation information, please wait..."},
		{ FA_TITLE, "Funds Audit Report" },
		{ FA_CREATE_REPORT, "Create a Funds Audit Report?" },
		{ FA_CREATING_REPORT_WAIT, "Creating a Funds Audit Report. Please wait... " },
		{ FA_SUCCESS, "Audit info posted successfully" },
		{ FA_AUDIT_HOST_DOWN, "Unable to reach Audit host system" },
		{ FA_OPERATION_ABORTED, "Operation aborted by user"},
		{ HOUSE_ACCT_PROMPT_TITLE, "IN-HOUSE ACCOUNT" },
		{ HOUSE_ACCT_NUM_PROMPT, "Enter Account Number" },
		{ HOUSE_SUB_ACCT_NUM_PROMPT , "Enter Sub Account Number"},
		{ HOUSE_ACCT_RCPT_TITLE, "HOUSE ACCT" },
		{ HOUSE_ACCT_NUM, "ACCOUNT " },
		{ HOUSE_ACCT_NAME, "NAME " },
		{ HOUSE_SUB_ACCT_NUM, "SUB ACCT# " },
		{ HOUSE_ACCT_SIGN_LINE1, "I AGREE TO PAY ABOVE TOTAL AMOUNT" },
		{ HOUSE_ACCT_SIGN_LINE2, "X________________________________" },
		{ HOUSE_ACCT_SIGN_LINE3, "BUYER'S SIGNATURE ID " },

		{ PUMP_OVERRUN, "Pump Overrun" },
		{USE_IMPRINTER, "Use Imprinter"},
		{REMINDER, "Reminder"},
		{SAFE_DROP_CORR_ENTER_TICKET_NUM, "Enter Original Ticket #"},
		{SAFE_DROP_CORR_ENTER_REVISED_AMOUNT , "Enter Revised Amount"},
		{SAFE_DROP_CORR, "Safe Drop Correction"},
		{SAFE_DROP_CORR_PRESS_ENTER, "And Press ENTER Key"},
		{SAFE_DROP_CORR_ENTER_AMOUNT, "ENTER Amount"},
		{SAFE_DROP_CORR_HDR, "SAFE DROP CORR"},
		{READYLINK_RECHARGE, "VISA READYLINK RECHARGE"},
		{CARDLOAD_AMOUNT, "CARD LOAD AMOUNT"},
		{CARD_LOADED, "CARD LOADED"},
		{TRANSACTION_REJECTED, "  TRANSACTION REJECTED"},
		{ AUTH, "  AUTH: "},
		{ DOC_NO, "  DOC # "},
		{ REJECT_REASON, "  Reject Reason:"},
		{ CARD_LOAD_ERROR, "CARD LOAD ERROR"},
		/* Ruby error message strings. */

		{ ERRM_1100, "E1100: NO SALES FILES"},
		{ ERRM_1101, "E1101: INVALID CASHIER #"},
		{ ERRM_1102, "E1102: INVALID PASSWORD"},
		{ ERRM_1103, "E1103: INVALID DRAWER # "},       // sdrwget()
		{ ERRM_1104, "E1104: MOP INVALID/NOT ALLOWED"},
		{ ERRM_1105, "E1105: LAN UNAVAILABLE"},
		{ ERRM_1106, "E1106: USE VOID LINE / VOID TICKET"},
		{ ERRM_1107, "E1107: INVALID KEY PRESSED"},
		{ ERRM_1108, "E1108: INVALID QUANTITY"},
		{ ERRM_1109, "E1109: PRESET NOT USED"},         // skplu()

		{ ERRM_1110, "E1110: PLU TOO LONG"},            // inputplu()
		{ ERRM_1111, "E1111: INVALID PLU"},             // skplu()
		{ ERRM_1112, "E1112: ART. NOT FOR SALE"},       // skplu()
		{ ERRM_1113, "E1113: NO REFUND ALLOWED"},       // skplu()
		{ ERRM_1114, "E1114: INVALID BARCODE"},         // inputplu()
		{ ERRM_1115, "E1115: INVALID DEPARTMENT"},      // skplu()
		{ ERRM_1116, "E1116: AMOUNT TOO LARGE"},
		{ ERRM_1117, "E1117: CASH BACK NOT ALLOWED"},
		{ ERRM_1118, "E1118: NO SPLIT TENDER ON FUEL"},
		{ ERRM_1119, "E1119: OPER. NOT ALLOWED"},       // skrefund()

		{ ERRM_1120, "E1120: DO NOT OVERRIDE MOP AMOUNT"},
		{ ERRM_1121, "E1121: DISCOUNT TOO SMALL"},
		{ ERRM_1122, "E1122: DISCOUNT TOO LARGE"},
		{ ERRM_1123, "E1123: INV. FUEL QUANTITY"},
		{ ERRM_1124, "E1124: PAYROLL RECORD FULL"},     // supdclock()
		{ ERRM_1125, "E1125: INVALID CHOICE, TRY AGAIN"},
		{ ERRM_1126, "E1126: MUST CLOCK OUT FIRST"},
		{ ERRM_1127, "E1127: MUST CLOCK IN FIRST"},
		{ ERRM_1128, "E1128: FINISH TRANSACTION"},
		{ ERRM_1129, "E1129: NO FUEL DEPARTMENT"},      // skfuelsale

		{ ERRM_1130, "E1130: MOP CONFLICT"},            // skfuelsale
		{ ERRM_1131, "E1131: AMOUNT TOO SMALL"},
		{ ERRM_1132, "E1132: SUB-TOTAL REQUIRED"},      // skmop.c
		{ ERRM_1134, "E1133: ONLY REFUNDS ALLOWED"},
		{ ERRM_1134, "E1134: PENDING TRANSACTION"},
		{ ERRM_1135, "E1135: DROP MONEY FIRST"},
		{ ERRM_1136, "E1136: INVALID CATEGORY NR"},
		{ ERRM_1137, "E1137: NO FEE/CHARGES DEPT."},
		{ ERRM_1138, "E1138: INVALID MOP AMOUNT"},


		{ ERRM_1139, "E1139: INVALID AMOUNT ENTERED"},  // skpayfood.c

		{ ERRM_1140, "E1140: AMOUNT REQUIRED"},         // skmop.c

		{ ERRM_1141, "E1141: PURCH. NOT ALLOWED"},
		{ ERRM_1142, "E1142: INVALID ENTRY"},           // usused as of 6/10/94
		{ ERRM_1143, "E1143: INVALID DATE, CHECK FORMAT"}, //smdobchk.c
		{ ERRM_1144, "E1144: INVALID MODIFIER"},        // skplu.c
		{ ERRM_1145, "E1145: CASH ONLY ALLOWED  "},     // skmop.c

		// EXXON SPECIFIC
		{ ERRM_1146, "E1146: MISMATCHING INFORMATION"},
		{ ERRM_1147, "E1147: Invalid Account Number"},
		{ ERRM_1148, "E1148: Invalid account type"},
		{ ERRM_1149, "E1149: Invalid product code"},


		// CITPAK and SHELL SPECIFIC
		// 01234567890123456789
		{ ERRM_1150, "E1150: REFUND NOT ALLOWED FOR CREDIT"},
		{ ERRM_1151, "E1151: TICKET TOTALS  ZERO - Press CASH"},
		{ ERRM_1152, "E1152: NEGATIVE CHECK  AMOUNT NOT ALLOWED"},
		{ ERRM_1153, "E1153: TOTAL OVER LIMIT"},
		{ ERRM_1154, "E1154: AMOUNT INVALID WITH CR or DB"},

		{ ERRM_1155, "E1155: NO PENDING TRANSACTIONS"},
		{ ERRM_1156, "E1156: INVALID RECEIPT INFO"},
		{ ERRM_1157, "E1157: UNABLE TO SUSPEND"},
		{ ERRM_1158, "E1158: REPRINT NOT POSSIBLE"},
		{ ERRM_1159, "E1159: INVALID RECEIPT NUMBER"},
		{ ERRM_1160, "E1160: MAXIMUM PENDING TRANS. EXCEEDED"},
		{ ERRM_1161, "E1161: NO SAVED RECEIPTS"},
		{ ERRM_1162, "E1162: NEED TO SETTLE PENDING TRANS."},
		{ ERRM_1163, "E1163: NO CHANGE ALLOWED"},
		{ ERRM_1164, "E1164: REFUND NOT ALLOWED"},
		{ ERRM_1165, "E1165: FUNCTION NOT SUPPORTED"},
		{ ERRM_1166, "E1166: INVALID FUEL TRANSACTION"},
		{ ERRM_1167, "E1167: SOFT KEY NOT DEFINED"},
		{ ERRM_1168, "E1168: SALE REQUIRED"},
		{ ERRM_1169, "E1169: INVALID KEY SEQUENCE"},
		{ ERRM_8003, "MERCHANDISE OVER CREDIT LIMIT"},
		{ ERRM_8037, "E8037: CARD HAS THREE PRODUCT LIMIT"},
		{ ERRM_8038, "E8038: CARD HAS ONE FUEL PRODUCT LIMIT"},
		{ ERRM_8039, "E8039: CARD HAS TWO PROD LIMIT PLUS TAX"},
		{ ERRM_8040, "E8040 CARD HAS TWO FUEL PRODUCT LIMIT"},
		{ ERRM_8041, "E8041 CARD HAS FOUR PRODUCT LIMIT"},
		{ ERRM_8XX1, "Purchases of only 3 products allowed!"},

		// CAR WASH SPECIFIC
		{ ERRM_1170, "E1170: CARWASH QTY SALE NOT ALLOWED"},
		{ ERRM_1171, "E1171: NO CAR WASH KEY DEFINED FOR PLU"},
		{ ERRM_1172, "E1172: CAR WASH KEY NOT PROGRAMMED"},
		{ ERRM_1173, "E1173: CAR WASH COMM ERROR"},
		{ ERRM_1174, "E1174: NO CAR WASH COMM"},
		{ ERRM_1175, "E1175: LAN COMMS ERROR"},
		{ ERRM_1176, "E1176: MOP NOT ALLOWED WITH CASHBACK"},
		{ ERRM_1177, "E1177: NOT ALLOWED IN TRAINING MODE"},
		{ ERRM_1178, "E1178; CAR WASH PARM FILE READ ERROR"},
		{ ERRM_1179, "E1179: CREDIT ONLY ALLOWED"},   // skmop.c

		{ ERRM_1180, "E1180: RUBY CARD REQUIRED "},     // skmop.c
		{ ERRM_1181, "E1181: SAFEDROP NOT ALLOWED FOR MOP"},
		{ ERRM_1182, "E1182: ONLY 16 ITEMS ALLOWED"},
		{ ERRM_1183, "E1183: NOT ENOUGH CASH. CONTINUE? [Y/N]"},
		{ ERRM_1184, "E1184: NO SPLIT TENDER FOR THIS MOP"},
		{ ERRM_1185, "E1185: ONLY FUEL ALLOWED FOR THIS MOP"},
		{ ERRM_1186, "E1186: INVALID PUMP NUMBER"},
		{ ERRM_1187, "E1187: NETWORK SUSPENDED TRANSACTION"},
		{ ERRM_1188, "E1188: MOP APPLIED BEFORE"},
		{ ERRM_1189, "E1189: NO ELIGIBLE ITEM"},

		{ ERRM_1190, "E1190: MUST BE FIRST MOP"},
		{ ERRM_1191, "E1191: TOO MANY PRODUCTS"},
		{ ERRM_1192, "E1192: REFILL COIN DISP"},
		{ ERRM_1193, "E1193: CHECK COIN DISP"},
		{ ERRM_1194, "E1194: NOT ENOUGH MONEY IN DRAWER"},
		{ ERRM_1195, "E1195: NOT ALLOWED FOR AMT 0.00"},
		{ ERRM_1196, "E1196: BLUE LAW RESTRICTION"},
		{ ERRM_1197, "E1197: INVALID PRICE"},
		{ ERRM_1198, "E1198: MUST USE 'FOOD STAMP'/'NON TAX COUPON' AS FIRST MOP"},

		{ ERRM_1200, "E1200: USE VOID TICKET"},
		{ ERRM_1201, "E1201: NO AT-FOR SALES W/ FRACTIONAL QTY"},
		{ ERRM_1202, "E1202: UNSUPPORTED TRANSACTION TYPE"},

		{ ERRM_1203, "E1203: TERMINAL FULL, CLOSE DAY"},
		{ ERRM_1204, "E1204: TERMINAL FULL, CLOSE SHIFT"},
		{ ERRM_1205, "E1205: MAX # OF ADJUSTMENTS PERFORMED THIS PERIOD"},
		{ ERRM_1206, "E1206: \007 PAYROLL RECORD FULL"},
		{ ERRM_1207, "E1207: INVALID CHOICE, TRY AGAIN"},
		{ ERRM_1208, "E1208: MUST CLOCK OUT FIRST"},
		{ ERRM_1209, "E1209: MUST CLOCK IN FIRST"},

		{ ERRM_1210, "E1210: CAR WASH DOWN. CODE AVAILABLE"},
		{ ERRM_1211, "E1211: CAR WASH CODE UNAVAILABLE"},
		{ ERRM_1212, "E1212: NO DCR RECEIPT AVAILABLE"},
		{ ERRM_1213, "E1213: MANUAL CREDIT NOT ALLOWED"},
		{ ERRM_1214, "E1214: ONLY FUEL ALLOWED ON PREPAY CREDIT"},
		{ ERRM_1215, "E1215: RECEIPT PRINTER UNAVAILABLE"},
		{ ERRM_1216, "E1216: LICENSE TRACK2 EMPTY"},
		{ ERRM_1217, "E1217: LICENSE NOT SUPPORTED"},
		{ ERRM_1218, "E1218: LICENSE EXPIRED"},
		{ ERRM_1219, "E1219: LICENSE EXPIRATION DATE ERROR"},

		{ ERRM_1220, "E1220: LICENSE BIRTH DATE INVALID"},
		{ ERRM_1221, "E1221: COULD NOT FIND DATA FILE"},
		{ ERRM_1222, "E1222: UNEXPECTED EASYID ERROR"},
		{ ERRM_1223, "E1223: SCANNER NOT PDF417 DATA"},

		{ ERRM_1234, "E1234: SCANNER DATA EMPTY"},
		{ ERRM_1235, "E1235: MONEY ORDER PRINTER UNAVAILABLE NO MONEY ORDERS WILL PRINT CONTINUE Y/N?"},
		{ ERRM_1236, "E1236: FEATURE CARD NOT FOUND"},
		{ ERRM_1237, "E1237: NO MONEY ORDER PURCHASE FOR MOP"},
		{ ERRM_1238, "E1238: TOO MANY MONEY ORDERS IN SALE"},
		{ ERRM_1239, "E1239: MONEY ORDER PRINTER UNAVAILABLE"},

		{ ERRM_1242, "E1242: GET TRK 2 ERROR"},
		{ ERRM_1243, "E1243: TRK 2 READ FAIL"},
		{ ERRM_1244, "E1244: POP CODE REJECT - INVALID CODE"},
		{ ERRM_1245, "E1245: POP CODE REJECT - EXPIRED CODE"},
		{ ERRM_1246, "E1246: POP CODE REJECT - PREV REDEEMED"},

		{ ERRM_1249, "E1249: SPLIT TENDER NOT ALLOWED"},
		{ ERRM_1250, "E1250: ONLY FUEL PRODUCTS ARE ALLOWED"},
		{ ERRM_1251, "E1251: ONLY POST PAY FUEL IS ALLOWED"},

		{ ERRM_1254, "E1254: MEMBER ID CARD REJECTED"},
		{ ERRM_1255, "E1255: OPERATOR #"},
		{ ERRM_1259, "E1259: FUEL TAX EXEMPTIONS UNDEFINED"},

		// New error message for enhanced ID functionality

		{ ERRM_1260, "E1260: DISC MUST BE BEFORE EXEMPTION"},
		{ ERRM_1261, "E1261: MEMBER ID ALREADY APPLIED"},

		{ ERRM_1262, "E1262: BIRTHDATE ENTRY REQUIRED"},
		{ ERRM_1263, "E1263: ITEM REJECT- BIRTHDATE ENTRY REQ'D"},
		{ ERRM_1264, "E1264: ITEM REJECT - CASHIER ENTRY REQ'D"},

		{ ERRM_1265, "E1265: MEMBER ID REJECT - MAN ENTRY"},
		{ ERRM_1266, "E1266: FUEL TAX ALREADY ADDED"},
		{ ERRM_1267, "E1267: SPLIT TENDER NOT ALLOWED WITH FUEL PREPAY"},
		{ ERRM_1268, "E1268: CANNOT CYCLE THROUGH PLU MODIFIERS"},
		{ ERRM_1270, "E1270: DISC NOT ALLOWED WITH PROMO"},
		{ ERRM_1273, "E1273: FUEL TAX NOT ALLOWED WITH % DISC"},
		{ ERRM_1283, "E1283: SUSPEND WITH FUEL INVALID"},
		{ ERRM_1294, "E1294: NO MOP CONFIGURED FOR SAFE DROP"},
		{ ERRM_1295, "E1295: MENU NOT DEFINED"},

		{ ERRM_7026, "E7026: BAD DAY"},
		{ ERRM_7027, "E7027: BAD MONTH"},
		{ ERRM_7028, "E7028: BAD YEAR"},
		{ ERRM_7041, "E7041: MONEY ORDER COMM ERROR"},
		{ ERRM_7042, "E7042: MONEY ORDER AMOUNT TOO LARGE"},

		{ ERRM_1300, "E1300: EXPIRED COUPON"},
		{ ERRM_1301, "E1301: COUPON NOT VALID WITH THIS TRANSACTION"},
		{ ERRM_1302, "E1302: COUPON REJECTED - DATE NOT YET VALID"},
		{ ERRM_1303, "E1303: FRACTIONAL QUANTITY SALE DISALLOWED"},

		//new error messgae for PLU promo discount.
		{ ERRM_1304, "E1304:PROMO EXCEEDS PLU PRICE"},

		//newly added for scanned coupon
		{ SCANNED_COUPON_HDR, "Scanned Coupon"},
		{ ENTER_COUPON_DISC_AMT, "Verify required purchases. Enter value of the Coupon"},
		{ ADDITIONAL_ITEM_CANT_BE_ADDED, "Additional items cannot be added after coupons are scanned."},
		{ COUPON_SCANNING_DISABLED, "Coupon Scanning Disabled"},
		//newly added for scanned coupon

		{ ERRM_1417, "E1417: POSTPAY NOT ALLOWED"},
		{ ERRM_1419, "E1419: TOO MANY ACTIVE PUMPS"},

		// Loyalty messages
		{ ERRM_1296, "E1296: NO MULTIPLE LOYALTY PPU DISCOUNTS IN SALE"},
		{ ERRM_1297, "E1297: FUNCTION NOT VALID AFTER LOYALTY"},
		{ LOYALTY_UNDERRUN_OVERRUN, "LOYALTY: NO OTHER ITEMS WITH LOYALTY PREPAY UNDERRUN/OVERRUN"},
		{ ERRM_1312, "E1312: ONLY 1 PREPAY PER TRANS ALLOWED" },
		{ ERRM_9040, "E9040: UNABLE TO STORE FUEL PREPAY TRANS" },

		//EPSPrepaid messages
		{ PRODUCT_CODE_MISMATCH, "PREPAID: PRODUCT CODE MISMATCH"},
		{ PREPAID_DEP_NOT_AVAILABLE, "PREPAID: DEPT: CONFIGURATION NOT AVAILABLE"},
		{ EVALUATION_FAILED, "PREPAID: EVALUATION FAILED"},
		{ REFUND_FAILED, "PREPAID: REFUND FAILED"},
		{ MUST_COMPLETE_REFUND, "PREPAID: OPER NOT ALLOWED - MUST COMPLETE REFUND"},

		// System Error Messages

		{ ERRM_1199, "E1199: \007ERROR: %.8s-%d #%d"},


		{ RECALL_TXN, "Preview / Recall Transaction"},
		{ REPRINT_TXN, "Preview / Reprint Transaction"},
		{ FUELONLY_REPRINT_TXN, "Fuel-only Receipt Reprint"},
		{ PURGE_ORDER, "Purge Food Order"},
		{ CLAIM_ORDER, "Claim Food Order"},
		{ CHOOSE_ORDER, "Choose a food order"},
		{ INCLUDES, "Includes"},
		{ AMOUNT, "Amount"},
		{ TAXABLE, "Taxable"},
		{ VAT_INCLUDED, "VAT INCLUDED"},
		{ CONTINUE_OK, "CONTINUE? (Y/N)"},
		{ QUARTS_OF_OIL, "NUMBER OF QUARTS OF OIL PURCHASED:"},
		{ SD_ELIGIBLE, "ELIGIBLE TOTAL" },
		{ SERVER_UNREACHABLE, "Error communicating with server"},
		{ COUPON_DISC_NAME, "Coupon"},
		{ PAYROLL_FNS_TITLE, "Payroll Functions"},
		{ NO_PENDING_FOOD_ORDERS, "No pending food orders"},
		{ PAYROLL_FNS, "Clock In/Out"},
		{ CLOCK_IN, "Clock In"},
		{ CLOCK_OUT, "Clock Out"},
		{ CHANGE_JOB_CODE, "Change Job Code"},
		{ ENTER_JOB_CODE, "Enter Job Code"},
		{ JOB_CODES, "Job Codes"},
		{ JOB_CODE, "Job Code"},
		{ SELECT_JOB_CODE, "Select Job Code"},
		{ PAYROLL_CASHIER_LINE, "CASHIER# {0} at {1}"},
		{ PAYROLL_TXN_FOOTER, " REG# {0} CSH# {1}    TRAN# {2}"},
		{ STORE_NUM_FOOTER, "ST#"},
		{ HOURS, "HOURS"},
		{ TIME_IN, "TIME IN"},
		{ TIME_OUT, "TIME OUT"},
		{ ENDING, "ENDING"},
		{ JOB, "JOB"},
		{ TOTAL_HRS_LINE1, "TOTAL"},
		{ PLEASE_WAIT, "Please wait"},
		{ DATA_ERROR, "Data Retrieval Error"},
		{ CODEBASE_CGI_ERROR, "Codebase CGI Error" },
		{ SAFEDROP_REQUIRED, "SAFE DROP REQUIRED" },
		{ CONFIGURED_TO_ALLOWSAFEDROP, "  mop must be configured to allow Safe Drop"},
		{ TAX_EXEMPT, "TAX EXEMPT"},
		{ SUSPENDED_ALARM, "{0} RECEIPT(S) PENDING"},
		{ PENDING_KIOSK_ALARM, "{0} KIOSK ORDER(S) PENDING"},
		{ PENDING_FC_ALARM, "{0} FAST CREDIT(S) PENDING"},

		{ KITCHENPRINTER_OFFLINE, " Printer is OFFLINE" },
		{ KITCHENPRINTER_NEAREMPTY, " Printer is NEAR EMPTY" },
		{ KITCHENPRINTER_EMPTY, " Printer is EMPTY" },
		{ KITCHENPRINTER_COVEROPEN, " Printer COVER OPEN" },
		{ KITCHENPRINTER_RMIDOWN, " RMI Service DOWN" },
		{ KITCHENPRINTER_RMIUP, " RMI Service UP" },

		{ BALANCE_INQUIRY, "BALANCE INQUIRY"},
		{ ESAFE_PROMPT_TITLE, "Electronic Safe Drop" },
		{ ESAFE_LOAN_PROMPT_TITLE, "Electronic Safe Loan" },
		{ ESAFE_ELECTRONIC_PROMPT, "Is this an Electronic Safe drop? (Y/N)" },
		{ ELECTRONIC_ESAFE_LOAN_PROMPT, "Is this an Electronic Safe Loan (Y/N)" },
		{ ESAFE_ID_PROMPT, "Please choose safe ID" },
		{ ESAFE_INVALID_ID, "Invalid Safe ID" },
		{ ESAFE_ID, "SafeID: "},
		{ NAME, "Name: "},
		{ ESAFE_COMM_IN_PROG, "Communicating with Safe"},
		{ FLASH_CATEGORY_REPORT_TITLE, "CATEGORY REPORT"},
		{ FLASH_DEPARTMENT_REPORT_TITLE, "DEPARTMENT REPORT"},
		{ FLASH_NETWORK_REPORT_TITLE, "NETWORK CARD REPORT"},
		{ FLASH_ASA_MOBILE_REPORT_TITLE_LINE1, "MOBILE PAYMENT REPORT"},
		{ FLASH_ASA_MOBILE_REPORT_TITLE_LINE2, "(Collected By Host)"},
		{ FLASH_PLU_REPORT_TITLE, "PLU REPORT"},
		{ FLASH_PROPCARD_REPORT_TITLE, "PROPRIETARY CARD RPT"},
		{ FLASH_PROPPROD_REPORT_TITLE, "PROPRIETARY PROD RPT"},
		{ FLASH_SUMMARY_REPORT_TITLE, "SUMMARY REPORT"},
		{ FLASH_TANK_REPORT_TITLE, "TANK REPORT"},
		{ FLASH_CASH_ACCEPTOR_REPORT_TITLE, "CASH ACCEPTOR REPORT"},
		{ FLASH_TANKREC_REPORT_TITLE, "TANK RECONCILIATION"},
		{ FLASH_TIERPRODUCT_REPORT_TITLE, "TIER/PR REPORT"},
		{ NETWORK_TOTAL_REPORT_TITLE, "NETWORK TOTALS REPORT"},
		{ CW_REPORT_TITLE, "CARWASH PAY POINT"},
		{ ESAFE_REPORT_TITLE, "E-SAFE DAY REPORT"},
		{ FUEL_STREET_PRICE_TITLE1, "FUEL STREET PRICE"},
		{ FUEL_STREET_PRICE_TITLE2, "CHANGE REPORT"},
		{ NO_DATA_AVLBLE, "No Data Available"},

		{ COIN_DISPENSER_NAME, "Coin Dispenser"},
		{ PINPAD_NAME, "PinPad"},
		{ POLE_DISPLAY_NAME, "Pole Display"},
		{ PRINTER_NAME, "Receipt Printer"},
		{ SCANNER_NAME, "Scanner"},
		{ CHECK_SCANNER_NAME, "Check Scanner"},
		{ DVR_JOURNAL_NAME, "DVR Journal"},
		{ KITCHEN_PRINTER_NAME, "Kitchen Printer"},

		{ SERIAL_PORT_SETUP, "Serial Port Setup"},
		{ AVAILABLE_DEVICES, "Available Devices"},
		{ CASH_DRAWER_SETUP, "Cash Drawer Port Setup"},

		{ DEVICE_SAVE_BTN, "Save"},
		{ DEVICE_QUIT_BTN, "Quit"},
		{ DEVICE_REBOOT_BTN, "Reboot"},
		{ DEVICE_BAUD_BTN, "Baud"},
		{ DEVICE_PORT_BTN, "Port"},
		{ SELECT_OPTION, "Select Option"},
		{ ENTER, "ENTER"},
		{ EXIT, "EXIT"},
		{ REPORT_FUNCTIONS, "REPORT FUNCTIONS"},
		{ NETWORK_FUNCTIONS, "NETWORK FUNCTIONS"},
		{ FUEL_FUNCTIONS, "FUEL FUNCTIONS"},
		{ MAINTENANCE_FUNCTIONS, "MAINTENANCE FUNCTIONS"},
		{ EMPLOYEE, "EMPLOYEE"},
		{ SALES, "SALES"},
		{ REGISTER, "REGISTER"},
		{ VOID_LINE, "Void Line"},
		{ CHANGE_QTY, "Change Qty"},
		{ CHANGE_PRICE, "Change Price"},
		{ ADD_TAX_EXEMPT, "Add Tax Exempt"},
		{ FIXED_DISCOUNT, "Fixed Discount"},
		{ DOLLAR_DISCOUNT, "  Discount"},
		{ PERCENT_DISCOUNT, "% Discount"},
		{ MANUAL_DISCOUNT, "Discount"},
		{ MODIFY, "Modify"},
		{ JPOS_PRINTER, "Printer"},
		{ JPOS_RECEIPT_PRINTER_S, "Rcpt Ptr"},
		{ JPOS_RECEIPT_PRINTER_L, "Receipt Printer"},
		{ JPOS_JOURNAL_PRINTER_S, "Jrnl Ptr"},
		{ JPOS_JOURNAL_PRINTER_L, "Journal Printer"},
		{ JPOS_SLIP_PRINTER_S, "Slip Ptr"},
		{ JPOS_SLIP_PRINTER_L, "Slip Printer"},
		{ JPOS_ONLINE, "ONLINE"},
		{ JPOS_OFFLINE, "OFFLINE"},
		{ JPOS_PTR_NEAREMPTY, "Paper Low"},
		{ JPOS_PTR_EMPTY, "No Paper"},
		{ JPOS_PTR_COVEROPEN, "COVER OPEN"},
		{ JOURNAL_PRINTER_DISABLED, "Journal Printer Disabled"},
		{ JOURNAL_PRINTER_OFFLINE, "Journal Printer Offline"},
		{ JOURNAL_PRINTER_PAPER_EMPTY, "Journal Printer Paper Empty"},
		{ JOURNAL_PRINTER_PAPER_LOW, "Journal Printer Paper Low"},
		{ JPOS_PTR_UNAVAILABLE, "Unavailable"},
		{ JPOS_PTR_UNAUTHORIZED, "UNAUTHORIZED"},
		{ PRINTER_PAPER_OK, "PRINTER PAPER OK"},
		{ PRINTER_COVER_CLOSED, "PRINTER COVER CLOSED"},
		{ SECONDARY_SCANNER_NAME, "Secondary Scanner"},
		{ DOB_SKIPPED, "SKIPPED" },
		{ DOB_FAILED, "FAILED" },
		{ PREPAY_PRODUCT, "Product: " },
		{ PREPAID_RECEIPT_TEXT, "***PREPAID RECEIPT***" },
		{ PREAUTH_RECEIPT_TEXT, "***PRE-AUTHORIZED RECEIPT***" },

		//TidelEsafe
		{ SAFE_DROP_INSERT_BILLS, "Insert Bills"},
		{ SAFE_DROP_VAULT_DROP, "Vault Drop"},
		{ SAFE_LOAN_VEND_TUBE, "Vend Tube"},
		{ SAFE_LOAN_DISPENSE_COMBO, "Dispense Combo"},
		{ SAFE_LOAN_DISPENSE_COINS, "Dispense Coins"},
		{ SAFE_LOAN_DISPENSE_NOTES, "Dispense Cash"},
		{ ESAFE_DROP_MENU, "Electronic Safe Drop Menu"},
		{ ESAFE_LOAN_MENU, "Electronic Safe Loan Menu"},
		{ ESAFE_LOAN_COIN_DENOMINATION, "Choose Coin Denomination"},
		{ ESAFE_LOAN_NOTE_DENOMINATION, "Choose Note Denomination"},
		{ ESAFE_PROMPT_INSERT_BILLS, "Proceed to E-Safe to Insert Bills through Bill Acceptor"},
		{ ESAFE_PROMPT_VAULT_DROP, "Proceed to E-Safe to complete the Vault Drop"},
		{ ESAFE_PROMPT_VEND_TUBE, "Proceed to E-Safe to complete the Vend Tube"},
		{ PROCEED_WITH_NON_ELECTRONIC_SAFEDROP, "Proceed With Non-electronic SafeDrop"},
		{ SELECT_MOP_KEY, "And Select MOP Key"},
		{ ENTER_MEDIA_COUNT, "Enter Media Count"},
		{ ENTER_ENVELOP_NUMBER, "Enter Envelope Number"},
		{ MAX_ENVELOP_NUMBER_LEN, "Maximum Length "},
		{ SAFE_DROP_INSERT_BILLS_CMPLTED_SUCCESS, "INSERT BILLS COMPLETED SUCCESSFULLY"},
		{ SAFE_DROP_VAULT_DROP_CMPLTED_SUCCESS, "VAULT DROP COMPLETED SUCCESSFULLY"},
		{ SAFE_LOAN_VEND_TUBE_CMPLTED_SUCCESS, "VEND TUBE COMPLETED SUCCESSFULLY"},
		{ SAFE_LOAN_DISPENSE_COINS_CMPLTED_SUCCESS, "DISPENSE COINS COMPLETED SUCCESSFULLY"},
		{ SAFE_LOAN_DISPENSE_NOTES_CMPLTED_SUCCESS, "DISPENSE NOTES COMPLETED SUCCESSFULLY"},
		{ SAFE_LOAN_DISPENSE_COMBO_CMPLTED_SUCCESS, "DISPENSE COMBO COMPLETED SUCCESSFULLY"},
		{ NO_CASHIER_TOTALS, "TIDEL SENTINEL DOES NOT SUPPORT E-SAFE CASHIER TOTALS"},
		{ ENTER_DENOMINATION, "Enter Denomination"},
		{ PROCEED_WITH_NON_ELECTRONIC_SAFELOAN, "Proceed With Non-electronic SafeLoan"},
		{ PROCEED_WITH_NON_ELECTRONIC_SAFEDROP_YN, "Proceed With Non-electronic SafeDrop(Y/N)"},
		{ PROCEED_WITH_NON_ELECTRONIC_SAFELOAN_YN, "Proceed With Non-electronic SafeLoan(Y/N)"},
		{ ENTER_COUNT, "Enter Count"},
		{ ENTER_ANOTHER_DENOMINATION, "Do you want to enter another Denomination ?"},
		{ USER_UNKNOWN, "Unknown User"},
		{ DEVICE_UNAVAILABLE, "Device Unavailable"},
		{ INTERNAL_ERROR, "Error Communicating with ESafe"},
		{ REMOTE_SERVER_DOWN, "Unable to communicate with Server."},
		{ REMOTE_SERVER_INVALID_RESPONSE, "Invalid response from server."},
		{ ESAFE_NOT_INITIALIZED, " ESafe Not Configured"},
		{ CANNOT_PROCEED, "Cannot Proceed Now"},
		{ DEVICE_BUSY, "Device Busy"},
		{ LOCK_FAILED, "Failed Acquiring Lock on ESafe"},
		{ LOCK_EXPIRED, "Lock Expired"},
		{ CANNOT_PROCEED_NO_HW, "Operation not Supported by ESafe"},
		{ ENTER_AMOUNT_AGAIN, "Enter a Valid Amount"},
		{ CHOOSE_MOP, "Choose an MOP"},
		{ VAULT_DROP_TIMED_OUT, " Vault Drop Operation Timed Out"},
		{ INSERT_BILLS_TIMED_OUT, "Insert Bills Operation Timed Out"},
		{ CANNOT_PROCEED_CUP_NOT_EMPTY, "Hopper not Empty.Remove Coins from Hopper First"},
		{ OPRN_CANCELLED_AT_ESAFE, "Operation Cancelled at ESafe"},
		{ MALFUNCTION_ON_VEND_TUBE, "Unable to complete Vend Tube Oprn at ESafe"},
		{ MALFUNCTION_ON_DISPENSE_COMBO, "Unable to complete Dispense Combo Oprn at ESafe"},
		{ MALFUNCTION_ON_DISPENSE_COINS, "Unable to complete Dispense Coins Oprn at ESafe"},
		{ MALFUNCTION_ON_DISPENSE_NOTES, "Unable to complete Dispense Notes Oprn at ESafe"},
		{ CANNOT_PROCEED_ON_EOD, "Cannot Proceed with EndOfDay"},
		{ EOS_FAILED, "End of Shift Failed"},
		{ INVALID_INPUT, "Invalid Input"},
		{ PRICE_CHECK_EXCEPTION, "Error occurred during price check"},
		{ CASHIER_ESAFE_DATA_UNAVAILABLE, "CASHIER ESAFE DATA UNAVAILABLE"},
		{ CASHIER_ESAFE_REPORT, "CASHIER ESAFE REPORT"},
		{ E_SAFE_ID, "*** E-SAFE ID "},
		{ TOTALS, "*** TOTALS"},
		{ CASHIER_TOTALS_FOR, "CASHIER TOTALS FOR "},
		{ E_SAFE_DROPS, "E-SAFE DROPS"},
		{ ENVELOPE_DROPS, "Envelope Drops"},
		{ TOTAL_ENVELOPE_DROPS, "  Total Envelope Drops "},
		{ TOTAL_ENV_DROPS, "  Total Env Drops "},
		{ BILL_ACCEPTOR_DROPS, "Bill Acceptor Drops "},
		{ TOTAL_ESAFE_DROPS, "  TOTAL E-SAFE DROPS"},
		{ ESAFE_LOANS, "E-SAFE LOANS"},
		{ TOTAL_TUBES_VENDED, "  Total Tubes Vended "},
		{ TOTAL_POS_DROPS, "  TOTAL POS DROPS"},
		{ POS_SAFE_DROPS, "POS SAFE DROPS"},
		{ POS_SAFE_LOANS, "POS SAFE LOANS"},
		{ TOTAL_COINS_DISPENSED, "  Total Coins Dispensed "},
		{ TOTAL_ESAFE_LOANS, "  TOTAL E-SAFE LOANS"},
		{ UNRECOGNIZED_BILLS, "UNRECOGNIZED BILLS"},
		{ UNVERIFIED_CASH_RATIO, "UNVERIFIED CASH RATIO"},
		{ TOTAL_POS_LOANS, "  TOTAL POS LOANS" },
		{ RECONCILIATION, "E-SAFE / POS RECONCILIATION"},
		{ ESAFE, "             E-SAFE"},
		{ POS, "POS"},
		{ DIFF, "DIFF"},
		{ SAFE_DROPS, " SAFE DROPS"},
		{ SAFE_LOANS, " SAFE LOANS"},
		{ ESAFE_DATA_UNAVAILABLE, "ESAFE DATA UNAVAILABLE"},
		{ ESAFE_DEVICE_DAY, "E-SAFE DEVICE DAY:   "},
		{ ESAFE_SHIFT_RANGE, "E-SAFE SHIFT RANGE:  "},
		{ ESAFE_MOP_NOT_SUPPORTED, "MOP not supported by ESafe"},
		{ ESAFE_EOD_COMM_FAIL, "Unable to retrieve financial data from ESafe on Close Daily"},
		{ ESAFE_EOD_LOCK_FAIL, "Unable to Communicate with ESafe on Close Daily"},
		{ ESAFE_COMM_FAIL_ON_CURRENT_CONTENTS, "Unable to Communicate with ESafe for generating Content Report"},
		{ ESAFE_OPRN_CANCELLED, "Electronic Safe Loan Cancelled by User"},
		{ RESET_EXTERNALINPUTALARM_FLAG, "Reset External Input Alarm Flag in TLS"},
		{ RESET_TANKALARM_TANKNUMBER, "Reset Tank Alarm For a Tank"},
		{ RESET_TANKALARM, "Reset Tank Alarm"},
		{ ENTER_TLS_TANK_NO, "Enter Tank Number for TLS to Reset(0 to select all tanks)"},
		{ ENTER_ALARM_FLAG, "Enter the Alarm Flag for TLS to reset"},
		{ RESET_EXTERNAL_FLAG, "Clear External input in TLS?"},
		{ CLEAR_EXTERNAL_INPUT, "Press YES or <ENTER> to continue"},
		{ INVALID_TANK_SELECTION, "SORRY!!.Selection of a tank number to reset tank alarm "},
		{ BAD_SELLABLE, "Bad Sellable"},
		{ DEVICE_COMM_EXCEPTION, "Device Comm Exception"},
		{ NO_SALE_ALLOWED, "No Sale Allowed"},
		{ PLU_NOT_FOUND_EXCEPTION, "PLU [" + "{0}" + "] not found"},
		{ AEOD_FAILED, "Auto End of Day Failed"},
		{ AEOD_INITIATE_AN_END_OF_DAY_MANUALLY, "Initiate an End of Day manually"},
		{ ENABLE_CARWASH, "Enable Car Wash"},
		{ DISABLE_CARWASH, "Disable Car Wash"},
		{ ENABLE_LOGIN, "Enable Helpdesk Login"},
		{ DISABLE_LOGIN, "Disable Helpdesk Login"},
		{ GENERATE_SECURE_OTP, "Generate Config OTP" },
		{ DELETE_SECURE_OTP, "Delete Config OTP" },
		{ LOGIN_FUNC_FAILURE, "Unable to exercise login functionality"},
		{ LOGIN_TOKEN, "Login Token: "},
		{ OTP_STR, "OTP: " },
		{ UPLINK_VPN, "Uplink: " },
		{ ENABLE_LOGIN_SUCCESS_MSG, "Helpdesk Login enabled Successfully"},
		{ DISABLE_LOGIN_SUCCESS_MSG, "Helpdesk Login disabled Successfully"},
		{ OTP_GENERATED_SUCCESS_MSG, "OTP Generated Successfully" },
		{ OTP_DELETED_SUCCESS_MSG, "OTP Deleted Successfully" },
        { MNSP_VPN_NOT_ESTABLISHED, "Remote connection not established"},
		{ ERRM_1271, "E1271"},
		{MO_1234, "MO1234"},
		{ESAFE_NOT_FOUND, " Esafe Not Configured "},
		{MOBILE_PAYMENT_UNAVAILABLE, "MOBILE: MOBILE PAYMENT NOT ACCEPTED"},
		{REBOOT_POS_SHORT_MSG, "Reboot POS"},
		{REBOOT_POS_DETAILED_MSG, "Reboot POS to switch the UI layout"},
		{EXCEPTION_REPRINT, "Exception Reprint"},

		// iOrder
		{FOOD_SERVICE_HDR, "FOOD SERVICE"},
		{KIOSK_UNAVAILABLE, "iOrder  Unavailable"},
		{FALLBACK_WITH_KP, "Order redirected to POS kitchen Printer"},
		{PRINTING_FOOD_ORDER_FOR_KITCHEN_PREP, "Printing Food Order for kitchen preparation"},
		{FEATURE_NOT_SUPPORTED, "Not Supported at iOrder"},
		{KIOSK_COMM_FAILURE, "Error communicating with Kitchen Display"},
		{PRINT_FOOD_SVC_PMNT_TICKET, "Printing FoodSvc payment ticket"},
		{FOOD_SVC_ORDER_PMNT_RECEIPT_HDR, "Food Service Order Payment"},
		{PAID_STATUS, "PAID"},
		{DUE_STATUS, "PAYMENT DUE"},
		{LISTEN_TICKET_NUMBER, "Please listen for your number"},
		{PICKUP_TICKET_NUMBER, "Your Pickup # is"},
		{LOCATION_ID, "LOCATION ID"},
		{STORE_NUMBER, "STORE#"},
		{ CONFIG_MANAGER_TITLE  , "Configuration Manager"},
		{ KBD_CONN  , "Keyboard is connected"},
		{ KBD_NOT_CONN  , "Keyboard is not connected"},
		{ KBD_CONN_MESSAGE  , "Please do not remove keyboard until you exit from Configuration Manager"},
		{ KBD_NOT_CONN_MESSAGE  , "Configuration Manager will be opened with virtual keyboard"},
		{ USER_PROMPT, "Do you want to proceed?"},
		{ REGISTER_DCR, "Register DCR"},
		{ INCREMENT_DCR_KEY, "Advance DCR Key"},
		{ UPDATE_DCR_SETTINGS, "Update DCR Settings"}, 
		{ TAVE_DCR_SETTINGS, "TAVE Configuration"},
		{ENABLE_UNATTENDED, "Enable Unattended Mode"},
		{DISABLE_UNATTENDED, "Disable Unattended Mode"},
		{SCHEDULE_UNATTENDED, "Follow Unattended Schedule"},
		{UNATTENDED_MENU, "Unattended Mode Menu"},
		{ ENTER_DCR_NUM, "Enter DCR Number"},
		{ PERIOD_CLOSE_CANCELED_BY, "Period close was cancelled by "},
		{ UNACKNOWLEDGED_CLOSE_BY, "Period close was unacknowleged by "},
		{ FAILURE_REASON, "Failure Reason: "},
		{ADVANCED_OPTIONS_SELECTION_IMAGE_FILE, "GfxResources/UnusedBlue.jpg"},
		{ENTER_OPEN_DRAWER_AMOUNT        , "Enter Open Drawer Amount"},
		{UPDATING_SCREEN_CONFIG          , "Updating screen config"},
		{INCLUDED_IN_PRICE               , "Included in Price"},                   
		{M_O_SERIAL_NUMBER               , "M.O. Serial Number"}, 
		{TAX_ON_REBATE_OF                , " Tax on Rebate of "},  
		{SECURITY_CANCEL, "Verification Cancelled"},
		{AUTO_FREE_POP_TITLE, "AutoGenerate POP Codes"},
		{AUTO_FREE_POP_DEF, "DEF"},
		{AUTO_FREE_POP_PFDD, "POP Fuel Discount Definition"},
		{AUTO_FREE_POP_SFD, "Select Fuel Discount Definition"},
		{AUTO_FREE_POP_QTY, "Enter Quantity of Codes Needed"},
		{AUTO_FREE_POP_FOR, "for"},
		{AUTO_FREE_POP_GEN, "Generate"},
		{AUTO_FREE_POP_GTING, "Generating"},
		{AUTO_FREE_POP_CODES, "Codes"},
		{AUTO_FREE_POP_COMPL, "Process Complete"},
		{AUTO_FREE_POP_TLOG, "Codes have been posted to TLog"},
		{ EDIT_FOOD_ORDER, "EDIT FOOD ORDER"},
		{ REM_KIOSK_ORDER, "Remove kiosk order"},
		{ DINE_IN_QUESTION, "DINE IN ?"},
		{SELECT_DIAG_TYPE, "Select Diagnostics Type "},
		{HELP_DIAGNOSTICS_MENU, "Helpdesk Diagnostics Menu"},
		{HELP_DIAGNOSTICS, "Helpdesk Diagnostics"},
		{GENERAL, "General"},
		{FORECOURT, "Forecourt"},
		{PAYMENT, "Payment"},
		{MNSP, "MNSP"},
		{ERRM_PLACE_ORDER_CANCELLED, "PLACE ORDER skipped - No new FS items to send to kitchen"},
		{ERRM_VOID_LINE_CANCELLED, "'Void' OPERATION ON SENT FOOD SERVICE LINES NOT ALLOWED"},
		{YOUR_PICKUP_IS                  , "Your Pickup # is"}, 
		{LANGUAGE_MENU                   , "Language Menu"}, 
		{SELECT_LANGUAGE                 , "Select Language"}, 
		{PINPAD_CONFIGURATION            , "Pinpad Configuration"}, 
		{SELECT_INSTALLED_PINPAD         , "Select Installed Pinpad - ["}, 
		{CURRENTLY_CONFIGURED            , "] currently configured"}, 
		{SCANNER_CONFIGURATION           , "Scanner Configuration"}, 
		{SELECT_INSTALLED_SCANNER        , "Select Installed Scanner - ["}, 
		{PRINT_CASHIER_REPORT            , "Print Cashier Report"}, 
		{ENTER_END_DRAWER_AMOUNT_FOR     , "Enter End Drawer Amount for"}, 
		{ENTER_PUMP_NUMBER               , "Enter pump number"}, 
		{GROUPED_ITEM_MENU               , "Grouped Item Menu"}, 
		{MODIFIER_MENU                   , "Modifier Menu"},
		{OPER_NOT_ALLOWED                , "OPER NOT ALLOWED"},
		{TKT_NO_INFO, "No Info"},
		{TKT_MO_SERIAL, "M.O. Serial#: "},
		{TKT_IN_HOUSE_ACCT, "IN HOUSE ACCT"},                
		{TKT_MONEY_ORDER, "MONEY ORDER"},
		{TKT_SUB_ACCT, "SUB ACCT# "},
		{TKT_CSH, "CSH:"},
		{TKT_SAFE_DROP_TRANS, "Safe Drop Trans#"},
		{TKT_BOTTOM, "ST#          TILL XXXX DR#  TRAN#"},
		{TKT_ATT_BOTTOM, "ST#          REG#           TRAN#"},
		{TKT_PAYMENT_DUE, "*** PAYMENT DUE ***\n\n"},
		{TKT_TRAN, "TRAN# "},
		{TKT_ADDT_LOYALTY_DISC, "Additional Loyalty Disc"},
		{TKT_REDEEM_LOYALTY_DISCOUNT, "Redeemed Loyalty Disc"},   
		{TKT_TAX_ON, " Tax on  "},
		{TKT_REBATE_OF, " Rebate of "},  
		{TKT_EA, "EA"},
		{TKT_FEE, "*FEE*"},
		{TKT_PRO, "*PRO*"},
		{TKT_GALLONS, " GALLONS"},
		{TKT_LITRES, " LITRES"},
		{TKT_FOR, "FOR "},
		{TKT_FUEL_DISCOUNT, "Fuel Discount"},

		// OTP Related messages.
		{OTP_REQUIRED, "OTP REQUIRED"},
		{PLEASE_ENTER_OTP, "Please enter OTP"},
		{GENERATE_OTP_MSG1, "Go to Maintenance menu to generate OTP"},
		{GENERATE_OTP_MSG2, "Maintenance -> Generate Config OTP"},
		{GENERATE_CONFIG_OTP, "Generate Config OTP"},
		{DELETE_CONFIG_OTP, "Delete Config OTP"},
		{FUEL_RCF_CONFIGURATION, "RC Fuel Config."},
		{SELECT_RCF_CONFIGURATION, "Select Rapid Change Fuel Configuration" },
		{RCF_MENU_NAME, "Rapid Change Fuel Configuration Menu" },
		{RCF_NOT_CONFIGURED, "Error: Rapid Change Fuel Configuration Not Configured!"},
		{RCF_CURRENT_SELECTION, " - Current Selection"},
		{RCF_SELECTED, "''{0}'' Selected"},
		{RCF_INIT_SUCCESS, "Rapid Change Fuel Configuration Initialization Successful"},
		{RCF_FORCE_INIT, "Price Display Offline. Proceed With Fuel Initialization"},
		{FUEL_INITIALIZATION_PENDING, "Fuel Initialization Pending ..."},
		{ENTER_CURRENT_DRAWER_AMOUNT, "Enter Current Drawer Amount for "},
		{ZERO_NOT_ALLOWED, "Zero not Allowed"},
		{CLOSED, "closed:"},
		{OPEN_DRAWER, "Open Drawer"},
		{DO_YOU_WANT_TO_OPEN_CONNECTED_DRAWERS, "Do you want to open connected drawers?"},
		{INVALID_CASHIER_NUMBER_OR_NO_PERIOD_AVAILABLE_FOR, "Invalid cashier number or no period available for the cashier"},
		{DISCOUNT_SELECTION, "Discount Selection"},
		{TOUCH_TO_MODIFY, "Touch-to-modify"},
		{ENTER_NEW_PRICE, "Enter New Price"},
		{ENTER_NEW_QUANTITY, "Enter New Quantity"},
		{REMOTE_SERVER_IS_DOWN, "Remote server is down!"},
		{REMOTE_SERVICE_IS_DOWN, "Remote service is down!"},
		{ERROR_IN_PROCESSING_REQUEST, "Error in processing request"},
		{PINPAD_1, "PINpad ["},
		{CONFIGURED_1, "] configured"},
		{SCANNER_1, "Scanner ["},

		{TOPAZ_RPT_NAME_UNAVAILABLE, "-NAME UNAVAILABLE-"}, 
		{TOPAZ_RPT_CURRENT_PAYROLL_REPORT, "CURRENT PAYROLL REPORT"},
		{TOPAZ_RPT_CLOSE_PAYROLL_REPORT, "CLOSE PAYROLL REPORT"},
		{TOPAZ_RPT_PREVIOUS_PAYROLL_REPORT, "PREVIOUS PAYROLL REPORT"},
		{TOPAZ_RPT_EMPLOYEE_SIGNATURE, "EMPLOYEE SIGNATURE"},
		{TOPAZ_RPT_MANAGER_SIGNATURE, "MANAGER SIGNATURE"},
		{TOPAZ_RPT_CASHIER, " CASHIER #"},
		{TOPAZ_RPT_ATTENDANT, "ATTENDANT #"},
		{TOPAZ_RPT_ATTENDANT_CARD, "ATTENDANT CARD #"},
		{TOPAZ_RPT_CASHIER_WORKSHEET, "CASHIER WORKSHEET"},
		{TOPAZ_RPT_AMOUNTS_AT_CLOSE, "AMOUNTS AT CLOSE"},
		{TOPAZ_RPT_CASHIER_TRACKING, "CASHIER TRACKING"},
		{TOPAZ_RPT_CASHIER_TRACKING_DATA_UNAVAILABLE, "CASHIER TRACKING DATA UNAVAILABLE"},
		{TOPAZ_RPT_PLU_TRACKING, "------------- PLU TRACKING -------------"},
		{TOPAZ_RPT_PLU_NUMBER_DESCRIPTION, "PLU NUMBER          DESCRIPTION         "},
		{TOPAZ_RPT_QTY_EXT_QTY_AMOUNT, "      QTY     EXT QTY       AMOUNT      "},
		{TOPAZ_RPT_TOTALS_WITH_DASH, "---TOTALS-------------------------------"},
		{TOPAZ_RPT_DEPARTMENT_TRACKING, "--------- DEPARTMENT TRACKING ----------"},
		{TOPAZ_RPT_DEPT_DESCRIPTION_ITEMS, "DEPT#   DESCRIPTION                ITEMS"},
		{TOPAZ_RPT_GROSS_REFUNDS_DISCOUNT_NET, "    GROSS   REFUNDS  DISCOUNT       NET "},
		{TOPAZ_RPT_TOTALS, "TOTALS"},
		{TOPAZ_RPT_CATEGORY_TRACKING, "---------- CATEGORY TRACKING -----------"},
		{TOPAZ_RPT_CAT_DESCRIPTION_ITEMS_NET_SALES, "CAT#  DESCRIPTION       ITEMS  NET SALES"},

		{TOPAZ_RPT_SUMMARY_DASH, "----------------SUMMARY-----------------"},
		{TOPAZ_RPT_MOP_SALES, "MOP SALES"},
		{TOPAZ_RPT_MOP_CANCEL_REFUNDS, "MOP CANCEL/REFUNDS"},
		{TOPAZ_RPT_NET_SALES_TOTAL, "NET SALES TOTAL"},
		{TOPAZ_RPT_PAYMENT_OUT, "PAYMENT OUT"},
		{TOPAZ_RPT_PAYMENT_IN, "PAYMENT IN"},
		{TOPAZ_RPT_TOTAL_TO_ACCOUNT_FOR, "TOTAL TO ACCOUNT FOR"},
		{TOPAZ_RPT_CASHIER_DETAILS_DASH, "-----------CASHIER DETAILS--------------"},        
		{TOPAZ_RPT_CARD_BASED, "CARD BASED"},
		{TOPAZ_RPT_TOTAL_MOP_SALES, "TOTAL MOP SALES"},
		{TOPAZ_RPT_CARD_BASED, "CARD BASED"},
		{TOPAZ_RPT_TOTAL_MOP_CANCEL_REFUNDS, "TOTAL MOP CANCEL/REFUNDS"},
		{TOPAZ_RPT_CASH_BACK, "CASH BACK"},
		{TOPAZ_RPT_TOTAL_CASHBACK, "  TOTAL CASHBACK"},
		{TOPAZ_RPT_PAY_OUT, "PAY OUT"},
		{TOPAZ_RPT_CHANGE_CHECK, "CHANGE/CHECK"},
		{TOPAZ_RPT_SAFE_DROP, "SAFE DROP"},
		{TOPAZ_RPT_TOTAL_SAFE_DROP, "  TOTAL SAFE DROP"},
		{TOPAZ_RPT_IN_HOUSE, "IN HOUSE"},
		{TOPAZ_RPT_TOTAL_PAYMENT_OUT, "TOTAL PAYMENT OUT"},
		{TOPAZ_RPT_CASH_BACK_CANCEL, "CASH BACK CANCEL"},
		{TOPAZ_RPT_TOTAL_CASHBACK_CANCEL, "  TOTAL CASHBACK CANCEL"},
		{TOPAZ_RPT_PAY_IN, "PAY IN"},
		{TOPAZ_RPT_SAFE_LOAN, "SAFE LOAN"},
		{TOPAZ_RPT_IN_HOUSE, "IN HOUSE"},
		{TOPAZ_RPT_TOTAL_PAYMENT_IN, "TOTAL PAYMENT IN"},
		{TOPAZ_RPT_MEMO_ITEMS_DASH, "-----------MEMO ITEMS-------------------"},
		{TOPAZ_RPT_NO_ITEMS, "#ITEMS"},
		{TOPAZ_RPT_NO_CUSTOMERS, "#CUSTOMERS"},
		{TOPAZ_RPT_NO_NO_SALES, "#NO-SALES"},
		{TOPAZ_RPT_DISCOUNTS, "DISCOUNTS"},
		{TOPAZ_RPT_ERR_CORRECTS, "ERR/CORRECTS"},
		{TOPAZ_RPT_VOID_LINES, "VOID LINES"},
		{TOPAZ_RPT_FUEL_CONVERTS, "FUEL CONVERTS"},
		{TOPAZ_RPT_VOID_TICKETS, "VOID TICKETS"},
		{TOPAZ_RPT_POSITIVE, "    POSITIVE"},
		{TOPAZ_RPT_NEGATIVE, "    NEGATIVE"},
		{TOPAZ_RPT_EZR_TICKET, "EZ-RECEIPT"},
		{TOPAZ_RPT_EZR_INSIDE, "    INSIDE"},
		{TOPAZ_RPT_EZR_OUTSIDE,"    OUTSIDE"},
		{TOPAZ_RPT_SCANNED_COUPONS, "SCANNED COUPONS"},
		{TOPAZ_RPT_TICKET_LEVEL, "   TICKET LEVEL"},
		{TOPAZ_RPT_SUSPENDED, "SUSPENDED"},
		{TOPAZ_RPT_SUSPEND_VOID, "SUSPEND/VOID"},
		{TOPAZ_RPT_UNSETTLED_SUSPENDS, "UNSETTLED SUSPENDS"},
		{TOPAZ_RPT_COIN_DISPENSER, "COIN DISPENSER"},
		{TOPAZ_RPT_VENDOR_PAYMENTS, "VENDOR PAYMENTS"},
		{TOPAZ_RPT_PREPAID_ACTIVATIONS, "PREPAID ACTIVATIONS"},
		{TOPAZ_RPT_PREPAID_RECHARGES, "PREPAID RECHARGES"},
		{TOPAZ_RPT_PUMP_OVERRUNS, "PUMP OVERRUNS"},
		{TOPAZ_RPT_CUST, "CUST"},
		{TOPAZ_RPT_AMT, "AMT"},
		{TOPAZ_RPT_VOL, "VOL"},
		{TOPAZ_RPT_MANUAL_SETTLED, "MANUAL SETTLED"},
		{TOPAZ_RPT_AUTO_SETTLED, "AUTO SETTLED"},
		{TOPAZ_RPT_POP_DISCOUNT_TOTALS_DASH, "----------POP DISCOUNT TOTALS-----------"},
		{TOPAZ_RPT_VOLUME, "VOLUME"},
		{TOPAZ_RPT_DISC_AMT, "DISC AMT"},
		{TOPAZ_RPT_TOT_POST_DISP, "TOT POST-DISP"},
		{TOPAZ_RPT_TOT_PRE_DISP, "TOT PRE-DISP"},
		{TOPAZ_RPT_TOTAL_POP, "TOTAL POP"},
		{TOPAZ_RPT_TOTAL_COUPONS_EARNED, "TOTAL COUPONS EARNED"},
		{TOPAZ_RPT_TOTAL_CODES_EARNED, "TOTAL CODES EARNED"},
		{TOPAZ_RPT_TOTAL_CODES_REDEEMED, "TOTAL CODES REDEEMED"},
		{TOPAZ_RPT_TOTAL_FREE_CODES, "TOTAL FREE CODES"},
		{TOPAZ_RPT_TOTAL_FREE_COUPONS, "TOTAL FREE COUPONS"},															 
		{TOPAZ_RPT_TRANSACTION_TIMINGS_DASH, "----------TRANSACTION TIMINGS-----------"},
		{TOPAZ_RPT_in_seconds, "             (in seconds)"},
		{TOPAZ_RPT_MAX_AVG2, "                     MAX       AVG"},
		{TOPAZ_RPT_MAX_AVG, "                   MAX             AVG"},
		{TOPAZ_RPT_NETWORK_SUSPENDED, "NETWORK SUSPENDED"},
		{TOPAZ_RPT_END_OF_TICKET, "END OF TICKET"},
		{TOPAZ_RPT_TOTALS_DASH, "----------------TOTALS------------------"},
		{TOPAZ_RPT_CASH_BACK_FEE, "CASH BACK FEE"},
		{TOPAZ_RPT_CANCEL_REFUND, "CANCEL/REFUND "},
		{TOPAZ_RPT_DEBIT_FEE, "DEBIT FEE"},
		{TOPAZ_RPT_CANCEL_REFUND, "CANCEL/REFUND "},
		{TOPAZ_RPT_TOTAL_FUEL_SALES, "TOTAL FUEL SALES"},
		{TOPAZ_RPT_TOTAL_MERCH_SALES, "TOTAL MERCH SALES"},
		{TOPAZ_RPT_REFUND_TAXES, "REFUND TAXES"},
		{TOPAZ_RPT_SALES_TAXES, "SALES TAXES"},
		{TOPAZ_RPT_TOTAL_TAXES, "TOTAL TAXES"},
		{TOPAZ_RPT_TOTAL_INCLUDED_TAXES, "TOTAL INCLUDED TAXES"},
		{TOPAZ_RPT_SALES_TOTALIZER, "SALES TOTALIZER"},
		{TOPAZ_RPT_GRAND_TOTALIZER, "GRAND TOTALIZER"},
		{TOPAZ_RPT_ENDING, "ENDING"},
		{TOPAZ_RPT_BEGINNING, "BEGINNING"},
		{TOPAZ_RPT_DIFFERENCE, "DIFFERENCE"},

		{TOPAZ_RPT_CURRENT_CASHIER, "CURRENT CASHIER"},
		{TOPAZ_RPT_CASHIER_REPORT_NO, "CASHIER REPORT #"},
		{TOPAZ_RPT_ATTENDANT_REPORT_NO, "ATTENDANT REPORT# "},
		{TOPAZ_RPT_REG_NO, "REG #"},
		{TOPAZ_RPT_REG_NO_NO, "REG NO#"},
		{TOPAZ_RPT_CASHIER_NO, "CASHIER #"},
		{TOPAZ_RPT_RCPTS, "RCPTS: "},
		{TOPAZ_RPT_TOT, " TOT="},
		{TOPAZ_RPT_ACT, " ACT="},
		{TOPAZ_RPT_OPEN_CASHIER, "OPEN  CASHIER "},
		{TOPAZ_RPT_CLOSE_CASHIER, "CLOSE CASHIER "},
		{TOPAZ_RPT_OPEN_ATTENDANT,"OPEN  ATTENDANT "},
		{TOPAZ_RPT_CLOSE_ATTENDANT,"CLOSE ATTENDANT "},
		{TOPAZ_RPT_BEGINNING_CASH, "BEGINNING CASH"},
		{TOPAZ_RPT_BEGINNING_FOOD_STAMPS, "BEGINNING FOOD STAMPS"},
		{TOPAZ_RPT_NET_SALES_TOTAL, "NET SALES TOTAL"},		
		{TOPAZ_RPT_TOTAL_TO_ACCOUNT_FOR, "TOTAL TO ACCOUNT FOR"},        
		{TOPAZ_RPT_CARD_BASED, "CARD BASED"},
		{TOPAZ_RPT_TOTAL_MOP_SALES, "TOTAL MOP SALES"},

		{TOPAZ_RPT_TOTAL_MOP_CANCEL_REFUNDS, "TOTAL MOP CANCEL/REFUNDS      "},
		{TOPAZ_RPT_TOTAL_CASHBACK, "  TOTAL CASHBACK"},
		{TOPAZ_RPT_TOTAL_SAFE_DROP, "  TOTAL SAFE DROP"},
		{TOPAZ_RPT_TOTAL_PAYMENT_OUT, "TOTAL PAYMENT OUT"},
		{TOPAZ_RPT_CASH_BACK_CANCEL, "CASH BACK CANCEL"},
		{TOPAZ_RPT_TOTAL_CASHBACK_CANCEL, "  TOTAL CASHBACK CANCEL"},
		{TOPAZ_RPT_TOTAL_PAYMENT_IN, "TOTAL PAYMENT IN"},
		{TOPAZ_RPT_NO_ITEMS, "#ITEMS"},
		{TOPAZ_RPT_NO_CUSTOMERS, "#CUSTOMERS"},
		{TOPAZ_RPT_NO_NO_SALES, "#NO-SALES"},
		{TOPAZ_RPT_DISCOUNTS, "DISCOUNTS"},
		{TOPAZ_RPT_ERR_CORRECTS, "ERR/CORRECTS"},
		{TOPAZ_RPT_VOID_LINES, "VOID LINES"},
		{TOPAZ_RPT_VOID_TICKETS, "VOID TICKETS"},
		{TOPAZ_RPT_SCANNED_COUPONS, "SCANNED COUPONS"},
		{TOPAZ_RPT_TICKET_LEVEL, "   TICKET LEVEL"},
		{TOPAZ_RPT_SUSPEND_SETTLE, "SUSPEND/SETTLE"},
		{TOPAZ_RPT_SUSPEND_VOID, "SUSPEND/VOID"},
		{TOPAZ_RPT_UNSETTLED_SUSPEND, "UNSETTLED SUSPEND"},
		{TOPAZ_RPT_COIN_DISPENSER, "COIN DISPENSER"},
		{TOPAZ_RPT_PUMP_OVERRUNS_CUST_AMT_VOL, "PUMP OVERRUNS     CUST    AMT      VOL"},
		{TOPAZ_RPT_GALLONS, "GALLONS"},
		{TOPAZ_RPT_MANUAL_SETTLED, "MANUAL SETTLED"},
		{TOPAZ_RPT_AUTO_SETTLED, "AUTO SETTLED"},
		{TOPAZ_RPT_VENDOR_PAYMENTS, "VENDOR PAYMENTS"},
		{TOPAZ_RPT_NO_SAFE_DROP_CANCELS, "#SAFE DROP CANCELS"},
		{TOPAZ_RPT_NO_DRAWER_VIOLATIONS, "#DRAWER VIOLATIONS"},

		{TOPAZ_RPT_PREPAID_ACTIVATIONS, "PREPAID ACTIVATIONS"},
		{TOPAZ_RPT_CASH_BACK_FEE, "CASH BACK FEE"},
		{TOPAZ_RPT_CANCELREFUND, "CANCEL/REFUND "},
		{TOPAZ_RPT_CASH_BACK_FEE, "     CASH BACK FEE"},
		{TOPAZ_RPT_DEBIT_FEE, "DEBIT FEE"},
		{TOPAZ_RPT_CANCEL_REFUND, "CANCEL/REFUND "},
		{TOPAZ_RPT_TOTAL_FUEL_SALES, "TOTAL FUEL SALES"},
		{TOPAZ_RPT_TOTAL_FUEL_DISCOUNT, "TOTAL FUEL DISCOUNT"},
		{TOPAZ_RPT_TOTAL_MERCH_SALES, "TOTAL MERCH SALES"},
		{TOPAZ_RPT_TOTAL_TAXES, "TOTAL TAXES"},
		{TOPAZ_RPT_TOTAL, "TOTAL"},
		{TOPAZ_RPT_NETWORK, "NETWORK"},
		{TOPAZ_RPT_NETWORK_SUSPENDED, "NETWORK SUSPENDED"},
		{TOPAZ_RPT_END_OF_TICKET, "END OF TICKET"},
		{TOPAZ_RPT_CURRENT_AMOUNTS_DASH, "----------- CURRENT AMOUNTS -----------"},
		{TOPAZ_RPT_AMOUNTS_AT_CLOSE_DASH, "---------- AMOUNTS AT CLOSE -----------"},
		{TOPAZ_RPT_ECR_ACTUAL_OVER_SHORT, "               ECR    ACTUAL OVER(SHORT)"},
		{TOPAZ_RPT_MISC_MOP, "MISC MOP"},
		{TOPAZ_RPT_GROSS, "GROSS"},
		{TOPAZ_RPT_FOREIGN_CURRENCY_AT_CLOSE, "       FOREIGN CURRENCY AT CLOSE"},
		{TOPAZ_RPT_ECR_ACTUAL_OVER_SHORT, "               ECR    ACTUAL OVER(SHORT)"},
		{TOPAZ_RPT_CURRENCY_CONVERSION, "          CURRENCY CONVERSION"},
		{TOPAZ_RPT_AMOUNT_RATE_VALUE, "            AMOUNT     RATE       VALUE "},
		{TOPAZ_RPT_CASH_PASSED_DASH, "CASH PASSED:  $__________________"},
		{TOPAZ_RPT_TO_X_DASH, "TO: X___________________________________"},
		{TOPAZ_RPT_CASHIER_SIGNATURE, "CASHIER SIGNATURE:"},

		{TOPAZ_RPT_STORE_NO, "STORE#"},
		{TOPAZ_RPT_REGISTER_NO, " REGISTER#"},
		{TOPAZ_RPT_REGISTER_SPACE_NO, "REGISTER # "},

		{TOPAZ_RPT_Includes, "Includes "},
		{TOPAZ_RPT_thru_NO, " thru #"},
		{TOPAZ_RPT_Receipt_NO, "Receipt #"}, 
		{TOPAZ_RPT_to_NO, " to #"},
		{TOPAZ_RPT_ALL_DCRS, "ALL DCRS  "},
		{TOPAZ_RPT_PENDING, "PENDING"},
		{TOPAZ_RPT_OPEN, "OPEN  "},
		{TOPAZ_RPT_CLOSE, "CLOSE "},

		{TOPAZ_RPT_CW, "CW"},
		{TOPAZ_RPT_No_Data_Available, "No Data Available"},
		{TOPAZ_RPT_PAY_POINT, "PAY POINT"},
		{TOPAZ_RPT_LAST_EVENT_DATE, "LAST EVENT DATE"},
		{TOPAZ_RPT_IN_START, "  ** IN **"},
		{TOPAZ_RPT_BILLS, "BILLS"},
		{TOPAZ_RPT_COINS, "COINS"},
		{TOPAZ_RPT_COUPONS, "COUPONS"},
		{TOPAZ_RPT_TOKENS, "TOKENS"},
		{TOPAZ_RPT_OUT_START, "  ** OUT **"},

		{TOPAZ_RPT_PURE_PRODUCT, "              PURE PRODUCT"},
		{TOPAZ_RPT_PERC_SALES, "%SALES"},
		{TOPAZ_RPT_PERC_SPACE_SALES, "% SALES"},
		{TOPAZ_RPT_BLEND_PRODUCT, "             BLEND PRODUCT"},
		{TOPAZ_RPT_NON_TAX_SALES, "         NON-TAX SALES"},
		{TOPAZ_RPT_TAXABLE_SALES_TAXES, "         TAXABLE-SALES    TAXES"},
		{TOPAZ_RPT_SERIAL_NO_PAYEE, "       SERIAL#      PAYEE               "},
		{TOPAZ_RPT_TOTAL_MO_SALES, "     TOTAL MO SALES"},
		{TOPAZ_RPT_TOTAL_VEND_P_O, "     TOTAL VEND P/O"},
		{TOPAZ_RPT_NO_CUST_NO_COMBOS_TOTAL_SALES, "   #CUST       #COMBOS       TOTAL SALES"},
		{TOPAZ_RPT_NO_CUST_NO_MATCHES_TOTAL_SALES, "   #CUST       #MATCHES      TOTAL SALES"},
		{TOPAZ_RPT_MO_OFFLINE, "  MO OFFLINE"},
		{TOPAZ_RPT_MO_PRINTED, "  MO PRINTED"},
		{TOPAZ_RPT_OFFLINE, "  OFFLINE"},
		{TOPAZ_RPT_TOTAL_OFFLINE, "  TOTAL OFFLINE"},
		{TOPAZ_RPT_TOTAL_PRINTED, "  TOTAL PRINTED"},
		{TOPAZ_RPT_TOTALS_NOT_SUPPORTED, "  TOTALS NOT SUPPORTED"},
		{TOPAZ_RPT_UNINITIALIZED_TOTALS, "  UNINITIALIZED TOTALS"},
		{TOPAZ_RPT_VEND_P_O_OFFLINE, "  VEND P/O OFFLINE"},
		{TOPAZ_RPT_VEND_P_O_PRINTED, "  VEND P/O PRINTED"},
		{TOPAZ_RPT_Discount_Totals, " Discount Totals "},        
		{TOPAZ_RPT_NO_OF_SALES, "# OF SALES"},
		{TOPAZ_RPT_PERC_LOYALTY_CUSTOMERS, "% LOYALTY CUSTOMERS"},
		{TOPAZ_RPT_PERC_OF_TOTAL_SALES, "% OF TOTAL SALES: "},		                                                            
		{TOPAZ_RPT_PERC_SALES_ON_LOYALTY, "% SALES ON LOYALTY"},
		{TOPAZ_RPT_PERC_SALES_W_OUT_LOYALTY, "% SALES W/OUT LOYALTY"},        
		{TOPAZ_RPT_PERC_OF_SALES, "%OF SALES"},
		{TOPAZ_RPT_PERC_TANK1, "%TANK1"},
		{TOPAZ_RPT_PERC_TANK2, "%TANK2"},
		{TOPAZ_RPT_ACCEPTED, "ACCEPTED"},
		{TOPAZ_RPT_ACCEPTOR, "ACCEPTOR"},
		{TOPAZ_RPT_ALL_DCRS, "ALL DCRS"},
		{TOPAZ_RPT_ALL_FUELING_POINTS, "ALL FUELING POINTS"},
		{TOPAZ_RPT_ALL_REGISTERS, "ALL REGISTERS"},
		{TOPAZ_RPT_AMOUNT, "AMOUNT"},
		{TOPAZ_RPT_AUTOCOLLECT, "AUTOCOLLECT                             "},
		{TOPAZ_RPT_AUTOCOLLECT_REPORT, "AUTOCOLLECT REPORT"},
		{TOPAZ_RPT_Amount_Percentage, "Amount / Percentage"},
		{TOPAZ_RPT_BLEND_PRODUCT_REPORT, "BLEND PRODUCT REPORT"},
		{TOPAZ_RPT_CASH, "CASH"},
		{TOPAZ_RPT_CAT_NO, "CAT#"},
		{TOPAZ_RPT_COMBO_DEALS, "COMBO DEALS"},
		{TOPAZ_RPT_COUNT, "COUNT"},
		{TOPAZ_RPT_CUST, "CUST"},
		{TOPAZ_RPT_DATE_TIME_REG_NO_EMP_NO_AMOUNT, "DATE   TIME         REG#    EMP#  AMOUNT"},
		{TOPAZ_RPT_DCR_MERCHANDISE, "DCR MERCHANDISE"},
		{TOPAZ_RPT_DEAL_REPORT, "DEAL REPORT"},
		{TOPAZ_RPT_DEPT_NO, "DEPT#"},
		{TOPAZ_RPT_DESCRIPTION, "DESCRIPTION"},
		{TOPAZ_RPT_DISCOUNTS, "DISCOUNTS"},
		{TOPAZ_RPT_DOLLARS, "DOLLARS"},
		{TOPAZ_RPT_Description, "Description"},
		{TOPAZ_RPT_ECR_MO_TOTALS_COUNT_AMOUNT, "ECR MO TOTALS          COUNT  AMOUNT"},
		{TOPAZ_RPT_EPS_Network_Report, "EPS Network Report"},        
		{TOPAZ_RPT_Sapphire, "Sapphire"},
		{TOPAZ_RPT_report_lowercase, "report"},
		{TOPAZ_RPT_Error_while_getting_report_data_from, "Error while getting {0} data from {1}."},        
		{TOPAZ_RPT_FP_DISPENSER_REPORT, "FP DISPENSER REPORT"},
		{TOPAZ_RPT_FP_HOSE_REPORT, "FP/HOSE REPORT"},
		{TOPAZ_RPT_FP_HOSE_RUNNING_RPT, "FP/HOSE RUNNING RPT"},
		{TOPAZ_RPT_FUEL_ONLY, "FUEL ONLY"},
		{TOPAZ_RPT_FUELING_POINT, "FUELING POINT "},
		{TOPAZ_RPT_FUELING_POINT_NO, "FUELING POINT #"},
		{TOPAZ_RPT_GROSS, "GROSS"},
		{TOPAZ_RPT_HOUR_ITEMS_CUST_NET_SALES, "HOUR    ITEMS            CUST  NET SALES"},
		{TOPAZ_RPT_HOURLY_REPORT, "HOURLY REPORT"},
		{TOPAZ_RPT_ITEMS, "ITEMS"},
		{TOPAZ_RPT_LOYALTY_REPORT, "LOYALTY REPORT"},
		{TOPAZ_RPT_LOYALTY_TRANSACTIONS_INSIDE, "LOYALTY TRANSACTIONS INSIDE"},
		{TOPAZ_RPT_LOYALTY_TRANSACTIONS_OUTSIDE, "LOYALTY TRANSACTIONS OUTSIDE"},
		{TOPAZ_RPT_MER_ONLY, "MER ONLY"},
		{TOPAZ_RPT_MER_FUEL, "MER+FUEL"},
		{TOPAZ_RPT_MIX_N_MATCH_DEALS, "MIX-N-MATCH DEALS"},
		{TOPAZ_RPT_MONEY_ORDER_DETAILS, "MONEY ORDER DETAILS"},
		{TOPAZ_RPT_NAME_TAX_RATE_ACT_RATE, "NAME     TAX-RATE         ACT-RATE"},
		{TOPAZ_RPT_NEG_DEPTS, "NEG DEPTS"},
		{TOPAZ_RPT_NET_SALES, "NET SALES"},
		{TOPAZ_RPT_NO_DATA_AVAILABLE, "NO DATA AVAILABLE"},
		{TOPAZ_RPT_OTHER_DEPTS, "OTHER DEPTS"},
		{TOPAZ_RPT_PLU_NUMBER, "PLU NUMBER"},
		{TOPAZ_RPT_PLU_PROMO_REPORT, "PLU PROMO REPORT"},
		{TOPAZ_RPT_PRICE, "PRICE"},
		{TOPAZ_RPT_PROD, "PROD"},
		{TOPAZ_RPT_PRODUCT_TOTALS, "PRODUCT TOTALS"},
		{TOPAZ_RPT_PROMOTION_ID, "PROMOTION ID"},
		{TOPAZ_RPT_RC, "RC"},        
		{TOPAZ_RPT_REFUNDS, "REFUNDS"},        
		{TOPAZ_RPT_SALES_Before_Ticket_Disc, "SALES (Before Ticket Disc)"},
		{TOPAZ_RPT_SALES_TAXES, "  SALES TAXES"},
		{TOPAZ_RPT_SOLD, "SOLD"},
		{TOPAZ_RPT_STATION_TOTALS, "STATION TOTALS"},
		{TOPAZ_RPT_TANK, "TANK"},
		{TOPAZ_RPT_TANK1, "TANK1"},
		{TOPAZ_RPT_TANK2, "TANK2"},
		{TOPAZ_RPT_TAX_REPORT, "TAX REPORT"},
		{TOPAZ_RPT_TOT_SALES, "TOT-SALES"},
		{TOPAZ_RPT_TOTAL_CUSTOMERS, "TOTAL CUSTOMERS"},
		{TOPAZ_RPT_TOTAL_DISCOUNT, "TOTAL DISCOUNT"},
		{TOPAZ_RPT_TOTAL_ITEMS_SOLD, "TOTAL ITEMS SOLD: "},
		{TOPAZ_RPT_TOTAL_LINE_ITEM_DISCOUNT, "TOTAL LINE ITEM DISCOUNT"},
		{TOPAZ_RPT_TOTAL_LOYALTY_CUSTOMERS, "TOTAL LOYALTY CUSTOMERS"},
		{TOPAZ_RPT_TOTAL_LOYALTY_DISCOUNT, "TOTAL LOYALTY DISCOUNT"},
		{TOPAZ_RPT_TOTAL_PPG_DISCOUNT, "TOTAL PPG DISCOUNT"},
		{TOPAZ_RPT_TOTAL_SALES_TAX, "TOTAL SALES TAX"},
		{TOPAZ_RPT_TOTAL_SALES, "TOTAL SALES: "},
		{TOPAZ_RPT_TOTAL_TICKET_DISCOUNT, "TOTAL TICKET DISCOUNT"},
		{TOPAZ_RPT_TOTAL, "TOTAL"},
		{TOPAZ_RPT_Total, "Total"},
		{TOPAZ_RPT_VOLUME, "VOLUME"},
		{TOPAZ_RPT_Found_0_records_to_print, "\n## Found 0 records to print ##\n"},

		{TOPAZ_RPT_GRADE_NO_DISC_VOLUME_DISC_AMT, "    GRADE    #DISC     VOLUME   DISC AMT  "},
		{TOPAZ_RPT_SPACES_TOTAL, "    TOTAL"},
		{TOPAZ_RPT_SPACES_TOTALS, "    TOTALS"},
		{TOPAZ_RPT_and_post_dispensed_amounts, "    and post-dispensed amounts."},
		{TOPAZ_RPT_discount_applied_at_Ruby_when, "    discount applied at Ruby when"},
		{TOPAZ_RPT_discount_price_amount_reported, "    discount price; amount reported"},
		{TOPAZ_RPT_discounted_portion_of_the_fuel_sales, "    discounted portion of the fuel sales"},
		{TOPAZ_RPT_includes_both_pre_dispensed, "    includes both pre-dispensed"},
		{TOPAZ_RPT_payment_is_tendered, "    payment is tendered."},
		{TOPAZ_RPT_reflects_discount_from_street_price, "    reflects discount from street price."},
		{TOPAZ_RPT_where_POP_was_applied_Each_entry, "    where POP was applied. Each entry"},
		{TOPAZ_RPT_SPACES_AMOUNT, "   AMOUNT"},
		{TOPAZ_RPT_CSH_NO_QTY_ORG_PRICE_OVER_PRICE, "   CSH#        QTY ORG PRICE OVER PRICE "},
		{TOPAZ_RPT_Cash, "(Cash)"},
		{TOPAZ_RPT_Check, "(Check)"},
		{TOPAZ_RPT_Other, "(Other)"},
		{TOPAZ_RPT_IN, "  ** IN **"},
		{TOPAZ_RPT_OUT, "  ** OUT **"},
		{TOPAZ_RPT_ASSOCIATED_PROGRAM_NAMES, "  ASSOCIATED PROGRAM NAME(S)"},
		{TOPAZ_RPT_SPACES_CASH, "  CASH"},
		{TOPAZ_RPT_DEF, "  DEF"},
		{TOPAZ_RPT_DISCOUNT_DEFINITION, "  DISCOUNT DEFINITION"},
		{TOPAZ_RPT_END, "  END:    "},
		{TOPAZ_RPT_ENVELOPE_ITEMS, "  ENVELOPE ITEMS"},
		{TOPAZ_RPT_ENVELOPE_VALUE, "  ENVELOPE VALUE"},
		{TOPAZ_RPT_FROM, "  FROM: "},
		{TOPAZ_RPT_RECOGNIZED_BILLS, "  RECOGNIZED BILLS"},
		{TOPAZ_RPT_SEAL_NUMBER, "  SEAL NUMBER"},
		{TOPAZ_RPT_START, "  START:  "},
		{TOPAZ_RPT_TOTAL_CASSETTE_CASH, "  TOTAL CASSETTE CASH"},
		{TOPAZ_RPT_TOTAL, "  TOTAL"},
		{TOPAZ_RPT_UNRECOGNIZED_BILLS, "  UNRECOGNIZED BILLS"},
		{TOPAZ_RPT_TOTALS, " ** TOTALS"},
		{TOPAZ_RPT_COUNT, " COUNT"},
		{TOPAZ_RPT_Fuel_Dispensed, " Fuel Dispensed"},
		{TOPAZ_RPT_TOTAL_ALL_DISCOUNT_DEFINITIONS, " TOTAL - ALL DISCOUNT DEFINITIONS"},
		{TOPAZ_RPT_TOTAL_ALL_DISCOUNT_PROGRAMS, " TOTAL - ALL DISCOUNT PROGRAMS"},
		{TOPAZ_RPT_Tier, " Tier "},
		{TOPAZ_RPT_NO_SAFE_DROP_CANCELS, "#SAFE DROP CANCELS     "},
		{TOPAZ_RPT_PERC_DCR, "%DCR"},
		{TOPAZ_RPT_PERC_FP, "%FP"},
		{TOPAZ_RPT_PERC_FUEL, "%FUEL"},
		{TOPAZ_RPT_Total, "(Total)"},
		{TOPAZ_RPT_E_SAFE_ID, "** E-SAFE ID: "},
		{TOPAZ_RPT_POST_DISP_eq_fuel_dispensed_at, "** POST-DISP = fuel dispensed at"},
		{TOPAZ_RPT_PRE_DISP_eq_fuel_dispensed_at, "** PRE-DISP = fuel dispensed at"},
		{TOPAZ_RPT_RECONCILIATION_SUMMARY, "** RECONCILIATION SUMMARY **"},
		{TOPAZ_RPT_WASH_DETAILS_PAYPOINT, "** WASH DETAILS PAYPOINT "},
		{TOPAZ_RPT_This_report_represents_the, "*** This report represents the "},
		{TOPAZ_RPT_Deliveries, "Deliveries"},
		{TOPAZ_RPT_Dispensed, "Dispensed"},
		{TOPAZ_RPT_Ending_Inventory, "Ending Inventory"},
		{TOPAZ_RPT_ACTIVATIONS, "ACTIVATIONS"},
		{TOPAZ_RPT_ALL_DCRS, "ALL DCRS"},
		{TOPAZ_RPT_AMOUNT, "AMOUNT"},
		{TOPAZ_RPT_AUDIT_NUM, "AUDIT NUM"},
		{TOPAZ_RPT_Acct_Type, "Acct Type"},
		{TOPAZ_RPT_Amount, "Amount"},
		{TOPAZ_RPT_Approval_Code, "Approval Code"},
		{TOPAZ_RPT_BAG_SEAL_NUMBERS, "BAG SEAL NUMBERS"},
		{TOPAZ_RPT_BATCH_DAY_SEQ_NO, "BATCH/DAY SEQ# = "},
		{TOPAZ_RPT_BILL_ACCEPTOR_CONTENTS, "BILL ACCEPTOR CONTENTS"},
		{TOPAZ_RPT_BILLS, "BILLS"},
		{TOPAZ_RPT_BUS, "BUS"},
		{TOPAZ_RPT_BY, "BY:"},
		{TOPAZ_RPT_Bill_Acceptor, "Bill Acceptor"},
		{TOPAZ_RPT_BillValue, "BillValue"},
		{TOPAZ_RPT_CASH, "CASH"},
		{TOPAZ_RPT_CASSETTE_SEAL_NUMBERS, "CASSETTE SEAL NUMBERS"},
		{TOPAZ_RPT_CNT, "CNT"},
		{TOPAZ_RPT_COIN_CONTENTS, "COIN CONTENTS"},        
		{TOPAZ_RPT_COLUMN_CONTENTS, "COLUMN CONTENTS"},
		{TOPAZ_RPT_CONSOLE, "CONSOLE"},
		{TOPAZ_RPT_CONTENT_REPORT_NUMBER, "CONTENT REPORT NUMBER: "},
		{TOPAZ_RPT_CONTENT_REPORT, "CONTENT REPORT"},
		{TOPAZ_RPT_COUNT, "COUNT"},
		{TOPAZ_RPT_COUPONS, "COUPONS"},
		{TOPAZ_RPT_CREDIT, "CREDIT"},
		{TOPAZ_RPT_Cassette_NO, "Cassette#"},
		{TOPAZ_RPT_CoinValue, "CoinValue"},
		{TOPAZ_RPT_Col_NO, "Col#"},
		{TOPAZ_RPT_Count, "Count"},
		{TOPAZ_RPT_Courier_Tray, "Courier Tray"},
		{TOPAZ_RPT_Created, "Created "},
		{TOPAZ_RPT_DATE_TIME_REF_NO_C_NO_R_NO_AMOUNT_MOP, "DATE  TIME  REF#  C#  R#  AMOUNT MOP"},
		{TOPAZ_RPT_DATE, "DATE"},
		{TOPAZ_RPT_DCR_NO, "DCR #"},
		{TOPAZ_RPT_DCR_STATISTICAL_RPT, "DCR STATISTICAL RPT"},
		{TOPAZ_RPT_DEF, "DEF"},
		{TOPAZ_RPT_DISCOUNT_DEFINITION, "DISCOUNT DEFINITION"},
		{TOPAZ_RPT_DISPENSER_CONTENTS, "DISPENSER CONTENTS"},
		{TOPAZ_RPT_DOLLARS, "DOLLARS"},
		{TOPAZ_RPT_Date, "Date"},
		{TOPAZ_RPT_Date, "Date"},
		{TOPAZ_RPT_Del, "Del       "},
		{TOPAZ_RPT_Denomination, "Denomination"},
		{TOPAZ_RPT_Discrepancy, "Discrepancy"},
		{TOPAZ_RPT_E_SAFE_PERIOD, "E-SAFE PERIOD:"},
		{TOPAZ_RPT_ENV, "ENV"},
		{TOPAZ_RPT_ENVELOPE_DETAIL, "ENVELOPE DETAIL"},
		{TOPAZ_RPT_EVENT_DATE, "EVENT DATE"},
		{TOPAZ_RPT_FP_HOSE_TEST_REPORT, "FP/HOSE TEST REPORT"},
		{TOPAZ_RPT_FUEL_PRICE_CHANGE, "FUEL PRICE CHANGE :"},
		{TOPAZ_RPT_Hopper_NO, "Hopper#"},
		{TOPAZ_RPT_ID, "ID"},
		{TOPAZ_RPT_ITEM, "ITEM"},
		{TOPAZ_RPT_Inventory, "Inventory "},
		{TOPAZ_RPT_Loyalty_Discount, "Loyalty Discount"},
		{TOPAZ_RPT_Loyalty_Reward_ID, "Loyalty Reward ID"},
		{TOPAZ_RPT_Loyalty_Terminal_Batch, "Loyalty Terminal Batch"},
		{TOPAZ_RPT_MOP_No_AMOUNT, "MOP            No.   AMOUNT"},
		{TOPAZ_RPT_MOP, "MOP"},
		{TOPAZ_RPT_Masked_Acct_NO, "Masked Acct #"},
		{TOPAZ_RPT_Merchant, "Merchant "},
		{TOPAZ_RPT_Msg_Type, "Msg Type"},
		{TOPAZ_RPT_NAME, "NAME"},
		{TOPAZ_RPT_NETWORK_PRODUCT_RPT, "NETWORK PRODUCT RPT"},
		{TOPAZ_RPT_NUM, "NUM"},
		{TOPAZ_RPT_NUMB, "NUMB"},
		{TOPAZ_RPT_New, "New"},
		{TOPAZ_RPT_No_Data_Available, "No Data Available"},
		{TOPAZ_RPT_NoteCount, "NoteCount"},
		{TOPAZ_RPT_Number_of_Bill_Acceptors, "Number of Bill Acceptors     : "},
		{TOPAZ_RPT_Number_of_Cassettes, "Number of Cassettes          : "},
		{TOPAZ_RPT_Number_of_Columns, "Number of Columns            : "},
		{TOPAZ_RPT_Number_of_Hoppers, "Number of Hoppers            : "},
		{TOPAZ_RPT_Number_of_Rejected_Notes, "Number of Rejected Notes     : "},
		{TOPAZ_RPT_OTHER, "OTHER"},
		{TOPAZ_RPT_OVER_LIMIT_EVENTS_DETAIL, "OVER LIMIT EVENTS DETAIL"},
		{TOPAZ_RPT_Overall_Result, "Overall Result"},
		{TOPAZ_RPT_PAY_POINT, "PAY POINT"},
		{TOPAZ_RPT_PLU_EXCEPTION_REPORT, "PLU EXCEPTION REPORT"},
		{TOPAZ_RPT_PLU_NUMBER_EXCEPTION_STATE, "PLU NUMBER        EXCEPTION      STATE   "},
		{TOPAZ_RPT_POP_DISCOUNT_DEF_RPT, "POP DISCOUNT DEF RPT"},
		{TOPAZ_RPT_POP_DISCOUNT_RPT, "POP DISCOUNT RPT"},
		{TOPAZ_RPT_POP_DISCOUNT, "POP DISCOUNT"},
		{TOPAZ_RPT_POS, "POS"},
		{TOPAZ_RPT_PR_PRICE_LEVEL_RPT, "PR/PRICE LEVEL RPT"},
		{TOPAZ_RPT_PROD_DESC_QTY_CNT_TOTAL, "PROD    DESC         QTY   CNT    TOTAL$"},
		{TOPAZ_RPT_PROD_DISC_TYPE_VOLUME_DISC_AMT, "PROD DISC TYPE        VOLUME    DISC AMT"},
		{TOPAZ_RPT_PROGRAM_NAME, "PROGRAM NAME"},
		{TOPAZ_RPT_PROGRAM_REPORT, "PROGRAM REPORT"},
		{TOPAZ_RPT_Period_End, "Period End "},
		{TOPAZ_RPT_Period_Start, "Period Start "},
		{TOPAZ_RPT_Prev, "Prev"},
		{TOPAZ_RPT_Prod, "Prod"},
		{TOPAZ_RPT_REFUNDS, "REFUNDS"},
		{TOPAZ_RPT_REJECTS_CONTENTS, "REJECTS CONTENTS"},
		{TOPAZ_RPT_Ref_NO, "Ref #"},
		{TOPAZ_RPT_Report, "REPORT"},
		{TOPAZ_RPT_Reserve_Change_Fund, "Reserve Change Fund"},
		{TOPAZ_RPT_SAFE_DROP_DETAIL, "SAFE DROP DETAIL"},
		{TOPAZ_RPT_SALES, "SALES"},
		{TOPAZ_RPT_SL, "SL"},
		{TOPAZ_RPT_SL_PRICE_LEVEL_RPT, "SL/PRICE LEVEL RPT"},
		{TOPAZ_RPT_SUMMARY, "SUMMARY"},
		{TOPAZ_RPT_Starting_Inventory, "Starting Inventory"},
		{TOPAZ_RPT_TIER_NO, "TIER #"},
		{TOPAZ_RPT_TOKENS, "TOKENS"},
		{TOPAZ_RPT_TOTAL, "TOTAL "},
		{TOPAZ_RPT_TOTAL_NUM_CASSETTES, "TOTAL NUM CASSETTES"},
		{TOPAZ_RPT_TOTAL_NUM_ENVELOPES, "TOTAL NUM ENVELOPES"},
		{TOPAZ_RPT_TOTAL_VALUE, "TOTAL VALUE"},
		{TOPAZ_RPT_TOTAL, "TOTAL"},
		{TOPAZ_RPT_TOTALS, "TOTALS"},
		{TOPAZ_RPT_TYPE, "TYPE"},
		{TOPAZ_RPT_Tank, "Tank "},
		{TOPAZ_RPT_Tank, "Tank"},
		{TOPAZ_RPT_Terminal_Batch, "Terminal Batch"},
		{TOPAZ_RPT_Terminal_STAN, "Terminal STAN"},
		{TOPAZ_RPT_Time, "Time"},
		{TOPAZ_RPT_TotAmt, "TotAmt"},
		{TOPAZ_RPT_Total_Amount_In_Hoppers, "Total Amount In Hoppers      : "},
		{TOPAZ_RPT_Total_Amount_in_BillAcceptors, "Total Amount in BillAcceptors: "},
		{TOPAZ_RPT_Total_Amount_in_Cassettes, "Total Amount in Cassettes    : "},
		{TOPAZ_RPT_Total_Amount_in_Columns, "Total Amount in Columns      : "},
		{TOPAZ_RPT_Total_Amount_in_Overflow_bin, "Total Amount in Overflow bin :"},
		{TOPAZ_RPT_Total_Loyalty_Discount, "Total Loyalty Discount"},
		{TOPAZ_RPT_Total, "Total"},
		{TOPAZ_RPT_TotalAmt, "TotalAmt"},
		{TOPAZ_RPT_TotalAmt, "TotalAmt"},
		{TOPAZ_RPT_Transaction, "Transaction"},
		{TOPAZ_RPT_TubeCnt, "TubeCnt"},
		{TOPAZ_RPT_TubeVal, "TubeVal"},
		{TOPAZ_RPT_Txn_Amt, "Txn Amt"},
		{TOPAZ_RPT_UNVERIFIED_CASH_RATIO, "UNVERIFIED CASH RATIO"},
		{TOPAZ_RPT_UPGRADES, "UPGRADES"},
		{TOPAZ_RPT_Unpaid_Transactions, "Unpaid Transactions"},
		{TOPAZ_RPT_VAULT_CONTENTS, "VAULT CONTENTS"},
		{TOPAZ_RPT_VOLUME, "VOLUME"},
		{TOPAZ_RPT_Value_of_Rejected_Notes, "Value of Rejected Notes      : "},
		{TOPAZ_RPT_Vault_Courier_Tray_Total, "Vault Courier Tray Total     : "},
		{TOPAZ_RPT_Vault_Drop_Total, "Vault Drop Total             : "},
		{TOPAZ_RPT_Vault_Drop, "Vault Drop"},
		{TOPAZ_RPT_Vault_ReserveChangeFund_Total, "Vault ReserveChangeFund Total: "},
		{TOPAZ_RPT_Volume, "Volume"},
		{TOPAZ_RPT_WASH_ID, "WASH ID"},
		{TOPAZ_RPT_WASH, "WASH"},
		{TOPAZ_RPT_Found_0_records_to_print, "\n## Found 0 records to print ##\n"},
		{TOPAZ_RPT_ALL_CAR_WASH_PAYPOINTS, "ALL CARWASH PAYPOINTS"},
		{TOPAZ_RPT_NO_LOGIN_OVERRIDES, "#LOGIN OVERRIDES"},
		{TOPAZ_RPT_DISPENSER_REPORT, "DISPENSER REPORT"},
		{THIRD_PARTY_PRODUCT_KEY, "3rd Prty Product"},
		{ENTER_VOUCHER_ID, "Please Enter Voucher Id"},
		{UNKNOWN, "UNKNOWN"},
		{ENTER_NAME, "ENTER NAME"},
        {ENTER_PHONE_NUMBER, "ENTER PHONE NUMBER"},
        {MAX_CHAR_NAME, "MAXIMUM LIMIT 9 CHARACTERS"},
        {MAX_CHAR_PHONE_NUMBER, "MAXIMUM LIMIT 10 CHARACTERS"},
		{LISTEN_TICKET_NAME, "Please listen for your name"},
		{ NETWORK_ERROR_IGNORED , "Network Error Ignored"},
		{PERIOD_CLOSE_WARNING,   "Warning - Auto End of Day will begin in approximately 5 minutes"},
		{AEOD_CLOSE_ALARM_SHORT, 	"AEOD is starting"},
		{AEOD_CLOSE_ALARM_DETAIL, 	"Finish and log out"},
		{PERIOD_CLOSE,	"PERIOD CLOSE"},
		{CASHIER_PERIOD_CLOSED,	  "NO OPEN CASHIER SESSION. LOGGING OUT."},
		{PERIODCLOSE_LOGOUT,      "REGISTER LOGGED OUT FOR PERIOD CLOSE"},
		{STICKY_LABEL,"STICKY LABEL"},
		{CUSTOMER_NAME_REQUIRED,"CUSTOMER NAME REQUIRED"},
		{CUSTOMER_NAME, "Name: "},
		{CUSTOMER_NUMBER, "Customer No: "},
		{SEQUENCE_RANGE, "Range: {0} to"},
		{VENTA_AFECTA, "Venta Afecta a Iva"},
		{RETRIEVING_EPS_REPORT, "Retrieving EPS Network Report data..."},
		{USB_DETECT_ERROR_TITLE,"USB Storage Detect Error"},
		{USB_DETECT_ERROR_MSG, "Error detecting USB storage"},
		{REPORT_SAVE_ERROR_TITLE,"Report Save Error"},
		{REPORT_SAVE_USB_ERROR_MSG,"Please connect exactly 1 USB device"},
		{REPORT_SAVE_ERROR_MSG, "Error saving report"},
		{REPORT_SAVE_TITLE, "Save Report"},
		{ REPORT_SAVE_TITLE_MSG,"Saved report file"},
		{FISCAL_CF, "CF"},
		{FISCAL_CUSTOMER_TAX_UPDATE, "Update Customer Tax"},
		{FSC_PRNT_STR_COLON_TAXID, "{0}: {1}"},
		{FSC_FORMAT_FC_OPTIONS, "{0}. {1} {2}"},
		{FISCAL_FINAL_CONSUMER, "Final Consumer"},
		{SWIPE_SCAN_LICENSE, "Swipe/Scan License"},
		{MANUAL_CANCEL_TO_EXIT, "To Exit, press Manual Entry Override, then Cancel"},
		{MANUAL_ENTRY_OVERRIDE, "Manual Entry Override"},
		{SKIP, "SKIP"},
		{OK_SKIP, "OK/SKIP"},
		{BYPASS_ID, "BYPASS ID"},
		{IS_MILITARY_ID, "Is this a Military ID?"},
		{CONFIRM,"CONFIRM"},
		{DECLINE,"DECLINE"},
		{CONFIRM_PHOTO_ID,"CONFIRM PHOTO ID"},
		{ID_NUMBER,"ID Number: "},
		{MAN_ID_NOT_ALLOWED,"MANUAL ID ENTRY NOT ALLOWED"},
		{TAX_EXEMPT_CONFIG_ERROR,"TAX EXEMPT:TAX EXEMPT CONFIG NOT FOUND"},
		{OPERATION_NOT_ALLOWED ,"OPERATION NOT ALLOWED"},
		{ERROR_CORRECT_KEY, "Error Correct"},
		{VOID_TICKET_KEY,"Void Ticket"},
		{REFUND_KEY,"Refund"},
		{PRICE_OVERRIDE_KEY,"Price Override"},
		{NO_SALE_KEY,"No Sale"},
		{MANAGED_UPDATE_KEY,"Apply Updates"},
		{PAY_OUT_KEY,"Pay Out"},
		{INVALID_SOFTKEYTYPE, "Invalid SoftKeyType"},
		{INVALID_SECURITY_LEVEL, "Invalid security level for SoftKey code:"},
		{ERROR_LOADING_PERSIST_ADMIN, "Error in persisting data"},
		{EMP_PREFS_TITLE, "Cashier Preferences"},
		{EMP_PREFS_OUT_OF_SYNC_WITH_SERVER, "The configuration which you see may not be updated yet. Please logout and login again to get the updated changes."},
		{EMP_PREFS_CONFIG_NOT_SAVED, "Could not save configurations, please try again or when system is online."},
		{DEVICE_CONTROL_HELP_TEXT, "To connect a device, touch the 'Connect Device' button, and select from the available device list."
				+ "\n\n"
				+ "To disconnect, touch the 'Disconnect' button."
				+ "\n\n"
				+ "To reconnect a device to another port, first disconnect and then connect again"
				+ "\n\n"
				+ "To change the baud rate of a COM port, touch the 'Adjust Baudrate' button, and select Baudrate from the list."
				+ "\n\n"
				+ "To enable/disable the 12 volt power on a COM port, touch the associated '12V' button."
				+ "\n\n"
				+ "To make the changes permanent, press the 'Save' button."
				+ "\n\n"
				+ "To abort any changes, press the 'Cancel' button. This will only abort changes made from last Save operation."
				+ "\n\n"},
		{SCREEN_LOCK_CLEAN_TITLE, "Screen Cleaning Mode"},
		{SCREEN_LOCK_CLEAN_HOLD_EXIT, "Tap & Hold to Exit"},
		{SCREEN_LOCK_CLEAN_INSTRUCTION, "Clean screen with a damp microfiber cloth. Only use water, and mild detergent if needed. Other cleaning agents may damage the unit and should not be used."},
		{ATTENDANT_SESSION_RETRIEVE_ERROR, "Unable to retrieve Attendant information"},
		{WHATS_NEW, "What\'s New?"},
		{REGISTER_LOGGED_OUT_FOR_ATTENDANT,   "Logging out Attendant"},
		{ERROR_INITIATING_TRANSACTION, "Error Initiating Transaction"},
		{ALL_ATTENDANT_INDOOR_RPT, "ALL ATTENDANTS INDOOR"},
		{ALL_ATTENDANT_OUTDOOR_RPT, "ALL ATTENDANTS OUTDOOR"}
		
		
	};
}
