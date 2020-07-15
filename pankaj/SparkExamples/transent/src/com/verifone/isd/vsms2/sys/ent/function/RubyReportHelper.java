/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verifone.isd.vsms2.sys.ent.function;


/**
 * Loads sub functions for vrubyrept function, that are required in a regular Commander
 * 
 * @author bhanu_a1
 */
class RubyReportHelper implements SubFunctionHelper {
   protected static final String SUBFN_QUERY = "reptname";
   
   RubyReportHelper() {}
   
    public SubFunctionInfo getSubFunctionInfo() {
    	return ReportHelper.getSubFunctionInfo(SUBFN_QUERY, RubyReport.values());
    }
}
