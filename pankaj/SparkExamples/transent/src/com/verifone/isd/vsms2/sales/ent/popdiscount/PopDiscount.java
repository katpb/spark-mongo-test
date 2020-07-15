package com.verifone.isd.vsms2.sales.ent.popdiscount;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.popdefinition.PopDefinitionPK;
import com.verifone.isd.vsms2.sys.util.PopAwardType;

/**
 *  entity class for popDiscount
 *
 *  @author "mailto:mike_reese@verifone.com"
 *  @version 1.0 Copyright(c) 2003 VeriFone, Inc., All Rights Reserved
 */
public class PopDiscount implements IEntityObject, ISalesEntityVisitable {
    /**
     * Maximum number of pop discounts
     */    
    public static final int MAX_POPDISCOUNTS = 25;
    /**
     * Maximum pop discount ID
     */    
    public static final int MAX_POPDISCOUNT_ID = MAX_POPDISCOUNTS;
    /**
     * Number of decimal positions for amounts
     */    
    public static final int NUM_DECIMALS = 0;

    /**
     * Representation for min amount on Ruby
     */    
    public static final String MIN_AMOUNT = "A";
    /**
     * Representation for min volume on Ruby
     */    
    public static final String MIN_VOLUME = "Q";
    /**
     * Representation for by date on Ruby
     */    
    public static final int BY_DATE = 1;
    /**
     * Representation for by day on Ruby
     */    
    public static final int BY_DAY  = 2;
    /**
     * Representation for bar code on Ruby
     */    
    public static final int BAR_CODE   = 1;
    /**
     * Representation for mag stripe on Ruby
     */    
    public static final int MAG_STRIPE = 2;
    /**
     * Representation for discount only on Ruby
     */    
    public static final int DISCOUNT_ONLY    = 1;
    /**
     * Representation for discount or code on Ruby
     */    
    public static final int DISCOUNT_OR_CODE = 2;
    /**
     * Representation for coupon only on Ruby
     */    
    public static final int COUPON_ONLY      = 3;
    /**
     * Representation for PLU based discount on Ruby
     */    
    public static final int PLU_BASED_DISCOUNT      = 1;
    /**
     * Representation for MOP based discount on Ruby
     */    
    public static final int MOP_BASED_DISCOUNT      = 2;
    /**
     * Representation for card based discount on Ruby
     */    
    public static final int CARD_BASED_DISCOUNT     = 3;
    /**
     * Representation for min amount based discount on Ruby
     */    
    public static final int MIN_AMOUNT_DISCOUNT     = 4;
    /**
     * Representation for min department purchase based discount on Ruby
     */    
    public static final int MIN_DEPT_PURCH_DISCOUNT = 5;
    /**
     * Representation for member based discount on Ruby
     */    
    public static final int MEMBER_BASED_DISCOUNT   = 6;
    
    /**
     * Representation for no POP by BIN configurations on Ruby
     */    
    public static final int BIN_TYPE_NONE  = 0;
    
    /**
     * Representation for Mask based POP by BIN configurations on Ruby
     */    
    public static final int BIN_TYPE_MASK  = 1;
    
    /**
     * Representation for Bin Range POP by BIN configurations on Ruby
     */    
    public static final int BIN_TYPE_RANGE  = 2;
    
    private PopDiscountPK ID;
    private String description;
    private IPopScheduleType scheduleType;
    private PopDefinitionPK popDefinitionNum;
    private PopAwardType awardType;
    private IPopDiscountType discountType;
    
    /**
     * Constructor
     * @param ID ID for this pop discount
     */    
    public PopDiscount(PopDiscountPK ID) {
        this.ID = ID;
        this.description = "";
    }
    
    /**
     * No-args constructor
     */    
    public PopDiscount() {
        this(new PopDiscountPK(0));
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
        this.ID = (PopDiscountPK)pk;
    }

    /**
     * Getter for description property
     * @return Description of this pop discount
     */    
    public String getDescription() {
        return this.description;
    }
    
    /**
     * Setter for description property
     * @param description description of this pop discount
     */    
    public void setDescription(String description) {
        if (description == null) {
            this.description = "";
        }
        else {
            this.description = description;
        }
    }

    /**
     * Getter for scheduleType property
     * @return Schedule type
     */    
    public IPopScheduleType getScheduleType() {
        return this.scheduleType;
    }
    
    /**
     * Setter for scheduleType property
     * @param sType Schedule type
     */    
    public void setScheduleType(IPopScheduleType sType) {
        this.scheduleType = sType;
    }

    /**
     * Getter for popDefinitionNum property
     * @return Pop definition number
     */    
    public PopDefinitionPK getPopDefinitionNum() {
        return this.popDefinitionNum;
    }
    
    /**
     * Setter for popDefinitionNum property
     * @param defNum Pop definition number
     */    
    public void setPopDefinitionNum(PopDefinitionPK defNum) {
        this.popDefinitionNum = defNum;
    }

    /**
     * Getter for awardType property
     * @return Award type
     */    
    public PopAwardType getAwardType() {
        return this.awardType;
    }
    
    /**
     * Setter for awardType property
     * @param award Award type
     */    
    public void setAwardType(PopAwardType award) {
        this.awardType = award;
    }

    /**
     * Getter for discountType property
     * @return Discount type
     */    
    public IPopDiscountType getDiscountType() {
        return this.discountType;
    }
    
    /**
     * Setter for discountType property
     * @param dType Discount type
     */    
    public void setDiscountType(IPopDiscountType dType) {
        this.discountType = dType;
    }

    /** Method to clone the current entity into another
     * @param obj object to be copied to
     */    
    public void setAttributes(IEntityObject obj) {
        PopDiscount pObj = (PopDiscount) obj;
        pObj.setPK(this.getPK());
        pObj.setDescription(this.getDescription());
        pObj.setScheduleType(this.getScheduleType());
        pObj.setPopDefinitionNum(this.getPopDefinitionNum());
        pObj.setAwardType(this.getAwardType());
        pObj.setDiscountType(this.getDiscountType());
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
        if (!this.ID.isValid()) {
            throw new Exception ("Invalid ID for PopDiscount: " +this.ID);
        }
        if (popDefinitionNum != null) {
            if (!popDefinitionNum.isValid()) {
                throw new Exception("Invalid Definition Value: " + popDefinitionNum +
                                                            " for POP Discount: " + this.ID);
            }
        }
        discountType.validate();
    }

    /** Implementation method for visitable in the visitor pattern
     * @param v visitor
     * @throws Exception on exception in visitor's visit method
     */    
    public void accept(SalesEntityVisitor v) throws Exception {
        v.visit(this);
    }
}