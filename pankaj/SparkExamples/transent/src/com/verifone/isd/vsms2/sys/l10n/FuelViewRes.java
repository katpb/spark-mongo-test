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
 * Resource bundle for all fuel view related strings.
 * Strings here have constants that reference the string key used for lookup.
 * This looks redundant, but allows compile-time checking that we have at least
 * a valid key to index.
 *
 * @author	Bhanu_N2
 * @version 0.1
 */
public class FuelViewRes extends ListResourceBundle {
	public static final String FP               = "FP";
	//Transaction positions
	public final static String CURRENT_TXN      = "CURRENT_TXN";
	public final static String STACKED_TXN      = "STACKED_TXN";
	//Transaction states
	public static final String DUE_SALE         = "DUE_SALE";
	public static final String SOLD_SALE        = "SOLD_SALE";
	public static final String HOLD_SALE        = "HOLD_SALE";
	public static final String NEW_SALE        = "NEW_SALE";
	//Pump states
	public static final String AUTHORIZED       = "AUTHORIZED";
	public static final String CALLING          = "CALLING";
	public static final String FUELING          = "FUELING";
	public static final String IDLE             = "IDLE";
	public static final String OFFLINE          = "OFFLINE";
	public static final String RESERVED         = "RESERVED";
	public static final String STOPPED          = "STOPPED";
    public static final String INITIALIZING     ="INITIALIZING";
    public static final String INITIALIZED      ="INITIALIZED";
    public static final String PRICE_INITIALIZING     ="PRICE_INITIALIZING";
    public static final String PRICE_INITIALIZED      ="PRICE_INITIALIZED";
    public static final String INIT_PEND      ="INIT_PEND";
    public static final String PRICE_PEND     ="PRICE_PEND";

	//Transaction message
	public static final String PREPAID          = "PREPAID";

	//Fuel actions
	public static final String FP_MOVE          = "FP_MOVE";
	public static final String FP_MOVE_FROM     = "FP_MOVE_FROM";
	public static final String FP_MOVE_TO       = "FP_MOVE_TO";
	public static final String FROM_PUMP        = "FROM_PUMP";
	public static final String MOVING_PREPAY    = "MOVING_PREPAY";
	public static final String TO_PUMP          = "TO_PUMP";

	//Fuel express keys
	public static final String PRT_DCR_TRAN     = "PRT_DCR_TRAN";
	public static final String MORE_FUEL_FNS    = "MORE_FUEL_FNS";
	public static final String SHOW_FUEL        = "SHOW_FUEL";
	public static final String HIDE_FUEL        = "HIDE_FUEL";

	//More fuel functions overlay strings
	public static final String FUEL_SALE_FNS    = "FUEL_SALE_FNS";
	public static final String FUELING_POINT    = "FUELING_POINT";
	public static final String SELL_CURR_FUEL   = "SELL_CURR_FUEL";
	public static final String SELL_STK_FUEL    = "SELL_STK_FUEL";
	public static final String SELL_FUEL        = "SELL_FUEL";
	public static final String APPROVE_PUMP     = "APPROVE_PUMP";
	public static final String SILENCE_PUMP     = "SILENCE_PUMP";
	public static final String PREPAY_MOVE      = "PREPAY_MOVE";
	public static final String STOP_PUMP        = "STOP_PUMP";
	public static final String WATCH_PUMP       = "WATCH_PUMP";
	public static final String APPROVE          = "APPROVE";
	public static final String STOP             = "STOP";
	public static final String FP_OFFLINE       = "FP_OFFLINE";

	//Prepay
	public static final String PREPAY_FUEL      = "PREPAY_FUEL";
	public static final String FILL_UP_FUEL      = "FILL_UP_FUEL";
	public static final String ENTER_PUMP       = "ENTER_PUMP";
	public static final String ENTER_AMOUNT     = "ENTER_AMOUNT";
	public static final String ENTER_VOLUME     = "ENTER_VOLUME";
	public static final String QTY_HELPER       = "QTY_HELPER";
	public static final String PUMP             = "PUMP";
	public static final String ON_PUMP          = "ON_PUMP";
	public static final String ENTER_MOP        = "ENTER_MOP";
	public static final String MOPS             = "MOPS";
	public static final String SELECT_MOP       = "SELECT_MOP";
	public static final String FUEL_PRODUCTS    = "FUEL_PRODUCTS";
	public static final String SELECT_PRODUCT   = "SELECT_PRODUCT";
	public static final String ENTER_PRODUCT    = "ENTER_PRODUCT";
	public static final String PREPAY_STOP      = "PREPAY_STOP";
	public static final String PREPAY_STOP_CMD  = "PREPAY_STOP_CMD";

