package com.verifone.isd.xml.vocabulary;

public interface IXMLVocabulary {
    /**
     * Namespace for schema instance
     */
    public static final String XSI_NS = "http://www.w3.org/2001/XMLSchema-instance";
    /** Namespace for vocabulary elements
     */
    public static final String VS_NS = "urn:vfi-sapphire:vs.2001-10-01";
    public static final String PRIMARY_NS = "urn:vfi-sapphire:np.domain.2001-07-01";
    public static final String FUEL_NS = "urn:vfi-sapphire:fuel.2001-10-01";
    public static final String DCR_NS = "urn:vfi-psc:dcr.2012-04-10";
    public static final String APP_NS = "urn:vfi-sapphire:app.2003-02-18";
	public static final String ECHECK_NS = "urn:vfi-sapphire:np.echeck.2005-09-01";
    public static final String ESAFE_NS = "urn:vfi-sapphire:fuel.2007-08-31";
    public static final String ESAFE_NS1 = "urn:vfi-sapphire:pd.2002-05-21";
	public static final String IPT_NS = "urn:vfi-sapphire:ipt.2008-12-09";
	public static final String EXT_NS = "urn:vfi-sapphire:np.naxmlext.2005-06-24";
	public static final String PSC_FUEL_NS ="urn:vfi-psc:fuel.2013-02-08";
	public static final String EPS_PREPAID_NS = "urn:vfi-sapphire:np.epsprepaid.2012-02-20";
	public static final String KIOSK_NS  ="urn:vfi-sapphire:kiosk.2005-08-13";
	public static final String DIAG_NS = "urn:vfi-sapphire:diagnostics.2017-01-17";
	public static final String USER_PROFILE_NS  ="urn:vfi-petro:userprofile.2017-03-20";
	public static final String TPPP_CONFIG_NS = "urn:vfi-sapphire:np.thirdpartyproductconfig.2017.08.22";
	public static final String APT_CONFIG_NS  ="urn:vfi-apt.2017-07-07";
	public static final String VISTA_CONFIG_NS  ="urn:vfi-vista.2017-07-07";
	public static final String CCW_NS = "urn:vfi-extpos.ui.ccw.2018-08-24";
	public static final String CSC_NS = "urn:vfi-extpos.ui.csc.2018-08-24";
    /** Namespace for report documents
     */
    public static final String PERIOD_NS = "urn:vfi-sapphire:pd.2002-05-21";
    /** Namespace for base vocabulary elements
     */
    public static final String BASE_NS = "urn:vfi-sapphire:base.2001-10-01";
    public static final String EVENT_NS = "urn:vfi-sapphire:event.2004-03-22";
    /** Namespace for Gempro Maintenance interface
     */
    public static final String GPMAINT_NS = "urn:vfi-sapphire:np.gpmaint.2004-08-03";
    /** Namespace for report configuration interface
     */
    public static final String REPORTCFG_NS = "urn:vfi-sapphire:np.rptcfg.2005-02-07";

    public static final String BASE_NET_NS = "urn:vfi-sapphire:np.network.2005-02-18";
	/**
	 * Namespace for payroll reports
	 */
	public static final String PAYROLLRPT_NS = "urn:vfi-sapphire:np.payrollrpt.2005-03-09";
	
	/**
	 * Namespace for screen configuration.
	 */
	public static final String SC_NS = "urn:vfi-sapphire:sc.2018-11-29";
	public static final String SC_NS_PANELCFG = "sc:panelCfg";
	
	public static final String AMPERSAND_SYMBOL = "&";
	public static final String EQUALS_SYMBOL = "=";

	public static final String  UPGRADE_NS 			=	"urn:vfi-sapphire:up.2008-04-16";
	public static final String  UPGRADE_SUMMARY_NS 	=	"urn:vfi-psc:upgradeSummary.2008-04-16";
	public static final String  PACKAGE_DETAILS		= "packageDetails";
	public static final String  SUB_PACKAGE_TASKS	= "subPackageTasks";
	public static final String  PACKAGE_VERSION		= "packageVersion";
	public static final String  ORIGIN_VERSION		= "originVersion";
	public static final String  CROSS_BRANDING		= "crossBranding";
	public static final String  BRANDING_ENABLED	= "enabled";
	public static final String  BRAND_NAME	= "brandName";
	public static final String  UPGRADE_TYPE   		= "upgradeType";
	public static final String  INSTALLATION_SUPPORTING_TASK   	= "isInstallationSupportingTask";
	public static final String  SCUPGRADETASK   	= "SCUpgradeTask";
	public static final String  TARGET_VERSION		= "targetVersion";
	public static final String  SUB_PACKAGE	    	= "subPackage";
	public static final String  ACTIVATION_CRITERIA	= "activationCriteria";
	public static final String  UPG_ACTIVATION_CRITERIA	= "upgActivationCriteria";
	public static final String  FORCED_UPG_ACT_CRITERION = "forcedUpgActivationCriteria";
	public static final String  FILES	        	= "files";
	public static final String  APPL_NAME	    	= "applName";
	public static final String  APPL_VER	    	= "applVer";
	public static final String  BASE_VERSION	    	= "baseVersion";
	public static final String  APPLICATION_NAME	    	= "applicationName";
	public static final String  BASE_VER	    	= "baseVer";
	public static final String  TARGET_DEVICE   	= "targetDevice";
	public static final String  TARGET_DEVICES   	= "targetDevices";
	public static final String  UPGRADE_MESSAGE		= "upgradeMessage";
	public static final String  REBOOT_REQ	    	= "rebootReq";
	public static final String  LISTENER_LOOKUP_TIME= "listenerLookupTime";
	public static final String  PROMPT_REQ	    	= "promptReq";
	public static final String  DEMO_MODE	    	= "demoMode";
	public static final String  ALLOW_SAME_VERSION_UPGRADE = "allowSameVersionUpg";
	public static final String  ALLOW_DOWNGRADE = "allowDowngrade";
	public static final String  SKIP_APP_NAME_CHECKING = "skipAppNameChecking";
	public static final String  KEY_BOARD_TIME_OUT	= "keyboardTimeout";
	public static final String  ALWAYS_PRINT_INSTRUCTION	= "alwaysPrintInstruction";
	public static final String  CONTINUE_ON_TIMEOUT	= "continueOnTimeout";
	public static final String  FILE_NAME	    	= "fileName";
	public static final String  SOURCEPATH	    	= "sourcePath";
	public static final String  DESTINATION_DEVICE 	= "destinationDevice";
	public static final String  DESTINATION_PATH 	= "destinationPath";
	public static final String  WAIT_FOR_COMPLETION = "waitForCompletion";
	public static final String  PROCEED_ON_FAILURE  = "proceedOnFailure";
	public static final String  IS_SECOND_PHASE_TASK  = "isSecondPhaseTask";
	public static final String  NO_OF_RETRIES    	= "noOfRetries";
	public static final String  EXECUTABLE_DESC  	= "executableDesc";
	public static final String  ALWAYS_EXECUTE   	= "alwaysExecute";
	public static final String  FORMAT_DOM   	= "formatDOM";
	public static final String  SKIP_PERIOD_CLOSE_CHECKING   	= "skipPeriodCloseChecking";
	public static final String  COMMAND_NAME   	= "commandName";
	public static final String  EXECUTABLE_NAME   	= "executableName";
	public static final String  TASK              	= "task";
	public static final String  RESPONSE   			= "response";
	public static final String  REASON_TEXT   		= "reasonText";
	public static final String  UPGRADE_RESPONSE   	= "upgradeResponse";
	public static final String  PARAMS   			= "params";
	public static final String  WAIT_TIME   		= "waitTime";
	public static final String  UP_PREFIX			= "up";
	public static final String  US_PREFIX			= "us";
	public static final String  PROGRESS_ALARM   	= "progressAlarm";
	public static final String  SUCCESS_ALARM    	= "successAlarm";
	public static final String  FAILURE_ALARM   	= "failureAlarm";
	public static final String  COMPLETED_WITH_ERRORS_ALARM   	= "completedWithErrorsAlarm";
	public static final String  UPGRADE_SUMMARY  	= "upgradeSummary";
	public static final String  UPGRADE_BENCHMARK  	= "upgradeBenchmark";
	public static final String  UPG_BENCHMARK_CREATION_TIME		= "benchMarkCreationTime";
	public static final String  UPG_BENCHMARK_VERSION		= "version";
	public static final String  SITE_VERSION_BEFORE_UPGRADE   	= "beforeUpgrade";
	public static final String  SITE_VERSION_AFTER_UPGRADE   	= "afterUpgrade";	
	public static final String  PROGRESS_DETAILS   	= "progressDetails";
	public static final String  UPGRADE_BEGIN_TIME  = "beginTime";
	public static final String  ELAPSED_TIME 	= "elapsedTime";
	public static final String  REMAINING_TIME  = "remainingTime";		
	public static final String CHALLENGE_QUESTIONS_SET = "challengeQuestionsSet";
	public static final String PROFILE = "profile";
	public static final String  UPGRADE_END_TIME  	= "endTime";
	public static final String  TASK_DETAILS  	= "taskDetails";
	public static final String  OVERALL_UPGRADE_STATUS  	= "upgradeStatus";
	public static final String  TIME_TAKEN  	= "timeTakenSeconds";
	public static final String  MESSAGE            	= "msg";
	public static final String  ERROR_DETAILS       	= "errorDetails";
	public static final String  UPG_SUMMARY		= "upgradeSummary";
	public static final String  UPG_DETAILS		= "upgradeDetails";
	public static final String  UPG_ACTIVATION_DETAILS = "activationDetails";
	public static final String  EXT_ACTIVATION_CRITERIA = "externalCriteria";
	public static final String  APPLICABLE_ACTIVATION_CRITERIA = "applicableCriteria";
	
	public static final String  APPLY_UPGRADE_FORCEFULLY = "applyUpgradeForcefully";	
	public static final String  METHOD_USED_TO_START_UPG = "methodUsedToStartUpgrade";
	
	public static final String  ACT_CRITERION = "criterion";
	public static final String  ACT_CRITERION_VALUE = "criterionValue";
	
	
	public static final String UPG_VALUE = "value";
	public static final String  METHOD = "method";
	public static final String  METHOD_APPLIED_AT = "appliedAt";
	public static final String  DAYS_REMAINING_FOR_UPGRADE = "daysRemainingForUpgrade";
	
	public static final String  UPG_EVENT = "event";
	public static final String  UPG_REMOTE_HOST = "host";
	public static final String  UPG_TOTAL_TASKS = "totalTasks";
	public static final String  UPG_PENDING_TASKS = "pendingTasks";
	
	public static final String  UPGRADE_STATUS = "upgradeStatus"; 
	public static final String  STATUS_MSG = "message";
	public static final String  STATUS_MSG_ID = "messageId";
	public static final String  UPG_STATUS = "status";
	public static final String  UPG_STATUS_ID = "statusId"; 	
	public static final String  UPG_EVENT_DETAILS = "eventDetails";	
	public static final String  UPG_IN_PROGRESS = "upgradeInProgress";
	public static final String  UPG_TIME = "time";
	public static final String  EVENT_ORIGINATOR = "eventOriginator";
	
	public static final String  METHOD_USED_TO_INITIATE_UPGRADE = "methodUsedToInitiateUpgrade";
    public static final String SITE_VERSION = "siteVersion";
	
	public static final String  TOKEN_AND_INSTRUCTIONS = "tokenAndInstructions";
	public static final String  UPG_TOKEN = "token";
	public static final String  INSTRUCTIONS = "instructions";
	public static final String  INSTRUCTION = "instruction";	

	public static final String  UPG_PACKAGE_VERSION		= "packageVersion";	
	
	public static final String ON_EOD = "onEOD";
	public static final String PRE = "pre";
	public static final String POST = "post";
	public static final String ON_ARRIVAL = "onArrival";
	public static final String ON_EOD_DATE = "onEODDate";
	public static final String ON_EOD_DAYS = "onEODDays";
	public static final String ON_CINIT = "onCustomerInit";
	public static final String ON_DTIME = "onSpecifiedTime";	
	public static final String UPG_SITE_VERSION = "siteVersion";
    public static final String FILE_NOT_FOUND = "File Not Found";
    public static final String CDATA_TYPE   = "CDATA";
    public static final String TRUE_STRING  = "1";
    public static final String ZERO_STRING  = "0";
    public static final String FALSE_STRING = ZERO_STRING;
    public static final String EMPTY_STRING = "";
    public static final String TIME_SEP_STRING  = ":";
    public static final String PERCENT_STRING = "%";
    public static final String NIL_STRING   = "nil";
    public static final String TRUE_STR_STRING  = "true";
    public static final String FALSE_STR_STRING  = "false";
    public static final String EMPTY_DATE_STRING = "------------";
    public static final String UNDERSCORE = "_";
	public static final String  UPGRADE_INFO		= "upgActivationInfo";
	public static final String  UPG_INFO		= "upgInfo";
	public static final String  UPGRADE_SOURCE   	= "upgradeSource";
	public static final String  TASK_IDENTIFIER   	= "identifier";

	public static final String BACKUP_CLEANUP_RULES = "backupCleanupFiles";
	public static final String DEFAULT = "default";
	public static final String BACK_UP = "backup";
	public static final String DELETE = "delete";	
	public static final String VPKS = "vpks";
	public static final String VPK = "vpk";
	public static final String UPG_TYPE = "upgType";
	public static final String UPG_TYPES = "upgTypes";
	public static final String FILE = "file";
	public static final String DELETE_ON_CLEAN_INSTALL = "deleteOnCleanInstall";
    public static final String PD_CLOSE_REQ_HISTORY_NS = "urn:vfi-psc:pd.close.2016-07-19";
    public static final String PD_CLOSE_REQ_HISTORY_PREFIX  = "pd";

    public static final String PD_CLOSE_REQ_HISTORY="periodCloseSummary";
    public static final String PD_CLOSE_REQ     = "request";
    public static final String PD_CLOSE_REQ_INFO    = "requestInfo";
    public static final String PD_CLOSE_REQ_TIME    = "requestTime";
    public static final String PD_CLOSE_REQ_TYPE    = "requestType";
    public static final String PD_CLOSE_REQ_PD_TYPE     = "requestPdType";
    public static final String PD_CLOSE_REQ_INITIATOR   = "initiator";

    public static final String PD_CLOSE_REQ_STATUS  = "status";
    public static final String PD_CLOSE_REQ_STATUS_INPROGRESS   = "inProgress";
    public static final String PD_CLOSE_REQ_STATUS_STATE  = "state";
    public static final String PD_CLOSE_REQ_STATUS_FAILURE  = "failure";
    public static final String PD_CLOSE_REQ_STATUS_FAILURE_REASON   = "reason";
    public static final String PD_CLOSE_REQ_STATUS_SUCCESS  = "success";
    public static final String NETWORK_ERROR_IGNORED  = "networkErrorIgnored";
    public static final String PD_CLOSE_REQ_STATUS_SUCCESS_PDINFO   = "periodInfo";
    public static final String PD_CLOSE_REQ_STATUS_SUCCESS_BEGIN_TIME   = "openedDate";
    public static final String PD_CLOSE_REQ_STATUS_SUCCESS_END_TIME     = "closedDate";
    public static final String PD_CLOSE_REQ_STATUS_SUCCESS_SEQ_NO   = "seqnr";
    public static final String PD_CLOSE_REQ_STATUS_SUCCESS_CONSTITUENT_INFO     = "constituentPeriodInfo";
    public static final String PD_CLOSE_REQ_STATUS_FAILURE_CODE   = "code";
    public static final String PD_CLOSE_EPS_RECONCILIATION     = "epsReconciliation";
    public static final String PD_CLOSE_EPS_BATCH_INFO     = "epsBatchInfo";
    public static final String PD_CLOSE_EPS_ID     = "epsID";
    public static final String PD_CLOSE_TERMINAL_BATCH     = "terminalBatch";

    //Element/ attribute names used across all documents
    public static final String XSI_NS_PREFIX= "xsi";
    public static final String VS_NS_PREFIX= "vs";
    public static final String CCW_NS_PREFIX= "ccw";
    public static final String CSC_NS_PREFIX= "csc";
    public static final String v1_NS_PREFIX= "v1";
    public static final String BASE_NET_NS_PREFIX= "net";
    public static final String FUEL_NS_PREFIX= "fuel";
    public static final String DCR_NS_PREFIX= "dcr";
    public static final String BASE_NS_PREFIX= "base";
    public static final String SC_NS_PREFIX= "sc";

    public static final String DOMAIN_NS    = "domain";
    public static final String APT_NS    = "apt";
    public static final String VISTA_NS    = "vista";
    public static final String USERPROFILE    = "userprofile";
	public static final String QUESTION_ID = "questionID";
	public static final String DESCRIPTION_STR = "description";
	public static final String QUESTION = "question";
	public static final String ANSWER = "answer";
	public static final String USER_NAME = "userName";
	public static final String CHALLENGE_ANSWERS = "challengeAnswers";
    public static final String APP_DOMAIN   = "app";
    public static final String ATTR_XMLSPACE   = "xml:space";
    public static final String ATTR_XMLSPACE_PRESERVE = "preserve";
    public static final String SITE_ID      = "site";
    public static final String SYS_ID       = "sysid";
    public static final String RCFC_INEFFECT_SYSID       = "inEffectRapidChangeFuelConfig";
    public static final String TENDERCODE_ID       = "id";
    public static final String TENDERSUBCODE_ID       = "id";
    public static final String CAT          = "cat";
    public static final String NAXML_PROMOTION_ID     = "promotionid";
	public static final String PROMOTION_ID	= "promotionID";
    public static final String PROMO_ID     = "promoID";
    public static final String NAME         = "name";
    public static final String IDENTIFIER   = "feeIdentifier";
    public static final String OPERATION    = "operation";
    public static final String TYPE_STRING  = "type";
    public static final String CANCEL_STRING  = "cancel";
    public static final String UPDATE_OP    = "update";
    public static final String DELETE_OP    = "delete";
    public static final String EMPTY_OP		= "empty";
    public static final String VALUE        = "value";
	public static final String IGNORE		= "ignore";
	public static final String DISABLED		= "disabled";
	public static final String DISABLE_UC	= "DISABLE";
    public static final String UOM          = "uom";
    public static final String MSG_STRING   = "message";
    public static final String PRODUCT_CODE = "prodCode";
    public static final String PRODUCT_CODES = "prodCodes";
    public static final String DEPARTMENT   = "department";
    public static final String DEPARTMENTS  = "departments";
    public static final String INTERNAL_DEPARTMENTS  = "internalDepartments";
    public static final String INTERNAL_DEPARTMENT   = "internalDepartment";
    public static final String MOP_CODES    = "mopCodes";
    public static final String MOP_CODE     = "mopCode";
    public static final String NACS_TENDERCODE     = "nacstendercode";
    public static final String NACS_TENDERSUBCODE  = "nacstendersubcode";
	public static final String NACS_TENDERCODES = "nacsTenderCodes";
	public static final String NACS_TENDERSUBCODES = "nacsTenderSubCodes";
    public static final String MOP_CFG      = "mopConfig";
    public static final String MOPS         = "mops";
    public static final String MOP          = "mop";
    public static final String CATEGORIES   = "categories";
    public static final String CATEGORY     = "category";
    public static final String FEE_CFG      = "feeConfig";
    public static final String FEES         = "fees";
    public static final String FEE          = "fee";
    public static final String TAX_RATE_CFG = "taxRateConfig";
    public static final String TAX_RATES    = "taxRates";
    public static final String TAX_RATE     = "taxRate";
    public static final String TAX_AMT      = "taxAmt";
    public static final String TAX_NET      = "taxNet";
    public static final String TAX_IN_TOT   = "taxInTot";
    public static final String TAX_ATTRRIBUTE = "taxAttribute";

    public static final String TAXABLE_REBATE = "taxableRebate";
    public static final String IS_FUEL      = "isFuel";
    public static final String DISALLOW_ASSIGNMENT   = "disallowAssignment";
    public static final String LIMIT        = "limit";
    public static final String CURRENCY_LIMIT        = "currencyLimit";
    public static final String CURRENCY_CFG = "currencyConfig";
    public static final String PLUPROMO_CFG = "pluPromoConfig";
	public static final String ENTRY_METHOD = "entryMethod";
	public static final String KEYBOARD 	= "keyboard";
	public static final String SCANNER		= "scanner";
	public static final String OTHER		= "other";
    public static final String IPT	    	= "ipt";
    public static final String BASE	    	= "base";
    public static final String FOREIGNCURR_STRING = "trpForeign";
    public static final String PERIOD_TYPES  = "periodTypes";
    public static final String IS_NETWORK = "isNetwork";
    
    public static final String HELPDESKPHONENUMBER  = "helpDeskPhoneNumber";
    public static final String HELPDESKPHONENUMBERS  = "helpDeskPhoneNumbers";
    public static final String STORE_SERVICEID       = "storeServiceID";
    
    //Format types
    public static final String MODE_STRING  = "mode";
    public static final String DOUBLE_MODE  = "double";
    public static final String NORMAL_MODE  = "normal";
    public static final String IS_ENABLED   = "enabled";

    public static final String JUSTIFY_STRING   = "justify";
    public static final String CENTER_JUSTIFY   = "center";
    public static final String LEFT_JUSTIFY     = "left";
    public static final String RIGHT_JUSTIFY    = "right";

    public static final String ROTATE_DISPLAY   = "rotateDisplay";

    //vAppInfo
    public static final String APP_INFO     = "appInfo";
    public static final String SUITE_VER   = "suiteVersions";
    public static final String NEWPRO_VER   = "newproVersions";
    public static final String GEMPRO_VER   = "gemproVersions";
    public static final String TOPAZ_VER    = "topazVersions";
    public static final String RUBY2_VER    = "ruby2Versions";
    public static final String C18_VER      = "c18Versions";
    public static final String C15_VER      = "c15Versions";
    
    public static final String VERSION      = "version";
    public static final String DATE         = "date";
    public static final String DATA_SUBSET  = "dataSubsetName";
    public static final String IS_LDM       = "isLoadModule";
    public static final String SIZE         = "size";
    public static final String MAJOR_VER    = "majorVersionNr";
    public static final String MINOR_VER    = "minorVersionNr";
    public static final String REL_VER      = "releaseVersionNr";
    public static final String MAINT_VER    = "maintenanceVersionNr";
    public static final String TIME_STAMP   = "timeStamp";
    public static final String SCREEN_CFG	= "screencfg";
    public static int MAX_SCREEN_NAME_LENGTH = 12;
    public static final String SCREEN_WIDTH	= "screenWidth";
    public static final String SCREEN_HEIGHT = "screenHeight";
    public static final String MAX_ROWS   = "maxRows";
    public static final String MAX_COLS   = "maxCols";
    public static final String FORCE_TOPAZ_PANEL   = "forceTopazLayout";

    //vdcrconfig and udcrconfig
    public static final String DCR_CFG      = "dcrConfig";
    public static final String DCR_HDR_CFG  = "dcrHeaderConfig";
    public static final String DCR_HDRS     = "dcrHeaders";
    public static final String DCR_MSG_CFG  = "dcrMessageConfig";
    public static final String DCR_MSGS     = "dcrMessages";
    public static final String DCR_TRL_CFG  = "dcrTrailerConfig";
    public static final String DCR_TRLS     = "dcrTrailers";
    public static final String DCR_HDR      = "dcrHeader";
    public static final String DCR_TRL      = "dcrTrailer";
    public static final String DCR_MSG      = "dcrMessage";
    public static final String DCR_MAX_POSITIONS = "maxDCRPositions";
    public static final String FORCE_EMV_ENABLED = "forceEmvEnabled";

    public static final String DCR_SITEINFO     = "dcrSiteInfo";
    public static final String APPROVEALL       = "isApproveAllSales";
    public static final String NAMEONRCPT       = "isNameOnReceipt";
    public static final String ACCTONRCPT       = "isAccountOnReceipt";
    public static final String HANDLEUPHELP     = "handleUpHelpMsg";
    public static final String ALWAYSPRINTRCPT  = "isAlwaysPrintReceipt";
    public static final String SCROLLRATE       = "scrollingRate";
    public static final String LOWPAPERALARM    = "isLowPaperAlarm";
    public static final String GRAPHICDELAY     = "graphicAnimationDelay";
    public static final String RECEIPTBEFORE    = "isPromptReceiptBefore";
    public static final String RECEIPTAFTER     = "isPromptReceiptAfter";
    public static final String ARMEDFORCES      = "isArmedForcesRestriction";
    public static final String DEBITSURCHFEE    = "isDebitSurchargeFee";
    public static final String SURCHPROMPT      = "isSurchargePrompt";
    public static final String ERRORPROMPT      = "errorPromptTime";
    public static final String INFOPROMPT       = "infoPromptTime";
    public static final String USERPROMPT       = "userPromptTime";
    public static final String DEBITYNPROMPT    = "isDebitYNPrompt";
    public static final String DCRDIAGNOSTIC    = "isDCRDiagnostic";
    public static final String MISTAKEBEEP      = "isMistakeBeep";
    public static final String ATTENTIONBEEP    = "isAttentionBeep";
    public static final String KEYPRESSBEEP     = "isKeypressBeep";
    public static final String PRINTCASHPREPAYDCR     = "isPrintCashPrepayOutside";
    public static final String DISPCASHCREDITPROMPT   = "isDisplayCashCreditPrompt";
    public static final String PLAYDCRAUDIO   = "isPlayDCRAudio";
    
    public static final String SENDPRESETAMTTOHOST   = "isSendPresetAmountToHost";
    public static final String ALLOWFILLUPWITHPRESET = "isAllowFillUpWithPreset";

    public static final String DCR_ATTRIBUTES   = "dcrAttributes";
    public static final String DCRINDISPENSER   = "isDCRInDispenser";
    public static final String DCROUTOFSERVICE  = "isDCROutOfService";
    public static final String PAYATPUMP        = "isPayAtPump";
    public static final String PAYATPUMPONLY    = "isPayAtPumpOnly";
    public static final String PREPAYONLY       = "isPrepayOnly";
    public static final String HOTDCR           = "isHotDCRMode";
    public static final String STARTBUTTON      = "isStartButton";
    public static final String GRADEBUTTON      = "isGradeButton";
    public static final String INSTANTON        = "isInstantOn";
    public static final String LEVERONPUMP      = "isLeverOnPump";
    public static final String HANDLEUPCALL     = "isHandleUpCalling";
    public static final String FULLSERVEPRESET  = "isFullServicePreset";
    public static final String GRAPHICENABLED   = "isGraphicEnabled";
    public static final String PRIMARYSIDE      = "primaryGraphicSide";
    public static final String GRAPHICKEYPAD    = "isGraphicKeypad";
    public static final String GRAPHICDISPLAY   = "graphicDisplay";
    public static final String GRAPHICPRINTER   = "isGraphicPrinter";
    public static final String SCANNERENABLED   = "isScannerEnabled";
    public static final String DCRDEBITENABLED  = "isDebitEnabled";
    public static final String RFIDENABLED      = "isRFIDEnabled";
    public static final String MENUCAPABLE      = "isMenuCapable";
    public static final String GRAPHICSCREEN_SIZE   = "graphicScreenSize";
    public static final String GRAPHICSCREEN_TEXT   = "graphicScreenText";
	public static final String DCREMVENABLED 	= "isEMVEnabled";
	public static final String DCREMVIP 		= "emvIPAddress";
	public static final String DCREMVIPPORT 	= "emvIPPort";


    //vpscdcrkeycfg and upscdcrkeycfg
    public static final String DCR_FIXEDKEY_CFG  = "dcrFixedKeyConfig";
    public static final String DCR_FIXEDKEY_LAYOUT  = "fixedKeyLayout";
    public static final String DCR_FIXEDKEY_LAYOUTS  = "fixedKeyLayouts";
    public static final String DCR_FIXEDKEY_LAYOUT_TYPE  = "fixedKeyLayoutType";
    public static final String DCR_KEYS  = "dcrKeys";
    public static final String DCR_KEY  = "key";
    public static final String DCR_ROW  = "row";
    public static final String DCR_COL  = "col";
    public static final String DCR_CODE  = "code";
    public static final String DCR_IDLE_FUNCTION = "idleFunction";
    public static final String DCR_IDLE_FUNCTIONS = "idleFunctions";
    public static final String DCR_ROWS  = "rows";
    public static final String DCR_COLUMNS  = "columns";
    public static final String DCR_POSITIONS  = "positions";
    public static final String DCR_POSITION  = "position";
    public static final String DCR_SYSID  = "sysid";
    public static final String DCR_NUM_OF_POSITIONS  = "numberOfPositions";
    public static final String DCR_LABEL  = "label";
    public static final String DCR_KEYTYPES  = "keyTypes";
    public static final String DCR_FUNCTION_KEYTYPES  = "functionKeyTypes";
    public static final String DCR_KEYTYPE  = "keyType";
    public static final String DCR_FUNCTION_TYPE  = "functionType";
    public static final String DCR_NAME  = "name";
    public static final String DCR_DISPLAY  = "display";

	//(v|u)dcrunattended
	public static final String DCR_UNATTENDED_CFG = "dcrUnattendedConfig";
	public static final String UNATTENDED_MODE = "unattendedMode";
	public static final String START_UNATTENDED_HRS = "startUnattendedHrs";
	public static final String NUM_UNATTENDED_HRS = "numUnattendedHrs";
	public static final String HELP_MESSAGE = "helpMessage";
	public static final String CASH_RECEIPT_MSG = "cashReceiptMsg";
	public static final String CASH_ACC = "cashAcc";
	public static final String ESIGN_OFFLINE ="esignOffline";

    //vdcridlescreencfg and udcridlescreencfg
    public static final String DCR_IDLESCREEN_CFG  = "dcrIdleScreenConfig";
    public static final String DCR_IDLESCREENS  = "idleScreens";
    public static final String DCR_IDLESCREEN  = "idleScreen";
    public static final String DCR_SOFTKEYS_ENABLED  = "softkeysEnabled";
    public static final String DCR_OLD_LABEL  = "oldLabel";
    public static final String DCR_IS_DELETE  = "isDelete";
    public static final String DCR_IDLESCREEN_TYPE  = "idleScreenType";
    public static final String DCR_GRAPHIC_SCREEN = "graphicScreen";
    public static final String DCR_SOFTKEY  = "softkey";
    public static final String DCR_TEXT  = "text";
    public static final String DCR_UNATTENDED  = "unattended";
    public static final String DCR_TYPE  = "type";
    public static final String DCR_EDITABLE  = "editable";
    public static final String DCR_MIDDLE_LINE  = "middleLine";
    public static final String DCR_NON_GRAPHIC_SCREEN = "nonGraphicScreen";
    public static final String DCR_LINE  = "line";
    public static final String DCR_DEFAULT_LINES  = "defaultLines";
    public static final String DCR_SOFTKEY_TYPES  = "softkeyTypes";
    public static final String DCR_SOFTKEY_TYPE  = "softkeyType";
    public static final String DCR_MAX_FPS  = "maxFuelingPositions";

