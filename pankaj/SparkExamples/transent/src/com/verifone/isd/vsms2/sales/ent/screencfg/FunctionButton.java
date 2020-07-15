/* Copyright (C) 2018 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 29 Nov, 2018                                     T_pankajM2
 */
package com.verifone.isd.vsms2.sales.ent.screencfg;

import com.verifone.isd.vsms2.sales.ent.softkey.SoftKeyType;

/**
 * This class will contain the configuration information required for displaying
 * non function item(such as APPROVE, SAFE DROP etc.) on the Topaz screen.
 *
 * @author T_pankajm2.
 * @version 2.0
 */
public class FunctionButton extends ItemButton {

	/**
	 * 
	 * @param id          - button position id
	 * @param bgColor     - background color
	 * @param lableColor  - text label color
	 * @param textLine1   - Text to use for line 1. Can be null.
	 * @param textLine2   - Text to use for line 2. Can be null.
	 * @param isInactive  - status of the button
	 * @param softKeyType - soft key type
	 * @param image       - image details.
	 */
	public FunctionButton(int id, String bgColor, String lableColor, String textLine1, String textLine2,
			boolean isInactive, SoftKeyType softKeyType, Image image) {
		super(id, bgColor, lableColor, textLine1, textLine2, isInactive, softKeyType, image);
	}

	public String toString() {
		return super.toString();
	}
}
