package com.verifone.isd.vsms2.sales.ent.trans;

/**
 * DineInDataSet Enum for DineIn
 * @author Peder_K1
 *
 */
public enum DineInDataSet {
	DINEIN("DINEIN"),
	TAKEOUT("TAKEOUT");

	private String dineInString;

	DineInDataSet(String dineInString){
		this.dineInString = dineInString;
	}

	public String dineInString(){
		return dineInString;
	}
}
