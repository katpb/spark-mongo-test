package com.verifone.isd.vsms2.sys.util.sax;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.io.output.TeeOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import com.verifone.isd.vsms2.sys.util.CommonThreadPoolUtil;

/**
 * Class to perform schema validation.
 * @author MuditS1
 *
 */
public class PrivateSchemaValidator {

	private final String schemaForValidation;
	private final Logger logger = LoggerFactory.getLogger(SAXWriter.class);
	public PrivateSchemaValidator(String schemaForValidation) {
		this.schemaForValidation = schemaForValidation;
	}

	/**
	 * Set's up for schema validation and spawn a new thread to do schema validation
	 * so that client does not need to wait for response until schema validiton is done.
	 * @param realOutputStream
	 * @return TeeOutputStream
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	public OutputStream setupForValidation(final OutputStream realOutputStream) throws IOException, ParserConfigurationException {
		PipedInputStream pipedIS = new PipedInputStream();
		PipedOutputStream pipedOS = new PipedOutputStream();
		TeeOutputStream teeOutputStream = new TeeOutputStream(pipedOS, realOutputStream);
		try {
			pipedOS.connect(pipedIS);
		}
		catch (IOException ioe) {
			throw new ParserConfigurationException();
		}
		StreamSource input = new StreamSource(pipedIS);
		Runnable task = () -> {
			try {
				SchemaValidator schemaValidator = new SchemaValidator();
				schemaValidator.validateXml(schemaForValidation, input); 
			} catch (SAXException ex) { 
				logger.error("Exception while parsing for schema validation: ", ex);
			} 
		};
		CommonThreadPoolUtil.getInstance().execute(task);
		return teeOutputStream;
	}
}