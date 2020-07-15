package com.verifone.isd.vsms2.sales.ent.fiscalreceipt;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * 
 * @author T_VaishnaviS1
 *
 */
public class FiscalReceiptTaxExemptConfigPK implements IEntityPK {
	
	private static final long serialVersionUID = -5016346013361190695L;
	private int id;
	
	public FiscalReceiptTaxExemptConfigPK(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(IEntityPK obj) {
		if (obj != null && obj instanceof FiscalReceiptTaxExemptConfigPK) {
			return (this.id == ((FiscalReceiptTaxExemptConfigPK) obj).id);
		}
		return false;
	}

	@Override
	public boolean isValid() {
		return ((this.id > 0) && (this.id <= FiscalReceiptTaxExemptConfig.MAX_TAX_EXEMPT));
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
