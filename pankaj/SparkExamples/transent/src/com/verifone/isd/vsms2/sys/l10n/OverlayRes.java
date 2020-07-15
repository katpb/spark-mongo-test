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

public class OverlayRes extends ListResourceBundle {
	public final static String	STARTING_DRAWER_AMOUNT      = "STARTING_DRAWER_AMOUNT";
	public final static String	ITEM_CANNT_SOLD_TIME        = "ITEM_CANNT_SOLD_TIME";
	public final static String	PRESS_ENTER_TO_ACK          = "PRESS_ENTER_TO_ACK";
	public final static String	ITEM_CANNT_BE_SOLD          = "ITEM_CANNT_BE_SOLD";
	public final static String	ENTER_PRICE                 = "ENTER_PRICE";
	public final static String	ENTER_BIRTH_DATE            = "ENTER_BIRTH_DATE";
	public final static String	MUST_BE_BORN_BEFORE         = "MUST_BE_BORN_BEFORE";
	public final static String	ASSOCIATED_RESTRICTION      = "ASSOCIATED_RESTRICTION";
	public final static String	CANNT_SOLD_ITEM_CUSTOMER    = "CANNT_SOLD_ITEM_CUSTOMER";
	public final static String	SWIPE_CARD                  = "SWIPE_CARD";
	public final static String	SWIPE_CARD_OR_ENTER_ACC     = "SWIPE_CARD_OR_ENTER_ACC";
	public final static String	ENTER_ACCT_NUM     			= "ENTER_ACCT_NUM";
	public final static String	SWIPE_NEXT_CARD             = "SWIPE_NEXT_CARD";
	public final static String	SWIPE_NEXT_CARD_ENTER_ACC   = "SWIPE_NEXT_CARD_ENTER_ACC";
	public final static String	ENTER_EXPIRATION_DATE       = "ENTER_EXPIRATION_DATE";
	public final static String  ENTER_AUTH_NUMBER			= "EnterAuthNumber";
	public final static String  ACCOUNT_NUMBER              = "ACCOUNT_NUMBER";
	public final static String	PROCESSING_CARD             = "PROCESSING_CARD";
	public final static String	DIALING                     = "DIALING";
	public final static String	CONNECTING                  = "CONNECTING";
	public final static String	AUTHORIZING                 = "AUTHORIZING";
	public final static String	TRANSMITTING                = "TRANSMITTING";
	public final static String	RECEIVING                   = "RECEIVING";
	public final static String	PLEASE_WAIT                 = "PLEASE_WAIT";
	public final static String	APPROVED                    = "APPROVED";
	public final static String	CARD_EXPIRED                = "CARD_EXPIRED";
	public final static String	CARD_INVALID                = "CARD_INVALID";
	public final static String	CARD_BAD_READ               = "CARD_BAD_READ";
	public final static String	WRONG_CARD_TYPE             = "WRONG_CARD_TYPE";
	public final static String	CARD_NOT_ALLOWED            = "CARD_NOT_ALLOWED";
	public final static String	ACCT_NBR_ERR                = "ACCT_NBR_ERR";
	public final static String	INVALID_SVC_CODE            = "INVALID_SVC_CODE";
	public final static String	INVALID_TRK_DATA            = "INVALID_TRK_DATA";
	public final static String	INVALID_USER_DATA            = "INVALID_USER_DATA";
	public final static String	NO_MANUAL_ENTRY             = "NO_MANUAL_ENTRY";
	public static final String  OVERLAY_REVIEW_FOOTER       = "OVERLAY_REVIEW_FOOTER";
	public static final String  SELECT_DIAGNOSTICS_TYPE       = "SELECT_DIAGNOSTICS_TYPE";
	public static final String  INVALID_PROD_FOR_CARD_TYPE	= "INVALID_PROD_FOR_CARD_TYPE";

	public final static String	PCHECK_HEADING              = "PCHECK_HEADING";
	public final static String	PCHECK_PROMPT_1             = "PCHECK_PROMPT_1";
	public final static String	PCHECK_PROMPT_2             = "PCHECK_PROMPT_2";
	public final static String	PLUNF_HEADING               = "PLUNF_HEADING";
	public final static String	PLUNF_PROMPT_1              = "PLUNF_PROMPT_1";
	public final static String	PLUNF_PROMPT_2              = "PLUNF_PROMPT_2";
	public final static String	PLUNF_PROMPT_3              = "PLUNF_PROMPT_3";
	public final static String	PLUOP_HEADING               = "PLUOP_HEADING";
	public final static String	MPLU_HEADING               = "MPLU_HEADING";
	public final static String	MPLU_PROMPT_1               = "MPLU_PROMPT_1";

	public final static String  CASHBACK_REQUIRED           = "CASHBACK_REQUIRED";
	public final static String  ENTER_CASHBACK_AMT          = "ENTER_CASHBACK_AMT";
	public final static String  ENTER_CASHBACK_FEE          = "ENTER_CASHBACK_FEE";
	public final static String  CASHBACK_LIMIT_EXCEED       = "CASHBACK_LIMIT_EXCEED";
	public final static String  ENTER_PIN_PINPAD            = "ENTER_PIN_PINPAD";
	public final static String  USE_PINPAD_NOW              = "USE_PINPAD_NOW";
	public final static String  MOP_CONFLICT                = "MOP_CONFLICT";
	public final static String  CUSTOMER_CHOICE             = "CUSTOMER_CHOICE";
	public final static String  CHECK_PINPAD                = "CHECK_PINPAD";
	public final static String  CLEAR_PINPAD                = "CLEAR_PINPAD";
	public final static String  CANCEL_PINPAD_SESSION       = "CANCEL_PINPAD_SESSION";
	public final static String  READ_PINPAD                 = "READ_PINPAD";
	public final static String  SELECT_PINPAD               = "SELECT_PINPAD";
	public final static String  SC5000_EVEREST              = "SC5000_EVEREST";
	public final static String  CHECK_PP_MOP                = "CHECK_PP_MOP";
	public final static String  ENTER_TKT_NUMBER            = "ENTER_TKT_NUMBER";
	public final static String  ENTER_VEH_NUMBER            = "ENTER_VEH_NUMBER";
	public final static String  FUEL_ONLY_CARD              = "FUEL_ONLY_CARD";
	public final static String  ENTER_RESTRICT_CODE         = "ENTER_RESTRICT_CODE";
	public final static String  INVALID_RESTRICT_CODE       = "INVALID_RESTRICT_CODE";
	public final static String  FUEL_PRODUCTS_ONLY          = "FUEL_PRODUCTS_ONLY";
	public final static String  REFUNDS_NOT_ALLOWED         = "REFUNDS_NOT_ALLOWED";
	public final static String  CARD_DATA_ERROR             = "CARD_DATA_ERROR";
	public final static String  CASH_PROD_DISALLOWED        = "CASH_PROD_DISALLOWED";
	public final static String  MDSE_PROD_DISALLOWED        = "MDSE_PROD_DISALLOWED";
	public final static String  SERV_PROD_DISALLOWED        = "SERV_PROD_DISALLOWED";
	public final static String  TRANSACTION_DENIED          = "TRANSACTION_DENIED";
	public final static String  TRANSACTION_CANCELLED       = "TRANSACTION_CANCELLED";
	public final static String  BAD_CARD_FMT                = "BAD_CARD_FMT";
	public final static String  HOST_UNAVAIL_FMT            = "HOST_UNAVAIL_FMT";
	public final static String  PIN_INVALID                 = "PIN_INVALID";
	public final static String  PIN_ERROR                   = "PIN_ERROR";
	public final static String  TICKET_NUM_ERR              = "TICKET_NUM_ERR";
	public final static String  SAPPHIRE_UNAVAILABLE        = "CONTROLLER_UNAVAILABLE";
	public final static String  ENTER_VOICE_AUTH            = "ENTER_VOICE_AUTH";
	public final static String  UNSUPP_NET_OP               = "UNSUPP_NET_OP";
	public final static String  PRE_AUTH_AMT                = "PRE_AUTH_AMT";
	public final static String  PRE_AUTH_FUEL_AMT           = "PRE_AUTH_FUEL_AMT";
	public final static String  PRE_AUTH_MDSE_AMT           = "PRE_AUTH_MDSE_AMT";
	public final static String  PRE_AUTH_SERV_AMT           = "PRE_AUTH_SERV_AMT";
	public final static String  AUTH_AMT_REQD               = "AUTH_AMT_REQD";
	public final static String  ENTER_ACTIVATION_AMT        = "ENTER_ACTIVATION_AMT";
	public final static String  ENTER_RECHARGE_AMT          = "ENTER_RECHARGE_AMT";
	public final static String  ACTIVATE_FUNC_LATER         = "ACTIVATE_FUNC_LATER";
	public final static String  RECHARGE_FUNC_LATER         = "RECHARGE_FUNC_LATER";
	public final static String  INIT_ACTIVATE               = "INIT_ACTIVATE";
	public final static String  INIT_RECHARGE               = "INIT_RECHARGE";
	public final static String  INIT_DEACTIVATE             = "INIT_DEACTIVATE";
	public final static String  INIT_BAL_QUERY              = "INIT_BAL_QUERY";
	public final static String  INIT_VOID_ACTIVATE          = "INIT_VOID_ACTIVATE";
	public final static String  INIT_VOID_RECHARGE          = "INIT_VOID_RECHARGE";
	public final static String  PREPARE_ACTIVATE            = "PREPARE_ACTIVATE";
	public final static String  PREPARE_RECHARGE            = "PREPARE_RECHARGE";
	public final static String  PREPARE_VOID                = "PREPARE_VOID";
	public final static String  SVC_RANGE_MIN               = "SVC_RANGE_MIN";
	public final static String  SVC_RANGE_MAX               = "SVC_RANGE_MAX";
	public final static String  MUST_BE_SVC                 = "MUST_BE_SVC";
	public static final String  ACTIVATION_SUCCESS          = "ACTIVATION_SUCCESS";
	public static final String  VOID_RECHARGE_SUCCESS       = "VOID_RECHARGE_SUCCESS";
	public static final String  VOID_ACTIVATION_SUCCESS     = "VOID_ACTIVATION_SUCCESS";
	public static final String  RECHARGE_SUCCESS            = "RECHARGE_SUCCESS";
	public static final String  DEACTIVATE_SUCCESS          = "DEACTIVATE_SUCCESS";
	public static final String  VOID_SUCCESS                = "VOID_SUCCESS";
	public static final String  CARD_BALANCE                = "CARD_BALANCE";
	public static final String  APPROVED_AMOUNT             = "APPROVED_AMOUNT";
	public static final String 	INVALID_AMOUNT				= "INVALID_AMOUNT";
	public static final String  ACCEPT_PREAUTH				= "ACCEPT_PREAUTH";
	public static final String  DEACTIVATE_CONFIRM          = "DEACTIVATE_CONFIRM";
	public static final String  RECHARGE_MAXIMUM            = "RECHARGE_MAXIMUM";
	public static final String  BALANCE_EXCEED              = "BALANCE_EXCEED";
	public static final String  RETRIEVE_CARD               = "RETRIEVE_CARD";
	public static final String  ERR_RETRIEVE_CARD           = "ERR_RETRIEVE_CARD";
	public static final String  SVC_SALE_EXCEED             = "SVC_SALE_EXCEED";
	public static final String  SVC_VOID                    = "SVC_VOID";
	public static final String  SVC_CARD_NUM                = "SVC_CARD_NUM";
	public static final String  SVC_VOID_ALL1               = "SVC_VOID_ALL1";
	public static final String  SVC_VOID_ALL2               = "SVC_VOID_ALL2";
	public static final String  SVC_OVERRIDE                = "SVC_OVERRIDE";
	public static final String  CHECK_CARD_BAL              = "CHECK_CARD_BAL";
	public static final String  INSUFF_CARD_BAL             = "INSUFF_CARD_BAL";
	public static final String  REMAIN_TRAN_BAL             = "REMAIN_TRAN_BAL";
	public static final String  UPDATE_PUMP                 = "UPDATE_PUMP";
	public static final String  UPDATE_PUMP_FAIL            = "UPDATE_PUMP_FAIL";
	public static final String  EPS_BUSY_MSG	            = "EPS_BUSY_MSG";

