package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import com.verifone.isd.vsms2.fuel.ent.FuelEntityVisitor;
import com.verifone.isd.vsms2.sys.util.ISapphireCollection;
import com.verifone.isd.vsms2.sys.util.Quantity;

/**
 *  Interface to return the singleton fuel site object. Any operation on the
 *  fuel site object is through this interface.
 *  @author Bhanu Narayanan "mailto:bhanu_narayanan@verifone.com"
 *  @version 1.0
 */
public interface IFuelSite {
    /**
     * Maximum fueling positions supported by Ruby
     */
    public static final int DEFAULT_MAX_POSITIONS = 64;
    /**
     * Maximum fuel service levels supported by Ruby
     */
    public static final int MAX_SERVICELEVELS = 3;
    /**
     * Maximum MOPs supported by Ruby
     */
    public static final int MAX_MOPS = 2;
    /**
     * Maximum tanks supported by Ruby
     */
    public static final int MAX_TANKS = 20;
    /**
     * Maximum tiers supported by Ruby
     */
    public static final int MAX_TIERS = 2;
    /**
     * Maximum products supported by Ruby
     */
    public static final int MAX_PRODUCTS = 20;
    /**
     * Maximum blender types supported by Ruby
     */
    public static final int MAX_BLENDTYPES = 6;
    /**
     * Constant used to get the fuel transactions history (vfuelhoserept) for the current period
     */
    public static final int CURRENT_PERIOD = 0;
    /**
     * Constant used to get the fuel transactions history (vfuelhoserept) for the previous period
     */
    public static final int PREVIOUS_PERIOD = 1;
    
    /**
     * Maximum auto disapproval delay in seconds
     */
    public static final int MAX_AUTODISAPPROVALDELAY = 600;
    
    /**
     * Maximum PPU decimal position
     */
    public static final int MAX_PPUDECPOSITION = 3;
    
    public static final String DEFAULT_VOLUME_UOM = "USG";
    
    /**
     * Maximum Total decimal position
     */
    public static final int MAX_TOTALDECPOSITION = 2;
    /**
     * MAximum value NAXML Fuel Grade ID
     */
    public static final int MAX_NAX_FUELGRADEID = 9999;
    
    /**
     *  Gets the ISapphireCollection interface of the available fueling positions
     *  owned by the fuel site object
     *  @return fueling positions collection
     *  @exception FuelException thrown  if the fuel site is not initialized
     */
    public ISapphireCollection getFuelingPositionColl() throws FuelException;
    
    /**
     *  Sets the ISapphireCollection interface of the available fueling positions
     *  owned by the fuel site object
     *  @param fpColl - a FuelingPosition collection
     *  @exception FuelException thrown  if the fuel site is not initialized
     */
    public void setFuelingPositionColl(ISapphireCollection fpColl) throws FuelException;
    
    /**
     *  Gets the ISapphireCollection interface of the available fuel service levels
     *  @return fuel service levels collection
     *  @exception FuelException thrown  if the fuel site is not initialized
     */
    public ISapphireCollection getServiceLevelColl() throws FuelException;
    
    /**
     *  Gets the ISapphireCollection interface of the available fuel MOPs
     *  @return fuel MOPs collection
     *  @exception FuelException thrown  if the fuel site is not initialized
     */
    public ISapphireCollection getMOPColl() throws FuelException;
    
    /**
     *  Gets the ISapphireCollection interface of the available fuel tanks
     *  @return fuel tanks collection
     *  @exception FuelException thrown  if the fuel site is not initialized
     */
    public ISapphireCollection getTankColl() throws FuelException;
    
    /**
     *  Gets the ISapphireCollection interface of the available NAX fuel product
     *  @return NAX fuel products collection
     *  @exception FuelException thrown  if the fuel site is not initialized
     */
    public ISapphireCollection getNAXFuelProductColl() throws FuelException;
    
    /**
     *  Gets the current tier in effect
     *  @return NAX int tier index
     *  @exception FuelException thrown  if the fuel site is not initialized
     */
    public int getCurrentTierIndex() throws FuelException;
    
    /**
     *  Sets the current tier in effect
     *  @param newIndex - target tier
     *  @exception FuelException thrown  if the fuel site is not initialized
     */
    public void setCurrentTierIndex(int newIndex) throws FuelException;
    
    /**
     *  Gets the ISapphireCollection interface of the available fuel tiers
     *  @return fuel tiers collection
     *  @exception FuelException thrown  if the fuel site is not initialized
     */
    public ISapphireCollection getTierColl() throws FuelException;
    
    /**
     *  Gets the ISapphireCollection interface of the available fuel products
     *  @return fuel products collection
     *  @exception FuelException thrown  if the fuel site is not initialized
     */
    public ISapphireCollection getProductColl() throws FuelException;
    
