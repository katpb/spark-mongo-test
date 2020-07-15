package com.verifone.isd.vsms2.sys.l10n;

import java.util.ListResourceBundle;

/**
 * Resource Bundle for Commander Console
 * @author T_Aswathik1
 *
 */
public class CommanderConsoleRes extends ListResourceBundle {

	@Override
	public Object[][] getContents() {
		return contents;
	}

	public static final String INVALID_URL 	= "INVALID_URL";
	public static final String MISSING_URL 		= "MISSING_URL";
	public static final String CONNECTION_FAILED	= "CONNECTION_FAILED";	
	public static final String INVALID_VALUE	= "INVALID_VALUE";
	
	static private final Object[][] contents = {
		{ INVALID_URL,			"Invalid URL.Please enter again."},
		{ MISSING_URL,          		"Missing Parameter - URL"},
		{ CONNECTION_FAILED,          "Commander console URL connection failed."},
		{INVALID_VALUE,            "Invalid value for the element "}
		};
}