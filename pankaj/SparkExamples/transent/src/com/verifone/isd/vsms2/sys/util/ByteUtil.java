/**
 * 
 */
package com.verifone.isd.vsms2.sys.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Utility class to convert Byte Array to various other forms.
 * 
 * @author Raghavendra_R1
 *
 */
public class ByteUtil
{
	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(ByteUtil.class);

	public static final byte ASCII_NULL  = 0x00;
	public static final byte ASCII_SOH   = 0x01;
	public static final byte ASCII_STX   = 0x02;
	public static final byte ASCII_ETX   = 0x03;
	public static final byte ASCII_EOT   = 0x04;
	public static final byte ASCII_ENQ   = 0x05;
	public static final byte ASCII_ACK   = 0x06;
	public static final byte ASCII_DLE   = 0x10;
	public static final byte ASCII_NAK   = 0x15;
	public static final byte ASCII_US    = 0x1F;
	public static final byte ASCII_SPACE = 0x20;
	public static final byte ASCII_ZERO  = 0x30;
	public static final byte ASCII_ONE   = 0x31;
	public static final byte ASCII_TWO   = 0x32;
	public static final byte ASCII_THREE = 0x33;
	public static final byte ASCII_FOUR  = 0x34;
	public static final byte ASCII_FIVE  = 0x35;
	public static final byte ASCII_SIX   = 0x36;
	public static final byte ASCII_SEVEN = 0x37;
	public static final byte ASCII_EIGHT = 0x38;
	public static final byte ASCII_NINE  = 0x39;
	public static final byte ASCII_A 	  = 0x41;
	public static final byte ASCII_B     = 0x42;
	public static final byte ASCII_C     = 0x43;
	public static final byte ASCII_D     = 0x44;
	public static final byte ASCII_E     = 0x45;
	public static final byte ASCII_F     = 0x46;
	public static final byte ASCII_G     = 0x47;
	public static final byte ASCII_H     = 0x48;
	public static final byte ASCII_I     = 0x49;
	public static final byte ASCII_J     = 0x4A;
	public static final byte ASCII_K     = 0x4B;
	public static final byte ASCII_L     = 0x4C;
	public static final byte ASCII_M     = 0x4D;
	public static final byte ASCII_N     = 0x4E;
	public static final byte ASCII_O     = 0x4F;
	public static final byte ASCII_P     = 0x50;
	public static final byte ASCII_Q     = 0x51;
	public static final byte ASCII_R     = 0x52;
	public static final byte ASCII_S     = 0x53;
	public static final byte ASCII_T     = 0x54;
	public static final byte ASCII_U     = 0x55;
	public static final byte ASCII_V     = 0x56;
	public static final byte ASCII_W     = 0x57;
	public static final byte ASCII_X     = 0x58;
	public static final byte ASCII_Y     = 0x59;
	public static final byte ASCII_Z     = 0x5A;
	public static final byte ASCII_SMALL_A 	    = 0x61;
	public static final byte ASCII_SMALL_B      = 0x62;
	public static final byte ASCII_SMALL_C      = 0x63;
	public static final byte ASCII_SMALL_D      = 0x64;
	public static final byte ASCII_SMALL_E      = 0x65;
	public static final byte ASCII_SMALL_F      = 0x66;
	public static final byte ASCII_SMALL_G      = 0x67;
	public static final byte ASCII_SMALL_H      = 0x68;
	public static final byte ASCII_SMALL_I      = 0x69;
	public static final byte ASCII_SMALL_J      = 0x6A;
	public static final byte ASCII_SMALL_K      = 0x6B;
	public static final byte ASCII_SMALL_L      = 0x6C;
	public static final byte ASCII_SMALL_M      = 0x6D;
	public static final byte ASCII_SMALL_N      = 0x6E;
	public static final byte ASCII_SMALL_O      = 0x6F;
	public static final byte ASCII_SMALL_P      = 0x70;
	public static final byte ASCII_SMALL_Q      = 0x71;
	public static final byte ASCII_SMALL_R      = 0x72;
	public static final byte ASCII_SMALL_S      = 0x73;
	public static final byte ASCII_SMALL_T      = 0x74;
	public static final byte ASCII_SMALL_U      = 0x75;
	public static final byte ASCII_SMALL_V      = 0x76;
	public static final byte ASCII_SMALL_W      = 0x77;
	public static final byte ASCII_SMALL_X      = 0x78;
	public static final byte ASCII_SMALL_Y      = 0x79;
	public static final byte ASCII_SMALL_Z      = 0x7A;
	
	/**
	 * No-args constructor
	 */
	public ByteUtil() {

	}
	
	/**
	 * Gets the int from bytes.
	 *
	 * @param array the array
	 * @param index the offset
	 * @param length the length
	 * @return the int from bytes
	 */
	public static int toInt(byte[] array, int index, int length) throws NumberFormatException {
		return (int)toLong(array, index, length);
	}

	/**
	 * Gets the primitive short from bytes.
	 *
	 * @param array the array
	 * @param index the offset
	 * @param length the length
	 * @return the short from bytes
	 */
	public static short toShort(byte[] array, int index, int length) throws NumberFormatException {
		return (short)toLong(array, index, length);
	}

	/**
	 * Gets the primitive long from bytes.
	 *
	 * @param array the array
	 * @param index the offset
	 * @param length the length
	 * @return the long from bytes
	 * @throws NumberFormatException
	 */
	public static long toLong(byte[] array, int index, int length) throws NumberFormatException {

		long result = 0;
		for(int i = 0, counter = index; i < length; i++, counter++) {
			byte currentByte = array[counter];
			if(currentByte < ASCII_ZERO || currentByte > ASCII_NINE) {
				LOGGER.debug("Invalid byte present at index '{}' in the array '{}' while conversion",i,new String(array));
				throw new NumberFormatException("Byte not in numeric range");
			}
			result = result * 10 + (currentByte - ASCII_ZERO);
		}
		LOGGER.debug("After conversion to long primitive data type,value is '{}'",result);
		return result;
	}
	
	/**
	 * Gets the string from bytes.
	 *
	 * @param array the array
	 * @param index the offset
	 * @param length the length
	 * @return the string from bytes
	 */
	public static String toString(byte[] array, int index, int length) {
		return new String(array, index, length);
	}
	
	/**
	 * Convert byte array to hex string with spaces between each byte
	 * @param bytes[]
	 */
	public static String getHexString(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		sb.append(" : ");
		for(byte b: bytes) {
			sb.append(String.format("%02X ", b));
		}
		return sb.toString();
	}
	
	/**
	 * Convert byte to hex string
	 * @param byte
	 */
	public static String getHexString(byte b) {
		return String.format("%02X", b);
	}
	
	/**
	 * Gets the money amount from bytes.
	 *
	 * @param array the array
	 * @param index the offset
	 * @param length the length
	 * @param numDecimals the num decimals
	 * @return the money amount from bytes
	 */
	public static MoneyAmount toMoneyAmount(byte[] array, int index, int length, int numDecimals) throws NumberFormatException {
		return new MoneyAmount(toLong(array, index, length), numDecimals);
	}
}