	public static final String HOST_TOTALS_OVERLAY_TITLE    = "HOST_TOTALS_OVERLAY_TITLE";
	public static final String HOST_TOTALS_DATE_PROMPT      = "HOST_TOTALS_DATE_PROMPT";
	public static final String INVALID_DATE                 = "INVALID_DATE";

	public final static String  IS_VISA_CARD                = "IS_VISA_CARD";
	public final static String  IS_SUNOCO_CARD              = "IS_SUNOCO_CARD";
	public final static String  IS_GULF_CARD                = "IS_GULF_CARD";
	public final static String  IS_CENEX_CARD               = "IS_CENEX_CARD";

	public final static String  EXPRESS_SUSPEND              = "EXPRESS_SUSPEND";
	public final static String  EXPRESS_ERROR_CORR           = "EXPRESS_ERROR_CORR";	
	public final static String  EXPRESS_RECALL               = "EXPRESS_RECALL";
	public final static String  EXPRESS_VOID_LINE             = "EXPRESS_VOID_LINE";
	public final static String  EXPRESS_PRICE_CHECK           = "EXPRESS_PRICE_CHECK";
	public final static String  EXPRESS_REPRINT              = "EXPRESS_REPRINT";
	public final static String  EXPRESS_FREPRINT             = "EXPRESS_FREPRINT";
	public final static String  EXPRESS_LOGOFF               = "EXPRESS_LOGOFF";
	public final static String  EXPRESS_LOCKWS               = "EXPRESS_LOCKWS";
	public final static String  EXPRESS_CSRFUNC              = "EXPRESS_CSRFUNC";
	public final static String  EXPRESS_DISMISS_MENU         = "EXPRESS_DISMISS_MENU";
	public final static String  EXPRESS_DISMISS_LIST         = "EXPRESS_DISMISS_LIST";
	public final static String  EXPRESS_DONE				 = "EXPRESS_DONE";
	public static final String  EXPRESS_VIRTUAL_KBD          = "EXPRESS_VIRTUAL_KBD";
	public static final String  EXPRESS_SAVE_CHANGES 	     = "EXPRESS_SAVE_CHANGES";
	public static final String  EXPRESS_DISCARD_CHANGES      = "EXPRESS_DISCARD_CHANGES";
	public static final String  EXPRESS_RETURN_TO_SALES      = "EXPRESS_RETURN_TO_SALES";
    public static final String  EXPRESS_ADVANCED_OPTIONS      = "EXPRESS_ADVANCED_OPTIONS";
    public static final String  EXPRESS_CANCEL     			 = "EXPRESS_CANCEL";
    public static final String  EXPRESS_SHOW_LIST     		 = "EXPRESS_SHOW_LIST";

	public final static String REFUND_CARWASH               = "REFUND_CARWASH";
	public final static String USE_CW_CTRL                  = "USE_CW_CTRL";
	public final static String CW_RAIN_CHECK_CASE2          = "CW_RAIN_CHECK_CASE2";
	public static final String CW_RAIN_CHECK_CASE1 			= "CW_RAIN_CHECK_CASE1";

    public final static String	ADVANCED_SEARCH_HOURS        = "ADVANCED_SEARCH_HOURS";
    public final static String	ADVANCED_SEARCH_NUM_OF_HOURS = "ADVANCED_SEARCH_NUM_OF_HOURS";
    
    public final static String	ADVANCED_SEARCH_DATE_TIME       = "ADVANCED_SEARCH_DATE_TIME";
    public final static String	ADVANCED_SEARCH_DATE = "ADVANCED_SEARCH_DATE";
    public final static String	ADVANCED_SEARCH_TIME = "ADVANCED_SEARCH_TIME";
    public final static String	ADVANCED_SEARCH_OLD_TRANS_DATE_TIME = "ADVANCED_SEARCH_OLD_TRANS_DATE_TIME";
    
    public final static String	ADVANCED_SEARCH_FUEL_POSITION      = "ADVANCED_SEARCH_FUEL_POSITION";
    public final static String	ADVANCED_SEARCH_FUEL = "ADVANCED_SEARCH_FUEL";
    
    public final static String ADVANCED_SEARCH_REGISTER = "ADVANCED_SEARCH_REGISTER";
    
