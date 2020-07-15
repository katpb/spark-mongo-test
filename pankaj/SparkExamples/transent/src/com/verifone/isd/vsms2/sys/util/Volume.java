package com.verifone.isd.vsms2.sys.util;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to represent Volume. Default unit of measure is "USG". Default # of implied decimals is 3.
 */
public class Volume extends Quantity implements Serializable {
	private static final Logger LOGGER	= LoggerFactory.getLogger(Volume.class);
	/**
	 * serial version uid
	 */
	private static final long serialVersionUID = 5222777360492083875L;

	private static String defaultUOM = "USG";
	private static final int DEFAULT_NUMDECIMALS = 3;

	/** Constructor.
	 * @param value volume
	 */
	public Volume(long value) {
		super(value, DEFAULT_NUMDECIMALS, defaultUOM);
	}

	/**
	 * Copy constructor; preferred to clone method.
	 * @param orig original object to be cloned
	 */
	public Volume(Volume orig) {
		super(orig);
	}

	/** Constructor.
	 * @param value volume
	 * @param numDec Number of implied decimals
	 */
	public Volume(long value, int numDec) {
		super(value, numDec, defaultUOM);
	}

	/** Constructor
	 * @param value volume
	 * @param UOM unit of measure
	 */
	public Volume(long value, String UOM) {
		super(value, DEFAULT_NUMDECIMALS, UOM);
	}

	/** Constructor
	 * @param value volume
	 * @param numDec Number of implied decimals
	 * @param UOM unit of measure
	 */
	public Volume(long value, int numDec, String UOM) {
		super(value, numDec, UOM);
	}

	/** Constructor
	 * @param val string that represents the volume
	 */
	public Volume(String val) {
		super(val, DEFAULT_NUMDECIMALS, defaultUOM);
	}

	/** Constructor
	 * @param val string that represents the volume
	 * @param UOM unit of measure
	 */
	public Volume(String val, String UOM) {
		super(val, DEFAULT_NUMDECIMALS, UOM);
	}

	/** Constructor
	 * @param val string that represents the volume
	 * @param numDecs Number of implied decimals
	 */
	public Volume(String val, int numDecs) {
		super(val, numDecs, defaultUOM);
	}

	/** Constructor
	 * @param val string that represents the volume
	 * @param numDecs Number of implied decimals
	 * @param UOM unit of measure
	 */
	public Volume(String val, int numDecs, String UOM) {
		super(val, numDecs, UOM);
	}

	public static void setDefaultUOM(String defaultUOM) {
		Volume.defaultUOM = defaultUOM;
	}

	/** Implement Cloneable interface
	 * @return a clone object
	 */
	@Override
	public Object clone() {
		return super.clone();
	}

	/**
	 * Checks if the two objects are equal.
	 * 
	 * @return true if both objects are equal.
	 */
	@Override
	public boolean equals (Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null || !(obj instanceof Volume))
		{
			return false;
		}
		return super.equals(obj);
	}

	/**
	 * Gets the hashcode for this object
	 * 
	 * @return The hashcode
	 */
	@Override
	public int hashCode() {

		return super.hashCode();
	}
}
