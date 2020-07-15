package com.verifone.isd.vsms2.sales.ent.bluelaw;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
/** Entity class for blue law
 * @author "mailto:bhanu_n2@verifone.com"
 * @version 1.0
 */
public class BlueLaw implements IEntityObject, ISalesEntityVisitable {
    static final long serialVersionUID = -7530059168402884506L;
    /** Maximum blue laws
     */    
    public static final int MAX_BLUELAWS = 2;
    /** Weekly configuration for blue law */
    public static final int MAX_BLUELAWDAYS = 7; // All days of a week    
    private BlueLawPK ID;
    private BlueLawProps[] dayRestrictions;
   
    /** No-args constructor
     */    
    public BlueLaw() {
        this.dayRestrictions = new BlueLawProps[MAX_BLUELAWDAYS];  
    }
    
    /** Constructor
     * @param pk primary key for the entity
     */    
    public BlueLaw (BlueLawPK pk) {
        this.ID = pk;
        this.dayRestrictions = new BlueLawProps[MAX_BLUELAWDAYS];        
    }
    
    /** Getter of the entity object's primary key
     * @return the ID of the entity object
     */
    public IEntityPK getPK() {
        return this.ID;
    }
    
    /** Getter for a given weekday's bluelaw properties
     * @param day day of week (use Calendar.SUNDAY thro' Calendar.SATURDAY as parameter)
     * @return bluelaw properties for the day of week
     */    
    public BlueLawProps getDayRestriction(int day) {
        if (this.dayRestrictions[day-1] == null) {
            this.dayRestrictions[day-1] = new BlueLawProps();
        }
        return this.dayRestrictions[day-1];
    }
    
    /** Set the bluelaw properties for a given day of week
     * @param day day of week (use Calendar.SUNDAY thro' Calendar.SATURDAY as parameter)
     * @param newR bluelaw properties for the day
     */    
    public void setDayRestriction(int day, BlueLawProps newR) {
        this.dayRestrictions[day-1] = newR;
    }

    /** Method to set attributes of another entity from this entity (clone)
     * @param obj entity to copy to
     */    
    public void setAttributes(IEntityObject obj) {
        BlueLaw bObj = (BlueLaw) obj;
        bObj.ID = this.ID;
        for (int i = 1; i <= dayRestrictions.length; i++) {
            bObj.setDayRestriction(i, this.getDayRestriction(i));
        }
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
        this.ID = (BlueLawPK)pk;        
    }
    
    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {
        if (!isPKValid()) {
            throw new Exception("Invalid blue law: " +this.ID);            
        }
        for (int i = 1; i <= MAX_BLUELAWDAYS; i++) {
            BlueLawProps curRestr = this.getDayRestriction(i);
            try {
                curRestr.validate();
            }
            catch (Exception e) {
                throw new Exception("Blue law: " +this.ID +" Day: " +i
                +" - " +e.getMessage());
            }
        }
    }
    
    /** Implementation method for visitable class in the visitor pattern
     * @param v visitor
     * @throws Exception propagates exceptions from the visitor's visit() method
     */    
    public void accept(SalesEntityVisitor v) throws Exception {
        v.visit(this);
    }    
}



