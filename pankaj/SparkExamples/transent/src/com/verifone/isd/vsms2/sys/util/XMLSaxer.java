/*-
 * Copyright (C) 2005 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Topaz version checking utility
 * Created July 12, 2005                                      David C. Brown
 *
 */

package com.verifone.isd.vsms2.sys.util;

import com.verifone.isd.vsms2.sys.util.sax.SAXFilter;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * This simple class associates the given input stream with the given
 * content handler and then invokes the parse of the XML document.  By
 * overriding the getInputSource() and getSAXFilter() methods the actual
 * object associated can be modified, inspected, etc.
 *
 * @version	1.0
 * @author	Based on Bhanu Narayanan/XMLUpdateMgr
 * @see		com.verifone.isd.vsms2.CGIPortal.XMLUpdateMgr
 * @since	production
 */

public class XMLSaxer {

	private	SAXFilter	sf;
	private InputSource	is;

	/**
	 * XML input source this class will associate with the content handler.
	 *
	 * @param	is
	 */

	public void setInputSource(InputSource is) {
		this.is = is;
	}

	/**
	 * SAX filter that does the parsing work, pulling from the input source
	 * we supply at parse time.
	 *
	 * @param	sf
	 */

	public void setSAXFilter(SAXFilter sf) {
		this.sf = sf;
	}

	/**
	 * Return the input source set earlier.  Also, this method furnishes
	 * the input source used by the perform() method.
	 *
	 * @return	InputSource
	 * @see		#perform
	 */

	public InputSource getInputSource() {
		return this.is;
	}

	/**
	 * Return the SAXFilter set earlier.  Also, this method furnishes the
	 * SAX Fitler used by the perform() method.
	 *
	 * @return	SAXFilter
	 * @see		#perform
	 */

	public SAXFilter getSAXFilter() {
		return this.sf;
	}

	/**
	 * This method simply associates the SAX Filter with the input source to
	 * parse the document, overriden methods can change how the association
	 * happens.  Any problems in the content handler will be passed back as
	 * an exception.
	 *
	 * NOTE that all work happens via side effect within the content handler.
	 *
	 * @exception Exception
	 */

	public void perform() throws Exception {
		getSAXFilter().parse(getInputSource());
	}
}
