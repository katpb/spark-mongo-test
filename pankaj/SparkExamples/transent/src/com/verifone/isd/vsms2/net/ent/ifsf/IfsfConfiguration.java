package com.verifone.isd.vsms2.net.ent.ifsf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class IfsfConfiguration {

	public static final String IFSF_VERSION = "V2.60";
	private static final int POP_ID_LEN_VIPER = 3;
	public static final int DEFAULT_DEV_REQ_PORT = 4004;

	/**
	 * Port number for CardRequest channel <code>CARD_PORT</code>.
	 */
	private int cardPort;
	/**
	 * Port number for ServiceRequest channel <code>SERVICE_PORT</code>.
	 */
	private int servicePort;
	/**
	 * Port number for Device channel <code>DEVICE_PORT</code>.
	 */
	private int devicePort;
	/**
	 * Port number for DeviceRequest channel <code>DEVREQ_PORT</code>.
	 */
	private int devReqPort;
	/**
	 * Unsolicited service request port
	 */
	private int unsolicitedServicePort;
	/**
	 * Viper host address
	 */
	private String viperHost;

	/**
	 * Pos request timeout
	 */
	private int posRequestTimeOut;

	/**
	 * Pos response timeout
	 */
	private int posResponseTimeOut;

	private List<String> popIdList = new ArrayList<>();
	private List<EPSConfiguration> epsConfigList = new ArrayList<EPSConfiguration>();
	private Map<String, EPSConfiguration> epsConfigMap = new HashMap<String, EPSConfiguration>();
	private List<String> secondaryEPSNames = new ArrayList<String>();
	private Map<String, SecondaryPinpadInfo> secondaryPinpadMap = new LinkedHashMap<String, SecondaryPinpadInfo>();

	private String siteId;
	private String posRefreshTimer;
	private String connectTimeOut;
	private String maxRetry;
	private String devReqDefaultTimer;
	private boolean bypassPopConfig;

	private SSLConfiguration sslConfig = null;
	private boolean nonSSLModeEnabled = true;

	private String primaryPinpadId;
	private Map<String, SecondaryPinpadInfo> tempSecondaryPinpadMap;

	private Map<String, String> extPosPopIdMap = new LinkedHashMap<String, String>();

	private Map<String, String> tempExtPosPopIdMap = new LinkedHashMap<String, String>();
	
	public int getCardPort() {
		return cardPort;
	}

	public int getServicePort() {
		return servicePort;
	}

	public int getDevicePort() {
		return devicePort;
	}

	public int getDevReqPort() {
		return devReqPort;
	}

	public String getViperHost() {
		return viperHost;
	}

	/**
	 * @return the posRequestTimeOut
	 */
	public int getPosRequestTimeOut() {
		return posRequestTimeOut;
	}

	/**
	 * @return the posResponseTimeOut
	 */
	public int getPosResponseTimeOut() {
		return posResponseTimeOut;
	}

	public String getSiteId() {
		return siteId;
	}

	public String[] getPOPIds() {
		return popIdList.toArray(new String[0]);
	}

	public String getPOSRefreshTimer() {
		return posRefreshTimer;
	}

	public String getConnectTimeOut() {
		return connectTimeOut;
	}

	public String getMaxRetry() {
		return maxRetry;
	}

	public String getDeviceReqDefaultTimer() {
		return devReqDefaultTimer;
	}

	public boolean isBypassPopConfig() {
		return bypassPopConfig;
	}

	public String getPrimaryPinpadId(int regID) {
		if (regID > 0) {

			/*
			 * Try to get POP-ID from extPosPopId map, if POP-ID doesn't exist in the map
			 * then fetch it from popIdList(topaz-pop id list)
			 */
			primaryPinpadId = extPosPopIdMap.get(String.valueOf(regID));
			final int index = (regID - 101);
			if (primaryPinpadId == null && index >= 0 && index <= 31 && popIdList.size() > index) {
				primaryPinpadId = popIdList.get(index);
			}

			// adding a null check to resolve coverity
			if (primaryPinpadId != null) {
				adjustPopID();
			}
		}
		return primaryPinpadId;
	}

	/**
	 * Adjust the POP ID to the length required by Viper
	 */
	private void adjustPopID() {
		if (primaryPinpadId.length() < POP_ID_LEN_VIPER) {
			final StringBuilder buf = new StringBuilder();
			for (int i = 0; i < POP_ID_LEN_VIPER; i++) {
				buf.append("0");
			}
			buf.replace(POP_ID_LEN_VIPER - primaryPinpadId.length(), POP_ID_LEN_VIPER, primaryPinpadId);
			primaryPinpadId = buf.toString();
		}
	}

	/**
	 * This method returns the EPSConfiguration Object for all the EPS including
	 * Primary EPS.
	 * 
	 * @return
	 */
	public List<EPSConfiguration> getAllEPSConfiguration() {
		return epsConfigList;
	}

	/**
	 * This method returns names of all secondary EPS. Name of primary EPS is not
	 * set anywhere or is null in Configuration list, so will not be included in
	 * this method's return value.
	 * 
	 * @return
	 */
	public List<String> getSecondaryEPSNames() {
		return secondaryEPSNames;

	}

	/**
	 * This method returns true, if the epsName matches with secondary epsNames.
	 * 
	 * @param epsName
	 * @return true - if it is secondary eps Name
	 */
	public boolean isSecondaryEps(String epsName) {
		if (secondaryEPSNames.contains(epsName)) {
			return true;
		}
		return false;
	}

	/**
	 * This method returns the EPSConfiguration object based on EPSName passed as
	 * method argument.
	 * 
	 * @param epsName
	 * @return
	 */
	public EPSConfiguration getEPSConfiguration(String epsName) {
		return epsConfigMap.get(epsName);
	}

	/**
	 * This method returns the EPSConfiguration object based on EPSName passed as
	 * method argument.
	 * 
	 * @param epsName
	 * @return
	 */
	public boolean isEpsEnabled(String epsName) {
		if (epsName == null) {
			return true;
		} else if (EPSNameEnum.fromValue(epsName) == EPSNameEnum.VFI) {
			return true;
		} else {
			return epsConfigMap.get(epsName).isEnabled();
		}
	}

	/**
	 * @return the unsolicitedServicePort
	 */
	public int getUnsolicitedServicePort() {
		return unsolicitedServicePort;
	}

	/**
	 * @param unsolicitedServicePort the unsolicitedServicePort to set
	 */
	public void setUnsolicitedServicePort(int unsolicitedServicePort) {
		this.unsolicitedServicePort = unsolicitedServicePort;
	}

	public void setDevReqPort(int overridePort) {
		devReqPort = overridePort;
	}

	public void setViperHost(String ip) {
		viperHost = ip;
	}

	public SSLConfiguration getSSLConfiguration() {
		return sslConfig;
	}

	public void setSSLConfiguration(SSLConfiguration sslConfig) {
		this.sslConfig = sslConfig;
	}

	public boolean isNonSSLModeEnabled() {
		return nonSSLModeEnabled;
	}

	/**
	 * Getter method for secondaryPinpadMap
	 * 
	 * @return secondaryPinpadMap
	 */
	public Map<String, SecondaryPinpadInfo> getSecondaryPinpadMap() {
		return secondaryPinpadMap;
	}

	/**
	 * Getter method for temporary secondaryPinpadMap
	 * 
	 * @return tempSecondaryPinpadMap
	 */
	public Map<String, SecondaryPinpadInfo> getTempSecondaryPinpadMap() {
		return tempSecondaryPinpadMap;
	}

	/**
	 * Getter method for thinClientPopIdMap
	 * 
	 * @return secondaryPinpadMap
	 */
	public Map<String, String> getExtPosPopIdMap() {
		return extPosPopIdMap;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public List<String> getPOPIdList() {
		return popIdList;
	}

	public void setCardPort(int cardPort) {
		this.cardPort = cardPort;
	}

	public void setServicePort(int servicePort) {
		this.servicePort = servicePort;

	}

	public void setDevicePort(int devicePort) {
		this.devicePort = devicePort;
	}

	public void setPosRequestTimeOut(int posRequestTimeOut) {
		this.posRequestTimeOut = posRequestTimeOut;
	}

	public void setPosResponseTimeOut(int posResponseTimeOut) {
		this.posResponseTimeOut = posResponseTimeOut;
	}

	public void setPopIdList(List<String> popIdList) {
		this.popIdList = popIdList;
	}

	public void setEpsConfigList(List<EPSConfiguration> epsConfigList) {
		this.epsConfigList = epsConfigList;
	}

	public void setEpsConfigMap(Map<String, EPSConfiguration> epsConfigMap) {
		this.epsConfigMap = epsConfigMap;
	}

	public void setSecondaryEPSNames(List<String> secondaryEPSNames) {
		this.secondaryEPSNames = secondaryEPSNames;
	}

	public void setSecondaryPinpadMap(Map<String, SecondaryPinpadInfo> secondaryPinpadMap) {
		this.secondaryPinpadMap = secondaryPinpadMap;
	}

	public void setPosRefreshTimer(String posRefreshTimer) {
		this.posRefreshTimer = posRefreshTimer;
	}

	public void setConnectTimeOut(String connectTimeOut) {
		this.connectTimeOut = connectTimeOut;
	}

	public void setMaxRetry(String maxRetry) {
		this.maxRetry = maxRetry;
	}

	public void setDevReqDefaultTimer(String devReqDefaultTimer) {
		this.devReqDefaultTimer = devReqDefaultTimer;
	}

	public void setBypassPopConfig(boolean bypassPopConfig) {
		this.bypassPopConfig = bypassPopConfig;
	}

	public void setNonSSLModeEnabled(boolean nonSSLModeEnabled) {
		this.nonSSLModeEnabled = nonSSLModeEnabled;
	}

	public void setPrimaryPinpadId(String primaryPinpadId) {
		this.primaryPinpadId = primaryPinpadId;
	}

	public void setTempSecondaryPinpadMap(Map<String, SecondaryPinpadInfo> tempSecondaryPinpadMap) {
		this.tempSecondaryPinpadMap = tempSecondaryPinpadMap;
	}

	public void setExtPosPopIdMap(Map<String, String> extPosPopIdMap) {
		this.extPosPopIdMap = extPosPopIdMap;
	}

	public Map<String, String> getTempExtPosPopIdMap() {
		return tempExtPosPopIdMap;
	}

	public void setTempExtPosPopIdMap(Map<String, String> tempExtPosPopIdMap) {
		this.tempExtPosPopIdMap = tempExtPosPopIdMap;
	}

}