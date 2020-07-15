/**
 * TransactionType.java
 *
 * Created on April 29, 2003, 5:40 PM
 * Modified 2/13/2109 joswillp1: changed to enum and localizable.
 */
package com.verifone.isd.vsms2.sales.ent.trans;

import com.verifone.isd.vsms2.sys.l10n.LocalizedRB;

public enum TransactionType {
	/**
	 * Do not change the order of the enum, add new values at the end of the list.
	 * The ordinal is persisted in the DB therefore the order MUST be immutable.
	 */
	SALE("SALE"),
	REFUND("REFUND"),
	NOSALE("NOSALE", false),
	SAFEDROP("SAFEDROP"),
	SAFELOAN("SAFELOAN"),
	PAYOUT("PAYOUT"),
	PAYIN("PAYIN"),
	CLOCKOUT("CLOCKOUT", false),
	CLOCKIN("CLOCKIN", false),
	FREEPOPCODE("FREE POP CODE", false),
	FREEAUTOPOPCODE("FREE AUTO POP CODE", false),
	FREEPOPCOUPON("FREE POP COUPON", false),
	KIOSKORDER("KIOSK ORDER"),
	SAFEDROP_CORRECTION("SDRP CORR");

	/**
	 * Should not be here kept for backward compatibility.
	 */
	private String oldName;

	private String localizedString;
	private boolean financial;

	private TransactionType(String name) {
		this(name, true);
	}

	private TransactionType(String name, boolean financial) {
		this.oldName = name;
		this.localizedString = LocalizedRB.getSalesCfgRes(super.name());
		this.financial = financial;
	}

	public boolean isFinancial() {
		return this.financial;
	}

	/** 
	 * Override toString() method to provide the transaction type's name
	 * Maintained for backward compatibility, Should not been done this way
	 * since the beginning.
	 * 
	 * @return transaction type's name
	 */    
	@Override
	public String toString() {
		return this.oldName;
	}

	/**
	 * Returns the localized string for the TransactionType using the default
	 * locale.
	 * 
	 * The type is localized in {@link com.verifone.isd.vsms2.sys.l10n.SalesConfigRes}
	 * 
	 * @return the localized string for the type.
	 */
	public String toLocalizedString() {
		return localizedString;
	}

	/**
	 * Given a String, returns the corresponding TransactionType enumeration
	 * Returns null, if no match found. 
	 * 
	 * @param str
	 * @return
	 */
	public static TransactionType fromString(String str) {
		for(TransactionType type : TransactionType.values()) {
			if(type.oldName.equalsIgnoreCase(str)) {
				return type;
			}
		}
		return null;
	}

	public static final TransactionType getObject(int ordinal) {
		return TransactionType.values()[ordinal];
	}
}
