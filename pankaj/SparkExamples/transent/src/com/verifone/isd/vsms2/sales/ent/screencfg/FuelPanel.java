/* Copyright (C) 2018 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 29 Nov, 2018                                     T_pankajM2
 */
package com.verifone.isd.vsms2.sales.ent.screencfg;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the fuel Panel in the Topaz screen.
 * 
 * @author T_pankajm2.
 * @version 1.0
 */
public class FuelPanel {	
	private String name;
	private List<FuelButton> fuelButtonList = new ArrayList<FuelButton>();

	/**
	 * Constructor
	 */
	public FuelPanel() {
	}

	/**
	 * 
	 * @param button - fuel button to add.
	 */
	public void addFuelButton(FuelButton button) {
		fuelButtonList.add(button);
	}

	/**
	 * 
	 * @param fuelButtonList fuel button list
	 */
	protected void addFuelButtons(List<FuelButton> fuelButtonList) {
		this.fuelButtonList = fuelButtonList;
	}

	/**
	 * 
	 * @return fuel button list
	 */
	public List<FuelButton> getFuelButtons() {
		return fuelButtonList;
	}

	/**
	 * 
	 * @param index - button position ID
	 * @return fuel button.
	 */
	public FuelButton getFuelButton(int index) {
		return fuelButtonList.get(index);
	}

	public void setFuelButton(FuelButton fuelButton) {
		this.fuelButtonList.add(fuelButton);
	}

	/**
	 * 
	 * @return fuelButtonList size.
	 */
	public int getFuelingButtonsSize() {
		return fuelButtonList.size();
	}

	public String getName() {		
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}