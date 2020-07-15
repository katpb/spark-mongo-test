/*
 * MopCode.java
 *
 * Created on April 29, 2003, 5:40 PM
 */

package com.verifone.isd.vsms2.sales.ent.mop;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/** Type-safe enumeration of MOP codes
 * TO DO: Convert all the strings here to support i18n, Uncomment (and
 * change the method name?) the abstract method and provide concrete
 * control classes for each mop code processing. Provide a
 * vanilla control class and subclass it as we add support for each mop code?
 * @author Bhanu_N2
 */
public class MopCode implements java.io.Serializable {

	private static final Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sales.ent.mop.MopCode.class);
	private static final long serialVersionUID = 4810635319868263978L;   
    private static final int NACS_CODE_CASH = 10;
    private static final int NACS_CODE_CREDIT = 60;
    private static final int NACS_CODE_DEBIT = 80;
    private static final int NACS_CODE_FOODSTAMP = 40;
    private static final int NACS_CODE_EBT = 45;
    private static final int NACS_CODE_PREPAID = 100;
    private static final int NACS_CODE_LOTTERY_WINNING = 160;
    private static final int NACS_CODE_LOTTO_WINNING = 170;
    private static final int NACS_CODE_PUMP_TEST = 200;
    private static final int NACS_CODE_DRIVE_OFF = 150;
    private static final int NACS_CODE_COUPONS = 180;
    private static final int NACS_CODE_CHECK = 20;
    private static final int NACS_CODE_HOUSE_CHARGES = 130;
    private static final int NACS_CODE_SPECIAL_DISCOUNT = 500;
    private static final int NACS_CODE_FUEL_VOUCHER = 501;
    private static final int NACS_CODE_TAX_EXEMPT_MOP = 502;
    private static final int NACS_CODE_MOBILE = 210;
    
    private transient int nacsCode;
    private transient String name;
    private transient boolean valid;
    private transient int gemproCode;
    private static MopCode[] VALID_CODES;
    
    private transient boolean typeCash;
    private transient boolean typeCoupon;
    private transient boolean typeFS;
    private transient boolean typeNetwork;
    private transient boolean changeAllowed;
    private transient boolean voidTicketAllowed;
    private transient boolean refundAllowed;
    private transient boolean prepayAllowed;
	private transient MoneyAmount fixedValue;
	private transient boolean configurableFixedValue;
  
    /**
     * Sole constructor. It takes <code>MopCodeBuilder</code> to initialize its state variables.
     * 
     * @param builder instance of <code>MopCodeBuilder</code> 
     */
	protected MopCode(MopCodeBuilder builder) {
		this.valid = true;
		this.gemproCode = this.ordinal;
		this.nacsCode = builder.nacsCode;
		this.name = builder.name;
		this.typeCash = builder.typeCash;
		this.typeCoupon = builder.typeCoupon;
		this.typeFS = builder.typeFS;
		this.typeNetwork = builder.typeNW;
		this.changeAllowed = builder.changeAllowed;
		this.voidTicketAllowed = builder.voidTicketAllowed;
		this.refundAllowed = builder.refundAllowed;
		this.prepayAllowed = builder.prepayAllowed;
		this.fixedValue = builder.fixedValue;
		this.configurableFixedValue = builder.configurableFixedValue;
	}   
    
    /** Override toString() method to provide the MOP code's name
     * @return MOP code's name
     */
    @Override
	public String toString() {
        return this.name;
    }

    /** Getter for NACS tender code
     * @return NACS tender code
     */
    public int getNacsCode() {
        return this.nacsCode;
    }
     
    public boolean isTypeCash(){
    	return typeCash;
    }
    
    public boolean isTypeFoodStamp(){
    	return typeFS;
    }

    public boolean isTypeNetwork(){
    	return typeNetwork;
    }
    
    public boolean isTypeCoupon(){
    	return typeCoupon;
    }
    
    /**
     * Returns whether this Mop allows change or not.
     * This method has to be enhanced in a generic way.
     *
     * @return
     */
    public boolean isChangeAllowed() {
    	return changeAllowed;
    }

    public boolean isVoidTicketAllowed(){
    	return voidTicketAllowed;
    }
    
    public boolean isRefundAllowed(){
    	return refundAllowed;
    }
    
    public boolean isPrepayAllowed(){
    	return prepayAllowed;
    }

	public MoneyAmount getFixedValue() {
		return this.fixedValue;
	}
	
	public boolean isConfigurableFixedValue() {
		return this.configurableFixedValue;
	}

    /** Prevent subclasses from overriding Object.hashCode() to ensure
     * the following contract of typesafe enum:
     * "All equal objects of the enumerated type are also
     * identical i.e., a.equals(b) iff a==b".
     * Thus, it is enough to do an == instead of the expensive
     * Object.equals method
     * @return Value returned by super class's hashCode() method
     */
    @Override
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
    @Override
	public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    
	// Begin generic codes: Caution: the order of the generic codes below MUST
	// be in sync with Gempro
	public static MopCode CASH = new MopCodeBuilder(NACS_CODE_CASH, "CASH")
			.typeCash(true,null).build();
	public static MopCode CREDIT = new MopCodeBuilder(NACS_CODE_CREDIT,
			"CREDIT").typeNetwork(true).build();
	public static MopCode DEBIT = new MopCodeBuilder(NACS_CODE_DEBIT, "DEBIT")
			.typeNetwork(true).build();
	public static MopCode MANUAL_CREDIT = new MopCodeBuilder(NACS_CODE_CREDIT,
			"MANUAL_CREDIT").build();
	public static MopCode MANUAL_DEBIT = new MopCodeBuilder(NACS_CODE_DEBIT,
			"MANUAL_DEBIT").build();
    
    /**
     * Lotto - Mop code that is used for machine ticket lottery
     */
	public static MopCode LOTTO = new MopCodeBuilder(NACS_CODE_LOTTO_WINNING,
			"LOTTO").build();
	public static MopCode CHECK = new MopCodeBuilder(NACS_CODE_CHECK, "CHECK")
			.build();
	public static MopCode COUPON = new MopCodeBuilder(NACS_CODE_COUPONS,
			"TAX_COUPON").typeCoupon(true).build();
	public static MopCode CASH_1 = new MopCodeBuilder(NACS_CODE_CASH,
			"1_CASH").typeCash(false,new MoneyAmount(100L,Mop.NUM_DECIMALS)).build();
	public static MopCode CASH_5 = new MopCodeBuilder(NACS_CODE_CASH,
			"5_CASH").typeCash(false,new MoneyAmount(500L,Mop.NUM_DECIMALS)).build();
	public static MopCode CASH_10 = new MopCodeBuilder(NACS_CODE_CASH,
			"10_CASH").typeCash(false,new MoneyAmount(1000L,Mop.NUM_DECIMALS)).build();
	public static MopCode CASH_20 = new MopCodeBuilder(NACS_CODE_CASH,
			"20_CASH").typeCash(false,new MoneyAmount(2000L,Mop.NUM_DECIMALS)).build();
	public static MopCode CASH_50 = new MopCodeBuilder(NACS_CODE_CASH,
			"50_CASH").typeCash(false,new MoneyAmount(5000L,Mop.NUM_DECIMALS)).build();
	public static MopCode FOOD_STAMP = new MopCodeBuilder(NACS_CODE_FOODSTAMP,
			"FOOD_STAMP").typeFoodStamp(true).build();
	public static MopCode DRIVE_OFF = new MopCodeBuilder(NACS_CODE_DRIVE_OFF,
			"DRIVE_OFF").changeAllowed(false).build();
    
    //No eqvt NACS code!
	public static MopCode SPECIAL_DISC = new MopCodeBuilder(
			NACS_CODE_SPECIAL_DISCOUNT, "SPECIAL_DISC").changeAllowed(false)
			.build();
	public static MopCode ELECTR_FS = new MopCodeBuilder(NACS_CODE_EBT,
			"MANUAL_FS").typeNetwork(false).typeFoodStamp(true)
			.changeAllowed(false).build();

	/*
	 * Lottery - MOP code that identifies scratchoff lottery; identical to
	 * Lotto, but a separate MOP for accounting purposes
	 */
	public static MopCode LOTTERY = new MopCodeBuilder(
			NACS_CODE_LOTTERY_WINNING, "LOTTERY").build();
	public static MopCode IN_HOUSE = new MopCodeBuilder(
			NACS_CODE_HOUSE_CHARGES, "IN_HOUSE").build();
	public static MopCode PUMP_TEST = new MopCodeBuilder(NACS_CODE_PUMP_TEST,
			"PUMP_TEST").changeAllowed(false).prepayAllowed(false).build();
	public static MopCode EBT_FS = new MopCodeBuilder(NACS_CODE_EBT, "EBT_FS")
			.typeFoodStamp(true).typeNetwork(true).changeAllowed(false)
    		.build();
	public static MopCode EBT_CB = new MopCodeBuilder(NACS_CODE_EBT, "EBT")
			.typeNetwork(true).build();
	public static MopCode MANUAL_CB = new MopCodeBuilder(NACS_CODE_EBT,
			"MANUAL_EBT_CB").typeNetwork(true).build();
    public static MopCode MANUAL_FS        = ELECTR_FS;
	public static MopCode ECHECK = new MopCodeBuilder(NACS_CODE_CHECK, "ECHECK")
			.build();
	public static MopCode STORED_VAL_CARD = new MopCodeBuilder(
			NACS_CODE_PREPAID, "STORED_VAL_CARD").typeNetwork(true).build();
	
    //End generic MOP codes
	public static MopCode MANUAL_ENTRY = new MopCodeBuilder(NACS_CODE_CREDIT,
			"MANUAL_ENTRY").typeNetwork(true).build();
	public static MopCode FORCE_POST = new MopCodeBuilder(NACS_CODE_CREDIT,
			"FORCE_POST").typeNetwork(true).voidTicketAllowed(false)
			.refundAllowed(false).prepayAllowed(false).build();
	public static MopCode POST_ENTRY = new MopCodeBuilder(NACS_CODE_CREDIT,
			"POST_ENTRY").typeNetwork(true).voidTicketAllowed(false)
			.refundAllowed(false).prepayAllowed(false).build();
	public static MopCode MOBILE = new MopCodeBuilder(NACS_CODE_MOBILE,
			"MOBILE").typeNetwork(true).build();
    public static MopCode UNATTENDED_REFUND = new MopCodeBuilder(NACS_CODE_CASH, 
                        "UNATTENDED_REFUND").typeCash(false,null).build();
    public static MopCode NON_TAX_COUPON = new MopCodeBuilder(
			NACS_CODE_COUPONS, "NON_TAX_COUPON").typeCoupon(true).build();

    public static MopCode FUEL_VOUCHER = new MopCodeBuilder(
    		NACS_CODE_FUEL_VOUCHER, "FUEL_VOUCHER").typeCoupon(true)
    		.refundAllowed(false).changeAllowed(false).prepayAllowed(false).build();

    public static MopCode TAX_EXEMPT_VOUCHER = new MopCodeBuilder(
    		NACS_CODE_TAX_EXEMPT_MOP, "TAX_EXEMPT_VOUCHER").changeAllowed(false).build();

    // The 4 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++; //MOP's code; auto-incremented
	private static final MopCode[] VALUES = { CASH, CREDIT, DEBIT,
			MANUAL_CREDIT, MANUAL_DEBIT, LOTTO, CHECK, COUPON, CASH_1, CASH_5,
			CASH_10, CASH_20, CASH_50, FOOD_STAMP, DRIVE_OFF, SPECIAL_DISC,
			ELECTR_FS, LOTTERY, IN_HOUSE, PUMP_TEST, EBT_FS, EBT_CB, MANUAL_CB,
			ECHECK, STORED_VAL_CARD, MANUAL_ENTRY, FORCE_POST, POST_ENTRY,
			MOBILE, UNATTENDED_REFUND, NON_TAX_COUPON, FUEL_VOUCHER, TAX_EXEMPT_VOUCHER};

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
        return VALUES[ordinal]; // Canonicalize
    }

    /** Getter for property ordinal. Used to get the gempro's #define value
     * @return Value of property ordinal.
     */
    public int getOrdinal() {
        return this.ordinal;
    }

    /**
     * Getter for property gemproCode.
     * @return Value of property gemproCode.
     */
    public int getGemproCode() {
        return gemproCode;
    }

    /** Method to get the MopCode object for a specified ordinal.
     * Used to get the object given a gempro's #define value
     * @param ordinal the #define value represented by the object
     * @return MopCode object representing the ordinal
     */
    public static MopCode getObject(int ordinal) {
        return (ordinal >= 0 && ordinal < VALUES.length && VALUES[ordinal].valid) ? VALUES[ordinal] : null;
    }

    public static MopCode getObjectByGemproCode(int gemproCode) {
        MopCode[] codes = MopCode.getObjects();
        MopCode reqdCode = null;
        for (int i = 0; i < codes.length; i++) {
            if (codes[i].gemproCode == gemproCode) {
                reqdCode = codes[i];
                break;
            }
        }
        return reqdCode;
    }

    /** Getter for all the MopCode objects
     * @return array of MopCodes
     */
    @SuppressWarnings("cast")
	public static MopCode[] getObjects() {
        if (null == VALID_CODES) {
            ArrayList<MopCode> arrList = new ArrayList<MopCode>();
            for (int i = 0; i < VALUES.length; i++) {
                if (VALUES[i].valid) {
                    arrList.add(VALUES[i]);
                }
            }
            VALID_CODES = (MopCode[])arrList.toArray(new MopCode[0]);
        }
        MopCode[] codes = new MopCode[VALID_CODES.length];
        System.arraycopy(VALID_CODES, 0, codes, 0, VALID_CODES.length);
        return codes;
    }

    /** Test method
     * @param args params to the test
     */
    public static void main(String[] args) {
        MopCode[] codes = MopCode.getObjects();
        for (int i = 0; i < codes.length; i++) {
            System.out.println("Code: " +codes[i].getOrdinal() +" name = " +codes[i].toString() +" gempro code: " +codes[i].getGemproCode());
        }
    }
    
    private static class MopCodeBuilder {
    	private final int nacsCode;
    	private final String name;    	
    	
    	private boolean typeCash;
    	private boolean typeNW;
    	private boolean typeFS;
    	private boolean typeCoupon;
    	private boolean  changeAllowed = true;
    	private boolean  voidTicketAllowed = true;
    	private boolean  refundAllowed = true;
    	private boolean  prepayAllowed = true;
		private MoneyAmount fixedValue;
		private boolean configurableFixedValue;
    	
    	public MopCodeBuilder(int nacsCode, String name){
    		this.nacsCode = nacsCode;
    		this.name = name;
    	}
    	/***@fixed value: if the mop code has/supports a  denomination 
    	 * @supportsFixedAmount: if the mopCode supports fixed amount(Quick Cash key) has to set it to true
    	 * */
    	public MopCodeBuilder typeCash(boolean supportsFixedAmount,MoneyAmount fixedValue){
    		this.typeCash = true;
			this.fixedValue = fixedValue;
			this.configurableFixedValue = supportsFixedAmount;
    		return this;
    	}
    	
    	public MopCodeBuilder typeCoupon(boolean typeCoupon){
    		this.typeCoupon = typeCoupon;
    		return this;
    	}
    	
    	public MopCodeBuilder typeNetwork(boolean typeNW){
    		this.typeNW = typeNW;
    		return this;
    	}
    	
    	public MopCodeBuilder typeFoodStamp(boolean typeFS){
    		this.typeFS = typeFS;
    		return this;
    	}
    	
    	public MopCodeBuilder changeAllowed(boolean changeAllowed){
    		this.changeAllowed = changeAllowed;
    		return this;
    	}
    	
    	public MopCodeBuilder voidTicketAllowed(boolean voidTicketAllowed){
    		this.voidTicketAllowed = voidTicketAllowed;
    		return this;
    	}
    	
    	public MopCodeBuilder refundAllowed(boolean refundAllowed){
    		this.refundAllowed = refundAllowed;
    		return this;
    	}
    	
    	public MopCodeBuilder prepayAllowed(boolean prepayAllowed){
    		this.prepayAllowed = prepayAllowed;
    		return this;
    	}
    	
    	public MopCode build() {
    		return new MopCode(this);
    	}
    }
}


