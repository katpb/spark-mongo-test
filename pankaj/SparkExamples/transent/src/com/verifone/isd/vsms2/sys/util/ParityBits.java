package com.verifone.isd.vsms2.sys.util;



/**
 * Enumeration to fix the options that are settable for Parity.
 *
 */
public enum ParityBits {

    /**
     * The serial communication parity setting is Even parity.
     */
    EVEN(2),
    /**
     * The serial communication parity setting is Odd parity.
     */
    ODD(1),
    /**
     * The serial communication parity setting is No parity.
     */
    NONE(0);

    private int parityValue;
    
    private static String[]  enumStrings = {"NONE","ODD","EVEN"};

    private ParityBits(int parityValue){
        this.parityValue = parityValue;
    }

    /**
     * get integer representation for parity from the ParityEnum enumeration.
     * @return - the integer representation of the ParityEnum enumeration.
     */
    public int getParityValue() {
        return this.parityValue;
    }
    
    
    /**
	 * Returns the BaudRate corresponding to a String value.
	 */
	public static ParityBits fromString(String strVal) {
		ParityBits retVal = null;
		if (strVal != null) {
			if(strVal.equalsIgnoreCase(enumStrings[2]))
			{
				retVal = ParityBits.EVEN;
			}
			else if(strVal.equalsIgnoreCase(enumStrings[1]))
			{
				retVal = ParityBits.ODD;
			}
			else if(strVal.equalsIgnoreCase(enumStrings[0]))
			{
				retVal = ParityBits.NONE;
			}
		}
		return retVal;
	}
	
	/**
	 * Gets string representation of enum value by passing integer represenation of parity.
	 * 
	 * @param strVal
	 *            the str val
	 * @return the string
	 */
	public static String fromValue(int strVal) {
		String retVal = null;
		switch (strVal) {
		case 0:
			retVal = enumStrings[0];
			break;
		case 1:
			retVal = enumStrings[1];
			break;
		case 2:
			retVal = enumStrings[2];
			break;
		}
		return retVal;

	}
}
