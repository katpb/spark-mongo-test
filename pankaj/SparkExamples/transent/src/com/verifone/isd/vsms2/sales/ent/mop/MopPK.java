/**
 * MopPK.java
 *
 * Created on April 1, 2003, 5:39 PM
 */

package com.verifone.isd.vsms2.sales.ent.mop;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Primary key class for Mop.
 * 
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class MopPK implements IEntityPK {
    
    /** The Constant serialVersionUID. */
    static final long serialVersionUID = -4380077982571000200L;
    
    /** The mop nr. */
    private int mopNr;
    
    /** Creates a new instance of MopPK */
    public MopPK() {
    }

    /** Constructor
     * @param mopNr Mop number
     */    
    public MopPK(int mopNr) {
        this.mopNr = mopNr;
    }
    
    /**
	 * Getter for Mop number.
	 * 
	 * @return Mop number
	 */    
    public int getValue() {
        return this.mopNr;
    }

    /** Setter for property value.
     * @param value New value of property value.
     */
    public void setValue(int value) {
        this.mopNr = value;
    }
    
    /** Method to compare two MopPK objects for equality
     * @param obj object to compare with
     * @return true if the current and compared objects represent the same Mop number
     */    
    @Override
	public boolean equals(IEntityPK obj) {
        if (obj instanceof MopPK) {
            MopPK mObj = (MopPK)obj;
            return (this.mopNr == mObj.mopNr);
        }
        return false;
    }
    
    @Override
	public boolean equals(Object obj) {
        if ((obj != null) && (obj instanceof IEntityPK)) {
            return this.equals((IEntityPK) obj);
        }
        return false;
    } 
    
    /** Method override since equals() is implemented
     * @return hash code for the object
     */   
    @Override
	public int hashCode() {
        int hc = 37 * 17;
        return (hc + this.mopNr);
    }
    
    /** Returns the objects string representation
     * @return string representation of the Mop number
     */    
    @Override
	public String toString() {
        return String.valueOf(this.mopNr);
    }
    
     /**
		 * Method to valiate the Mop number.
		 * 
		 * @return true if the Mop number is valid
		 */    
    @Override
	public boolean isValid() {
        return ((this.mopNr > 0) && (this.mopNr <= Mop.MAX_MOPS));
    }
}
