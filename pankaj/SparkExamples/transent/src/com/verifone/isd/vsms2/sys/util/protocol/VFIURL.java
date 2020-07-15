/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 23 May, 2007                                    Rajesh Brahmankar
 */

package com.verifone.isd.vsms2.sys.util.protocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLStreamHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.sys.util.CommonThreadPoolUtil;
import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;

/**
 * Custom <code>URL</code> class to provide configurable HTTP timeout. 
 * Standard HTTP request timeout is too long (~10 min). Topaz looks very slow 
 * when HTTP request is made under the following conditions.
 * 1. Sapphire is not connected to network.
 * 2. HTTP server in Sapphire is down.
 * 3. Sapphire VM lockup or VM is not running.
 * <p>
 * Default timeout value honored by this custom class is 10 sec if "http.timeout" 
 * property is not specified.
 * <p>
 * CAUTION: Use this custom class for only HTTP request. For all other request 
 * use <code>URL</code> and <code>URLConnection</code> classes
 *
 * @see java.net.URL
 */
public class VFIURL {
    private static final Logger LOGGER
            = LoggerFactory.getLogger(VFIURL.class);
    URL url = null;    
    private Object obj = null;
    static final String HTTP_TIMEOUT_PROP = "http.timeout";
    public static final int httpTimeout;
    private int customHttpTimeout = 0;
    
    static {
        int httpTimeout1 = 0;
        try {
            httpTimeout1 = Integer.parseInt(SysPropertyFactory.getProperty(HTTP_TIMEOUT_PROP, "10000"));
            if (httpTimeout1 <= 0) {
                httpTimeout1 = 10000;
            }
        } catch ( NumberFormatException nfe) {
            LOGGER.error( "VFIURL: specified timeout is not a valid number", nfe);
            httpTimeout1 = 10000;
        } finally {
            httpTimeout = httpTimeout1;
        }
    }
        
    public VFIURL(String spec) throws MalformedURLException {
        customHttpTimeout = httpTimeout;
        url = new URL(spec);              
    }
    
    public VFIURL(String protocol, String host, int port, String file) throws MalformedURLException {
        customHttpTimeout = httpTimeout;
        url = new URL(protocol, host, port, file);              
    }
    
    public VFIURL(String protocol, String host, int port, String file, URLStreamHandler handler) throws MalformedURLException {
        customHttpTimeout = httpTimeout;
        url = new URL(protocol, host, port, file, handler);      
    }
    
    public VFIURL(String protocol, String host, String file) throws MalformedURLException {
        customHttpTimeout = httpTimeout;
        url = new URL(protocol, host, file);      
    }
    
    public VFIURL(URL context, String spec) throws MalformedURLException {
        customHttpTimeout = httpTimeout;
        url = new URL(context, spec);      
    }

    public VFIURL(URL context, String spec, URLStreamHandler handler) throws MalformedURLException {
        customHttpTimeout = httpTimeout;
        url = new URL(context, spec, handler);      
    }
    
    public boolean equals(Object obj) {
        return url.equals(obj);
    }
    
    public String getAuthority() {
        return url.getAuthority();
    }
    
    /**
     * Returns the contents of this URL. 
     * <p>
     * Custom timeout is achieved by calling <code>java.net.URL#getContent</code> 
     * method in a background thread. <code>TimerTask</code> is scheduled for execution 
     * after delay equal to custom timeout. If <code>getContent()</code> method is blocked 
     * then timer will notify waiting foreground thread otherwise background thread 
     * will notify.
     * <p>
     * @return     the contents of this URL.
     * @exception  IOException  if an I/O exception occurs.
     * @see        java.net.URL#getContent()
     */
    public final Object getContent() throws IOException {            
        obj = null;
        
        Thread urlthread = new Thread() { 
           public void run(){
               try {                   
                   obj = url.getContent();                   
                   synchronized(VFIURL.this) {                           
                       VFIURL.this.notifyAll();
                   }
               } catch(IOException e) {      
                   obj = null;
               }               
           } 
        };        
                
        urlthread.start();

        CommonThreadPoolUtil.getInstance().schedule(new Runnable() {
			
			@Override
			public void run() {
				 synchronized(VFIURL.this) {                        
	                   VFIURL.this.notifyAll();
	                }
				
			}
		},  customHttpTimeout);
            
        synchronized(this) {
            if (obj == null) {
                try {                                
                    wait();
                }
                catch(InterruptedException ex) {                
                }        
            }
        }
                                
        if (obj != null) {
            return obj;
        } else {
            throw new InterruptedIOException("No response from server for " + customHttpTimeout + " ms");
        }
    }        

