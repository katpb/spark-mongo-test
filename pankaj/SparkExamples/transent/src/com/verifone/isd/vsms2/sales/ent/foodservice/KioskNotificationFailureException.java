package com.verifone.isd.vsms2.sales.ent.foodservice;


public class KioskNotificationFailureException  extends KioskException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2482106395232587038L;

	public KioskNotificationFailureException(String errorKey, String bundleName) {
        super(errorKey, bundleName);
    }
}
