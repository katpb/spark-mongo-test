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
 *  implementation class for the fuel hose entity object
 *  @see FuelingPosition
 *  @author "mailto:bhanu_narayanan@verifone.com"
 */
public class FuelHose implements IFuelEntityVisitable, Serializable {
    private int number = 0;
    private int prodNum;
    
    
    // Change this serialVersionUID if any incompatible changes are made to this class
    static final long serialVersionUID = -8434284417991560505L;
    
    /** Constructor
     * @param number hose ID
     * @param prodNum the ID of the product assigned
     */
    public FuelHose(int number, int prodNum) {
        this.number = number;
        this.prodNum = prodNum;
    }
    
    /** Copy constructor
     * @param orig object to clone from
     */
    public FuelHose(FuelHose orig) {
        this.number = orig.number;
        this.prodNum = orig.prodNum;        
    }     
    
    /**
     *  Getter  for the hose id
     *  @return the fuel hose object's ID
     */
    public int getID() {
        return number;
    }
    
    /**
     *  Getter for fuel product number
     *  @return the ID of the product assigned to the fuel hose
     */
    public int getProductID() {
        return prodNum;
    }
    
    void setProductID(int prodID) throws FuelException {
        if (prodID < 0) {

            ArrayList exceptionParams = new ArrayList(1);
            Integer parameterNumber = Integer.valueOf(prodID);
            exceptionParams.add(parameterNumber);
            throw new FuelException(FuelViewRes.ERROR_INVALID_PRODUCT_ID, LocalizedRB.FUELVIEW_RESOURCE, exceptionParams);
        }
        else {
            this.prodNum = prodID;
        }
        
    }
    /** 	This method calls back into the FuelVisitor#visit() method of the visitor object
     * @param v visitor
     * @exception Exception if visitor encounters an error
     */
    public void accept(FuelEntityVisitor v) throws Exception {
        v.visit(this);
    }
    
    /** Method to compare to FuelHose objects for equality
	 * @param obj FuelHose object to be compared against
	 */    
	public boolean equals(Object obj) {

		 if (this == obj) {
				return true;
			}
			if ((obj == null) || !(obj instanceof FuelHose)) {
				return false;
			}
			FuelHose aHose = (FuelHose) obj;
			
			return new EqualsBuilder().append(this.number, aHose.number)
									  .append(this.prodNum, aHose.prodNum)
									  .isEquals();		
	}

	/** Method override since equals() is implemented
	 * @return hash code for the object
	 */    
	public int hashCode() {
		return new HashCodeBuilder(19, 29).append(this.number)
		  .append(this.prodNum)
		  .toHashCode();
	}
}
