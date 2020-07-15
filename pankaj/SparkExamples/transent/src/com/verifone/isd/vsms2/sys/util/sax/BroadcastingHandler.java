package com.verifone.isd.vsms2.sys.util.sax;

import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLFilterImpl;

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

public class BroadcastingHandler extends DefaultHandler {
    private Logger logger
            = LoggerFactory.getLogger(BroadcastingHandler.class);
    /**
     * Package scoped access for the element stack for access from SAXContentHandler
     */
    /*package*/ ElementStack elementStack = null;   // with throw if init() not called
    private Locator locator;
    /**
     *  constructor for the filter
     *  @param xmlReader that parses the XML document
     *  @param initialHandler the root handler for all SAX events
     *  @see org.xml.sax.XMLReader
     *  @see SAXContentHandler
     */
    public BroadcastingHandler(SAXContentHandler initialHandler) {
        elementStack = new ElementStack(initialHandler);
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
        elementStack.startElement(uri,localName,qName,attributes);
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
    public void endElement(String uri, String localName, String qName)
    throws SAXException {
        this.elementStack.endElement(uri, localName, qName);
    }
    
    /**
     * Passes the event to the currently active content handler.
     * @param ch An array of characters.
     * @param start The starting position in the array.
     * @param length The number of characters to use from the array.
     * @see org.xml.sax.helpers.XMLFilterImpl#endElement
     * @exception org.xml.sax.SAXException thrown by the client content handler
     */
    public void characters(char[] ch, int start, int length)
    throws SAXException {
        String chars = (new String(ch, start, length));
        elementStack.getCurrentHandler().characters(chars.toCharArray(),
        0, chars.length());
    }

    public void error(org.xml.sax.SAXParseException paramSAXParseException) throws SAXException {
        elementStack.getCurrentHandler().error(paramSAXParseException);
    }
    
    public void fatalError(org.xml.sax.SAXParseException paramSAXParseException) throws SAXException {
        elementStack.getCurrentHandler().fatalError(paramSAXParseException);
    }
    
    public void warning(org.xml.sax.SAXParseException paramSAXParseException) throws SAXException {
        elementStack.getCurrentHandler().warning(paramSAXParseException);
    }
    
    public void startDocument() throws SAXException {
        elementStack.getCurrentHandler().startDocument();    
    }

    public void endDocument() throws SAXException {
        elementStack.getCurrentHandler().endDocument();        
    }
    
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        elementStack.getCurrentHandler().startPrefixMapping(prefix, uri);
    }
    
    public void endPrefixMapping(String prefix) throws SAXException {
        elementStack.getCurrentHandler().endPrefixMapping(prefix);       
    }   
    
    public void ignorableWhitespace(char[] ch,  int start, int length) throws SAXException {
        elementStack.getCurrentHandler().ignorableWhitespace(ch, start, length);       
    }
    
    public void processingInstruction(String target, String data) throws SAXException {
        elementStack.getCurrentHandler().processingInstruction(target, data);
    }
    
    public void setDocumentLocator(Locator locator) {
        elementStack.getCurrentHandler().setDocumentLocator(locator);   
        this.locator = locator;
    }
    
    void push(SAXContentHandler ch, boolean isDelegate) throws SAXException {
        this.elementStack.push(ch, isDelegate);
        ch.setDocumentLocator(this.locator);
    }
    
    void popDelegate() {
        this.elementStack.popDelegate();
    }
    /**
     * Inner class to maintain a stack of the elements to help in performing navigate and delegate correctly.
     */
    private class ElementStack {
        private StackEntry[] entries;
        private SAXContentHandler initialHandler = null;
        private int depth = 0;
        private int curTop = -1;
        
        /** Constructor
         * @param initialHandler Initial content handler for the filter
         */
        private ElementStack(SAXContentHandler initialHandler) {
            this.depth = 10;
            this.initialHandler = initialHandler;
            initialHandler.setSAXFilterImpl(BroadcastingHandler.this);
            reset();
        }
        
        private void reset() {
            StackEntry[] oldEntries = this.entries;
            this.entries = new StackEntry[this.depth];
            
            if (oldEntries != null && oldEntries.length < this.depth) {
                System.arraycopy(oldEntries, 0, entries, 0, oldEntries.length);
            }
        }
        
        /** Add new content handler to the stack to process the specified element fragment. 
         * Handler on the top of the stack is in focus and gets all callbacks until 
         * the registered element ends; it is automatically popped off the stack when the
         * registered element ends.
         * @param uri content handler's root element uri
         * @param ruleName content handler's root element name
         * @param ch content handler to be pushed onto the stack. This
         * will become the content handler in focus until the
         * the end tag of registered root element is processed.
         */
        private void push(SAXContentHandler ch, boolean isDelegate) throws SAXException {
            checkStackForPush();
            
            StackEntry tip = this.getCurrentEntry();
            if (tip != null) {
                ElementInfo info = tip.getTipElementInfo();
                if (null != info) {
                    StackEntry newEntry = new StackEntry(ch, info.uri, info.name,info.qName);
                    newEntry.isDelegate = isDelegate;
                    this.entries[++curTop] = newEntry;
                    ch.setSAXFilterImpl(BroadcastingHandler.this);
                    if (tip.activeAttribs != null) {
                        newEntry.startElement(info.uri, info.name, info.qName, tip.activeAttribs);
                    }
                }
            }
        }
        
