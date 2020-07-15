package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import com.verifone.isd.vsms2.fuel.ent.FuelEntityVisitor;
import com.verifone.isd.vsms2.sys.util.Quantity;

/**
 *  Interface for Fueling position object.
 *  The methods help to query the fueling position object, register/ remove
 *  listeners and to control operations on the fueling position.
 *
 *  @author David Ezell "mailto:david_ezell@verifone.com"
 *  @version 1.0
 */
public interface IFuelingPosition {
    /**
     * Maximum fuel hoses in a fueling position
     */
    public static final int MAX_HOSES = 7;
    
    /*
     * Bits representing the attributes of a fueling position
     */
    /** FuelingPosition bitmask to query for specific attribute*/      
    public static final long VALID          = 0x00000001L;
    /** FuelingPosition bitmask to query for specific attribute - PREPAY_ALLOWED*/      
    public static final long PREPREPERM     = 0x00000002L;
    /** FuelingPosition bitmask to query for specific attribute - POSTPAY_ALLOWED*/      
    public static final long PREPOSTPERM    = 0x00000004L;
    /** FuelingPosition bitmask to query for specific attribute - STACKING_ALLOWED*/      
    public static final long STACKPERM      = 0x00000008L;
    /** FuelingPosition bitmask to query for specific attribute - FIRST_IN_FIRST_OUT*/      
    public static final long FIFO           = 0x00000010L;
    /** FuelingPosition bitmask to query for specific attribute - AUTO_APPROVAL*/      
    public static final long AUTOAPP        = 0x00000020L;
    /** FuelingPosition bitmask to query for specific attribute - AUTO_COLLECT*/      
    public static final long AUTOCOL        = 0x00000040L;
    /** FuelingPosition bitmask to query for specific attribute - PT_PERMISSION*/      
    public static final long PTPERM         = 0x00000080L;
    /** FuelingPosition bitmask to query for specific attribute - AUTO_DISAPPROVAL*/      
    public static final long AUTODIS        = 0x00000100L;
    /** FuelingPosition bitmask to query for specific attribute - HANDLE_UP_CALLING*/      
    public static final long HANDLECALL     = 0x00000200L;
    /** FuelingPosition bitmask to query for specific attribute - CAT_ONLY*/      
    public static final long CATONLY        = 0x00000400L;
    /** FuelingPosition bitmask to query for specific attribute - PREPAY_ONLY*/      
    public static final long PREONLY        = 0x00000800L;
    /** FuelingPosition bitmask to query for specific attribute - DCR_IN_DISPENSER*/      
    public static final long DCRIN          = 0x00001000L;
    /** FuelingPosition bitmask to query for specific attribute - HOT_PUMP*/      
    public static final long HOTPUMP        = 0x00002000L;
    /** FuelingPosition bitmask to query for specific attribute - START_SWITCH*/      
    public static final long STARTBUTTON    = 0x00004000L;
    /** FuelingPosition bitmask to query for specific attribute - GRADE_SWITCH*/      
    public static final long GRADEBUTTON    = 0x00008000L;
    /** FuelingPosition bitmask to query for specific attribute - FULL_SERVICE_PRESET*/      
    public static final long DCRPRESET      = 0x00010000L;
    /** FuelingPosition bitmask to query for specific attribute - INSTANT_ON*/      
    public static final long INSTANTON      = 0x00020000L;
    /** FuelingPosition bitmask to query for specific attribute - BUZZER_OFF*/      
    public static final long BUZOFFVIEW     = 0x00040000L;
    /** FuelingPosition bitmask to query for specific attribute - LEVER_SWITCH*/      
    public static final long LEVERPUMP      = 0x00080000L;
    /** FuelingPosition bitmask to query for specific attribute - AUTO_COLLECT_CREDIT*/      
    public static final long AUTOCOLCRED    = 0x00100000L;
    /** FuelingPosition bitmask to query for specific attribute */      
    public static final long IGNOREFPREERR  = 0x00200000L;
    /** FuelingPosition bitmask to query for specific attribute - INSTANT_AUTO_APPROVAL */      
    public static final long INSTANT_AUTO_APPROVAL  = 0x00400000L;
    
    /** List of all attributes */    
    public static final String ALL_ATTRIBUTES = "VALID PREPREPERM PREPOSTPERM STACKPERM FIFO AUTOAPP AUTOCOL PTPERM AUTODIS HANDLECALL	CATONLY	PREONLY	DCRIN HOTPUMP STARTBUTTON GRADEBUTTON DCRPRESET	INSTANTON BUZOFFVIEW LEVERPUMP AUTOCOLCRED IGNOREFPREERR";
    
    /** Getter for the current service level for the fueling position
     * @return the current service level for the fueling position
     * @exception FuelException if the fueling position is not initialized
     */
    public int getServiceLevel() throws FuelException;

    /** Getter for the default MOP for the fueling position
     * @return the default MOP for the fueling position
     * @exception FuelException if the fueling position is not initialized
     */
    public int getMOP() throws FuelException;
    /** Getter for the blend type for the fueling position
     * @return the blend type for the fueling position
     * @exception FuelException if the fueling position is not initialized
     */
    public int getBlendType() throws FuelException;

    /** getter for array of hoses attached to the fueling position
     * @return array of hoses attached to the fueling position
     * @exception FuelException if the fueling position is not initialized
     */
    public FuelHose[] getHoses() throws FuelException;
    
    /** Get hoses assigned to the pump
     * that have distinct products assigned
     * @see IFuelingPosition#getDistinctHoses
     * @return hoses
     */
    public FuelHose[] getHosesWithDistinctProducts()throws FuelException;
    
