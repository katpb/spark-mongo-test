package com.verifone.isd.vsms2.sys.l10n;

import java.util.ListResourceBundle;

/**
 * The Class NACSCodeRes is the resourceBundle for NACS specific tender codes.
 * 
 * @author Sanjeev_S1
 */
public class NACSCodeRes extends ListResourceBundle {

	/** The Constant CASH. */
	public static final String CASH = "CASH";
	
	/** The Constant CHECK. */
	public static final String CHECK = "CHECK";
	
	/** The Constant MO. */
	public static final String MO = "MO";
	
	/** The Constant FOODSTAMPS. */
	public static final String FOODSTAMPS = "FOODSTAMPS";
	
	/** The Constant EBT. */
	public static final String EBT = "EBT";
	
	/** The Constant GIFTCERTIFICATE. */
	public static final String GIFTCERTIFICATE = "GIFTCERTIFICATE";
	
	/** The Constant CREDITCARD. */
	public static final String CREDITCARD = "CREDITCARD";
	
	/** The Constant FLEETCARD. */
	public static final String FLEETCARD = "FLEETCARD";
	
	/** The Constant DEBITCARD. */
	public static final String DEBITCARD = "DEBITCARD";
	
	/** The Constant RF. */
	public static final String RF = "RF";
	
	/** The Constant PREPAIDCARD. */
	public static final String PREPAIDCARD = "PREPAIDCARD";
	
	/** The Constant SMARTCARD. */
	public static final String SMARTCARD = "SMARTCARD";
	
	/** The Constant HOUSECHARGE. */
	public static final String HOUSECHARGE = "HOUSECHARGE";
	
	/** The Constant DRIVEOFF. */
	public static final String DRIVEOFF = "DRIVEOFF";
	
	/** The Constant LOTTERYWINTICKET. */
	public static final String LOTTERYWINTICKET = "LOTTERYWINTICKET";
	
	/** The Constant LOTTOWINTICKET. */
	public static final String LOTTOWINTICKET = "LOTTOWINTICKET";
	
	/** The Constant COUPONS. */
	public static final String COUPONS = "COUPONS";
	
	/** The Constant WICPAYMENT. */
	public static final String WICPAYMENT = "WICPAYMENT";
	
	/** The Constant PUMPFORTEST. */
	public static final String PUMPFORTEST = "PUMPFORTEST";
	
	/** The Constant USERDEFINEDTENDER. */
	public static final String USERDEFINEDTENDER = "USERDEFINEDTENDER";
	
	/** The Constant GENERIC. */
	public static final String GENERIC = "GENERIC";
	
	/** The Constant COMMERCIALCHECK. */
	public static final String COMMERCIALCHECK = "COMMERCIALCHECK";
	
	/** The Constant EMPLOYEECHECK. */
	public static final String EMPLOYEECHECK = "EMPLOYEECHECK";
	
	/** The Constant GOVCHECK. */
	public static final String GOVCHECK = "GOVCHECK";
	
	/** The Constant CASHBACK. */
	public static final String CASHBACK = "CASHBACK";
	
	/** The Constant EBTFOODSTAMP. */
	public static final String EBTFOODSTAMP = "EBTFOODSTAMP";
	
	/** The Constant AMEX. */
	public static final String AMEX = "AMEX";
	
	/** The Constant VISA. */
	public static final String VISA = "VISA";
	
	/** The Constant MASTERCARD. */
	public static final String MASTERCARD = "MASTERCARD";
	
	/** The Constant OILCOMPANY. */
	public static final String OILCOMPANY = "OILCOMPANY";
	
	/** The Constant PROPRIETARY. */
	public static final String PROPRIETARY = "PROPRIETARY";
	
	/** The Constant MANUFACTURER. */
	public static final String MANUFACTURER = "MANUFACTURER";
	
	/** The Constant STORE. */
	public static final String STORE = "STORE";

	/** The Constant contents. */
	private static final Object[][] contents = { 
	{ CASH, "cash" },
	{ CHECK, "check" },
	{ MO, "moneyOrder" },
	{ FOODSTAMPS, "foodStamps" },
	{ EBT, "ebt" },
	{ GIFTCERTIFICATE, "giftCertificates" },
	{ CREDITCARD, "creditCards" },
	{ FLEETCARD, "fleetCards" },
	{ DEBITCARD, "debitCards" },
	{ RF, "radioFrequency" },
	{ PREPAIDCARD, "prepaidCards" },
	{ SMARTCARD, "smartCards" },
	{ HOUSECHARGE, "houseCharges" },
	{ DRIVEOFF, "driveOff" },
	{ LOTTERYWINTICKET, "lotteryWinTicket" },
	{ LOTTOWINTICKET, "lottoWinningTicket" },
	{ COUPONS, "coupons" },
	{ WICPAYMENT, "wicPayment" },
	{ PUMPFORTEST, "pumpForTest" },
	{ USERDEFINEDTENDER, "userDefTenderType" },
	{ GENERIC, "generic" },
	{ COMMERCIALCHECK,"commercialCheck"},
	{ EMPLOYEECHECK,"employeeCheck"},
	{ GOVCHECK,"governmentCheck"},
	{ CASHBACK,"cashBack"},
	{ EBTFOODSTAMP,"ebtFoodStamp"},
	{ AMEX,"americanExpress"},
	{ VISA,"visa"},
	{ MASTERCARD,"masterCard"},
	{ OILCOMPANY,"oilCompany"},
	{ PROPRIETARY,"proprietary"},
	{ MANUFACTURER,"manufacturer"},
	{ STORE,"store"}

	};


	@Override
	protected Object[][] getContents() {
		return contents;
	}

}
