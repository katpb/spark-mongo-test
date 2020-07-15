package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import com.verifone.isd.vsms2.fuel.ent.FuelEntityVisitor;
import com.verifone.isd.vsms2.fuel.ent.IFuelEntityVisitable;
import com.verifone.isd.vsms2.sys.l10n.FuelViewRes;
import com.verifone.isd.vsms2.sys.l10n.LocalizedRB;
import com.verifone.isd.vsms2.sys.util.Volume;

import com.verifone.isd.vsms2.sys.util.Quantity;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *  implementation class for the fueling position entity object
 *  @author "mailto:david_ezell@verifone.com"
 */
public class FuelingPosition implements IFuelingPosition, IFuelEntityVisitable, Serializable {

	// Change this serialVersionUID if any incompatible changes are made 
    //to this class
	private static final long serialVersionUID = 6593761242819048360L;
	
	private Logger logger  = LoggerFactory.getLogger(FuelingPosition.class);
   
    private int identifier = 0;
    private int currentServiceLevel;
    private int defaultMOP;
    private int blendType;
    private FuelHose[] hoses;
    private Quantity currencyLimit;
    private int slowFlowOffset;
    private long attributes;
    private boolean payAtPumpOnly;
    private boolean prepayOnly;
    private boolean dcrInDispenser;
    private boolean handleUpCalling;
    private boolean fullServicePresetAtPump;
    private Quantity volumeLimit;
    private Quantity minimumPPU;
    private String spiIP;

    
    /** Constructor
     * @throws FuelException on error in creating the object
     */    
    public FuelingPosition() throws FuelException {
        this(0);
    }
    
    /** Constructor
     * @param id fueling position ID
     */    
    public FuelingPosition(int id) {
        this.identifier = id;
        this.setCurrencyLimit(new MoneyAmount(30000L));
        this.setVolumeLimit(new Volume(30000,"USG"));
        this.setMinimumPPU(new MoneyAmount(9,3));
        this.setServiceLevel(1);
        this.setMOP(1);
        this.setBlendType(1);
    }
    
    /** Copy Constructor
     * @param orig object to clone from
     */    
    public FuelingPosition(FuelingPosition orig) {
        this.currentServiceLevel = orig.currentServiceLevel;
        this.blendType = orig.blendType;
        this.defaultMOP = orig.defaultMOP;
        this.identifier = orig.identifier;
        this.slowFlowOffset = orig.slowFlowOffset;
        this.attributes = orig.attributes;
        this.dcrInDispenser = orig.dcrInDispenser;
        this.handleUpCalling = orig.handleUpCalling;
        this.payAtPumpOnly = orig.payAtPumpOnly;
        this.prepayOnly = orig.prepayOnly;
        this.fullServicePresetAtPump = orig.fullServicePresetAtPump;
        this.spiIP = orig.spiIP;
        if (orig.currencyLimit != null) {
            this.currencyLimit = (Quantity) orig.currencyLimit.clone();
        }
        if (orig.volumeLimit != null) {
            this.volumeLimit = (Quantity) orig.volumeLimit.clone();
        }
        if (orig.minimumPPU != null) {
            this.minimumPPU = (Quantity) orig.minimumPPU.clone();
        }
        if (orig.hoses == null) {
            this.hoses = new FuelHose[0];
        }
        else {
            int len = orig.hoses.length;
            this.hoses = new FuelHose[len];
            for (int i = 0; i < len; i++) {
                this.hoses[i] = new FuelHose(orig.hoses[i]);
            }
        }
     }
    
    /**  Sets the fueling position parameters. Used while creating/ updating
     *  fueling position objects.
     * @param newFPParam the new parameters to be set for the fueling position
     * @exception FuelException on error in the parameter values
     */
    public void setFuelingPositionParameters(FuelingPositionParameters newFPParam) throws FuelException {
        this.setHoses(newFPParam.getHoses());
        this.setCurrencyLimit(newFPParam.getLimit());
        this.setSlowFlowOffset(newFPParam.getSlowFlowOffset());
        this.setServiceLevel(newFPParam.getCurrentServiceLevelNum());
        this.setMOP(newFPParam.getDefaultMOPNum());
        this.setBlendType(newFPParam.getBlendTypeNum());
        this.setAttributes(newFPParam.getAttributes());
        int cs = newFPParam.getCurrentState();
    }
    
