/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
*
* Created 07 Mar, 2006                                     Sudesh Srinivasan
*/
package com.verifone.isd.vsms2.sales.ent.trans;

import com.verifone.isd.vsms2.sys.error.VFIException;

/**
 * 
 * @author  sudesh_s1
 * @version 1.0
 */
public class TransactionException extends VFIException {

    /**
     * @param errorKey
     * @param bundleName
     */
    public TransactionException(String errorKey, String bundleName) {
        super(errorKey, bundleName);
    }
    
    public TransactionException(String errorKey, String bundleName,
            Throwable source) {
        super(errorKey, bundleName, source);
    }
}
