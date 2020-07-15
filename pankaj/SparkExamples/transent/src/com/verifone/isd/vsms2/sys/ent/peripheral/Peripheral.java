/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 08 June, 2009                                     Ganesh Kumar
 */
package com.verifone.isd.vsms2.sys.ent.peripheral;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.ent.ISystemEntityVisitable;
import com.verifone.isd.vsms2.sys.ent.ISystemEntityVisitor;
import com.verifone.isd.vsms2.sys.ent.deviceversion.DeviceVersionInfo;
import com.verifone.isd.vsms2.sys.ent.pinentrydevice.PinEntryDevice;



/** Entity class for Peripheral.
 * @author ganesh_k1
 * @version 1.0
 */
public class Peripheral implements IEntityObject, ISystemEntityVisitable {

    public static final String LOCATION_OUTSIDE = "OUTSIDE";
    public static final String LOCATION_INSIDE = "INSIDE";
    public static final String PERIPHERAL="Peripheral";
    
    private static final long serialVersionUID = -117018873419160592L;
    
    private PeripheralPK pk;    
    private long versionInfoID;
    private String deviceType;
    private String primaryDevice;
    private String assetNo;
    private String description;
    private String location;

    private DeviceVersionInfo versionInfo;
    private PinEntryDevice pinDevice;
    
    /**
     * default constructor
     */
    public Peripheral() {
    }

    /**
     * Constructor
     * 
     * @param deviceID
     * @param deviceCategory
     */
    public Peripheral(PeripheralPK pk) {
	this();
	this.pk = pk;
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
     * @return the deviceType
     */
    public String getDeviceType() {
	return deviceType;
    }

    /**
     * @param deviceType the deviceType to set
     */
    public void setDeviceType(String deviceType) {
	this.deviceType = deviceType;
    }

    /**
     * @return the primaryDevice
     */
    public String getPrimaryDevice() {
	return primaryDevice;
    }

    /**
     * @param primaryDevice the primaryDevice to set
     */
    public void setPrimaryDevice(String primaryDevice) {
	this.primaryDevice = primaryDevice;
    }

    /**
     * @return the location
     */
    public String getLocation() {
	return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
	this.location = location;
    }    

    /**
     * Method to validate an entity object's attributes.
     * 
     * @throws Exception
     *             if validation fails
     */
    public void validate() throws Exception {
	if (!isPKValid()) {
	    throw new Exception("Invalid device key: " + this.pk);
	}
	if (this.versionInfoID < 0) {
	    throw new Exception("Invalid versionInfoID for Peripheral: " +pk.toString());
	}
	if (this.deviceType != null && this.deviceType.length() > 20) {
	    throw new Exception("Invalid deviceType for Peripheral: " +pk.toString());
	}
	if (this.primaryDevice != null && this.primaryDevice.length() > 20) {
	    throw new Exception("Invalid primaryDevice for Peripheral: " +pk.toString());
	}
	if (this.assetNo != null && this.assetNo.length() > 10) {
	    throw new Exception("Invalid assetNo for Peripheral: " +pk.toString());
	}
	if (this.description != null && this.description.length() > 50) {
	    throw new Exception("Invalid description for Peripheral: " +pk.toString());
	}
	if (this.location != null && this.location.length() > 10) {
	    throw new Exception("Invalid location for Peripheral: " +pk.toString());
	}
    }

    /** String representation of the entity
     * @return String representation of the entity
     */    
    public String toString() {
	return " versionInfoID=" + versionInfoID + "; deviceType="
	+ deviceType + "; assetNo=" + assetNo + "; primaryDevice=" + primaryDevice
	+ "; description=" + description + "; location" + location;
    }

    /**
     * @return the pk
     */
    public IEntityPK getPK() {
	return pk;
    }

    public boolean isPKValid() {
	return (this.pk == null) ? false : this.pk.isValid();
    }


    public void setAttributes(IEntityObject obj) {
	Peripheral mObj = (Peripheral) obj;
	mObj.pk = this.pk;
	mObj.versionInfoID = this.versionInfoID;
	mObj.deviceType = this.deviceType;
	mObj.primaryDevice = this.primaryDevice;
	mObj.assetNo = this.assetNo;
	mObj.description = this.description;	
	mObj.location = this.location;
    }

    /**
     * Set the primary key of the entity object
     * 
     * @param pk primary key for the entity object
     */
    public void setPK(IEntityPK pk) {
	this.pk = (PeripheralPK) pk;
    }


    public void accept(ISystemEntityVisitor v) throws Exception {
	v.visit(this);
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


    /**
     * @return the pinDevice
     */
    public PinEntryDevice getPinDevice() {
	return pinDevice;
    }


    /**
     * @param pinDevice the pinDevice to set
     */
    public void setPinDevice(PinEntryDevice pinDevice) {
	this.pinDevice = pinDevice;
    }   
}

