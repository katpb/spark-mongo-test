/*
 * SoftKeyType.java
 *
 * Created on April 29, 2003, 5:40 PM
 */

package com.verifone.isd.vsms2.sales.ent.softkey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.ent.keybd.SoftKeyConstants;
import com.verifone.isd.vsms2.sys.ent.securityctrl.SecurityCtrlPK;
import com.verifone.isd.vsms2.sys.l10n.LocalizedRB;
import com.verifone.isd.vsms2.sys.l10n.TopazRes;


/** Type-safe enumeration of all soft key types
 * TO DO: Convert all the strings here to support i18n, Uncomment (and
 * change the method description?) the abstract method and provide concrete
 * control classes for each softkey type processing. Provide a
 * vanilla control class and subclass it as we add support for each softkey type?
 * @author Bhanu_N2
 */
public class SoftKeyType implements java.io.Serializable {
	private static final long serialVersionUID = -4484649362118028962L;
	private transient String code;
    private transient String description;
    private transient Class mappedPKClass;
	private transient boolean disallowedOnRuby;
    private transient int keyConstant;
    private transient SecurityCtrlPK securityCtrl;
    private transient boolean securityLevelConfigurable;
    private transient boolean transactionLevelKey;
    private transient SoftKeyType parentSoftKeyType;
    
    private static  ArrayList<SoftKeyType> securityLevelConfigurableKeys = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(SoftKeyType.class);
    
    /**
     * Constructor to use with builder
     * @param builder
     */
    protected SoftKeyType(SoftKeyBuilder builder) {
    	 this.code = builder.code;
         this.description = builder.description;
         this.mappedPKClass = builder.mappedPKClass;
         this.disallowedOnRuby = builder.disallowedOnRuby;
         this.keyConstant = builder.keyConstant;
         this.securityCtrl = builder.securityCtrl;
         this.securityLevelConfigurable = builder.securityLevelConfigurable;
         this.transactionLevelKey = builder.transactionLevelKey;
         this.parentSoftKeyType = builder.parentSoftKeyType;
    }
    
    /** Constructor to allow subclassing
     * @param code Unique 3 letter softkey type as used by Gemcom
     * @param description softkey type's description
     * @param pkClassName null or an IEntityPK class name if an object 
     * id is reqd (e., PLU, Dept, MOP)
     */
    protected SoftKeyType(String code, String description, String pkClassName, 
            boolean disallowedOnRuby, int keyConstant) {
        this(code, description, pkClassName, disallowedOnRuby, keyConstant, null);
    }
    
    
    /**
     * Constructor to allow subclassing 
     * @param code
     * @param description
     * @param pkClassName
     * @param disallowedOnRuby
     * @param keyConstant
     * @param securityCtrl
     */
    protected SoftKeyType(String code, String description, String pkClassName,
            boolean disallowedOnRuby, int keyConstant, SecurityCtrlPK securityCtrl) {
    	this(code, description, pkClassName, disallowedOnRuby, keyConstant, securityCtrl ,false);
    }
    
    
    protected SoftKeyType(String code, String description, String pkClassName,
            boolean disallowedOnRuby, int keyConstant, SecurityCtrlPK securityCtrl, boolean securityLevelConfigurable) {
        this.code = code;
        this.description = description;

        
        if (pkClassName != null) {
            try {
                this.mappedPKClass = Class.forName(pkClassName);
            }
            catch (Exception e){
            	logger.debug("Error creating instance of {}", pkClassName);
            }
        }
        this.disallowedOnRuby = disallowedOnRuby;
        this.keyConstant = keyConstant;
        this.securityCtrl = securityCtrl;
        this.securityLevelConfigurable = securityLevelConfigurable;
    }
    
    
    /** Override toString() method to provide the MOP code's description
     * @return MOP code's description
     */    
    public String toString() {
        return this.description;
    }
    
    /** Getter for softkey type
     * @return softkey type
     */    
    public String getCode() {
        return this.code;
    }
    
    /** Getter for mapped PK class for the softkey type
     * @return mapped PK class
     */    
    public Class getMappedPKClass() {
        return this.mappedPKClass;
    }
        
    /** Getter for disallowedOnRuby for the softkey type
     * @return disallowedOnRuby
     */    
    public boolean isDisallowedOnRuby() {
        return this.disallowedOnRuby;
    }

    /**
     * @return Returns the keyConstant.
     */
    public int getKeyConstant() {
        return keyConstant;
    }
    
