/* Copyright (C) 2018 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 29 Nov, 2018                                     T_pankajM2
 */
package com.verifone.isd.vsms2.sales.ent.screencfg;

import java.util.Map;
import java.util.TreeMap;

/**
 * Contains buttons related details.
 * 
 * @author T_PankajM2
 * @version 1.0
 */
public class ItemPanel {
	private String name;
	private Map<Integer, ItemButton> buttonMap = new TreeMap<>();	

	/**
	 * 
	 * @param name - item panel name.
	 * @throws ScreenCfgException
	 */
	public ItemPanel() {		
	}

	/**
	 * 
	 * @return item panel name
	 */
	public String getName() {
		return name;
	}

	/**
	 * private method for setting the item panel name.
	 * 
	 * @param name item panel name
	 * @throws ScreenCfgException
	 */
	public void setName(String name) {		
		this.name = name;		
	}

	/**
	 * 
	 * @return buttonMap
	 */
	public Map<Integer, ItemButton> getButtonMap() {
		return buttonMap;
	}

	/**
	 * Add single item buttons.
	 * 
	 * @param itemButton - item buttons
	 */
	public void addItemButton(ItemButton itemButton) {

		if (!buttonMap.containsKey(itemButton.getId())) {
			buttonMap.put(itemButton.getId(), itemButton);
		}
	}

	@Override
	public String toString() {
		return String.format("ItemPanel [name=%s, buttonMap=%s, pk=%s]", name, buttonMap);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buttonMap == null) ? 0 : buttonMap.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ItemPanel other = (ItemPanel) obj;
		if (buttonMap == null) {
			if (other.buttonMap != null)
				return false;
		} else if (!buttonMap.equals(other.buttonMap))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		}
		return true;
	}
}
