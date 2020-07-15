package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.verifone.isd.vsms2.fuel.ent.FuelEntityVisitor;
import com.verifone.isd.vsms2.fuel.ent.IFuelEntityVisitable;
/**
 *  Implementation class for the fuel blend entity object.
 *  The fuel blend types that map to Ruby blend types are:
 *  <pre>
 *      0   NONE
 *      1   MECH
 *      2   ELEC
 *      3   VARI
 *      4   FIX
 *      5   SC82
 *  </pre>
 *  @author "mailto:bhanu_narayanan@verifone.com"
 */
public class FuelBlendType implements IFuelEntityVisitable, Serializable {
    private int number = 0;
    private String name = null;
    
    private static final String[] defName = {"NONE", "MECH", "ELEC", "VARI", "FIX", "SC82"};
    private static final String UNKNOWN = "UNKNOWN";
    
    // Change this serialVersionUID if any incompatible changes are made to this class
    static final long serialVersionUID = -6173034738226777584L;
    
    /** Constructor
     * @param number the blend type ID
     * @param name the blend type name
     */
    public FuelBlendType(int number, String name) {
        this.number = number;
        this.name = name;
    }
    
    /** Copy constructor
     * @param orig blen type object to clone from
     */
    public FuelBlendType(FuelBlendType orig) {
        this.number = orig.number;
        this.name = orig.name;        
    }
    
    /** Getter for blend type ID
     * @return the blend type ID
     */
    public int getID() {
        return number;
    }
    
    /** Getter for blend type name
     * @return the blend type name
     */
    public String getName() {
        return name;
    }
    
    /** Getter for default name for a blend type
     * @return default name for a blend type
     * @param id blend type ID
     */    
    public static String getDefaultName(int id) {
        return (id > 0 && id <= defName.length) ? defName[id-1] : UNKNOWN;
    }
    
    /** Setter for blend type name
     * @param newName blend type name
     */
    public void setName(String newName) {
        this.name = newName;
    }
    
    /** This method calls back into the FuelVisitor#visit() method of the visitor object
     * @param v visitor
     * @exception Exception if the visitor encounters any error during XML serialization/ parsing
     */
    public void accept(FuelEntityVisitor v) throws Exception {
        v.visit(this);
    }
    
    /** Method to compare to FuelBlendType objects for equality
	 * @param obj FuelBlendType object to be compared against
	 */    
	public boolean equals(Object obj) {

		 if (this == obj) {
				return true;
			}
			if ((obj == null) || !(obj instanceof FuelBlendType)) {
				return false;
			}
			FuelBlendType aBlendType = (FuelBlendType) obj;
			
			return new EqualsBuilder().append(this.number, aBlendType.number)
									  .append(this.name, aBlendType.name)
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
