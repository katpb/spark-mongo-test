
package com.verifone.isd.vsms2.sys.util.channel.ssl;

import java.io.File;
import java.security.KeyStore;

import javax.net.ssl.X509TrustManager;

public class TrustDetails {
	private X509TrustManager trustManager;
	private KeyStore keyStore ;
	private File trustStorename;
	private String password ;
	
	public TrustDetails(X509TrustManager trustManager ,KeyStore keyStore,File trustStorename , String password){
		this.trustManager = trustManager ;
		this.keyStore = keyStore;
		this.trustStorename = trustStorename;
		this.password = password ;
	}

	public KeyStore getKeyStore() {
		return keyStore;
	}

	public void setKeyStore(KeyStore keyStore) {
		this.keyStore = keyStore;
	}

	public X509TrustManager getTrustManager() {
		return trustManager;
	}

	public void setTrustManager(X509TrustManager trustManager) {
		this.trustManager = trustManager;
	}

	public File getTrustStorename() {
		return trustStorename;
	}

	public void setTrustStorename(File trustStorename) {
		this.trustStorename = trustStorename;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