/*
 *  Ruby #defines
 *=================
     CASHNUM        0
     CREDNUM        1
     DEBNUM         2
     MANCREDNUM     3
     MANDEBNUM      4
     LOTNUM         5
     CHECKNUM       6
     COUPNUM        7
     MINCASHDOLLAR  8
     CASH1          8
     CASH5          9
     CASH10         10
     CASH20         11
     CASH50         12
     MAXCASHDOLLAR  12
     FOODSTAMPNUM   13
     DRIVEOFFNUM    14
     SPDISCNUM      15
     ELECTRFS       16
     VPASSPAY       17
     INHOUSE        18
     PUMPTESTNUM    19
     EBTFSNUM       25
     EBTCBNUM       26
     MANEBTCB       27
     MANEBTFS       ELECTRFS
     MOBILE			28
 *=================
 */

/*
 * NACS Tender codes
 * see: http://www.naxml.org/POS%20Back%20Office/Version%203.2/TenderCode.pdf
================================================================
Tender      Description         Tender          Description
Code                            Sub-Code
================================================================
0010        Cash                0000
                                0001
                                0002
                                0003
================================================================
0020        Check               0000
                                0001            Commercial Check
                                0002            Employee Check
                                0003            Government Check
================================================================
0030        Money Order         0000
================================================================
0040        Food Stamps         0000
================================================================
0045        EBT                 0000
                                0001            EBT Cash
                                0002            EBT CB
                                0003            EBT Food stamp
================================================================
0050        Gift Certificates   0000
================================================================
0060        Credit Cards        0000
                                0001            American Express
                                0002            Visa
                                0003            MasterCard
                                0004            Oil Company
                                0005            Proprietary
================================================================
0070        Fleet Cards         0000
================================================================
0080        Debit Cards         0000
================================================================
0090        Radio Frequency     0000
================================================================
0100        Pre-Paid Cards      0000
================================================================
0110        Smart Cards         0000
================================================================
0130        House Charges       0000
            (onaccount)
================================================================
0140        Cash back           0000
================================================================
0150        Drive-off           0000
================================================================
0160        Lottery Winning     0000
            ticket
================================================================
0170        Lotto Winning       0000
            ticket
================================================================
0180        Coupons             0000
                                0001            Manufacturer
                                0002            Store
================================================================
0190        WIC Payment         0000
================================================================
0200        Pump-for-test       0000
================================================================
0210		MOBILE				0000			Mobile Payment
================================================================
0500 ï¿½      User Defined        0000
            Tender Types
0700
================================================================
0900 Generic 0000
================================================================
**/