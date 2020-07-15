/* Copyright (C) 2018 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 29 Nov, 2018                                     T_pankajM2
 */
package com.verifone.isd.vsms2.sales.ent.screencfg;

/**
 * Enum for encoding type for UPC.
 * 
 * @author T_PankajM2
 * @version 1.0
 */
public enum UpcEncodingType {

	A, E, EAN, RW;

	/**
	 * 
	 * @return name.
	 */
	public String value() {
		return name();
	}

	/**
	 * 
	 * @param v
	 * @return instance of UpcEncodingType
	 */
	public static UpcEncodingType fromValue(String v) {
		return valueOf(v);
	}
}
