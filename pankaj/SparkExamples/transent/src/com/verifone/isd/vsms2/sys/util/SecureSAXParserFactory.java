package com.verifone.isd.vsms2.sys.util;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamSource;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

import com.verifone.isd.xml.directives.ParserConstants;

/**
 * Utility methods to obtain a secure instance of SAXParserFactory.
 * @author David_G3
 */
public class SecureSAXParserFactory {
    
    /*
     * Constants used to form URL from file path
     */
    private static final char FORWARD_SLASH_CHAR = '/';
    private static final String FORWARD_SLASH_STRING = "/";

    private SecureSAXParserFactory() {
    }

    /**
     * Obtain a new instance of a SAXParserFactory but preconfigured for secure parsing.
     * @return instance of a SAXParserFactory
     * @throws FactoryConfigurationError on failure
     */
    public static SAXParserFactory newSPFInstance() throws FactoryConfigurationError {
        return buildSPFInstance(null, null);
    }

    /**
     * Obtain a new instance of a SAXParserFactory from class name but preconfigured for secure parsing.
     * @param factoryClassName fully qualified factory class name that provides implementation of javax.xml.parsers.SAXParserFactory.
     * @param classLoader ClassLoader used to load the factory class. If null current Thread's context classLoader is used to load the factory class.
     * @return instance of a SAXParserFactory
     * @throws FactoryConfigurationError on failure
     */
    public static SAXParserFactory newSPFInstance(String factoryClassName, ClassLoader classLoader) throws FactoryConfigurationError {
        return buildSPFInstance(factoryClassName, classLoader);
    }

    /**
     * Obtain a new instance of a SAXParserFactory but preconfigured for secure parsing.
     * @return instance of a SAXParserFactory
     * @throws FactoryConfigurationError on failure
     */
    private static SAXParserFactory buildSPFInstance(String factoryClassName, ClassLoader classLoader) throws FactoryConfigurationError {
        SAXParserFactory factory = null;
        if (factoryClassName == null) {
            factory = SAXParserFactory.newInstance();
        } else {
            factory = SAXParserFactory.newInstance(factoryClassName, classLoader);
        }
        // Unfortunately SonarQube expects the statements below to be immediately after the line above, cannot move to private method
        try {
            factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            factory.setFeature(ParserConstants.APACHE_XML_FEATURES_DISALLOW_DOCTYPE_DECL, true);
            factory.setFeature(ParserConstants.XML_SAX_FEATURES_EXTERNAL_GENERAL_ENTITIES, false);
            factory.setFeature(ParserConstants.XML_SAX_FEATURES_EXTERNAL_PARAMETER_ENTITIES, false);
            factory.setFeature(ParserConstants.APACHE_XML_FEATURES_LOAD_EXTERNAL_DTD, false);
        } catch (ParserConfigurationException | SAXNotRecognizedException | SAXNotSupportedException e) {
            // Wrap the possible exceptions from setFeature() to that expected from newInstance()
            throw new FactoryConfigurationError(e);
        }
        /*
         * Note: Unlike DocumentBuilderFactory, these methods are absent from SAXParserFactory
         *   setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, ParserConstants.EXTERNAL_ACCESS_PROTOCOL_NONE);     // fails with xerces
         *   setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, ParserConstants.EXTERNAL_ACCESS_PROTOCOL_NONE);  // fails with xerces
         *   setExpandEntityReferences(false);
         */
        factory.setXIncludeAware(false);
        factory.setNamespaceAware(true);    // Set so caller doesn't have to, should always be true in our system
        factory.setValidating(false);       // Set so caller doesn't have to, should always be false in our system
        return factory;
    }

    /*
     * Static methods intended for use with Unmarshaller#unmarshal() to prepare a secure source via SecureSAXParser.
     * 
     * Note: We cannot produce a SecureSAXParser using the following
     * parameters because there is not enough information provided:
     *  toSecureSAXSource(Node node)
     *  toSecureSAXSource(DOMSource source)
     *  toSecureSAXSource(XMLStreamReader reader)
     *  toSecureSAXSource(XMLEventReader reader)
     * However, for Node, the source of data can be traced back to a prior call
     * to unmarshal() which can be secured using one of the static methods below.
     *  
     * Additionally, for:
     *  toSecureSAXSource(Source source)
     * only SAXSource and StreamSource can be used, so those methods are explicitly provided below.
     * 
     * The absence of the parameter types shown above will result in fast-fail behavior (i.e., compiler error)
     * if/when someone attempts to secure a source of XML data that cannot be supported.
     */

