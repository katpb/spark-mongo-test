/**
 * Created on Apr 12, 2019 at 11:45:37 AM 
 * Verifone Inc., Copyright(c) 2016 All rights reserved
 *
 */
package com.verifone.isd.vsms2.sales.ent.charity;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/**
 * @author T_LaxmanG1
 * @author BaishampayM1
 *
 */
public class CharityDenomination implements IEntityObject {

	private static final long serialVersionUID = 1176900974445231093L;
	
	private CharityDenominationPK pk;
	private CharityPK charityPK;
	private MoneyAmount amount;
	private static final int MAX_AMOUNT = 999999;

	/**
	 * Default constructor
	 */
	public CharityDenomination() {
	}

	/**
	 * Constructor with a Parameter
	 * 
	 * @param pk
	 */
	public CharityDenomination(CharityDenominationPK pk) {
		this.pk = pk;
	}
	
	/**
	 * @return the amount
	 */
	public MoneyAmount getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(MoneyAmount amount) {
		this.amount = amount;
	}	

	/**
	 * 
	 * @return
	 */
	public CharityPK getCharityPK() {
		return charityPK;
	}

	/**
	 * 
	 * @param charityPK
	 */
	public void setCharityPK(CharityPK charityPK) {
		this.charityPK = charityPK;
	}

	@Override
	public IEntityPK getPK() {
		return this.pk;
	}

	@Override
	public void setPK(IEntityPK pk) {
		this.pk = (CharityDenominationPK)pk;		
	}

	@Override
	public void setAttributes(IEntityObject obj) {
		CharityDenomination cObj = (CharityDenomination) obj;
		cObj.setPK(this.pk);
		cObj.setAmount(this.amount);
		cObj.setCharityPK(this.charityPK);
	}

	@Override
	public void validate() throws Exception {
		if (!isPKValid()) {
			throw new Exception("Invalid charity denomination: " + this.pk);
		}		
		validateAmount();
	}
	
	@SuppressWarnings("deprecation")
	private void validateAmount() throws Exception {
		if (this.amount != null) {
			long amountVal = this.amount.getLongValue();
			if (amountVal > MAX_AMOUNT) {
				throw new Exception("Invalid denomination amount: " + amount.toString() + " for denomination: " + this.pk);
			}
		}
	}

	@Override
	public boolean isPKValid() {
		return this.pk == null ? false : this.pk.isValid();
	}

}
