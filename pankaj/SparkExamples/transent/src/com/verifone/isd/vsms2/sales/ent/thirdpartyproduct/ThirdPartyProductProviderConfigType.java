package com.verifone.isd.vsms2.sales.ent.thirdpartyproduct;

import java.io.Serializable;

import com.verifone.isd.vsms2.sales.ent.dept.DepartmentPK;

public class ThirdPartyProductProviderConfigType implements Serializable{
	
	private static final long serialVersionUID = 1799347100492035584L;
	
    DepartmentPK  department = new DepartmentPK();
	
	private long thirdPartyProductProviderRangeStart;
	
	private long thirdPartyProductProviderRangeEnd;

    
    public ThirdPartyProductProviderConfigType() {
	}

	public DepartmentPK getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentPK department) {
		this.department = department;
	}

	public long getThirdPartyProductProviderRangeStart() {
		return thirdPartyProductProviderRangeStart;
	}

	public void setThirdPartyProductProviderRangeStart(long thirdPartyProductProviderRangeStart) {
		this.thirdPartyProductProviderRangeStart = thirdPartyProductProviderRangeStart;
	}
	
	public long getThirdPartyProductProviderRangeEnd() {
		return thirdPartyProductProviderRangeEnd;
	}

	public void setThirdPartyProductProviderRangeEnd(long thirdPartyProductProviderRangeEnd) {
		this.thirdPartyProductProviderRangeEnd = thirdPartyProductProviderRangeEnd;
	}
}
