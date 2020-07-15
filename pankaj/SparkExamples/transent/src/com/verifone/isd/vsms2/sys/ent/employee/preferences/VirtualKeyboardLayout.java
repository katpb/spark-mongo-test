package com.verifone.isd.vsms2.sys.ent.employee.preferences;

public enum VirtualKeyboardLayout {
	MOVABLE(0), 
	BUILT_IN(1);

	private int value;

	private VirtualKeyboardLayout(int alignment) {
		this.value = alignment;
	}

	public int getValue() {
		return value;
	}

	public static VirtualKeyboardLayout fromValue(int value) {
		for (VirtualKeyboardLayout layout : VirtualKeyboardLayout.values()) {
			if (layout.getValue() == value) {
				return layout;
			}
		}
		return null;
	}

	public static VirtualKeyboardLayout fromValue(String value) {
		for (VirtualKeyboardLayout layout : VirtualKeyboardLayout.values()) {
			if (layout.toString().equalsIgnoreCase(value)) {
				return layout;
			}
		}
		return null;
	}
}
