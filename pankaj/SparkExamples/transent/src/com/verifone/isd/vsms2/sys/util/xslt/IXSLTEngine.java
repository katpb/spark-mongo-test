package com.verifone.isd.vsms2.sys.util.xslt;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;

/**
 * IXSLTEngine is the root interface for any XSLTEngine.
 * 
 * @author Sanjeev_S1
 */
public interface IXSLTEngine {

	String XSLT1_0_ENGINE = "XSLT1.0";

	/**
	 * Perform XSLT transformation by applying style sheet on a sourceXML file.
	 * Necessary parameters(String xslt parameter or DOM parameter) should be
	 * set before performing XSLT transformation.Namespaces should be used
	 * accordingly while setting any XSLT parameter.
	 * 
	 * @param srcXml
	 *            the sourceXML
	 * @param xsltData
	 *            the xslt data
	 * @return the input stream
	 * @throws TransformerException
	 *             the transformer exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	InputStream transform(Source srcXml, XSLTData xsltData)
			throws TransformerException, IOException;
}