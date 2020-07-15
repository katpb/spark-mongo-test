/*
 * FiscalReceiptConfigPK.java
 * Created by: JoswillP1
 *
 * COPYRIGHT (c) 2018 by VeriFone Inc., All Rights Reserved.
 *
 *                       N O T I C E
 *
 * Under Federal copyright law, neither the software nor accompanying
 * documentation may be copied, photocopied, reproduced, translated,
 * or reduced to any electronic medium or machine-readable form, in
 * whole or in part, without the prior written consent of VeriFone Inc.,
 * except in the manner described in the documentation.
 */
package com.verifone.isd.vsms2.sales.ent.fiscalreceipt;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 *
 * @author JoswillP1
 */
public class FiscalReceiptConfigPK implements IEntityPK {

	private static final long serialVersionUID = -972128647791856335L;

	public FiscalReceiptConfigPK() {
		
	}
	
	@Override
	public boolean equals(IEntityPK obj) {
		return (obj instanceof FiscalReceiptConfigPK);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof IEntityPK) {
			return this.equals((IEntityPK) obj);
		}
		return false;
	}

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 7 * 13;
		return hash;
	}
}
