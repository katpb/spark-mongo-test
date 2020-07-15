package com.verifone.isd.vsms2.sys.util.sax;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLFilterImpl;

import com.verifone.isd.xml.directives.ParserConstants;

/**
 *  SAXFilter and SAXContentHandler work in tandem to
 *  relieve the business objects of performing the following
 *  tasks:
 *  1. track the content handler for each parsed element
 *  2. hand over control to the appropriate content handler.
 * 
 *  The client objects need to supply a content handler and
 *  XMLReader (typically, SAXParser) to be used in parsing
 *  the document.
 * 
 *  <pre>
 *       FileReader fr = new FileReader("testSAXFilter.xml");
 *       SAXFilter msf = new SAXFilter(new SAXParser(),new MySAXContentHandler());
 *       msf.parse(new InputSource(fr));
 *  </pre>
 * 
 *  On inspecting a new element, the currently active content handler may decide
 *  to hand over control to a different content handler until a matching end 
 *  element is reached. To accomplish this, it has to register the new content 
 *  handler using SAXContentHandler#navigate()
 *  method.
 * 
 *  <pre>
 * 	    public void startElement (String uri, String localName, 
 *          String qName, Attributes attributes) throws SAXException
 * 	    {
 * 	        if (localName.equals("two"))
 * 	            navigate(new MySAXContentHandler1(),uri,localName,qName,attributes);
 * 	    }
 *  </pre>
 *  
 *  Once content handlers are registered as above, the SAXFilter keeps track of
 *  which content handler to use and when to hand back control to the previous
 *  content handler.  It passes requests up to the reader and events
 *  on to the correct content handlers unmodified.
 *  <br>
 *  Alternatively, the currently active content handler may decide to unconditionally 
 *  hand over control to a different content handler. To accomplish this, it has to 
 *  register the new content handler using SAXContentHandler#delegate() method.
 * 
 *  <pre>
 * 	    public void startElement (String uri, String localName,
 * 	    String qName, Attributes attributes) throws SAXException
 * 	    {
 * 	        if (localName.equals("two"))
 * 	            delegate(new MySAXContentHandler1(),uri,localName,qName,attributes);
 * 	    }
 *  </pre>
 *  
 *  In this case, it is the new content handler's responsibility to relinquish control by 
 *  invoking SAXContentHandler#endDelegation method.
 * 
 *  <pre>
 * 	    public void endElement (String uri, String localName,
 * 	    String qName, Attributes attributes) throws SAXException
 * 	    {
 * 	        if (localName.equals("five"))
 * 	            endDelegation();
 * 	    }
 *  </pre>
 * @author David Ezell "mailto:david_ezell@verifone.com"
 * @version 1.0
 * @see SAXContentHandler
 * @see org.xml.sax.XMLFilterImpl
 * @see org.xml.sax.XMLReader
 * @see org.xml.sax.ContentHandler
 */

public class SAXFilter extends XMLFilterImpl {
    private static final String CANNOT_DISABLE = "Cannot disable: ";
    private Logger logger
            = LoggerFactory.getLogger(SAXFilter.class);
    /**
     * Package scoped access for the element stack for access from SAXContentHandler
     */
    private BroadcastingHandler[] callbacks;
    /**
     *  constructor for the filter
     *  @param xmlReader that parses the XML document
     *  @param initialHandler the root handler for all SAX events
     *  @see org.xml.sax.XMLReader
     *  @see SAXContentHandler
     */
    public SAXFilter(XMLReader xmlReader,SAXContentHandler initialHandler) {
        this(xmlReader);
        this.callbacks = new BroadcastingHandler[1];
        this.callbacks[0] = new BroadcastingHandler(initialHandler);
    }    
    public SAXFilter(XMLReader xmlReader, SAXContentHandler[] initialHandlers) {
        this(xmlReader);        
        int cnt = (initialHandlers == null) ? 0 : initialHandlers.length;
        this.callbacks = new BroadcastingHandler[cnt];
        for (int i = 0; i < cnt; i++) {
            this.callbacks[i] = new BroadcastingHandler(initialHandlers[i]);
        }
    }
    
    private SAXFilter(XMLReader xmlReader) {
        super(xmlReader);
        // N.B., these setters are necessary to secure XMLReader instances that are created without using SecureSAXParserFactory
        try {
            xmlReader.setFeature(ParserConstants.XML_SAX_FEATURES_EXTERNAL_GENERAL_ENTITIES, false); 
        } catch (SAXException e) {
            logger.error(CANNOT_DISABLE + ParserConstants.XML_SAX_FEATURES_EXTERNAL_GENERAL_ENTITIES);
        }
        try {
            xmlReader.setFeature(ParserConstants.XML_SAX_FEATURES_EXTERNAL_PARAMETER_ENTITIES, false); 
        } catch (SAXException e) {
            logger.error(CANNOT_DISABLE + ParserConstants.XML_SAX_FEATURES_EXTERNAL_PARAMETER_ENTITIES);
        }
        try {
            xmlReader.setFeature(ParserConstants.APACHE_XML_FEATURES_DISALLOW_DOCTYPE_DECL, true); 
        } catch (SAXException e) {
            logger.error(CANNOT_DISABLE + ParserConstants.APACHE_XML_FEATURES_DISALLOW_DOCTYPE_DECL);
        }
        this.setContentHandler(this);        
    }

    
    /** Passes the event to the currently active content handler
     * @see org.xml.sax.helpers.XMLFilterImpl#startElement
     * @param attributes Attributes for the element
     * @param uri The element's Namespace URI, or the empty string.
     * @param localName The element's local name, or the empty string.
     * @param qName The element's qualified (prefixed) name, or the empty
     *        string.
     * @exception org.xml.sax.SAXException thrown by the client content handler
     */
    @Override
    public void startElement(String uri, String localName,
    String qName, Attributes attributes)
    throws SAXException {
        /* AttributesImpl was the concrete class used in Xerces1.4.x. But, with 
         * Xerces 2.x, a different concrete class is used. This causes a 
         * ClassCastException. Since there is no setXXX method on the Attributes
         * interface, the attribute values are not trimmed anymore. Client apps 
         * have to trim the attribute value, if required.
         */
        /*
        AttributesImpl attImpl = (AttributesImpl) attributes;
        int attCnt = attImpl.getLength();
        for (int i = 0; i < attCnt; i++) {
            attImpl.setValue(i, attImpl.getValue(i).trim());
        }
         **/
    	for (int i = 0; i < this.callbacks.length; i++){
            BroadcastingHandler curImpl = this.callbacks[i]; 
            curImpl.startElement(uri,localName,qName,attributes);
        }
    }
    
