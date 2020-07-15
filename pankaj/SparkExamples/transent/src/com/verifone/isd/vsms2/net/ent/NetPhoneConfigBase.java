/*
 * NetPhoneConfig.java
 *
 * Created on December 02, 2004, 1:46 PM
 */

package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

import java.io.Serializable;

/**
 *
 * @author  Aaron_S1
 */
public abstract class NetPhoneConfigBase implements INetPhoneConfig, INetEntityVisitable, Serializable
{
    static final long serialVersionUID = -6063891130640491948L;

    private static short MAX_MODEM_DIAL_STRING_SIZE = 15;
    private static short MAX_MODEM_RESET_STRING_SIZE = 20;

    protected boolean toneDialing;
    protected String modemReset;
    protected String modemDial;
    protected NetPhoneConfigPK ID;
    
    /** Creates a new instance of NetPhoneConfig */
    public NetPhoneConfigBase() {
        modemReset = new String("");
        modemDial = new String("");
    }
    
    public void setRecordNr(short recordNr) {
        ID = new NetPhoneConfigPK(recordNr);
    }
    
    public boolean getToneDialing() {
        return this.toneDialing;
    }
    
    public void setToneDialing(boolean toneDialing) {
        this.toneDialing = toneDialing;
    }
    
    public String getModemReset() {
        return this.modemReset;
    }
    
    public void setModemReset(String modemReset) {
        this.modemReset = modemReset;
    }
    
    public String getModemDial() {
        return this.modemDial;
    }
    
    public void setModemDial(String modemDial) {
        this.modemDial = modemDial;
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
        this.ID = (NetPhoneConfigPK)pk;
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
            throw new Exception("Invalid NetPhoneConfig Entry: " +this.ID);
        }
        
        if ((this.modemReset != null) && (this.modemReset.length() > MAX_MODEM_RESET_STRING_SIZE)) {
            throw new Exception("Invalid NetPhoneConfig Entry modemReset: " + this.modemReset);
        }
        
        if ((this.modemDial != null) && (this.modemDial.length() > MAX_MODEM_DIAL_STRING_SIZE)) {
            throw new Exception("Invalid NetPhoneConfig Entry modemDial: " + this.modemDial);
        }
        
    }
    
    public void setAttributes(IEntityObject obj) {
        NetPhoneConfigBase netPhoneConfig = (NetPhoneConfigBase)obj;
        
        netPhoneConfig.ID = this.ID;
        netPhoneConfig.setModemReset(this.modemReset);
        netPhoneConfig.setModemDial(this.modemDial);
        netPhoneConfig.setToneDialing(this.toneDialing);
        
    }
    
    /* Depricated - use retrieve method in PersistAdmin
    public void reloadConfig(INetPhoneConfig phoneConfig) {
        NetPhoneConfigBase local = (NetPhoneConfigBase) phoneConfig;
        
        this.toneDialing = local.getToneDialing();
        this.modemReset = local.getModemReset();
        this.modemDial = local.getModemDial();
    }
     */
    
    public static void setMaxModemDialStringSize(short maxValue) {
        MAX_MODEM_DIAL_STRING_SIZE=maxValue;
    }
    
    public static short getMaxModemDialStringSize() {
        return MAX_MODEM_DIAL_STRING_SIZE;
    }
    public static void setMaxModemResetStringSize(short maxValue) {
        MAX_MODEM_RESET_STRING_SIZE=maxValue;
    }
    
    public static short getMaxModemResetStringSize() {
        return MAX_MODEM_RESET_STRING_SIZE;
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



 
