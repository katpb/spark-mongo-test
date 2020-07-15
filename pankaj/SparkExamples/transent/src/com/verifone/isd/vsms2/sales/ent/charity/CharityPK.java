package com.verifone.isd.vsms2.sales.ent.charity;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * 
 * @author T_LaxmanG1
 * @author BaishampayM1
 *
 */
public class CharityPK implements IEntityPK {
	private static final long serialVersionUID = -4560911134572245503L;
	private int charityID;

	public CharityPK() {
	}

	/**
	 * 
	 * @param charityID
	 */
	public CharityPK(int charityID) {
		this.charityID = charityID;
	}

	/**
	 * 
	 * @return
	 */
	public int getValue() {
		return this.charityID;
	}

	@Override
	public boolean equals(IEntityPK obj) {
		if (obj instanceof CharityPK) {
			CharityPK charityPK = (CharityPK) obj;
			return (this.charityID == charityPK.charityID);
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hc = 57 * 17;
		return (hc + charityID);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof IEntityPK) {
			return this.equals((IEntityPK) obj);
		}
		return false;
	}

	@Override
	public boolean isValid() {
		return (this.charityID > 0 && this.charityID <= Charity.MAX_CHARITY_PGMS);
	}

}