    /**
     * Passes the event to the currently active content handler.
     * Selects the correct content handler for subsequent SAX events.
     * @param uri The element's Namespace URI, or the empty string.
     * @param localName The element's local name, or the empty string.
     * @param qName The element's qualified (prefixed) name, or the empty
     *        string.
     * @see org.xml.sax.helpers.XMLFilterImpl#endElement
     * @exception org.xml.sax.SAXException thrown by the client content handler
     */
    @Override
    public void endElement(String uri, String localName, String qName)
    throws SAXException {
    	BroadcastingHandler curImpl = null;
        for (int i = 0; i < this.callbacks.length; i++){
            curImpl = this.callbacks[i]; 
            curImpl.endElement(uri,localName,qName);
        }
    }
    
    
    /**
     * Passes the event to the currently active content handler.
     * @param ch An array of characters.
     * @param start The starting position in the array.
     * @param length The number of characters to use from the array.
     * @see org.xml.sax.helpers.XMLFilterImpl#endElement
     * @exception org.xml.sax.SAXException thrown by the client content handler
     */
    
    @Override
    public void characters(char[] ch, int start, int length)
    throws SAXException {
    	BroadcastingHandler curImpl = null;
    	for (int i = 0; i < this.callbacks.length; i++){
            curImpl = this.callbacks[i]; 
            curImpl.characters(ch, start, length);
        }        
        
    }

    @Override
    public void error(org.xml.sax.SAXParseException paramSAXParseException) throws SAXException {
    	BroadcastingHandler curImpl = null;
    	for (int i = 0; i < this.callbacks.length; i++){
            curImpl = this.callbacks[i]; 
            curImpl.error(paramSAXParseException);
        }
    }
    
    @Override
    public void fatalError(org.xml.sax.SAXParseException paramSAXParseException) throws SAXException {
    	BroadcastingHandler curImpl = null;
    	for (int i = 0; i < this.callbacks.length; i++){
            curImpl = this.callbacks[i]; 
            curImpl.fatalError(paramSAXParseException);
        }
    }
    
    @Override
    public void warning(org.xml.sax.SAXParseException paramSAXParseException) throws SAXException {
    	BroadcastingHandler curImpl = null;
    	for (int i = 0; i < this.callbacks.length; i++){
            curImpl = this.callbacks[i]; 
            curImpl.warning(paramSAXParseException);
        }
    }
    
    @Override
    public void startDocument() throws SAXException {
    	BroadcastingHandler curImpl = null;
    	for (int i = 0; i < this.callbacks.length; i++){
            curImpl = this.callbacks[i]; 
            curImpl.startDocument();
        }        
    }

    @Override
    public void endDocument() throws SAXException {
    	BroadcastingHandler curImpl = null;
    	for (int i = 0; i < this.callbacks.length; i++){
            curImpl = this.callbacks[i]; 
            curImpl.endDocument();
        }        
    }
    
    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
    	BroadcastingHandler curImpl = null;
    	for (int i = 0; i < this.callbacks.length; i++){
            curImpl = this.callbacks[i]; 
            curImpl.startPrefixMapping(prefix, uri);
        }        
    }
    
    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
    	BroadcastingHandler curImpl = null;
    	for (int i = 0; i < this.callbacks.length; i++){
            curImpl = this.callbacks[i]; 
            curImpl.endPrefixMapping(prefix);
        }        
    }   
    
    @Override
    public void ignorableWhitespace(char[] ch,  int start, int length) throws SAXException {
    	BroadcastingHandler curImpl = null;
    	for (int i = 0; i < this.callbacks.length; i++){
            curImpl = this.callbacks[i]; 
            curImpl.ignorableWhitespace(ch, start, length);
        }        
    }
    
    @Override
    public void processingInstruction(String target, String data) throws SAXException {
    	BroadcastingHandler curImpl = null;
    	for (int i = 0; i < this.callbacks.length; i++){
            curImpl = this.callbacks[i]; 
            curImpl.processingInstruction(target, data);
        }
    }
    
    @Override
    public void setDocumentLocator(Locator locator) {
    	BroadcastingHandler curImpl = null;
    	for (int i = 0; i < this.callbacks.length; i++){
            curImpl = this.callbacks[i]; 
            curImpl.setDocumentLocator(locator);
        }        
    }
    
 
    /** Overridden method
     * @exception Throwable thrown per spec
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