    //vdatetime and udatetime
    public static final String SYS_DATE_TIME    = "sysDateTime";
    public static final String DATE_TIME        = "sysDT";
    public static final String SYS_TZ_ID        = "sysTzId";

    public static final String TIME_ZONE        = "tZone";
    public static final String TZ_ID            = "tzId";
    public static final String TZ_OFFSET        = "offset";
    public static final String DST_APPLIES      = "dstApplies";

    //vsapphireprop and usapphireprop
    public static final String SAPPHIRE_PROPS   = "sapphireProperties";

    //vlocaleinfo and ulocaleinfo
    public static final String LOCALE_INFO      = "localeinfo";

    //cloud agent property
    public static final String CLOUDAGENT_PROPS   = "cloudagentProperties"; 
    
  //cdm agent property
    public static final String CDMAGENT_PROPS   = "cdmagentProperties"; 
    public static final String CDMAGENT_DIAGNOSTICS_STATUS   = "cdmagentStatus"; 
      
    //vuseradmin, uuseradmin and changepasswd
    public static final String CHALLENGE_QUESTIONS = "challengeQuestions";
    public static final String USER_CFG     = "userConfig";    
    public static final String ROLE_CFG     = "roleConfig";
    public static final String USERS        = "users";
    public static final String USER         = "user";
    public static final String ROLES        = "roles";
    public static final String ROLE         = "role";
    public static final String FUNCTIONS    = "functions";
    public static final String FUNCTION     = "function";
    public static final String VALID_ROLES  = "validRoles";
    public static final String EXPIRE       = "expire";
    public static final String FREQ         = "freq";
    public static final String MIN_LENGTH   = "minLen";
    public static final String MAX_LENGTH   = "maxLen";
    public static final String PASSWORD     = "passwd";
    public static final String FORCE_CHANGE = "forceChange";
    public static final String VALID_FNS    = "validFns";
    public static final String COMMAND      = "cmd";
    public static final String PASSWORD_CFG = "passwdConfig";
    public static final String OLD_VALUE    = "oldValue";
    public static final String NEW_VALUE    = "newValue";
    public static final String PASSWORD_FAIL_COUNT    = "pwdFailCount";
    public static final String PASSWORD_EXPIRY_DATE   = "pwdExpiryDate";
    public static final String LOCK_OUT_EXPIRATION    = "lockOutExpiration";
    public static final String RECENT_PASSWORDS   	  = "recentPasswords";
    public static final String RECENT_PWD   	  = "recentPwd";
    public static final String OTPREQUIRED	= "OTPRequired";
    public static final String ADDITIONAL_DATA = "additionalData";
            
//    code added for CR-3835 (3913) tattu
    public static final String SECURE_USER_ID    = "secureUserID";
    public static final String SECURE_USER_ADMIN = "isSecureUserAdmin";
    public static final String SECURE_ROLE = "isSecureRole";
    //CR 6067.00 TT1
    public static final String IS_DISALLOW_LOGIN = "isDisallowLogin";
    //vsalescfg and usalescfg
    public static final String SALES_CFG        = "salesConfig";
    public static final String SALES_CFG_ITEMS  = "salesConfigItems";
    public static final String SALES_CFG_ITEM   = "salesConfigItem";
    public static final String DESCRIPTION      = "desc";
    public static final String SALESLOGINOUT    = "salesLogInOut";
    public static final String SALESLOGIN       = "logIn";
    public static final String SALESLOGOUT      = "logOut";
    public static final String MSG_LINE         = "msgLine";

    //vperiodcfg and uperiodcfg
    public static final String PERIOD_CFG       ="periodConfig";
    public static final String PERIOD           ="period";

    //vrestrictionscfg and urestrictionscfg
    public static final String RESTRICTION_CFG  = "restrictionsConfig";
    public static final String CUST_ID_CFG      = "ageValidationConfig";
    public static final String CUST_ID_CHECKS   = "ageValidations";
    public static final String CUST_ID_CHECK    = "ageValidation";
    public static final String BLUE_LAW_CFG     = "blueLawConfig";
    public static final String BLUE_LAWS        = "blueLaws";
    public static final String BLUE_LAW         = "blueLaw";
    public static final String PLU_PROMOS       = "pluPromos";
    public static final String PLU_PROMO        = "pluPromo";
    public static final String MINIMUM_AGE      = "minAge";
    public static final String DAY              = "day";
    public static final String IS_EFFECTIVE     = "isEffective";
    public static final String PROPERTIES       = "properties";
    public static final String PROPERTY         = "property";
    public static final String UPC              = "upc";
    public static final String UPC_MODIFIER     = "upcModifier";
    public static final String START_DATE       = "startDate";
    public static final String END_DATE         = "endDate";
    public static final String START_TIME       = "startTime";
    public static final String END_TIME         = "endTime";
    public static final String MONEY_DISC       = "moneyDiscount";
    public static final String PCT_DISC         = "pctDiscount";
    public static final String CWDISC_VOLUME    = "carWashDiscVolume";
    public static final String PROD_RESTR       = "prodRestrictionId";
    public static final String CWDISC_MONEY     = "carWashDiscMoney";
    public static final String EFFECTIVE_DURN   = "effDurn";
    public static final String SUPPORTINFO	    = "supportInfo";
	public static final String FORCE_SCAN_SWIPE_ID_CHECK = "forceScanSwipeIDCheck";
	public static final String PERFORM_LEGITIMACY_CHECK = "performLegitimacyCheck";
	
	// KKB - CR2452.01
    public static final String MAN_ENTRY_OVERRIDE = "manEntryOverride";
    public static final String MAN_ENTRY_OVERRIDE_SECLEVEL = "manEntryOverrideSecLevel";
    public static final String BYPASS_ID_CHECK = "bypassIDCheck";
    public static final String BYPASS_ID_CHECK_SECLEVEL = "bypassIDCheckSecLevel";
    public static final String BYPASS_ID_CHECK_CONFIRM_PRMPT = "bypassIDCheckConfirmPrmpt";
    public static final String MILITARY = "military";
    public static final String MILITARY_MIN_AGE = "militaryMinAge";
    public static final String GRANDFATHER = "grandfather";
    public static final String GRANDFATHER_MIN_AGE = "grandfatherMinAge";
    public static final String GRANDFATHER_MIN_DATE_AGE = "grandfatherMinDateAge";

    //vregistercfg and uregistercfg
    public static final String REGISTER_NUMBER  = "regNum";
    public static final String REGISTER_CFG     = "registerConfig";
    public static final String REGISTERS        = "registers";
    public static final String REGISTER         = "register";
    public static final String REGISTER_TYPE    = "registerType";
    public static final String CONTROLLER         = "controller";
    public static final String SAPPHIRE         = "controller";
    public static final String RUBYCI           = "controller";
    public static final String RUBY             = "ruby";
    public static final String TOPAZ            = "topaz";
    public static final String RUBY2            = "ruby2";
    /** Model name for Python platforms with 15" display. See '...vsms2.sys.util.register.ModelInfo'. */
    public static final String PYTHON_C15       = "C15";
    /** Model name for Python platforms with 18" display. See '...vsms2.sys.util.register.ModelInfo'. */
    public static final String PYTHON_C18       = "C18";
    public static final String BANNER_CFG       = "bannerConfig";
    public static final String BANNERS          = "banners";
    public static final String BANNER           = "banner";
    public static final String LOGO_CFG         = "logoConfig";
    public static final String LOGOS            = "logos";
    public static final String LOGO             = "logo";
    public static final String SLOGAN_CFG       = "sloganConfig";
    public static final String SLOGANS          = "slogans";
    public static final String SLOGAN           = "slogan";
    public static final String MENUS            = "menus";
    public static final String MENU             = "menu";
    public static final String CHECK_LINE_CFG   = "checkLineConfig";
    public static final String CHECK_LINES      = "checkFrankLines";
    public static final String CHECK_LINE       = "checkFrankLine";
    public static final String SOFT_KEY_CFG     = "softKeyConfig";
    public static final String SOFT_KEYS        = "softKeys";
    public static final String SOFT_KEY         = "softKey";
    public static final String ROTATE_DISP      = "rotateDisplay";
    public static final String PLU              = "PLU";
    public static final String MODIFIER         = "modifier";
    public static final String MSG              = "msg";
    public static final String IS_ENABLED1      = "isEnabled";
    public static final String OBJECT_ID        = "objID";

    public static final String KEY_BOARD   = "keybd";
    public static final String COLUMN_ID   = "colID";
    public static final String ROW_ID      = "rowID";
    public static final String KEY_TYPE    = "keyType";
    public static final String KEY         = "key";
    public static final String SOFT_KEY_TYPES = "softKeyTypes";
    public static final String KEY_CODE    = "code";
    public static final String IS_OBJ_REQD = "isObjReqd";
    public static final String SOFT_KEY_TYPE   = "softKeyType";
    public static final String DISALLOWED_RUBY = "disallowedOnRuby";
    public static final String SECURITY_LEVEL_CONFIGURABLE= "securityLevelConfigurable";

    //vpaymentcfg and upaymentcfg
    public static final String PMT_CFG          = "paymentConfig";
    public static final String CURRENCIES       = "currencies";
    public static final String CURRENCY         = "currency";
    public static final String CODE             = "code";
    public static final String MINIMUM          = "min";
    public static final String MAXIMUM          = "max";
    public static final String NUM_RCPT_COPIES  = "numReceiptCopies";
    public static final String FORCE_SAFEDROP   = "isForceSafeDrop";
    public static final String OPEN_DRW_SALE    = "isOpenDrwOnSale";
    public static final String TENDER_AMT_REQD  = "isTenderAmtReqd";
    public static final String CASHR_RPT_PROMPT = "isCashrRptPrompt";
    public static final String ZERO_ENTRY       = "isAllowZeroEntry";
    public static final String WITHOUT_SALE     = "isAllowWithoutSale";
    public static final String REFUND           = "isAllowRefund";
    public static final String CHANGE           = "isAllowChange";
    public static final String SAFEDROP         = "isAllowSafeDrop";
    public static final String MO_PURCHASE     = "isAllowMOPurch";
    public static final String TICKET_PRINT     = "isForceTicketPrint";
	public static final String FORCE_FIXED_AMOUNT  = "isForceFixedAmount";
	public static final String ATTR_FIXED_AMT  = "fixedAmount";
	public static final String ATTR_CONFIGURABLE_FIXED_AMT  = "configurableFixedAmount";
    public static final String FEE_DEPARTMENT   = "dept";
    public static final String REFUNDABLE       = "isRefundable";
    public static final String RANGE            = "range";
    public static final String RANGE_FEE        = "rangeFee";
    public static final String RANGE_END        = "rangeEnd";
    public static final String SYMBOL           = "symbol";
    public static final String PRINTNAME_PLURAL_ONE = "printNamePluralOne";
    public static final String PRINTNAME_PLURAL_OTHER = "printNamePluralOther";
	public static final String INDICATOR        = "indicator";
    public static final String PRICE_INCTAX     = "isPriceIncsTax";
    public static final String PROMPT_EXEMPT    = "isPromptExemption";
    public static final String RATE             = "rate";
    public static final String PCT_START_AMT    = "pctStartAmt";
    public static final String TAX_PROPS        = "taxProperties";
    public static final String MIN_TAXABLE_AMT  = "minTaxableAmt";
    public static final String RPT_START        = "rptStartNum";
    public static final String RPT_END          = "rptEndNum";
    public static final String BP_ALL_AMTS      = "isBPTableForAllAmts";
    public static final String BREAKPT_PROPS    = "breakPtProps";
    public static final String REG_NUM          = "regNum";
    public static final String FUEL_INC_TAX     = "fuelIncTax";
    public static final String CGST_PROPS       = "canadianGSTProps";
    public static final String TAX_ID           = "taxID";
    public static final String COLLECT_ON       = "collectOnTax";
    public static final String TAX_BPS          = "taxBreakPts";
    public static final String BP_NUM           = "bpNum";
    public static final String AMT_DIFF         = "amtDiff";
    public static final String TAX_INCR         = "taxIncr";
    public static final String BREAK_PT         = "breakPt";
    public static final String PERCENTAGE_FEE         = "percentageFee";

    //vpossecurity and upossecurity

    public static final String POS_SECURITY     = "posSecurity";
    public static final String SECURITY_CTRLS   = "securityCtrls";
    public static final String SECURITY_CTRL    = "securityCtrl";
    public static final String EMPLOYEES        = "employees";
    public static final String EMPLOYEE         = "employee";
    public static final String EMP_NR           = "number";
    public static final String SECURITY_LEVEL   = "securityLevel";
    public static final String IS_CASHIER       = "isCashier";
	public static final String GEMCOM_PASSWD       = "gemcomPasswd";
    public static final String MENU_ID          = "menuID";
    public static final String SUBMENU_ID       = "subMenuID";

    //vposcfg and uposcfg
    public static final String POS_CFG          = "posConfig";
    public static final String IS_NOTSOLD       = "isNotSold";
    public static final String MIN_AMOUNT       = "minAmt";
    public static final String MAX_AMOUNT       = "maxAmt";
    public static final String FOOD_STAMPABLE   = "isAllowFS";
    public static final String NEGATIVE         = "isNegative";
    public static final String HIDDEN           = "isHidden";
    public static final String FRACT_QTY        = "isAllowFQ";
    public static final String SPL_DISC         = "isAllowSD";
    public static final String BL1              = "isBL1";
    public static final String BL2              = "isBL2";
    public static final String LOYALTY          = "isLoyaltyRedeemable";
    public static final String MONEY_ORDER      = "isMoneyOrder";
    public static final String SN_PROMPT_REQD      = "isSNPromptReqd";
    public static final String TAXES            = "taxes";
    public static final String TAX              = "tax";
    public static final String CUST_IDS         = "ageValidns";
    public static final String CUST_ID          = "ageValidn";
    public static final String PROHIBIT_DISC    = "prohibitDisc";
    public static final String MAX_QTY_PER_TRANS= "maxQtyPerTrans";

    //vdealcfg and udealcfg
    public static final String DEAL_CFG          = "dealConfig";
    public static final String BEGIN_DATETIME    = "begin";
    public static final String END_DATETIME      = "end";
    public static final String PLU_NUM           = "pluNum";
    public static final String ITEM_PRINT        = "receiptIncludesItems";
    public static final String FLAGS             = "flags";
    public static final String SALE_PRICE        = "salePrice";

    public static final String MIXES             = "mixes";
    public static final String MIX               = "mix";
    public static final String MIX_ITEM          = "mixItem";
    public static final String PRIMARY_MIX       = "primaryMix";

    public static final String DEPT_MIXES        = "deptMixes";
    public static final String DEPT_MIX          = "deptMix";
    public static final String DEPT_MIX_ITEM     = "deptMixItem";

    public static final String MATCHES           = "matches";
    public static final String MATCH             = "match";
    public static final String MATCH_ITEM        = "matchItem";
    public static final String USE_PLU_PRICE     = "isUsePLUPrice";
    public static final String PRICING_SCHEME    = "pricingScheme";
    public static final String PRICE_MATCH       = "Price Match";
    public static final String PRICE_EACH_MIX    = "Price Each Mix";
    public static final String QTY               = "qty";

    //vpopcfg and upopcfg
    public static final String POP_CFG          = "popConfig";
    public static final String COUPON_MSGS      = "couponMsgs";
    public static final String COUPON_MSG       = "couponMsg";
    public static final String POP_FUEL_DISCS   = "popFuelDiscounts";
    public static final String POP_FUEL_DISC    = "popFuelDiscount";
    public static final String DISCOUNT_AMOUNT  = "discountAmount";
    public static final String DISC_LEVEL       = "discLevel";
    public static final String POP_DISCS        = "popDiscounts";
    public static final String POP_DISC         = "popDiscount";
    public static final String WEEK_DAYS        = "weekDays";
    public static final String WEEK_DAY         = "weekDay";
    public static final String DISCOUNT_TYPE    = "discountType";
    public static final String PLU_BASED_DISC  	= "pluBasedDiscount";
    public static final String MOP_BASED_DISC  	= "mopBasedDiscount";
    public static final String CARD_BASED_DISC 	= "cardBasedDiscount";
    public static final String MIN_AMOUNT_DISC 	= "minAmountBasedDiscount";
    public static final String MIN_DEPT_PURCH_DISC 	= "minDeptPurchBasedDiscount";
    public static final String CARD_MEMBER_DISC 	= "cardTypeMemberDiscount";
    public static final String BAR_CODE_MEMBER_DISC = "barCodeTypeMemberDiscount";
    public static final String POP_DEFINITIONS  = "popDefinitions";
	public static final String POP_DEF_MAX_RECORDS = "POPDEFMAXRECS";
    public static final String POP_DEFINITION   = "popDefinition";
    public static final String GRADE_DEFINITION = "gradeDefinition";
    public static final String LEVEL            = "level";
    public static final String DISCOUNT_ONLY    = "Discount Only";
    public static final String DISCOUNT_OR_CODE = "Discount or Code";
    public static final String COUPON_ONLY      = "Coupon Only";
    public static final String CARD_TYPE        = "cardType";
    public static final String AWARD_TYPE       = "awardType";
    public static final String QUANTITY		= "quantity";
    public static final String MASK             = "mask";
    public static final String ALLOW_MANUAL     = "isAllowManualEntry";
    public static final String TRACK_1_OFFSET   = "track1Offset";
    public static final String TRACK_2_OFFSET   = "track2Offset";
    public static final String TRACK_PREFERENCE = "trackPreference";
    public static final String FUEL_LIMIT       = "fuelLimit";
    public static final String FUEL_VOLUME_LIMIT       = "fuelVolumeLimit";
    public static final String MEMBER_CARD_REQD = "membershipCardRequired";
    public static final String CARD_BASED_MASKED= "masked";
    public static final String CARD_BASED_BEGIN = "start";
    public static final String CARD_BASED_END   = "end";
	public static final String CARD_BASED_LOWFEE= "lowFee";
    public static final String NONE_REQUIRED    = "None";
    public static final String ANY_MEMBER_CARD  = "Any Card";
    public static final String SITE_PARAMETERS  = "siteParameters";
    public static final String POP_ENABLE       = "isPopEnable";
    public static final String POP_MODE         = "popMode";
    public static final String BASIC_MODE       = "Basic";
    public static final String BASIC_CODES      = "Basic_Codes";
    public static final String BASIC_MEMBERSHIP = "Basic_Membership";
    public static final String DAYS_CODE_VALID  = "daysCodeValid";
    public static final String FREE_CODE_ID     = "freeCodeDiscountId";
    public static final String FREE_AWARD_SEC   = "freeAwardSecurity";
    public static final String FREE_AUTO_AWARD_SEC  = "freeAutoAwardSecurity";
    public static final String RECALC_PROMPT    = "isRecalcPromptEnable";
    public static final String POP_MEMBER_NAME  = "popMembershipName";
    public static final String RCPT_PROMO_TYPE  = "receiptPromoType";
    public static final String BY_AMOUNT        = "byAmount";
    public static final String BY_VOLUME        = "byVolume";
    public static final String ALTERNATE_POP    = "isAlternatePop";
    public static final String LOWEST_PRICE_LVL = "lowestPriceLevel";
    public static final String CASH_PRICE_LVL   = "CASH";
    public static final String CREDIT_PRICE_LVL = "CREDIT";
    public static final String MEMBER_ID_PROMPT = "isMemberIdPrompt";
    public static final String POST_PAY_MEMBER  = "isPostPayMemberIdEnable";
    public static final String CARD_MEMBER_ID   = "isCardMemberIdEnable";
    public static final String SCAN_MEMBER_ID   = "isScanMemberIdEnable";
    public static final String FUEL_LOW_LIMIT   = "fuelLowLimit";

    public static final String NET_CARDS = "networkCards";
    public static final String NET_CARD = "networkCard";
	public static final String NET_CARD_LOWFEE= "lowFee";
	
	//System logon and logoff
	public static final String SYSTEM_LOGON_REQUEST = "SystemLogOnRequest";
	public static final String SYSTEM_LOGOFF_REQUEST = "SystemLogOffRequest";

    //vcarwashcfg and ucarwashcfg
    public static final String CARWASH_CONFIG   = "carWashConfig";
    public static final String IS_PROMPT_BEFORE = "isPromptBefore";
    public static final String IS_PROMPT_AFTER  = "isPromptAfter";
    public static final String IS_FORCE_BOTH_PROMPTS = "isForceBothPrompts";
    public static final String IS_ALWAYS_AUTHORIZE = "isAlwaysAuthorize";
    public static final String IS_FORCE_PREFUEL_VEND = "isForcePrefuelVend";
    public static final String AUTHORIZE_LIMIT = "authorizeLimit";
    public static final String USER_TIMEOUT = "userTimeout";
    public static final String SERVICE_NUMBER = "serviceNumber";
    public static final String PROMO_MESSAGE = "promoMessage";
    public static final String GRAPHIC = "graphic";
    public static final String NON_GRAPHIC = "nonGraphic";
    public static final String CONTROLLER_IP = "controllerIP";
    public static final String CLIENT_PORT = "clientPort";
    public static final String CLIENT_UDPPORT = "clientUDPPort";
    public static final String VENDING_ISLANDS = "vendingIslands";
    public static final String VENDING_ISLAND = "vendingIsland";
    public static final String VENDING_PLU = "vendingPLU";
    public static final String IS_MENU_PRSNTATN = "isMenuPresentation";
    public static final String DISPLAY_ORDER    = "displayOrder";
    public static final String UNSORTED         = "Unsorted";
    public static final String LEAST_TO_MOST    = "Least to Most Expensive";
    public static final String MOST_TO_LEAST    = "Most to Least Expensive";
    public static final String DAYS_VALID       = "daysValid";
    public static final String CARWASH_KEY      = "carWashKey";
    public static final String OUTDOOR_ENABLED  = "isOutdoorEnabled";

    public static final String CA_SITEINFO      = "cashAccSiteInfo";
    public static final String DISABLE_CHEATED  = "isDisableIfCheated";
    public static final String DISABLE_PAPR_LOW = "isDisableIfPaperLow";
    public static final String DISABLE_NO_PRNTR = "isDisableIfNoPrinter";
    public static final String INSERT_CSH_PRMPT = "isInsertCashPrompt";
    public static final String ENABLE_1_BILL    = "is1BillEnabled";
    public static final String ENABLE_2_BILL    = "is2BillEnabled";
    public static final String ENABLE_5_BILL    = "is5BillEnabled";
    public static final String ENABLE_10_BILL   = "is10BillEnabled";
    public static final String ENABLE_20_BILL   = "is20BillEnabled";
    public static final String ENABLE_50_BILL   = "is50BillEnabled";
    public static final String ENABLE_100_BILL  = "is100BillEnabled";
    public static final String BILL_ORIENTATION = "isBillOrientation";
    public static final String TIMEOUT          = "timeout";
    public static final String ATTRIBUTES       = "attributes";
    public static final String IN_DISPENSER     = "isInDispenser";
    public static final String RESET_PRNTR_ERR  = "isResetPrinterError";
    public static final String PRINT_TOTALS_NOW = "isPrintTotalsNow";
    public static final String MAX_CASH_ACCEPTORS    = "maxCashAcceptors";

    public static final String TLS_SITEINFO     = "tlsSiteInfo";
    public static final String UNIT_OF_MEASURE  = "unitOfMeasure";
    public static final String FUEL_UOM_G       = "USG";
    public static final String FUEL_UOM_L       = "LITERS";
    public static final String TANK_VARIANCE    = "tankVariance";
    public static final String LOW_LIMIT_ALARM  = "lowLimitAlarm";

    public static final String FEP_CONFIG		= "fepConfig";
    public static final String LOYALTY_CONFIG   = "loyaltyConfig";
    public static final String VENDING_CONFIG = "vendingConfig";
    public static final String MERCHANT_NUM     = "merchantNum";
    public static final String MASK_ACCOUNT     = "isMaskAcct";
    public static final String PROMPTING        = "prompting";
    public static final String REFUND_PROMPT    = "isRefundPrompt";
    public static final String INSIDE    = "INSIDE";
    public static final String OUTSIDE    = "OUTSIDE";
    public static final String BOTH    = "BOTH";
    public static final String NONE    = "NONE";
    public static final String MAN_ENTRY_PROMPT = "manualEntry";
    public static final String OVERRIDE_POP_DISC_PROMPT = "isOverridePOPDisc";
    public static final String ENABLE_PPG_DISC_PROMPT   = "isEnablePPGDisc";
    public static final String PROMPT_LOYALTY_FIRST   = "isPromptLoyaltyFirst";
    public static final String LOYALTY_CLOSE_PERIOD   = "LoyaltyClosePeriod";
    public static final String AUTH_TOTAL_KEY         = "isAuthOnTotalKey";
    public static final String LOYALTY_FUEL_LIMIT     = "LoyaltyFuelLimits";
    public static final String LOYALTY_FUEL_ONLY      = "isLoyaltyFuelOnly";
    public static final String LOYALTY_CONFIG_RECORDS = "loyaltyConfigRecords";
    public static final String LOYALTY_CONFIG_RECORD = "loyaltyConfigRecord";
    public static final String LOYALTY_SYSID = "loyaltySysID";
	public static final String LOYALTY_VIEW_ONLY = "viewOnly";
	public static final String LOYALTY_PROGRAM_ID = "programID";
	public static final String LOYALTY_PROGRAM_NAME = "name";

    //  vmenuConfig and umenuConfig
    public static final String MENU_CONFIG		= "menuConfig";
    public static final String RUBY_MENU		= "rubyMenu";
    public static final String EXPANDED_MENU	= "expandedMenu";
    public static final String MULTI_SELECT_MENU	= "multiSelectMenu";
    public static final String MENU_CHAIN		= "menuChain";
    public static final String MENU_ITEM		= "menuItem";
    public static final String MENU_CHAIN_ELEMENT = "menuChainElement";
    public static final String LOCATION 		= "location";
    public static final String SUB_MENU			= "subMenu";
    public static final String PARKED			= "parked";

    public static final String DEALER_NAME      = "dealerName";
    public static final String DEALER_ADDRESS   = "dealerAddress";
    public static final String DEALER_CITY      = "dealerCity";
    public static final String DEALER_STATE     = "dealerState";
    public static final String DEALER_ZIPCODE   = "dealerZipcode";
	public static final String DEALER_PHONE_NUM = "dealerPhoneNumber";
    public static final String BATCH_CLOSE_PRD  = "batchClosePeriod";
    public static final String DISP_MSG_PERSIST = "dispMsgPersist";
    public static final String FC_MERCH_AUTOFINISH_DELAY_ATTRIB = "autofinishdelay";
    public static final String CASHBACK_LIMIT = "cashbackLimit";
    

    // Fuel specific strings
    public static final String FUEL_DOMAIN_NS   = "fuel";
    public static final String PSC_FUEL_DOMAIN_NS   = "fuelcfg";
    public static final String FUEL_POSNS_STAT  = "fuelingPositionsStatus";
    public static final String FUEL_POSN_STAT   = "fuelingPositionStatus";
    public static final String CUR_STATE        = "currentState";
    public static final String DUE_SALES        = "dueSales";
    public static final String FUEL_TXN         = "fuelTransaction";
    public static final String IS_PRESET_PREPAY = "isPresetPrepay";
    public static final String IS_PRESET_POSTPAY = "isPresetPostpay";
    public static final String IS_DCR_TXN       = "isDCRTxn";
    public static final String IS_FAST_CREDIT   = "isFastCredit";
    public static final String IS_CA_TXN        = "isCashAcceptorTxn";
    public static final String IS_AUTOCOL       = "isAutoCollect";
    public static final String TXN_ATTRIBS      = "trAttributes";
    public static final String TXN_TIME         = "txnTime";
    public static final String PREPAY_RECEIPT   = "prepayReceiptNr";
    public static final String FP_DISPENSER_DATA = "fpDispenserData";
    public static final String PRODUCT_ID = "productID";
    public static final String PRODUCT_NUMBER   = "productNumber";
    public static final String FUEL_MONEY = "fuelMoney";
    public static final String FUELING_POSITION_ID = "fuelingPositionId";
    public static final String FUELING_POINT_STATUS = "fuelingPointStatus";

    public static final String AMOUNT           = "amount";
    public static final String PRICE            = "price";
    public static final String VOLUME           = "volume";
    public static final String PRODUCT          = "prod";
    public static final String GRADE            = "grade";
    public static final String ID               = "id";
    public static final String SERV_LEVEL       = "svcLevel";
    public static final String TIER             = "tier";
    public static final String HOSE             = "hose";
    public static final String URL              = "url";
    public static final String DATE_MODIFIED    = "dateModified";
    
