package com.verifone.isd.vsms2.sales.ent.apt;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Entity class for APT Department Config
 * 
 * @author MadhusudhanB1
 *
 */
public class APTDepartmentConfig implements IEntityObject, ISalesEntityVisitable {

	private static final long serialVersionUID = 3727349047290906687L;
	private int departmentNumber;
	
	public APTDepartmentConfig() {
	 
	}
	
	public APTDepartmentConfig(int deptNumber) {
		this.departmentNumber = deptNumber; 
	}
	
	@Override
	public void accept(SalesEntityVisitor v) throws Exception {
		v.visit(this);
	}

	@Override
	public IEntityPK getPK() {
		return null;
	}

	@Override
	public void setPK(IEntityPK pk) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAttributes(IEntityObject obj) {
		APTDepartmentConfig config = (APTDepartmentConfig) obj;
		config.setDepartmentNumber(this.departmentNumber);
	}

	@Override
	public void validate() throws Exception {
		if(this.departmentNumber < 0) {
			throw new Exception("Invalid Department Number : " + this.departmentNumber);
		}
	}

	@Override
	public boolean isPKValid() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(int departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof APTDepartmentConfig)) {
			return false;
		}
		
		APTDepartmentConfig config = (APTDepartmentConfig) obj;
		if(this.departmentNumber != config.departmentNumber) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int hash = 17;
		hash += hash * 12 + this.departmentNumber;
		
		return hash;
	}
}
