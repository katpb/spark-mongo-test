/*
 * Created on Apr 21, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.verifone.isd.vsms2.sales.ent.trans;

import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import com.verifone.isd.vsms2.sys.util.Volume;

/**
 * @author Anindya_D1
 * 
 * Extension of the FuelItemLine in case of a pump overrun. Some applications
 * require that we subtract the overrun amount before charging a credit card
 * customer (as in a fast credit completion).
 */
public class OverrunItemLine extends FuelItemLine {
	
	
	private static final long serialVersionUID = -8691670854267087849L;
	private Volume overVolume;	/* overrun volume */
	private MoneyAmount overAmount;	/* overrun amount */
	private boolean dcrOverrun;	/* indicates if the overrun resulted from a fast credit fuel only or DCR transaction */
	private boolean autoSettled;	/* overrun automatically settled or no.  */

	/**
	 * 
	 */
	public OverrunItemLine() {
		overAmount = new MoneyAmount(0);
		overVolume = new Volume(0);
	}

	/**
	 * @return Returns the overAmount.
	 */
	public MoneyAmount getOverAmount() {
		return overAmount;
	}
	/**
	 * @param overAmount The overAmount to set.
	 */
	public void setOverAmount(MoneyAmount overAmount) {
		if (overAmount != null) {
			this.overAmount = overAmount;
		}
	}
	/**
	 * @return Returns the overVolume.
	 */
	public Volume getOverVolume() {
		return overVolume;
	}
	/**
	 * @param overVolume The overVolume to set.
	 */
	public void setOverVolume(Volume overVolume) {
		if (overVolume != null) {
			this.overVolume = overVolume;
		}
	}

	/**
	 * @return the dcrOverrun
	 */
	public boolean isDcrOverrun() {
		return dcrOverrun;
	}

	/**
	 * @param dcrOverrun the dcrOverrun to set
	 */
	public void setDcrOverrun(boolean dcrOverrun) {
		this.dcrOverrun = dcrOverrun;
	}

	
	/**
	 * @return the autoSettled
	 */
	public boolean isAutoSettled() {
		return autoSettled;
	}

	/**
	 * @param autoSettled the autoSettled to set
	 */
	public void setAutoSettled(boolean autoSettled) {
		this.autoSettled = autoSettled;
	}

		

    public ItemLine createDeepCopy(){
    	ItemLine origLine = new OverrunItemLine();
    	((OverrunItemLine) this).deepCopy(origLine);
    	return origLine;
    }
}
