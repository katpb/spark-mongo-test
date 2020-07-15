package com.verifone.isd.vsms2.sys.util.channel.ssl;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Date;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;

/**
 * This class generates SSL Server certificate and stores it at default location, if there
 * is no certificate already. It uses CertAndKeyGen from 'sun\security\tools\keytool' package 
 * which was moved from 'sun\security\x509' package recently with Java8. <b>Hence this class is 
 * compatible with Java8 only. </b>
 *
 * Currently this class will be invoked from home/topaz/bin/startapp script file.
 * 
 * @author KathirS1
 *
 */
public class SSLUtil {

	private static final Logger logger = LoggerFactory.getLogger(SSLUtil.class.getName());
	private static final String LOG4J_PROPERTIES_PATH = "config/log4j.prop";
	
	private static final String DEFAULT_KEYSTORE_DIR = "serverKeystoreDir";
	private static final String DEFAULT_KEYSTORE_FILENAME = "serverKeystore";
	
	private static final String CERTANDKEYGEN_CLASSNAME = "sun.security.tools.keytool.CertAndKeyGen";
	private static final String X500NAME_CLASSNAME = "sun.security.x509.X500Name";
	private static SSLUtil myInstance;

	private SSLUtil() {
	}

	public static synchronized SSLUtil getInstance() {
		if (myInstance == null) {
			myInstance = new SSLUtil();
		}
		return myInstance;
	}

	/**
	 * Creates self signed certificate and stores it.
	 * @return
	 */
	private int createSelfSignedCertificate() {
		int result = 1;
		CertificateDetails certificateDetails = new CertificateDetails();
		FileOutputStream fileOutputStream = null;
		String keyStorePassWord = null;
		try{

			// Create Keystore
			Class<?> certAndKeyGenClass = getCertAndKeyGenClass();
			Constructor<?> constructor = certAndKeyGenClass.getDeclaredConstructor(String.class, String.class);
			Object keyPairObj = constructor.newInstance(certificateDetails.getKeyPairGeneratorAlgorithm(), certificateDetails.getSignatureAlgorithm());
			Method generate = keyPairObj.getClass().getMethod("generate", int.class);
			generate.invoke(keyPairObj, certificateDetails.getKeySize());
			Object x500NameObj = getX500NameObject(certificateDetails);
			X509Certificate[] chain = new X509Certificate[1];
			chain[0] = (X509Certificate) (keyPairObj.getClass().getMethod("getSelfCertificate", x500NameObj.getClass(), Date.class, long.class)
					.invoke(keyPairObj, x500NameObj, new Date(),(long) certificateDetails.getValidity() * 24 * 60 * 60));
			logger.debug("Self Signed Certificate Created.");

			// Store Keystore
			keyStorePassWord = certificateDetails.getPassword();
			PrivateKey privKey = getPrivateKey(keyPairObj);
			KeyStore keyStore = KeyStore.getInstance("JKS");
			keyStore.load(null, null);
			keyStore.setKeyEntry(certificateDetails.getAlias(), privKey, keyStorePassWord.toCharArray(), chain);
			fileOutputStream = new FileOutputStream(getDefaultKeystoreFilePath());
			keyStore.store(fileOutputStream, keyStorePassWord.toCharArray());
			logger.debug("Self Signed Certificate Stored at "+getDefaultKeystoreFilePath());

			result = 0;
		}catch (Exception exception){
			logger.error("Exception occurred while creating certificate.", exception.getMessage());
		}finally{
			closeResource(fileOutputStream);
		}
		return result;
	}

	/**
	 * Creates keystore at default directory.
	 * @throws IOException
	 */
	private void createKeystoreDir() throws IOException {
		File defaultKeyStoreDir = new File(getDefaultKeystoreDirectory());
		if (!defaultKeyStoreDir.exists()) {
			boolean dirCreated = defaultKeyStoreDir.mkdirs();
			if(!dirCreated) {
				logger.error("Unable to create key store directory.");
				throw new IOException();
			}
		}
	}