	public final static String FREE_POP_CODE_GEN_ERR		= "FREE_POP_CODE_GEN_ERR";
	public final static String FREE_POP_CODE_CONFIG_ERR	= "FREE_POP_CODE_CONFIG_ERR";
	public final static String FREE_POP_DISABLED		= "FREE_POP_DISABLED";
	public final static String FREE_POP_NO_CODE_ALLOW = "FREE_POP_NO_CODE_ALLOW";
	public final static String FREE_POP_NO_DISCS		= "FREE_POP_NO_DISCS";
	public final static String FREE_POP_AUTO_CODE_ERR = "FREE_POP_AUTO_CODE_ERR";
	public final static String FREE_POP_CODES_EXCEED	= "FREE_POP_CODES_EXCEED";
	public final static String FREE_POP_LIMIT		= "FREE_POP_LIMIT";
	public final static String FREE_POP_INV_DISC_DEF	= "FREE_POP_INV_DISC_DEF";
	public final static String FREE_POP_CODE_DEF_TABLE = "FREE_POP_CODE_DEF_TABLE";
	public final static String FREE_POP_CODE_MAX_LIMIT = "FREE_POP_CODE_MAX_LIMIT";
    
    
	public final static String POP_TITLE                    = "POP_TITLE";
	public final static String MEMBER_ID_PROMPT             = "MEMBER_ID_PROMPT";
	public final static String MEMBER_ID_ACCEPT				= "MEMBER_ID_ACCEPT";
	public final static String POP_CODE_PROMPT              = "POP_CODE_PROMPT";
	public final static String INVALID_DATA                 = "INVALID_DATA";
	public final static String INVALID_DATA_FINAL           = "INVALID_DATA_FINAL";
	public final static String EXPIRED_CODE                 = "EXPIRED_CODE";
	public final static String UNKNOWN_CODE                 = "UNKNOWN_CODE";
	public final static String USEDUP_CODE                  = "USEDUP_CODE";
	public final static String GENERATE_CODE                = "GENERATE_CODE";
	public final static String GENERATE_COUPON              = "GENERATE_COUPON";
	public final static String POP_QUAL_DISC				= "POP_QUAL_DISC";
	public final static String PREPAY_AMT					= "PREPAY_AMT";
	public final static String CONFIRM_MSG_CLEAR_RESERVE    = "CONFIRM_MSG_CLEAR_RESERVE";/*cr1239.01- message to be displayed on confirmation overlay of clear reserve button*/
	public final static String POP_LIMIT					= "POP_LIMIT";
	public final static String POP_CONT_VOID				= "POP_CONT_VOID";
	public final static String POP_FUEL_LIMIT				= "POP_FUEL_LIMIT";
	public final static String USER_ID                      = "USER_ID";
	public final static String PASSWORD                     = "PASSWORD";
	public final static String PROTECTED_FUNCTION           = "PROTECTED_FUNCTION";
	public final static String ERROR                        = "ERROR";
	public final static String PERMISSION_DENIED            = "PERMISSION_DENIED";
	public final static String UNSUPPORTED_FUNCTION         = "UNSUPPORTED_FUNCTION";
	public final static String SYSTEM_MESSAGES              = "SYSTEM_MESSAGES";
	public final static String IDCHECK_PROMPT               = "IDCHECK_PROMPT";
	public final static String BORN_BEFORE                  = "BORN_BEFORE";
	public final static String TRACK2_EMPTY                 = "TRACK2_EMPTY";
	public final static String UNSUPP_LICENSE               = "UNSUPP_LICENSE";
	public final static String LICENSE_EXPIRED              = "LICENSE_EXPIRED";
	public final static String LICENSE_EXP_DATE             = "LICENSE_EXP_DATE";
	public final static String LICENSE_BIRTH_DATE           = "LICENSE_BIRTH_DATE";
	public final static String EASYID_FILE_MISSING          = "EASYID_FILE_MISSING";
	public final static String MO_PAYEE                     = "MO_PAYEE";
	public final static String MO_NAME_MAXIMUM              = "MO_NAME_MAXIMUM";
	public final static String MO_INVALID_PAYEE             = "MO_INVALID_PAYEE";
	public final static String MO_ADD_REMOVE                = "MO_ADD_REMOVE";
	public final static String MO_RETRY_STOP                = "MO_RETRY_STOP";
	public final static String MO_DISABLED                  = "MO_DISABLED";
	public final static String MO_PRINTING_WAIT             = "MO_PRINTING_WAIT";
	public final static String MO_PRINT_SUCCESS             = "MO_PRINT_SUCCESS";
	public final static String MO_COVER_OPEN                = "MO_COVER_OPEN";
	public final static String MO_SERVICE_UNAVAIL           = "MO_SERVICE_UNAVAIL";
	public final static String MO_LOAD_FORMS                = "MO_LOAD_FORMS";
	public final static String MO_LOAD_ERR                  = "MO_LOAD_ERR";
	public final static String QC_APPLICATION_PENDING       = "ApplicationPending";
	public final static String QC_TRANSMISSION_ERROR        = "TransmissionError";
	public final static String QC_INVALID_SSN               = "InvalidSSN";
	public final static String QC_CANNOT_PROCESS            = "CannotProcess";
	public final static String QC_HANDLING_ERROR            = "HandlingError";
	public final static String FUELPROD_NOT_ALLOWED         = "FuelprodNotAllowed";
	public final static String NO_PROD_SELECT               = "NoProdSelect";
	public final static String FATAL_ERROR_EXIT             = "FatalErrorExit";
	public final static String CREDIT                       = "Credit";
	public final static String PREPAID                      = "Prepaid";
	public final static String QUICK_CREDIT                 = "QuickCredit";
	public final static String TRACK_1_MISSING                 = "TrackOneMissing";
	public final static String PREAUTH                      = "Preauth";
	public final static String KSL_GEMREG1                  = "KSL_GEMREG1";
	public final static String KSL_GEMREG2                  = "KSL_GEMREG2";
	public final static String KSL_TRIAL1                   = "KSL_TRIAL1";
	public final static String KSL_TRIAL2                   = "KSL_TRIAL2";
	public final static String EXTRA_DOLLARS                = "ExtraDollars";
	public final static String COMPLETE_SALE                = "CompleteSale";
	public final static String APPLY_DOLLAR                 = "ApplyDollar";
	public final static String APPLY_CURTRAN				= "ApplyCurtran";
	public final static String OTHER_FUNCS					= "OtherFuncs";
	public final static String OTHER_FUEL_FUNCS				= "OtherFuelFuncs";
	public final static String CHOOSE_FUNC					= "ChooseFunc";
	public final static String VIEW_PENDING_TXNS			= "ViewPendingTxns";
	public final static String PRINT_PREV_TXN				= "PrintPreviousTxn";
	public final static String PREVIOUS						= "Previous";
	public final static String NEXT							= "Next";
    public final static String SKIP							= "Skip";

	public final static String MONEY_TRANSFER               = "MONEY_TRANSFER";
	public final static String ENTER_BENEFICIARY            = "ENTER_BENEFICIARY";
	public final static String ACTIVATE_PIN        		    = "ACTIVATE_PIN";
	public final static String DEACTIVATE_PIN        	    = "DEACTIVATE_PIN";
	public final static String ENTER_ORIG_REFNUM       	    = "ENTER_ORIG_REFNUM";
	public final static String SWIPE_PREPAID       	    	= "SWIPE_PREPAID";
	public final static String ENTER_PREPAID_PIN       	    = "ENTER_PREPAID_PIN";
	public final static String SWIPE_MONEY_TRANSFER       	= "SWIPE_MONEY_TRANSFER";
	public final static String ACTIVATE        	   			= "ACTIVATE";
	public final static String RECHARGE       	   			= "RECHARGE";
	public final static String DEACTIVATE_CARD        	    = "DEACTIVATE_CARD";
	public final static String CUSTOMER_CREDIT        	    = "CUSTOMER_CREDIT";


	public static final String LOYALTY_MEMBER               = "LOYALTY_MEMBER";
	public static final String LOYALTY_SWIPE                = "LOYALTY_SWIPE";
	public static final String LOYALTY_SCAN           		= "LOYALTY_SCAN";
	public static final String LOYALTY_SWIPE_SCAN           = "LOYALTY_SWIPE_SCAN";
	public static final String LOYALTY_CARD                 = "LOYALTY_CARD";
	public static final String LOYALTY_CONFIRM				= "LOYALTY_CONFIRM";
	public static final String LOYALTY_ENTER_ACCOUNT        = "LOYALTY_ENTER_ACCOUNT";
	public static final String LOYALTY_PINPAD_ENTRY        	= "LOYALTY_PINPAD_ENTRY";
	public static final String LOYALTY_UNAVAILABLE          = "LOYALTY_UNAVAILABLE";
	public static final String LOYALTY                      = "LOYALTY";
	public static final String LOCAL_DISCOUNTS              = "LOCAL_DISCOUNTS";
	public static final String MOBILE_LOYALTY              = "MOBILE_LOYALTY";
	public static final String YES                          = "YES";
	public static final String NO                           = "NO";
	public static final String SAVE                          = "SAVE";
	public static final String LOYALTY_PPG_REQ              = "LOYALTY_PPG_REQ";
	public static final String LOYALTY_AUTH_REQ             = "LOYALTY_AUTH_REQ";
	public static final String LOYALTY_COMPLETION_REQ       = "LOYALTY_COMPLETION_REQ";
	public static final String LOYALTY_ORIG_DATE            = "LOYALTY_ORIG_DATE";
	public static final String LOYALTY_ORIG_TRAN_NUM        = "LOYALTY_ORIG_TRAN_NUM";
	public static final String LOY_VOL_LIM 					= "LOY_VOL_LIM";
	public static final String LOY_ADJ_PREPAY_AMT 			= "LOY_ADJ_PREPAY_AMT";
	public static final String LOCAL_DISCOUNTS_REQ 			= "LOCAL_DISCOUNTS_REQ";
	public static final String MOBILE_LOYALTY_REQ 			= "MOBILE_LOYALTY_REQ";

	public final static String BALANCE_INQUIRY              = "BALANCE_INQUIRY";
	public final static String VOID                         = "Void";