    public static final String FUEL_SITE        = "fuelSite";
    public static final String FUEL_CONFIG      = "fuelConfig";
    public static final String FUEL_PRICES      = "fuelPrices";
    public static final String FUEL_SITE_PARAMS = "siteParams";
    public static final String IS_RT_CONFIG     = "isRtConfig";
    public static final String FUEL_UOM         = "fuelUOM";
    public static final String FUEL_INEFFECT_RCF         = "inEffectRapidChangeConfig";
    public static final String SIX_DIGITS_PROTOCOL  = "sixDigitsGilbarcoMode";
    public static final String REQUIRE_ATTENDANT_CARD  = "requireAttendantCard";
    public static final String IGNORE_CONFLICT  = "ignoreMOPConflict";
    public static final String HALT_MODE        = "haltMode";
    public static final String MAX_ACTIVE_PUMPS = "maxActivePumps";
    public static final String UNIT             = "unit";
    public static final String AUTO_DISAP_DELAY = "autoDisapprovalDelay";
    public static final String MINUTES          = "Minutes";
    public static final String START_POSTPAY_HR = "startPostpayHrs";
    public static final String NUM_POSTPAY_HRS  = "numPostpayHrs";
    public static final String START_MAN_APP_HR = "startManApprovalHrs";
    public static final String NUM_MAN_APP_HRS  = "numManApprovalHrs";
    public static final String TIER2_START_HR   = "tier2StartHr";
    public static final String TIER2_HRS        = "tier2Hrs";
    public static final String APPROVE_ALL      = "approveAllEnabled";
    public static final String FORCE_P9_PER_GAL = "forcePt9CentsPerGal";
    public static final String JRNL_CSHR_APP    ="jrnlCshrApproval";
    public static final String AUTO_COL_INSIDE  = "autoCollectInside";
    public static final String SALE_DATA_FREQ   = "saleDataFreq";
    public static final String CURRENT_TIER     = "currTier";
    public static final String PPU_DEC_POSITION = "ppuDecPosition";
    public static final String TOT_DEC_POSITION = "totalDecPosition";
    public static final String ADJ_ALT_POP      = "adjustForAlternatePop";
    public static final String POP_LOW_PRC_LVL  = "popLowestPriceLevel";
    public static final String ALL_PURE_PRODS   = "allProductsPure";
    public static final String MAX_SIZE         = "maxSize";
    public static final String FUEL_SLS         = "fuelSvcModes";
    public static final String FUEL_SL          = "fuelSvcMode";
    public static final String FUEL_SERV_LEVELS = "fuelServiceLevels";
    public static final String FUEL_SERV_LEVEL  = "fuelServiceLevel";
    public static final String FUEL_MOPS        = "fuelMOPs";
    public static final String FUEL_MOP         = "fuelMOP";
    public static final String FUEL_TANKS       = "fuelTanks";
    public static final String FUEL_TANK        = "fuelTank";
    public static final String FUEL_BLENDTYPES  = "fuelBlendTypes";
    public static final String FUEL_BLENDTYPE   = "fuelBlendType";
    public static final String FUEL_PRODUCTS    = "fuelProducts";
    public static final String FUEL_PRODUCT     = "fuelProduct";
    public static final String FUEL_PROD_NUM    = "number";
    public static final String FUEL_POSITIONS   = "fuelingPositions";
    public static final String FUEL_POSITION    = "fuelingPosition";
    public static final String FUEL_HOSES       = "fuelHoses";
    public static final String FUEL_HOSE        = "fuelHose";
    public static final String FUEL_TIER        = "fuelTier";
    public static final String CURR_SL          = "currentServiceLevel";
    public static final String DEFAULT_MOP      = "defaultMOP";
    public static final String BLEND_TYPE       = "blendType";
    public static final String SFO              = "slowFlowOffset";
    public static final String GRADE_RESTR      = "gradeRestriction";
    public static final String ENFRCE_GR_INSIDE = "enforcePromptingInside";
    public static final String PROMPT_RESTR_DCR = "promptRestrictionOutside";

    public static final String DEFAULT_LIMIT = "defaultLimit";
    public static final String VOLUME_LIMIT = "volumeLimit";
    public static final String MINIMUM_PPU = "minimumPPU";
    public static final String SPI_IP = "spiIP";

    public static final String ACCESS           = "access";
    public static final String PRESET_PREPAY    = "presetPrepay";
    public static final String PRESET_POSTPAY   = "presetPostpay";
    public static final String STACKING         = "stacking";
    public static final String FIFO             = "fifo";
    public static final String AUTO_APP         = "autoApproval";
    public static final String INSTANT_AUTO_APPROVAL = "instantAutoApproval";
    public static final String AUTO_DISAPP      = "autoDisapproval";
    public static final String AUTO_COLLECT     = "autoCollect";
    public static final String VIEW_BUZ_OFF     = "viewBuzzerOff";
    public static final String IGNORE_PUMP_ERR  = "ignorePumpErr";
    public static final String NO_AUTO_COL      = "none";
    public static final String ALL_AUTO_COL     = "all";
    public static final String CASH_AUTO_COL    = "cash";
    public static final String LOW_FEED         = "lowFeedTank";
    public static final String HIGH_FEED        = "highFeedTank";
    public static final String LOW_FEED_PCT     = "lowFeedPercent";
    public static final String TANKS     = "tanks";
    public static final String TANK     = "tank";
    public static final String TANK_PERCENT     = "tankPercent";
    public static final String MAX_BLEND_TANKS  = "maxBlendTanks";

    public static final String PRICES           = "prices";
    public static final String SERVICE_LEVEL    = "servLevel";
    public static final String MANIFOLD_TANK    = "manifold";
    public static final String START_HR         = "startHr";
    public static final String NUMBER_HRS       = "numHrs";
    public static final String NAXML_FUELGRADEID = "NAXMLFuelGradeID";

    public static final String NAXML_FUELPRODID = "NAXMLFuelProdID";
    public static final String FP_OFFLINE_NOTIFY = "FPOfflineNotify";

    public static final String NAX_FUELPRODS = "NAXMLFuelProducts";
    public static final String NAX_FUELPROD = "NAXMLFuelProduct";
    public static final String JLOG_ENTRY       = "JLogEntry";

    //Period list xml
    public static final String PERIOD_LIST = "periodList";
    public static final String PERIOD_INFO = "periodInfo";
    public static final String REPORT_PARAMS = "reportParameters";
    public static final String REPORT_PARAM = "reportParameter";
    public static final String DATA_FILENAME = "filename";
    public static final String DATA_PERIOD = "period";
    public static final String DATA_REGNUM = "regNum";
    public static final String DATA_CASHIERNUM = "cashierNum";

    //Credential doc
    public static final String CREDENTIAL       = "credential";
    public static final String COOKIE           = "cookie";
    public static final String FUNCTION_LIST    = "funcList";
    public static final String DAYS             = "days";
    public static final String REPORT_OPTS      = "ReportOpts";
    public static final String REPORT_OPT       = "ReportOpt";
    public static final String DISPLAY          = "display";
    public static final String ARG              = "arg";

    //Gempro Maintenance Interface
    public static final String GPMAINT          = "gpmaint";
    public static final String UMAINT           = "umaint";
    public static final String UMAINT_TOTALIZERS= "umainttotalizers";
    public static final String UMAINT_FPRHT     = "umaintfprht";
    public static final String UMAINT_REG_KEY   = "umaintregistrationkey";
    public static final String UMAINT_TELEPHONE = "umainttelephone";
    public static final String UMAINT_POSTAL    = "umaintpostal";
    public static final String UMAINT_START_DBG = "umaintstartdebugger";
    public static final String UMAINT_START_LDM = "umaintstartldm";
    public static final String UMAINT_RESET_MDM = "umaintresetmodem";
    public static final String UMAINT_CP_CPRINT = "umaintcopycprintf";
    public static final String MAINT            = "maintenance";
    public static final String MAINT_VER_DATA   = "maintVersionData";
    public static final String MAINT_VER_LINE   = "maintVersionLine";
    public static final String MAINT_IO_DATA    = "maintIOConifgData";
    public static final String MAINT_IO_LINE    = "maintIOConfigLine";
    public static final String MAINT_IO_DRIVER  = "maintIODriver";
    public static final String MAINT_IO_DEVICE  = "maintIODevice";
    public static final String MAINT_IO_BPS     = "maintIOBPS";
    public static final String MAINT_IO_PARITY  = "maintIOParity";
    public static final String MAINT_IO_BPC     = "maintIOBPC";
    public static final String MAINT_IO_STOP    = "maintIOStopBits";
    public static final String MAINT_IO_CONFIG  = "maintIOConfig";
    public static final String MAINT_TOTALIZER  = "maintTotalizers";
    public static final String MAINT_T_REGISTER = "maintTotRegister";
    public static final String MAINT_T_R_NUMBER = "maintTotRegNumber";
    public static final String MAINT_T_R_PERD   = "maintTotRegPeriod";
    public static final String MAINT_T_R_PNAME  = "maintTotRegPerName";
    public static final String MAINT_T_R_PGRAND = "maintTotRegPerGrand";
    public static final String MAINT_T_R_PSALES = "maintTotRegPerSales";
    public static final String MAINT_T_R_PAMNT  = "maintTotRegPerAmount";
    public static final String MAINT_FPRHT      = "maintFuelPointRunningHoseTotals";
    public static final String MAINT_FPRHT_FP   = "maintFPRHTFuelingPoint";
    public static final String MAINT_FPRHT_FPN  = "maintFPRHTFPNumber";
    public static final String MAINT_FPRHT_FPH  = "maintFPRHTFPHose";
    public static final String MAINT_FPRHT_FPHN = "maintFPRHTFPHNum";
    public static final String MAINT_FPRHT_FPHV = "maintFPRHTFPHVol";
    public static final String MAINT_FPRHT_FPHA = "maintFPRHTFPHAmt";
    public static final String MAINT_FILE       = "maintFileInfo";
    public static final String MAINT_FILE_LINE  = "maintFileInfoLine";
    public static final String GEMREG           = "gemreg";
    public static final String GEMREG_KEY       = "gemregkey";
    public static final String GEMREG_DATA      = "gemregdata";
    public static final String GEMREG_LINE      = "gemregline";
    public static final String MAINT_TELEPHONE  = "maintStoreTelephoneNumber";
    public static final String MAINT_POSTAL     = "maintStorePostalCode";
    public static final String MAINT_DEBUGGER   = "maintStartDebugger";
    public static final String MAINT_DB_PATHS   = "maintDebuggerPaths";
    public static final String MAINT_DB_PATH    = "maintDebuggerPath";
    public static final String MAINT_EXEC_LM    = "maintExecuteLoadModule";
    public static final String MAINT_RS_MODEM   = "maintResetModem";
    public static final String MAINT_CP_CPRINTF = "maintCopyCPrintfFile";
    public static final String MAINT_IP_STATS   = "maintIPStats";
    public static final String MAINT_IP_LINE    = "maintIPStatsLine";
    public static final String MAINT_INST_INFO  = "maintInstallInfo";
    public static final String MAINT_INST_LINE  = "maintInstallInfoLine";
    public static final String MAINT_CPRNT_LOG  = "maintCprintfLog";
    public static final String MAINT_CPRNT_LINE = "maintCprintfLogLine";

    // Report Configuration
    public static final String REPORTCFG_PF     = "rptcfg";
    public static final String RPTCFGPERIOD_AT	= "period";
    public static final String REPORTCFG       = "reportConfig";
    public static final String RPTCFGPERIOD     = "period";
    public static final String RPTCFGPERIODNAME = "periodName";
    public static final String RPTCFGPDNAME = "periodname";
    public static final String RPTCFGDELAYBC    = "delayBetweenCloses";
    public static final String RPTCFGUOTIMEBC   = "unitOfTimeBetweenCloses";
    public static final String PERSIST_RAW_TXNS = "persistRawTxns";
    public static final String PERSIST_REPTS    = "persistProcessedReports";
    public static final String RPTCFGFCCASHIER  = "forceCloseCashier";
    public static final String RPTCFGAUTOPRINT  = "autoPrintReport";
    public static final String RPTCFGSPANSHIFTS = "cashierTotalsSpanPeriodClose";
    public static final String RPTCFGFCPRINT	= "forceCashierToPrint";
    public static final String RPTCFGNOACTIVITY = "noActivity";
    public static final String RPTCFGRECLOSESEC = "recloseSecurity";
    public static final String RPTCFGFCPSECUR   = "forceClosePendingSecurity";
    public static final String RPTCFGALLOWPEND  = "allowSuspendedTransactions";
    public static final String RPTCFUNIT		= "unit";
    public static final String RPTCFGAEOD       = "aeod";
    public static final String RPTCFGAEODENABLED    = "aeodEnabled";
    public static final String RPTCFGAEODTIME   = "aeodTime";
    public static final String RPTCFGAEODFUELDISABLE    = "aeodDisableFuel"; 
    public static final String RPTCFGAEOD_IGNORENETWORKERROR    = "aeodIgnoreNetworkError";
    
    
    public static final String MANAGERWORKSTATION       = "managerworkstation";
    public static final String MWSENABLED       = "mwsEnabled";
    public static final String MWSAUTOAPPROVELIMIT       = "mwsAutoApprovalLimit";

    // Period Details and Constituent period details
    public static final String PERIOD_TYPE      = "periodType";
    public static final String PERIOD_SEQNUM    = "periodSeqNum";
    public static final String PERIOD_BEGINDATE = "periodBeginDate";
    public static final String PERIOD_ENDDATE   = "periodEndDate";
    public static final String CONSTITUENT_PERIODS = "constituentPeriods";
    public static final String IS_FIRST         = "isFirst";
    public static final String IS_LAST          = "isLast";
    public static final String TICKET_RANGE     = "ticketRange";

    //Event posting
    public static final String EVENT_MONITOR_TYPES = "eventMonitorTypes";
    public static final String EVENTTYPE = "eventType";
    public static final String EVENT = "event";
    public static final String ATTR_IS_SCHEDULED ="isScheduled";
    public static final String ATTR_IS_COOKIE_REQUIRED ="isCookieRequired";
    public static final String ATTR_IS_REPEAT_EVENT_SUPPORTED ="isRepeatEventSupported";
    public static final String EVENTFREQUENCYTYPE = "eventFrequencyType";
    public static final String FREQUENCY = "frequency";
    public static final String ATTR_TIME_UNIT = "timeUnit";
    
    public static final String EVENT_NS_PREFIX = "ev";
    public static final String EVENT_DESC = "description";
    public static final String APPSTART_EVENT = "appStartEvent";
    public static final String APP_NAME = "appName";
    public static final String PDCLOSE_EVENT = "periodCloseEvent";
    public static final String PREV_FILENAME = "previousFilename";
    public static final String CLOSE_INITIATOR = "closeInitiator";
    public static final String FUELINIT_EVENT = "fuelInitEvent";
    public static final String FUNDS_AUDIT_EVENT = "csrAuditEvent";
    public static final String FUNDS_AUDIT_REGISTER = "auditedRegID";
    public static final String EVENT_ERROR = "fault";
    public static String COOKIE_ATTR = "cookie";
    public static String DUPLICATE_ATTR = "duplicate";
    public static final String MWSMGRACCEPT_EVENT = "mwsmgracceptevent";
    public static final String OTP_GENERATED_EVENT = "otpGeneratedEvent";
    public static final String OTP = "otp";
    
    public static final String PERIPHERAL_STATUS_EVENT = "peripheralStatusEvent";
    public static final String PERIPHERAL_ELEMENT = "peripheral";
    public static final String ATTR_DEVICE_TYPE = "deviceType";
    public static final String ATTR_DEVICE_STATUS = "deviceStatus";
    
    //Diagnostics
    public static final String DIAG_NS_PREFIX = "diag";
    public static final String FUELING_POINT = "fuelingPoint";
    public static final String DIAGNOSTICS = "diagnostics";
    public static final String FORECOURT_DIAGNOSTICS = "forecourtDiagnostics";
    public static final String POS_DIAGNOSTICS = "posDiagnostics";
    public static final String PAYMENT_DIAGNOSTICS = "paymentDiagnostics";
    public static final String MOBILE_DIAG = "mobileDetail";
    public static final String APP_START_TIME = "appStartTime";
    public static final String STATUS_UPDATE_TIME = "statusUpdateTime";
    public static final String IS_AVAILABLE = "isAvailable";
    public static final String DURATION = "duration";
    public static final String OFFLINE_DURATION = "offlineDuration";
    public static final String MIN = "min";
    public static final String HOUR = "hour";
    public static final String SEC = "sec";
    public static final String AGO = "ago";
    public static final String SPACE_CHAR = " ";
    public static final String FUEL = "Fuel";
    public static final String HOURS = "hours";
    public static final String MINS = "mins";
    public static final String SECONDS = "seconds";
    
    //Money Order Report
    public static final String TRLMO             = "trlMO";
    public static final String TRLMO_NOT_PRINTED = "trlMONotPrinted";
    public static final String MO_REPORT         = "moneyOrderPd";
    public static final String TR_MISC_REFNUM    = "trMiscRefNum";
    public static final String POS_NUM           = "posNum";
    public static final String TRL_MOPAYEE       = "trlMOPayee";
    public static final String TRL_MO_SERIALNUM  = "trlMOSerialNum";
    public static final String TRL_MO_VENDPMT    = "trlMOVendorPmt";
    public static final String TRL_UNIT_PRICE    = "trlUnitPrice";
    public static final String VEND_PMT_EVENT    = "vendorPmtEvent";
    public static final String MONEYORDER_EVENT  = "moneyOrderEvent";
    public static final String MONEYORDER_REFUNDS = "moneyOrderRefunds";
    public static final String OFFLINE           = "offline";
    public static final String PRINTED           = "printed";
    public static final String PAYEE_ID          = "payeeID";
    public static final String PERIOD_ID         = "periodID";
    public static final String LONG_ID           = "longId";
    public static final String SHORT_ID          = "shortId";
    public static final String SERIAL_NUM        = "serialNum";
    public static final String PAYOUT   = "payout";
    public static final String TRANS_SET        = "transactionSet";
    public static final String TRANS_STRING     = "trans";
    public static final String OPEN_TIME        = "openedTime";
    public static final String CLOSE_TIME       = "closedTime";
    public static final String TR_HEADER        = "trHeader";
    public static final String TR_LINES        = "trLines";
    public static final String TR_LINE        = "trLine";
    //PLU report
    //Overridden by PLUPromoReportXMLVisitor
    public static final String PLU_REPORT = "pluPd";

    public static final String TOTALS = "totals";
    public static final String PLU_INFO = "pluInfo";
    //   public static final String BY_REGISTER = "byRegister";
    public static final String BY_CASHIER = "byCashier";
    //   public static final String REGISTER = "register";
    public static final String CASHIER = "cashier";
    public static final String NET_SALES = "netSales";
    public static final String ITEM_COUNT = "itemCount";
    public static final String PCT_SALES = "percentOfSales";
    public static final String TOTAL = "total";
    public static final String DEPT_BASE = "deptBase";
    public static final String DEPT_TYPE = "deptType";
    public static final String DEPT_ISNEG = "isNegative";
    public static final String ORIGINAL_PRICE = "originalPrice";
    public static final String PLU_BASE = "pluBase";
    public static final String REASON_CODE = "reasonCode";

    //PLU promo report
    public static final String PLUPROMO_REPORT = "pluPromoPd";

    //Pop report
    public static final String POPDISC_REPORT = "popDiscPd";
    public static final String GRADE_INFO = "gradeInfo";
    public static final String FUEL_PROD_BASE = "fuelProdBase";
    public static final String POP_INFO= "popInfo";
    public static final String DISC_TYPE= "discType";
    public static final String BY_DISC_TYPE= "byDiscType";
    public static final String DISC_INFO= "discInfo";
    public static final String PRE_DISP = "PRE-DISP";
    public static final String POST_DISP = "POST-DISP";
    public static final String ALL_DISCOUNT = "ALL";
    public static final String POP_DISC_PRGM_TOTAL = "popDiscPrgmTotal";
    public static final String POP_DISC_PRGM_TOTALS = "popDiscPrgmTotals";
    public static final String POPDISCPRG_REPORT = "popDiscPrgmPd";

    //Pop Definition
    public static final String POPDEF_REPORT = "popDefPd";
    public static final String POPDEFINITION_INFO = "definitionInfo";
    public static final String POPDEF_INFO = "popDefInfo";
    public static final String POPDEF_BASE = "definitionBase";
    public static final String POPDISC_DEF = "discDefinition";

    //Fuel reports
    public static final String FUEL_PRICE_LEVEL = "fuelPriceLevel";
    public static final String PRICE_LVL_INFO = "priceLvlInfo";
    public static final String FUEL_INFO = "fuelInfo";
    public static final String PROD_SUBTOTAL = "subtotal";
    public static final String COUNT = "count";

    //Dept report
    public static final String DEPT_REPORT = "departmentPd";
    public static final String BY_REGISTER = "byRegister";
    public static final String DEPT_INFO = "deptInfo";
    public static final String GROSS_SALES = "grossSales";
    public static final String REFUNDS = "refunds";
    public static final String DISCOUNTS = "discounts";
    public static final String PROMOTIONS = "promotions";
    public static final String MANUAL_DISC = "manualDiscounts";
    public static final String NEG_DEPTS = "negative";
    public static final String OTHER_DEPTS = "other";

    //DashBoard Info
    public static final String DASHBOARD_NS = "urn:vfi-sapphire:dashboard.2013-03-21";
    public static final String CONFIG = "config";
    public static final String DASHBOARD_INFO = "dashBoardInfo";
    public static final String SUMMARY_TOTALS = "summaryTotals";
    public static final String UOM_USGALLON = "USG";
    public static final String DEPARTMENT_TRACKING = "departmentTracking";
    public static final String PLU_TOPSELLERS = "pluTopSellers";
    public static final String PROMOTION_TOTALS = "promotionTotals";
    public static final String HOURLY_TOTALS = "hourlyTotals";
    public static final String FUEL_TOTALS = "fuelTotals";
    public static final String LOYALTY_TOTALS = "loyaltyTotals";
    public static final String TANK_MONITOR_DATA = "tankMonitorData";


    //Tank mon report
    public static final String TANKMON_REPORT = "tankMonitorPd";
    public static final String INVENTORY_INFO = "inventoryInfo";
    public static final String LEAK_INFO = "leakInfo";
    public static final String ALARM_HISTORY = "alarmHistory";
    public static final String EXTERNAL_ALARMS = "externalAlarms";
    public static final String INTERNAL_TANK_ALARMS = "internalTankAlarms";
    public static final String INTERNAL_ALARM = "internalAlarm";
    public static final String ALARM_TYPE_DESCRIPTION = "alarmTypeDescription";
    public static final String ALARM_DATE = "alarmDate";
    public static final String DELIVERY_INFO = "deliveryInfo";
    public static final String DELIVERY_RECORDS = "deliveryRecords";
    public static final String INVENTORY_DATE = "inventoryDate";
    public static final String FUEL_LVL = "fuelLvl";
    public static final String FUEL_LVL_INCHES = "in";
    public static final String FUEL_VOLUME = "fuelVolume";
    public static final String FUEL_TEMPERATURE = "fuelTemperature";
    public static final String FUEL_TEMPERATURE_FAHRENHEIT = "F";
    public static final String ULLAGE = "ullage";
    public static final String WATER_LVL = "waterLvl";
    public static final String WATER_LVL_INCHES = "INCHES";
    public static final String LEAK_DATE = "leakDate";
    public static final String TEMP_CHANGE = "tempChange";
    public static final String HOURLY_CHANGE = "hourlyChange";
    public static final String HOUR_NUM = "hourNum";
    public static final String LEAK_CHANGE = "leakChange";
    public static final String START_VOLUME = "startVolume";
    public static final String END_VOLUME = "endVolume";
    public static final String START_TEMPERATURE = "startTemperature";
    public static final String END_TEMPERATURE = "endTemperature";
    public static final String TANKMON_UOM = "uom";
    public static final String LITERS = "LITERS";
    public static final String CELSIUS = "CENTIGRADE";
    public static final String MILLIMETERS = "MM";
    public static final String EXT_INPUT_STATUS = "extInputStatus";
    public static final String EXT_INPUT_CLOSED = "extInputClosed";
    public static final String EXT_INPUT_OPEN = "extInputOpen";
    public static final String INT_TANK_ALARM_STATUS = "intTankAlarmStatus";
    public static final String INT_TANK_AUTO_TRANS_FLAGS = "intTankAutoTransFlags";
    public static final String INT_TANK_FLAGS = "intTankFlags";
    public static final String TANK_MONITOR_TYPE = "tankMonitorType";
    public static final String ALARM_STATUS = "alarmStatus";
    public static final String AUTO_TRANS_FLAG = "autoTransFlag";
	public static final String TANK_REC_TOTALS = "tankRecTotals";

    //Carwash report
    public static final String CARWASH_REPORT = "carWashPd";
    public static final String COIN_REVENUE = "coinRevenue";
    public static final String TOKEN_REVENUE = "tokenRevenue";
    public static final String WASHES_USED = "washesUsed";
    public static final String TYPE = "type";
    public static final String MOP_INFO = "mopInfo";
    public static final String PAID_TICKETS = "paidTickets";
    public static final String FREE_TICKETS = "freeTickets";
    public static final String FLEET_TICKETS = "fleetTickets";
    public static final String CAR_WASH_KEY_INFO = "carWashKeyInfo";
    public static final String CASH = "cash";
    public static final String CREDIT = "credit";
    public static final String IS_CARD_MOP = "isCardBased";

    //Category report
    public static final String CATEG_REPORT = "categoryPd";
    public static final String CATEG_BASE = "categoryBase";
    public static final String CATEG_INFO = "categoryInfo";

    //Tax report
    public static final String TAX_REPORT = "taxPd";
    public static final String TAX_INFO = "taxInfo";
    public static final String TAXRATE_BASE = "taxrateBase";
    public static final String ACTUAL_TAXRATE= "actualTaxRate";
    public static final String TAXABLE_SALES = "taxableSales";
    public static final String NONTAXABLE_SALES = "nonTaxableSales";
    public static final String SALES_TAX = "salesTax";
    public static final String REFUND_TAX = "refundTax";
    public static final String NET_TAX = "netTax";
    public static final String TAXABLE_REFUNDS = "taxableRefunds";
    public static final String TAX_EXEMPT_SALES ="taxExemptSales";
    public static final String TAX_EXEMPT_REFUNDS = "taxExemptRefunds";
    public static final String TAX_FORGIVEN_SALES ="taxForgivenSales";
    public static final String TAX_FORGIVEN_REFUNDS = "taxForgivenRefunds";

    //Deal report
    public static final String DEAL_REPORT = "dealPd";
    public static final String DEAL_INFO = "dealInfo";
    public static final String DEAL_BASE= "dealBase";
    public static final String MATCH_BASE = "matchbase";
    public static final String DEAL_COMBO_BASE = "comboBase";
    public static final String DEAL_MATCH_BASE = "matchBase";
    		

    //Money order device report
    public static final String MO_DEVICE_REPORT = "moDevicePd";
    public static final String MO_SALES = "moneyOrderSales";
    public static final String VEND_PMTS = "vendorPayments";

    //Network report
    public static final String NETWORK_REPORT = "networkPd";
    public static final String BY_BATCH = "byBatch";
    public static final String BATCH    = "batch";
    public static final String CARD_INFO = "cardInfo";
    public static final String CARD_NUMBER = "cardNumber";
    public static final String CARD_NAME= "cardName";
    public static final String CARD_CHARGES= "cardCharges";
    public static final String CARD_CORRECTIONS = "cardCorrections";
    
    //ASA Mobile payment report
    public static final String ASA_MOBILE_PAYMENT_REPORT = "aboveSitePd";
    static final String IS_ABOVE_SITE = "isAboveSite";
    static final String DEFAULT_CARD_TYPE = "OTHR";

    //N/W Prod report
    public static final String NETPROD_REPORT = "netProdPd";
    public static final String NETPROD_INFO = "netProdInfo";
    public static final String NETW_CODE = "netwCode";
    public static final String PRIMARY_NET_TYPE = "PRIMARY";
    public static final String SECONDARY_NET_TYPE = "SECONDARY";
    public static final String PRODUCT_PRICE = "productPrice";
    public static final String NETWORKTYPE = "networkType";
    public static final String NET_PROD_RECORD = "networkProductRecord";
	public static final String IS_PROPRIETARY = "isProprietary";
	public static final String NET_PROD_TOTALS = "networkProductTotals";
	public static final String PRIMARY_NET_TYPE_VALUE = "0";
	public static final String SECONDARY_NET_TYPE_VALUE = "1";
	public static final String NO_NET_TYPE_VALUE = "2";

    //Autocol report
    public static final String AUTOCOL_REPORT = "autoCollectPd";

    //Hourly report
    public static final String HOURLY_REPORT = "hourlyPd";
    public static final String HOURLY_INFO = "hourlyInfo";
    public static final String HRLY_HOUR_NUM = "hour";
    public static final String HRLY_ITEM_CNT= "itemCnt";
    public static final String MERCH_ONLY= "merchOnly";
    public static final String MERCH_FUEL = "merchFuel";
    public static final String FUEL_ONLY = "fuelOnly";

    //DCR stat report
    public static final String DCRSTAT_REPPORT = "dcrstPd";
    public static final String DCR_NUM = "dcrNum";
    public static final String DCR_SALE = "dcrSale";
    public static final String DCR_STAT= "dcrStat";
    public static final String THIS_FP_PCT = "thisFpPct";
    public static final String ALL_DCR_PCT = "allDcrPct";
    public static final String ALL_FP_PCT= "allFpPct";

    //Tank report
    public static final String TANK_REPORT = "tankPd";
    public static final String TANK_TOTAL = "tankTotal";

    //Cash Acc report
    public static final String CASHACC_REPORT = "cashAccPd";
    public static final String CASH_ACC_INFO = "cashAccInfo";
    public static final String CASH_ACC_TOTAL = "cashAccTotal";
    public static final String CASH_ACC_COUNT = "count";
    public static final String FP_NUM = "fpNum";
    public static final String SALE_AMOUNT = "saleAmount";
    public static final String AMOUNT_TAKEN = "amountTaken";

    //Tank rec report
    public static final String TANKREC_REPORT = "tankRecPd";
    public static final String BEGIN_INVENTORIES = "beginInventories";
    public static final String END_INVENTORIES = "endInventories";
    public static final String TOTAL_BEGIN_INVENTORY = "totalBeginInventory";
    public static final String TOTAL_END_INVENTORY = "totalEndInventory";
    public static final String TOTAL_FUEL_DELIVERED = "totalFuelDelivered";
    public static final String INVENTORY_VOLUME = "inventoryVolume";
    public static final String DELIVERY_DATE = "deliveryDate";
    public static final String DELIVERY_VOLUME = "deliveryVolume";
    public static final String DISPENSE_RECORDS = "dispenseRecords";
    public static final String DISPENSED_VOLUME = "dispensedVolume";
    public static final String TOTAL_FUEL_DISPENSED = "totalFuelDispensed";
    public static final String DISCREPANCY = "discrepancy";

    //FP Hose Running report
    public static final String FPHOSE_RUN_REPORT = "fpHoseRunningPd";
    public static final String FPHOSERUNNING_BACKUP_ROOTELEMENT = "fpHoseRunningTotals";

    //FP hose (test) report
    public static final String FPHOSE_TEST_REPORT = "fptHosePd";
    public static final String BY_FUELING_POSITION = "byFuelingPosition";
    public static final String BY_FUEL_PRODUCT = "byFuelProduct";
    public static final String FPHOSE_ISPUMPTEST = "isPumpTest";
    public static final String FPHOSE_NUMBER = "hoseNumber";

    //FP Hose report
    public static final String FPHOSE_REPORT = "fpHosePd";
    public static final String FPHOSE_BACKUP_ROOTELEMENT = "fpHoseTotals";
    public static final String FPHOSE_BACKUP_RECORD = "fpHoseRecord";

