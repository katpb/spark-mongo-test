/*
 * DetailedStatus.java
 *
 * Created on February 26, 2003, 9:45 PM
 */

package com.verifone.isd.vsms2.fuel.ent.util;

import java.io.Serializable;

import com.verifone.isd.vsms2.fuel.ent.fuelSite.FuelTransaction;

/**
 *
 * @author  D. Michael Barton
 */
public class DetailedStatus implements Serializable {
    
    static final long VersionUID = 389702992210938559L;
    
    private short fuelingPosition = 0;
    private Status status = null;
    private FuelTransaction currentTxn = null;
    private FuelTransaction stackedTxn = null;
    
    /** Creates a new instance of DetailedStatus with fueling position set to 0 */
    public DetailedStatus() {
    }
 
    /**
     * Constructor
     * Creates new instance of DetailedStatus for fuelingPosition 
     * @param fuelingPosition
     */
    public DetailedStatus(short fuelingPosition) {
        
        setFuelingPosition(fuelingPosition);
        setStatus(new Status(fuelingPosition));
        setCurrentTransaction(new FuelTransaction());
        setStackedTransaction(new FuelTransaction());
    }
 
    /**
     * Constructor
     * @param fuelingPosition
     * @param state
     * @param currentTransaction
     * @param stackedTransaction
     */
    public DetailedStatus(short fuelingPosition, FuelStatusEnum state, FuelTransaction currentTransaction, FuelTransaction stackedTransaction) {
        setFuelingPosition(fuelingPosition);
        Status status = new Status();
        status.setFuelingPosition(fuelingPosition);
        status.setPumpState(state);
        setStatus(status);
        setCurrentTransaction(currentTransaction);
        setStackedTransaction(stackedTransaction);
    }
    
    /**
     * Getter for fueling position
     * @return short
     */
    public short getFuelingPosition() {
        return(this.fuelingPosition);
    }
    
    /**
     * Setter for Fueling position
     * @param fuelingPosition
     */
    public void setFuelingPosition(short fuelingPosition) {
        this.fuelingPosition = fuelingPosition;
    }
 
    /**
     * Getter for status
     * @return Status
     */
    public Status getStatus() {
        return(this.status);
    }
    
    /**
     * Setter for status
     * @param fuelingPosition
     */
    public void setStatus(Status aStatus) {
        this.status = aStatus;
    }

    /**
     * Getter for "current transaction"
     * @return FuelTransaction
     */
    public FuelTransaction getCurrentTransaction() {
        return(currentTxn);
    }

    /**
     * Setter for "current transaction"
     * @param currentTransaction
     */
    public void setCurrentTransaction(FuelTransaction currentTransaction) {
        this.currentTxn = currentTransaction;
    }
     
    /**
     * Getter for "stacked transaction"
     * @return FuelTransaction
     */
    public FuelTransaction getStackedTransaction() {
        return(stackedTxn);
    }

    /**
     * Setter for "stacked trasaction"
     * @param stackedTransaction
     */
    public void setStackedTransaction(FuelTransaction stackedTransaction) {
        this.stackedTxn = stackedTransaction;
    }
}
