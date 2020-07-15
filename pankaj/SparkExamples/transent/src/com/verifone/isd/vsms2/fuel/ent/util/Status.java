/*
 * Status.java
 *
 * Created on February 26, 2003, 9:45 PM
 */

package com.verifone.isd.vsms2.fuel.ent.util;

import java.io.Serializable;

import com.verifone.isd.vsms2.fuel.ent.util.FuelStatusEnum;
import com.verifone.isd.vsms2.fuel.ent.fuelSite.FuelMOP;
import com.verifone.isd.vsms2.fuel.ent.fuelSite.FuelServiceLevel;

/**
 *
 * @author  D. Michael Barton
 */
public class Status implements Serializable {
    
//    static final long VersionUID = 6153504297287177998L;
    static final long VersionUID = -779862893876067864L;
    
    private short fuelingPosition = 0;
    private FuelStatusEnum pumpState = FuelStatusEnum.UNINITIALIZED;
	private boolean prepayInProgress = false;
	private boolean viewBuzzer;
	private FuelMOP mop;
	private FuelServiceLevel serviceLevel;

    
    /** Creates a new instance of Status */
    public Status() {
    	  this.viewBuzzer = true;   
    }
 
    public Status(short aFuelingPosition) {

       this.fuelingPosition = aFuelingPosition;
        
      
    }
    
    
   
    /**
     *  
     * @return
     */
    public short getFuelingPosition() {
        return(this.fuelingPosition);
    }
    
    /**
     * 
     * @param fuelingPosition
     */
    public void setFuelingPosition(short fuelingPosition) {
        this.fuelingPosition = fuelingPosition;
    }

    /**
     * 
     * @return
     */
    public boolean getPrepayInProgress() {
        return(prepayInProgress);
    }
    /**
     * 
     * @param prepayInProgress
     */
    public void setPrepayInProgress(boolean prepayInProgress) {
        this.prepayInProgress = prepayInProgress;
    }

    /**
     * 
     * @return
     */
	public boolean isViewBuzzerOff() {
		return (viewBuzzer == false);
	}
	/**
	 * 
	 * @return
	 */
	public boolean isViewBuzzerOn() {
		return (viewBuzzer == true);
	}
	/**
	 * 
	 * @return
	 */
	public FuelMOP getMop() {
		return mop;
	}
	
	/**
	 * @return the serviceLevel
	 */
	public FuelServiceLevel getServiceLevel() {
		return serviceLevel;
	}
	/**
	 * 
	 * @param viewBuzzer
	 */
	public void setViewBuzzer(boolean viewBuzzer) {
		this.viewBuzzer = viewBuzzer;
	}

	/**
	 * 
	 * @param mop
	 */
	public void setMop(FuelMOP mop) {
		this.mop = mop;
	}

	/**
	 * @param serviceLevel the serviceLevel to set
	 */
	public void setServiceLevel(FuelServiceLevel serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	/**
	 * @param pumpState the pumpState to set
	 */
	public void setPumpState(FuelStatusEnum pumpState) {
		this.pumpState = pumpState;
	}

	/**
	 * @return the pumpState
	 */
	public FuelStatusEnum getPumpState() {
		return (pumpState == null) ? FuelStatusEnum.OFFLINE : pumpState;
	}

	

	
}
