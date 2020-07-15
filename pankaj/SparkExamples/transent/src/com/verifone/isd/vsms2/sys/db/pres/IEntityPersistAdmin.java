package com.verifone.isd.vsms2.sys.db.pres;

import java.util.Date;


/**
 * Interface for admin object to manage a class of object to and from a persistent medium
 * @version 1.0 Copyright(c) 2000-2007 Verifone, All Rights Reserved.
 */
public interface IEntityPersistAdmin {
    /**
     * Register ID for the controller.
     */
    public static final int CONTROLLER_ID = 0;
    public static final int OLD_CONTROLLER_ID = 1;
    /**
     * Submit an entity object (IEntityObject) to the database.
     * @param obj The object to be committed (not typesafe).
     * @exception Exception Thrown on error in the store.
     */
    public void store(IEntityObject obj) throws Exception;

 
    /**
     * Submit a set of entity objects to the database.
     * @param objs Is the set to be committed (not typesafe).
     * @exception Exception Thrown on error in the store.
     */
    public void store(IEntityObject[] objs) throws Exception;

    /**
     * Ask for an entity object (IEntityObject) from the database.
     * @param objContainKey The object to be retrieved (probably only the key
     * field set, not typesafe) and overloaded on success.
     * @exception Exception Thrown on error in the retrieve.
     */
    public void retrieve(IEntityObject objContainKey) throws Exception;

    /**
     * Ask for all entity objects (IEntityObject) from a database table.
     * @return an array of IEntityObject
     * @exception Exception thrown on error in the retrieve
     */
    public IEntityObject[] retrieve() throws Exception;

    /**
     * Ask for a set entity objects (IEntityObject) from the database.
     * @param objContainKey The parameter for objects to be retrieved.
     * @exception Exception Thrown on error in the retrieve.
     */
    public IEntityObject[] retrieveSet(IEntityObject objContainKey) throws Exception;

    /**
     * Ask for an entity object (IEntityObject) to be deleted from from the database.
     * @param objContainKey the object to be deleted (may have only the key field set,
     * not typesafe).
     * @exception Exception Thrown on error in the delete.
     */
    public void delete(IEntityObject objContainKey) throws Exception;

    /**
     * Ask for the table's data store to be emptied.
     * @exception Exception Thrown on error in the delete.
     */
    public void empty() throws Exception;

    /**
     * Start a session. All subsequent changes will be committed to the
     * persistant store on a subsequent commit().
     * @exception Exception Thrown on error (e.g., if multiple concurrent sessions
     * are not allowed).
     */
    public void savePoint() throws Exception;

    /**
     * End a session. All changes from the start of the session
     * will be committed to the persistant store.
     * @exception Exception Thrown on error in committing changes.
     */
    public void commit() throws Exception;

    /**
     * Undo a session. All changes from the start of the session will be lost.
     * @exception Exception Thrown on error in committing changes.
     */
    public void rollBack() throws Exception;

    /**
     * Synchronize the data set with the persistant store.
     * @exception Exception On error in processing the synchronize request.
     */
    public void synchronize() throws Exception;

    /**
     * Synchronize the data set with the persistant store.
     * @param processOnlyEmpty True if processing required only for empty dataset.
     * @exception Exception On error in processing the synchronize request.
     */
    public void synchronize(boolean processOnlyEmpty) throws Exception;

    /**
     * Helper function to determine if the data set needs to be
     * synchronized with the persistent store.
     * @return String dataset name.
     * @throws Exception On error in retrieveing the timestamp.
     */
    public Date getTimeStamp() throws Exception;

    /**
     * Get the dataset's name.
     * @return The dataset's name.
     */
    public String getEntityName();

    /**
     * Control preload operation from secondary persist store if
     * the primary store is empty.
     * @param isTrue True if preload is required.
     */
    public void setPreloadRequired(boolean isTrue);

    /**
     * Control preload operation from secondary persist store if the primary
     * store is empty.
     * @return True if preload is enabled.
     */
    public boolean isPreloadRequired();

    /**
     * Initiate preload operation; based on the preload bean, the
     * implementation should control this operation based on preload bean
     * @throws UnsupportedEntityException If a persist admin is not mapped to the entity.
     * @return True if preload was performed.
     */
    public boolean preLoad() throws UnsupportedEntityException;

    /**
     * Get the record count for the entity
     * @return The number of records in the entity's persist store.
     * @throws Exception On error in retrieving record count.
     */
    public int getRecordCount() throws Exception;

    /**
     * Set the response wait time. Actual usage of this value
     * depends on the persist store. For example, if Gempro is
     * the persist store, socket timeouts are determined based
     * on this value. For DB as persist store, this value could
     * determine the amount of time the persist admin waits to
     * get a connection from the pool.
     * @param waitTime Response wait time in millis.
     */
    public void setTimeOut(int waitTime);
    
    public String getTableName() throws Exception; 
    
	default public String[] getNestedTables() throws Exception {
		 return new String[0];		
	}
   
}
