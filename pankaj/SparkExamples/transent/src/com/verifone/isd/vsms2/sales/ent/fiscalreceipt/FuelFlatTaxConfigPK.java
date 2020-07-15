package com.verifone.isd.vsms2.sales.ent.fiscalreceipt;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * 
 * @author T_VaishnaviS1
 *
 */
public class FuelFlatTaxConfigPK implements IEntityPK{
	
	private static final long serialVersionUID = 209081666942099611L;
	int id;
	
	public FuelFlatTaxConfigPK(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(IEntityPK obj) {
		if (obj != null && obj instanceof FuelFlatTaxConfigPK) {
			return (this.id == ((FuelFlatTaxConfigPK) obj).id);
		}
		return false;
	}

	@Override
	public boolean isValid() {
		return ((this.id > 0) && (this.id <= FuelFlatTaxConfig.MAX_FUEL_PROD));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
