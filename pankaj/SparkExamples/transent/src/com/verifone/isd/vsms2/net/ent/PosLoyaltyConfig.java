package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

public class PosLoyaltyConfig implements IEntityObject{
	
	private static final long serialVersionUID = -2835650906073286812L;
	private static final String MULTIPLE_LOYALTY_CAPABLE = "MultipleLoyaltyCapable";
	
	private boolean loyaltyEnabled;
	private boolean multipleLoyaltyEnabled;
	private boolean loyaltyAuthOnTotalKey;
	private boolean epsPpgPrecedesPosPpg;
	private boolean forceCashReceipt = true;
	
	/**
	 * 
	 */
	public PosLoyaltyConfig() {
	}
	/**
	 * @param loyaltyEnabled
	 * @param loyaltyAuthOnTotalKey
	 * @param epsPpgPrecedesPosPpg
	 */
	public PosLoyaltyConfig(boolean loyaltyEnabled,
			boolean loyaltyAuthOnTotalKey, boolean epsPpgPrecedesPosPpg) {
		this.loyaltyEnabled = loyaltyEnabled;
		this.loyaltyAuthOnTotalKey = loyaltyAuthOnTotalKey;
		this.epsPpgPrecedesPosPpg = epsPpgPrecedesPosPpg;
	}
	/**
	 * @return the loyaltyEnabled
	 */
	public boolean isLoyaltyEnabled() {
		return loyaltyEnabled;
	}
	
	/**
	 * @param loyaltyEnabled the loyaltyEnabled to set
	 */
	public void setLoyaltyEnabled(boolean loyaltyEnabled) {
		this.loyaltyEnabled = loyaltyEnabled;
	}
	
	/**
	 * @return the loyaltyAuthOnTotalKey
	 */
	public boolean isLoyaltyAuthOnTotalKey() {
		return loyaltyAuthOnTotalKey;
	}
	
	/**
	 * @param loyaltyAuthOnTotalKey the loyaltyAuthOnTotalKey to set
	 */
	public void setLoyaltyAuthOnTotalKey(boolean loyaltyAuthOnTotalKey) {
		this.loyaltyAuthOnTotalKey = loyaltyAuthOnTotalKey;
	}
	
	/**
	 * @return the epsPpgPrecedesPosPpg
	 */
	public boolean isEpsPpgPrecedesPosPpg() {
		return epsPpgPrecedesPosPpg;
	}
	
	/**
	 * @param epsPpgPrecedesPosPpg the epsPpgPrecedesPosPpg to set
	 */
	public void setEpsPpgPrecedesPosPpg(boolean epsPpgPrecedesPosPpg) {
		this.epsPpgPrecedesPosPpg = epsPpgPrecedesPosPpg;
	}
	
	/**
	 * @return the forceCashReceipt
	 */
	public boolean isForceCashReceipt() {
		return forceCashReceipt;
	}
	/**
	 * @param forceCashReceipt the forceCashReceipt to set
	 */
	public void setForceCashReceipt(boolean forceCashReceipt) {
		this.forceCashReceipt = forceCashReceipt;
	}
	@Override
	public IEntityPK getPK() {
		return null;
	}
	
	@Override
	public boolean isPKValid() {
		return true;
	}
	
	@Override
	public void setAttributes(IEntityObject obj) {
		PosLoyaltyConfig posLoyaltyConfig = (PosLoyaltyConfig) obj;
		posLoyaltyConfig.setLoyaltyEnabled(loyaltyEnabled);
		posLoyaltyConfig.setMultipleLoyaltyEnabled(multipleLoyaltyEnabled);
		posLoyaltyConfig.setLoyaltyAuthOnTotalKey(loyaltyAuthOnTotalKey);
		posLoyaltyConfig.setEpsPpgPrecedesPosPpg(epsPpgPrecedesPosPpg);
		posLoyaltyConfig.setForceCashReceipt(forceCashReceipt);
	}
	
	@Override
	public void setPK(IEntityPK pk) {
	}
	
	@Override
	public void validate() throws Exception {
	}
	/**
	 * @return the multipleLoyaltyEnabled
	 */
	public boolean isMultipleLoyaltyEnabled() {
		return multipleLoyaltyEnabled;
	}
	/**
	 * @param multipleLoyaltyEnabled the multipleLoyaltyEnabled to set
	 */
	public void setMultipleLoyaltyEnabled(boolean multipleLoyaltyEnabled) {
		this.multipleLoyaltyEnabled = multipleLoyaltyEnabled;
	}
	
	/**
	 * Return a string that describes POS loyalty capability as per enhanced
	 * schema for multiple loyalty programs.
	 * 
	 * @return loyalty capability of POS
	 */
	public String getLoyaltyCapability() {
		if (loyaltyEnabled) {
			if (multipleLoyaltyEnabled) {
				return MULTIPLE_LOYALTY_CAPABLE;
			} else {
				return Boolean.TRUE.toString();
			}
		} else {
			return Boolean.FALSE.toString();
		}
	}
}
