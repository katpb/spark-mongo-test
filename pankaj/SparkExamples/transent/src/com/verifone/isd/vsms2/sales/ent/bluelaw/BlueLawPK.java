/*
 * BlueLawPK.java
 *
 * Created on April 1, 2003, 5:39 PM
 */
package com.verifone.isd.vsms2.sales.ent.bluelaw;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.log4j.*;
/** Primary key class for BlueLaw
 * @author "mailto:bhanu_n2@verifone.com"
 * @version 1.0
 */
public class BlueLawPK implements IEntityPK {
    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sales.ent.bluelaw.BlueLawPK.class);
    static final long serialVersionUID = -7530059168402884506L;
    private int blNr;

    /** No-args constructor */    
    public BlueLawPK() {
    }

    /** Constructor
     * @param blNr blue law number
     */    
    public BlueLawPK(int blNr) {
        this.blNr = blNr;
    }
    
    /** Getter for the blue law number
     * @return blue law number
     */    
    public int getValue() {
        return this.blNr;
    }
    
    /** Method to compare two blue law primary keys
     * @param obj bluelaw primary key to be compared
     * @return true if the blue law number is the same as this object
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof BlueLawPK) {
            BlueLawPK cObj = (BlueLawPK)obj;
            return (this.blNr == cObj.blNr);
        }
        return false;
    }

    /** Method to compare an object with 'this'
     * @param obj object to be compared
     * @return true if the object passed in is an equivalent
     * instance of BlueLawPK
     */    
    public boolean equals(Object obj) {
        if (obj instanceof BlueLawPK) {
            BlueLawPK cObj = (BlueLawPK)obj;
            return (this.blNr == cObj.blNr);
        }
        return false;
    }
    
    /** Method override since equals() is implemented
     * @return hash code for the object
     */
    public int hashCode() {
        int hc = 37 * 17;
        return (hc + this.blNr);
    }
    
    /** Validates the blue law id
     * @return true if the blue law id is valid
     */    
    public boolean isValid() {
        return ((this.blNr > 0) && (this.blNr <= BlueLaw.MAX_BLUELAWS));
    }   

    /*
     * Helper method to convert the primary key to a string
     */
    /** Getter for string representation of the entity PK
     * @return string representation of the entity PK
     */    
    public String toString() {
        return String.valueOf(this.blNr);
    }        
}
