/*-
 * Created January 20, 2005								Aaron Sorgius
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
 * @author	Aaron Sorgius
 * @version 0.1
 */

public class NetworkRes extends ListResourceBundle {
    public static final String PROMPT_DRIVER_ID             = "DRIVER_ID";
    public static final String PROMPT_VEHICLE               = "VEHICLE_NUM";
    public static final String PROMPT_ODOMETER              = "ODOMETER";
    public static final String PROMPT_LICENSE               = "LICENSE_NUM";
    public static final String PROMPT_JOB_NO                = "JOB_NUM";
    public static final String PROMPT_DATA                  = "DATA";
    public static final String PROMPT_DEPT                  = "DEPT";
    public static final String PROMPT_PIN                   = "PIN";
    public static final String PROMPT_REF_NO                = "REF_NO";
    public static final String PROMPT_USER_ID               = "USER_ID";
    public static final String PROMPT_ZIP_CODE              = "ZIPCODE";
    public static final String PROMPT_STREET                = "STREET";
    public static final String PROMPT_VISIBLE_DRIVER_ID     = "VISIBLE_DRIVER_ID";
    public static final String PROMPT_ID_NUMBER             = "ID_NUMBER";
    public static final String PROMPT_CUST_CODE             = "CUST_CODE";
    public static final String PROMPT_SOC_SEC               = "SOC_SEC";
    public static final String PROMPT_EMP_NUM               = "EMP_NUM";
    public static final String PROMPT_CLIENT_NUM            = "CLIENT_NUM";
    public static final String PROMPT_TRAILER_ID            = "TRAILER_ID";
    public static final String PROMPT_HUBOMETER             = "HUBOMETER";
    public static final String INVALID_RES                  = "INVALID_RES";
    public static final String INVALID_DRIVER_ID            = "INVALID_DRIVER_ID";
    public static final String INVALID_VEHICLE              = "INVALID_VEHICLE_NUM";
    public static final String INVALID_ODOMETER             = "INVALID_ODOMETER";
    public static final String INVALID_LICENSE              = "INVALID_LICENSE_NUM";
    public static final String INVALID_JOB_NO               = "INVALID_JOB_NUM";
    public static final String INVALID_DATA                 = "INVALID_DATA";
    public static final String INVALID_DEPT                 = "INVALID_DEPT";
    public static final String INVALID_PIN                  = "INVALID_PIN";
    public static final String INVALID_REF_NO               = "INVALID_REF_NO";
    public static final String INVALID_USER_ID              = "INVALID_USER_ID";
    public static final String INVALID_ZIP_CODE             = "INVALID_ZIPCODE";
    public static final String INVALID_STREET               = "INVALID_STREET";
    public static final String INVALID_VISIBLE_DRIVER_ID    = "INVALID_VISIBLE_DRIVER_ID";
    public static final String INVALID_ID_NUMBER            = "INVALID_ID_NUMBER";
    public static final String INVALID_CUST_CODE            = "INVALID_CUST_CODE";
    public static final String INVALID_SOC_SEC              = "INVALID_SOC_SEC";
    public static final String INVALID_EMP_NUM              = "INVALID_EMP_NUM";
    public static final String INVALID_CLIENT_NUM           = "INVALID_CLIENT_NUM";
    public static final String INVALID_TRAILER_ID           = "INVALID_TRAILER_ID";
    public static final String INVALID_HUBOMETER            = "INVALID_HUBOMETER";
    public static final String PROMPT_LAST4           		= "PromptLast4";
    public static final String LAST4_MISMATCH           	= "Last4Mismatch";
    public static final String PAYMENT_TIME                 = "PaymentTime";
    public static final String BATCH_DETAILS_MENU           = "BatchDetailsMenu";
    public static final String QUICK_CREDIT                 = "QuickCredit";
    public static final String PRINT_NET_LOG                = "PrintNetLog";
    public static final String ACTIVATE_PREPAID_CARD        = "ActivatePrepaidCard";
    public static final String REPLENISH_PREPAID_CARD       = "ReplenishPrepaidCard";
    public static final String EBT_BALANCE_INQUIRY          = "EBTBalanceInquiry";
    public static final String EBT_VOUCHER                  = "EBTVoucher";
    public static final String ACTIVATE_PREPAID_PROMPT      = "ActivatePrepaidPrompt";
    public static final String REPLENISH_PREPAID_PROMPT     = "ReplenishPrepaidPrompt";
    public static final String INVALID_AMOUNT_ENTERED       = "InvalidAmountEntered";
    public static final String RFND_REF_NUM                 = "RfndRefNum";
    public static final String RFND_SALE_DATE               = "RfndSaleDate";
    public static final String RFND_SALE_TIME               = "RfndSaleTime";
    public static final String RFND_TRACE_AUDIT             = "RfndTraceAudit";
    public static final String USE_IMPRINTER_RCPT           = "UseImprinterRcpt";
    public static final String SEND_COMPLETION              = "SendCompletion";
    public static final String ACCT_CONFIRM					= "AcctConfirm";
    public static final String ENTER_LICENSE				= "EnterLicense";
    public static final String RETRIES_EXCEED				= "RetriesExceed";
    public static final String PP_SELECT					= "PpSelect";
    public static final String DEB_CASHBACK					= "DebCashback";
    public static final String PP_CASHBACK_OPTION			= "PpCashbackOption";
    public static final String PP_YES_NO					= "PpYesNo";
    public static final String CALL_PHONE_NR				= "CallPhoneNr";
    public static final String FOR_VOICE_AUTH				= "ForVoiceAuth";
    public static final String ON_PINPAD					= "OnPinpad";
    public static final String ENTER_CASHBACK				= "EnterCashback";
    public static final String CHK_NONE                     = "CHK_NONE";
    public static final String CHK_LUHN                     = "CHK_LUHN";
    public static final String CHK_MASTERCARD               = "CHK_MASTERCARD";
    public static final String CHK_WXPRESS                  = "CHK_WXPRESS";
    public static final String CHK_VISA                     = "CHK_VISA";
    public static final String CHK_CUSTOM                   = "CHK_CUSTOM";
    public static final String CHK_CALIF                    = "CHK_CALIF";
    public static final String CHK_PHH                      = "CHK_PHH";
    public static final String CHK_IAS                      = "CHK_IAS";
    public static final String CHK_AMOCO                    = "CHK_AMOCO";
    public static final String CHK_AMOCO_MULTI              = "CHK_AMOCO_MULTI";
    public static final String CHK_UNIVERSAL                = "CHK_UNIVERSAL";
    public static final String CHK_DISCOVER                 = "CHK_DISCOVER";
    public static final String CHK_GSA                      = "CHK_GSA";
    public static final String CHK_VOYAGER                  = "CHK_VOYAGER";
    public static final String CHK_AMEX                     = "CHK_AMEX";
    public static final String CHK_FMGC                     = "CHK_FMGC";
    public static final String CHK_FUELMN                   = "CHK_FUELMN";
    public static final String CHK_DONLN                    = "CHK_DONLN";
    public static final String CHK_MCFLT                    = "CHK_MCFLT";
    public static final String CHK_MCPURC                   = "CHK_MCPURC";
    public static final String CHK_PREPAID                  = "CHK_PREPAID";
    public static final String CHK_VISAFLT	                = "CHK_VISAFLT";
    public static final String CHK_ENMARK                   = "CHK_ENMARK";
    public static final String CHK_PNS                      = "CHK_PNS";
    public static final String CHK_MOTOMART                 = "CHK_MOTOMART";
    public static final String CHK_GATE                     = "CHK_GATE";
    public static final String ISO_RECORDS                  = "ISO_RECORDS";
    public static final String SELECT_RECORD                = "SELECT_RECORD";
    public static final String BAD_CARD_RETRY				= "BadCardRetry";
    public static final String PP_ACT_INSTR                 = "PpActInstr";
    public static final String ADD_ITEM_MOP                 = "AddItemMop";
    public final static String IS_DEBIT_CARD                = "IsDebitCard";
    public final static String DEBIT_MOP					= "DebitMop";
    public final static String TIMEOUT						= "Timeout";
    public final static String ERROR						= "Error";
    public static final String EBT_BAL_INQ = "EBT_BAL_INQ";
    public static final String EBT_VOUCHER_CLR = "EBT_VOUCHER_CLR";
    public static final String EBT_VOUCHER_RETURN = "EBT_VOUCHER_RETURN";
    public static final String CASH_BAL = "CASH_BAL";
    public static final String FOODSTAMP_BAL = "FOODSTAMP_VAL";
    public static final String AMOUNT = "AMOUNT";
    public static final String APPROVAL_NUM = "APPROVAL_NUM";
    public static final String VOUCHER_NUM = "VOUCHER_NUM";
    public static final String EBT_BAL_INQ_REJECT = "EBT_BAL_INQ_REJECT";
    public static final String EBT_VOUCHER_REJECT = "EBT_VOUCHER_REJECT";
    public static final String EBT_REJECT_REASON = "EBT_REJECT_REASON";
    public static final String PRN_OUT_OF_PAPER = "PrnOutOfPaper";
    public static final String PRN_OFFLINE = "PrnOffline";
    public static final String PRN_UNAVAILABLE = "PrnUnavailable";
    public static final String NO_COMPLETION = "NoCompletion";
    public static final String PREPAID_NOT_ALLOWED = "PrepaidNotAllowed";
    public static final String PREPAID_ACT_CONFLICT = "PrepaidActConflict";
    public static final String PREPAID_RCG_CONFLICT = "PrepaidRcgConflict";
    public static final String ACT_RCG_FAILED = "ActRcgFailed";
    public static final String PERFORM_REFUND = "PerformRefund";
    public static final String PRIMARY_APPROVAL = "PrimaryApproval";
    public static final String MTEC_APPROVAL = "MtecApproval";
    public static final String REG_CLOSED = "RegClosed";
    public static final String REG_CLOSED_MX870 = "RegClosedMx870";
    public static final String AVAILABLE_BALANCE = "AvailableBalance";
    public static final String BALANCE_INQUIRY = "BalanceInquiry";
    public static final String ASK_FOR_CARD = "AskForCard";
    public static final String FOLLOW_STORE_PROC = "FollowStoreProc";
    public static final String PREPAID_REV_FAIL = "PrepaidRevFail";
    public static final String CREDIT_REV_FAIL = "CreditRevFail";
    public static final String IMAGE_TIFF = "ImageTiff";
    public static final String FORWARD_EPS = "ForwardEps";
    public static final String ASK_CUSTOMER_SWIPE = "AskCustomerSwipe";
    public static final String ASK_CUSTOMER_ACTIVATE = "AskCustomerActivate";
    public static final String ASK_CUSTOMER_DEACTIVATE = "AskCustomerDeActivate";
    public static final String COLLECT_SENT = "CollectSent";
    public static final String FOLLOW_PINPAD = "FollowPinpad";
    public static final String MUST_TENDER_TO_CASH = "MUST_TENDER_TO_CASH";
    public static final String ASK_CUSTOMER_RECHARGE = "AskCustomerRecharge";
    public static final String ASK_CUSTOMER_DERECHARGE = "AskCustomerDeRecharge";
    public static final String PINPAD_UNAVAILABLE = "PINPAD_UNAVAILABLE";
    public static final String EPS_LOGIN_FAILED = "EPS_LOGIN_FAILED";
    public static final String INITIALIZE_VOUCHER = "INITIALIZE_VOUCHER";
    public static final String FINALIZE_VOUCHER = "FINALIZE_VOUCHER";
    public static final String ACKNOWLEDGE_VOUCHER = "ACKNOWLEDGE_VOUCHER";
    public static final String CANCEL_VOUCHER = "CANCEL_VOUCHER";
    public static final String UPOPCARD_EXCEED = "UPOPCARD_EXCEED";
    public static final String UPOPCARD_DISCARD = "UPOPCARD_DISCARD";
    public static final String SEND_REVERSAL = "SEND_REVERSAL";
    public static final String HOLD_CARD = "HOLD_CARD"; 
    public static final String ASTERISKS = "ASTERISKS";
    public static final String ACT_RECH = "ACT_RECH";
    public static final String FAILED = "FAILED";
    public static final String ISSUE_REFUND = "ISSUE_REFUND";
    public static final String PLEASE_REFUND = "PLEASE_REFUND";    
    public static final String RCPT_DASHES = "RCPT_DASHES";
    public static final String GIFT_ACT_FAILED = "GIFT_ACT_FAILED";
    public static final String GIFT_RECH_FAILED = "GIFT_RECH_FAILED";  
    public static final String ACCT 			= "ACCT";
    public static final String EPSPREPAID_EVALUATION_FAILED = "EPSPREPAID_EVALUATION_FAILED";
    public static final String EPSPREPAID_PROCESSING_FAILED = "EPSPREPAID_PROCESSING_FAILED";
    public static final String EPSPREPAID_REFUND_FAILED = "EPSPREPAID_REFUND_FAILED";
    public static final String REFUND_REQUIRED = "REFUND_REQUIRED";
    public static final String REFUND_NOT_REQUIRED = "REFUND_NOT_REQUIRED";
    public static final String REFUND_NOT_DONE = "REFUND_NOT_DONE";
    public static final String INVALID_SERIAL = "INVALID_SERIAL";
    public static final String CONFIRM_RESCAN = "Rescan";
    public static final String EVALUATE_REQUEST = "Evaluatingprepaidcard";
    public static final String REFUND_REQUEST = "Deactivatingprepaidcard";
    public static final String ACTIVATION_REQUEST = "Activatingprepaidcard";
    public static final String COMPLETION_FAILED = "CompletionFailed";
    public static final String MOBILE_REPORTS = "MOBILE_REPORTS";
    public static final String VOID_ACT_FAILED = "VOID_ACT_FAILED";
    public static final String VOID_RECH_FAILED = "VOID_RECH_FAILED";
    public static final String VOID_ACT_MENUITEM = "VOID_ACT_MENUITEM" ;
    public static final String VOID_RECH_MENUITEM = "VOID_RECH_MENUITEM" ;
    public static final String REFUND_ACT_MENUITEM = "REFUND_ACT_MENUITEM" ;
    public static final String REFUND_OP_FAILED = "REFUND_OP_FAILED" ;
    public static final String FINADVICE_RETRY = "FINADVICE_RETRY";
    public static final String TRY_LATER = "TRY_LATER";
    public static final String CASH_OUT = "CASH_OUT";
    public static final String EMPTY_TRANS = "EMPTY_TRANS";
    public static final String MOBILE_AUTH_COMPLETION = "AUTH_COMPLETION";
    public static final String FORWARDING_TO_MOBILE = "FORWARDING_TO_MOBILE";
    public static final String PRICE_TIER_CONFLICT_FOR = "PRICE_TIER_CONFLICT_FOR";
    public static final String ZERO_BALANCE_WARNING = "ZERO_BALANCE_WARNING";
    public static final String SKIP_CARD_PAYMENT = "SKIP_CARD_PAYMENT"; 
// All Mobile ASA transaction card Type should be prefixed by # 
    public final static String ASA_CARDTYPE_PREFIX=		"ASA_CARDTYPE_PREFIX";
    public final static String ASA_TRANSCATION_NOTE = 	"ASA_TRANSCATION_NOTE";    
// Default program names for various loyalty programs
    public static final String DEFAULT_EPS_LOYALTY = "DEFAULT_EPS_LOYALTY";
    public static final String DEFAULT_EPS_HOST_DISCOUNT = "DEFAULT_EPS_HOST_DISCOUNT";
    public static final String DEFAULT_ASA_LOYALTY = "DEFAULT_ASA_LOYALTY";
    public static final String DEFAULT_ASA_HOST_DISCOUNT = "DEFAULT_ASA_HOST_DISCOUNT";
	public static final String CARD_TYPE = "CARD_TYPE";
	public static final String ACCT_NUMBER = "ACCT_NUMBER";
	public static final String TICKET_NUM = "TICKET_NUM";
	public static final String ENTRY_MODE = "ENTRY_MODE";
	public static final String DATE = "DATE";
	public static final String TIME = "TIME";
	public static final String REQUEST_TIMEDOUT = "REQUEST_TIMEDOUT";
	public static final String VIRTUAL_POS_REGISTERS_ARE_BUSY = "VIRTUAL_POS_REGISTERS_ARE_BUSY";
	public static final String UNABLE_TO_PROCESS_MOBILE_REQUEST = "UNABLE_TO_PROCESS_MOBILE_REQUEST";
	public static final String PAYMENT_NOT_PROCESSED = "PAYMENT_NOT_PROCESSED";
	public static final String ITEM_NOT_ALLOWED = "ITEM_NOT_ALLOWED";
	public static final String SALE_EVALUATION_FAILED = "SALE_EVALUATION_FAILED";
	public static final String AUTH_AMOUNT_LESS_THAN_TXN_AMOUNT = "AUTH_AMOUNT_LESS_THAN_TXN_AMOUNT";
	public static final String CW_CODE_NOT_GENERATED = "CW_CODE_NOT_GENERATED";
	public static final String INVALID_CARWASH_SALE_ITEM_IN_AUTH = "INVALID_CARWASH_SALE_ITEM_IN_AUTH";
    public static final String CARD_PAYMENT_FAILED = "CARD_PAYMENT_FAILED";
	public static final String MISSING_MANDATORY_DATA_IN_AUTH = "MISSING_MANDATORY_DATA_IN_AUTH";
	public static final String ACCESS_RESTRICTED = "ACCESS_RESTRICTED";
	public static final String INVALID_DATA_IN_AUTH = "INVALID_DATA_IN_AUTH";
	public static final String MOBILE_AUTH_FAILED = "MOBILE_AUTH_FAILED";
	public static final String CONNECTION_ERROR = "CONNECTION_ERROR";
	public static final String MOBILE_AUTH_RESP_NOT_SENT = "MOBILE_AUTH_RESP_NOT_SENT";
    public static final String NETWORK_REPORTS = "NetworkReports";
    public static final String PRODUCT_NOT_ALLOWED = "ProductNotAllowed";
    public static final String PRINT_PARAMETERS = "PrintParameters";
    public static final String ENTER_INVOICE = "EnterInvoice";
    public static final String INVOICE_NUM_ERR = "InvoiceErr";
    public static final String BYPASS_PROP_CARD = "BypassPropCard";
    public static final String PROP_CARDS_ONLY = "PropCardsOnly";
    public static final String CARD_BALANCE_INQUIRY = "CardBalanceInquiry"; 
    public static final String NETWORK_REPORTS_MENU = "NetworkReportsMenu"; 
    public static final String PRINT_PRODUCT_CODES = "PrintProductCodes"; 
    public static final String UPDATE_POP_CARD_LIST = "UpdatePopCardList"; 
    public static final String DIAGNOSTIC_CHECK_HOST_STATUS = "DiagnosticCheckHostStatus"; 
    public static final String DIAGNOSTIC_POP_INIT = "DiagnosticPopInit"; 
    public static final String DIAGNOSTIC_SEND_OFFLINE_TRANSACTIONS = "DiagnosticSendOfflineTransactions";    
    public static final String  CANCEL_RECEIPT = 		"CANCEL_RECEIPT";
    public static final String  ENTER_TICKET = 	 		"ENTER_TICKET";
    public static final String  ENTER_ACCT_CARD	=		"ENTER_ACCT_CARD";
    public static final String  ENTER_PASSWORD = 		"ENTER_PASSWORD";
    public static final String  INVALID_ACCOUNT =		"INVALID_ACCOUNT";
    public static final String  INVALID_TICKET =		"INVALID_TICKET";
    public static final String  INVALID_PASSWORD =		"INVALID_PASSWORD";
    public static final String  NETWORK_NOT_INITIALIZED = "NETWORK_NOT_INITIALIZED";
    public static final String CC_PFLEET_NO_EXP = "ccPFleetNoExp";
    public static final String CC_PFLEET_DATA = "ccPFleetData";
    public static final String CC_PFLEET_REF = "CC_PFLEET_REF";
    public static final String EPS_NETWORK_REPORTS = "EPSNetworkReports";
    public static final String EPS_SECURE_REPORTS = "EPSSecureReports";
    public static final String EPS_NETWORK_FUNCTION= "EPSNetworkFunctions";
    public static final String EPS_DEALER_CONFIGURATION= "EPSDealerConfiguration";
    public static final String VIPER_UNAVAILABLE="VIPER_UNAVAILABLE";
    public static final String EPS_FORWARD_MSG="EPS_FORWARD_MSG";
    public static final String EPS_NETWORK_MANAGER_FUNCTION= "EPSNetworkManagerFunctions";
    public static final String EPS_SECURE_NETWORK_MANAGER_FUNCTION= "EPSSecureNetworkManagerFunctions";
    public static final String EBT_VOUCHER_CLEAR= "EBTVoucherClear";
    public static final String DIAGNOSTIC_NETWORK_CHIME = "DiagnosticNetworkChime";
    public static final String SEND_MAIL = "SendMail";
    public static final String EPS_ALL_REPORTS = "EPSAllReports";
    public static final String LOYALTY_BALANCE_INQUIRY_MENU = "LoyaltyBalanceInquiry";
    public static final String PRE_AUTHORIZATION = "PreAuthorization";
    public static final String REFRESH_EPS_CONFIG  = "RefreshEpsConfiguration";
    public static final String PROPRIETARY_NETMGR_MENU  = "ProprietaryNetworkMenu";
    public static final String PLEASE_SWIPE_CARD	= "PLEASE_SWIPE_CARD";
    public static final String CHARITY_DONATIONS	= "CHARITY_DONATIONS";
    public static final String CHARITY_PROMTING_ON_PINPAD	= "CHARITY_PROMTING_ON_PINPAD";
    public static final String CHARITY_PINPAD_MESSAGE	= "CHARITY_PINPAD_MESSAGE";
    public static final String CHARITY_NO_CHARITY	= "CHARITY_NO_CHARITY";
    
    

