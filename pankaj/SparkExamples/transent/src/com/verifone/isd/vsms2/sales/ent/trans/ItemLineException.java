/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
*
* Created 07 Mar, 2006                                     Sudesh Srinivasan
*/
package com.verifone.isd.vsms2.sales.ent.trans;

/**
 * This exception is used by Transaction entity to disallow certain changes
 * to an ItemLine. 
 * @author  sudesh_s1
 * @version 1.0
 */
public class ItemLineException extends TransactionException {

    /**
     * @param errorKey
     * @param bundleName
     */
    public ItemLineException(String errorKey, String bundleName) {
        super(errorKey, bundleName);
    }
    
    public ItemLineException(String errorKey, String bundleName, Throwable source) {
        super(errorKey, bundleName, source);
    }
}
