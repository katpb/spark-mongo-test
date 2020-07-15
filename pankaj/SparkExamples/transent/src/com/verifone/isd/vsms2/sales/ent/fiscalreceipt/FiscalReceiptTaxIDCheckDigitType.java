package com.verifone.isd.vsms2.sales.ent.fiscalreceipt;

public enum FiscalReceiptTaxIDCheckDigitType {
	
	NONE("NONE"),
	MOD11K("MOD11K");
	
	private final String type;
	
	FiscalReceiptTaxIDCheckDigitType(String fiscalReceiptTaxIDCheckDigitType){
		this.type = fiscalReceiptTaxIDCheckDigitType;
	}
	
	public String getFiscalReceiptTaxIDCheckDigitType() {
		return this.type;
	}

	@Override
	public String toString() {
		return this.type;
	}

	public static FiscalReceiptTaxIDCheckDigitType fromValue(String type) {
		for (FiscalReceiptTaxIDCheckDigitType value : FiscalReceiptTaxIDCheckDigitType.values()) {
			if (value.type.equals(type)){
				return value;
			}
		}
		throw new IllegalArgumentException(type);
	}
}
