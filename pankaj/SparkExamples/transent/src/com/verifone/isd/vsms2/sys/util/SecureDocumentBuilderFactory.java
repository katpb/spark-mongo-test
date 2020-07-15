package com.verifone.isd.vsms2.sys.util;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import com.verifone.isd.xml.directives.ParserConstants;

/**
 * Utility methods to obtain a secure instance of DocumentBuilderFactory.
 * @author David_G3
 */
public class SecureDocumentBuilderFactory {
    
    private SecureDocumentBuilderFactory() {
    }

    /**
     * Obtain a new instance of a DocumentBuilderFactory but preconfigured for secure parsing.
     * @return instance of a DocumentBuilderFactory
     * @throws FactoryConfigurationError on failure
     */
    public static DocumentBuilderFactory newDBFInstance() throws FactoryConfigurationError {
        return buildDBFInstance(null, null, false);        
    }

    /**
     * Obtain a new instance of a DocumentBuilderFactory from class name but preconfigured for secure parsing.
     * @param factoryClassName fully qualified factory class name that provides implementation of javax.xml.parsers.DocumentBuilderFactory.
     * @param classLoader ClassLoader used to load the factory class. If null current Thread's context classLoader is used to load the factory class.
     * @return instance of a DocumentBuilderFactory
     * @throws FactoryConfigurationError on failure
     */
    public static DocumentBuilderFactory newDBFInstance(String factoryClassName, ClassLoader classLoader) throws FactoryConfigurationError {
        return buildDBFInstance(factoryClassName, classLoader, false);
    }

    /**
     * Obtain a new instance of a DocumentBuilderFactory but preconfigured for secure parsing.
     * @return instance of a DocumentBuilderFactory
     * @throws FactoryConfigurationError on failure
     */
    public static DocumentBuilderFactory newDBFInstanceWithFileAccess() throws FactoryConfigurationError {
        return buildDBFInstance(null, null, true);        
    }

    /**
     * Obtain a new instance of a DocumentBuilderFactory from class name but preconfigured for secure parsing; WARNING: access to local file system is permitted!
     * @param factoryClassName fully qualified factory class name that provides implementation of javax.xml.parsers.DocumentBuilderFactory.
     * @param classLoader ClassLoader used to load the factory class. If null current Thread's context classLoader is used to load the factory class.
     * @return instance of a DocumentBuilderFactory
     * @throws FactoryConfigurationError on failure
     */
    public static DocumentBuilderFactory newDBFInstanceWithFileAccess(String factoryClassName, ClassLoader classLoader) throws FactoryConfigurationError {
        return buildDBFInstance(factoryClassName, classLoader, true);
    }

    /**
     * Obtain a new instance of a DocumentBuilderFactory but preconfigured for secure parsing; WARNING: access to local file system is permitted!
     * @return instance of a DocumentBuilderFactory
     * @throws FactoryConfigurationError on failure
     */
    private static DocumentBuilderFactory buildDBFInstance(String factoryClassName, ClassLoader classLoader, boolean bWithFileAccess) throws FactoryConfigurationError {
        DocumentBuilderFactory factory = null;
        if (factoryClassName == null) {
            factory = DocumentBuilderFactory.newInstance();
        } else {
            factory = DocumentBuilderFactory.newInstance(factoryClassName, classLoader);
        }
        // Unfortunately SonarQube expects the statements below to be immediately after the line above, cannot move to private method
        try {
            factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            factory.setFeature(ParserConstants.APACHE_XML_FEATURES_DISALLOW_DOCTYPE_DECL, true);
            factory.setFeature(ParserConstants.XML_SAX_FEATURES_EXTERNAL_GENERAL_ENTITIES, false);
            factory.setFeature(ParserConstants.XML_SAX_FEATURES_EXTERNAL_PARAMETER_ENTITIES, false);
            factory.setFeature(ParserConstants.APACHE_XML_FEATURES_LOAD_EXTERNAL_DTD, false);
        } catch (ParserConfigurationException e) {
            // Wrap the possible exception from setFeature() to that expected from newInstance()
            throw new FactoryConfigurationError(e);
        }
        try {
            factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, ParserConstants.EXTERNAL_ACCESS_PROTOCOL_NONE);     // fails with xerces
            factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, bWithFileAccess ? ParserConstants.EXTERNAL_ACCESS_PROTOCOL_FILE : ParserConstants.EXTERNAL_ACCESS_PROTOCOL_NONE);  // fails with xerces
        }
        catch (IllegalArgumentException e) {
            // Ignore as this is expected when the parser implementation is xerces
        }
        factory.setExpandEntityReferences(false);
        factory.setXIncludeAware(false);
        factory.setNamespaceAware(true);    // Set so caller doesn't have to, should always be true in our system
        factory.setValidating(false);       // Set so caller doesn't have to, should always be false in our system
        return factory;
    }
}
