package com.verifone.isd.vsms2.sys.ent.keybd;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.ent.ISystemEntityVisitable;
import com.verifone.isd.vsms2.sys.ent.ISystemEntityVisitor;

/**
 *  entity class for key
 *
 *  @author "mailto:bhanu_n2@verifone.com"
 */
public class Key implements IEntityObject, ISystemEntityVisitable {
    static final long serialVersionUID = 1813432041361824972L;
    /** Maximum keys
     */    
    public static final int MAX_COLUMNS = 100;
    public static final int MAX_ROWS = 100;
    public static final int MAX_KEYS = MAX_COLUMNS*MAX_ROWS;
    
    private KeyPK ID;
    private KeyType keyType;
    private String keyValue;
    
    public Key() {
    }    
    
    /** Constructor
     * @param pk primary key for the entity
     */    
    public Key(KeyPK pk) {
        this.ID = pk;
    }
    
    /** Constructor
     * @param pk primary key for the entity
     */    
    public Key(KeyPK pk, KeyType keyType, String keyValue) {
        this.ID = pk;
        this.keyType = keyType;
        this.keyValue = keyValue;        
    }
    
    /** Getter of the entity object's primary key
     * @return the ID of the entity object
     */
    public IEntityPK getPK() {
        return this.ID;
    }
    
    public KeyType getType() {
        return this.keyType;
    }
    
    public void setType(KeyType keyType) {
        this.keyType = (keyType == null) ? KeyType.UNDEFINED : keyType;
    }
    
    public String getValue() {
        return this.keyValue;
    }
    
    public void setValue(String keyValue) {
        this.keyValue = (keyValue == null) ? "" : keyValue;
    }
    
    /** Set the attributes from another entity object (clone)
     * @param obj The entity object to clone
     */    
    public void setAttributes(IEntityObject obj) {
        Key aObj = (Key) obj;
        aObj.ID = this.ID;
        aObj.setType(this.getType());
        aObj.setValue(this.getValue());
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
        this.ID = (KeyPK)pk;        
    }
    
    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {
        if (!isPKValid()) {
            throw new Exception("Invalid age validation: " +this.ID);            
        }
    }
    
    public void accept(ISystemEntityVisitor v) throws Exception {
        v.visit(this);
    }
}



