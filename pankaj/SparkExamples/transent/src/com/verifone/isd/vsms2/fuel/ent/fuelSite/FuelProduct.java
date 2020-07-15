package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import com.verifone.isd.vsms2.fuel.ent.FuelEntityVisitor;
import com.verifone.isd.vsms2.fuel.ent.IFuelEntityVisitable;
import com.verifone.isd.vsms2.sys.l10n.FuelViewRes;
import com.verifone.isd.vsms2.sys.l10n.LocalizedRB;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation class for the fuel product entity object.
 * 
 * @author "mailto:bhanu_narayanan@verifone.com"
 */
public class FuelProduct implements IFuelEntityVisitable, Serializable {
    
    public static final int MAX_BLEND_TANKS = 2;
    public static final int FUELPRODUCTID_ZERO = 0;
    private Logger logger = LoggerFactory.getLogger(FuelProduct.class);
	/**
	 * This points to VFI sysid for a given Fuel Product if configured through
	 * Fuel Product UI page(example:1-UNLD1,1 here refers to sysid which is
	 * treated as the value here).If configured through
	 * NAXML-uMaintanence/dataset=FuelGrade,then this instance variable points to naxfuelgradeid
	 * pushed by this cgi command.
	 */
    private int sysID = 0;
    private String name = null;

    private List<BlendTank> tanks;
    private int[] pcNum = new int[2];
    private int depNum;
    private boolean fuelGradeActiveFlag = true;

    private MoneyAmount[] prices;

	/**
	 * Holds value of property prodNum.This maps to alternateID exposed via
	 * FuelGrade ID (in Fuel Product UI page).The same will be serialized as number attribute in
	 * vperiodTargs.
	 */
    private int prodNum;

    /*
     * Holds value of decimals for price per unit
     */
    private int ppuDecPosition = 3;

    // Change this serialVersionUID if any incompatible changes are made to this
    // class
    static final long serialVersionUID = -8371636923618550902L;

    /**
     * Constructor
     * 
     * @param ID
     *            product ID
     * @param name
     *            product name
     */
    public FuelProduct(int ID, String name) {
        this.sysID = ID;
        this.name = name;
        tanks = new ArrayList<BlendTank>(MAX_BLEND_TANKS);
    }

    /**
     * Copy constructor
     * 
     * @param orig
     *            object to clone from
     */
    public FuelProduct(FuelProduct orig) {
        this.sysID = orig.sysID;
        this.name = orig.name;
        this.tanks = orig.tanks;

        this.pcNum[0] = orig.pcNum[0];
        this.pcNum[1] = orig.pcNum[1];
        this.depNum = orig.depNum;
        this.prodNum = orig.prodNum; 
        if (orig.prices != null) {
            int len = orig.prices.length;
            this.prices = new MoneyAmount[len];
            for (int i = 0; i < len; i++) {
            	if(null != orig.prices[i]) {
            		this.prices[i] = (MoneyAmount) orig.prices[i].clone();
            	}
            }
        } else {
            this.prices = new MoneyAmount[0];
        }
        this.ppuDecPosition = orig.ppuDecPosition;
    }

    /**
     * Constructor
     * 
     * @param ID the product ID
     * @param name product name
     * @param tanks the list of tanks that make up the fuel product
     * @param prodNum
     * @exception FuelException
     *                thrown if total blend percentages for the grade do not equal 100
     */
    public FuelProduct(int ID, String name, List<BlendTank> tanks, int prodNum) {

            this.sysID = ID;
            this.name = name;
            this.tanks = tanks;
            this.prodNum = prodNum;
            logger.debug("Create a new fuel product with a tank list size of " + tanks.size());
    }

