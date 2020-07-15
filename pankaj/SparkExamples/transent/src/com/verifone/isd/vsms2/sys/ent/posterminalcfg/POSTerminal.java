/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 08 June, 2009                                     Ganesh Kumar
 */
package com.verifone.isd.vsms2.sys.ent.posterminalcfg;

import java.util.ArrayList;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.ent.ISystemEntityVisitable;
import com.verifone.isd.vsms2.sys.ent.ISystemEntityVisitor;
import com.verifone.isd.vsms2.sys.ent.deviceversion.DeviceVersionInfo;
import com.verifone.isd.vsms2.sys.ent.peripheral.Peripheral;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.log4j.*;

/** Entity class for POSTerminal.
 * @author ganesh_k1
 * @version 1.0
 */
public class POSTerminal implements IEntityObject, ISystemEntityVisitable {

    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.ent.posterminalcfg.POSTerminal.class);
    private static final long serialVersionUID = -7368861114539862485L;
    private POSTerminalPK pk;
    private long versionInfoID;
    private String methodOfOperation;
    private String applicationStartTime;
    private String role;
    private String assetNo;
    private String description;

    private DeviceVersionInfo versionInfo;
    private ArrayList deviceList;
    private ArrayList middleWareList;
    /**
     * default constructor
     */
    public POSTerminal() {
	this(null);
    }

    /**
     * Constructor
     * 
     * @param pk Primary key for the entity
     */
    public POSTerminal(POSTerminalPK pk) {
	this.pk = pk;
	this.deviceList = new ArrayList();
	middleWareList = new ArrayList();
    }    

    /**
     * @return the applicationStartTime
     */
    public String getApplicationStartTime() {
	return applicationStartTime;
    }

    /**
     * @return the assetNo
     */
    public String getAssetNo() {
	return assetNo;
    }

    /**
     * @return the description
     */
    public String getDescription() {
	return description;
    }

    /**
     * @return the methodOfOperation
     */
    public String getMethodOfOperation() {
	return methodOfOperation;
    }

    /**
     * @return the role
     */
    public String getRole() {
	return role;
    }

    /**
     * @param applicationStartTime the applicationStartTime to set
     */
    public void setApplicationStartTime(String applicationStartTime) {
	this.applicationStartTime = applicationStartTime;
    }

    /**
     * @param assetNo the assetNo to set
     */
    public void setAssetNo(String assetNo) {
	this.assetNo = assetNo;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * @param methodOfOperation the methodOfOperation to set
     */
    public void setMethodOfOperation(String methodOfOperation) {
	this.methodOfOperation = methodOfOperation;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
	this.role = role;
    }

    /**
     * @return the versionInfoID
     */
    public long getVersionInfoID() {
	return versionInfoID;
    }

    /**
     * @param versionInfoID the versionInfoID to set
     */
    public void setVersionInfoID(long versionInfoID) {
	this.versionInfoID = versionInfoID;
    }

    /**
     * Getter of the entity object's primary key
     * 
     * @return the ID of the entity object
     */
    public IEntityPK getPK() {
	return this.pk;
    }

    /**
     * Method to clone another entity with this enity's attributes
     * 
     * @param obj entity to copy to
     */
    public void setAttributes(IEntityObject obj) {
	POSTerminal mObj = (POSTerminal) obj;
	mObj.pk = this.pk;	
	mObj.versionInfoID = this.versionInfoID;
	mObj.methodOfOperation = this.methodOfOperation;
	mObj.applicationStartTime = this.applicationStartTime;
	mObj.role = this.role;
	mObj.assetNo = this.assetNo;
	mObj.description = this.description;
	mObj.setDevices(this.getDevices());
	mObj.setMiddleWares(this.getMiddleWares());
    }

    /**
     * Returns the array of devices for the PosTerminal
     * 
     * @return the array of devices for the PosTerminal
     */
    public Peripheral[] getDevices() {
	return (Peripheral[]) this.deviceList.toArray(new Peripheral[0]);
    }


    /** Sets the Lisst of Devices for the PosTerminal. Clears the existing
     * devices list and adds the new devices.
     * @param devices list of POSDevices for the PosTerminal
     */
    public void setDevices(Peripheral[] devices) {
	this.deviceList.clear();
	if (devices != null) {
	    int numEl = devices.length;
	    for (int i = 0; i < numEl; i++) {
		this.deviceList.add(devices[i]);
	    }
	}
    }

    /**
     * Returns the array of MiddleWares for the PosTerminal. Clears the existing
     * middleWares list and adds the new middleWare.
     * 
     * @return the array of MiddleWares for the PosTerminal
     */
    public POSMiddleware[] getMiddleWares() {
	return (POSMiddleware[]) this.middleWareList.toArray(new POSMiddleware[0]);
    }

    /** Sets the Lisst of MiddleWares for the PosTerminal. 
     * @param devices list of POSMiddleware for the PosTerminal
     */
    public void setMiddleWares(POSMiddleware[] middlewares) {
	this.middleWareList.clear();
	if (middlewares != null) {
	    int numEl = middlewares.length;
	    for (int i = 0; i < numEl; i++) {
		this.middleWareList.add(middlewares[i]);
	    }
	}
    }

    /**
     * Method to validate the primary key of the entity object
     * 
     * @return true if the primary key of the entity object is valid
     */
    public boolean isPKValid() {
	return (this.pk == null) ? false : this.pk.isValid();
    }

    /**
     * Set the primary key of the entity object
     * 
     * @param pk primary key for the entity object
     */
    public void setPK(IEntityPK pk) {
	this.pk = (POSTerminalPK) pk;
    }

    /**
     * Method to validate an entity object's attributes.
     * 
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {
	if (!isPKValid()) {
	    throw new Exception("Invalid posterminalKey: " + this.pk);
	}
	if (this.versionInfoID < 0) {
	    throw new Exception("Invalid versionInfoID for posterminal info: " +pk.getValue());
	}
	if (this.methodOfOperation != null && this.methodOfOperation.length() > 50) {
	    throw new Exception("Invalid methodOfOperation for posterminal info: " +pk.getValue());
	}
	if (this.applicationStartTime != null && this.applicationStartTime.length() > 26) {
	    throw new Exception("Invalid applicationStartTime for posterminal info: " +pk.getValue());
	}
	if (this.role != null && this.role.length() > 20) {
	    throw new Exception("Invalid role for posterminal info: " +pk.getValue());
	}
	if (this.assetNo != null && this.assetNo.length() > 20) {
	    throw new Exception("Invalid assetNo for posterminal info: " +pk.getValue());
	}
	if (this.description != null && this.description.length() > 50) {
	    throw new Exception("Invalid description for posterminal info: " +pk.getValue());
	}	    
	this.validateDevices();
	this.validateMiddlewares();
    }

    private void validateDevices() {
	Peripheral[] devices = this.getDevices();
	int len = devices.length;
	for (int i = 0; i < len; i++) {
	    Peripheral item = devices[i];
	    try {
		item.validate();
	    } catch (Exception e) {
		logger.error("Device: " + this.pk + " validation error - "
			+ e.getMessage());
	    }
	}
    }

    public void addPOSDevice(Peripheral device) {
	deviceList.add(device);
    }

    private void validateMiddlewares() {
	POSMiddleware[] middleWares = this.getMiddleWares();
	int len = middleWares.length;
	for (int i = 0; i < len; i++) {
	    POSMiddleware item = middleWares[i];
	    try {
		item.validate();
	    } catch (Exception e) {
		logger.error("POSMiddleWare: " + this.pk + " validation error - "
			+ e.getMessage());
	    }
	}
    }

    public void addPOSMiddleWare(POSMiddleware middleWare) {
	middleWareList.add(middleWare);
    }



    /** String representation of the entity
     * @return String representation of the entity
     */    
    public String toString() {
	return "versionInfoID=" + versionInfoID + "; methodOfOperation"
	+ methodOfOperation + "; applicationStartTime"
	+ applicationStartTime + "; role" + role + "; assetNo"
	+ assetNo + "; description" + description;
    }

    public void accept(ISystemEntityVisitor v) throws Exception {
	v.visit(this);	
    }

    /**
     * @return the deviceList
     */
    public ArrayList getDeviceList() {
	return deviceList;
    }

    /**
     * @return the middlewareComponentList
     */
    public ArrayList getMiddleWareList() {
	return middleWareList;
    }

    /**
     * @param deviceList the deviceList to set
     */
    public void setDeviceList(ArrayList deviceList) {
	this.deviceList = deviceList;
    }

    /**
     * @param mwComponentList the middlewareComponentList to set
     */
    public void setMiddleWareList(ArrayList middleWareList) {
	this.middleWareList = middleWareList;
    }

    /**
     * @return the versionInfo
     */
    public DeviceVersionInfo getVersionInfo() {
        return versionInfo;
    }

    /**
     * @param versionInfo the versionInfo to set
     */
    public void setVersionInfo(DeviceVersionInfo versionInfo) {
        this.versionInfo = versionInfo;
    }
}

