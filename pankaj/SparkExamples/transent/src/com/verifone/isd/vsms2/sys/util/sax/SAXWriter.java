package com.verifone.isd.vsms2.sys.util.sax;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.xml.serialize.OutputFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

/**
 * Creates a stream object to use for serializing objects which understand the
 * SAX interface. The XML document to be created is initialized with a set of
 * helpful defaults, which may need to be changed for later implementations.
 *
 * By default, the created XML document will have XML declaration. To disable
 * this feature, call the method setOmitXMLDeclaration() before writeSAX().
 *
 * In general, objects to be serialized must implement an ISAXSerializable
 * interface, which in turn accepts a ContentHandler parameter which is the
 * interface that the objects will use to serialize themselves.
 *
 * The writeSAX() method on SAXWriter should only be called once to serialize an
 * object graph into a set of XML elements. The writeSAX() method on the objects
 * to be serialized may be called as often as needed (i.e. the writeSAX() method
 * on ISAXSerializable).
 *
 * e.g.
 * <pre>
 * // in outer class...
 * // note that the prefixes are mapped to namespaces here, but
 * // it's not required.  However, mapping namespaces causes the
 * // namespace definition to be reserialized in the XML...
 * //
 * SAXWriter wr = new SAXWriter(System.out);
 * wr.getContentHandler().startPrefixMapping("vfi1",mainNS);
 * wr.getContentHandler().startPrefixMapping("vfi2",secNS);
 * wr.writeSAX(new FirstClass());
 * wr.getContentHandler().endPrefixMapping("vfi1");
 * wr.getContentHandler().endPrefixMapping("vfi2");
 * ...
 * // in FirstClass() (which contains a secondClass)
 * // the serialized class must know the namespace(s) with which
 * // it's expected to work.
 *
 * public void writeSAX(ContentHandler ch) throws SAXException
 * {
 * AttributesImpl attrs = new AttributesImpl();
 * attrs.addAttribute(TestSAX.secNS,"d1",null,"CDATA","12345");
 * ch.startElement(TestSAX.mainNS,"david",null,attrs);
 * char[] chars = "\nhello1, world\n".toCharArray();
 * ch.characters(chars,0,chars.length);
 * secondClass.writeSAX(ch);
 * ch.endElement(TestSAX.mainNS,"david",null);
 * }
 * </pre>
 *
 * @version 1.0
 * @author David Ezell "mailto:david_ezell@verifone.com"
 * @see ISAXSerializable
 * @see org.xml.sax.ContentHandler
 */
public class SAXWriter {

	private OutputStream outputStream;
	private boolean preserveWhiteSpace;
	private Charset encoding;
	private OutputFormat outputFormat;
	private boolean writeSAXAlreadyCalled = false;
	private String schemaForValidation;
	public static final String ENCODING = "UTF-8";

	private final Logger logger = LoggerFactory.getLogger(SAXWriter.class);
	//Replaced by the Charset in the constructor

	/**
	 * constructor for the stream
	 *
	 * @param os is the OutputStream to receive the XML document
	 * @exception IOException thrown on error
	 * @see java.io.OutputStream
	 */
	public SAXWriter(OutputStream os) throws IOException {
		this(os, false);
	}

	/**
	 * constructor for the stream
	 *
	 * @param os is the OutputStream to receive the XML document
	 * @param encoding - Charset of de stream, UTF-8 default
	 * @exception IOException thrown on error
	 * @see java.io.OutputStream
	 */
	public SAXWriter(OutputStream os, Charset encoding) throws IOException {
		this(os, false, encoding);
	}

	/**
	 * constructor for the stream
	 *
	 * @param os is the OutputStream to receive the XML document
	 * @param preserveWhiteSpace - if this is true then will preserve the white
	 * space in the stream
	 * @throws IOException
	 */
	public SAXWriter(OutputStream os, boolean preserveWhiteSpace) throws IOException {
		this(os, preserveWhiteSpace, Charset.forName(ENCODING)); //Default Charset, replaced the ENCODING const string
	}

