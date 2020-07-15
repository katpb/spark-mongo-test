package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import com.verifone.isd.vsms2.sys.l10n.FuelViewRes;
import com.verifone.isd.vsms2.sys.l10n.LocalizedRB;
import com.verifone.isd.vsms2.sys.util.ISapphireCollection;

import com.verifone.isd.vsms2.sys.util.Quantity;

/**
 *  Intermediate class used to set the fueling position parameters. 
 *  The contained objects are transfered to FuelingPosition object. 
 *
 *  @author "mailto:bhanu_narayanan@verifone.com"
 */
public class FuelingPositionParameters {
    private FuelHose[] hoses;
    private Quantity limit;
    private int currentServiceLevelNum;
    private int defaultMOPNum;
    private int blendTypeNum;
    private int slowFlowOffset;
    private long attributes;
    private int currentState = 0; //FuelingPositionEvent.UNKNOWN;
    private IFuelSite fuelSite;
    
    /**
     *  Initializes the object with the fueling position attributes
     *  @param currSLNum	current service level number
     *  @param defMOPNum default MOP number
     *  @param fpHoses the hose objects that are applicable to the fueling position
     *  @param limit specifies the maximum quantity per sale and the limiting attribute (volume/ amount)
     *  @param sfo slow flow offset
     *  @param attributes 
     * @exception FuelException if invalid parameters are passed to the constructor
     */
    public FuelingPositionParameters(int currSLNum, int defMOPNum, int blendTypeNum, FuelHose[] fpHoses, 
    Quantity limit, int sfo, long attributes, int currentState, IFuelSite fuelSite) throws FuelException {
        if ((currSLNum <= 0) || (defMOPNum <= 0) || (fpHoses == null) || (limit == null)) {
            throw new FuelException(FuelViewRes.ERROR_FP_PARMS_NOT_INIT, LocalizedRB.FUELVIEW_RESOURCE);

        }
        
        this.currentServiceLevelNum = currSLNum;
        this.defaultMOPNum = defMOPNum;
        this.blendTypeNum = blendTypeNum;
        this.hoses = fpHoses;
        this.limit = limit;
        this.slowFlowOffset = sfo;
        this.attributes = attributes;
        this.currentState = currentState;
        this.fuelSite = fuelSite;
    }
    
    /**
     *  Returns the current service level object
     *  @exception FuelException if current service level is invalid or fuel site is uninitialized
     */
    public FuelServiceLevel getCurrentServiceLevel() throws FuelException {
        if (currentServiceLevelNum == 0) {
            throw new FuelException(FuelViewRes.ERROR_FP_PARMS_NOT_INIT, LocalizedRB.FUELVIEW_RESOURCE);
        }
        return getServiceLevel(currentServiceLevelNum);
    }
    
    /**
     *  Returns the current service level number
     */
    public int getCurrentServiceLevelNum() {
        return currentServiceLevelNum;
    }
    
    /**
     *  Returns the default MOP number
     */
    public int getDefaultMOPNum() {
        return defaultMOPNum;
    }
    
    /**
     *  Returns the blend type number
     */
    public int getBlendTypeNum() {
        return blendTypeNum;
    }
    
    /**
     *  Obtains the default MOP object
     *  @exception FuelException if default MOP number is invalid or fuel site is uninitialized
     */
    public FuelMOP getDefaultMOP() throws FuelException {
        if (defaultMOPNum == 0) {
            throw new FuelException(FuelViewRes.ERROR_FP_PARMS_NOT_INIT, LocalizedRB.FUELVIEW_RESOURCE);
        }
        return getMOP(defaultMOPNum);
    }
    
    /**
     *  Obtains the default MOP object
     *  @exception FuelException if default MOP number is invalid or fuel site is uninitialized
     */
    public FuelBlendType getBlendType() throws FuelException {
        if (blendTypeNum == 0) {
            throw new FuelException(FuelViewRes.ERROR_FP_PARMS_NOT_INIT, LocalizedRB.FUELVIEW_RESOURCE);
        }
        return getBlendType(blendTypeNum);
    }
    /**
     *  Returns the service level object for a given service level number
     *  @param number service level number
     *  @exception FuelException if service level number is invalid or fuel site is uninitialized
     */
    public FuelServiceLevel getServiceLevel(int number) throws FuelException {
        ISapphireCollection sl = this.fuelSite.getServiceLevelColl();
        return (FuelServiceLevel)sl.get(new Integer(number));
    }
    
    /**
     *  Returns the MOP object for a given MOP number
     *  @param number MOP number
     *  @exception FuelException if MOP number is invalid or fuel site is uninitialized
     */
    public FuelMOP getMOP(int number) throws FuelException {
        ISapphireCollection mop = this.fuelSite.getMOPColl();
        return (FuelMOP)mop.get(new Integer(number));
    }
    
    /**
     *  Returns the blend type object for a given blend type number
     *  @param number blend type number
     *  @exception FuelException if blend type number is invalid or fuel site is uninitialized
     */
    public FuelBlendType getBlendType(int number) throws FuelException {
        ISapphireCollection blend = this.fuelSite.getBlendTypeColl();
        return (FuelBlendType)blend.get(new Integer(number));
    }
    
    /**
     *  Returns the hose objects
     */
    public FuelHose[] getHoses() {
        return hoses;
    }
    
    /**
     *  Returns the limit object
     */
    public Quantity getLimit() {
        return limit;
    }
    
    /**
     *  Returns the slow flow offset value
     */
    public int getSlowFlowOffset() {
        return slowFlowOffset;
    }
    
    /**
     *  Returns the fueling position attributes
     */
    public long getAttributes() {
        return attributes;
    }
    
    /**
     *  Returns the fueling position state
     */
    public int getCurrentState() {
        return currentState;
    }
}


