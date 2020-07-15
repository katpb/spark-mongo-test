package com.verifone.isd.vsms2.sys.util;

/**
 *  interface to retrieve environment settings for Sapphire.
 *  @author David Ezell "mailto:david_ezell@hp.com"
 *  @version 1.0
 */
public interface ISapphireEnv
{
    /**
     *  get the base IP Port for Sapphire NewPro
     *  @return an Integer representing the base port
     */
    public Integer getSapphireBaseIPPort();
    
    /**
     *  @return the String which describes this built version of the VM for this 
     *  application.
     */
    public String getVMAppVersion();
    
    /**
     *  @return the String which describes this version of SapphireClasses.zip
     */
    public String getSapphireClassesVersion();
    
    /**
     *  @param decryptThis a String to be decrypted
     *  @return a string decrypted using the Ruby Password algorithm
     */
    public String rubyDecrypt(String decryptThis);

    /**
     *  @param encryptThis a String to be encrypted
     *  @return a string encrypted using the Ruby Password algorithm
     */
    public String rubyEncrypt(String encryptThis);
    
    /**
     *  @param encText an encoded String to be decrypted
     *  @return a string decrypted using the Ruby Password algorithm
     */    
    public String rubyDecryptEncoded(String encText);
    
    /**
     *  @param plainText a String to be encrypted and encoded
     *  @param maxSize max size is allowed for this plainText
     *  @return a string encrypted using the Ruby Password algorithm and convert each character
     *  into hexString.
     */
    public String rubyEncryptAndEncode(String plainText, int maxSize);    
}