/*
 * EBT.java
 *
 * Created on Dec 3, 2004, 4:30 PM
 */

package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

import java.io.Serializable;

/**
 *
 *  @author  Linda_T1
 *  ADS Network Version
 */
public abstract class NetEBTConfigBase implements INetEBTConfig, INetEntityVisitable, Serializable
{
    static final long serialVersionUID = -8836805845679565676L;
    
    private static short MAX_CASHBACK_AMT = 10000;
    
    /** Creates a new instance of NetEBTConfig */
    public NetEBTConfigBase()
    {
        //this.cashbackEnabled=false;
        //this.ebtAllowed = false;
    }
    
    protected boolean cashbackEnabled;
    protected short cashbackLimit;
    protected short cashbackFee;
    protected NetEBTConfigPK ID;
    
    /** Holds value of property ebtAllowed. */
    private boolean ebtAllowed;
    
    public void setRecordNr(short recordNr) {
        ID = new NetEBTConfigPK(recordNr);
    }
    
    public boolean getCashbackEnabled()
    {
        return this.cashbackEnabled;
    }
    
    public void setCashbackEnabled(boolean cashbackEnabled)
    {
        this.cashbackEnabled = cashbackEnabled;
    }
    
    public short getCashbackLimit()
    {
        return this.cashbackLimit;
    }
    
    public void setCashbackLimit(short cashbackLimit)
    {
        this.cashbackLimit = cashbackLimit;
    }
    
    public short getCashbackFee()
    {
        return this.cashbackFee;
    }
    
    public void setCashbackFee(short cashbackFee)
    {
        this.cashbackFee = cashbackFee;
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
        this.ID = (NetEBTConfigPK)pk;        
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
        if (!isPKValid()) {
            throw new Exception("Invalid NetEBTConfig Entry: " + this.ID);            
        }
        
        if ((this.cashbackLimit < 0) || (this.cashbackLimit > MAX_CASHBACK_AMT)) {
            throw new Exception("Invalid NetEBTConfig Entry cashbackLimit: " + this.cashbackLimit);            
        }
        
        if ((this.cashbackFee < 0) || (this.cashbackFee > MAX_CASHBACK_AMT)) {
            throw new Exception("Invalid NetEBTConfig Entry cashbackFee: " + this.cashbackFee);            
        }
    }

    public void setAttributes(IEntityObject obj) {
        NetEBTConfigBase netEBTConfig = (NetEBTConfigBase)obj;
        
        netEBTConfig.ID = this.ID;
        netEBTConfig.setCashbackEnabled(this.cashbackEnabled);
        netEBTConfig.setCashbackLimit(this.cashbackLimit);
        netEBTConfig.setCashbackFee(this.cashbackFee);
        netEBTConfig.setEbtAllowed(this.ebtAllowed);
    
    }
    
    /* Depricated - use retrieve method in PersistAdmin
    public void reloadConfig(INetEBTConfig ebtConfig) {
        NetEBTConfigBase local = (NetEBTConfigBase) ebtConfig;
        
        this.cashbackEnabled = local.getCashbackEnabled();
        this.cashbackLimit = local.getCashbackLimit();
        this.cashbackFee = local.getCashbackFee();
        this.ebtAllowed = local.isEbtAllowed();
    }
     */

    /**
     * Setter for property MAX_CASHBACK_AMT.
     * @param maxValue New value of property MAX_CASHBACK_AMT.
     */
    public static void setMaxCashbackAmt(short maxValue) {
        MAX_CASHBACK_AMT = maxValue;
    }
    
    /**
     * Getter for property MAX_CASHBACK_AMT.
     * @return Value of property MAX_CASHBACK_AMT.
     */
    public static short getMaxCashbackAmt() {
        return MAX_CASHBACK_AMT;
    }
    
    /** Implementation method for visitor pattern
     * @param v visitor instance
     * @throws Exception propagates exceptions thrown by the visitor class
     * in its visit() method implementation
     */
    public void accept(NetEntityVisitor v) throws Exception {
        v.visit(this);
    }      
    
    /** Getter for property ebtAllowed.
     * @return Value of property ebtAllowed.
     *
     */
    public boolean isEbtAllowed() {
        return this.ebtAllowed;
    }
    
    /** Setter for property ebtAllowed.
     * @param ebtAllowed New value of property ebtAllowed.
     *
     */
    public void setEbtAllowed(boolean ebtAllowed) {
        this.ebtAllowed = ebtAllowed;
    }
    
}
