package com.verifone.isd.vsms2.sys.util.xslt;

/**
 * The Interface IXSLTVocabulary holds the xml tags/attribute names for easing the parse logic and property file name.
 * 
 * @author Sanjeev_S1
 */
public interface IXSLTVocabulary {

	/** The xslt property file. */
	String XSLT_PROPERTY_FILE = "ReportTransformXSLTConfig.xml";

	/** The xslt param list. */
	String XSLT_PARAM_LIST = "xsltParamList";

	/** The dom param map. */
	String DOM_PARAM_MAP = "domParamMap";

	/** The sourcedoc. */
	String SOURCEDOC = "sourceDoc";

	/** The namespace val. */
	String NAMESPACE_VAL = "ns_name";

	/** The xslfilename. */
	String XSLFILENAME = "xslfilename";

	/** The command name. */
	String COMMAND_NAME = "name";

	/** The dom command name. */
	String DOM_COMMAND_NAME = COMMAND_NAME;

	/** The root command. */
	String ROOT_COMMAND = "command";

	/** The dom cgi cmd. */
	String DOM_CGI_CMD = "domCGICmd";

	/** The domasxmlparam. */
	String DOMASXMLPARAM = "domXMLval";

	/** The dom querystring. */
	String DOM_QS = "queryString";

	/** The dom param. */
	String DOM_PARAM = "domParam";

	/** The srcdoc querystring. */
	String SRCDOC_QS = "qs";

	/** The src cgi cmd. */
	String SRC_CGI_CMD = "srcCGICmd";

}