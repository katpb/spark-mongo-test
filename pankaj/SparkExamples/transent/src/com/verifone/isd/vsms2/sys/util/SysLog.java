package com.verifone.isd.vsms2.sys.util;

import com.verifone.isd.vsms2.sys.util.log4j.RemoteLog;

/**
 * Skeleton temporarily in place until a home is found for the only method hosted here
 */
public class SysLog
{
    public static boolean isRemoteServerReachable() {
        return RemoteLog.getInstance().isRemoteServerReachable();
    }
}
