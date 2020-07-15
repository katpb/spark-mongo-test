package com.verifone.isd.vsms2.fuel.ent.rcf;

import com.verifone.isd.vsms2.fuel.ent.FuelEntityVisitor;
import com.verifone.isd.vsms2.fuel.ent.IFuelEntityVisitable;
import com.verifone.isd.vsms2.fuel.ent.fuelSite.FuelServiceLevelEnum;
import com.verifone.isd.vsms2.fuel.ent.fuelSite.IFuelSite;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

public class RCFAttributeConfig implements IEntityObject, IFuelEntityVisitable {

	private static final long serialVersionUID = 2654005569967452341L;

	private RCFAttributeConfigPK pk;
	private int serviceLevel;
	private AutoApprovalEnum autoApproval = AutoApprovalEnum.DEFAULT;
	public static final int MAX_FUEL_POS = IFuelSite.DEFAULT_MAX_POSITIONS;
	
	public RCFAttributeConfig() {
		
	}
	
	public RCFAttributeConfig(RCFAttributeConfigPK pk) {
		this.pk = pk;
	}

	@Override
	public void accept(FuelEntityVisitor v) throws Exception {
		v.visit(this);
	}
	
	@Override
	public IEntityPK getPK() {
		return this.pk;
	}

	@Override
	public void setPK(IEntityPK pk) {
		this.pk = (RCFAttributeConfigPK) pk;
	}

	@Override
	public void setAttributes(IEntityObject obj) {
		if(obj instanceof RCFAttributeConfig) {
			RCFAttributeConfig rcfConfigFP = (RCFAttributeConfig) obj;
			rcfConfigFP.setPK(this.getPK());
			rcfConfigFP.setServiceLevel(this.getServiceLevel());
			rcfConfigFP.setAutoApproval(this.getAutoApproval());			
		}
	}

	@Override
	public void validate() throws Exception {
		if(!isPKValid()) {
			throw new Exception("Invalid fueling position ID : " + this.pk);
		}
		
		if (FuelServiceLevelEnum.getEnumFromInt(this.serviceLevel) == FuelServiceLevelEnum.UNKNOWN) {
			throw new Exception("Invalid service level for fueling position : " + this.pk);
		}
	}

	@Override
	public boolean isPKValid() {
		return (this.pk == null) ? false : this.pk.isValid();
	}

	public int getServiceLevel() {
		return serviceLevel;
	}

	public void setServiceLevel(int serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	public AutoApprovalEnum getAutoApproval() {
		return autoApproval;
	}

	public void setAutoApproval(AutoApprovalEnum autoApproval) {
		this.autoApproval = autoApproval;
	}
}
