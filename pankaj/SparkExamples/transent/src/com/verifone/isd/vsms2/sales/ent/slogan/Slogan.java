package com.verifone.isd.vsms2.sales.ent.slogan;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.util.MessageJustification;
import com.verifone.isd.vsms2.sys.util.MessageMode;
import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;

/** Entity class for slogan
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class Slogan implements IEntityObject, ISalesEntityVisitable {
    static final long serialVersionUID = 3825806434385311902L;
    /** Maximum slogans
     */    
    public static final int MAX_SLOGANS = 20;
    
    private SloganPK ID;
    private String message;
   
    /** Holds value of property mode. */
    private MessageMode mode;
    
    /** Holds value of property justification. */
    private MessageJustification justification;
    
    /** Holds value of property enabled. */
    private boolean enabled;
    
    /** No-args constructor
     */    
    public Slogan() {
    }
    
    /** Constructor
     * @param pk Primary key for the entity
     */    
    public Slogan(SloganPK pk) {
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
        Slogan lObj = (Slogan) obj;
        lObj.ID = this.ID;
        lObj.message = this.message;
        lObj.justification = this.justification;
        lObj.mode = this.mode;
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
        this.ID = (SloganPK)pk;        
    }
    
    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {
        if (!isPKValid()) {
            throw new Exception("Invalid slogan: " +this.ID);            
        }
    }
    
    /** Getter for property mode.
     * @return Value of property mode.
     */
    public MessageMode getMode() {
        return this.mode;
    }
    
    /** Setter for property mode.
     * @param mode New value of property mode.
     */
    public void setMode(MessageMode mode) {
        this.mode = mode;
    }
    
    /** Getter for property justification.
     * @return Value of property justification.
     */
    public MessageJustification getJustification() {
        return this.justification;
    }
    
    /** Setter for property justification.
     * @param justification New value of property justification.
     */
    public void setJustification(MessageJustification justification) {
        this.justification = justification;
    }
    
    /** Getter for property enabled.
     * @return Value of property enabled.
     */
    public boolean isEnabled() {
        return this.enabled;
    }
    
    /** Setter for property enabled.
     * @param enabled New value of property enabled.
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    /** Implementation method for visitable in vistor pattern
     * @param v visitor
     * @throws Exception on exception in visitor's visit method
     */    
    public void accept(SalesEntityVisitor v) throws Exception {
        v.visit(this);
    }      
}



