package com.verifone.isd.vsms2.sales.ent.prodcode;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
/** Entity class for product code
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class ProdCode implements IEntityObject, ISalesEntityVisitable {
    static final long serialVersionUID = -2515195492433535708L;
    /** Maximum product codes
     */    
    public static final int MAX_PRODUCT_CODES = 999;
    
    private ProdCodePK ID;
    private String name;
   
    /** Holds value of property fuel. */
    private boolean fuel;
    
    /** Holds value of property sellable. */
    private boolean sellable = true;
    
    /** No-args constructor
     */    
    public ProdCode() {
    }
    
    /** Constructor
     * @param pk primary key of the entity
     */    
    public ProdCode(ProdCodePK pk) {
        this.ID = pk;
    }
    
    /** Setter for property name
     * @param name name of the entity
     */    
    public void setName(String name) {
        this.name = name;
    }
    
    /** Getter for property name
     * @return name
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
    
    /** Method to copy this object's attributes to another (clone)
     * @param obj object to be copied to
     */    
    public void setAttributes(IEntityObject obj) {
        ProdCode pObj = (ProdCode) obj;
        pObj.ID = this.ID;
        pObj.name = this.name;
        pObj.fuel = this.fuel;
        pObj.sellable = this.sellable;
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
        this.ID = (ProdCodePK)pk;        
    }
    
    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {
        if (!isPKValid()) {
            throw new Exception("Invalid product code: " +this.ID);            
        }
        if ((this.name == null) || (this.name.trim().equals("")) || 
        (this.name.trim().equals("*"))) {
            throw new Exception("Invalid name for product code: " +ID);
        }        
    }
    
    /** Getter for property fuel.
     * @return Value of property fuel.
     */
    public boolean isFuel() {
        return this.fuel;
    }
    
    /** Setter for property fuel.
     * @param fuel New value of property fuel.
     */
    public void setFuel(boolean fuel) {
        this.fuel = fuel;
    }
    
    /** Getter for property sellable.
     * @return Value of property sellable.
     */
    public boolean isSellable() {
        return this.sellable;
    }
    
    /** Setter for property sellable.
     * @param sellable New value of property sellable.
     */
    public void setSellable(boolean sellable) {
        this.sellable = sellable;
    }
    
    /** Implementation method for visitable in visitor pattern
     * @param v visitor
     * @throws Exception on exception in visitor's visit method
     */    
    public void accept(SalesEntityVisitor v) throws Exception {
        v.visit(this);
    }      
}



