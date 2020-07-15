package com.verifone.isd.vsms2.sales.ent.banner;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;

/** Entity class for banner
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class Banner implements IEntityObject, ISalesEntityVisitable {
    static final long serialVersionUID = 8665153957533349120L;
    /** Maximum number of banners */    
    public static final int MAX_BANNERS = 2;
    
    private BannerPK ID;
    /** Holds value of property message. */    
    private String message;
    /** Holds value of property rotating. */
    private boolean rotating;
    
    /** No-args constructor
     */    
    public Banner() {
    }
    
    /** Constructor
     * @param pk Primary key for the entity
     */    
    public Banner(BannerPK pk) {
        this.ID = pk;
    }
    
    /** Setter for property message
     * @param message message of the entity
     */    
    public void setMessage(String message) {
        this.message = message;
    }
    
    /** Getter for property message
     * @return message of the entity
     */    
    public String getMessage() {
        return this.message;
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
        Banner bObj = (Banner) obj;
        bObj.ID = this.ID;
        bObj.message = this.message;
        bObj.rotating = this.rotating;
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
        this.ID = (BannerPK)pk;        
    }
    
    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {
        if (!isPKValid()) {
            throw new Exception("Invalid banner: " +this.ID);            
        }
    }
    
    /** Getter for property rotating.
     * @return Value of property rotating.
     */
    public boolean isRotating() {
        return this.rotating;
    }
    
    /** Setter for property rotating.
     * @param rotating New value of property rotating.
     */
    public void setRotating(boolean rotating) {
        this.rotating = rotating;
    }
    
    /** Implementation method for visitable in the visitor pattern
     * @param v visitor
     * @throws Exception propagates exceptions thrown by the visitor
     */    
    public void accept(SalesEntityVisitor v) throws Exception {
        v.visit(this);
    }
}