    /** Prevent subclasses from overriding Object.hashCode() to ensure
     * the following contract of typesafe enum:
     * "All equal objects of the enumerated type are also
     * identical i.e., a.equals(b) iff a==b".
     * Thus, it is enough to do an == instead of the expensive
     * Object.equals method
     * @return Value returned by super class's hashCode() method
     */    
    public final int hashCode() {
        return super.hashCode();
    }
    
    /** Prevent subclasses from overriding Object.equals to ensure
     * the following contract of typesafe enum:
     * "All equal objects of the enumerated type are also
     * identical i.e., a.equals(b) iff a==b".
     * Thus, it is enough to do an == instead of the expensive
     * Object.equals method
     * @param obj Object to be compared for equality
     * @return true if the compared instance satisfies == test
     */    
    public final boolean equals(Object obj) {
        return super.equals(obj);
    }
    //PLUTYP on Ruby
    public static SoftKeyType PLU       = new SoftKeyType("PLU", "PLU", 
    "com.verifone.isd.vsms2.sales.ent.plu.PluPK", false, SoftKeyConstants.KB_PLU);
    //DEPTYP on Ruby
    public static SoftKeyType DEPT      = new SoftKeyType("DEP", "Department", 
    "com.verifone.isd.vsms2.sales.ent.dept.DepartmentPK", false, SoftKeyConstants.KB_DEPARTMENT_KEY);
    //MOPTYP on Ruby
    public static SoftKeyType MOP       = new SoftKeyType("MOP", "MOP", 
    "com.verifone.isd.vsms2.sales.ent.mop.MopPK", false, SoftKeyConstants.KB_MOP_MOPTYP);
    //MENUKTYP on Ruby
    public static SoftKeyType MENUKEY   = new SoftKeyType("MNU", "Menu key", 
    "com.verifone.isd.vsms2.sales.ent.menu.MenuPK", false, SoftKeyConstants.KB_MENU_KEY);
    //OTHERTYP on Ruby (Used only to group all following soft key types in softkey config)
    public static SoftKeyType DUMMY = new SoftKeyType("", "Group all following functions", 
    null, false, 0);
    //OTHDEPTYP on Ruby    
    public static SoftKeyType OTHER_DEPT = new SoftKeyType("ODP", "Other Department", 
    null, false, SoftKeyConstants.KB_FCT_OTHERDEPT);
    //OTHMOPTYP on Ruby    
    public static SoftKeyType OTHER_MOP = new SoftKeyType("OMP", "Other MOP", 
    null, false, SoftKeyConstants.KB_MOP_OTHERMOP);  
    //PRTICKTYP on Ruby
    public static SoftKeyType PRINT_TKT = new SoftKeyType("TPR", "Ticket Print", 
    null, false, SoftKeyConstants.KB_FCT_TICKET);  
    // Fuel Ticket Print (Topaz only)
    public static SoftKeyType FPRINT_TKT = new SoftKeyType("FTP", "Fuel Ticket Print", 
    null, true, SoftKeyConstants.KB_FCT_FPRINT);
    //RECALLTYP on Ruby
    public static SoftKeyType FUEL_VIEW = new SoftKeyType("FVI", "View Fuel", 
    null, false, SoftKeyConstants.KB_FUEL_VIEW);
    //FUELMOPTYP on Ruby
    public static SoftKeyType FUEL_CONVERT = new SoftKeyType("FCV", "Convert Fuel MOP", 
    null, false, SoftKeyConstants.KB_FUEL_PCONV);       
    //PREMOVETYP on Ruby
    public static SoftKeyType FUEL_MOVE = new SoftKeyType("FPM", "Fueling Point Move", 
    null, false, SoftKeyConstants.KB_FUEL_FPMOVE);  
    //OTHFUELTYP on Ruby
    public static SoftKeyType OTHER_FUEL = new SoftKeyType("OFU", "Other Fuel Functions", 
    null, false, SoftKeyConstants.KB_FUEL_OTHFUEL);       
    //FUELTYP on Ruby
    public static SoftKeyType FUEL      = new SoftKeyType("FUE", "Fuel", 
    null, false, SoftKeyConstants.KB_FUEL_FSALE);  
    //FUELPREPOSTTYP on Ruby
    public static SoftKeyType FUEL_PRESET = new SoftKeyType("FPR", "Fuel Preset", 
    null, false, SoftKeyConstants.KB_FUEL_PRESET);    
    //FUELPREPRETYP on Ruby
    public static SoftKeyType FUEL_FILLUP = new SoftKeyType("FLL", "Fill Up", 
    null, false, SoftKeyConstants.KB_FUEL_FILLUP);
    //FUELFILLUPTYP on Ruby
    public static SoftKeyType FUEL_PREPAY = new SoftKeyType("FPP", "Fuel Prepay", 
    null, false, SoftKeyConstants.KB_FUEL_PREP); 
    //PAYINTYP on Ruby
    public static SoftKeyType PAY_IN = new SoftKeyType("PIN", "Pay In", 
    null, false, SoftKeyConstants.KB_FCT_PAYIN);
    

