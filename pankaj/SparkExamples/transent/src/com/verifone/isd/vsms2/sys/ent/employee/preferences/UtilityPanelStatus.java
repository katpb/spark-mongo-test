package com.verifone.isd.vsms2.sys.ent.employee.preferences;

public enum UtilityPanelStatus {
	OFF(0), ON(1);

	private int status;

	private UtilityPanelStatus(int status) {
		this.status = status;
	}

	public int getPanelStatus() {
		return status;
	}

	public static UtilityPanelStatus fromValue(int value) {
		for (UtilityPanelStatus status : UtilityPanelStatus.values()) {
			if (status.getPanelStatus() == value) {
				return status;
			}
		}
		return null;
	}

}
