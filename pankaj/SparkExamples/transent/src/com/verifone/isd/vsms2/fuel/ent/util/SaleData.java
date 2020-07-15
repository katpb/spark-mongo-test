/*
 * SaleData.java
 *
 * Created on February 26, 2003, 9:45 PM
 */

package com.verifone.isd.vsms2.fuel.ent.util;

import java.io.Serializable;

import java.util.Date;

//import com.verifone.isd.vsms2.fuel.ent.config.DefaultServiceLevel;
//import com.verifone.isd.vsms2.fuel.ent.config.DefaultMOP;
//import com.verifone.isd.vsms2.fuel.ent.config.FuelProduct;

import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import com.verifone.isd.vsms2.sys.util.Volume;
import com.verifone.isd.vsms2.sys.util.Quantity;

/**
 * Aggregates all data related to a Fuel Sale
 * @author  D. Michael Barton
 */
public class SaleData implements Serializable {
    
    static final long VersionUID = -7628657125249970797L;
    
//    private DefaultServiceLevel serviceLevel = new DefaultServiceLevel();
//    private DefaultMOP MOP = new DefaultMOP();
    private short tier = 0;
//    private FuelProduct product = new FuelProduct();
    private short hose = 0;
    private short mode = 0;
    private short tenderingTerminalID = 0;
    private AuthorizingTerminal authorizingTerminal = new AuthorizingTerminal();
    private MoneyAmount currency = new MoneyAmount(0);
    private Volume volume = new Volume(0);
    private long limit = 0;
    private MoneyAmount price = new MoneyAmount(0);
    private long sequenceNumber = 0;
    private Date authTime = new Date();
    private Date beginFuelingTime = new Date();
    private Date endFuelingTime = new Date();
    private Date settleTime = new Date();
    private boolean dueStatus = false;

    /**
     * Creates a new instance of SaleData.
     */
    public SaleData() {
    }

    /**
     * Provides Service Level assigned to this sale.
     * @return A short representing the Service Level.
     */
/*    public short getServiceLevel() {
	return(serviceLevel.getDefaultServiceLevel());
    }
*/
    /**
     * Assigns Service Level to this sale.
     * @param srvcLvl A short representing the Service Level.
     */
/*    public void setServiceLevel(short srvcLvl) {
	serviceLevel.setDefaultServiceLevel(srvcLvl);
    }
*/
    /**
     * Provides the MOP assigned to this sale.
     * @return A short representing the MOP.
     */
/*    public short getMOP() {
	return(MOP.getDefaultMOP());
    }
*/
    /**
     * Assigns the MOP for this sale.
     * @param mop A short representing the MOP.
     */
/*    public void setMOP(short mop) {
	MOP.setDefaultMOP(mop);
    }
*/
    /**
     * Provides the Pricing Tier for this sale.
     * @return A short representing the Tier.
     */
    public short getTier() {
	return(tier);
    }

    /**
     * Assigns the Procing Tier for this sale.
     * @param tier A short representing the Tier.
     */
    public void setTier(short tier) {
	this.tier = tier;
    }

    /**
     * Provides the Fuel Product object assigned to this sale.
     * @return A FuelProduct object.
     */
/*    public FuelProduct getFuelProduct() {
	return(product);
    }
*/
    /**
     * Assigns a Fuel Product Object this sale.
     * @param product A FuelProduct Object.
     */
/*    public void setProduct(FuelProduct product) {
	this.product = product;
    }
*/
    /**
     * Provides the Hose number for this sale.
     * @return A short representing the Hose.
     */
    public short getHose() {
	return(hose);
    }

    /**
     * Assigns the Hose Number for this sale.
     * @param hose A short representing the Hose.
     */
    public void setHose(short hose) {
	this.hose = hose;
    }

    /**
     * Provides the Mode for this sale.
     * @return A short representing the Mode.
     */
    public short getMode() {
	return(mode);
    }

    /**
     * Assigns the Mode for this sale.
     * @param mode A short representing the Mode.
     */
    public void setMode(short mode) {
	this.mode = mode;
    }

    /**
     * Provides the Terminal ID that has claimed this sale for tendering.
     * @return A short representing the Terminal.
     */
    public short getTenderingTerminalID() {
	return(tenderingTerminalID);
    }

    /**
     * Assigns a Terminal ID as the tendering terminal for this sale.
     * @param tenderingTerminalID A short representing the Terminal.
     */
    public void setTenderingTerminalID(short tenderingTerminalID) {
	this.tenderingTerminalID = tenderingTerminalID;
    }

    /**
     * Provides the Terminal ID that orignally authorized this sale.
     * @return A short representing the Terminal.
     */
    public short getAuthorizingTerminal() {
	return(authorizingTerminal.getTerminalID());
    }

    /**
     * Assigns a Terminal ID as the original authority fo this sale.
     * @param terminalID A short representing the Terminal.
     */
    public void setAuthorizingTerminal(short terminalID) {
	authorizingTerminal.setTerminalID(terminalID);
    }

    /**
     * Provides the Transaction Number for this sale.
     * @return An int representing the Transaction Number.
     */
    public int getTransactionNumber() {
	return(authorizingTerminal.getTransactionNumber());
    }

    /**
     * Assigns the Transaction Number for this sale.
     * @param transactionNumber An int representing the Transaction Number.
     */
    public void setTransactionNumber(int transactionNumber) {
	authorizingTerminal.setTransactionNumber(transactionNumber);
    }

    /**
     * Provides the Currency amount for this sale.
     * @return A MoneyAmount object.
     */
    public MoneyAmount getCurrency() {
	return(currency);
    }

    /**
     * Assigns the Currency amount for this sale.
     * @param currency A MoneyAmount object.
     */
    public void setCurrency(MoneyAmount currency) {
	this.currency = currency;
    }

    /**
     * Provides the Volume dispensed for this sale.
     * @return A Volume object.
     */
    public Volume getVolume() {
	return(volume);
    }

    /**
     * Assigns the Volume dispensed for this sale.
     * @param volume A Volume object.
     */
    public void setVolume(Volume volume) {
	this.volume = volume;
    }

    /**
     * Provides the Currenecy Limit for this sale.
     * @return A Long.
     */
    public long getLimit() {
	return(limit);
    }

    /**
     * Assigns the Currenecy Limit for this sale.
     * @param limit A Long.
     */
    public void setLimit(long limit) {
	this.limit = limit;
    }

    /**
     * Provides the Price for this sale.
     * @return A MoneyAmount object.
     */
    public MoneyAmount getPrice() {
	return(price);
    }

    /**
     * Assigns the Price for this sale.
     * @param price A MoneyAmount object.
     */
    public void setPrice(MoneyAmount price) {
	this.price = price;
    }

    /**
     * Provides the Sequence Number for this sale.
     * @return a long representing the Sequence Number.
     */
    public long getSequenceNumber() {
	return(sequenceNumber);
    }

    /**
     * Assigns the Sequence Number for this sale.
     * @param sequenceNumber A long representing the Sequence Number.
     */
    public void setSequenceNumber(long sequenceNumber) {
	this.sequenceNumber = sequenceNumber;
    }
    /**
     * Provides the Due status for this sale.
     * @return a boolean representing the Due status.
     */
    public boolean getDueStatus() {
	return(dueStatus);
    }

    /**
     * Assigns the Due status for this sale.
     * @param dueStatus a boolean representing the Due status.
     */
    public void setDueStatus(boolean dueStatus) {
	this.dueStatus = dueStatus;
    }
}