    //FP Dispenser Report
    public static final String FPDISPENSER_REPORT = "fpDispenserPd";
    public static final String FPDISPENSER_BACKUP_ROOTELEMENT = "fpDispenserTotals";
    public static final String FPSTATUS = "fpStatus";

    //Tire Prod report
    public static final String TIER_PROD_REPORT = "tierProductPd";
    public static final String FUEL_TIER_BASE = "fuelTierBase";

    //Dispenser report
    public static final String FP_EXCEPTION="fpException";
    public static final String FP_NOTSUPPORTED="NOTSUPPORTED";
    public static final String FP_OFFLINE="OFFLINE";
    public static final String FP_UNINITIALIZED="UNIINITIALIZED";

    //Prop card report
    public static final String PROP_CARD_REPORT = "propCardPd";

    //Prop prod report
    public static final String PROP_PROD_REPORT = "propProdPd";

    //All Product Report (Includes both Network and Non-network sales)
    public static final String ALL_PROD_REPORT = "allProdPd";

    //SL/PL report
    public static final String SL_PRICELVL_REPORT = "slPriceLvlPd";
    public static final String SL_PRICELVL_INFO = "slPriceLvlInfo";
    public static final String PR_PRICELVL_REPORT = "prPriceLvlInfo";
    public static final String FUEL_SVC_LEVEL_BASE = "fuelSvcLevelBase";


    //PR/PL report
    public static final String PROD_PRICELVL_REPORT = "prPriceLvlPd";

    //Summary report
    public static final String SUMMARY_REPORT = "summaryPd";
    public static final String AVG = "avg";
    public static final String BEGIN = "begin";
    public static final String CANCEL_REFUND = "cancelRefund";
    public static final String CASH_BACK = "cashBack";
    public static final String CASH_BACK_CANCEL = "cashBackCancel";
    public static final String SUMMARY_CASH_BACK_FEE = "cashBackFee";
    public static final String SUMMARY_DEBIT_FEE = "debitFee";
    public static final String DEBIT_FEE_CANCELED = "debitFeeCanceled";
    public static final String CASH_BACK_FEE_CANCELED = "cashBackFeeCanceled";
    public static final String CHANGE_CHECK = "changeCheck";
    public static final String COIN_DISPENSER = "coinDispenser";
    public static final String CUSTOMER_COUNT = "customerCount";
    public static final String DIFFERENCE = "difference";
    public static final String DRAWER_VIOLATIONS = "drawerViolations";
    public static final String END = "end";
    public static final String END_OF_TRANS_TIME = "endOfTransTime";
    public static final String ERROR_CORRECT = "errorCorrect";
    public static final String FUEL_SALES = "fuelSales";
    public static final String FUEL_DISCOUNTS = "fuelDiscounts";
    public static final String IN_HOUSE = "inHouse";
    public static final String IN_HOUSE_PAY_IN = "inHousePayIn";
    public static final String IN_HOUSE_PAY_OUT = "inHousePayOut";
    public static final String HOUSE_ACCOUNT = "houseAccount";
    public static final String ACCOUNT_NUMBER = "accountNumber";
    public static final String SUB_ACCOUNT = "subAccount";
    public static final String IN_HOUSE_MOP_ACCT = "inHouseMOP";
    public static final String PAY_IN_ACCT = "payIN";
    public static final String PAY_OUT_ACCT = "payOUT";
   

    public static final String HOUSE_ACCT_CONFIG = "houseAcctConfig";
    public static final String INSIDE_GRAND = "insideGrand";
    public static final String ATTD_INSIDE_GRAND = "attendantInsideGrand";
    public static final String INSIDE_SALES = "insideSales";
    public static final String ATTD_INSIDE_SALES = "attendantInsideSales";
    public static final String LOGIN_OVERRIDES = "loginOverrides";
    public static final String MAX = "max";
    public static final String MERCH_SALES = "merchSales";
    public static final String MOP_TOTALS = "mopTotals";
    public static final String NEG_VOID_TICKET = "negative";
    public static final String NETWORK_SUSPENDED_TRANS_TIME =
        "networkSuspendedTransTime";
    public static final String NETWORK_TRANS_TIME = "networkTransTime";
    public static final String NO_SALE_COUNT = "noSaleCount";
    public static final String OUTSIDE_GRAND = "outsideGrand";
    public static final String ATTD_OUTSIDE_GRAND = "attendantOutsideGrand";
    public static final String OUTSIDE_SALES = "outsideSales";
    public static final String ATTD_OUTSIDE_SALES = "attendantOutsideSales";
    public static final String OVERALL_GRAND = "overallGrand";
    public static final String OVERALL_SALES = "overallSales";
    public static final String PAY_IN = "payIn";
    public static final String PAY_OUT = "payOut";
    public static final String POP_CODES_EARNED = "popCodesEarned";
    public static final String POP_CODES_REDEEMED = "popCodesRedeemed";
    public static final String POP_COUPONS_EARNED = "popCouponsEarned";
    public static final String POP_CODES_FREE = "popCodesFree";
    public static final String POP_COUPONS_FREE = "popCouponsFree";
    public static final String POP_MEMBER_IDS = "popMemberIDs";
    public static final String POP_PREDISPENSED = "popPredispensed";
    public static final String POP_POSTDISPENSED = "popPostdispensed";
    public static final String POS_VOID_TICKET = "positive";
    public static final String RESERVE_APPROVE = "reserveApprove";
    public static final String RESERVE_STOP = "reserveStop";
    public static final String SAFE_DROP = "safeDrop";
    public static final String SAFE_DROP_CANCEL = "safeDropCancel";
    public static final String SAFE_LOAN = "safeLoan";
    public static final String SALE = "sale";
    public static final String START = "start";
    public static final String SUMMARY_INFO = "summaryInfo";
    public static final String SUSPEND_SETTLED = "suspendSettled";
    public static final String SUSPEND_TOTAL = "suspendTotal";
    public static final String SUSPEND_UNSETTLED = "suspendUnsettled";
    public static final String SUSPEND_VOID = "suspendVoid";
    public static final String TAKEN_OVER = "takenOver";
    public static final String TOTAL_PAYMENT_OUT = "totalPaymentOut";
    public static final String TOTAL_PAYMENT_IN = "totalPaymentIn";
    public static final String TOTAL_TO_ACCOUNT_FOR = "totalToAccountFor";
    public static final String TOTAL_REFUND_TAXES = "totalRefundTaxes";
    public static final String TOTAL_SALES_TAXES = "totalSalesTaxes";
    public static final String TOTAL_TAXES = "totalTaxes";
    public static final String TOTAL_INCLUDED_TAXES = "totalIncludedTaxes";
    public static final String TOTAL_DISCOUNTS = "totalDiscounts";
    public static final String TOTALIZERS = "totalizers";
    public static final String TRANS_TIME_INFO = "transTimeInfo";
    public static final String VENDOR_PAYMENTS = "vendorPayments";
    public static final String VOID_LINE = "voidLine";
    public static final String VOID_TICKET = "voidTicket";
    public static final String AUTO_SETTLED_OVERRUN = "autoSettledFuelOverrun";
    public static final String AUTO_DROPPED_OVERRUN = "autoDroppedFuelOverrun";
    public static final String MANUAL_SETTELED_OVERRUN = "manuallySettledFuelOverrun";
    public static final String PREPAID_ACTIVATION = "prepaidActivation";
    public static final String PREPAID_RECHARGE = "prepaidRecharge";
    public static final String FUEL_CONVERSION = "fuelConversion";
	public static final String TICKET_LVL_COUPONS = "ticketLvlCoupons";
	public static final String EZ_RECEIPT="ezReceipt";
	public static final String EZ_RECEIPT_INSIDE="inside";
	public static final String EZ_RECEIPT_OUTSIDE="outside";
    //cashier report
    public static final String CASHIER_SPECIFIC_INFO = "cashierSpecificInfo";
    public static final String BEGIN_TICKET = "beginTicket";
    public static final String END_TICKET = "endTicket";
    public static final String BEGIN_TICKET_OUTDOOR = "beginTicketOutdoor";
    public static final String END_TICKET_OUTDOOR = "endTicketOutdoor";
    
    public static final String TOT_TICKET = "totTicket";
    public static final String ACT_TICKET = "actTicket";
    public static final String CURRENCY_AMOUNTS = "currencyAmounts";
    public static final String EXCHANGE_RATE = "exchangeRate";
    public static final String MOP_AMOUNTS = "mopAmounts";
    public static final String BEGIN_DRAWER_AMOUNT = "beginDrawerAmount";
    public static final String SALE_COUNT = "saleCount";
    public static final String ECR_AMOUNT = "ecrAmount";
    public static final String CONV_ECR_AMOUNT = "convEcrAmount";
    public static final String MOP_PAID = "mopPaid";
    public static final String IMBAL_AMOUNT = "imbalAmount";
    public static final String CANCEL_REFUND_COUNT = "cancelRefundCount";
    public static final String CANCEL_REFUND_AMOUNT = "cancelRefundAmount";
    public static final String SAFE_DROP_COUNT = "safeDropCount";
    public static final String SAFE_DROP_AMOUNT = "safeDropAmount";
    public static final String CASH_BACK_COUNT= "cashBackCount";
    public static final String CASH_BACK_AMOUNT= "cashBackAmount";
    public static final String CASH_BACK_CANCEL_COUNT= "cashBackCancelCount";
    public static final String CASH_BACK_CANCEL_AMOUNT= "cashBackCancelAmount";

    //code added by tattu  for safe drop correction Testing.......
    public static final String SAFE_DROP_CORRECTION = "safeDropCorrection";
    public static final String TR_SDINF ="originalSafeDropInfo";
    public static final String TR_PAYC = "trpPaycode";
    public static final String TR_CURR = "trCurrTot";
    public static final String TR_SEQ  = "trSeq";
    public static final String TR_JTEXT = "trjText";
    public static final String TR_SDCTP ="safedropcorrection";
    public static final String TR_SDTP = "safedrop";
    public static final String TR_PAMT = "trpAmt";
    public static final String SAFEDROPEVENT_STRING = "SAFE DROP EVENT";
    //Loyalty report
	public static final String BY_PROGRAM = "byProgram";
    public static final String LOYALTY_REPORT =    "loyaltyPd";
    public static final String INSIDE_STR =        "inside";
    public static final String OUTSIDE_STR =       "outside";
    public static final String PPG_DISCOUNT_STR =      "ppgDiscount";
    public static final String TICKET_DISCOUNT_STR =   "ticketDiscount";
    public static final String SALES_STR =         "sales";
    public static final String LOYALTY_STR =       "loyalty";
    public static final String PERCENT_STR1 =      "percent";
    public static final String LOYALTY_TRANS =     "loyaltyTransactions";
    public static final String LOYALTY_SALES =     "loyaltySales";
    public static final String NON_LOYALTY_SALES = "nonLoyaltySales";
    public static final String LINE_DISCOUNT_STR = "lineItemDiscount";
    public static final String LINE_TAX_CREDIT 	 = "lintItemTaxCredit";

    //Sales config strings
    public static final String PERCENT_STR = "P";
    public static final String AMOUNT_STR = "A";
    
    //Sales config receipt print program name type strings
    public static final String YES_STR = "Y";
    public static final String NO_STR = "N";
    public static final String DETAILED_STR = "D";
    /* Sales config item codes.
     * Note: Since these codes should go away when we define a new schema,
     * no effort has been taken to make the codes more readable
     */
    public static final String PNF = "PNF";
    public static final String MAQ = "MAQ";
    public static final String MAA = "MAA";
    public static final String MIA = "MIA";
    public static final String MAD = "MAD";
    public static final String MID = "MID";
    public static final String RFD = "RFD";
    public static final String DTP = "DTP";
    public static final String DFX = "DFX";
    public static final String DFR = "DFR";
    public static final String RFS = "RFS";
    public static final String VLS = "VLS";
    public static final String VTS = "VTS";
    public static final String NSS = "NSS";
    public static final String VPS = "VPS";
    public static final String TSD = "TSD";
    public static final String CSR = "CSR";
    public static final String SBT = "SBT";
    public static final String TDB = "TDB";
    public static final String JRN = "JRN";
    public static final String VLP = "VLP";
    public static final String VTP = "VTP";
    public static final String NSP = "NSP";
    public static final String RFP = "RFP";
    public static final String EJR = "EJR";
    public static final String DDS = "DDS";
    public static final String DOP = "DOP";
    public static final String DRH = "DRH";
    public static final String DRC = "DRC";
    public static final String DTO = "DTO";
    public static final String GST = "GST";
    public static final String VAT = "VAT";
    public static final String STB = "STB";
    public static final String FCR = "FCR";
    public static final String EAR = "EAR";
    public static final String CAR = "CAR";
    public static final String ASO = "ASO";
    public static final String CDA = "CDA";
    public static final String MOL = "MOL";
    public static final String RTD = "RTD";
    public static final String OCD = "OCD";
    public static final String FDC = "FDC";
    public static final String EMT = "EMT";
    public static final String RTT = "RTT";
    public static final String PMC = "PMC";
    public static final String DAT = "DAT";
    public static final String PPA = "PPA";
    public static final String PPR = "PPR";
    public static final String DSL = "DSL";
    public static final String POS = "POS";
    public static final String RTC = "RTC";
	public static final String FDS = "FDS";
    public static final String ECS = "ECS";
	  //code added by tattu 14 may 2007 for imprinter
    public static final String IMP="IMP";
	//code added by tattu for safe drop correction
	public static final String SDC="SDC";

	//CR6668 Open Cash Drawer on cashier close
	public static final String OCC = "OCC";
	//CR6876.01 Enable taxable rebate
	public static final String ETR = "ETR";
	//code added to add property Maximum Till Transaction Amount in sales config
	public static final String MTTA="MTA";
	//code added  for Ready link Recharge
	public static final String RLL = "RLL";
    public static final String DPN = "DPN";  // Display PLU Not Found Department List
    public static final String LPN = "LPN";	// Prompt Loyalty for PLU not found
	//DOB masking changes CR6477
	public static final String PDR = "PDR";  //Print DOB On Receipt
	public static final String PDJ = "PDJ";  //Print DOB on Journal
	public static final String RPN = "RPN";  //Receipt print program name type
    /*
     * Fuel tax exemption configuration strings
     */
    public static final String FUELTAXEXCONF = "fuelTaxExemptConfig";
    public static final String FUELTAXEXS = "fuelTaxExemptions";
    public static final String FUELTAXEX = "fuelTaxExemption";
    public static final String FUELTAXEXNAME = "name";
    public static final String FUELTAXEXADJAMT = "adjAmt";
    public static final String FUELTAXEXADJTYPE = "adjType";
    public static final String FUELTAXEXSIGN = "signatureLine";
    public static final String FUELTAXEXCURRENCY = "currency";
    public static final String FUELTAXEXTAXNR = "taxnr";
    public static final String FUELTAXEXRCPT = "fuelTaxReceipt";
    public static final String FUELTAXEXRCPTLINE = "line";
    public static final String FUELTAXEXRCPTID = "id";
    //refinteg Network section
    public static final String CARD_TYPES = "cardTypes";
    public static final String CARD_TYPE_ENTRY  = "cardType";
    public static final String ACCT_VALIDN_TYPES = "acctValidationTypes";
    public static final String ACCT_VALIDN_TYPE  = "acctValidation";
    public static final String ACCT_VALIDN_DESC = "description";

	// Payroll report strings
	public static final String PAYROLLRPTNS = "payroll";
	public static final String PAYROLL_CAPS = "PAYROLL";
	public static final String PAYROLLRPTLIST = "payrollReportList";
	public static final String PAYROLLRPT = "payrollReport";
	public static final String PAYROLLRPTPERIODS = "payrollPeriods";
	public static final String PAYROLLRPTCLOSEDDATE = "closedDate";
	public static final String PAYROLLRPTEMPLOYEEREC = "employeeRecord";
	public static final String PAYROLLRPTCLOCKENTS = "clockEntries";
	public static final String PAYROLLRPTCLOCKENT = "clockEntry";
	public static final String PAYROLLRPTEMPLOYEEID = "employeeID";
	public static final String PAYROLLRPTCLOCKIN = "clockIn";
	public static final String PAYROLLRPTCLOCKOUT = "clockOut";
	public static final String PAYROLLRPTTOTALHOURS = "totalHoursWorked";
	public static final String PAYROLLRPTHOURSWORKED = "hoursWorked";
	public static final String PAYROLLRPTCLOCKOUTPEND = "clockoutPending";
	public static final String PAYROLLRPTAUTOMATIC = "automatic";
	public static final String PAYROLLRPTJOBCODE = "jobCode";
	public static final String PAYROLLRPTPD = "payrollPd";
	public static final String PAYROLLRPTEMPINFO = "employeeInfo";
	public static final String PAYROLLRPTPAYPERINF = "payPeriodInfo";
	public static final String PAYROLLRPTSESINF = "sessionInfo";
	public static final String PAYROLLRPTSTART = "start";
	public static final String PAYROLLRPTEND = "end";
	public static final String PAYROLLRPTDURATION = "duration";

    public static final String CGI_RESPONSE = "Response";
    public static final String CGI_PREFIXMAPPING= "VFI";
    public static final String CGI_FAULT    = "Fault";
    public static final String CGI_FAULT_CODE = "faultCode";
    public static final String CGI_FAULT_STRING = "faultString";
    public static final String CGI_FAULT_DTL = "detail";
    public static final String CGI_VFI_FAULT = "vfiFault";
    public static final String CGI_VFI_FAULT_MSG = "message";
    public static final String CGI_FAULT_PARSE_LINE = "lineNumber";
    public static final String CGI_FAULT_PARSE_COL = "columnNumber";
    public static final String CGI_FAULT_PARSE_ELEM = "elementName";

	public static final String COUPON_FAM_COUPFAMCFG = "couponFamilyConfig";
	public static final String COUPON_FAM_COUPFAMENTS = "couponFamilyEntries";
	public static final String COUPON_FAM_COUPFAMENT = "couponFamilyEntry";
	public static final String COUPON_FAM_FAMCODE = "familyCode";
	public static final String COUPON_FAM_DESCRIPTION = "description";

    // POP Auto Code Generation
	public static final String POP_AUTOCODE_CFG = "autoCodeConfig";
	public static final String POP_AUTOCODE_CODEENTS = "codes";
	public static final String POP_AUTOCODE_CODEENT = "popCodeGen";
	public static final String POP_AUTOCODE_FREECODE = "freeCode";
	public static final String POP_AUTOCODE_DISCGRADES = "discGrades";
	public static final String POP_AUTOCODE_EXPIRATION = "expiration";


	public static final String DISCOUNT_DENOM_DISCDENOMCFG = "discountConfig";
	public static final String DISCOUNT_DENOM_DISCDENOMENTS = "discounts";
	public static final String DISCOUNT_DENOM_DISCDENOMENT = "discount";
	public static final String DISCOUNT_DENOM_DISCDENOM_DESC = "description";
	public static final String DISCOUNT_DENOM_AMOUNT = "amount";
	public static final String DISCOUNT_DENOM_PERCENT = "percent";

    // Generic Prepaid Card Card Configuration strings
    public static final String PPD_CFG 							= "prepaidConfiguration";
    public static final String PPD_NETWORK_NAME					= "networkName";
    public static final String PPD_IP_ADDR 						= "ipAddress";
    public static final String PPD_IP_PORT_NUM 					= "ipPortNumber";
    public static final String PPD_MERCH_ID 					= "merchantID";
    public static final String PPD_MERCH_NAME 					= "merchantName";
    public static final String PPD_DEPARTMENT                   = "department";
    public static final String PPD_DEPARTMENTENABLED            = "enabled";
    public static final String PPD_REFUNDSENABLED               = "refundsEnabled";
    public static final String PPD_TRANSACTIONTYPE              = "transactionType";
    public static final String PPD_PREPAIDCONFIGELEMENT         = "prepaidConfigElement";
    public static final String PPD_PREPAIDCONFIGELEMENTS        = "prepaidConfigElements";
    public static final String PPD_DISABLED      = "prepaidDisabled";
    public static final String NETWORK          = "network";
    // Generic EPSPrepaid Card Card Configuration strings
    public static final String EPS_PPD_CFG 						= "epsPrepaidConfiguration";
    public static final String EPS_PPD_NETWORK_NAME				= "networkName";
    public static final String EPS_PPD_NETWORK_ENABLED 			= "networkEnabled";
    public static final String EPS_PPD_PREPAID_ENABLED 			= "prepaidEnabled";
    public static final String EPS_PPD_DEPARTMENT				= "prepaidDepartment";
    public static final String EPS_PPD_DEPT_ENABLED				= "enabled";
    public static final String EPS_PPD_EVALUATE					= "evaluate";
    public static final String EPS_PPD_TKT_REPRINT_SECLVL 		= "ticketReprintSecLvl";
    public static final String EPS_PPD_CONFIGURATION     		= "epsPrepaidConfiguration";
    public static final String PPD_RESP_TIMEOUT					= "responseTimeOut";
	public static final String PPD_CLOSE_PERIOD 				= "closePeriod";
    public static final String EPS_PPD_DEPARTMENTS 				= "epsPrepaidDepartments";
    public static final String EPS_PREPAID_PREFIX_NS            = "eppd";
    public static final String EPS_PPD_INCOMM_NETWORK_NAME	    = "incomm";

    // Prepaid Messages Configuration
    public static final String EPS_PPD_MESSAGES					= "messages";
    public static final String EPS_PPD_PREPAID_MESSAGE			= "prepaidMessage";
    public static final String EPS_PPD_PREPAID_MESSAGE_TYPE		= "messageType";
    public static final String EPS_PPD_MSG_PMT_ENABLED			= "enabled";
    public static final String EPS_PPD_MESSAGE					= "message";

        //vcashiertrackingconfig & ucashiertrackingconfig
        public static final String CSH_TRACKING_CONFIG = "cashierTrackingConfig";
        public static final String CSH_TRACKING = "cashierTracking";
        public static final String PLU_TRACKING = "pluTracking";
        public static final String DEPT_TRACKING = "deptTracking";
        public static final String CAT_TRACKING = "catTracking";
        public static final String CSH_TRACKING_PLU = "plu";
	public static final String CSH_TRACKING_UPC = "upc";
	public static final String CSH_TRACKING_MODIFIER = "modifier";
        public static final String CSH_TRACKING_DEPT = "dept";
        public static final String CSH_TRACKING_CAT = "cat";
        public static final String CSH_TRACKING_SYSID = "sysid";
        public static final String CSH_TRACKING_NAME = "name";


    //vcwpaypointcfg and ucwpaypointcfg
    public static final String CARWASH_PAYPOINT_CONFIG   = "carWashPaypointConfig";
    public static final String DAY_CLOSE_PERIOD = "dayClosePeriod";
    public static final String NETWORK_TIMEOUT  = "networkTimeout";
    public static final String IS_ENABLED2      = "isEnabled";
    public static final String IS_DEBIT_ENABLED = "isDebitEnabled";
    public static final String BAY_IP           = "bayIP";
    public static final String AUTH_PORT        = "authPort";
    public static final String ALERT_PORT       = "alertPort";
    public static final String ENTRY_PORT       = "entryPort";
    public static final String RECONCILIATION_PORT   = "reconciliationPort";
    public static final String CW_KEY_ID        = "cwKeyID";
    public static final String CARWASH_BAY      = "carWashBay";

	//String constants for rules XML document
    public static final String RULES = "rules";
    public static final String RULE = "rule";
    public static final String SCOPE = "scope";
    public static final String TRIGGER = "trigger";
    public static final String ACTIVE = "active";
    public static final String POLICY_DESC = "description";
    public static final String CONDITION = "condition";
    public static final String WHERE = "where";
    public static final String RULES_PLU_NUM = "plu";
    public static final String RULES_UPC = "upc";
    public static final String RULES_MODIFIER = "modifier";
    public static final String RULES_PLU = "vs:pluNum";
    public static final String RULES_QTY = "qty";
    public static final String RULES_AMT = "amt";
    public static final String RULES_AND = "and";
    public static final String RULES_OR = "or";
    public static final String THEN = "then";
    public static final String ACTION = "action";
    public static final String ALERT_CASHIER = "alertCashier";
    public static final String JOURNAL_EVENT = "journalEvent";
    public static final String ID_CHECK = "idCheck";
    public static final String VETO = "veto";
    public static final String RECEIPTMSG = "receiptMsg";
    public static final String RECEIPTHDR = "receiptHdr";
    public static final String LINE = "line";
    public static final String RESTRICT_DEPT = "restrictDept";

    /*Food Service*/

    //String constants for foodservcfg XML document
    public static final String FOODSERVCFG = "foodServiceConfig";
    public static final String IORDER = "iOrder";
    public static final String SEND_TO_KDS = "sendToKitchenDisplaySystem";
    public static final String IORDER_IPADRESS = "IPAddress";
    public static final String PORT = "Port";
    public static final String FOOD_SRVC_TICKET= "foodserviceticket";
    public static final String PRINT_TICKET = "printTicket";
    public static final String CUSTOM_MSG = "receiptMessage";
    public static final String TICKET = "ticket";
    public static final String FOOD_SERVC_NOTFN = "foodServicePaymentNotification";
    public static final String ELECTRONIC_NOTFN = "notifyElectronically";
    public static final String KIOSK = "kiosk";

    //String constants for food service messages
    public static final String POS_FOOD_ORDER = "posFoodOrder";
    public static final String PRINT_LOC ="printLoc";
    public static final String ITEM ="item";
    public static final String DEPT_ID ="deptId";
    public static final String PAYMENT_STATUS = "paymentStatus";
    public static final String POS_FOOD_ORDER_RES="posFoodOrderResponse";
    public static final String TRANS_NUM = "transNum";
    public static final String FAILURE = "failure";
    public static final String FOOD_ORDERS = "foodOrders";
    public static final String ORDER_NUM = "orderNum";
    public static final String KIOSK_DOMAIN_NS   = "ko";
    public static final String PAID = "PAID";
    public static final String VOIDED = "VOIDED";
    public static final String PENDING = "PMNT DUE";
    public static final String AMT = "amt";
    public static final String POS_ID = "posId";
    public static final String SUCCESS = "success";
	public static final String DINE_IN = "dineInStatus";
	public static final String CUSTOMERDETAILS= "customerDetails";
	public static final String CUSTOMERNAME= "name";
	public static final String CUSTOMERPHONENUMBER= "phoneNumber";
	
	
	//kiosk version and upgrade related XMLs
	public static final String MODULE = "module";
	public static final String MODULE_VER = "version";
	public static final String MODULE_NAME = "name";
	public static final String BUILD_HASH = "build";
	public static final String KIOSK_RESPONSE = "kioskResponse";
	public static final String KIOSK_COMMAND = "command";
	public static final String KIOSK_DEVICE_RESP = "deviceResponse";
	public static final String KIOSK_RESULT = "result";
	public static final String KIOSK_UPG_STATUS = "status";
	public static final String KIOSK_STATUS_LOG = "statusLog";

   // String added for IPConfig
    public static final String DEVICE_CONFIG = "DeviceConfig";
    public static final String SAPPHIRE_IP = "SapphireIP";
    public static final String GATEWAYIP  = "GatewayIP";
    public static final String NETMASK = "NetMask";
    public static final String HPV = "HPV-20IP";
    public static final String RESTORE_DEFAULT_CONFIG = "RESTORE_DEFAULT_CONFIG";
        public static final String LINE1 = "line1";
        public static final String LINE2 = "line2";
        public static final String LINE3 = "line3";
        public static final String LINE4 = "line4";
        public static final String IDLE_PROMPT_CONFIG = "netIdlePromptConfig";
	public static final String KITCHEN_PRINT = "kitchenPrint";
	public static final String PROMPT = "prompt";
	public static final String PROMPT_MESSAGE = "promptMessage";
	public static final String PROMPT_TYPE = "promptType";
	public static final String MENU_KEY = "menuKey";
	public static final String ADD_ITEM = "addItem";
	
    //Carwash paypoint    
	public static final String CW_PAYPOINT_REPORT = "cwPaypointPd";
    public static final String CW_PAYPOINT_TOTALS = "cwPaypointTotals";
    public static final String CW_PAYPOINT_RECON = "cwPaypointReconciliation";
    public static final String PAYPOINT_ID = "paypointID";
    public static final String WASH_DETAILS = "washDetails";
    public static final String WASH_ID = "washID";
    public static final String COUNT_WASH_ACTIVATIONS = "countWashActivations";
    public static final String COUNT_SALES_PAYPOINT = "countSalesPaypoint";
    public static final String CASH_SALES_PAYPOINT = "cashSalesPaypoint";
    public static final String CREDIT_SALES_PAYPOINT = "creditSalesPaypoint";
    public static final String OTHER_SALES_PAYPOINT = "otherSalesPaypoint";
    public static final String UPGRADES_PAYPOINT = "upgradesPaypoint";
    public static final String POS_TOTALS = "posTotals";
    public static final String CONSOLE_TOTALS = "consoleTotals";
    public static final String RECEIVED = "received";
    public static final String DISPENSED = "dispensed";
    public static final String AMOUNT_BILLS = "amountBills";
    public static final String AMOUNT_COINS = "amountCoins";
    public static final String COUNT_COUPONS = "countCoupons";
    public static final String COUNT_TOKENS = "countTokens";
    public static final String CW_PAYPOINT_DATE_TIME = "dateTime";
    public static final String CW_PAYPOINT_DATE_TIME_TAG = "DateTime";
    public static final String CW_PAYPOINT_OPENED_DATE_TIME_TAG = "OpenedDateTime";
    public static final String CW_PAYPOINT_TIME = "Time";
    public static final String CW_PAYPOINT_TERMINAL_ID = "TerminalID";
    public static final String CW_PAYPOINT_SEQUENCE_ID = "SequenceID";
    public static final String CW_PAYPOINT_SEQUENCE_NUM = "SequenceNumber";
    public static final String CW_PAYPOINT_TIMEOUT = "TimeOut";
    public static final String CW_PAYPOINT_NETWORK_TIMEOUT  = "NetworkTimeout";
    public static final String CW_PAYPOINT_REASON = "Reason";
    public static final String CW_PAYPOINT_RESULT = "Result";
    public static final String CW_PAYPOINT_ACCEPTED= "Accepted";

