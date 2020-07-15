package com.verifone.isd.vsms2.sys.util;

import java.io.OutputStream;
import java.io.IOException;

/** Helper class to write HTTP result headers to the stream. Use this class 
 * if the response contains binary data.
 * @author Bhanu_N2
 */
public class HttpResultOutputStream {
    private static final String COOKIE_HTTP_HDR = "Set-Cookie: credential=";
    private static final String SITE_ID_HTTP_HDR = "Sapphire-Site-Id: ";
    private static final String PERIOD_ID_HTTP_HDR = "Sapphire-Period-Id: ";
    private static final String PERIOD_NAME_HTTP_HDR = "Sapphire-Period-Name: ";
    
    private OutputStream outputStream;
    /** Creates a new instance of HttpResultOutputStream
     * @param outputStream output outputStream
     */
    public HttpResultOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
    
    /** Writes the specified message to a given outputStream
     * @param code the result code
     * @param info the message to be written to the outputStream
     * @exception java.io.IOException on writing the message
     */
    public void writeResult(int code, String info) throws IOException {
        String data = code+" "+info+"\n\n";
        this.outputStream.write(data.getBytes());
        this.outputStream.flush();
    }
    
    /** Writes the HTTP header to a given outputStream
     * @param names header name array
     * @param values header value array
     * @param mimeType the mime type string
     * @exception java.io.IOException on writing the header
     */
    
    public void writeHTTPHeader(String mimeType,String[] names, String[] values) throws IOException {
        String mime = (mimeType != null && mimeType.equals("text/xml")) ? "application/xml" : mimeType;
        String data = "Content-Type: "+mime+";\n";
        this.outputStream.write(data.getBytes());
        this.outputStream.write("Cache-Control: no-store;\n".getBytes());        
        if (names != null) {
            for (int i = 0; i < names.length; i++) {
                if ( values[i] != null) {
                    data = names[i] +values[i] +"\n";
                    this.outputStream.write(data.getBytes());
                }
            }
        }
        this.outputStream.write("\n".getBytes());
        this.outputStream.flush();
    }
    
    /** Method to write 'Set-Cookie' HTTP header
     * @param mimeType mime type
     * @param cookie cookie string
     * @throws IOException on error in writing to the outputStream
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
     * @throws IOException on error in writing to the outputStream
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
     * @throws IOException on error in writing to the outputStream
     */
    public void writeHTTPHeaderPeriodId(String mimeType,String periodId) throws IOException {
        String[] names = new String[1];
        names[0] = PERIOD_ID_HTTP_HDR;
        String[] values = new String[1];
        values[0] = periodId;
        this.writeHTTPHeader(mimeType, names, values);
    }
       
    /** Method to flush data written using the outputStream
     * @throws IOException on error in flushing the underlying output stream
     */    
    public void flush() throws IOException {
        this.outputStream.flush();
    }
    
    /** Getter for property outputStream.
     * @return Value of property outputStream.
     *
     */
    public OutputStream getOutputStream() {
        return outputStream;
    }
}