    /**
     * Sets the price array for the product. This method is given public scope
     * to support test applications
     * 
     * @param newPrices
     *            new prices
     * @exception FuelException
     *                if the newPrices is null
     */
    public void setPrices(int[] newPrices) throws FuelException {
        if (newPrices == null) {
            throw new FuelException(FuelViewRes.ERROR_INVALID_PRICE, LocalizedRB.FUELVIEW_RESOURCE);
        }
        prices = new MoneyAmount[newPrices.length];
        for (int i = 0; i < newPrices.length; i++) {
            prices[i] = new MoneyAmount(newPrices[i], this.ppuDecPosition);
        }
    }

    /**
     * Getter for fuel prices
     * 
     * @return the price array
     * @exception FuelException
     *                if the price is not initialized
     */
    public int[] getLongPrices() throws FuelException {
        if (prices == null) {
            throw new FuelException(FuelViewRes.ERROR_PRICE_NOT_INIT, LocalizedRB.FUELVIEW_RESOURCE);
        }
        int[] tmpPrices = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
        	if(prices[i]!= null)
        	{
            tmpPrices[i] = (int) (prices[i].getLongValue());
        	}
        	else
        	{
        		tmpPrices[i] = 0;
        	}
        }
        return tmpPrices;
    }

    /**
     * Get fuel prices as MoneyAmount objects
     * 
     * @return the price array
     */
    public MoneyAmount[] getPrices() {
        return prices;
    }

    /**
     * Getter for a specific fuel price
     * 
     * @param SLNum
     *            service level for which the price is required
     * @param MOPNum
     *            MOP for which the price is required
     * @param tierNum
     *            tier for which the price is required
     * @return the price for a specific service level, MOP and tier
     * @exception FuelException
     *                if the fuel site/ price is not initialized
     */
    public MoneyAmount getPrice(int SLNum, int MOPNum, int tierNum) throws FuelException {
        if (prices == null) {
            throw new FuelException(FuelViewRes.ERROR_PRICE_NOT_INIT, LocalizedRB.FUELVIEW_RESOURCE);
        }

        if (prices.length < (IFuelSite.MAX_SERVICELEVELS * IFuelSite.MAX_MOPS * IFuelSite.MAX_TIERS)) {
            throw new FuelException(FuelViewRes.ERROR_INVALID_PRICE_INIT, LocalizedRB.FUELVIEW_RESOURCE);
        }
        MoneyAmount price = prices[((tierNum - 1) * IFuelSite.MAX_SERVICELEVELS * IFuelSite.MAX_MOPS)
                + ((SLNum - 1) * IFuelSite.MAX_MOPS) + (MOPNum - 1)];
        // return a copy of the MoneyAmount object instead of the reference
        return new MoneyAmount(price);
    }

    /**
     * Setter for a specific fuel price
     * 
     * @param price
     *            new price
     * @param SLNum
     *            service level for which the price is required
     * @param MOPNum
     *            MOP for which the price is required
     * @param tierNum
     *            tier for which the price is required
     * @exception FuelException
     *                if the fuel site/ price is not initialized
     */
    public void setPrice(int SLNum, int MOPNum, int tierNum, int price) throws FuelException {
        if (prices == null)
            prices = new MoneyAmount[IFuelSite.MAX_SERVICELEVELS * IFuelSite.MAX_MOPS * IFuelSite.MAX_TIERS];

        if (prices.length != (IFuelSite.MAX_SERVICELEVELS * IFuelSite.MAX_MOPS * IFuelSite.MAX_TIERS)) {
            throw new FuelException(FuelViewRes.ERROR_INVALID_PRICE_INIT, LocalizedRB.FUELVIEW_RESOURCE);
        }
        prices[((tierNum - 1) * IFuelSite.MAX_SERVICELEVELS * IFuelSite.MAX_MOPS) + ((SLNum - 1) * IFuelSite.MAX_MOPS)
                + (MOPNum - 1)] = new MoneyAmount(price, this.ppuDecPosition);
    }

	/**
	 * This points to VFI sysid for a given Fuel Product if configured through
	 * Fuel Product UI page(example:1-UNLD1,1 here refers to sysid which is
	 * treated as the value here).If configured through
	 * NAXML-uMaintanence/dataset=FuelGrade,then this instance variable points
	 * to naxfuelgradeid pushed by this cgi command.
	 */

	public int getID() {
		return sysID;
	}

    /**
     * Getter for name
     * 
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for fuel product codes for different service levels
     * 
     * @return product codes for different service levels
     */
    public int[] getProdCodeNum() {
        return this.pcNum;
    }

    /**
     * Getter for fuel product code for specific service level
     * 
     * @param serviceLevel
     *            service level
     * @return fuel product code for the service level
     */
    public int getProdCodeNum(int serviceLevel) {
        if (serviceLevel <= 0 || serviceLevel > this.pcNum.length) {
            return this.pcNum[0];
        } else {
            return this.pcNum[serviceLevel - 1];
        }
    }

    /**
     * Getter for department number
     * 
     * @return department number
     */
    public int getDepartmentNum() {
        return this.depNum;
    }

    /**
     * Getter for fuelGradeActiveFlag
     * 
     * @return the fuelGradeActiveFlag
     */
    public boolean getFuelGradeActiveFlag() {
        return fuelGradeActiveFlag;
    }

    /**
     * Setter for fuelGradeActiveFlag
     * 
     * @param newFuelGradeActiveFlag
     */
    public void setFuelGradeActiveFlag(boolean newFuelGradeActiveFlag) {
        this.fuelGradeActiveFlag = newFuelGradeActiveFlag;
    }

    /**
     * Setter for name
     * 
     * @param newName
     *            name
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     * Setter for fuel product codes by service level
     * 
     * @param pcNum
     *            product code array
     * @throws FuelException
     *             on invalid size of the array or invalid product code values
     */
    public void setProdCodeNum(int[] pcNum) throws FuelException {
        if (pcNum == null) {
            throw new FuelException(FuelViewRes.ERROR_INVALID_PRODUCT_CODE, LocalizedRB.FUELVIEW_RESOURCE);
        }
        System.arraycopy(pcNum, 0, this.pcNum, 0, 2);
    }

    /**
     * Setter for department number
     * 
     * @param depNum
     *            department number
     * @throws FuelException
     *             on invalid department number
     */
    public void setDepartmentNum(int depNum) throws FuelException {
        if (depNum < 0) {
            throw new FuelException(FuelViewRes.ERROR_INVALID_DEPARTMENT, LocalizedRB.FUELVIEW_RESOURCE);
        }
        this.depNum = depNum;
    }

    /**
     * This method calls back into the FuelVisitor#visit() method of the visitor
     * object
     * 
     * @param v
     *            visitor
     * @exception Exception
     *                if the visitor encounters any error during XML
     *                serialization/ parsing
     */
    @Override
    public void accept(FuelEntityVisitor v) throws Exception {
        v.visit(this);
    }

    /**
     * Getter for property prodNum.
     * 
     * @return Value of property prodNum.
     */
    public int getProdNum() {
        return this.prodNum;
    }

    /**
     * Setter for property prodNum.
     * 
     * @param prodNum
     *            New value of property prodNum.
     */
    public void setProdNum(int prodNum) {
        this.prodNum = prodNum;
    }

    /**
     * Setter method for "price per unit decimal position".
     * 
     * @param ppuDecPosition
     * @throws FuelException
     */
    public void setPPUDecPosition(int ppuDecPosition) throws FuelException {
        if ((ppuDecPosition < 0) || (ppuDecPosition > IFuelSite.MAX_PPUDECPOSITION)) {
            ArrayList exceptionParams = new ArrayList(1);
            Integer intExceptionParam = Integer.valueOf(ppuDecPosition);
            exceptionParams.add(intExceptionParam);
            throw new FuelException(FuelViewRes.ERROR_INVALID_PPU_DEC, LocalizedRB.FUELVIEW_RESOURCE, exceptionParams);
        }
        this.ppuDecPosition = ppuDecPosition;
        /*
         * * Update fuelprices to reflect new ppu decimal position
         */
        try {
            int origprices[] = this.getLongPrices();
            this.setPrices(origprices);

        } catch (Exception e) {
            /*
             * Nothing to do - since prices have not been loaded yet
             */

        }

    }

    /**
     * @return the ppuDecPosition
     */
    public int getPpuDecPosition() {
    	return ppuDecPosition;
    }


    /**
     * Get the list of tanks for the fuel product.  Can be a single tank or multiple tanks to
     * create a blended fuel product.
     * @return
     */
    public List<BlendTank> getTanks() {
        if(tanks == null){
            tanks = new ArrayList<BlendTank>(MAX_BLEND_TANKS);
        }
        return tanks;
    }

    /**
     * Set the list of tanks for the fuel product.  Can be a single tank or multiple tanks to
     * create a blended fuel product.
     * @param tanks
     * @throws FuelException - duplicate tank numbers in blend or the blend % does not equal 100%
     */
    public void setTanks(List<BlendTank> tanks) throws FuelException {
        if (tanks != null && tanks.isEmpty()) { //to allow 0 as tank id
            this.tanks.clear();
        }
        else if (validTankList(tanks)) {
            this.tanks = tanks;
        } else {
            throw new FuelException(FuelViewRes.ERROR_INVALID_TANK_FEED, LocalizedRB.FUELVIEW_RESOURCE);
        }
    }

    /*
     * Determine if the list of tanks used to create the fuel product is valid.  The list of tanks is not
     * valid if the number of entries is 0 or greater than max tanks, the there are duplicate tank number
     * entries, or the total percentage of all the blends != 100.
     */
    private boolean validTankList(List<BlendTank> tanks) {

        boolean tankListValid = true;
        short totalBlendPercent = 0;

        if (tanks == null) {
            tankListValid = false;
            logger.error("Tank list null");
        } else if ((tanks.size() > MAX_BLEND_TANKS) || (tanks.size() < 1)) {
            tankListValid = false;
            logger.error("Invalid tank size: " + tanks.size());
        } else {
            for (int i = 0; i < tanks.size(); i++) {

                int tankNo = tanks.get(i).getTankNumber();
                totalBlendPercent += tanks.get(i).getBlendPercent();

                for (int j = 0; j < tanks.size(); j++) {

                    if (i!=j) {
                        if (tankNo == tanks.get(j).getTankNumber()) {
                            tankListValid = false;
                            logger.error("Duplicate tank number entry: " + i);
                        }
                    }
                }
            }
            if (totalBlendPercent != 100) {
                tankListValid = false;
                logger.error("Total tank percentage is != 100 : " + totalBlendPercent);
            }
        }
        return tankListValid;
    }
    
    /** Method to compare to FuelProduct objects for equality
	 * @param obj FuelProduct object to be compared against
	 */    
	public boolean equals(Object obj) {

		 if (this == obj) {
				return true;
			}
			if ((obj == null) || !(obj instanceof FuelProduct)) {
				return false;
			}
			FuelProduct aFP = (FuelProduct) obj;
			
			return new EqualsBuilder().append(this.sysID, aFP.sysID)
									  .append(this.depNum, aFP.depNum)
									  .append(this.fuelGradeActiveFlag, aFP.fuelGradeActiveFlag)
									  .append(this.pcNum, aFP.pcNum)
									  .append(this.ppuDecPosition, aFP.ppuDecPosition)
									  .append(this.prodNum, aFP.prodNum)
									  .append(this.tanks, aFP.tanks)
									  .isEquals();		
	}

	/** Method override since equals() is implemented
	 * @return hash code for the object
	 */    
	public int hashCode() {
		return new HashCodeBuilder(19, 29).append(this.sysID)
		 .append(this.depNum)
		 .append(this.fuelGradeActiveFlag)
		 .append(this.pcNum)
		 .append(this.ppuDecPosition)
		 .append(this.prodNum)
		 .append(this.tanks)
		  .toHashCode();
	}
}
