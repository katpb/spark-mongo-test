/* Copyright (C) 2018 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 29 Nov, 2018                                     T_pankajM2
 */
package com.verifone.isd.vsms2.sales.ent.screencfg;

/**
 * Contains prepay buttons details.
 * 
 * @author T_PankajM2
 * @version 1.0
 */
public class PrepayButton implements Button {

	private int sysID;
	private long amount;
	private static final long MIN_AMOUNT = 1;
	private static final long MAX_AMOUNT = 9999;
	private static final int MIN_SYSID = 1;
	private static final int MAX_SYSID = 5;

	/**
	 * 
	 * @param sysID
	 * @param amount
	 * @throws ScreenCfgException
	 */
	public PrepayButton(int sysID, long amount) throws ScreenCfgException {
		setSysID(sysID);
		setAmount(amount);
	}

	/**
	 * Default constructor
	 */
	public PrepayButton() {
	}

	/**
	 * 
	 * @return sysID
	 */
	public int getSysID() {
		return sysID;
	}

	/**
	 * 
	 * @param sysID
	 * @throws ScreenCfgException
	 */
	public void setSysID(int sysID) throws ScreenCfgException {

		if (sysID >= MIN_SYSID && sysID <= MAX_SYSID) {
			this.sysID = sysID;
		} else {
			throw new ScreenCfgException("Invalid PrepayButton : sysID configuration : " + sysID);
		}
	}

	/**
	 * 
	 * @return amount
	 */
	public long getAmount() {
		return amount;
	}

	/**
	 * 
	 * @param amount
	 * @throws ScreenCfgException
	 */
	public void setAmount(long amount) throws ScreenCfgException {

		if (amount >= MIN_AMOUNT && amount <= MAX_AMOUNT) {
			this.amount = amount;
		} else {
			throw new ScreenCfgException("Invalid PrepayButton : sysID configuration : " + sysID);
		}
	}
}