    /**
     * Filter XML data through a SecureSAXParser, use with existing unmarshal() calls.
     * All of the other methods in this group flow through here.
     * @param source source of XML data to read
     * @return SAXSource XML data via SecureSAXParser
     * @throws JAXBException using this exception type ensures compatibility with existing unmarshal() calls
     */
    public static SAXSource toSecureSAXSource(InputSource source) throws JAXBException {
        SAXParserFactory factory = SecureSAXParserFactory.newSPFInstance();
        SAXParser saxParser;
        XMLReader xmlReader = null;
        try {
            saxParser = factory.newSAXParser();
            xmlReader = saxParser.getXMLReader();
        } catch (ParserConfigurationException | SAXException e) {
            throw new JAXBException(e);
        }
        return new SAXSource(xmlReader, source);
    }

    /**
     * Filter XML data through a SecureSAXParser, use with existing unmarshal() calls.
     * @param f source of XML data to read
     * @return SAXSource XML data via SecureSAXParser
     * @throws JAXBException using this exception type ensures compatibility with existing unmarshal() calls
     */
    public static SAXSource toSecureSAXSource(File f) throws JAXBException {
        try {
            String path = f.getAbsolutePath();
            if (File.separatorChar != FORWARD_SLASH_CHAR)
                path = path.replace(File.separatorChar, FORWARD_SLASH_CHAR);
            if (!path.startsWith(FORWARD_SLASH_STRING))
                path = FORWARD_SLASH_STRING + path;
            if (!path.endsWith(FORWARD_SLASH_STRING) && f.isDirectory())
                path = path + FORWARD_SLASH_STRING;
            return toSecureSAXSource(new URL(ParserConstants.EXTERNAL_ACCESS_PROTOCOL_FILE, "", path));
        } catch(MalformedURLException e) {
            throw new IllegalArgumentException(e.getMessage());
        }        
    }

    /**
     * Filter XML data through a SecureSAXParser, use with existing unmarshal() calls.
     * @param url source of XML data to read
     * @return SAXSource XML data via SecureSAXParser
     * @throws JAXBException using this exception type ensures compatibility with existing unmarshal() calls
     */
    public static SAXSource toSecureSAXSource(URL url) throws JAXBException {
        return toSecureSAXSource(new InputSource(url.toExternalForm()));
    }

    /**
     * Filter XML data through a SecureSAXParser, use with existing unmarshal() calls.
     * @param is source of XML data to read
     * @return SAXSource XML data via SecureSAXParser
     * @throws JAXBException using this exception type ensures compatibility with existing unmarshal() calls
     */
    public static SAXSource toSecureSAXSource(InputStream is) throws JAXBException {
        return toSecureSAXSource(new InputSource(is));
    }

    /**
     * Filter XML data through a SecureSAXParser, use with existing unmarshal() calls.
     * @param reader source of XML data to read
     * @return SAXSource XML data via SecureSAXParser
     * @throws JAXBException using this exception type ensures compatibility with existing unmarshal() calls
     */
    public static SAXSource toSecureSAXSource(Reader reader) throws JAXBException {
        return toSecureSAXSource(new InputSource(reader));
    }

    /**
     * Filter XML data through a SecureSAXParser, use with existing unmarshal() calls.
     * @param source source of XML data to read
     * @return SAXSource XML data via SecureSAXParser
     * @throws JAXBException using this exception type ensures compatibility with existing unmarshal() calls
     */
    public static SAXSource toSecureSAXSource(StreamSource source) throws JAXBException {
        return toSecureSAXSource(SAXSource.sourceToInputSource(source));
    }

    /**
     * Filter XML data through a SecureSAXParser, use with existing unmarshal() calls.
     * @param source source of XML data to read
     * @return SAXSource XML data via SecureSAXParser
     * @throws JAXBException using this exception type ensures compatibility with existing unmarshal() calls
     */
    public static SAXSource toSecureSAXSource(SAXSource source) throws JAXBException {
        return toSecureSAXSource(SAXSource.sourceToInputSource(source));
    }
}
