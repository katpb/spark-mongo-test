package com.verifone.isd.vsms2.sales.ent.softkey;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;

/** Entity class for softkey
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class SoftKey implements IEntityObject, ISalesEntityVisitable {
    //static final long serialVersionUID = 985619620923153219L;
    /** Maximum softkeys
     */    
    public static final int MAX_SOFTKEYS = 120;
    
    private SoftKeyPK ID;
   
    /** Holds value of property type. */
    private SoftKeyType type;
    
    /** Holds value of property mappedPK. */
    private IEntityPK mappedPK;
    
    /** No-args constructor
     */    
    public SoftKey() {
    }
    
    /** Constructor
     * @param pk Primary key for the entity
     */    
    public SoftKey(SoftKeyPK pk) {
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
        SoftKey sObj = (SoftKey) obj;
        sObj.ID = this.ID;
        sObj.type = this.type;
        sObj.mappedPK = this.mappedPK;
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
        this.ID = (SoftKeyPK)pk;        
    }
    
    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {
        if (!isPKValid()) {
            throw new Exception("Invalid softkey: " +this.ID);            
        }
        if ((this.mappedPK != null) && (!this.mappedPK.isValid())) {
            throw new Exception("Softkey: " +ID +" - Invalid mapped object: " 
            +this.mappedPK);
        }        
    }
    
    /** Getter for property type.
     * @return Value of property type.
     */
    public SoftKeyType getType() {
        return this.type;
    }
    
    /** Setter for property type.
     * @param type New value of property type.
     */
    public void setType(SoftKeyType type) {
        this.type = type;
    }
    
    /** Getter for property mappedPK.
     * @return Value of property mappedPK.
     */
    public IEntityPK getMappedEntityPK() {
        return this.mappedPK;
    }
    
    /** Setter for property mappedPK.
     * @param newPK New value of property mappedPK.
     */
    public void setMappedEntityPK(IEntityPK newPK) {
        this.mappedPK = null;
        if ((newPK != null) && newPK.isValid()) {
            Class clz = this.type.getMappedPKClass();
            Class inClz = newPK.getClass();
            if ((clz != null) && (clz == inClz)) {
                this.mappedPK = newPK;
            }
        }
    }
    
    /** Implementation method for visitable in vistor pattern
     * @param v visitor
     * @throws Exception on exception in visitor's visit method
     */    
    public void accept(SalesEntityVisitor v) throws Exception {
        v.visit(this);
    }    
}