	//Preset
	public static final String PRESET_FUEL      = "PRESET_FUEL";

	//Rest In Gas
	public static final String RIG              = "RIG";
	public static final String ENTER_AMOUNT_CASH= "ENTER_AMOUNT_CASH";

	//DCR reprint
	public static final String DCR_REPRINT_HDR  = "DCR_REPRINT_HDR";
	public static final String DCR_REPRINT      = "DCR_REPRINT";
	public static final String FUEL_DETAIL      = "FUEL_DETAIL";

	//Status messages
	public static final String APPROVE_PUMP_HDR = "APPROVE_PUMP_HDR";
	public static final String APPROVING_PUMP   = "APPROVING_PUMP";
	public static final String STOPPING_PUMP    = "STOPPING_PUMP";
	public static final String CLAIMING_FUEL    = "CLAIMING_FUEL";
	public static final String CLAIMING_CUR     = "CLAIMING_CUR";
	public static final String CLAIMING_STK     = "CLAIMING_STK";
	public static final String PRINTING_RCPT    = "PRINTING_RCPT";
	public static final String RETRIEVING_RCPTS = "RETRIEVING_RCPTS";
	public static final String SILENCE_PUMP_HDR = "SILENCE_PUMP_HDR";
	public static final String SILENCING_PUMP   = "SILENCING_PUMP";
	public static final String WATCHING_PUMP   = "WATCHING_PUMP";
	public static final String DISMISS_FP_OFFLINE = "DISMISS_FP_OFFLINE";

