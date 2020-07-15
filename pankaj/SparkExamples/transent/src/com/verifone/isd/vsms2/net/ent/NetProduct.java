/*
 * NetProduct.java
 *
 * Created on April 30, 2003, 6:40 PM
 */
package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import com.verifone.isd.vsms2.sys.util.Quantity;

/** NetProduct represents a single network product that will be sent to the credit
 * card host. A product can be a fuel product, a non fuel product, or
 * notsold - No item was sold for this product type. The network product
 * code is a POS product code and is not the actual product code sent to
 * to the credit card host.
 * @author kelvin_f1
 * @version 1.0
 */
public class NetProduct implements java.io.Serializable
{
    static final long serialVersionUID = 8147425506589273686L; 

    private short prodType;         // type PRODNOTSOLD, NONFUELPROD, FUELPROD
    private short fuelingPosition;  // fueling position of a fuel product		
    private int prodCode;           // POS network product code
    private MoneyAmount amount;     // amount sold of the product
    private Quantity quantity;      // quantity sold of the product
    private Quantity gallons;       // gallons sold of a fuel product
    private MoneyAmount pricePerGallon; // price per gallon of a fuel product
    private short serviceLevel;     // service level of a fuel product 
    private short MOP;              // fuel product pricing level
	private String upcNum;			// UPC Number for a PLU item
	private String description;		// Item line description
	private boolean fuelAuth;		// Fast credit w/o grade prompting

    /** No-args constructor. Create a new product object with
     * the product type initialized to PRODNOTSOLD.
     */
    public NetProduct() {
        this.prodType = 0;
        this.fuelingPosition = 0;
        this.prodCode = 0;
        this.amount = new MoneyAmount(0);
        this.quantity = new Quantity(0,"");
        this.gallons = new Quantity(0,"");
        this.pricePerGallon = new MoneyAmount(0);
        this.serviceLevel = 0;
        this.MOP = 0;
        this.description = new String("");
		this.upcNum = new String("");
    }

    /** Setter method for setting the network product type. Only allows
     *  valid product type entries PRODNOTSOLD, FUELPROD or NONFUELPROD
     *  for a fuel product, a non fuel product, or product not sold
     * @param prodType the product type, PRODNOTSOLD, FUELPROD or NONFUELPROD
     * @throws NetworkException The prodType parameter contained an invalid product type.
     */    
    public void setProdType(short prodType) throws NetworkException {
        this.prodType = prodType;
    }

    /** Getter method to retrieve the network product type.  The product can
     *  be a fuel product, non fuel product, or not sold
     * @return the product type PRODNOTSOLD, FUELPROD or NONFUELPROD
     */    
    public short getProdType()
    {
        return this.prodType;
    }

    /** Setter method to set the fueling position.  This field is only valid 
     * for a fuel product type.
     * @param fuelingPosition the fueling position for the fuel product bucket.
     */    
    public void setFuelingPosition(short fuelingPosition)
    {
        this.fuelingPosition = fuelingPosition;
    }		

    /** Getter method to retrieve the fueling position of the network product bucket.
     * This field is only valid for a fuel product bucket.
     * @return The fueling position for the fuel product
     */    
    public short getFuelingPosition()
    {
        return this.fuelingPosition;
    }		

     /** Setter method to set the network product code. This product code is
      * the POS product code and not the actual product code that is sent to
      * the credit card network.
      * @param prodCode The POS network product code.
      */    
    public void setProdCode(int prodCode)
    {
        this.prodCode = prodCode;
    }

    /** Getter method to retrieve the network product code.
     * This product code is the POS network product code and
     * not the actual product code that is transmitted to the
     * credit card host.
     * @return The POS network product code.
     */    
    public int getProdCode()
    {
        return this.prodCode;
    }

    /** Setter method to set the amount of the network product
     * bucket.
     * @param amount Amount sold of the product.
     */    
    public void setAmount(MoneyAmount amount)
    {
        this.amount = amount;	
    }    

    /** Getter method to retrieve the amount contained in the product bucket.
     * @return The amount contained in the product bucket.
     */    
    public MoneyAmount getAmount()
    {
        return this.amount;
    }

    /** Setter method to set the quantity of items sold of this product.
     * @param quantity The quauntity of items sold of this product.
     */    
    public void setQuantity(Quantity quantity)
    {
        this.quantity = quantity;
    }

    /** Getter method to retrieve the quantity of items stored in this product bucket.
     * @return The quantity of items of this product.
     */    
    public Quantity getQuantity()
    {
        return this.quantity;
    }

    /** Setter method to set the quantity of gallons sold of this fuel product. This
     *  value is only valid for a fuel product.
     * @param gallons the quantity of gallons sold of this product.
     */    
    public void setGallons(Quantity gallons)
    {
        this.gallons = gallons;
    }

    /** Getter method to retrieve the quantity of gallons sold of this fuel product.
     * This value is only valid for a fuel product.
     * @return The quantity of gallons sold of this fuel product.
     */    
    public Quantity getGallons()
    {
        return this.gallons;
    }

    /** Setter method to set the price per gallon for a fuel product. This value is
     * only valid for a fuel product.
     * @param pricePerGallon The price per gallon of a fuel product.
     */    
    public void setPricePerGallon(MoneyAmount pricePerGallon)
    {
        this.pricePerGallon = pricePerGallon;
    }

    /** Getter method to retrieve the price per gallon of this fuel product. This value
     * is only valid for a fuel product.
     * @return The price per gallon of this fuel product.
     */    
    public MoneyAmount getPricePerGallon()
    {
        return this.pricePerGallon;
    }

    /** Setter method to set the fuel price service level of a fuel product.  This value
     * is only valid for a fuel product.
     * @param serviceLevel The fuel price service level of this fuel product.
     */    
    public void setServiceLevel(short serviceLevel)
    {
        this.serviceLevel = serviceLevel;
    }

    /** Getter method to retrieve the fuel price service level for this fuel product.
     * This value is only valid for a fuel product.
     * @return The fuel price service level of this fuel product.
     */    
    public short getServiceLevel()
    {
        return this.serviceLevel;
    }

    /** Setter method to set the method of payment for this fuel product.  This value is
     * only valid for a fuel product.
     * @param MOP Method of payment of this fuel product.
     */    
    public void setMOP(short MOP)
    {
        this.MOP = MOP;
    }

    /** Getter method to retrieve the method of payment for this fuel product.  This value
     * is only valid for a fuel product.
     * @return The method of payment for the fuel product.
     */    
    public short getMOP()
    {
        return this.MOP;
    }

	/**
	 * Getter method for the PLU UPC number
	 * @return UPC number of the PLU
	 */
	public String getUpcNum() {
		return this.upcNum;
	}

	/**
	 * Setter method for the UPC number
	 * @param upc The UPC number from the PLU item line
	 */
	public void setUpcNum(String upc) {
		this.upcNum = upc;
	}
		
	/**
	 * @return Returns the fuelAuth.
	 */
	public boolean isFuelAuth() {
		return fuelAuth;
	}
	/**
	 * @param fuelAuth The fuelAuth to set.
	 */
	public void setFuelAuth(boolean fuelAuth) {
		this.fuelAuth = fuelAuth;
	}
	
	/**
	 * @return Returns the description.
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
