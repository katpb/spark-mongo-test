/*
 * ReportPeriodInfo.java
 *
 * Created on September 7, 2005, 12:08 PM
 */

package com.verifone.isd.vsms2.sys.ent.report;

import java.io.Serializable;

import com.verifone.isd.vsms2.sys.ent.securityctrl.SecurityLevel;

/**
 * Entity representing period type specific configuration
 * @author  bhanu_n2
 */
public class ReportPeriodInfo implements  Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8264164929865400376L;

	/**
     * Holds value of property name.
     */
    private String name;
    
    /**
     * Holds value of property periodNum.
     */
    private int periodNum;
    
    /**
     * Holds value of property periodType.
     */
    private PeriodType periodType;
    
    /**
     * Holds value of property delayBetweenCloses.
     */
    private PeriodDuration delayBetweenCloses;
    
    /**
     * Holds value of property minimumSecurityToClose.
     */
    private SecurityLevel minimumSecurityToClose;
    
    /**
     * Holds value of property preserveRawTxns.
     */
    private boolean preserveRawTxns;
    
    /**
     * Holds value of property preserveRawTxns.
     */
    private String rawTxnsPath = null;
    
    /**
     * Holds value of property processDBReports.
     */
    private boolean processDBReports;
    
    /** Creates a new instance of ReportPeriodInfo 
     * @param periodNum period type represented by the object
     */
    public ReportPeriodInfo(int periodNum) {
        this.periodNum = periodNum;
    }
    
    /**
     * Getter for property name.
     * @return Value of property name.
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Setter for property name.
     * @param name New value of property name.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Getter for property type.
     * @return Value of property type.
     */
    public int getPeriodNum() {
        return this.periodNum;
    }
    
    /**
     * Setter for property type.
     * @param periodNum New value of property type.
     */
    public void setPeriodNum(int periodNum) {
        this.periodNum = periodNum;
    }
    
    /**
     * Getter for property type.
     * @return Value of property type.
     */
    public PeriodType getPeriodType() {
        return this.periodType;
    }
    
    /**
     * Setter for property type.
     * @param periodType New value of property type.
     */
    public void setPeriodType(PeriodType periodType) {
        this.periodType = periodType;
    }
    
    /**
     * Getter for property delayBetweenCloses.
     * @return Value of property delayBetweenCloses.
     */
    public PeriodDuration getDelayBetweenCloses() {
        return this.delayBetweenCloses;
    }
    
    /**
     * Setter for property delayBetweenCloses.
     * @param delayBetweenCloses New value of property delayBetweenCloses.
     */
    public void setDelayBetweenCloses(PeriodDuration delayBetweenCloses) {
        this.delayBetweenCloses = delayBetweenCloses;
    }
    
    /**
     * Getter for property minimumSecurityToClose.
     * @return Value of property minimumSecurityToClose.
     */
    public SecurityLevel getMinimumSecurityToClose() {
        return this.minimumSecurityToClose;
    }
    
    /**
     * Setter for property minimumSecurityToClose.
     * @param minimumSecurityToClose New value of property minimumSecurityToClose.
     */
    public void setMinimumSecurityToClose(SecurityLevel minimumSecurityToClose) {
        this.minimumSecurityToClose = minimumSecurityToClose;
    }
    
    /**
     * Getter for property preserveRawTxns.
     * @return Value of property preserveRawTxns.
     */
    public boolean isPreserveRawTxns() {
        if (this.periodNum <= Report.MAX_TLOG_PERIOD_TYPE) {        
            return this.preserveRawTxns;
        }
        else {
            return false;
        }
            
    }
    
    /**
     * Setter for property preserveRawTxns.
     * @param preserveRawTxns New value of property preserveRawTxns.
     */
    public void setPreserveRawTxns(boolean preserveRawTxns) {
        if (this.periodNum <= Report.MAX_TLOG_PERIOD_TYPE) {
            this.preserveRawTxns = preserveRawTxns;
        }
    }
    
    /**
     * Getter for property preserveRawTxns.
     * @return Value of property preserveRawTxns.
     */
    public String getRawTxnsPath() {
    	return rawTxnsPath;
            
    }
    
    /**
     * Setter for property preserveRawTxns.
     * @param preserveRawTxns New value of property preserveRawTxns.
     */
    public void setRawTxnsPath(String rawTxnsPath) {
    	if (this.periodNum <= Report.MAX_TLOG_PERIOD_TYPE) {
    		this.rawTxnsPath = rawTxnsPath;
    	}
    }
    
    /**
     * Getter for property processDBReports.
     * @return Value of property processDBReports.
     */
    public boolean isProcessDBReports() {
        //Do not allow period 1 close to be disabled
        if (this.periodNum == Report.MIN_CONFIGURABLE_PERIOD_TYPE) {
            return true;
        }
        else {
            return this.processDBReports;
        }
    }
    
    /**
     * Setter for property processDBReports.
     * @param processDBReports New value of property processDBReports.
     */
    public void setProcessDBReports(boolean processDBReports) {
        if (this.periodNum != Report.MIN_CONFIGURABLE_PERIOD_TYPE) {
            this.processDBReports = processDBReports;
        }
    }
    
}