	public static final String SCAN_CHECK                   = "SCAN_CHECK";
	public static final String MANUAL_MICR                  = "MANUAL_MICR";
	public static final String CHECK_NUM                    = "CHECK_NUM";
	public static final String CHECK_TYPE                   = "CHECK_TYPE";
	public static final String CHECK_TYPE_PERSONAL          = "CHECK_TYPE_PERSONAL";
	public static final String CHECK_TYPE_COMPANY           = "CHECK_TYPE_COMPANY";
	public static final String PRIMARY_ID                   = "PRIMARY_ID";
	public static final String SUPPLEMENTAL_ID              = "SUPPLEMENTAL_ID";
	public static final String ID_TYPE                      = "ID_TYPE";
	public static final String NAME                         = "NAME";
	public static final String PHONE_NUMBER                 = "PHONE_NUMBER";
	public static final String STREET_ADDRESS               = "STREET_ADDRESS";
	public static final String CITY                         = "CITY";
	public static final String STATE                        = "STATE";
	public static final String ZIP_CODE                     = "ZIP_CODE";
	public static final String INITIALS                     = "INITIALS";
	public static final String ACCEPT_ECA                   = "ACCEPT_ECA";
	public static final String CARDLOAD_RCHRG               = "CARDLOAD_RCHRG";
	public static final String PARTIAL_AUTH                 = "PARTIAL_AUTH";
	public static final String PARTIAL_CASHBACK				= "PARTIAL_CASHBACK";
	public static final String SIG_CAPTURE                 	= "SIG_CAPTURE";
	public static final String SIG_DISPLAY_FAIL             = "SIG_DISPLAY_FAIL";
	public static final String PROMPT_SIGNATURE				= "PROMPT_SIGNATURE";
	public static final String PROCESS_SIGNATURE			= "PROCESS_SIGNATURE";
	public static final String PURCHASE_TRAN				= "PURCHASE_TRAN";
	public static final String REFUND_TRAN					= "REFUND_TRAN";
	public static final String VOID_TRAN					= "VOID_TRAN";
	public static final String PROMPT_PAYMENT_KEY 			= "PROMPT_PAYMENT_KEY";
	public static final String PROMPT_CASHIER_FOR_CUST_COPY = "PROMPT_CASHIER_FOR_CUST_COPY";
	public static final String NUMERIC_KEYPAD 				= "NUMERIC_KEYPAD";
    public static final String ADJUST_FUEL_LIMIT 			= "ADJUST_FUEL_LIMIT";
    
    public final static String PRESS_ENTER_OR_EXIT			= "PRESS_ENTER_OR_EXIT";
    public static final String PRE_AUTH_CANCELLED 			= "PRE_AUTH_CANCELLED";
    public static final String AEOD_FAILED = "AEOD_FAILED";
    public static final String INITIATE_AN_END_OF_DAY_MANUALLY = "INITIATE_AN_END_OF_DAY_MANUALLY";
    public static final String AEOD_SUCCESS = "AEOD_SUCCESS";
    public static final String COMPLETED_WITH_NETWORK_ERRORS = "COMPLETED_WITH_NETWORK_ERRORS";
    public static final String EBT_VOUCHERCLEAR 			= "EBT_VOUCHERCLEAR";
    public static final String VOUCHER_CLEAR_AMOUNT 			= "VOUCHER_CLEAR_AMOUNT";
    public static final String PRICE_CHECK_CONFIRM_ADD 		= "CONFIRM_ADD";
    public static final String PRICE_CHECK_CANCEL 			= "CANCEL";
    
    //CR2452 JUUL enhancements
    public static final String IDCHECK_TRANS_NUMBER				= "IDCHECK_TRANS_NUMBER";
    public static final String IDCHECK_DOB_VERIFY				= "IDCHECK_DOB_VERIFY";
    public static final String IDCHECK_DOB_SKIPPED				= "IDCHECK_DOB_SKIPPED";
    public static final String IDCHECK_SKIPPED					= "IDCHECK_SKIPPED";
	public static final String IDCHECK_MILITARY_EXCEPTION		= "IDCHECK_MILITARY_EXCEPTION";
	public static final String IDCHECK_DATE_BASED_EXCEPTION		= "IDCHECK_DATE_BASED_EXCEPTION";
	public static final String IDCHECK_MANUAL_ENTRY_OVERRIDE	= "IDCHECK_MANUAL_ENTRY_OVERRIDE";
	public static final String IDCHECK_BYPASS					= "IDCHECK_BYPASS";
	
	public static final String IDCHECK_LEGAL_AGE				= "IDCHECK_LEGAL_AGE";
   
	//CR6677 SWB Money Order enhancements
    public static final String MO_SALE_NOT_ALLOWED 		= "MO_SALE_NOT_ALLOWED";
    public static final String MO_PAYMENT_NOT_ALLOWED 		= "MO_PAYMENT_NOT_ALLOWED";
    public static final String CSHR_NOT_SELF_CERTIFIED		= "CSHR_NOT_SELF_CERTIFIED";
    public static final String INVALID_EMPLOYEE_NAME		= "INVALID_EMPLOYEE_NAME";
	public static final String MONEY_ORDER = "MONEY_ORDER";
	public static final String MO_SWB_PROMPT1 = "MO_SWB_PROMPT1";
	public static final String MO_SWB_PROMPT2 = "MO_SWB_PROMPT2";

	public static final String EMPLOYEE_ID = "EMPLOYEE_ID";

	public static final String CSR_MSG_USED_DRAWER = "CSR_MSG_USED_DRAWER";

	public static final String CSR_MSG_MOBILE_SERVICE_UNAVAILABLE = "CSR_MSG_MOBILE_SERVICE_UNAVAILABLE";
	
	public static final String 	SEND_ZERO_COLLECT		= "SEND_ZERO_COLLECT";
	
	public static final String 	LABEL_OK		= "LABEL_OK";
	public static final String 	LABEL_CANCEL		= "LABEL_CANCEL";
	
	public static final String 	SN_HEADER		= "SN_HEADER";
	public static final String 	ENTER_SN		= "ENTER_SN";
	public static final String FAILURE_REASON = "FAILURE_REASON";
		
	public static final String  PRINT_DETAIL_REVIEW_FOOTER       = "PRINT_DETAIL_REVIEW_FOOTER";
	public static final String  RECALL_DETAIL_REVIEW_FOOTER       = "RECALL_DETAIL_REVIEW_FOOTER";
	
	/*cr1239.01- message to be displayed on confirmation overlay of clear reserve button*/
	public static final String 	CONFIRM_HEADER         = "CONFIRM_HEADER";
	public static final String  CONFIRM_SYMBOL         = "CONFIRM_SYMBOL";
	/************************************************************************************/
	
	public static final String SHORT_DATE_DISPLAY_PATTERN		= "SHORT_DATE_DISPLAY_PATTERN";
	public static final String COLLECT_DIAG_DATA ="COLLECT_DIAG_DATA";
	public static final String SELECT_OPTION = "SELECT_OPTION";

	// Fiscal Printer Strings
	public final static String	FSC_PRINT_REPORT			= "FSC_PRINT_REPORT";
	public final static String	FSC_SELECT_REPORT			= "FSC_SELECT_REPORT";
	public final static String	FSC_OR_PRESS_ANY_KEY		= "FSC_OR_PRESS_ANY_KEY";
	public final static String	FSC_Z_REPORT				= "FSC_Z_REPORT";
	public final static String	FSC_X_REPORT				= "FSC_X_REPORT";
	public final static String	FSC_PRINTING_REPORT			= "FSC_PRINTING_REPORT";
	public final static String	FSC_PLEASE_WAIT				= "FSC_PLEASE_WAIT";
	public final static String	FSC_PRINTER_ERROR			= "FSC_PRINTER_ERROR";
	public final static String	FSC_ERROR_CODE				= "FSC_ERROR_CODE";

	public final static String	FSC_DATA					= "FSC_DATA";
	public final static String	FSC_INVALID_ENTRY			= "FSC_INVALID_ENTRY"; 
	public final static String	FSC_TRANSACTION_FORCED_VOID	= "FSC_TRANSACTION_FORCED_VOID";
	public final static String	FSC_AMOUNT_FORCED_TO_ZERO 	= "FSC_AMOUNT_FORCED_TO_ZERO";
	public final static String	FSC_PRESS_ENTER_TO_CONTINUE	= "FSC_PRESS_ENTER_TO_CONTINUE";
	public final static String	FSC_PRINTING				= "FSC_PRINTING"; 
	public final static String	FSC_PRINTING_TRANSACTION	= "FSC_PRINTING_TRANSACTION";
	
	public final static String	FSC_CUST_TAX			  	= "FSC_CUST_TAX";
	public final static String	FSC_CUST_NAME		  	  	= "FSC_CUST_NAME";
	public final static String	FSC_CUST_ADDR		  	  	= "FSC_CUST_ADDR";
	public final static String	FSC_ORIG_COO		    	= "FSC_ORIG_COO";
	public final static String	FSC_ORIG_PRT		  		= "FSC_ORIG_PRT";
	public final static String	FSC_ORIG_DATE			  	= "FSC_ORIG_DATE";
	public final static String	FSC_ORIG_TIME			  	= "FSC_ORIG_TIME";
	public final static String	FSC_REMAINING_RETRIES 		= "FSC_REMAINING_RETRIES";
	
