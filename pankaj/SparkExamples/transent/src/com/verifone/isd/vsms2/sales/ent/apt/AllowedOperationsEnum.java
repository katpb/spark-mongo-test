package com.verifone.isd.vsms2.sales.ent.apt;

public enum AllowedOperationsEnum {
	
	MERCHANDISE(0),
	PRESET_FUEL(1),
	POSTPAY_FUEL(2),
	PREAUTH_FUEL(3),
	REPRINT_FUEL_TICKET(4);
	
	private final int ordinal;
	
	AllowedOperationsEnum(int ordinal) {
		this.ordinal =  ordinal;
	}
	
	public static AllowedOperationsEnum getAllowedOperationsEnum(int ordinal) {
		AllowedOperationsEnum allowedOp = null;
		for(AllowedOperationsEnum operation : AllowedOperationsEnum.values()) {
			if(operation.getOrdinal() == ordinal) {
				allowedOp = operation;
				break;
			}
		}
		return allowedOp;
	}
	
	public int getOrdinal() {
		return this.ordinal;
	}
}
