/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 26 May, 2009                                     Sudesh Srinivasan
 */
package com.verifone.isd.vsms2.sys.ent.report.grouplist;

import java.util.ArrayList;

/**
 * ReportGroups represents a collection of 'group' elements listed in grouplist.xml
 * along with the master list of period reports.
 * 
 * @author sudesh_s1
 * @version 1.0
 */
public class ReportGroups {

    private ArrayList groups;
    private ArrayList reportMasterList;

    public ReportGroups() {
        this.groups = new ArrayList();
        this.reportMasterList = new ArrayList();
    }

    /**
     * @return return the collection of groups as an array of ReportGroup
     *         objects
     */
    public ReportGroup[] getGroups() {
        return (ReportGroup[]) groups.toArray(new ReportGroup[0]);
    }

    /**
     * Add the specified report group
     * @param reportGroup the group to add
     */
    public void addGroup(ReportGroup reportGroup) {
        this.groups.remove(reportGroup);
        this.groups.add(reportGroup);
    }

    /**
     * Remove the specified report group
     * @param reportGroup the group to remove
     */
    public void removeGroup(ReportGroup reportGroup) {
        this.groups.remove(reportGroup);
    }

    /**
     * @return return the collection of period reports as an array of
     *         PeriodReport objects
     */
    public PeriodReport[] getReportMasterList() {
        return (PeriodReport[]) reportMasterList.toArray(new PeriodReport[0]);
    }

    /**
     * Add the specified period report
     * @param report the report to add
     */
    public void addReportToMasterList(PeriodReport report) {
        this.reportMasterList.remove(report);
        this.reportMasterList.add(report);
    }

    /**
     * Remove the specified report group
     * @param reportGroup the group to remove
     */
    public void removeReportFromMasterList(PeriodReport report) {
        this.reportMasterList.remove(report);
    }
}
