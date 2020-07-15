package com.verifone.isd.vsms2.sales.ent.trans;

import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/**
 * Value object to capture the loyalty program details from transaction needed
 * for transaction XML serialization. There will be one such entry for each
 * loyalty program applicable to the transaction.
 * 
 * @author Anindya_D1
 *
 */
public class LoyaltyProgramDetails {

	private String programName;		// customer friendly loyalty program name
	private MoneyAmount autoDiscount = new MoneyAmount(0);	// automatic ticket discount
	private MoneyAmount custDiscount = new MoneyAmount(0);	// customer choice ticket discount
	private LoyaltyAuthDetails authDetail;	// site level loyalty authorization details, when available
	
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public MoneyAmount getAutoDiscount() {
		return autoDiscount;
	}
	public void setAutoDiscount(MoneyAmount autoDiscount) {
		if (autoDiscount != null) {
			this.autoDiscount = autoDiscount.abs();
		}
	}
	public MoneyAmount getCustDiscount() {
		return custDiscount;
	}
	public void setCustDiscount(MoneyAmount custDiscount) {
		if (custDiscount != null) {
			this.custDiscount = custDiscount.abs();
		}
	}
	public LoyaltyAuthDetails getAuthDetail() {
		return authDetail;
	}
	public void setAuthDetail(LoyaltyAuthDetails authDetail) {
		this.authDetail = authDetail;
	}
	
	/**
	 * Accumulate multiple automatic ticket level discounts from the same
	 * loyalty program into a single entry at the transaction level program
	 * detail.
	 * 
	 * @param discount
	 */
	public void addAutoDiscount(MoneyAmount discount) {
		this.autoDiscount.add(discount.abs());
	}
	
	/**
	 * Accumulate multiple customer choice ticket level discounts from the same
	 * loyalty program into a single entry at the transaction level program
	 * detail
	 * 
	 * @param discount
	 */
	public void addCustDiscount(MoneyAmount discount) {
		this.custDiscount.add(discount.abs());
	}
}
