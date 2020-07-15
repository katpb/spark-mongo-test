/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 08 June, 2009                                     Ganesh Kumar
 */
package com.verifone.isd.vsms2.sys.ent.dispenserinterface;

import java.util.ArrayList;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.ent.ISystemEntityVisitable;
import com.verifone.isd.vsms2.sys.ent.ISystemEntityVisitor;
import com.verifone.isd.vsms2.sys.ent.deviceversion.DeviceVersionInfo;
import com.verifone.isd.vsms2.sys.ent.dispenser.Dispenser;

/** Entity class for DispenserInterface.
 * @author ganesh_k1
 * @version 1.0
 */
public class DispenserInterface implements IEntityObject, ISystemEntityVisitable {

    private static final long serialVersionUID = 2874086292582521028L;
    private DispenserInterfacePK pk;
    private long versionInfoID;
    private DeviceVersionInfo versionInfo;
    private ArrayList dispenserList;

    /**
     * default constructor
     */
    public DispenserInterface() {
	this(null);	
    }

    /**
     * Constructor
     * 
     * @param pk
     *            Primary key for the entity
     */
    public DispenserInterface(DispenserInterfacePK pk) {
	this.dispenserList = new ArrayList();
	this.pk = pk;
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
     * @param obj
     *            entity to copy to
     */
    public void setAttributes(IEntityObject obj) {
	DispenserInterface mObj = (DispenserInterface) obj;
	mObj.pk = this.pk;
	mObj.versionInfoID = this.versionInfoID;
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
	this.pk = (DispenserInterfacePK) pk;
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
	if (this.versionInfoID <= 0) {
            throw new Exception("Invalid versionInfoID for DispenserInterface info: " + this.pk.toString());
        }
    }
    
    /** String representation of the entity
     * @return String representation of the entity
     */    
    public String toString() {
	return "versionInfoID:" + versionInfoID;
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
     * @return the dispenserList
     */
    public ArrayList getDispenserList() {
        return dispenserList;
    }

    /**
     * @param dispenserList the dispenserList to set
     */
    public void setDispenserList(ArrayList dispenserList) {
        this.dispenserList = dispenserList;
    }
    
    /**
     * Returns the array of dispensers for the DispenserInterface
     * 
     * @return the array of dispensers for the DispenserInterface
     */
    public Dispenser[] getDispensers() {
        return (Dispenser[]) this.dispenserList.toArray(new Dispenser[0]);
    }
    
    /** Sets the List of dispensers for the DispenserInterface. Clears the existing
     * dispensers list and adds the new dispensers.
     * @param devices list of Dispenser for the DispenserInterface
     */
    public void setDispensers(Dispenser[] dispensers) {
        this.dispenserList.clear();
        if (dispensers != null) {
            int numEl = dispensers.length;
            for (int i = 0; i < numEl; i++) {
                this.dispenserList.add(dispensers[i]);
            }
        }
    }
    
    public void addDispenser(Dispenser dispenser) {
	dispenserList.add(dispenser);
    }
}

