/*
 * MOPConvertResponse.java
 *
 * Created on December 14, 2003, 9:45 PM
 */

package com.verifone.isd.vsms2.fuel.ent.util;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;

import java.io.Serializable;

/**
 *
 * @author  D. Michael Barton
 */
public class MOPConvertResponse implements Serializable {
    
	private static final long serialVersionUID = -1587003662272903967L;


	private short fuelingPosition = 0;
	

	private MoneyAmount mopConvertAmount = null; //The total amount after conversion 
	private int mopConv = 0; //The new price level
	private MoneyAmount mopConvPrice = null; //The new PPU
	/*
	 * The difference between original amount at the pump and the amount to be paid
	 */
	private MoneyAmount mopConvAdjustment;

    
    /** Creates a new instance of MOPConvertResponse */
    public MOPConvertResponse() {
    }
 
    /**
     * Constructor
     * 
     * @param fuelingPosition
     * @param mopConvertAmount, the total amount after conversion 
     * @param mopConv, the new price level
     * @param mopConvPrice, the new PPU
     * @param adjAmount adjustment from original amount
     */
    public MOPConvertResponse(short fuelingPosition, MoneyAmount mopConvertAmount, int mopConv, MoneyAmount mopConvPrice, MoneyAmount adjAmount) {

        this.fuelingPosition = fuelingPosition;
        this.mopConvertAmount = mopConvertAmount; 
        this.mopConv = mopConv;
        this.mopConvPrice = mopConvPrice;
        this.mopConvAdjustment = adjAmount;
    }
 
    public short getFuelingPosition() {
        return(this.fuelingPosition);
    }
 
    public MoneyAmount getMOPConvertAmount() {
        return(this.mopConvertAmount);
    }
    
    public MoneyAmount getPricePerVolume() {
    	return(this.mopConvPrice);
    }
    
    public int getPriceLevel() {
    	return(this.mopConv);
    }
    
    public void setFuelingPosition(short fuelingPosition) {
		this.fuelingPosition = fuelingPosition;
	}

	public void setMOPConvertAmount(MoneyAmount mopConvertAmount) {
		this.mopConvertAmount = mopConvertAmount;
	}

	/**
	 * Set the new price level 
	 * @param mopConv
	 */
	public void setMOPconv(int mopConv) {
		this.mopConv = mopConv;
	}

	/**
	 * Set the new PPU
	 * 
	 * @param mopConvPrice
	 */
	public void setMOPconvPrice(MoneyAmount mopConvPrice) {
		this.mopConvPrice = mopConvPrice;
	}

	public MoneyAmount getMopConvAdjustment() {
		if(null == mopConvAdjustment) {
			mopConvAdjustment = new MoneyAmount(0);
		}
		return mopConvAdjustment;
	}

	public void setMopConvAdjustment(MoneyAmount mopConvAdjustment) {
		this.mopConvAdjustment = mopConvAdjustment;
	}
	
}
