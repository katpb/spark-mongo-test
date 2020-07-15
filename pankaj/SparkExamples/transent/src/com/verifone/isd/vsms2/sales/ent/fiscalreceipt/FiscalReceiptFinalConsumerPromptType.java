package com.verifone.isd.vsms2.sales.ent.fiscalreceipt;

public enum FiscalReceiptFinalConsumerPromptType {
	
	DEFAULT("DEFAULT"),
	PROMPTYN("PROMPTYN"),
	MENU("MENU");
	
	private final String type;
	
	FiscalReceiptFinalConsumerPromptType(String fiscalReceiptFinalConsumerPromptType){
		this.type = fiscalReceiptFinalConsumerPromptType;
	}
	
	public String getFiscalReceiptFinalConsumerPromptType() {
		return this.type;
	}

	@Override
	public String toString() {
		return this.type;
	}

	public static FiscalReceiptFinalConsumerPromptType fromValue(String type) {
		for (FiscalReceiptFinalConsumerPromptType value : FiscalReceiptFinalConsumerPromptType.values()) {
			if (value.type.equals(type)){
				return value;
			}
		}
		throw new IllegalArgumentException(type);
	}
}
