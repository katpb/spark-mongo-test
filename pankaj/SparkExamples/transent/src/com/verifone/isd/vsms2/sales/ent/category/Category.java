package com.verifone.isd.vsms2.sales.ent.category;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;

/** Entity class for category
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class Category implements IEntityObject, ISalesEntityVisitable {
    static final long serialVersionUID = -5957782369531111408L;
    /** Maximum categories
     */    
    public static final int MAX_CATEGORIES = 9999;
    
    private static final int FUEL_DEPOSIT_NR = 9999;
    private static final CategoryPK FUEL_DEPOSIT_PK;
    
    static {
        FUEL_DEPOSIT_PK = new CategoryPK(FUEL_DEPOSIT_NR);
    }
    
    private CategoryPK ID;
    private String name;
    
    /** Static method to return the Fuel deposit category
     * (this category is read-only)
     * @return fuel deposit category
     */    
    public static final CategoryPK getFuelDeposit() {
        return FUEL_DEPOSIT_PK;
    }    
   
    /** No-args constructor
     */    
    public Category() {
    }
    
    /** Constructor
     * @param pk Primary key for the entity
     */    
    public Category (CategoryPK pk) {
        this.ID = pk;
    }
    
    /** Setter for property name
     * @param name name of the entity
     */    
    public void setName(String name) {
        this.name = name;
    }
    
    /** Getter for property name
     * @return name of the entity
     */    
    public String getName() {
        return (this.name != null ? this.name: "");
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
        Category cObj = (Category) obj;
        cObj.ID = this.ID;
        cObj.name = this.name;
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
        this.ID = (CategoryPK)pk;        
    }
    
    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {
        if (!isPKValid()) {
            throw new Exception("Invalid category: " +this.ID);            
        }
        if ((this.name == null) || (this.name.trim().equals("")) || 
        (this.name.trim().equals("*"))) {
            throw new Exception("Invalid name for category: " +ID);
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