	public final static String	FSC_PRMPT_VALID_INFO		= "FSC_PRMPT_VALID_INFO";
	public final static String	FSC_PRMPT_CUST_TAX 			= "FSC_PRMPT_CUST_TAX";
	public final static String	FSC_PRMPT_CUST_NAME			= "FSC_PRMPT_CUST_NAME";
	public final static String	FSC_PRMPT_NEW_CUST_NAME		= "FSC_PRMPT_NEW_CUST_NAME";
	public final static String	FSC_PRMPT_OLD_CUST_NAME		= "FSC_PRMPT_OLD_CUST_NAME";
	public final static String	FSC_PRMPT_OLD_CUST_ADDR		= "FSC_PRMPT_OLD_CUST_ADDR";
	public final static String	FSC_PRMPT_STR_COLON_TAXID	= "FSC_PRMPT_STR_COLON_TAXID";
	public final static String	FSC_PRMPT_CUST_ADDR 		= "FSC_PRMPT_CUST_ADDR";
	public final static String	FSC_PRMPT_CUST_COO 			= "FSC_PRMPT_CUST_COO";
	public final static String	FSC_PRMPT_ORIG_PRT  		= "FSC_PRMPT_ORIG_PRT";
	public final static String	FSC_PRMPT_ORIG_DATE 		= "FSC_PRMPT_ORIG_DATE";
	public final static String	FSC_PRMPT_ORIG_TIME 		= "FSC_PRMPT_ORIG_TIME";
	public final static String	FSC_ALARM_AVAILABLE 		= "FSC_ALARM_AVAILABLE";
	public final static String	FSC_ALARM_END_DATE			= "FSC_ALARM_END_DATE";
	public final static String	FSC_PRMPT_STATUS 			= "FSC_PRMPT_STATUS";
        
        public final static String      SAFE_DROP        = "SAFE_DROP";
        public final static String      SAFE_LOAN        = "SAFE_LOAN";
        public final static String      CLOCK_FNS        = "CLOCK_FNS";
        public final static String      PAY_IN           = "PAY_IN";
        public final static String      PAY_OUT          = "PAY_OUT";
        public final static String      SAFE_DROP_CORR   = "SAFE_DROP_CORR";
       
        public final static String		CHOOSE_PINPAD	 = "CHOOSE_PINPAD";
        public final static String		CHOOSEAPINPAD	= "CHOOSEAPINPAD";
        public final static String		LOGIN_SUCCESS 	= "LOGIN_SUCCESS";
        public final static String		PINPAD_IN_USE 	= "PINPAD_IN_USE";
        public final static String		PRIMARY_PINPAD_DEFAULT = "PRIMARY_PINPAD_DEFAULT";
        
        public final static String	THIRD_PARTY_PRODUCT		= "THIRD_PARTY_PRODUCT";
        public final static String	VOUCHER_NOT_CONFIGURED		= "VOUCHER_NOT_CONFIGURED";
        public final static String  VOUCHER_FAILURE = "VOUCHER_FAILURE";
        public final static String  MULT_VOUCHER_FAILURE = "MULT_VOUCHER_FAILURE";
        public final static String NO_MATCHING_NETWORK = "NO_MATCHING_NETWORK";
        public final static String REFUND_NOT_SUPPORTED = "REFUND_NOT_SUPPORTED";
        public final static String NO_SALE_ITEMS_FROM_TPP = "NO_SALE_ITEMS_FROM_TPP";
        public final static String RECALL_TXN = "RECALL_TXN";
        public final static String REPRINT_TXN = "REPRINT_TXN";
	
        public final static String PRMPT_CUST_NUMBER = "PRMPT_CUST_NUMBER";
        public final static String FV_ENTER_NUMBER = "FV_ENTER_NUMBER";
        public final static String INVALID_SEQ_NUM = "INVALID_SEQ_NUM";
        public final static String OUTDATED_SEQ_NUM = "OUTDATED_SEQ_NUM";
        public final static String MORE = "MORE"; 
        public final static String OPERATION_NOT_SUPPORTED = "OPERATION_NOT_SUPPORTED"; 
        public final static String CARD_ACTIVATED = "CARD_ACTIVATED"; 
        public final static String TAX_EXEMPT_TYPE = "TAX_EXEMPT_TYPE"; 
        public final static String TAX_EXEMPT = "TAX_EXEMPT";
        public static final String ATTENDANT_ACTIVATION = "ATTENDANT_ACTIVATION";
        public static final String ATTENDANT_SESSION_STORE_FAILED = "ATTENDANT_SESSION_STORE_FAILED";
        public static final String FAILURE = "FAILURE";
        public static final String CANCELLED = "CANCELLED";

	/**
	 * Accessor for the actual strings that have been internationalized.
	 */
	@Override
	public Object[][] getContents() {
		return this.contents;
	}

