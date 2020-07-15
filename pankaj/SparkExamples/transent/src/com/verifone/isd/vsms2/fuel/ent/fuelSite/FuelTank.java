package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import com.verifone.isd.vsms2.sys.util.ISapphireCollection;
import com.verifone.isd.vsms2.fuel.ent.FuelEntityVisitor;
import com.verifone.isd.vsms2.fuel.ent.IFuelEntityVisitable;
import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 *  Implementation class for the fuel tank entity object.
 *  @author "mailto:bhanu_narayanan@verifone.com"
 */
public class FuelTank implements IFuelEntityVisitable, Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 810998682347901691L;
	private int number = 0;
    private String name = null;
    private int manifold = 0;

    // new attributes required by NAXML - not currently supported on GEMSTONE systems
    private int NAXFuelProductID = 0;           // maps to NAXFuelProduct Collection
    private int NAXTankChartID = 0;             // not defined by NAXML or GEMSTONE
    private String NAXTankDescription = null;   // text
    private Date NAXTankInstallDate = null;     // Date
    private String NAXTankManufacturer = null;  // Manufacturer name
    private int NAXTankModelNumber = 0;         // Tank model number
    private int NAXTankSerialNumber = 0;        // Tank serial number
    private int NAXTankDepth = 0;               // Tank depth
    private int NAXTankLowInventoryVolume = 0;  // Tank Low Inventory Volume
    private int NAXTankReorderVolume = 0;       // Tank reorder Volume
    private int NAXTankVolume = 0;              // Tank Volume
    
    // Change this serialVersionUID if any incompatible changes are made to this class
    //static final long serialVersionUID = 1257618544988673312L;
    
    /** Constructor
     * @param manifold manifold tank id
     * @param number the tank ID
     * @param name the tank name
     */
    public FuelTank(int number, String name, int manifold) {
        this.number = number;
        this.name = name;
        this.manifold = manifold;
    }
    
    /** Copy constructor
     * @param orig object to clone from
     */
    public FuelTank(FuelTank orig) {
        this.number = orig.number;
        this.name = orig.name;  
        this.manifold = orig.manifold;
        this.setNAXAttributes(orig);
    }
    
    /** Getter for ID
     * @return the tank ID
     */
    public int getID() {
        return number;
    }
    
    /** Getter for name
     * @return the tank name
     */
    public String getName() {
        return name;
    }
    
    /** Query method to find if tank is manifold.
     * @return the manifold flag
     */
    public boolean isManifold() {
        return (manifold > 0);
    }
    
    /** Getter for manifold tank ID
     * @return the manifold tank ID
     */
    public int getManifoldID() {
        return manifold;
    }
    
    /** Getter for NAXML FuelProductID
     * @return the NAX Fuel Product ID
     */
    public int getNAXFuelProductID() {
        return(NAXFuelProductID);
    }
    
    /** Getter for NAXML TankChartID
     * @return the NAX Tank Chart ID
     */
    public int getNAXTankChartID() {
        return(NAXTankChartID);
    }
    
    /** Getter for NAXML TankDescription
     * @return the NAX Tank Description
     */
    public String getNAXTankDescription() {
        return(NAXTankDescription);
    }
    
    /** Getter for NAXML TankInstallDate
     * @return the NAX Tank Install date
     */
    public Date getNAXTankInstallDate() {
        return(NAXTankInstallDate);
    }
    
    /** Getter for NAXML TankManufacturer
     * @return the NAX Tank Manufacturer
     */
    public String getNAXTankManufacturer() {
        return(NAXTankManufacturer);
    }

    /** Getter for NAXML TankModelNumber
     * @return the NAX Tank model number
     */
    public int getNAXTankModelNumber() {
        return(NAXTankModelNumber);
    }

    /** Getter for NAXML TankSerialNumber
     * @return the NAX Tank serial number
     */
    public int getNAXTankSerialNumber() {
        return(NAXTankSerialNumber);
    }

    /** Getter for NAXML TankDepth
     * @return the NAX Tank depth
     */
    public int getNAXTankDepth() {
        return(NAXTankDepth);
    }

    /** Getter for NAXML TankLowInventoryVolume
     * @return the NAX Tank low inventory volume
     */
    public int getNAXTankLowInventoryVolume() {
        return(NAXTankLowInventoryVolume);
    }

    /** Getter for NAXML TankReorderVolume
     * @return the NAX Tank reorder volume
     */
    public int getNAXTankReorderVolume() {
        return(NAXTankReorderVolume);
    }

    /** Getter for NAXML TankVolume
     * @return the NAX Tank volume
     */
    public int getNAXTankVolume() {
        return(NAXTankVolume);
    }

    /** Setter for manifold tank ID
     * @param newID manifold tank ID
     */
    public void setManifoldID(int newID) {
        manifold = newID;
    }
    
    /** Setter for name
     * @param newName tank name
     */
    public void setName(String newName) {
        this.name = newName;
    }
    
    /** Setter for NAXML FuelProductID
     * @param newFuelProductID
     */
    public void setFuelProductID(int newFuelProductID) {
        this.NAXFuelProductID = newFuelProductID;
    }
    
    /** Setter for NAXML TankChartID
     * @param newTankChartID
     */
    public void setNAXTankChartID(int newTankChartID) {
        this.NAXTankChartID = newTankChartID;
    }
    
    /** Setter for NAXML TankDescription
     * @param newTankDescription
     */
    public void setNAXTankDescription(String newTankDescription) {
        this.NAXTankDescription = newTankDescription;
    }
    
    /** Setter for NAXML TankInstallDate
     * @param newTankInstallDate
     */
    public void setNAXTankINstallDate(Date newTankInstallDate) {
        this.NAXTankInstallDate = newTankInstallDate;
    }
    
    /** Setter for NAXML TankManufacturer
     * @param newTankManufacturer
     */
    public void setNAXTankManufacturer(String newTankManufacturer) {
        this.NAXTankManufacturer = newTankManufacturer;
    }
    
    /** Setter for NAXML TankModelNumber
     * @param newTankModelNumber
     */
    public void setNAXTankModelNumber(int newTankModelNumber) {
        this.NAXTankModelNumber = newTankModelNumber;
    }
    
    /** Setter for NAXML TankSerialNumber
     * @param newTankSerialNumber
     */
    public void setNAXTankSerialNumber(int newTankSerialNumber) {
        this.NAXTankSerialNumber = newTankSerialNumber;
    }
    
    /** Setter for NAXML TankDepth
     * @param newTankDepth
     */
    public void setNAXTankDepth(int newTankDepth) {
        this.NAXTankDepth = newTankDepth;
    }
    
    /** Setter for NAXML TankLowInventoryVolume
     * @param newTankLowInventoryVolume
     */
    public void setNAXTankLowInventoryVolume(int newTankLowInventoryVolume) {
        this.NAXTankLowInventoryVolume = newTankLowInventoryVolume;
    }
    
    /** Setter for NAXML TankReorderVolume
     * @param newTankReorderVolume
     */
    public void setNAXTankReorderVolume(int newTankReorderVolume) {
        this.NAXTankReorderVolume = newTankReorderVolume;
    }
    
    /** Setter for NAXML TankVolume
     * @param newTankVolume
     */
    public void setNAXTankVolume(int newTankVolume) {
        this.NAXTankVolume = newTankVolume;
    }
    
    /** This method calls back into the FuelVisitor#visit() method of the visitor object
     * @param v visitor
     * @exception Exception if the visitor encounters any error during XML serialization/ parsing
     */
    public void accept(FuelEntityVisitor v) throws Exception {
        v.visit(this);
    }

	/**	The Setter for all NAXML elements of the class
	 * @param fTank
	 */	
   	public void setNAXAttributes(FuelTank fTank) {
		/** Re: CR3017. Tankid, Manifoldid and name are not copied intentionally as  
		 *	they are already available from the runtime instance.
		 */
   		this.setFuelProductID(fTank.getNAXFuelProductID());
    	this.setNAXTankChartID(fTank.getNAXTankChartID());
    	this.setNAXTankDepth(fTank.getNAXTankDepth());
   		this.setNAXTankDescription(fTank.getNAXTankDescription());
   		this.setNAXTankINstallDate(fTank.getNAXTankInstallDate());
    	this.setNAXTankLowInventoryVolume(fTank.getNAXTankLowInventoryVolume());
   		this.setNAXTankManufacturer(fTank.getNAXTankManufacturer());
    	this.setNAXTankModelNumber(fTank.getNAXTankModelNumber());
    	this.setNAXTankReorderVolume(fTank.getNAXTankReorderVolume());
    	this.setNAXTankSerialNumber(fTank.getNAXTankSerialNumber());
    	this.setNAXTankVolume(fTank.getNAXTankVolume());
    }
   	
   	/** Method to compare to FuelTank objects for equality
	 * @param obj FuelTank object to be compared against
	 */    
	public boolean equals(Object obj) {

		 if (this == obj) {
				return true;
			}
			if ((obj == null) || !(obj instanceof FuelTank)) {
				return false;
			}
			FuelTank aTank = (FuelTank) obj;
			
			return new EqualsBuilder().append(this.number, aTank.number)
									  .append(this.name, aTank.name)
									  .append(this.manifold, aTank.manifold)
									  .append(this.NAXFuelProductID, aTank.NAXFuelProductID)
									  .append(this.NAXTankChartID, aTank.NAXTankChartID)
									  .append(this.NAXTankDepth, aTank.NAXTankDepth)
									  .append(this.NAXTankLowInventoryVolume, aTank.NAXTankLowInventoryVolume)
									  .append(this.NAXTankModelNumber, aTank.NAXTankModelNumber)
									  .append(this.NAXTankReorderVolume, aTank.NAXTankReorderVolume)
									  .append(this.NAXTankSerialNumber,aTank.NAXTankSerialNumber)
									  .append(this.NAXTankVolume, aTank.NAXTankVolume)
									  .append(this.NAXTankDescription, aTank.NAXTankDescription)
									  .append(this.NAXTankInstallDate, aTank.NAXTankInstallDate)
									  .append(this.NAXTankManufacturer, aTank.NAXTankManufacturer)
									  .isEquals();		
	}

	/** Method override since equals() is implemented
	 * @return hash code for the object
	 */    
	public int hashCode() {
		return new HashCodeBuilder(19, 29).append(this.number)
		 .append(this.name)
		 .append(this.manifold)
		 .append(this.NAXFuelProductID)
		 .append(this.NAXTankChartID)
		 .append(this.NAXTankDepth)
		 .append(this.NAXTankLowInventoryVolume)
		 .append(this.NAXTankModelNumber)
		 .append(this.NAXTankReorderVolume)
		 .append(this.NAXTankSerialNumber)
		 .append(this.NAXTankVolume)
		 .append(this.NAXTankDescription)
		 .append(this.NAXTankInstallDate)
		 .append(this.NAXTankManufacturer)
		 .toHashCode();
	}
}
