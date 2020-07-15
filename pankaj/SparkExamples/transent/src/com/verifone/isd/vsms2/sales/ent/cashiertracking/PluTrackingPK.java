/*
 * PluTrackingPK.java
 *
 * Created on Feb 27, 2006
 */

package com.verifone.isd.vsms2.sales.ent.cashiertracking;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.log4j.*;

/** Primary key class for PluTracking
 * @author "mailto:linda_t1@verifone.com"
 */
public class PluTrackingPK implements IEntityPK {
    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sales.ent.cashiertracking.PluTrackingPK.class);
    private String upcModifier;
    
    /** Creates a new instance of PluTrackingPK */
    public PluTrackingPK() {
    }

    /** Constructor
     * @param upcModifier plu number
     */    
    public PluTrackingPK(String upcModifier) {
        this.upcModifier=upcModifier;
    }
    
    /** Getter for the plu number
     */    
    public String getUpcModifier() {
        return this.upcModifier;
    }
    
    /** Method to compare to PluTrackingPK objects for equality
     * @param obj PluTrackingPK object to be compared against
     * @return true if both primary keys represent the same plu
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof PluTrackingPK) {
            PluTrackingPK pObj = (PluTrackingPK)obj;
		return (this.upcModifier == pObj.upcModifier);
    }
		return false;
	}
    
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof IEntityPK) {
            return this.equals((IEntityPK) obj);
        }
        return false;
    } 
    
    /** Method override since equals() is implemented
     * @return hash code for the object
     */    
    public int hashCode() {
        int hc = 37 * 17;
        return hc + ((this.upcModifier == null) ? 0 : this.upcModifier.hashCode());
    }    
    
    /** Validator for the plu number
     */    
    public boolean isValid() {
		return this.upcModifier == null ? false : true;
	}
	
	/** Provides string representation of the entity ID
	 * @return string representation of the entity ID
	 */
	public String toString() {
		return this.upcModifier;
	}
    
 }
