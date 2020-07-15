/* Copyright (C) 2018 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 29 Nov, 2018                                     T_pankajM2
 */
package com.verifone.isd.vsms2.sales.ent.screencfg;

import com.verifone.isd.vsms2.sales.ent.softkey.SoftKeyType;
import com.verifone.isd.vsms2.sys.util.StringUtils;

/**
 * This class will contain the configuration information required for displaying
 * an item on the Topaz screen. An item can be either a Plu, Menu, Department,
 * MOP, or a Function key.
 * 
 * @author T_pankajm2.
 * @version 2.0
 */
public abstract class ItemButton implements Button {

	private static final String DEFAULT_LABEL_COLOR = "#FFFFFF";
	private static final String DEFAULT_BG_COLOR = "#30323A";
	private String bgColor;
	private String labelColor;
	private String textLine1;
	private String textLine2;
	private SoftKeyType softKeyType;
	private boolean isInActive;
	private Image image;
	private int id;

	/**
	 * 
	 * @param id          - button position id
	 * @param bgColor     - background color
	 * @param labelColor  - text label color
	 * @param textLine1   - Text to use for line 1. Can be null.
	 * @param textLine2   - Text to use for line 2. Can be null.
	 * @param isInactive  - status of the button
	 * @param softKeyType - soft key type
	 * @param image       - image details.
	 */
	protected ItemButton(int id, String bgColor, String labelColor, String textLine1, String textLine2,
			boolean isInactive, SoftKeyType softKeyType, Image image) {
		this.bgColor = bgColor;
		this.textLine1 = textLine1;
		this.textLine2 = textLine2;
		this.softKeyType = softKeyType;
		this.isInActive = isInactive;
		this.image = image;
		this.id = id;
		this.labelColor = labelColor;

	}

	/**
	 * @return Returns the textLine1.
	 */
	public String getTextLine1() {
		return textLine1 != null ? textLine1 : "";
	}

	/**
	 * @param textLine1 The textLine1 to set.
	 */
	public void setTextLine1(String textLine1) {
		this.textLine1 = textLine1;
	}

	/**
	 * @return Returns the textLine2.
	 */
	public String getTextLine2() {
		return textLine2 != null ? textLine2 : "";
	}

	/**
	 * @param textLine2 The textLine2 to set.
	 */
	public void setTextLine2(String textLine2) {
		this.textLine2 = textLine2;
	}

	/**
	 * @return the softKeyType
	 */
	public SoftKeyType getSoftKeyType() {
		return softKeyType;
	}

	/**
	 * @param softKeyType the softKeyType to set
	 */
	protected void setSoftKeyType(SoftKeyType softKeyType) {
		this.softKeyType = softKeyType;
	}

	/**
	 * @return the isInActive
	 */
	public boolean isInActive() {
		return isInActive;
	}

	/**
	 * @param isInActive the isInActive to set
	 */
	public void setInActive(boolean isInActive) {
		this.isInActive = isInActive;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bgColor == null) ? 0 : bgColor.hashCode());
		result = prime * result + id;
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + (isInActive ? 1231 : 1237);
		result = prime * result + ((labelColor == null) ? 0 : labelColor.hashCode());
		result = prime * result + ((softKeyType == null) ? 0 : softKeyType.hashCode());
		result = prime * result + ((textLine1 == null) ? 0 : textLine1.hashCode());
		result = prime * result + ((textLine2 == null) ? 0 : textLine2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemButton other = (ItemButton) obj;
		if (bgColor == null) {
			if (other.bgColor != null)
				return false;
		} else if (!bgColor.equals(other.bgColor))
			return false;
		if (id != other.id)
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (isInActive != other.isInActive)
			return false;
		if (labelColor == null) {
			if (other.labelColor != null)
				return false;
		} else if (!labelColor.equals(other.labelColor))
			return false;
		if (softKeyType == null) {
			if (other.softKeyType != null)
				return false;
		} else if (!softKeyType.equals(other.softKeyType))
			return false;
		if (textLine1 == null) {
			if (other.textLine1 != null)
				return false;
		} else if (!textLine1.equals(other.textLine1))
			return false;
		if (textLine2 == null) {
			if (other.textLine2 != null)
				return false;
		} else if (!textLine2.equals(other.textLine2))
			return false;
		return true;
	}

	public String getBgColor() {
		return StringUtils.isNotNullNotEmpty(bgColor) ? this.bgColor : DEFAULT_BG_COLOR;
	}

	public void setBgColor(String bgColor) {
		this.bgColor = bgColor;
	}

	public String getLabelColor() {
		return StringUtils.isNotNullNotEmpty(labelColor) ? this.labelColor : DEFAULT_LABEL_COLOR;
	}

	public void setLabelColor(String lableColor) {
		this.labelColor = lableColor;
	}

	@Override
	public String toString() {
		return String.format(
				"ItemButton [bgColor=%s, lableColor=%s, textLine1=%s, textLine2=%s, softKeyType=%s, isInActive=%s, image=%s, id=%s]",
				bgColor, labelColor, textLine1, textLine2, softKeyType, isInActive, image, id);
	}
}
