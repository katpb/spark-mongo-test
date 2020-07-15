package com.verifone.isd.vsms2.sys.util.encrypt;

/**
 * Interface to the Sapphire NewPro encryption service daemon.
 * The daemon provides basic encryption service, isolating the
 * application from knowledge of encryption keys or encryption
 * algorithm.
 */
public interface IEncryptionService
{
    /**
     * method encrypt()
     * encrypt plainText using this EncryptionService algorithm and
     * key management scheme.
     * @param plainText String of data to be encrypted (plain text)
     * @return byte array of encrypted data (secure text)
	 * see also decrypt()
     */
    public byte[] encrypt(byte[] plainText) throws Exception;

    /**
     * method decrypt()
     * decrypt the supplied text previously encrypted by this class
     * of Encryption service.
     * @param secureText byte array of secure text previously encrypted by this
     * implementation.
     * @return decrypted plain text String
     * NB: Original plain text must have been a String.
     * @throws Exception exception returned by network or from error
     * reported by the encryption service daemon
     */
    public byte[] decrypt(byte[] secureText) throws Exception;

     /**
      * reEncrypt()
      * decrypt secureText encrypted with a recent key and then encrypt it
      * using the current key.
      * @param secureText byte array of previously encrypted dfata
      */
      public byte[] reEncrypt(byte[] secureText) throws Exception;     

      /**
      * method encryptToEncodedString
      * @param plainText
      * @return encrypted text encoded to printable ASCII
      */
     public char[] encryptAndEncode(char[] plainText) throws Exception;
     /**
      * method decryptFromEncodedString
      * @param encodedString from encryptToEncodedString
      * @return decrypted string
      */
     public char[] decryptEncodedData(char[] encodedString) throws Exception;
     
    /**
     * reEncrypt()
     * decrypt secureText encrypted with a recent key and then encrypt it
     * using the current key.
     * @param encodedBytes byte array of previously encrypted data encoded to bytes
     */
     public char[] reEncryptAndEncode(char[] encodedBytes) throws Exception;
     
     /**
     * method forceNewKey
     * force this Encryption service to stop using its current
     * encryption key.
     *
     * This method should be used if there is suspicion that the current
     * encryption key has been compromised.
     */
    public void forceNewKey() throws Exception;

}