	public static final SoftKeyType PAY_OUT = new SoftKeyBuilder("POU", LocalizedRB.getTopazRes(TopazRes.PAY_OUT_KEY),
			 SoftKeyConstants.KB_FCT_PAYOUT).withSecurityLevelConfigurable(true)
					.withTransacationScopeIndicator(true).build();
  
    //TAXREVTYP on Ruby
    public static SoftKeyType TAX_EXEMPT = new SoftKeyType("TEX", "Tax Exempt", 
    null, false, SoftKeyConstants.KB_FCT_TAXEXEMPT);       
    //PICKUPTYP on Ruby
    public static SoftKeyType SAFE_DROP = new SoftKeyType("SDR", "Safe Drop", 
    null, false, SoftKeyConstants.KB_FCT_SAFEDROP);
    //LOANTYP on Ruby
    public static SoftKeyType SAFE_LOAN = new SoftKeyType("SLO", "Safe Loan", 
    null, false, SoftKeyConstants.KB_FCT_SAFELOAN);  
    
	public static final SoftKeyType NO_SALE = new SoftKeyBuilder("NSA", LocalizedRB.getTopazRes(TopazRes.NO_SALE_KEY),
			 SoftKeyConstants.KB_FCT_NOSALE).withSecurityLevelConfigurable(true)
					.withTransacationScopeIndicator(true).build();
   
    public static final SoftKeyType SUSPEND = new SoftKeyBuilder("SUS", LocalizedRB.getTopazRes(TopazRes.SUSPEND),
			 SoftKeyConstants.KB_FCT_SUSPEND).withSecurityLevelConfigurable(true)
					.withTransacationScopeIndicator(true).build();
    
   	
	public static final SoftKeyType DISCOUNT = new SoftKeyBuilder("MDC",
			LocalizedRB.getTopazRes(TopazRes.MANUAL_DISCOUNT), SoftKeyConstants.KB_FCT_DISC)
					.withSecurityLevelConfigurable(true).build();
	
	public static final SoftKeyType PERCENT_DISC = new SoftKeyBuilder("PDC", "Percent Discount",
			SoftKeyConstants.KB_FCT_DISCPERCENT).withSecurityLevelConfigurable(false)
					.withParentSoftKey(DISCOUNT).build();


	public static final SoftKeyType AMOUNT_DISC = new SoftKeyBuilder("ADC", "Amount Discount",
			SoftKeyConstants.KB_FCT_DISCDOLLAR).withSecurityLevelConfigurable(false)
					.withParentSoftKey(DISCOUNT).build();
   
 
    //SPECFUNCTYP on Ruby
    public static SoftKeyType OTHER_FNS = new SoftKeyType("OFN", "Other Functions", 
    null, false, SoftKeyConstants.KB_FCT_OTHERFCT);        
    //MODIFTYP on Ruby
    public static SoftKeyType MODIFY = new SoftKeyType("MOD", "Modify", 
    null, false, SoftKeyConstants.KB_FCT_MODIFY);           
   
    public static final SoftKeyType PRICE_OVERRIDE = new SoftKeyBuilder("POR",
			LocalizedRB.getTopazRes(TopazRes.PRICE_OVERRIDE_KEY),  SoftKeyConstants.KB_FCT_PRICEOVER)
					.withSecurityLevelConfigurable(true).build();
    
