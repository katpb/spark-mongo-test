/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 23 May, 2007                                    Rajesh Brahmankar
 */

package com.verifone.isd.vsms2.sys.util.protocol;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownServiceException;
import java.security.Permission;

import com.verifone.isd.vsms2.sys.util.CommonThreadPoolUtil;

/**
 * Custom <code>HttpURLConnection</code> class to provide configurable HTTP 
 * timeout. Standard HTTP request timeout is too long (~10 min). Topaz looks 
 * very slow when HTTP request is made under the following conditions.
 * <p>
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
 * NOTE: Only blocking methods on <code>URLConnection</code> have custom implementaion 
 * and all other methods called through it's instance. Exposing every public 
 * method of <code>URLConnection</code> would have been avoided by inheriting 
 * this class from <code>URLConnection</code> but can't directly use methods 
 * without actually getting it's instance through java.net.URL#openConnection() 
 *
 * @see java.net.URLConnection
 * @see java.net.HttpURLConnection
 */
public class VFIHttpURLConnection extends Object {

    URLConnection urlcon = null;
    Object obj = null;
    private int customHttpTimeout = 0;
    private int readTimeOut = 0;
    /** Creates a new instance of VFIHttpURLConnection */
    public VFIHttpURLConnection(URL url) throws IOException {
        super();
        customHttpTimeout = VFIURL.httpTimeout;
        urlcon = url.openConnection();        
    }

    public void connect() throws IOException {
        urlcon.connect();
    }
    
    public boolean getAllowUserInteraction() {
        return urlcon.getAllowUserInteraction();
    }

