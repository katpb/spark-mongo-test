/**
 * 
 */
package com.verifone.isd.vsms2.net.ent;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.verifone.isd.vsms2.net.ent.eps.LoyaltyProgramConfig;
import com.verifone.isd.vsms2.net.ent.eps.NetDealerConfig;
import com.verifone.isd.vsms2.net.ent.eps.NetworkConfig;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Entity class for POSConfigUpdate
 * @author Regan_D1
 *
 */
public class PosConfig implements IEntityObject {
	
	/**
	 * Serial Version Id.
	 */
	private static final long serialVersionUID = -7380328760832305124L;
	private NetDealerConfigBase netDealerCfg;
	private NetworkConfigBase netCfg;
	private List<LoyaltyProgramConfig> loyaltyProgramCfgList;
	private NetReceiptMessageConfigSet indoorReceiptSet;
	private NetReceiptMessageConfigSet outdoorReceiptSet;
	private String rewardsButtonLabel;
	private boolean isPaymentAvailable;
	private boolean isLotteryAvailable;
	private String LotteryFepName;
	private Map<String, String> fepNameMap;
	
	private PosConfigPK ID;
	
	public PosConfig(){
		netDealerCfg = new NetDealerConfig();
		netCfg = new NetworkConfig();
		loyaltyProgramCfgList = new ArrayList<LoyaltyProgramConfig>();
		indoorReceiptSet = new NetReceiptMessageConfigSet();
		outdoorReceiptSet = new NetReceiptMessageConfigSet();
		fepNameMap = new HashMap<String, String>();
		rewardsButtonLabel="";
	}
	
	/**
	 * set the name of EPS.
	 * @param epsName
	 */
	public void setEpsName(String epsName){
		ID = new PosConfigPK(epsName);
	}
	
	/**
	 * Returns net dealer config
	 * @return netDealerCfg
	 */
	public NetDealerConfigBase getNetDealerCfg() {
		return netDealerCfg;
	}
	
	/**
	 * set net dealer config
	 * @param netDealerCfg
	 */
	public void setNetDealerCfg(NetDealerConfigBase netDealerCfg) {
		this.netDealerCfg = netDealerCfg;
	}
	
	/**
	 * returns indoor receipt set 
	 * @return the receiptList
	 */
	public NetReceiptMessageConfigSet getIndoorReceiptSet() {
		return indoorReceiptSet;
	}

	/**
	 * returns outdoor receipt set
	 * @return the receiptList
	 */
	public NetReceiptMessageConfigSet getOutdoorReceiptSet() {
		return outdoorReceiptSet;
	}
	
	/**
	 * Add Indoor receipt message 
	 * @param receiptText
	 */
	public void addIndoorReceiptMessage(NetReceiptMessageConfig receiptText){
		indoorReceiptSet.addRecordToSet(receiptText);
	}
	
	/**
	 * Add outdoors receipt message
	 * @param receiptText
	 */
	public void addOutdoorReceiptMessage(NetReceiptMessageConfig receiptText){
		outdoorReceiptSet.addRecordToSet(receiptText);
	}
	
	/**
	 * Returns Rewards label to be displayed in outdoors Idle Screen. 
	 * @return
	 */
	public String getRewardsButtonLabel() {
		return rewardsButtonLabel;
	}

	/**
	 * set Rewards label to be displayed in outdoors Idle Screen.
	 * @param rewardsButtonLabel
	 */
	public void setRewardsButtonLabel(String rewardsButtonLabel) {
		this.rewardsButtonLabel = rewardsButtonLabel;
	}

	/**
	 * Returns available loyalty program list.
	 * @return
	 */
	public List<LoyaltyProgramConfig> getLoyaltyProgramCfgList() {
		return loyaltyProgramCfgList;
	}

	/**
	 * set Loyalty program list
	 * @param loyaltyProgramCfgList
	 */
	public void setLoyaltyProgramCfgList(
			List<LoyaltyProgramConfig> loyaltyProgramCfgList) {
		this.loyaltyProgramCfgList = loyaltyProgramCfgList;
	}
	
	/**
	 * Add the Loyalty program to the list
	 * @param lyltyPgm
	 */
	public void addLoyaltyProgram(LoyaltyProgramConfig lyltyPgm) {
		loyaltyProgramCfgList.add(lyltyPgm);
	}
	
	/**
	 * set meerchant id
	 * @param merchantId
	 */
	public void setMerchantId(String merchantId) {
		netCfg.setMerchantNum(merchantId);
	}
	
	/**
	 * set merchant name
	 * @param merchantName
	 */
	public void setMerchantName(String merchantName) {
		netDealerCfg.setDealerName(merchantName);
	}
	
	/**
	 * set merchant address line 1
	 * @param dealerAddress
	 */
	public void setMerchantAddress(String dealerAddress){
		netDealerCfg.setDealerAddress(dealerAddress);
	}
	
	/**
	 * set merchant address line 2
	 * @param dealerAddress
	 */
	public void setMerchantAddressLine2(String dealerAddress){
		netDealerCfg.setDealerAddressLine2(dealerAddress);
	}
	
