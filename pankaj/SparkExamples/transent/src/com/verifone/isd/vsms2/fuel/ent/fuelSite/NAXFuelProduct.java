package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import com.verifone.isd.vsms2.fuel.ent.FuelEntityVisitor;
import com.verifone.isd.vsms2.fuel.ent.IFuelEntityVisitable;
import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 *  Implementation class for the NAX fuel product entity object.
  */
public class NAXFuelProduct implements IFuelEntityVisitable, Serializable {
    private int number = 0;
    private String name = null;
    private int productCode;
    
    // Change this serialVersionUID if any incompatible changes are made to this class
    static final long serialVersionUID = -5189911031770121172L;
    
    /** Constructor
     * @param number the NAX product ID
     * @param name the NAX product name
     */
    public NAXFuelProduct(int number, String name) {
        this.number = number;
        this.name = name;
    }
    
    /** Copy constructor
     * @param orig object to clone from
     */
    public NAXFuelProduct(NAXFuelProduct orig) {
        this.number = orig.number;
        this.name = orig.name;  
    }
    
    /** Getter for ID
     * @return the NAX product ID
     */
    public int getID() {
        return number;
    }
    
    /** Getter for name
     * @return the NAX product name
     */
    public String getName() {
        return name;
    }
    
    /** Setter for name
     * @param newName NAX product name
     */
    public void setName(String newName) {
        this.name = newName;
    }
    
    /** Setter for NAXML FuelProductID
     * @param newID
     */
    public void setID(int newID) {
        this.number = newID;
    }
    
    /** This method calls back into the FuelVisitor#visit() method of the visitor object
     * @param v visitor
     * @exception Exception if the visitor encounters any error during XML serialization/ parsing
     */
    public void accept(FuelEntityVisitor v) throws Exception {
        v.visit(this);
    }

    /**
     * @return the productCode
     */
    public int getProductCode() {
        return productCode;
    }

    /**
     * @param productCode the productCode to set
     */
    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }
    
    /** Method to compare to NAXFuelProduct objects for equality
	 * @param obj NAXFuelProduct object to be compared against
	 */    
	public boolean equals(Object obj) {

		 if (this == obj) {
				return true;
			}
			if ((obj == null) || !(obj instanceof NAXFuelProduct)) {
				return false;
			}
			NAXFuelProduct aProduct = (NAXFuelProduct) obj;
			
			return new EqualsBuilder().append(this.number, aProduct.number)
									  .append(this.name, aProduct.name)
									  .append(this.productCode, aProduct.productCode)
									  .isEquals();		
	}

	/** Method override since equals() is implemented
	 * @return hash code for the object
	 */    
	public int hashCode() {
		return new HashCodeBuilder(19, 29).append(this.number)
		 .append(this.name)
	     .append(this.productCode)
		 .toHashCode();
	}
}
