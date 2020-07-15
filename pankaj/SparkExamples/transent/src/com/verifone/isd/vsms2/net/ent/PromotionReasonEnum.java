package com.verifone.isd.vsms2.net.ent;


public enum PromotionReasonEnum {
	COMBINATIONOFFER("combinationOffer", false, false),
	MIXANDMATCHOFFER("mixAndMatchOffer", false, false),
	POSFUELDISCOUNT("posFuelDiscount", false, false),
	POSPROMOTION("posPromotion", false, false),
	LOYALTYOFFER("loyaltyOffer", true, false),
	OTHER("other", true, true);
	
	private String value;
	private boolean epsDriven;
	private boolean paymentBased;
	
	
	/**
	 * @param priceLevel
	 */
	private PromotionReasonEnum(String value, boolean epsDriven, boolean paymentBased) {
		this.value = value;
		this.epsDriven = epsDriven;
		this.paymentBased = paymentBased;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @return the paymentBased
	 */
	public boolean isPaymentBased() {
		return paymentBased;
	}

	/**
	 * @return the epsDriven
	 */
	public boolean isEpsDriven() {
		return epsDriven;
	}
	
	/**
	 * 
	 * @param text
	 * @return the promotion reason enum based on the String
	 */
	public static PromotionReasonEnum fromValue(String text) {
		if (text != null) {
			try {
				return PromotionReasonEnum.valueOf(text.trim().toUpperCase());
			} catch (IllegalArgumentException iae) {
			}
		}
		return null;
	}
}
