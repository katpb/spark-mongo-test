/* Copyright (C) 2018 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 29 Nov, 2018                                     T_pankajM2
 */
package com.verifone.isd.vsms2.sales.ent.screencfg;

/**
 * This class will contain the configuration information required for displaying
 * a fueling position on the Topaz screen.
 * 
 * @author T_pankajm2.
 * @version 2.0
 */
public class FuelButton implements Button {

	private int fuelingPositionId;

	/**
	 * constructor
	 * 
	 * @param fuelingPositionId - fueling position id.
	 */
	public FuelButton(int fuelingPositionId) {
		this.fuelingPositionId = fuelingPositionId;
	}

	/**
	 * @return Returns the fuelingPositionId.
	 */
	public int getFuelingPositionId() {
		return fuelingPositionId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "fuelingPositionId-" + fuelingPositionId;
	}
}