        private void checkStackForPush() {
            if ((curTop + 1) > this.depth) {
                this.depth += 10;
                reset();
            }
        }
        
        /** Remove the content handler in focus from the stack; the one below it
         * gets focus and becomes the recipient for all SAX event callbacks.
         */        
        private void popDelegate() {
            if (curTop >= 1) {
                StackEntry delegate = this.entries[curTop];
                if (delegate.isDelegate) {
                    delegate.inProgressElems.clear();
                    entries[curTop--] = null;
                }
            }
        }
        
        /**
         * Remove the content handler in focus from the stack, if the element name matches the content 
         * handler's registered element name; the one below it gets focus and becomes the recipient for
         * all SAX event callbacks.
         * @param uri content handler's root element uri
         * @param name content handler's root element name
         * @return last popped stack entry 
         */
        private StackEntry pop(String uri,String name,String qName) {
            StackEntry lastPopped = null;
            if (curTop >= 0 && uri.equals(entries[curTop].element.uri) &&
                    name.equals(entries[curTop].element.name) && qName.equals(entries[curTop].element.qName)) {
                lastPopped = entries[curTop];
                entries[curTop--] = null;
            }
            return lastPopped;
        }
        
        private void startElement(String uri, String localName, String qName, 
                Attributes attributes) throws SAXException {
            StackEntry entry = this.getCurrentEntry();
            if (entry != null) {
                entry.startElement(uri, localName, qName, attributes);
            }
            else {
                checkStackForPush();
                StackEntry newEntry = new StackEntry(this.initialHandler, uri, localName,qName);
                this.entries[++curTop] = newEntry;                
                newEntry.startElement(uri, localName, qName, attributes);
            }
        }
        
        private void endElement(String uri, String localName, String qName)
                throws SAXException {
            StackEntry entry = this.getCurrentEntry();
            if (null == entry) {
                initialHandler.endElement(uri, localName, qName);
            }
            else {
                entry.endElement(uri, localName, qName);
                while (true) {
                    StackEntry lastPopped = this.pop(uri, localName, qName);
                    if (lastPopped == null || lastPopped == entry) {
                        StackEntry tip = this.getCurrentEntry();
                        if (null != tip) { 
                            tip.endElement(uri, localName, qName);
                        }
                        break;
                    }
                    else {
                        entry = lastPopped;
                    }
                }
                /*
                while (true) {
                    
                    StackEntry lastPopped = this.pop(uri, localName, qName);
                    if (lastPopped == null) {
                        StackEntry tip = this.getCurrentEntry();
                        if (null != tip) { 
                            tip.endElement(uri, localName, qName);
                        } 
                        break;
                    }
                    else { //Prevents double notification to curHandler
                        lastPopped.endElement(uri, localName, qName);
                    }
                }*/
            }
        }
        
        /** Return the content handler in focus.
         * @return content handler currently in focus
         */
        private SAXContentHandler getCurrentHandler() {
            if (curTop >= 0) {
                return entries[curTop].ch;
            }
            return initialHandler;
        }
        
        private StackEntry getCurrentEntry() {
            if (curTop >= 0) {
                return entries[curTop];
            }
            return null;
        }
    }
    
    /**
     * Inner class to hold the element information in a stack
     */
    private class StackEntry {
        private SAXContentHandler ch;
        private ElementInfo element;
        private ArrayList inProgressElems;
        private Attributes activeAttribs;
        private boolean isDelegate;
        /**
         * Constructor
         * @param ch content handler for the entry
         * @param namespace namespace of the element being pushed on stack
         * @param name name of the element being pushed on stack
         */
        private StackEntry(SAXContentHandler ch, String namespace, String name, String qName) {
            this.ch = ch;
            this.element = new ElementInfo(namespace, name, qName);
            this.inProgressElems = new ArrayList();
        }
        
        private void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            this.activeAttribs = attributes;
            this.inProgressElems.add(new ElementInfo(uri, localName, qName));
            this.ch.startElement(uri, localName, qName, attributes);
        }
        
        private void endElement(String uri, String localName, String qName) throws SAXException {
            this.activeAttribs = null;
            ElementInfo ended = getTipElementInfo();
            if (ended != null && localName.equals(ended.name) && uri.equals(ended.uri) && qName.equals(ended.qName)) {
                this.inProgressElems.remove(ended);
                this.ch.endElement(uri, localName, qName);                
            }
        }
        
        private ElementInfo getTipElementInfo() {
            int size = this.inProgressElems.size();
            ElementInfo info = null;
            if (size > 0) {
                info = (ElementInfo)this.inProgressElems.get(size -1);
            }
            return info;
        }
    }
    
    private class ElementInfo {
        private String uri;
        private String name;
        private String qName;
        
        private ElementInfo(String uri, String name, String qName) {
        
        /**
         * Constructor
         * @param namespace namespace of the element being pushed on stack
         * @param name name of the element being pushed on stack
         * @param qName qualified name
         */
            this.uri = uri;
            this.name = name;
            this.qName = qName;
        }
    }
    
    /** Overridden method
     * @exception Throwable thrown per spec
     */
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