    public static final String CW_PAYPOINT_ALERT_SERVICE = "AlertService";
    public static final String CW_PAYPOINT_ALERT_EVENT = "AlertEvent";
    public static final String CW_PAYPOINT_ALERT_SEVERITY = "severity";
    public static final String CW_PAYPOINT_ALERT_DESCRIPTION = "description";
    public static final String CW_PAYPOINT_ALERT_STATUS = "status";
    public static final String CW_PAYPOINT_ALERT_EQUIPMENT = "Equipment";
    public static final String CW_PAYPOINT_ALERT_EQUIP_NAME = "Name";
    public static final String CW_PAYPOINT_ALERT_EQUIP_UUID = "UUID";
    public static final String CW_PAYPOINT_ALERT_EQUIP_VERSION = "Version";
    public static final String CW_PAYPOINT_ALERT_EQUIP_ECODE = "ErrorCode";
    public static final String CW_PAYPOINT_ALERT_EQUIP_SENSOR = "Sensor";
    public static final String CW_PAYPOINT_ALERT_EQUIP_SENSOR_NAME = "name";
    public static final String CW_PAYPOINT_ALERT_EQUIP_SENSOR_VALUE = "value";

    public static final String CW_PAYPOINT_AUTH_SERVICE = "AuthorizeService";
    public static final String CW_PAYPOINT_AUTH_COMMAND = "AuthorizeCommand";
    public static final String CW_PAYPOINT_AUTH_RESPONSE = "AuthorizeResponse";
    public static final String CW_PAYPOINT_AUTH_RESPONSE_ACK = "AcknowledgeAuthResponse";
    public static final String CW_PAYPOINT_USER_QUERY_COMMAND = "UserQueryCommand";
    public static final String CW_PAYPOINT_USER_QUERY_RESPONSE = "UserQueryResponse";
    public static final String CW_PAYPOINT_PIN_QUERY_COMMAND = "UserPINQueryCommand";
    public static final String CW_PAYPOINT_PIN_QUERY_RESPONSE = "UserPINQueryResponse";
    public static final String CW_PAYPOINT_CANCEL_EVENT = "CancelEvent";
    public static final String CW_PAYPOINT_HEARTBEAT = "Heartbeat";
    public static final String CW_PAYPOINT_MAC = "MAC";
    public static final String CW_PAYPOINT_MAC_ID = "MACID";
    public static final String CW_PAYPOINT_RFID = "RFID";
    public static final String CW_PAYPOINT_RFID_DATA = "rfidData";
    public static final String CW_PAYPOINT_RFID_TRACK_DATA = "trackData";
    public static final String CW_PAYPOINT_MAGSTRIPE = "MagStripe";
    public static final String CW_PAYPOINT_TRACK1_DATA = "track1Data";
    public static final String CW_PAYPOINT_TRACK2_DATA = "track2Data";
    public static final String CW_PAYPOINT_ITEM = "Item";
    public static final String CW_PAYPOINT_ITEM_ID = "ID";
    public static final String CW_PAYPOINT_ITEM_AMOUNT = "ItemAmount";
    public static final String CW_PAYPOINT_PREPAID_ITEM_ID = "PrePaidItemID";
    public static final String CW_PAYPOINT_REGULAR_SELL_PRICE = "RegularSellPrice";
    public static final String CW_PAYPOINT_APPROVED = "Approved";
    public static final String CW_PAYPOINT_DISPLAY_TEXT = "DisplayText";
    public static final String CW_PAYPOINT_CHARGED_AMOUNT = "ChargedAmount";
    public static final String CW_PAYPOINT_RECEIPT_TEXT = "ReceiptText";
    public static final String CW_PAYPOINT_ENTRY_MODE = "EntryMode";
    public static final String CW_PAYPOINT_ENTRY_PARAM = "EntryParameters";
    public static final String CW_PAYPOINT_ENTRY_MODE_DIGIT = "Digit";
    public static final String CW_PAYPOINT_ENTRY_MODE_QUESTION = "Question";
    public static final String CW_PAYPOINT_ENTRY_MODE_NUMERIC = "Numeric";
    public static final String CW_PAYPOINT_ENTRY_MASKED = "masked";
    public static final String CW_PAYPOINT_ENTRY_MIN_DIGITS = "minDigits";
    public static final String CW_PAYPOINT_ENTRY_MAX_DIGITS = "maxDigits";
    public static final String CW_PAYPOINT_ENTRY_ATTEMPTS = "attempts";
    public static final String CW_PAYPOINT_QUERY_KEY = "Key";
    public static final String CW_PAYPOINT_QUERY_USER_DATA = "UserData";
    public static final String CW_PAYPOINT_QUERY_ACCT_DATA = "AccountData";
    public static final String CW_PAYPOINT_QUERY_USER_PIN = "UserPIN";

    public static final String CW_PAYPOINT_ENTRY_SERVICE = "EntryService";
    public static final String CW_PAYPOINT_SET_CONFIG_COMMAND = "SetConfigurationCommand";
    public static final String CW_PAYPOINT_SET_CONFIG_RESPONSE = "SetConfigurationResponse";
    public static final String CW_PAYPOINT_CONFIG_DEBIT_ENABLED = "DebitEnabled";
    public static final String CW_PAYPOINT_CONFIG_WASH_PACKAGE = "WashPackage";
    public static final String CW_PAYPOINT_CONFIG_DESCRIPTION_8_CHAR = "Description8A";
    public static final String CW_PAYPOINT_CONFIG_DISC_AMOUNT_1 = "DiscAmt1";
    public static final String CW_PAYPOINT_CONFIG_DISC_AMOUNT_2 = "DiscAmt2";
    public static final String CW_PAYPOINT_ACCOUNT_DATA_COMMAND = "AccountDataCommand";
    public static final String CW_PAYPOINT_ACCOUNT_DATA_RESPONSE = "AccountingDataResponse";
    public static final String CW_PAYPOINT_ACCOUNT_DATA_RESET = "Reset";
    public static final String CW_PAYPOINT_ACCOUNT_DATA_WASH_SALES_DATA = "WshS";
    public static final String CW_PAYPOINT_ACCOUNT_DATA_COUNT_WASH_ACTIVATIONS = "WA";
    public static final String CW_PAYPOINT_ACCOUNT_DATA_COUNT_SALES = "SC";
    public static final String CW_PAYPOINT_ACCOUNT_DATA_COUNT_CASH_SALES = "CaC";
    public static final String CW_PAYPOINT_ACCOUNT_DATA_AMOUNT_CASH_SALES = "CaS";
    public static final String CW_PAYPOINT_ACCOUNT_DATA_COUNT_CREDIT_SALES = "CrC";
    public static final String CW_PAYPOINT_ACCOUNT_DATA_AMOUNT_CREDIT_SALES = "CrS";
    public static final String CW_PAYPOINT_ACCOUNT_DATA_COUNT_OTHER_SALES = "OSC";
    public static final String CW_PAYPOINT_ACCOUNT_DATA_AMOUNT_OTHER_SALES = "OSS";
    public static final String CW_PAYPOINT_ACCOUNT_DATA_COUNT_UPGRADES = "UpC";
    public static final String CW_PAYPOINT_ACCOUNT_DATA_AMOUNT_UPGRADES = "UpS";
    public static final String CW_PAYPOINT_ACCOUNT_DATA_AMOUNT_CODES_POS = "PCS";
    public static final String CW_PAYPOINT_ACCOUNT_DATA_COUNT_CODES_POS = "PCC";
    public static final String CW_PAYPOINT_ACCOUNT_DATA_AMOUNT_CODES_CW_CONSOLE = "CCS";
    public static final String CW_PAYPOINT_ACCOUNT_DATA_COUNT_CODES_CW_CONSOLE = "CCC";
    public static final String CW_PAYPOINT_ACCOUNT_DATA_PAYMENTS_RECEIVED = "Rcv";
    public static final String CW_PAYPOINT_ACCOUNT_DATA_AMOUNT_BILLS_IN = "BsIn";
    public static final String CW_PAYPOINT_ACCOUNT_DATA_AMOUNT_COINS_IN = "CnIn";
    public static final String CW_PAYPOINT_ACCOUNT_DATA_COUNT_COUPONS_IN = "CpIn";
    public static final String CW_PAYPOINT_ACCOUNT_DATA_COUNT_TOKENS_IN = "TkIn";
    public static final String CW_PAYPOINT_ACCOUNT_DATA_DISPENSED_DATA = "Dsp";
    public static final String CW_PAYPOINT_ACCOUNT_DATA_AMOUNT_BILLS_OUT = "BO";
    public static final String CW_PAYPOINT_ACCOUNT_DATA_COUNT_TOKENS_OUT = "TO";
    public static final String CW_PAYPOINT_ACCOUNT_DATA_AMOUNT_COINS_OUT = "CO";
    public static final String CW_PAYPOINT_CASH_RECON_EVENT = "CashReconciliationEvent";
    public static final String CW_PAYPOINT_CASH_RECON_RESPONSE = "CashReconciliationResponse";
    public static final String CW_PAYPOINT_CASH_RECON_BILLS_IN = "BillsIn";
    public static final String CW_PAYPOINT_CASH_RECON_COINS_IN = "CoinsIn";
    public static final String CW_PAYPOINT_CASH_RECON_TOKENS_IN = "TokensIn";
    public static final String CW_PAYPOINT_CASH_RECON_COUPONS_IN = "CouponsIn";
    public static final String CW_PAYPOINT_CASH_RECON_BILLS_OUT = "BillsOut";
    public static final String CW_PAYPOINT_CASH_RECON_COINS_OUT = "CoinsOut";
    public static final String CW_PAYPOINT_CASH_RECON_TOKENS_OUT = "TokensOut";

    // ESafe strings
    public static final String ESAFE_CSAFE = "CSafe";
    public static final String ESAFE_CSHIFT = "CShift";
    public static final String ESAFE_CSHIFT_NUMBER = "CShiftNo";
    public static final String ESAFE_CASHIER_ID = "CashID";
    public static final String ESAFE_OLD_CSHIFT = "OldCShft";
    public static final String ESAFE_CURRENT_CSHIFT = "CurCShft";
    public static final String ESAFE_START_TIME = "StartTime";
    public static final String ESAFE_END_TIME = "EndTime";
    public static final String ESAFE_ENVELOPE_COUNT = "EnvCount";
    public static final String ESAFE_UNRECOGNIZED_BILLS = "UnrecBill";
    public static final String ESAFE_UNVERIFIED_CASH_RATIO = "UCRatio";
    public static final String ESAFE_ENVELOPE_CASH = "EnvCash";
    public static final String ESAFE_ENVELOPE_NON_CASH = "NonCash";
    public static final String ESAFE_CASSETTE_CASH = "CassCash";
    public static final String ESAFE_TOTAL_AMOUNT = "TotalAmt";
    public static final String ESAFE_SALES_AMOUNT = "SalesAmt";
    public static final String ESAFE_CHANGE_VEND_AMOUNT = "ChgVend";
    public static final String ESAFE_PAYOUT_AMOUNT = "Payout";
    public static final String ESAFE_ENVELOPE_CHECK_AMOUNT = "Check";
    public static final String ESAFE_FOODSTAMP_AMOUNT = "FoodStamp";
    public static final String ESAFE_CURRENT_RPT_NUMBER = "CurRptNo";
    public static final String ESAFE_CONTENT_NUMBER = "ContentNo";
    public static final String ESAFE_DAY_NUMBER = "DayNo";
    public static final String ESAFE_SHIFT_NUMBER = "ShiftNo";
    public static final String ESAFE_SHIFT_RANGE = "ShiftRng";
    public static final String ESAFE_FIRST_SHIFT = "FirstShft";
    public static final String ESAFE_LAST_SHIFT = "LastShft";
    public static final String ESAFE_CONTENT = "Content";
    public static final String ESAFE_FILE = "File";
    public static final String ESAFE_WRITE = "Write";
    public static final String ESAFE_NETWORK = "Network";
    public static final String ESAFE_READ = "Read";
    public static final String ESAFE_ADDRESS = "address";
    public static final String ESAFE_NETMASK = "netmask";
    public static final String ESAFE_GATEWAY = "gateway";
    public static final String ESAFE_PORT = "port";
    public static final String ESAFE_RXTIMEOUT = "rxTimeout";
    public static final String ESAFE_ERROR = "Error";
    public static final String ESAFE_ID = "id";
    public static final String ESAFE_DAY = "Day";
    public static final String ESAFE_OLD_DAY = "OldDay";
    public static final String ESAFE_CURRENT_DAY = "CurDay";
    public static final String ESAFE_CHANGE_FUND = "ChgFund";
    public static final String ESAFE_CATEGORY2_SALES = "Cat2Sales";
    public static final String ESAFE_CHANGE_DAY = "ChgDay";
    public static final String ESAFE_RESULT = "Result";
    public static final String ESAFE_OLD_CONTENT = "OldCont";
    public static final String ESAFE_CURRENT_CONTENT = "CurCont";
    public static final String ESAFE_CASSETTE = "Cassette";
    public static final String ESAFE_ENVELOPE = "Envelope";
    public static final String ESAFE_OVER_LIMIT = "OvrLimit";
    public static final String ESAFE_ENVELOPE_ITEMS = "EnvItems";
    public static final String ESAFE_ENVELOPE_TOTAL = "EnvTotal";
    public static final String ESAFE_FIRST_DAY = "FirstDay";
    public static final String ESAFE_LAST_DAY = "LastDay";
    public static final String ESAFE_DAY_COUNT = "DayCount";
    public static final String ESAFE_BAG_SEAL = "BagSeal";
    public static final String ESAFE_CASSETTE_STATUS = "CassStat";
    public static final String ESAFE_SAFE_ENTRY = "SafeEntry";
    public static final String ESAFE_SEQUENCE = "Sequence";
    public static final String ESAFE_SEAL_NUMBER = "SealNo";
    public static final String ESAFE_NUMBER_RECOGNIZED_BILLS = "NoRecBill";
    public static final String ESAFE_STATUS = "Status";
    public static final String ESAFE_BUSINESS_DATE = "BussDate";
    public static final String ESAFE_TICKET_NUMBER = "TicketNo";
    public static final String ESAFE_ITEM_COUNT = "ItemCount";
    public static final String ESAFE_CASHIER_ID_FOR_ENVELOPE = "CashierId";
    public static final String ESAFE_TYPE_DROP = "TypeDrop";
    public static final String ESAFE_DROP_TIME = "DropTime";
    public static final String ESAFE_TIME = "Time";
    public static final String ESAFE_AMOUNT_OVER = "AmtOver";
    public static final String ESAFE_AUDIT_NUMBER = "AuditNo";
    public static final String ESAFES = "safes";
    public static final String ESAFE = "safe";
    public static final String ESAFE_OPERATION = "operation";
    public static final String ESAFE_TYPE = "type";
    public static final String ESAFE_SYSID = "sysid";
    public static final String ESAFE_ISENABLED = "isEnabled";
    public static final String ESAFE_ISSAFEIP = "eSafeIP";
    public static final String ESAFE_SUBNET = "eSafeSubnet";
    public static final String ESAFE_USESAFEONLY = "useESafeOnly";
    public static final String ESAFE_DAYCLOSEPERIOD = "dayClosePeriod";
    public static final String ESAFE_SITEPARAMETERS= "siteParameters";
    public static final String ESAFE_IDMAPPINGS = "idMappings";
    public static final String ESAFE_IDMAPPING = "idMapping";
    public static final String ESAFE_ESAFECONFIG = "eSafeConfig";
    public static final String ESAFE_EMPID = "employeeId";
    public static final String ESAFE_EMPSAFEID = "employeeSafeId";
    public static final String ESAFE_DESCRIPTION = "description";
    public static final String ESAFE_CONFIG_GATEWAY = "eSafeGateway";
    public static final String ESAFE_CONFIG_PORT = "eSafePort";
    public static final String ESAFE_ESAFEID = "eSafeId";
	public static final String ESAFE_SAFETYPE = "safeType";
	public static final String ESAFE_DEVICETYPE = "deviceType";
	public static final String ESAFE_CASHIER_TOTALS = "eSafeCashierTotals";
	public static final String CURRENT = "CURRENT";
	public static final String CURRENT_SMALL = "current";
	
	//Vista Terminal Group Strings
    public static final String VISTA_GROUP_CONFIG= "vistaGroupConfig";
    public static final String VISTA_GROUP= "group";
    public static final String VISTA_NAME= "name";
    public static final String VISTA_STICKY_LABEL= "stickyLabelRequired";
    public static final String VISTA_ENABLED_MOP_CODES = "enabledMOPCodes";
    public static final String VISTA_ENABLED_DEPARTMENTS = "enabledDepartments";
    public static final String VISTA_MOP_CODE = "mopCode";
    public static final String VISTA_DEPARTMENT = "department";
    public static final String VISTA_MENU_CONFIG = "menuConfig";
    public static final String VISTA_MENU = "menu";
    public static final String VISTA_MENU_NAME = "menuName";
    public static final String VISTA_MENU_TYPE = "menuType";
    public static final String VISTA_EXPANDED_MENU_SYSID = "sysid";
    public static final String VISTA_EXPANDED_MENU_NAME = "name";
    public static final String VISTA_EXPANDED_MENU_PARKED = "parked";
    public static final String VISTA_GROUP_OPERATION_TYPE = "operationType";
    
    //Vista Terminal Config Strings
    public static final String VISTA_TERMINAL_CONFIG= "vistaTerminalConfig";
    public static final String VISTA_TERMINAL_SITE= "vs:site";
    public static final String VISTA_TERMINAL_LOCATION_ID= "locationId";
    public static final String VISTA_TERMINAL_CONFIG_TERMINAL_GROUP_SYSID = "groupSysID";
    public static final String VISTA_TERMINAL_CONFIG_TERMINAL_IDENTIFIER = "terminalIdentifier";
    public static final String VISTA_TERMINAL_CONFIG_TERMINAL_OPERATION_TYPE = "operationType";
    
	//Tidel ESafe Messages
	public static final String ESAFE_TIDEL_SAFETYPE_NAME = "tidel";
	public static final String ESAFE_TIDEL_NAME = "Name";
	public static final String ESAFE_TIDEL_REGISTER = "Register";
	public static final String ESAFE_TIDEL_CURRENCY_CODE = "CurrencyCode";
	public static final String ESAFE_TIDEL_CURRENCY_CODE_ATTR = "currencyCode";
	public static final String ESAFE_TIDEL_INFO_TEXT = "Text";
	public static final String ESAFE_TIDEL_SUCCESS_CODE = "SuccessCode";

	//Request Status, Status Response
	public static final String ESAFE_TIDEL_REQ_STATUS = "RequestStatus";
	public static final String ESAFE_TIDEL_DISCARD_DATA = "DiscardTardyData";
	public static final String ESAFE_TIDEL_STAT_RESP = "StatusResponse";
	public static final String ESAFE_TIDEL_STATUS = "Status";

	public static final String ESAFE_TIDEL_STAT_IDLE= "Idle";
	public static final String ESAFE_TIDEL_STAT_LOCKED= "Locked";
	public static final String ESAFE_TIDEL_STAT_INLOCALUSE= "InLocalUse";
	public static final String ESAFE_TIDEL_STAT_ACCEPTING_BILLS= "AcceptingBills";
	public static final String ESAFE_TIDEL_STAT_VENDING= "Vending";
	public static final String ESAFE_TIDEL_STAT_VAULT_DROP= "VaultDrop";
	public static final String ESAFE_TIDEL_STAT_LOADING_TUBES= "LoadingTubes";
	public static final String ESAFE_TIDEL_STAT_UPDATING_ACCEPTORS= "UpdatingAcceptors";
	public static final String ESAFE_TIDEL_STAT_SAVING_EMP_INFO= "SavingEmployeeInformation";
	public static final String ESAFE_TIDEL_STAT_SAVING_CONFIGN= "SavingConfiguration";
	public static final String ESAFE_TIDEL_STAT_PRINTING_REPORTS= "PrintingReports";
	public static final String ESAFE_TIDEL_STAT_ENDING_SHIFT= "EndingShift";
	public static final String ESAFE_TIDEL_STAT_ENDING_DAY= "EndingDay";
	public static final String ESAFE_TIDEL_STAT_UPDATING_IMAGE= "UpdatingImage";
	public static final String ESAFE_TIDEL_STAT_GETTING_FINAN_INFO= "GettingFinancialInformation";
	public static final String ESAFE_TIDEL_STAT_UNZIPPING_FILE= "UnzippingFile";
	public static final String ESAFE_TIDEL_STAT_UNKNOWN_NETWORK_USE= "UnknownNetworkUse";

	//Lock, LockResponse
	public static final String ESAFE_TIDEL_LOCK = "Lock";
	public static final String ESAFE_TIDEL_LOCK_RESPONSE = "LockResponse";
	public static final String ESAFE_TIDEL_LOCKED = "Locked";
	public static final String ESAFE_TIDEL_LOCK_FAILED = "Failed";
	public static final String ESAFE_TIDEL_LOCK_FAILED_ID_NUMBER = "ID NUMBER INVALID";
	public static final String ESAFE_TIDEL_LOCK_FAILED_DEVICE_BUSY = "Lock pending from user interface";

	//Unlock, UnLockResponse
	public static final String ESAFE_TIDEL_UNLOCK = "Unlock";
	public static final String ESAFE_TIDEL_UNLOCK_RESPONSE = "UnlockResponse";
	public static final String ESAFE_TIDEL_UNLOCKED = "Unlocked";
	public static final String ESAFE_TIDEL_UNLOCK_FAILED = "Failed";

	//Command Response
	public static final String ESAFE_TIDEL_COMMAND_RESPONSE = "CommandResponse";
	public static final String ESAFE_TIDEL_COMMAND_STATUS = "CommandStatus";
	public static final String ESAFE_TIDEL_EXENDED_STATUS = "ExendedStatus";
	public static final String ESAFE_TIDEL_COMMAND_STATUS_OK="OK";
	public static final String ESAFE_TIDEL_COMMAND_STATUS_BUSY="Busy";
	public static final String ESAFE_TIDEL_COMMAND_STATUS_CORRUPTED="Corrupted";
	public static final String ESAFE_TIDEL_COMMAND_STATUS_LOCK_REQUIRED="LockRequired";
	public static final String ESAFE_TIDEL_COMMAND_STATUS_CANNOT_PROCEED="CannotProceed";
	public static final String ESAFE_TIDEL_COMMAND_STATUS_CANT_PROCEED_NO_HW_SUPPORT = "SAFE HARDWARE ERROR";
	public static final String ESAFE_TIDEL_COMMAND_STATUS_CANT_PROCEED_NOT_CONFIGURED="not been configured";

	public static final String ESAFE_TIDEL_EXENDED_STATUS_OK="OK";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_ACNT_OVERFLOW="CA_AccountingOverflow";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_ALL_CLEAR="CA_AllClear";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_BAG_STOP="CA_BagStop";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_COM1ERR="CA_Com1Error";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_COM2ERR="CA_Com2Error";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_COM3ERR="CA_Com3Error";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_COM4ERR="CA_Com4Error";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_COMFAIL="CA_CommFail";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_DIR_SENSOR="CA_DirtySensor";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_DIR_SENSOR_aT_STARTUP="CA_DirtySensorAtStartup";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_LOCKERR="CA_InterlockError";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_KEYSEQERR="CA_KeySequenceError";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_LOW_BATTERY="CA_LowBattery";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_MOTOR_FAIL="CA_MotorFail";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_MOTOR_LOCK="CA_MotorLock";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_NO_COIN_ACCEPTOR="CA_NoCoinAcceptor";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_PRINTER_BUSY="CA_PrinterBusy";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_RAM_ERR="CA_RamError";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_RUN_NO_ACCEPT="CA_RunNoAccept";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_TOTAL_NOT_ZERO="CA_TotalNotZero";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_TUBE_JAM="CA_TubeJam";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_VEND_DELAY="CH_VendDelay";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_HOPPER_MALFUN="CH_HopperMalfunction";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_CUP_NOT_EMPTY="CH_CupNotEmpty";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_CUP_MISSING="CH_CupMissing";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_CH_CH_EMPTY="CH_Empty";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_OVER_VEND_LIMIT="CH_OverVendLimit";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_HOPPER_NOT_INIT="CH_HopperNotInitialized";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_OVERFLOW_BIN_FULL="CH_OverflowBinFull";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_CUP_DRAWER_CLOSED="CupDrawerClosed";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_CUP_DRAWER_OPEN="CupDrawerOpen";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_HOPPER_FULL="HopperFull";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_HOPPER_VAULT_NOT_SECURE="HopperVaultNotSecured";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_NO_CUP_DRAWER="NoCupDrawer";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_NO_HOPPER="NoHopper";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_ALREADY_DISPENSING="AlreadyDispensing";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_TOO_MANY_FOR_CUP="TooManyForCup";
	public static final String ESAFE_TIDEL_EXENDED_STATUS_UNKNOWN="Unknown";

	//RequestParameters
	public static final String ESAFE_TIDEL_REQUEST_PARAMETERS = "Request Parameters";

	//RequestCurrentContents- Request for Content Report
	public static final String ESAFE_TIDEL_REQUEST_CURRENT_CONTENTS = "RequestCurrentContents";

	//CurrentContents - Tidel Content Report
	public static final String ESAFE_CONTENT_PD_V1 = "v1:eSafeContentPd";
	public static final String ESAFE_CONTENT_PD_NS1 = "ns1:eSafeContentPd";
	public static final String ESAFE_CONTENT_PD = "eSafeContentPd";
	public static final String ESAFE_TIDEL_ESAFE_TIDEL_CONTENT_DATA = "tidelContentData";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS = "CurrentContents";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_STORE_NAME = "StoreName";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_REPORT_FAMILY = "ReportFamily";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_BILL_READERS = "BillReaders";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_BILL_READER = "BillReader";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_VAULT = "Vault";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_INDEX = "Index";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_COL_CONFIGURATIONS = "ColumnConfigurations";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_COL_CONFIGURATION = "ColumnConfiguration";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_DENOMINATION = "Denomination";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_COUNT = "Count";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_AMOUNT = "Amount";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_VALUE_IN_CENTS = "ValueInCents";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_COL_COUNTS = "ColumnCounts";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_COL_COUNT = "ColumnCount";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_TUBE_COUNT = "TubeCount";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_HOPPERS = "Hoppers";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_HOPPER = "Hopper";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_CURRENCY_CODE = "CurrencyCode";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_COIN_COUNT = "CoinCount";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_DISPENSER = "Dispenser";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_CASSETTE = "Cassette";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_NOTE_COUNT = "NoteCount";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_REJECTS = "Rejects";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_STACK = "Stack";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_VAULT_CONTENTS = "VaultContents";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_DROPS = "Drops";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_CASH = "Cash";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_CHECK = "Check";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_OTHER = "Other";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_RESERVE = "Reserve";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_COURIER_TRAY = "CourierTray";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_OVERFLOW_BIN = "OverflowBin";
	public static final String ESAFE_TIDEL_CURRENT_CONTENTS_COINS = "Coins";

	//Brinks content report
	public static final String ESAFE_SAFE_DATA = "safeData";
	public static final String ESAFE_BRINKS_CONTENT_DATA = "contentData";
	public static final String ESAFE_BRINKS_SAFE_OPEN = "safeOpen";
	public static final String ESAFE_BRINKS_CONTENT_RPT_NUM ="contentReportNumber";
	public static final String ESAFE_BRINKS_START_DATE_TIME="startDateTime";
	public static final String ESAFE_BRINKS_END_DATE_TIME="endDateTime";
	public static final String ESAFE_BRINKS_START_DAY_RPT_NUM="startDayReportNumber";
	public static final String ESAFE_BRINKS_END_DAY_RPT_NUM="endDayReportNumber";
	public static final String ESAFE_BRINKS_DAY_COUNT="dayCount";
	public static final String ESAFE_BRINKS_SEQ_NUM="sequenceNumber";
	public static final String ESAFE_BRINKS_SUMMARY_TOT="summaryTotals";
	public static final String ESAFE_BRINKS_TOTALS="totals";
	public static final String ESAFE_BRINKS_CASSETTE_MOP="cassetteByMop";
	public static final String ESAFE_BRINKS_NAME="name";
	public static final String ESAFE_BRINKS_COUNT="count";
	public static final String ESAFE_BRINKS_AMOUNT="amount";
	public static final String ESAFE_BRINKS_CHANGE_VEND_MOP="changeVendByMop";
	public static final String ESAFE_BRINKS_PAY_OUT_MOP="payoutsByMop";
	public static final String ESAFE_BRINKS_ENV_MOP="envelopeByMop";
	public static final String ESAFE_BRINKS_ENV_COUNT="envelopeCount";
	public static final String ESAFE_BRINKS_CASH_RATIO="unverifiedCashRatio";
	public static final String ESAFE_BRINKS_ENV_ITEM_COUNT="envelopeItemCount";
	public static final String ESAFE_BRINKS_CAT_SALE_AMT="cat2SalesAmount";
	public static final String ESAFE_BRINKS_CHANGE_FUND_MOP="changeFundDepositByMop";
	public static final String ESAFE_BRINKS_SEAL="seal";
	public static final String ESAFE_BRINKS_BAG_SEAL="bagSeal";
	public static final String ESAFE_BRINKS_STATUS="status";
	public static final String ESAFE_BRINKS_CASSETTE_STATUS="cassetteStatus";
	public static final String ESAFE_BRINKS_CASSETTE_TOT="cassetteTotals";
	public static final String ESAFE_BRINKS_SEAL_NUM="sealNumber";
	public static final String ESAFE_BRINKS_TOT_MOP="totalByMop";
	public static final String ESAFE_BRINKS_TOT_BILL_COUNT="recognizedBillCount";
	public static final String ESAFE_BRINKS_TOT__UNREC_BILL_COUNT="unrecognizedBillCount";
	public static final String ESAFE_BRINKS_ENV_TOT="envelopeTotals";
	public static final String ESAFE_BRINKS_BUSINESS_DATE_TIME="businessDateTime";
	public static final String ESAFE_BRINKS_ENV_DROP_DATE_TIME="envelopeDropDateTime";
	public static final String ESAFE_BRINKS_ENV_TICKET_NUM="envelopeTicketNumber";
	public static final String ESAFE_BRINKS_DAY_RPT_NUM="dayReportNumber";
	public static final String ESAFE_BRINKS_CASHIER_ID="verifoneCashierId";
	public static final String ESAFE_BRINKS_DROP_TYPE="dropType";
	public static final String ESAFE_BRINKS_OVER_LMT_EVENT="overlimitEvents";
	public static final String ESAFE_BRINKS_EVENT_TIME="eventDateTime";
	public static final String ESAFE_BRINKS_OVER_LMT_AMT="overlimitAmount";
	public static final String ESAFE_BRINKS_AUDIT_NUM="auditNumber";



