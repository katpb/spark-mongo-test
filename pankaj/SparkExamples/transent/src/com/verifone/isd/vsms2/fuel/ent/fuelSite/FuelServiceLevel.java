package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import com.verifone.isd.vsms2.fuel.ent.FuelEntityVisitor;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import java.io.Serializable;

/** Implementation class for the fuel service level entity object.
 * @author "mailto:bhanu_narayanan@verifone.com"
 */
public class FuelServiceLevel implements Serializable {
	private int number = 0;
    private String name = null;

	private static final long serialVersionUID = 7009911964452112146L;
	
    /** Constructor
     * @param number the service level ID
     * @param name the service level name
     */
    public FuelServiceLevel(int number, String name) {
        this.number = number;
        this.name = name;
    }
    
    /** Copy constructor
     * @param orig object to clone from
     */
    public FuelServiceLevel(FuelServiceLevel orig) {
        this.number = orig.number;
        this.name = orig.name;        
    }    
    
    /** Getter for ID
     * @return the service level ID
     */
    public int getID() {
        return number;
    }
    
    /** Getter for name
     * @return the service level name
     */
    public String getName() {
        return name;
    }
    
    /** Getter for default service level name for a given ID
     * @param id required ID
     * @return default service level name
     */    
    public static String getDefaultName(int id) {
        return FuelServiceLevelEnum.getNameFromInt(id);
    }
    
    /** Setter for name
     * @param newName name
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
    
    /** Method to compare to FuelServiceLevel objects for equality
	 * @param obj FuelServiceLevel object to be compared against
	 */    
	public boolean equals(Object obj) {

		 if (this == obj) {
				return true;
			}
			if ((obj == null) || !(obj instanceof FuelServiceLevel)) {
				return false;
			}
			FuelServiceLevel aMOP = (FuelServiceLevel) obj;
			
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
