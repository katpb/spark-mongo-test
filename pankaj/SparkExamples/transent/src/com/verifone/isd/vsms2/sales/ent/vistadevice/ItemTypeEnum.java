package com.verifone.isd.vsms2.sales.ent.vistadevice;

/**
 * This Enum holds different Item types
 * 
 * @author MadhusudhanB1
 *
 */
public enum ItemTypeEnum {
	PLU(0),
	DEPARTMENT(1),
	MENU(2);
	
	private int ordinal;
	private ItemTypeEnum(int ordinal) {
		this.ordinal = ordinal;
	}
	
	public static ItemTypeEnum getApplicationTypeByOrdinal(int ordinal) {
		ItemTypeEnum appTypeByOrdinal = null;
		for(ItemTypeEnum type : ItemTypeEnum.values()) {
			if(type.getOrdinal() == ordinal) {
				appTypeByOrdinal = type;
				break;
			}
		}
		return appTypeByOrdinal;
	}

	public int getOrdinal() {
		return ordinal;
	}
}
