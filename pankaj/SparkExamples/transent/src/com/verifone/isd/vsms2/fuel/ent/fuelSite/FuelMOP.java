package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.verifone.isd.vsms2.fuel.ent.FuelEntityVisitor;
import com.verifone.isd.vsms2.fuel.ent.IFuelEntityVisitable;

/**
 *  Implementation class for the fuel MOP entity object.
 *  @author "mailto:bhanu_narayanan@verifone.com"
 */
public class FuelMOP implements IFuelEntityVisitable, Serializable {
	private int number = 0;
    private String name = null;
    
    // Change this serialVersionUID if any incompatible changes are made to this class
	private static final long serialVersionUID = 1963520328071375935L;
    
    /** Constructor
     * @param number the MOP ID
     * @param name the MOP name
     */
    public FuelMOP(int number, String name) {
        this.number = number;
        this.name = name;
    }
    
    /** Copy constructor
     * @param orig object to clone from
     */
    public FuelMOP(FuelMOP orig) {
        this.number = orig.number;
        this.name = orig.name;        
    }
    
    /** Getter for ID
     * @return the MOP ID
     */
    public int getID() {
        return number;
    }
    
    /** Getter for name
     * @return the MOP name
     */
    public String getName() {
        return name;
    }
    
    /** Getter for default Fuel MOP name for a given ID
     * @param id MOP ID
     * @return default name for the fuel mop
     */    
    public static String getDefaultName(int id) {
        return FuelMOPEnum.getNameFromInt(id);
    }
    /** Setter for name
     * @param newName name
     */
    public void setName(String newName) {
        name = newName;
    }
    
    /** This method calls back into the FuelVisitor#visit() method of the visitor object
     * @param v visitor
     * @exception Exception if the visitor encounters any error during XML serialization/ parsing
     */
    public void accept(FuelEntityVisitor v) throws Exception {
        v.visit(this);
    }
    
    /** Method to compare to FuelMOP objects for equality
	 * @param obj FuelMOP object to be compared against
	 */    
	public boolean equals(Object obj) {

		 if (this == obj) {
				return true;
			}
			if ((obj == null) || !(obj instanceof FuelMOP)) {
				return false;
			}
			FuelMOP aMOP = (FuelMOP) obj;
			
			return new EqualsBuilder().append(this.number, aMOP.number)
									  .append(this.name, aMOP.name)
									  .isEquals();		
	}

	/** Method override since equals() is implemented
	 * @return hash code for the object
	 */    
	public int hashCode() {
		return new HashCodeBuilder(19, 29).append(this.number)
		  .append(this.name)
		  .toHashCode();
	}
}
