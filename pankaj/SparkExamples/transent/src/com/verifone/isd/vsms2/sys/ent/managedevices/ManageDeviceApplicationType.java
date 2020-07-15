package com.verifone.isd.vsms2.sys.ent.managedevices;

/**
 * This Enum holds different application types
 * 
 * @author MadhusudhanB1
 *
 */
public enum ManageDeviceApplicationType {

	APT(0, "AttendantPaymentTerminal", "Attendant Payment Terminal", true),
	CCW(1, "CarbonCommanderWorkStation", "Carbon Commander Workstation", true),
	CSC(2, "CarbonSelfCheckout", "Carbon Self Checkout", false),
	RM(3, "RubyMobile", "Ruby Mobile", true);
	
	private int ordinal;
	private String appStringType;
	private String appStringName;
	private boolean isCashierDriven;
	
	private ManageDeviceApplicationType(int ordinal, String appStringType, String appStringName, boolean isCashierDriven) {
		this.ordinal = ordinal;
		this.appStringType = appStringType;
		this.appStringName = appStringName;
		this.isCashierDriven = isCashierDriven;
	}
	
	public static ManageDeviceApplicationType getApplicationTypeByOrdinal(int ordinal) {
		ManageDeviceApplicationType appTypeByOrdinal = null;
		for(ManageDeviceApplicationType type : ManageDeviceApplicationType.values()) {
			if(type.getOrdinal() == ordinal) {
				appTypeByOrdinal = type;
				break;
			}
		}
		return appTypeByOrdinal;
	}
	
	public static ManageDeviceApplicationType getApplicationTypeByStringType(String appType) {
		ManageDeviceApplicationType appTypeByString = null;
		for(ManageDeviceApplicationType type : ManageDeviceApplicationType.values()) {
			if(type.getAppTypeStringType().equals(appType)) {
				appTypeByString = type;
				break;
			}
		}
		return appTypeByString;
	}
	
	
	public static ManageDeviceApplicationType getApplicationTypeByStringName(String appName) {
		ManageDeviceApplicationType appTypeByStringName = null;
		for(ManageDeviceApplicationType type : ManageDeviceApplicationType.values()) {
			if(type.getAppTypeStringName().equals(appName)) {
				appTypeByStringName = type;
				break;
			}
		}
		return appTypeByStringName;
	}
	
	public int getOrdinal() {
		return this.ordinal;
	}
	
	public String getAppTypeStringType() {
		return this.appStringType;
	}
	
	public String getAppTypeStringName() {
		return this.appStringName;
	}
	
	public boolean isCashierDriven() {
		return isCashierDriven;
	}

	public void setCashierDriven(boolean isCashierDriven) {
		this.isCashierDriven = isCashierDriven;
	}
}
