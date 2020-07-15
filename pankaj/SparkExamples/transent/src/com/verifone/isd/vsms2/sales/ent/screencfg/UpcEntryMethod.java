/* Copyright (C) 2018 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 29 Nov, 2018                                     T_pankajM2
 */
package com.verifone.isd.vsms2.sales.ent.screencfg;

/**
 * Enum for upc entry method.
 * 
 * @author T_PankajM2
 * @version 1.0
 */
public enum UpcEntryMethod {

	KEYBOARD("keyboard"), SCANNER("scanner"), OTHER("other");
	private final String value;

	UpcEntryMethod(String v) {
		value = v;
	}

	/**
	 * 
	 * @return value.
	 */
	public String value() {
		return value;
	}

	/**
	 * 
	 * @param v
	 * @return instance of UpcEntryMethod.
	 */
	public static UpcEntryMethod fromValue(String v) {
		for (UpcEntryMethod c : UpcEntryMethod.values()) {
			if (c.value.equals(v)) {
				return c;
			}
		}
		throw new IllegalArgumentException(v);
	}
}
