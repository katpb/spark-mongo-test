package com.verifone.isd.vsms2.sys.util.xslt;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.TransformerException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class XalanErrorListenerImpl is the errorlistener class whenever there is
 * an error encountered during xalan transformation.
 * 
 * @author Sanjeev_S1
 * 
 */
public class XalanErrorListenerImpl implements ErrorListener {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(XalanErrorListenerImpl.class);

	/** The exception. */
	private TransformerException exception;

	/**
	 * Gets the exception.
	 * 
	 * @return the exception
	 */
	public TransformerException getException() {
		return this.exception;
	}

	@Override
	public void error(TransformerException exception) {
		this.exception = exception;
		LOGGER.error("TransformerException", exception);
	}

	@Override
	public void fatalError(TransformerException exception) {
		this.exception = exception;
		LOGGER.error("TransformerException", exception);
	}

	@Override
	public void warning(TransformerException exception) {
		this.exception = exception;
		LOGGER.error("TransformerException", exception);
	}
}