    /**
     *  Gets the ISapphireCollection interface of the available blend types
     *  @return fuel blend type collection
     *  @exception FuelException thrown  if the fuel site is not initialized
     */
    public ISapphireCollection getBlendTypeColl() throws FuelException;
    /** Getter for unit of measure
     * @return Unit of Measure
     * @exception FuelException thrown  if the fuel site is not initialized
     */
    public String getUOM() throws FuelException;
    
    /** Query method for 'ignore MOP conflict'
     * @return true if 'ignore MOP conflict' is set
     */    
    public boolean isIgnoreMOPConflict();

    /** Query method for 'six digits protocol'
     * @return true if 'six digits protocol' is set
     */    
    public boolean isSixDigitsProtocol();

    /** Getter for halt mode
     * @return halt mode
     */    
    public String getHaltMode();
  
    /** Getter for auto disapproval delay
     * @return auto disapproval delay
     */    
    public Quantity getAutoDisapprovalDelay();
    /** Getter for post pay begin hour
     * @return post pay begin hour
     */    
    public int getStartPostpayHrs();
    /** Getter for number of post pay hours
     * @return number of post pay hours
     */    
    public int getNumPostpayHrs();
    /** Getter for manual approval begin hour
     * @return manual approval begin hour
     */    
    public int getStartManApprovalHrs();
    /** Getter for number of manual approval hours
     * @return number of manual approval hours
     */    
    public int getNumManApprovalHrs();
    /** Query method for 'approve all enabled pumps'
     * @return true if 'approve all enabled pumps' is set
     */    
    public boolean isApproveAllEnabled();
    /** Query method for 'force .9 cents per gallon'
     * @return true if 'force .9 cents per gallon' is set
     */    
    public boolean isForcePt9CentsPerGal();
    /** Query method for 'journal cashier approval'
     * @return true if 'journal cashier approval' is set
     */    
   
    public boolean isAutoCollectInside();
    
    
    /** Query method for 'Sale Data Frequency'
     * @return return frequency(milli Seconds) in which sale data should be send to client
     */    
    public long getSaleDataFreq();
    
    /** Getter for current tier
     * @return currently active tier
     * @exception FuelException thrown  if the fuel site is not initialized
     */
    public FuelTier getCurrentTier() throws FuelException;
    
    /** Getter for price per unit decimal position
     * @return PPU decimal position
     * @exception FuelException thrown  if the fuel site is not initialized
     */
    public int getPPUDecPosition() throws FuelException;
    
    /** Getter for total number of  decimal positions
     * @return Total decimal position
     * @exception FuelException thrown  if the fuel site is not initialized
     */
    public int getTotalDecPosition() throws FuelException;
    
    /** Getter for FP Offline Notify setting
     * @return fpOfflineNotify
     * @exception FuelException thrown  if the fuel site is not initialized
     */
    public int getFPOfflineNotify() throws FuelException;
    
    /**
     *  sets the UOM
     *  @param UOM the new UOM string
     */
    public void setUOM(String UOM);
    
    /** Setter for 'ignore MOP conflict'
     * @param newVal true to enable feature
     */    
    public void setIgnoreMOPConflict(boolean newVal);

    /** Setter for 'six digits protocol'
     * @param newVal true to enable this protocol
     */    
    public void setSixDigitsProtocol(boolean newVal);

    /** Setter fro halt mdoe
     * @param haltMode new halt mode
     */    
    public void setHaltMode(String haltMode);
   
    /** Setter for auto disapproval delay
     * @param delay auto disapproval delay
     * @throws FuelException in invalid parameter value
     */    
    public void setAutoDisapprovalDelay(Quantity delay) throws FuelException;
    /** Setter for post pay begin hour
     * @param startHr post pay begin hour
     * @throws FuelException on invalid parameter value
     */    
    public void setStartPostpayHrs(int startHr) throws FuelException;
    /** Setter for number of post pay hours
     * @param numHrs number of post pay hours
     * @throws FuelException on invalid parameter value
     */    
    public void setNumPostpayHrs(int numHrs) throws FuelException;
    /** Setter for manual approval begin hour
     * @param startHr manual approval begin hour
     * @throws FuelException on invalid parameter value
     */    
    public void setStartManApprovalHrs(int startHr) throws FuelException;
    /** Setter for number of manual approval hours
     * @param numHrs umber of manual approval hours
     * @throws FuelException on invalid parameter value
     */    
    public void setNumManApprovalHrs(int numHrs) throws FuelException;
    /** Setter for tier2 begin hour
     * @param startHr tier2 begin hour
     * @throws FuelException on invalid parameter value
     */    
    public void setStartTier2Hrs(int startHr) throws FuelException;
    /** Setter for number of tier2  hours
     * @param numHrs number of tier2 approval hours
     * @throws FuelException on invalid parameter value
     */
    public void setNumTier2Hrs(int numHrs) throws FuelException;
    /** Setter for tier 2 values
     * @param startHr tier 2 begin hour
     * @param numHrs tier 2 number of hours
     * @throws FuelException on invalid parameter values
     */    
    public void setTier2(int startHr, int numHrs) throws FuelException;
    /** Setter for 'approve all enabled pumps'
     * @param newVal true to enable feature
     */    
    public void setApproveAllEnabled(boolean newVal);
    /** Setter for 'force .9 cents per gallon'
     * @param newVal true to enable feature
     */    
    public void setForcePt9CentsPerGal(boolean newVal);
  
