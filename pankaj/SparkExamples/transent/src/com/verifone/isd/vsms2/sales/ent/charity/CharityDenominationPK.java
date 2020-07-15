/**
 * Created on Apr 12, 2019 at 1:18:10 PM 
 * Verifone Inc., Copyright(c) 2016 All rights reserved
 *
 */
package com.verifone.isd.vsms2.sales.ent.charity;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * @author T_LaxmanG1
 * @author BaishampayM1
 *
 */
public class CharityDenominationPK implements IEntityPK {

	private static final long serialVersionUID = -5127376078597578149L;
	private int denominationID;

	/**
	 * Default Constructor
	 */
	public CharityDenominationPK() {
	}

	/**
	 * Constructor with Parameter
	 * 
	 * @param denominationID
	 */
	public CharityDenominationPK(int denominationID) {
		this.denominationID = denominationID;
	}

	/**
	 * 
	 * @return
	 */
	public int getValue() {
		return this.denominationID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verifone.isd.vsms2.sys.db.pres.IEntityPK#equals(com.verifone.isd.vsms2.sys.db.pres.
	 * IEntityPK)
	 */
	@Override
	public boolean equals(IEntityPK obj) {
		if (obj instanceof CharityDenominationPK) {
			CharityDenominationPK lObj = (CharityDenominationPK) obj;
			return (this.denominationID == lObj.denominationID);
		}
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof IEntityPK) {
			return this.equals((IEntityPK) obj);
		}
		return false;
	}

	/**
	 * Method override since equals() is implemented
	 * 
	 * @return hash code for the object
	 */
	public int hashCode() {
		int hc = 37 * 17;
		return (hc + this.denominationID);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verifone.isd.vsms2.sys.db.pres.IEntityPK#isValid()
	 */
	@Override
	public boolean isValid() {
		return (this.denominationID > 0);
	}

}