    /** Getter for default service level
     * @see IFuelingPosition#getServiceLevel
     * @return default service level
     */
    public int getServiceLevel() {
        if(currentServiceLevel < 1) {
            return 1;
        } else {
           return currentServiceLevel;
        }
    }
    
    /** Getter for default price level
     * @see IFuelingPosition#getMOP
     * @return default price level
     */
    public int getMOP() {
        return defaultMOP;
    }
    
    /** Getter for blend type
     * @see IFuelingPosition#getBlendType
     * @return blend type
     */
    public int getBlendType() {
        return blendType;
    }
    
    /** Get hoses assigned to the pump
     * @see IFuelingPosition#getHoses
     * @return hoses
     */
    public FuelHose[] getHoses() {
        if (this.hoses == null) {
            this.hoses = new FuelHose[IFuelingPosition.MAX_HOSES];
            for (int i = 1; i <= hoses.length; i++) {
                this.hoses[i-1] = new FuelHose(i, 0);
            }
        }
        return hoses;
    }
    
    /** Get hoses assigned to the pump
     * that have distinct products assigned
     * @see IFuelingPosition#getDistinctHoses
     * @return hoses
     */
    public FuelHose[] getHosesWithDistinctProducts() {
    	//Map of hoses with Distinct Fuel Products
    	Map<Integer ,FuelHose> distinctHosesMap = new HashMap<Integer,FuelHose>();
        if (this.hoses != null) {
           
       		for (int i = 0; i < this.hoses.length; i++) {
				int productID = this.hoses[i].getProductID();
				if(productID != 0 && !distinctHosesMap.keySet().contains(productID)) {
					distinctHosesMap.put(productID, this.hoses[i]);
				}
			}
        }
        return distinctHosesMap.values().toArray( new FuelHose[0]);
    }
    
    /** Getter for pump currencyLimit
     * @see IFuelingPosition#getLimit
     * @return limit
     */
    public Quantity getCurrencyLimit() {
        return currencyLimit;
    }
    
    /** Getter for slow flow offset
     * @see IFuelingPosition#getSlowFlowOffset
     * @return slow flow offset
     */
    public int getSlowFlowOffset() {
        return slowFlowOffset;
    }
    
    /** Getter for fueling position attributes
     * @see IFuelingPosition#getAttributes
     * @return fueling position attributes
     */
    public long getAttributes() {
        return attributes;
    }
    
    /** Getter for ID
     * @see IFuelingPosition#getID
     * @return pump number
     */
    public int getID() {
        return this.identifier;
    }

    /** This method calls back into the FuelVisitor#visit() method of the visitor object
     * @param v visitor
     * @exception Exception on error in the visitor visit method
     */
    public void accept(FuelEntityVisitor v) throws Exception {
        v.visit(this);
    }
    
    /**
     *  sets the fueling position ID. This method is explicitly
     *  given package level scope.
     */
    void setID(int identifier) {
        this.identifier = identifier;
    }

    /**  Sets the hose object array for the fueling position
     * @param newHoses the array of hoses assigned to the fueling position
     * @exception FuelException on invalid hose array size/ values
     */
    public void setHoses(FuelHose[] newHoses) throws FuelException {
        if (newHoses.length > IFuelingPosition.MAX_HOSES) {
            throw new FuelException(FuelViewRes.ERROR_INVALID_HOSE_ARRAY_SIZE, LocalizedRB.FUELVIEW_RESOURCE);
        }
        
        this.hoses = new FuelHose[IFuelingPosition.MAX_HOSES];
        /*
         * getProduct() is called on each hose object to
         * ensure existence of the corresponding FuelProduct
         * object (either the object already exists or a
         * dummy object is created by the getProduct() method.
         */
        for (int i = 1; i <= hoses.length; i++) {
            for (int j = 0; j < newHoses.length; j++) {
                if (newHoses[j].getID() == i) {
                    newHoses[j].getProductID();
                    this.hoses[i-1] = newHoses[j];
                    break;
                }
            }
        }
        for (int i = 0; i < hoses.length; i++) {
            if (this.hoses[i] == null) {
                this.hoses[i] = new FuelHose(i+1, 0);
            }
        }
    }
    
