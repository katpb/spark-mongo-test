/*
 * CustomerTaxPK.java
 * Created by: JoswillP1
 *
 * COPYRIGHT (c) 2019 by VeriFone Inc., All Rights Reserved.
 *
 *                       N O T I C E
 *
 * Under Federal copyright law, neither the software nor accompanying
 * documentation may be copied, photocopied, reproduced, translated,
 * or reduced to any electronic medium or machine-readable form, in
 * whole or in part, without the prior written consent of VeriFone Inc.,
 * except in the manner described in the documentation.
 */
package com.verifone.isd.vsms2.sales.ent.customerTax;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.l10n.LocalizedRB;
import com.verifone.isd.vsms2.sys.l10n.TopazRes;

/**
 *
 * @author JoswillP1
 */
public class CustomerTaxPK implements IEntityPK, java.io.Serializable {
	private String taxID;
	public static final int MAX_CUSTOMER_TAXID_LEN = 20;
	public static final String FISCAL_FINAL_CONSUMER;
	public static final CustomerTaxPK FISCAL_FC_PK;
	static {
		/**
		 * PK for Final Consumer customer Tax Information
		 */
		FISCAL_FINAL_CONSUMER = LocalizedRB.getTopazRes(TopazRes.FISCAL_CF);
		FISCAL_FC_PK = new CustomerTaxPK(CustomerTaxPK.FISCAL_FINAL_CONSUMER);
	}

	public CustomerTaxPK(){
	}

	public CustomerTaxPK(String taxID) {
		if (taxID != null) {
			if (taxID.trim().length() < MAX_CUSTOMER_TAXID_LEN) {
				this.taxID = taxID.trim();
			} else {
				//TODO Throw new ecxeption?
			}
		}
	}

	public String getValue() {
		return taxID;
	}

	@Override
	public boolean equals(IEntityPK obj) {
		if (this == obj) return true;
		if (CustomerTaxPK.class.isInstance(obj)) {
			CustomerTaxPK cObj = CustomerTaxPK.class.cast(obj);
			return (this.taxID.equals(cObj.taxID));
		}
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		return (IEntityPK.class.isInstance(obj)?
				this.equals(IEntityPK.class.cast(obj)) : false);
	}

	@Override
	public boolean isValid() {
		return (taxID != null && !taxID.trim().isEmpty()
				&& taxID.length() <= MAX_CUSTOMER_TAXID_LEN
				&& !this.equals(FISCAL_FC_PK));
	}

	@Override
	public String toString() {
		return "taxID=" + taxID;
	}
}
