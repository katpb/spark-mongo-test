/*
 * BannerPK.java
 *
 * Created on April 1, 2003, 5:39 PM
 */

package com.verifone.isd.vsms2.sales.ent.banner;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPersistAdmin;
import com.verifone.isd.vsms2.sys.db.pres.IRegisterEntityPK;
/** Primary key class for Banner
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class BannerPK implements IRegisterEntityPK {
    static final long serialVersionUID = 4113680002236614453L;
   
    private int registerNum;
    private int lineNr;
    
    
    /** Creates a new instance of BannerPK */
    public BannerPK() {
    }

    /** Constructor
     * @param registerNum register number
     * @param lineNr banner number
     */    
    public BannerPK(int lineNr, int registerNum) {
        this.lineNr = lineNr;
        if(registerNum == IEntityPersistAdmin.OLD_CONTROLLER_ID)
        {
        	this.registerNum = IEntityPersistAdmin.CONTROLLER_ID;
        }else{
        	this.registerNum = registerNum;
        }        
    }

    /** Constructor
     * @param lineNr banner number
     */    
    public BannerPK(int lineNr) {
        this.lineNr = lineNr;
    }
    
    /** Getter for the banner number
     * @return banner number
     */    
    public int getValue() {
        return this.lineNr;
    }
    
    /** Method to compare to BannerPK objects for equality
     * @param obj BannerPK object to be compared against
     * @return true if both primary keys represent the same banner
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof BannerPK) {
            BannerPK lObj = (BannerPK)obj;
            return (this.registerNum == lObj.registerNum && this.lineNr == lObj.lineNr);
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
        int hc = 17;
        hc = 37 * hc + this.lineNr;
        hc = 37 * hc + this.registerNum;
        return hc;
    }
    
    /** Validator for the banner number
     * @return true if the banner number is valid
     */    
    public boolean isValid() {
        return ((this.registerNum >= IEntityPersistAdmin.CONTROLLER_ID) && 
        (this.lineNr > 0) && (this.lineNr <= Banner.MAX_BANNERS));
    }    
    
    /*
     * Helper method to convert the primary key to a string
     */
    /** Getter for string representation of the entity PK
     * @return string representation of the entity PK
     */    
    public String toString() {
        return String.valueOf(this.registerNum +"-" +this.lineNr);
    }    
    
    /** Get the register id for the entity
     * @return regId register assigned for the entity
     */
    public int getRegisterId() {
        return this.registerNum;
    }
    
    /** Set the register id for the entity
     * @param regId register assigned for the entity
     */
    public void setRegisterId(int regId) {
    	if(regId == IEntityPersistAdmin.OLD_CONTROLLER_ID)
        {
        	this.registerNum = IEntityPersistAdmin.CONTROLLER_ID;
        }else{
        	this.registerNum = regId;
        }
    }
    
}
