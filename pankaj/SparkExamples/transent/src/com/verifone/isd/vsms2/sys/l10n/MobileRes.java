package com.verifone.isd.vsms2.sys.l10n;

import java.util.ListResourceBundle;

public class MobileRes extends ListResourceBundle {

	public static final String MOBILE;
	public static final String NO_MOBILE_TXN_TYPE_DEFINED; 
	public static final String VALIDATION_ERROR;
	public static final String VITUAL_POS_NOT_INITIALIZED_WITH_TERMINAL_ID; 
	public static final String ERROR_WHILE_PROCESSING_REQUEST; 
	public static final String PLEASE_ENTER_CODE; 
	public static final String CHOOSE_A_PROGRAM;  
	public static final String ABORT_DISPLAY_MESSAGE;  
	public static final String NO_PROGRAM_RUNNING; 
	public static final String NO_PROGRAM_CONFIGURED;
	public static final String HOST_DECLINED_CODE; 
	public static final String NO_TOKEN_AVAILABLE;
	public static final String AUTHORIZATION_FAILED;
	public static final String MOBILE_YOU_SAVED;
	public static final String SCAN_QR_CODE;
	public static final String PLEASE_WAIT;
	public static final String PLEASE_ENTER_TOKEN_ON_PHONE;
	public static final String APPROVED;
	public static final String AUTHENTICATION_FAILED;
	public static final String WAITING_FOR_AUTH;
	public static final String PREAUTH_TIMED_OUT;
	
	static {		
		MOBILE = "MOBILE";
		NO_MOBILE_TXN_TYPE_DEFINED = "NO_MOBILE_TXN_TYPE_DEFINED";
		VALIDATION_ERROR = "VALIDATION_ERROR";
		VITUAL_POS_NOT_INITIALIZED_WITH_TERMINAL_ID = "VITUAL_POS_NOT_INITIALIZED_WITH_TERMINAL_ID";
		ERROR_WHILE_PROCESSING_REQUEST = "ERROR_WHILE_PROCESSING_REQUEST";
		PLEASE_ENTER_CODE = "PLEASE_ENTER_CODE";
		CHOOSE_A_PROGRAM = "CHOOSE_A_PROGRAM";
		ABORT_DISPLAY_MESSAGE = "ABORT_DISPLAY_MESSAGE";
		NO_PROGRAM_RUNNING = "NO_PROGRAM_RUNNING";
		NO_PROGRAM_CONFIGURED = "NO_PROGRAM_CONFIGURED";
		HOST_DECLINED_CODE = "HOST_DECLINED_CODE";
		NO_TOKEN_AVAILABLE = "NO_TOKEN_AVAILABLE";
		AUTHORIZATION_FAILED = "AUTHORIZATION_FAILED";
		MOBILE_YOU_SAVED = "MOBILE_YOU_SAVED";
		SCAN_QR_CODE = "SCAN_QR_CODE";
		PLEASE_WAIT = "PLEASE_WAIT";
		PLEASE_ENTER_TOKEN_ON_PHONE = "PLEASE_ENTER_TOKEN_ON_PHONE";
		APPROVED = "APPROVED";
		AUTHENTICATION_FAILED = "AUTHENTICATION_FAILED";
		WAITING_FOR_AUTH = "WAITING_FOR_AUTH";
		PREAUTH_TIMED_OUT = "PREAUTH_TIMED_OUT";
	}
	
	@Override
	protected Object[][] getContents() {
		return contents;
	}

	static private final Object[][] contents =  { 
			{ MOBILE, "MOBILE" },
			{ NO_MOBILE_TXN_TYPE_DEFINED, "MOBILE TRANSACTION TYPE IS NOT DEFINED." },
			{ VALIDATION_ERROR, "REQUEST HAS SOME VALIDATION ERROR" },
			{ VITUAL_POS_NOT_INITIALIZED_WITH_TERMINAL_ID, "VIRTUAL POS NOT INITIALIZED WITH A VALID TERMINAL ID" },
			{ ERROR_WHILE_PROCESSING_REQUEST, "ERROR WHILE PROCESSING REQUEST"},
			{ PLEASE_ENTER_CODE, "ENTER CODE"},
			{ CHOOSE_A_PROGRAM, "CHOOSE A PROGRAM"},
			{ ABORT_DISPLAY_MESSAGE, "Transaction Cancelled"},
			{ NO_PROGRAM_RUNNING, "No Programs Running"},
			{ NO_PROGRAM_CONFIGURED, "No Program Configured"},
			{ HOST_DECLINED_CODE, "Program declined Code"},
			{ NO_TOKEN_AVAILABLE, "No Token available from Program"},
			{ AUTHORIZATION_FAILED, "Authorization Failed"},
			{ MOBILE_YOU_SAVED, "YOU SAVED "},
			{ SCAN_QR_CODE, "Please scan QR code"},
			{ PLEASE_WAIT, "Please wait ..."},
			{ PLEASE_ENTER_TOKEN_ON_PHONE, "Enter Token on Phone"},
			{ APPROVED, "APPROVED" },
			{ AUTHENTICATION_FAILED, "AUTHENTICATION FAILED"},
			{ WAITING_FOR_AUTH, "Authorizing ..." },
			{ PREAUTH_TIMED_OUT, "Preauthorization Timed Out!"}
			
	};
	
	
	public MobileRes() {
	    

	}
	
}
