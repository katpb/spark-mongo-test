/**
 * 
 */
package com.verifone.isd.vsms2.fuel.ent.fuelSite;

/**
 * Enumeration for fuel tier levels
 * 
 * @author Raghavendra_R1
 *
 */
public enum FuelTierEnum {

	UNKNOWN(0, "UNKNOWN"),
	
	ONE(1, "NORMAL"),
	
	TWO(2, "ALTERNATE");
	
	private int tierLevel;
	private String name;

	/**
	 * @param tierLevel
	 */
	private FuelTierEnum(int tierLevel, String name) {
		this.tierLevel = tierLevel;
		this.name = name;
	}
	
	public int getTierLevel() {
		return this.tierLevel; 
	}
	
	public String getName() {
		return this.name;
	}
	
	public static FuelTierEnum getEnumFromInt(int level) {
		for(FuelTierEnum tier : FuelTierEnum.values()) {
			if(tier.tierLevel == level) {
				return tier;
			}
		}
		return UNKNOWN;
	}
	
	public static FuelTierEnum getEnumFromName(String name) {
		for(FuelTierEnum tier : FuelTierEnum.values()) {
			if(tier.name.equals(name)) {
				return tier;
			}
		}
		return UNKNOWN;
	}
	
	public static String getNameFromInt(int level) {
		return FuelTierEnum.getEnumFromInt(level).name;
	}
	
	public static int getIntFromName(String name) {
		return FuelTierEnum.getEnumFromName(name).tierLevel;
	}
}
