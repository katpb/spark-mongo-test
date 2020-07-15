package com.verifone.isd.vsms2.sys.util.sax;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * This class has the serialization logic to stage the configuration 
 * The existing content handler should implement ISerializableSaxContentHandler interface to serialize the payload
 * @author T_ShailendraP1
 *
 */
public class GenericSerializationHandler extends SAXContentHandler {
	private static Logger logger = LoggerFactory
			.getLogger(GenericSerializationHandler.class);
	private boolean skipSerialization;
	private FileOutputStream fos = null;
	private File tempFile = null;
	private XMLSerializer serializer;
	private IManagedUpdateSaxContentHandler serializableSaxContentHandler;
	public static final String TEMP = "temp";
	private Exception ignoredException;
	public GenericSerializationHandler(IManagedUpdateSaxContentHandler serilizableSaxContentHandler){
		this.serializableSaxContentHandler=serilizableSaxContentHandler;
	}
	
	public GenericSerializationHandler(IManagedUpdateSaxContentHandler serilizableSaxContentHandler,boolean skipSerialization){
		this.serializableSaxContentHandler=serilizableSaxContentHandler;
		this.skipSerialization=skipSerialization;
	}

	/**
	 * @return the skipSerialize
	 */
	public boolean isSkipSerialization() {
		return skipSerialization;
	}

	/**
	 * @return the serializableSaxContentHandler
	 */
	public IManagedUpdateSaxContentHandler getSerializableSaxContentHandler() {
		return serializableSaxContentHandler;
	}

	/**
	 * @param serializableSaxContentHandler
	 *            the serializableSaxContentHandler to set
	 */
	public void setSerilizableSaxContentHandler(
			IManagedUpdateSaxContentHandler serilizableSaxContentHandler) {
		this.serializableSaxContentHandler = serilizableSaxContentHandler;
	}
	
	/**
	 * Gets the Exception to be ignored on processing
	 * @return
	 */
	public Exception getIgnoredException(){
		return ignoredException;
	}

	/**
	 * Receive notification of the beginning of the document. Open the local xml
	 * file and pass it to the {@link XMLSerializer} as a
	 * {@link FileOutputStream}.
	 * 
	 * @exception org.xml.sax.SAXException
	 *                Any SAX exception, possibly wrapping another exception.
	 * @see org.xml.sax.ContentHandler#startDocument
	 */
	public void startDocument() throws SAXException {
		try {
			if (isSkipSerialization() == false
					&& serializableSaxContentHandler != null) {
				File rootDirectory = serializableSaxContentHandler.getRootPath();
				// Make sure the Directory is available for writing
				if(rootDirectory != null){
					if (! rootDirectory.exists()) {
						if (!rootDirectory.mkdirs()) {
						logger.error("Not able to create "
								, rootDirectory.getAbsolutePath());
						return;
						}
					}

				File tempDirectory = new File(rootDirectory.getAbsolutePath()+File.separatorChar+TEMP);

				// Check for Temporary Directory
				if (tempDirectory != null && (! tempDirectory.exists())) {
					if (!tempDirectory.mkdirs()) {
						logger.error("Not able to create "
								, tempDirectory.getAbsolutePath());
						return;
					}
				}

				tempFile = new File(tempDirectory.getAbsolutePath()
						+ File.separatorChar + System.currentTimeMillis()
						+ "."+TEMP);

				if (!tempFile.createNewFile()) {
					if (tempFile.delete()) {
						if (tempFile.createNewFile()) {
							logger.debug("created new temporary file to stage data");
						}
					}

				}
				OutputFormat outFormat = new OutputFormat("xml", "UTF-8", false);
				outFormat.setPreserveSpace(true);
				serializer = new XMLSerializer();
				this.fos = new FileOutputStream(tempFile);
				serializer.setOutputByteStream(this.fos);
				serializer.startDocument();
			}
			}
		} catch (Exception e) {
			throw new SAXException(e);
		}
	}

	/**
	 * Receive notification of the start of a Namespace mapping.
	 * 
	 * @param prefix
	 *            The Namespace prefix being declared.
	 * @param uri
	 *            The Namespace URI mapped to the prefix.
	 * @exception org.xml.sax.SAXException
	 *                Any SAX exception, possibly wrapping another exception.
	 * @see org.xml.sax.ContentHandler#startPrefixMapping
	 */
	public void startPrefixMapping(String prefix, String uri)
			throws SAXException {
		if (serializer != null) {
			serializer.startPrefixMapping(prefix, uri);
		}
	}

	/**
	 * Receive notification of the end of a Namespace mapping.
	 * 
	 * @param prefix
	 *            The Namespace prefix being declared.
	 * @exception org.xml.sax.SAXException
	 *                Any SAX exception, possibly wrapping another exception.
	 * @see org.xml.sax.ContentHandler#endPrefixMapping
	 */
	public void endPrefixMapping(String prefix) throws SAXException {
		if (serializer != null) {
			serializer.endPrefixMapping(prefix);
		}
	}

	/**
	 * cleanup if something goes wrong
	 */
	private void cleanup() {
		if (isSkipSerialization() == false) {
			if (this.fos != null) {
				try {
					this.fos.close();
				} catch (IOException ioe) {
					logger.error("Error in closing outputstream ", ioe);
				}
				this.fos = null;
			}
			if (tempFile.delete()) {
				logger.debug("Deleted Temporary File :" , tempFile.getName());
			}
		}
	}
	

	/**
	 * Save the Configuration in file system
	 */
	private void saveDocument() {
		if (this.fos != null) {
			try {
				this.fos.close();
			} catch (IOException ioe) {
				logger.error("Error in closing outputstream ", ioe);
			}
			this.fos = null;
		}

		serializableSaxContentHandler.saveFile(tempFile);
		this.cleanup();
	}

	/**
	 * Receive notification of the start of an element.
	 * 
	 * @param uri
	 *            the element's uri
	 * @param localName
	 *            the element's local name
	 * @param qName
	 *            The element's qualified name.
	 * @param attributes
	 *            The specified or defaulted attributes.
	 * @exception org.xml.sax.SAXException
	 *                Any SAX exception, possibly wrapping another exception.
	 * @see org.xml.sax.ContentHandler#startElement
	 */
	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
		try {
			if (isSkipSerialization() == false
					&& serializableSaxContentHandler != null) {
				serializableSaxContentHandler.setSerializer(serializer);
				if (serializableSaxContentHandler instanceof SAXContentHandler) {
					SAXContentHandler saxContentHandler = (SAXContentHandler) serializableSaxContentHandler;
					this.navigate(saxContentHandler, uri, localName, qName,
							atts);
				}

			}
		} catch (SAXException e) {
			logger.error(
					"Exception in GenericSerializationHandler startElement ", e);
			this.cleanup();
			throw e;
		}
	}

	/**
	 * Receive notification of the end of an element.
	 * 
	 * @param uri
	 *            the element's uri
	 * @param localName
	 *            the element's local name
	 * @param qName
	 *            The element's qualified name.
	 * @exception org.xml.sax.SAXException
	 *                Any SAX exception, possibly wrapping another exception.
	 * @see org.xml.sax.ContentHandler#endElement
	 */
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
			if (isSkipSerialization() == false
					&& serializableSaxContentHandler != null
					&& localName.equals(serializableSaxContentHandler
							.getRootElementName())) {
					this.saveDocument();
					ignoredException = serializableSaxContentHandler.getIgnoredException();
			}
	}

}
