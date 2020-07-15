/*
 * PeriodDelay.java
 *
 * Created on September 13, 2005, 12:56 PM
 */

package com.verifone.isd.vsms2.sys.ent.report;

import java.io.Serializable;

/**
 *
 * @author  bhanu_n2
 */
public class PeriodDuration implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -7649692526897768390L;

	/**
     * Holds value of property durationType.
     */
    private PeriodDurationType durationType;
    
    /**
     * Holds value of property value.
     */
    private int value;
    
    /** Creates a new instance of PeriodDelay */
    public PeriodDuration() {
    }
    
    /**
     * Getter for property durationType.
     * @return Value of property durationType.
     */
    public PeriodDurationType getDurationType() {
        return (this.durationType == null) ? PeriodDurationType.HOUR : this.durationType;
    }
    
    /**
     * Setter for property durationType.
     * @param durationType New value of property durationType.
     */
    public void setDurationType(PeriodDurationType durationType) {
        this.durationType = durationType;
    }
    
    /**
     * Getter for property value.
     * @return Value of property value.
     */
    public int getValue() {
        return this.value;
    }
    
    /**
     * Setter for property value.
     * @param value New value of property value.
     */
    public void setValue(int value) {
        this.value = value;
    }
    
    public int getDurationHours() {
        return this.value * this.getDurationType().getHourMultiplier();
    }
}