	//Start Acceptor, Acceptance Complete
	public static final String ESAFE_TIDEL_START_ACCEPTOR = "StartAcceptor";
	public static final String ESAFE_TIDEL_ACCEPTANCE_COMPLETE = "AcceptanceComplete";
	public static final String ESAFE_TIDEL_BILL_ACCEPTOR_STATUS ="BillAcceptorStatus";
	public static final String ESAFE_TIDEL_INDEX = "Index";
	public static final String ESAFE_TIDEL_ACCEPTANCE_STATUS = "Status";
	public static final String ESAFE_TIDEL_BILL_ACCEPTOR_STATUS_OK = "OK";
	public static final String ESAFE_TIDEL_BILL_ACCEPTOR_STATUS_JAMMED = "Jammed";
	public static final String ESAFE_TIDEL_BILL_ACCEPTOR_STATUS_CASSETTE_MISSING = "Cassette Missing";
	public static final String ESAFE_TIDEL_BILL_ACCEPTOR_STATUS_FULL = "Full";
	public static final String ESAFE_TIDEL_CASH_ACCEPTED = "CashAccepted";

	//Vault Drop, Vault Drop Complete
	public static final String ESAFE_TIDEL_VAULT_DROP = "VaultDrop";
	public static final String ESAFE_TIDEL_VAULT_DROP_MEDIA_TYPE = "MediaType";
	public static final String ESAFE_TIDEL_VAULT_DROP_MEDIA_COUNT = "MediaCount";
	public static final String ESAFE_TIDEL_VAULT_DROP_VALUE_IN_CENTS = "ValueInCents";
	public static final String ESAFE_TIDEL_VAULT_DROP_ENVELOP_NUMBER = "EnvelopeNumber";
	public static final String ESAFE_TIDEL_VAULT_DROP_MEDIA_TYPE_CASH = "Cash";
	public static final String ESAFE_TIDEL_VAULT_DROP_MEDIA_TYPE_CHECK = "Check";
	public static final String ESAFE_TIDEL_VAULT_DROP_MEDIA_TYPE_FOODSTAMP = "FoodStamps";

	public static final String ESAFE_TIDEL_VAULT_DROP_COMPLETE = "VaultDropComplete";
	public static final String ESAFE_TIDEL_VAULT_DROP_CHUTE_OPENED = "ChuteOpened";

	//Vend Tube, Vend Tube Complete
	public static final String ESAFE_TIDEL_VEND_TUBE = "VendTube";
	public static final String ESAFE_TIDEL_VEND_TUBE_COMPLETE = "VendTubeComplete";
	public static final String ESAFE_TIDEL_VEND_TUBE_COMPLETE_NAME = "Name";
	public static final String ESAFE_TIDEL_VEND_TUBE_COMPLETE_REGISTER= "Register";
	public static final String ESAFE_TIDEL_VEND_TUBE_COMPLETE_VALUE_IN_CENTS = "ValueInCents";
	public static final String ESAFE_TIDEL_VEND_TUBE_COMPLETE_ADJUSTED_VAL_IN_CENTS = "AdjustedValueInCents";
	public static final String ESAFE_TIDEL_VEND_TUBE_COMPLETE_SUCC_CODE_MALFUNC = "Malfunction";
	public static final String ESAFE_TIDEL_VEND_TUBE_COMPLETE_SUCC_CODE_DECLARED_BAD= "Declared Bad By User";
	public static final String ESAFE_TIDEL_VEND_TUBE_COMPLETE_SUCC_CODE_CANCELLED = "Cancelled";
	public static final String ESAFE_TIDEL_VEND_TUBE_COMPLETE_SUCC_CODE_OK = "OK";

	//Dispense Combo, Dispense Combo Complete
	public static final String ESAFE_TIDEL_DISPENSE_COINS = "DispenseCoins";
	public static final String ESAFE_TIDEL_DISPENSE_NOTES = "DispenseNotes";
	public static final String ESAFE_TIDEL_DISPENSE_COMBO = "DispenseCombo";
	public static final String ESAFE_TIDEL_VEND_TUBE_DISPENSE_CHOICE = "DispenseChoice";
	public static final String ESAFE_TIDEL_DISPENSE_COMBO_DENOMINATION = "Denomination";
	public static final String ESAFE_TIDEL_DISPENSE_COMBO_CURRENCY_CODE = "CurrencyCode";
	public static final String ESAFE_TIDEL_DISPENSE_COMBO_COIN_COUNT = "CoinCount";
	public static final String ESAFE_TIDEL_DISPENSE_COMBO_NOTE_COUNT = "NoteCount";

	public static final String ESAFE_TIDEL_DISPENSE_COMBO_COMPLETE = "ComboDispenseComplete";
	public static final String ESAFE_TIDEL_DISPENSE_COINS_COMPLETE = "DispenseCoinsComplete";
	public static final String ESAFE_TIDEL_DISPENSE_NOTES_COMPLETE = "NoteDispenseComplete";
	public static final String ESAFE_TIDEL_DISPENSE_COMBO_COMPLETE_TOT_VAL_IN_CENTS = "TotalValueInCents";
	public static final String ESAFE_TIDEL_DISPENSE_COMBO_COMPLETE_TOT_VAL = "TotalValue";
	public static final String ESAFE_TIDEL_DISPENSE_COMBO_COMPLETE_DISPENSED = "Dispensed";
	public static final String ESAFE_TIDEL_DISPENSE_COMBO_COMPLETE_SUCC_CODE_MALFUNC = "Malfunction";
	public static final String ESAFE_TIDEL_DISPENSE_COMBO_COMPLETE_SUCC_CODE_CANCELLED = "Cancelled";
	public static final String ESAFE_TIDEL_DISPENSE_COMBO_COMPLETE_CODE_OK = "OK";

	//Request Financial Info, Financial Information
	public static final String ESAFE_TIDEL_REQUEST_FINANCIAL_INFO = "RequestFinancialInfo";
	public static final String ESAFE_TIDEL_REQUEST_FINANCIAL_INFO_DAY_NUM = "DayNumber";
	public static final String ESAFE_TIDEL_REQUEST_FINANCIAL_INFO_SHIFT_NUM = "ShiftNumber";
	public static final String ESAFE_TIDEL_REQUEST_FINANCIAL_INFO_BY_EMP = "ByEmployee";

	public static final String ESAFE_TIDEL_FINANCIAL_INFO = "FinancialInformation";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_NAXML_AUTO_SAFE_RPT = "NAXML-AutoSafeReport";
	public static final String ESAFE_TIDEL_FINANCIAL_AUT0_SAFE_RPT_HEADER = "AutoSafeReportHeader";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_RPT_SEQ_NUM = "ReportSequenceNumber";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_PRIMARY_RPT_PERIOD = "PrimaryReportPeriod";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_SEC_RPT_PERIOD = "SecondaryReportPeriod";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_BEGIN_DATE = "BeginDate";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_BEGIN_TIME = "BeginTime";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_END_DATE = "EndDate";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_END_TIME = "EndTime";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_AUTO_SAFE_DETAIL = "AutoSafeDetail";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_ATTR_SEAL = "SEAL";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_BUSINESS_DAY_INFO = "BusinessDayInfo";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_DAY_SUMMARY = "DaySummary";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_CHANGE_FUND = "ChangeFund";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_DISPENSER = "Dispenser";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_VAL_ROLL_AMT = "ValuePerRollAmount";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_CHANGE_ADDED_AMT = "ChangeAddedAmount";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_CHANGE_DISP_AMT = "ChangeDispensedAmount";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_ROLLS_AMT = "RollsAmount";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_TOT_VAL_AMT = "TotalValueAmount";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_ATTR_NUMBER = "number";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_CHANGE_BOUGHT_AMT = "ChangeBoughtAmount";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_TOT_ADDED_AMT = "TotalAddedAmount";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_TOT_DISP_AMT = "TotalDispensedAmount";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_CASH_ADDED_AMT = "CashAddedAmount";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_CHANGE_FUND_TOT_AMT = "ChangeFundTotalAmount";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_ENVELOP_DRP = "EnvelopeDrop";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_CASH_AMT = "CashAmount";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_CHECKS_AMT = "ChecksAmount";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_CREDIT_CARD_AMT = "CreditCardsAmount";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_MAN_RECEIPT_AMT = "ManualReceiptsAmount";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_COUPONS_AMT = "CouponsAmount";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_LOTTERY_AMT = "LotteryAmount";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_FOOD_STAMPS_AMT = "FoodStampsAmount";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_MISC_AMT = "MiscellaneousAmount";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_ENV_DROP_TOT_AMT = "EnvelopeDropTotalAmount";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_BILL_READERS = "BillReaders";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_CHANGE_BILL_READER_AMT = "ChangeBillReadersAmount";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_DEPOSIT_BILL_READER_AMT = "DepositBillReadersAmount";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_UNKNOWN_BILLS = "UnknownBills";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_ATTR_CASHIER_NUM = "cashierNumber";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_ATTR_NAME = "name";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_DOORS ="Doors";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_SHIFT_SUMMARY = "ShiftSummary";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_SHIFT = "Shift";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_RANGE = "Range";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_START_TIME = "startTime";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_RANGE_END_TIME = "endTime";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_USER = "User";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_CHECK_DROP_COUNTS = "CheckDropCounts";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_REGISTER= "Register";
	public static final String ESAFE_TIDEL_FINANCIAL_INFO_REGISTER_NUM = "number";

	//EndOfDay, EndOfDayComplete
	public static final String ESAFE_TIDEL_END_OF_DAY = "EndOfDay";
	public static final String ESAFE_TIDEL_END_OF_DAY_NUMBER = "DayNumber";
	public static final String ESAFE_TIDEL_END_OF_DAY_VERSION = "version";
	public static final String ESAFE_TIDEL_END_OF_DAY_COMPLETE = "EndOfDayComplete";
	public static final String ESAFE_TIDEL_END_OF_DAY_COMPLETE_SUCCESS_CODE = "SuccessCode";
	public static final String ESAFE_TIDEL_END_OF_DAY_COMPLETE_SUCC_CODE_OK = "OK";
	public static final String ESAFE_TIDEL_END_OF_DAY_COMPLETE_SUCC_CODE_DUP_DAY_NUM = "Duplicate Day Number";
	public static final String ESAFE_TIDEL_END_OF_DAY_COMPLETE_SUCC_CODE_RECENT = "Too Recent";

	//EndOfShift, EndOfShiftComplete
	public static final String ESAFE_TIDEL_END_OF_SHIFT = "EndOfShift";
	public static final String ESAFE_TIDEL_END_OF_SHIFT_TIME = "EndTime";
	public static final String ESAFE_TIDEL_END_OF_SHIFT_USER_NAME = "UserName";
	public static final String ESAFE_TIDEL_END_OF_SHIFT_COMPLETE ="EndOfShiftComplete";
	public static final String ESAFE_TIDEL_END_OF_SHIFT_COMPLETE_SUCCESS_CODE = "SuccessCode";

    //For ESafe Cashier Reports
    public static final String ESAFE_CASHIER_PD = "eSafeCashierPd";
    public static final String TOTALS_BY_SAFE = "totalsBySafe";
    public static final String ESAFE_V1_CASHIER_PD = "v1:eSafeCashierPd";
    public static final String ENVELOP_BY_MOP = "envelopeByMop";
    public static final String CASSETT_BY_MOP = "cassetteByMop";
    public static final String CHANGEVEND_BY_MOP = "changeVendByMop";
    public static final String PAYOUTS_BY_MOP = "payoutsByMop";
    public static final String CHANGE_FUND_DEPOSIT_BY_MOP_CASH_TYPE = "cashType";
    public static final String CHANGE_FUND_DEPOSIT_CASH_TYPE_COINS = "COINS";
    public static final String CHANGE_FUND_DEPOSIT_CASH_TYPE_TUBES = "TUBES";
    public static final String CASHIER_SHIFT_REPORT_NUMBER = "cashierShiftReportNumber";
    public static final String ENVELOP_COUNT = "envelopeCount";
    public static final String UNVERIFIED_CASH_RATIO = "unverifiedCashRatio";
    public static final String UNRECOGNIZED_BILL_COUNT = "unrecognizedBillCount";
    public static final String DROPS_BY_SAFE = "dropsBySafe";
    public static final String LOANS_BY_SAFE = "loansBySafe";

    public static final String SEQ_NUM = "seqNum";
    public static final String OPEN_DATE = "openDate";
    public static final String CLOSE_DATE = "closeDate";
    public static final String PERIOD_BEGIN_DATE = "periodBeginDate";
    public static final String PERIOD_END_DATE = "periodEndDate";
    //Esafe  EOD REPORTS

	public static final String ESAFE_EOD_REPORT = "eSafeDayPd";
	public static final String ESAFE_CASHIER_REPORT = "eSafeCashierPd";
	public static final String ESAFE_DAY_PD = "pd:eSafeDayPd";
	public static final String ESAFE_EOD_DESC = "description";
	public static final String ESAFE_EOD_REPORT_NUMBER = "dayReportNumber";
	public static final String ESAFE_EOD_START_SHIFT_NUMBER = "startShiftNumber";
	public static final String ESAFE_EOD_END_SHIFT_NUMBER = "endShiftNumber";
	public static final String ESAFE_EOD_CAT2SALES_AMOUNT = "cat2SalesAmount";
	public static final String ESAFE_EOD_CHANGE_FUND_DEPOSIT_BY_MOP = "changeFundDepositByMoP";
	// Esafe Content Report
    public static final String ESAFE_DOMAIN_NS   = "v1";
    public static final String ESAFE_DOMAIN_NS1   = "ns1";


    // ECheck Configuration strings
    public static final String ECHK_CFG 			= "eCheckConfig";
    public static final String ECHK_TRANS_IP_ADDR 		= "transactionIPAddress";
    public static final String ECHK_TRANS_PORT_NUM 		= "transactionPortNumber";
	public static final String ECHK_IMAGE_HOST			= "imageHost";
	public static final String ECHK_IMAGE_IP			= "imageIPAddress";
	public static final String ECHK_IMAGE_PORT_NUM 		= "imagePortNumber";
	public static final String ECHK_CAPTURE_CHECK_IMAGE	= "captureCheckImage";
    public static final String ECHK_MERCH_ID 			= "merchantID";
    public static final String ECHK_MERCH_NAME 			= "merchantName";
    public static final String ECHK_MERCH_ADDR 			= "merchantAddress";
    public static final String ECHK_MERCH_CITY 			= "merchantCity";
    public static final String ECHK_MERCH_STATE 		= "merchantState";
    public static final String ECHK_MERCH_ZIP 			= "merchantZip";
    public static final String ECHK_MERCH_PHONENR 		= "merchantPhone";
    public static final String ECHK_PROC_PHONEHR 		= "processorPhone";
    public static final String ECHK_TRAILER_LINE1 		= "trailerLine1";
    public static final String ECHK_TRAILER_LINE2 		= "trailerLine2";
    public static final String ECHK_TRAILER_LINE3 		= "trailerLine3";
    public static final String ECHK_TRAILER_LINE4 		= "trailerLine4";
    public static final String ECHK_OFFER_CUST_ECA 		= "offerCustomerECA";
    public static final String ECHK_ALLOW_DUAL_ID_PRMPT	= "allowDualIDSwipePrompt";
    public static final String ECHK_SUPP_ID_PRMPT 		= "supplementIDPrompt";
    public static final String ECHK_DATE_BIRTH_PRMPT 	= "dateBirthPrompt";
    public static final String ECHK_WRITER_NAME_PRMPT 	= "checkWriterNamePrompt";
    public static final String ECHK_WRITER_ADDR_PRMPT 	= "checkWriterAddressPrompt";
    public static final String ECHK_WRITER_INIT_PRMPT	= "checkWriterInitialsPrompt";
    public static final String ECHK_DUALID_FLOOR_LIMIT 	= "dualIDFloorLimit";
    public static final String ECHK_PHONENR_PRMPT_LIMIT = "phoneNumPromptLimit";
    public static final String ECHK_RESP_TIMEOUT		= "responseTimeOut";
    public static final String ECHK_CLOSE_PERIOD		= "closePeriod";

        // ECheck Report strings
    public static final String ECHECK_PD                = "eCheckPd";
    public static final String ECHECK_MERCHANT_ID       = "merchantId";
    public static final String ECHECK_MERCHANT_NAME     = "merchantName";
    public static final String ECHECK_BATCH_NUMBER      = "batchNumber";
    public static final String ECHECK_BATCH_RECONCILED  = "batchReconciled";
    public static final String ECHECK_ECA_TOTALS        = "ecaTotals";
    public static final String ECHECK_NON_ECA_TOTALS    = "nonEcaTotals";
    public static final String ECHECK_DECLINE_TOTALS    = "declineTotals";
    public static final String ECHECK_DETAILS           = "details";
    public static final String ECHECK_BATCH_TRANS_NUM   = "batchTransNumber";
    public static final String ECHECK_TRAN_TYPE         = "tranType";
    public static final String ECHECK_DATE_TIME         = "dateTime";
    public static final String ECHECK_TRACE_ID          = "traceID";
    public static final String ECHECK_TRANSIT_NUM       = "transitNumber";
    public static final String ECHECK_ACCOUNT_NUM       = "accountNum";
    public static final String ECHECK_CHECK_NUM         = "checkNumber";
    public static final String ECHECK_APPROVAL_CODE     = "approvalCode";
    public static final String ECHECK_REGISTER_NUMBER   = "registerNumber";
    public static final String ECHECK_CASHIER_NUMBER    = "cashierNumber";
    public static final String ECHECK_TICKET_NUMBER     = "ticketNumber";

    //viptconfig and uiptconfig

    public static final String IPT_ALLOWED_MOPS			= "iptAllowedMOPs";
    public static final String IPT_ALLOWED_MOP 			= "iptAllowedMOP";

    public static final String IPT_SITE_CFG 			= "IPTSiteConfig";

    public static final String IPT_SITE_PARAMS  		= "IPTSiteParams";
    public static final String IPT_CASHIERLOGINPROMPT 	= "cashierLoginPrompt";
    public static final String IPT_NUMRECEIPTCOPIES 	= "numReceiptCopies";
    public static final String IPT_LASTCONFDCRNUMBER 	= "lastConfDCRNumber";
    public static final String IPT_INVOICEENABLED		= "invoiceEnabled";
    public static final String IPT_PRINTCASHRECEIPT 	= "printCashReceipt";
    public static final String IPT_PRESETSECURITY 		= "presetSecurity";
    public static final String IPT_SERVICELEVEL 		= "serviceLevel";
    public static final String IPT_ALLOWBYPUMPNUMBER 	= "allowByPumpNumber";
    public static final String IPT_COMPANYNAME 			= "companyName";
    public static final String IPT_RUCNUMBER 			= "RUCNumber";
    public static final String IPT_AUTHNUMBER 			= "authNumber";
    public static final String IPT_AUTHEXPIRATIONDATE 	= "authExpirationDate";
    public static final String IPT_FLEETENABLEDPERPUMPS = "fleetEnabledPerPumps";
    public static final String IPT_FLEETENABLEDPERPUMP 	= "fleetEnabledPerPump";
    public static final String IPT_PUMPTESTSECURITY 	= "pumpTestSecurity";
    public static final String IPT_DRIVEOFFSECURITY 	= "driveOffSecurity";
    public static final String IPT_RCPT_HDR  			= "receiptHeader";
    public static final String IPT_HDR_LINE  			= "receiptHeaderLine";
    public static final String IPT_RCPT_TRL  			= "receiptTrailer";
    public static final String IPT_TRL_LINE  			= "receiptTrailerLine";
    public static final String IPT_RCPT_ATTRS  			= "receiptAttributes";
    public static final String IPT_RCPT_ATTR  			= "receiptAttribute";

    public static final String IPT_RCPT_TYPE  			= "receiptType";
    public static final String IPT_RCPT_PREFIX 			= "prefixNumber";
    public static final String IPT_RCPT_SEQNUM 			= "seqNumber";

    public static final String IPT_CASHIERLOGIN_NEVER	= "NEVER";
    public static final String IPT_CASHIERLOGIN_ALWAYS	= "ALWAYS";
    public static final String IPT_CASHIERLOGIN_ONCE	= "ONCE";

    public static final String IPT_SERVICELEVEL_ALL		= "ALL";
    public static final String IPT_SERVICELEVEL_FULL	= "FULL";
    public static final String IPT_SERVICELEVEL_SELF	= "SELF";

    public static final String IPT_POSITIONS 			= "IPTPositions";
    public static final String IPT_POSITION 			= "IPTPosition";
    public static final String IPT_ACCESS 				= "access";
    public static final String IPT_PINPADTYPE 			= "pinpadType";
    public static final String IPT_PRINTERTYPE 			= "printerType";
    public static final String IPT_ALLOWEDMOPSONIPT 	= "allowedMopsOnIpt";
    public static final String IPT_ALLOWEDMOPONIPT 		= "allowedMopOnIpt";
    public static final String IPT_TERMINALTYPE 		= "terminalType";
    public static final String IPT_TRANSACTIONTYPE 		= "transactionType";
    public static final String IPT_FUELRESTRICTION 		= "fuelRestriction";
    public static final String IPT_PUMPSALLOWEDONIPT 	= "pumpsAllowedOnIpt";
    public static final String IPT_PUMPALLOWEDONIPT 	= "pumpAllowedOnIpt";
    public static final String IPT_DISPLAYSEQ		 	= "displaySequence";
    public static final String IPT_DISPLAYSEQ_PRIMARY 	= "PRIMARY";
    public static final String IPT_DISPLAYSEQ_SECONDARY	= "SECONDARY";

    public static final String IPT_PINPADTYPE_1000		= "1000";
    public static final String IPT_PINPADTYPE_5000		= "5000";
    public static final String IPT_PINPADTYPE_5000b		= "5000b";
    public static final String IPT_PINPADTYPE_SC542		= "SC542";
    public static final String IPT_PINPADTYPE_SC552		= "SC552";
    public static final String IPT_PINPADTYPE_NONE		= "NONE";

    public static final String IPT_PRINTERTYPE_EXTERNAL	= "External";
    public static final String IPT_PRINTERTYPE_FISCAL	= "Fiscal";
    public static final String IPT_PRINTERTYPE_INTERNAL	= "Internal";
    public static final String IPT_PRINTERTYPE_P255		= "P255";
    public static final String IPT_PRINTERTYPE_P900		= "P900";


    public static final String IPT_TERMINALTYPE_GENERIC	= "Generic";
    public static final String IPT_TERMINALTYPE_OMNI	= "OMNI";
    public static final String IPT_TERMINALTYPE_Vx5XX   = "Vx 5XX";
    public static final String IPT_TERMINALTYPE_Vx610	= "Vx 610";


    public static final String IPT_TRANSACTIONTYPE_POSTPAY	= "Postpay Only";
    public static final String IPT_TRANSACTIONTYPE_PREPAY 	= "Prepay Only";
    public static final String IPT_TRANSACTIONTYPE_BOTH 	= "Prepay and Postpay";


    //vcngconfig and ucngconfig
    public static final String CNGSITE 					= "CNGSite";
    public static final String CNGSITEPARAMS 			= "CNGSiteParams";
    public static final String CNG_VALIDATIONMETHODS 	= "validationMethods";
    public static final String CNG_VALIDATIONMETHOD 	= "validationMethod";
    public static final String CNG_DATABASEIPADDRESS 	= "databaseIPAddress";
    public static final String CNG_DATABASEPORT 		= "databasePort";
    public static final String CNG_DATABASEUPDATEHOUR  	= "databaseUpdateHour";
    public static final String CNG_IBUTTONMODE 			= "iButtonMode";
    public static final String CNG_FTPUSERNAME 			= "ftpUserName";
    public static final String CNG_FTPPASSWORD 			= "ftpPassword";
    public static final String CNGPOSITIONS 			= "CNGPositions";
    public static final String CNGPOSITION 				= "CNGPosition";
    public static final String MAX_RECORDS 				= "maxRecords";
    public static final String MAX_FEES_PER_ITEM 		= "maxFeesPerItem";
//	misc department setting
    public static final String NET_DEPARTMENT_CFG="netDepartmentConfig" ;

//  SiteAsset Data
    public static final String SITE_ASSET_NS = "urn:vfi-sapphire:asset.2009-04-09";
    public static final String SITE_ASSET_NS_PREFIX = "asset";
    public static final String SITE_ASSET_DATA = "siteAssetData";
    public static final String DATE_TIME_STAMP = "dateTimeStamp";
    public static final String SITE_DETAILS = "siteDetails";
    public static final String POS_TERMINALS = "posTerminals";
    public static final String POS_TERMONAL = "posTerminal";
    public static final String VENDOR = "vendor";
    public static final String MODEL = "model";
    public static final String SOFTWARE_VERSION = "softwareVersion";
    public static final String FIRMWARE_VERSION = "firmwareVersion";
    public static final String OS_VERSION = "osVersion";
    public static final String HARDWARE_VERSION = "hardwareVersion";
    public static final String APPLICATION_START_TIME = "applicationStartTime";
    public static final String MIDDLEWARE_COMPONENTS = "middlewareComponents";
    public static final String MIDDLEWARE = "middleware";
    public static final String PERIPHERALS = "peripherals";
    public static final String DEVICE = "device";
    public static final String PIN_DEVICE = "pinDevice";
    public static final String PERIPHERAL = "peripheral";
    public static final String CONNECTION = "connection";
    public static final String INTEGRATED = "integrated";
    public static final String PRIMARY_DEVICE = "primaryDevice";
    public static final String KEY_MANAGEMENT = "keyManagement";
    public static final String ENCRYPTION = "encryption";
    public static final String INTEGRATED_CONTACTLESS_READER = "integratedContactlessReader";
    public static final String PIN_ENTRY = "PINENTRY";
    public static final String DISPENSER_DATA = "dispenserData";
    public static final String DISPENSER_INTERFACE = "dispenserInterfaceHardware";
    public static final String DISPENSER = "dispenser";
    public static final String STAND_ALONE_DEVICE = "standAloneDevices";
    public static final String BLENDER = "blender";
    public static final String SITEID = "siteId";
    public static final String ADDRESS_LINE = "addressLine";
    public static final String ADDRESS = "address";
    public static final String CITY = "city";
    public static final String STATE = "state";
    public static final String ZIP = "zip";
    public static final String PHONE_NUMBER = "phoneNumber";
    public static final String SITE_BRAND = "siteBrand";
    public static final String ATTENDED_OPERATION = "attendedOperation";

    //Fuel Price Info Report
    public static final String FUELPRICEPD = "fuelPricePd";
    public static final String FUELTOTALS = "fuelTotals";
	public static final String PREVIOUSPRICE = "previousPrice";
	public static final String CURRENTPRICE = "currentPrice";
	public static final String FUELPRICECHANGEPD = "fuelPriceChangePd";

    //DATABASE BACKUP
    public static final String EXTENSION = "Extension";
    public static final String NETWORKDB = "networkDB";
    public static final String TOTALSDB = "totalsDB";
    public static final String PERIOD_DATA = "periodData";
    public static final String CASHIER_PERIOD_DATA = "cashierPeriodData";
    public static final String CW_PAYPOINT_PERIOD_DATA = "cwPaypointPeriodData";
    public static final String PAYROLL_PERIOD_DATA = "payrollPeriodData";
    public static final String PERIOD_BASED_DATA = "periodBasedData";
    public static final String FUELPRICECHANGE_TOTALS = "fuelPriceChangeTotals";


    //SafeDropDetail Report
    public static final String SAFEDROP_PD = "safedropPd";
    public static final String CORRECTION = "correction";
    public static final String TICKET_NUMBER = "ticketNumber";
    public static final String SAFEDROP_EVENT = "safedropEvent";
    public static final String DROP_TIME = "dropTime";
    public static final String REF_NUM = "refNum";
    public static final String SAFEDROP_INFO = "safeDropInfo";
    public static final String DROP_CANCEL_COUNT = "dropCancelCount";

    //Security Log server configuration
    public static final String SECURITY_LOGSERVER_CFG = "securityLogServerConfig";
    public static final String SECURITY_LOGSERVER_ADDRESS = "ipAddress";
//	String added for scanned coupon
	public static final String COUPON_DATA = "couponData";
	public static final String SCANNED_COUPON = "scannedCoupon";
	public static final String COUPON_SITE_PARAMS                   = FUEL_SITE_PARAMS;
	public static final String COUPON_PROCESSING_LEVEL = "couponProcessingLevel";
    public static final String COUPON_ALLOWS_NEGATIVE_TRANS_TOTAL = "allowNegativeTransTotal";
//	String added for scanned coupon
    // BlendProduct Report
    public static final String BLEND_REPORT = "blendPd";
    public static final String BLEND_INFO = "blendInfo";
    public static final String FP_VOLUME = "fpVolume";
    public static final String FP_TOTAL_VOLUME = "fpTotalVolume";
    public static final String DISP_VOLUME = "dispVolume";
    public static final String PROD_INFO = "prodInfo";
    public static final String BY_PROD_INFO = "byProdInfo";
    public static final String BY_FP_INFO = "byFpInfo";
    public static final String FIRST_TANK_ID = "firstTankID";
    public static final String SECOND_TANK_ID = "secondTankID";
    public static final String FIRST_TANK_NAME = "firstTankName";
    public static final String SECOND_TANK_NAME = "secondTankName";
    public static final String FIRST_TANK_PERCENT = "firstTankPercent";
    public static final String SECOND_TANK_PERCENT = "secondTankPercent";
    public static final String BLEND_PRODUCT_BACKUP = "blendProductBackup";
    public static final String BLEND_PERCENT_BACKUP = "blendPercentBackup";
    public static final String BLEND_PRODUCT_TOTALS = "blendProductTotals";
    public static final String DISCOUNT_STR =      "discount";
    public static final String DATETIME = "dateTime";
    public static final String TIME = "time";
    public static final String DAY_OF_WEEK = "dayOfWeek";
    public static final String GROUPS = "groups";
    public static final String GROUP = "group";
    public static final String REPORT_NAME = "reportName";
    public static final String GROUP_MASTER_LIST = "groupsMasterList";
    public static final String REPORT_NAME_ML = "reportNameML";
    public static final String PERIOD1 = "Period1";
    public static final String PERIOD2 = "Period2";
    public static final String PERIOD3 = "Period3";
    public static final String PERIOD4 = "Period4";
    public static final String REPORTS = "reports";
    public static final String REPORT = "report";
    public static final String REPORT_CMD = "reportCMD";
    public static final String REPORT_PERIOD = "reportPeriod";
    public static final String REPORT_PERIODS = "reportPeriods";
    public static final String REPORT_HTML = "reportHTML";
    public static final String REPORT_COOKING = "reportCooking";
    public static final String COOKING_STEP = "cookingStep";
    public static final String USER_PARAMETER = "userParameter";
    public static final String UI_LABEL = "uiLabel";
    public static final String UI_LIST = "uiList";
    public static final String REPORT_GZIP = "reportGZip";
    public static final String REPORT_GROUP = "reportGroup";
    public static final String SOURCE = "source";
    //common elements
    public static final String ROW = "row";
    public static final String COL = "col";
    public static final String POSITION = "position";
    public static final String ZONED_FUEL_CONTROL = "zonedFuelControl";
    //elements for Fuel panel
    public static final String CREATION_DATE = "creationDate";
    public static final String UNASSIGNED_KEY_COLOR_ID = "unassignedkey_clrGrfxCombo_ID";
    // CR3306 SK_1
    public static final String INACTIVE_KEY_COLOR_ID = "inactive_clrGrfxCombo_ID";
    public static final String REGISTER_ID = "registerId";
    public static final String SCREEN = "screen";
    public static final String SCREEN_NAME = "screenName";
    
