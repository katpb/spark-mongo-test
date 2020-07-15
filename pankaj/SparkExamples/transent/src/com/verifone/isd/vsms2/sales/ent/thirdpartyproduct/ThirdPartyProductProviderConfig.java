package com.verifone.isd.vsms2.sales.ent.thirdpartyproduct;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

public class ThirdPartyProductProviderConfig implements IEntityObject,
						IThirdPartyProductProviderEntityVisitable, Serializable {

	private static final long serialVersionUID = 1887834605461469022L;
	private static final Logger logger
    			= LoggerFactory.getLogger(ThirdPartyProductProviderConfig.class);
    
    private static final int MAXNETNAMELEN = 20;
    
    public static final int DEF_PREFIX_LEN = 4;
    
    private ThirdPartyProductProviderConfigPK ID; 
    
    private String thirdPartyProductProviderNetworkName;
	
	private String thirdPartyProductProviderNetworkBarcodeID;
    
    private boolean thirdPartyProductProviderNetworkEnabled;
    
    private boolean thirdPartyProductProviderEnabled;
	
    private List<ThirdPartyProductProviderConfigType> configTypeList ;
    

    /** Creates a new instance of ThirdPartyProductCardConfig */
    public ThirdPartyProductProviderConfig() {
    	thirdPartyProductProviderNetworkName = new String("");
		thirdPartyProductProviderNetworkBarcodeID = new String("");
        configTypeList = new ArrayList<ThirdPartyProductProviderConfigType>();
    }
    
    public int getThirdPartyProductProviderNetworkNum() {
        return ((int) ID.getValue());
    }
    
    public void setThirdPartyProductProviderNetworkNum(int recordNr) {
    	ID = new ThirdPartyProductProviderConfigPK(((short)recordNr));
    }
    
	@Override
	public void accept(ThirdPartyProductProviderEntityVisitor v) throws Exception {
		v.visit(this);
		
	}
	   /** Getter of the entity object's primary key
     * @return the ID of the entity object
     */
    @Override
	public IEntityPK getPK() {
        return this.ID;
    }
    
    /** Set the primary key of the entity object
     * @param pk primary key for the entity object
     */
    @Override
	public void setPK(IEntityPK pk) {
        this.ID = (ThirdPartyProductProviderConfigPK)pk;
    }
    
    /** Method to validate the primary key of the entity object
     * @return true if the primary key of the entity object is valid
     */
    @Override
	public boolean isPKValid() {
        return (this.ID == null) ? false : this.ID.isValid();
    }
    
	@Override
	public void setAttributes(IEntityObject obj) {
		
	}
	
	@Override
	public void validate() throws Exception {
		if (!isPKValid()) {
            throw new Exception("Invalid ThirdPartyProductProviderConfig entry: " + this.ID);
        }
        
        if ((this.thirdPartyProductProviderNetworkName != null) && (this.thirdPartyProductProviderNetworkName.length() > MAXNETNAMELEN)) {
            throw new Exception("Invalid thirdPartyProductProvider Config entry hostName: " + this.thirdPartyProductProviderNetworkName);
        } 
		
	}

	public ThirdPartyProductProviderConfigPK getID() {
		return ID;
	}

	public void setID(ThirdPartyProductProviderConfigPK id) {
		ID = id;
	}

	public String getThirdPartyProductProviderNetworkName() {
		return thirdPartyProductProviderNetworkName;
	}

	public void setThirdPartyProductProviderNetworkName(String thirdPartyProductProviderNetworkName) {
		this.thirdPartyProductProviderNetworkName = thirdPartyProductProviderNetworkName;
	}
	
	public String getThirdPartyProductProviderNetworkBarcodeID() {
		if ((thirdPartyProductProviderNetworkBarcodeID == null) || thirdPartyProductProviderNetworkBarcodeID.isEmpty()) {
			if ((thirdPartyProductProviderNetworkName != null) && (thirdPartyProductProviderNetworkName.length() >= DEF_PREFIX_LEN)) {
				thirdPartyProductProviderNetworkBarcodeID = thirdPartyProductProviderNetworkName.substring(0, DEF_PREFIX_LEN).toUpperCase();
			}
		}
		return thirdPartyProductProviderNetworkBarcodeID;
	}

	public void setThirdPartyProductProviderNetworkBarcodeID(String thirdPartyProductProviderNetworkBarcodeID) {
		this.thirdPartyProductProviderNetworkBarcodeID = thirdPartyProductProviderNetworkBarcodeID;
	}

	public boolean isThirdPartyProductProviderNetworkEnabled() {
		return thirdPartyProductProviderNetworkEnabled;
	}

	public void setThirdPartyProductProviderNetworkEnabled(boolean thirdPartyProductProviderNetworkEnabled) {
		this.thirdPartyProductProviderNetworkEnabled = thirdPartyProductProviderNetworkEnabled;
	}

	public boolean isThirdPartyProductProviderEnabled() {
		return thirdPartyProductProviderEnabled;
	}

	public void setThirdPartyProductProviderEnabled(boolean thirdPartyProductProviderEnabled) {
		this.thirdPartyProductProviderEnabled = thirdPartyProductProviderEnabled;
	}

	public List<ThirdPartyProductProviderConfigType> getConfigTypeList() {
		return configTypeList;
	}

	public void setConfigTypeList(List<ThirdPartyProductProviderConfigType> configTypeList) {
		this.configTypeList = configTypeList;
	}
	
    public void addThirdPartyProductProviderConfigTypeList(ThirdPartyProductProviderConfigType e) { 
            this.configTypeList.add(e);
    }
	
    /**
     * This method will check the Third Party Product Provider configuration present for the Barcode ID
     * passed as the argument.  
     * @param barcodeID : Barcode ID needed to check for active configuration.
     * @return : Third Party Product Provider configuration data present or not.
     */
    public boolean isThirdPartyProductProviderBarcodeID(String barcodeID) {
        boolean isTPPP_BarcodeID_True = false;
        if(this.getThirdPartyProductProviderNetworkBarcodeID().equals(barcodeID)){
        	isTPPP_BarcodeID_True = true;
        }
        logger.info("boolean :isThirdPartyProductProviderBarcodeID: returning with isTPPP_BarcodeID_True=" + isTPPP_BarcodeID_True);
        return isTPPP_BarcodeID_True;
	}

   
   /**
    * This method will check whether the configuration data is valid or not by checking the boolean flags
    * networkEnabled and thirdPartyProductProviderEnabled.
    * @return : Configuration data is valid or not.
    */
   
   public boolean isValidConfigType(){
	   boolean isValidConfigType = false;
	   if(thirdPartyProductProviderNetworkEnabled && thirdPartyProductProviderEnabled){
		   isValidConfigType = true;
	   }
	   
	   return  isValidConfigType;
   }
   
   public int getBarcodePrefixLen() {
	   return getThirdPartyProductProviderNetworkBarcodeID().length();
   }

}
