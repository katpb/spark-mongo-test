
package com.verifone.isd.vsms2.sales.ent.salescfg;

import com.verifone.isd.vsms2.sales.ent.softkey.SoftKeyType;

/**
 * Enum for Sales config items related to Security Levels, which are moved to
 * SoftKeyType Security Config
 * 
 * @author Medha_K1
 *
 */
public enum SalesConfigSecurityLevelItem {

	RFS("RFS") { // Refund security
		@Override
		public String getSoftKeyCode() {
			return SoftKeyType.REFUND.getCode();
		}
	},
	VLS("VLS") { // Void line security
		@Override
		public String getSoftKeyCode() {
			return SoftKeyType.VOID_LINE.getCode();
		}
	},
	VTS("VTS") { // Void transaction security
		@Override
		public String getSoftKeyCode() {
			return SoftKeyType.VOID_TICKET.getCode();
		}
	},
	NSS("NSS") { // No sale security
		@Override
		public String getSoftKeyCode() {
			return SoftKeyType.NO_SALE.getCode();
		}
	},
	VPS("VPS") { // Vendor payment security - > Pay out security.
		@Override
		public String getSoftKeyCode() {
			return SoftKeyType.PAY_OUT.getCode();
		}
	},
	DSL("DSL") { // Discount Security Level
		@Override
		public String getSoftKeyCode() {
			return SoftKeyType.DISCOUNT.getCode();
		}
	},
	POS("POS") { // Price Override Security Level
		@Override
		public String getSoftKeyCode() {
			return SoftKeyType.PRICE_OVERRIDE.getCode();
		}
	},
	ECS("ECS") { // Error Correction Security Level
		@Override
		public String getSoftKeyCode() {
			return SoftKeyType.ERROR_CORRECT.getCode();
		}
	},
	SDC("SDC") { // Safe Drop Correction Security
		@Override
		public String getSoftKeyCode() {
			return SoftKeyType.SAFE_DROP_CORR.getCode();
		}
	},

	MUP("MUP") { // Managed Update Security Level
		@Override
		public String getSoftKeyCode() {
			return SoftKeyType.MANAGED_UPDATE.getCode();
		}
	};

	private String code;

	private SalesConfigSecurityLevelItem(final String code) {
		this.code = code;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/*
	 * Return the corresponding soft key code for the sales Config
	 */
	public abstract String getSoftKeyCode();
}
