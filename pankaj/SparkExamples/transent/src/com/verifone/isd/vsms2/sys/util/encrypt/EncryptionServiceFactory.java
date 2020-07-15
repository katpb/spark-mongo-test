package com.verifone.isd.vsms2.sys.util.encrypt;

import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Factory to produce EncryptionService objects.  Presently, there is no need
 * to require the object to be a singleton.  However, the factory method is
 * used to preserve the capability to do that, and possibly to use other
 * selection criteria for selecting other implementation classes in the future.
 */
public class EncryptionServiceFactory
{
    /**
     * Application system property to specify JCA message digest type to use for password hashing.
     * <p>
     * Value of property is used for parameter to
     * {@link java.security.MessageDigest#getInstance(java.lang.String).
     * <p>
     * This means the value must conform to Java Cryptographic Architecture (JCA).
     * 
     * @see #DEFAULT_MESSAGE_DIGEST
     */
    public static final String MESSAGE_DIGEST_IMPL_PROPNAME = "security.pwd.messagedigest";

    /**
     * Default Message Digest type to use if not specified by application system properties.
     * Currently, this value is {@value #DEFAULT_MESSAGE_DIGEST}.
     */
    public static final String DEFAULT_MESSAGE_DIGEST = "SHA-256";

    private static final Logger LOGGER
            = LoggerFactory.getLogger(EncryptionServiceFactory.class);
    private static String encryptionServiceName = null;
    private static IEncryptionService service = null;
	private static String hashName = null;
	private static ISecureHash hash = null;
    /**
     * getEncryptionService
     * @return reference to an object that implements IEncryptionService
     * @throws java.lang.Exception on error in creating the encryption service using reflection
     */
    public static synchronized IEncryptionService getEncryptionService() throws Exception
    {
        if (service == null)
        {
            encryptionServiceName = SysPropertyFactory.getProperty("ENCRYPTION_SERVICE_NAME", "com.verifone.isd.vsms2.sys.util.encrypt.EncryptionService");
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info( "encryption service name="+encryptionServiceName);
            }
            service = (IEncryptionService) Class.forName(encryptionServiceName).newInstance();
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("Encryption Service Class instantiated OK");
            }
        }
        return(service);
    }
    /**
     * No public constructors needed
     */
    private EncryptionServiceFactory() 
    {
    }
	/**
	 * Factory method to get a secure hash.  The default hash is SHA-1.
	 * The initial use is for Passwords.
	 * By using this factory method, we can change to whatever algorithm we
	 * need in the future without breaking any code that uses this.
     *
     * @return ISecureHash implementation
     */
	public static synchronized ISecureHash getSecureHash() throws Exception
	{
		if (hash == null)
		{
			/*
			 * Changed default hash to Sha256, and removed Sha1 because
			 * of claimed weakness in Sha1 det 2007-11-07
			 */
		    hashName = SysPropertyFactory.getProperty("SECURE_HASH_NAME", Sha256.class.getName());
		    if (LOGGER.isInfoEnabled()) {
                LOGGER.info( "hash class name=" + hashName);
            }
		    hash = (ISecureHash) Class.forName(hashName).newInstance();
		    if (LOGGER.isInfoEnabled()) {
                LOGGER.info("Secure Hash Class instantiated OK");
            }
		}
		return(hash);
	}
    
    public static MessageDigest getMessageDigest() throws NoSuchAlgorithmException
    {
        String messageDigestImpl = SysPropertyFactory.getProperty(MESSAGE_DIGEST_IMPL_PROPNAME, DEFAULT_MESSAGE_DIGEST);
        return java.security.MessageDigest.getInstance(messageDigestImpl);
    }
    
}
