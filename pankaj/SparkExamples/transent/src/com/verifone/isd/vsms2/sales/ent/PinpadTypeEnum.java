package com.verifone.isd.vsms2.sales.ent;

public enum PinpadTypeEnum {
	
	INTERNAL(0),
	EXTERNAL(1);
	
	private final int ordinal;
	
	PinpadTypeEnum(int ordinal) {
		this.ordinal =  ordinal;
	}
	
	public static PinpadTypeEnum getPinpadTypeEnum(int ordinal) {
		PinpadTypeEnum pinpadType = null;
		for(PinpadTypeEnum type : PinpadTypeEnum.values()) {
			if(type.getOrdinal() == ordinal) {
				pinpadType = type;
				break;
			}
		}
		return pinpadType;
	}
	
	public int getOrdinal() {
		return this.ordinal;
	}
}
