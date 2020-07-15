package com.verifone.isd.vsms2.sales.ent.trans;

import com.verifone.isd.xml.vocabulary.IXMLVocabulary;

public enum FiscalReceiptType {

	FISCAL_SALE_RECEIPT (IXMLVocabulary.FISCAL_SALE),
	FISCAL_REFUND_RECEIPT (IXMLVocabulary.FISCAL_REFUND),
	FUEL_VOUCHER_RECEIPT (IXMLVocabulary.FUEL_VOUCHER),
	NON_FISCAL_NETWORK_RECEIPT (IXMLVocabulary.NON_FISCAL_NETWORK),
	PUMP_TEST_RECEIPT (IXMLVocabulary.PUMP_TEST);
	
	
	private final String type;
	
	FiscalReceiptType(String fiscalreceiptType){
		this.type = fiscalreceiptType;
	}
	
	public String getFiscalreceiptType() {
		return this.type;
	}

	@Override
	public String toString() {
		return this.type;
	}

	public static FiscalReceiptType fromValue(String type) {
		for (FiscalReceiptType value : FiscalReceiptType.values()) {
			if (value.type.equals(type)){
				return value;
			}
		}
		throw new IllegalArgumentException(type);
	}
	
}
