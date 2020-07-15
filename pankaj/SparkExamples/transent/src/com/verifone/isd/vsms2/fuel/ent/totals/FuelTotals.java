package com.verifone.isd.vsms2.fuel.ent.totals;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.util.Volume;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import com.verifone.isd.vsms2.fuel.ent.FuelEntityVisitor;
import com.verifone.isd.vsms2.fuel.ent.IFuelEntityVisitable;

/**
 *  entity class for FuelTotals
 *
 *  @author "mailto:bhanu_n2@verifone.com"
 *  @version 1.0 Copyright(c) 2000 Hewlett-Packard Company, All Rights Reserved
 */
public class FuelTotals implements IEntityObject, IFuelEntityVisitable {
    static final long serialVersionUID = -1784568794340205614L;

    private FuelTotalsPK ID;
    private int fuelPosn;
    private int prodNum;
    private Volume vol;
    private MoneyAmount amt;
    private int prodID;
    private String fpStatus;
    private int conversions;
    
    /** No-args constructor
     */    
    public FuelTotals() {
    }
    
    /** Constructor
     * @param pk primary key for the entity
     */    
    public FuelTotals(FuelTotalsPK pk) {
        this.ID = pk;
    }
   
    /** Getter of the entity object's primary key
     * @return the ID of the entity object
     */
    public IEntityPK getPK() {
        return this.ID;
    }
    
    /**
     * Getter for "fueling position"
     * @return int
     */
    public int getFuelingPosition() {
        return this.fuelPosn;
    }
    
    /**
     * Setter for "fueling position"
     * @param fuelPosn
     */
    public void setFuelingPosition(int fuelPosn) {
        this.fuelPosn = fuelPosn;
    }
    
    /**
     * Getter for "product number"
     * @return int
     */
    public int getProductNr() {
        return this.prodNum;
    }
    
    /**
     * Setter for "product number"
     * @param prodNum
     */
    public void setProductNr(int prodNum) {
        this.prodNum = prodNum;
    }
    
    /**
     * Getter for "product id"
     * @return int
     */
    public int getProductID() {
        return this.prodID;
    }
    
    /**
     * Setter for "product id"
     * @param prodID
     */
    public void setProductID(int prodID) {
        this.prodID = prodID;
    }
    
    /**
     * Getter for "fueling position status"
     * @return String
     */
    public String getFuelingPositionStatus() {
        return this.fpStatus;
    }
    
    /**
     * Setter for "fueling position status"
     * @param fpStatus
     */
    public void setFuelingPositionStatus(String fpStatus) {
        this.fpStatus = fpStatus;
    }
    
    /**
     * Getter for "Volume"
     * @return Volume
     */
    public Volume getFuelVolume() {
        return this.vol;
    }
    
    /**
     * Setter for "Volume"
     * @param vol
     */
    public void setFuelVolume(Volume vol) {
        this.vol = vol;
    }
    
    /**
     * Getter for "Fuel Amount"
     * @return MoneyAmount
     */
    public MoneyAmount getFuelMoneyAmount() {
        return this.amt;
    }
    
    /**
     * Setter for "Fuel Amount"
     * @param amt
     */
    public void setFuelMoneyAmount(MoneyAmount amt) {
        this.amt = amt;
    }
    
    /**
     * Getter for "Number Conversions"
     * @return int
     */
    public int getNumConversions() {
        return this.conversions;
    }
    
    /**
     * Setter for "Number Conversions"
     * @param conversions
     */
    public void setNumConversions(int conversions) {
        this.conversions = conversions;
    }
    
    /**
     * Setter for All Attributes
     * @param obj
     */
    public void setAttributes(IEntityObject obj) {
        FuelTotals fObj = (FuelTotals) obj;
        fObj.setPK(this.getPK());
        fObj.setFuelingPosition(this.getFuelingPosition());
        fObj.setProductNr(this.getProductNr());
        fObj.setProductID(this.getProductID());
        fObj.setFuelingPositionStatus(this.getFuelingPositionStatus());
        fObj.setFuelVolume(this.getFuelVolume());
        fObj.setFuelMoneyAmount(this.getFuelMoneyAmount());
        fObj.setNumConversions(this.getNumConversions());
    }
    
    /** Method to validate the primary key of the entity object
     * @return true if the primary key of the entity object is valid
     */
    public boolean isPKValid() {
        return (this.ID == null) ? false : this.ID.isValid();    
    }

    
    /** Set the primary key of the entity object
     * @param pk primary key for the entity object
     */
    public void setPK(IEntityPK pk) {
        this.ID = (FuelTotalsPK)pk;        
    }
    
    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {
        if (!isPKValid()) {
            throw new Exception("Invalid FuelTotals: " +this.ID);            
        }
    }
    
    /**
     * Accept used by the visitor pattern.
     */
    public void accept(FuelEntityVisitor v) throws Exception {
        v.visit(this);
    }
}

