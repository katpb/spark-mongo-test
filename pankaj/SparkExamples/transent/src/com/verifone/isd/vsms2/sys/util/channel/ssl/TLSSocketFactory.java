/**
 * 
 */
package com.verifone.isd.vsms2.sys.util.channel.ssl;

import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
//import javax.security.cert.X509Certificate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;


/**
 * This factory provides SSL client and server sockets for the caller.
 * 
 * @author T_ShivrajS1
 *
 */
public class TLSSocketFactory implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4702879186293638024L;

	private static final Logger log = LoggerFactory.getLogger(TLSSocketFactory.class.getName());
	
	private static TLSSocketFactory  tlsSocketFactory = new TLSSocketFactory();

	private static final String KEYSTORE_TYPE = "JKS";
	private static final String PROTOCOL = "TLS";
	private static final String DEFAULT_KEYSTORE_DIR = "serverKeystoreDir";
	private static final String DEFAULT_KEYSTORE_FILENAME = "serverKeystore";
	private static final String DEFAULT_TRUSTSTORE_DIR = "trustStoreDir";
	private static final String DEFAULT_TRUSTSTORE_FILENAME = "trustStore";
	private static final String DEFAULT_TRUSTSTORE_DCR_FILENAME = "trustStoreDcr";
	private static final String DEFUALT_GILBARCO_CERTIFICATE_DIR = "/home/fcc/data/security/";
	private static final StringBuffer DEFAULT_PASSWORD = new StringBuffer("123456");
	private static final String Gilbarco_Alias_gvr1 = "gvr1";
	private static final String Gilbarco_Alias_gvr2 = "gvr2";
	private static final String GILBARCO_PRODUCTION_CERTIFICATE_NAME = "M11671BP05001.crt";
	private static final String GILBARCO_TEST_CERTIFICATE_NAME = "M11671BD05001.crt";
	private static HashMap<String, SSLSocketFactory> sslClientSocketFactoryMap = new HashMap <String, SSLSocketFactory>();
	private static HashMap<String, SSLServerSocketFactory> sslServerSocketFactoryMap = new HashMap <String, SSLServerSocketFactory>();
	private static HashMap<String, TrustDetails> trustDetailsMap = new HashMap <String, TrustDetails>();
	private static HashMap<String, SSLSocketFactory> sslClientDcrSocketFactoryMap = new HashMap <String, SSLSocketFactory>();
	private static HashMap<String, SSLServerSocketFactory> sslServerDcrSocketFactoryMap = new HashMap <String, SSLServerSocketFactory>();
	private static HashMap<String, TrustDetails> trustDcrDetailsMap = new HashMap <String, TrustDetails>();
	
	public static synchronized TLSSocketFactory getInstance(){
		if (tlsSocketFactory == null){
			tlsSocketFactory = new TLSSocketFactory();
		}
		return tlsSocketFactory;	
	}
	
	/**
	 * This method will create and return SSL server socket with default backlog(how many connections are queued).
	 * 
	 * @param port
	 * @return
	 * @throws IOException
	 */
	public ServerSocket getServerSocket(int port) throws IOException {
		return getServerSocket(port, 0);
	}
	
	/**
	 * This method will create and return SSL server socket with passed backlog(how many connections are queued).
	 * 
	 * @param port
	 * @return
	 * @throws IOException
	 */
	public ServerSocket getServerSocket(int port, int backlog) throws IOException {
		ServerSocket ssocket;
		ssocket = createDefaultServerSSLSocket(port, backlog);
		if(ssocket != null) {
			log.info("Server is running on secured port: {}", port);
		}
		if(ssocket == null) {
			throw new IOException("Error creating server socket. Socket null.");
		}
		return ssocket;
	}

	/**
	 * This method will create and return SSL client socket.
	 * 
	 * @param host
	 * @param port
	 * @return
	 * @throws Exception
	 */
	public Socket getClientSocket(String host, int port) throws Exception {
		Socket socket;
		socket = createDefaultClientSSLSocket(host, port);
		if(socket != null){ 
			log.info("We are currently connected to :" + host + " on secure port :" 
					+ port + " from: " + socket.getLocalAddress().getHostAddress() + " source port:" + socket.getLocalPort());
		}
		else { 
			throw new IOException("Error creating client socket. Socket null.");
		}
		return socket;
	}
	
	/**
	 * Creates default SSL client socket.
	 * 
	 * @param host
	 * @param port
	 * @return
	 * @throws Exception
	 */
	private Socket createDefaultClientSSLSocket(String host, int port) throws Exception {
		Socket socket = null;
		
		File defaultTrustStore = new File(getDefaultTrustStoreLocation());
		StringBuffer password = getDefaultPassword();

		if(!defaultTrustStore.exists()) {
			try{
				File defaultTrustStoreDir = verifyAndCreateDefaultTrustStoreDir();
				log.info("Default trustStore directory is - {}", defaultTrustStoreDir);
			}catch(FileNotFoundException fnf){
				log.info("Failed to created trust store directory" );
				return socket;
			}
		}
		try{
			SSLSocketFactory factory;
			String factoryKey = defaultTrustStore.getAbsolutePath();
			synchronized(sslClientSocketFactoryMap){
				if (sslClientSocketFactoryMap.containsKey(factoryKey)){
					factory = (SSLSocketFactory)sslClientSocketFactoryMap.get(factoryKey);
				}else{
					SSLContext context = SSLContext.getInstance(PROTOCOL);
					TrustDetails trustDetails = null;
					if (trustDetailsMap.containsKey(factoryKey)){
						trustDetails = (TrustDetails)trustDetailsMap.get(factoryKey);
					}else{
						KeyStore ks = null;
						InputStream in = null;
						try {
							ks = KeyStore.getInstance(KEYSTORE_TYPE);
							// if the trust store file exists then load it to the TrustStore
							if (defaultTrustStore.isFile()) {
								in = new FileInputStream(defaultTrustStore);
								ks.load(in, password.toString().toCharArray());
							}else {
								// else initialize the empty trustStore 
								ks.load(null,null);
							}
						}
						catch (CertificateException ex) {
							log.error("Error loading keystore - {}", ex.getMessage());
							return null;
						}finally {
							closeResource(in);
						}
						TrustManagerFactory tmf = TrustManagerFactory
								.getInstance(TrustManagerFactory.getDefaultAlgorithm());
						tmf.init(ks);

						TrustManager tms [] = tmf.getTrustManagers();
						X509TrustManager defaultTrustManager = null; 

						/*
						 * Iterate over the returned trustmanagers, look
						 * for an instance of X509TrustManager.  If found,
						 * use that as our "default" trust manager.
						 */
						for (int i = 0; i < tms.length; i++) {
							if (tms[i] instanceof X509TrustManager) {
								defaultTrustManager = (X509TrustManager) tms[i];
								
								break;
							}
						}
						trustDetails = new TrustDetails(defaultTrustManager, ks , defaultTrustStore, password.toString());
						trustDetailsMap.put(factoryKey , trustDetails);					
					}
					DefaultTrustManager tm = new DefaultTrustManager(trustDetails);
					tm.setInstallNewCertificate(true);        
					tm.setTrustall(true);
					context.init(null, new TrustManager[] { tm }, null);
					factory = context.getSocketFactory();
					sslClientSocketFactoryMap.put(factoryKey, factory);
				}
			}
			socket = factory.createSocket(host, port);
		} catch(KeyManagementException ex){
			log.error("Exception occured while creating SSL client socket. - {}", ex.getMessage());
		} catch (NoSuchAlgorithmException ex) {
			log.error("Exception occured while creating SSL client socket. - {}", ex.getMessage());
		} catch (KeyStoreException ex) {
			log.error("Exception occured while creating SSL client socket. - {}", ex.getMessage());
		} catch (Exception ex) {
			log.error("Exception occured while creating SSL client socket. - {}", ex.getMessage());
			throw ex;
		}
		return socket;		
	}

	/**
	 * This method will create and return SSL client socket for use by DCR's.
	 * 
	 * @param host
	 * @param port
	 * @param secure
	 * @return
	 * @throws Exception
	 */
	public Socket getClientSocket(String host, int port, boolean secure) throws Exception {
		Socket socket = null;
		File defaultTrustDcrStore = new File(getDefaultTrustStoreDir()+ File.separator + DEFAULT_TRUSTSTORE_DCR_FILENAME);

		if(!defaultTrustDcrStore.exists()) {
			try{
				File defaultTrustStoreDir = verifyAndCreateDefaultTrustStoreDir();
				log.info("Default Dcr trustStore directory is - {}", defaultTrustStoreDir);
			}catch(FileNotFoundException fnf){
				log.info("Failed to create Dcr trust store directory" );
				return socket;
			}
		}

		socket = createDefaultClientDcrSSLSocket(host, port);
		if(socket != null){ 
			log.info("We are currently connected to DCR :" + host + " on secure port :" 
					+ port + " from: " + socket.getLocalAddress().getHostAddress() + " source port:" + socket.getLocalPort());
		}
		else { 
			throw new IOException("Error creating client socket. DCR socket null.");
		}
		return socket;
	}

	/**
	 * Creates default SSL client socket for DCR with certificate validation.
	 * 
	 * @param host
	 * @param port
	 * @return
	 * @throws Exception
	 */
	private Socket createDefaultClientDcrSSLSocket(String host, int port) throws Exception {
		Socket socket = null;
		File defaultTrustStoreDcr = new File(getDefaultDcrTrustStoreLocation());
		StringBuffer password = getDefaultPassword();
		
		// Checks if dcr trust file exists.  Creates empty trust if not, and loads certificates.
		loadCertsToDcrTrustStore(GILBARCO_PRODUCTION_CERTIFICATE_NAME, password, Gilbarco_Alias_gvr1);
		loadCertsToDcrTrustStore(GILBARCO_TEST_CERTIFICATE_NAME, password, Gilbarco_Alias_gvr2);
					
		try{
			SSLSocketFactory factory;
			String factoryKey = defaultTrustStoreDcr.getAbsolutePath();

			synchronized(sslClientDcrSocketFactoryMap){

				if (sslClientDcrSocketFactoryMap.containsKey(factoryKey)){
					factory = (SSLSocketFactory)sslClientDcrSocketFactoryMap.get(factoryKey);
					log.debug("sslClientDcrSocketFactoryMap size = {}", sslClientDcrSocketFactoryMap.size() );
				} else {
					SSLContext context = SSLContext.getInstance(PROTOCOL);
					TrustDetails trustDcrDetails = null;

					if (trustDcrDetailsMap.containsKey(factoryKey)){
						trustDcrDetails = (TrustDetails)trustDcrDetailsMap.get(factoryKey);
						log.debug("trustDcrDetailsMap has the key, map size = {}", trustDcrDetailsMap.size() );
					} else {
						log.debug("createDefaultClientDcrSSLSocket: factorykey not found in either map, load from dcr trust store");						
						KeyStore ks = null;
						InputStream in = null;
						try {
							ks = KeyStore.getInstance(KEYSTORE_TYPE);
							// if the trust store file exists then load it to the TrustStore
							if (defaultTrustStoreDcr.isFile()) {
								in = new FileInputStream(defaultTrustStoreDcr);
								ks.load(in, password.toString().toCharArray());
							} else {
								// else initialize the empty trustStore 
								ks.load(null,null);
							}
						}
						catch (CertificateException ex) {
							log.error("Error loading keystore - {}", ex.getMessage());
							return null;
						} finally {
							closeResource(in);
						}
						TrustManagerFactory tmf = TrustManagerFactory
								.getInstance(TrustManagerFactory.getDefaultAlgorithm());
						tmf.init(ks);					

						TrustManager tms [] = tmf.getTrustManagers();
						X509TrustManager defaultDcrTrustManager = null; 

						/*
						 * Iterate over the returned trustmanagers, look
						 * for an instance of X509TrustManager.  If found,
						 * use that as our "default" trust manager.
						 */
						int t = 0;
						for (int i = 0; i < tms.length; i++) {
							if (tms[i] instanceof X509TrustManager) {
								defaultDcrTrustManager = (X509TrustManager) tms[i];
								break;
							}
						}
						trustDcrDetails = new TrustDetails(defaultDcrTrustManager, ks , defaultTrustStoreDcr, password.toString());
						trustDcrDetailsMap.put(factoryKey , trustDcrDetails);					
					}
					DcrTrustManager tmDcr = new DcrTrustManager(trustDcrDetails);
					tmDcr.setInstallNewDcrCertificate(false);        
					tmDcr.setDcrTrustall(false);
					context.init(null, new TrustManager[] { tmDcr }, null);
					factory = context.getSocketFactory();
					sslClientDcrSocketFactoryMap.put(factoryKey, factory);
				}
			}
			socket = factory.createSocket(host, port);

			/* getSessions() seems to trigger the eventual checkServerTrusted() 
			 * call in DcrTrustManager.j which verifies the CRIND supplied 
			 * certificate chain against the local dcrTrustStore contents
			*/
	        SSLSession session = ((SSLSocket) socket).getSession();

	        //commented section saved for future debugging purposes
/*	        Certificate[] cchain = session.getPeerCertificates();
         	log.debug("The Certificates used by peer");
        	for (int i = 0; i < cchain.length; i++) {
        		log.debug("i={}, {}", i, ((X509Certificate) cchain[i]).getSubjectDN());
        	}
			log.debug("Peer host is " + session.getPeerHost());
			log.debug("Cipher is " + session.getCipherSuite());
			log.debug("Protocol is " + session.getProtocol());
			log.debug("ID is " + new BigInteger(session.getId()));
			log.debug("Session created in " + session.getCreationTime());
			log.debug("Session accessed in " + session.getLastAccessedTime());
*/
		} catch(KeyManagementException kme){
			log.error("Exception occured while creating DCR SSL client socket. - {}", kme.getMessage());
		} catch (NoSuchAlgorithmException nsae) {
			log.error("Exception occured while creating DCR SSL client socket. - {}", nsae.getMessage());
		} catch (KeyStoreException kse) {
			log.error("Exception occured while creating DCR SSL client socket. - {}", kse.getMessage());
		} catch (Exception e) {
			log.error("Exception occured while creating DCR SSL client socket. - {}", e.getMessage());
			throw e;
		}

		return socket;		
	}	


	private void loadCertsToDcrTrustStore(String certificateName, StringBuffer password, String alias) {
		
		InputStream in = null;
		FileOutputStream out = null;
    	File keystoreFile = null;	
		File defaultTrustStoreDcr = new File(getDefaultDcrTrustStoreLocation());
		CertificateFactory cf;
		
		try {
			KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());

			// if dcrTrustFile already exists then load it
			if (defaultTrustStoreDcr.isFile()) {
				in = new FileInputStream(defaultTrustStoreDcr);
				keystore.load(in, password.toString().toCharArray());
			} else {  // create new empty trust store
				keystore.load(null, null);
			}

			//if alias of cert to be added already exists then don't add again
			if (keystore.isCertificateEntry(alias)) {
				log.debug("Certificate alias {} already exists in truststore", alias);

			} else {  //need to add certificate to trust store
				log.debug("certificate to be added: {}", DEFUALT_GILBARCO_CERTIFICATE_DIR + certificateName);
				keystoreFile = new File(getDefaultDcrTrustStoreLocation());
				cf = CertificateFactory.getInstance("X.509");
				InputStream certstream =  addCertificateStream(DEFUALT_GILBARCO_CERTIFICATE_DIR + certificateName);
				Certificate certs =  cf.generateCertificate(certstream);
				// Add the certificate
				keystore.setCertificateEntry(alias, certs);
				// Save the new keystore contents
				out = new FileOutputStream(keystoreFile);
				keystore.store(out, password.toString().toCharArray());
				log.debug("keystore size {}", keystore.size());
			}
		
		} catch (FileNotFoundException fnfe) {
			log.error("File not found exception: {}", fnfe.getMessage());
		} catch (CertificateException ce) {
			log.error("Certificate Exception: {}", ce.getMessage());
		} catch (KeyStoreException kse) {
			log.error("KeyStore Exception: {}", kse.getMessage());
		} catch (IOException ioe) {
			log.error("IO Exception: {}", ioe.getMessage());
		} catch (NoSuchAlgorithmException nsae) {
			log.error("NoSuchAlgorithm Exception: {}", nsae.getMessage());
		} catch (Exception e) {
			log.error("General exception: {}", e.getMessage());
		} finally {
			closeResource(in);
			closeResource(out);
		}
	}
	
    private InputStream addCertificateStream(String certfile) throws IOException {

    	FileInputStream fis = null;
		DataInputStream dis = null;
		ByteArrayInputStream bais = null;
    	try {
	    	fis = new FileInputStream(certfile);
			dis = new DataInputStream(fis);
			byte[] bytes = new byte[dis.available()];
			dis.readFully(bytes);
			bais = new ByteArrayInputStream(bytes);
    	} catch (FileNotFoundException fnfe) {
    		
    	} catch (IOException ioe) {
    		
    	}
    	finally {
			closeResource(fis);
			closeResource(dis);
    	}
		return bais;
	}
	
	/**
	 * Creates default SSL server socket with passed backlog(how many connections are queued).
	 * 
	 * @param port
	 * @param backlog
	 * @return
	 */
	private ServerSocket createDefaultServerSSLSocket(int port, int backlog) {
		ServerSocket serverSocket = null;
		FileInputStream fileInputStream = null;
		try{
			String keyStorePath = getDefaultKeyStoreLocation();
			File keyStore = new File(keyStorePath);
			if(!keyStore.exists()) {
				throw new Exception("Error: No SSL server certificates found..");
			}

			SSLServerSocketFactory factory;
			synchronized(sslServerSocketFactoryMap){
				if (sslServerSocketFactoryMap.containsKey(keyStorePath)){
					factory = (SSLServerSocketFactory)sslServerSocketFactoryMap.get(keyStorePath);
				}else{
					KeyManagerFactory kmf;
					KeyStore ks;
					char[] passphrase = getDefaultPassword().toString().toCharArray();
					SSLContext context = SSLContext.getInstance(PROTOCOL);
					kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());//x509
					ks = KeyStore.getInstance(KEYSTORE_TYPE);
					fileInputStream = new FileInputStream(keyStore);
					ks.load( fileInputStream , passphrase);			        	 
					kmf.init(ks, passphrase);
					context.init(kmf.getKeyManagers(), null, null);
					factory = context.getServerSocketFactory();
					sslServerSocketFactoryMap.put(keyStorePath, factory);
				}    
			}
			if(backlog > 0){
				serverSocket = factory.createServerSocket(port, backlog);
			} else {
				serverSocket = factory.createServerSocket(port);
			}
			
		}catch(Exception e){
			log.error("Exception occured while creating SSL server socket: "	+ e.getMessage());
		}finally{
			closeResource(fileInputStream);	         
		}
		return serverSocket;		
	}
	
	private static StringBuffer getDefaultPassword() {
		return DEFAULT_PASSWORD;
	}
	
	private static String getDefaultKeyStoreLocation() {
		return (SysPropertyFactory.getAbsoluteSecurityPath() + File.separator + 
				DEFAULT_KEYSTORE_DIR + File.separator + DEFAULT_KEYSTORE_FILENAME);
	}
	
	private static String getDefaultTrustStoreLocation() {
		return (getDefaultTrustStoreDir() + File.separator + DEFAULT_TRUSTSTORE_FILENAME);
	}
	
	private static String getDefaultTrustStoreDir() {
		return (SysPropertyFactory.getAbsoluteSecurityPath() + File.separator + 
				DEFAULT_TRUSTSTORE_DIR);
	}

	private static String getDefaultDcrTrustStoreLocation() {
		return (getDefaultTrustStoreDir() + File.separator + DEFAULT_TRUSTSTORE_DCR_FILENAME);
	}	
	
	/**
	 * Creates default trust store directory at ~\data\security\ when it doesn't exists.
	 */
	private static File verifyAndCreateDefaultTrustStoreDir() throws FileNotFoundException {
		
		String defaultTrustStoreDirPath = getDefaultTrustStoreDir();
		File defaultTrustStoreDir = new File(defaultTrustStoreDirPath);
		if (!defaultTrustStoreDir.exists()) {
			boolean created = defaultTrustStoreDir.mkdirs();
			if(!created){
				throw new FileNotFoundException("Trust store could not be created..");
			}
		}
		return defaultTrustStoreDir;
	}
	
	private static void closeResource(Closeable resource) {
		if (resource != null) {
			try {
				resource.close();
			} catch (IOException e) {
			}
		}
	}
	
}
