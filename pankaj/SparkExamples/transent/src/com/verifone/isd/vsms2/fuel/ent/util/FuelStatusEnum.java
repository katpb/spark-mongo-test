/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.verifone.isd.vsms2.fuel.ent.util;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * This enumeration represents true pump states returned by the dispenser.
 * @author kelvin_f1
 */
public enum FuelStatusEnum {

    /**
     * Dispenser is in the Offline State
     */
    OFFLINE('0', 0, false, false,true,false),
    /**
     * Dispenser is idle and the handle is switch is off
     */
    IDLEOFF('1', 1, true, false,true),
    /**
     * Dispenser is authorized the switch is on / handle is removed / dispensing fuel.
     */
    BUSYON('2', 2, false, false, false),
    /**
     * The transaction is complete.
     */
    EOT('3', 3, false, false, false),
    /**
     * The dispenser is idle the switch is on / handle is removed / calling.
     */
    IDLEON('5', 5, true, false,false),
    /**
     * Dispenser is closed.
     * Currently, this state is maintained only in the Runtime layer
     * and not coming from the Driver/Pump. So we are assuming that
     * this is not a actual pump state. If this changes and we get this
     * state from the Driver/pump we need to re-visit the existing logic
     * for handling closed state in Fuel Runtime layer.
     */
    CLOSED('6', 6, false, true,true, false),
    /**
     * Dispensing has been stopped.
     */
    STOP('8', 8, false, false,false),
    /**
     * The dispenser is authorized and switch is off / handle not removed.
     */
    BUSYOFF('9', 9, false, false,false),
    /**
     * The dispenser is calling while being initialized price / fuel.
     */
    PUMPINITCALL(':', 11, false, false,false),
    /**
     * The dispenser is idle while being initialized price / fuel.
     */
    PUMPINITIDLE(';', 10, false, false,true),
    /**
     * The dispenser is calling after initialization is complete price / fuel.
     */
    PUMPINITCALLCOMPLETE('<', 12, false, false,false),
    
    /**
	 *This enum is used to represent an Error state 
     */
    ERROR('E', 7, false, false,true, false),
    
    /**
     * This enum is used to represent the Runtime State Uninitialized which is used when
     * the fuelsite/prices is being initialized to prevent any actions at the site
     */
     UNINITIALIZED('U', 6, false, true,true, false),
    
    /**
     * This enum is used to represent the Runtime State Reserved which is used to prevent
     * other POSes from trying to authorize a pump that is already being authorized by a POS
     */
     RESERVED('R', 14, false, true,false),
     
     /**
      * This enum is used to represent the Runtime State Reserved_Calling,which is used
      * to represent the State when a Pump Handle is raised after it has been reserved by DCR
      * This state will be used to prevent cashier from approving a pump for a postpay
      * when DCR transaction is in progress that is already being authorized by a POS.
      */
      RESERVEDCALLING('C', 15, false, true,false),
    
    /**
     * This enum is used to represent the runtime state DCRIDLEON,the Runtime transitions
     * to this state when the DCR Pay Inside Key is pressed 
     */
    DCRIDLEON('D', 5, true, true,false),
    
    /**
     * This enum is used to represent the runtime state PTHOLD, runtime transitions to this state
     * when the Pump reports IDLEON(when some one lifts the handle) , but the handle up calling is
     * disabled. 
     */
    PTHOLD('P', 13, true, true,false);
    
    private char statusValue;
    private int numericValue;
    private boolean reserveAllowed;
    private boolean nonPumpState;
    private boolean driverInitAllowed;
    private boolean isOnlineStatus;

    private static final Map<Character, FuelStatusEnum> lookup
          = new HashMap<Character,FuelStatusEnum>();


    static {
          for(FuelStatusEnum s : EnumSet.allOf(FuelStatusEnum.class))
               lookup.put(s.getFuelStatusValue(), s);
     }

    private FuelStatusEnum (char statusValue, int numericValue, boolean reserveAllowed, boolean nonPumpState, boolean driverInitAllowed){
        this.statusValue = statusValue;
        this.numericValue = numericValue;
        this.reserveAllowed = reserveAllowed;
        this.nonPumpState = nonPumpState;
        this.driverInitAllowed = driverInitAllowed;
        this.isOnlineStatus = true;
    }
    
    private FuelStatusEnum (char statusValue, int numericValue, boolean reserveAllowed, boolean nonPumpState,
    		boolean driverInitAllowed, boolean isOnlineState){
        this.statusValue = statusValue;
        this.numericValue = numericValue;
        this.reserveAllowed = reserveAllowed;
        this.nonPumpState = nonPumpState;
        this.driverInitAllowed = driverInitAllowed;
        this.isOnlineStatus = isOnlineState;
    }

    /**
     * get the character / dispenser representation for a specific dispenser state.
     * @return - the character / dispenser representation for a specific dispenser state.
     */
    public char getFuelStatusValue(){
        return statusValue;
    }

    /**
     * get the fuel state enumeration for a specific dispenser / character state.
     * @param statusValue - the character / dispenser representation for a specific dispenser state.
     * @return - the dispenser enumeration for a specific state.
     */
    public static FuelStatusEnum getFuelStatusEnum(char statusValue) {
        return lookup.get(statusValue);
    }

    public int getFuelStatusNumericValue() {
        return this.numericValue;
    }
    
    public boolean isReserveAllowed() {
    	return reserveAllowed;
    }
    
    public boolean isDriverInitAllowed() {
    	return driverInitAllowed;
    }
    
    public boolean isNonPumpState() {
    	return this.nonPumpState;
    }

	/**
	 * @return the isOnlineStatus
	 */
	public boolean isOnlineStatus() {
		return isOnlineStatus;
	}
    
}

