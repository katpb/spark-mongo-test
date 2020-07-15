package com.verifone.isd.vsms2.sys.ent.employee.preferences;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.ent.employee.EmployeePK;

public class EmployeePreferences implements IEntityObject {

	private static final long serialVersionUID = 4983715828720895441L;

	private EmployeePK empId;
	private ReceiptLayout receiptLayout = ReceiptLayout.LEFT;
	private UtilityPanelStatus utilityPanelStatus = UtilityPanelStatus.ON;
	private VirtualKeyboardLayout virtualKeyboardLayout = VirtualKeyboardLayout.MOVABLE;

	@Override
	public IEntityPK getPK() {
		return this.empId;
	}

	@Override
	public void setPK(IEntityPK pk) {
		this.empId = (EmployeePK) pk;
	}

	public ReceiptLayout getReceiptLayout() {
		return receiptLayout;
	}

	public void setReceiptLayout(ReceiptLayout layout) {
		this.receiptLayout = layout;
	}

	public UtilityPanelStatus getUtilityPanelStatus() {
		return utilityPanelStatus;
	}

	public void setUtilityPanelStatus(UtilityPanelStatus status) {
		this.utilityPanelStatus = status;
	}

	public VirtualKeyboardLayout getVirtualKeyboardLayout() {
		return virtualKeyboardLayout;
	}

	public void setVirtualKeyboardLayout(VirtualKeyboardLayout virtualKeyboardLayout) {
		this.virtualKeyboardLayout = virtualKeyboardLayout;
	}

	@Override
	public void setAttributes(IEntityObject obj) {
		EmployeePreferences preferences = (EmployeePreferences) obj;
		preferences.setPK(this.getPK());
		preferences.setReceiptLayout(this.getReceiptLayout());
		preferences.setUtilityPanelStatus(this.getUtilityPanelStatus());
		preferences.setVirtualKeyboardLayout(this.getVirtualKeyboardLayout());
	}

	@Override
	public void validate() throws Exception {
		if (!isPKValid()) {
			throw new Exception("Invalid employee: " + this.empId);
		}
	}

	@Override
	public boolean isPKValid() {
		return (this.empId == null) ? false : this.empId.isValid();
	}

}
