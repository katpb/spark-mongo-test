/**
 * 
 */
package com.verifone.isd.vsms2.sys.ent.function;

import java.util.ArrayList;
import java.util.List;

/**
 * Loads sub functions for vrubyrept function, that are required in Commander EF and F variants
 * 
 * @author Raghavendra_R1
 *
 */
class RubyReport_CMDR_F_Helper extends RubyReportHelper {

	/**
	 * 
	 */
	RubyReport_CMDR_F_Helper() {

	}
	
    public SubFunctionInfo getSubFunctionInfo() {
    	List<ReportDetails> reports = new ArrayList<ReportDetails>();
    	reports.addAll(RubyReport.getCoresvcsReports());
    	reports.addAll(RubyReport.getFCCReports());
    	return ReportHelper.getSubFunctionInfo(SUBFN_QUERY, reports.toArray(new ReportDetails[0]));
    }
}
