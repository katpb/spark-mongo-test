package com.verifone.isd.vsms2.sales.ent.trans;

import java.io.Serializable;

import com.verifone.isd.vsms2.sales.ent.dept.Department;
import com.verifone.isd.vsms2.sales.ent.dept.DepartmentPK;
import com.verifone.isd.vsms2.sales.ent.prodcode.ProdCodePK;

/**
 * @author T_PankajM2
 *
 */
public class DepartmentInfo implements Serializable, Cloneable{
	private static final long serialVersionUID = -2016203621829035615L;
	private boolean negativeDept;
	private String deptName;
	private boolean fuelDept;
	private boolean moneyOrderDept;
	private int deptNum;
	private int deptProductCode;
	
	// default constructor
	public DepartmentInfo() {
	}
	
	// Constructor to take the Department object to set the required values.
	public DepartmentInfo(Department dept) {
		if(dept != null) {
			this.negativeDept = dept.isNegative();
			this.deptName = dept.getName();
			this.fuelDept = dept.isFuel();
			this.moneyOrderDept = dept.isMoneyOrder();
			this.deptNum = ((DepartmentPK)dept.getPK()).getValue();
			ProdCodePK pk =  dept.getProductCode() ;
			if(pk != null){
				this.deptProductCode = pk.getValue();
			}
		}
	}
	public boolean isNegativeDept() {
		return negativeDept;
	}
	public void setNegativeDept(boolean negativeDept) {
		this.negativeDept = negativeDept;
	}
	public String getDeptName() {
		return deptName != null ? deptName : "";
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public boolean isFuelDept() {
		return fuelDept;
	}
	public void setFuelDept(boolean fuelDept) {
		this.fuelDept = fuelDept;
	}
	public boolean isMoneyOrderDept() {
		return moneyOrderDept;
	}
	public void setMoneyOrderDept(boolean moneyOrderDept) {
		this.moneyOrderDept = moneyOrderDept;
	}
	public int getDeptNum() {
		return deptNum;
	}
	public void setDeptNum(int deptNum) {
		this.deptNum = deptNum;
	}
	public int getDeptProductCode() {
		return deptProductCode;
	}
	public void setDeptProductCode(int deptProductCode) {
		this.deptProductCode = deptProductCode;
	}

	@Override
	public Object clone() {
		DepartmentInfo clonedDept = null;
		try {
			clonedDept = (DepartmentInfo)super.clone();
		} catch (CloneNotSupportedException badclone) {
			throw new InternalError(badclone.toString());
		}
		clonedDept.negativeDept = this.negativeDept;
		clonedDept.deptName = this.deptName;
		clonedDept.fuelDept = this.fuelDept;
		clonedDept.moneyOrderDept = this.moneyOrderDept;
		clonedDept.deptNum = this.deptNum;
		clonedDept.deptProductCode = this.deptProductCode;
		return clonedDept;
	}
}
