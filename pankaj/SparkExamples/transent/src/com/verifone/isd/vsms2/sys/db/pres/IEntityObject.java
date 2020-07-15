package com.verifone.isd.vsms2.sys.db.pres;

import java.io.Serializable;
/**
 * This interface defines the methods specific to entity objects that
 * are persisted thro' the persistence framework. All managed entity
 * objects should hava a unique ID of type IEntityPK.
 * @see IEntityObject
 * @version 1.0 Copyright(c) 2000-2007 Verifone, All Rights Reserved.
 */
public interface IEntityObject extends Serializable
{
    /**
     * Getter of the entity object's primary key.
     * @return The ID of the entity object.
     */
    public IEntityPK getPK();
    
    /**
     * Set the primary key of the entity object.
     * @param pk Primary key for the entity object.
     */    
    public void setPK(IEntityPK pk);
    
    /**
     * Sets the attributes of the new object; this operation is similar to deep
     * cloning.
     * @param obj The target object to be written into.
     */
    public void setAttributes(IEntityObject obj);
     
    /**
     * Method to validate an entity object's attributes.
     * @throws Exception If validation fails
     */
    public void validate() throws Exception;
    
    /**
     * Method to validate the primary key of the entity object.
     * @return true If the primary key of the entity object is valid.
     */
    public boolean isPKValid();
}
