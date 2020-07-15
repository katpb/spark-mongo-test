package com.verifone.isd.vsms2.sys.util;

/**
 * Exception thrown by IpHostnamevalidator if an invalid ip address or Hostname is given
 * @author suhailj1
 */

public class InvalidIpHostnameException extends java.lang.Exception {

	private static final long serialVersionUID = -8459515203452070391L;

	public InvalidIpHostnameException() {
		super("Invalid Ip Or Hostname Configuration");
	}
}
