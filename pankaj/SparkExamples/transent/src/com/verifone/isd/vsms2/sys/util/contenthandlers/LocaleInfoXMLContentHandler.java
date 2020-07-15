/*
 * 2017-04-10
 *
 * COPYRIGHT (c) 2017 by VeriFone Inc., All Rights Reserved.
 *
 *                       N O T I C E
 *
 * Under Federal copyright law, neither the software nor accompanying
 * documentation may be copied, photocopied, reproduced, translated,
 * or reduced to any electronic medium or machine-readable form, in
 * whole or in part, without the prior written consent of VeriFone Inc.,
 * except in the manner described in the documentation.
 */

package com.verifone.isd.vsms2.sys.util.contenthandlers;

import com.verifone.isd.vsms2.sys.util.sax.SAXContentHandler;
import com.verifone.isd.xml.vocabulary.IXMLVocabulary;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 *
 * @author T_JoswillP1 <t_joswillp1@verifone.com>
 */
public class LocaleInfoXMLContentHandler extends SAXContentHandler {
	private final Logger logger = LoggerFactory.getLogger(LocaleInfoXMLContentHandler.class);
	private boolean isRootFound = false;
	private final Properties prop;

	/**
	 * Constructor of the content Handler.
	 * 
	 * Note: do not add this content handler to the CGI Class-map the purpose of
	 * this handler is to be used only when topaz register the sapphire props to
	 * get also the locale information properties.
	 */
	public LocaleInfoXMLContentHandler(){
		prop = new Properties();
	}

	@Override
	public void startElement(String uri, String localName,
			String qName, Attributes atts) throws SAXException {
		if (!isRootFound) {
			if ((uri.equals(IXMLVocabulary.PRIMARY_NS))
			&& (localName.equals(IXMLVocabulary.LOCALE_INFO))) {
				isRootFound = true;
			} else {
				logger.error("Invalid root element: " + localName);
				throw new SAXException("Invalid root element: " +localName);
			}
		} else {
			if (IXMLVocabulary.PROPERTY.equals(localName)){
				String propName = atts.getValue(IXMLVocabulary.EMPTY_STRING,
						IXMLVocabulary.NAME);
				String value = atts.getValue(IXMLVocabulary.EMPTY_STRING,
						IXMLVocabulary.VALUE);
				if ((null != propName) && (!propName.isEmpty())){
					prop.setProperty(propName, value);
				} else {
					logger.error("Empty name attribute in property element.");
					throw new SAXException("Empty name attribute in property element.");
				}
			}
		}
	}

	/**
	 * Return the locale properties parsed from the XML document.
	 * 
	 * @return the locale properties parsed from the XML
	 */
	public Properties getProperties() {
		return prop;
	}
}