	/**
	 * constructor for the stream
	 *
	 * @param os is the OutputStream to receive the XML document
	 * @param preserveWhiteSpace - if this is true then will preserve the white
	 * space in the stream
	 * @param encoding - Charset of de stream, UTF-8 default
	 * @throws IOException
	 */
	public SAXWriter(OutputStream os, boolean preserveWhiteSpace, Charset encoding) throws IOException {
		this.outputStream = os;
		this.encoding = encoding;
		this.preserveWhiteSpace = preserveWhiteSpace;
		/**
		 * * NOTE: When we support other character sets, NEED TO REVISIT using
		 * SAXSerializer **
		 */
		this.outputFormat = new OutputFormat("xml", encoding.displayName(), false);
		outputFormat.setPreserveSpace(true);
	}

	/**
	 * Enable/ disable XML declaration from the XML document using this method.
	 * By default, XML declaration is NOT omitted.
	 *
	 * @param isTrue flag to specify if XML declaration is to be omitted
	 */
	public void setOmitXMLDeclaration(boolean isTrue) {
		outputFormat.setOmitXMLDeclaration(isTrue);
	}

	/*
	 * get the ContentHandler associated with the SAXWriter. Mainly this call is
	 * used to access other ContentHandler methods, such as startPrefixMapping()
	 * (see example above).
	 *
	 * @return the ContentHandler
	 * @see org.xml.sax.ContentHandler
	 */
	/*
	public ContentHandler getContentHandler() {
		return contentHandler;
	}*/
	public void setSchemaForValidation(String schemaFileForValidation) {
		this.schemaForValidation = schemaFileForValidation;
	}

	/**
	 * call once on a SAXWriter to serialize an object graph
	 *
	 * @param obj the object to serialize (must be ISAXSerializable)
	 * @exception SAXException thrown if SAXExceptions are encountered or if
	 * this method has already been called on this SAXWriter object.
	 * @exception IOException thrown on IO problem
	 * @see org.xml.sax.SAXException
	 */
	public void writeSAX(ISAXSerializable obj) throws SAXException, IOException {
		if (writeSAXAlreadyCalled) {
			throw new SAXException("Document already started");
		}
		writeSAXAlreadyCalled = true;   // prevent recall
		if (schemaForValidation == null) {
			writeWithoutSchemaValidation(obj);
		} else {
			writeWithSchemaValidation(obj);
		}
	}

	/**
	 * Writes the XML to output stream without validating with Schema.
	 * @param obj
	 * @throws IOException
	 * @throws SAXException
	 */
	private void writeWithoutSchemaValidation(ISAXSerializable obj) throws IOException, SAXException {
		OutputStreamWriter out = new OutputStreamWriter(this.outputStream, encoding);
		ContentHandler contentHandler = new SAXSerializer(out, outputFormat, preserveWhiteSpace).asContentHandler();
		serialize(contentHandler, obj);
		out.flush();        
	}

	/**
	 * Writes XML to output stream as well as validates the xml which is sent
	 * with schema in a seperate thread.
	 * @param obj
	 * @throws SAXException
	 * @throws IOException
	 */
	private void writeWithSchemaValidation(ISAXSerializable obj) throws SAXException, IOException {
		/* disable indenting since this seems to write the entire xml to a StringBuffer
		 * and this results in OutOfMemoryError in case of huge xml docs; also, even
		 * if a stream is handled, the data is buffered until eos instead of being
		 * streamed.. beats the whole point of using SAX!!!
		 */
		OutputStream pipedOS = null;
		try {
			pipedOS = new PrivateSchemaValidator(this.schemaForValidation).setupForValidation(this.outputStream);
			ContentHandler contentHandler = new SAXSerializer(pipedOS, outputFormat, preserveWhiteSpace).asContentHandler();
			serialize(contentHandler, obj);
			pipedOS.flush();
			pipedOS.close();
		} catch (ParserConfigurationException pce) {
			logger.error("Schema validation not possible: ", pce);
			writeWithoutSchemaValidation(obj);
		}finally {
			if(pipedOS != null) {
				pipedOS.close();
			}
		}
	}

	/**
	 * Serializes the obj to contentHandlers outputstream.
	 * @param contentHandler
	 * @param obj
	 * @throws SAXException
	 */
	private void serialize(ContentHandler contentHandler, ISAXSerializable obj) throws SAXException {
		contentHandler.startDocument();
		obj.writeSAX(contentHandler);
		contentHandler.endDocument();
	}

	
}
