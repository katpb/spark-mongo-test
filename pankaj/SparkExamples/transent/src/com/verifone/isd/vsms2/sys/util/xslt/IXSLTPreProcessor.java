package com.verifone.isd.vsms2.sys.util.xslt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;

/**
 * The Interface IXSLTPreProcessor is a handler to deal with loop back URL
 * requests,DOM source(Document) creator from a File.Interface Segregation
 * design principle followed.
 * 
 * @author Sanjeev_S1
 */
public interface IXSLTPreProcessor {

	/** The Constant SC_LOOPBACK. */
	public String SC_LOOPBACK = "http://127.0.0.1/cgi-bin/CGILink?cmd=";

	/**
	 * The Constant DEFAULT_XSLTENGINE_VAL is the default XSLT engine through
	 * factory.
	 */
	public String DEFAULT_XSLTENGINE_VAL = "xalan-xslt";

	/** The Constant XSLTENGINE_PROPNAME is the custom property name in config. */
	public String XSLTENGINE_PROPNAME = "xsltEngine.val";

	/** The Constant DEFAULT_TMP_DIR. */
	public static final String DEFAULT_TMP_DIR = "tmp";

	/** The Constant TEMP_DIR_PROPNAME. */
	public static final String TEMP_DIR_PROPNAME = "root.temp.dir";

	/** The Constant TEMP_DIRECTORY. */
	public static final String TEMP_DIRECTORY = SysPropertyFactory.getProperty(
			TEMP_DIR_PROPNAME, DEFAULT_TMP_DIR);

	/**
	 * Convert XML file to Document(DOM).
	 * 
	 * @param xmlFileName
	 *            the xml file name
	 * @return the document
	 * @throws FileNotFoundException
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 */
	Document convertXML2DOM(String xmlFileName) throws FileNotFoundException,
			SAXException, IOException, ParserConfigurationException;

	/**
	 * Retrieve source XML file required for XSLT processing..
	 * 
	 * @param url
	 *            the url
	 * @return the file
	 * @throws SAXException
	 */
	File retrieveSourceDoc(String url) throws SAXException;

	/**
	 * Retrieve XSLT parameter based on the URL sent.An XSLT param can be a DOM
	 * parameter predominantly.
	 * 
	 * @param url
	 *            the url
	 * @return the document
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 */
	Document retrieveXSLTParam(String url) throws ParserConfigurationException,
			IOException, SAXException;

	/**
	 * Convert DOCUMENT(DOM) to xml.
	 * 
	 * @param doc
	 * @param filename
	 * @throws Exception
	 */
	void convertDOMtoXML(Document doc, String filename) throws IOException,
			TransformerException;

	/**
	 * Convert string to xml.
	 * 
	 * @param xmlString
	 *            the xml string
	 * @param directoryName
	 *            the directory name
	 */
	void convertStringtoXML(String xmlString, String directoryName,
			String expectedFileName);
}