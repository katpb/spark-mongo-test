package com.verifone.isd.vsms2.sys.util;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyStore;
import java.util.HashMap;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;
import com.verifone.isd.vsms2.sys.util.channel.ssl.DefaultTrustManager;
import com.verifone.isd.vsms2.sys.util.channel.ssl.TrustDetails;

/**
 * This factory provides client and server sockets for the caller based on the IFSF
 * configuration. It can return SSL/Plain sockets based on the configuration.
 * 
 * @author KathirS1
 *
 */
public class SocketFactoryUtil {
	
	private static final Logger log = LoggerFactory.getLogger(SocketFactoryUtil.class.getName());
	private static SocketFactoryUtil  socketFactory = new SocketFactoryUtil();
	private static final String DEFAULT_KEYSTORE_DIR = "serverKeystoreDir";
	private static final String DEFAULT_KEYSTORE_FILENAME = "serverKeystore";
	private static final String DEFAULT_TRUSTSTORE_DIR = "trustStoreDir";
	private static final String DEFAULT_TRUSTSTORE_FILENAME = "trustStore";
	private static final String DEFAULT_PASSWORD = "123456";
	private static HashMap<String, SSLSocketFactory> sslClientSocketFactoryMap = new HashMap <String, SSLSocketFactory>();
	private static HashMap<String, SSLServerSocketFactory> sslServerSocketFactoryMap = new HashMap <String, SSLServerSocketFactory>();
	private static HashMap<String, TrustDetails> trustDetailsMap = new HashMap <String, TrustDetails>();
	
	public static synchronized SocketFactoryUtil getInstance(){
		if (socketFactory == null){
			socketFactory = new SocketFactoryUtil();
		}
		return socketFactory;	
	}

	/**
	 * This overloaded getClientSocket() method creates only plain TCP sockets for the
	 * passed port #. 
	 * 
	 * @param host
	 * @param port
	 * @return
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public Socket getClientSocket(String host, int port) throws UnknownHostException, IOException {
		if(port < 0 || port > 65536) {
			throw new IOException("Error creating client socket. Invalid port #: " + port);
		}
		return new Socket(host, port);
	}

	/**
	 * This overloaded getServerSocket() method creates only plain TCP sockets for the
	 * passed port #. 
	 * 
	 * @param port
	 * @return
	 * @throws UnknownHostException
	 * @throws IOException
	 */
	public ServerSocket getServerSocket(int port) throws UnknownHostException, IOException {
		if(port < 0 || port > 65536) {
			throw new IOException("Error creating server socket. Invalid port #: " + port);
		}
		return new ServerSocket(port);
	}
	
	/**
	 * Creates default SSL server socket.
	 * 
	 * @return
	 */
	public ServerSocket getDefaultServerSSLSocket() {
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
				} else {
					String password = getDefaultPassword();
					char[] passphrase = password.toCharArray();
					SSLContext context = SSLContext.getInstance("TLS");		         
					KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());//x509
					KeyStore ks = KeyStore.getInstance("JKS"); 		
					fileInputStream = new FileInputStream(keyStore);
					ks.load( fileInputStream , passphrase);			        	 
					kmf.init(ks, passphrase);
					context.init(kmf.getKeyManagers(), null, null);
					factory = context.getServerSocketFactory();
					sslServerSocketFactoryMap.put(keyStorePath, factory);
				}
			}
			serverSocket = factory.createServerSocket();
		} catch(Exception e){
			log.info("Exception occured while creating SSL server certificate."	+ e.getMessage());
		} finally {
			closeResource(fileInputStream);	         
		}
		return serverSocket;		
	}
	
	/**
	 * Creates default SSL client socket.
	 * 
	 * @param host
	 * @param port
	 * @return
	 */
	public Socket getDefaultClientSSLSocket(String host, int port) throws FileNotFoundException {
		Socket socket = null;
		
		File defaultTrustStore = new File(getDefaultTrustStoreLocation());

		String password = getDefaultPassword();

		if(!defaultTrustStore.exists()) {
			try{
				File defaultTrustStoreDir = verifyAndCreateDefaultTrustStoreDir();
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
					SSLContext context = SSLContext.getInstance("TLS");
					TrustDetails trustDetails = null;
					if (trustDetailsMap.containsKey(factoryKey)){
						trustDetails = (TrustDetails)trustDetailsMap.get(factoryKey);
					}else{
						KeyStore ks = null;
						InputStream in = null;
						try {
							//ks = KeyStore.getInstance(KeyStore.getDefaultType());
							ks = KeyStore.getInstance("JKS"); 
							// if the trust store file exists the load it to the TrustStore
							if (defaultTrustStore.isFile()) {
								in = new FileInputStream(defaultTrustStore);
								ks.load(in, password.toCharArray());
							}else {
								// else initialize the empty trustStore 
								ks.load(null,null);
							}
						}
						catch (Exception e) {
							throw e;
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
						trustDetails = new TrustDetails(defaultTrustManager, ks , defaultTrustStore,password);
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
		}catch(Exception e){
			log.info("Exception occured while creating SSL client socket."	+ e.getMessage());
		}	
		return socket;		
	}

	private static String getDefaultPassword() {
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
	
	/**
	 * Creates default trust store directory at ~\data\security\ when it doesn't exists.
	 */
	private static File verifyAndCreateDefaultTrustStoreDir() throws FileNotFoundException {
		//commented out the code for coverity fix.
		/*String securityDirPath = SysPropertyFactory.getAbsoluteSecurityPath();
		File securityDir = new File(securityDirPath);
		if (!securityDir.exists()) {
			securityDir.mkdirs();
		}*/ 
		
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

