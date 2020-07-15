package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import com.verifone.isd.vsms2.fuel.ent.FuelEntityVisitor;
import com.verifone.isd.vsms2.fuel.ent.IFuelEntityVisitable;
import com.verifone.isd.vsms2.sys.l10n.FuelViewRes;
import com.verifone.isd.vsms2.sys.l10n.LocalizedRB;
import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 *  Implementation class for the fuel tier entity object.
 *  @author "mailto:bhanu_narayanan@verifone.com"
 */
public class FuelTier implements IFuelEntityVisitable, Serializable {
	private int number = 0;
    private int startHr = 0;
    private int numHrs = 0;
    
    // Change this serialVersionUID if any incompatible changes are made to this class
	private static final long serialVersionUID = -6649948078991140504L;
    
    
    /** Constructor
     * @param startHr tier begin hour
     * @param numHrs number of hours tier is effective
     * @param number the tier ID
     * @exception FuelException if startHr or numHrs is invalid
     */
    public FuelTier(int number, int startHr, int numHrs) throws FuelException {
        this.number = number;
        ArrayList exceptionParams;
        Integer intExceptionParam1;
        Integer intExceptionParam2;

        if ((startHr < 0) || (startHr > 23)) {
            exceptionParams = new ArrayList(2);
            intExceptionParam1 = Integer.valueOf(startHr);
            intExceptionParam2 = Integer.valueOf(number);
            exceptionParams.add(intExceptionParam1);
            exceptionParams.add(intExceptionParam2);
            throw new FuelException(FuelViewRes.ERROR_INVALID_TIER_START, LocalizedRB.FUELVIEW_RESOURCE, exceptionParams);
        }
        if ((numHrs < 0) || (numHrs > 24)) {
            exceptionParams = new ArrayList(2);
            intExceptionParam1 = Integer.valueOf(numHrs);
            intExceptionParam2 = Integer.valueOf(number);
            exceptionParams.add(intExceptionParam1);
            exceptionParams.add(intExceptionParam2);
            throw new FuelException(FuelViewRes.ERROR_INVALID_TIER_HOURS, LocalizedRB.FUELVIEW_RESOURCE, exceptionParams);
        }
        this.startHr = startHr;
        this.numHrs = numHrs;
    }
    
    /** Copy constructor
     * @param orig object to clone from
     */
    public FuelTier(FuelTier orig) {
        this.number = orig.number;
        this.startHr = orig.startHr;  
        this.numHrs = orig.numHrs;        
    }    
    
    /** Getter for ID
     * @return the tier ID
     */
    public int getID() {
        return number;
    }
    
    /** Getter for default tier name for a given ID
     * @param id tier ID
     * @return default tier name
     */    
    public static String getDefaultName(int id) {
        return FuelTierEnum.getNameFromInt(id);
    }
    
    /** Getter for tier begin hour
     * @return the time when the tier goes into effect
     */
    public int getStartHour() {
        return startHr;
    }
    
    /** Getter for tier's number of effective hours
     * @return the number of hours in which the tier is valid
     */
    public int getEffectiveHours() {
        return numHrs;
    }
    
    /** Setter for tier begin hour
     * @param startHr tier begin hour
     * @exception FuelException if startHr is invalid
     */
    public void setStartHour(int startHr) throws FuelException {
        if ((startHr < 0) || (startHr > 23)) {
            ArrayList exceptionParams = new ArrayList(1);
            Integer intExceptionParam = Integer.valueOf(startHr);
            exceptionParams.add(intExceptionParam);
            throw new FuelException(FuelViewRes.ERROR_INVALID_START_TIER, LocalizedRB.FUELVIEW_RESOURCE, exceptionParams);
        }
        this.startHr = startHr;
    }
    
    /** Setter for tier's number of effective hours
     * @param numHrs number of effective hours for the tier
     * @exception FuelException if numHrs is invalid
     */
    public void setEffectiveHours(int numHrs) throws FuelException {
        if ((numHrs < 0) || (numHrs > 24)) {

            ArrayList exceptionParams = new ArrayList(2);
            Integer intExceptionParam1 = Integer.valueOf(numHrs);
            Integer intExceptionParam2 = Integer.valueOf(number);
            exceptionParams.add(intExceptionParam1);
            exceptionParams.add(intExceptionParam2);
            throw new FuelException(FuelViewRes.ERROR_INVALID_TIER_HOURS, LocalizedRB.FUELVIEW_RESOURCE, exceptionParams);
        }
        this.numHrs = numHrs;
        
    }
    
    /** This method calls back into the FuelVisitor#visit() method of the visitor object
     * @param v visitor
     * @exception Exception if the visitor encounters any error during XML serialization/ parsing
     */
    public void accept(FuelEntityVisitor v) throws Exception{
        v.visit(this);
    }
    
    /** Method to compare to FuelTier objects for equality
	 * @param obj FuelTier object to be compared against
	 */    
	public boolean equals(Object obj) {

		 if (this == obj) {
				return true;
			}
			if ((obj == null) || !(obj instanceof FuelTier)) {
				return false;
			}
			FuelTier aTier = (FuelTier) obj;
			
			return new EqualsBuilder().append(this.number, aTier.number)
									  .append(this.startHr, aTier.startHr)
									  .append(this.numHrs, aTier.numHrs)
									  .isEquals();		
	}

	/** Method override since equals() is implemented
	 * @return hash code for the object
	 */    
	public int hashCode() {
		return new HashCodeBuilder(19, 29).append(this.number)
		  .append(this.startHr)
		  .append(this.numHrs)
		  .toHashCode();
	}
}