    // New elements added for PYTHON 
    public static final String SCREENS = "screens";
    public static final String INCLUDEFUEL = "includeFuel";
    public static final String INCLUDEPARKEDMENU = "includeParkedMenu";
    public static final String PANELCFG = "panelCfg";
    public static final String ITEMPANELS = "itemPanels";
    public static final String ITEMPANEL = "itemPanel";
    public static final String FUELDETAILPANEL = "fuelDetailPanel";
    public static final String LABELTEXT = "labelText";
    public static final String LABELCOLOR = "labelColor";
    public static final String BUTTON_LABELTEXT_ID_ONE = "1";
    public static final String BUTTON_LABELTEXT_ID_TWO = "2";
    public static final String BUTTONID = "buttonId";
    public static final String SCREENID = "screenId";
    public static final String PANEL = "panel";
    public static final String SCREENCFG = "screenCfg";
    public static final String RULE_SCREENCFG = "sc:screenCfg";
    public static final String RULE_FUELBUTTON = "sc:fuelButton";
    
    public static final String RECEIPT_LOCATION = "receiptLocation";
    public static final String FUEL_PANEL = "fuelPanel";
    
    public static final String TOP = "top";
    public static final String BOTTOM = "bottom";
    public static final String LEFT = LEFT_JUSTIFY;
    public static final String RIGHT = RIGHT_JUSTIFY;
    public static final String IS_SPLIT_COLUMN = "isSplitColumn";
	public static final String ONE_TOUCH_APPROVE = "oneTouchApprove";
	public static final String ONE_TOUCH_CLAIM = "oneTouchClaim";
    public static final String ROW_COUNT = "rowCount";
    public static final String COLUMNS_PER_ROW = "columnsPerRow";
    public static final String COLUMN_COUNT = "columnCount";
    public static final String FUEL_BUTTON = "fuelButton";
    public static final String RULE_FUELPANEL_INFO = "sc:fuelPanelInfo";
    public static final String RULE_ITEMPANELINFO = "sc:itemPanelInfo";
    public static final String RULE_PARKEDMENUPANELINFO = "sc:parkedMenuPanelInfo";    
    public static final String FUELPANELINFO = "fuelPanelInfo";
    public static final String ITEMPANELINFO = "itemPanelInfo";
    public static final String PARKEDMENUPANELINFO = "parkedMenuPanelInfo";    
    public static final String RULE_POSSCREENCFG = "sc:posscreenCfg";    
    
    //elements for ParkedMenuPanel
    public static final String PARKED_MENU_PANEL = "parkedMenuPanel";
    public static final String DEFAULT_PARKED_MENU = "defaultParkedMenu";
    public static final String BEGIN_POSITION = "beginPosition";
    public static final String END_POSITION = "endPosition";
    //elements for Item Panel buttons
    public static final String PLU_BUTTON = "pluButton";
    public static final String DEP_BUTTON = "depButton";
    public static final String MENU_BUTTON = "menuButton";
    public static final String MOP_BUTTON = "mopButton";
    public static final String FUNCTION_BUTTON = "functionButton";
    public static final String PREPAY_BUTTONS = "prepayButtons";
    public static final String PREPAY_BUTTON = "prepayButton";
    public static final String PREPAY_AMOUNT = "prepayAmount";
	// Element for storing the default rows number
	public static final String DEFAULTROWS = "defaultRows";

    // CR3306 SK_1
    public static final String INACTIVE_FLAG = "inactive";
    public static final String COLOR_ID = "clrGrfxCombo_ID";
    public static final String TEXT_LINE1 = "textLine1";
    public static final String TEXT_LINE2 = "textLine2";
    public static final String ITEM_ID = "itemId";
    public static final String SOFTKEY_TYPE = "softkeyType";
    //elements for expanded menu
    public static final String EXPANDED_MENU_SCREEN = "expandedMenuScreen";
    public static final String COLOR_SCHEME = "colorScheme";
    public static final String ENCODING = "encoding";
    public static final String THEME_CFG = "themecfg";
    public static final String MAX_SCREENS = "maxScreens";
    public static final String CLR_GRFX = "clrGrfx";
    public static final String FORE_COLOR = "foreColor";
    public static final String FORE_COLOR_RGB = "foreColorRGB";
    public static final String SOUND = "sound";
    public static final String USE = "use";

    //Menu configuration
    public static final String MAX_RUBY_MENU_ITEMS = "maxRubyMenuItems";
    public static final String MAX_EXPANDED_MENU_ITEMS = "maxExpandedMenuItems";
    public static final String MAX_MENU_CHAIN_ITEMS = "maxMenuChainItems";

    //Item price check
    public static final String PRICE_CHECK_CANCEL_ITEM = "priceCheckCancelItem";
    public static final String TRL_MODIFIER = "trlModifier";
    public static final String TRL_UPC = "trlUPC";
    public static final String TRL_DESC = "trlDesc";
    public static final String TRL_LINE_TOT = "trlLineTot";
    public static final String TRL_QTY = "trlQty";
    //elements for PLU
    public static final String QUERY = "query";
    public static final String PAGE_SIZE = "pageSize";
    public static final String PAGE = "page";
    public static final String AND = "and";
    public static final String OR = "or";
    public static final String KIND = "kind";
    public static final String ORDER_BY = "orderby";
    public static final String PROD_CODE = "pcode";
    public static final String PLU_ITEM_DESCRIPTION = "description";
    public static final String PLU_SELECT = "PLUSelect";
    public static final String PLU_NUMBER = "PLUNumber";
    public static final String PLU_MODIFIER = "PLUModifier";
    public static final String PLU_PRODUCT_CODE = "PLUProductCode";
    public static final String PLU_DEPARTMENT = "PLUDepartment";
    public static final String PLU_DESCRIPTION = "PLUDescription";
	public static final String PLUS = "PLUs";
	public static final String CLEAR_ALL_PLUS = "clearAllPLUs";
	public static final String DELETE_PLU = "deletePLU";
	public static final String FLAG = "flag";
	public static final String ID_CHECKS = "idChecks";
	public static final String SELL_UNIT = "SellUnit";
    //elements for vMaintenance&dataset=item
    public static final String NAXML_MAINT_REQUEST = "NAXML-MaintenanceRequest";
	public static final String ITTDETAIL = "ITTDetail";
	public static final String RECORD_ACTION = "RecordAction";
	public static final String RECORD_ACTION_ADD_CHANGE = "addchange";
    public static final String MAINTENANCEGET_TABLEACTION_DEFAULT = "initialize";
	public static final String RECORD_ACTION_DELETE = "delete";
	public static final String POS_CODE_FORMAT = "POSCodeFormat";
	public static final String FORMAT = "format";
	public static final String POS_CODE = "POSCode";
	public static final String POS_CODE_MODIFIER = "POSCodeModifier";
	public static final String ACTIVE_FLAG = "ActiveFlag";
	public static final String MERCHANDISE_CODE = "MerchandiseCode";
	public static final String REGULAR_SELL_PRICE = "RegularSellPrice";
	public static final String NAXML_ITEM_DESCRIPTION = "Description";
	public static final String NAXML_ITEM_ID = "ItemID";
	public static final String PAYMENT_SYSTEM_PROD_CODE = "PaymentSystemsProductCode";
	public static final String SALES_RESTRICT_CODE = "SalesRestrictCode";
	public static final String SELLING_UNITS = "SellingUnits";
	public static final String TAX_STRATEGY_ID = "TaxStrategyID";
	public static final String PRICE_REQUIRED_FLAG = "PriceRequiredFlag";
	public static final String FEE_NUMBER = "FeeNumber";
	public static final String FLAG_ARTICLE_PROMO = "FlagArticlePromo";
	public static final String FLAG_ARTICLE_NORETURN = "FlagArticleNoReturn";
	public static final String FLAG_ARTICLE_FOODSTAMP = "FlagArticleFoodStamp";
	public static final String FLAG_ARTICLE_SPECIAL_DISCOUNT = "FlagArticleSpecialDiscount";
	public static final String FLAG_ARTICLE_DEPT_FRAC_QTY = "FlagArticleDepartmentFractionalQuantity";
	public static final String FLAG_DEPT_SPECIAL_DISC = "FlagDepartmentSpecialDiscount";
	public static final String FLAG_DEPT_FOODSTAMP = "FlagDepartmentFoodStamp";
	public static final String FLAG_ARTICLE_LOTTO = "FlagArticleLotto";
	public static final String FLAG_ARTICLE_POPUP = "FlagArticlePopup";
	public static final String FLAG_ARTICLE_SN_PROMPT = "FlagArticleSNPrompt";
	public static final String FLAG_ARTICLE_PRDISC = "FlagProhibitDiscount";
	public static final String BLUELAW1 = "BlueLaw1";
	public static final String BLUELAW2 = "BlueLaw2";
	public static final String TAXABLE_REBATE_ELEMENT = "taxableRebate";
	public static final String TAXABLE_REBATE_AMOUNT = "amount";
	public static final String TAXABLE_REBATE_TAX = "taxRate";
	public static final String NAXML_TAXABLE_REBATE_ELEMENT = "TaxableRebate";
	public static final String NAXML_TAXABLE_REBATE_AMOUNT = "Amount";
	public static final String NAXML_TAXABLE_REBATE_TAX = "Tax";
	public static final String NAXML_SALES_RESTRICTION = "SalesRestriction";
	public static final String NAXML_TRANSACTION_LIMIT = "TransactionLimit";

	public static final String PLU_GROUP_CODE = "groupCode";
	public static final String PLU_GROUP_ID = "type";
	public static final String PLU_GROUP_INDEX = "index";
	
	public static final String PLU_ITT_GROUPCODES = "ITTGroupCodes";
	public static final String PLU_NAXML_GROUPCODE = "GroupCode";
	
	public static final String TRANSM_HDR = "TransmissionHeader";
	public static final String STORELOCN_ID = "StoreLocationID";
	public static final String VENDOR_NAME = "VendorName";
	public static final String VENDOR_MOD_VER = "VendorModelVersion";

	public static final String ITEM_MAINTENANCE = "ItemMaintenance";
	public static final String TABLE_ACTION = "TableAction";
	public static final String TABLE_ACTION_UPDATE = "update";
	public static final String ITEM_CODE = "ItemCode";
	public static final String ITT_DATA = "ITTData";
	public static final String ITEM_TYPE = "ItemType";

	/** Namespace for ESign vocabulary elements
	 */
	public static final String FPD_NS = "urn:vfi-sapphire:fuelPriceDisplay.2005-03-15";
	public static final String FPD_NS_PREFIX = "fpd";
	public static final String FPD_CONFIG = "fuelPriceDisplay";
	public static final String ENABLE = "enable";
	public static final String ENABLE_UC = "ENABLE";
	public static final String PORTID = "comPortID";

	public static final String PRODUCT_MAPPINGS = "productMappings";
	public static final String PROD_MAPPING = "prodMapping";
	public static final String SRVLVL = "srvLvl";
	public static final String PRCLVL = "prcLvl";
	public static final String SYSID = "prodSysid";
	public static final String TRPCC_SYSID = "sysid";
	public static final String PRODID = "fpdProdID";
	public static final String DECIMAL = "impliedDecimal";
	public static final String PROD_ENABLED = "enabled";

	public static final String TEXTGROUP = "textGroup";
	public static final String TEXT = "text";
	public static final String TEXTID = "textID";
	public static final String ITEM_TYPE_CODE = "ItemTypeCode";
    public static final String ITEM_TYPE_SUBCODE = "ItemTypeSubCode";
    public static final String YES_STRING = "yes";
    public static final String NO_STRING = "no";
    public static final String OK_STRING = "Ok";

    public static final String PLU_COPY_PROGRESS_STATUS = "pluCopyProgressStatus";
    public static final String STATUS = "status";
    public static final String PERCENT_COMPLETE = "percentComplete";

    //For Cmds vnetposcfg & unetposcfg
    public static final String NETPOS_PREFIX = "netpos";
	public static final String NETPOS_NS = "urn:vfi-sapphire:np.network.netpos.2011-11-23";
    public static final String NETPOSCFG = "netPosConfig";
	public static final String ENABLED = "enabled";
	public static final String MULTIPLELOYALTYENABLED = "multipleLoyaltyEnabled";
	public static final String AUTH_ON_TOTAL = "authOnTotalKey";
	public static final String LOYALTY_TAKES_PRECEDENCE = "loyaltyTakesPrecedenceInPopDiscount";
	public static final String FORCE_CASH_RECEIPT = "forceCashReceipt";
	public static final String MISC_CFG = "miscConfig";
	public static final String MSG_DISP_DURATION = "msgDispDuration";
	public static final String PRINT_CUSTOMER_COPY = "printCustomerCopy";
	public static final String NET_BATCH_CFG = "netBatchConfig";

    // XML element names for Features list - CGI cmd=vfeaturelist
    public static final String SCFEAT_NS = "urn:vfi-psc:sc.feature.2012-04-04";
    public static final String SCFEAT = "scfeat";
    public static final String FE_FEATURELIST = "featurelist";
    public static final String FE_FEATURE    = "feature";
    public static final String FE_INSTALLED  = "Installed";
    public static final String FE_NOTINSTALLED  = "NotInstalled";
    public static final String FE_EXPIRED = "Expired";
    public static final String FE_NOTENABLED  = "InstalledNotEnabled";
    public static final String FE_ONDEMAND = "EnableOnDemand";
    public static final String FE_MAJOR   = "major";
    public static final String FE_MINOR   = "minor";
    public static final String FE_EXPIRATION   = "expiration";
    public static final String FE_STARTENABLE   = "startEnable";

    /**
     * Date format specifier for XML Schema <code>date<code> data types.
     * <p>
     * Culled from the W3C XML Schema specification for 'date' data type format
     * To be used with <code>java.text.SimpleDateFormat</code>
     */
    public static final String XSD_DATETYPEFORMAT = "yyyy-MM-dd";
	public static final String CLEAR_DATA = "clearData";
    public static final String FP_HOSE_RUNNING_TOTALS = "fpRunningHoseTotals";
    public static final String USE_DEVICE_REPORT_DATA = "useDeviceReportData";
    public static final String MAX_TRACKING_RECORDS = "maxTrackingRecords";
    //XML Elements from Vipercfg
	public static final String EPSID = "epsID";
	public static final String SITENAME = "siteName";
	public static final String VIPERVFG = "viperConfig";
	public static final String POSTALCODE = "postalCode";
    public static final String PRIMARY_FEP = "primaryFep";
    public static final String VOID_TICKET_ON_ACTIVATION_FAILURE = "voidTicketOnActivationFailure";
    public static final String ALLOW_DEACTIVATION = "deactivationSupported";
    public static final String POP_ID = "popID";
    public static final String POP_IP_ADDRESS = "ipAddress";
    public static final String POP_PORT = "portNumber";
    public static final String POP_LINE_DISPLAY_LISTENING_PORT = "lineDisplayListeningPort";
    public static final String POP_LINE_DISPLAY_ENABLED = "lineItemDisplayEnabled";
    public static final String POP_SIGNATURE_CAPTURE_ENABLED = "signatureCaptureEnabled";
    public static final String POP_ENTRY = "popEntry";
    public static final String DISPLAY_PINPAD_PROMPTS_TO_CASHIER = "displayPINpadPromptsToCashier";

	public static final String TRANSSET = "transSet";

	//For Network Configuration
	public static final String NETWORK_CONFIG = "networkConfig";
	public static final String ROUTE_DETAILS = "routeDetails";
	public static final String VERIFONE_ROUTE_DETAILS = "verifoneRouteDetails";
	public static final String VFI_DEFAULT_ROUTES = "vfiDefaultRoutes";
	public static final String DEVICES = "devices";
	public static final String IP_DETAILS = "ipDetails";
	public static final String IP_DETAIL = "ipDetail";
	public static final String IP_ADDRESS = "ipAddress";
	public static final String GATEWAY = "gateway";
	public static final String NET_MASK = "netmask";
	public static final String SERVICE = "service";
	public static final String SERVICE_TYPE = "serviceType";
	
	public static final String ALTERNATE_IP = "alternateIP";
	public static final String ALTERNATE_GATEWAY = "alternateGateway";
	public static final String ALTERNATE_NETMASK = "alternateNetmask";

	public static final String ROUTE = "route";
	public static final String DESTINATION = "destination";
	public static final String DEVICE_TYPE = "destination";
	public static final String REGISTER_SYS_ID = "registerSysid";
	public static final String NIC = "nic";
	public static final String ROUTE_TYPE = "routeType";
	public static final String NIC_DESC = "nicDesc";
	public static final String PRIMARY_EDITABLE = "primaryEditable";
	public static final String DHCP_ENABLED = "dhcpEnabled";
	public static final String DEFAULT_ROUTE = "defaultRoute";
	
	public static final String VERIFONE_ZONE = "Verifone Zone";
	public static final String DNS_CONFIG = "dnsConfig";
	public static final String GATEWAY_TYPE="gatewayType";
	public static final String VERIFONE_SERVICE_ROUTE_CFG = "verifoneServiceRouteCfg";
	public static final String DOMAIN_NAME = "domainName";
	public static final String DOMAIN_NAME_SERVER = "domainNameServer";

	//Names needed to create ifsfConfig
	public static final String IFSF_NS = "urn:vfi-sapphire:np.network.eps.2005-05-10";
	public static final String IFSF = "ifsf";
	public static final String IFSF_CFG = "ifsfConfig";
	public static final String IFSF_TPZ_POP_ID = "ifsfTopazPopId";
	public static final String IFSF_SECONDARY_PINPAD = "secondaryPinpad";
	public static final String IFSF_SECONDARY_PINPAD_ID = "popId";
	public static final String IFSF_SECONDARY_PINPAD_NAME = "popName";
	public static final String IFSF_SECONDARY_PINPAD_ENABLED = "isPinpadEnable";
	public static final String IFSF_SECONDARY_PINPAD_LANE_ID = "laneId";
	public static final String IFSF_POS_REFRESH_TIMER = "ifsfPOSRefreshTimer";
	public static final String IFSF_DEV_REQ_TIMER = "ifsfDeviceRequestDefaultTimer";
	public static final String IFSF_TO_REQUEST = "ifsfTORequest";
	public static final String IFSF_TO_CONNECT = "ifsfTOConnect";
	public static final String IFSF_TO_RESPONSE = "ifsfTOResponse";
	public static final String IFSF_MAX_REPEAT = "ifsfMaxRepetition";
	public static final String IFSF_SERVICE_WAITING_PORT = "ifsfServiceWaitingPort";
	public static final String IFSF_CARD_WAITING_PORT = "ifsfCardWaitingPort";
	public static final String IFSF_DEV_WAITING_PORT = "ifsfDeviceWaitingPort";
	public static final String IFSF_DEV_REQ_PORT = "ifsfDeviceRequestPort";
	public static final String IFSF_UNSOLICITED_WAITING_PORT = "ifsfUnsolicitedServiceWaitingPort";
	public static final String IFSF_VIPER_IP = "ifsfViperIpAddr";
	public static final String BYPASS_POP_CONFIG_ELEMENT_NAME = "bypassPopConfig";
    public static final String SECONDARY_EPS_ELEMENT_NAME = "secondaryEPSConfig";
    public static final String SECONDARY_EPS_ENABLED_ELEMENT_NAME = "epsEnabled";
    public static final String EPS_IP_ADDRESS_ELEMENT_NAME = "epsIPAddr";
    public static final String EPS_CARD_WAITING_PORT_ELEMENT_NAME = "epsCardWaitingPort";
    public static final String EPS_SERVICE_WAITING_PORT_ELEMENT_NAME = "epsServiceWaitingPort";
    public static final String EPS_DEVICE_WAITING_PORT_ELEMENT_NAME = "epsDeviceWaitingPort";
    public static final String EPS_NAME_ATTRIBUTE = "epsName";
    public static final String EPS_PRIORITY_ATTRIBUTE = "priority";
    public static final String NON_SSL_MODE_ELEMENT_NAME = "nonSSL";
    public static final String SSL_SERVICE_WAITING_PORT_ELEMENT_NAME = "ifsfServiceWaitingSSLPort";
    public static final String SSL_CARD_WAITING_PORT_ELEMENT_NAME = "ifsfCardWaitingSSLPort";
    public static final String SSL_DEVICE_WAITING_PORT_ELEMENT_NAME = "ifsfDeviceWaitingSSLPort";
    public static final String SSL_DEVICE_REQUEST_PORT_ELEMENT_NAME = "ifsfDeviceRequestSSLPort";
    public static final String SSL_UNSOLICITED_SERVICE_WAITING_PORT_ELEMENT_NAME = "ifsfUnsolicitedServiceWaitingSSLPort";
    public static final String DEALER_CFG_NS = "urn:vfi-sapphire:np.network.dealerConfig.2014-01-30";
    public static final String DEALER_PREFIX = "dealer";
    public static final String DEALER_CFG = "dealerConfig";
    public static final String SITE_NAME = "siteName";
    public static final String EDITABLE_CONFIG_ENTRIES = "editableConfigEntries";
    public static final String EDITABLE_ENTRY = "editableEntry";
    public static final String ATTRIBUTE_EDITABLE_ELEMENT_NAME = "elementName";
    public static final String ATTRIBUTE_EDITABLE_XPATH_EXPRESSION = "xpathExpression";
    public static final String ATTRIBUTE_EDITABLE_VISIBLE = "visible";
    public static final String ATTRIBUTE_EDITABLE_ENABLED = "enabled";
    public static final String MERCHANT_ID = "MerchantID";
    public static final String MERCHANT_NAME = "MerchantName";
    public static final String MERCHANT_ADDRESS1 = "MerchantAddress1";
    public static final String MERCHANT_ADDRESSS2 = "MerchantAddress2";
    public static final String LOCATION_ID = "LocationID";
    public static final String POSCONFIG_UPATE = "POSConfigUpdate";
    public static final String CONFIG_UPDATE_ROOT_ELEMENT = "ConfigUpdate";
    public static final String LOYALTY_PROGRAM = "LoyaltyProgram";
    public static final String LOYALTY_DATA = "LoyaltyData";
    public static final String CARD_CIRCUIT_LIST = "CardCircuitList";
    public static final String ATTR_LOYALTY_NAME = "Name";
    public static final String ATTR_LOYALTY_ID = "ProgramID";
    public static final String ATTR_TIME_ZONE = "TimeZone";
    public static final String ALLOWED_ENTRY_METHOD = "AllowedEntryMethod";
    public static final String ATTR_LABEL = "Label";
    public static final String CURRENT_TIME = "CurrentTime";
    public static final String HEADER_WIDE = "EnterpriseHeaderWide";
    public static final String FOOTER_WIDE = "EnterpriseFooterWide";
    public static final String HEADER_NARROW = "EnterpriseHeaderNarrow";
    public static final String FOOTER_NARROW = "EnterpriseFooterNarrow";
    public static final String REWARD_BUTTON_LABEL = "RewardsButtonLabel";


    //For Shell EPSConfigUpdate
    public static final String CONFIG_UPDATE_NS = "http://www.shell.com/Florence/AdminData";
    public static final String EPS_CONFIG_PREFIX = "epsconfig";
    public static final String EPSCONFIG_UPATE = "EPSConfigUpdate";
    public static final String SEC_LOYALTY_SUPPORT = "SecondaryLoyaltySupport";
    public static final String SEC_PAYMENT_SUPPORT = "SecondaryPaymentSupport";
    public static final String MINIMUN_FUEL_PRICE = "MinimumFuelPrice";
    public static final String INDOOR_BARCODE_SCANNER_AVAIL = "IndoorBarcodeScannerAvailable";
    public static final String SEC_CONFIG_UPDATE_NS = "http://www.verifone.com/AdminData";
    public static final String SEC_EPS_CONFIG_PREFIX = "config";
    public static final String POPCONFIG_LIST = "POPConfigList";
    public static final String POPCONFIG = "POPConfig";
    public static final String WIDEPRINTER_FOR_REPORTS_AVAIL = "WidePrinterForReportsAvailable";

	//For posPaymentConfig command
	public static final String POS_PAYMENT_CFG_NS = "urn:vfi-sapphire:np.network.indoorPaymentConfig.2014-02-26";
	public static final String POS_PAYMENT_PREFIX = "payment";
	public static final String POSPAYMENTCFG = "posPaymentConfig";
	public static final String RECEIPT_MESSAGE = "receiptMessage";
	public static final String CASH_AVAILABLE = "cashbackLimit";
	public static final String TEXT_LINE = "textLine";
	public static final String RECEIPT_TYPE = "receiptType";

    //NTP Server configuration
    public static final String NTP_SERVER_CONFIG	=	"ntpServerConfig";
    public static final String USE_NTP_SERVER		=	"syncWithNTPServer";
    public static final String NTP_SERVER_IP			=	"ntpServerIp";


    // EPS Print formatting
    public static final String ALIGNMENT = "Alignment";
    public static final String HEIGHT = "Height";
    public static final String WIDTH = "Width";
    public static final String BOLD_STYLE = "BoldStyle";
    public static final String UNDERLINED_STYLE = "UnderlinedStyle";
    public static final String ITALIC_STYLE = "ItalicStyle";
    public static final String EPS_NETWORK_REPORT = "EPSNetworkReport";
    public static final String REPORT_TEXT_LINE = "ReportTextLine";
    public static final String SETTLEMENT_TEXT_LINE = "TextLine";
    


    // vrefinteg SMS support
    public static final String POPDEFMAXRECS = "maxRecords";

