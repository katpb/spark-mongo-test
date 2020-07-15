package com.verifone.isd.vsms2.sys.db.pres;

/**
 * Interface for "bridge" object between Entity Object and persistent medium.
 * @version 1.0 Copyright(c) 2000-2007 Verifone, All Rights Reserved.
 */
public interface IEntityPersistState {
    /**
     * Logic to convert an IEntityObject (an OO entity object) to
     * an IEntityPersistState object, which knows about database
     * formats, etc.
     * @param obj the entity object to convert.
     * @throws Exception On error in converting to the persistent state.
     */
    public abstract void convertToPS(IEntityObject obj) throws Exception;
    
    /**
     * Logic to convert an IEntityPersistState object into an IEntityObject.
     * @param obj The entity object to load.
     * @throws Exception On error in loading the entity object with persistent state data.
     */
    public abstract void convertToObj(IEntityObject obj) throws Exception;
    
    /**
     * Get the primary key of the entity object.
     * @return Primary key object.
     */
    public IEntityPK getPK();    
    
    /**
     * Set the primary key of the entity object.
     * @param pk Primary key of the entity object.
     */
    public void setPK(IEntityPK pk);        
}
