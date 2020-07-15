/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 26 May, 2009                                     Sudesh Srinivasan
 */
package com.verifone.isd.vsms2.sys.ent.report.reportlist;

import java.util.ArrayList;

/**
 * ReportInfoColl represents a collection of 'report' elements listed in
 * reportlist.xml
 * 
 * @author sudesh_s1
 * @version 1.0
 */
public class ReportInfoColl {

    private ArrayList reports;

    public ReportInfoColl() {
        this.reports = new ArrayList();
    }

    /**
     * @return return the collection of reports as an array of ReportInfo
     *         objects
     */
    public ReportInfo[] getReports() {
        return (ReportInfo[]) reports.toArray(new ReportInfo[0]);
    }

    /**
     * Add the specified report
     * @param report the report to add
     */
    public void addReport(ReportInfo report) {
        this.reports.remove(report);
        this.reports.add(report);
    }

    /**
     * Remove the specified report
     * @param report the report to remove
     */
    public void removeReport(ReportInfo report) {
        this.reports.remove(report);
    }

}
