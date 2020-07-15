package com.verifone.isd.vsms2.sys.util;

import java.io.IOException;

/**
 *  interface to mark a class as serializable into XML.
 *  An object implementing this interface can be serialized using the 
 *  OutputXMLWriter class.
 *
 *  @version 1.0
 *  @author David Ezell "mailto:david_ezell@verifone.com"
 *  @see com.verifone.isd.vsms2.sys.util.OutputXMLWriter
 */
public interface IXMLSerializable
{
    /**
     *  implement on an object to serialize it into XML format.  E.g.
     *
     *  <pre>
     *  public void writeXML(OutputXMLWriter out) throws IOException
     *  {
     *      out.println("<testXMLClass>");
     *      out.printlnIndent("<a>"+a+"</a>");
     *      out.printlnIndent("<b>"+b+"</b>");
     *      out.printlnIndent("<c>"+c+"</c>");
     *      out.printlnIndent("<wrapper>");
     *      out.pushLevel();
     *      out.writeXML(t2);
     *      out.popLevel();
     *      out.printlnIndent("</wrapper>");
     *      out.println("</testXMLClass>");
     *  }
     *  </pre>
     *
     *  @param out the OutputXMLWriter to which the object will be serialized
     *  @exception IOException thrown on I/O error
     */
    public void writeXML(OutputXMLWriter out) throws IOException;
}