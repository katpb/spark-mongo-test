package com.verifone.isd.vsms2.sys.util;

import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

/**
 *  Class that supports opening a circular log if a fileName is supplied, otherwise prints to a stream,
 *  usually constructed as such for debugging purposes.
 *
 *  @author "mailto:david_ezell@verifone.com"
 *  @version 1.0
 */
public class CircularLog
{
    private PrintStream out = null;
    private boolean isAFile = false;    // if true will allow changing of files
    private long size = 0;
    private long curLen = 0;
    
    /**
     *  uses the given filename to open the log, and limits the total characters kept in the 
     *  system.
     * @see java.io.File
     * @param fileName the path of the file to use
     * @param size the total number of characters to allow
     * @throws java.io.IOException on writing to the specified file name
     */
    public CircularLog(String fileName,long size) throws IOException
    {
        File f = new File(fileName);
        curLen = f.length();
        FileOutputStream os = new FileOutputStream(fileName,true);
        out = new PrintStream(os);
        isAFile = true;
        this.size = size;
    }
    
    /**
     *  constructor for debug purposes.  There is no "circular" functionality, but the
     *  print statements are sent to the stream (probably System.out)
     *  @param stream the stream to use for output
     *  @see java.io.PrintStream
     */
    public CircularLog(PrintStream stream)
    {
        out = stream;
        isAFile = false;
        this.size = 0;
    }
    
    /**
     *  print a string to the output designated, tallying the characters
     *  @param s the string to print
     *  @see java.io.PrintStream#print(String s)
     */
    public void print(String s)
    {
        out.print(s);
        curLen += s.length();
    }
    
    /**
     *  print a string to the output designated, and add a new line, tallying the characters
     *  @param s the string to print
     *  @see java.io.PrintStream#println(String s)
     */
    public void println(String s)
    {
        out.println(s);
        curLen += s.length() + 1;
    }
    
    /**
     *  print a newline and add one to the character tally
     *  @see java.io.PrintStream#println()
     */
    public void println()
    {
        out.println();
        curLen += 1;
    }
    
    /**
     *  flush characters to output medium
     *  @see java.io.PrintStream#flush()
     */
    public void flush()
    {
        out.flush();
    }
    
    /**
     *  close the medium
     *  @see java.io.PrintStream#close()
     */
    public void close()
    {
        out.close();
        out = null;
    }
}