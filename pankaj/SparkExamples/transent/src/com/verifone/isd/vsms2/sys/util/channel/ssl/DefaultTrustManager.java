package com.verifone.isd.vsms2.sys.util.channel.ssl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultTrustManager implements X509TrustManager{

	private TrustDetails trustDetails;
	private static final Logger log = LoggerFactory.getLogger(DefaultTrustManager.class.getName());
	
	private boolean trustall;
	private boolean installNewCertificate;

	public DefaultTrustManager(TrustDetails trustDetails) {
		this.trustDetails = trustDetails;
	}

	public X509Certificate[] getAcceptedIssuers() {
		 return new X509Certificate[0];
//		throw new UnsupportedOperationException();
	}

	public void checkClientTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
		throw new UnsupportedOperationException();
	}
	/*
	 * (non-Javadoc)
	 * @see javax.net.ssl.X509TrustManager#checkServerTrusted(java.security.cert.X509Certificate[], java.lang.String)
	 */
	public void checkServerTrusted(X509Certificate[] chain, String authType) {
		if (!trustall  ||(trustall && installNewCertificate)){
			try{
				synchronized(trustDetails){
					trustDetails.getTrustManager().checkServerTrusted(chain, authType);
					log.debug("Trust Details verified");
				}
			}catch(Exception certificateException){
				if (installNewCertificate){
	
						if (chain != null) {						
							boolean result = storeChain(chain);		
							if (!result){
	//							throw certificateException;
							}
						}
					
				}
			}
		}
	}
	
	/**
	 * Stores the entire certificate chain.
	 * 
	 * @param chain
	 * @throws CommunicationException
	 */
	private boolean  storeChain(X509Certificate[] chain){
		boolean result = false ;
		if (chain != null && chain.length > 0) {
			for (int i = 0; i < chain.length; i++) {
				result = storeCertificate(chain[i], chain[i].getIssuerDN().getName());
				if (!result){
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Stores a certificate with the specified alias in local key store.
	 * 
	 * @param cert
	 * @param alias
	 * @throws CommunicationException
	 */
	private boolean storeCertificate(X509Certificate cert, String alias){
		OutputStream out = null;
		boolean result = false ;
		if (cert != null) {
			try {	
				synchronized(trustDetails){
					if ( !trustDetails.getKeyStore().containsAlias(alias)){
						this.trustDetails.getKeyStore().setCertificateEntry(alias, cert);
						out = new FileOutputStream(this.trustDetails.getTrustStorename());
						this.trustDetails.getKeyStore().store(out, this.trustDetails.getPassword().toCharArray());	
					}
					result = true;
				}
			} catch (Exception e) {
				log.info("Exception occured while storing the certificate."	+ e.getMessage());
			} finally {			
				if (out != null) {
					try {
						out.close();
					} catch (IOException e) {
					}
				}
			}
		}
		return result;
	}

	public void setInstallNewCertificate(boolean installNewCertificate) {
		this.installNewCertificate = installNewCertificate;
	}

	public void setTrustall(boolean trustall) {
		this.trustall = trustall;
	}
}
