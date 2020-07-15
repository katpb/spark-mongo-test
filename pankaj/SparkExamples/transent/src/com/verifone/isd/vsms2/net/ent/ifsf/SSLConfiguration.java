package com.verifone.isd.vsms2.net.ent.ifsf;

public class SSLConfiguration {

    private int serviceWaitingSSLPort;
    private int cardWaitingSSLPort;
    private int deviceWaitingSSLPort;
    private int deviceRequestSSLPort;
    private int unsolicitedServiceWaitingSSLPort;

	public int getServiceWaitingSSLPort() {
		return serviceWaitingSSLPort;
	}

	public void setServiceWaitingSSLPort(int serviceWaitingSSLPort) {
		this.serviceWaitingSSLPort = serviceWaitingSSLPort;
	}

	public int getCardWaitingSSLPort() {
		return cardWaitingSSLPort;
	}

	public void setCardWaitingSSLPort(int cardWaitingSSLPort) {
		this.cardWaitingSSLPort = cardWaitingSSLPort;
	}

	public int getDeviceWaitingSSLPort() {
		return deviceWaitingSSLPort;
	}

	public void setDeviceWaitingSSLPort(int deviceWaitingSSLPort) {
		this.deviceWaitingSSLPort = deviceWaitingSSLPort;
	}

	public int getDeviceRequestSSLPort() {
		return deviceRequestSSLPort;
	}

	public void setDeviceRequestSSLPort(int deviceRequestSSLPort) {
		this.deviceRequestSSLPort = deviceRequestSSLPort;
	}

	public int getUnsolicitedServiceWaitingSSLPort() {
		return unsolicitedServiceWaitingSSLPort;
	}

	public void setUnsolicitedServiceWaitingSSLPort(
			int unsolicitedServiceWaitingSSLPort) {
		this.unsolicitedServiceWaitingSSLPort = unsolicitedServiceWaitingSSLPort;
	}
    
}
