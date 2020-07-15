package com.verifone.isd.vsms2.net.ent;

import java.util.List;

/**
 * PINpad configuration info holder.
 * 
 * @author t_kathirs1
 * 
 */
public class PopConfig {

	private String popID;
	private String popIpAddress;
	private String popPort;
	private String lineDisplayListeningPort;
	private boolean lineItemDisplayEnabled;
	private boolean signatureCaptureEnabled;

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("PopInfo > ");
		int popID_int = Integer.parseInt(popID);
		if (popID_int > 0 || popID_int < 99) {
			sb.append("POP ID - " + popID);
		}
		sb.append(":");
		if (popIpAddress != null && popIpAddress.length() > 0) {
			sb.append("POP IP ADDRESS - " + popIpAddress);
		}
		sb.append(":");
		int popPort_int = Integer.parseInt(popPort);
		if (popPort_int > 0 || popPort_int < 65536) {
			sb.append("POP PORT - " + popPort);
		}
		sb.append(":");
		int lineDisplayListeningPort_int = Integer
				.parseInt(lineDisplayListeningPort);
		if (lineDisplayListeningPort_int > 0
				|| lineDisplayListeningPort_int < 65536) {
			sb.append("POP DISPLAY LISTENING PORT - "
					+ lineDisplayListeningPort_int);
		}
		sb.append(":");
		sb.append("POP LINE DISPLAY ENABLED - " + lineItemDisplayEnabled);
		sb.append(":");
		sb.append("POP SINATURE CAPTURE ENABLED - " + signatureCaptureEnabled);
		return sb.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object popConfig) {
		if(popConfig instanceof PopConfig)
		{
			PopConfig popCfg = (PopConfig) popConfig ;
			if(((this.popID == popCfg.getPopID()) || this.popID != null && this.popID.equals(popCfg.getPopID())) &&
				((this.popIpAddress == popCfg.getPopIpAddress()) || this.popIpAddress != null && this.popIpAddress.equals(popCfg.getPopIpAddress())) &&
				((this.popPort == popCfg.getPopPort()) || this.popPort != null && this.popPort.equals(popCfg.getPopPort())) &&
				((this.lineDisplayListeningPort == popCfg.getLineDisplayListeningPort()) || 
						this.lineDisplayListeningPort != null && this.lineDisplayListeningPort.equals(popCfg.getLineDisplayListeningPort())) &&
				(this.lineItemDisplayEnabled == popCfg.isLineItemDisplayEnabled()) &&
				(this.signatureCaptureEnabled == popCfg.isSignatureCaptureEnabled())){
				return true;
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		
		int hashCode = 1 ;
		
		hashCode += this.popID != null?this.popID.hashCode() : 0;
		hashCode += this.popIpAddress != null?this.popIpAddress.hashCode() : 0;
		hashCode += this.popPort != null?this.popPort.hashCode() : 0;
		hashCode += this.lineDisplayListeningPort != null?this.lineDisplayListeningPort.hashCode() : 0;
		hashCode += this.lineItemDisplayEnabled ? 1 : 0 ;
		hashCode += this.signatureCaptureEnabled ? 1 : 0 ;
		
		return hashCode;
	}

	/**
	 * @return the popID
	 */
	public String getPopID() {
		return popID;
	}

	/**
	 * @return the popIpAddress
	 */
	public String getPopIpAddress() {
		return popIpAddress;
	}

	/**
	 * @return the popPort
	 */
	public String getPopPort() {
		return popPort;
	}

	/**
	 * @return the lineDisplayListeningPort
	 */
	public String getLineDisplayListeningPort() {
		return lineDisplayListeningPort;
	}

	/**
	 * @return the lineItemDisplayEnabled
	 */
	public boolean isLineItemDisplayEnabled() {
		return lineItemDisplayEnabled;
	}

	/**
	 * @return the signatureCaptureEnabled
	 */
	public boolean isSignatureCaptureEnabled() {
		return signatureCaptureEnabled;
	}

	/**
	 * @param popID
	 *            the popID to set
	 */
	public void setPopID(String popID) {
		this.popID = popID;
	}

	/**
	 * @param popIpAddress
	 *            the popIpAddress to set
	 */
	public void setPopIpAddress(String popIpAddress) {
		this.popIpAddress = popIpAddress;
	}

	/**
	 * @param popPort
	 *            the popPort to set
	 */
	public void setPopPort(String popPort) {
		this.popPort = popPort;
	}

	/**
	 * @param lineDisplayListeningPort
	 *            the lineDisplayListeningPort to set
	 */
	public void setLineDisplayListeningPort(String lineDisplayListeningPort) {
		this.lineDisplayListeningPort = lineDisplayListeningPort;
	}

	/**
	 * @param lineItemDisplayEnabled
	 *            the lineItemDisplayEnabled to set
	 */
	public void setLineItemDisplayEnabled(boolean lineItemDisplayEnabled) {
		this.lineItemDisplayEnabled = lineItemDisplayEnabled;
	}

	/**
	 * @param signatureCaptureEnabled
	 *            the signatureCaptureEnabled to set
	 */
	public void setSignatureCaptureEnabled(boolean signatureCaptureEnabled) {
		this.signatureCaptureEnabled = signatureCaptureEnabled;
	}
	
}