    /**
     * Returns the contents of this URL. 
     * <p>
     * Custom timeout is achieved by calling <code>java.net.URL#getContent(Class[])</code> 
     * method in a background thread. <code>TimerTask</code> is scheduled for execution 
     * after delay equal to custom timeout. If <code>getContent(Class[])</code> method 
     * is blocked then timer will notify waiting foreground thread otherwise background 
     * thread will notify.
     * <p>
     * @param classes the <code>Class</code> array 
     * indicating the requested types
     * @return     the content object of this URL that is the first match of
     *               the types specified in the classes array.
     *               null if none of the requested types are supported.
     * @exception  IOException  if an I/O exception occurs.
     * @see        java.net.URL#getContent(Class[])
     */    
    public final Object getContent(final Class[] classes) throws IOException {                            
        obj = null;        
        
        Thread urlthread = new Thread() { 
           public void run(){               
               try {                   
                   obj = url.getContent(classes);
                   synchronized(VFIURL.this) {                                                  
                       VFIURL.this.notifyAll();
                   }
               } catch(IOException e) {      
                   obj = null;
               }               
           } 
        };        
                
        urlthread.start();
        
        CommonThreadPoolUtil.getInstance().schedule(new Runnable() {
			
			@Override
			public void run() {
				 synchronized(VFIURL.this) {                        
	                   VFIURL.this.notifyAll();
	                }
				
			}
		},  customHttpTimeout);
            
        synchronized(this) {
            if (obj == null) {
                try {                                
                    wait();
                }
                catch(InterruptedException ex) {                
                }        
            }
        }
                                
        if (obj != null) {
            return obj;
        } else {
            throw new InterruptedIOException("No response from server for " + customHttpTimeout + " ms");
        }
    }
    
    public String getFile() {
        return url.getFile();
    }
        
    public String getHost() {
        return url.getHost();
    }
    
    public String getPath() {
        return url.getPath();
    }
    
    public int getPort() {
        return url.getPort();
    }
    
    public String getProtocol() {
        return url.getProtocol();
    }
    
    public String getQuery() {
        return url.getQuery();
    }

    public String getRef() {
        return url.getRef();
    }

    public String getUserInfo() {
        return url.getUserInfo();
    }
    
    public int hashCode() {
        return url.hashCode();
    }
    
    public VFIHttpURLConnection openConnection() throws IOException {                     
        return new VFIHttpURLConnection(url);        
    }
    
    /**
     * Opens a connection to this <code>URL</code> and returns an 
     * <code>InputStream</code> for reading from that connection. 
     * <p>
     * Custom timeout is achieved by calling <code>java.net.URL#openStream()</code> 
     * method in a background thread. <code>TimerTask</code> is scheduled for execution 
     * after delay equal to custom timeout. If <code>getContent(Class[])</code> method 
     * is blocked then timer will notify waiting foreground thread otherwise background 
     * thread will notify.
     * <p>
     * @return     an input stream for reading from the URL connection.
     * @exception  IOException  if an I/O exception occurs.
     * @see        java.net.URL#openStream()
     */    
    public final InputStream openStream() throws IOException {
        obj = null;
        
        Thread urlthread = new Thread() { 
           public void run(){
               try {   
                   obj = url.openStream();
                   synchronized(VFIURL.this) {                                                  
                       VFIURL.this.notifyAll();
                   }
               } catch(IOException e) {      
                   obj = null;
               }               
           } 
        };        
                
        urlthread.start();        
        
        CommonThreadPoolUtil.getInstance().schedule(new Runnable() {
			
			@Override
			public void run() {
				 synchronized(VFIURL.this) {                        
	                   VFIURL.this.notifyAll();
	                }
				
			}
		},  customHttpTimeout);
            
        synchronized(this) {
            if (obj == null) {
                try {                                
                    wait();
                }
                catch(InterruptedException ex) {                                    
                }
            }
        }
                                
        if (obj != null) {
            return (InputStream)obj;
        } else {
            throw new InterruptedIOException("No response from server for " + customHttpTimeout + " ms");
        }                
    }
    
    public boolean sameFile(URL other) {
        return url.sameFile(other);
    }
        
    public String toExternalForm() {
        return url.toExternalForm();
    }
    
    public String toString() {
        return url.toString();
    }
    
  
    /**
     * Sets the timeout value for http request.
     * @param timeOut new timeout value for this request
     */
    public void setTimeoutValue(int timeOut) {
        if (timeOut > 0) {
            customHttpTimeout = timeOut;
        }
    }

    /**
     * Returns the timeout value for http request.
     * @return new timeout value for this request
     */
    public int getTimeoutValue() {
        return customHttpTimeout;
    }

}
