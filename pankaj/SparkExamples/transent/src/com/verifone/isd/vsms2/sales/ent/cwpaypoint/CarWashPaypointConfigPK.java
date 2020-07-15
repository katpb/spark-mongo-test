/*
 * CarWashPaypointConfigPK.java
 *
 * Created on June 6, 2007, 2:39 PM
 */

package com.verifone.isd.vsms2.sales.ent.cwpaypoint;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
/**
 * Primary key class for CarWashPaypointConfig entity
 * @author Aaron_S1
 */
public class CarWashPaypointConfigPK implements IEntityPK {
   
    private int config;
    
    public static final int MAX_CONFIGS = 1;
    /** Creates a new instance of CarWashPaypointConfigPK */
    public CarWashPaypointConfigPK() {
    }
    /** Creates a new instance of CarWashPaypointConfigPK */
    public CarWashPaypointConfigPK(int config) {
        this.config = config;
    }
        
    /** Method to compare two CarWashPaypointConfigPK objects for equality
     * @param obj CarWashPaypointConfigPK object to compared with
     * @return true if both objects represent the same product code value
     */    
    public boolean equals(IEntityPK obj) {
         if (obj instanceof CarWashPaypointConfigPK && this.config == ((CarWashPaypointConfigPK)obj).config) {
            return true;
        }
        return false;
    }

    /** Getter for config number
     * @return config number
     */    
    public int getValue() {
        return config; 
    }


    /** Validator for the product code value
     * @return true if the product code is valid
     */    
    public boolean isValid() {
        return (this.config > 0 && this.config <= MAX_CONFIGS);
    } 
}
