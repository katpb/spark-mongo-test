/* Copyright (C) 2018 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 29 Nov, 2018                                     T_pankajM2
 */
package com.verifone.isd.vsms2.sales.ent.screencfg;

/**
 * Color constant to provide support for old screen configuration conversion.
 * 
 * @author T_PankajM2
 *
 */
public enum ColorSchemeConstant {
	BROWN(1, "#A52A2A", "#FDFFED"), BLUE(2, "#0000FF", "#F2F2F8"), GREEN(3, "#00FF00", "#000000"),
	PERIWINKLE(4, "#CCCCFF", "#F9F1F8"), PURPLE(5, "#A020F0", "#F9F1F8"), YELLOW(6, "#FFFF00", "#000000"),
	UNASSIGNEDKEY(7, "#CCCCCC", "#000000"), SILVER(8, "#C0C0C0", "#000000"), NAVY_BLUE(9, "#000080", "#F2F2F8"),
	SEA_FOAM(10, "#A3C1AD", "#000000"), DARK_GREEN(11, "#006400", "#F1F7EF"), PALE_BLUE(12, "#AFEEEE", "#000000"),
	GOLD(13, "#FFD700", "#000000"), BISQUE(14, "#FFE4C4", "#000000"), COPPER(15, "#B87333", "#000000"),
	LILAC(16, "#C8A2C8", "#000000"), RED(17, "#FF0000", "#000000"), PALE_YELLOW(18, "#CDCD00", "#000000"),
	PALE_GREEN(19, "#98FB98", "#000000"), TEAL_GREEN(20, "#008080", "#000000"), MAROON(21, "#800000", "#FAF2F5"),
	ROYAL_BLUE(22, "#4169E1", "#F2F2F8"), INACTIVEKEY(23, "#C1C1C1", "#808080"), LIGHT_BLUE(24, "#BFEFFF", "#FFFFFF"),
	MEDIUM_BLUE(25, "#0000CD", "#FFFFFF"), LIGHT_TEAL(26, "#B2D8D8", "#FFFFFF"), MEDIUM_TEAL(27, "#66B2B2", "#FFFFFF");

	private final String labelColor;
	private final String bgColor;
	private final int colorID;

	/**
	 * Private constructor - do not allow subclasses.
	 * 
	 * @param num color number
	 * @param bgc background hexadecimal number
	 * @param lbc label hexadecimal number
	 */
	private ColorSchemeConstant(int num, String bgc, String lbc) {
		colorID = num;
		bgColor = bgc;
		labelColor = lbc;
	}

	/**
	 * 
	 * @return hexadecimal background color
	 */
	public String getBGColor() {
		return bgColor;
	}

	/**
	 * 
	 * @return hexadecimal text label color
	 */
	public String getLabelColor() {
		return labelColor;
	}

	/**
	 * 
	 * @return color id.
	 */
	public int colorNum() {
		return colorID;
	}

	/**
	 * 
	 * @param color id
	 * @return instance ColorSchemeConstant to the passed color id.
	 */
	public static ColorSchemeConstant fromValue(int v) {
		for (ColorSchemeConstant c : ColorSchemeConstant.values()) {
			if (c.colorID == v) {
				return c;
			}
		}
		return UNASSIGNEDKEY;
	}
}
