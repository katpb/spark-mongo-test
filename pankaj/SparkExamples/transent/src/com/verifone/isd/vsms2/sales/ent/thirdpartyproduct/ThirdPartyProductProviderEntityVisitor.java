package com.verifone.isd.vsms2.sales.ent.thirdpartyproduct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.sales.ent.salescfg.SalesConfig;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPersistAdmin;
import com.verifone.isd.vsms2.sys.db.pres.IReferenceDataSystem;
import com.verifone.isd.vsms2.sys.db.pres.ReferenceDataSystemFactory;

public abstract class ThirdPartyProductProviderEntityVisitor {
	 private Logger logger
	 = LoggerFactory.getLogger(com.verifone.isd.vsms2.sales.ent.thirdpartyproduct.ThirdPartyProductProviderEntityVisitor.class);

	/**
	* Visitor method for object of type ThirdPartyProductProviderConfig.
	* Default behavior is no-op. To be implemented by subclasses if
	* specific xml serialization is reqd.
	* @param thirdPartyProductProviderConfig the ThirdPartyProductProviderConfig object to be visited
	* @exception org.xml.sax.Exception thrown by visitor if any
	* error is encountered
	*/
	public void visit(ThirdPartyProductProviderConfig thirdPartyProductProviderConfig) throws Exception {
	}
	
	protected String getSiteID() {
			
		 String siteID = "";
		 
		 try {
		     IEntityPersistAdmin pa = ReferenceDataSystemFactory.getInstance().getPersistAdmin(IReferenceDataSystem.SALES_CFG);
		     IEntityObject[] objs = pa.retrieve();
		     SalesConfig cfg = (SalesConfig)objs[0];
		     siteID = cfg.getStoreNumber();
		 }
		 catch (Exception e) {
		     logger.error("exception " + e.getClass().getName()+ " " + e.getMessage());
		 }
	 return siteID;
	}
}
