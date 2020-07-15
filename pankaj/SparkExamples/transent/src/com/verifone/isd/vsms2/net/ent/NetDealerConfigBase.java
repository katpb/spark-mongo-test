 /*
  * NetDealerConfig.java
  *
  * Created on Dec 3, 2004, 4:30 PM
  */

package com.verifone.isd.vsms2.net.ent;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.util.PromptOptionsType;

/**
 *
 * @author  Linda_T1
 */
public abstract class NetDealerConfigBase implements INetDealerConfig, INetEntityVisitable, Serializable {
    private static final long serialVersionUID = -1792835439962035938L;

    public static short MAX_DEALER_CONFIG_RECS = 1;
    public static int MAXNAMELEN = 30;
    public static int MAXADDRLEN = 18;
    public static int MAXCITYLEN = 16;
    public static int MAXSTATELEN = 2;
    public static int MAXZIPLEN = 10;
    public static int MAXPHONELEN = 14;
     protected String dealerName;
     protected String dealerAddress;
     protected String dealerAddressLine2;
     protected String dealerCity;
     protected String dealerState;
     protected String dealerZipCode;
     protected String locationId;
     protected String dealerPhoneNumber;
     protected String dealerSiteBrand;
     protected String attendedOperation;
     protected boolean refundAllowed;
     protected boolean manualEntryAllowed;
     protected PromptOptionsType prtCustCopy = PromptOptionsType.YES;
     protected int dispMsgPersist;
     protected boolean prtMerchCopy;
     protected boolean voidTicketOnActivationFailure;
     protected boolean deactivationSupported;
     protected boolean remotePOSControlEnabled;
     protected BigDecimal cashbackLimit = new BigDecimal(0);
     protected static final String ZERO_REMOVER_REGEX = "^0+(?!$)"; 
     /** Map to hold the pop configuration from viper */
     protected Map<String, PopConfig> popConfigurationMap;
     protected NetDealerConfigPK ID;

     /** Creates a new instance of NetDealerConfig */
     public NetDealerConfigBase() {
         dealerName = "";
         dealerAddress = "";
         dealerCity = "";
         dealerState = "";
         dealerZipCode = "";
         dealerAddressLine2="";
         locationId="";
         popConfigurationMap = new HashMap<String, PopConfig>();
     }

     public void setRecordNr(short recordNr) {
         ID = new NetDealerConfigPK(recordNr);
     }

     public String getDealerName() {
         return this.dealerName;
     }

     public void setDealerName(String dealerName) {
         this.dealerName = dealerName;
     }

     public String getDealerAddress() {
         return this.dealerAddress;
     }

     public void setDealerAddress(String dealerAddress) {
         this.dealerAddress = dealerAddress;
     }

     public String getDealerCity() {
         return this.dealerCity;
     }

     public void setDealerCity(String dealerCity) {
         this.dealerCity = dealerCity;
     }

     public String getDealerState() {
         return this.dealerState;
     }

     public void setDealerState(String dealerState) {
         this.dealerState = dealerState;
     }

     public boolean getRefundAllowed() {
         return this.refundAllowed;
     }

     public void setRefundAllowed(boolean refundAllowed) {
         this.refundAllowed = refundAllowed;
     }

     public boolean getManualEntryAllowed() {
         return this.manualEntryAllowed;
     }

     /**
	 * @return the dealerAddress1
	 */
	public String getDealerAddressLine2() {
		return dealerAddressLine2;
	}

	/**
	 * @param dealerAddress1 the dealerAddress1 to set
	 */
	public void setDealerAddressLine2(String dealerAddress1) {
		this.dealerAddressLine2 = dealerAddress1;
	}

	public void setManualEntryAllowed(boolean manualEntryAllowed) {
         this.manualEntryAllowed = manualEntryAllowed;
     }

     /**
	 * @return the locationId
	 */
	public String getLocationId() {
		return locationId;
	}

	/**
	 * @param locationId the locationId to set
	 */
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public boolean getPrtCustCopy() {
         if(prtCustCopy == PromptOptionsType.NO || prtCustCopy == PromptOptionsType.PROMPT) {
             return false;
         }
         return true;
     }

     public void setPrtCustCopy(boolean prtCustCopy) {
         if(prtCustCopy == true) {
             this.prtCustCopy = PromptOptionsType.YES;
         }
         else {
             this.prtCustCopy = PromptOptionsType.NO;
         }
     }

     public int getDispMsgPersist() {
         return this.dispMsgPersist;
     }

     public void setDispMsgPersist(int dispMsgPersist) {
         this.dispMsgPersist = dispMsgPersist;
     }

