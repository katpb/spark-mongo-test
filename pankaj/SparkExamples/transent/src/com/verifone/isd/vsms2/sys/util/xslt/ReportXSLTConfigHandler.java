package com.verifone.isd.vsms2.sys.util.xslt;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.xerces.parsers.SAXParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;
import com.verifone.isd.vsms2.sys.util.sax.SAXContentHandler;
import com.verifone.isd.vsms2.sys.util.sax.SAXFilter;
import com.verifone.isd.vsms2.sys.util.xslt.XSLTInputDetails.DOMInput;
import com.verifone.isd.vsms2.sys.util.xslt.XSLTInputDetails.SourceDocCGICmd;

/**
 * The Class ReportXSLTConfigHandler does the SAX parsing to read XSLT
 * ReportConfig file.
 * 
 * @author Sanjeev_S1
 */
public class ReportXSLTConfigHandler extends SAXContentHandler implements
		IXSLTVocabulary {

	/** The Constant LOGGER. */
	public static final Logger LOGGER = LoggerFactory
			.getLogger(ReportXSLTConfigHandler.class);

	/** The Constant REPTTRANS_CONFIG_INSTANCE. */
	public static final ReportXSLTConfigHandler REPTTRANS_CONFIG_INSTANCE = new ReportXSLTConfigHandler();

	/**
	 * The xsltInputPropMap holds every details retrieved through SAX parsing
	 * handler inner class.
	 */
	private Map<String, XSLTInputDetails> xsltInputPropMap;

	/** The root command name. */
	private String rootCommandName;

	/**
	 * The xsltConfigMap holds every details retrieved through this SAX parsing.
	 */
	private Map<String, XSLTInputDetails> xsltConfigMap = new HashMap<String, XSLTInputDetails>();

	/** The cur elem str. */
	private StringBuffer curElemStr;

	/** The XSLTInputDetails is having default visibility for inner classes. */
	XSLTInputDetails xsltInputDetails;

	/**
	 * Gets the REPTTRANS_CONFIG_INSTANCE.
	 * 
	 * @return the reportTransformConfig Instance.
	 */
	public static ReportXSLTConfigHandler getRepttransConfigInstance() {
		return ReportXSLTConfigHandler.REPTTRANS_CONFIG_INSTANCE;
	}

	/**
	 * Instantiates a new ReportXSLTConfigHandler.
	 */
	private ReportXSLTConfigHandler() {
		this.readXSLTPropertiesForReports();
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {

		if (this.curElemStr != null) {
			for (int i = start; i < (start + length); i++) {
				switch (ch[i]) {
				case '\\':
				case '"':
				case '\n':
				case '\r':
				case '\t':
					break;
				default:
					this.curElemStr.append(ch[i]);
					break;
				}
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (localName.equalsIgnoreCase(XSLFILENAME)) {
			this.xsltInputDetails.setXsltFileName(this.curElemStr.toString());
		} else if (localName.equalsIgnoreCase(NAMESPACE_VAL)) {
			this.xsltInputDetails.setXsltNamespace(this.curElemStr.toString());
		} else if (localName.equalsIgnoreCase(XSLT_PARAM_LIST)) {
			List<String> lst = Arrays.asList(this.curElemStr.toString().split(
					","));
			this.xsltInputDetails.setXsltStringParamsList(lst);
		} else if (localName.equalsIgnoreCase(ROOT_COMMAND)) {
			LOGGER.debug("XSLTInputDetails holds '{}'",
					this.xsltInputDetails.toString());
			this.xsltConfigMap.put(this.rootCommandName, this.xsltInputDetails);
			this.rootCommandName = null;
		}
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		this.curElemStr = new StringBuffer();
		if (qName.equalsIgnoreCase(ROOT_COMMAND)) {
			this.rootCommandName = attributes.getValue(COMMAND_NAME);
			this.xsltInputDetails = new XSLTInputDetails();
		} else if (qName.equalsIgnoreCase(SOURCEDOC)) {
			SourceDocCGICmdHandler srcDocCGICmdHandler = new SourceDocCGICmdHandler();
			this.navigate(srcDocCGICmdHandler, uri, localName, qName,
					attributes);
		} else if (qName.equalsIgnoreCase(DOM_PARAM_MAP)) {
			DOMInputHandler domInputHandler = new DOMInputHandler();
			this.navigate(domInputHandler, uri, localName, qName, attributes);
		}
	}

	/**
	 * The Class SourceDocCGICmdHandler is the handler intended for parsing
	 * source document related portion.
	 */
	class SourceDocCGICmdHandler extends SAXContentHandler {

		/** The src doc cgi cmd. */
		private SourceDocCGICmd srcDocCGICmd;

		/** The cur elem str. */
		private StringBuffer curElemStr;

		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			if (this.curElemStr != null) {
				for (int i = start; i < (start + length); i++) {
					switch (ch[i]) {
					case '\\':
					case '"':
					case '\n':
					case '\r':
					case '\t':
						break;
					default:
						this.curElemStr.append(ch[i]);
						break;
					}
				}
			}
		}

		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			this.curElemStr = new StringBuffer();
			if (qName.equalsIgnoreCase(SOURCEDOC)) {
				this.srcDocCGICmd = ReportXSLTConfigHandler.this.xsltInputDetails.new SourceDocCGICmd();
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			if (localName.equals(SRC_CGI_CMD)) {
				this.srcDocCGICmd.setName(this.curElemStr.toString());
			} else if (localName.equalsIgnoreCase(SRCDOC_QS)) {
				List<String> srcQsList = Arrays.asList(this.curElemStr
						.toString().split(","));
				this.srcDocCGICmd.setSourceDocQueryString(srcQsList);
			} else if (localName.equalsIgnoreCase(SOURCEDOC)) {
				ReportXSLTConfigHandler.this.xsltInputDetails
						.setSrcDocCGICmd(this.srcDocCGICmd);
			}
		}
	}

	/**
	 * The Class DOMInput is the handler intended for parsing DOM parameter
	 * related portion.
	 */
	class DOMInputHandler extends SAXContentHandler {

		/** The dom param name. */
		private String domParamName;

		/** The dom input src. */
		private DOMInput domInputSrc;

		/** The cur elem str. */
		private StringBuffer curElemStr;

		@Override
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			if (this.curElemStr != null) {
				for (int i = start; i < (start + length); i++) {
					switch (ch[i]) {
					case '\\':
					case '"':
					case '\n':
					case '\r':
					case '\t':
						break;
					default:
						this.curElemStr.append(ch[i]);
						break;
					}
				}
			}
		}

		@Override
		public void startElement(String uri, String localName, String qName,
				Attributes attributes) throws SAXException {
			this.curElemStr = new StringBuffer();
			if (qName.equalsIgnoreCase(DOM_PARAM)) {
				this.domParamName = attributes.getValue(DOM_COMMAND_NAME);
				this.domInputSrc = ReportXSLTConfigHandler.this.xsltInputDetails.new DOMInput();
			} else if (qName.equalsIgnoreCase(DOMASXMLPARAM)) {
				this.domParamName = attributes.getValue(DOM_COMMAND_NAME);
				this.domInputSrc = ReportXSLTConfigHandler.this.xsltInputDetails.new DOMInput();
			}
		}

		@Override
		public void endElement(String uri, String localName, String qName)
				throws SAXException {
			if (localName.equals(DOM_CGI_CMD)) {
				this.domInputSrc.setDomCGICmdName(this.curElemStr.toString());
			} else if (localName.equals(DOM_QS)) {
				List<String> domQsList = Arrays.asList(this.curElemStr
						.toString().split(","));
				this.domInputSrc.setDomQs(domQsList);
			} else if (localName.equals(DOMASXMLPARAM)) {
				this.domInputSrc.setXmlAsDom(this.curElemStr.toString());
				ReportXSLTConfigHandler.this.xsltInputDetails.getDomParamMap()
						.put(this.domParamName, this.domInputSrc);
			} else if (localName.equals(DOM_PARAM)) {
				ReportXSLTConfigHandler.this.xsltInputDetails.getDomParamMap()
						.put(this.domParamName, this.domInputSrc);
			}
		}
	}

	/**
	 * Gets the XSLT input property map.
	 * 
	 * @return the xsltInputPropMap
	 */
	public Map<String, XSLTInputDetails> getXsltInputPropMap() {
		return this.xsltInputPropMap;
	}

	/**
	 * Sets the XSLT input property map.
	 * 
	 * @param xsltInputPropMap
	 *            the xsltInputPropMap to set
	 */
	private void setXsltInputPropMap(
			final Map<String, XSLTInputDetails> xsltInputPropMap) {
		this.xsltInputPropMap = xsltInputPropMap;
	}

	/**
	 * Read XSLT properties for reports.
	 */
	@SuppressWarnings("boxing")
	private void readXSLTPropertiesForReports() {
		FileReader fr = null;
		try {
			this.xsltConfigMap.clear();
			/** clears existing entries. */
			File appFile = new File(
					SysPropertyFactory
							.makeAbsoluteConfigPath(XSLT_PROPERTY_FILE));
			fr = new FileReader(appFile);
			SAXFilter sf = new SAXFilter(new SAXParser(), this);
			sf.parse(new InputSource(fr));
			LOGGER.debug(
					"Setting the XSLT Config Property map with size = '{}'",
					this.xsltConfigMap.size());
			this.setXsltInputPropMap(this.xsltConfigMap);
		} catch (Exception e) {
			LOGGER.error(
					"Exception occured while invoking readXSLTPropertiesForReports():::'{}'",
					e);
		} finally {
			if (null != fr) {
				try {
					fr.close();
				} catch (IOException e) {
					LOGGER.error(
							"Exception ooccured while closing file reader {}'",
							e);
				}
			}
		}
	}

}