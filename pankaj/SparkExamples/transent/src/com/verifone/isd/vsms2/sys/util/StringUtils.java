/**
 * 
 */
package com.verifone.isd.vsms2.sys.util;

import java.math.BigDecimal;

/**
 * String operation utility class
 * 
 * @author ManjunathaV1
 * 
 */
public class StringUtils {
	
	public static final String SINGLE_SPACE_STRING = " ";

	public static char SPACE_CHAR = ' ';
	
	public static final String DOT_STRING = ".";

	public static final String UTF8_CHARSET_STR = "UTF-8";

	public static final byte LOWEST_ASCII_PRINTABLE_CHARACTER = 0X20; // Space
	public static final byte HIGHEST_ASCII_PRINTABLE_CHARACTER  = 0X7E; // ~

	public static final String EMPTY_STRING = "";

	/***
	 * Checks passed in string param for non empty string
	 * 
	 * @param param
	 * @return
	 */
	public static boolean isNotNullNotEmpty(String param) {
		boolean retValue = false;
		if (param != null && param.trim().length() > 0) {
			retValue = true;
		}
		return retValue;
	}

	/***
	 * Checks passed in string param for null or empty string
	 * 
	 * @param param
	 * @return
	 */
	public static boolean isNullOrEmpty(String param) {
		return !isNotNullNotEmpty(param);
	}

	/***
	 * Formats the string to given length aligning the text to center with space
	 * as padding.
	 * 
	 * @param s
	 * @param size
	 * @return
	 */
	public static String formatCenter(String text, int size) {
		return formatCenter(text, size, SPACE_CHAR);
	}

	/***
	 * Formats the string to given length aligning the text to center with space
	 * as padding.
	 * 
	 * @param s
	 * @param size
	 * @return
	 */
	public static String formatLeft(String text, int size) {
		return formatLeft(text, size, SPACE_CHAR);
	}
	
	/***
	 * Formats the string to given length aligning the text to center with space
	 * as padding.
	 * 
	 * @param s
	 * @param size
	 * @return
	 */
	public static String formatRight(String text, int size) {
		return formatRight(text, SPACE_CHAR, size);
	}

	/**
	 * Creates a right justified string with the specified size. If the
	 * specified size is:
	 * 
	 * <ul>
	 * <li>same size as the input String, the input string is returned.
	 * <li>shorter than the input String, the input String is truncated. *
	 * <li>longer than the input String, the input String is left padded with
	 * the specified char.
	 * </ul>
	 * 
	 * @param size
	 *            The size of the output String
	 * @param value
	 *            The input String to be right justified
	 * @return A string that is right justified and left padded with a char
	 */
	public static final String formatRight(String inputString, char padChar, int size) {
		String formattedString = null;
		if (inputString == null) {
			formattedString = formatLeft(size, padChar);
		} else if (inputString.length() < size) {
			StringBuffer sb = new StringBuffer(size);
			sb.append(formatLeft(size - inputString.length(), padChar));
			sb.append(inputString);
			formattedString = sb.toString();
		} else if (inputString.length() > size) {
			formattedString = inputString.substring(inputString.length() - size, inputString.length());
		} else {
			formattedString = inputString;
		}
		return formattedString;
	}

	/**
	 * Creates a left justified string with the specified size. If the specified
	 * size is:
	 * 
	 * <ul>
	 * <li>same size as the input String, the input string is returned.
	 * <li>shorter than the input String, the input String is truncated.
	 * <li>longer than the input String, the input String is right padded with
	 * the specified character.
	 * </ul>
	 * 
	 * @param size
	 *            The size of the output String
	 * @param value
	 *            The input String to be left justified
	 * @return A string that is left justified and padded with a specified char
	 */
	public static final String formatLeft(String inputString, int size, char padChar) {
		String s = null;
		if (inputString == null) {
			s = formatLeft(size);
		} else if (inputString.length() < size) {
			StringBuffer sb = new StringBuffer(size);
			sb.append(inputString);
			sb.append(formatLeft(size - inputString.length(), padChar));
			s = sb.toString();
		} else if (inputString.length() > size) {
			s = inputString.substring(0, size);
		} else {
			s = inputString;
		}
		return s;
	}

