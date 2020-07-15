package com.verifone.isd.vsms2.sales.ent.cwpaypoint;


import java.util.Enumeration;
import java.util.Hashtable;
import java.util.HashMap;
import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.log4j.*;

/**
 *  entity class for CarWashBay
 *
 *  @author Aaron_S1
 *  @version 1.0 Copyright(c) 2007 VeriFone, Inc., All Rights Reserved
 */
public class CarWashBay {
    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sales.ent.cwpaypoint.CarWashBay.class);
    /**
     * Maximum number of car wash bays
     */    
    public static final int MAX_CAR_WASH_BAYS = 4;
    public static final int MAX_CAR_WASH_KEYS = 4;

    private int ID;
    private boolean enabled;
    private boolean debitEnabled;
    private String bayIP;
    private int authPort;
    private int alertPort;
    private int entryPort;
    private int reconciliationPort;
    
    private HashMap cwKeys;
    
    
    /**
     * Constructor
     * @param ID Car wash bay number
     */
    public CarWashBay(int ID) {
        this.ID = ID;
        this.cwKeys = new HashMap();
        setupPorts();
    }

    /**
     * No-args constructor
     */    
    public CarWashBay() {
        this.cwKeys = new HashMap();
        setupPorts();
    }

    private void setupPorts(){
        authPort = 9105;
        alertPort = 9106;
        entryPort = 9108;
        reconciliationPort = 9107;
        try {
            authPort = Integer.parseInt(SysPropertyFactory.getProperty("cwpaypoint.auth.port"));
        } catch (Exception e) {
            logger.error("CwAuthServer getting cwpaypoint.auth.port: Exception " + e.getMessage());
            e.printStackTrace();
        }
        try {
            alertPort = Integer.parseInt(SysPropertyFactory.getProperty("cwpaypoint.alert.port"));
        } catch (Exception e) {
            logger.error("CwAuthServer getting cwpaypoint.alert.port: Exception " + e.getMessage());
            e.printStackTrace();
        }
        try {
            entryPort = Integer.parseInt(SysPropertyFactory.getProperty("cwpaypoint.entry.port"));
        } catch (Exception e) {
            logger.error("CwAuthServer getting cwpaypoint.entry.port: Exception " + e.getMessage());
            e.printStackTrace();
        }
        try {
            reconciliationPort = Integer.parseInt(SysPropertyFactory.getProperty("cwpaypoint.recon.port"));
        } catch (Exception e) {
            logger.error("CwAuthServer getting cwpaypoint.recon.port: Exception " + e.getMessage());
            e.printStackTrace();
        }
        logger.info("CarWashBayPorts:  auth="+authPort+" alert="+alertPort+" entry="+entryPort+" recon="+reconciliationPort);
    }

    /**
     * Getter for ID property
     * @return car wash bay number
     */    
    public int getID() {
        return this.ID;
    }
    
    /**
     * Setter for ID property
     * @param ID car wash bay number
     */    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    /**
     * Getter for isEnabled property
     * @return true if this car wash bay is being configured
     */    
    public boolean isEnabled() {
        return this.enabled;
    }
    
    /**
     * Setter for enabled property
     * @param isTrue if true, this car wash bay is being configured
     */    
    public void setEnabled(boolean isTrue) {
        this.enabled = isTrue;
    }
                       
    /**
     * Getter for property debitEnabled.
     * @return Value of property debitEnabled.
     */
    public boolean isDebitEnabled() {
        return this.debitEnabled;
    }
    
    /**
     * Setter for property debitEnabled.
     * @param debitEnabled New value of property debitEnabled.
     */
    public void setDebitEnabled(boolean debitEnabled) {
        this.debitEnabled = debitEnabled;
    }
    
    /**
     * Getter for property authIP.
     * @return Value of property authIP.
     */
    public String getBayIP() {
        return this.bayIP;
    }
    
    /**
     * Setter for property bayIP.
     * @param bayIP New value of property bayIP.
     */
    public void setBayIP(String bayIP) {
        this.bayIP = bayIP;
    }
    
    /**
     * Getter for property authPort.
     * @return Value of property authPort.
     */
    public int getAuthPort() {
        return this.authPort;
    }
    
    /**
     * Setter for property authPort.
     * @param authPort New value of property authPort.
     */
    public void setAuthPort(int authPort) {
        this.authPort = authPort;
    }
    
    /**
     * Getter for property alertPort.
     * @return Value of property alertPort.
     */
    public int getAlertPort() {
        return this.alertPort;
    }
    
    /**
     * Setter for property alertPort.
     * @param alertPort New value of property alertPort.
     */
    public void setAlertPort(int alertPort) {
        this.alertPort = alertPort;
    }
    
    /**
     * Getter for property entryPort.
     * @return Value of property entryPort.
     */
    public int getEntryPort() {
        return this.entryPort;
    }
    
    /**
     * Setter for property entryPort.
     * @param entryPort New value of property entryPort.
     */
    public void setEntryPort(int entryPort) {
        this.entryPort = entryPort;
    }

    /**
     * Getter for property reconciliationPort.
     * @return Value of property reconciliationPort.
     */
    public int getReconciliationPort() {
        return this.reconciliationPort;
    }    

    /**
     * Setter for property reconciliationPort.
     * @param reconciliationPort New value of property reconciliationPort.
     */
    public void setReconciliationPort(int reconciliationPort) {
        this.reconciliationPort = reconciliationPort;
    }
    

    /**
     * Getter for a specific car wash key
     * @param keyID key number of value to be returned
     * @throws Exception if invalid key number is requested
     * @return requested value
     */    
    public int getCarWashKey(int keyID) throws Exception {
        Integer tempKey = (Integer)cwKeys.get(new Integer(keyID));
        return tempKey.intValue();
    }

    /**
     * Getter for the car wash bay list
     * @return enumeration of the car wash bays
     */    
    public HashMap getCarWashKeys() {
        return cwKeys;
    }
    
        
    /**
     * Setter for the car wash key list
     * @param keys enumeration of the car wash keys
     */    
    public void setCarWashKeys(HashMap keys) {
        this.cwKeys.clear();
        if (keys != null) {
            this.cwKeys.putAll(keys);
        }
    }

    /**
     * Validator for the entitie's attributes
     * @throws Exception if validation fails
     */    
    public void validate() throws Exception {
        if ((this.ID <= 0) || (this.ID > MAX_CAR_WASH_BAYS))
            throw new Exception("Invalid CarWashBay ID: " + this.ID);
    }
    

}