    // Vendgogh support
    //Properties to validate the XML document using the XSD in the SAXParser
public static final String JAXP_SCHEMA_LANGUAGE	= "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
public static final String JAXP_SCHEMA_SOURCE	= "http://java.sun.com/xml/jaxp/properties/schemaSource";

//VendGogh vending machine I2POS interface
public static final String VDGH_I2POS_CABINTEMPERATURE = "CabinTemperature";
public static final String VDGH_I2POS_CAPACITY			= "Capacity";
public static final String VDGH_I2POS_COLUMN			= "Column";
public static final String VDGH_I2POS_COLUMNERROR		= "ColumnError";
public static final String VDGH_I2POS_COLUMNERRORS		= "ColumnErrors";
public static final String VDGH_I2POS_COLUMNNUMBER		= "ColumnNumber";
public static final String VDGH_I2POS_COMMANDOK			= "CommandOK";
public static final String VDGH_I2POS_CURRENTTIME		= "CurrentTime";
public static final String VDGH_I2POS_DATETIME			= "DateTime";
public static final String VDGH_I2POS_DELETEOTHERS		= "DeleteOthers";
public static final String VDGH_I2POS_DETECTEDAT		= "DetectedAt";
public static final String VDGH_I2POS_DISPENSERCOLUMN	= "DispenserColumn";
public static final String VDGH_I2POS_DISPENSERID		= "DispenserID";
public static final String VDGH_I2POS_DOOROPEN			= "DoorOpen";
public static final String VDGH_I2POS_DROPSSINCETRANSSTART = "DropsSinceTransStart";
public static final String VDGH_I2POS_DROPSQUALIFIEDFORDISCOUNT = "DropsQualifiedForDiscount";
public static final String VDGH_I2POS_ENABLED			= "Enabled";
public static final String VDGH_I2POS_ENDTRANSACTION	= "EndTransaction";
public static final String VDGH_I2POS_ERRORCODE			= "ErrorCode";
public static final String VDGH_I2POS_FUELDOLLARS		= "FuelDollars";
public static final String VDGH_I2POS_FUELVOLUME		= "FuelVolume";
public static final String VDGH_I2POS_GETINVENTORY		= "GetInventory";
public static final String VDGH_I2POS_GETOPENCONFIG		= "GetOpenConfig";
public static final String VDGH_I2POS_GETPRODUCTDATA	= "GetProductData";
// @todo This is missing a d in Har_d_wareFailure. Check schema.
public static final String VDGH_I2POS_HARDWAREFAILURE	= "HarwareFailure";
public static final String VDGH_I2POS_ICONIMAGEFILENAME = "IconImageFileName";
public static final String VDGH_I2POS_INTERNALERROR		= "InternalError";
public static final String VDGH_I2POS_INVENTORY			= "Inventory";
public static final String VDGH_I2POS_LASTBUTTONPRESS	= "LastButtonPress";
public static final String VDGH_I2POS_LASTDROPTIME		= "LastDropTime";
public static final String VDGH_I2POS_LASTRESTOCKTIME	= "LastRestockTime";
public static final String VDGH_I2POS_PAYMETHOD			= "PayMethod";
public static final String VDGH_I2POS_OPERATORMESSAGE   = "OperatorMessage";
public static final String VDGH_I2POS_PING				= "Ping";
public static final String VDGH_I2POS_PING2				= "Ping2";
public static final String VDGH_I2POS_PRODUCT			= "Product";
public static final String VDGH_I2POS_PRODUCTNAME		= "ProductName";
public static final String VDGH_I2POS_PRODUCTSALE		= "ProductSale";
public static final String VDGH_I2POS_RECORDOPENSALE	= "RecordOpenSale";
public static final String VDGH_I2POS_SALEITEM			= "SaleItem";
public static final String VDGH_I2POS_SERVICEMODE		= "ServiceMode";
public static final String VDGH_I2POS_SETOPENCONFIG		= "SetOpenConfig";
public static final String VDGH_I2POS_SETPRODUCTDATA	= "SetProductData";
public static final String VDGH_I2POS_SEQUENCE			= "Sequence";
public static final String VDGH_I2POS_STARTTIME			= "StartTime";
public static final String VDGH_I2POS_STARTTRANSACTION	= "StartTransaction";
public static final String VDGH_I2POS_STATUS			= "Status";
public static final String VDGH_I2POS_TOTALPRICE		= "TotalPrice";
public static final String VDGH_I2POS_TRANSACTIONCOMPLETE	= "TransactionComplete";
public static final String VDGH_I2POS_TRANSACTIONDATA	= "TransactionData";
public static final String VDGH_I2POS_TRANSACTIONID	= "TransactionID";
public static final String VDGH_I2POS_TRANSACTIONISOPEN = "TransactionIsOpen";
public static final String VDGH_I2POS_TRANSACTIONSEQUENCE	= "TransactionSequence";
public static final String VDGH_I2POS_UNITCOUNT			= "UnitCount";
public static final String VDGH_I2POS_UNITPRICE			= "UnitPrice";
public static final String VDGH_I2POS_UPCCODE			= "UpcCode";
public static final String VDGH_I2POS_VENDINGENABLED	= "VendingEnabled";
public static final String VDGH_I2POS_VENDLIMIT			= "VendLimit";
public static final String VDGH_I2POS_VENDSALES			= "VendSales";
// shell login enable/disable support
public static final String LOGIN_TOKEN      = "loginToken";
public static final String TOKEN      = "token";
public static final String PRICE_CHANGED_BY      = "priceChangedBy";
public static final String PRICE_CHNAGE_ORIGIN      = "priceChangeOrigin";
public static final String LOCATIONID					= "locationId";

// CR0768.01
public static final String REASON					= "reason";

//manager workstation
public static final String MWS_CASHIER_DRAWER_AMTS = "mwsCashierDrawerAmts";
public static final String CASHIER_DRAWER_AMTS ="cashierDrawerAmts";
public static final String CASHIER_END_DRAWER_AMOUNTS = "cashierEndDrawerAmts";
public static final String END_DRAWER_MOP_AMOUNT="endDrawerMopAmount";
public static final String POSTED_BY="postedBy";
public static final String RECONCILED_BY_ID="reconciledByID";
public static final String RECONCILED_BY="reconciledBy";
public static final String RECONCILED_BY_NAME="reconciledByName";
public static final String MGRVERIFIED="mgrVerified";
public static final String RECONCILED="reconciled";

public static final String POS_CREDENTIAL       = "poscredential";
public static final String POS_FUNCTION_LIST       = "posfuncList";
public static final String POS_FUNCTION       = "POSFunction";
public static final String POS_FUNCTION_DISPLAY_NAME       = "displayName";
public static final String FUNCTION_CMD       = "FunctionCmd";
public static final String FUNCTION_DETAIL       = "FunctionDetail";
public static final String NUMBER = "number";
public static final String FUNCTION_APP_GROUP = "FunctionAppGroup";
public static final String MWS_CASHIER_MOP_AMOUNTS = "mwsCashierMopAmounts";
public static final String REPORT_APPROVED="reportApproved";
public static final String REPORT_STATUS="reportStatus";
public static final String AUTO_APPROVED         = "autoApproved";
public static final String REVIEW_CASHIER_REPT         = "reviewCashierRept";
public static final String FINALIZE_DEPOSIT         = "finalizeDeposit";
public static final String ACCEPT_DAILY_REPT         = "acceptDailyRept";
public static final String POS_FUNCTION_COMMAND      = "command";
public static final String POS_FUNCTION_DESCRIPTION      = "description";
public static final String EMPID = "employeeId";
public static final String TILL_EVENT_REPORT = "tillEventReport";
public static final String TILL_EVENT_by_csr = "tillEventsByCsr";
public static final String TILL_EVENT = "tillEvent";
public static final String TRAN_NUM = "tranNum";
public static final String TRAN_TIME = "tranTime"; 
public static final String TRAN_HOUSE_ACCT = "trHouseAcct";
public static final String TRAN_VENDOR_PMT = "trVendorPmt";
public static final String ORIGINAL_SAFEDROP_TRANS_NUM="originalSafeDropTranNum";
public static final String ORIGINAL_SAFEDROP_AMOUNT="originalSafeDropAmount";
public static final String MANAGER_ADJUSTMENT = "managerAdjustment";
public static final String ADJUSTMENT_TYPE ="adjustmentType";
public static final String ADJUSTMENT_AMOUNT ="adjustmentAmount";
public static final String ADJUSTMENT_REF_NUM ="adjustmentRefNum";

public static final String MANAGER_CORRECTION = "managerCorrection";
public static final String MWS_CORRECTION_MOP_AMOUNTS = "mwsCorrectionMopAmounts";
public static final String CORRECTION_MOP_AMOUNT = "correctionMopAmount";

public static final String MWS_CASH_MOVEMENT_REPORT = "mwsCashMovementReport";
public static final String TOTAL_DEPOSITE_AMOUNT = "totalDepositAmount";
public static final String DEPOSITE_BAG_REF = "depositBagRef";
public static final String SAFE_BEGIN_AMOUNTS = "safeBeginAmounts";
public static final String BEGIN_MOP_AMOUNTS = "beginMopAmounts";
public static final String BEGIN_MOP_AMOUNT = "beginMopAmount";
public static final String BEGIN_AMOUNT = "beginAmount";
public static final String MWS_CASHIER_PERIOD = "mwsCashierPeriod";
public static final String BEGIN_DRAWER_AMOUNTS = "beginDrawerAmounts";
public static final String SUMMARY_MOP_TOTALS = "summaryMopTotals";
public static final String SUMMARY_PAY_OUTS = "summaryPayOuts";
public static final String SUMMARY_PAY_INS = "summaryPayIns";
public static final String SUMMARY_SAFE_DROPS = "summarySafeDrops";
public static final String SUMMARY_SAFE_LOANS = "summarySafeLoans";
public static final String MOP_INFO_SALE = "mopInfoSale";
public static final String CORRECTIVE_AMOUNT = "correctiveAmount";
public static final String FINAL_NET_SALES = "finalNetSales";
public static final String ACTUAL_AMOUNT = "actualAmount";
public static final String FINAL_MOP_SALES = "finalMopSales";
public static final String TOTAL_AMOUNT = "totalAmount";
public static final String ACCOUNTED_TOTALS = "accountedTotals";
public static final String CASHIER_REPORT_REVIEW = "cashierReportReview";
public static final String CASHIER_REPORT_REVIEW_STATUS = "cashierReportReviewStatus";
public static final String MWS_SPECIFIC_CSR_DATA = "mwsSpecificCashierData";
public static final String MWS_SPECIFIC_PERIOD_DATA = "mwsSpecificPeriodData";
public static final String PERIOD_1_KEY = "period1Key";
public static final String PERIOD_2_KEY = "period2Key";
public static final String MWS_VERIFIED = "mwsVerified";
public static final String MWS_ADJUSTMENTS = "adjustments";
public static final String TRANS_TIME = "transTime";
public static final String TRANS_TYPE = "transType";
public static final String MWS_CORRECTIONS = "corrections";
public static final String MWS_CORRECTION = "correction";
public static final String MWS_MGR_ACCEPTED = "mwsMgrAccepted";
public static final String MWS_AUTO_APPROVED = "mwsAutoApproved";
public static final String MWS_MGR_ACCEPTED_BY = "mwsMgrAcceptedBy";
public static final String MWS_MANAGER_REVIEW_STATUS = "managerReviewStatus";
public static final String MWS_MANAGER_FINALIZE_INFO = "managerFinalizeInfo";
public static final String MWS_CORRECTION_AMOUNT="mwsCorrectionAmount";
public static final String MWS_CORRECTION_POSTED_BY="mwsCorrectionPostedBy";
public static final String NETWORKS = "networks";
public static final String CASHIER_PD = "cashierPd";
public static final String ATTENDANT_PD = "attendantPd";

public static final String SALES_DATA_EVENT = "salesDataEvent";
public static final String SALES_MONITOR_DATA = "salesMonitorData";
public static final String SALES_BY_FUEL_POSITION = "salesByFuelPosition";
public static final String LAST_PREPAY_SALE = "lastPrepaySale";
public static final String LAST_POSTPAY_SALE = "lastPostpaySale";
public static final String LAST_DCR_SALE = "lastDCRSale";
public static final String SALES_BY_REG = "salesByRegister";
public static final String LAST_SALE = "lastSale";
public static final String SITE_LEVEL_DATA = "siteLevelSalesData";
public static final String LAST_INDOOR_NETWORK_SALE = "lastIndoorNetworkSale";
public static final String LAST_INDOOR_SALE = "lastIndoorSale";
public static final String SALES_DATA = "SALES_DATA";
public static final String STATUS_OFFLINE = "Offline";
public static final String STATUS_ONLINE = "Online";
public static final String STATUS_MIXED = "Mixed";
public static final String TERMINAL = "terminal";	

	//System Updates
	public static final String SYS_UPD_NS = "urn:vfi-psc:systemupdates.2016.04.20";
	public static final String SYS_UPD_NS_PREFIX = "sysupd";
	public static final String SYS_UPD_LOGON_REQ = "SystemLogOnRequest";
	public static final String SYS_UPD_LOGOFF_REQ = "SystemLogOffRequest";
	public static final String SYS_UPD_LOGON_RESP = "SystemLogOnResponse";
	public static final String SYS_UPD_LOGOFF_RESP = "SystemLogOffResponse";
	public static final String SYS_UPD_FDC_ALARMS = "FDCAlarms";
	public static final String SYS_UPD_EPS_ALARMS = "EPSAlarms";
	public static final String SYS_UPD_SYSTEM_ALARMS = "SystemAlarms";
	public static final String SYS_UPD_AU_UPDATES = "UpgradeUpdates";
	public static final String SYS_UPD_PDCLOSE_UPDATES = "PeriodCloseUpdates";
	public static final String SYS_UPD_TRAN_UPDATES = "TransactionUpdates";
	public static final String SYS_UPD_TRAN_LASTTRAN_ATTR = "lastTrUniqueSN";
	public static final String SYS_UPD_WORKSTATION_ATTR = "workstationID";
	public static final String SYS_UPD_OVERALL_RESULT = "OverallResult";
	
	//Alarms
	public static final String ALARMS_UPD_NS = "urn:vfi-psc:alarms.2016.04.20";
	public static final String ALARMS_UPD_NS_PREFIX = "alarms";
	public static final String ALARMS = "Alarms";
	public static final String ALARMS_FDC = "FDCAlarms";
	public static final String ALARMS_EPS = "EPSAlarms";
	public static final String ALARMS_SYSTEM = "SystemAlarms";
	public static final String ALARMS_MSG = "AlarmMsg";
	public static final String ALARMS_NUMBER_ATTR = "number";
	public static final String ALARMS_ONESHOT_ATTR = "oneShotAlarm";
	public static final String ALARMS_TEXT = "Text";
	
	//Transaction list
	public static final String TRANS_LIST_ROOT = "transList";

	//Transaction numbers list
	public static final String TRANS_NUM_LIST_ROOT = "transNumList";
	public static final String TRANS_TICKET_NUM = "trTickNum";
	public static final String TRANS_POS_NUM = "posNum";
	public static final String TRANS_SEQ = "trSeq";
	
	public static final String POS_PAYMENT_CFG_CONFIGURED_FEP_LIST = "configuredFepList";
	public static final String POS_PAYMENT_CFG_CONFIGURED_FEP = "configuredFep";
	public static final String POS_PAYMENT_CFG_CONFIGURED_FEP_NAME = "fepName";
	public static final String POS_PAYMENT_CFG_CONFIGURED_EPS_NAME = "epsName";
	public static final String POS_PAYMENT_CFG_LOYALTY_PROGRAM_LIST = "loyaltyProgramList";
	public static final String POS_PAYMENT_CFG_LOYALTY_PROGRAM = "loyaltyProgram";
	public static final String POS_PAYMENT_CFG_LOYALTY_PROGRAM_NAME = "loyaltyProgramName";
	public static final String POS_PAYMENT_CFG_LOYALTY_PROGRAM_ID = "loyaltyProgramID";
	public static final String POS_PAYMENT_CFG_FSA_FEP_NAME = "FSAFepName";
	
	// Rapid Change Fuel Config
	public static final String RAPID_CHANGE_FUEL_CONFIG = "rapidChangeFuelConfig";	
	public static final String RAPID_CHANGE_CONFIGS = "rapidChangeConfigs";
	public static final String RAPID_CHANGE_CONFIG = "rapidChangeConfig";
	public static final String RCF_SERVICE_LEVEL = "serviceLevel";
	public static final String FUELING_POSITIONS = "fuelingPosition";
	public static final String AUTO_APPROVAL = "autoApproval";
	
	//VHQ
	public static final String VHQ_CFG = "vhqConfig";
	public static final String VHQ_ENABLED = "vhqEnabled";
	public static final String CUSTOMER_ID = "customerID";
	public static final String VHQ_SERVER_LOCATION = "vhqServerLocation";
	public static final String STORE_ID = "storeID";
	public static final String SERVICE_ID = "serviceID";
	public static final String CUSTOMER_PROFILE = "customerProfile";	

	// APT Global
	public static final String  APT_GLOBAL_CFG = "aptGlobalConfig";
	public static final String  APT_GLOBAL = "global";
	public static final String  APT_GLOBAL_LOGIN_EVERY_TRAN = "loginForEveryTransaction";
	public static final String  APT_GLOBAL_LOGIN_TIMEOUT = "loginTimeout";
	public static final String  APT_GLOBAL_RECEIPT_REQ = "cashierReceiptRequired";
	public static final String  APT_GLOBAL_PRESET_SEC_LEVEL = "presetSecurityLevel";
	public static final String  APT_GLOBAL_ENABLED_MOP_CODES = "enabledMOPCodes";
	public static final String  APT_GLOBAL_MOP_CODE = "mopCode";
	public static final String  APT_GLOBAL_CODE = "code";
	public static final String  APT_GLOBAL_ENABLED_DEPTS = "enabledDepartments";
	
	// APT Terminal
	public static final String  APT_TERMINAL_CFG = "aptTerminalConfig";
	public static final String  TERMINAL_ID = "terminalId";
	public static final String  TERMINAL_NAME = "terminalName";
	public static final String  TERMINAL_ID_QUERYSTRING = "terminalid";
	public static final String  APT_TERMINAL_ALLOWED_FPS = "allowedFuelingPositions";
	public static final String  APT_TERMINAL_FP = "fuelingPosition";
	public static final String  APT_TERMINAL_ALLOWED_OPS = "allowedOperations";
	public static final String  APT_TERMINAL_OPERATION = "operation";
	
	// APT/Vista common constants
	public static final String  TERMINAL_PINPAD_TYPE = "pinPadType";
	public static final String  TERMINAL_STYLE_DETAILS = "receiptStyleDetails";
	public static final String  TERMINAL_STYLE_HEADER = "header";
	public static final String  TERMINAL_STYLE_TRAILER = "trailer";
	public static final String  TERMINAL_STYLE_TEXT = "text";
	public static final String  TERMINAL_STYLE_ALIGN = "align";
	
	// Vista Item Subset constants
	public static final String  VISTA_ITEM_SUBSET_CFG = "vistaItemSubsetConfig";
	public static final String  VISTA_ITEM_SUBSET = "itemSubset";
	public static final String  ITEMS = "items";
	public static final String  DISPLAY_NAME = "displayName";
	public static final String  HOT_ITEM = "hotItem";
	public static final String  VISTA_ITEM_SUBSET_GROUP_ID = "groupId";
	public static final String  PLU_LC = "plu";
	public static final String  DEPT = "dept";
	
	// Vista Itemset constants
	public static final String  VISTA_ITEMSET_CFG = "vistaItemsetConfig";
	public static final String  VISTA_ITEMSET = "itemSet";
	public static final String  VISTA_ITEMSET_SUBSETS = "itemSubsets";
	
	// Vista Terminal Preview constants	
	public static final String  VISTA_TERMINAL_PREVIEW_CFG = "vistaTerminalPreviewConfig";
	public static final String  VISTA_TERMINAL_PREVIEW_ITEMSETS = "itemSets";
	public static final String  VISTA_TERMINAL_PREVIEW_ITEMSET = "itemSet";
	public static final String  VISTA_TERMINAL_PREVIEW_CASHIER_DRIVEN = "cashierDriven";
	public static final String  VISTA_TERMINAL_PREVIEW_CUSTOMER_DRIVEN = "customerDriven";
	public static final String  MISC_CONFIG = "miscConfig";
	public static final String  SHOW_HOT_ITEMS = "showHotItems";
	public static final String  LOYALTY_MEMBER = "loyaltyMember";
	public static final String  NON_LOYALTY_CUSTOMER = "nonLoyaltyCustomer";
	public static final String  MEMBER_INSTRUCTIONS = "memberInstructions";
	public static final String  VISTA_TERMINAL_PREVIEW_BUTTON_COLOR = "buttonColor";
	
	public static final String  ICON_NAME = "iconName";
	public static final String  COLOR_CODE = "colorCode";

	// APT RefInteg
	public static final String  APT_TERMINAL_IDS = "aptTerminalIds";
	public static final String  REGISTERED_DEVICES = "registeredDevices";
	
	// Vista RefInteg
	public static final String  VISTA_TERMINAL_IDS = "vistaTerminalIds";
	public static final String  VISTA_TERMINAL_ID = "terminalId";
	public static final String  VISTA_GROUPS = "vistaGroups";
	public static final String  VISTA_GROUP_ID = "vistaGroup";
	public static final String  VISTA_ITEM_SUBSETS = "itemSubsets";
	public static final String  VISTA_IMAGE_DETAILS = "imageDetails";
	public static final String  VISTA_COLOR_CODES = "colorCodes";
	public static final String  IMAGE = "image";
	public static final String  COLOR = "color";
	
	// Carbon Device Config - These constants are used only for Vista Device AU restore
	public static final String  CARBON_GROUP_CFG = "terminalGroup";
	public static final String  CARBON_TERMINAL_CFG = "terminalConfig";
	public static final String  CARBON_ITEMSUBSET_CFG = "carbonItemSubsetConfig";
	public static final String  CARBON_ITEMSET_CFG = "carbonItemsetConfig";
	public static final String  CARBON_TERMINAL_PREVIEW_CFG = "carbonTerminalPreviewConfig";
	
	// Image Config constants
	public static final String  IMAGE_CONFIG = "imageConfig";
	public static final String  IMAGE_BASE64_IMAGE = "base64Image";
	
	public static final String IPADDRESS_REGEX_PATTERN = 
			"^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}" +
			"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
	public static final String HOSTNAME_REGEX_PATTERN =
			"^([a-zA-Z0-9]([a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,6}$";
	
	public static final String INTEGER_REGEX_PATTERN = "[*0-9]{1}[*0-9]{0,11}";
	
	/**These constants are related to commander_console.prop file*/
	//COMMANDER CONSOLE
	public static final String CIA_OVERRIDESERIALNUMBER = "cia.overrideSerialNumber";
	public static final String CIA_REPORTCLOSEPERIODNUMBER= "cia.reportClosePeriodNumber";
	public static final String CIA_ENABLE_CLOUD_AGENT = "cia.enableCloudAgent";
	public static final String CIA_USETESTHOST = "cia.useTestHost";
	public static final String CIA_REPORTCLOSEMAXBACKLOG = "cia.reportCloseMaxBacklog";
	public static final String CIA_OVERRIDEHOSTBASEURL = "cia.overrideHostBaseURL";
	public static final String CIA_OVERRIDESITEID = "cia.overrideSiteID";
	public static final String CIA_ENABLEMESSAGELOGGING = "cia.enableMessageLogging";
	public static final String CIA_OVERRIDESERVICEID = "cia.overrideServiceID";
	public static final String CIA_OVERRIDEDEFAULTHOSTBASEURL = "cia.overrideDefaultHostBaseURL";
	
	// iOrder Upgrade Summaery Constants 
	public static final String KIOSK_UPGRADE_SUMMARY = "KioskUpgradeSummary";
	public static final String BUILD_NAME = "buildName";
	public static final String BEGINNING = "beginning";
	public static final String ENDING = "ending";
	public static final String TOTAL_TIME_TAKEN = "timeTaken";
	public static final String EVENT_NAME = "eventName";
	public static final String TASK_NAME = "taskName";
	public static final String TASK_STATUS = "taskStatus";
	public static final String KIOSK_UPG_DETAILS = "kioskUpgDetails";
	public static final String KIOSK_UPG_DETAIL = "kioskUpgDetail";
	public static final String UPGRADE_VERSION = "upgradeVersion";
	public static final String NO_OF_KIOSKS_IN_UPG = "noOfKiosksInUpg";
	public static final String UPG_BEGINNING = "upgBeginning";
	public static final String UPG_ENDING = "upgEnding";
	// Third Party Product Provider Configuration
	public static final String TPPP_CFG = "thirdPartyProductProviderConfiguration";
	public static final String TPPP_NETWORK_NAME = "thirdPartyProductProviderNetworkName";
	public static final String TPPP_NETWORK_BARCODEID = "thirdPartyProductProviderNetworkBarcodeID";
	public static final String TPPP_NETWORK_ENABLED = "thirdPartyProductProviderNetworkEnabled";
	public static final String TPPP_ENABLED = "thirdPartyProductProviderEnabled";
	public static final String TPPP_DEPARTMENT = "thirdPartyProductProviderDepartment";
	public static final String TPPP_RANGE_START = "thirdPartyProductProviderRangeStart";
	public static final String TPPP_RANGE_END = "thirdPartyProductProviderRangeEnd";
	
	public static final String TPPP_PREFIX_NS = "tppp";
	
	public static final String VERSION_BEFORE_UPG = "versionBeforeUpg";
	public static final String VERSION_AFTER_UPG = "versionAfterUpg";
	
	// APT Range
	public static int APT_MIN_REGISTER_ID = 168;
	public static int APT_MAX_REGISTER_ID = 175;
	
	public static final String EXCLUDE_VARIANTS = "excludeVariants";	

	// Vista Terminal Range
	public static int VISTA_MIN_TERMINAL_ID = 151;
	public static int VISTA_MAX_TERMINAL_ID = 199;
	public static final String EXTPOS = "extPos";
	public static final String IFSF_EXTPOS_POPID = "extPosPopId";
	
	// External Device Registration Configuration
	public static final String REGISTER_TOKEN_REQ = "registerDeviceRequest";
	public static final String REGISTER_TOKEN_RES = "registerDeviceResponse";
	public static final String MANAGE_DEVCIE_CONFIG = "manageDeviceConfig";
	public static final String MANAGED_DEVCIE_CONFIG = "managedDeviceConfig";
	public static final String APPLICATION_TYPES = "applicationTypes";
	public static final String APPLICATION_TYPE = "applicationType";
	public static final String APPLICATION = "application";
	public static final String SUCCESS_UC = "SUCCESS";
	public static final String FAILURE_UC = "FAILURE";
	public static final String DEVICE_DETAILS = "deviceDetails";
	public static final String SECURE_DEVICE_DETAILS = "secureDeviceDetails";
	public static final String HASHED_TOKEN      = "hashedToken";
	public static final String PORT_SL = "port"; 
	public static final String TOKEN_ACTION ="tokenAction";
	public static final String TOKEN_GENERATED ="tokenGenerated";
	public static final String WORK_STATION = "Reg";

	//Fiscal receipt 
	public static final String FISCAL_RECEIPT_CONFIG = "fiscalReceiptConfig";
	public static final String MERCHANT_TAX_ID_NAME = "merchantTaxIdName";
	public static final String TAD_ID = "taxID";
	public static final String CUSTOMER_TAX = "customerTax";
	public static final String CUSTOMER_TAX_INFO = "customerTaxInfo";
	public static final String CUSTOMER_TAX_ID_NAME = "customerTaxIdName";
	public static final String CUSTOMER_TAX_ID_MAX_LEN = "customerTaxIdMaxLen";
	public static final String CUSTOMER_TAX_ID_MIN_LEN = "customerTaxIdMinLen";
	public static final String END_SEQ_ALARM_THRESHOLD = "endSeqAlarmThreshold";
	public static final String CUSTOMER_TAX_ID_CHECK_DIGIT = "taxIdCheckDigit";
	public static final String SEQUENCE_NUM = "endSeqAlarmThreshold";
	public static final String TAXID_DB = "taxIdDatabase";
	public static final String TAXID_DB_CUST_NAME = "customerName";
	public static final String TAXID_DB_CUST_ADDRESS = "customerAddress";
	public static final String AUTHORIZATION_DAYS = "endAuthDateAlarmThreshold";	
	public static final String COMMON_SEQ_APT = "commonSeqAPT";
	public static final String COMMON_APT_REG_ID = "commonAPTRegisterId";
	public static final String PRINT_CURRENCY_SYMBOL= "currencyAllAmounts";
	public static final String PRINT_UNIT_PRICE= "printUnitPrice";
	public static final String VERBOSE_TOTAL= "printWrittenAmount";
	public static final String PRINT_TAX_SUMMARY= "printTaxSummary";
	public static final String PRINT_ALL_TAXES= "printAllTaxes";
	public static final String FISCAL_RECEIPT_ENABLED = "fiscalReceiptEnabled";
	public static final String FISCAL_RECEIPT_DATA = "fiscalReceiptData";
	public static final String FISCAL_RECEIPT_TYPES = "fiscalReceiptTypes";
	public static final String RECEIPT_NAME = "receiptName";
	public static final String RECEIPT_PREFIX = "receiptPrefix";
	public static final String BEGIN_SEQUENCE = "beginSequence";
	public static final String NEXT_SEQUENCE = "nextSequence";
	public static final String END_SEQUENCE = "endSequence";
	public static final String MERCHANT_TAX_ID_NUMBER = "merchantTaxIdNumber";
	public static final String AUTH_NAME = "authName";
	public static final String AUTH_NUMBER = "authNumber";
	public static final String CUSTOMER_DATA_PROMPT = "customerDataPrompt";
	public static final String ORIGINAL_RECEIPT_PROMPT = "originalReceiptPrompt";
	public static final String VOUCHER_NUM_PROMPT = "voucherNumPrompt";
	public static final String FISCAL_SALE = "fiscalSale";
	public static final String FISCAL_REFUND = "fiscalRefund";
	public static final String FUEL_VOUCHER = "fuelVoucher";
	public static final String NON_FISCAL_NETWORK = "nonFiscalNetwork";
	public static final String PUMP_TEST = "pumpTest";
   
	public static final String TAX_EXEMPT_VOUCHER_RECEIPT = "taxExemptVoucher";
	public static final String START_AUTH_DATE_LBL = "startAuthDateLabel";
	public static final String START_AUTH_DATE = "startAuthDate";
	public static final String END_AUTH_DATE_LBL = "endAuthDateLabel";
	public static final String END_AUTH_DATE = "endAuthDate";
	public static final String FINAL_CONSUMER_PROMPT = "finalConsumerPrompt";
	public static final String LABEL = "label";
	
	//Fiscal receipt - Fuel Flat Tax
	public static final String FUELFLAT_TAX_CONFIG = "fuelFlatTaxConfig";
	public static final String FUEL_FLAT_TAX = "fuelFlatTax";
	public static final String FLAT_TAX_DETAIL = "flatTaxDetail";
	
	////Fiscal receipt - Tax Exemption
	public static final String TAX_EXEMPTION_CONFIG = "taxExemptionConfig";
	public static final String TAX_EXEMPTION = "taxExemption";
	public static final String PURCHASE_ORDER_PROMPT = "purchaseOrderPrompt";
	public static final String CUST_NUM_PROMPT = "customerNumberPrompt";
	public static final String TAX_EXEMPT_MERCH = "exemptMerchandise";
	public static final String TAX_EXEMPT_FUEL = "exemptFuelSales";
	public static final String EXEMPT_FUELFLAT_TAX = "exemptFuelFlat";
	// Managed Network Service Provider (MNSP) Status defininitions
	public static final String VPN_STATUS = "vpnStatus";
	public static final String VPN_CAPABILITY = "capVPN";
	public static final String VPN_CONNECTED = "vpnConnected";
	public static final String VPN_ERRORCODE = "vpnErrorCode";
	public static final String VPN_ERRORMESSAGE = "vpnErrorMessage";
	public static final String VPN_UPLINKINFO = "uplinkInfo";
    
    // Managed Network Service Provider (MNSP) Diagnostics defininitions
	public static final String MNSP_DIAG_ELEMENT = "mnspDiagnostics";
	public static final String MNSP_DIAG_INFO = "info";
	public static final String MNSP_DIAG_STATUS = "status";
    
    // Managed Network Service Provider (MNSP) diag 'info' defininitions
	public static final String MNSP_INFO_APIVER = "apiVersion";
	public static final String MNSP_INFO_MANUFACTURER = "manufacturer";
	public static final String MNSP_INFO_MODELNR = "modelNumber";
	public static final String MNSP_INFO_SERIALNR = "serialNumber";
	public static final String MNSP_INFO_FIRMWARE = "firmwareVersion";
	public static final String MNSP_INFO_UPLINKMAC = "uplinkMAC";
	public static final String MNSP_INFO_UPLINKIP = "uplinkIP";
	public static final String MNSP_INFO_HOSTNAME = "hostname";

    // Managed Network Service Provider (MNSP) diag 'status' defininitions
	public static final String MNSP_STATUS_CONNECTED = "connected";
	public static final String MNSP_STATUS_DURATION = "duration";
	public static final String MNSP_STATUS_TIMELEFT = "timeLeft";
	public static final String MNSP_STATUS_LINKID = "linkId";

	public static final String SOFTKEYCODE       = "softKeyCode";
	public static final String SOFTKEYNAME       = "softKeyName";
	public static final String  SOFTKEYTYPE_SECURITY_CFG = "softKeyTypeSecurityConfig";
	public static final String SOFTKEYTYPE = "softKeyType";
    
	
	//Charity Config
	public static final String CHARITY_CONFIG = "charityConfig";
	public static final String CHARITY_PROGRAM ="charityProgram";
	public static final String CHARITY_CASH_PAYMENT_OPTIONS= "cashPaymentOptions";
	public static final String CHARITY_NETWORK_PAYMENT_OPTIONS= "networkPaymentOptions";
	public static final String CHARITY_ROUND_UP = "roundUp";
	public static final String CHARITY_REST_FOR_CHARITY = "restForCharity";
	public static final String CHARITY_DENOMINATION = "denomination";
	
	// Cashier Preference Constants
	public static final String EMP_PREFS_CFG = "empPrefsCfg";
	public static final String UTILITY_PANEL_ENABLED = "utilityPanelEnabled";
	public static final String RECEIPT_LAYOUT = "receiptLayout";
	public static final String VIRTUALKEYBOARD_LAYOUT = "virtualKeyboardLayout";
	public static final String EMP_PREFS = "empPrefs";

	public static final String ATTENDANT_ID = "attendantID";
	
	
	
	
	

}
