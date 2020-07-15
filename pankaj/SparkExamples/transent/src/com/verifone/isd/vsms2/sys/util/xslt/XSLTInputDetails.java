package com.verifone.isd.vsms2.sys.util.xslt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Class XSLTInputDetails is the data structure to hold details while
 * reading from the XSLT_PROPERTY_FILE property file.
 * 
 * @author Sanjeev_S1
 */
public class XSLTInputDetails {

	/** The dom param map. */
	private Map<String, DOMInput> domParamMap = new HashMap<String, DOMInput>();
	/** domParamterName is the key. */

	private SourceDocCGICmd srcDocCGICmd;

	/** The xslt file name. */
	private String xsltFileName;

	/** The xslt namespace. */
	private String xsltNamespace;

	/** The xslt string params list. */
	private List<String> xsltStringParamsList;

	/**
	 * The Class DOMInput.
	 */
	public class DOMInput {

		/** The dom cgi cmd name. */
		private String domCGICmdName;

		/** The querystring list to retrieve DOM parameter. */
		private List<String> domQs;

		/** The xml as dom. */
		private String xmlAsDom;

		/**
		 * @return the xmlAsDom
		 */
		public String getXmlAsDom() {
			return this.xmlAsDom;
		}

		/**
		 * @param xmlAsDom
		 *            the xmlAsDom to set
		 */
		public void setXmlAsDom(String xmlAsDom) {
			this.xmlAsDom = xmlAsDom;
		}

		/**
		 * Gets the dom cgi cmd name.
		 * 
		 * @return the domCGICmdName
		 */
		public String getDomCGICmdName() {
			return this.domCGICmdName;
		}

		/**
		 * Gets the querystring list to obtain a DOm parameter through CGI
		 * request.
		 * 
		 * @return the domQs
		 */
		public List<String> getDomQs() {
			return this.domQs;
		}

		/**
		 * Sets the dom cgi cmd name.
		 * 
		 * @param domCGICmdName
		 *            the domCGICmdName to set
		 */
		public void setDomCGICmdName(final String domCGICmdName) {
			this.domCGICmdName = domCGICmdName;
		}

		/**
		 * Sets the querystring list to retrieve DOM parameter.
		 * 
		 * @param domQs
		 *            the domQs to set
		 */
		public void setDomQs(final List<String> domQs) {
			this.domQs = domQs;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "DOMInput [domCGICmdName=" + this.domCGICmdName + ", domQs="
					+ this.domQs + ", xmlAsDom=" + this.xmlAsDom + "]";
		}

	}

	/**
	 * The Class SourceDocCGICmd.
	 */
	public class SourceDocCGICmd {

		/** The name. */
		private String name;

		/** The querystring list to retrieve sourceXML. */
		private List<String> srcDocQueryString;

		/**
		 * Gets the name.
		 * 
		 * @return the name
		 */
		public String getName() {
			return this.name;
		}

		/**
		 * Gets the source doc query string.
		 * 
		 * @return the srcDocQueryString
		 */
		public List<String> getSourceDocQueryString() {
			return this.srcDocQueryString;
		}

		/**
		 * Sets the name.
		 * 
		 * @param name
		 *            the name to set
		 */
		public void setName(final String name) {
			this.name = name;
		}

		/**
		 * Sets the source doc query string.
		 * 
		 * @param srcDocQueryString
		 *            the srcDocQueryString to set
		 */
		public void setSourceDocQueryString(
				final List<String> sourceDocQueryString) {
			this.srcDocQueryString = sourceDocQueryString;
		}

		@Override
		public String toString() {
			return "SourceDocCGICmd [name=" + this.name
					+ ", srcDocQueryString=" + this.srcDocQueryString + "]";
		}
	}

	/**
	 * Gets the dom param map.
	 * 
	 * @return the domParamMap
	 */
	public Map<String, DOMInput> getDomParamMap() {
		return this.domParamMap;
	}

	/**
	 * Gets the domParamterName is the key.
	 * 
	 * @return the srcDocCGICmd
	 */
	public SourceDocCGICmd getSrcDocCGICmd() {
		return this.srcDocCGICmd;
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
	 * Gets the xslt namespace.
	 * 
	 * @return the xsltNamespace
	 */
	public String getXsltNamespace() {
		return this.xsltNamespace;
	}

	/**
	 * Gets the xslt string params list.
	 * 
	 * @return the xsltStringParamsList
	 */
	public List<String> getXsltStringParamsList() {
		return this.xsltStringParamsList;
	}

	/**
	 * Sets the domParamterName is the key.
	 * 
	 * @param srcDocCGICmd
	 *            the srcDocCGICmd to set
	 */
	public void setSrcDocCGICmd(final SourceDocCGICmd srcDocCGICmd) {
		this.srcDocCGICmd = srcDocCGICmd;
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

	/**
	 * Sets the xslt namespace.
	 * 
	 * @param xsltNamespace
	 *            the xsltNamespace to set
	 */
	public void setXsltNamespace(final String xsltNamespace) {
		this.xsltNamespace = xsltNamespace;
	}

	/**
	 * Sets the xslt string params list.
	 * 
	 * @param xsltStrPrmLst
	 *            the xsltStringParamsList to set
	 */
	public void setXsltStringParamsList(final List<String> xsltStrPrmLst) {
		this.xsltStringParamsList = xsltStrPrmLst;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "XSLTInputDetails [domParamMap=" + this.domParamMap
				+ ", srcDocCGICmd=" + this.srcDocCGICmd + ", xsltFileName="
				+ this.xsltFileName + ", xsltNamespace=" + this.xsltNamespace
				+ ", xsltStringParamsList=" + this.xsltStringParamsList + "]";
	}
	
}