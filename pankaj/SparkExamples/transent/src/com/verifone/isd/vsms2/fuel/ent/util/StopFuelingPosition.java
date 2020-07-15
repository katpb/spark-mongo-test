/*
 * StopFuelingPosition.java
 *
 * Created on March 31, 2004
 */

package com.verifone.isd.vsms2.fuel.ent.util;

import java.io.Serializable;

/**
 *
 * @author  D. Michael Barton
 */
public class StopFuelingPosition implements Serializable {
   
	private static final long serialVersionUID = 1726927400116618083L;

	public static final int DISPENSER_REFUND = 0;
	public static final int DISPENSER_NO_REFUND = 1;
	public static final int DISPENSER_FORCE_REFUND = 2;

    private short fuelingPosition = 0;
    private int refund = 0;
    private short terminalID = 0;

    /** Creates a new instance of StopFuelingPosition */
    public StopFuelingPosition(short fuelingPosition, int refund, short terminalID) {

        this.fuelingPosition = fuelingPosition;
		this.refund = refund;
        this.terminalID = terminalID;
    }
    
    public short getFuelingPosition() {
        return(fuelingPosition);
    }

    public int getRefund() {
		return(refund);
	}

    public short getTerminalID() {
		return(terminalID);
	}
}