	//Error status messages
	public static final String ERROR_APPROVE    = "ERROR_APPROVE";
	public static final String ERROR_RESTART    = "ERROR_RESTART";
	public static final String ERROR_SILENCE    = "ERROR_SILENCE";
	public static final String ERROR_WATCH      = "ERROR_WATCH";
	public static final String ERROR_DCR_LIST   = "ERROR_DCR_LIST";
	public static final String ERROR_DCR_PRINT  = "ERROR_DCR_PRINT";
	public static final String ERROR_COMMN      = "ERROR_COMMN";
    public static final String ERROR_COMM_TO     = "ERROR_COMM_TO";
    public static final String ERROR_INVALID_RSP = "ERROR_INVALID_RSP";
    public static final String ERROR_CALLBACK_REQ = "ERROR_CALLBACK_REQ";
    public static final String ERROR_CMD_ERR = "ERROR_CMD_ERR";
    public static final String ERROR_CNT_EXEC = "ERROR_CNT_EXEC";
    public static final String ERROR_SITE_NOT_INIT = "ERROR_SITE_NOT_INIT";
    public static final String ERROR_INVALID_TEIR = "ERROR_INVALID_TEIR";
    public static final String ERROR_INVALID_PPU_DEC = "ERROR_INVALID_PPU_DEC";
    public static final String ERROR_INVALID_TOT_DEC = "ERROR_INVALID_TOT_DEC";
    public static final String ERROR_INVALID_NO_FPS = "ERROR_INVALID_NO_FPS";
    public static final String ERROR_INVALID_AUTODS_DELAY = "ERROR_INVALID_AUTODS_DELAY";
    public static final String ERROR_INVALID_POSTPAY_START_HR = "ERROR_INVALID_POSTPAY_START_HR";
    public static final String ERROR_INVALID_POSTPAY_NUM_HR = "ERROR_INVALID_POSTPAY_NUM_HR";
    public static final String ERROR_INVALID_MANAPPR_START_HR = "ERROR_INVALID_MANAPPR_START_HR";
    public static final String ERROR_INVALID_MANAPPR_NUM_HR = "ERROR_INVALID_MANAPPR_NUM_HR";
    public static final String ERROR_INVALID_TIER_DETAILS = "ERROR_INVALID_TIER_DETAILS";
    public static final String ERROR_INVALID_FP_OFFLINE_NOTIFY = "ERROR_INVALID_FP_OFFLINE_NOTIFY";
    public static final String ERROR_INVALID_PRODUCT_ID = "ERROR_INVALID_PRODUCT_ID";
    public static final String ERROR_INVALID_TIER_START = "ERROR_INVALID_TIER_START";
    public static final String ERROR_INVALID_TIER_HOURS = "ERROR_INVALID_TIER_HOURS";
    public static final String ERROR_INVALID_START_TIER = "ERROR_INVALID_START_TIER";
    public static final String ERROR_INVALID_HOURS_TIER = "ERROR_INVALID_HOURS_TIER";
    public static final String ERROR_INVALID_TANK_FEED = "ERROR_INVALID_TANK_FEED";
    public static final String ERROR_INVALID_LOW_FEED_PERC = "ERROR_INVALID_LOW_FEED_PERC";
    public static final String ERROR_INVALID_PRICE = "ERROR_INVALID_PRICE";
    public static final String ERROR_INVALID_PRICE_DEC = "ERROR_INVALID_PRICE_DEC";
    public static final String ERROR_INVALID_PRICE_MAX = "ERROR_INVALID_PRICE_MAX";
    public static final String ERROR_PRICE_NOT_INIT = "ERROR_PRICE_NOT_INIT";
    public static final String ERROR_INVALID_PRICE_INIT = "ERROR_INVALID_PRICE_INIT";
    public static final String ERROR_INVALID_PRODUCT_CODE = "ERROR_INVALID_PRODUCT_CODE";
    public static final String ERROR_INVALID_PRODUCT_CODE_FP = "ERROR_INVALID_PRODUCT_CODE_FP";
    public static final String ERROR_INVALID_DEPARTMENT = "ERROR_INVALID_DEPARTMENT";
    public static final String ERROR_INVALID_DEPARTMENT_FP = "ERROR_INVALID_DEPARTMENT_FP";
    public static final String ERROR_INVALID_HOSE_ARRAY_SIZE = "ERROR_INVALID_HOSE_ARRAY_SIZE";
    public static final String ERROR_INVALID_HOSE_ID = "ERROR_INVALID_HOSE_ID";
    public static final String ERROR_FP_PARMS_NOT_INIT = "ERROR_FP_PARMS_NOT_INIT";
	public static final String ERROR_ITEM_ADDN  = "ERROR_ITEM_ADDN";
	public static final String ERROR_FUEL_SALE  = "ERROR_FUEL_SALE";
	public static final String ERROR_FP_MOVE    = "ERROR_FP_MOVE";
	public static final String ERROR_PREAUTH    = "ERROR_PREAUTH";
	public static final String ERROR_PREPAY     = "ERROR_PREPAY";
	public static final String ERROR_PREPAY_RSV = "ERROR_PREPAY_RSV";
	public static final String ERROR_PRESET     = "ERROR_PRESET";
	public static final String ERROR_UNRESERVE  = "ERROR_UNRESERVE";
    public static final String ERROR_RESERVE  = "ERROR_RESERVE";
    public static final String ERROR_AUTO_APPROVE = "ERROR_AUTO_APPROVE";
    public static final String ERROR_FP_MOVE_NOT_ALLOWED  = "ERROR_FP_MOVE_NOT_ALLOWED";
    public static final String ERROR_VIEW_STATUS  = "ERROR_VIEW_STATUS";
    public static final String ERROR_POSTPAY_NOTALLOWED  = "ERROR_POSTPAY_NOTALLOWED";
    public static final String ERROR_STK_POSTPAY_NOTALLOWED = "ERROR_STK_POSTPAY_NOTALLOWED";
    public static final String ERROR_STK_POSTPAY_LIMIT = "ERROR_STK_POSTPAY_LIMIT";
    public static final String ERROR_AUTH_PREPAY_IVLD_STATE  = "ERROR_AUTH_PREPAY_IVLD_STATE";
    public static final String ERROR_CANNOT_POST_CONFIG_UPDATE  = "ERROR_CANNOT_POST_CONFIG_UPDATE";
    public static final String ERROR_NULL_FUEL_SITE  = "ERROR_NULL_FUEL_SITE";
    public static final String ERROR_FUELPOSITION_TOTALS= "ERROR_FUELPOSITION_TOTALS";
    public static final String ERROR_BLENDPOSITION_TOTALS= "ERROR_FUELPOSITION_TOTALS";
    public static final String ERROR_INVALID_FUEL_SEQUENCE_NUM = "ERROR_INVALID_FUEL_SEQUENCE_NUM";
    public static final String ERROR_DATABASE_OPERATION = "ERROR_DATABASE_OPERATION";
    
