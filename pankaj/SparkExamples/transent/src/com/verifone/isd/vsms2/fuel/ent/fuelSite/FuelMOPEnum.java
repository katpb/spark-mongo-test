/**
 * 
 */
package com.verifone.isd.vsms2.fuel.ent.fuelSite;

/**
 * Enumeration for fuel MOP levels
 * 
 * @author Raghavendra_R1
 *
 */
public enum FuelMOPEnum {

	UNKNOWN(0, "UNKNOWN"),
	
	CASH(1, "CASH"),
	
	CREDIT(2, "CREDIT");
	
	private int mop;
	private String name;

	/**
	 * @param mop
	 */
	private FuelMOPEnum(int mop, String name) {
		this.mop = mop;
		this.name = name;
	}
	
	public int getMOP() {
		return this.mop; 
	}
	
	public String getName() {
		return this.name;
	}
	
	public static FuelMOPEnum getEnumFromInt(int mop) {
		for(FuelMOPEnum mopEnum : FuelMOPEnum.values()) {
			if(mopEnum.mop == mop) {
				return mopEnum;
			}
		}
		return UNKNOWN;
	}
	
	public static FuelMOPEnum getEnumFromName(String name) {
		for(FuelMOPEnum mopEnum : FuelMOPEnum.values()) {
			if(mopEnum.name.equals(name)) {
				return mopEnum;
			}
		}
		return UNKNOWN;
	}
	
	public static String getNameFromInt(int mop) {
		return FuelMOPEnum.getEnumFromInt(mop).name;
	}
	
	public static int getIntFromName(String name) {
		return FuelMOPEnum.getEnumFromName(name).mop;
	}
}
