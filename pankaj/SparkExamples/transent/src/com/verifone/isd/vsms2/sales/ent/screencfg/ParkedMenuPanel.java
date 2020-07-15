/* Copyright (C) 2018 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 29 Nov, 2018                                     T_pankajM2
 */
package com.verifone.isd.vsms2.sales.ent.screencfg;

/**
 * This class represents the parked menu zone in the Topaz screen.
 *
 * @author T_Pankajm2.
 * @version 2.0
 */
public class ParkedMenuPanel {
	private int defaultParkedMenu;
	private String bgcolor;
	private String labelColor;
	private String name;
	private static final int DEFUALT_PARKEDMEUNU_VALUE = 200;
	private static final String DEFUALT_BGCOLOR_VALUE = "#057cdd";
	private static final String DEFUALT_TEXTCOLOR_VALUE = "#333333";

	/**
	 * Constructor
	 */
	public ParkedMenuPanel() {
	}

	/**
	 * @return Returns the defaultParkedMenu.
	 */
	public int getDefaultParkedMenu() {
		return defaultParkedMenu > 0 ? this.defaultParkedMenu : DEFUALT_PARKEDMEUNU_VALUE;
	}

	/**
	 * @param defaultParkedMenu The defaultParkedMenu to set.
	 */
	public void setDefaultParkedMenu(int defaultParkedMenu) {
		this.defaultParkedMenu = defaultParkedMenu;
	}

	/**
	 * @return Returns the colorId.
	 */
	public String getColorId() {
		return bgcolor != null ? this.bgcolor : DEFUALT_BGCOLOR_VALUE;
	}

	/**
	 * @param colorId The colorId to set.
	 */
	public void setColorId(String colorId) {
		this.bgcolor = colorId;
	}
	
	public String getLabelColor() {
		return labelColor != null ? this.labelColor : DEFUALT_TEXTCOLOR_VALUE;
	}

	public void setLabelColor(String textColor) {
		this.labelColor = textColor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
