package com.verifone.isd.vsms2.sales.ent.popdefinition;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/**
 *  entity class for popDefinition
 *
 *  @author "mailto:mike_reese@verifone.com"
 *  @version 1.0 Copyright(c) 2003 VeriFone, Inc., All Rights Reserved
 */
public class PopDefinition implements IEntityObject, ISalesEntityVisitable {
    static final long serialVersionUID = -8357456058068722646L;
    /**
     * Maximum number of pop definitions
     */    
    public static final int MAX_POPDEFINITIONS = 25;
    /**
     * Maximum pop definition ID
     */    
    public static final int MAX_POPDEFINITION_ID = MAX_POPDEFINITIONS;
    /**
     * Maximum number of fuel products
     */    
    public static final int MAX_PRODUCTS = 20;
    /**
     * Maximum discount
     */    
    public static final int MAX_DISCOUNT = 999;

    /**
     * Max pop fuel product name length
     */    
    public static final int MAX_FUEL_PRODNMAE_LENGTH = 10;

    /**
     * Number of decimal positions for discount
     */    
    public static final int NUM_DECIMALS = 3;
    
    private PopDefinitionPK ID;
    private MoneyAmount[] discAmount;
    
    /**
     * Constructor
     * @param ID Primary key for this pop definition
     */    
    public PopDefinition(PopDefinitionPK ID) {
        this.ID = ID;
        this.discAmount = new MoneyAmount[PopDefinition.MAX_PRODUCTS];
    }
    
    /**
     * No-args constructor
     */    
    public PopDefinition() {
        this(new PopDefinitionPK(0));
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
        this.ID = (PopDefinitionPK)pk;
    }

    /**
     * Getter for discount amount
     * @param grade Fuel grade
     * @return Discount for requested grade
     */    
    public MoneyAmount getDiscAmount(int grade) {
        if (grade > 0 && grade <= MAX_PRODUCTS)
            return(this.discAmount[grade-1]);
        else 
            return new MoneyAmount(0); 
    }

    /**
     * Setter for discount amount
     * @param grade Fuel grade
     * @param discAmount Discount for designated grade
     */    
    public void setDiscAmount(int grade, MoneyAmount discAmount) {
        if (grade > 0 && grade <= MAX_PRODUCTS)        
            this.discAmount[grade-1] = discAmount;
    }
    
    /** Method to clone the current entity into another
     * @param obj object to be copied to
     */    
    public void setAttributes(IEntityObject obj) {
        PopDefinition pObj = (PopDefinition) obj;
        pObj.setPK(this.getPK());
        for (int i = 1; i <= PopDefinition.MAX_PRODUCTS; i++) {
            pObj.setDiscAmount(i, this.getDiscAmount(i));
        }
    }

    /** Method to validate the primary key of the entity object
     * @return true if the primary key of the entity object is valid
     */
    public boolean isPKValid() {
        return this.ID.isValid();
    }
    
    /** Validator for the entity attributes
     * @throws Exception if validation fails
     */    
    public void validate() throws Exception {
        if (!isPKValid()) {
            throw new Exception ("Invalid ID for PopDefinition: " +this.ID);
        }
        for (int i=0; i < PopDefinition.MAX_PRODUCTS; i++) {
            if (discAmount[i] != null && (discAmount[i].getLongValue() < 0 || (discAmount[i].getLongValue() > MAX_DISCOUNT))) {
                throw new Exception("Invalid Discount Amount: " + discAmount[i] + " for definition: " +
                                        this.ID + " Fuel Product: " + (i+1));
            }
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