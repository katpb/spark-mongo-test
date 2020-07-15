package com.verifone.isd.vsms2.sys.util.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class to access explicitly named loggers. Currently, two loggers
 * fall into this category: AUTOUPGRADE and SECURITY.
 * @author bhanu_a1
 */
public final class NamedLoggers {
    public static final Logger AUTOUPGRADE = LoggerFactory.getLogger("autoupgrade");
    public static final Logger RSD = LoggerFactory.getLogger("RSD");
    public static final Logger SECURITY = LoggerFactory.getLogger("security");
}
