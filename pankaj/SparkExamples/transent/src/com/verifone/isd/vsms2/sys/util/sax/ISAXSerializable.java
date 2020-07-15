package com.verifone.isd.vsms2.sys.util.sax;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

/**
 *  interface, normally called from SAXWriter to
 *  ask an object (or view) to serialize itself.
 *  Objects with a need to serialize to XML will implement
 *  this method.  Note that the object must know the
 *  namespace(s) with which it's expected to work.
 *
 *  <pre>
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
 *  </pre>
 *  @version 1.0
 *  @author David Ezell "mailto:david_ezell@verifone.com"
 *  @see com.verifone.isd.vsms2.sys.util.sax.SAXWriter
 */
public interface ISAXSerializable {
    /** method to call on an object to have it serialize
     *  itself to a ContentHandler.
     * @param contentHandler reference to the ContentHandler.
     * @exception SAXException thrown on a serialization error.
     * @see org.xml.sax.ContentHandler
     */
    public void writeSAX(ContentHandler contentHandler) throws SAXException;
}