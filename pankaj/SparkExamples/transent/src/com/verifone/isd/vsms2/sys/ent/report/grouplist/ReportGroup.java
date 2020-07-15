/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 26 May, 2009                                     Sudesh Srinivasan
 */
package com.verifone.isd.vsms2.sys.ent.report.grouplist;

import java.util.ArrayList;

/**
 * A ReportGroup entity represents a group of reports listed in grouplist.xml
 * 
 * @author sudesh_s1
 * @version 1.0
 */
public class ReportGroup {

    private String groupName;
    private ArrayList reportNames;

    public ReportGroup() {
        this.reportNames = new ArrayList();
    }

    /**
     * @return the groupName
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * @param groupName the groupName to set
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * @return return the collection of reportNames as an array of Strings
     */
    public String[] getReportNames() {
        return (String[]) reportNames.toArray(new String[0]);
    }

    /**
     * Add the specified report to the group
     * @param reportNames the reportNames to set
     */
    public void addReportName(String reportName) {
        this.reportNames.remove(reportName);
        this.reportNames.add(reportName);
    }

    /**
     * Remove the specified report from the group
     * @param reportNames the reportNames to set
     */
    public void removeReportName(String reportName) {
        this.reportNames.remove(reportName);
    }
    
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof ReportGroup) {
            return this.groupName.equals(((ReportGroup) obj).groupName);
        }
        return false;
    }
   
    /** 
     * Method override since equals() is implemented
     * @return hash code for the object
     */    
    public int hashCode() {
        int hc = 37 * 17;
        return hc + ((this.groupName == null) ? 0 : this.groupName.hashCode());
    }
}
