package com.verifone.isd.vsms2.sys.util.encrypt;

/**
 *  interface to retrieve environment settings for Sapphire.
 *  @author David Ezell "mailto:david_ezell@hp.com"
 *  @version 1.0
 */
public interface ISecureHash
{
	/**
	 *  @param plainBytes a byte array to be hashed
	 *	@param first index of first byte to use for hash
	 *  @param len count of bytes to hash
	 *  @return Secure Hash as a hex coded string
	 */
	public String secureHash(byte[] plainBytes, int first, int len);
	/**
	 *  @param plainText a String to hash
	 *  @return Secure Hash as a hex coded string
	 */
	public String secureHash(String plainText);
}