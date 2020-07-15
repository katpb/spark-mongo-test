/*
 * NetPrepaidConfigBase.java
 *
 * Created on December 06, 2004, 9:40 AM
 */

package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

import java.io.Serializable;


/**
 *
 * @author  Aaron_S1
 */
public abstract class NetPrepaidConfigBase implements INetPrepaidConfig, INetEntityVisitable, Serializable
{
    static final long serialVersionUID =  -8270076800484813341L;

    public static short MAX_PREPAID_CONFIG_RECS = 1;
    private static short MAX_PREPAID_AMOUNT = 500;  /* default */

    /** Creates a new instance of NetPrepaidConfigBase */
    public NetPrepaidConfigBase()
    {
    }

    private boolean prepaidEnabled;
    private boolean activationEnabled;
    private boolean rechargeEnabled;
    private short activationMin;
    private short activationMax;
    private short rechargeMin;
    private short rechargeMax;
    protected NetPrepaidConfigPK ID;
    
    public void setRecordNr(short recordNr) {
        ID = new NetPrepaidConfigPK(recordNr);
    }
    
    public boolean getPrepaidEnabled()
    {
        return this.prepaidEnabled;
    }
    
    public void setPrepaidEnabled(boolean isTrue) {
        this.prepaidEnabled = isTrue;
    }
    
    public boolean getActivationEnabled()
    {
        return this.activationEnabled;
    }
    
    public void setActivationEnabled(boolean activationEnabled)
    {
        this.activationEnabled = activationEnabled;
    }
    
    public boolean getRechargeEnabled()
    {
        return this.rechargeEnabled;
    }
    
    public void setRechargeEnabled(boolean rechargeEnabled)
    {
        this.rechargeEnabled = rechargeEnabled;
    }
    
    public short getActivationMin()
    {
        return this.activationMin;
    }
    
    public void setActivationMin(short activationMin)
    {
        this.activationMin = activationMin;
    }
    
    public short getActivationMax()
    {
        return this.activationMax;
    }
    
    public void setActivationMax(short activationMax)
    {
        this.activationMax = activationMax;
    }
    
    public short getRechargeMin()
    {
        return this.rechargeMin;
    }
    
    public void setRechargeMin(short rechargeMin)
    {
        this.rechargeMin = rechargeMin;
    }
    
    public short getRechargeMax()
    {
        return this.rechargeMax;
    }
    
    public void setRechargeMax(short rechargeMax)
    {
        this.rechargeMax = rechargeMax;
    }
    
    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {
        if (!isPKValid()) {
            throw new Exception("Invalid NetPrepaidConfigBase Entry: " + this.ID);            
        }
        
        if ((this.activationMin < 0) || (this.activationMin > MAX_PREPAID_AMOUNT)) {
            throw new Exception("Invalid NetPrepaidConfigBase Entry activationMin: " + this.activationMin);            
        }
        
        if ((this.activationMax < 0) || (this.activationMax > MAX_PREPAID_AMOUNT)) {
            throw new Exception("Invalid NetPrepaidConfigBase Entry activationMax: " + this.activationMax);            
        }
        
        if ((this.rechargeMin < 0) || (this.rechargeMin > MAX_PREPAID_AMOUNT)) {
            throw new Exception("Invalid NetPrepaidConfigBase Entry rechargeMin: " + this.rechargeMin);            
        }
        
        if ((this.rechargeMax < 0) || (this.rechargeMax > MAX_PREPAID_AMOUNT)) {
            throw new Exception("Invalid NetPrepaidConfigBase Entry rechargeMax: " + this.rechargeMax);            
        }
    }

    public void setAttributes(IEntityObject obj) {
        NetPrepaidConfigBase netPrepaidConfig = (NetPrepaidConfigBase)obj;
        
        netPrepaidConfig.ID = this.ID;
        netPrepaidConfig.prepaidEnabled = this.prepaidEnabled;        
        netPrepaidConfig.setActivationEnabled(this.activationEnabled);
        netPrepaidConfig.setRechargeEnabled(this.rechargeEnabled);
        netPrepaidConfig.setActivationMin(this.activationMin);
        netPrepaidConfig.setActivationMax(this.activationMax);
        netPrepaidConfig.setRechargeMin(this.rechargeMin);
        netPrepaidConfig.setRechargeMax(this.rechargeMax);
    
    }
    
    /* Depricated - use retrieve method in PersistAdmin
    public void reloadConfig(INetPrepaidConfig prepaidConfig) {
        NetPrepaidConfigBase local = (NetPrepaidConfigBase) prepaidConfig;
        this.prepaidEnabled = local.prepaidEnabled;
        this.activationEnabled = local.getActivationEnabled();
        this.rechargeEnabled = local.getRechargeEnabled();
        this.activationMin = local.getActivationMin();
        this.activationMax = local.getActivationMax();
        this.rechargeMin = local.getRechargeMin();
        this.rechargeMax = local.getRechargeMax();
    }
     */
    
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
        this.ID = (NetPrepaidConfigPK)pk;        
    }
    
    /** Method to validate the primary key of the entity object
     * @return true if the primary key of the entity object is valid
     */
    public boolean isPKValid() {
        return (this.getPK() == null) ? false : this.getPK().isValid();
    }  
     
    public static void setMaxAmountValue(short maxValue) {
        MAX_PREPAID_AMOUNT = maxValue;
    }
    
    public static short getMaxAmountValue() {
        return MAX_PREPAID_AMOUNT;
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
