package com.verifone.isd.vsms2.sys.util.xslt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A factory for creating XSLTEngine objects.
 * 
 * @author Sanjeev_S1
 */
public class XSLTEngineFactory {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(XSLTEngineFactory.class);

	/**
	 * The Enum XSLTEngineType.
	 */
	public enum XSLTEngineType {

		/** The default xslt. */
		DEFAULT_XSLT(IXSLTEngine.XSLT1_0_ENGINE, XalanXSLTEngineImpl.getXsltengine());

		/** The engine name. */
		private String engineName;

		/** The engine. */
		private IXSLTEngine engine;

		/**
		 * Gets the engine name.
		 * 
		 * @return the engineName
		 */
		public String getEngineName() {
			return this.engineName;
		}

		/**
		 * Gets the XSLT engine.
		 * 
		 * @return the engine
		 */
		public IXSLTEngine getEngine() {
			return this.engine;
		}

		/**
		 * Instantiates a new xSLT engine type.
		 * 
		 * @param engineName
		 *            the engine name
		 * @param engine
		 *            the engine
		 */
		XSLTEngineType(String engineName, IXSLTEngine engine) {
			this.engineName = engineName;
			this.engine = engine;
		}

		/**
		 * Gets the XSLT engine.
		 * 
		 * @param strVal
		 *            the str val
		 * @return the xSLT engine
		 */
		public static IXSLTEngine getXSLTEngine(XSLTEngineType engine) {
			if (engine != null) {
				for (XSLTEngineType engType : XSLTEngineType.values()) {
					if (engine.getEngineName().equalsIgnoreCase(engType.getEngineName())) {
						return engType.getEngine();
					}
				}
			}
			return null;
		}
	}

	/**
	 * Instantiates a new xSLT engine factory.
	 */
	private XSLTEngineFactory() {
		LOGGER.debug("XSLTEngineFactory instantiated.");
	}

	/**
	 * Builds the XSLTEngine.
	 * 
	 * @param xsltEngineType
	 *            the xslt engine type
	 * @return the iXSLT engine
	 */
	public static IXSLTEngine buildXSLTEngine(final XSLTEngineType engine) {
		return XSLTEngineType.getXSLTEngine(engine);
	}
}