    /** Getter for hose object
     * @param hoseID required hose ID
     * @throws FuelException on error in getting the required hose object
     * @return hose object
     */    
    public FuelHose getHose(int hoseID) throws FuelException {
        if ((hoseID <= 0) || (hoseID > IFuelingPosition.MAX_HOSES)) {
            ArrayList exceptionParams = new ArrayList(1);
            Integer intExceptionParam = Integer.valueOf(hoseID);
            exceptionParams.add(intExceptionParam);
            throw new FuelException(FuelViewRes.ERROR_INVALID_HOSE_ID, LocalizedRB.FUELVIEW_RESOURCE, exceptionParams);
        }
        FuelHose reqHose = null;
        if (this.hoses == null) {
            reqHose = new FuelHose(hoseID, 0);
        }
        else {
            for (int i = 0; i < hoses.length; i++) {
                if (hoses[i].getID() == hoseID) {
                    reqHose = hoses[i];
                }
            }
        }
        return reqHose;
    }
    
    /** Associate hose with a product
     * @param hoseID hose ID
     * @param prodID product ID
     * @throws FuelException on invalid parameters
     */    
    public void setHose(int hoseID, int prodID) throws FuelException {
        if ((hoseID <= 0) || (hoseID > IFuelingPosition.MAX_HOSES)) {
            ArrayList exceptionParams = new ArrayList(1);
            Integer intExceptionParam = Integer.valueOf(hoseID);
            exceptionParams.add(intExceptionParam);
            throw new FuelException(FuelViewRes.ERROR_INVALID_HOSE_ID, LocalizedRB.FUELVIEW_RESOURCE, exceptionParams);
        }
        if (this.hoses == null) {
            this.hoses = new FuelHose[IFuelingPosition.MAX_HOSES];
            for (int i = 1; i <= hoses.length; i++) {
                this.hoses[i-1] = new FuelHose(i, 0);
            }
        }
        hoses[hoseID-1].setProductID(prodID);
    }
    
    /**
     *  Sets the fuel currencyLimit 
     *  @param newLimit the limit object
     */
    public void setCurrencyLimit(Quantity newCurrencyLimit) {
        currencyLimit = newCurrencyLimit;
    }
    
    /**
     *  Sets the fueling position attributes
     *  @param newAttributes the new attribute bitmap for the fueling position
     *  @see IFuelingPosition
     */
    public void setAttributes(long newAttributes) {
        attributes = newAttributes;
    }
    
    /**
     *  Sets the slow flow offset
     *  @param newSFO   the new slow flow offset value
     */
    public void setSlowFlowOffset(int newSFO) {
        slowFlowOffset = newSFO;
    }
    
    /**  Sets the current service level
     * @param newSLNum current service level ID
     */
    public void setServiceLevel(int newSLNum) {
        if(newSLNum < 1) {
            currentServiceLevel = 1;
        } else {
            currentServiceLevel = newSLNum;
        }
    }
    
    /**  Sets the default MOP
     * @param newMOPNum default MOP ID
     */
    public void setMOP(int newMOPNum)  {
        defaultMOP = newMOPNum;
    }
    
    /**  Sets the blend type
     * @param newBlendNum blend type ID
     */
    public void setBlendType(int newBlendNum) {
        blendType = newBlendNum;
     }
    
    public void setVolumeLimit(Quantity newVolumeLimit) {
		this.volumeLimit = newVolumeLimit;
	}

	public void setMinimumPPU(Quantity minimumPPU) {
		this.minimumPPU = minimumPPU;
	}

	public Quantity getMinimumPPU() {
		return minimumPPU;
	}
	
	public void setSpiIP(String spiIP){
		this.spiIP = spiIP;
	}
	
	public String getSpiIP(){
		return spiIP;
	}

	public Quantity getVolumeLimit() {
		return this.volumeLimit;
	}

	/** Accessor method for a specific fueling position attribute
     * @return true if fueling position is enabled
     */    
	public boolean isValid() {
		return((this.attributes & IFuelingPosition.VALID) == IFuelingPosition.VALID);
	}
    
    /** Accessor method for a specific fueling position attribute
     * @return true if prepay is allowed
     */    
	public boolean isPrepayAllowed() {
		return((this.attributes & IFuelingPosition.PREPREPERM) == IFuelingPosition.PREPREPERM);
	}

    /** Accessor method for a specific fueling position attribute
     * @return true if post pay is allowed
     */    
	public boolean isPostpayAllowed() {
		return((this.attributes & IFuelingPosition.PREPOSTPERM) == IFuelingPosition.PREPOSTPERM);
	}

    /** Accessor method for a specific fueling position attribute
     * @return true if stacked sale is allowed
     */    
	public boolean isStackingAllowed() {
		return((this.attributes & IFuelingPosition.STACKPERM) == IFuelingPosition.STACKPERM);
	}

