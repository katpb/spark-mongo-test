package com.verifone.isd.vsms2.sys.util.encrypt;

import java.net.InetAddress;
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.UnknownHostException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Interface to the Sapphire NewPro encryption service daemon.
 * The daemon provides basic encryption service, isolating the
 * application from knowledge of encryption keys or encryption
 * algorithm.
 *
 * refer to isdSys/os/lynxUtils/src/encryptd/encapi.h for interface 
 * constant definitions.
 */
class EncryptionService implements IEncryptionService
{
    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.util.encrypt.EncryptionService.class);
    // Important constants for the AES-128 encryption service daemon
    private static final int blockSize = 16;
    private static final int extraLen = 8; // Embedded length and index values
	private static final String localHost = "127.0.0.1";
	private static final int encryptPort = 8905;

	private static final byte doEncrypt = 1;
	private static final byte doDecrypt = 2;
	private static final byte reEncrypt = 3;
	private static final byte changeKey = 4;
	// Not likely used by Java Application code
	private static final byte shutDown = 5;

	public static final byte ENCR_NO_ERROR =      0;	// Success
	public static final byte ENCR_MSG_SIZE =      1;	// Plain text data length is > ENCR_PLAIN_MAX,
								                        // or is less than 1 byte.
	public static final byte ENCR_INVALID_DATALEN=2;	// Decrypted datalength does not match remainder
								                        // of the packet.  Probably a decryption error.
	public static final byte ENCR_INVALID_DATA =  3;	// Data could not be decrypted properly.
	public static final byte ENCR_INVALID_FNC =   4;	// Function requested not defined.
	public static final byte ENCR_IO_FAIL =       5;	// The function failed due to an I/O error
	private InetAddress localHostAddress;

    /**
     * Default Constructor
     * Should only be used by Factory Method
     * @see EncryptionServiceFactory
     */
    EncryptionService() throws UnknownHostException
    {
        localHostAddress = InetAddress.getByName(localHost);
    }

    /**
     * encryptBytes()
     * encrypt plainText using the implemented EncryptionService algorithm and
     * key management scheme.
     * @param plainText byte array of data to be encrypted (plain text)
     * @return byte array of encrypted data (secure text)
     */
    public byte[] encrypt(byte[] plainText) throws Exception
    {
        if (null == plainText || plainText.length == 0) {
            return new byte[0];
        }
        DatagramSocket udpSocket = null;
    	try {
    		 udpSocket = new DatagramSocket();
    		udpSocket.setSoTimeout(5000);
    		byte [] msg = new byte[plainText.length + 2];
    		System.arraycopy(plainText, 0, msg, 2, plainText.length);
    		msg[0] = doEncrypt;
    		msg[1] = 0;
    		DatagramPacket dgram = new DatagramPacket(msg, msg.length,
    				localHostAddress, encryptPort);
    		// encrypted data includes original plain text, plus 4 bytes of length
    		// then after the encryption, 4 more bytes are embedded
    		// and as always, the two byte header is added.
            int padLen = (plainText.length + 4) % blockSize;
            padLen = (0 != padLen) ? blockSize - padLen : padLen;
    		int replyLenMax = msg.length + padLen + extraLen;
    		byte[] replyMsg = new byte[replyLenMax];
    		DatagramPacket response = new DatagramPacket(replyMsg, replyMsg.length);
    		udpSocket.send(dgram);
    		udpSocket.receive(response);
    		if (replyMsg[1] != ENCR_NO_ERROR)
    		{
    			throw new Exception("Encryption Service Daemon error=" + replyMsg[1]);
    		}
    		int dataLen = response.getLength() - 2;
    		byte[] result = new byte[dataLen];
    		System.arraycopy(replyMsg, 2, result, 0, dataLen);
    		return(result);
		}
		catch (Exception e) {
            logger.error("Encrypt error", e);
            throw e;
        } finally{
            if (null != udpSocket) {
                udpSocket.close();
            }
        }
    }
    /**
     * method encryptToEncodedString
     * @param plainText
     * @return encrypted text encoded to printable ASCII
     */
    public char[] encryptAndEncode(char[] plainText) throws Exception
    {
        int len = (null == plainText) ? 0 : plainText.length;
    	byte[] raw = new byte[len];
        for (int i = 0; i < len; i++) {
            raw[i] = (byte)plainText[i];
        }
    	return encode(encrypt(raw));
    }
    /**
     * method decryptFromEncodedString
     * @param encodedString from encryptToEncodedString
     * @return decrypted string
     */
    public char[] decryptEncodedData(char[] encodedString) throws Exception
    {
    	// logger.debug( "ENCR: decrypting encoded string "+encodedString);
    	byte[] byteRes = this.decrypt(this.decode(encodedString), doDecrypt);
    	char[] result = new char[byteRes.length];
        for (int i = 0; i < byteRes.length; i++) {
            result[i] = (char)byteRes[i];
            byteRes[i] = (byte)0;
        }
        return result;
    }
    
    /**
     * method decryptToBytes()
     * decrypt the supplied text previously encrypted by this class
     * of Encryption service.
     * @param secureText byte array of secure text previously encrypted by this
     * implementation.
     * @return decrypted plain text bytes
     * @throws Exception exception returned by network or from error
     * reported by the encryption service daemon
     * see also decryptToString
     */
    public byte[] decrypt(byte[] secureText) throws Exception
    {
        return(decrypt(secureText, doDecrypt));
    }

    /**
     * decrypt, or re-encrypt depending mode
     * @param text bytes to decrypt or re-encrypt
     * @param mode = doDecrypt or reEncrypt
     */
        
    private byte[] decrypt(byte[] text, byte mode) throws Exception
    {
        if (null == text || text.length == 0) {
            return new byte[0];
        }        
        DatagramSocket udpSocket = null;
        try {
            udpSocket = new DatagramSocket();
            udpSocket.setSoTimeout(5000);
            byte [] msg = new byte[text.length + 2];
            System.arraycopy(text, 0, msg, 2, text.length);
            msg[0] = mode;
            msg[1] = 0;
            DatagramPacket dgram = new DatagramPacket(msg, msg.length,
                    localHostAddress, encryptPort);
            // encrypted data includes original plain text, plus 4 bytes of length
            // then after the encryption, 4 more bytes are embedded
            // and as always, the two byte header is added.
            int replyLenMax = text.length;    // The reply can be smaller, but not larger
            byte[] replyMsg = new byte[replyLenMax];
            DatagramPacket response = new DatagramPacket(replyMsg, replyMsg.length);
            udpSocket.send(dgram);
            udpSocket.receive(response);
            if (replyMsg[1] != ENCR_NO_ERROR) {
                throw new Exception("Encryption Service Daemon error=" + replyMsg[1]);
            }
            int dataLen = response.getLength() - 2;
            byte[] result = new byte[dataLen];
            System.arraycopy(replyMsg, 2, result, 0, dataLen);
            //Clear the local buffer
            int len = replyMsg.length;
            for (int i = 0; i < len; i++) {
                replyMsg[i] = (byte)0;
            }
            return(result);
        }
        finally {
            if (null != udpSocket) {
                udpSocket.close();
            }
        }        
    }

    /**
     * method forceNewKey
     * force this Encryption service to stop using its current
     * encryption key.
     *
     * This method should be used if there is suspicion that the current
     * encryption key has been compromised.
     * The application should also the re-encrypt all sensitive data.
     *
     */
    public void forceNewKey() throws Exception
    {
        byte[] msg = new byte[2];
        msg[0] = changeKey;
        msg[1] = 0;
        byte[] replyMsg = new byte[2];
        DatagramSocket udpSocket = null;
        
        try {
            udpSocket = new DatagramSocket();
            udpSocket.setSoTimeout(5000);
            DatagramPacket dgram = new DatagramPacket(msg, msg.length,
                    localHostAddress, encryptPort);
            DatagramPacket response = new DatagramPacket(replyMsg, replyMsg.length);
            udpSocket.send(dgram);
            udpSocket.receive(response);
            if (replyMsg[1] != ENCR_NO_ERROR) {
                throw new Exception("Encryption Service Daemon error=" + replyMsg[1]);
            }
        }
        finally {
            if (null != udpSocket)
            udpSocket.close();            
        }
    }
    /**
     * reEncrypt()
     * decrypt secureText encrypted with a recent key and then encrypt it
     * using the current key.
     * @param secureText byte array of previously encrypted data
     * @return byte array re-encrypted using the current key
     */
    public byte[] reEncrypt(byte[] secureText) throws Exception
    {
        return(decrypt(secureText, reEncrypt));
    }
    /**
     * reEncrypt()
     * decrypt secureText encrypted with a recent key and then encrypt it
     * using the current key.
     * @param secureText as returned by encryptToEncodedBytes()
     * @return byte array re-encrypted using the current key
     */
    public char[] reEncryptAndEncode(char[] secureText) throws Exception
    {
    	byte[] tmp = decode(secureText);
    	byte[] tmp2 = reEncrypt(tmp);
        return(encode(tmp2));
    }
    /**
     * forward and reverse transformations to force encrypted data into a
     * legitimate string.
     * This implementation is temporary while we wait to find the XERCESE solution.
     */
    private char[] encode(byte[] value) {
        int len = (null == value) ? 0 : value.length;
        char[] charArr = new char[2*len];
        for (int i = 0, j = 0; i < len; ++i)
        {
            int foo = value[i];
            charArr[j++] = (char) ('A' + (0x0F & (foo >> 4)));
            charArr[j++] = (char) ('A' + (foo & 0x0F));
        }
        return charArr;
    }

    private byte[] decode(char[] value)
    {
        // NB: an odd length in is invalid and will cause
        // an Array out of bounds exception (unchecked)
        int len = (null == value) ? 0 : (value.length) ;
        byte[] r = new byte[len/2];
        for (int i = 0, j = 0; i < len; ++j)
        {
            int foo = (int)value[i++];
            foo -= 'A';
            foo &= 0x0F;
            foo <<= 4;
            int bar = (int)value[i++];
            bar -= 'A';
            bar &= 0x0F;
            r[j] = (byte) (foo | bar);
        }
        return(r);
    }    
}
