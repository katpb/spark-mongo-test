package com.verifone.isd.vsms2.sys.util.xslt;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import com.verifone.isd.vsms2.sys.util.FileUtil;
import com.verifone.isd.vsms2.sys.util.SecureDocumentBuilderFactory;
import com.verifone.isd.vsms2.sys.util.SecureSAXParserFactory;
import com.verifone.isd.vsms2.sys.util.sax.SAXBreakOutException;
import com.verifone.isd.xml.vocabulary.IXMLVocabulary;

/**
 * XSLTPreProcessorImpl is a helper class to retrieve sourceXML/XSLT DOM
 * parameter through a loop back CGI request. It can return the result of CGI
 * request as a DOM or a File.
 * 
 * @author Sanjeev_S1
 * 
 */
public class XSLTPreProcessorImpl implements IXSLTPreProcessor {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(XSLTPreProcessorImpl.class);

	/** The Constant HTTP_RESPONSE_OK. */
	private static final int HTTP_RESPONSE_OK = 200;

	/** The Constant SOURCE_XML. */
	private static final String SOURCE_XML = File.separator + TEMP_DIRECTORY
			+ File.separator + "Src";

	private StringBuffer    curElemStr;
	@Override
	public Document convertXML2DOM(final String xmlFileName)
			throws SAXException, IOException, ParserConfigurationException {
		FileInputStream fin = null;
		try {
			LOGGER.info("XML to be converted to DOM input is '{}'",
					xmlFileName);
			File file = new File(xmlFileName);
			fin = new FileInputStream(file);
			InputSource inSource = new InputSource(
					this.getUsableInputStream(fin));
			return this.createDOM(inSource);
			/**
			 * The 'toString(document)' representation by default is [#document:
			 * null].This doesn't mean that document=null.
			 */
		} finally {
			if (null != fin) {
				fin.close();
			}
		}
	}

