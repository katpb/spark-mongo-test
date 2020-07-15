package com.verifone.isd.vsms2.sys.util;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.URIResolver;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamSource;

import org.xml.sax.SAXException;

import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.ErrorListener;
import javax.xml.transform.Result;
import javax.xml.transform.Source;

/**
 * Extend Transformer to force its transform() method to use an input source secured against XXE attacks.
 * Other methods are passed through to the superclass (Transformer).
 * This is automatically incorporated for Transformer instances where the TransformerFactory
 * is obtained from SecureTransformerFactory. 
 * @author David_G3
 */
public class SecureTransformer extends Transformer {
    
    Transformer transformer;
    
    public SecureTransformer(Transformer transformer) {
        this.transformer = transformer;
    }

    /**
     * Transform the XML Source to a Result after modifying the XML Source using a method
     * from SecureSAXParserFactory.
     * @param xmlSource The XML input to transform.
     * @param outputTarget The Result of transforming the xmlSource.
     * @throws TransformerException If an unrecoverable error occurs during the course of the transformation.
     */
    public void transform(Source xmlSource, Result outputTarget) throws TransformerException {
        SAXParserFactory spf = SecureSAXParserFactory.newSPFInstance();
        Source xmlSource2 = null;
        try {
            if (xmlSource instanceof StreamSource) {
                xmlSource2 = new SAXSource(spf.newSAXParser().getXMLReader(), SAXSource.sourceToInputSource(xmlSource));
            } else {
                throw new TransformerException("Expecting instance of StreamSource");
            }
        } catch (SAXException | ParserConfigurationException e) {
            throw new TransformerException(e);
        }
        transformer.transform(xmlSource2, outputTarget);
    }

    @Override
    public void setParameter(String name, Object value) {
        transformer.setParameter(name, value);
    }

    @Override
    public Object getParameter(String name) {
        transformer.getParameter(name);
        return null;
    }

    @Override
    public void clearParameters() {
        transformer.clearParameters();
    }

    @Override
    public void setURIResolver(URIResolver resolver) {
        transformer.setURIResolver(resolver);
    }

    @Override
    public URIResolver getURIResolver() {
        return transformer.getURIResolver();
    }

    @Override
    public void setOutputProperties(Properties oformat) {
        transformer.setOutputProperties(oformat);
    }

    @Override
    public Properties getOutputProperties() {
        return transformer.getOutputProperties();
    }

    @Override
    public void setOutputProperty(String name, String value) {
        transformer.setOutputProperty(name, value);
    }

    @Override
    public String getOutputProperty(String name) {
        return transformer.getOutputProperty(name);
    }

    @Override
    public void setErrorListener(ErrorListener listener) {
        transformer.setErrorListener(listener);
    }

    @Override
    public ErrorListener getErrorListener() {
        return transformer.getErrorListener();
    }
}
