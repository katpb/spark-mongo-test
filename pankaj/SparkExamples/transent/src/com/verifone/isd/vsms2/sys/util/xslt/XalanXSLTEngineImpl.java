package com.verifone.isd.vsms2.sys.util.xslt;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Semaphore;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;

import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;

/**
 * The Class XalanXSLTEngineImpl is XSLTEngine to perform XSLT transformation.
 * 
 * @author Sanjeev_S1
 */
public class XalanXSLTEngineImpl implements IXSLTEngine {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(XalanXSLTEngineImpl.class);

	/** The Constant xsltEngine. */
	private static final IXSLTEngine xsltEngine = new XalanXSLTEngineImpl();

	/**
	 * The Constant XSLT_SEMAPHORE_PERMITS is intentionally introduced to
	 * throttle the number of concurrent threads to perform XSLT transformation
	 * as it is CPU intensive.CPU and memory footprint were high if we allow too
	 * many threads.
	 */
	private static final String XSLT_SEMAPHORE_PERMITS = "2";

	/** The Constant XSLT_CONCURRENY_REQUESTS_LIMIT. */
	private static final String XSLT_CONCURRENY_REQUESTS_LIMIT = "xslt.concurrenyRequests.limit";

	/** The transformer. */
	private Transformer transformer;

	/** The xslt data holder which holds XSLT parameters. */
	private XSLTData xsltDataHolder;

	/** The xslt semaphore. */
	private Semaphore xsltSema4 = new Semaphore(
			Integer.parseInt(SysPropertyFactory.getProperty(
					XSLT_CONCURRENY_REQUESTS_LIMIT, XSLT_SEMAPHORE_PERMITS)),
			true);

	/**
	 * Instantiates a private XalanXSLTEngineImpl.
	 */
	private XalanXSLTEngineImpl() {
		LOGGER.debug("XalanXSLTEngineImpl instantiated.This supports only XSLT1.0 version, XPATH 1.0 version");
	}

	/**
	 * Gets the singleton xsltengine.
	 * 
	 * @return the xsltengine
	 */
	public static IXSLTEngine getXsltengine() {
		return xsltEngine;
	}

