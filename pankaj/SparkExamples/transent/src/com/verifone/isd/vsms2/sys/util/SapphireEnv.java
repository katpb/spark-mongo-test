package com.verifone.isd.vsms2.sys.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  static class to retrieve environment settings for Sapphire.
 *  The current implementation uses JNI calls to get values from
 *  a C header file which is shared with the Ruby system.
 *  @author David Ezell "mailto:david_ezell@hp.com"
 *  @version 1.0
 */
public class SapphireEnv implements ISapphireEnv 
{
    private Logger logger = LoggerFactory.getLogger(SapphireEnv.class);
    static SapphireEnv theInstance = null;
    private static final boolean LIB_LOADED;

    private static final String VERSION = "1.0.1";
    private static final String PAD_ZERO_STRING = "00";
    private static final int BASE_PORT = 9000;
    /**
     *  private default constructor for the singleton class
     */
    private SapphireEnv() {} 
    
    /**
     *  @return the interface to the singleton Instance
     *  @see ISapphireEnv
     */
    static public synchronized ISapphireEnv getInstance() 
    {
        if (theInstance == null)
            theInstance = new SapphireEnv();
        return theInstance;
    }
    
    
    @Override
    public Integer getSapphireBaseIPPort()
    {
        return (LIB_LOADED) ? rSapphireBaseIPPort() : new Integer(BASE_PORT);
    }
  
    @Override
    public String getVMAppVersion()
    {
        return (LIB_LOADED) ? rVMAppVersion() : VERSION;
    }
    
    @Override
    public String getSapphireClassesVersion()
    {
        return VERSION;
    }
    
    @Override
    public String rubyDecrypt(String decryptThis)
    {
        return (LIB_LOADED) ? rCDecrypt(decryptThis) : decryptThis;
    }
    
    @Override
    public String rubyEncrypt(String encryptThis)
    {
        return (LIB_LOADED) ? rCEncrypt(encryptThis) : encryptThis;
    }
    
    @Override
    public String rubyEncryptAndEncode(String plainText, int maxSize) {        
        String encTxt = rubyEncrypt((plainText == null) ?
        "" : plainText);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; i < encTxt.length(); i++) {
            int ch = (int)encTxt.charAt(i);
            sb.append(Integer.toHexString(ch));
        }
        for (; i < maxSize; i++) {
            sb.append(PAD_ZERO_STRING);
        }
        return sb.toString();
    }
    
    /* Assumption: The data should be processed 2 chars together and therefore, encText
     * will always be of even length
     */
    @Override
    public String rubyDecryptEncoded(String encText) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < encText.length(); i+=2) {
            String tmpCh = encText.substring(i,i+2);
            if (tmpCh.equals(PAD_ZERO_STRING)) {
                //EOD - if last 2 chars are 0 padding
                break;
            }
            int ch = Integer.valueOf(tmpCh, 16).intValue();
            sb.append((char)ch);
        }        
        return rubyDecrypt(sb.toString());
    }    
    
    static {
        /**
         * For running under NT, this code tries to find a .dll in the jniNT directory
         * If it doesn't exist, we must be on Apogee where the JNI code is linked into
         * the VM.
         */
        boolean loaded = false;
        try {
            String s = "SapphireEnv";
            System.loadLibrary(s);
            LoggerFactory.getLogger(SapphireEnv.class)
			                .info("loading shared library for SapphireEnv:  "+s);
            loaded = true;
        }
        catch (UnsatisfiedLinkError e)
        {
        }
        finally {
            LIB_LOADED = loaded;
        }
    }

    private native Integer rSapphireBaseIPPort();
    private native String rVMAppVersion();
    private native String rCEncrypt(String encryptThis);
    private native String rCDecrypt(String decryptThis);    
}