     /**
      * @return the prtPromptCustCopy
      */
     public PromptOptionsType getPrtPromptCustCopy() {
         return prtCustCopy;
     }

     /**
      * @param prtPromptCustCopy the prtPromptCustCopy to set
      */
     public void setPrtPromptCustCopy(PromptOptionsType prtPromptCustCopy) {
         if(prtPromptCustCopy != null) {
             this.prtCustCopy = prtPromptCustCopy;
         }
     }

     /**
      * @return the prtMerchCopy
      */
     public boolean isPrtMerchCopy() {
         return prtMerchCopy;
     }

     /**
      * @param prtMerchCopy the prtMerchCopy to set
      */
     public void setPrtMerchCopy(boolean prtMerchCopy) {
         this.prtMerchCopy = prtMerchCopy;
     }

     /**
      * @return the attendedOperation
      */
     public String getAttendedOperation() {
         return attendedOperation;
     }

     /**
      * @return the dealerPhoneNumber
      */
     public String getDealerPhoneNumber() {
         return dealerPhoneNumber;
     }

     /**
      * @return the dealerSiteBrand
      */
     public String getDealerSiteBrand() {
         return dealerSiteBrand;
     }

     /**
      * @return the dealerZipCode
      */
     public String getDealerZipCode() {
         return dealerZipCode;
     }

     /**
      * @param attendedOperation the attendedOperation to set
      */
     public void setAttendedOperation(String attendedOperation) {
         this.attendedOperation = attendedOperation;
     }

     /**
      * @param dealerPhoneNumber the dealerPhoneNumber to set
      */
     public void setDealerPhoneNumber(String dealerPhoneNumber) {
         this.dealerPhoneNumber = dealerPhoneNumber;
     }

     /**
      * @param dealerSiteBrand the dealerSiteBrand to set
      */
     public void setDealerSiteBrand(String dealerSiteBrand) {
         this.dealerSiteBrand = dealerSiteBrand;
     }

     /**
      * @param dealerZipCode the dealerZipCode to set
      */
     public void setDealerZipCode(String dealerZipCode) {
         this.dealerZipCode = dealerZipCode;
     }

     /** Getter of the entity object's primary key
      * @return the ID of the entity object
      */
     public IEntityPK getPK() {
         return this.ID;
     }

     /** Set the primary key of the entity object
      * @param pk primary key for the entity object
      */
     public void setPK(IEntityPK pk) {
         this.ID = (NetDealerConfigPK)pk;
     }

     /** Method to validate the primary key of the entity object
      * @return true if the primary key of the entity object is valid
      */
     public boolean isPKValid() {
         return (this.ID == null) ? false : this.ID.isValid();
     }
     /** Method to validate an entity object's attributes.
      * @throws Exception if validation fails
      */
     public void validate() throws Exception {

         if (!isPKValid()) {
             throw new Exception("Invalid NetDealerConfig Entry: " +this.ID);
         }

         if ((this.dealerName != null) && (this.dealerName.length() > MAXNAMELEN)) {
             throw new Exception("Invalid NetDealerConfig Entry dealerName: " + this.dealerName);
         }

         if ((this.dealerAddress != null) && (this.dealerAddress.length() > MAXADDRLEN)) {
             throw new Exception("Invalid NetDealerConfig Entry dealerAddress: " + this.dealerAddress);
         }

         if ((this.dealerCity != null) && (this.dealerCity.length() > MAXCITYLEN)) {
             throw new Exception("Invalid NetDealerConfig Entry dealerCity: " + this.dealerCity);
         }

         if ((this.dealerState != null) && (this.dealerState.length() > MAXSTATELEN)) {
             throw new Exception("Invalid NetDealerConfig Entry dealerState: " + this.dealerState);
         }

         if (this.dispMsgPersist > 5){
             throw new Exception("Invalid msgDispPersist: "+this.dispMsgPersist);
         }
         if((this.dealerZipCode!=null) && (this.dealerZipCode.length()>MAXZIPLEN)){
        	 throw new Exception("Invalid NetDealerConfig Entry dealerZipCode: " + this.dealerZipCode);
         }
         if((this.dealerPhoneNumber!=null) && (this.dealerPhoneNumber.length()>MAXPHONELEN)){
        	 throw new Exception("Invalid NetDealerConfig Entry dealerPhoneNumber: " + this.dealerPhoneNumber);
         }
     }

