package com.verifone.isd.vsms2.sys.util;

import javax.xml.XMLConstants;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.validation.SchemaFactory ;
import javax.xml.validation.SchemaFactoryConfigurationError;

import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

import com.verifone.isd.xml.directives.ParserConstants;

/**
 * Utility methods to obtain a secure instance of SchemaFactory.
 * @author David_G3
 */
public class SecureSchemaFactory {

    private SecureSchemaFactory() {
    }

    /**
     * Obtain a new instance of a SchemaFactory but preconfigured for secure parsing.
     * @return instance of a SchemaFactory 
     * @throws FactoryConfigurationError on failure
     */
    public static SchemaFactory newSFInstance(String schemaLanguage) throws SchemaFactoryConfigurationError {
        return buildSFInstance(schemaLanguage, null, null, false);
    }

    /**
     * Obtain a new instance of a SchemaFactory from class name but preconfigured for secure parsing.
     * SchemaFactory is returned if specified factory class name supports the specified schema language.
     * @param schemaLanguage Specifies the schema language which the returned SchemaFactory will understand.
     * @param factoryClassName fully qualified factory class name that provides implementation of javax.xml.validation.SchemaFactory.
     * @param classLoader ClassLoader used to load the factory class.
     * @return instance of a SchemaFactory 
     */
    public static SchemaFactory newSFInstance(String schemaLanguage, String factoryClassName, ClassLoader classLoader) {
        return buildSFInstance(schemaLanguage, factoryClassName, classLoader, false);
    }

    /**
     * Obtain a new instance of a SchemaFactory but preconfigured for secure parsing; WARNING: access to local file system is permitted!
     * @return instance of a SchemaFactory 
     * @throws FactoryConfigurationError on failure
     */
    public static SchemaFactory newSFInstanceWithFileAccess(String schemaLanguage) throws SchemaFactoryConfigurationError {
        return buildSFInstance(schemaLanguage, null, null, true);
    }

    /**
     * Obtain a new instance of a SchemaFactory from class name but preconfigured for secure parsing; WARNING: access to local file system is permitted!
     * SchemaFactory is returned if specified factory class name supports the specified schema language.
     * @param schemaLanguage Specifies the schema language which the returned SchemaFactory will understand.
     * @param factoryClassName fully qualified factory class name that provides implementation of javax.xml.validation.SchemaFactory.
     * @param classLoader ClassLoader used to load the factory class.
     * @return instance of a SchemaFactory 
     */
    public static SchemaFactory newSFInstanceWithFileAccess(String schemaLanguage, String factoryClassName, ClassLoader classLoader) {
        return buildSFInstance(schemaLanguage, factoryClassName, classLoader, true);
    }

    /**
     * Obtain a new instance of a SchemaFactory but preconfigured for secure parsing.
     * @return instance of a SchemaFactory 
     * @throws FactoryConfigurationError on failure
     */
    private static SchemaFactory buildSFInstance(String schemaLanguage, String factoryClassName, ClassLoader classLoader, boolean bWithFileAccess) throws SchemaFactoryConfigurationError {
        if (!XMLConstants.W3C_XML_SCHEMA_NS_URI.equals(schemaLanguage))
            throw new IllegalArgumentException("W3C XML schema namespace is required for secure processing");
        SchemaFactory factory = null;
        if (factoryClassName == null) {
            factory = SchemaFactory.newInstance(schemaLanguage);
        } else {
            factory = SchemaFactory.newInstance(schemaLanguage, factoryClassName, classLoader);
        }
        // Unfortunately SonarQube expects the statements below to be immediately after the line above, cannot move to private method
        // Note: apache xerces, unlike JAXP default (built-in) implementation, doesn't recognize the two properties
        try {
            factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            factory.setFeature(ParserConstants.APACHE_XML_FEATURES_DISALLOW_DOCTYPE_DECL, true);
            //factory.setFeature(ParserConstants.XML_SAX_FEATURES_EXTERNAL_GENERAL_ENTITIES, false);
            //factory.setFeature(ParserConstants.XML_SAX_FEATURES_EXTERNAL_PARAMETER_ENTITIES, false);
            //factory.setFeature(ParserConstants.APACHE_XML_FEATURES_LOAD_EXTERNAL_DTD, false);
            try {   // Cannot extract this to private method as SonarQube will raise an issue about need to secure the factory 
                factory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, ParserConstants.EXTERNAL_ACCESS_PROTOCOL_NONE);
                factory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, bWithFileAccess ? ParserConstants.EXTERNAL_ACCESS_PROTOCOL_FILE : ParserConstants.EXTERNAL_ACCESS_PROTOCOL_NONE);
            } catch (SAXNotRecognizedException e) {
                // Must be using xerces, ignore it
            }
        } catch (SAXNotRecognizedException | SAXNotSupportedException e) {
            // Wrap the possible exception from setFeature() to that expected from newInstance()
            throw new SchemaFactoryConfigurationError(e);
        }
        return factory;
    }    
}