    /**
     * Accessor for the actual strings that have been internationalized.
     */
    @Override
	public Object[][] getContents() {
        return contents;
    }
    
    protected Object[][] contents = {
        { ACTIVATION_REQUEST,       "Processing the prepaid product" },
        { EVALUATE_REQUEST,         "Evaluating the prepaid product" },
        { REFUND_REQUEST,           "De-activating the prepaid product" },	
        { CONFIRM_RESCAN,           "Rescan?" },	
        { PROMPT_DRIVER_ID,         "ENTER DRIVER ID" },
        { PROMPT_VEHICLE,           "ENTER VEHICLE" },
        { PROMPT_ODOMETER,          "ENTER ODOMETER" },
        { PROMPT_LICENSE,           "ENTER DRIVER LICENSE" },
        { PROMPT_JOB_NO,            "ENTER JOB ID" },
        { PROMPT_DATA,              "ENTER DATA" },
        { PROMPT_DEPT,              "ENTER DEPT" },
        { PROMPT_PIN,               "ENTER PIN" },
        { PROMPT_REF_NO,            "ENTER REFERENCE #" },
        { PROMPT_USER_ID,           "ENTER USER ID" },
        { PROMPT_ZIP_CODE,          "ENTER ZIP CODE" },
        { PROMPT_STREET,            "ENTER STREET #" },
        { PROMPT_VISIBLE_DRIVER_ID, "ENTER DRIVER ID" },
        { PROMPT_ID_NUMBER,         "ENTER ID NUMBER" },
        { PROMPT_CUST_CODE,         "ENTER SECURITY CODE" },
        { PROMPT_SOC_SEC,           "ENTER SOC SEC #" },
        { PROMPT_EMP_NUM,           "ENTER EMP #" },
        { PROMPT_CLIENT_NUM,        "ENTER CLIENT #" },
        { PROMPT_TRAILER_ID,        "ENTER TRAILER ID" },
        { PROMPT_HUBOMETER ,        "ENTER HUB" },
        { INVALID_RES,              "INVALID_" },
        { INVALID_DRIVER_ID,        "INVALID DRIVER ID" },
        { INVALID_VEHICLE,          "INVALID VEHICLE" },
        { INVALID_ODOMETER,         "INVALID ODOMETER" },
        { INVALID_LICENSE,          "INVALID DRIVER LICENSE" },
        { INVALID_JOB_NO,           "INVALID JOB ID" },
        { INVALID_DATA,             "INVALID DATA" },
        { INVALID_DEPT,             "INVALID DEPT" },
        { INVALID_PIN,              "INVALID PIN" },
        { INVALID_REF_NO,           "INVALID REFERENCE #" },
        { INVALID_USER_ID,          "INVALID USER ID" },
        { INVALID_ZIP_CODE,         "INVALID ZIP CODE" },
        { INVALID_STREET,           "INVALID STREET #" },
        { INVALID_VISIBLE_DRIVER_ID, "INVALID DRIVER ID" },
        { INVALID_ID_NUMBER,        "INVALID ID NUMBER" },
        { INVALID_CUST_CODE,        "INVALID SECURITY CODE" },
        { INVALID_SOC_SEC,          "INVALID SOC SEC #" },
        { INVALID_EMP_NUM,          "INVALID EMP #" },
        { INVALID_CLIENT_NUM,       "INVALID CLIENT #" },
        { INVALID_TRAILER_ID,       "INVALID TRAILER ID" },
        { INVALID_HUBOMETER ,       "INVALID HUB" },
        { PROMPT_LAST4,				"Enter last 4 digits of account" },
        { LAST4_MISMATCH, 			"Account Number Mismatch" },
        { PAYMENT_TIME,             "  PAYMENT TIME: " },
        { BATCH_DETAILS_MENU,       "Batch Details Menu" },
        { QUICK_CREDIT,             "Quick Credit" },
        { PRINT_NET_LOG,            "Print Network Log" },
        { ACTIVATE_PREPAID_CARD,    "Activate Prepaid Card" },
        { REPLENISH_PREPAID_CARD,   "Replenish Prepaid Card" },
        { EBT_BALANCE_INQUIRY,      "EBT Balance Inquiry" },
        { EBT_VOUCHER,              "EBT Voucher" },
        { ACTIVATE_PREPAID_PROMPT,  "Enter Activation Amount:" },
        { REPLENISH_PREPAID_PROMPT, "Enter Replenish Amount:" },
        { INVALID_AMOUNT_ENTERED,   "Invalid Amount Entered" },
        { RFND_REF_NUM,             "Enter Original Reference #" },
        { RFND_SALE_DATE,           "Enter Original Sale Date" },
        { RFND_SALE_TIME,           "Enter Original Sale Time" },
        { RFND_TRACE_AUDIT,         "Enter System Trace Audit #" },
        { USE_IMPRINTER_RCPT,       "USE IMPRINTER, APPROVAL " },
        { SEND_COMPLETION,          "Sending Completion" },
        { ACCT_CONFIRM, 			"Verify Account Number" },
        { RETRIES_EXCEED,			"Maximum Retries Exceeded" },
        { PP_SELECT,          		"Choose Y/N on PinPad" },
        { DEB_CASHBACK,          	"For Cashback Prompt" },
        { PP_CASHBACK_OPTION,       "CASHBACK YES/NO?" },
        { PP_YES_NO,          		"  NO        YES" },
        { CALL_PHONE_NR,			"Call " },
        { FOR_VOICE_AUTH,			"for voice auth" },
        { ON_PINPAD,				" on PinPad" },
        { ENTER_CASHBACK,			"Enter Cashback" },
        { CHK_NONE, "No special validation"},
        { CHK_LUHN, "Perform simple luhn check"},
        { CHK_MASTERCARD, "Check MC restrictions"},
        { CHK_WXPRESS, "Check Wright Express restrictions"},
        { CHK_VISA, "Check VISA restrictions"},
        { CHK_CUSTOM, "Check custom card restrictions"},
        { CHK_CALIF, "Check california card"},
        { CHK_PHH, "Check phh card restrictions"},
        { CHK_IAS, "Check int'l automated card restrictions"},
        { CHK_AMOCO, "Check Amoco card restrictions"},
        { CHK_AMOCO_MULTI , "Check Amoco Multi card restrictions"},
        { CHK_UNIVERSAL, "Check Universal card restrictions"},
        { CHK_DISCOVER, "Check Discover card restrictions"},
        { CHK_GSA, "Check GSA card restrictions"},
        { CHK_VOYAGER, "Check Voyager card restrictions"},
        { CHK_AMEX, "Check Amex card restrictions"},
        { CHK_FMGC, "Check FuelmanGas Original card restrictions"},
        { CHK_FUELMN, "Check Fuelman card restrictions"},
        { CHK_DONLN, "Check Donlen card restrictions"},
        { CHK_MCFLT, "Check MC Fleet card restrictions"},
        { CHK_MCPURC, "Check MC Purchase card restrictions"},
        { CHK_PREPAID, "Check Prepaid card restrictions"},
        { CHK_VISAFLT, "Check Visa Fleet card restrictions"},
        { CHK_ENMARK, "Check Enmark card restrictions"},
        { CHK_PNS, "Check Paymentech Private Label card restrictions"},
        { CHK_MOTOMART, "Check Motomart card restrictions"},
        { CHK_GATE, "Check Gate card restrictions"},
        {  ISO_RECORDS, "ISO Records"},
        {  SELECT_RECORD, "Select ISO Record"},
        { BAD_CARD_RETRY,	"Bad Card Read, Please Retry" },
        { PP_ACT_INSTR,  "PpActInstr"},
        { EBT_BAL_INQ,              "EBT BALANCE INQUIRY"},
        { EBT_VOUCHER_CLR,          "EBT VOUCHER CLEAR"},
        { EBT_VOUCHER_RETURN,       "EBT VOUCHER RETURN"},
        { CASH_BAL,                 "  Cash              "},
        { FOODSTAMP_BAL,            "  Food Stamp        "},
        { AMOUNT,                   "  AMOUNT:"},
        { APPROVAL_NUM,             "  APPROVAL# "},
        { VOUCHER_NUM,              "  VOUCHER # : "},
        { EBT_BAL_INQ_REJECT,       "  EBT BALANCE INQUIRY REJECTED"},
        { EBT_VOUCHER_REJECT,       "  EBT VOUCHER CLEAR REJECTED"},
        { EBT_REJECT_REASON,        "  Reject Reason:"},
        { ADD_ITEM_MOP,				"Add Item or Select MOP" },
        { PRN_OUT_OF_PAPER,			"Printer out of paper" },
        { PRN_OFFLINE,				"Printer offline" },
        { PRN_UNAVAILABLE,			"Printer unavailable" },
        { ENTER_LICENSE,			"Enter Driver License" },
        { NO_COMPLETION,			"Settling Fuel Transaction" },
        { IS_DEBIT_CARD,            "Debit card [Y/N]?" },
        { DEBIT_MOP,				"Debit" },
        { TIMEOUT,					"Timeout" },
        { ERROR,					"Error" },
        { PREPAID_NOT_ALLOWED,		"Prepaid Cards Not Allowed" },
        { PREPAID_ACT_CONFLICT, 	"Card Activated in Sale, not allowed" },
        { PREPAID_RCG_CONFLICT,		"Card Recharged in Sale, not allowed" },
        { ACT_RCG_FAILED,			"Activation/Recharge Failed" },
        { PERFORM_REFUND,			"Press ENTER to perform refunds" },
        { PRIMARY_APPROVAL,			"Approval # " },
        { MTEC_APPROVAL,			"Approved for Net 2" },
        { REG_CLOSED,				"    REGISTER         CLOSED" },
        { REG_CLOSED_MX870,			"REGISTER CLOSED" },
        {ASK_FOR_CARD,  "Ask the customer for all cards"},
        {FOLLOW_STORE_PROC, "Please follow store procedure"},
        {PREPAID_REV_FAIL, "Reversal of prepaid card activation failed"},
        {CREDIT_REV_FAIL, "Reversal of credit card payment failed"},
        { AVAILABLE_BALANCE,		"  AVAILABLE BALANCE: " },
        { BALANCE_INQUIRY,          "BALANCE INQUIRY" },
        { IMAGE_TIFF,				"image/tiff" },
        { FORWARD_EPS,				"Forwarding to EPS..." },
        { ASK_CUSTOMER_SWIPE,		"Ask customer to swipe/insert card" },
        { ASK_CUSTOMER_ACTIVATE,	"Ask customer to activate card" },
        { ASK_CUSTOMER_DEACTIVATE,	"Ask customer to deactivate card" },
        { COLLECT_SENT,				"Sending prepay completion to the host" },
        { FOLLOW_PINPAD,			"Follow PINpad instructions" },
        { ASK_CUSTOMER_RECHARGE,	"Ask customer to recharge card" },
        { ASK_CUSTOMER_DERECHARGE,	"Ask customer to derecharge card" },
        { MUST_TENDER_TO_CASH,      "Must tender to CASH"},
        { PINPAD_UNAVAILABLE, 		"PINpad unavailable"},
        { EPS_LOGIN_FAILED, 		"Unable to login to EPS Network"},
        { UPOPCARD_EXCEED, 			"Update card list after period close"},
        { UPOPCARD_DISCARD, 		" primary cards max, dropping "},
        { SEND_REVERSAL,			"SENDING REVERSAL" },
        { HOLD_CARD,				"HOLD CARD AND WAIT" },        
        {ASTERISKS,					"********************"},
        {ACT_RECH, 					"ACTIVATION/RECHARGE"},
        {FAILED, 					"FAILED"},
        {ISSUE_REFUND, 				"***PENDING REFUNDS***"},
        {PLEASE_REFUND, 			"Please Refund the Amount"},        
        {RCPT_DASHES,				"----------------------------------------"},
        {GIFT_ACT_FAILED, 			"GIFT CARD ACTIVATION FAILED"},
        {GIFT_RECH_FAILED,			"GIFT CARD RECHARGE   FAILED"},
        {ACCT,						"Acct: "},
        {EPSPREPAID_EVALUATION_FAILED, "EPSPREPAID EVALUATION FAILED"},
        {EPSPREPAID_PROCESSING_FAILED, "EPSPREPAID PROCESSING FAILED"},
        {EPSPREPAID_REFUND_FAILED, "EPSPREPAID REFUND FAILED"},
        {REFUND_REQUIRED,			"REFUND REQUIRED"},
        {REFUND_NOT_REQUIRED,		"REFUND NOT REQUIRED"},
        {REFUND_NOT_DONE,		    "REFUND NOT DONE"},
        {VOID_ACT_FAILED, 			"VOID ACTIVATION FAILED"},
        {VOID_RECH_FAILED,			"VOID RECHARGE FAILED"},
        {INVALID_SERIAL,       		"Invalid Serial Number"},
        {VOID_ACT_MENUITEM,			"1. Void Activation"},
        {VOID_RECH_MENUITEM,		"2. Void Recharge"},
        {REFUND_ACT_MENUITEM,		"3. Refund Failed Act/Rech"},
        {REFUND_OP_FAILED,			"REFUND OPERATION FAILED"},
        {FINADVICE_RETRY,			"Try completion later or Cash out"},
        {TRY_LATER,					"TRY LATER"},
        {CASH_OUT,					"CASH OUT"},
        {INVALID_SERIAL,       "Invalid Serial Number"},
        {COMPLETION_FAILED,		"Completion attempt already failed"},
        {EMPTY_TRANS, 			"Empty Transaction: No Items Present"},
        {MOBILE_REPORTS,          "MOBILE REPORTS"},
        {MOBILE_AUTH_COMPLETION, "Sending Auth Completion to Host"},
        {FORWARDING_TO_MOBILE, "Forwarding to mobile service"},
        {PRICE_TIER_CONFLICT_FOR, "PRICE TIER CONFLICT FOR"},
        {ZERO_BALANCE_WARNING,		"Transaction balance fully paid"},
        {SKIP_CARD_PAYMENT, 		"Card payment not needed"},
        {ASA_CARDTYPE_PREFIX,      "^"},
        {ASA_TRANSCATION_NOTE, 	   "Mobile ASA Transactions"},
        {DEFAULT_EPS_LOYALTY,		"EPS Loyalty"},
        {DEFAULT_EPS_HOST_DISCOUNT,		"EPS Host Discount"},
        {DEFAULT_ASA_LOYALTY,		"Above Site Loyalty"},
        {DEFAULT_ASA_HOST_DISCOUNT,		"Above Site Discount"},
		{CARD_TYPE, 				"CARD TYPE"},
		{ACCT_NUMBER, 				"ACCT#"},
		{TICKET_NUM, 				"TICKET NUM#"},
		{ENTRY_MODE, 				"ENTRY MODE"},
		{DATE, 						"DATE"},
		{TIME, 						"TIME"},
		{REQUEST_TIMEDOUT, 			"Request Timed out."},
		{VIRTUAL_POS_REGISTERS_ARE_BUSY, 	"All Virtual POS Registers are busy"},
		{UNABLE_TO_PROCESS_MOBILE_REQUEST, 	"Unable to process Mobile Request"},
		{PAYMENT_NOT_PROCESSED, 	"Payment could not be processed"},
		{ITEM_NOT_ALLOWED, 			"Item not allowed"},
		{SALE_EVALUATION_FAILED, 	"Sale evaluation failed"},
		{AUTH_AMOUNT_LESS_THAN_TXN_AMOUNT, 	"Auth amount is less than transaction amount"},
		{CW_CODE_NOT_GENERATED, 	"Carwash Code could not be generated"},
		{INVALID_CARWASH_SALE_ITEM_IN_AUTH, "Invalid Carwash Sale Item in auth request"},
		{CARD_PAYMENT_FAILED, 		"Card Read/Payment Failed"},
		{MISSING_MANDATORY_DATA_IN_AUTH, 	"Missing mandatory data in auth request"},
		{ACCESS_RESTRICTED, 		"Access Retricted"},
		{INVALID_DATA_IN_AUTH, 		"Invalid data in auth request"},
		{MOBILE_AUTH_FAILED, 		"MOBILE AUTH FAILED"},
		{CONNECTION_ERROR, 			"Connection Error."},
		{MOBILE_AUTH_RESP_NOT_SENT, "Mobile auth response could not be sent"},
        {INITIALIZE_VOUCHER, 		"Verifying Voucher"},
        {FINALIZE_VOUCHER,			"Finalizing Voucher"},
        {ACKNOWLEDGE_VOUCHER,		"Acknowledging Voucher"},
        {CANCEL_VOUCHER,			"Canceling Voucher"},
        { NETWORK_REPORTS,          "Network Reports" },
        { PRODUCT_NOT_ALLOWED, 	    "Invalid Product for this Card Type"},
        { PRINT_PARAMETERS,         "Print Parameters" },
        { ENTER_INVOICE,			"Enter Invoice Number" },
        { INVOICE_NUM_ERR, 			"Invoice must be 7 characters" },
        { BYPASS_PROP_CARD, 		"Press Enter for Proprietary Card" },
        { PROP_CARDS_ONLY,			"Must Swipe Proprietary Card" },
        { CARD_BALANCE_INQUIRY,      			"Card Balance Inquiry" },
        { NETWORK_REPORTS_MENU,      			"Network Reports Menu" },
        { PRINT_PRODUCT_CODES,      			"Print Product Codes" },
        { UPDATE_POP_CARD_LIST,      			"Update Pop Card List" },
        { DIAGNOSTIC_CHECK_HOST_STATUS,      	"Diagnostic Check Host Status" },
        { DIAGNOSTIC_POP_INIT,       			"Diagnostic Pop Init" },
        { DIAGNOSTIC_SEND_OFFLINE_TRANSACTIONS, "Send Offline Transactions" },        	
        { CANCEL_RECEIPT,           "CANCEL RECEIPT"},
        { ENTER_TICKET, 			"ENTER TICKET NUMBER"},
        { ENTER_ACCT_CARD, 			"ENTER ACCOUNT / CARD NUMBER"},
        { ENTER_PASSWORD, 			"ENTER PASSWORD"},
        { INVALID_ACCOUNT, 			"INVALID ACCOUNT"},
        { INVALID_TICKET, 			"INVALID TICKET"},
        { INVALID_PASSWORD, 		"INVALID PASSWORD"},                
        { NETWORK_NOT_INITIALIZED, 	"NETWORK NOT INITIALIZED"},
        { CC_PFLEET_NO_EXP,         "            " },
        { CC_PFLEET_DATA,           "  CARD DATA: " },
        { CC_PFLEET_REF,		  	"                      INV#: "},
        { EPS_NETWORK_REPORTS,          "EPS Network Reports" },
        { EPS_SECURE_REPORTS,          "EPS Secure Reports" },
        { EPS_NETWORK_FUNCTION,          "EPS Network Functions" },
        { EPS_DEALER_CONFIGURATION,          "Dealer Configuration" },
        { VIPER_UNAVAILABLE,          "EPS Network Unavailable" },
        { EPS_FORWARD_MSG,          "Forwarding To EPS" },
        { EPS_NETWORK_MANAGER_FUNCTION, "EPS Network Manager Functions"},
        { EPS_SECURE_NETWORK_MANAGER_FUNCTION, "EPS Secure Network Manager Functions"},
        { EBT_VOUCHER_CLEAR, "EBT Voucher Clear"},
        {DIAGNOSTIC_NETWORK_CHIME, "Network Chime"},
        {SEND_MAIL, "Send Mail"},
        {EPS_ALL_REPORTS, "EPS All Reports"},
        {LOYALTY_BALANCE_INQUIRY_MENU, "Loyalty Balance Inquiry"},
        {PRE_AUTHORIZATION, "Pre-Authorization"},
        {REFRESH_EPS_CONFIG, "Refresh EPS Configuration"},
        {PROPRIETARY_NETMGR_MENU, "Proprietary Network Menu"},
        {PLEASE_SWIPE_CARD, "Please swipe/insert Card"},
        {CHARITY_DONATIONS,"Charity Donation"},
        {CHARITY_PROMTING_ON_PINPAD,"Charity is being prompted on PinPad"},
        {CHARITY_PINPAD_MESSAGE,"Would you like to donate to " },	
        {CHARITY_NO_CHARITY,"No Thanks"}
    };
}
