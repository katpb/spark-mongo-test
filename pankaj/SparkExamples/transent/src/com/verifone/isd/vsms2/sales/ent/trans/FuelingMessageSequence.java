/**
 * 
 */
package com.verifone.isd.vsms2.sales.ent.trans;

/**
 * @author anindya_d1
 *
 */
public enum FuelingMessageSequence {
	
	BEFOREFUELING,
	DURINGFUELING,
	AFTERFUELING;
	
	/**
	 * 
	 * @param text
	 * @return the fueling message sequence enum based on the string
	 */
	public static FuelingMessageSequence fromValue(String text) {
		if (text != null) {
			try {
				return FuelingMessageSequence.valueOf(text.trim().toUpperCase());
			} catch (IllegalArgumentException iae) {
			}
		}
		return null;
	}
}
