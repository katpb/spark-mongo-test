/*
 * NetException.java
 *
 * Created on May 02, 2003, 6:10 PM
 */
package com.verifone.isd.vsms2.net.ent;

/** NetException Extends the exception class to allow specific exceptions to be
 *  generated from the network components.
 * @author kelvin_f1
 * @version 1.0
 */
public class NetworkException extends java.lang.Exception
{
    /** Constructor method with an error message. s contains the details of the exception.
     * Creates a new instance of the network exception.
     * @param s details of the network exception.
     */    
    public NetworkException(String s)
    {
        super(s);
    }
    
    /** No argument contructor method. Creates an new instance of a network exception.
     */    
    public NetworkException()
    {
        super();
    }
    
    // Additional message to be displayed to the CSR
    private String line2;
    private String line3;
    
    // indicates if cashier should be allowed to override the error condition
    private boolean csrPromptReqd;   
    
    //indicates if network request timed out
    private boolean timedOut;
    
    //indicates if network request resulted in an communication error
    private boolean commError;
    
    public void setLine2(String line) {
        this.line2 = line;
    }
    
    public String getLine2() {
        return this.line2;
    }
	/**
	 * @return Returns the line3.
	 */
	public String getLine3() {
		return line3;
	}
	/**
	 * @param line3 The line3 to set.
	 */
	public void setLine3(String line3) {
		this.line3 = line3;
	}
    public void setCsrPromptReqd(boolean prompt) {
        this.csrPromptReqd = prompt;
    }
    
    public boolean getCsrPromptReqd() {
        return this.csrPromptReqd;
    }

	/**
	 * @return the timedOut
	 */
	public boolean isTimedOut() {
		return timedOut;
	}

	/**
	 * @param timedOut the timedOut to set
	 */
	public void setTimedOut(boolean timedOut) {
		this.timedOut = timedOut;
	}

	/**
	 * @return the commError
	 */
	public boolean isCommError() {
		return commError;
	}

	/**
	 * @param commError the commError to set
	 */
	public void setCommError(boolean commError) {
		this.commError = commError;
	}
}