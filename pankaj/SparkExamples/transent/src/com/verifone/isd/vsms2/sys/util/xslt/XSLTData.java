package com.verifone.isd.vsms2.sys.util.xslt;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.xml.transform.ErrorListener;

import org.w3c.dom.Document;

/**
 * The Class XSLTData holds the necessary data for XSLT transformation.
 * 
 * @author Sanjeev_S1
 */
public class XSLTData {

	/** The string params. */
	private Map <String, String> stringParams= new HashMap<String, String>();

	/** The doc params. */
	private Map <String, Document> docParams = new HashMap<String, Document>();

	/** The output params. */
	private Properties outputParams;

	/** The error listener. */
	private ErrorListener errorListener;

	/** The xslt file name. */
	private String xsltFileName;

	/**
	 * Gets the string params.
	 * 
	 * @return the stringParams
	 */
	public Map<String, String> getStringParams() {
		return this.stringParams;
	}

	/**
	 * Gets the doc params.
	 * 
	 * @return the docParams
	 */
	public Map<String, Document> getDocParams() {
		return this.docParams;
	}

	/**
	 * Gets the output params.
	 * 
	 * @return the outputParams
	 */
	public Properties getOutputParams() {
		return this.outputParams;
	}

	/**
	 * Gets the error listener.
	 * 
	 * @return the errorListener
	 */
	public ErrorListener getErrorListener() {
		return this.errorListener;
	}

	/**
	 * Gets the xslt file name.
	 * 
	 * @return the xsltFileName
	 */
	public String getXsltFileName() {
		return this.xsltFileName;
	}

	/**
	 * Sets the string params.
	 * 
	 * @param stringParams
	 *            the stringParams to set
	 */
	public void setStringParams(final Map<String, String> stringParams) {
		this.stringParams = stringParams;
	}

	/**
	 * Sets the doc params.
	 * 
	 * @param docParams
	 *            the docParams to set
	 */
	public void setDocParams(final Map<String, Document> docParams) {
		this.docParams = docParams;
	}

	/**
	 * Sets the output params.
	 * 
	 * @param outputParams
	 *            the outputParams to set
	 */
	public void setOutputParams(final Properties outputParams) {
		this.outputParams = outputParams;
	}

	/**
	 * Sets the error listener.
	 * 
	 * @param errorListener
	 *            the errorListener to set
	 */
	public void setErrorListener(final ErrorListener errorListener) {
		this.errorListener = errorListener;
	}

	/**
	 * Sets the xslt file name.
	 * 
	 * @param xsltFileName
	 *            the xsltFileName to set
	 */
	public void setXsltFileName(final String xsltFileName) {
		this.xsltFileName = xsltFileName;
	}

	@Override
	public String toString() {
		return "XSLTData [stringParams=" + this.stringParams + ", docParams="
		+ this.docParams + ", outputParams=" + this.outputParams
		+ ", errorListener=" + this.errorListener + ", xsltFileName="
		+ this.xsltFileName + "]";
	}
}