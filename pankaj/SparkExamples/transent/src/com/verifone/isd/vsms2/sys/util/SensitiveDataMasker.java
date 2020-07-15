package com.verifone.isd.vsms2.sys.util;

import java.util.Arrays;

/**
 * This utility class is used to mask any sensitive data like CardPAN,
 * CardCircuit.. It will mask all the characters in the sensitive data except
 * the first 6 and the last 4 characters and masking also depends on the number
 * of characters present in the sensitive data
 * 
 * @author T_VadirajaC1
 * 
 */
public class SensitiveDataMasker {

	private static final int LAST_CHAR_COUNT = 4;
	private static final int FIRST_CHAR_COUNT = 6;
	private static final char MASKING_CHARACTER = '*';

	/**
	 * This utility method gets a sensitive data which is to be masked and
	 * returns the masked data.
	 * 
	 * @param sensitiveData
	 *            Sensitive data to be masked
	 * @return Masked data masked String
	 */
	public static String mask(String sensitiveData) {
		return mask(sensitiveData, MASKING_CHARACTER);
	}
	
	/**
	 * Allow caller to specify masking character
	 * 
	 * @param sensitiveData
	 *            Sensitive data to be masked
	 * @param maskingChar
	 *            masking character to be used
	 * @return Masked data masked String
	 */
	public static String mask(String sensitiveData, char maskingChar) {
		if (sensitiveData != null) {
			char[] maskedData = mask(sensitiveData.toCharArray(), maskingChar);
			return String.valueOf(maskedData);
		}
		return sensitiveData;
	}
	
	/**
	 * This method gets a char array of sensitive data and masks it based on the
	 * number of characters present.
	 * 
	 * @param sensitiveData
	 *            Sensitive data to be masked
	 * @return Masked data masked char array
	 */
	public static char[] mask(char[] sensitiveData) {
		return mask(sensitiveData, MASKING_CHARACTER);
	}
	
	/**
	 * Allow caller to specify masking character
	 * 
	 * @param sensitiveData
	 *            Sensitive data to be masked
	 * @param maskingChar
	 *            masking character to be used
	 * @return Masked data masked char array
	 */
	public static char[] mask(char[] sensitiveData, char maskingChar) {
		int length = sensitiveData.length;

		if (length >= FIRST_CHAR_COUNT + LAST_CHAR_COUNT + 1) {

			char[] maskingCharachers = generateMaskedChars(length - (FIRST_CHAR_COUNT + LAST_CHAR_COUNT), maskingChar);

			System.arraycopy(maskingCharachers, 0, sensitiveData, FIRST_CHAR_COUNT, maskingCharachers.length);

		} else if (length > LAST_CHAR_COUNT*2) {

			char[] maskingCharachers = generateMaskedChars(length - (LAST_CHAR_COUNT), maskingChar);

			System.arraycopy(maskingCharachers, 0, sensitiveData, 0, maskingCharachers.length);

		} else if (length > LAST_CHAR_COUNT && length <= LAST_CHAR_COUNT*2) {

			char[] maskingCharachers = generateMaskedChars(LAST_CHAR_COUNT, maskingChar);

			System.arraycopy(maskingCharachers, 0, sensitiveData, 0, maskingCharachers.length);

		} else if (length <= LAST_CHAR_COUNT && length > 0) {

			sensitiveData = generateMaskedChars(length, maskingChar);
		}

		return sensitiveData;	
	}

	/**
	 * Generates the number of passed maskable characters specified in the count
	 * 
	 * @param count
	 *            Number of characters to which are maskable
	 * @return
	 */
	private static char[] generateMaskedChars(int count, char maskingChar) {
		char[] ca = new char[count];
		Arrays.fill(ca, maskingChar);
		return ca;
	}
}