	public static final String ERROR_STOP       = "ERROR_STOP";
	public static final String NO_PREPAY_STOP   = "NO_PREPAY_STOP";
    public static final String ERROR_GRADE_MAP_SFC_POS   = "ERROR_GRADE_MAP_SFC_POS";
    public static final String ERROR_GRADE_MAP_POS_SFC_SL   = "ERROR_GRADE_MAP_POS_SFC_SL";
    public static final String ERROR_GRADE_MAP_POS_SFC_GR   = "ERROR_GRADE_MAP_POS_SFC_GR";
    public static final String ERROR_IO_ERROR_GRADE_FILE   = "ERROR_IO_ERROR_GRADE_FILE";
    public static final String ERROR_IO_ERROR_HOSE_FILE   = "ERROR_IO_ERROR_HOSE_FILE";
    public static final String ERROR_IO_ERROR_SITECFG_FILE   = "ERROR_IO_ERROR_SITECFG_FILE";
    public static final String ERROR_IO_ERROR_BLEND_FILE   = "ERROR_IO_ERROR_BLEND_FILE";
    public static final String ERROR_IO_ERROR_SPICFG_FILE   = "ERROR_IO_ERROR_SPICFG_FILE";
    public static final String ERROR_SFC_NAK_RSP   = "ERROR_SFC_NAK_RSP";
    public static final String ERROR_SFC_INV_PRICE_LVL   = "ERROR_SFC_INV_PRICE_LVL";
    public static final String ERROR_INV_DISCOUNT_AMT   = "ERROR_INV_DISCOUNT_AMT";

	public static final String NO_PREPAY_APPROVE = "NO_PREPAY_APPROVE";
	public static final String NO_PREPAY        = "NO_PREPAY";
	public static final String NO_PREPAY_RIG    = "NO_PREPAY_RIG";
	public static final String FUEL_STATUS      = "FUEL_STATUS";
	public static final String ERROR_CONFIG_ACCESS = "ERROR_CONFIG_ACCESS";
	public static final String INVALID_FUELPOSN = "INVALID_FUELPOSN";
	public static final String UNASSIGNED_FUELPOSN = "UNASSIGNED_FUELPOSN";
	public static final String INACTIVE_FUELPOSN = "INACTIVE_FUELPOSN";
	public static final String ERROR_STATUS = "ERROR_STATUS";
	public static final String INVALID_SALES_STATE = "INVALID_SALES_STATE";
	public static final String INVALID_TXN_TYPE = "INVALID_TXN_TYPE";
	public static final String ALREADY_CLAIMED = "ALREADY_CLAIMED";
	public static final String ALREADY_IN_TICKET = "ALREADY_IN_TICKET";
	// DMS00023293
	public static final String FIFO_SALE = "FIFO_SALE";


	public static final String PRICE_CONFIG = "PRICE_CONFIG";
	public static final String SELECT_TIER = "SELECT_TIER";
	public static final String TIER = "TIER";
	public static final String SELECT_PRICE_CHG = "SELECT_PRICE_CHG";
	public static final String ENTER_FUEL_PRICE = "ENTER_FUEL_PRICE";
	public static final String FUEL_PROD = "FUEL_PROD";
	public static final String SERVICE_LEVEL = "SERVICE_LEVEL";
	public static final String PRICE_LEVEL = "PRICE_LEVEL";
	public static final String CUR_PRICE = "CUR_PRICE";
	public static final String CONFIRM_CHANGES = "CONFIRM_CHANGES";
	public static final String SAVING_CHANGES = "SAVING_CHANGES";
	public static final String ERROR_SAVING_CHANGES = "ERROR_SAVING_CHANGES";

	public static final String  ESIGN_INIT_TITLE = "ESIGN_INIT_TITLE";
	public static final String  ESIGN_INIT_PROMPT = "ESIGN_INIT_PROMPT";
	public static final String  PRICE_DISPLAY_COMMS_ERROR = "PRICE_DISPLAY_COMMS_ERROR";

	public static final String INSUFFICIENT_AMT  = "INSUFFICIENT_AMT";
	public static final String FUEL_ERROR  = "FUEL_ERROR";
	public static final String FUEL_INITIALIZATION_PENDING = "FUEL_INITIALIZATION_PENDING";

