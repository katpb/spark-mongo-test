/*
 * IChainedEntityPersistAdmin.java
 *
 * Created on May 20, 2003, 6:29 PM
 */

package com.verifone.isd.vsms2.sys.db.pres;

/**
 * It is possible for an entity to be persisted in multiple
 * persist stores. In such cases one has to be identified as
 * the master store. This interface provides a mechanism for
 * persist admins to be chained. No external client will ever
 * use this interface directly.
 * @version 1.0 Copyright(c) 2000-2007 Verifone, All Rights Reserved.
 */
public interface IChainedEntityPersistAdmin {
    /**
     * Set the secondary persist admin for a persist admin.
     * @param secPA Secondary persist admin.
     */
    public void setSecondaryPersistAdmin (IEntityPersistAdmin secPA);
    
    /**
     * Set the primary persist admin for this entity.
     * @param priPA Primary persist admin.
     */    
    public void setPrimaryPersistAdmin (IEntityPersistAdmin priPA);
    
    /**
     * Get the secondary persist admin for a persist admin.
     * @return secPA Secondary persist admin.
     */
    public IEntityPersistAdmin getSecondaryPersistAdmin();
    
    /**
     * Get the primary persist admin for this entity.
     * @return Primary persist admin.
     */    
    public IEntityPersistAdmin getPrimaryPersistAdmin ();
    
    /**
     * Provide a way to notify a persist admin of changes done on
     * another persist admin in the chain as a result of sync request
     * (e.g., from Gempro). Note that this method will not be used
     * for regular updates that occur thro' the primary persist
     * admin.  The primary persist admin may request the secondary
     * persist admin to clear its local entity collection.
     * @param registerID Register ID for the request.
     * @param chainedPA The chained persist admin that has handled changes.
     */
    public void processChainedSyncEvent(final IEntityPersistAdmin chainedPA, int registerID);
    
    /**
     * Provide a way for a primary persist admin to request the secondary
     * persist admin to clear its local entity collection (if it has one).
     * This method will be used only by a primary persist admin object on 
     * a chained secondary persist admin. 
     */
    public void clearLocalEntityColl();    
}
