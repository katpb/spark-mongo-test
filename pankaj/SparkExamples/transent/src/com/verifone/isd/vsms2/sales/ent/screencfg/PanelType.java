/* Copyright (C) 2018 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 29 Nov, 2018                                     T_pankajM2
 */
package com.verifone.isd.vsms2.sales.ent.screencfg;

/**
 * Enum for panel type.
 * 
 * @author T_PankajM2
 * @version 1.0
 */
public enum PanelType {
	FUEL, ITEM, PARKED_MENU;

	/**
	 * 
	 * @return panel name
	 */
	public String value() {
		return name();
	}

	/**
	 * 
	 * @param v
	 * @return instance of {@link PanelType}.
	 */
	public static PanelType fromValue(String v) {
		return valueOf(v);
	}
}