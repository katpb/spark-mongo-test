package com.verifone.isd.vsms2.sys.l10n;

import java.util.ListResourceBundle;

/**
 * Resource Bundle for Manager Workstation
 * @author T_ShailendraP1
 *
 */
public class MWSRes extends ListResourceBundle {

	@Override
	public Object[][] getContents() {
		return contents;
	}

	public static final String MWS_FEATURE_NOT_ENABLED 	= "MWS_FEATURE_NOT_ENABLED";
	public static final String INVALID_MAX_LIMIT 		= "INVALID_MAX_LIMIT";
	public static final String PERIOD_ALREADY_APPROVED	= "PERIOD_ALREADY_APPROVED";
	public static final String NO_MGR_ACCEPTED_PERIOD_AVAILABLE	= "NO_MGR_ACCEPTED_PERIOD_AVAILABLE";
	public static final String CSR_PERIOD_ALREADY_RECONCILED = "CSR_PERIOD_ALREADY_RECONCILED";
	public static final String REPORT_INVALID_MIN_TYPE = "REPORT_INVALID_MIN_TYPE";
	public static final String REPORT_INVALID_DAY_TYPE = "REPORT_INVALID_DAY_TYPE";
	public static final String REPORT_INVALID_ORDER = "REPORT_INVALID_ORDER";
	public static final String REPORT_DUPLICATE_PERIOD_ENABLE = "REPORT_DUPLICATE_PERIOD_ENABLE";
	public static final String REPORT_PERSIST_RAW_TRANX = "REPORT_PERSIST_RAW_TRANX";
	
	static private final Object[][] contents = {
		{ MWS_FEATURE_NOT_ENABLED,			"Manager Workstation Feature Not Enabled."},
		{ INVALID_MAX_LIMIT,          		"Please enter a proper value for 'Max Unaccepted Period Reports'"},
		{ PERIOD_ALREADY_APPROVED,          "Associated Period is Already Approved."},
		{ CSR_PERIOD_ALREADY_RECONCILED,    "Cashier Period Already Reconciled."},
		{ NO_MGR_ACCEPTED_PERIOD_AVAILABLE, "No Manager Accepted Reports Available."},
		{ REPORT_INVALID_MIN_TYPE,    		"Lowest period type should be daypart or day."},
		{ REPORT_INVALID_DAY_TYPE,    		"Peiod 1 or 2 should be period type day"},
		{ REPORT_DUPLICATE_PERIOD_ENABLE,   "You cannot enable roll up DB reports for 2 periods with the same period type"},
		{ REPORT_PERSIST_RAW_TRANX,   		"You can enable Store T-Log Data only for period type daypart or day"},
		{ REPORT_INVALID_ORDER,    			"Period Type should be higher than the previous Period Type."}
		};
}
