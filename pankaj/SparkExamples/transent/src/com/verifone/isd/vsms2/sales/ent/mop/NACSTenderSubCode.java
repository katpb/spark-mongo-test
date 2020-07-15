package com.verifone.isd.vsms2.sales.ent.mop;

import com.verifone.isd.vsms2.sys.l10n.NACSCodeRes;

/**
 * The Enum NACSTenderSubCode is the catalogue for NACS specific tendersubcodes.
 * 
 * @author Sanjeev_S1
 */
public enum NACSTenderSubCode {
	
	/** The generic. */
	GENERIC(NACSCodeRes.GENERIC,200),
	
	/** The commercialcheck. */
	COMMERCIALCHECK(NACSCodeRes.COMMERCIALCHECK,201),
	
	/** The employeecheck. */
	EMPLOYEECHECK(NACSCodeRes.EMPLOYEECHECK,202),
	
	/** The govcheck. */
	GOVCHECK(NACSCodeRes.GOVCHECK,203),
	
	/** The cash. */
	CASH(NACSCodeRes.CASH,204),
	
	/** The cashback. */
	CASHBACK(NACSCodeRes.CASHBACK,205),
	
	/** The ebtfoodstamp. */
	EBTFOODSTAMP(NACSCodeRes.EBTFOODSTAMP,206),
	
	/** The amex. */
	AMEX(NACSCodeRes.AMEX,207),
	
	/** The visa. */
	VISA(NACSCodeRes.VISA,208),
	
	/** The mastercard. */
	MASTERCARD(NACSCodeRes.MASTERCARD,209),
	
	/** The oilcompany. */
	OILCOMPANY(NACSCodeRes.OILCOMPANY,210),
	
	/** The proprietary. */
	PROPRIETARY(NACSCodeRes.PROPRIETARY,211),
	
	/** The manufacturer. */
	MANUFACTURER(NACSCodeRes.MANUFACTURER,212),
	
	/** The store. */
	STORE(NACSCodeRes.STORE,213);


	/** The tender sub code. */
	private final String tenderSubCode;
	
	private final int tenderSubCodeID;
	
	
	/**
	 * Instantiates a new nACS tender sub code.
	 * 
	 * @param tenderSubCode
	 *            the tender sub code
	 */
	NACSTenderSubCode(String tenderSubCode,int tenderSubCodeID){
		this.tenderSubCode = tenderSubCode;
		this.tenderSubCodeID = tenderSubCodeID;
	}


	/**
	 * Gets the tender sub code.
	 * 
	 * @return the tenderSubCode
	 */
	public String getTenderSubCode() {
		return this.tenderSubCode;
	}


	/**
	 * Gets the tender sub code id.
	 * 
	 * @return the tenderSubCodeID
	 */
	public int getTenderSubCodeID() {
		return this.tenderSubCodeID;
	}

}