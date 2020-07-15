/*
 * OCBResourceBundle.java
 * Created by: Joe Hutzenbiler
 * 2016-09-29
 *
 * COPYRIGHT (c) 2016 by VeriFone Inc., All Rights Reserved.
 *
 *                       N O T I C E
 *
 * Under Federal copyright law, neither the software nor accompanying
 * documentation may be copied, photocopied, reproduced, translated,
 * or reduced to any electronic medium or machine-readable form, in
 * whole or in part, without the prior written consent of VeriFone Inc.,
 * except in the manner described in the documentation.
 */

package com.verifone.isd.vsms2.sys.l10n;

import java.util.ListResourceBundle;

/**
 *
 * @author Joe_H5
 */
public class OCBResourceBundle extends ListResourceBundle
{
    public static final String ERROR_DEVICE_UNREACHABLE;
	public static final String ERROR_DEVICE_UNREACHABLE_DTL;
    
    static
    {
        int idx = 0;
        ERROR_DEVICE_UNREACHABLE = "ERROR_DEVICE_UNREACHABLE";
        ERROR_DEVICE_UNREACHABLE_DTL = "ERROR_DEVICE_UNREACHABLE_DTL";
    }
    
    protected Object[][] contents = {
		{  ERROR_DEVICE_UNREACHABLE,        "OCB device is not responding!"},
		{  ERROR_DEVICE_UNREACHABLE_DTL,    "Order Confirmation Board device is not responding!"},
    };

    @Override
    protected Object[][] getContents()
    {
        return contents;
    }
   

}
