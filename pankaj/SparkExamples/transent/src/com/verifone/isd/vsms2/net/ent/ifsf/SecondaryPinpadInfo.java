package com.verifone.isd.vsms2.net.ent.ifsf;

/**
 * Entity class for storing SecondaryPinpadName and isSecondaryPinpadEnable
 * This Entity will used as Value in a Map.
 * @author MuditS1
 *
 */
public class SecondaryPinpadInfo {
	
	private String secondaryPinpadName; // Secondary Pinpad Name
	private boolean isSecondaryPinpadEnabled; // Secondary Pinpad is enabled or not.
	private String laneId; //Lane ID for Secondary Pinpad
	
	/**
	 * Constructor for SecondaryPinpadInfo. 
	 * @param secondaryPinpadName
	 * @param isSecondaryPinpadEnabled
	 */
	public SecondaryPinpadInfo(String secondaryPinpadName, boolean isSecondaryPinpadEnabled, String laneId){
		this.secondaryPinpadName = secondaryPinpadName;
		this.isSecondaryPinpadEnabled = isSecondaryPinpadEnabled;
		this.laneId = laneId;
	}

	/**
	 * Getter for Lane ID for Secondary Pinpad.
	 * @return laneId
	 */
	public String getLaneId() {
		return laneId;
	}

	/**
	 * Getter for Secondary Pinpad Name. 
	 * @return secondaryPinpadName
	 */
	public String getSecondaryPinpadName() {
		return secondaryPinpadName;
	}

	/**
	 * Returns whether the Secondary is enabled or not. 
	 * @return isSecondaryPinpadEnabled
	 */
	public boolean isSecondaryPinpadEnabled() {
		return isSecondaryPinpadEnabled;
	}
	
}
