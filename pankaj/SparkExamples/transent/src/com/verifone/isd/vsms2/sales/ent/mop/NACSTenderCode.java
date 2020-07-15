package com.verifone.isd.vsms2.sales.ent.mop;

import com.verifone.isd.vsms2.sys.l10n.NACSCodeRes;

/**
 * The Enum NACSTenderCode is the catalogue for NACS specific tender codes.
 * 
 * @author Sanjeev_S1
 */
public enum NACSTenderCode  {
	
	/** The cash. */
	CASH(NACSCodeRes.CASH,100),
	
	/** The check. */
	CHECK(NACSCodeRes.CHECK,101),
	
	/** The mo. */
	MO(NACSCodeRes.MO,102),
	
	/** The foodstamps. */
	FOODSTAMPS(NACSCodeRes.FOODSTAMPS,103),
	
	/** The ebt. */
	EBT(NACSCodeRes.EBT,104),
	
	/** The giftcertificate. */
	GIFTCERTIFICATE(NACSCodeRes.GIFTCERTIFICATE,105),
	
	/** The creditcard. */
	CREDITCARD(NACSCodeRes.CREDITCARD,106),
	
	/** The fleetcard. */
	FLEETCARD(NACSCodeRes.FLEETCARD,107),
	
	/** The debitcard. */
	DEBITCARD(NACSCodeRes.DEBITCARD,108),
	
	/** The rf. */
	RF(NACSCodeRes.RF,109),
	
	/** The prepaidcard. */
	PREPAIDCARD(NACSCodeRes.PREPAIDCARD,110),
	
	/** The smartcard. */
	SMARTCARD(NACSCodeRes.SMARTCARD,111),
	
	/** The housecharge. */
	HOUSECHARGE(NACSCodeRes.HOUSECHARGE,112),
	
	/** The driveoff. */
	DRIVEOFF(NACSCodeRes.DRIVEOFF,113),
	
	/** The lotterywinticket. */
	LOTTERYWINTICKET(NACSCodeRes.LOTTERYWINTICKET,114),
	
	/** The lottowinticket. */
	LOTTOWINTICKET(NACSCodeRes.LOTTOWINTICKET,115),
	
	/** The coupons. */
	COUPONS(NACSCodeRes.COUPONS,116),
	
	/** The wicpayment. */
	WICPAYMENT(NACSCodeRes.WICPAYMENT,117),
	
	/** The pumpfortest. */
	PUMPFORTEST(NACSCodeRes.PUMPFORTEST,118),
	
	/** The userdefinedtender. */
	USERDEFINEDTENDER(NACSCodeRes.USERDEFINEDTENDER,119),
	
	/** The generic. */
	GENERIC(NACSCodeRes.GENERIC,120);

	
	/** The tender code. */
	private final String tenderCode;

	/** The tendercode id. */
	private final int tendercodeID;
	
	/**
	 * Instantiates a new nACS tender code.
	 * 
	 * @param tenderCode
	 *            the tender code
	 */
	NACSTenderCode(String tenderCode,int tendercodeID){
		this.tenderCode = tenderCode;
		this.tendercodeID = tendercodeID;
	}


	/**
	 * Gets the tender code.
	 * 
	 * @return the tender code
	 */
	public String getTenderCode() {
		return this.tenderCode;
	}


	/**
	 * Gets the tendercode id.
	 * 
	 * @return the tendercodeID
	 */
	public int getTendercodeID() {
		return this.tendercodeID;
	}
}