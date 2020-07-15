package com.verifone.isd.vsms2.sys.util.encrypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.sys.util.Base64Coder;

public class CredentialUtility {
	private static final Logger logger = LoggerFactory.getLogger(CredentialUtility.class);    
	private static final String URANDOM_SCRIPT = "/dev/urandom";
	private final static SecureRandom secRand;
	public static final int TOKEN_SIZE = 40;
	public static final int COOKIE_SIZE = 32;
	
    static
    {
        java.security.SecureRandom tmpRand;
        try
        {
            tmpRand = java.security.SecureRandom.getInstance("SHA1PRNG");
        } catch (Exception e)
        {
            tmpRand = new java.security.SecureRandom();
        }
        secRand = tmpRand;
        secRand.setSeed(System.currentTimeMillis());
    }

	/**
	 * Delimiter used to separate salt string and hash of password with salt.
	 * <p>
	 * Because the salt and the salted hashed password string must be kept
	 * together, the internal storage class variable <i>passwd</i> contains the
	 * concatenation of the salt, the delimiter and the salted hashed password.
	 * 
	 * @see #getPassword()
	 * @see #getSalt()
	 * @see #setPassword(java.lang.String)
	 * @see #setPassword(java.lang.String, java.lang.String)
	 * @see CredentialUtility#hashRawPassword(java.lang.String, java.lang.String)
	 * @see CredentialUtility#makeNewHashedPassword(java.lang.String)
	 * 
	 */
	public static final char SALT_DELIMITER_CHAR = '$';

    // Use for size of byte array passed to SecureRandom.
    public static final int DEFAULT_SALTCREATION_SIZE = 8;
    
	public static String calculateCookie(int size) {
        // Calculate a cookie with a full 128 bits of entropy
        // Represented by 32 hex digits
        // /dev/urandom is cryptographically secure, and therefore preferred
        // over java.util.Random, but it can throw an exception, so
        // we use java.Util.Random as a backup.
        FileInputStream fis = null;
        StringBuffer sb = new StringBuffer(size);
        try {
            fis = new FileInputStream(new File(URANDOM_SCRIPT));
            for (int i=0; i < size/8; ++i) {
                int next = fis.read();
                for (int j=0; j < 3; ++j) {
                    next <<= 8;
                    next |= fis.read();
                }
                sb.append(Integer.toHexString(next));
            }
        } catch (IOException ex) {
            // Just user random instead
            Random r = new Random(new Date().getTime());
            for (int i=0; i < size/8; ++i) {
                sb.append(Integer.toHexString(r.nextInt()));
            }
        }
        finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch(Exception ex) {};
            }
        }
        return(sb.toString());
    }
    
    /**
     * Create a new salted hash of plain text password string.
     * @param rawPassword The plain text password to be hashed.
     * @return A string concatenated with a new random salt, delimiter and salted hashed password.
     * @throws UnsupportedEncodingException If character set is not found.
     * @throws NoSuchAlgorithmException If the hashing digest implementation is not found.
     */
    public final static String makeNewHashedPassword(String rawPassword) throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
		secRand.setSeed(System.currentTimeMillis());
        String salt = createNewSalt(secRand);
        String hashedPW = hashRawPassword(salt, rawPassword);

        StringBuilder sb = new StringBuilder();
        sb.append(salt);
        sb.append(SALT_DELIMITER_CHAR);
        sb.append(hashedPW);
        return sb.toString();
    }

    /**
     * Create a secure random string to be used to create a new salted hashed password.
     * @return Random string of Base64 characters. 
     */
    public final static String createNewSalt(SecureRandom secRand)
    {
        byte[] saltBytes = new byte[DEFAULT_SALTCREATION_SIZE];
        secRand.nextBytes(saltBytes);
        String retVal = Base64Coder.encode(saltBytes, false);
        return retVal;
    }

    /**
     * Hash a plain text string with provided salt.
     * @param salt The salt to prime the hashing digest.
     * @param rawPassword The plain text string to hash with the primed hashing digest.
     * @return The salted hash of the plain text parameter <i>rawPassword</i>.
     * @throws UnsupportedEncodingException Thrown if encoding character set is not installed.
     * @throws NoSuchAlgorithmException  Thrown if the request hashing digest is not found.
     * 
     * @see #getSalt()
     * @see #makeNewHashedPassword(java.lang.String)
     */
    public final static String hashRawPassword(String salt, String rawPassword) throws UnsupportedEncodingException, NoSuchAlgorithmException
    {
        String retVal;
        if (!salt.isEmpty())
        {
            MessageDigest md = EncryptionServiceFactory.getMessageDigest();
            md.reset();
            md.update(salt.getBytes("US-ASCII"));
            md.update(rawPassword.getBytes("US-ASCII"));
            byte[] theDigest = md.digest();

            retVal = Base64Coder.encode(theDigest, false);
        } else
        {
            try
            {
                retVal = EncryptionServiceFactory.getSecureHash().secureHash(rawPassword);
            } catch (Exception ex)
            {
                retVal = rawPassword;
                logger.error("Unable to hash string!");
            }
        }
        return retVal;
    }
}
