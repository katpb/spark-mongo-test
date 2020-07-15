package com.verifone.isd.vsms2.sales.ent.vistadevice;

/**
 * This Enum holds different menu types
 * 
 * @author MadhusudhanB1
 *
 */
public enum VistaMenuTypeEnum {

	EXPANDED_MENU(0),
	MULTISELECT_MENU(1),
	MENU_CHAIN(2);
	
	private final int ordinal;
	
	VistaMenuTypeEnum(int ordinal) {
		this.ordinal =  ordinal;
	}
	
	public static VistaMenuTypeEnum getVistaMenuTypeEnum(int ordinal) {
		VistaMenuTypeEnum vistaMenuType = null;
		for(VistaMenuTypeEnum type : VistaMenuTypeEnum.values()) {
			if(type.getOrdinal() == ordinal) {
				vistaMenuType = type;
				break;
			}
		}
		return vistaMenuType;
	}
	
	public int getOrdinal() {
		return this.ordinal;
	}
}
