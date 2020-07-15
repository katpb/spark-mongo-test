package com.verifone.isd.vsms2.sys.util;

import org.xml.sax.SAXException;

public class RequestNotSupportedException extends SAXException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public RequestNotSupportedException(String errorMsg){
		super(errorMsg);
	}

	public RequestNotSupportedException(){
		super();
	}
}
