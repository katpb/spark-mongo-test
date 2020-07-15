/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 08 June, 2009                                     Ganesh Kumar
 */

package com.verifone.isd.vsms2.sys.ent.peripheral;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Primary key class for Peripheral.
 * @author  ganesh_k1
 * @version 1.0
 */
public class PeripheralPK implements IEntityPK {

    private static final long serialVersionUID = 7191129375728405254L;
    
    /** Terminal ID for standalone devices */
    public static final String STANDALONE_DEVICE_TERMINAL_ID = "NA";

    /** Device categories as per Site Asset Schema */
    
    public enum DeviceCategory{
    	CATEGORY_BACKOFFICE("BACKOFFICE"),
    	CATEGORY_CARD_READER("CARD_READER"),
    	CATEGORY_CARD_SCANNER("SCANNER"),
    	CATEGORY_CARWASH("CARWASH"),
    	CATEGORY_CASH_ACCEPTOR("CASH_ACCEPTOR"),
    	CATEGORY_CHECK_READER("CHECK_READER"),
    	CATEGORY_CONTACTLESS_READER("CONTACTLESS_READER"),
    	CATEGORY_JOURNAL_PRINTER("JOURNAL_PRINTER"),
    	CATEGORY_LOTTERY("LOTTERY"),
    	CATEGORY_MONEYORDER("MONEYORDER"),
    	CATEGORY_PINENTRY("PINENTRY"),
    	CATEGORY_PRICESIGN("PRICESIGN"),
    	CATEGORY_RECEIPT_PRINTER("RECEIPT_PRINTER"),
    	CATEGORY_SAFE("SAFE"),
    	CATEGORY_SPEEDPASS("SPEEDPASS"),
    	CATEGORY_TANKGAUGE("TANKGAUGE");
    	
    	private String category;
    	private DeviceCategory(String category){
    		this.category = category;
    	}
    	public String getValue(){
    		return category;
    	}
    }

    private String terminalID;
    private int deviceID;
    private String deviceCategory;


    /** Creates a new instance of PeripheralPK */
    public PeripheralPK() {
    }

    /**
     * Constructor
     * @param terminalID
     */
    public PeripheralPK(String terminalID) {
	this.terminalID = terminalID;
    } 

    /**
     * Constructor
     * @param terminalID
     * @param deviceID
     */   
    public PeripheralPK(String terminalID, int deviceID) {
	this(terminalID);
	this.deviceID = deviceID; 
    }
    
    /**
     * Constructor
     * @param terminalID
     * @param deviceID
     */   
    public PeripheralPK(String terminalID, int deviceID, String deviceCategory) {
    this(terminalID,deviceID);
    this.deviceCategory = deviceCategory; 
    }  

    /** Method to compare two PeripheralPK objects for equality
     * @param obj PeripheralPK object to be compared against
     * @return true if both primary keys represent the same Peripheral
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof PeripheralPK) {
            PeripheralPK lObj = (PeripheralPK) obj;
            return (this.terminalID.equals(lObj.terminalID) && 
                    this.deviceID == lObj.deviceID &&
                    this.deviceCategory.equals(lObj.deviceCategory));
        }
        return false;
    }

    public boolean equals(Object obj) {
	if (obj != null && obj instanceof IEntityPK) {
	    return this.equals((IEntityPK) obj);
	}
	return false;
    } 

    /** Method override since equals() is implemented
     * @return hash code for the object
     */   
    public int hashCode() {
	int hc = 17;
	hc = 37 * hc + this.terminalID.hashCode();
	hc = 37 * hc + this.deviceID;
	hc = 37 * hc + this.deviceCategory.hashCode();
	return hc;
    }

    /** Validator for the terminalID and versionInfoID
     * @return true if the terminalID and versionInfoID are valid
     */    
    public boolean isValid() {
	return (this.terminalID != null && this.terminalID.trim().length() > 0
		&& this.terminalID.trim().length() <= 10 && this.deviceID > 0)
		&& (this.deviceCategory != null && this.deviceCategory.length() < 20) ;       
    }    

    /*
     * Helper method to convert the primary key to a string
     */
    /** String representation of the entity PK
     * @return String representation of the entity PK
     */    
    public String toString() {
	return String.valueOf(terminalID+":"+this.deviceID +":"+ this.deviceCategory);
    }

    /**
     * @return the deviceID
     */
    public int getDeviceID() {
	return deviceID;
    }

    /**
     * @return the terminalID
     */
    public String getTerminalID() {
	return terminalID;
    }

    /**
     * @param deviceID the deviceID to set
     */
    public void setDeviceID(int deviceID) {
	this.deviceID = deviceID;
    }

    /**
     * @param terminalID the terminalID to set
     */
    public void setTerminalID(String terminalID) {
	this.terminalID = terminalID;
    }
    
    /**
     * @return the deviceCategory
     */
    public String getDeviceCategory() {
        return deviceCategory;
    }

    /**
     * @param deviceCategory the deviceCategory to set
     */
    public void setDeviceCategory(String deviceCategory) {
        this.deviceCategory = deviceCategory;
    }
}

