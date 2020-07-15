/*
 * DueSale.java
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
public class DueSale implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -6667109855477950128L;

    private short fuelingPosition = 0;
    private FuelTransaction curTxn = null;
    private FuelTransaction stkTxn = null;
    
    public DueSale(short fuelingPosition) {
    	this.fuelingPosition = fuelingPosition;
    }
    
    public DueSale(short fuelingPosition, FuelTransaction currentTransaction, FuelTransaction stackedTransaction) {
        setFuelingPosition(fuelingPosition);
        setCurrentTransaction(currentTransaction);
        setStackedTransaction(stackedTransaction);
    }
    
    public short getFuelingPosition() {
        return(this.fuelingPosition);
    }
    public void setFuelingPosition(short fuelingPosition) {
        this.fuelingPosition = fuelingPosition;
    }
 
    public FuelTransaction getCurrentTransaction() {
        return(curTxn);
    }

    public void setCurrentTransaction(FuelTransaction txn) {
        
            this.curTxn = txn;
        
    }
 
    public FuelTransaction getStackedTransaction() {
        return(stkTxn);
    }

    public void setStackedTransaction(FuelTransaction txn) {
       
            this.stkTxn = txn;
        
    }
}
