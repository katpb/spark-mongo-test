package com.verifone.isd.vsms2.sys.util.sax;

import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 *  Base class for application content handlers to inherit from.
 *  It provides the implementation for navigation and delegation methods.
 *
 *  The derived content handlers should override the no-op methods
 *  startElement(), endElement() and characters() to support required
 *  processing.
 *
 * navigate() method should be called by a content handler at the start of an
 * element fragment that has to be processed by a different content handler. Use 
 * this method if processing an element with all its sub-elements is entirely handed
 * over to a different content handler.
 * <pre>
 *	public void startElement (String uri, String localName, String qName,
 *		Attributes attributes) throws SAXException
 *	{
 *	    if (localName.equals("two"))
 *	        navigate(new MySAXContentHandler1(),uri,localName,qName,attributes);
 *	}
 * </pre>
 *
 * delegate() method should be called by a content handler if it is entrusting a different
 * content handler with extracting information from a partial xml fragment. 
 * <pre>
 * 	public void startElement (String uri, String localName,
 * 	    String qName, Attributes attributes) throws SAXException
 * 	{
 * 	    if (localName.equals("two"))
 * 	        delegate(new MySAXContentHandler1(),uri,localName,qName,attributes);
 * 	}
 * </pre>
 * In this case, the delegate content handler must know when its task is over and call the 
 * endDelegate() method appropriately.
 *  <pre>
 * 	    public void endElement (String uri, String localName,
 * 	    String qName, Attributes attributes) throws SAXException
 * 	    {
 * 	        if (localName.equals("five"))
 * 	            endDelegation();
 * 	    }
 *  </pre>
 *  @version 1.0
 *  @author David Ezell "mailto:david_ezell@verifone.com"
 *  @see SAXFilter
 */
public abstract class SAXContentHandler extends DefaultHandler {
    /**
     * the associated SAXFIlter instance
     */
    /*package*/ BroadcastingHandler wrapperHandler = null;
    private Locator locator;
    
    /**
     *  no-args constructor for the content handler
     */
    public SAXContentHandler() {
    }
    
    /**
     * Registers the new content handler with the SAXFilter and notifies the
     * new content handler of the start element event.
     * Use this method when a wrapped XML fragment handling is done by a different
     * content handler.  
     * 
     * @param newHandler content handler that handles subsequent events till the end of the element
     * @param uri The element's Namespace URI, or the empty string.
     * @param name The element's local name, or the empty string.
     * @param qName The element's qualified (prefixed) name, or the empty string.
     * @param atts The element's attributes.
     * @see org.xml.sax.helpers.XMLFilterImpl#startElement
     * @exception org.xml.sax.SAXException thrown by the client content handler
     */
    public void navigate(SAXContentHandler newHandler,String uri, String name,String qName, Attributes atts) throws SAXException {
        newHandler.setDocumentLocator(this.locator);
        wrapperHandler.push(newHandler, false);   // null wrapperHandler will throw
    }
    
    /**
     * Provides a mechanism to register new content handler that controls its own
     * lifeline in the SAX event handler stack. This mechanism allows using different 
     * content handlers to process different unwrapped sections of an xml document. 
     * Like navigate() method, registered handler will get notified for the initial
     * event that triggered this call, if registration is on a startElement. 
     * 
     * When done with its task, the registered content handler must relinquish control 
     * of the events by calling endDelegation() method.  If it does not do so, when the
     * end element corresponding to the original content handler is reached, this object
     * will also be removed from the event notification.

     * Use this method when unwrapped segments have to be processed by different
     * content handlers.
     * 
     * @param newHandler content handler that handles subsequent events till it relinquishes
     * control or till end of element of the registering content handler 
     */    
    public void delegate(SAXContentHandler newHandler) throws SAXException {
        newHandler.setDocumentLocator(this.locator);        
        wrapperHandler.push(newHandler, true);
    }
    
    /**
     * Call this method to unregister content handlers added using delegate() method.
     * The original (previous) handler will get notified ONLY for subsequent SAX events.
     */      
    public void endDelegation() {
        wrapperHandler.popDelegate();
    }
    
    /**
     * Setter for SAXFilter
     * @param wrapperHandler sax filter for parsing the document
     */
    void setSAXFilterImpl(BroadcastingHandler wrapperHandler)  // called locally SAXFilter to set itself
    {
        this.wrapperHandler = wrapperHandler;
    }
    
    /** Overridden method
     * @exception Throwable thrown per spec
     */
    protected void finalize() throws Throwable {
        super.finalize();
    }
    
    /**
     * Provide a custom Locator
     * @param locator custom loader
     * @see org.xml.sax.Locator
     */
    public void setDocumentLocator(Locator locator) {
        this.locator = locator;
    }
    
    /**
     * Getter for locator
     * @return locator
     * @see org.xml.sax.Locator
     */
    public Locator getDocumentLocator() {
        return this.locator;
    }
    
	/**
	 * Method to release the resources if any by the content handler. Note:
	 * While parsing any exceptions occurred and if any connections need to be
	 * released, this method can be overridden to do that.
	 */
    public void releaseResources() {
    	
    }
    
}