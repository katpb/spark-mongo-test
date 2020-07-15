package com.verifone.isd.vsms2.sales.ent.fiscalreceipt;


import java.util.List;

import com.verifone.isd.vsms2.sales.ent.IEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.IEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Entity class for Fuel Flat Tax Config
 * @author T_VaishnaviS1
 *
 */
public class FuelFlatTaxConfig implements IEntityObject, IEntityVisitable{
	
	private static final long serialVersionUID = 749968824747991528L;
	private FuelFlatTaxConfigPK pk;
	private List<FuelFlatTaxDetailConfig> fuelFlatTaxs;
	public static final int MAX_FLAT_TAXES = 2;
	public static final int ADJ_AMT_DECIMALS = 3;
	public static final int MAX_FUEL_PROD = 20;
		
	
	public FuelFlatTaxConfig() {
	}
	
	public FuelFlatTaxConfig(FuelFlatTaxConfigPK pk) {
		this.pk = pk;
	}
	
	@Override
	public void setAttributes(IEntityObject obj) {
		FuelFlatTaxConfig config = (FuelFlatTaxConfig) obj;
		config.setPK(this.pk);
		config.setFuelFlatTaxs(this.fuelFlatTaxs);
	}

	@Override
	public void accept(IEntityVisitor v) throws Exception {
		v.visit(this);
	}
	
	@Override
	public IEntityPK getPK() {
		return pk;
	}
	
	@Override
	public void setPK(IEntityPK pk) {
		this.pk = (FuelFlatTaxConfigPK) pk;		
	}
	
	public List<FuelFlatTaxDetailConfig> getFuelFlatTaxs() {
		return fuelFlatTaxs;
	}

	public void setFuelFlatTaxs(List<FuelFlatTaxDetailConfig> fuelFlatTaxs) {
		this.fuelFlatTaxs = fuelFlatTaxs;
	}

	@Override
	public void validate() throws Exception {
        if (!this.isPKValid()) {
            throw new Exception("Invalid Id for Fuel Flat Tax Config: " +this.pk.getId());            
        }	
        
        for (int i = 0; i < fuelFlatTaxs.size(); i++) {
        	fuelFlatTaxs.get(i).validate();
        }
	}

	@Override
	public boolean isPKValid() {
		return (this.pk == null) ? false : this.pk.isValid();
	}

}
