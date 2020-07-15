/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
*
* Created 07 Mar, 2006                                     Sudesh Srinivasan
*/
package com.verifone.isd.vsms2.sales.ent.trans;

/**
 * This exception is used by Transaction entity to disallow certain changes
 * to an PaymentLine. 
 * @author  sudesh_s1
 * @version 1.0
 */
public class PaymentLineException extends TransactionException {

    /**
     * @param errorKey
     * @param bundleName
     */
    public PaymentLineException(String errorKey, String bundleName) {
        super(errorKey, bundleName);
    }
}
