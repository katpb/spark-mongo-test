package com.verifone.isd.vsms2.sys.ent.report;

import java.io.Serializable;

/**
 * This is the system entity for processing Auto End of Day configuration
 * requests
 * 
 */
public class AEOD implements Serializable{


	private static final long serialVersionUID = 170664919104453832L;
	
	/*
	 *  enableAEOD flag is responsible for enabling or disabling Auto End of Day
	 *  True  : Auto End of Day Enabled
	 *  False :	Auto End of Day Disabled
	 */
	private boolean enableAEOD;
	
	/*
	 * aeodTime variable is responsible for automatic close daily at a specified time of day
	 * String of format HH:MM
	 *  
	 */
	private String aeodTime;	
	
	/*
	 * aeodDisableFuel	True 	– Disables fueling until period close runs 
	 * 					False  	-  Start period Close without considering the fueling status
	 */
	private boolean aeodDisableFuel;

	
	/**
	 * If set, ignores the network error during AEOD. 
	 */
	private boolean aeodIgnoreNetworkError;
	/**
	 * @return the enableAEOD
	 *  True  : Auto End of Day Enabled
	 *  False :	Auto End of Day Disabled
	 */
	public boolean isEnableAEOD() {
		return enableAEOD;
	}

	/**
	 * @param enableAEOD the enableAEOD to set
	 * 
	 */
	public void setEnableAEOD(boolean enableAEOD) {
		this.enableAEOD = enableAEOD;
	}

	/**
	 * @return the aeodTime
	 * String of format HH:MM
	 */
	public String getAeodTime() {
		return aeodTime;
	}

	/**
	 * @param aeodTime the aeodTime to set
	 * String of format HH:MM
	 */
	public void setAeodTime(String aeodTime) {
		this.aeodTime = aeodTime;
	}

	/**
	 * @return the aeodDisableFuel
	 * 				True 	– Disables fueling until period close runs 
	 * 				False  	- Start period Close without considering the fueling status
	 */
	public boolean isAeodDisableFuel() {
		return aeodDisableFuel;
	}

	/**
	 * @param aeodDisableFuel the aeodDisableFuel to set
	 */
	public void setAeodDisableFuel(boolean aeodDisableFuel) {
		this.aeodDisableFuel = aeodDisableFuel;
	}

	/**
	 * 
	 * @return aeodIgnoreNetworkError
	 */
	public boolean isAeodIgnoreNetworkError() {
		return aeodIgnoreNetworkError;
	}

	/**
	 * Sets aeodIgnoreNetworkError
	 * @param aeodIgnoreNetworkError
	 */
	public void setAeodIgnoreNetworkError(boolean aeodIgnoreNetworkError) {
		this.aeodIgnoreNetworkError = aeodIgnoreNetworkError;
	}


	
}
