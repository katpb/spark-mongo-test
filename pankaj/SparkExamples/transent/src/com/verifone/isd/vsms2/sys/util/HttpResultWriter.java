/*
 * HttpResultWriter.java
 *
 * Created on September 20, 2004, 12:06 PM
 */

package com.verifone.isd.vsms2.sys.util;

import java.io.Writer;
import java.io.IOException;

/** Helper class to write HTTP result headers
 * @author Bhanu_N2
 */
public class HttpResultWriter {
    private static final String COOKIE_HTTP_HDR = "Set-Cookie: credential=";
    private static final String SITE_ID_HTTP_HDR = "Sapphire-Site-Id: ";
    private static final String PERIOD_ID_HTTP_HDR = "Sapphire-Period-Id: ";
    private static final String PERIOD_NAME_HTTP_HDR = "Sapphire-Period-Name: ";
    
    private Writer writer;
    
    /** Creates a new instance of HttpResultWriter
     * @param writer output writer
     */
    public HttpResultWriter(Writer writer) {
        this.writer = writer;
    }
    
    /** Writes the specified message to a given writer
     * @param code the result code
     * @param info the message to be written to the writer
     * @exception java.io.IOException on writing the message
     */
    public void writeResult(int code,String info) throws IOException {
        this.writer.write(code+" "+info+"\n\n");
        this.writer.flush();
    }
    
    /** Writes the HTTP header to a given writer
     * @param names header name array
     * @param values header value array
     * @param mimeType the mime type string
     * @exception java.io.IOException on writing the header
     */
    
    public void writeHTTPHeader(String mimeType,String[] names, String[] values) throws IOException {
        String mime = (mimeType != null && mimeType.equals("text/xml")) ? "application/xml" : mimeType;
        this.writer.write("Content-Type: "+mime+";\n");
        this.writer.write("Cache-Control: no-store;\n");        
        if (names != null) {
            for (int i = 0; i < names.length; i++) {
                if ( values[i] != null) {
                    this.writer.write(names[i] +values[i] +";\n");
                }
            }
        }
        this.writer.write("\n");
        this.writer.flush();
    }
    
    /** Method to write 'Set-Cookie' HTTP header
     * @param mimeType mime type
     * @param cookie cookie string
     * @throws IOException on error in writing to the writer
     */    
    public void writeHTTPHeaderCookie(String mimeType,String cookie) throws IOException {
        String[] names = null; //new String[1];
//        names[0] = COOKIE_HTTP_HDR;
        String[] values = null; //new String[1];
//        values[0] = cookie; 
        this.writeHTTPHeader(mimeType, names, values);
		
    }
    
    /** Method to write 'Sapphire-Site-Id' HTTP header
     * @param siteID site id
     * @param mimeType mime type
     * @throws IOException on error in writing to the writer
     */    
    public void writeHTTPHeaderSiteId(String mimeType,String siteID) throws IOException {
        String[] names = new String[1];
        names[0] = SITE_ID_HTTP_HDR;
        String[] values = new String[1];
        values[0] = siteID;
        this.writeHTTPHeader( mimeType, names, values);
    }
    
    /** Method to write 'Sapphire-Period-Id' HTTP header
     * @param periodId period id
     * @param mimeType mime type
     * @throws IOException on error in writing to the writer
     */
    public void writeHTTPHeaderPeriodId(String mimeType,String periodId) throws IOException {
        String[] names = new String[1];
        names[0] = PERIOD_ID_HTTP_HDR;
        String[] values = new String[1];
        values[0] = periodId;
        this.writeHTTPHeader(mimeType, names, values);
    }
       
    /** Method to flush data written using the writer
     * @throws IOException on error in flushing the underlying output stream
     */    
    public void flush() throws IOException {
        this.writer.flush();
    }
    
    /** Getter for property writer.
     * @return Value of property writer.
     *
     */
    public java.io.Writer getWriter() {
        return writer;
    }
}
