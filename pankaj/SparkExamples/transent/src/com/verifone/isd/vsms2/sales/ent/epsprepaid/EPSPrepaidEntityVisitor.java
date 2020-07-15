package com.verifone.isd.vsms2.sales.ent.epsprepaid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.sales.ent.salescfg.SalesConfig;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPersistAdmin;
import com.verifone.isd.vsms2.sys.db.pres.IReferenceDataSystem;
import com.verifone.isd.vsms2.sys.db.pres.ReferenceDataSystemFactory;

public abstract class EPSPrepaidEntityVisitor {
	 private Logger logger
	 = LoggerFactory.getLogger(com.verifone.isd.vsms2.sales.ent.epsprepaid.EPSPrepaidEntityVisitor.class);

	/**
	* Visitor method for object of type EPSPrepaidCardConfig.
	* Default behavior is no-op. To be implemented by subclasses if
	* specific xml serialization is reqd.
	* @param prepaidCardConfig the EPSPrepaidCardConfig object to be visited
	* @exception org.xml.sax.Exception thrown by visitor if any
	* error is encountered
	*/
	public void visit(EPSPrepaidCardConfig prepaidCardConfig) throws Exception {
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