	/**
	 * Returns location id
	 * @return locationId
	 */
	public String getLocationId() {
		return netDealerCfg.getLocationId();
	}

	/**
	 * set location id
	 * @param locationId
	 */
	public void setLocationId(String locationId) {
		netDealerCfg.setLocationId(locationId);
	}

	/**
	 * Returns merchant id
	 * @return merchantId
	 */
	public String getMerchantId() {
		return netCfg.getMerchantNum();
	}

	/**
	 * set cashback limit
	 * @param cashBackLimit
	 */
	public void setCashBackLimit(BigDecimal cashBackLimit)
	{
		netDealerCfg.setCashbackLimit(cashBackLimit);
	}
	/**
	 * Returns CashBack Limit 
	 * @return cashBackLimit
	 */
	public BigDecimal getCashBackLimit()
	{
		return netDealerCfg.getCashbackLimit();
	}
	/**
	 * Return merchant name
	 * @return merchant name
	 */
	public String getMerchantName()
	{
		return netDealerCfg.getDealerName();
	}
	
	/**
	 * Return network config
	 * @return the netCfg
	 */
	public NetworkConfigBase getNetCfg() {
		return netCfg;
	}
	
	
	
	public Map<String, String> getFepNameMap() {
		return fepNameMap;
	}

	public void setFepNameMap(Map<String, String> fepNameMap) {
		this.fepNameMap = fepNameMap;
	}

	@Override
	public String toString() {
		StringBuffer outPut = new StringBuffer();
		
		if(netCfg != null)
		{
			outPut.append("[Merchant Name] : "+netCfg.getMerchantNum() + System.getProperty("line.separator"));
		}
		if(netDealerCfg != null)
		{
			outPut.append("[Merchant Name] : "+netDealerCfg.getDealerName() + System.getProperty("line.separator"));
			outPut.append("[Merchant Address] : "+netDealerCfg.getDealerAddress() + System.getProperty("line.separator"));
			outPut.append("[City] : "+netDealerCfg.getDealerCity() + System.getProperty("line.separator"));
			outPut.append("[STATE] : "+netDealerCfg.getDealerState() + System.getProperty("line.separator"));
			outPut.append("[ZIP CODE] : "+netDealerCfg.getDealerZipCode() + System.getProperty("line.separator"));
		}
		
		for(LoyaltyProgramConfig lytyPgm : loyaltyProgramCfgList ) {
			outPut.append(lytyPgm.toString());
		}
		
		return outPut.toString();
	}

	@Override
	public IEntityPK getPK() {
		return ID;
	}

	@Override
	public void setPK(IEntityPK pk) {
		
	}

	@Override
	public void setAttributes(IEntityObject obj) {
		
		if(obj instanceof PosConfig){
			PosConfig config = (PosConfig) obj;
			netDealerCfg.setAttributes(config.getNetDealerCfg());
			config.setMerchantId(getMerchantId());
			config.setPaymentAvailable(isPaymentAvailable());
			config.setLotteryAvailable(isLotteryAvailable());
			config.setLotteryFepName(getLotteryFepName());
			config.setFepNameMap(getFepNameMap());
			setLoyaltyPgmDetails(config);
			setReceiptDetails(config);
		}
	}

	private void setLoyaltyPgmDetails(PosConfig config){
		
		for(LoyaltyProgramConfig lytyPgm : loyaltyProgramCfgList ){
			config.addLoyaltyProgram(lytyPgm);
		}
		
		config.setRewardsButtonLabel(rewardsButtonLabel);
	}
	
	private void setReceiptDetails(PosConfig config){
		
		for( Object obj : indoorReceiptSet.getNetCCSet()){
			if(obj instanceof NetReceiptMessageConfig)
			{
				NetReceiptMessageConfig receipt = (NetReceiptMessageConfig)obj;
				config.addIndoorReceiptMessage(receipt);
			}
		}
		
		for( Object obj : outdoorReceiptSet.getNetCCSet()){
			if(obj instanceof NetReceiptMessageConfig)
			{
				NetReceiptMessageConfig receipt = (NetReceiptMessageConfig)obj;
				config.addOutdoorReceiptMessage(receipt);
			}
		}
		
	}
	
	/**
	 * @return the isPaymentAvailable
	 */
	public boolean isPaymentAvailable() {
		return isPaymentAvailable;
	}

	/**
	 * @param isPaymentAvailable the isPaymentAvailable to set
	 */
	public void setPaymentAvailable(boolean isPaymentAvailable) {
		this.isPaymentAvailable = isPaymentAvailable;
	}
	
	

	public boolean isLotteryAvailable() {
		return isLotteryAvailable;
	}

	public void setLotteryAvailable(boolean isLotteryAvailable) {
		this.isLotteryAvailable = isLotteryAvailable;
	}

	
	public String getLotteryFepName() {
		return LotteryFepName;
	}

	public void setLotteryFepName(String lotteryFepName) {
		LotteryFepName = lotteryFepName;
	}

	@Override
	public void validate() throws Exception {
		
	}

	@Override
	public boolean isPKValid() {
		return  this.ID !=null? this.ID.isValid() : false;
	}
}
