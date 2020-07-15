package com.verifone.isd.vsms2.sales.ent.cashiertracking;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.log4j.*;
import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;

import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

/** Entity class for PluTracking
 * @author "mailto:linda_t1@verifone.com"
 * @version 1.0
 */
public class PluTracking implements IEntityObject, ISalesEntityVisitable {

    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sales.ent.cashiertracking.PluTracking.class);
    public static final int MAX_UPC_LENGTH = 14;
    public static final int MAX_MODIFIER_LENGTH = 3;
    public static final String MAX_TRACKING_RECORDS = "50";
    
    private PluTrackingPK ID;
    String upcModifier;
    
    /** No-args constructor
     */    
    public PluTracking() {
    }
    
    /** Constructor
     * @param ID Primary key for the entity
     */    
    public PluTracking(PluTrackingPK ID) {
		this.ID = ID;
    }
    

    public void setUpcModifier(String upcModifier) {
        this.upcModifier = upcModifier;
    }
    public String getUpcModifier() {
        return this.upcModifier;
    }
    public String getUpc() {
        String buf = new String(this.upcModifier);
        return (buf.substring(0,14));
    }
    public String getModifier() {
        String buf = new String(this.upcModifier);
        return (buf.substring(14));
    }
    /** Method to clone another entity with this enity's attributes
     * @param obj entity to copy to
     */    
    public void setAttributes(IEntityObject obj) {
        PluTracking pObj = (PluTracking) obj;
        pObj.ID = this.ID;
	pObj.upcModifier=this.upcModifier;
    }
    
    /** Method to validate the primary key of the entity object
     * @return true if the primary key of the entity object is valid
     */
    public boolean isPKValid() {
		return this.ID.isValid();
    }

    
    
    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {
        if (!isPKValid()) {
            throw new Exception("Invalid PluTracking: " +this.ID);            
        }
        if ((this.upcModifier == null) || 
          (this.upcModifier.length() != (MAX_UPC_LENGTH+MAX_MODIFIER_LENGTH))){
            throw new Exception("Invalid Plu: " +this.upcModifier);
        }        
    }
    
    /** Implementation method for visitable in visitor pattern
     * @param v visitor
     * @throws Exception on exception in visitor's visit method
     */    
    public void accept(SalesEntityVisitor v) throws Exception {
        v.visit(this);
    }      
  
	/**
	 * This method returns a reference to the IEntityPk.
	 * @return A reference to the IEntityPK.
	 */
	public IEntityPK getPK() {
		return this.ID;
	}
	
	/**
	 * This method sets the primary key.
	 * @param pk The primary key value.
	 */
	public void setPK(IEntityPK pk) {
		this.ID = (PluTrackingPK) pk;
	}
}