     public void setAttributes(IEntityObject obj) {
         NetDealerConfigBase netDealerConfig = (NetDealerConfigBase)obj;

         netDealerConfig.ID = this.ID;
         netDealerConfig.setDealerName(this.dealerName);
         netDealerConfig.setDealerAddress(this.dealerAddress);
         netDealerConfig.setDealerAddressLine2(this.dealerAddressLine2);
         netDealerConfig.setDealerCity(this.dealerCity);
         netDealerConfig.setDealerState(this.dealerState);
         netDealerConfig.setRefundAllowed(this.refundAllowed);
         netDealerConfig.setLocationId(this.locationId);
         netDealerConfig.setManualEntryAllowed(this.manualEntryAllowed);
         netDealerConfig.setPrtPromptCustCopy(this.prtCustCopy);
         netDealerConfig.setDispMsgPersist(this.dispMsgPersist);
         netDealerConfig.setDealerZipCode(this.dealerZipCode);
         netDealerConfig.setDealerPhoneNumber(this.dealerPhoneNumber);
         netDealerConfig.setPrtMerchCopy(this.prtMerchCopy);
         netDealerConfig.setVoidTicketOnActivationFailure(this.voidTicketOnActivationFailure);     
         netDealerConfig.setPopConfigurationMap(this.popConfigurationMap);
         netDealerConfig.setCashbackLimit(this.getCashbackLimit());
         netDealerConfig.setDeactivationSupported(this.deactivationSupported);
     }

     public static void setNameMaxLength(int maxLen) {
         MAXNAMELEN = maxLen;
     }

     public static int getNameMaxLength() {
         return MAXNAMELEN;
     }

     public static void setAddressMaxLength(int maxLen) {
         MAXADDRLEN = maxLen;
     }

     public static int getAddressMaxLength() {
         return MAXADDRLEN;
     }

     public static void setCityMaxLength(int maxLen) {
         MAXCITYLEN = maxLen;
     }

     public static int getCityMaxLength() {
         return MAXCITYLEN;
     }

     public static void setStateMaxLength(int maxLen) {
         MAXSTATELEN = maxLen;
     }

     public static int getStateMaxLength() {
         return MAXSTATELEN;
     }
     public static int  getZipcodeMaxLength(){
    	 return MAXZIPLEN;
     }
     public static void setZipcodeMaxLenght(int maxLen){
    	 MAXZIPLEN=maxLen;
     }
     public static int  getPhoneNumberMaxLength(){
    	 return MAXPHONELEN;
     }
     public static void setPhoneNumberMaxLenght(int maxLen){
    	 MAXPHONELEN = maxLen;
     }
     
    /** Implementation method for visitor pattern
      * @param v visitor instance
      * @throws Exception propagates exceptions thrown by the visitor class
      * in its visit() method implementation
      */
     public void accept(NetEntityVisitor v) throws Exception {
         v.visit(this);
     }

	public boolean isVoidTicketOnActivationFailure() {
		return voidTicketOnActivationFailure;
	}

	public void setVoidTicketOnActivationFailure(
			boolean voidTicketOnActivationFailure) {
		this.voidTicketOnActivationFailure = voidTicketOnActivationFailure;
	}
	

     public boolean isRemotePOSControlEnabled() {
		return this.remotePOSControlEnabled;
     }

     public void setRemotePOSControlEnabled(boolean remotePOSControlEnabled) {
		this.remotePOSControlEnabled = remotePOSControlEnabled;
     }
     
     public boolean isDeactivationSupported() {
 		return deactivationSupported;
 	 }

 	public void setDeactivationSupported(boolean deactivationSupported) {
 		this.deactivationSupported = deactivationSupported;
 	 }

	
	/**
	 * @return the popConfigurationMap
	 */
	public Map<String, PopConfig> getPopConfigurationMap() {
		return popConfigurationMap;
	}

	/**
	 * @param popConfigurationMap the popConfigurationMap to set
	 */
	public void setPopConfigurationMap(Map<String, PopConfig> popConfigurationMap) {
		this.popConfigurationMap = popConfigurationMap;
	}

	/**
	 * Method to get the pop configuration from the pop configuration map.
	 * 
	 * @param popID (int)
	 * @return com.verifone.isd.vsms2.net.ent.PopConfig
	 */
	public PopConfig getPopConfig(String popID) {
		return popConfigurationMap.get(removeZeros(popID));
	}

	/**
	 * This method removes leading zeroes.
	 * 
	 * @param popIDString
	 * @return
	 */
	private String removeZeros(String popID) {
		String zeroRemovedID = popID.replaceFirst(ZERO_REMOVER_REGEX, "");
		return zeroRemovedID;
	}

	public BigDecimal getCashbackLimit() {
		return cashbackLimit;
	}

	public void setCashbackLimit(BigDecimal cashbackLimit) {
		this.cashbackLimit = cashbackLimit;
	}
}