    //REFERDISCTYP on Ruby
    public static SoftKeyType FUEL_DISC = new SoftKeyType("FDC", "Fuel Discount", 
    null, false, SoftKeyConstants.KB_FUEL_FDISC);    
    //CURRCONVTTYP on Ruby
    public static SoftKeyType OTHER_CURRENCY = new SoftKeyType("OCU", "Other Currency", 
    null, false, SoftKeyConstants.KB_FCT_OTHERCURR);     
    //APPFUN1TYP on Ruby
    public static SoftKeyType NETWORK_FNS = new SoftKeyType("NFN", "Network Functions", 
    null, false, SoftKeyConstants.KB_FCT_NETWORKFCT);     
    //TOTKEYTYP on Ruby
    public static SoftKeyType TOTAL = new SoftKeyType("TOT", "Total", 
    null, false, SoftKeyConstants.KB_FCT_TOTAL);   
    //APPROVETYP on Ruby
    public static SoftKeyType FUEL_APPROVE = new SoftKeyType("FAP", "Approve Fuel", 
    null, false, SoftKeyConstants.KB_FUEL_APPR);  
    //STOPTYP on Ruby
    public static SoftKeyType FUEL_STOP = new SoftKeyType("FST", "Stop Fuel", 
    null, false, SoftKeyConstants.KB_FUEL_STOP);      
    //CLOCKTYP on Ruby (also defined to MIDSOFTKTYP)
    public static SoftKeyType CLOCK_FNS = new SoftKeyType("CIO", "Clock In/Out", 
    null, false, SoftKeyConstants.KB_FCT_CLOCKINOUT);    
 

	public static final SoftKeyType VOID_LINE = new SoftKeyBuilder("VLI", LocalizedRB.getTopazRes(TopazRes.VOID_LINE),
			 SoftKeyConstants.KB_FCT_LVOID).withSecurityLevelConfigurable(true).build();
	

	public static final SoftKeyType VOID_TICKET = new SoftKeyBuilder("VTI",
			LocalizedRB.getTopazRes(TopazRes.VOID_TICKET_KEY),  SoftKeyConstants.KB_FCT_TVOID)
					.withSecurityLevelConfigurable(true).withTransacationScopeIndicator(true).build();
	
	public static final SoftKeyType ERROR_CORRECT = new SoftKeyBuilder("ECR",
			LocalizedRB.getTopazRes(TopazRes.ERROR_CORRECT_KEY), SoftKeyConstants.KB_FCT_ECORR)
					.withSecurityLevelConfigurable(true).build();


	public static final SoftKeyType REFUND = new SoftKeyBuilder("REF", LocalizedRB.getTopazRes(TopazRes.REFUND_KEY),
			 SoftKeyConstants.KB_FCT_REFUND).withSecurityLevelConfigurable(true)
					.withTransacationScopeIndicator(true).build();
	
	public static final SoftKeyType SAFE_DROP_CORR = new SoftKeyBuilder("SDC",
			LocalizedRB.getTopazRes(TopazRes.SAFE_DROP_CORR),  SoftKeyConstants.KB_FCT_SAFEDROP_CORR)
					.withSecurityLevelConfigurable(true).withTransacationScopeIndicator(true).build();
	
	public static final SoftKeyType MANAGED_UPDATE = new SoftKeyBuilder("MUP",
			LocalizedRB.getTopazRes(TopazRes.MANAGED_UPDATE_KEY),SoftKeyConstants.KB_MANAGED_UPDATE)
					.withSecurityLevelConfigurable(true).disallowedOnRuby(true).build();
	
    //QTYTYP on Ruby
    public static SoftKeyType QUANTITY = new SoftKeyType("QTY", "Quantity", 
    null, false, SoftKeyConstants.KB_FCT_QTY);  
    //FSTAMPTYP on Ruby
    public static SoftKeyType ALLOW_FOODSTAMP = new SoftKeyType("STM", "Allow Food Stamps for Item", 
    null, false, SoftKeyConstants.KB_FCT_ALLOWFS);  
    //POPTYP on Ruby 
    public static SoftKeyType POP_DISC = new SoftKeyType("POP", "Manual POP Discount", 
    null, false, SoftKeyConstants.KB_FCT_FREE_POP);
    //POPAUTOTYP on Ruby
    public static SoftKeyType POP_AUTO_CODE = new SoftKeyType("PAC", "AutoGen POP Code", 
    null, false, SoftKeyConstants.KB_FCT_FREE_AUTO_POP);

    //Update Fiscal Customer Tax Info
    public static SoftKeyType FISC_CUST_TAX = new SoftKeyType("CTI", "Update Customer Tax Info", 
    null, false, SoftKeyConstants.KB_FSC_CUST_TAX_INFO);

    //FUELTAXEXTYP on Ruby 
    public static SoftKeyType FUEL_TAX_EXEMPT = new SoftKeyType("FTX", "Fuel Tax Exemption", 
    null, false, SoftKeyConstants.KB_FCT_FUEL_TAX_EXEMPT);       
    //FUELTAXADDTYP on Ruby 
    public static SoftKeyType FUEL_TAX_ADDITION = new SoftKeyType("FTA", "Fuel Tax Addition", 
    null, false, SoftKeyConstants.KB_FCT_FUEL_TAX_ADD);       
    // RESTGASTYP on Ruby 
    public static SoftKeyType REST_IN_GAS = new SoftKeyType("RIG", "Rest In Gas", 
    null, false, SoftKeyConstants.KB_FUEL_RIG);
    /*************************cr1239.01-button to clear reserve pump*****************************/ 
    public static SoftKeyType CLEAR_RESERVE_PUMP = new SoftKeyType("CRP", "Clear Reserve Pump", 
    null, false, SoftKeyConstants.KB_FUEL_PREPAY_STOP);
    
