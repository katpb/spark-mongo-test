package com.verifone.isd.vsms2.sys.l10n;

import java.util.ListResourceBundle;

public class RSDRes extends ListResourceBundle {
	
	public static final String VRSD_INIT_SUCCESS   	 		= "VRSD_INIT_SUCCESS";
	public static final String VRSD_INIT_FAILURE 			= "VRSD_INIT_FAILURE";
	public static final String VRSD_FAILURE 				= "VRSD_FAILURE";
	public static final String VRSD_DOWNLOAD_FAILURE 		= "VRSD_DOWNLOAD_FAILURE";
	public static final String VRSD_CONNECTION_ERROR 		= "VRSD_CONNECTION_ERROR";
	public static final String OVERLAY_TITLE 				= "OVERLAY_TITLE";
	public static final String UPDATES_NOT_AVAIL 			= "UPDATES_NOT_AVAIL";
	public static final String UPDATES_CHECK_ON 			= "UPDATES_CHECK_ON"; 
	public static final String UPDATES_AVAIL 				= "UPDATES_AVAIL";
	public static final String CONFIRM_UPDATES_AVAIL 		= "CONFIRM_UPDATES_AVAIL";
	public static final String DOWNLOADING_UPDATES			= "DOWNLOADING_UPDATES";
	public static final String DOWNLOAD_COMPLETED			= "DOWNLOAD_COMPLETED";
	public static final String VRSD_ALREADY_DOWNLOADED 		= "VRSD_ALREADY_DOWNLOADED";
	public static final String CHECKING_FOR_VRSD_UPDATES	= "CHECKING_FOR_VRSD_UPDATES";
	public static final String USER_PROMPT					= "USER_PROMPT";
	public static final String USER_FIRST_PROMPT			= "USER_FIRST_PROMPT";
	public static final String DOWNLOAD_SCHEDULED			= "DOWNLOAD_SCHEDULED";
	public static final String LAST_UPDATE_DATE				= "LAST_UPDATE_DATE";
	public static final String LAST_SCHEDULED_DATE			= "LAST_SCHEDULED_DATE";
	public static final String LAST_UPDATE_CHECK_STATUS		= "LAST_UPDATE_CHECK_STATUS";
	public static final String LAST_UPDATE_STATUS			= "LAST_UPDATE_STATUS";
	public static final String CURRENT_UPDATE_STATUS		= "CURRENT_UPDATE_STATUS";
	public static final String LAST_DOWNLOAD_SCHEDULED		= "LAST_DOWNLOAD_SCHEDULED";
	public static final String FIREWALL_BLOCK			 	= "FIREWALL_BLOCK";
	public static final String COMM_ERROR  					= "COMM_ERROR";
	public static final String STATE		    			= "STATE";
	public static final String STATE_UNAVAILABLE   			= "STATE_UNAVAILABLE";
	public static final String 	YES = "YES";
	public static final String 	No = "NO";
	

	/**
	 * Accessor for the actual strings that have been internationalized.  
	 */
	public Object[][] getContents() {
		return contents;
	}

	static private final Object[][] contents = {
		{ VRSD_INIT_SUCCESS, "Update check initiated"},		
		{ VRSD_INIT_FAILURE, "Error initiating update check"},
		{ VRSD_FAILURE, "Update check failed"},
		{ VRSD_DOWNLOAD_FAILURE, "Download failed"},
		{ OVERLAY_TITLE, "VRSD Update Check"},
		{ UPDATES_NOT_AVAIL, "Updates not available"},
		{ UPDATES_CHECK_ON, "Update-check in-progress"}, 
		{ UPDATES_AVAIL, "Updates available"},
		{ CONFIRM_UPDATES_AVAIL, "Confirming update-check in-progress"},
		{ DOWNLOADING_UPDATES, "Downloading updates..."},
		{ DOWNLOAD_COMPLETED, "Updates downloaded successfully"},
		{ VRSD_ALREADY_DOWNLOADED, "Updates are already downloaded"},
		{ CHECKING_FOR_VRSD_UPDATES, "Initiating VRSD update check..."}, 
		{ USER_PROMPT, "Do you want to check again?"},
		{ USER_FIRST_PROMPT, "Do you want to check for updates?"},
		{ DOWNLOAD_SCHEDULED, "Download is scheduled"},
		{ LAST_UPDATE_DATE, "Last Update Check"},
		{ LAST_SCHEDULED_DATE, "Next Download"},
		{ LAST_UPDATE_CHECK_STATUS, "Status"},
		{ LAST_UPDATE_STATUS, "Last Update Check Status"},
		{ CURRENT_UPDATE_STATUS, "Current Update Check Status"},
		{ LAST_DOWNLOAD_SCHEDULED, "Download scheduled"},
		{ FIREWALL_BLOCK, "Firewall blocking the request"},
		{ COMM_ERROR, "Error communicating with Commander"},
		{ VRSD_CONNECTION_ERROR, "Error communicating with host"},
		{ STATE, "State"},
		{ STATE_UNAVAILABLE, "Unavailable"},
		{ YES , "Yes"},
		{ No , "No"}
	};
}
