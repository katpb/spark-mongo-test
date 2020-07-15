/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 08 June, 2009                                     Ganesh Kumar
 */
package com.verifone.isd.vsms2.sys.ent.middlewareversion;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.ent.ISystemEntityVisitable;
import com.verifone.isd.vsms2.sys.ent.ISystemEntityVisitor;


/** Entity class for MiddlewareVersionInfo.
 * @author ganesh_k1
 * @version 1.0
 */
public class MiddlewareVersionInfo implements IEntityObject, ISystemEntityVisitable  {

    private static final long serialVersionUID = -7785768625058078482L;
    private MiddlewareVersionInfoPK ID = null;
    private String vendor;
    private String model;
    private String softwareVersion;

    /**
     * default constructor
     */
    public MiddlewareVersionInfo() {
    }

    /**
     * Constructor
     * 
     * @param pk
     *            Primary key for the entity
     */
    public MiddlewareVersionInfo(MiddlewareVersionInfoPK ID) {
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
        this.ID = (MiddlewareVersionInfoPK)pk;        
    }

    /**
     * @return the model
     */
    public String getModel() {
	return model;
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
     * @param model the model to set
     */
    public void setModel(String model) {
	this.model = model;
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
    
    /** Method to clone this entity's attribute to another
     * @param obj object to copy to
     */    
    public void setAttributes(IEntityObject obj) {
	MiddlewareVersionInfo mObj = (MiddlewareVersionInfo) obj;
        mObj.ID = this.ID;
        mObj.model = this.model;
        mObj.vendor = this.vendor;
        mObj.softwareVersion = this.softwareVersion;
    }
    
    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {
        if (!isPKValid()) {
            throw new Exception("Invalid MiddlewareVersionInfo: " +this.ID);            
        }
        if (this.model != null && this.model.length() > 50) {
            throw new Exception("Invalid model for middlewareversion info: " +ID);
        }
        if (this.vendor != null && this.vendor.length() > 50) {
            throw new Exception("Invalid vendor for middlewareversion info: " +ID);
        }
        if (this.softwareVersion != null && this.softwareVersion.length() > 50) {
            throw new Exception("Invalid softwareVersion for middlewareversion info: " +ID);
        }        
    }

    /** String representation of the entity
     * @return String representation of the entity
     */    
    public String toString() {
	return "model:" + model + "vendor:" + vendor + "softwareVersion:" + softwareVersion;
    }

    public void accept(ISystemEntityVisitor v) throws Exception {
	v.visit(this);
    }   
}

