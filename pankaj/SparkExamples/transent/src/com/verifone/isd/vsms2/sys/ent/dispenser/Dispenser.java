/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 08 June, 2009                                     Ganesh Kumar
 */
package com.verifone.isd.vsms2.sys.ent.dispenser;

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


/** Entity class for Dispenser.
 * @author ganesh_k1
 * @version 1.0
 */
public class Dispenser implements IEntityObject, ISystemEntityVisitable {

    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.ent.dispenser.Dispenser.class);
    private static final long serialVersionUID = 7716982960533980847L;
    private DispenserPK pk;
    private int interfaceID;
    private long versionInfoID;
    private boolean blender;

    private DeviceVersionInfo versionInfo;
    private ArrayList deviceList;
    /**
     * default constructor
     */
    public Dispenser() {	
	this.deviceList = new ArrayList();
    }    
    public Dispenser(DispenserPK pk) {
	this();
	this.pk = pk;	
    }

    /**
     * @return the interfaceID
     */
    public int getInterfaceID() {
	return interfaceID;
    }
    /**
     * @param interfaceID the interfaceID to set
     */
    public void setInterfaceID(int interfaceID) {
	this.interfaceID = interfaceID;
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
     * @return the blender
     */
    public boolean isBlender() {
	return blender;
    }

    /**
     * @param blender the blender to set
     */
    public void setBlender(boolean blender) {
	this.blender = blender;
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
	Dispenser dObj = (Dispenser) obj;
	dObj.pk = this.pk;
	dObj.versionInfoID = this.versionInfoID;
	dObj.interfaceID = this.interfaceID;	
	dObj.setBlender(this.blender);
    }

    /**
     * Returns the array of devices 
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
     * @param pk
     *            primary key for the entity object
     */
    public void setPK(IEntityPK pk) {
	this.pk = (DispenserPK) pk;
    }

    /**
     * Method to validate an entity object's attributes.
     * 
     * @throws Exception
     *             if validation fails
     */
    public void validate() throws Exception {
	if (!isPKValid()) {
	    throw new Exception("Invalid DispenserInterfaceKey: " + this.pk);
	}
	if (this.interfaceID < 0) {
	    throw new Exception("Invalid interfaceID for Dispenser info: " +this.pk.toString());
	}
	if (this.versionInfoID <= 0) {
	    throw new Exception("Invalid versionInfoID for Dispenser info: " +this.pk.toString());
	}	
	validateDevices();
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

    public void addDispenserDevice(Peripheral device) {
	deviceList.add(device);
    }



    /** String representation of the entity
     * @return String representation of the entity
     */    
    public String toString() {
	return "interfaceID = " + interfaceID + "; versionInfoID = " + versionInfoID + "; blender = " + blender;
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
     * @param deviceList the deviceList to set
     */
    public void setDeviceList(ArrayList deviceList) {
	this.deviceList = deviceList;
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

