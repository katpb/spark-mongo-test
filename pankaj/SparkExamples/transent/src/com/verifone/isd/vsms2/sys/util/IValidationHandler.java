package com.verifone.isd.vsms2.sys.util;

/**
 * 
 *
 */
public interface IValidationHandler {
	
	/**
	 * method to define whether the data has to be validated or not
	 * @param shouldValidate
	 */
	public void shouldValidateData(boolean shouldValidate);

}
