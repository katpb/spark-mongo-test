/*-
 * Copyright (C) 2005 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Topaz property file content handler
 * Created July 14, 2005                                      David C. Brown
 *
 */

package com.verifone.isd.vsms2.sys.util;

import com.verifone.isd.xml.vocabulary.IXMLVocabulary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.log4j.*;
import com.verifone.isd.vsms2.sys.util.sax.SAXContentHandler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import java.util.Properties;

/**
 * Each property entry is an element name and the property data is the
 * element data.  Simply construct a property entity based on the data.
 *
 * @author	David C. Brown
 * @version	1.0
 * @since	production
 */

public class PropHandler extends SAXContentHandler {

    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.util.PropHandler.class);
	private static final String	SAPP_DOMAIN = "domain:sapphireProperties";

	private Properties 	tprop;
	private int			elementCount;
	private boolean		elementOpen = false;
	private boolean		documentOpen = false;

	/**
	 * Start an empty property list.  When the content handler finishes
	 * we will have an instance of the Properties all ready to go.
	 */

	public PropHandler() {
		tprop = new Properties();
	}

	/** 
	 * Report back how many elements were encountered.
	 *
	 * @return	int
	 */

	public int getElementCount() {
		return elementCount;
	}

	/**
	 * We consider the document done if no elements are still open and
	 * the document itself is closed.  NOTE that we don't care about the
	 * test failing if the document hasn't even been started yet.
	 *
	 * @return	boolean
	 */

	public boolean isDocumentDone() {
		return !(elementOpen && documentOpen);
	}

	/**
	 * If the document is closed and there are no open elements return
	 * the Properties instance, otherwise return null.
	 *
	 * @return	Properties
	 */

	public Properties getProperties() {
		if (isDocumentDone()) {
			return tprop;
		} else {
			return null;
		}
	}

	/**
	 * When we first start the document set the processing flag for the
	 * document.  With each element set the element open flag, then stuff
	 * a property entry based on the element's name and the value will be
	 * whatever attribute the element has.
	 *
	 * @param		uri
	 * @param		localName
	 * @param		qName
	 * @param		atts
	 * @exception	SAXException
	 */

	public void startElement(String uri, String localName, String qName,
		Attributes atts) throws SAXException
	{
		String	propval;

		if (uri.equals(IXMLVocabulary.EMPTY_STRING)) {
			if (localName.equals(SAPP_DOMAIN)) {
				documentOpen = true;
				return;
			}

			/*-
			 * Skip over <site> and other element-based tags, just take
			 * tags with attributes for "value".
			 */

			propval = atts.getValue(IXMLVocabulary.EMPTY_STRING, "value");
			if (null == propval) {
				return;
			}

			elementOpen = true;
			tprop.setProperty(localName, propval);
		}
	}

	/**
	 * Simply update the properties count and property parse state flag each
	 * time we close an element.  When we find out the document closed we are
	 * done with the properties.
	 *
	 * @param		uri
	 * @param		localName
	 * @param		qName
	 * @exception	SAXException
	 */

	public void endElement(String uri, String localName, String qName) throws
		SAXException
	{
		if (uri.equals(IXMLVocabulary.EMPTY_STRING)) {
			if (localName.equals(SAPP_DOMAIN)) {
				documentOpen = false;
				return;
			}

			elementOpen = false;
			elementCount++;
		}
	}
}
