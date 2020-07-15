/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.verifone.isd.vsms2.sys.util;

import com.verifone.isd.vsms2.sys.util.sax.SAXContentHandler;
import com.verifone.isd.xml.vocabulary.IXMLVocabulary;
import org.xml.sax.Attributes;

/**
 * class to parse the CGI response
 */
public class VFIResponseXMLHandler extends SAXContentHandler {

    private StringBuffer buffer = null;
    private StringBuffer errorBuffer = null;
    private boolean isfaultDocument = false;

    public VFIResponseXMLHandler() {
        buffer = new StringBuffer();
        errorBuffer = new StringBuffer();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        buffer.delete(0, buffer.length());
        if (localName.equals(IXMLVocabulary.CGI_FAULT)) {
            isfaultDocument = true;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (isfaultDocument) {
            if (localName.equals(IXMLVocabulary.CGI_FAULT_CODE) || localName.equals(IXMLVocabulary.CGI_FAULT_STRING) || localName.equals(IXMLVocabulary.CGI_VFI_FAULT_MSG) || localName.equals(IXMLVocabulary.CGI_FAULT_PARSE_LINE) || localName.equals(IXMLVocabulary.CGI_FAULT_PARSE_COL) || localName.equals(IXMLVocabulary.CGI_FAULT_PARSE_ELEM)) {
                errorBuffer.append(localName);
                errorBuffer.append(": ");
                errorBuffer.append(buffer.toString());
                errorBuffer.append(" ").append(System.getProperty("line.separator"));
            }
        }
    }

    public String getErrorData() {
        if (isfaultDocument){
            return errorBuffer.toString();
        } else {
            return null;
        }
    }

    public String getValue(String element) {
        String value = null;
        String[] lines = errorBuffer.toString().split(System.getProperty("line.separator"));
        for (String line : lines) {
            if (line.startsWith(element) && line.indexOf(':') > 0) {
                value = line.substring(line.indexOf(':') + 1);
            }
        }
        return value;
    }
    
    public boolean isFaultDocument() {
    	return isfaultDocument;
    }
}