    /*******************************************************************************************/
    // SKPOPMEMCDTYP on Ruby
    // CR6129: Change Pop Member Card softkey code from PMC to PME to match the equivalent GemPro/Ruby softkey as previously documented in the Gemcom Dataset Ref 1.08r5
    public static SoftKeyType POP_MEMBER_CD = new SoftKeyType("PME", "Pop Member Card", 
    null, false, SoftKeyConstants.KB_FCT_POP_MEM);       

    //  PRICECHECKTYP on Ruby 
    public static SoftKeyType PRICE_CHECK = new SoftKeyType("PCH", "Price Check", 
    null, false, SoftKeyConstants.KB_FCT_PRICE_CHK);  
    
    // Next Dollar (Topaz only)
    public static SoftKeyType NEXT_DOLLAR = new SoftKeyType("NDA", "Next dollar Amount", 
    null, true, SoftKeyConstants.KB_MOP_NEXTDOLLAR); 
    // Repeat last item (Topaz only)
    public static SoftKeyType REPEAT_LAST_ITEM = new SoftKeyType("RLA", "Repeat Last Item", 
    	    null, true, SoftKeyConstants.KB_FCT_REPEAT_LAST_ITEM);       
    //  PPDPURCHTYP on Ruby
    public static SoftKeyType GIFT_ACTIVATE = new SoftKeyType("GCA", "Gift Card Activate", 
    null, false, SoftKeyConstants.KB_FCT_GIFT_ACTIVATE);
    //  PPDRECHARGETYP on Ruby
    public static SoftKeyType GIFT_RECHARGE = new SoftKeyType("GCR", "Gift Card Recharge", 
    null, false, SoftKeyConstants.KB_FCT_GIFT_RECHARGE);
    
    public static SoftKeyType KIOSK_ORDER =  new SoftKeyType("KFO", "Kiosk Order", 
    	    null, false, SoftKeyConstants.KB_FCT_KIOSK_ORDER);    
    
    public static SoftKeyType PURGE_KIOSK_ORDER =  new SoftKeyType("PKO", "Purge Kiosk Order", 
    	    null, false, SoftKeyConstants.KB_FCT_PURGE_KIOSK_ORDER);
    // Recall (Topaz only)    
    public static SoftKeyType RECALL =  new SoftKeyType("REC", "Recall", 
    	    null, true, SoftKeyConstants.KB_FCT_RECALL);
    
    
    public static SoftKeyType KB_FCT_FLASH_RPTS = new SoftKeyType("SFR", "Sales Flash Reports",
    	    null, true, SoftKeyConstants.KB_FCT_FLASH_RPTS , new SecurityCtrlPK("RPT", "FLR"));
    
    public static SoftKeyType MANUAL_PLU = new SoftKeyType("MPL", "Manual PLU",
    		null, true, SoftKeyConstants.KB_MANUAL_PLU);
    
    public static SoftKeyType LOYALTY_CARD = new SoftKeyType("LCA", "Loyalty Card",
    		null, true, SoftKeyConstants.KB_FCT_LOYALTY_SCAN);

    // CODES added for buttons on fuel detailed view widgets. 
    public static SoftKeyType FUEL_WATCH = new SoftKeyType("FWP", "Fuel Watch", 
                null, false, SoftKeyConstants.KB_FUEL_WATCH);
    
    public static SoftKeyType DISMISS = new SoftKeyType("EXT", "Dismiss Widget", 
                null, false, SoftKeyConstants.KB_FCT_EXIT);
    
    public static SoftKeyType LOYALTY_BALANCE = new SoftKeyType("LBQ", "Loyalty Balance",
    		null, true, SoftKeyConstants.KB_FCT_LOYALTY_BALANCE);

    public static SoftKeyType EXCEPTION_TICKET_PRINT = new SoftKeyType("EXP", "Exception Ticket Print",
    		null, false, SoftKeyConstants.KB_FCT_EXCEPTION_PRINT);

    public static SoftKeyType PLACE_ORDER = new SoftKeyType("PLO","Place Order",
            null, false, SoftKeyConstants.KB_FCT_PLACE_ORDER);

