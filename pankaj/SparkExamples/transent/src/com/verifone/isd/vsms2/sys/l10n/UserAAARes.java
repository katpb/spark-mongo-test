package com.verifone.isd.vsms2.sys.l10n;

import java.util.ListResourceBundle;

public class UserAAARes extends ListResourceBundle {

	public static final String EX_ACCOUNT_LOCKED="EX_ACCOUNT_LOCKED";
	public static final String EX_LOGIN_FAILED="EX_LOGIN_FAILED";
	public static final String EX_NO_CREDENTIAL="EX_NO_CREDENTIAL";
	public static final String EX_FUNCTION_NOT_ALLOWED ="EX_FUNCTION_NOT_ALLOWED";
	public static final String INVALID_POS_NOT_ALLOWED ="INVALID_POS_NOT_ALLOWED";
	public static final String UNABLE_TOQUERY_FEATUREREGISTRY ="UNABLE_TOQUERY_FEATUREREGISTRY";
	public static final String EX_NEEDS_SECURE_CONNECTION ="EX_NEEDS_SECURE_CONNECTION";
	public static final String NO_AAA_SERVICE_REGISTERED = "NO_AAA_SERVICE_REGISTERED";
	public static final String AAA_SERVICE_UNAVAILABLE = "AAA_SERVICE_UNAVAILABLE";
	
	// cr0913.01 added Exception messages during validating the password syntax.
	public static final String EX_PWD_MIN_LEN = "EX_PWD_MIN_LEN";
	public static final String EX_PWD_MAX_LEN = "EX_PWD_MAX_LEN";
	public static final String EX_PWD_CONTAIN_LETTER_DIGIT = "EX_PWD_CONTAIN_LETTER_DIGIT";
	public static final String EX_RECENT_PWD_USED = "EX_RECENT_PWD_USED";
		
	public static final String OTP_REQUIRED = "OTP_REQUIRED";
	public static final String IP_NOT_IN_VERIFONE_ZONE = "IP_NOT_IN_VERIFONE_ZONE";
	public static final String DEVICE_DISABLED = "DEVICE_DISABLED";
	public static final String DEVICE_NOT_REGISTERED = "DEVICE_NOT_REGISTERED";

	@Override
	protected Object[][] getContents() {
		return contents;
	}
	static private final Object[][] contents = {
		{EX_ACCOUNT_LOCKED,"Maximum failed attempts reached. Your Account has been locked"},
		{EX_LOGIN_FAILED,"Invalid Credentials"},
		{EX_NO_CREDENTIAL,"No Credential for the User. Please login to get the Credential"},
		{EX_FUNCTION_NOT_ALLOWED,"Permission denied for the function"},
		{INVALID_POS_NOT_ALLOWED,"Invalid register detected - Credentials cannot be validated"},
		{UNABLE_TOQUERY_FEATUREREGISTRY,"Unable to fetch the count of POS allowed from feature registry.Credentials cannot be validated."},
		{EX_NEEDS_SECURE_CONNECTION, "Secure connection required for the function."},
		{NO_AAA_SERVICE_REGISTERED, "No AAA service registered to handle this request"},
		{AAA_SERVICE_UNAVAILABLE, "AAA service unavailable"},
		
		// Cr0913.01, added the messages.
		{EX_PWD_MIN_LEN, "Password must be at least {0} characters."},
		{EX_PWD_MAX_LEN, "Password must be no more than {0} characters."},
		{EX_PWD_CONTAIN_LETTER_DIGIT, "Password must contain both letters and digits."},
		{EX_RECENT_PWD_USED, "Re-use of recent password not allowed."},

		{ OTP_REQUIRED, "One Time Password required" },
		{IP_NOT_IN_VERIFONE_ZONE, "IP Address not in Verifone zone"},
		
		{DEVICE_DISABLED, "This device is disabled" },
		{DEVICE_NOT_REGISTERED, "This device is not registered"}
		
	};
}