    /** Accessor method for a specific fueling position attribute
     * @return true if transactions have to be settled in sequence
     */    
	public boolean isFIFO() {
		return((this.attributes & IFuelingPosition.FIFO) == IFuelingPosition.FIFO);
	}

    /** Accessor method for a specific fueling position attribute
     * @return true if auto approve is enabled
     */    
	public boolean isAutoApproval() {
		return((this.attributes & IFuelingPosition.AUTOAPP) == IFuelingPosition.AUTOAPP);
	}

    /**
	 * Accesor method for a specific fueling position attribute
     * @return true if instant auto approval is enabled
     */    
	public boolean isInstantAutoApproval() {
		return((this.attributes & IFuelingPosition.INSTANT_AUTO_APPROVAL)
			== IFuelingPosition.INSTANT_AUTO_APPROVAL);
	}

    /** Accessor method for a specific fueling position attribute
     * @return true if autocollect is enabled
     */    
	public boolean isAutoCollect() {
		return((this.attributes & IFuelingPosition.AUTOCOL) == IFuelingPosition.AUTOCOL);
	}

    /** Accessor method for a specific fueling position attribute
     * @return true if PT_PERMISSION is set
     */    
	public boolean isPTPermission() {
		return((this.attributes & IFuelingPosition.PTPERM) == IFuelingPosition.PTPERM);
	}

    /** Accessor method for a specific fueling position attribute
     * @return true if autodisapproval is enabled
     */    
	public boolean isAutoDisapproval() {
		return((this.attributes & IFuelingPosition.AUTODIS) == IFuelingPosition.AUTODIS);
	}

    /** Accessor method for a specific fueling position attribute
     * @return true if handle up calling is enabled
     */    
	public boolean isHandleUpCalling() {
		return this.handleUpCalling;
	}

    /** Accessor method for a specific fueling position attribute
     * @return true if only DCR sale is allowed at the pump
     */    
	public boolean isPayAtPumpOnly() {
		return this.payAtPumpOnly;
	}

    /** Accessor method for a specific fueling position attribute
     * @return true if the pump is prepay only
     */    
	public boolean isPrepayOnly() {
		return this.prepayOnly;
	}

     /** Accessor method for a specific fueling position attribute
     * @return true if 'view buzzer off' is enabled
     */    
	public boolean isBuzzerOff() {
		return((this.attributes & IFuelingPosition.BUZOFFVIEW) == IFuelingPosition.BUZOFFVIEW);
	}

    /** Accessor method for a specific fueling position attribute
     * @return true if pump has autocollect with credit enabled
     */    
	public boolean isAutoCollectCredit() {
		return((this.attributes & IFuelingPosition.AUTOCOLCRED) == IFuelingPosition.AUTOCOLCRED);
	}

    /** Accessor method for a specific fueling position attribute
     * @return true if 'ignore preset error' is enabled
     */    
	public boolean isIGNOREFPREERR() {
		return((this.attributes & IFuelingPosition.IGNOREFPREERR) == IFuelingPosition.IGNOREFPREERR);
	}

    /** Query method to find if a parameter flag is set
     * @param flag required paramter
     * @return true if the parameter's flag is set
     */    
    public boolean getFlag(long flag) {
        if (isValidFPFlag(flag)) {
            return ((this.attributes & flag) == flag);
        }
        return false;
    }
    
    /** Setter for a parameter flag
     * @param flag required paramter
     * @param newState new value for the flag
     */    
    public void setFlag(long flag, boolean newState) {
        if (isValidFPFlag(flag)) {
            if (newState)
                this.attributes |= flag;
            else
                this.attributes &= ~flag;
        }
    }
    
    private boolean isValidFPFlag(long flag) {
        boolean flagExists = false;
        
        if ((flag == IFuelingPosition.VALID) ||
        (flag == IFuelingPosition.PREPREPERM) ||
        (flag == IFuelingPosition.PREPOSTPERM) ||
        (flag == IFuelingPosition.STACKPERM) ||
        (flag == IFuelingPosition.FIFO) ||
        (flag == IFuelingPosition.AUTOAPP) ||
        (flag == IFuelingPosition.INSTANT_AUTO_APPROVAL) ||
        (flag == IFuelingPosition.AUTOCOL) ||
        //	(flag == IFuelingPosition.PTPERM) ||
        (flag == IFuelingPosition.AUTODIS) ||
        //	(flag == IFuelingPosition.HANDLECALL) ||
        //	(flag == IFuelingPosition.CATONLY) ||
        //	(flag == IFuelingPosition.PREONLY) ||
        //	(flag == IFuelingPosition.DCRIN) ||
        //	(flag == IFuelingPosition.HOTPUMP) ||
        //	(flag == IFuelingPosition.STARTBUTTON) ||
        //		(flag == IFuelingPosition.GRADEBUTTON) ||
        //		(flag == IFuelingPosition.DCRPRESET) ||
        //		(flag == IFuelingPosition.INSTANTON) ||
        (flag == IFuelingPosition.BUZOFFVIEW) ||
        //		(flag == IFuelingPosition.LEVERPUMP) ||
        (flag == IFuelingPosition.AUTOCOLCRED) ||
        (flag == IFuelingPosition.IGNOREFPREERR))
            flagExists = true;
        return flagExists;
    }

