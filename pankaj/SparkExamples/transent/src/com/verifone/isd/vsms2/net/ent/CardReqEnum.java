package com.verifone.isd.vsms2.net.ent;

public enum CardReqEnum {
	SALE("Sale"),
	REFUND("Refund");
	
	String value;
	
	public String getValue(){
		return this.value;
	}
	
	private CardReqEnum(String value) {
		this.value = value;
	}

}