    /** Getter for specific hose attached to the fueling position
     * @param hoseID ID of the required hose
     * @return specified hose attached to the fueling position
     * @exception FuelException if the fueling position is not initialized
     */
    public FuelHose getHose(int hoseID) throws FuelException;
    
    /** Getter for limit set for the fueling position 
     * @return currencyLimit set for the fueling position 
     * @exception FuelException if the fueling position is not initialized
     * @see com.verifone.isd.vsms2.sys.util.Quantity
     * @see com.verifone.isd.vsms2.sys.util.MoneyAmount
     */
    public Quantity getCurrencyLimit() throws FuelException;
    
    /** Getter for slow flow offset value for the fueling position
     * @return slow flow offset value for the fueling position
     */
    public int getSlowFlowOffset();
    
    /** Getter for fueling position ID
     * @return the fueling position ID
     */
    public int getID();
    
    /** Getter for attributes of the fueling position
     * @return attributes of the fueling position
     */
    public long getAttributes();
    
    /**  Sets the hose object array for the fueling position
     * @param newHoses the array of hoses assigned to the fueling position
     * @exception FuelException on invalid parameter
     */
    public void setHoses(FuelHose[] newHoses) throws FuelException;
    
    /**  Sets a hose object
     * @param hoseID hose ID
     * @param prodID product ID
     * @exception FuelException on invalid parameter values
     */
    public void setHose(int hoseID, int prodID) throws FuelException;
    
    /**
     *  Sets the fuel currency limit 
     *  @param newLimit the limit object
     */
    public void setCurrencyLimit(Quantity newLimit);
    
    /**
     *  Sets the fueling position attributes
     *  @param newAttributes the new attribute bitmap for the fueling position
     *  @see IFuelingPosition
     */
    public void setAttributes(long newAttributes);
    
    /**
     *  Sets the slow flow offset
     *  @param newSFO   the new slow flow offset value
     */
    public void setSlowFlowOffset(int newSFO);
    
    /**
     *  Sets the current service level
     *  @param newSLNum   current service level ID
     *  @exception FuelException if fuel site is not initialized
     */
    public void setServiceLevel(int newSLNum) throws FuelException;
    
    /**
     *  Sets the default MOP
     *  @param newMOPNum   default MOP ID
     *  @exception FuelException if fuel site is not initialized
     */
    public void setMOP(int newMOPNum) throws FuelException;
    
    /**
     *  Sets the blend type
     *  @param newBlendNum   blend type ID
     *  @exception FuelException if fuel site is not initialized
     */
    public void setBlendType(int newBlendNum) throws FuelException;
    
    /**
     * 
     * @param defaultLimit
     * @throws FuelException
     */
    public void setVolumeLimit(Quantity defaultLimit) throws FuelException ;
		
	/**
	 * Sets the Minimum Price per Unit
	 * @param mimimumPPU
	 * @throws FuelException
	 */
    public void setMinimumPPU(Quantity mimimumPPU) throws FuelException ;
	
    /**
     * Getter for  Minimum Price per Unit for the Fueling Position
     * @return    the minimum PPU 
     * @throws FuelException
     */
	public Quantity getMinimumPPU() throws FuelException ;
	
	/**
	 * Sets the spiIP for the Fueling Position
	 * @param spi IP
	 * @throws FuelException
	 */
    public void setSpiIP(String spiIP) throws FuelException ;
	
    /**
     * Getter for  spiIP for the Fueling Position
     * @return    the spi IP 
     * @throws FuelException
     */
	public String getSpiIP() throws FuelException;
	
    /**
     * Getter for the volume Limit for the Fueling Position
     * @return the volumeLimit
     * @throws FuelException
     */
	public Quantity getVolumeLimit() throws FuelException;
	
    
	/**
	 * Checks whether the Fueling Position is configured.
	 * @return
	 */
    public boolean isValid();

    /** Method to query if a parameter is set
     * @param flag parameter type
     * @return true if parameter is set
     */    
    public boolean getFlag(long flag);
    
    
    public boolean isDcrInDispenser();
    
    public boolean isHandleUpCalling();
    
    public boolean isAutoApproval();
    
	public boolean isInstantAutoApproval();
	
	public boolean isFullServicePresetAtPump();
    
    public boolean isPrepayOnly();
    
    public boolean isPayAtPumpOnly();
        
    
    /** Setter for a parameter flag
     * @param flag parameter
     * @param newState new value
     */    
    public void setFlag(long flag, boolean newState);
    
	/**
	 * @param payAtPump the payAtPump to set
	 */
	public void setPayAtPumpOnly(boolean payAtPumpOnly) ;

	/**
	 * @param prepayOnly the prepayOnly to set
	 */
	public void setPrepayOnly(boolean prepayOnly); 

	/**
	 * @param dcrInDispenser the dcrInDispenser to set
	 */
	public void setDcrInDispenser(boolean dcrInDispenser);
	
	/**
	 * @param handleUpCalling the handleUpCalling to set
	 */
	public void setHandleUpCalling(boolean handleUpCalling);


	/**
	 * @param fullServicePresetAtPump the fullServicePresetAtPump to set
	 */
	public void setFullServicePresetAtPump(boolean fullServicePresetAtPump); 
		
    
    /** This method calls back into the FuelVisitor#visit() method of the visitor object
     * @param v visitor
     * @exception Exception on error in the visitor's visit method
     */
    public void accept(FuelEntityVisitor v) throws Exception;
}
