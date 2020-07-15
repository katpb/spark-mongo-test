/*
 * Report.java
 *
 * Created on March 11, 2005, 4:58 PM
 */

package com.verifone.isd.vsms2.sys.ent.report;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.ent.ISystemEntityVisitable;
import com.verifone.isd.vsms2.sys.ent.ISystemEntityVisitor;
import com.verifone.isd.vsms2.sys.ent.securityctrl.SecurityLevel;

/**
 * This is the system entity for processing report manager configuration
 * requests
 * @author  tom_s5
 */
public class Report implements IEntityObject, ISystemEntityVisitable {
	private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.ent.report.Report.class);
        public static final int MAX_PERIOD_TYPE = 4;
        public static final int MIN_PERIODTYPE = 1;
 
        public static final int MIN_CONFIGURABLE_PERIOD_TYPE = 1;
        public static final int MAX_TLOG_PERIOD_TYPE = 2;
    
    private boolean autoPrintReport;
	private boolean forceCashierClose;
	private boolean cashierSpansShifts;
	private boolean forceCashierToPrint;
	private boolean closeWithNoActivity;
	private boolean allowSuspendedTransactions;
        private SecurityLevel recloseSecurity;
	private SecurityLevel forceClosePendTransSecurity;
        private HashMap<Integer, ReportPeriodInfo> periodConfigData;        
	private ReportPK ID;
	/*
	 * Object to configure Auto End of Day settings
	 */
	private AEOD aeod;	
	/*
	 * Object to configure Manager Workstation Settings
	 */
	private MWS mws;
	
	/**
	 * Default no-argument constructor
	 */
	public Report() {
            this.periodConfigData = new HashMap<Integer, ReportPeriodInfo>();
	}
	
	/**
	 * This method 
	 */
	public void accept(ISystemEntityVisitor v) throws Exception {
	}
	
	/**
	 * Getter of the entity object's primary key
	 * @return the ID of the entity object
	 */
	public IEntityPK getPK() {
		if (null == this.ID) {
			this.ID = new ReportPK();
		}
		return this.ID;
	}
	
	/**
	 * Method to validate the primary key of the entity object
	 * @return true if the primary key of the entity object is valid
	 */
	public boolean isPKValid() {
		return this.getPK().isValid();
	}
	
	/**
	 * This method sets the attributes of the new object, which is similar to
	 * deep cloning
	 * @param obj the target object to be written into
	 */
	public void setAttributes(IEntityObject obj) {
		Report rObj = (Report) obj;
		rObj.setPK(this.getPK());
                rObj.allowSuspendedTransactions = this.allowSuspendedTransactions;
                rObj.cashierSpansShifts = this.cashierSpansShifts;
                rObj.closeWithNoActivity = this.closeWithNoActivity;
                rObj.forceCashierClose = this.forceCashierClose;
                rObj.forceCashierToPrint = this.forceCashierToPrint;
                rObj.forceClosePendTransSecurity = this.forceClosePendTransSecurity;
                rObj.recloseSecurity = this.recloseSecurity;
                rObj.periodConfigData.putAll(this.periodConfigData);
                rObj.aeod		= this.aeod;
                rObj.mws		=this.mws;
	}
	
	/**
	 * Set the primary key of the entity object
	 * @param pk primary key for the entity object
	 */
	public void setPK(IEntityPK pk) {
		this.ID = (ReportPK) pk;
	}
	
	/**
	 * This method
	 */
	public void validate() throws Exception {
		
		/*
		 * CR6068.00 - This variable is used to check if at least one period
		 *             preserves raw transactions
		 * TT1
		 */
		boolean foundOne = false;
		
		if (!isPKValid())
			throw new Exception("Invalid report: " + this.ID);
		
		/*
		 * CR6068.00 - loop through the periods and check the value of
		 *             isPreservesRawTxns.  Break after one is found
		 * TT1
		 */		
		for (int i = MIN_CONFIGURABLE_PERIOD_TYPE; i <= MAX_PERIOD_TYPE; i++) {
			
			if (getReportPeriodInfo(i).isPreserveRawTxns()) {
				foundOne = true;
				break;
			}
		}
		
		/*
		 * CR6068.00 - At least one period must preserves raw transactions.
		 *			   Throw an exception if this is not true since this 
		 *			   would be an invalid configuration.
		 * TT1
		 */
		if (!foundOne) {
			throw new Exception("Invalid report settings: only one period can be set not to store T-Log data.");
		}
	}
        
        public void setReportPeriodInfo(ReportPeriodInfo rptData) {
            int periodType = rptData.getPeriodNum();
            if (periodType >= MIN_CONFIGURABLE_PERIOD_TYPE && periodType <= MAX_PERIOD_TYPE) {
                this.periodConfigData.put(periodType, rptData);
            }
        }
        
        public ReportPeriodInfo getReportPeriodInfo(int periodType) {
            return  this.periodConfigData.get(periodType);
        }
        
        public ReportPeriodInfo[] getAllReportPeriodInfo() {
            return this.periodConfigData.values().toArray(new ReportPeriodInfo[0]);
        }

        public int getPeriodNumByType(PeriodType periodType) {
        	int periodNum = 0;
        	for (int i = MIN_CONFIGURABLE_PERIOD_TYPE; i <= MAX_PERIOD_TYPE; i++) {
        		ReportPeriodInfo periodInfo = this.periodConfigData.get(i);
        		if(periodInfo.getPeriodType().equals(periodType)) {
        			periodNum =  periodInfo.getPeriodNum();
        		}
        	}
        	return periodNum;
        }
        
        public PeriodType getPeriodTypeByNum(int periodNum) {
        	PeriodType periodType = null;
        	for (int i = MIN_CONFIGURABLE_PERIOD_TYPE; i <= MAX_PERIOD_TYPE; i++) {
        		ReportPeriodInfo periodInfo = this.periodConfigData.get(i);
        		if(periodInfo.getPeriodNum() == periodNum) {
        			periodType =  periodInfo.getPeriodType();
        		}
        	}
        	return periodType;
        }
        
	/**
	 * This method sets the force cashier close setting
	 * @param forceCashierClose The force cashier close setting.
	 */
	public void setForceCashierClose(boolean forceCashierClose) {
		this.forceCashierClose = forceCashierClose;
	}

	/**
	 * This method returns the force cashier close setting
	 * @return Returns the force cashier close setting
	 */
	public boolean getForceCashierClose() {
		return this.forceCashierClose;
	}

	/**
	 * This method sets cashier spans chifts setting
	 * @param cashierSpansShifts The cashier spans shifts setting.
	 */
	public void setCashierSpansShifts(boolean cashierSpansShifts) {
		this.cashierSpansShifts = cashierSpansShifts; 
	}

	/**
	 * This method returns the cashier spans shifts setting
	 * @return Returns the cashier spans shifts setting
	 */
	public boolean getCashierSpansShifts() {
		return this.cashierSpansShifts;
	}

	/**
	 * This method sets the force cashier to print setting
	 * @param forceCashierToPrint The force cashier to print setting.
	 */
	public void setForceCashierToPrint(boolean forceCashierToPrint) {
		this.forceCashierToPrint = forceCashierToPrint;
	}

	/**
	 * This method returns the force cashier to print setting
	 * @return Returns the force cashier to print setting
	 */
	public boolean getForceCashierToPrint() {
		return this.forceCashierToPrint;
	}

	/**
	 * This method sets the close with no activity setting
	 * @param closeWithNoActivity The close with no activity setting.
	 */
	public void setCloseWithNoActivity(boolean closeWithNoActivity) {
		this.closeWithNoActivity = closeWithNoActivity;
	}

	/**
	 * This method returns the close wiht no activity setting
	 * @return Returns the close with no activity setting
	 */
	public boolean getCloseWithNoActivity() {
		return this.closeWithNoActivity;
	}

	/**
	 * This method sets the reclose security setting
	 * @param recloseSecurity The reclose security setting.
	 */
	public void setRecloseSecurity(SecurityLevel recloseSecurity) {
		this.recloseSecurity = recloseSecurity;
	}

	/**
	 * This method returns the reclose security setting
	 * @return Returns the reclose security setting
	 */
	public SecurityLevel getRecloseSecurity() {
		return this.recloseSecurity;
	}

	/**
	 * This method sets the force close pending transactions security setting
	 * @param forceClosePendTransSecurity The force close pending transactions
	 * security setting.
	 */
	public void setForceClosePendTransSecurity(SecurityLevel forceClosePendTransSecurity) {
		this.forceClosePendTransSecurity = forceClosePendTransSecurity;
	}

	/**
	 * This method returns the force close pending transactions security setting
	 * @return Returns the force close pending transactions security setting
	 */
	public SecurityLevel getForceClosePendTransSecurity() {
		return this.forceClosePendTransSecurity;
	}

	/**
	 * This method sets the allow suspended transactions setting
	 * @param allowSuspendedTransactions The allow suspended transactions
	 * setting.
	 */
	public void setAllowSuspendedTransactions(boolean allowSuspendedTransactions) {
		this.allowSuspendedTransactions = allowSuspendedTransactions;
	}

	/**
	 * This method returns the allow suspended transactions setting
	 * @return Returns the allow suspended transactions setting
	 */
	public boolean getAllowSuspendedTransactions() {
		return this.allowSuspendedTransactions;
	}

	/**
	 * This API returns the AEOD configuration settings
	 * @return the aeod
	 */
	public AEOD getAeod() {
		return aeod;
	}

	/**
	 * This API is used to modify AEOD configuration
	 * @param aeod the aeod to set
	 */
	public void setAeod(AEOD aeod) {
		this.aeod = aeod;
	}
	
	/**
	 * This API returns the Auto Print Settings
	 * @return the autoPrintReport value
	 */
	
	public boolean isAutoPrintReport() {
		return autoPrintReport;
	}

	/**
	 * This API is used to modifies the Auto Print Settings
	 * @param autoPrintReport to set
	 */
	public void setAutoPrintReport(boolean autoPrintReport) {
		this.autoPrintReport = autoPrintReport;
	}

	public MWS getMws() {
		return mws;
	}

	public void setMws(MWS mws) {
		this.mws = mws;
	}
}
