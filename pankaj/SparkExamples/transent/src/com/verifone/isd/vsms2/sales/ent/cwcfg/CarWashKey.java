package com.verifone.isd.vsms2.sales.ent.cwcfg;

import java.io.Serializable;

import com.verifone.isd.vsms2.sales.ent.plu.PluPK;

/**
 *  entity class for CarWashKey
 *
 *  @author "mailto:mike_reese@verifone.com"
 *  @version 1.0 Copyright(c) 2003 VeriFone, Inc., All Rights Reserved
 */
public class CarWashKey implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 3136290378495954493L;

	/**
     * Maximum number of car wash keys
     */    
    public static final int MAX_CARWASHKEYS = 14;

    private int ID;
    private PluPK plu;
    private boolean isOutDoorEnabled;
    
    /**
     * Constructor
     * @param ID Car wash key number
     */    
    public CarWashKey(int ID) {
        this.ID = ID;
    }

    /**
     * No-args constructor
     */    
    public CarWashKey() {
    }

    /**
     * Getter for ID property
     * @return car wash key number
     */    
    public int getID() {
        return this.ID;
    }
    
    /**
     * Setter for ID property
     * @param ID car wash key number
     */    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    /**
     * Getter for PLU property
     * @return PluPK object
     */    
    public PluPK getPLU() {
        return plu;
    }
    
    /**
     * Setter for PLU property
     * @param plu PluPK object
     */    
    public void setPLU(PluPK plu) {
        this.plu = plu;
    }

    /**
     * Getter for outDoorEnabled property
     * @return true if this car wash can be sold at the pump
     */    
    public boolean isOutDoorEnabled() {
        return this.isOutDoorEnabled;
    }
    
    /**
     * Setter for outDoorEnabled property
     * @param isTrue if true, this car wash can be sold at the pump
     */    
    public void setOutDoorEnabled(boolean isTrue) {
        this.isOutDoorEnabled = isTrue;
    }
                       
    /**
     * Validator for the entitie's attributes
     * @throws Exception if validation fails
     */    
    public void validate() throws Exception {
        if ((this.ID <= 0) || (this.ID > MAX_CARWASHKEYS))
            throw new Exception("Invalid CarWashKey ID: " + this.ID);
    }
}