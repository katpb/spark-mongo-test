package com.verifone.isd.vsms2.net.ent;

public enum OperatorModel {
	CUSTOMER(true, CASHIERPROMPT.RESTRICTED), CASHIER(false, CASHIERPROMPT.ALL), COMBINED(false, CASHIERPROMPT.NONE);
	
	public enum CASHIERPROMPT {
		/**
		 * ALL 			- Cashier operated Device, send all cashier prompt
		 * NONE   		- Register shared by Customer & Cashier, No prompt needed
		 * RESTRICTED 	- Customer operated devices with Restricted cashier Prompts
		 */
		
		ALL, NONE, RESTRICTED;
	}

	private boolean suppressMerchantCopy = false;
	private CASHIERPROMPT cashierPrompt = CASHIERPROMPT.ALL;

	private OperatorModel(boolean suppressMerchantCopy, CASHIERPROMPT cashierPrompt) {
		this.suppressMerchantCopy = suppressMerchantCopy;
		this.cashierPrompt = cashierPrompt;
	}

	public boolean isSuppressMerchantCopy() {
		return suppressMerchantCopy;
	}

	public void setSuppressMerchantCopy(boolean suppressMerchantCopy) {
		this.suppressMerchantCopy = suppressMerchantCopy;
	}

	public CASHIERPROMPT getCashierPrompt() {
		return cashierPrompt;
	}

	public void setCashierPrompt(CASHIERPROMPT cashierPrompt) {
		this.cashierPrompt = cashierPrompt;
	}

}


