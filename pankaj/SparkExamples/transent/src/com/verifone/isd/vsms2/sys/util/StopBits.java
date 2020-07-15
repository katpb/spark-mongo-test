package com.verifone.isd.vsms2.sys.util;

/**
 *  Enumeration to fix the options that are settable for Stop Bits.
 */
public enum StopBits {

	ONE("1"),

	TWO("2"),

	THREE("3");

	private String stopBits;

	StopBits(String stopBits) {
		this.stopBits = stopBits;
	}

	/**
	 * @return the stopBits
	 */
	public String getStopBits() {
		return this.stopBits;
	}

	/**
	 * Check permitted values in the constant SELECTABLE_VALUES.
	 * If not falling in range,returns null else returns string
	 * representation of the stop bit value sent.
	 * 
	 * @param strVal
	 *            the str val
	 * @return the  stop bits
	 */
	public static StopBits fromString(String strVal) {
		if (strVal != null) {
			for (StopBits b : StopBits.values()) {
				if (strVal.equalsIgnoreCase(b.stopBits)) {
					return b;
				}
			}
		}
		return null;
	}
}