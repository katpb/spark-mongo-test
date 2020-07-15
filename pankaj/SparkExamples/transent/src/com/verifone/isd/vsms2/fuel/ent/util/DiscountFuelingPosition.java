package com.verifone.isd.vsms2.fuel.ent.util;

import java.io.Serializable;
import java.util.Map;

public class DiscountFuelingPosition implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8278580904057036956L;
	private short fuelingPosition;
    private PpgDiscDetails ppgDiscDetails;
    private short discountPriceLevel;
    private short systemPriceLevel;
    private short durationMode;
    private short adjustMode;
    private short outOfRangeRule;
    private short pumpCallInRule;

    public short getFuelingPosition() {
		return fuelingPosition;
	}

	public void setFuelingPosition(short fuelingPosition) {
		this.fuelingPosition = fuelingPosition;
	}

	public DiscountFuelingPosition (short fuelingPosition){
        this.fuelingPosition = fuelingPosition;
    }

	public void setDiscountPriceLevel(short discountPriceLevel) {
		this.discountPriceLevel = discountPriceLevel;
	}

	public short getDiscountPriceLevel() {
		return discountPriceLevel;
	}

	public void setSystemPriceLevel(short systemPriceLevel) {
		this.systemPriceLevel = systemPriceLevel;
	}

	public short getSystemPriceLevel() {
		return systemPriceLevel;
	}

	public void setDurationMode(short durationMode) {
		this.durationMode = durationMode;
	}

	public short getDurationMode() {
		return durationMode;
	}

	public void setAdjustMode(short adjustMode) {
		this.adjustMode = adjustMode;
	}

	public short getAdjustMode() {
		return adjustMode;
	}

	public void setOutOfRangeRule(short outOfRangeRule) {
		this.outOfRangeRule = outOfRangeRule;
	}

	public short getOutOfRangeRule() {
		return outOfRangeRule;
	}

	public void setPumpCallInRule(short pumpCallInRule) {
		this.pumpCallInRule = pumpCallInRule;
	}

	public short getPumpCallInRule() {
		return pumpCallInRule;
	}

	public void setPpgDiscDetails(PpgDiscDetails ppgDiscDetails) {
		this.ppgDiscDetails = ppgDiscDetails;
	}

	public PpgDiscDetails getPpgDiscDetails() {
		return ppgDiscDetails;
	}


}