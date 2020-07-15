package com.verifone.isd.vsms2.sys.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *  Utility class to split a long message into multiple ones while
 *  honoring word boundaries.
 *  @version 1.0
 *  @author Anindya Datta "mailto:anindya_d1@verifone.com"
 *
 */
public class StringSplitter
{
	/**
	 * Breaks incoming (long) message into multiple lines of specified width at
     * word boundary. It also honors CR/LF characters in the original message.
     * 
     * @param message
     *            original long message
     * @param lineWidth
     *            maximum width for display / printing
     * @return array of broken up Strings
     */
    public static String[] splitAtWordBoundary(String message, int lineWidth) {
        List<String> lines = new ArrayList<String>();
        String str;

        if ((message != null) && (message.length() > 0)) {
              StringTokenizer st = new StringTokenizer(message, " \n\r\t", true);
              StringBuffer sb = new StringBuffer(lineWidth);

              while (st.hasMoreTokens()) {
                    String token = st.nextToken();
                    if (token.equals("\r")) {
                          continue;
                    } else if (token.equals("\n")) {
                          lines.add(sb.toString().trim());
                          sb = new StringBuffer(lineWidth);
                    } else if (sb.length() + token.length() <= lineWidth) {
                    	if (token.equals("\t")) {
                    		sb.append(" ");
                    	} else {
                    		sb.append(token);
                    	}
				} else {
					str = sb.toString().trim();
					if ((str != null) && (str.length() > 0)) {
						lines.add(str);
					}
					sb = new StringBuffer(lineWidth);
					sb.append(token);
					while (sb.length() > lineWidth) {
						lines.add(sb.substring(0, lineWidth));
						sb.delete(0, lineWidth);
					}
				}
            } 
              str = sb.toString().trim();
              if ((str != null) && (str.length() > 0)){
            	  lines.add(str);
              }
        }
        return ((String []) lines.toArray(new String[0]));
    }
    
    /**
     * 
     * Provide an API to truncate a flexible part of a long description 
     * @param original   - original description
     * @param flexpart -  flexible part, must be part of original description
     * @param fieldWidth - maximum field width where the description must be fitted
     * @return an abbreviated String for the output
     */
    public static String abbreviateSubString(String original, String flexpart, int fieldWidth) {
	int origLen = original.length();
	if (origLen <= fieldWidth) {
	    return original;
	}
	int firstOccur = original.indexOf(flexpart);
	if (firstOccur == -1) {
	    return original.substring(0, fieldWidth);
	}
	int truncate = origLen - fieldWidth;
	int flexLen = flexpart.length();
	/*
	 * For meaningful truncation we need at least 1 characters
	 * at the beginning and 2 characters at the end
	 */

	if (truncate > flexLen - 3) {
	    return original.substring(0, fieldWidth);
	}
	StringBuffer buf = new StringBuffer();
	buf.append(original.substring(0, firstOccur));
	buf.append(flexpart.substring(0, flexLen - 2 - truncate));
	buf.append(flexpart.substring(flexLen - 2, flexLen));
	buf.append(original.substring(firstOccur + flexLen));
	return buf.toString();
    }

}