package com.verifone.isd.vsms2.sales.ent.apt;

import com.verifone.isd.vsms2.fuel.ent.fuelSite.IFuelSite;
import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Entity class for APT Fueling Position
 * 
 * @author MadhusudhanB1
 *
 */
public class APTAllowedFPConfig implements IEntityObject, ISalesEntityVisitable {
	
	private static final long serialVersionUID = 8704011779861469949L;
	private int fuelingPositionNum;
	public static final int MAX_FUEL_POS = IFuelSite.DEFAULT_MAX_POSITIONS;

	public APTAllowedFPConfig() {
	
	}
	
	public APTAllowedFPConfig(int fpNum) {
		this.fuelingPositionNum = fpNum;
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
		APTAllowedFPConfig config = (APTAllowedFPConfig) obj;
		
		config.setAllowedFP(this.fuelingPositionNum);
	}

	@Override
	public void validate() throws Exception {
		if(this.fuelingPositionNum <= 0 || this.fuelingPositionNum > MAX_FUEL_POS) {
			throw new Exception("Invalid Fueling Position Number : " + this.fuelingPositionNum);
		}
	}

	@Override
	public boolean isPKValid() {
		return false;
	}

	public int getAllowedFP() {
		return fuelingPositionNum;
	}

	public void setAllowedFP(int fpNum) {
		this.fuelingPositionNum = fpNum;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof APTAllowedFPConfig)) {
			return false;
		}
		
		APTAllowedFPConfig config = (APTAllowedFPConfig) obj;
		if(config.getAllowedFP() != this.fuelingPositionNum) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public int hashCode() {
		int hash = 18;
		hash += hash * 9 + this.fuelingPositionNum;
		
		return hash;
	}

}
