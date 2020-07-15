/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 *
 * @author kelvin_f1
 */
public class BlendTank implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 8043304841405407158L;
	
	private int tankNumber = 0;
    private int blendPercent = 0;

    /**
     * @return the tankNumber
     */
    public int getTankNumber() {
        return tankNumber;
    }

    /**
     * @param tankNumber the tankNumber to set
     */
    public void setTankNumber(int tankNumber) {
        this.tankNumber = tankNumber;
    }

    /**
     * @return the blendPercent
     */
    public int getBlendPercent() {
        return blendPercent;
    }

    /**
     * @param blendPercent the blendPercent to set
     */
    public void setBlendPercent(int blendPercent) {
        this.blendPercent = blendPercent;
    }
    
    /** Method to compare to BlendTank objects for equality
	 * @param obj BlendTank object to be compared against
	 */    
	public boolean equals(Object obj) {

		 if (this == obj) {
				return true;
			}
			if ((obj == null) || !(obj instanceof BlendTank)) {
				return false;
			}
			BlendTank aTank = (BlendTank) obj;
			
			return new EqualsBuilder().append(this.tankNumber, aTank.tankNumber)
									  .append(this.blendPercent, aTank.blendPercent)
									  .isEquals();		
	}

	/** Method override since equals() is implemented
	 * @return hash code for the object
	 */    
	public int hashCode() {
		return new HashCodeBuilder(19, 29).append(this.tankNumber)
		  .append(this.blendPercent)
		  .toHashCode();
	}


}
