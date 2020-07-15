package com.verifone.isd.vsms2.sys.l10n;

import java.util.ListResourceBundle;
/**
 * Resource Bundle for Managed Update
 * @author T_ShailendraP1
 *
 */
public class ManagedUpdateRes extends ListResourceBundle {
	
	@Override
	public Object[][] getContents() {
		return contents;
	}
	
	//Managed Update.
	public static final String ERRM_7000 = "ERRM_7000";
	public static final String ERRM_7001 = "ERRM_7001";
	public static final String ERRM_7002 = "ERRM_7002";
	public static final String 	MANAGED_UPDATE		= "MANAGED_UPDATE";
	public static final String 	LAST_PENDING_UPDATE		= "LAST_PENDING_UPDATE";
	public static final String 	ACCEPT_UPDATES		= "ACCEPT_UPDATES";
	public static final String 	UPDATE_INITIATED_SUCCESS		= "UPDATE_INITIATED";
	
	public static final String PENDING_UPDATES_MSG = "PENDING_UPDATES_MSG";
	public static final String MANAGED_UPDATE_SUCCESSFUl = "MANAGED_UPDATE_SUCCESSFUl";
	public static final String MANAGED_UPDATE_FAILED = "MANAGED_UPDATE_FAILED";
	
	static private final Object[][] contents = {
		{ERRM_7000, "E7000: Feature Not Enabled"},
		{ERRM_7001, "E7001: Update already in progress"},
		{ERRM_7002, "E7002: Update Failed"},
  		{ MANAGED_UPDATE,			"Managed Update" },
  		{ LAST_PENDING_UPDATE,			"Last Pending Update" },
  		{ ACCEPT_UPDATES,			"\n\n\n\n\nAccept Updates?" },
  		{ UPDATE_INITIATED_SUCCESS,			"Update Initiated Successfully" },
  		{ PENDING_UPDATES_MSG,			"Pending Managed Updates" },
  		{ MANAGED_UPDATE_SUCCESSFUl,			"Managed Update Successful" },
  		{ MANAGED_UPDATE_FAILED,			"Managed Update Failed" }
		};
}
