package com.verifone.isd.vsms2.sys.ent.managedevices;

/**
 * Exception class for devices that are not registered
 * 
 * @author MadhusudhanB1
 *
 */
public class DeviceNotRegisteredException extends Exception {

	private static final long serialVersionUID = -7876046082109636054L;

    /**
     * Instantiates a new of device not registered exception
     * 
     * @param errorKey the error key
     */
    public DeviceNotRegisteredException(String errorKey) {
		super(errorKey);
    }
    
    /**
     * Instantiates a new of device not registered exception
     */
    public DeviceNotRegisteredException() {
    	super();
    }
}
