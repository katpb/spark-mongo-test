package com.verifone.isd.vsms2.sys.util;

import java.io.IOException;

public class XMLTransformer {
    /**
     * Converts xml to a plain String by replacing < > & ' " with Entity References. 
     * @param xml the xml to convert 
     * @return string
     */
    public static String xmlToString(String xml) {		
	char[] chars = xml.toCharArray();
	StringBuffer buffer = new StringBuffer();
	for (int i=0; i<chars.length; i++) {
	    if (chars[i] == '<') {
		buffer.append("&lt;");
	    } else if (chars[i] == '>') {
		buffer.append("&gt;");
	    } else if (chars[i] == '&') {
		buffer.append("&amp;");
	    } else if (chars[i] == '\'') {
		buffer.append("&apos;");
	    } else if (chars[i] == '"') {
		buffer.append("&quot;");
	    } else {
		buffer.append((char)chars[i]);
	    }
	}
	return buffer.toString();
    }

    /**
     * Converts String to xml by Entity References with < > & ' ". 
     * @param String 
     * @return xml 
     */
    public static String stringToXml(String text) {
	StringBuffer buffer = new StringBuffer();
	String token = null;
	int index1 = 0;
	int index2 = -1;	
	while ((index2 = text.indexOf('&',index1)) != -1) {
	    buffer.append(text.substring(index1, index2));
	    index1 = text.indexOf(';',index1) + 1;
	    token = text.substring(index2,index1);
	    if (token.equals("&lt;")) {
		buffer.append("<");
	    } else if (token.equals("&gt;")) {
		buffer.append(">");
	    } else if (token.equals("&amp;")) {
		buffer.append("&");
	    } else if (token.equals("&apos;")) {
		buffer.append("'");
	    } else if (token.equals("&quot;")) {
		buffer.append("\"");
	    }	    
	}
	return buffer.toString();
    }

    public static void main(String args[]) throws IOException {
	String actualString = "<root><element1 att=\"sf\" att=''></element1><element2/></root>";
	String s1 = xmlToString("<root><element1 att=\"sf\" att=''></element1><element2/></root>");
	String s2 = stringToXml(s1);
	System.out.println(actualString);
	System.out.println(s1);
	System.out.println(s2);
	
	System.out.println(actualString.equals(s2));
    }
}
