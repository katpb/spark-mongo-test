package com.verifone.isd.vsms2.sales.ent;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Entity class for APT MOP Config
 * 
 * @author MadhusudhanB1
 *
 */
public class MOPCodeConfig implements IEntityObject, ISalesEntityVisitable {

	private static final long serialVersionUID = 3727349047290906687L;
	private int mopCode;
	
	public MOPCodeConfig() {
	 
	}
	
	public MOPCodeConfig(int mopCode) {
		this.mopCode = mopCode; 
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
		MOPCodeConfig config = (MOPCodeConfig) obj;
		config.setMOPCode(this.mopCode);
	}

	@Override
	public void validate() throws Exception {
		if(this.mopCode < 0) {
			throw new Exception("Invalid MOP Code : " + this.mopCode);
		}
	}

	@Override
	public boolean isPKValid() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getMOPCode() {
		return mopCode;
	}

	public void setMOPCode(int mopCode) {
		this.mopCode = mopCode;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof MOPCodeConfig)) {
			return false;
		}
		
		MOPCodeConfig config = (MOPCodeConfig) obj;
		if(this.mopCode != config.mopCode) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int hash = 17;
		hash += hash * 12 + this.mopCode;
		
		return hash;
	}
}
