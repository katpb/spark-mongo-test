package com.verifone.isd.vsms2.sys.util.sax;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Objects;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Class to validate the source xml with a schema.
 * @author MuditS1
 *
 */

public class SchemaValidator {

	private Logger logger = LoggerFactory.getLogger(SchemaValidator.class);


	/**
	 * Validates the xml with the schema located at absoluteFilePath.
	 * @param absoluteFilePath for schema
	 * @param xml to be validated against the schema
	 * @throws SAXParseException
	 */
	public void validateXml(String absoluteFilePath, StreamSource xml) throws SAXParseException {
		try {
			Handler handler = new Handler();

			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			schemaFactory.setErrorHandler(handler);
			//create a grammar object.
			Schema schemaGrammar = schemaFactory.newSchema(new File(absoluteFilePath));

			logger.debug("Created Grammar object for schema : {}", absoluteFilePath);

			Resolver resolver = new Resolver("\\");
			//create a validator to validate against grammar schema.
			Validator schemaValidator = schemaGrammar.newValidator();
			// Withheld from cr2468.01 pending further study: schemaValidator.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, ParserConstants.EXTERNAL_ACCESS_PROTOCOL_NONE);
			// Withheld from cr2468.01 pending further study: schemaValidator.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, ParserConstants.EXTERNAL_ACCESS_PROTOCOL_NONE);
			schemaValidator.setResourceResolver(resolver);
			schemaValidator.setErrorHandler(handler);

			logger.debug("Validating {} against grammar {}", xml, absoluteFilePath);
			//validate xml instance against the grammar.
			schemaValidator.validate(xml);
		}
		catch(FileNotFoundException fnefe) {
			logger.error("Schema not found {}", absoluteFilePath);
		}
		catch (SAXParseException spe) {
			throw spe;
		}
		catch(Exception e) {
			logger.error("Exception occured while validating xml", e);
		}
	}

	private class Handler extends DefaultHandler {

		/**
		 *
		 * @param sAXParseException
		 * @throws SAXException
		 */
	    @Override
		public void error(SAXParseException sAXParseException) throws SAXException {
			logger.error("Error occured", sAXParseException);
		}

		/**
		 *
		 * @param sAXParseException
		 * @throws SAXException
		 */
        @Override
		public void fatalError(SAXParseException sAXParseException) throws SAXException {
			logger.error("Fatal Error occured", sAXParseException);
		}

		/**
		 *
		 * @param sAXParseException
		 * @throws SAXException
		 */
        @Override
		public void warning(SAXParseException sAXParseException) throws org.xml.sax.SAXException {
			logger.warn("Warning", sAXParseException);
		}

	}

	private class Resolver implements LSResourceResolver{
		private String basePath;

		public Resolver(String basePath) {
			this.basePath = basePath;
		}

		@Override
		public LSInput resolveResource(String type, String namespaceURI, String publicId, String systemId, String baseURI) {
			InputStream resourceAsStream = this.getClass().getClassLoader()
					.getResourceAsStream(buildPath(systemId));
			Objects.requireNonNull(resourceAsStream, String.format("Could not find the specified xsd file: %s", systemId));
			return new Input(publicId, systemId, resourceAsStream);
		}

		private String buildPath(String systemId) {
			return basePath == null ? systemId : String.format("%s/%s", basePath, systemId);
		}

	}    
}
