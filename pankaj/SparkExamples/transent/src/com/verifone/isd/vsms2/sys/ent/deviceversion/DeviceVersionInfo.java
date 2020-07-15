/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 08 June, 2009                                     Ganesh Kumar
 */
package com.verifone.isd.vsms2.sys.ent.deviceversion;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.ent.ISystemEntityVisitable;
import com.verifone.isd.vsms2.sys.ent.ISystemEntityVisitor;


/** Entity class for DeviceVersionInfo.
 * @author ganesh_k1
 * @version 1.0
 */
public class DeviceVersionInfo implements IEntityObject, ISystemEntityVisitable  {
    
    public static final String PORT_TYPE_IP = "ethernet";
    public static final String PORT_TYPE_SERIAL = "serial";
    public static final String PORT_TYPE_USBL = "usb";

    private static final long serialVersionUID = -7785768625058078482L;
    private DeviceVersionInfoPK ID = null;
    private String vendor;
    private String modelName;
    private String hardwareVersion;
    private String softwareVersion;
    private String firmwareVersion;
    private String osVersion;
    private String portType;

    /**
     * default constructor
     */
    public DeviceVersionInfo() {
    }

    /**
     * Constructor
     * 
     * @param pk Primary key for the entity
     */
    public DeviceVersionInfo(DeviceVersionInfoPK ID) {
	this.ID = ID;
    }
    

    /** Getter of the entity object's primary key
     * @return the ID of the entity object
     */
    public IEntityPK getPK() {
        return this.ID;
    }
    
    /** Method to validate the primary key of the entity object
     * @return true if the primary key of the entity object is valid
     */
    public boolean isPKValid() {
        return (this.ID == null) ? false : this.ID.isValid();
    }
    
    /** Set the primary key of the entity object
     * @param pk primary key for the entity object
     */
    public void setPK(IEntityPK pk) {
        this.ID = (DeviceVersionInfoPK)pk;        
    }

    /**
     * @return the modelName
     */
    public String getModelName() {
	return modelName;
    }

    /**
     * @return the softwareVersion
     */
    public String getSoftwareVersion() {
	return softwareVersion;
    }

    /**
     * @return the vendor
     */
    public String getVendor() {
	return vendor;
    }

    /**
     * @param modelName the modelName to set
     */
    public void setModelName(String modelName) {
	this.modelName = modelName;
    }

    /**
     * @param softwareVersion the softwareVersion to set
     */
    public void setSoftwareVersion(String softwareVersion) {
	this.softwareVersion = softwareVersion;
    }

    /**
     * @param vendor the vendor to set
     */
    public void setVendor(String vendor) {
	this.vendor = vendor;
    }
    

    /**
     * @return the firmwareVersion
     */
    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    /**
     * @return the hardwareVersion
     */
    public String getHardwareVersion() {
        return hardwareVersion;
    }

    /**
     * @return the osVersion
     */
    public String getOsVersion() {
        return osVersion;
    }

    /**
     * @return the portType
     */
    public String getPortType() {
        return portType;
    }

    /**
     * @param firmwareVersion the firmwareVersion to set
     */
    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    /**
     * @param hardwareVersion the hardwareVersion to set
     */
    public void setHardwareVersion(String hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
    }

    /**
     * @param osVersion the osVersion to set
     */
    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    /**
     * @param portType the portType to set
     */
    public void setPortType(String portType) {
        this.portType = portType;
    }

    /** Method to clone this entity's attribute to another
     * @param obj object to copy to
     */    
    public void setAttributes(IEntityObject obj) {
	DeviceVersionInfo mObj = (DeviceVersionInfo) obj;
        mObj.ID = this.ID;
        mObj.modelName = this.modelName;
        mObj.vendor = this.vendor;
        mObj.hardwareVersion = this.hardwareVersion;
        mObj.softwareVersion = this.softwareVersion;
        mObj.firmwareVersion = this.firmwareVersion;
        mObj.osVersion = this.osVersion;
        mObj.portType = this.portType;
    }
    
    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {
        if (!isPKValid()) {
            throw new Exception("Invalid DeviceVersionInfo: " +this.ID);            
        }        
        if (this.modelName != null && this.modelName.length() > 50) {
            throw new Exception("Invalid modelName for DeviceVersion info: " +ID);
        }
        if (this.vendor != null && this.vendor.length() > 50) {
            throw new Exception("Invalid vendor for DeviceVersion info: " +ID);
        }
        if (this.softwareVersion != null && this.softwareVersion.length() > 50) {
            throw new Exception("Invalid softwareVersion for DeviceVersion info: " +ID);
        }
        if (this.hardwareVersion != null && this.hardwareVersion.length() > 50) {
            throw new Exception("Invalid hardwareVersion for DeviceVersion info: " +ID);
        }
        if (this.firmwareVersion != null && this.firmwareVersion.length() > 50) {
            throw new Exception("Invalid firmwareVersion for DeviceVersion info: " +ID);
        }
        if (this.osVersion != null && this.osVersion.length() > 50) {
            throw new Exception("Invalid osVersion for DeviceVersion info: " +ID);            
        }
        if (this.portType != null && this.portType.length() > 10) {
            throw new Exception("Invalid portType for DeviceVersion info: " +ID);            
        }
    }

    /** String representation of the entity
     * @return String representation of the entity
     */    
    public String toString() {	
	return "vendor=" + vendor + "; modelName=" + modelName + "; hardwareVersion=" + hardwareVersion 
	+ "; softwareVersion=" + softwareVersion + "; firmwareVersion=" + firmwareVersion 
	+ "; osVersion=" + osVersion + "; portType=" + portType;
    }

    public void accept(ISystemEntityVisitor v) throws Exception {
	v.visit(this);
    }
}

