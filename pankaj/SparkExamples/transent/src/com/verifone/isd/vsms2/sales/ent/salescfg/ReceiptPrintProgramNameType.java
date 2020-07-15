package com.verifone.isd.vsms2.sales.ent.salescfg;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReceiptPrintProgramNameType implements Serializable {
	/**
	 * Type-safe enumeration of receipt print name types configurable thro'
	 * SalesConfig
	 */
	private static final long serialVersionUID = 1388236572432827108L;

	private final String type;

	public static final ReceiptPrintProgramNameType YES = new ReceiptPrintProgramNameType("Yes");
	public static final ReceiptPrintProgramNameType NO = new ReceiptPrintProgramNameType("No");
	public static final ReceiptPrintProgramNameType DETAILED = new ReceiptPrintProgramNameType("Detailed");

	private static final Map<String, ReceiptPrintProgramNameType> lookup = new HashMap<>();

	static {
		for (ReceiptPrintProgramNameType type : Arrays.asList(YES, NO, DETAILED)) {
			lookup.put(type.getCode().substring(0, 1), type);
		}
	}

	private ReceiptPrintProgramNameType(final String text) {
		this.type = text;
	}

	public String getCode() {
		return type;
	}

	public static ReceiptPrintProgramNameType getEnumTypeByValue(String strType) {
		return lookup.get(strType);
	}

	// The 4 declarations below are necessary for serialization
	private static int nextOrdinal = 0;
	private final int ordinal = nextOrdinal++; // discount type; auto-incremented
	private static final ReceiptPrintProgramNameType[] VALUES = { YES, NO, DETAILED };

	/**
	 * Method to prevent duplicate constants from coexisting as a result of
	 * deserialization (ensures that only a single object represents each enum
	 * constant. This method is automatically invoked by the serialization
	 * mechanism. Without this method, Object.equals() method would be more involved
	 * and not a straightforward super.equals() which does just a == check.
	 * 
	 * @throws java.io.ObjectStreamException
	 *             on serialization system issues
	 * @return the enum array
	 */
	Object readResolve() throws java.io.ObjectStreamException {
		return VALUES[ordinal]; // Canonicalize
	}

	/**
	 * Getter for property ordinal.
	 * 
	 * @return Value of property ordinal.
	 */
	public int getOrdinal() {
		return this.ordinal;
	}

	/**
	 * Method to get the ReceiptPrintProgramNameType object for a specified ordinal.
	 * Used to get the object given a gempro's #define value
	 * 
	 * @param ordinal
	 *            the #define value represented by the object
	 * @return ReceiptPrintProgramNameType object representing the ordinal
	 */
	public static final ReceiptPrintProgramNameType getObject(int ordinal) {
		return VALUES[ordinal];
	}
}
