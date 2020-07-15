/*
 * SignedPackageUpdateRes.java
 *
 * COPYRIGHT (c) 2013 by VeriFone Inc., All Rights Reserved.
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
 * Resource bundle for all Signed Package Update related strings.  This is the
 * abbreviated class name bundle.
 * 
 * @see SignedPackageUpdateRes
 * 
 * @author David_G3
 */
public class SignedPackageUpdateRes extends ListResourceBundle {
    public static final String FILE_SIZE_LIMIT_EXCEEDED;
    public static final String FE_LIC_FILE_INSTALLATION_FAILED;
    public static final String EXCEPTION_IN_FE_FILE_RECEIVE;
    public static final String EXCEPTION_IN_SWUPGR_FILE_RECEIVE;
    public static final String INVALID_BASE64_DATA;
    public static final String INVALID_PORTALCMD;
    public static final String HANDLER_IS_BUSY;

    static
    {       
        FILE_SIZE_LIMIT_EXCEEDED = "FILE_SIZE_LIMIT_EXCEEDED";
        FE_LIC_FILE_INSTALLATION_FAILED = "FE_LIC_FILE_INSTALLATION_FAILED";
        EXCEPTION_IN_FE_FILE_RECEIVE = "EXCEPTION_IN_FE_FILE_RECEIVE";
        EXCEPTION_IN_SWUPGR_FILE_RECEIVE = "EXCEPTION_IN_SWUPGR_FILE_RECEIVE";
        INVALID_BASE64_DATA = "INVALID_BASE64_DATA";
        INVALID_PORTALCMD = "INVALID_PORTALCMD";
        HANDLER_IS_BUSY = "HANDLER_IS_BUSY";
    };

	private static final Object[][] CONTENTS = {
        { FILE_SIZE_LIMIT_EXCEEDED, "Uploaded file exceeds size limit"},
        { FE_LIC_FILE_INSTALLATION_FAILED, "Installation of feature enablement license failed"},
        { EXCEPTION_IN_FE_FILE_RECEIVE, "Exception occurred during FE file reception: "},
        { EXCEPTION_IN_SWUPGR_FILE_RECEIVE, "Exception occurred during software upgrade file reception: "},
        { INVALID_BASE64_DATA, "Cannot convert received data from Base64: "},
        { INVALID_PORTALCMD, "Invalid command request - ''{0}''!"},
        { HANDLER_IS_BUSY, "Command handler is busy with another request"},
    };

    @Override
    protected Object[][] getContents()
    {
        return CONTENTS;
    }
}
