/**
 * 
 */
package com.verifone.isd.vsms2.net.ent;

import java.util.ArrayList;
import java.util.List;

import com.verifone.isd.vsms2.net.ent.eps.LoyaltyProgramConfig;
import com.verifone.isd.vsms2.sys.util.Quantity;


/**
 * Entity class for EPS Config Upate.
 * @author Regan_D1
 *
 */
public class EPSConfig {
	private boolean isSecLoyaltySupport;
	private boolean isSecPaymentSupport;
	private Quantity minimumFuelPrice = new Quantity(0,"");
	private boolean indoorBarcodeScannerAvailable;
	private boolean widePrinterForReportsAvailable;
	
	private List<LoyaltyProgramConfig> secLoyaltyProgramList = new ArrayList<LoyaltyProgramConfig>();
	private String merchantName="";
	private List<PopConfig> popConfigList= new ArrayList<PopConfig>();
	/**
	 * @return the isSecLoyaltySupport
	 */
	public boolean isSecLoyaltySupport() {
		return isSecLoyaltySupport;
	}
	/**
	 * @param isSecLoyaltySupport the isSecLoyaltySupport to set
	 */
	public void setSecLoyaltySupport(boolean isSecLoyaltySupport) {
		this.isSecLoyaltySupport = isSecLoyaltySupport;
	}
	/**
	 * @return the isSecPaymentSupport
	 */
	public boolean isSecPaymentSupport() {
		return isSecPaymentSupport;
	}
	/**
	 * @param isSecPaymentSupport the isSecPaymentSupport to set
	 */
	public void setSecPaymentSupport(boolean isSecPaymentSupport) {
		this.isSecPaymentSupport = isSecPaymentSupport;
	}
	/**
	 * @return the fuelPrice
	 */
	public Quantity getMinimumFuelPrice() {
		return minimumFuelPrice;
	}
	/**
	 * @param fuelPrice the fuelPrice to set
	 */
	public void setMinimumFuelPrice(Quantity fuelPrice) {
		this.minimumFuelPrice = fuelPrice;
	}
	/**
	 * @return the indoorBarcodeScannerAvailable
	 */
	public boolean isIndoorBarcodeScannerAvailable() {
		return indoorBarcodeScannerAvailable;
	}
	/**
	 * @param indoorBarcodeScannerAvailable the indoorBarcodeScannerAvailable to set
	 */
	public void setIndoorBarcodeScannerAvailable(
			boolean indoorBarcodeScannerAvailable) {
		this.indoorBarcodeScannerAvailable = indoorBarcodeScannerAvailable;
	}
	
	/**
	 * @return the widePrinterForReportsAvailable
	 */	
	public boolean isWidePrinterForReportsAvailable() {
		return widePrinterForReportsAvailable;
	}
	
	/**
	 * @param widePrinterForReportsAvailable the widePrinterForReportsAvailable to set
	 */
	public void setWidePrinterForReportsAvailable(
			boolean widePrinterForReportsAvailable) {
		this.widePrinterForReportsAvailable = widePrinterForReportsAvailable;
	}

	
	/**
	 * @return the secLoyaltyProgramList
	 */
	public List<LoyaltyProgramConfig> getSecLoyaltyProgramList() {
		return secLoyaltyProgramList;
	}
	/**
	 * @param secLoyaltyProgramList the secLoyaltyProgramList to set
	 */
	public void setSecLoyaltyProgramList(
			List<LoyaltyProgramConfig> secLoyaltyProgramList) {
		this.secLoyaltyProgramList = secLoyaltyProgramList;
	}
	/**
	 * @return the merchantName
	 */
	public String getMerchantName() {
		return merchantName;
	}
	/**
	 * @param merchantName the merchantName to set
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	
	/**
	 * @return the popConfigList
	 */
	public List<PopConfig> getPopConfigList() {
		return popConfigList;
	}
	/**
	 * @param popConfigList the popConfigList to set
	 */
	public void setPopConfigList(List<PopConfig> popConfigList) {
		this.popConfigList = popConfigList;
	}
	
	private boolean isFuelMinPPUEqual(EPSConfig epsConfig)
	{
		if(epsConfig.getMinimumFuelPrice()!=null && this.getMinimumFuelPrice() != null && 
				this.getMinimumFuelPrice().compare(epsConfig.getMinimumFuelPrice()) == 0){
					return true;
			}
		return false;
	}
	
	private boolean isLoyaltyEqual(EPSConfig epsConfig){
		List<LoyaltyProgramConfig> lyltyPgmList = epsConfig.getSecLoyaltyProgramList();
		
		if((lyltyPgmList.size() == this.secLoyaltyProgramList.size()) &&
				(lyltyPgmList.containsAll(secLoyaltyProgramList))) {
				return true;
		}
		
		return false;	
	}
	
	private boolean isPOPConfigEquals(EPSConfig epsConfig){
		List<PopConfig> popConfigList = epsConfig.getPopConfigList();
		
		if((popConfigList.size() == this.popConfigList.size()) &&
				(this.popConfigList.containsAll(popConfigList))) {
				return true;
		}
		
		return false;	
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object epsConfig) {
		
		if(epsConfig instanceof EPSConfig)
		{
			EPSConfig epsCfg=(EPSConfig)epsConfig;
			if(this.isSecLoyaltySupport() == epsCfg.isSecLoyaltySupport() &&
			   this.isSecPaymentSupport() == epsCfg.isSecPaymentSupport() &&
			   this.isIndoorBarcodeScannerAvailable() == this.isIndoorBarcodeScannerAvailable() &&
			   this.getMerchantName().equals(epsCfg.getMerchantName()) &&
			   isFuelMinPPUEqual(epsCfg) &&
			   isLoyaltyEqual(epsCfg) &&
			   isPOPConfigEquals(epsCfg)){
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
		int hashCode = 1;
		
		hashCode += this.isSecLoyaltySupport() == true ? 1 :0;
		hashCode += this.isSecPaymentSupport() == true ? 1 :0;
		hashCode += this.isIndoorBarcodeScannerAvailable() == true ? 1 :0;
		hashCode += this.getMerchantName()!=null ? this.getMerchantName().hashCode() : 0 ;
		hashCode += this.getMinimumFuelPrice() != null ? this.getMinimumFuelPrice().hashCode() : 0 ;
		
		List<LoyaltyProgramConfig> lyltyPgmList = this.getSecLoyaltyProgramList();
		for(LoyaltyProgramConfig lyltCfg : lyltyPgmList){
			hashCode += lyltCfg.hashCode();
		}
		
		List<PopConfig> popConfigList = this.getPopConfigList();
		for(PopConfig popCfg : popConfigList){
			hashCode += popCfg.hashCode();
		}
		
		return hashCode;
	}
}
