/*
 * NetDebitConfig.java
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
public abstract class NetDebitConfigBase implements INetDebitConfig, INetEntityVisitable, Serializable
{
    static final long serialVersionUID = 8207468368504144043L;

    private static short MAX_CASHBACK_AMT = 10000;
    
    /** Creates a new instance of NetDebitConfig */
    public NetDebitConfigBase()
    {
    }
    
    protected boolean cashbackEnabled;
    protected short cashbackLimit;
    protected short cashbackFee;
    protected boolean encryptDUKPT;
    protected NetDebitConfigPK ID;
    
    public void setRecordNr(short recordNr) {
        ID = new NetDebitConfigPK(recordNr);
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
    
    public boolean getEncryptDUKPT()
    {
        return this.encryptDUKPT;
    }
    
    public void setEncryptDUKPT(boolean encryptDUKPT)
    {
        this.encryptDUKPT = encryptDUKPT;
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
        this.ID = (NetDebitConfigPK)pk;        
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
            throw new Exception("Invalid NetDebitConfig Entry: " + this.ID);            
        }
        
        if ((this.cashbackLimit < 0) || (this.cashbackLimit > MAX_CASHBACK_AMT)) {
            throw new Exception("Invalid NetDebitConfig Entry cashbackLimit: " + this.cashbackLimit);            
        }
        
        if ((this.cashbackFee < 0) || (this.cashbackFee > MAX_CASHBACK_AMT)) {
            throw new Exception("Invalid NetDebitConfig Entry cashbackFee: " + this.cashbackFee);            
        }
    }

    public void setAttributes(IEntityObject obj) {
        NetDebitConfigBase netDebitConfig = (NetDebitConfigBase)obj;
        
        netDebitConfig.ID = this.ID;
        netDebitConfig.setCashbackEnabled(this.cashbackEnabled);
        netDebitConfig.setCashbackLimit(this.cashbackLimit);
        netDebitConfig.setCashbackFee(this.cashbackFee);
        netDebitConfig.setEncryptDUKPT(this.encryptDUKPT);
    
    }
    
    /* Depricated - use retrieve method in PersistAdmin
    public void reloadConfig(INetDebitConfig debitConfig) {
        NetDebitConfigBase local = (NetDebitConfigBase) debitConfig;
        
        this.cashbackEnabled = local.getCashbackEnabled();
        this.cashbackLimit = local.getCashbackLimit();
        this.cashbackFee = local.getCashbackFee();
        this.encryptDUKPT = local.getEncryptDUKPT();
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
}
