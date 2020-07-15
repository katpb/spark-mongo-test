/*
 * MenuID.java
 *
 * Created on August 30, 2003, 11:57 PM
 */

package com.verifone.isd.vsms2.sys.ent.securityctrl;

/** This class defines the contants to be used with SecurityCtrl
 * in order to access the SecurityLevel of a function.
 * The menuID string to be passed has to match the Gemcom MenuID strings
 * defined. The other parameter to access the function is
 * the SubMenuID which is defined in class SubMenuID.
 * @author anju_a1
 */
public class MenuID {
    
    public static final String FUEL_MANAGER = "FUE";
    
    public static final String NETWORK_MANAGER = "NET";
    
    public static final String DCR = "DCR";
    
    public static final String CAR_WASH = "CWA";
    
    public static final String CONFIGURATION = "CFG";
    
    public static final String FLASH_REPORTS = "FSH";
    
    public static final String MAINTENANCE = "MNT";
    
    public static final String REPORTS = "RPT";
    
    public static final String SECURITY = "SEC";
    
    public static final String SYSTEM_MANAGER = "SYS";
    
    public static final String TAVE_CONFIGURATION = "TCF";
    
    public static final String UNATTENDED_CONFIGURATION = "UCF";
    
    /** Creates a new instance of MenuID */
    public MenuID() {
    }
    
}
