/* Copyright (C) 2018 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 29 Nov, 2018                                     T_pankajM2
 */
package com.verifone.isd.vsms2.sales.ent.screencfg;

import com.verifone.isd.vsms2.sales.ent.menu.MenuPK;
import com.verifone.isd.vsms2.sales.ent.softkey.SoftKeyType;

/**
 * This class will contain the configuration information required for displaying
 * a Menu item on the Topaz screen. This button can be displayed as part of
 * either ParkedMenuPanel or ItemPanel.
 *
 * @author T_pankajm2.
 * @version 2.0
 */
public class MenuButton extends NonFunctionButton {

	/**
	 * 
	 * @param id         - button position id
	 * @param bgColor    - background color
	 * @param lableColor - text label color
	 * @param textLine1  - Text to use for line 1. Can be null.
	 * @param textLine2  - Text to use for line 2. Can be null.
	 * @param isInactive - status of the button
	 * @param image      - image details.
	 * @param menuNr     - menu primary key.
	 */
	public MenuButton(int id, String bgColor, String lableColor, String textLine1, String textLine2, boolean isInactive,
			Image image, MenuPK menuNr) {
		super(id, bgColor, lableColor, textLine1, textLine2, isInactive, SoftKeyType.MENUKEY, image, menuNr);
	}

	/**
	 * @param softKeyType the softKeyType to set
	 */
	@Override
	protected void setSoftKeyType(SoftKeyType softKeyType) {
		// Preventing from modifying softky type.
	}

	public String toString() {
		return super.toString();
	}
}
