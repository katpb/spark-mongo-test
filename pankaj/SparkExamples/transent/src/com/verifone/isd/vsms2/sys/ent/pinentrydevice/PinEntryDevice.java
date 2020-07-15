/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 08 June, 2009                                     Ganesh Kumar
 */
package com.verifone.isd.vsms2.sys.ent.pinentrydevice;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.ent.ISystemEntityVisitable;
import com.verifone.isd.vsms2.sys.ent.ISystemEntityVisitor;
import com.verifone.isd.vsms2.sys.ent.peripheral.PeripheralPK;



/** Entity class for PinEntryDevice.
 * @author ganesh_k1
 * @version 1.0
 */
public class PinEntryDevice implements IEntityObject, ISystemEntityVisitable {

    private static final long serialVersionUID = 4986811781633441321L;
    private PeripheralPK pk;
    private String keyManagement;
    private String pinEncryption;
    private short integratedContactlessReader;

    /**
     * default constructor
     */
    public PinEntryDevice() {
    }

    /**
     * Constructor
     * 
     * @param pk Primary key for the entity
     */
    public PinEntryDevice(PeripheralPK pk) {
	this.pk = pk;
    }
        
    /**
     * @return the integratedContactlessReader
     */
    public short getIntegratedContactlessReader() {
        return integratedContactlessReader;
    }

    /**
     * @return the keyManagement
     */
    public String getKeyManagement() {
        return keyManagement;
    }

    /**
     * @return the pinEncryption
     */
    public String getPinEncryption() {
        return pinEncryption;
    }

    /**
     * @param integratedContactlessReader the integratedContactlessReader to set
     */
    public void setIntegratedContactlessReader(short integratedContactlessReader) {
        this.integratedContactlessReader = integratedContactlessReader;
    }

    /**
     * @param keyManagement the keyManagement to set
     */
    public void setKeyManagement(String keyManagement) {
        this.keyManagement = keyManagement;
    }

    /**
     * @param pinEncryption the pinEncryption to set
     */
    public void setPinEncryption(String pinEncryption) {
        this.pinEncryption = pinEncryption;
    }
    
    /**
     * Method to clone another entity with this enity's attributes
     * 
     * @param obj entity to copy to
     */
    public void setAttributes(IEntityObject obj) {
	PinEntryDevice pObj = (PinEntryDevice) obj;
	pObj.pk = this.pk;	
	pObj.setKeyManagement(this.keyManagement);
	pObj.setPinEncryption(this.pinEncryption);
	pObj.setIntegratedContactlessReader(this.integratedContactlessReader);
    }
    
    public void accept(ISystemEntityVisitor v) throws Exception {
	v.visit(this);	
    }
    
    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {  
	if (!isPKValid()) {
	    throw new Exception("Invalid PinEntryDeviceKey: " + this.pk);
	}
	if ((this.keyManagement != null && this.keyManagement.length() > 10)) {
	    throw new Exception("Invalid keyManagement for PinEntryDevice : " +pk.toString());
	}
	if ((this.pinEncryption != null && this.pinEncryption.length() > 16)) {
	    throw new Exception("Invalid pinEncryption for PinEntryDevice : " +pk.toString());
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
	this.pk = (PeripheralPK) pk;
    }
    
    /**
     * Getter of the entity object's primary key
     * 
     * @return the ID of the entity object
     */
    public IEntityPK getPK() {
	return this.pk;
    }

    /** String representation of the entity
     * @return String representation of the entity
     */    
    public String toString() {	
	return "keyManagement=" + keyManagement + "; pinEncryption="
		+ pinEncryption + "; integratedContactlessReader="
		+ integratedContactlessReader;
    }

}

