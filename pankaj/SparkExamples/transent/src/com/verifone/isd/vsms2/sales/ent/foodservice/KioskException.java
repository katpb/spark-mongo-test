package com.verifone.isd.vsms2.sales.ent.foodservice;

import com.verifone.isd.vsms2.sys.error.VFIException;


public class KioskException extends VFIException{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 8226149417329160923L;

	public KioskException(String errorKey, String bundleName) {
	        super(errorKey, bundleName);
	    }
}
