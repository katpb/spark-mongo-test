package com.verifone.isd.vsms2.sys.db.pres;

/**
 * Interface to obtain IEntityPersistAdmin object based on
 * datasetID or entity object type.
 * @version 1.0 Copyright(c) 2000-2007 Verifone, All Rights Reserved.
 */
public interface IReferenceDataSystem {
    /*
     * Make PLU the first dataset since the order is used by Gempro to
     * determine if sync request is required. Without this change, if
     * plu and menukey files were changes, menukey sync request would
     * be sent first followed by plu request. When menukey sync request
     * is processed, plu file is sent to gempro (to make sure menukey
     * plu's are in the cache) and this would overwrite the plu file
     * before it is fetched to newpro for sync request processing.
     * NOTE: If any other dataset dependencies are identified, move
     * them to the appropriate position at the top of this list.
     */
    public static final int START_ENTITY = 1;
    public static final int PLU                 = 1;
    public static final int CATEGORY            = 2;
    public static final int CHECK_FRANK         = 3;
    public static final int CURRENCY            = 4;
    public static final int AGE_VALIDN          = 5;
    public static final int DCR_RCPT_HDR        = 6;
    public static final int DCR_MESSAGE         = 7;
    public static final int DCR_RCPT_TRL        = 8;
    public static final int DEPARTMENT          = 9;
    public static final int DEPARTMENT_TRACK    = 10;
    public static final int EMPLOYEE            = 11;
    public static final int EMPLOYEE_AUTH       = 12;
    public static final int FEE_CHARGE          = 13;
    public static final int FUEL_MOP            = 14;
    public static final int FUEL_PARAMS         = 15;
    public static final int FUEL_PRICE          = 16;
    public static final int FUEL_PRODUCT        = 17;
    public static final int FUEL_POINT          = 18;
    public static final int FUEL_SERVICE_LEVEL  = 19;
    public static final int FUEL_TANK_NAME      = 20;
    