	@Override
	public File retrieveSourceDoc(final String urlVal) throws SAXException {
		LOGGER.info("retrieveSourceDoc instantiated with url ='{}'", urlVal);
		File file = null;
		InputStream inputStream = null;
		OutputStream out = null;
		try {
			inputStream = this.fireURL(urlVal);
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("ssSSS");
			file = new File(SOURCE_XML + dateFormat.format(date) + ".xml");
			out = new FileOutputStream(file);
			int read = 0;
                        byte[] bytes = new byte[10240];
			while ((read = inputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
                        out.close();
			LOGGER.info(
					"Source XML is created on the fly with size '{}' bytes.Path of the SourceXML is '{}'",
					file.length(), file.getCanonicalPath());
			this.validateXML(file, urlVal);
		} catch (MalformedURLException e) {
			LOGGER.error("MalformedURLException while firing URL", e);
		} catch (IOException e) {
			LOGGER.error("IOException while firing URL", e);
		} finally {
			try {
				if (null != inputStream) {
					inputStream.close();
				}
				if (null != out) {
					out.close();
				}
			} catch (IOException e) {
				LOGGER.error("Unable to close streams:'{}'", e);
			}
		}
		return file;
	}

	/**
	 * Validate xml.
	 * 
	 * @param srcXML
	 *            the src xml
	 * @param srcXMLURL
	 *            the src xmlurl
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws SAXException
	 *             the sAX exception
	 */
	private void validateXML(File srcXML, String srcXMLURL)
			throws IOException, SAXException {
		DefaultHandler handler = new DefaultHandler() {
			List<String> xmlElementsObtained = new ArrayList<String>();

			@Override
			public void startElement(String uri, String localName, String name,
					Attributes attributes) throws SAXException {
				curElemStr = new StringBuffer();
				xmlElementsObtained.add(localName);
				
				if (xmlElementsObtained.size() > 3) {
					String faultXMLElement = IXMLVocabulary.CGI_FAULT;
					
					if (!xmlElementsObtained.contains(faultXMLElement)) {
						throw new SAXBreakOutException();
					}
				}
			}
			
			@Override
			public void endElement(String uri, String localName, String qName)
			        throws SAXException {
				
				if(localName.equalsIgnoreCase(IXMLVocabulary.CGI_VFI_FAULT_MSG)) {
					if(curElemStr.length() > 0) {
						throw new SAXException(curElemStr.toString());
					} 
				}
				if (localName.equalsIgnoreCase(IXMLVocabulary.CGI_FAULT)) {
					// If fault occurred but there was no "message" element
					throw new SAXException("Fault document received.");
				}
			}
			
			@Override  
			public void characters(char ch[], int start, int length)
			        throws SAXException {
			            if (curElemStr != null) {
			                for (int i = start; i < start + length; i++) {
			                    switch (ch[i]) {
			                        case '\\':
			                        case '"':
			                        case '\n':
			                        case '\r':
			                        case '\t':
			                            break;
			                        default:
			                            curElemStr.append(ch[i]);
			                            break;
			                    }
			                }
			            }
			        }     
		};

		SAXParserFactory spf = SecureSAXParserFactory.newSPFInstance();
		XMLReader reader = null;
		try {
			SAXParser parser = spf.newSAXParser();
			reader = parser.getXMLReader();
			reader.setContentHandler(handler);
			InputSource is = new InputSource(srcXML.getPath());
			reader.parse(is);
		} catch (SAXException e) {
			if (e instanceof SAXBreakOutException) {
				double fileSizeInMB = FileUtil.getFileSizeInBytes(srcXML
						.getPath()) / (1024*1024);
				DecimalFormat df = new DecimalFormat("#.000");
				LOGGER.info("source xml obtained with url '{}' is of size '{}MB'", srcXMLURL,df.format(fileSizeInMB));
			} else {
				LOGGER.error("source xml obtained with url '{}'is INVALID",
						srcXMLURL, e);
				throw e;
			}
		} catch (ParserConfigurationException e) {
			throw new SAXException(e);
		}
	}

	@Override
	public Document retrieveXSLTParam(final String urlVal)
			throws ParserConfigurationException, IOException, SAXException {
		LOGGER.info("retrieveXSLTParam instantiated with url ='{}'", urlVal);
		Document document = null;
		InputStream inpStrm = null;
		try {
			inpStrm = this.fireURL(urlVal);
			LOGGER.debug("Input stream received properly");
			InputSource inSource = new InputSource(
					this.getUsableInputStream(inpStrm));
			document = this.createDOM(inSource);
		} finally {
			if (null != inpStrm) {
				try {
					inpStrm.close();
				} catch (IOException e) {
					LOGGER.error("Unable to close Inputstream:'{}'", e);
				}
			}
		}
		return document;
		/**
		 * The 'toString(document)' representation by default is [#document:
		 * null].This doesn't mean that document=null.
		 */
	}

	/**
	 * Creates the document(DOM).
	 * 
	 * @param inSource
	 *            the in source
	 * @throws SAXException
	 *             the sAX exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ParserConfigurationException
	 *             the parser configuration exception
	 */
	private Document createDOM(final InputSource inSource) throws SAXException,
			IOException, ParserConfigurationException {
		DocumentBuilderFactory dbf = SecureDocumentBuilderFactory.newDBFInstance();
		dbf.setIgnoringComments(false);
		dbf.setIgnoringElementContentWhitespace(true);
		Document document = dbf.newDocumentBuilder().parse(inSource);
		LOGGER.debug("document parsed");
		return document;
		/**
		 * The 'toString(document)' representation by default is [#document:
		 * null].This doesn't mean that document=null.
		 */
	}

	/**
	 * Fire url.This makes http requests(predominantly,loopback requests) to
	 * sitecontroller.
	 * 
	 * @param urlVal
	 *            the url val
	 * @return the input stream
	 * @throws MalformedURLException
	 *             the malformed url exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@SuppressWarnings("boxing")
	private InputStream fireURL(final String urlVal)
			throws MalformedURLException, IOException {
		HttpURLConnection upgDataConnection = null;
		URL upgDatasURL = new URL(urlVal);
		upgDataConnection = (HttpURLConnection) upgDatasURL.openConnection();
		int responseCode = upgDataConnection.getResponseCode();
		if (responseCode == HTTP_RESPONSE_OK) {
			LOGGER.debug(
					"'{}' is the http response code after firing URL '{}'",
					responseCode, urlVal);
		} else {
			LOGGER.error(
					"'{}' is the http response code after firing URL '{}'",
					responseCode, urlVal);
			throw new IOException("Http Error for url-" + urlVal);
		}
		return upgDataConnection.getInputStream();
	}

	/**
	 * Gets the usable input stream.
	 * 
	 * @param inpStream
	 *            the is
	 * @return the usable input stream
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private InputStream getUsableInputStream(final InputStream inpStream)
			throws IOException {
		int i = -1;
		ByteArrayInputStream bais = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		while ((i = inpStream.read()) != -1) {
			baos.write(i);
		}
		bais = new ByteArrayInputStream(baos.toByteArray());
		return bais;
	}

	@Override
	public void convertDOMtoXML(final Document doc, final String filename)
			throws IOException, TransformerException {
		try {
			/**
			 * The 'toString(doc)' representation by default is [#document:
			 * null].This doesn't mean that document=null.
			 */
			if ((null != filename) && (null != doc)) {
				File file = new File(filename);
				Document document = doc;
				TransformerFactory tranFact = TransformerFactory.newInstance();
				Transformer trans = tranFact.newTransformer();
				DOMSource source = new DOMSource(document);
				StreamResult result = new StreamResult(file);
				trans.transform(source, result);
			} else {
				throw new IOException(
						"Filename/document(DOM) cannot be a null value");
			}
		} catch (TransformerConfigurationException e) {
			LOGGER.error(
					"TransformerConfigurationException while converting DOM to an XML:'{}'",
					e);
			throw e;
		} catch (TransformerFactoryConfigurationError e) {
			LOGGER.error(
					"TransformerFactoryConfigurationError while converting DOM to an XML:'{}'",
					e);
			throw e;
		} catch (TransformerException e) {
			LOGGER.error(
					"TransformerException while converting DOM to an XML:'{}'",
					e);
			throw e;
		}
	}

	@Override
	public void convertStringtoXML(String xmlString, String directoryName,
			String expectedFileName) {
		FileUtil.convertStringtoXML(xmlString, directoryName, expectedFileName);
	}
}