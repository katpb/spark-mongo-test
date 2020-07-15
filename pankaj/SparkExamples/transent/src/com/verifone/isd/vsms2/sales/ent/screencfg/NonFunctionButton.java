/* Copyright (C) 2018 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 29 Nov, 2018                                     T_pankajM2
 */
package com.verifone.isd.vsms2.sales.ent.screencfg;

import com.verifone.isd.vsms2.sales.ent.softkey.SoftKeyType;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * This class will contain the configuration information required for displaying
 * either a Menu, Department, or an MOP item on the Topaz screen.
 *
 * @author T_pankajm2
 * @version 2.0
 */
public abstract class NonFunctionButton extends ItemButton {

	private IEntityPK pk;

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
	 * @param pk          - primary key.
	 */
	public NonFunctionButton(int id, String bgColor, String lableColor, String textLine1, String textLine2,
			boolean isInactive, SoftKeyType softKeyType, Image image, IEntityPK pk) {
		super(id, bgColor, lableColor, textLine1, textLine2, isInactive, softKeyType, image);
		this.pk = pk;
	}

	/**
	 * @return Returns the itemId.
	 */
	public IEntityPK getPK() {
		return pk;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		return String.format("NonFunctionButton %s [id=%s]", super.toString(), pk);
	}
}