	/**
	 * Initialize transformer to apply stylesheet on a source XML file.
	 * 
	 * @throws TransformerException
	 *             the transformer exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private void initializeTransformer() throws TransformerException,
			IOException {
		if (this.isFileNameValid(this.xsltDataHolder.getXsltFileName())) {
			File xsltFile = new File(
					SysPropertyFactory.makeAbsolutePath(this.xsltDataHolder
							.getXsltFileName()));
			Source xslSource = new StreamSource(xsltFile);
			TransformerFactory transFact = new org.apache.xalan.processor.TransformerFactoryImpl();

			/**
			 * TransformerFactory.newInstance() usage is discouraged here as
			 * LINUX environment would pick up different implementation of
			 * TransformationFactory which would not be compatible to our
			 * existing style sheets.
			 */
			Templates translets = transFact.newTemplates(xslSource);
			if (null != translets) {
				this.transformer = translets.newTransformer();
				this.transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			} else {
				String excepMsg = "Template is null(XSLT may be invalid).Unable to create XSLT transformer";
				LOGGER.error(excepMsg);
				throw new IOException(excepMsg);
			}
			LOGGER.info("Xalan Transformer created succesfully.");
		} else {
			String excepMsg = "Transformer creation failed.Invalid XSLT File received";
			LOGGER.error(excepMsg);
			throw new IOException(excepMsg);
		}
	}

	@Override
	public InputStream transform(final Source srcXml, final XSLTData xsltData)
			throws TransformerException, IOException {
		this.xsltSema4.acquireUninterruptibly();
		LOGGER.debug("{} thread is accessing semaphore now", Thread
				.currentThread().getName());
		this.setXsltDataHolder(xsltData);
		this.initializeTransformer();
		InputStream inpStream = null;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		/** Set the XSLT DOM parameter. */
		this.setDOMParameter();
		/** Set the XSLT string parameter. */
		this.setXSLTStringParameter();
		try {
			if (null != this.transformer) {
				Result outputTarget = new StreamResult(outputStream);
				XalanErrorListenerImpl xalanErrorListenerImpl = new XalanErrorListenerImpl();
				this.transformer.setErrorListener(xalanErrorListenerImpl);
				this.transformer.transform(srcXml, outputTarget);

				/**
				 * StreamResult consoleResult = new StreamResult(new StringWriter()); 
				 * this.transformer.transform(srcXml, consoleResult); 
				 * LOGGER.debug(
				 * "**************Transformation OUTPUT displaying in console*****************\n\n{}"
				 * ,consoleResult.getWriter().toString());
				 **/

				if (xalanErrorListenerImpl.getException() != null) {
					LOGGER.error("Transformation Exception");
					throw new TransformerException("Transformation Exception");
				}
				this.transformer.reset();
				if (outputStream.size() > 0) {
					LOGGER.info("XSLT Transformation completed succesfully.");
					inpStream = new ByteArrayInputStream(
							outputStream.toByteArray());
				} else {
					LOGGER.error("XSLT transformation resulted in empty output.");
				}
			} else {
				throw new TransformerException("Transformer is NULL");
			}
		} catch (Exception e) {
			LOGGER.error("Error in XSLT transformation:'{}'", e);
		} finally {
			LOGGER.debug("{} thread is releasing semaphore now", Thread
					.currentThread().getName());
			this.xsltSema4.release();
		}
		return inpStream;
	}

	/**
	 * Sets the XSLT string parameter.
	 */
	private void setXSLTStringParameter() {
		if (null != this.xsltDataHolder.getStringParams()) {
			Iterator<Map.Entry<String, String>> xsltStringParamsiterator = this.xsltDataHolder
					.getStringParams().entrySet().iterator();
			while (xsltStringParamsiterator.hasNext()) {
				Map.Entry<String, String> pairs = xsltStringParamsiterator
						.next();
				LOGGER.info(
						"Setting the XSLT string parameter '{}' with value '{}'",
						pairs.getKey(), pairs.getValue());
				this.transformer.setParameter(pairs.getKey(), pairs.getValue());
			}
		}
	}

	/**
	 * Sets the XSLT DOM parameter.
	 */
	private void setDOMParameter() {
		if (null != this.xsltDataHolder.getDocParams()) {
			Iterator<Map.Entry<String, Document>> xsltDOMiterator = this.xsltDataHolder
					.getDocParams().entrySet().iterator();
			while (xsltDOMiterator.hasNext()) {
				Map.Entry<String, Document> pairs = xsltDOMiterator.next();
				LOGGER.info("Setting the DOM parameter '{}' with value '{}'",
						pairs.getKey(), pairs.getValue());
				this.transformer.setParameter(pairs.getKey(), pairs.getValue());
			}
		}
	}

	/**
	 * Sets the XSLTData holder.
	 * 
	 * @param xsltDataHolder
	 *            the new XSLTData holder
	 */
	private void setXsltDataHolder(final XSLTData xsltDataHolder) {
		this.xsltDataHolder = xsltDataHolder;
	}

	/**
	 * Checks if a file name is valid.
	 * 
	 * @param xsltFileName
	 *            the xslt file name
	 * @return true, if is file name valid
	 */
	private boolean isFileNameValid(final String xsltFileName) {
		File file = new File(xsltFileName);
		boolean isFileValid = false;
		try {
			if (file.exists()) {
				LOGGER.debug("File name '{}' is valid", xsltFileName);
				isFileValid = true;
			} else {
				throw new FileNotFoundException(xsltFileName);
			}
		} catch (IOException ioe) {
			LOGGER.error("File name '{}' is INVALID::'{}'", xsltFileName, ioe);
		}
		return isFileValid;
	}
}