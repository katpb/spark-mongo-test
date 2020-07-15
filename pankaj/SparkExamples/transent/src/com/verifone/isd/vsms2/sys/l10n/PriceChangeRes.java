/*
 * Created on Feb 14, 2005
 *
 * Copyright (C) VeriFone, Inc. 							ALL RIGHTS RESERVED
 *
 * Collect the strings distributed throughout the application into a resource
 * bundle for localization (L10N).
 */
package com.verifone.isd.vsms2.sys.l10n;

import java.util.ListResourceBundle;

/**
 * @author Aamir_S1
 * @version 1.0
 * Resource bundle for all fuel view related strings.
 * Strings here have constants that reference the string key used for lookup.
 * This looks redundant, but allows compile-time checking that we have at least
 * a valid key to index.
 */
public class PriceChangeRes extends ListResourceBundle {
    
	public final static String FUEL_PRICE_PEND  = "FUEL_PRICE_PEND";
	public final static String INIT_FUEL	    = "INIT_FUEL";
	public final static String FUEL_PRICE_PEND_LONG  = "FUEL_PRICE_PEND_LONG";
	public final static String FUEL_UPDATES_PEND      = "FUEL_UPDATES_PEND";
	public final static String FUEL_UPDATES_PEND_LONG = "FUEL_UPDATES_PEND_LONG";
    

    /**
     * Accessor for the actual strings that have been internationalized.
     */
    public Object[][] getContents() {
        return contents;
    }
    
    static private final Object[][] contents = {
    		{ FUEL_PRICE_PEND 	  , "Fuel Prices Pending..."},
	        { INIT_FUEL           , "Initialize Fuel"},
			{ FUEL_PRICE_PEND_LONG, "Fuel Price Update Available. Select \"Download Fuel Prices\" to activate"},
			{ FUEL_UPDATES_PEND	  , "Fuel Updates Pending..."},
			{ FUEL_UPDATES_PEND_LONG , "Fuel Updates Available. Please Initialize Fuel to activate"}
	};
}
