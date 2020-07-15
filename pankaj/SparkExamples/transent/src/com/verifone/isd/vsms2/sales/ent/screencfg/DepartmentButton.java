/* Copyright (C) 2018 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 29 Nov, 2018                                     T_pankajM2
 */
package com.verifone.isd.vsms2.sales.ent.screencfg;

import com.verifone.isd.vsms2.sales.ent.dept.DepartmentPK;
import com.verifone.isd.vsms2.sales.ent.softkey.SoftKeyType;

/**
 * This class will contain the configuration information required for displaying
 * a Department item button on the Topaz screen. This button can be displayed as
 * part of either ParkedMenuPanel or ItemPanel.
 *
 * @author T_pankajm2.
 * @version 2.0
 */
public class DepartmentButton extends NonFunctionButton {

	/**
	 * 
	 * @param id           - button position number
	 * @param bgColor      - background color
	 * @param lableColor   - text label color
	 * @param textLine1    - Text to use for line 1. Can be null.
	 * @param textLine2    - Text to use for line 2. Can be null.
	 * @param isInactive   - status of the button
	 * @param image        - image for button
	 * @param departmentNr - department PK.
	 */
	public DepartmentButton(int id, String bgColor, String lableColor, String textLine1, String textLine2,
			boolean isInactive, Image image, DepartmentPK departmentNr) {
		super(id, bgColor, lableColor, textLine1, textLine2, isInactive, SoftKeyType.DEPT, image, departmentNr);
	}

	/**
	 * @param softKeyType the softKeyType to set
	 */
	@Override
	protected void setSoftKeyType(SoftKeyType softKeyType) {
		// Preventing from modifying softky type.
	}

	@Override
	public String toString() {
		return String.format(
				"DepartmentButton [getPK()=%s, toString()=%s, getTextLine1()=%s, getTextLine2()=%s, getSoftKeyType()=%s, isInActive()=%s, getImage()=%s, getId()=%s, hashCode()=%s, getBgColor()=%s, getLableColor()=%s, getClass()=%s]",
				getPK(), super.toString(), getTextLine1(), getTextLine2(), getSoftKeyType(), isInActive(), getImage(),
				getId(), hashCode(), getBgColor(), getLabelColor(), getClass());
	}
}
