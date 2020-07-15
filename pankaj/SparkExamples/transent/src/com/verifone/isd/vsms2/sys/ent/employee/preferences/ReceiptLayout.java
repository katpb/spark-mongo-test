package com.verifone.isd.vsms2.sys.ent.employee.preferences;

public enum ReceiptLayout {
	LEFT(0), 
	RIGHT(1);

	private int layout;

	private ReceiptLayout(int alignment) {
		this.layout = alignment;
	}

	public int getValue() {
		return layout;
	}

	public static ReceiptLayout fromValue(int value) {
		for (ReceiptLayout layout : ReceiptLayout.values()) {
			if (layout.getValue() == value) {
				return layout;
			}
		}
		return null;
	}

	public static ReceiptLayout fromValue(String value) {
		for (ReceiptLayout layout : ReceiptLayout.values()) {
			if (layout.toString().equalsIgnoreCase(value)) {
				return layout;
			}
		}
		return null;
	}

}
