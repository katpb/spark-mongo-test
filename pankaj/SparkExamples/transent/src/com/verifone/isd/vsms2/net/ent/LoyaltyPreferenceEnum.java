package com.verifone.isd.vsms2.net.ent;

/**
 * Indicates customer loyalty preference in a transaction. This also aligns with
 * the loyalty customer flag returned by EPS in a card service response. POS
 * should echo this flag in all subsequent card service requests from the same
 * transaction.
 * 
 * @author Anindya_D1
 *
 */
public enum LoyaltyPreferenceEnum {
	TRUE("true"),
	FALSE("false"),
	UNKNOWN("unknown");
	
	
	private String value;

	private LoyaltyPreferenceEnum(String value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * 
	 * @param text
	 * @return the loyalty preference enum based on the String
	 */
	public static LoyaltyPreferenceEnum fromValue(String text) {
		if (text != null) {
			try {
				return LoyaltyPreferenceEnum.valueOf(text.trim().toUpperCase());
			} catch (IllegalArgumentException iae) {
			}
		}
		return null;
	}

}
