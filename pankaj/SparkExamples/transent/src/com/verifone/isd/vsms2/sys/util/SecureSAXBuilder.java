package com.verifone.isd.vsms2.sys.util;

import javax.xml.XMLConstants;

import org.jdom.input.SAXBuilder;

import com.verifone.isd.xml.directives.ParserConstants;

/**
 * Utility methods to obtain a secure instance of SAXBuilder.
 * @author David_G3
 */
public class SecureSAXBuilder {
    
    private SecureSAXBuilder() {
    }

    /**
     * Obtain a new instance of a SAXBuilder but preconfigured for secure parsing.
     * @return instance of a SAXBuilder
     */
    public static SAXBuilder newSBInstance() {
        SAXBuilder sb = new SAXBuilder();
        sb.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        sb.setFeature(ParserConstants.APACHE_XML_FEATURES_DISALLOW_DOCTYPE_DECL, true);
        sb.setFeature(ParserConstants.XML_SAX_FEATURES_EXTERNAL_GENERAL_ENTITIES, false);
        sb.setFeature(ParserConstants.XML_SAX_FEATURES_EXTERNAL_PARAMETER_ENTITIES, false);
        sb.setFeature(ParserConstants.APACHE_XML_FEATURES_LOAD_EXTERNAL_DTD, false);
        return sb;
    }
}

