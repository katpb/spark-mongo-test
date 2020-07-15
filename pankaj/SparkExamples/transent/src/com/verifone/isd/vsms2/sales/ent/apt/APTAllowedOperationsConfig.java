package com.verifone.isd.vsms2.sales.ent.apt;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Entity class for APT Allowed Operation
 * 
 * @author MadhusudhanB1
 *
 */
public class APTAllowedOperationsConfig implements IEntityObject, ISalesEntityVisitable {

	private static final long serialVersionUID = 5753041718816871633L;
	private AllowedOperationsEnum allowedOperation;

	public APTAllowedOperationsConfig() {
	
	}
	
	public APTAllowedOperationsConfig(AllowedOperationsEnum allowedOperation) {
		this.allowedOperation = allowedOperation;
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

	}

	@Override
	public void setAttributes(IEntityObject obj) {
		APTAllowedOperationsConfig config = (APTAllowedOperationsConfig) obj;

		config.setAllowedOperation(this.allowedOperation);
	}

	@Override
	public void validate() throws Exception {
		// Validate does not required here because At visitor layer 
		// itself we get error while converting string to ENUM
	}

	@Override
	public boolean isPKValid() {
		return true;
	}

	public AllowedOperationsEnum getAllowedOperation() {
		return allowedOperation;
	}

	public void setAllowedOperation(AllowedOperationsEnum allowedOperation) {
		this.allowedOperation = allowedOperation;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof APTAllowedOperationsConfig)) {
			return false;
		}
		APTAllowedOperationsConfig config = (APTAllowedOperationsConfig) obj;
		if(config.getAllowedOperation() != this.allowedOperation) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int hash = 67;
		hash += hash * 3 + this.allowedOperation.hashCode();
		
		return hash;
	}
}
