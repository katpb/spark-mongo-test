package com.verifone.isd.vsms2.sales.ent.netcname;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;

/**
 *  entity class for network card name
 *
 *  @author "mailto:bhanu_n2@verifone.com"
 */
public class NetCardName implements IEntityObject, ISalesEntityVisitable, Comparable {
    static final long serialVersionUID = 5026184336896473698L;
    
    /**
     * Maximum card type value
     */    
    public static final int MAX_CARDTYPE = 999;
    
    private NetCardNamePK ID;
    private String name;
   
    /** No-args constructor
     */    
    public NetCardName() {
    }
    
    /** Constructor
     * @param pk primary key for the entity
     */    
    public NetCardName(NetCardNamePK pk) {
        this.ID = pk;
    }
    
    /** Setter for property name
     * @param name name of the age validation
     */    
    public void setName(String name) {
        this.name = name;
    }
    
    /** Getter for property 'name'
     * @return name of the entity
     */    
    public String getName() {
        return this.name;
    }
    
    /** Getter of the entity object's primary key
     * @return the ID of the entity object
     */
    public IEntityPK getPK() {
        return this.ID;
    }
    
    /** Set the attributes from another entity object (clone)
     * @param obj The entity object to clone
     */    
    public void setAttributes(IEntityObject obj) {
        NetCardName aObj = (NetCardName) obj;
        aObj.ID = this.ID;
        aObj.name = this.name;
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
        this.ID = (NetCardNamePK)pk;        
    }
    
    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {
        if (!isPKValid()) {
            throw new Exception("Invalid net card type: " +this.ID);            
        }
        if ((this.name == null) || (this.name.trim().equals("")) || 
        (this.name.trim().equals("*"))) {
            throw new Exception("Invalid name for card type: " +ID);
        }     
    }
    
    /**
     * Compare the passed in object to the current object
     * @param cName The object to be compared
     * @return 0 if the objects are equal, less than 0 if this object is less than the
     * argument and greater than 0 if this object is greater than the argument
     */    
    public int compareTo( Object cName ) {
        if ( this == cName ) return 0;
        final NetCardName cardName = (NetCardName)cName;

		/* If card names are same, use ascending order of card type */
		if (this.name.equals(cardName.name)) {
			return (this.ID.getValue() - cardName.ID.getValue());
		} else {
        	return (this.name.compareTo(cardName.name));
		}
    }
    
    /** Implementation method for visitable in the visitor pattern
     * @param v visitor
     * @throws Exception on exception in visitor's visit method
     */    
    public void accept(SalesEntityVisitor v) throws Exception {
        v.visit(this);
    }
}



