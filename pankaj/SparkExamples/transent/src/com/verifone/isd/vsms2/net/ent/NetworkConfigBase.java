/*
 * NetworkConfig.java
 *
 * Created on December 12, 2004, 2:43 PM
 */

package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import java.io.Serializable;

/**
 *
 * @author  Aaron_S1
 */
public abstract class NetworkConfigBase implements INetworkConfig, INetEntityVisitable, Serializable
{
    static final long serialVersionUID =  2558003421208883424L;
    
    private static int PHONENR_MAXLEN   = 40;   /* default */
    private static int MAX_MERCH_ID_LEN = 10;   /* default */
     
     protected boolean netEnabled;
     protected String merchantNum;
     protected String primaryPhoneNr;
     protected String secondaryPhoneNr;
     protected byte dataSize;
     protected byte parityBit;
     protected byte stopBit;
    
     protected NetworkConfigPK ID;
     
     /** Holds value of property networkName. */
     protected String networkName;
     
     public void setRecordNr(short recordNr) {
         ID = new NetworkConfigPK(recordNr);
     }
     
     /** Creates a new instance of NetworkConfig */
     public NetworkConfigBase() {
         merchantNum = new String("");
         primaryPhoneNr = new String("");
         secondaryPhoneNr = new String("");
         networkName = new String("");
     }
     
     public int getNetworkNum()
     {
         short netNum = ID.getValue();
         return ((int) netNum);
     }
     
     public void setNetworkNum(int networkNum)
     {
         this.setRecordNr((short) networkNum);
     }
     
     public String getMerchantNum()
     {
         return this.merchantNum;
     }
     
     public void setMerchantNum(String merchantNum)
     {
         this.merchantNum = merchantNum;
     }
     
     public boolean getNetEnabled()
     {
         return this.netEnabled;
     }
     
     public void setNetEnabled(boolean netEnabled)
     {
         this.netEnabled = netEnabled;
     }
     
     public String getPrimaryPhoneNr()
     {
         return this.primaryPhoneNr;
     }
     
     public void setPrimaryPhoneNr(String primaryPhoneNr)
     {
         this.primaryPhoneNr = primaryPhoneNr;
     }
     
     public String getSecondaryPhoneNr()
     {
         return this.secondaryPhoneNr;
     }
     
     public void setSecondaryPhoneNr(String secondaryPhoneNr)
     {
         this.secondaryPhoneNr = secondaryPhoneNr;
     }
     
     public byte getDataSize()
     {
         return this.dataSize;
     }
     
     public void setDataSize(byte dataSize)
     {
         this.dataSize = dataSize;
     }
     
     public byte getParityBit()
     {
         return this.parityBit;
     }
     
     public void setParityBit(byte parityBit)
     {
         this.parityBit = parityBit;
     }
     
     public byte getStopBit()
     {
         return this.stopBit;
     }
     
     public void setStopBit(byte stopBit)
     {
         this.stopBit = stopBit;
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
        this.ID = (NetworkConfigPK)pk;        
    }

    /** Method to validate the primary key of the entity object
     * @return true if the primary key of the entity object is valid
     */
    public boolean isPKValid() {
        return (this.ID == null) ? false : this.ID.isValid();
    }
    
    public boolean equals(Object obj) {
        if (obj instanceof NetworkConfigBase) {
            NetworkConfigBase netRecord = (NetworkConfigBase) obj;
            
            if (this.getNetworkNum() == netRecord.getNetworkNum()) {
                return true;
            }
        }
        return false;
    }
    
    public int hashCode() {
        int result = 17;
        result = 37*result + this.getNetworkNum();
        return result;
    }

    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {

        if (!isPKValid()) {
            throw new Exception("Invalid NetworkConfig Entry: " +this.ID);            
        }

        if ((this.merchantNum != null) && (this.merchantNum.length() > MAX_MERCH_ID_LEN)) {
            throw new Exception("Invalid NetworkConfig Entry merchantNum: " + this.merchantNum);            
        }

        if ((this.primaryPhoneNr != null) && (this.primaryPhoneNr.length() > PHONENR_MAXLEN)) {
            throw new Exception("Invalid NetworkConfig Entry primaryPhoneNr: " + this.primaryPhoneNr);            
        }

        if ((this.secondaryPhoneNr != null) && (this.secondaryPhoneNr.length() > PHONENR_MAXLEN)) {
            throw new Exception("Invalid NetworkConfig Entry secondaryPhoneNr: " + this.secondaryPhoneNr);            
        }

        if ((this.dataSize != 0) && (this.dataSize != 7) &&(this.dataSize != 8)) {
            throw new Exception("Invalid NetworkConfig Entry dataSize: " + this.dataSize);            
        }

        if ((this.parityBit < 0) || (this.parityBit > 2)) {
            throw new Exception("Invalid NetworkConfig Entry stopBit: " + this.parityBit);            
        }

        if ((this.stopBit < 0) || (this.stopBit > 2)) {
            throw new Exception("Invalid NetworkConfig Entry stopBit: " + this.stopBit);            
        }

    }

    public void setAttributes(IEntityObject obj) {
        NetworkConfigBase networkConfig = (NetworkConfigBase)obj;
        
        networkConfig.ID = this.ID;
        networkConfig.setNetEnabled(this.netEnabled);
        networkConfig.setMerchantNum(this.merchantNum);
        networkConfig.setPrimaryPhoneNr(this.primaryPhoneNr);
        networkConfig.setSecondaryPhoneNr(this.secondaryPhoneNr);
        networkConfig.setDataSize(this.dataSize);
        networkConfig.setParityBit(this.parityBit);
        networkConfig.setStopBit(this.stopBit);
        networkConfig.setNetworkName(this.networkName);
    }
    
    public static void setPhoneNrMaxlen(int maxLen) {
        PHONENR_MAXLEN = maxLen;
    }
    
    public static int getPhoneNrMaxlen() {
        return PHONENR_MAXLEN;
    }

    public static void setMaxMerchIDLen(int maxLen) {
        MAX_MERCH_ID_LEN = maxLen;
    }
    
    public static int getMaxMerchIDLen() {
        return MAX_MERCH_ID_LEN;
    }

    /** Getter for property networkName.
     * @return Value of property networkName.
     *
     */
    public String getNetworkName() {
        return this.networkName;
    }    

    /** Setter for property networkName.
     * @param networkName New value of property networkName.
     *
     */
    public void setNetworkName(String networkName) {
        this.networkName = networkName;
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
