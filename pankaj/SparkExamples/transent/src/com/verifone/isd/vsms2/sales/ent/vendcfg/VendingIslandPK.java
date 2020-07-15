/**
 * 
 * VendingIslandPK.java
 * 
 * Copyright (C) 2015 Verifone, Inc.				ALL RIGHTS RESERVED.
 * 
 */

package com.verifone.isd.vsms2.sales.ent.vendcfg;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 *
 * @author T_JoswillP1 <t_joswillp1@verifone.com>
 */
public class VendingIslandPK implements IEntityPK {
	/**
	 * TODO: Set your constructor
	 * TODO: comment the JavaDoc
	 */
	public VendingIslandPK(){
	}

	@Override
	public boolean equals(IEntityPK obj) {
		if (obj instanceof VendingIslandPK) {
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
		return 37 * 18;
	}
}