	protected Object[][] contents = {
		{ADVANCED_SEARCH_REGISTER, "Enter Register number: "},
		{ADVANCED_SEARCH_NUM_OF_HOURS, "Number of hours to go back"},
		{ADVANCED_SEARCH_HOURS, "Filter by Hours"},
		{ADVANCED_SEARCH_OLD_TRANS_DATE_TIME, "Oldest Transaction Time: "},
		{ADVANCED_SEARCH_DATE, "Enter Date ({0})"},
		{ADVANCED_SEARCH_TIME, "Enter Time {0} where hh is 0-24"},
		{ADVANCED_SEARCH_DATE_TIME, "Filter by Date/Time"},
		{ADVANCED_SEARCH_FUEL_POSITION, "Filter by FP"},
		{ADVANCED_SEARCH_FUEL, "Enter Fueling Position Number"},
		{EXPRESS_ADVANCED_OPTIONS, "Advanced Options"},
		{EXPRESS_CANCEL, "Cancel"},
		{EXPRESS_SHOW_LIST, "Show List"},
		{STARTING_DRAWER_AMOUNT, "Enter Starting Drawer Amount"},
		{ITEM_CANNT_SOLD_TIME, "Item cannot be sold at this time"},
		{PRESS_ENTER_TO_ACK, "Press ENTER/OK to Continue "},
		{ITEM_CANNT_BE_SOLD, "Item can not be sold "},
		{ENTER_PRICE, "Enter Price"},
		{ENTER_BIRTH_DATE, "Enter Birth Date "},
		{MUST_BE_BORN_BEFORE, "Must be born before "},
		{ASSOCIATED_RESTRICTION, "for associated restriction"},
		{CANNT_SOLD_ITEM_CUSTOMER, "Item cannot be sold to this customer"},
		{SWIPE_CARD, "Swipe Card "},
		{SWIPE_CARD_OR_ENTER_ACC, "Swipe Card / Enter Account #"},
		{ENTER_ACCT_NUM, "Enter Account Number"},
		{SWIPE_NEXT_CARD, "Swipe Next Card "},
		{SWIPE_NEXT_CARD_ENTER_ACC, "Swipe Next Card / Enter Acct #"},
		{ENTER_EXPIRATION_DATE, "Enter Expiration Date (MMYY)"},
		{ENTER_AUTH_NUMBER, "Enter AUTH Number"},
		{ACCOUNT_NUMBER, "Account #"},
		{PROCESSING_CARD, "Processing Card"},
		{DIALING, "Dialing  . . ."},
		{CONNECTING, "Connecting  . . ."},
		{AUTHORIZING, "Authorizing  . . ."},
		{TRANSMITTING, "Transmitting  . . ."},
		{RECEIVING, "Receiving  . . ."},
		{PLEASE_WAIT, "Please Wait  . . ."},
		{APPROVED, "Approved"},
		{CARD_EXPIRED, "Expired Card"},
		{CARD_INVALID, "Invalid Card"},
		{CARD_BAD_READ, "Unable to Read - Retry"},
		{WRONG_CARD_TYPE, "Wrong Card Type"},
		{CARD_NOT_ALLOWED, "Card Not Allowed"},
		{ACCT_NBR_ERR, "Account Number Error"},
		{INVALID_SVC_CODE, "Invalid Service Code"},
		{INVALID_TRK_DATA, "Invalid Track Data"},
		{INVALID_USER_DATA, "Invalid User Data"},
		{NO_MANUAL_ENTRY, "No Manual Entry"},
		{ OVERLAY_REVIEW_FOOTER,    "Key entry# and press <ENTER>, Touch Line Item on Screen "
			+"to choose entry, then touch Select/Enter" },
		{SELECT_DIAGNOSTICS_TYPE, "Select Diagnostic Type"},
		{INVALID_PROD_FOR_CARD_TYPE, "Invalid product for card type"},
		{PCHECK_HEADING, "PRICE CHECK"},
		{PCHECK_PROMPT_1, "Enter Item"},
		{PCHECK_PROMPT_2, "Add item to transaction?"},
		{PLUNF_HEADING, "PLU NOT FOUND"},
		{PLUNF_PROMPT_1, "Enter Price"},
		{PLUNF_PROMPT_2, "PLU #"},
		{PLUNF_PROMPT_3, "Price read is "},
		{PLUOP_HEADING, "OPEN PRICE ITEM"},
		{MPLU_HEADING, "MANUAL PLU"},
		{MPLU_PROMPT_1, "Enter Item"},
		{CASHBACK_REQUIRED, "Do you want Cashback?"},
		{ENTER_CASHBACK_AMT, "Enter Cashback Amount"},
		{ENTER_CASHBACK_FEE, "Enter Cashback Fee"},
		{CASHBACK_LIMIT_EXCEED, "Invalid Cashback Amount"},
		{ENTER_PIN_PINPAD, "Enter PIN on PinPad"},
		{USE_PINPAD_NOW, "USE PINPAD NOW"},
		{MOP_CONFLICT, "Method of Payment Conflict"},
		{CUSTOMER_CHOICE, "Use Customer's Choice?"},
		{CHECK_PINPAD, "Check PinPad Connection"},
		{CLEAR_PINPAD, "Press <CLEAR> on PinPad"},
		{CANCEL_PINPAD_SESSION, "Cancelling PinPad Session"},
		{READ_PINPAD, "Reading Card From PinPad"},
		{SELECT_PINPAD, "Card Reader in PinPad?"},
		{SC5000_EVEREST, "Select YES for SC5000, Everest"},
		{CHECK_PP_MOP, "Checking PinPad for card swipe"},
		{ENTER_TKT_NUMBER, "Enter Approval Number"},
		{ENTER_VEH_NUMBER, "Enter Vehicle ID Number#"},
		{FUEL_ONLY_CARD, "Fuel Only card?"},
		{ENTER_RESTRICT_CODE, "Enter 2-digit Restriction Code"},
		{INVALID_RESTRICT_CODE, "Invalid Restriction Code"},
		{FUEL_PRODUCTS_ONLY, "Only Fuel Products Allowed"},
		{REFUNDS_NOT_ALLOWED, "Refunds Not Allowed"},
		{CARD_DATA_ERROR, "Card Data Error"},
		{CASH_PROD_DISALLOWED, "Cashback Not Allowed"},
		{MDSE_PROD_DISALLOWED, "Merchandise Products Not Allowed"},
		{SERV_PROD_DISALLOWED, "Service Products Not Allowed"},
		{TRANSACTION_DENIED, "Transaction Denied "},
		{TRANSACTION_CANCELLED, "Transaction Cancelled"},
		{BAD_CARD_FMT, "Bad Card "},
		{HOST_UNAVAIL_FMT, "Host Unavailable "},
		{PIN_INVALID, "USER ID TRIES EXCEEDED"},
		{PIN_ERROR, "USER ID ERROR"},
		{TICKET_NUM_ERR, "Approval Number Must Be 6 Digits"},
		{SAPPHIRE_UNAVAILABLE, "Controller Unavailable"},
		{ENTER_VOICE_AUTH, "Enter voice approval number"},
		{UNSUPP_NET_OP, "Unsupported Network Operation"},
		{PRE_AUTH_AMT, "Enter Estimated Total Sale"},
		{PRE_AUTH_FUEL_AMT, "Enter Estimated Fuel Sale"},
		{PRE_AUTH_MDSE_AMT, "Enter Estimated Merchandise Sale"},
		{PRE_AUTH_SERV_AMT, "Enter Estimated Service Sale"},
		{AUTH_AMT_REQD, "Auth Amount Required"},
		{ENTER_ACTIVATION_AMT, "Enter Activation Amount"},
		{ENTER_RECHARGE_AMT, "Enter Recharge Amount"},
		{ACTIVATE_FUNC_LATER, "Activation at end of transaction"},
		{RECHARGE_FUNC_LATER, "Recharge at end of transaction"},
		{INIT_ACTIVATE, "Initiating Activation ..."},
		{INIT_RECHARGE, "Initiating Recharge ..."},
		{INIT_DEACTIVATE, "Initiating Deactivation ..."},
		{INIT_BAL_QUERY, "Initiating Balance Query ..."},
		{INIT_VOID_ACTIVATE, "Initiating Void Activation"},
		{INIT_VOID_RECHARGE, "Initiating Void Recharge"},
		{PREPARE_ACTIVATE, "Preparing to Activate"},
		{PREPARE_RECHARGE, "Preparing to Recharge"},
		{PREPARE_VOID, "Preparing Refund"},
		{SVC_RANGE_MIN, "Must be between "},
		{SVC_RANGE_MAX, " and "},
		{MUST_BE_SVC, "Must present Prepaid Card"},
		{ACTIVATION_SUCCESS, " Activation successful"},
		{VOID_ACTIVATION_SUCCESS, " Void Activation successful"},
		{VOID_RECHARGE_SUCCESS, " Void Recharge successful"},
		{RECHARGE_SUCCESS, " Recharge successful"},
		{DEACTIVATE_SUCCESS, " Deactivation successful"},
		{VOID_SUCCESS, " Refund successful"},
		{CARD_BALANCE, "Card balance "},
		{APPROVED_AMOUNT, "Approved for "},
		{INVALID_AMOUNT, "Invalid Approval Amount"},
		{ACCEPT_PREAUTH, "Press YES to accept, NO to void"},
		{DEACTIVATE_CONFIRM, "Press ENTER to Deactivate"},
		{RECHARGE_MAXIMUM, "Amount must be less than "},
		{BALANCE_EXCEED, "Balance exceeds recharge limit"},
		{RETRIEVE_CARD, "Retrieving card data"},
		{ERR_RETRIEVE_CARD, "Unable to retrieve card data"},
		{SVC_SALE_EXCEED, "Max prepaid cards exceeded"},
		{SVC_VOID, "Refunding previous charge ..."},
		{SVC_CARD_NUM, " Card #"},
		{SVC_VOID_ALL1, "Performing Reversals"},
		{SVC_VOID_ALL2, "on all cards..."},
		{SVC_OVERRIDE, " NOT EQUAL SALE "},
		{CHECK_CARD_BAL, "Checking card balance ..."},
		{INSUFF_CARD_BAL, "Insufficient card balance"},
		{REMAIN_TRAN_BAL, "Transaction has unpaid balance"},
		{UPDATE_PUMP, "Updating Pump "},
		{UPDATE_PUMP_FAIL, "Failed to update pump "},
		{EPS_BUSY_MSG, "Eps Busy! Please try again."},
		{IS_VISA_CARD, "Is this a VISA card?"},
		{IS_SUNOCO_CARD, "Is this a SUNOCO card?"},
		{IS_CENEX_CARD, "Is this a CENEX card?"},
		{IS_GULF_CARD, "Is this a GULF card?"},
		{HOST_TOTALS_OVERLAY_TITLE, "Host Totals Report"},
		{HOST_TOTALS_DATE_PROMPT, "Enter Totals Date (DDMMYY)"},
		{INVALID_DATE, "Invalid Date"},
		{EXPRESS_ERROR_CORR, "Error Correct"},
		{EXPRESS_SUSPEND, "Susp Trans"},
		{EXPRESS_RECALL, "Recall"},
		{EXPRESS_VOID_LINE, "Void Line"},
		{EXPRESS_PRICE_CHECK, "Price Check"},
		{EXPRESS_REPRINT, "Reprint"},
		{EXPRESS_FREPRINT, "Fuel Item(s) Reprint"},
		{EXPRESS_LOGOFF, "Log Off"},
		{EXPRESS_LOCKWS, "Lock W/S"},
		{EXPRESS_CSRFUNC, "CSR Func"},
		{EXPRESS_DISMISS_MENU, "Dismiss Menu"},
		{EXPRESS_DISMISS_LIST, "Dismiss List"},
		{EXPRESS_DONE, "Done"},
		{EXPRESS_VIRTUAL_KBD, "Virtual KBD"},
		{EXPRESS_SAVE_CHANGES, "Save Changes"},
		{EXPRESS_DISCARD_CHANGES, "Discard Changes"},
		{EXPRESS_RETURN_TO_SALES, "Return To Sales"},
		{USE_CW_CTRL, "Use Carwash controller to cancel code"},
		{REFUND_CARWASH, "Carwash Refund"},
		{CW_RAIN_CHECK_CASE2, "Carwash Code Unavailable"},
		{CW_RAIN_CHECK_CASE1, "Car Wash Down"},
		{FREE_POP_CODE_GEN_ERR, "Code Generation Failed"},
		{FREE_POP_CODE_CONFIG_ERR, "Config Error"},
		{FREE_POP_DISABLED, "POP Disabled"},
		{FREE_POP_NO_CODE_ALLOW, "No Codes Allowed"},
		{FREE_POP_NO_DISCS, "No Discounts"},
		{FREE_POP_AUTO_CODE_ERR, "Auto Code Error"},
		{FREE_POP_CODES_EXCEED, "Codes Exceed"},
		{FREE_POP_LIMIT, "limit"},
		{FREE_POP_INV_DISC_DEF, "Invalid Discount Definition"},
		{FREE_POP_CODE_DEF_TABLE, "POP Definition Table"},
		{FREE_POP_CODE_MAX_LIMIT, "Max. limit"},
		{POP_TITLE, "POP Discount"},
		{MEMBER_ID_PROMPT, "Enter Member ID / Scan or Swipe Membership Card"},
		{MEMBER_ID_ACCEPT, "Member ID Accepted"},
		{POP_CODE_PROMPT, "Enter POP Code"},
		{INVALID_DATA, "Invalid Entry, Please Re-enter"},
		{INVALID_DATA_FINAL, "Invalid Entry, Retry Limit Reached."},
		{EXPIRED_CODE, "Expired Code"},
		{UNKNOWN_CODE, "Unrecognized Code"},
		{USEDUP_CODE, "Code Already Used"},
		{GENERATE_CODE, "Generate Code"},
		{GENERATE_COUPON, "Generate Coupon"},
		{POP_QUAL_DISC, "Qualified for POP Discount"},
		{PREPAY_AMT, "Prepay = "},
		{CONFIRM_MSG_CLEAR_RESERVE, "Clear Reserved Pump "}, /*cr1239.01- message to be displayed on confirmation overlay of clear reserve button*/
		{POP_LIMIT, "POP Limit = "},
		{POP_CONT_VOID, "Continue Prepay[Y] or Void Ticket[N]"},
		{POP_FUEL_LIMIT, "POP FUEL LIMIT"},
		{USER_ID, "User ID"},
		{PASSWORD, "Password"},
		{PROTECTED_FUNCTION, "Secure Function - Please enter User ID/Password"},
		{ERROR, "Secure Function - Please enter User ID/Password"},
		{PERMISSION_DENIED, "Permission Denied"},
		{UNSUPPORTED_FUNCTION, "unsupported_func"},
		{SYSTEM_MESSAGES, "System Messages"},
		{IDCHECK_PROMPT, "Enter Birth Date or Swipe/Scan License"},
		{BORN_BEFORE, "Must be Born Before"},
		{TRACK2_EMPTY, "License Track2 Empty"},
		{UNSUPP_LICENSE, "License Not Supported"},
		{LICENSE_EXPIRED, "License Expired"},
		{LICENSE_EXP_DATE, "License Expiration Date Error"},
		{LICENSE_BIRTH_DATE, "License Birth Date Invalid"},
		{EASYID_FILE_MISSING, "EasyID Not Enabled"},
		{MO_PAYEE, "Enter Payee {0}{1}Name or Number"},
		{MO_NAME_MAXIMUM, "Maximum of {0} characters"},
		{MO_INVALID_PAYEE, "INVALID PAYEE NAME"},
		{MO_ADD_REMOVE, "<OK> to Continue, <CANCEL> to Remove"},
		{MO_RETRY_STOP, "<OK> to Retry, <CANCEL> to Stop Print"},
		{MO_DISABLED, "Money Order Feature Disabled"},
		{MO_PRINTING_WAIT, "Printing Money Order, Please Wait"},
		{MO_PRINT_SUCCESS, "Successfully Printed Money Order"},
		{MO_COVER_OPEN, "Money Order Printer Cover Open"},
		{MO_SERVICE_UNAVAIL, "Money Order Service Unavailable"},
		{MO_LOAD_FORMS, "Load Money Order Forms"},
		{MO_LOAD_ERR, "Money Order Load Error"},
		{QC_APPLICATION_PENDING, "Application Pending"},
		{QC_TRANSMISSION_ERROR, "Transmission Error - Try again later"},
		{QC_INVALID_SSN, "Invalid SSN"},
		{QC_CANNOT_PROCESS, "Cannot Process"},
		{QC_HANDLING_ERROR, "Handling Error - "},
		{FUELPROD_NOT_ALLOWED, "Fuel Grade Not Allowed"},
		{NO_PROD_SELECT, "Cannot buy products on pump "},
		{FATAL_ERROR_EXIT, "Fatal Error: Exiting..."},
		{CREDIT, "CREDIT"},
		{PREPAID, "PREPAID"},
		{QUICK_CREDIT, "QUICK CREDIT"},
		{TRACK_1_MISSING, "TRACK 1 MISSING, SWIPE DIFFERENT CARD"},
		{PREAUTH, "PREAUTH"},
		{SCAN_CHECK, "Insert Check Into Reader"},
		{MANUAL_MICR, "Enter Check MICR Data"},
		{CHECK_NUM, "Enter Check Number"},
		{CHECK_TYPE, "Select Check Type"},
		{CHECK_TYPE_PERSONAL, "1. Personal"},
		{CHECK_TYPE_COMPANY, "2. Company"},
		{PRIMARY_ID, "Swipe or Enter Driver's License or ID"},
		{SUPPLEMENTAL_ID, "Swipe or Enter Supplemental ID"},
		{ID_TYPE, "Select ID Type"},
		{NAME, "Enter Name"},
		{PHONE_NUMBER, "Enter Phone Number"},
		{STREET_ADDRESS, "Enter Street Address"},
		{CITY, "Enter City"},
		{STATE, "Enter State Abbreviation"},
		{ZIP_CODE, "Enter Zip Code"},
		{INITIALS, "Enter Initials"},
		{ACCEPT_ECA, "Accept ECA?"},
		{KSL_GEMREG1, "SYSTEM NOT REGISTERED"},
		{KSL_GEMREG2, "Please call to register your system"},
		{KSL_TRIAL1, "DEMO VERSION ONLY"},
		{KSL_TRIAL2, "Please call for more Topaz Information"},
		{EXTRA_DOLLARS, "Additional "},
		{COMPLETE_SALE, " needed to complete sale"},
		{APPLY_DOLLAR, "Apply "},
		{APPLY_CURTRAN, " to total sale?"},
		{OTHER_FUNCS, "Other Functions"},
		{OTHER_FUEL_FUNCS, "Other Fuel Functions"},
		{CHOOSE_FUNC, "Choose a Function"},
		{VIEW_PENDING_TXNS, "View Pending Transactions (Recall)"},
		{PRINT_PREV_TXN, "Print Previous Transaction (Reprint)"},
		{PREVIOUS, "Previous"},
		{NEXT, "Next"},
		{SKIP, "SKIP"},
		{MONEY_TRANSFER, "MONEY TRANSFER"},
		{ENTER_BENEFICIARY, "Enter Beneficiary Number"},
		{ACTIVATE_PIN, "ACTIVATE PIN"},
		{DEACTIVATE_PIN, "DEACTIVATE PIN"},
		{ENTER_ORIG_REFNUM, "Enter Original Transaction Reference Number"},
		{SWIPE_PREPAID, "Swipe Prepaid Card"},
		{ENTER_PREPAID_PIN, "Enter Prepaid PIN"},
		{SWIPE_MONEY_TRANSFER, "Swipe Money Transfer Card"},
		{ACTIVATE, "ACTIVATE"},
		{RECHARGE, "RECHARGE"},
		{DEACTIVATE_CARD, "DEACTIVATE CARD"},
		{CUSTOMER_CREDIT, "Customer Credit"},
		{LOYALTY_MEMBER, "Loyalty Member?"},
		{LOYALTY_SWIPE, "Swipe"},
		{LOYALTY_SCAN, "Scan or Enter Loyalty Card"},
		{LOYALTY_SWIPE_SCAN, "Swipe or Scan"},
		{LOYALTY_CARD, "Card"},
		{LOYALTY_CONFIRM, "Loyalty Card?"},
		{LOYALTY_ENTER_ACCOUNT, "or Enter Account Number"},
		{LOYALTY_PINPAD_ENTRY, "Press OK to bypass for PINpad entry"},
		{LOYALTY_UNAVAILABLE, "Loyalty Unavailable"},
		{LOYALTY, "LOYALTY"},
		{LOCAL_DISCOUNTS, "LOCAL DISCOUNTS"},
		{MOBILE_LOYALTY, "MOBILE LOYALTY"},
		{YES, "Yes"},
		{NO, "No"},
		{SAVE, "Save"},
		{LOYALTY_PPG_REQ, "Loyalty Price Per Gallon Request ..."},
		{LOYALTY_AUTH_REQ, "Loyalty Authorization Request ..."},
		{LOYALTY_COMPLETION_REQ, "Loyalty Completion Request ..."},
		{LOYALTY_ORIG_DATE, "Enter Ticket's Sale Date DD/MM/YYYY"},
		{LOYALTY_ORIG_TRAN_NUM, "Enter Ticket's Tran#"},
		{LOY_VOL_LIM, "VOLUME LIMIT "},
		{LOY_ADJ_PREPAY_AMT, "Fuel Prepay adjusted to "},
		{LOCAL_DISCOUNTS_REQ, "Sending Local Discounts Request"},
		{MOBILE_LOYALTY_REQ, "Sending Mobile Loyalty Award Request"},
		{BALANCE_INQUIRY, "BALANCE INQUIRY"},
		{VOID, "VOID"},
		{CARDLOAD_RCHRG, "VISA READYLINK"},
		{PARTIAL_AUTH, "PARTIAL APPROVAL: "},
		{PARTIAL_CASHBACK, "APPROVED CASH BACK AMOUNT: "},
		{SIG_CAPTURE, "Signature Capture"},
		{SIG_DISPLAY_FAIL, "Unable to display signature"},
		{PROMPT_SIGNATURE, "Sign on PINpad"},
		{PROCESS_SIGNATURE, "Processing Signature"},
		{PURCHASE_TRAN, "Purchase"},
		{REFUND_TRAN, "Return"},
		{VOID_TRAN, "Void"},
		{PROMPT_PAYMENT_KEY, "Select Payment Type on PINpad"},
		{PROMPT_CASHIER_FOR_CUST_COPY, "Print Customer Receipt?  [Y/N]"},
		{PRESS_ENTER_OR_EXIT, "Press ENTER to Continue / EXIT to Cancel"},
		{PRE_AUTH_CANCELLED, "Pre-Authorization CANCELLED"},
		{NUMERIC_KEYPAD, "Numeric Keypad"},
		{ADJUST_FUEL_LIMIT, "Adjust fuel limit  "},
		{AEOD_FAILED, "Auto End of Day Failed"},
		{INITIATE_AN_END_OF_DAY_MANUALLY, "Initiate an End of Day manually"},
		{ AEOD_SUCCESS , "Auto End of Day Successful"},
        { COMPLETED_WITH_NETWORK_ERRORS , "Completed With Network Errors"},
		{EBT_VOUCHERCLEAR, "EBT Voucher Clear"},
		{VOUCHER_CLEAR_AMOUNT, "Enter Purchase Amount"},
		{PRICE_CHECK_CONFIRM_ADD, "Confirm Add"},
		{PRICE_CHECK_CANCEL, "Cancel"},
		{IDCHECK_TRANS_NUMBER, "Trans#"},
		{IDCHECK_DOB_VERIFY, "DOB Verification"},
		{IDCHECK_DOB_SKIPPED, "DOB SKIPPED"},
		{IDCHECK_SKIPPED, "ID CHECK SKIPPED"},
		{IDCHECK_MILITARY_EXCEPTION, "MILITARY EXCEPTION"},
		{IDCHECK_DATE_BASED_EXCEPTION, "DATE BASED EXCEPTION"},
		{IDCHECK_MANUAL_ENTRY_OVERRIDE, "MANUAL ENTRY OVERRIDE"},
		{IDCHECK_BYPASS, "BYPASS"},
		{IDCHECK_LEGAL_AGE, "I confirm age is legal"},
		{MO_SALE_NOT_ALLOWED, "Money Orders cannot be sold at this time."},
		{MO_PAYMENT_NOT_ALLOWED, "Money Order Payment not allowed at this time."},
		{CSHR_NOT_SELF_CERTIFIED, "Cashier not self-certified."},
		{INVALID_EMPLOYEE_NAME, "No Valid Employee name"},
		{MONEY_ORDER, "MONEY ORDER"},
		{MO_SWB_PROMPT1, "I certify this is my true and correct name. I am AML/Fraud trained"},
		{MO_SWB_PROMPT2, "and will comply with all laws in processing transactions. Y/N?"},
		{EMPLOYEE_ID, "Employee ID"},
		{CSR_MSG_USED_DRAWER, "Drawer used by different employee"},
		{CSR_MSG_MOBILE_SERVICE_UNAVAILABLE, "MOBILE SERVICE IS UNAVAILABLE FOR PAYMENTS"},
		{SEND_ZERO_COLLECT, "Balance changed to zero. Sending zero collect."},
		{LABEL_OK, "OK [Enter]"},
		{LABEL_CANCEL, "Cancel [Err/Corr]"},
		{SN_HEADER, "Serial Number"},
		{ENTER_SN, "Enter Serial Number"},
		{PRINT_DETAIL_REVIEW_FOOTER, "Touch to select/highlight/display or key entry# and <ENTER>,then touch <ENTER> or <Reprint> to print receipt"},
		{RECALL_DETAIL_REVIEW_FOOTER, "Touch to select/highlight/display or key entry# and <ENTER>,then touch <ENTER> or <Recall> to recall receipt"},
		{FAILURE_REASON, "Failure Reason:"},
		
		/*cr1239.01- message to be displayed on confirmation overlay of clear reserve button*/
		{CONFIRM_HEADER, "CONFIRM"},
		{CONFIRM_SYMBOL, " ?"},
		/***********************************************************************************/
		{COLLECT_DIAG_DATA,"Collecting Diagnostics Data"},
		{SHORT_DATE_DISPLAY_PATTERN, ""},
		{SELECT_OPTION, "Select Option"},
		// Fiscal Printer Strings
		{FSC_PRINT_REPORT, "Print Fiscal Report?"},
		{FSC_SELECT_REPORT, "Select Report"},
		{FSC_OR_PRESS_ANY_KEY, "OR\n\nPress any other key to exit"},
		{FSC_Z_REPORT, "Z Report"},
		{FSC_X_REPORT, "X Report"},
		{FSC_PRINTING_REPORT, "Printing Report"},
		{FSC_PLEASE_WAIT, "Please Wait..."},
		{FSC_PRINTER_ERROR, "PRINTER ERROR"},
		{FSC_ERROR_CODE, "Error Code: "},
		{FSC_DATA, "Fiscal Data"},
		{FSC_INVALID_ENTRY, "Invalid Entry"},
		{FSC_TRANSACTION_FORCED_VOID, "Transaction is Forced Void"},
		{FSC_AMOUNT_FORCED_TO_ZERO, "Amount is Forced to Zero"},
		{FSC_PRESS_ENTER_TO_CONTINUE, "Press [ENTER] to Continue"},
		{FSC_PRINTING, "PRINTING"},
		{FSC_PRINTING_TRANSACTION, "Printing Transaction"},
		{FSC_CUST_TAX, "Tax # Must be Between %1$d and %2$d Characters"},
		{FSC_CUST_NAME, "Name Must be Between %1$d and %2$d Characters"},
		{FSC_CUST_ADDR, "Address Must be Between %1$d and %2$d Characters"},
		{FSC_ORIG_COO, "COO Must be %1$d Characters"},
		{FSC_ORIG_PRT, "Printer # Must be Between %1$d and %2$d Characters"},
		{FSC_ORIG_DATE, "Date Must be %1$d Characters"},
		{FSC_ORIG_TIME, "Time Must be %1$d Characters"},
		{FSC_REMAINING_RETRIES, "Remaining Retries "},
		{FSC_PRMPT_VALID_INFO, "Current tax information valid?"},
		{FSC_PRMPT_CUST_TAX, "Enter Customer Tax #"},
		{FSC_PRMPT_NEW_CUST_NAME, "New Customer {0}, Name"},
		{FSC_PRMPT_CUST_NAME, "Enter Customer Name"},
		{FSC_PRMPT_CUST_ADDR, "Enter Customer Address"},
		{FSC_PRMPT_OLD_CUST_NAME, "Old name: {0}"},
		{FSC_PRMPT_OLD_CUST_ADDR, "Old address: {0}"},
		{FSC_PRMPT_STR_COLON_TAXID, "{0}: {1}"},
		{FSC_PRMPT_CUST_COO, "Enter Original Customer COO"},
		{FSC_PRMPT_ORIG_PRT, "Enter Original Printer Serial #"},
		{FSC_PRMPT_ORIG_DATE, "Enter Original Voucher Date (yymmdd)"},
		{FSC_PRMPT_ORIG_TIME, "Enter Original Voucher Time (hhmmss)"},
		{FSC_ALARM_AVAILABLE, "There are {0} {1} available"},
		{FSC_ALARM_END_DATE, "{0} days to reach {1} end date"},
		{FSC_PRMPT_STATUS, "STATUS"},
		{SAFE_DROP, "Safe Drop"},
		{SAFE_LOAN, "Safe Loan"},
		{CLOCK_FNS, "Clock In/Out"},
		{PAY_IN, "Pay In"},
		{PAY_OUT, "Pay Out"},
		{SAFE_DROP_CORR, "Safe Drop Correction"},
		{CHOOSE_PINPAD, "Choose Pinpad"},
		{CHOOSEAPINPAD, "Choose a Pinpad"},
		{LOGIN_SUCCESS, "Login Success"},
		{PINPAD_IN_USE, "PINpad is in use or Unavailable"},
		{PRIMARY_PINPAD_DEFAULT, "Primary Pinpad (Default)"},
		{THIRD_PARTY_PRODUCT, "Third Party Product"},
		{VOUCHER_NOT_CONFIGURED, "Error: No Department is configured for the product or Third Party Product Provider is not configured."},
		{VOUCHER_FAILURE, "Error: Unable to complete 3rd Party Product Process."},
		{MULT_VOUCHER_FAILURE, "Multiple 3rd Party Products not allowed."},
		{NO_MATCHING_NETWORK, "Error: Invalid Voucher Id or matching Third Party Product Provider not found."},
		{REFUND_NOT_SUPPORTED, "Refund not supported for Third Party Products."},
		{NO_SALE_ITEMS_FROM_TPP, "No items were received from the 3rd Party Product Provider."},
		{RECALL_TXN,						"Recall Transaction"},
		{REPRINT_TXN,						"Reprint Transaction"},
		{PRMPT_CUST_NUMBER, "Enter Customer Number:"},
		{FV_ENTER_NUMBER, "Enter {0} Number:"},
		{INVALID_SEQ_NUM, "Invalid Sequence Number"},
		{OUTDATED_SEQ_NUM, "Outdated Sequence Number"},
		{MORE,"MORE"},
		{OPERATION_NOT_SUPPORTED,"Operation Not Supported."},
		{CARD_ACTIVATED,"CARD ACTIVATED"},
		{TAX_EXEMPT_TYPE,"Select Tax Exempt"},
		{TAX_EXEMPT,"Tax Exempt"},
		{ATTENDANT_ACTIVATION,"Attendant Activation"},
		{ATTENDANT_SESSION_STORE_FAILED,"Unable to store Attendant information"},
		{FAILURE,"Failure"},
		{CANCELLED,"Cancelled"}
	};
}
