package com.verifone.isd.vsms2.sys.db.pres;
import java.lang.Exception;

/**
 * Exception class for error in getting IEntityPersistAdmin for a required
 * entity and/or operations performed through IEntityPersistAdmin.
 * @see IEntityPersistState
 * @see IEntityPersistAdmin
 * @see IEntityObject
 * @version 1.0 Copyright(c) 2000-2007 Verifone, All Rights Reserved.
 */
public class DBException extends Exception {
	/**
	 * Ensures compatibility between versions when serializing and deserializing objects.
	 */
	static final long serialVersionUID = 3806493214038759194L;

	/**
     * Constructs an exception with a reason message.
     * @param reason The reason for the exception.
     */
    public DBException(String reason) {
        super(reason);
    }
}
