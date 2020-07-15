package com.verifone.isd.vsms2.sys.util.platform;

/**
 * A factory for creating ControllerInfo objects.
 * 
 * @author Sanjeev_S1
 */
public class ControllerInfoFactory {

	/**
	 * Gets the controller info.
	 * 
	 * @return the controller info
	 */
	public static IControllerInfo getControllerInfo() {
		return ControllerInfoImpl.getInstance();
		/**
		 * TO-DO:If there is a need to come up with new implementation of
		 * specific controller info,we can introduce the logic here to pick up
		 * the necessary implementation.As of now,rubyCI and commander doesn't
		 * require a separate implementation.
		 */
	}
}