	/***
	 * Formats the string to given length aligning the text to center with
	 * passed in padding char.
	 * 
	 * @param s
	 * @param size
	 * @param padding
	 * @return
	 */
	public static String formatCenter(String text, int size, char padding) {
		if (text == null || size <= text.length())
			return text;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < (size - text.length()) / 2; i++) {
			sb.append(padding);
		}
		sb.append(text);
		while (sb.length() < size) {
			sb.append(padding);
		}
		return sb.toString();
	}

	/**
	 * Creates a string containing the specified character with the specified
	 * length.
	 * 
	 * @return String that contains the specified character
	 * @param size
	 *            length of string
	 * @param fillerChar
	 *            the character used to fill this string
	 */
	public static final String formatLeft(int size, char fillerChar) {
		StringBuffer sb = new StringBuffer(size);
		for (int i = 0; i < size; i++) {
			sb.append(fillerChar);
		}
		return sb.toString();
	}

	/**
	 * This method creates a string of spaces with the specified length
	 * 
	 * @return String that contains spaces
	 * @param size
	 *            length of string to format
	 */
	public static final String formatLeft(int size) {
		return formatLeft(size, SPACE_CHAR);
	}
	
	/**
	 * Capitalize the first letter of a String 
	 * @param str String to be capitalized
	 * @return Capitalized String
	 */
	public static final String capitalize(String str){
		 if (str == null || str.length() == 0) {
		        return str;
		    }
		    return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	/**
	 * CR2291.01
	 *
	 * @param codePoints
	 * @return TRUE	-	if codePoints falls in ASCII printable range.
	 */
	public static boolean isPrintable(byte[] codePoints) {
		for(int index=0; index<codePoints.length; index++) {
			if(codePoints[index] < LOWEST_ASCII_PRINTABLE_CHARACTER
					|| codePoints[index] > HIGHEST_ASCII_PRINTABLE_CHARACTER) {
				return false;
			}
		}
		return true;
	}

	public static boolean isPrintable(String testString) {
		return isPrintable(testString.getBytes());
	}
    
    /**
     * Convenience method for use in JUnit tests where output to stdout is desired.
     * @param x string to output as a line
     */
    public static void junitSystemOutPrintln(String x) {
        System.out.println(x);
    }
    
    /**
     * Convenience method for use in JUnit tests where output to stdout is desired.
     * @param format A format string as described in Format string syntax
     * @param args Arguments referenced by the format specifiers
     */
    public static void junitSystemOutPrintf(String format, Object... args) {
        System.out.printf(format, args);
    }   
	
	/**
	 * Convenience method for use in JUnit tests where output to stderr is desired.
	 * @param x string to output as a line
	 */
	public static void junitSystemErrPrintln(String x) {
	    System.err.println(x);
	}
    
    /**
     * Convenience method for use in JUnit tests where output to stderr is desired.
     * @param format A format string as described in Format string syntax
     * @param args Arguments referenced by the format specifiers
     */
    public static void junitSystemErrPrintf(String format, Object... args) {
        System.err.printf(format, args);
    }	

    /**
	 * API to convert BigDecimal to String to fit out table schemas.
	 *
	 * @param decimalNumber
	 * @param stringLength
	 * @return
	 */
	public static String getStringVersion(BigDecimal decimalNumber, int stringLength) {
		if(decimalNumber == null || stringLength <=0) return "";

		StringBuilder builderString = new StringBuilder();
		int decimalIndex = decimalNumber.toPlainString().indexOf("."); // if decimal point is set, then decimalIndex >=0
		int zerosToAppend = stringLength - decimalNumber.toPlainString().length() + ((decimalIndex<0)?0:1);
		while(zerosToAppend >0) {
			builderString.append("0");
			zerosToAppend--;
		}
		if(decimalIndex < 0) {
			builderString.append(decimalNumber.toPlainString());
		} else {
			builderString.append(decimalNumber.toPlainString().substring(0, decimalIndex));
			builderString.append(decimalNumber.toPlainString().substring(decimalIndex+1));
		}
		return builderString.toString();
	}
}