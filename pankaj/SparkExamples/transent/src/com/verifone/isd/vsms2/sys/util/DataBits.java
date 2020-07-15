package com.verifone.isd.vsms2.sys.util;

/**
 * Enumeration to fix the options that are settable for Data Bits.
 * 
 */
public enum DataBits {

	FIVE("5"),

	SIX("6"),

	SEVEN("7"),

	EIGHT("8");

	private  String dataBits;

	DataBits(String dataBits) {
		this.dataBits = dataBits;
	}

	/**
	 * @return the dataBits
	 */
	public String getDataBits() {
		return this.dataBits;
	}

	/**
	 * Check permitted values in the constant SELECTABLE_VALUES.
	 * If not falling in range,returns null else returns actual
	 * value of the data bit value sent.
	 * 
	 * @param strVal
	 *            the str val
	 * @return the data bits
	 */
	public static DataBits fromString(String strVal) {
		if (strVal != null) {
			for (DataBits b : DataBits.values()) {
				if (strVal.equalsIgnoreCase(b.dataBits)) {
					return b;
				}
			}
		}
		return null;
	}
}