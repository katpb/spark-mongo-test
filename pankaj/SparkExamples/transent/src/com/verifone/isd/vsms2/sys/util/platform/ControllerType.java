package com.verifone.isd.vsms2.sys.util.platform;

/**
 * The Enum ControllerType constitutes of different controller types supported.
 * 
 * @author Sanjeev_S1
 */
public enum ControllerType {

	/** The commander. */
	COMMANDER("Site Controller","Commander"),

	/** The rubyci. */
	RUBYCI("Ruby Ci","Ruby Ci");

	/**
	 * Instantiates a new controller type.
	 * 
	 * @param controllerName
	 *            the controller name
	 */
	ControllerType(String controllerName,String controllerDisplayName ) {
		this.controllerName = controllerName;
		this.controllerDisplayName = controllerDisplayName;
	}

	/** The controller name. */
	private String controllerName;

	/**
	 * The controller display Name 
	 */
	private String controllerDisplayName; 
	
	/**
	 * Gets the controller name.
	 * 
	 * @return the controller name
	 */
	public String getControllerName() {
		return this.controllerName;
	}
	
	public String getControllerDisplayName() {
		return controllerDisplayName;
	}
}