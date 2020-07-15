package com.verifone.isd.vsms2.net.ent.ifsf;

/**
 *  This class holds the UI configurable elements for EPS.
 * @author Amit_K4
 *
 */
public class EPSConfiguration {
	
	private boolean enabled;
	private String ipAddress;
	private int serviceWaitingPort;
	private int deviceWaitingPort;
	private int cardWaitingPort;
	private  String epsName;
	private int priority;
	
	
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public int getServiceWaitingPort() {
		return serviceWaitingPort;
	}
	public void setServiceWaitingPort(int serviceWaitingPort) {
		this.serviceWaitingPort = serviceWaitingPort;
	}
	public int getDeviceWaitingPort() {
		return deviceWaitingPort;
	}
	public void setDeviceWaitingPort(int deviceWaitingPort) {
		this.deviceWaitingPort = deviceWaitingPort;
	}
	public int getCardWaitingPort() {
		return cardWaitingPort;
	}
	public void setCardWaitingPort(int cardWaitingPort) {
		this.cardWaitingPort = cardWaitingPort;
	}
	public String getEpsName() {
		return epsName;
	}
	public void setEpsName(String epsName) {
		this.epsName = epsName;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
