package com.verifone.isd.vsms2.sales.ent.vendcfg;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * @author VadirajaC1
 * 
 */
public class VendingConfigPK implements IEntityPK {

	private static final long serialVersionUID = 5160705264588353651L;

	public VendingConfigPK() {

	}

	@Override
	public boolean equals(IEntityPK obj) {
		if (obj instanceof VendingConfigPK) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof IEntityPK) {
			return this.equals((IEntityPK) obj);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return 37 * 17;
	}
}
