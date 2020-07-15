/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 26 May, 2009                                     Sudesh Srinivasan
 */
package com.verifone.isd.vsms2.sys.ent.report.reportlist;


/**
 * A ReportInfo entity represents each 'report' instance listed in
 * reportlist.xml
 * 
 * @author sudesh_s1
 * @version 1.0
 */
public class ReportInfo {

    private boolean forDisplay;
    private String reportName;
    private String reportCmd;
    private String reportPeriod;
    private boolean reportPeriodRange;
    private String reportStylesheet;
    private String reportCookingStep;

    private String reportParamName;
    private String reportParamValue;

    private String userParamName;
    private String userParamUILabel;
    private String userParamUIListSource;
    private String userParamUIListValue;

    private boolean reportGzip;
    private String reportGroup;

    public ReportInfo(boolean display) {
        this.forDisplay = display;
    }

    /**
     * @return the forDisplay
     */
    public boolean isForDisplay() {
        return forDisplay;
    }

    /**
     * @param forDisplay the forDisplay to set
     */
    public void setForDisplay(boolean forDisplay) {
        this.forDisplay = forDisplay;
    }

    /**
     * @return the reportName
     */
    public String getReportName() {
        return this.reportName;
    }

    /**
     * @param reportName the reportName to set
     */
    public void setReportName(String reportName) {
	this.reportName = reportName;
    }

    /**
     * @return the reportCmd
     */
    public String getReportCmd() {
        return reportCmd;
    }

    /**
     * @param reportCmd the reportCmd to set
     */
    public void setReportCmd(String reportCmd) {
        this.reportCmd = reportCmd;
    }

    /**
     * @return the reportPeriod
     */
    public String getReportPeriod() {
        return reportPeriod;
    }

    /**
     * @param reportPeriod the reportPeriod to set
     */
    public void setReportPeriod(String reportPeriod) {
        this.reportPeriod = reportPeriod;
    }

    /**
     * @return the reportStylesheet
     */
    public String getReportStylesheet() {
        return reportStylesheet;
    }

    /**
     * @param reportStylesheet the reportStylesheet to set
     */
    public void setReportStylesheet(String reportStylesheet) {
        this.reportStylesheet = reportStylesheet;
    }

    /**
     * @return the reportCookingStep
     */
    public String getReportCookingStep() {
        return reportCookingStep;
    }

    /**
     * @param reportCookingStep the reportCookingStep to set
     */
    public void setReportCookingStep(String reportCookingStep) {
        this.reportCookingStep = reportCookingStep;
    }

    /**
     * @return the reportParamName
     */
    public String getReportParamName() {
        return reportParamName;
    }

    /**
     * @param reportParamName the reportParamName to set
     */
    public void setReportParamName(String reportParamName) {
        this.reportParamName = reportParamName;
    }

    /**
     * @return the reportParamValue
     */
    public String getReportParamValue() {
        return reportParamValue;
    }

    /**
     * @param reportParamValue the reportParamValue to set
     */
    public void setReportParamValue(String reportParamValue) {
        this.reportParamValue = reportParamValue;
    }

    /**
     * @return the userParamName
     */
    public String getUserParamName() {
        return userParamName;
    }

    /**
     * @param userParamName the userParamName to set
     */
    public void setUserParamName(String userParamName) {
        this.userParamName = userParamName;
    }

    /**
     * @return the userParamUILabel
     */
    public String getUserParamUILabel() {
        return userParamUILabel;
    }

    /**
     * @param userParamUILabel the userParamUILabel to set
     */
    public void setUserParamUILabel(String userParamUILabel) {
        this.userParamUILabel = userParamUILabel;
    }

    /**
     * @return the userParamUIListSource
     */
    public String getUserParamUIListSource() {
        return userParamUIListSource;
    }

    /**
     * @param userParamUIListSource the userParamUIListSource to set
     */
    public void setUserParamUIListSource(String userParamUIListSource) {
        this.userParamUIListSource = userParamUIListSource;
    }

    /**
     * @return the userParamUIListValue
     */
    public String getUserParamUIListValue() {
        return userParamUIListValue;
    }

    /**
     * @param userParamUIListValue the userParamUIListValue to set
     */
    public void setUserParamUIListValue(String userParamUIListValue) {
        this.userParamUIListValue = userParamUIListValue;
    }

    /**
     * @return the reportGzip
     */
    public boolean isReportGzip() {
        return reportGzip;
    }

    /**
     * @param reportGzip the reportGzip to set
     */
    public void setReportGzip(boolean reportGzip) {
        this.reportGzip = reportGzip;
    }

    /**
     * @return the reportGroup
     */
    public String getReportGroup() {
        return reportGroup;
    }

    /**
     * @param reportGroup the reportGroup to set
     */
    public void setReportGroup(String reportGroup) {
        this.reportGroup = reportGroup;
    }

    /**
     * @return the reportPeriodRange
     */
    public boolean isReportPeriodRange() {
        return reportPeriodRange;
    }

    /**
     * @param reportPeriodRange the reportPeriodRange to set
     */
    public void setReportPeriodRange(boolean reportPeriodRange) {
        this.reportPeriodRange = reportPeriodRange;
    }
    
    /** Compares another primary key for equality
     * @param obj primary key to be compared for equality
     * @return true if both objects are equal
     */
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof ReportInfo) {
            ReportInfo aObj = (ReportInfo)obj;
            return (this.reportName.equals(aObj.reportName));
        }
        return false;
    }    
    
    /** 
     * Method override since equals() is implemented
     * @return hash code for the object
     */    
    public int hashCode() {
        int hc = 37 * 17;
        return hc + ((this.reportName == null) ? 0 : this.reportName.hashCode());
    }
}
