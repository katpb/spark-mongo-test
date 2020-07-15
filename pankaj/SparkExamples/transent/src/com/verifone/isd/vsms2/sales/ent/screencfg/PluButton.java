/* Copyright (C) 2018 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 29 Nov, 2018                                     T_pankajM2
 */
package com.verifone.isd.vsms2.sales.ent.screencfg;

import com.verifone.isd.vsms2.sales.ent.plu.PluPK;
import com.verifone.isd.vsms2.sales.ent.softkey.SoftKeyType;

/**
 * This class will contain the configuration information required for displaying
 * a Plu item on the Topaz screen. This button can be displayed as part of
 * either ParkedMenuPanel or ItemPanel.
 *
 * @author T_pankajm2.
 * @version 2.0
 */
public class PluButton extends NonFunctionButton {

	private UpcEncodingType upcEncodingType = UpcEncodingType.A; // Default value by schema.
	private UpcEntryMethod upcEntryMethod;

	/**
	 * 
	 * @param id              - button position id
	 * @param bgColor         - background color
	 * @param lableColor      - text label color
	 * @param textLine1       - Text to use for line 1. Can be null.
	 * @param textLine2       - Text to use for line 2. Can be null.
	 * @param isInactive      - status of the button
	 * @param image           - image details.
	 * @param pluID           - PLU primary key
	 * @param upcEncodingType - encoding type
	 * @param upcEntryMethod  - entry method
	 */
	public PluButton(int id, String bgColor, String lableColor, String textLine1, String textLine2, boolean isInactive,
			Image image, PluPK pluID, UpcEncodingType upcEncodingType, UpcEntryMethod upcEntryMethod) {
		super(id, bgColor, lableColor, textLine1, textLine2, isInactive, SoftKeyType.PLU, image, pluID);

		if (upcEncodingType != null) {
			this.upcEncodingType = upcEncodingType;
		}
		this.upcEntryMethod = upcEntryMethod;
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

	public UpcEncodingType getUpcEncodingType() {
		return upcEncodingType;
	}

	public UpcEntryMethod getUpcEntryMethod() {
		return upcEntryMethod;
	}
}