    public static SoftKeyType  GET_ORDER = new SoftKeyType("GTO", "Get Order",
    		null, false, SoftKeyConstants.KB_FCT_GET_ORDER);
    
    
	public static final SoftKeyType CHOOSE_PINPAD = new SoftKeyType("CPP", "Choose Pinpad", null, false,
			SoftKeyConstants.KB_FCT_CHOOSE_PINPAD);

	public static final SoftKeyType THIRD_PARTY_PRODUCT = new SoftKeyType("TPP",
			LocalizedRB.getTopazRes(TopazRes.THIRD_PARTY_PRODUCT_KEY), null, false,
			SoftKeyConstants.KB_FCT_THIRD_PARTY_PROD);
	
	 public static SoftKeyType NOT_USED = new SoftKeyType("NTU", "Not Used", 
			    null, false, SoftKeyConstants.KB_UNDEFINED);
	

    // The 4 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = ++nextOrdinal; //softkey type; pre-increment to skip 0
    
    private static final SoftKeyType[] VALUES = {
            PLU, DEPT, MOP, MENUKEY, DUMMY, OTHER_DEPT, OTHER_MOP, PRINT_TKT, FPRINT_TKT, //9
            FUEL_VIEW, FUEL_CONVERT, FUEL_MOVE, OTHER_FUEL, FUEL, FUEL_PRESET, FUEL_FILLUP, //7
            FUEL_PREPAY, PAY_IN, PAY_OUT, TAX_EXEMPT, SAFE_DROP, SAFE_LOAN, //6
            NO_SALE, SUSPEND, DISCOUNT,PERCENT_DISC, AMOUNT_DISC, OTHER_FNS, //6
            MODIFY, PRICE_OVERRIDE, FUEL_DISC, OTHER_CURRENCY, NETWORK_FNS, //5
            TOTAL, FUEL_APPROVE, FUEL_STOP, CLOCK_FNS,VOID_LINE, VOID_TICKET, //6
            ERROR_CORRECT, REFUND, SAFE_DROP_CORR,MANAGED_UPDATE,
            QUANTITY, ALLOW_FOODSTAMP, DUMMY, DUMMY, POP_DISC, POP_AUTO_CODE, FISC_CUST_TAX, //7
            FUEL_TAX_EXEMPT, FUEL_TAX_ADDITION, REST_IN_GAS, POP_MEMBER_CD, PRICE_CHECK, NEXT_DOLLAR, //6
            REPEAT_LAST_ITEM, KIOSK_ORDER, PURGE_KIOSK_ORDER, RECALL, GIFT_ACTIVATE, //5
            GIFT_RECHARGE,KB_FCT_FLASH_RPTS, LOYALTY_CARD, //3
            MANUAL_PLU, FUEL_WATCH, DISMISS, LOYALTY_BALANCE, //4
    		EXCEPTION_TICKET_PRINT, GET_ORDER, PLACE_ORDER, CLEAR_RESERVE_PUMP, CHOOSE_PINPAD,THIRD_PARTY_PRODUCT, //6
    		NOT_USED
        };
    
