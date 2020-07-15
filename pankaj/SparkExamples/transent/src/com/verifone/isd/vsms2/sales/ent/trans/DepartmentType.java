/**
 * 
 */
package com.verifone.isd.vsms2.sales.ent.trans;

/**
 * @author T_PankajM2
 *
 */
public enum DepartmentType {
	
	
	NEGATIVEDEPT("neg","neg"),FUELDEPT("fuel","fuel"),MONEYORDERDEPT("moneyOrder","moneyOrder"),NORMALDEPT("norm","norm");
	
	private final String name;
	private String nxmlName;
	
	private DepartmentType(String name,String nxmlName) {
		this.name = name;
		this.nxmlName = nxmlName;
	}

	public String getName() {
		return this.name;
	}
	
	public String getNXMLName() {
		return this.nxmlName;
	}
	

}