    /** Setter for 'autocollect inside'
     * @param newVal true to enable feature
     */    
    public void setAutoCollectInside(boolean newVal);
    
    /** Setter for 'Sale Data Frequency'
     * @param newVal long value represent the frequency(milli Seconds) in which sale data should be send to client
     */    
    public void setSaleDataFreq(long newVal);
    
    /** Setter for current tier
     * @param number currently active tier
     * @exception FuelException thrown  if the fuel site is not initialized
     */
    public void setCurrentTier(int number) throws FuelException;
    
    /** Setter for PPU decimal position
     * @param ppuDecPosition PPU decimal position
     * @exception FuelException thrown  if the fuel site is not initialized
     */
    public void setPPUDecPosition(int ppuDecPosition) throws FuelException;
    
    /** Setter for Total decimal position
     * @param totalDecPosition Total decimal position
     * @exception FuelException thrown  if the fuel site is not initialized
     */
    public void setTotalDecPosition(int totalDecPosition) throws FuelException;
    
    /** This method calls back into the FuelVisitor#visit() method of the visitor object
     * @param v visitor
     * @exception Exception if the visitor encounters any error during XML serialization/ parsing
     */
    public void accept(FuelEntityVisitor v) throws Exception;
    
   
    public boolean isAutoSettleOverrunEnabled();
    
    /** Setter for property autoSettleOverrunEnabled.
     * @param autoSettleOverrunEnabled New value of property autoSettleOverrunEnabled.
     *
     */
    public void setAutoSettleOverrunEnabled(boolean autoSettleOverrunEnabled);
    
    /**
     *  Setter for fuel product
     * @param fuelProductColl
     */
    public void setFuelProductColl(ISapphireCollection fuelProductColl);

    /**
     *  Setter for FP OFFLINE NOTIFY
     * @param newFPOfflineNotify
     */
    public void setFPOfflineNotify(int newFPOfflineNotify) throws FuelException;
    
    /** Query method for 'fuel price change happened'
     * @return true if 'price change' is set
     */    
    public boolean isPriceChanged();
    
    /** Setter method for 'fuel price change happened'
     * @param priceChanged
     */
	public void setPriceChanged(boolean priceChanged);	
    
    /**
     * Derives all fuel products available on specified fuel point.
     * 
     * @param fp				FuelPoint
     * @return FuelProduct[] 	Products available for selection
     * @author Satish_P1
     */
	public FuelProduct[] findGradesOnPump(int fp);

    /**
     * Verify if "prompt for grade restriction outside" flag is set
     * @return boolean
     */
	public boolean getPromptRestrictionOutside();

    /**
     * Setter method for "prompt for grade restriction outside" flag.
     * @param isTrue
     */
	public void setPromptRestrictionOutside(boolean promptRestrictionOutside) ;

    /**
     * Verify if "prompt for grade restriction inside" flag is set
     * @return boolean
     */
	public boolean getEnforcePromptingInside() ;

    /**
     * Setter method for "prompt for grade restriction inside" flag.
     * @param isTrue
     */
	public void setEnforcePromptingInside(boolean enforcePromptingInside) ;

	public int getStartTier2Hrs();

	public int getNumTier2Hrs();
	
	/**
	 * getter method for 'inEffectRCF'
	 * 
	 * @return int
	 */
	public int getInEffectRapidChangeConfig();
	
	/**
	 * setter method for 'inEffectRCF'
	 * 
	 * @param inEffectRCF
	 */
	public void setInEffectRapidChangeConfig(int inEffectRCF);
	
	/**
	 * Setter for Require Attendant FSA card
	 * @param requireAttendantCard
	 */
	public void setRequireAttendantCard(boolean requireAttendantCard);
	
	/**
	 * Getter for Require Attendant FSA Card 
	 * @return
	 */
	public boolean getRequireAttendantCard();
}
