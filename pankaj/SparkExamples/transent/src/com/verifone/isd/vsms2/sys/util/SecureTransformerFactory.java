package com.verifone.isd.vsms2.sys.util;

import javax.xml.XMLConstants;
import javax.xml.transform.ErrorListener;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory ;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.URIResolver;

import com.verifone.isd.xml.directives.ParserConstants;

/**
 * Utility methods to obtain a secure instance of TransformerFactory.
 * @author David_G3
 */
public class SecureTransformerFactory extends TransformerFactory {
    
    TransformerFactory factory;
    
    private SecureTransformerFactory() {
    }

    private SecureTransformerFactory(TransformerFactory factory) {
        this.factory = factory;
    }

    /**
     * Obtain a new instance of a TransformerFactory but preconfigured for secure parsing.
     * @return instance of a TransformerFactory 
     * @throws TransformerFactoryConfigurationError on failure
     */
    public static TransformerFactory newTFInstance() throws TransformerFactoryConfigurationError {
        return buildTFInstance(null, null, false);
    }

    /**
     * Obtain a new instance of a TransformerFactory from class name but preconfigured for secure parsing.
     * @param factoryClassName fully qualified factory class name that provides implementation of javax.xml.validation.TransformerFactory.
     * @param classLoader ClassLoader used to load the factory class.
     * @return instance of a TransformerFactory 
     * @throws TransformerFactoryConfigurationError on failure
     */
    public static TransformerFactory newTFInstance(String factoryClassName, ClassLoader classLoader) {
        return buildTFInstance(factoryClassName, classLoader, false);
    }

    /**
     * Obtain a new instance of a TransformerFactory but preconfigured for secure parsing; WARNING: access to local file system is permitted!
     * @return instance of a TransformerFactory 
     * @throws TransformerFactoryConfigurationError on failure
     */
    public static TransformerFactory newTFInstanceWithFileAccess() throws TransformerFactoryConfigurationError {
        return buildTFInstance(null, null, true);
    }

    /**
     * Obtain a new instance of a TransformerFactory from class name but preconfigured for secure parsing; WARNING: access to local file system is permitted!
     * @param factoryClassName fully qualified factory class name that provides implementation of javax.xml.validation.TransformerFactory.
     * @param classLoader ClassLoader used to load the factory class.
     * @return instance of a TransformerFactory 
     * @throws TransformerFactoryConfigurationError on failure
     */
    public static TransformerFactory newTFInstanceWithFileAccess(String factoryClassName, ClassLoader classLoader) {
        return buildTFInstance(factoryClassName, classLoader, true);
    }

    /**
     * Obtain a new instance of a TransformerFactory but preconfigured for secure parsing.
     * @return instance of a TransformerFactory
     * @throws TransformerFactoryConfigurationError on failure
     */
    private static TransformerFactory buildTFInstance(String factoryClassName, ClassLoader classLoader, boolean bWithFileAccess) throws TransformerFactoryConfigurationError {
        TransformerFactory factory = null;
        if (factoryClassName == null) {
            factory = new SecureTransformerFactory(TransformerFactory.newInstance());
        } else {
            factory = new SecureTransformerFactory(TransformerFactory.newInstance(factoryClassName, classLoader));
        }
        // Unfortunately SonarQube expects the statements below to be immediately after the line above, cannot move to private method
        try {
            factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            // factory.setFeature(ParserConstants.APACHE_XML_FEATURES_DISALLOW_DOCTYPE_DECL, true);     // fails with TransformerConfigurationException for JAXP built-in and xerces/xalan
            // factory.setFeature(ParserConstants.XML_SAX_FEATURES_EXTERNAL_GENERAL_ENTITIES, false);   // fails with JAXP built-in and xerces/xalan
            // factory.setFeature(ParserConstants.XML_SAX_FEATURES_EXTERNAL_PARAMETER_ENTITIES, false); // fails with JAXP built-in and xerces/xalan
            // factory.setFeature(ParserConstants.APACHE_XML_FEATURES_LOAD_EXTERNAL_DTD, false);// fails with JAXP built-in and xerces/xalan
        } catch (TransformerConfigurationException e) {
            // Wrap the possible exception from setFeature() to that expected from newInstance()
            throw new TransformerFactoryConfigurationError(e);
        }
        try {
            factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, ParserConstants.EXTERNAL_ACCESS_PROTOCOL_NONE);     // fails with xerces
            factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, bWithFileAccess ? ParserConstants.EXTERNAL_ACCESS_PROTOCOL_FILE : ParserConstants.EXTERNAL_ACCESS_PROTOCOL_NONE);  // fails with xerces
            factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, bWithFileAccess ? ParserConstants.EXTERNAL_ACCESS_PROTOCOL_FILE : ParserConstants.EXTERNAL_ACCESS_PROTOCOL_NONE);  // fails with xerces/xalan?
        }
        catch (IllegalArgumentException e) {
            // Ignore as this is expected when the parser implementation is xerces
        }
        return factory;
    }

    @Override
    public Transformer newTransformer(Source source) throws TransformerConfigurationException {
        return new SecureTransformer(factory.newTransformer(source));
    }

    @Override
    public Transformer newTransformer() throws TransformerConfigurationException {
        return new SecureTransformer(factory.newTransformer());
    }

    @Override
    public Templates newTemplates(Source source) throws TransformerConfigurationException {
        return factory.newTemplates(source);
    }

    @Override
    public Source getAssociatedStylesheet(Source source, String media, String title, String charset)
            throws TransformerConfigurationException {
        return factory.getAssociatedStylesheet(source, media, title, charset);
    }

    @Override
    public void setURIResolver(URIResolver resolver) {
        factory.setURIResolver(resolver);
    }

    @Override
    public URIResolver getURIResolver() {
        return factory.getURIResolver();
    }

    @Override
    public void setFeature(String name, boolean value) throws TransformerConfigurationException {
        factory.setFeature(name, value);
    }

    @Override
    public boolean getFeature(String name) {
        return factory.getFeature(name);
    }

    @Override
    public void setAttribute(String name, Object value) {
        factory.setAttribute(name, value);
    }

    @Override
    public Object getAttribute(String name) {
        return factory.getAttribute(name);
    }

    @Override
    public void setErrorListener(ErrorListener listener) {
        factory.setErrorListener(listener);
        
    }

    @Override
    public ErrorListener getErrorListener() {
        return factory.getErrorListener();
    }    
}
