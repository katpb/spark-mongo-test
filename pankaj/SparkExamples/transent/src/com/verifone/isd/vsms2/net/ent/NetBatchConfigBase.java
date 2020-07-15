/*
 * NetBatchConfig.java
 *
 * Created on December 20, 2004, 2:47 PM
 */

package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPersistAdmin;
import com.verifone.isd.vsms2.sys.db.pres.IReferenceDataSystem;
import com.verifone.isd.vsms2.sys.db.pres.ReferenceDataSystemFactory;
import com.verifone.isd.vsms2.sys.ent.report.PeriodType;
import com.verifone.isd.vsms2.sys.ent.report.Report;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author  Aaron_S1
 */
public abstract class NetBatchConfigBase implements INetBatchConfig, INetEntityVisitable, Serializable
{
	private Logger logger = LoggerFactory.getLogger(NetBatchConfigBase.class);
    static final long serialVersionUID =  -6162473968530568579L;
    public static final int DEFAULT_BATCH_CLOSE_PERIOD = 2; 
    
    private static int MAX_BATCH_CLOSE_PERIOD = DEFAULT_BATCH_CLOSE_PERIOD;   /* currently same as default */

    /** Creates a new instance of NetBatchConfig */
    public NetBatchConfigBase()
    {
    }

    protected int batchClosePeriod = DEFAULT_BATCH_CLOSE_PERIOD;
    protected boolean dispClosedueAlarm;
    protected NetBatchConfigPK ID;

    public void setRecordNr(short recordNr) {
        ID = new NetBatchConfigPK(recordNr);
    }

    public int getConfiguredBatchClosePeriod()
    {
        return this.batchClosePeriod;
    }
    
    public int getBatchClosePeriod()
    {
        Report report = new Report();
        try {
			IEntityPersistAdmin pa = ReferenceDataSystemFactory.getInstance().getPersistAdmin(IReferenceDataSystem.REPORTMGR);
			pa.retrieve(report);
			int configuredDayPd = report.getPeriodNumByType(PeriodType.DAY);
			if (this.batchClosePeriod > configuredDayPd) {
				return configuredDayPd;
			}
        } catch (Exception e) {
        	logger.error("Unable to get the report configurations", e);
        }
        return this.batchClosePeriod;
    }

    public void setBatchClosePeriod(int batchClosePeriod)
    {
        this.batchClosePeriod = batchClosePeriod;
    }

    public boolean getDispClosedueAlarm()
    {
        return this.dispClosedueAlarm;
    }

    public void setDispClosedueAlarm(boolean dispClosedueAlarm)
    {
        this.dispClosedueAlarm = dispClosedueAlarm;
    }

    /** Getter of the entity object's primary key
     * @return the ID of the entity object
     */
    public IEntityPK getPK() {
        return this.ID;
    }

    /** Set the primary key of the entity object
     * @param pk primary key for the entity object
     */
    public void setPK(IEntityPK pk) {
        this.ID = (NetBatchConfigPK)pk;
    }

    /** Method to validate the primary key of the entity object
     * @return true if the primary key of the entity object is valid
     */
    public boolean isPKValid() {
        return (this.ID == null) ? false : this.ID.isValid();
    }

    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {
    	/*
    	 * No need to validate PK in commander as batch config is part of NetPosConfig
    	 */
        if ((this.batchClosePeriod <= 0) || (this.batchClosePeriod > MAX_BATCH_CLOSE_PERIOD)) {
            throw new Exception("Invalid NetBatchConfig Entry batchClosePeriod: " +this.batchClosePeriod);
        }
    }

    public void setAttributes(IEntityObject obj) {
        NetBatchConfigBase netBatchConfig = (NetBatchConfigBase)obj;

        netBatchConfig.ID = this.ID;
        netBatchConfig.setBatchClosePeriod(this.batchClosePeriod);
        netBatchConfig.setDispClosedueAlarm(this.dispClosedueAlarm);
    }

    /* Depricated - use retrieve method in PersistAdmin
    public void reloadConfig(INetBatchConfig batchConfig) {
        NetBatchConfigBase local = (NetBatchConfigBase) batchConfig;

        this.batchClosePeriod = local.getBatchClosePeriod();
        this.dispClosedueAlarm = local.getDispClosedueAlarm();
    }
     */

    /**
	 * Setter for property MAX_BATCH_CLOSE_PERIOD. This is the highest period
	 * that a batch close can be set to.
	 * 
	 * @param maxLen
	 *            New value of property MAX_BATCH_CLOSE_PERIOD.
	 */
    public static void setMaxBatchClosePeriod(int maxLen) {
        MAX_BATCH_CLOSE_PERIOD = maxLen;
    }
    
    /**
     * Getter for property MAX_BATCH_CLOSE_PERIOD. This is
     *  the highest period that a batch close can be set to.
     * @return Value of property MAX_BATCH_CLOSE_PERIOD.
     */
    public static int getMaxBatchClosePeriod() {
        return MAX_BATCH_CLOSE_PERIOD;
    }

    /** Implementation method for visitor pattern
     * @param v visitor instance
     * @throws Exception propagates exceptions thrown by the visitor class
     * in its visit() method implementation
     */
    public void accept(NetEntityVisitor v) throws Exception {
        v.visit(this);
    } 
}
