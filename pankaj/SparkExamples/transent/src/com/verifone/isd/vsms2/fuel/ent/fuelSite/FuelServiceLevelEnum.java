/**
 * 
 */
package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import org.apache.commons.lang.ArrayUtils;

/**
 * Enumeration for fuel service levels
 * 
 * @author Raghavendra_R1
 *
 */
public enum FuelServiceLevelEnum {

	UNKNOWN(0, "UNKNOWN"),
	
	SELF(1, "SELF"),
	
	FULL(2, "FULL"),
	
	MINI(3, "MINI");
	
	private int serviceLevel;
	private String name;

	/**
	 * @param serviceLevel
	 */
	private FuelServiceLevelEnum(int serviceLevel, String name) {
		this.serviceLevel = serviceLevel;
		this.name = name;
	}
	
	public int getServiceLevel() {
		return this.serviceLevel; 
	}
	
	public String getName() {
		return this.name;
	}
	
	public static FuelServiceLevelEnum getEnumFromInt(int level) {
		for(FuelServiceLevelEnum sl : FuelServiceLevelEnum.values()) {
			if(sl.serviceLevel == level) {
				return sl;
			}
		}
		return UNKNOWN;
	}
	
	public static FuelServiceLevelEnum getEnumFromName(String name) {
		for(FuelServiceLevelEnum sl : FuelServiceLevelEnum.values()) {
			if(sl.name.equals(name)) {
				return sl;
			}
		}
		return UNKNOWN;
	}
	
	public static String getNameFromInt(int level) {
		return FuelServiceLevelEnum.getEnumFromInt(level).name;
	}
	
	public static int getIntFromName(String name) {
		return FuelServiceLevelEnum.getEnumFromName(name).serviceLevel;
	}
	
	public static FuelServiceLevelEnum[] getValidValues() {
		return (FuelServiceLevelEnum[]) ArrayUtils.removeElement(FuelServiceLevelEnum.values(), FuelServiceLevelEnum.UNKNOWN); 
	}
}
