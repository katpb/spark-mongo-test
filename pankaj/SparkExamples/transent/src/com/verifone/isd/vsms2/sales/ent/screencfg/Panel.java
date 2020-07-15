/* Copyright (C) 2018 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 29 Nov, 2018                                     T_pankajM2
 */
package com.verifone.isd.vsms2.sales.ent.screencfg;

/**
 * Contains the panel details.
 * 
 * @author T_PankajM2
 * @version 1.0
 */
public class Panel {
	private PanelType panelType;
	private String name;
	private int position;

	/**
	 * 
	 * @return panel type
	 */
	public PanelType getPanelType() {
		return panelType;
	}

	/**
	 * 
	 * @param panelType - panel type
	 */
	public void setPanelType(PanelType panelType) {
		this.panelType = panelType;
	}

	/**
	 * 
	 * @return panel name
	 */
	public String getName() {
		return name != null ? this.name : "";
	}

	/**
	 * 
	 * @param name - set panel name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return panel position.
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * 
	 * @param position - set position.
	 */
	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return String.format("Panel [panelType=%s, name=%s, position=%s]", panelType, name, position);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((panelType == null) ? 0 : panelType.hashCode());
		result = prime * result + position;
		return result;
	}

	@Override
	/**
	 * Overrides to avoid the duplicate entry in panelmap of screen.
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Panel other = (Panel) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (panelType != other.panelType)
			return false;
		if (position != other.position)
			return false;
		return true;
	}
}
