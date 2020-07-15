package com.verifone.isd.vsms2.sales.ent.epsprepaid;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

public class EPSPrepaidCardConfig implements IEntityObject,
						IEPSPrepaidEntityVisitable, Serializable {

	private static final long serialVersionUID = 1887834605461469022L;
	private static final Logger logger
    			= LoggerFactory.getLogger(EPSPrepaidCardConfig.class);
    
    private static final int MAXNETNAMELEN = 20;
    
    private EPSPrepaidCardConfigPK ID; 
    
    private String prepaidNetworkName;
    
    private boolean networkEnabled;
    
    private boolean prepaidEnabled;
    
    private List configTypeList ;
    
    private List<PrepaidMessage> prepaidMessages;

    /** Creates a new instance of EPSPrepaidCardConfig */
    public EPSPrepaidCardConfig() {
    	prepaidNetworkName = new String("");
        configTypeList = new ArrayList();
        prepaidMessages = new ArrayList();
    }
    
    public int getPrepaidNetworkNum() {
        return ((int) ID.getValue());
    }
    
    public void setPrepaidNetworkNum(int recordNr) {
    	ID = new EPSPrepaidCardConfigPK(((short)recordNr));
    }
    
	@Override
	public void accept(EPSPrepaidEntityVisitor v) throws Exception {
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
        this.ID = (EPSPrepaidCardConfigPK)pk;
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
            throw new Exception("Invalid EPSPrepaidCardConfig entry: " + this.ID);
        }
        
        if ((this.prepaidNetworkName != null) && (this.prepaidNetworkName.length() > MAXNETNAMELEN)) {
            throw new Exception("Invalid PrepaidParamsConfig entry hostName: " + this.prepaidNetworkName);
        } 
		
	}

	public EPSPrepaidCardConfigPK getID() {
		return ID;
	}

	public void setID(EPSPrepaidCardConfigPK id) {
		ID = id;
	}

	public String getPrepaidNetworkName() {
		return prepaidNetworkName;
	}

	public void setPrepaidNetworkName(String prepaidNetworkName) {
		this.prepaidNetworkName = prepaidNetworkName;
	}

	public boolean isNetworkEnabled() {
		return networkEnabled;
	}

	public void setNetworkEnabled(boolean networkEnabled) {
		this.networkEnabled = networkEnabled;
	}

	public boolean isPrepaidEnabled() {
		return prepaidEnabled;
	}

	public void setPrepaidEnabled(boolean prepaidEnabled) {
		this.prepaidEnabled = prepaidEnabled;
	}

	public List getConfigTypeList() {
		return configTypeList;
	}

	public void setConfigTypeList(List configTypeList) {
		this.configTypeList = configTypeList;
	}
	
    public void addPrepaidConfigTypeList(EPSPrepaidConfigType e) { 
            this.configTypeList.add(e);
    }
	
    /**
     * This method will check the activate department configuration present for the department number
     * passed as the argument.  
     * @param deptNum : Department number need to check for active configuration.
     * @return : Active department configuration data present or not.
     */
    public boolean isPrepaidDepartment(int deptNum) {
        boolean isPrepaidDepartment = false;
        if(getEpsPrepaidConfig(deptNum) != null){
        	isPrepaidDepartment = true;
        }
        logger.info("EPSPrepaidConfigType:isPrepaidDepartment: returning with isPrepaidDepartment=" +isPrepaidDepartment);
        return isPrepaidDepartment;
	}
    
    /**
     * This method will return whether evaluate flag enabled for a particular department in the configuration data.
     * @param deptNum : Department number need to check whether evaluate flag is enabled or not.
     * @return : Evaluate flag is enabled or not.
     */
    public boolean isEvaluateEnabled(int deptNum){
    	boolean isEvaluateEnabled = false;
    	EPSPrepaidConfigType configType = getEpsPrepaidConfig(deptNum);
    	 
    	if(configType != null){
    	    isEvaluateEnabled = configType.isEvaluate();
    	}
    	logger.info("EPSPrepaidConfigType:isEvaluateEnabled returning with isEvaluateEnabled=" + isEvaluateEnabled);
        return isEvaluateEnabled;
    }
    
    /**
     * This method will return the ticket reprint security level configured for a particular department in the configuration data.
     * @param deptNum : Department number needs to identify the ticket reprint security level. 
     * @return : Ticket reprint security level of the department.
     */
    
    public int getTicketReprintSecLvl(int deptNum){
	   int secLvl = 0;
	   EPSPrepaidConfigType configType = getEpsPrepaidConfig(deptNum);
	   
	   if(configType != null){
		   secLvl = configType.getTicketReprintSecLvl(); 
	   }
	
	   logger.info("EPSPrepaidConfigType:getTicketReprintSecLvl returning with security level=" + secLvl);
	   return secLvl;
   }
   
   /**
    * This method will check whether the configuration data is valid or not by checking the boolean flags
    * networkEnabled and prepaidEnabled.
    * @return : Configuration data is valid or not.
    */
   
   public boolean isValidConfigType(){
	   boolean isValidConfigType = false;
	   if(networkEnabled && prepaidEnabled){
		   isValidConfigType = true;
	   }
	   
	   return  isValidConfigType;
   }
   
   /**
    * This method will identify and  return the configuration data associated with a particular department number.
    * If the configuration data is not present or department is not enabled it will returns null. 
    * @param deptNum
    * @return EPSPrepaidConfigType : Configuration data associated with that department.
    */
   private EPSPrepaidConfigType getEpsPrepaidConfig(int deptNum){
	   EPSPrepaidConfigType epsConfigType = null;
	   if(configTypeList != null){
          Iterator i = configTypeList.iterator();
           
	       while(i.hasNext()) {
	        	EPSPrepaidConfigType configType = (EPSPrepaidConfigType)i.next();
	            if (configType.isDepartmentEnabled() && deptNum == configType.getDepartment().getValue()){
	            	epsConfigType = configType;
                	break;
	            }
	        }
        }
        logger.info("EPSPrepaidConfigType: returning config data as =" + epsConfigType);
        return epsConfigType;
   }

	/**
	 * @return the prepaidMessages
	 */
	public List<PrepaidMessage> getPrepaidMessages() {
		return prepaidMessages;
	}
	
	/**
	 * @param prepaidMessages the prepaidMessages to set
	 */
	public void setPrepaidMessages(List<PrepaidMessage> prepaidMessages) {
		this.prepaidMessages = prepaidMessages;
	}
	
	public void addPrepaidMessage(PrepaidMessage prepaidMessage){
		this.prepaidMessages.add(prepaidMessage);
	}
}