	public static final String FUEL_TAX_EXEMPT  = "FUEL_TAX_EXEMPT";
	public static final String FUEL_TAX_ADD  = "FUEL_TAX_ADD";
	public static final String FP_CONVERT  = "FP_CONVERT";
	public static final String FUEL_SITE_PAUSE_ACTIVE  = "FUEL_SITE_PAUSE_ACTIVE";
	public static final String FUEL_SITE_PAUSE_ACTIVATED  = "FUEL_SITE_PAUSE_ACTIVATED";
	public static final String FUEL_SITE_PAUSE_DEACTIVATED  = "FUEL_SITE_PAUSE_DEACTIVATED";
	public static final String CLEAR_PUMP_ON_HOLD  = "CLEAR_PUMP_ON_HOLD";
	
    public static final String PRICE_INIT = "PRICE_INIT";
    public static final String FUEL_INIT = "FUEL_INIT";
    
    // Rapid Change Fuel
    public static final String RCF_INIT = "RCF_INIT";
	public static final String INVALID_RCFC_ID = "INVALID_RCFC_ID";
	public static final String RCF_INIT_PEND     ="RCF_INIT_PEND";
	public static final String RCF_CONFIG = "RCF_CONFIG";

        // added for fuel detail view widget enhancement
        public static final String REST_IN_GAS  = "REST_IN_GAS";
        public static final String CLEAR_RESERVE_PUMP  = "CLEAR_RESERVE_PUMP"; /****cr1239.01-button to clear reserve pump*****/
        public static final String FILL_UP  = "FILL_UP";
        public static final String APPROVE_RESTART  = "APPROVE_RESTART";
        public static final String FUEL_STOP  = "FUEL_STOP";
        public static final String PRESET  = "PRESET";
        public static final String REPRINT  = "REPRINT";
        public static final String MOVE_PREPAY  = "MOVE_PREPAY";
        public static final String WATCH_FPUMP  = "WATCH_FPUMP";
        public static final String PREPAY  = "PREPAY";
        public static final String FUEL_POINT  = "FUEL_POINT";
        public static final String PUMP_STATUS  = "PUMP_STATUS";
        

	/**
	 * Accessor for the actual strings that have been internationalized.
	 */
	@Override
	public Object[][] getContents() {
		return this.contents;
	}