	/**
	 * Checks if self signed certificate exists already.
	 * @return
	 */
	private boolean isKeystoreExists() {
		File defaultKeyStoreDir = new File(getDefaultKeystoreDirectory());
		if (defaultKeyStoreDir.exists()) {
			File keystore = new File(getDefaultKeystoreFilePath());
			if (keystore != null && keystore.exists()) {
				logger.info("Default server certificate exist already.");
				return true;
			}
		}
		return false;
	}

	/**
	 * Closes passed resource.
	 * @param resource
	 */
	private void closeResource(Closeable resource) {
		if (resource != null) {
			try {
				resource.close();
			} catch (IOException e) {
			}
		}
	}
	
	/**
	 * @return Qualified keystore directory path '~/data/security/serverKeystoreDir'.
	 */
	private String getDefaultKeystoreDirectory() {
		return SysPropertyFactory.getAbsoluteSecurityPath() + File.separator + DEFAULT_KEYSTORE_DIR;
	}
	
	/**
	 * @return Qualified keystore file path '~/data/security/serverKeystoreDir/serverKeystore'.
	 */
	private String getDefaultKeystoreFilePath() {
		return getDefaultKeystoreDirectory() + File.separator + DEFAULT_KEYSTORE_FILENAME;
	}

	/**
	 * This method will return 'CertAndKeyGen' Class using reflection. In Java8 the package 'sun\security\x509' which was containing this
	 * class is moved to different location (sun\security\tools\keytool) with additional access restriction. To overcome this restriction 
	 * we are using reflection.
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 */
	private Class<?> getCertAndKeyGenClass() throws ClassNotFoundException {
		Class<?> certAndKeyGenClass = null;
		try {
			certAndKeyGenClass = Class.forName(CERTANDKEYGEN_CLASSNAME);
		} catch (ClassNotFoundException cnfe01) {
			logger.error("Could not find CertAndKeyGen class used for certificate generation");
			throw cnfe01;
		}
		return certAndKeyGenClass;
	}

	/**
	 * Constructs a name from fields common in Internet application environments. 
	 * @param certificateDetails
	 * @return
	 * @throws Exception 
	 */
	private Object getX500NameObject(CertificateDetails certificateDetails) throws Exception {
		try {
			Class<?> x500NameClass = Class.forName(X500NAME_CLASSNAME);
			Constructor<?> constructor = x500NameClass.getDeclaredConstructor(
					String.class, String.class, String.class, String.class,
					String.class, String.class);
			return constructor.newInstance(
					certificateDetails.getCommonName(),
					certificateDetails.getOrganizationalUnit(),
					certificateDetails.getOrganization(),
					certificateDetails.getCity(),
					certificateDetails.getState(),
					certificateDetails.getCountry());
		} catch (Exception exception) {
			logger.error("Exception occured while creating 'sun.security.x509.X500Name' object.", exception.getMessage());
			throw exception;
		}
	}

	/**
	 * 
	 * @param keyPair
	 * @return
	 * @throws Exception
	 */
	private PrivateKey getPrivateKey(Object keyPair) throws Exception {
		try {
			Class<?> klass = keyPair.getClass();
			Method method = klass.getMethod("getPrivateKey");
			return (PrivateKey) method.invoke(keyPair);
		} catch (Exception exception) {
			logger.error("Exception occured while creating private key.",
					exception.getMessage());
			throw exception;
		}
	}

	public static void main(String[] args) {
		PropertyConfigurator.configureAndWatch(LOG4J_PROPERTIES_PATH, 60000);
		System.exit(SSLUtil.getInstance().createServerKeyStore());
	}

	public int createServerKeyStore() {
		if (!this.isKeystoreExists()) {
			try {
				this.createKeystoreDir();
			} catch (IOException e) {
				logger.info("Exception occured while creating certificate - {}", e.getMessage());
				return 1;
			}
			return this.createSelfSignedCertificate();
		}
		return 0;
	}
}