    private static final SoftKeyType[] CONFIGURABLES = {
        PLU, DEPT, MOP, MENUKEY, OTHER_DEPT, OTHER_MOP, PRINT_TKT, FPRINT_TKT, //8
        FUEL_VIEW, FUEL_CONVERT, FUEL_MOVE, OTHER_FUEL, FUEL, FUEL_PRESET, FUEL_FILLUP, //7
        FUEL_PREPAY, PAY_IN, PAY_OUT, TAX_EXEMPT, SAFE_DROP, SAFE_LOAN, //6
        NO_SALE, SUSPEND, PERCENT_DISC, DISCOUNT, AMOUNT_DISC, OTHER_FNS, //6
        MODIFY, PRICE_OVERRIDE, FUEL_DISC, OTHER_CURRENCY, NETWORK_FNS, //5
        TOTAL, FUEL_APPROVE, FUEL_STOP, CLOCK_FNS, VOID_LINE, VOID_TICKET, //6
        REFUND, QUANTITY, ALLOW_FOODSTAMP, POP_DISC, POP_AUTO_CODE, FISC_CUST_TAX, //6
        FUEL_TAX_EXEMPT, FUEL_TAX_ADDITION, REST_IN_GAS, POP_MEMBER_CD, PRICE_CHECK, NEXT_DOLLAR, //6
        REPEAT_LAST_ITEM, KIOSK_ORDER, PURGE_KIOSK_ORDER, RECALL, GIFT_ACTIVATE, //5
        GIFT_RECHARGE,SAFE_DROP_CORR, KB_FCT_FLASH_RPTS, LOYALTY_CARD, //6
		MANUAL_PLU, LOYALTY_BALANCE, MANAGED_UPDATE, EXCEPTION_TICKET_PRINT, //4
		GET_ORDER, PLACE_ORDER ,CHOOSE_PINPAD,THIRD_PARTY_PRODUCT, //4
		NOT_USED
    };
    private static final SoftKeyType[] OTHER_FUNCS = {
        SAFE_DROP, SAFE_LOAN, CLOCK_FNS, PAY_IN, PAY_OUT, SUSPEND, PRINT_TKT ,SAFE_DROP_CORR//7    
    };
    private static final SoftKeyType[] OTHER_FUEL_FUNCS = {                //Other Fuel Functions
    	FUEL_MOVE, FUEL_CONVERT, FUEL_DISC, FUEL_PRESET, POP_DISC, FUEL_TAX_EXEMPT, FUEL_TAX_ADDITION
    };

   
    /** Method to prevent duplicate constants from coexisting as a
     * result of deserialization (ensures that only a single object
     * represents each enum constant. This method is automatically
     * invoked by the serialization mechanism. Without this method,
     * Object.equals() method would be more involved and not a
     * straightforward super.equals() which does just a == check.
     * @throws java.io.ObjectStreamException on serialization system issues
     * @return the enum array
     */
    Object readResolve() throws java.io.ObjectStreamException {
        return VALUES[ordinal-1]; // Canonicalize; -1 since ordinal is 1-based
    }     
    
    /** Getter for property ordinal. Used to get the gempro's  value
     * @return Value of property ordinal.
     */
    public int getOrdinal() {
        return this.ordinal;
    }
    
    /** Method to get the SoftKeyType object for a specified ordinal. 
     * Used to get the object given a gempro's  value
     * @param ordinal the  value represented by the object
     * @return SoftKeyType object representing the ordinal
     */
    public static final SoftKeyType getObject(int ordinal) {
        if (ordinal > 0 && ordinal <= VALUES.length) 
            return VALUES[ordinal-1];
        return null;
    }
    
    /** 
     * Method to get the SoftKeyType object for a specified code. 
     * This is an expensive operation compared to getObject(int ordinal).
     * Used to get the object given a gemcom 3 letter code
     * @param code the gemcom 3 letter code of the required object
     * @return SoftKeyType object representing the ordinal
     */
    public static final SoftKeyType getObjectByCode(String code) {
        if (code != null) {
            for (int i = 0; i < VALUES.length; i++) {
                if (VALUES[i].code.equals(code)) {
                    return VALUES[i];
                }
            }
        }
        return null;
    }    

    /**
     * Method to get the SoftKeyType object for a specified key constant.
     * This is an expensive operation compared to getObject(int ordinal).
     * If this is going to be used frequently, consider using a hashMap with
     * keyConstant as the key.
     * Used to get the object given a key constant
     * @param key constant mapped to this soft key type
     * @return SoftKeyType object representing the key constant
     */
    public static final SoftKeyType getObjectByKeyConstant(int keyConst) {
        for (int i = 0; i < VALUES.length; i++) {
            if (VALUES[i].keyConstant == keyConst) {
                return VALUES[i];
            }
        }
        return null;
    }

    /** Getter for a list of configurable softkey types
     * @return configurable softkey types
     */    
    public static final SoftKeyType[] getConfigurableTypes() {
        return CONFIGURABLES;
    }

    /** Getter for a list of Other Functions softkey types
     * @return other func softkey types
     */    
    public static final SoftKeyType[] getOtherFuncTypes() {
        return OTHER_FUNCS;
    }
    
    /**
     * Getter for a list of Other Fuel Functions softkey types
     * @return other fuel function softkey types
     */
    public static final SoftKeyType[] getOtherFuelFuncTypes() {
        return OTHER_FUEL_FUNCS;
    }
    
    /** Test method
     * @param args params
     */    
    public static void main(String[] args) {
        for (int i = 1; ; i++) {
            try {
                SoftKeyType skt = SoftKeyType.getObject(i);
                if (null != skt) {
                    System.out.println("Index: " +i +" ordinal = " +skt.getOrdinal() +" code = " +skt.getCode()
                    +" class = " +skt.getMappedPKClass() + " keyConstant = " + skt.getKeyConstant());
                }
                else {
                    System.out.println("Index: " +i +" - null");
                }
            }
            catch (Exception e) {
                break;
            }
        }
    }

