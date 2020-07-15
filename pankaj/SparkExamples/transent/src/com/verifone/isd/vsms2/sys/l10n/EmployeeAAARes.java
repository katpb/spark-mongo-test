package com.verifone.isd.vsms2.sys.l10n;

import java.util.ListResourceBundle;

public class EmployeeAAARes  extends ListResourceBundle {

	public static final String EX_LOGIN_FAILED				= "EX_LOGIN_FAILED";
	public static final String EX_MWS_FEATURE_NOT_ENABLED 	= "EX_MWS_FEATURE_NOT_ENABLED";
	public static final String EX_NO_CREDENTIAL				= "EX_NO_CREDENTIAL";
	public static final String EX_FUNCTION_NOT_ALLOWED	 	= "EX_FUNCTION_NOT_ALLOWED";

	@Override
	protected Object[][] getContents() {
		return contents;
	}
	static private final Object[][] contents = {
		{ EX_LOGIN_FAILED,				"Invalid Username or Password" },
		{ EX_MWS_FEATURE_NOT_ENABLED,	"Manager Workstation Feature Not Enabled." },
		{ EX_NO_CREDENTIAL,				"No Credential for the Employee. Please login to get the Credential"},
		{ EX_FUNCTION_NOT_ALLOWED,		"Permission denied for the function"},
	};
}