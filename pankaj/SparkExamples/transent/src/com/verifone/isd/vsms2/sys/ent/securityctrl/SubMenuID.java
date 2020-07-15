/*
 * SubMenuID.java
 *
 * Created on August 31, 2003, 12:19 AM
 */

package com.verifone.isd.vsms2.sys.ent.securityctrl;

/** This class is created to define the constants to be used
 * with the SecrityCtrl. The constants defined here are the
 * SubMenuIDs and need to be used with the MenuID in order
 * to retrieve the SecurityLevel for a function.
 * @author anju_a1
 */
public class SubMenuID {
    
    /* DCR Functions */
    
    public static final String DCR_ENABLE_DISABLE = "DED";
    
    public static final String DCR_RECEIPT_HEADER = "DRH";
    
    public static final String DCR_RECEIPT_TRAILER = "DRT";
    
    /* Fuel Manager Functions */
    
    public static final String CLEAR_PUMPS_ON_HOLD = "CPH";
    
    public static final String INITIALIZE_DCR = "IND";
    
    public static final String INITIALIZE_FUEL = "INF";
 
    public static final String RESET_CONTROLLER = "RCT";
    
    public static final String FUEL_SITE_PAUSE = "SPF";
    
    public static final String TAVE_CONFIGURATION = "TCG";

    public static final String UNATTENDED_CONFIGURATION = "UCG";
    
    /* Maintenance Functions */
    
    public static final String ADJUST_BUZZER_VOLUME = "ABV";
    
    public static final String DISABLE_PRINTER = "DPR";
    
    public static final String ENABLE_PRINTER = "EPR";
    
    public static final String FLUSH_PRINTER_QUEUE = "FPR";
    
    public static final String PRINT_INSTALLATION_INFO = "INS";
    
    public static final String REBOOT_SYSTEM = "RBS";
    
    public static final String SET_DATE_TIME = "SDT";
    
    public static final String VERSION_INFO = "VER";
    
    public static final String ADJUST_TOPAZ_VOLUME = "ATV";

    public static final String ADJUST_BRIGHTNESS = "ABT";
    
    public static final String SYSTEM_MESSAGES = "MSG";
    
    public static final String SELECT_LANGUAGE = "SLG";
    
	public static final String DEVICE_CONFIG = "DCG";

	public static final String PINPAD_CONFIG = "PCG";
    
	public static final String SCANNER_CONFIG = "SCG";
	
    
    /* Network Manager Functions */
    
    public static final String BATCH_DUMP = "BDP";
    
    public static final String BATCH_DETAILS = "BDT";
    
    public static final String BALANCE_INQUIRY = "BIQ";
    
    public static final String JOURNAL_LOG = "BJL";
    
    public static final String ENCRYPTION_KEY_CHANGE = "EKC";
    
    public static final String PARAMETER_DOWNLOAD = "PNL";
    
    /* Report Functions */
    
    public static final String CURRENT_CASHIER_REPORT = "CCR";
    
    public static final String CLOSE_CASHIER_TOTALS = "CCT";
    
    public static final String CLOSE_SHIFT = "CL1";
    
    public static final String CLOSE_DAILY = "CL2";
    
    public static final String CLOSE_MONTHLY = "CL3";
    
    public static final String CLOSE_YEARLY = "CL4";
    
    public static final String PRINT_CASHIER_REPORT = "PCR";
    
    public static final String PRINT_CURRENT_CASHIER_REPORT = "CCR";
    
    public static final String PRINT_WORK_SHEET = "PWS";
    
	public static final String PRINT_SHIFT_REPORT = "PR1";
	public static final String PRINT_DAILY_REPORT = "PR2";
	public static final String PRINT_MONTHLY_REPORT = "PR3";
	public static final String PRINT_YEARLY_REPORT = "PR4";
    
    

    public static final String CLOSE_CWPAYPOINT = "CCP";    
    
    public static final String PRINT_CWPAYPOINT = "PCP";
    
    public static final String FLASH_ESAFE_CONTENT = "ESC";    

	public static final String INITIALIZE_E_SIGN = "IES";
	
    public static final String FUNDS_AUDIT_REPORT = "FAR";
	
    public static final String VIEW_AMBER = "AMB";
    
    /* TAVE Configuration Functions */

    public static final String REGISTER_DCR = "RGD";
    
    public static final String INCREMENT_DCR_KEY = "IDK";
    
    public static final String UPDATE_DCR_SETTINGS = "UDS";
    
    /* Unattended Configuration Functions */
    public static final String ENABLE_UNATTENDED = "EUM";
    
    public static final String DISABLE_UNATTENDED = "DUM";
    
    public static final String SCHEDULE_UNATTENDED = "SUM";
    
	/** Creates a new instance of SubMenuID */
    public SubMenuID() {
    }
    
}
