package com.verifone.isd.vsms2.net.ent;

public enum DiscretionaryDataReceiptPreferenceEnum {
	
	PRINT("Y", false, true, false), 
	ELECTRONIC("E", true, false, false),
	ELECTRONICANDPRINT("EY", true, true, false),
	NO_RECEIPT("N", false, false, false), 
	ASK("C", false, false, true);
	
	DiscretionaryDataReceiptPreferenceEnum(String value, boolean electronicReceipt, boolean printReceipt, boolean promptReceipt){
		this.value = value;
		this.electronicReceipt = electronicReceipt;
		this.printReceipt = printReceipt;
		this.promptReceipt= promptReceipt;
		
	}
	
	private String value;
	private boolean electronicReceipt;
	private boolean printReceipt;
	private boolean promptReceipt;
	
	/**
	 * 
	 * @return value
	 */
	public String getValue(){
		return this.value;
	}

	/**
	 * 
	 * @return electronicReceipt
	 */
	public boolean isElectronicReceipt() {
		return electronicReceipt;
	}

	/**
	 * 
	 * @return printReceipt
	 */
	public boolean isPrintReceipt() {
		return printReceipt;
	}
	
	/**
	 * 
	 * @return promptReceipt
	 */
	public boolean isPromptReceipt() {
		return promptReceipt;
	}
	
	public static DiscretionaryDataReceiptPreferenceEnum fromValue(String text) {
	    for (DiscretionaryDataReceiptPreferenceEnum receiptPreference : values()) {
	        if (receiptPreference.value.equalsIgnoreCase(text)) {
	            return receiptPreference;
	        }
	    }    
	    return null;
	}
}
