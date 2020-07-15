package com.verifone.isd.vsms2.sales.ent.fiscalreceipt;

import com.verifone.isd.vsms2.sales.ent.IEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.IEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/**
 * Entity class for Fuel Flat Tax Detail Config
 * @author T_VaishnaviS1
 *
 */
public class FuelFlatTaxDetailConfig implements IEntityObject, IEntityVisitable, java.io.Serializable {
	
	private static final long serialVersionUID = -6337500063544394332L;
	private int flatTaxId;
	public String name;
	public MoneyAmount amount;
	public static int MAX_NAME_LENGTH = 10;
	
	public FuelFlatTaxDetailConfig() {
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MoneyAmount getAmount() {
		return amount;
	}
	public void setAmount(MoneyAmount amount) {
		this.amount = amount;
	}

	@Override
	public void accept(IEntityVisitor v) throws Exception {
		v.visit(this);
	}

	@Override
	public void setAttributes(IEntityObject obj) {
		FuelFlatTaxDetailConfig config = (FuelFlatTaxDetailConfig) obj;
		config.setFlatTaxId(this.flatTaxId);	
		config.setName(this.name);
		config.setAmount(this.amount);
	}

	@Override
	public void validate() throws Exception {
		if(this.flatTaxId <= 0 || flatTaxId > FuelFlatTaxConfig.MAX_FLAT_TAXES) {
			throw new Exception("Invalid Fuel Flat Tax ID : " + flatTaxId);
		}
		if(!(this.name != null && !this.name.isEmpty() && this.name.length() <= MAX_NAME_LENGTH)) {
			throw new Exception("Invalid name for Fuel Flat Tax Config : " + flatTaxId);
		}
		if(!(this.amount != null && this.amount.compareWithZero() > 0)) {
			throw new Exception("Invalid amount for Fuel Flat Tax Config : " + flatTaxId);
		}	
	}

	public int getFlatTaxId() {
		return flatTaxId;
	}

	public void setFlatTaxId(int flatTaxId) {
		this.flatTaxId = flatTaxId;
	}

	@Override
	public IEntityPK getPK() {
		return null;
	}

	@Override
	public void setPK(IEntityPK pk) {
		
	}

	@Override
	public boolean isPKValid() {
		return false;
	}
}
