/*
 * MnspVpnRes.java
 * Created by: Joe Hutzenbiler
 * 2019-02-05
 *
 * COPYRIGHT (c) 2019 by VeriFone Inc., All Rights Reserved.
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
 * @author joe_h5
 */
public class MnspVpnRes extends ListResourceBundle 
{
    
    public static final String E0 = "E0";
    public static final String E1 = "E1";
    public static final String E2 = "E2";
    public static final String E3 = "E3";
    public static final String E4 = "E4";
    public static final String E5 = "E5";
    public static final String E9999 = "E9999";

    @Override
    protected Object[][] getContents()
    {
        return CONTENTS;
    }
    
    static private final Object[][] CONTENTS = {
        {E0, "OK"},
        {E1, "VPN Connection terminated due to timeout."},
        {E2, "Physical connection not available."},
        {E3, "Network not available"},
        {E4, "Remote VPN service host not available."},
        {E5, "Service host authentication failure."},
        {E9999, "General Error - {0}."}
    };

}
