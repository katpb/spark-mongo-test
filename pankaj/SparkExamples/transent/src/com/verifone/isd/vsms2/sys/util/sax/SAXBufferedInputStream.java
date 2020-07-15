/*
 * SAXBufferedInputStream.java
 *
 * Created on May 24, 2005, 7:55 PM
 */

package com.verifone.isd.vsms2.sys.util.sax;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.IOException;
import java.io.EOFException;
/**
 * This is a wrapper class to be used for SAX parsing. When a stream is handed over to 
 * SAX parser, the stream gets closed by the parser. This causes 'Broken pipe' if the 
 * stream is from a socket and no response can be sent back to the client. This class 
 * overrides close() method to prevent the actual stream from getting closed by the 
 * SAX parser. The onus of closing the stream is on the calling object.
 * @author  bhanu_n2
 */
public class SAXBufferedInputStream extends BufferedInputStream {
    
    /**
     * Creates a new instance of SAXBufferedInputStream
     * @param is input stream to be wrapped
     */
    public SAXBufferedInputStream(InputStream is) {
        super(is);
    }
    
    /**
     * Method override to prevent actual close of the stream. It is the application's responsibility 
     * to close the underlying stream.
     */
    public void close() {
    }
    
    /**
     * Implementation method.
     * @return return value from read() call on the wrapped stream
     * @throws java.io.IOException on error in calling read on the wrapped stream
     * @see java.io.InputStream#read()
     */
    public int read() throws IOException {
        try {
            return super.read();
        }
        catch (InterruptedIOException ioe) {
            throw new EOFException();
        }
    }
    
    /**
     * Implementation method.
     * @param b byte array to be filled with read data
     * @param off begin offset in the byte array to write the data into
     * @param len maximum length of data that can be read
     * @throws java.io.IOException on error in calling read on the wrapped stream 
     * @return number of bytes read
     * @see java.io.InputStream#read(byte[] b, int off, int len)
     */
    public int read(byte[] b, int off, int len) throws IOException {
        try {
            return super.read(b, off, len);
        }
        catch (InterruptedIOException ioe) {
            throw new EOFException();
        }
    }    
}
