package com.verifone.isd.vsms2.sys.util;

/**
 * Enumeration to fix the options that are settable for Baud Rate.
 * 
 */
public enum BaudRates {

	BAUD_110(110),

	BAUD_150(150),

	BAUD_300(300),

	BAUD_600(600),

	BAUD_1200(1200),

	BAUD_2400(2400),

	BAUD_4800(4800),

	BAUD_9600(9600),

	BAUD_19200(19200),

	BAUD_38400(38400),

	BAUD_57600(57600),

	BAUD_115200(115200);

	private int baudRate;

	BaudRates(int baudRate) {
		this.baudRate = baudRate;
	}

	/**
	 * @return the baudRate
	 */
	public int getBaudRate() {
		return this.baudRate;
	}

	/**
	 * Check permitted values in the constant SELECTABLE_VALUES.
	 * If not falling in range,returns null else returns string
	 * representation of the baud rate value sent.
	 * 
	 * @param strVal
	 *            the str val
	 * @return the baud rate
	 */
	public static BaudRates fromString(String strVal) {
		if (strVal != null) {
			for (BaudRates b : BaudRates.values()) {
				if (strVal.equalsIgnoreCase(Integer.toString(b.baudRate))) {
					return b;
				}
			}
		}
		return null;
	}
}