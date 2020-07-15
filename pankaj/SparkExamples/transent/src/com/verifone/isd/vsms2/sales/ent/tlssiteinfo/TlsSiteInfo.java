package com.verifone.isd.vsms2.sales.ent.tlssiteinfo;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;

/**
 *  entity class for TlsSiteInfo
 *
 *  @author "mailto:mike_reese@verifone.com"
 *  @version 1.0 Copyright(c) 2003 VeriFone, Inc., All Rights Reserved
 */
public class TlsSiteInfo implements IEntityObject, ISalesEntityVisitable {
    
    /**
     * Maximum TLS variance
     */    
    public static final int MAX_VARIANCE = 999;
    /**
     * Gallons
     */    
    public static final String UOM_G = "G";
    /**
     * Liters
     */    
    public static final String UOM_L = "L";

    private TlsSiteInfoPK ID;
    private String unitOfMeasure;
    private int tankVariance;
    private boolean isLowLimitAlarm;
    
    /**
     * No-args constructor
     */    
    public TlsSiteInfo() {
        this.unitOfMeasure = UOM_G;
    }

    /**
     * Getter for unit of measure
     * @return Unit of measure
     */    
    public String getUnitOfMeasure() {
        return this.unitOfMeasure;
    }
    
    /**
     * Setter for unit of measure
     * @param setting Unit of measure
     */    
    public void setUnitOfMeasure(String setting) {
        this.unitOfMeasure = setting;
    }
    
    /**
     * Getter for tank variance
     * @return tank variance
     */    
    public int getTankVariance() {
        return this.tankVariance;
    }
    
    /**
     * Setter for tank variance
     * @param setting tank variance
     */    
    public void setTankVariance(int setting) {
        this.tankVariance = setting;
    }
    
    /**
     * Getter for lowLimitAlarm property
     * @return If true, low limit alarm is enabled.
     */    
    public boolean isLowLimitAlarm() {
        return this.isLowLimitAlarm;
    }
    
    /**
     * Setter for lowLimitAlarm property
     * @param isTrue If true, low limit alarm is enabled.
     */    
    public void setLowLimitAlarm(boolean isTrue) {
        this.isLowLimitAlarm = isTrue;
    }
    
    /** Method to clone the current entity into another
     * @param obj object to be copied to
     */    
    public void setAttributes(IEntityObject obj) {
        TlsSiteInfo tObj = (TlsSiteInfo) obj;
        tObj.setUnitOfMeasure(this.getUnitOfMeasure());
        tObj.setTankVariance(this.getTankVariance());
        tObj.setLowLimitAlarm(this.isLowLimitAlarm());
    }

    /**
     * Concrete method to validate the primary key of the entity object
     * @return true if ID is valid
     */
    public boolean isIDValid() {
        return true;
    }
    
    /** Validator for the entity attributes
     * @throws Exception if validation fails
     */    
    public void validate() throws Exception {
        if (!unitOfMeasure.equals(UOM_G) && !unitOfMeasure.equals(UOM_L)) {
            throw new Exception("Invalid UOM: " + unitOfMeasure + " for TLS");
        }
        if ((tankVariance < 0) || (tankVariance > MAX_VARIANCE)) {
            throw new Exception("Invalid Tank Variance: " + tankVariance + " for TLS");
        }
    }
    
    /** Method to validate the primary key of the entity object
     * @return true if the primary key of the entity object is valid
     */
    public boolean isPKValid() {
        return true;
    }
    
    /** Getter of the entity object's primary key
     * @return the ID of the entity object
     */
    public IEntityPK getPK() {
		if (this.ID == null) {
			this.ID = new TlsSiteInfoPK();
		}
        return this.ID;
    }
    
    /** Set the primary key of the entity object
     * @param pk primary key for the entity object
     */
    public void setPK(IEntityPK pk) {
		if (pk instanceof TlsSiteInfoPK) {
			this.ID = (TlsSiteInfoPK)pk;
		}
    }
    
    /** Implementation method for visitable in the visitor pattern
     * @param v visitor
     * @throws Exception on exception in visitor's visit method
     */    
    public void accept(SalesEntityVisitor v) throws Exception {
        v.visit(this);
    }       
}