    /**
     * @return the securityCtrl
     */
    public SecurityCtrlPK getSecurityCtrl() {
        return securityCtrl;
    }

	public boolean isSecurityLevelConfigurable() {
		return securityLevelConfigurable;
	}

	
	/**
	 * Returns a list of softkeys which can have security level associated with it
	 * 
	 * @return
	 */
	public static final List<SoftKeyType> getSecurityLevelConfigurableKeys() {

		if (securityLevelConfigurableKeys.isEmpty()) {
			try {
				/*
				 * Sorting security level configurable SoftKeyTypes based on its description
				 */
				securityLevelConfigurableKeys = (ArrayList<SoftKeyType>) Arrays.stream(VALUES)
						.filter(t -> (t.isSecurityLevelConfigurable()))
						.sorted((object1, object2) -> object1.toString().compareTo(object2.toString()))
						.collect(Collectors.toList());

			} catch (Exception e) {
				logger.error("error populating the securityLevelConfigurableKeys ", e);
			}
		}

		return securityLevelConfigurableKeys;
	}


	public boolean isTransactionLevelKey() {
		return transactionLevelKey;
	}

	
	public SoftKeyType getParentSoftKeyType() {
		return parentSoftKeyType;
	}



	private static class SoftKeyBuilder {
		private String code;
		private String description;
		private Class<IEntityPK> mappedPKClass;
		private boolean disallowedOnRuby;
		private int keyConstant;
		private SecurityCtrlPK securityCtrl;
		private boolean securityLevelConfigurable;
		private boolean transactionLevelKey;
		private SoftKeyType parentSoftKeyType;

		public SoftKeyBuilder(String code, String description,int keyConstant) {

			this.code = code;
			this.description = description;
			this.keyConstant = keyConstant;

		}

		public SoftKeyBuilder withSecurityLevelConfigurable(boolean securityLevelConfigurable) {
			this.securityLevelConfigurable = securityLevelConfigurable;
			return this;

		}

		public SoftKeyBuilder withTransacationScopeIndicator(boolean transactionLevelKey) {
			this.transactionLevelKey = transactionLevelKey;
			return this;

		}

		public SoftKeyBuilder disallowedOnRuby(boolean disallowedOnRuby) {
			this.disallowedOnRuby = disallowedOnRuby;
			return this;

		}
		
		public SoftKeyBuilder withParentSoftKey(SoftKeyType withParentSoftKeyType) {
			this.parentSoftKeyType = withParentSoftKeyType;
			return this;

		}
		
		public SoftKeyType build() {
			return new SoftKeyType(this);
		}
	}
	
}

    
/*  
 *  Ruby softkey #define's
 *=======================
 MINSOFTKTYP	1
 PLUTYP		1
 DEPTYP		2
 MOPTYP		3
 MENUKTYP	4
 OTHERTYP       5
 OTHDEPTYP	6
 OTHMOPTYP	7
 PRTICKTYP       8
 RECALLTYP       9
 FUELMOPTYP     10
 PREMOVETYP     11
 OTHFUELTYP     12
 FUELTYP        13
 FUELPREPOSTTYP 14
 FUELPREPRETYP  15
 PAYINTYP       16
 PAYOUTTYP      17
 TAXREVTYP      18
 PICKUPTYP      19
 LOANTYP        20
 OPENCDTYP      21
 SUSPENDTYP     22
 PDISCTYP       23
 DISCTYP        24
 ADISCTYP       25
 SPECFUNCTYP    26
 MODIFTYP       27
 PRICEOVERTYP   28
 REFERDISCTYP   29
 CURRCONVTTYP   30
 APPFUN1TYP     31
 TOTKEYTYP      32
 APPROVETYP     33
 STOPTYP        34

 MIDSOFTKTYP    35  MIDSOFTKTYP must be defined for sales; all functions (1-34) 
                    are called with the the parameter nkeys 
 CLOCKTYP       35 
 VOIDLINETYP    36 
 VOIDTICKTYP    37
 RFNDKEYTYP     38
 QTYTYP         39
 FSTAMPTYP      40
 DUMMY			41
 DUMMY			42
 POPTYP			43
 FUELTAXEXTYP   44
 FUELTAXADDTYP  45
 PRICECHECKTYP  46
 POPMEMCDTYP    47
 PPDPURCHTYP	48
 PPDRECHARGETYP	49
 POPAUTOTYP     50
 MAXSOFTKTYP    50

 NOT_USED		0 
 *=================
 */