    /*
    On the Sapphire end, Logo and Slogan are 2 different object types
    and do not go by the Ruby convention of 1 to 5 = Logo, 6 to 10 = Slogan.
    Therefore all references within and from/to Ruby will be separated as
    LOGO and SLOGAN. Ruby could respond with the same dataset for both
    requests. The persist state objects will discard or accept records based
    on their valid lineNr range.
     */
    public static final int LOGO                = 21;
    public static final int SLOGAN              = 22;
    public static final int MENU_KEY            = 23;
    public static final int MOP                 = 24;
    public static final int BANNER              = 25;
    public static final int PLU_PROMO           = 26;
    public static final int PLU_TRACK           = 27;
    public static final int PROD_CODE           = 28;
    public static final int SECURITY_CTRL       = 29;
    public static final int SOFT_KEY            = 30;
    public static final int SYS_DATE_TIME       = 31;
    public static final int TAX_BRK_PT          = 32;
    public static final int TAX_RATE            = 33;
    public static final int BLUE_LAW            = 34;
    public static final int VERSION             = 35;
    public static final int KEYBD               = 36;
    public static final int SALES_CFG           = 37;
    public static final int FUEL_PERIOD1_TOTALS = 38;
    public static final int FUEL_PERIOD2_TOTALS = 39;
    public static final int PAYROLL_CURRENT     = 40;
    public static final int PAYROLL_PREVIOUS    = 41;
    public static final int POP                 = 45;
    public static final int POPCOUPON           = 46;
    public static final int POPDEF              = 47;
    public static final int POPSITEINFO         = 48;
    public static final int DCRCFG              = 49;
    public static final int NETCARD_NAME        = 50;
    public static final int LOGINOUT            = 51;
    public static final int CWCFG               = 52;
    public static final int TLSSITEINFO         = 53;
    public static final int CASHACCSITEINFO     = 54;
    public static final int NETCCARD            = 58;    
    public static final int NETDLR              = 59;    
    public static final int NETINFO             = 60;    
    public static final int NETDEBIT            = 61;    
    public static final int NETPPAID            = 62;    
    public static final int NETPHONE            = 63;    
    public static final int NETBATCH            = 64;    
    public static final int USER                = 65; 
    public static final int ROLE                = 66; 
    public static final int PROPNET             = 67;    
    public static final int PROPCARD            = 68;
    public static final int NETEBT              = 69;    
    public static final int FUELTAXEX           = 70;    
    public static final int FUELTAXRCPT         = 71;    
    public static final int REPORTMGR           = 72;    
    public static final int PROMOCOMBO          = 73;
    public static final int PROMOITEMLISTPLU    = 74;
    public static final int PROMOITEMLISTDEPT   = 75;
    public static final int PROMOMIXANDMATCH    = 76;
    public static final int COUPONFAM		= 77;
    public static final int JOBCODE     	= 78;    
    public static final int CAT_TRACK           = 80;
    public static final int INHOUSEACCT			= 81;
    public static final int CWPAYPOINTCFG		= 82;
    public static final int ESAFE_DEVICECONFIG  = 83;
    public static final int ESAFE_IDMAPPINGS    = 84;
    public static final int ESAFE_SITECONFIG    = 85;
    public static final int ECHECKCONFIG        = 86;    
    public static final int CARWASH_TOTALS      = 87;
    public static final int CASHIER_MOP_TOTALS  = 88;
    public static final int CASHIER_TOTALS      = 89;
    public static final int CATEGORY_TOTALS     = 90;
    public static final int DCRSTAT             = 91;
    public static final int DEAL_TOTALS         = 92;
    public static final int DEPARTMENT_TOTALS   = 93;
    public static final int FP_HOSE_RUNNING_TOTALS = 94;
    public static final int FPHOSE_TOTALS       = 95;
    public static final int FACOLLECT_TOTALS    = 96;
    public static final int FCACCEPTOR_TOTALS   = 97;
    public static final int FINFO_TOTALS        = 98;
    public static final int FUELTANK_TOTALS     = 99;
    public static final int HOURLY_TOTALS       = 100;
    public static final int LOYALTY_TOTALS      = 101;
    public static final int MODEVICE_TOTALS     = 102;
    public static final int MOP_TOTALS          = 103;
    public static final int NETWORK_CARD_TOTALS = 104;
    public static final int NETWORK_PRODUCT_TOTALS = 105;
    public static final int PAYROLL_CLOCK_TOTALS = 106;
    public static final int PAYROLLPERIOD_TOTALS = 107;
    public static final int PERIODINFO_TOTALS   = 108;
    public static final int PLUCOUNT_TOTALS     = 109;
    public static final int PLU_TOTALS          = 110;    
    public static final int POPDISCOUNT_TOTALS  = 111;    
    public static final int PREPAIDTOTALS       = 112;
    public static final int SUMMARY_TOTALS      = 113;
    public static final int TANKHOURLEAK_TOTALS = 114;
    public static final int TANKMONALARMHIST_TOTALS = 115;
    public static final int TANKMONDELIVERY_TOTALS = 116;
    public static final int TANKMONEXTALARMHIST_TOTALS = 117;
    public static final int TANKMONFLAGS_TOTALS = 118;
    public static final int TANKMONINVENTORY_TOTALS = 119;
    public static final int TANKMON_LEAK        = 120;
    public static final int TANKMON_MISC        = 121;
    public static final int TANK_RECON          = 122;
    public static final int TAX_TOTALS          = 123;	
    public static final int TERMINAL_INFO_TOTALS = 124; 
    public static final int CWPAYPOINT_RECON = 125;
    public static final int CWPAYPOINT_WASHES = 126;
    public static final int ECHECK_TOTALS = 127;
    public static final int ECHECK_DETAILS = 128;
    public static final int ESAFE_DEVICE = 129;
    public static final int ESAFE_DEVICE_MOP = 130;
    public static final int ESAFE_MOP = 131;    
    public static final int CASHIER_ESAFE_DEVICE = 132;
    public static final int CASHIER_ESAFE_DEVICE_MOP = 133;
    public static final int CASHIER_ESAFE_MOP = 134;
    public static final int CWPAYPOINT_PERIOD = 135;
    public static final int CWPAYPOINT_PD_RECON = 136;
    public static final int POPDEFINITION_TOTALS  = 137;   
    public static final int IPT_SITEPARAMS      = 138;    
    public static final int IPT_POSITIONS       = 139;
    public static final int IPT_ALLOWMOP 		= 140;
    public static final int POS_TERMINAL_CONFIG = 141;
    public static final int DEVICE_VERSION = 142;
    public static final int MIDDLEWARE_VERSION = 143;    
    public static final int DISPENSER_INTERFACE = 144;
    public static final int DISPENSER = 145;
    public static final int PIN_ENTRY_DEVICE = 146;   
    public static final int PERIPHERAL = 147;
	public static final int FUEL_PRICE_TOTALS = 148;
	public static final int FUEL_PRICE_PERIOD = 149;
	public static final int FUEL_DISPENSER_TOTALS = 150;
    public static final int DCR_NETWORK_RECEIPT_TRAILER_LINE = 151;
    public static final int INSIDE_NETWORK_RECEIPT_TRAILER_LINE = 152;
    public static final int BLEND_PRODUCT = 153;
    public static final int BLEND_PERCENT = 154;
    public static final int READONLY_USER = 155;
    public static final int COUPON_SITE_CONFIG = 156;
	public static final int NET_POS_CFG = 157; 
    public static final int SITEINFO      = 158;
    public static final int EPS_PREPAIDCONFIG       = 159;    
    public static final int POS_CONFIG       = 160;
    public static final int VENDING_CONFIG       = 161;
    public static final int DISCOUNT_DENOM = 162;
    public static final int READONLY_EMPLOYEE = 163;
    public static final int RAPID_CHANGE_FUEL_CONFIG = 164;
    public static final int MAX_BASE_ENTITY_ID = 450;
    public static final int MANAGER_REVIEW_STATUS = 166;
    public static final int MANAGER_FINALIZE_INFO = 167;
    public static final int MANAGER_ADJUSTMENT = 169;
    public static final int TILL_EVENT = 170; 
    public static final int FUEL_PRICE_POSTGRES=171;
    public static final int VHQ_CONFIG = 172;
    public static final int THIRD_PARTY_PRODUCT_PROVIDER_CONFIG = 173;
    public static final int APT_GLOBAL_CONFIG = 174;
    public static final int APT_TERMINAL_CONFIG = 175;
    public static final int VISTA_TERMINAL_GROUP=176;
    public static final int VISTA_TERMINAL_CONFIG=177;
    public static final int MANAGE_DEVICES = 178;
    public static final int READONLY_MANAGE_DEVICES = 179;
    public static final int FISCAL_RECEIPT_CONFIG = 180;
    public static final int VISTA_ITEM_SUBSET_CONFIG = 181;
    public static final int VISTA_ITEMSET_CONFIG = 182;
    public static final int VISTA_TERMINAL_PREVIEW_CONFIG = 183;
    public static final int IMAGE_CONFIG = 184;
    public static final int FUEL_FLAT_TAX_CONFIG = 185;
    public static final int FISCAL_RECEIPT_TAX_EXEMPT_CONFIG = 186;
    public static final int FISCAL_CUSTOMER_TAX = 187;
    public static final int CHARITY = 188;
    public static final int SOFTKEYTYPE_SECURITY_CONFIG = 189;
	public static final int EMPLOYEE_PREFERENCES = 190;
	public static final int END_ENTITY          = EMPLOYEE_PREFERENCES;

    /**
     * Get the primary persist admin for a given entity.
     * @param dataSetID Entity ID.
     * @throws DBException On error in creating/ obtaining the persist admin object
     * @return Primary persist admin for the entity.
     */    
    public IEntityPersistAdmin getPersistAdmin(int dataSetID) throws DBException ;
  
    /**
     * Get the primary persist admin for a given entity object.
     * @param domainObj entity object to find persist admin.
     * @throws DBException On error in creating/ obtaining the persist admin object.
     * @return Primary persist admin for the entity object.
     */
    
    public IEntityPersistAdmin getPersistAdmin(IEntityObject domainObj) throws DBException ;
    
    /**
     * Returns an array of all entity id in sorted order (lowest first).
     * @return Entity id array.
     */ 
    public int[] getEntityIds();
}
