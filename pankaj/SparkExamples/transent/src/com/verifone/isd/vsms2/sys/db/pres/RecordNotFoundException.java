package com.verifone.isd.vsms2.sys.db.pres;

/**
 * Exception class to notify if a requested entity does not exist.
 * @see DBException
 * @version 1.0 Copyright(c) 2000-2007 Verifone, All Rights Reserved.
 */
public class RecordNotFoundException extends DBException {
	/**
	 * Ensures compatibility between versions when serializing and deserializing objects.
	 */
	static final long serialVersionUID = 138819426046835484L;
	
    /**
     * Constructs an exception with a reason message.
     * @param reason The reason for the exception.
     */
    public RecordNotFoundException(String reason) {
        super(reason);
    }
}
