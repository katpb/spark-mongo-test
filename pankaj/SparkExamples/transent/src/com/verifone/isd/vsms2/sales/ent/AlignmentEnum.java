package com.verifone.isd.vsms2.sales.ent;

public enum AlignmentEnum  {
	
	RIGHT(0, "Right"),
	LEFT(1, "Left"),
	CENTER(2, "Center");
	
	private final int ordinal;
	private final String value;
	
	AlignmentEnum(int ordinal, String value) {
		this.ordinal =  ordinal;
		this.value = value;
	}
	
	public static AlignmentEnum getAlignmentEnum(int ordinal) {
		AlignmentEnum alignmentType = null;
		for(AlignmentEnum alignment : AlignmentEnum.values()) {
			if(alignment.getOrdinal() == ordinal) {
				alignmentType = alignment;
				break;
			}
		}
		return alignmentType;
	}
	
	public int getOrdinal() {
		return this.ordinal;
	}
	
	public String getValue() {
		return this.value;
	}
}