	/**
	 * @param payAtPump the payAtPump to set
	 */
	public void setPayAtPumpOnly(boolean payAtPumpOnly) {
		this.payAtPumpOnly = payAtPumpOnly;
	}

	/**
	 * @param prepayOnly the prepayOnly to set
	 */
	public void setPrepayOnly(boolean prepayOnly) {
		this.prepayOnly = prepayOnly;
	}

	/**
	 * @param dcrInDispenser the dcrInDispenser to set
	 */
	public void setDcrInDispenser(boolean dcrInDispenser) {
		this.dcrInDispenser = dcrInDispenser;
	}

	/**
	 * @param handleUpCalling the handleUpCalling to set
	 */
	public void setHandleUpCalling(boolean handleUpCalling) {
		this.handleUpCalling = handleUpCalling;
	}

	/**
	 * @param fullServicePresetAtPump the fullServicePresetAtPump to set
	 */
	public void setFullServicePresetAtPump(boolean fullServicePresetAtPump) {
		this.fullServicePresetAtPump = fullServicePresetAtPump;
	}

	/**
	 * @return the fullServicePresetAtPump
	 */
	public boolean isFullServicePresetAtPump() {
		return fullServicePresetAtPump;
	}

	/**
	 * @return the dcrInDispenser
	 */
	public boolean isDcrInDispenser() {
		return dcrInDispenser;
	}
	
	/** Method to compare to FuelingPosition objects for equality
	 * @param obj FuelingPosition object to be compared against
	 */    
	public boolean equals(Object obj) {

		 if (this == obj) {
				return true;
			}
			if ((obj == null) || !(obj instanceof FuelingPosition)) {
				return false;
			}
			FuelingPosition aFP = (FuelingPosition) obj;
			
			return new EqualsBuilder().append(this.identifier, aFP.identifier)
									  .append(this.blendType, aFP.blendType)
									  .append(this.currentServiceLevel, aFP.currentServiceLevel)
									  .append(this.dcrInDispenser, aFP.dcrInDispenser)
									  .append(this.defaultMOP, aFP.defaultMOP)
									  .append(this.fullServicePresetAtPump, aFP.fullServicePresetAtPump)
									  .append(this.handleUpCalling, aFP.handleUpCalling)
									  .append(this.payAtPumpOnly, aFP.payAtPumpOnly)
									  .append(this.prepayOnly, aFP.prepayOnly)
									  .append(this.slowFlowOffset,aFP.slowFlowOffset)
									  .append(this.currencyLimit, aFP.currencyLimit)
									  .append(this.volumeLimit, aFP.volumeLimit)
									  .append(this.minimumPPU, aFP.minimumPPU)
									  .append(this.spiIP, aFP.spiIP)
									  .append(this.attributes, aFP.attributes)
									  .append(this.hoses, aFP.hoses)
									  .isEquals();		
	}

	/** Method override since equals() is implemented
	 * @return hash code for the object
	 */    
	public int hashCode() {
		return new HashCodeBuilder(19, 29).append(this.identifier)
		  .append(this.blendType)
		  .append(this.currentServiceLevel)
		  .append(this.dcrInDispenser)
		  .append(this.defaultMOP)
		  .append(this.fullServicePresetAtPump)
		  .append(this.handleUpCalling)
		  .append(this.payAtPumpOnly)
		  .append(this.prepayOnly)
		  .append(this.slowFlowOffset)
		  .append(this.currencyLimit)
		  .append(this.volumeLimit)
		  .append(this.minimumPPU)
		  .append(this.spiIP)
		  .append(this.attributes)
		  .append(this.hoses)
		  .toHashCode();
	}


}



