/* Copyright (C) 2018 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 29 Nov, 2018                                     T_pankajM2
 */
package com.verifone.isd.vsms2.sales.ent.screencfg;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Contain the item panel related configuration.
 * 
 * @author T_PankajM2
 * @version 1.0
 */
public class PanelCfg {

	private Map<String, ItemPanel> itemPanelMap;
	private Map<String, FuelPanel> fuelPanelMap;
	private Map<String, ParkedMenuPanel> parkedMenuPanelMap;
	private Date creationDate;	

	/**
	 * Constructor
	 */
	public PanelCfg() {	
		itemPanelMap = new LinkedHashMap<String, ItemPanel>();
		fuelPanelMap = new LinkedHashMap<String, FuelPanel>();
		parkedMenuPanelMap = new LinkedHashMap<String, ParkedMenuPanel>();		
	}
	/**
	 * 
	 * @return creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * 
	 * @param creationDate - item panel configuration creation date
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public Map<String, ItemPanel> getItemPanelMap() {
		return itemPanelMap;
	}
	public void setItemPanelMap(Map<String, ItemPanel> itemPanelMap) {
		this.itemPanelMap = itemPanelMap;
	}
	public Map<String, FuelPanel> getFuelPanelMap() {
		return fuelPanelMap;
	}
	public void setFuelPanelMap(Map<String, FuelPanel> fuelPanelMap) {
		this.fuelPanelMap = fuelPanelMap;
	}
	public Map<String, ParkedMenuPanel> getParkedMenuPanelMap() {
		return parkedMenuPanelMap;
	}
	public void setParkedMenuPanelMap(Map<String, ParkedMenuPanel> parkedMenuPanelMap) {
		this.parkedMenuPanelMap = parkedMenuPanelMap;
	}
	public void emptyPanels() {
		itemPanelMap.clear();
		parkedMenuPanelMap.clear();
		fuelPanelMap.clear();		
	}
	public void removeItemPanel(ItemPanel itemPanel) {
		itemPanelMap.remove(itemPanel.getName());
		
	}
	public void addItemPanel(ItemPanel itemPanel) {
		itemPanelMap.put(itemPanel.getName(), itemPanel);
		
	}
	public void removeFuelPanel(FuelPanel fuelPanel) {
		fuelPanelMap.remove(fuelPanel.getName());
		
	}
	public void addFuelPanel(FuelPanel fuelPanel) {
		fuelPanelMap.put(fuelPanel.getName(), fuelPanel);
		
	}
	public void removeParkedMenuPanel(ParkedMenuPanel parkedMenuPanel) {
		parkedMenuPanelMap.remove(parkedMenuPanel.getName());
		
	}
	public void addParkedMenuPanel(ParkedMenuPanel parkedMenuPanel) {
		parkedMenuPanelMap.put(parkedMenuPanel.getName(), parkedMenuPanel);
		
	}
	
	public boolean containsKey(String key) {
		if (itemPanelMap.containsKey(key) || fuelPanelMap.containsKey(key) || parkedMenuPanelMap.containsKey(key)) {
			return true;
		}		
		return false;
	}
	
}