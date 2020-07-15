/*
 * UnknownEntityException.java
 *
 * Created on July 27, 2004, 4:30 PM
 */

package com.verifone.isd.vsms2.sys.db.pres;

/**
 * Exception to notify unsupported/ invalid entity type access.
 * @version 1.0 Copyright(c) 2000-2007 Verifone, All Rights Reserved.
 */
public class UnsupportedEntityException extends DBException {
	/**
	 * Ensures compatibility between versions when serializing and deserializing objects.
	 */
	static final long serialVersionUID = 5774082644419647866L;

	/**
	 * Creates a new instance of <code>UnknownEntityException</code> without detail message.
     * @param msg The exception message string.
     */
    public UnsupportedEntityException(String msg) {
        super(msg);
    }
    
    /**
     * Constructs an instance of <code>UnknownEntityException</code> with the
     * specified detail message.
     */
    public UnsupportedEntityException() {
        super("Invalid/ Unsupported Entity");
    }
}
