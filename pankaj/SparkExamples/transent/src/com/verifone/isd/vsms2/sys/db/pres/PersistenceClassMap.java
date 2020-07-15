/*
 * PersistenceClassMap.java
 *
 * Created on March 13, 2003, 2:13 PM
 */

package com.verifone.isd.vsms2.sys.db.pres;

/**
 * Helper class that provides class map for a given entity object.
 * @version 1.0 Copyright(c) 2000-2007 Verifone, All Rights Reserved.
 */
public class PersistenceClassMap {
    private int entityId;
    private String entityName;
    private String entity;
    private String entityPK;
    private String priPersistAdmin;
    private String secPersistAdmin;
    private int primaryPATimeOut;
    private int secondaryPATimeOut;    
    /**
     * Holds value of property preloadPrimaryPA.
     */
    private boolean preloadPrimaryPA;
    
    /**
     * Holds value of property preloadPrimaryPA.
     */
    private boolean replicationRequired;    
    
    /**
     * Creates a new instance of PersistenceClassMap
     * @param entityId The entity ID to be set.
     * @param entityName The entity name to be set.
     */
    PersistenceClassMap(int entityId, String entityName) {
        this.entityId = entityId;
        this.entityName = entityName;
    }
    
    /**
     * Getter for property entityId.
     * @return Value of property entityId.
     */
    public int getEntityId() {
        return entityId;
    }    
    
    /**
     * Setter for property entityId.
     * @param entityId New value of property entityId.
     */
    void setEntityId(int entityId) {
        this.entityId = entityId;
    }
    
    /**
     * Getter for property entityName.
     * @return Value of property entityName.
     */
    public String getEntityName() {
        return entityName;
    }    
    
    /**
     * Setter for property entityName.
     * @param entityName New value of property entityName.
     */
    void setEntityName(String entityName) {
        this.entityName = entityName;
    }
    
    /**
     * Getter for property entity.
     * @return Value of property entity.
     */
    public String getEntityClassName() {
        return entity;
    }
    
    /**
     * Setter for property entity.
     * @param entity New value of property entity.
     */
    void setEntityClassName(String entity) {
        this.entity = entity;
    }
    
    /**
     * Getter for property entityPK.
     * @return Value of property entityPK.
     */
    public String getEntityPKClassName() {
        return entityPK;
    }
    
    /**
     * Setter for property entityPK.
     * @param entityPK New value of property entityPK.
     */
    void setEntityPKClassName(String entityPK) {
        this.entityPK = entityPK;
    }
    
    /**
     * Getter for property primary persistAdmin.
     * @return Value of property primary persistAdmin.
     */
    public String getPrimaryPAClassName() {
        return priPersistAdmin;
    }
    
    /**
     * Setter for property primary persistAdmin.
     * @param persistAdmin New value of property primary persistAdmin.
     */
    void setPrimaryPAClassName(String persistAdmin) {
        this.priPersistAdmin = persistAdmin;
    }
    
    /**
     * Getter for property secondary persistAdmin.
     * @return Value of property secondary persistAdmin.
     */
    public String getSecondaryPAClassName() {
        return secPersistAdmin;
    }
    
    /**
     * Setter for property secondary persistAdmin.
     * @param persistAdmin New value of property secondary persistAdmin.
     */
    void setSecondaryPAClassName(String persistAdmin) {
        this.secPersistAdmin = persistAdmin;
    }
 
    
    /**
     * Getter for property preloadPrimaryPA.
     * @return Value of property preloadPrimaryPA.
     */
    public boolean isPreloadPrimaryPA() {
        return this.preloadPrimaryPA;
    }
    
    /**
     * Setter for property preloadPrimaryPA.
     * @param preloadPrimaryPA New value of property preloadPrimaryPA.
     */
    void setPreloadPrimaryPA(boolean preloadPrimaryPA) {
        this.preloadPrimaryPA = preloadPrimaryPA;
    }
    

    /**
     * Getter for primary persist admin operation timeout
     * @return timeout value
     */
    public int getPrimaryPATimeOut() {
        return this.primaryPATimeOut;
    }

    /**
     * Setter for primary persist admin operation timeout
     * @param responseWaitTime timeout for operations on the persist admin
     */
    public void setPrimaryPATimeOut(int responseWaitTime) {
        this.primaryPATimeOut = responseWaitTime;
    }
    
    /**
     * Getter for secondary persist admin operation timeout
     * @return timeout value
     */
    public int getSecondaryPATimeOut() {
        return this.secondaryPATimeOut;
    }

    /**
     * Setter for secondary persist admin operation timeout
     * @param responseWaitTime timeout for operations on the persist admin
     */
    public void setSecondaryPATimeOut(int responseWaitTime) {
        this.secondaryPATimeOut = responseWaitTime;
    }

    /**
     * Getter to determine if proprietary replication module has to be notified
     * when changes are made to the entity 
     * @return true if proprietary replication module has to be invoked
     */
    public boolean isReplicationRequired() {
        return replicationRequired;
    }

    /**
     * Getter to determine if proprietary replication module has to be notified
     * when changes are made to the entity 
     * @param replicationRequired true if proprietary replication module has 
     * to be invoked
     */
    public void setReplicationRequired(boolean replicationRequired) {
        this.replicationRequired = replicationRequired;
    }
}
