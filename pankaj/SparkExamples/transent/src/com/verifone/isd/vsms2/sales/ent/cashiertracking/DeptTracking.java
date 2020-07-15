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

/** Entity class for DeptTracking
 * @author "mailto:linda_t1@verifone.com"
 * @version 1.0
 */
public class DeptTracking implements IEntityObject, ISalesEntityVisitable {

    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sales.ent.cashiertracking.DeptTracking.class);
    /** Maximum value allowed for department
     */
    
    public static final int MAX_DEPARTMENTS = 9999;
    public static final String MAX_TRACKING_RECORDS = "30";
    
    private DeptTrackingPK ID;
    /** No-args constructor
     */    
    public DeptTracking() {
    }
    
    /** Constructor
     * @param pk Primary key for the entity
     */    
    public DeptTracking(DeptTrackingPK pk) {
        this.ID = pk;
    }
    
    
    /** Getter of the entity object's primary key
     * @return the ID of the entity object
     */
    public IEntityPK getPK() {
        return this.ID;
    }
    
    /** Method to clone another entity with this enity's attributes
     * @param obj entity to copy to
     */    
    public void setAttributes(IEntityObject obj) {
        DeptTracking dObj = (DeptTracking) obj;
        dObj.ID = this.ID;
    }
    
    /** Method to validate the primary key of the entity object
     * @return true if the primary key of the entity object is valid
     */
    public boolean isPKValid() {
        return (this.ID == null) ? false : this.ID.isValid();  
    }

    
    /** Set the primary key of the entity object
     * @param pk primary key for the entity object
     */
    public void setPK(IEntityPK pk) {
        this.ID = (DeptTrackingPK)pk;        
    }
    
    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {
        if (!isPKValid()) {
            throw new Exception("Invalid DeptTracking: " +this.ID);            
        }
    }
    
    /** Implementation method for visitable in visitor pattern
     * @param v visitor
     * @throws Exception on exception in visitor's visit method
     */    
    public void accept(SalesEntityVisitor v) throws Exception {
        v.visit(this);
    }      
  
}
 



    
  
