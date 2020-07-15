package com.verifone.isd.vsms2.sys.util;

import java.io.OutputStreamWriter;
import java.io.OutputStream;
import java.io.NotSerializableException;
import java.io.IOException;

import java.util.Date;
import java.util.Calendar;

/**
 *  class to implement a writer stream for XML serialization.
 *  classes serialized must implement the IXMLSerializable interface
 * 
 *  <pre>
 *      OutputXMLWriter xw = new OutputXMLWriter(sm.getOutputStream());
 *      xw.writeXML(fuelSite);
 *      xw.flush();
 *  </pre>
 * @author David Ezell "mailto:david_ezell@verifone.com"
 * @version 1.0
 * @see java.io.OutputStreamWriter
 * @see java.io.OutputStream
 * @see IXMLSerializable
 */
public class OutputXMLWriter
{
    /**
     * Variable that defines the initial indent level of an xml document (TODO: Make this variable private scope)
     */
    public static final int XML_STARTLEVEL = -1;
    
    private OutputStreamWriter out = null;
    private int level = XML_STARTLEVEL; // number of indentitions currently in effect
   
    /**
     *  constructor
     *  @param o the OutputStream to write to, will construct an OutputStreamWriter from it
     *  @see java.io.OutputStreamWriter
     */
    public OutputXMLWriter(OutputStream o)
    {
        this(new OutputStreamWriter(o));
    }
    
    /**
     *  constructor
     *  @param o the OutputStreamWriter to write to
     */
    public OutputXMLWriter(OutputStreamWriter o)
    {
        this.out = o;
    }
    
    /**
     * Getter for the writer
     * @return the OutputStreamWriter for other purposes
     */
    public OutputStreamWriter getStreamWriter()
    {
        return out;
    }
    
    /**
     *  serialize an Object.  This form of the function is usually called internally by
     *  objects implementing the IXMLSerializable interface.
     *
     *  @param obj the object to serialize, must implement IXMLSerializable
     *  @exception NotSerializableException thrown if obj doesn't implement IXMLSerializable
     *  @exception IOException thrown on output error
     *  @see IXMLSerializable
     */
    public void writeXML(Object obj) throws NotSerializableException,IOException
    {
        try {
            IXMLSerializable x = (IXMLSerializable)obj;
            level++;
            x.writeXML(this);
            level--;
        }
        catch (ClassCastException e)
        {
            throw new NotSerializableException("Invalid class "+this.getClass().getName());
        }
    }

    /**
     *  serialize Date in ISO format.  This form of the function is usually called internally by
     *  objects implementing the IXMLSerializable interface to serialize date/ time data.
     * @param date the date object to be serialized
     * @return ISO format string representation of the date
     */
    public static String transformToXMLDate(Date date)
    {
        return "<time value='" +new DateTransformer().transformToISODate(date) +"'/>";						    
    }

    /**
     *  print a line at the current level of indention, adding a newline at the end.
     *  @param s the string to print
     *  @exception IOException thrown on output error
     */
    public void println(String s) throws IOException
    {
        insertMargin(level);
        out.write(s);
        out.write('\n');
    }

    /**
     *  print a line at the current level of indention + 1, adding a newline at the end.
     *  @param s the string to print
     *  @exception IOException thrown on output error
     */
    public void printlnIndent(String s) throws IOException
    {
        insertMargin(level+1);
        out.write(s);
        out.write('\n');
    }
    
    /**
     *  increase the current level of indention
     */
    public void pushLevel()
    {
        if (level == XML_STARTLEVEL)
            throw new ArrayIndexOutOfBoundsException("OutputXMLWriter indention level uninitialized");
        level++;
    }
    
    /**
     *  decrease the current level of indention
     * @throws java.lang.ArrayIndexOutOfBoundsException if the level is out of bounds.
     */
    public void popLevel() throws ArrayIndexOutOfBoundsException
    {
        if (level <= 0)
            throw new ArrayIndexOutOfBoundsException("OutputXMLWriter indention level not acceptable");
        level--;
    }

    /**
     *  increase the current level of indention
     */
    public void startDocument()
    {
		if (level != XML_STARTLEVEL)
            throw new ArrayIndexOutOfBoundsException("OutputXMLWriter document start failed");
        level++;
    }
    
    /**
     *  decrease the current level of indention
     * @throws java.lang.ArrayIndexOutOfBoundsException if the level is out of bounds.
     */
    public void endDocument() throws ArrayIndexOutOfBoundsException
    {
        if (level != 0)
            throw new ArrayIndexOutOfBoundsException("OutputXMLWriter document end failed");
        level--;
    }

    /**
     *  flush the stream
     *  @exception IOException thrown on output error
     *  @see java.io.OutputStreamWriter#flush()
     */
    public void flush() throws IOException
    {
        out.flush();
    }
    
    /**
     *  insert indentions at the level of the main serialization object.
     *  @param count the number of indentions to insert
     *  @exception IOException thrown on output error
     */
    private void insertMargin(int count) throws IOException
    {
        for (int i = 0; i < count; i++)
            out.write('\t');
    }
}