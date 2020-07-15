/** Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
*
* Created 17 Dec, 2004                                     Sudesh Srinivasan
*/
package com.verifone.isd.vsms2.sys.error;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.sys.l10n.LocalizedRB;

/**
 * The VFIException is a base class for all the exceptions that would be created
 * for Topaz and Sapphire applications. This class provides support for
 * localization of error messages that need to be displayed. It also allows the
 * application to pass values that need to be displayed as part of the error
 * message, as a parameter list. The exception classes that derive from
 * VFIException can override the getDisplayMsg and log methods if required.
 * 
 * @author  Sudesh_s1
 * @version 1.0  
 */
public class VFIException extends Exception {
    
	private static final long serialVersionUID = -5292108558589869931L;
	private Logger logger = LoggerFactory.getLogger(VFIException.class);
    protected String errorKey;
    protected String bundleName;
    protected ArrayList<String> errorParams;
    protected Throwable source;
    
    /**
     * constructor
     *
     * @param errorKey key for the error resource
     * @param bundleName name of the resource bundle
     */
    public VFIException(String errorKey, String bundleName) {
        this(errorKey, bundleName, null, null);
    }

    /**
     * constructor
     * 
     * @param errorKey Key for the error resource
     * @param bundleName name of the resource bundle
     * @param errorParams Values that need to be displayed as part of the error message,
     * as an ArrayList.
     */
    public VFIException(String errorKey, String bundleName, ArrayList<String> errorParams) {
        this(errorKey, bundleName, errorParams, null);
    }

    /**
     * constructor
     * 
     * @param errorKey Key for the error resource
     * @param bundleName name of the resource bundle
     * @param source Source exception as a Throwable object.
     */
    public VFIException(String errorKey, String bundleName, Throwable source) {
        this(errorKey, bundleName, null, source);
    }

    /**
     * constructor
     * 
     * @param errorKey Key for the error resource
     * @param bundleName name of the resource bundle
     * @param errorParams Values that need to be displayed as part of the error message,
     * as an ArrayList.
     * @param source Source exception as a Throwable object.
     */
    public VFIException(String errorKey, String bundleName, ArrayList<String> errorParams, Throwable source) {
        super();
        this.errorKey = errorKey;
        this.bundleName = bundleName;
        this.errorParams = errorParams;
        this.source = source;
    }
    
    /** 
     * Accessor method to get the error key
     * @return The errorKey 
     */
    public String getErrorKey() {
        return this.errorKey;
    }

    /** 
     * Accessor method to get the error resource bundle name
     * @return The bundleName 
     * */
    public String getBundleName() {
        return this.bundleName;
    }

    /**
     * Accessor method to get the parameters of the exception represented
     * @return The errorParams.
     */
    public ArrayList<String> getErrorParams() {
        return this.errorParams;
    }

    /**
     * Accessor method to set the parameters of the exception represented
     * @param  errorParams the array list of parameters to be set
     */
    public void setErrorParams(ArrayList<String> errorParams) {
        this.errorParams = errorParams;
    }

    /** 
     * Accessor method to get the initial exception
     * @return The initial exception
     * */
    public Throwable getSource() {
        return this.source;
    }

    /** 
     * Accessor method to set the initial exception
     * @param  source the initial exception to set 
     */
    public void setSource(Throwable source) {
         this.source = source;
    }

    /**
     * The getDisplayMsg method will return the error message that needs to be
     * displayed in the default Locale.
     * @return The display message in default locale
     */
    public String getDisplayMsg() {
        return this.getDisplayMsg(Locale.getDefault());
    }

    /**
     * The getDisplayMsg method will return the error message that needs to be
     * displayed in the specified Locale.
     * @param  locale the locale to be used to return the message
     * @return The display message in the locale requested
     */
    public String getDisplayMsg(Locale locale) {
        return this.getMessage((null == locale) ? Locale.getDefault() : locale);
    }

    /**
     * The getLogMessage method will return the error message that needs to be
     * logged in the default Locale.
     * @return The log message in the default locale.
     */
    public String getLogMessage() {
        return this.getMessage(new Locale(Locale.ENGLISH.getLanguage(), Locale.US
                .getCountry()));
    }
    
    /**
     * This method will log the error message using US ENGLISH Locale.
     */
    public void log() {
        this.logger.error( this.getLogMessage());
    }
    
    /**
     * The getMessage method will return the error message in the default Locale.
     * @return The message in default locale
     * @see #getDisplayMsg()
     */
    @Override
	public String getMessage() {
        return this.getMessage(Locale.getDefault());
    }
    
    /**
     * Return the error message that needs to be
     * displayed in the specified Locale.
     * @return The display message in the locale requested
     * @see #getDisplayMsg()
     */
    @Override
	public String getLocalizedMessage() {
        return this.getMessage();
    }
    
    private String getMessage(Locale locale) {
        String formattedMsg = this.errorKey; //default to key if RB lookup fails
        try {
            ResourceBundle bundle = LocalizedRB.getResourceBundle(this.bundleName, locale);
            if ((this.errorParams != null) && (this.errorParams.size() > 0)) {
                formattedMsg = MessageFormat.format(bundle.getString(this.errorKey),
                        (Object[]) this.errorParams.toArray(new String[0]));
            } else {
                formattedMsg = bundle.getString(this.errorKey);
            }
        }
        catch (Exception e) { //Catch MissingResourceException etc to prevent exception msg lookup from causing an exception!
            this.logger.error("Error in resource bundle lookup for: " +this.errorKey);
        }
        return formattedMsg;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "VFIException [errorKey=" + this.errorKey + ", bundleName="
				+ this.bundleName + ", errorParams=" + this.errorParams + ",Throwable source="
				+ this.source + "]";
	}
}
