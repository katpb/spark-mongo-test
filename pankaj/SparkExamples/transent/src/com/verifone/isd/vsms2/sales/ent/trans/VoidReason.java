package com.verifone.isd.vsms2.sales.ent.trans;
/**
 * Collection of possible reasons for voiding a transaction
 * @author Medha_K1
 *
 */
public enum VoidReason {

	AEOD_VOID("AEOD Void"), INACTIVITY_VOID("Inactivity Void");

	VoidReason(String s) {
		this.value = s;
	}

	private String value;

	public String getValue() {
		return this.value;
	}
}