    /**
     * Retrieves the contents of this URL connection. 
     * <p>
     * Custom timeout is achieved by calling <code>java.net.URLConnection#getContent()</code> 
     * method in a background thread. <code>TimerTask</code> is scheduled for execution 
     * after delay equal to custom timeout. If <code>getContent()</code> method is blocked 
     * then timer will notify waiting foreground thread otherwise background thread 
     * will notify.
     * <p>
     * @return     the object fetched. The <code>instanceOf</code> operation
     *               should be used to determine the specific kind of object
     *               returned.
     * @exception  IOException              if an I/O error occurs while
     *               getting the content.
     * @exception  UnknownServiceException  if the protocol does not support
     *               the content type.
     * @see        java.net.URLConnection#getContent()
     */
    public final Object getContent() throws IOException {  

        obj = null;
        
        Thread urlthread = new Thread() { 
           public void run(){
               try {                   
                   obj = urlcon.getContent();
                   synchronized(VFIHttpURLConnection.this) {                                                  
                       VFIHttpURLConnection.this.notifyAll();
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
				 synchronized(VFIHttpURLConnection.this) {                        
					 VFIHttpURLConnection.this.notifyAll();
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
     * Retrieves the contents of this URL connection. 
     * <p>
     * Custom timeout is achieved by calling <code>java.net.URLConnection#getContent(Class[])</code> 
     * method in a background thread. <code>TimerTask</code> is scheduled for execution 
     * after delay equal to custom timeout. If <code>getContent(Class[])</code> method 
     * is blocked then timer will notify waiting foreground thread otherwise background 
     * thread will notify.
     * <p>
     * @param classes the <code>Class</code> array 
     * indicating the requested types
     * @return     the object fetched that is the first match of the type
     *               specified in the classes array. null if none of 
     *               the requested types are supported.
     *               The <code>instanceOf</code> operation should be used to 
     *               determine the specific kind of object returned.
     * @exception  IOException              if an I/O error occurs while
     *               getting the content.
     * @exception  UnknownServiceException  if the protocol does not support
     *               the content type.
     * @see        java.net.URLConnection#getContent(java.lang.Class[])
     */    
    public final Object getContent(final Class[] classes) throws IOException {       
        obj = null;
        
        Thread urlthread = new Thread() { 
           public void run(){
               try {   
                   obj = urlcon.getContent(classes);
                   synchronized(VFIHttpURLConnection.this) {                                                  
                       VFIHttpURLConnection.this.notifyAll();
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
				 synchronized(VFIHttpURLConnection.this) {                        
					 VFIHttpURLConnection.this.notifyAll();
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

    public String getContentEncoding() {
        return urlcon.getContentEncoding();
    }

    public int getContentLength() {
        return urlcon.getContentLength();
    }

    public String getContentType() {
        return urlcon.getContentType();
    }

    public long getDate() {
        return urlcon.getDate();
    }

    public boolean getDefaultUseCaches() {
        return urlcon.getDefaultUseCaches();
    }

    public boolean getDoInput() {
        return urlcon.getDoInput();
    }

    public boolean getDoOutput() {
        return urlcon.getDoOutput();
    }    
    
    public long getExpiration() {
        return urlcon.getExpiration();
    }
    
    public String getHeaderField(int n) {
        return urlcon.getHeaderField(n);
    }

    public String getHeaderField(String name) {
       return urlcon.getHeaderField(name);                                
    }
    
    public int getHeaderFieldInt(String name, int Default) {
        return urlcon.getHeaderFieldInt(name, Default);
    }
    
    public String getHeaderFieldKey(int n) {
        return urlcon.getHeaderFieldKey(n);            
    }
    
    public long getIfModifiedSince() {
        return urlcon.getIfModifiedSince();
    }

    /**
     * Returns an input stream that reads from this open connection.
     * <p>
     * Custom timeout is achieved by calling <code>java.net.URLConnection#InputStream()</code> 
     * method in a background thread. <code>TimerTask</code> is scheduled for execution 
     * after delay equal to custom timeout. If <code>getInputStream()</code> method 
     * is blocked then timer will notify waiting foreground thread otherwise background 
     * thread will notify.
     * <p>
     * @return     an input stream that reads from this open connection.
     * @exception  IOException              if an I/O error occurs while
     *               creating the input stream.
     * @exception  UnknownServiceException  if the protocol does not support
     *               input.
     * @see        java.net.URLConnection#getInputStream()
     */    
    public InputStream getInputStream() throws IOException {
        obj = null;
        
        Thread urlthread = new Thread() { 
           public void run(){
               try {   
                   obj = urlcon.getInputStream();
                   synchronized(VFIHttpURLConnection.this) {                                                  
                       VFIHttpURLConnection.this.notifyAll();
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
				 synchronized(VFIHttpURLConnection.this) {                        
					 VFIHttpURLConnection.this.notifyAll();
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
    
    public long getLastModified() {
        return urlcon.getLastModified();
    }

    /**
     * Returns an output stream that writes to this connection.
     * <p>
     * Custom timeout is achieved by calling <code>java.net.URLConnection#getOutputStream()</code> 
     * method in a background thread. <code>TimerTask</code> is scheduled for execution 
     * after delay equal to custom timeout. If <code>getOutputStream()</code> method 
     * is blocked then timer will notify waiting foreground thread otherwise background 
     * thread will notify.
     * @return     an output stream that writes to this connection.
     * @exception  IOException              if an I/O error occurs while
     *               creating the output stream.
     * @exception  UnknownServiceException  if the protocol does not support
     *               output.
     * @see        java.net.URLConnection#getOutputStream()     
     */    
    public OutputStream getOutputStream() throws IOException {
        obj = null;
        
        Thread urlthread = new Thread() { 
           public void run(){
               try {                   
                   obj = urlcon.getOutputStream();
                   synchronized(VFIHttpURLConnection.this) {                                                  
                       VFIHttpURLConnection.this.notifyAll();
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
				 synchronized(VFIHttpURLConnection.this) {                        
					 VFIHttpURLConnection.this.notifyAll();
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
            return (OutputStream)obj;
        } else {
            throw new InterruptedIOException("No response from server for " + customHttpTimeout + " ms");
        }        
    }
    
    public String getRequestProperty(String key) {
        return urlcon.getRequestProperty(key);
    }           

    public URL getURL() {
        return urlcon.getURL();
    }
    
    public boolean getUseCaches() {
        return urlcon.getUseCaches();
    }
    
    public void setAllowUserInteraction(boolean allowuserinteraction) {
        urlcon.setAllowUserInteraction(allowuserinteraction);
    }
    
    public void setDefaultUseCaches(boolean defaultusecaches) {
        urlcon.setDefaultUseCaches(defaultusecaches);
    }
    
    public void setDoInput(boolean doinput) {
        urlcon.setDoInput(doinput);
    }
    
    public void setDoOutput(boolean dooutput) {
        urlcon.setDoOutput(dooutput);
    }
    
    public void setIfModifiedSince(long ifmodifiedsince) {
        urlcon.setIfModifiedSince(ifmodifiedsince);
    }
    
    public void setRequestProperty(String key, String value) {
        urlcon.setRequestProperty(key, value);
    }
    
    public void setUseCaches(boolean usecaches) {
        urlcon.setUseCaches(usecaches);
    }
    
    public String toString() {
        return urlcon.toString();
    }
    
    public void disconnect() {
        ((HttpURLConnection)urlcon).disconnect();
    }
    
    public InputStream getErrorStream() {
        return ((HttpURLConnection)urlcon).getErrorStream();
    }
    
    public long getHeaderFieldDate(String name, long Default) {
        return ((HttpURLConnection)urlcon).getHeaderFieldDate(name, Default);
    }
    
    public boolean getInstanceFollowRedirects() {
        return ((HttpURLConnection)urlcon).getInstanceFollowRedirects();
    }
    
    /**
     * Returns a permission object representing the permission
     * necessary to make the connection represented by this
     * object.
     * <p>
     * Custom timeout is achieved by calling <code>java.net.HttpURLConnection#getPermission()</code> 
     * method in a background thread. <code>TimerTask</code> is scheduled for execution 
     * after delay equal to custom timeout. If <code>getOutputStream()</code> method 
     * is blocked then timer will notify waiting foreground thread otherwise background 
     * thread will notify.
     * @return the permission object representing the permission
     * necessary to make the connection represented by this
     * URLConnection. 
     * @exception IOException if the computation of the permission
     * requires network or file I/O and an exception occurs while
     * computing it.
     * @see        java.net.HttpURLConnection#getPermission()     
     */    
    public Permission getPermission() throws IOException {
        obj = null;
        
        Thread urlthread = new Thread() { 
           public void run(){
               try {                   
                   obj = ((HttpURLConnection)urlcon).getPermission();
                   synchronized(VFIHttpURLConnection.this) {                                                  
                       VFIHttpURLConnection.this.notifyAll();
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
				 synchronized(VFIHttpURLConnection.this) {                        
					 VFIHttpURLConnection.this.notifyAll();
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
            return (Permission)obj;
        } else {
            throw new InterruptedIOException("No response from server for " + customHttpTimeout + " ms");
        }        
    }
    
    public String getRequestMethod() {
        return ((HttpURLConnection)urlcon).getRequestMethod();
    }
    
    public int getResponseCode() throws IOException {
        return ((HttpURLConnection)urlcon).getResponseCode();
    }
    
    public String getResponseMessage() throws IOException {
        return ((HttpURLConnection)urlcon).getResponseMessage();
    }
    
    public void setInstanceFollowRedirects(boolean followRedirects) {
        ((HttpURLConnection)urlcon).setInstanceFollowRedirects(followRedirects);
    }
    
    public void setRequestMethod(String method) throws ProtocolException {
        ((HttpURLConnection)urlcon).setRequestMethod(method);
    }
    
    public boolean usingProxy() {        
        return ((HttpURLConnection)urlcon).usingProxy();
    }

    /**
     * Sets the timeout value for http request.
     * @param timeOut new timeout value for this request
     */
    public void setTimeoutValue(int timeOut) {
        if (timeOut > 0) {
            customHttpTimeout = timeOut;
        }
        urlcon.setConnectTimeout(customHttpTimeout);
    }

    public int getReadTimeOut() {
		return readTimeOut;
	}

	public void setReadTimeOut(int readTimeOut) {
		if (readTimeOut > 0) {
            this.readTimeOut = readTimeOut;
            urlcon.setReadTimeout(this.readTimeOut);
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
