/*
 * MOPConvertRequest.java
 *
 * Created on December 14, 2003, 9:45 PM
 */

package com.verifone.isd.vsms2.fuel.ent.util;

import java.io.Serializable;

import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/**
 *
 * @author  D. Michael Barton
 */
public class MOPConvertRequest implements Serializable {

	private static final long serialVersionUID = 4535616594355029548L;
	private short fuelingPosition = 0;
	private int sequenceNumber = 0;
	private boolean autoRequest = false;
	private int newMOP = 0;
	private MoneyAmount ppgDiscount;	// PPG discount for the dispensed grade
    
    /** Creates a new instance of MOPConvertRequest */
    public MOPConvertRequest() {
    }
 
    public MOPConvertRequest(	short fuelingPosition,
    							int sequenceNumber,
    							boolean autoRequest,
    							int newMOP) {

        this.fuelingPosition    = fuelingPosition;
        this.sequenceNumber     = sequenceNumber;
        this.autoRequest        = autoRequest;
        this.newMOP             = newMOP;
    }
 
    public short getFuelingPosition() {
        return(this.fuelingPosition);
    }
 
    public int getSequenceNumber() {
        return(this.sequenceNumber);
    }
 
    public boolean getAutoRequest() {
        return(this.autoRequest);
    }
 
    public int getNewMOP() {
        return(this.newMOP);
    }

	/**
	 * @return the ppgDiscount
	 */
	public MoneyAmount getPpgDiscount() {
		return ppgDiscount;
	}

	/**
	 * @param ppgDiscount the ppgDiscount to set
	 */
	public void setPpgDiscount(MoneyAmount ppgDiscount) {
		this.ppgDiscount = ppgDiscount;
	}
}
