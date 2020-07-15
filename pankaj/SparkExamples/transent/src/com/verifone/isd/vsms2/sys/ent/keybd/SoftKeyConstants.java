/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
*
* Created 11 Mar, 2005                                     Sudesh Srinivasan
*/
package com.verifone.isd.vsms2.sys.ent.keybd;

/**
 * Key Constant values used in Topaz for softkey types.
 * @author  sudesh_s1
 * @version 1.0
 */
public class SoftKeyConstants {
	
	public static final int KB_UNDEFINED  = 0x0;
    /** Fuel function keys run from 0 - 15 inclusive */
    public static final int KB_FUELRANGE_BEGIN  = 0x1;
    public static final int KB_FUEL_APPR   = 0x1;
    public static final int KB_FUEL_PREP   = 0x2;
    public static final int KB_FUEL_VIEW   = 0x3;
    public static final int KB_FUEL_FSALE  = 0x4;
    public static final int KB_FUEL_OTHFUEL= 0x5;
    public static final int KB_FUEL_FPMOVE = 0x6;
    public static final int KB_FUEL_FDISC  = 0x7;
    public static final int KB_FUEL_PCONV  = 0x8;
    public static final int KB_FUEL_PRESET = 0x9;
    public static final int KB_FUEL_STOP   = 0xa;
    public static final int KB_FUEL_SILENCE = 0xb;  
    public static final int KB_FUEL_PREPAY_STOP   = 0xc;    
    public static final int KB_FUEL_WATCH   = 0xd;    
    public static final int KB_FUEL_RIG    = 0xe;		// Rest In Gas
    public static final int KB_FUEL_FILLUP  = 0xf;
    public static final int KB_FUELRANGE_END  = 0xf;

    /** POS and other system control keys run from 16 - 63 inclusive */
    public static final int KB_FCT_EXIT  = 0x10;
    public static final int KB_FCT_TVOID = 0x11;
    public static final int KB_FCT_LVOID = 0x12;
    public static final int KB_FCT_ECORR = 0x13;
    public static final int KB_FCT_CLEAR = 0x14;
    public static final int KB_FCT_PRINT = 0x15;
    public static final int KB_FCT_TICKET= 0x15;
    public static final int KB_FCT_ARROW_RIGHT = 0x15;
    public static final int KB_FCT_QTY   = 0x16;
    public static final int KB_FCT_ARROW_LEFT = 0x16;
    public static final int KB_FCT_ENTER = 0x17;
    public static final int KB_FCT_TOTAL = 0x18;
    public static final int KB_FCT_SUSPEND= 0x19;
    public static final int KB_FCT_RESUME = 0x19;	// Note ALIAS to suspend
    public static final int KB_FCT_REFUND = 0x1a;
    public static final int KB_FCT_MODIFY = 0x1b;
    public static final int KB_FCT_NOSALE = 0x1c;
    public static final int KB_FCT_PRICEOVER = 0x1d;
    public static final int KB_FCT_ALLOWFS   = 0x1e;
    public static final int KB_FCT_OTHERCURR = 0x1f;
    public static final int KB_FCT_DISCDOLLAR = 0x20;
    public static final int KB_FCT_DISCPERCENT = 0x21;
    public static final int KB_FCT_NETWORKFCT  = 0x22;
    public static final int KB_FCT_OTHERDEPT = 0x23;
    public static final int KB_FCT_TAXEXEMPT = 0x24;
    public static final int KB_FCT_DISC = 0x25;
    public static final int KB_FCT_LIST = 0x26;
    public static final int KB_FCT_SELECT = 0x27;
    public static final int KB_FCT_CLOCKINOUT = 0x28;
    public static final int KB_FCT_SAFELOAN = 0x29;
    public static final int KB_FCT_SAFEDROP = 0x2a;
    public static final int KB_FCT_PAYIN = 0x2b;
    public static final int KB_FCT_PAYOUT = 0x2c;
    public static final int KB_FCT_OTHERFCT = 0x2d;
    public static final int KB_FCT_PRICE_CHK = 0x2e;
    public static final int KB_FCT_RECALL    = 0x2f;
    public static final int KB_FCT_HELP_KEY = 0x30;
    public static final int KB_FCT_DISMISS_HELP_KEY = 0x31;
    public static final int KB_FCT_UPDATED = 0x32;	// COR signal: trans changed
    public static final int KB_FCT_FREE_POP = 0x33;
    public static final int KB_FCT_FORCE_EXIT = 0x34;
    public static final int KB_FCT_DRWR_OPEN = 0x35;
    public static final int KB_FCT_DRWR_CLOSE = 0x36;
    public static final int KB_FCT_TIMER_EXP = 0x37;
    public static final int KB_FCT_FUEL_TAX_EXEMPT = 0x38;
    public static final int KB_FCT_FUEL_TAX_ADD = 0x39;
    public static final int KB_FCT_FPRINT = 0x3a;	// Fuel Item(s) Reprint
    public static final int KB_FCT_REPEAT_LAST_ITEM = 0x3b;
    public static final int KB_FCT_KIOSK_ORDER = 0x3c;
    public static final int KB_FCT_PURGE_KIOSK_ORDER = 0x3d;  
    public static final int KB_FCT_GIFT_ACTIVATE = 0x3e;
    public static final int KB_FCT_GIFT_RECHARGE = 0x3f;
    public static final int KB_FCT_POP_MEM = 0x40;
//  code added by tattu for safe drop correction
    public static final int KB_FCT_SAFEDROP_CORR = 0x41;
   
