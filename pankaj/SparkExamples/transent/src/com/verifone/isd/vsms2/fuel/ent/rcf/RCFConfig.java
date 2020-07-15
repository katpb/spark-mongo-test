package com.verifone.isd.vsms2.fuel.ent.rcf;

import java.util.HashMap;
import java.util.Map;

import com.verifone.isd.vsms2.fuel.ent.FuelEntityVisitor;
import com.verifone.isd.vsms2.fuel.ent.IFuelEntityVisitable;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

public class RCFConfig implements IEntityObject, IFuelEntityVisitable {

	private static final long serialVersionUID = -6659925147443143085L;
	
	private RCFConfigPK pk;
	private String name;
	private Map <Integer, RCFAttributeConfig> fuelingPositions;
	public static final int MAX_RCF = 20;

	public RCFConfig() {
		this.fuelingPositions = new HashMap<Integer, RCFAttributeConfig>();
	}
	
	public RCFConfig(RCFConfigPK pk) {
		this.pk = pk;
		this.fuelingPositions = new HashMap<Integer, RCFAttributeConfig>();
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
		this.pk = (RCFConfigPK) pk;
	}

	@Override
	public void setAttributes(IEntityObject obj) {
		RCFConfig rcfconfig = (RCFConfig) obj;
		rcfconfig.setPK(this.getPK());
		rcfconfig.setName(this.getName());
		rcfconfig.setFuelingPositions(this.getFuelingPositions());
	}

	@Override
	public void validate() throws Exception {
		if (!isPKValid()) {
			throw new Exception("Invalid rapid change fuel ID : " + this.pk);            
		}
		if ((this.name == null) || (this.name.trim().equals("")) || (this.name.trim().equals("*"))) {
			throw new Exception("Invalid name for rapid change fuel : " + this.pk);
		}        
	}

	@Override
	public boolean isPKValid() {
		return (this.pk == null) ? false : this.pk.isValid();
	}

	public String getName() {
		return name;
	}

	public void setName(String rcfName) {
		this.name = rcfName;
	}

	public Map<Integer, RCFAttributeConfig> getFuelingPositions() {
		return fuelingPositions;
	}

	public void setFuelingPositions(Map<Integer, RCFAttributeConfig> fuelingPositions) {
		this.fuelingPositions = fuelingPositions;
	}

}
