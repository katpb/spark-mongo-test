package com.verifone.isd.vsms2.sales.ent.couponmsg;
/*
import com.hp.gemstone.sapphire.np.database.gemcom.GemcomEntityObject;
import com.hp.gemstone.sapphire.np.database.interfaces.IGemcomEntityObject;
import com.hp.gemstone.sapphire.np.database.DBException;

import com.hp.gemstone.sapphire.np.ui.view.domain.dataset.DataSetXMLVisitor;
import com.hp.gemstone.sapphire.np.domain.IReferenceDataSystem;

import java.util.Vector;
import java.util.Enumeration;
import java.util.Hashtable;

import java.io.Serializable;

import org.xml.sax.SAXException;
*/
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
/** Entity class for couponMsg
 * @author "mailto:Mike_Reese@verifone.com"
 * @version 1.0 Copyright(c) 2003 VeriFone Inc., All Rights Reserved
 */
public class CouponMsg implements IEntityObject, ISalesEntityVisitable {
    static final long serialVersionUID = 1940443350786609018L;
    
    /** Maximum number of coupon messages */    
    public static final int MAX_MSGS = 3;
    
    private CouponMsgPK ID;
    private String message;
    
    /** Constructor
     * @param ID coupon message ID
     */    
    public CouponMsg(CouponMsgPK ID) {
        this.ID = ID;
    }
    
    /** No-args constructor */    
    public CouponMsg() {
        this(new CouponMsgPK(0));
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
        this.ID = (CouponMsgPK)pk;
    }
    
    /** Getter for message property
     * @return message property value
     */    
    public String getMessage() {
        return this.message;
    }
    
    /** Getter for message property
     * @param message new message
     */    
    public void setMessage(String message) {
        if (message == null) {
            this.message = "";
        }
        else {
            this.message = message;
        }
    }
    
    /** Method to clone another entity with this enity's attributes
     * @param obj entity to copy to
     */    
    public void setAttributes(IEntityObject obj) {
        CouponMsg lObj = (CouponMsg) obj;
        lObj.setPK(this.getPK());
        lObj.setMessage(this.getMessage());
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
            throw new Exception("Invalid CouponMsg: " +this.ID);            
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