    public static final int KB_FCT_VKBD = 0x42;

    public static final int KB_FCT_FLASH_RPTS = 0x43;
    public static final int KB_FCT_LOYALTY_SCAN = 0x44;
    public static final int KB_FCT_DISMISS_REPORT = 0x45;
    public static final int KB_FCT_PRINT_REPORT = 0x46;
    public static final int KB_FCT_SAVE_REPORT = 0x47;
    public static final int KB_FCT_LOYALTY_BALANCE = 0x48;
	public static final int KB_FCT_REMKIOSKORD = 0x49;
	public static final int KB_FCT_EDITFOODORDER = 0x50;
	public static final int KB_FCT_FREE_AUTO_POP = 0x51;

	public static final int KB_FCT_THIRD_PARTY_PROD = 0x70;
	public static final int KB_FCT_CHOOSE_PINPAD = 0x71;
	public static final int KB_FSC_CUST_TAX_INFO = 0x72;

// cr1151.01 - Kitchen "Place Order" (suspend) and "Get Order" (recall)
    public static final int KB_FCT_PLACE_ORDER = 0x4a;
    public static final int KB_FCT_GET_ORDER = 0x4b;
    
    // CR 1524.01 Special exit for period close
    public static final int KB_FCT_PDCLOSE_EXIT = 0x4c;
    
    /* AEOD*/
    public static final int KB_AEOD_WARNING = 0x4d;

    public static final int KB_FCT_REBOOT  = 0x4e;
    public static final int KB_FCT_SAVE = 0x4f;
    
    /** MOP keys run from 64 - 95 inclusive */
    /*public static final int	KB_MOP_CASH  = 0x40;
    public static final int     KB_FCT_NOKEY = KB_MOP_CASH;
    public static final int	KB_MOP_CASH1 = 0x41;
    public static final int	KB_MOP_CASH5 = 0x42;
    public static final int	KB_MOP_CASH10 = 0x43;
    public static final int	KB_MOP_CASH20 = 0x44;
    public static final int	KB_MOP_CASH50 = 0x45;
    public static final int	KB_MOP_NEXTDOLLAR = 0x46;
    public static final int	KB_MOP_CREDIT = 0x47;
    public static final int	KB_MOP_DRIVEOFF = 0x48;
    public static final int	KB_MOP_OTHERMOP = 0x49;
    public static final int	KB_MOP_CHECK = 0x4a;
    public static final int	KB_MOP_LOTTO = 0x4b;
    public static final int	KB_MOP_FOODSTAMP = 0x4c;
    public static final int	KB_MOP_COUPON = 0x4d;
    public static final int	KB_MOP_DEBIT = 0x4e;
    public static final int	KB_MOP_SVC = 0x4f;
    public static final int	KB_MOP_HOUSECHG = 0x50;
    public static final int	KB_MOP_PUMPTEST = 0x51;
    public static final int	KB_MOP_MANUALCREDIT = 0x52;
    public static final int	KB_MOP_MANUALDEBIT = 0x53;
    public static final int	KB_MOP_ELECTRFS = 0x54;
    public static final int	KB_MOP_EBTCB = 0x55;
    public static final int	KB_MOP_EBTFS = 0x56;
    public static final int	KB_MOP_SPDISC = 0x57;*/

    public static final int	KB_MOP_NEXTDOLLAR = 0x5c;
    public static final int	KB_MOP_OTHERMOP = 0x5d;
    public static final int KB_FCT_NOKEY = 0x5e;
    public static final int     KB_FCT_YESKEY = 0x5b;
    public static final int	KB_MOP_MOPTYP = 0x5f;
    //public static final int	KB_MOP_MAXMOP = 0x5f;

    /** Application PLU/Department/Menu/Function keys run from 96 - 3167 */
    public static final int KB_PLU = 0x200; // Explicitly map PLU softkey type to a KeyConstant    
    public static final int KB_DEPARTMENT_KEY_DELTA = 0x400; // above CUSTOM
    public static final int KB_DEPARTMENT_KEY = 0x85f;
    public static final int KB_MENU_KEY_DELTA = 0x800;	// above DEPT
    public static final int KB_MENU_KEY = 0xc5f;
    public static final int KB_FUEL_KEY_DELTA = 0xc00;	// above MENU
    public static final int KB_FUEL_KEY = 0xcbf;
    
    public static final int KB_KEY_UNASSIGNED = 0xffffffff;
    /** Editting key codes used for field editting */
    public static final int KEY_EDIT_BS  = 4001;

	/** Special key codes used by the KeyboardLexStrategy **/
    public static final int KEY_SHIFT_MODE = 0x7fffff00;


    /** POS Numeric and other keys run from 48 - 63 inclusive
     * NOTE: These values are 'pend'ing codes. 
     */
    public static final int	KB_NUM_00 = 4006;    

    public static final int	KB_MANUAL_PLU = 0x60;
    
    public static final int	KB_MANAGED_UPDATE = 0x61;

    public static final int	KB_FCT_EXCEPTION_PRINT = 0x62;
    
    public static final int KB_FCT_SCREEN_UNLOCK = 0x2038;
}
