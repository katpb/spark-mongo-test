package com.verifone.isd.vsms2.sales.ent.epsprepaid;

import java.io.Serializable;

import com.verifone.isd.vsms2.sales.ent.dept.DepartmentPK;

public class EPSPrepaidConfigType implements Serializable{
	
	private static final long serialVersionUID = 1799347100492035584L;
	
    DepartmentPK  department = new DepartmentPK();
    
    private boolean evaluate;
    
    private boolean departmentEnabled;
    
    private int ticketReprintSecLvl;
    
    public EPSPrepaidConfigType() {
	}

	public DepartmentPK getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentPK department) {
		this.department = department;
	}

	public boolean isEvaluate() {
		return evaluate;
	}

	public void setEvaluate(boolean evaluate) {
		this.evaluate = evaluate;
	}

	public boolean isDepartmentEnabled() {
		return departmentEnabled;
	}

	public void setDepartmentEnabled(boolean departmentEnabled) {
		this.departmentEnabled = departmentEnabled;
	}

	public int getTicketReprintSecLvl() {
		return ticketReprintSecLvl;
	}

	public void setTicketReprintSecLvl(int ticketReprintSecLvl) {
		this.ticketReprintSecLvl = ticketReprintSecLvl;
	}
}