	protected Object[][] contents = {
		{FP, "FP"},
		{CURRENT_TXN, "Current"},
		{STACKED_TXN, "Stacked"},
		{DUE_SALE, "Due"},
		{SOLD_SALE, "Sold"},
		{HOLD_SALE, "Hold"},
		{NEW_SALE, "New"},
		{AUTHORIZED, "Authorized"},
		{CALLING, "Calling"},
		{FUELING, "Fueling"},
		{IDLE, "Idle"},
		{OFFLINE, "Offline"},
		{RESERVED, "Reserved"},
		{STOPPED, "Stopped"},
		{PREPAID, "Prepaid"},
		{FP_MOVE, "FP Move"},
		{FP_MOVE_FROM, "Pump to Move FROM"},
		{FP_MOVE_TO, "Pump to Move TO"},
		{FROM_PUMP, "from pump"},
		{MOVING_PREPAY, "Moving Prepay"},
		{TO_PUMP, "to pump"},
		{PRT_DCR_TRAN, "Reprint DCR Tran"},
		{MORE_FUEL_FNS, "More Fuel Func"},
		{SHOW_FUEL, "Show Fuel"},
		{HIDE_FUEL, "Hide Fuel"},
		{FUEL_SALE_FNS, "Fuel Sale Functions"},
		{FUELING_POINT, "Fueling Point"},
		{SELL_CURR_FUEL, "Sell Current Fuel Sale"},
		{SELL_STK_FUEL, "Sell Stacked Fuel Sale"},
		{SELL_FUEL, "Sell Fuel"},
		{APPROVE_PUMP, "Approve Calling Pump / Restart Stopped Pump"},
		{SILENCE_PUMP, "Silence Calling Pump"},
		{PREPAY_MOVE, "Move Prepaid Fuel"},
		{STOP_PUMP, "Stop Pump"},
		{WATCH_PUMP, "Watch Pump"},
		{APPROVE, "Approve"},
		{STOP, "Stop"},
		{FP_OFFLINE, "Fueling Position OFFLINE"},
		{PREPAY_FUEL, "Prepay Fuel"},
		{FILL_UP_FUEL, "Fill Up"},
		{ENTER_PUMP, "Enter pump number"},
		{ENTER_AMOUNT, "Enter Amount"},
		{ENTER_VOLUME, "Enter Volume"},
		{QTY_HELPER, "Press <QTY> to prepay by Volume"},
		{PUMP, "Pump"},
		{ON_PUMP, "on Pump"},
		{ENTER_MOP, "Enter Method Of Payment"},
		{MOPS, "Method Of Payments"},
		{SELECT_MOP, "Select MOP"},
		{FUEL_PRODUCTS, "Fuel Products"},
		{SELECT_PRODUCT, "Select Fuel Product"},
		{ENTER_PRODUCT, "Enter Fuel Product"},
		{PREPAY_STOP, "Prepay Stop"},
		{PREPAY_STOP_CMD, "Clear Reserved Pump (Prepay Stop)"},
		{PRESET_FUEL, "Preset Fuel"},
		{RIG, "Rest-In-Gas"},
		{CLEAR_RESERVE_PUMP, "Clear Reserve Pump"}, /****cr1239.01-button to clear reserve pump*****/
		{ENTER_AMOUNT_CASH, "Enter Amount (CASH)"},
		{DCR_REPRINT_HDR, "Preview / Reprint DCR Transactions"},
		{DCR_REPRINT, "DCR Transaction Reprint"},
		{FUEL_DETAIL, "Fuel Detail View"},
		{APPROVE_PUMP_HDR, "Approve / Restart Pump"},
		{APPROVING_PUMP, "Approving"},
		{STOPPING_PUMP, "Stopping"},
		{CLAIMING_FUEL, "Claiming fuel sale"},
		{CLAIMING_CUR, "Claiming current fuel sale"},
		{CLAIMING_STK, "Claiming stacked fuel sale"},
		{PRINTING_RCPT, "Printing DCR receipt"},
		{RETRIEVING_RCPTS, "Retrieving DCR receipt list"},
		{SILENCE_PUMP_HDR, "Silence Pump"},
		{SILENCING_PUMP, "Silencing"},
		{ERROR_APPROVE, "Error approving Pump"},
		{ERROR_RESTART, "Error restarting Pump"},
		{ERROR_SILENCE, "Error silencing Pump"},
		{ERROR_DCR_LIST, "Error retrieving DCR receipt list"},
		{ERROR_DCR_PRINT, "Error retrieving/ printing DCR transaction"},
		{ERROR_COMMN, "Error communicating with fuel server"},
		{ERROR_COMM_TO, "Error communication time out with fuel server"},
		{ERROR_INVALID_RSP, "Error invalid fuel server response"},
		{ERROR_CALLBACK_REQ, "Error invalid fuel server notification"},
		{ERROR_CMD_ERR, "Error request error"},
		{ERROR_CNT_EXEC, "Error cannot execute request"},
		{ERROR_SITE_NOT_INIT, "FuelSite not initialized"},
		{ERROR_INVALID_TEIR, "Invalid tier number: "},
		{ERROR_INVALID_PPU_DEC, "Invalid # PPU decimal position: "},
		{ERROR_INVALID_TOT_DEC, "Invalid # Total decimal position: "},
		{ERROR_INVALID_NO_FPS, "Invalid # pumps: "},
		{ERROR_INVALID_AUTODS_DELAY, "Invalid auto disapproval delay: "},
		{ERROR_INVALID_POSTPAY_START_HR, "Invalid postpay start hour: "},
		{ERROR_INVALID_POSTPAY_NUM_HR, "Invalid # postpay hours: "},
		{ERROR_INVALID_MANAPPR_START_HR, "Invalid man approval start hour: "},
		{ERROR_INVALID_MANAPPR_NUM_HR, "Invalid # man approval hours: "},
		{ERROR_INVALID_TIER_DETAILS, "Invalid tier details - startHr:  numHrs: "},
		{ERROR_INVALID_FP_OFFLINE_NOTIFY, "Invalid FP OFFLINE NOTIFY setting: "},
		{ERROR_INVALID_PRODUCT_ID, "Invalid product ID :"},
		{ERROR_INVALID_TIER_START, "Invalid start hours startHr: for tier: "},
		{ERROR_INVALID_TIER_HOURS, "Invalid number of tier hours: for tier: "},
		{ERROR_INVALID_START_TIER, "Invalid start hours startHr: for tier: "},
		{ERROR_INVALID_HOURS_TIER, "Invalid start hours startHr: for tier: "},
		{ERROR_INVALID_TANK_FEED, "Invalid feed tank"},
		{ERROR_INVALID_LOW_FEED_PERC, "Invalid Low Feed Percent"},
		{ERROR_INVALID_PRICE, "Invalid price"},
		{ERROR_INVALID_PRICE_DEC, "Invalid price: {} for Product:{} Decimal digits expected: {}"},
		{ERROR_INVALID_PRICE_MAX, "Invalid price: {} for Product:{} Max value exceeded"},
		{ERROR_PRICE_NOT_INIT, "Fuel prices not initialized"},
		{ERROR_INVALID_PRICE_INIT, "Invalid price init"},
		{ERROR_INVALID_PRODUCT_CODE, "Invalid product code"},
		{ERROR_INVALID_PRODUCT_CODE_FP, "Invalid configuration for {0} (invalid product code)"},
		{ERROR_INVALID_DEPARTMENT, "Invalid department"},
		{ERROR_INVALID_DEPARTMENT_FP, "Invalid configuration for {0} (invalid department)"},
		{ERROR_INVALID_HOSE_ARRAY_SIZE, "Invalid hose array size"},
		{ERROR_INVALID_HOSE_ID, "Invalid hoseID "},
		{ERROR_FP_PARMS_NOT_INIT, "Fuel position parameters not initialized"},
		{ERROR_ITEM_ADDN, "Error adding fuel sale to ticket"},
		{ERROR_FUEL_SALE, "Error processing fuel sale request"},
		{ERROR_FP_MOVE, "Error processing FP Move"},
		{ERROR_PREAUTH, "Error processing Approve - No Pre-auth"},
		{ERROR_PREPAY, "Error processing Prepay"},
		{ERROR_PREPAY_RSV, "Error reserving pump for Prepay"},
		{ERROR_PRESET, "Preset Not Allowed"},
		{ERROR_UNRESERVE, "Error unreserving pump"},
		{ERROR_RESERVE, "Error reserving pump"},
		{ERROR_FP_MOVE_NOT_ALLOWED, "FuelRT()#moveAuthorization: operation not allowed"},
		{ERROR_VIEW_STATUS, "Error getting fuel view status"},
		{ERROR_POSTPAY_NOTALLOWED, "Autorize Post Pay Not Allowed"},
		{ERROR_AUTO_APPROVE, "Error Auto-approving Pump"},
		{ERROR_STK_POSTPAY_NOTALLOWED, "Transaction Due on Pump. Stacking of PostPays Not Enabled"},
		{ERROR_STK_POSTPAY_LIMIT, "Due Postpay Stacking Limit Reached"},
		{ERROR_AUTH_PREPAY_IVLD_STATE, "Error Authroize Prepay Invalid State"},
		{ERROR_CANNOT_POST_CONFIG_UPDATE, "Error Cannot Post Fuel Configuration Update"},
		{ERROR_NULL_FUEL_SITE, "Error Invalid Fuel Site Data"},
		{ERROR_FUELPOSITION_TOTALS, "Error in Getting Fuel Position Totals"},
		{ERROR_BLENDPOSITION_TOTALS, "Error in Getting Blend  Totals"},
		{ERROR_STOP, "Error processing Pump Stop"},
		{ERROR_GRADE_MAP_SFC_POS, "Error mapping SFC to POS grade: "},
		{ERROR_GRADE_MAP_POS_SFC_SL, "Error mapping POS to SFC grade invalid service level: "},
		{ERROR_GRADE_MAP_POS_SFC_GR, "Error mapping POS to SFC grade invalid POS grade: "},
		{ERROR_IO_ERROR_GRADE_FILE, "Error creating grade.dat"},
		{ERROR_IO_ERROR_HOSE_FILE, "Error creating hose.dat"},
		{ERROR_IO_ERROR_SITECFG_FILE, "Error creating fp.config"},
		{ERROR_IO_ERROR_BLEND_FILE, "Error creating blend.dat"},
		{ERROR_IO_ERROR_SPICFG_FILE, "Error creating spiconfig.config"},
		{ERROR_SFC_NAK_RSP, "SFC NAK Response"},
		{ERROR_SFC_INV_PRICE_LVL, "SFC Invalid Pricing Level"},
		{ERROR_INV_DISCOUNT_AMT, "Invalid Discount Amount"},
		{ERROR_INVALID_FUEL_SEQUENCE_NUM, "Invalid Fuel Sequence No."},
		{ERROR_DATABASE_OPERATION, "Error in Database Operation"},
		{NO_PREPAY_STOP, "Prepay Stop not allowed"},
		{NO_PREPAY_APPROVE, "Prepay Approve not allowed"},
		{NO_PREPAY, "Preset Prepay not allowed"},
		{NO_PREPAY_RIG, "Rest In Gas not allowed - Payment already applied"},
		{FUEL_STATUS, "Fuel Status"},
		{ERROR_CONFIG_ACCESS, "Error retrieving fuel configuration"},
		{INVALID_FUELPOSN, "Invalid fueling position"},
		{UNASSIGNED_FUELPOSN, "Fueling point not available at this workstation"},
		{INACTIVE_FUELPOSN, "Inactive Fueling position"},
		{ERROR_STATUS, "Error getting fuel status for fuel point"},
		{INVALID_SALES_STATE, "Invalid sales state"},
		{INVALID_TXN_TYPE, "Invalid transaction type"},
		{ALREADY_CLAIMED, "Already claimed"},
		{ALREADY_IN_TICKET, "Already added to ticket"},
		{FIFO_SALE, "FIFO set. Settle stacked sale first."},
		{PRICE_CONFIG, "Fuel Price Configuration"},
		{SELECT_TIER, "Select Tier"},
		{TIER, "Tier"},
		{SELECT_PRICE_CHG, "Select Price to change"},
		{ENTER_FUEL_PRICE, "Enter new price"},
		{FUEL_PROD, "Product"},
		{SERVICE_LEVEL, "SL"},
		{PRICE_LEVEL, "PL"},
		{CUR_PRICE, "Current Price"},
		{CONFIRM_CHANGES, "Press Enter to commit changes"},
		{SAVING_CHANGES, "Saving changes"},
		{ERROR_SAVING_CHANGES, "Error saving changes"},
		{ESIGN_INIT_TITLE, "Site Sign"},
		{ESIGN_INIT_PROMPT, "Initialize Site text & Price sign?"},
		{PRICE_DISPLAY_COMMS_ERROR, "Price Display Offline"},
		{INSUFFICIENT_AMT, "Insufficient amount for Prepay"},
		{FUEL_ERROR, "Fuel Error"},
		{FUEL_TAX_EXEMPT, "Fuel Tax Exempt"},
		{FUEL_TAX_ADD, "Fuel Tax Add"},
		{FP_CONVERT, "FP Convert"},
		{FUEL_SITE_PAUSE_ACTIVE, "SITE-PAUSE ACTIVE"},
		{FUEL_SITE_PAUSE_ACTIVATED, "SITE PAUSE ACTIVATED"},
		{FUEL_SITE_PAUSE_DEACTIVATED, "SITE PAUSE DEACTIVATED"},
		{INIT_PEND, " Fuel Updates Pending"},
		{PRICE_PEND, "Fuel Prices Pending"},
		{INITIALIZING, "Initializing Fuel"},
		{INITIALIZED, "Initialized"},
		{PRICE_INITIALIZING, "Initializing Fuel Prices"},
		{PRICE_INITIALIZED, "Prices Initialized"},
		{CLEAR_PUMP_ON_HOLD, "Clear Pump on Hold for FP: #"},
		{PRICE_INIT, "Fuel Price Initialization"},
		{FUEL_INIT, "Fuel Initialization"},
		// added for fuel detail view widget enhancement
		{REST_IN_GAS, "Rest In Gas"},
		{CLEAR_RESERVE_PUMP, "Clear Reserve"}, /****cr1239.01-button to clear reserve pump*****/
		{FILL_UP, "FILL UP"},
		{APPROVE_RESTART, "Approve / Restart"},
		{FUEL_STOP, "Stop"},
		{PRESET, "Preset"},
		{REPRINT, "Reprint"},
		{MOVE_PREPAY, "Move Prepay"},
		{WATCH_FPUMP, "Watch Pump"},
		{PREPAY, "Prepay"},
		{RCF_INIT, "RCFC Initialization"},
		{RCF_INIT_PEND, "RCFC Updates Pending"},
		{RCF_CONFIG, "Rapid Change Fuel Configuration"},
		{INVALID_RCFC_ID, "Invalid Rapid Change Fuel Configuration ID"},
		{FUEL_INITIALIZATION_PENDING, "Fuel Initialization Pending ..."},
		{WATCHING_PUMP, "Watching Pump"},
		{DISMISS_FP_OFFLINE, "Touch [OK] Dismiss"},
		{FUEL_POINT, "Fuel Point"},
		{PUMP_STATUS, "Pump"},
		{ERROR_WATCH, "Error watching Pump"}
	};
}