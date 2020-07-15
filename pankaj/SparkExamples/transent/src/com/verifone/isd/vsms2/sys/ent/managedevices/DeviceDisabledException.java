package com.verifone.isd.vsms2.sys.ent.managedevices;

/**
 * Exception class for disabled device
 * 
 * @author MadhusudhanB1
 *
 */
public class DeviceDisabledException extends Exception {

	private static final long serialVersionUID = -1266756296210815678L;

    /**
     * Instantiates a new device disabled exception.
     * 
     * @param errorKey the error key
     */
    public DeviceDisabledException(String errorKey) {
		super(errorKey);
    }
    
    /**
     * Instantiates a new device disabled exception.
     */
    public DeviceDisabledException() {
    	super();
    }
}
