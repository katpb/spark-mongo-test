package com.verifone.isd.vsms2.sales.ent.popsiteinfo;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import com.verifone.isd.vsms2.sys.util.PopModeType;
import com.verifone.isd.vsms2.sys.util.ReceiptPromoType;

/**
 *  entity class for pop site information
 *
 *  @author "mailto:bhanu_narayanan@hp.com"
 *  @version 1.0 Copyright(c) 2000 Hewlett-Packard Company, All Rights Reserved
 */
public class PopSiteInfo implements IEntityObject, ISalesEntityVisitable, Cloneable {
    
    /**
     * Minimum program name length
     */    
    public static final int MIN_PROGRAM_NAME_LEN = 1;
    /**
     * Maximum program name length
     */    
    public static final int MAX_PROGRAM_NAME_LEN = 15;
    /**
     * Minimum discount mode value
     */    
    public static final int MIN_DISC_MODE = 0;
    /**
     * Maximum discount mode value
     */    
    public static final int MAX_DISC_MODE = 2;
    /**
     * Maximum days valid
     */    
    public static final int MAX_DAYS_VALID = 30;
    /**
     * Minimum free code value
     */    
    public static final int MIN_FREE_CODE = 1;
    /**
     * Maximum free code value
     */    
    public static final int MAX_FREE_CODE = 10;
    /**
     * Minimum receipt type
     */    
    public static final int MIN_RCPT_TYPE = 1;
    /**
     * Maximum receipt type
     */    
    public static final int MAX_RCPT_TYPE = 2;
    /**
     * Minimum default level
     */    
    public static final int MIN_DEFAULT_LEVEL = 1;
    /**
     * Maximum default level
     */    
    public static final int MAX_DEFAULT_LEVEL = 2;
    /**
     * Number of decimal positions for amounts
     */    
    public static final int NUM_DECIMALS = 2;
    
    private PopSiteInfoPK pk;
    
    private boolean popEnable;    
    
    /** Holds value of property popMode. */
    private PopModeType popMode;
    
    /** Holds value of property daysCodeValid. */
    private int daysCodeValid;
    
    /** Holds value of property freeCodeDiscountId. */
    private int freeCodeDiscountId;
    
    /** Holds value of property freeAwardSecurity. */
    private int freeAwardSecurity;

    /** Holds value of property freeAutoAwardSecurity. */
    private int freeAutoAwardSecurity;
    
    /** Holds value of property recalcPromptEnable. */
    private boolean recalcPromptEnable;
    
    /** Holds value of property popMembershipName. */
    private String popMembershipName;
    
    /** Holds value of property receiptPromoType. */
    private ReceiptPromoType receiptPromoType;
    
    /** Holds value of property alternatePop. */
    private boolean alternatePop;
    
    /** Holds value of property lowestPriceLevel. */
    private int lowestPriceLevel;
    
    /** Holds value of property memberIdPrompt. */
    private boolean memberIdPrompt;
    
    /** Holds value of property postPayMemberIdEnable. */
    private boolean postPayMemberIdEnable;
    
    /** Holds value of property cardMemberIdEnable. */
    private boolean cardMemberIdEnable;
    
    /** Holds value of property scanMemberIdEnable. */
    private boolean scanMemberIdEnable;
    
    /** Holds value of property fuelLowLimit. */
    private MoneyAmount fuelLowLimit;
    
    /** Getter of the entity object's primary key
     * @return the ID of the entity object
     */
    public IEntityPK getPK() {
        return this.pk;
    }
    
    /** Set the primary key of the entity object
     * @param pk primary key for the entity object
     */
    public void setPK(IEntityPK pk) {
        this.pk = (PopSiteInfoPK)pk;
    }
    
    /** Getter for property popEnable.
     * @return Value of property popEnable.
     *
     */
    public boolean isPopEnable() {
        return this.popEnable;
    }
    
    /** Setter for property popEnable.
     * @param popEnable New value of property popEnable.
     *
     */
    public void setPopEnable(boolean popEnable) {
        this.popEnable = popEnable;
    }
    
    /** Getter for property popMode.
     * @return Value of property popMode.
     *
     */
    public PopModeType getPopMode() {
        return this.popMode;
    }
    
    /** Setter for property popMode.
     * @param popMode New value of property popMode.
     *
     */
    public void setPopMode(PopModeType popMode) {
        this.popMode = popMode;
    }
    
    /** Getter for property daysCodeValid.
     * @return Value of property daysCodeValid.
     *
     */
    public int getDaysCodeValid() {
        return this.daysCodeValid;
    }
    
    /** Setter for property daysCodeValid.
     * @param daysCodeValid New value of property daysCodeValid.
     *
     */
    public void setDaysCodeValid(int daysCodeValid) {
        this.daysCodeValid = daysCodeValid;
    }
    
    /** Getter for property freeCodeDiscountId.
     * @return Value of property freeCodeDiscountId.
     *
     */
    public int getFreeCodeDiscountId() {
        return this.freeCodeDiscountId;
    }
    
    /** Setter for property freeCodeDiscountId.
     * @param freeCodeDiscountId New value of property freeCodeDiscountId.
     *
     */
    public void setFreeCodeDiscountId(int freeCodeDiscountId) {
        this.freeCodeDiscountId = freeCodeDiscountId;
    }
    
    /** Getter for property freeAwardSecurity.
     * @return Value of property freeAwardSecurity.
     *
     */
    public int getFreeAwardSecurity() {
        return this.freeAwardSecurity;
    }
    
    /** Setter for property freeAwardSecurity.
     * @param freeAwardSecurity New value of property freeAwardSecurity.
     *
     */
    public void setFreeAwardSecurity(int freeAwardSecurity) {
        this.freeAwardSecurity = freeAwardSecurity;
    }

    /** Getter for property freeAutoAwardSecurity.
     * @return Value of property freeAutoAwardSecurity.
     *
     */
    public int getFreeAutoAwardSecurity() {
        return this.freeAutoAwardSecurity;
    }
    
    /** Setter for property freeAutoAwardSecurity.
     * @param freeAutoAwardSecurity New value of property freeAutoAwardSecurity.
     *
     */
    public void setFreeAutoAwardSecurity(int freeAutoAwardSecurity) {
        this.freeAutoAwardSecurity = freeAutoAwardSecurity;
    }
    
    /** Getter for property recalcPromptEnable.
     * @return Value of property recalcPromptEnable.
     *
     */
    public boolean isRecalcPromptEnable() {
        return this.recalcPromptEnable;
    }
    
    /** Setter for property recalcPromptEnable.
     * @param recalcPromptEnable New value of property recalcPromptEnable.
     *
     */
    public void setRecalcPromptEnable(boolean recalcPromptEnable) {
        this.recalcPromptEnable = recalcPromptEnable;
    }
    
    /** Getter for property popMembershipName.
     * @return Value of property popMembershipName.
     *
     */
    public String getPopMembershipName() {
        return this.popMembershipName;
    }
    
    /** Setter for property popMembershipName.
     * @param popMembershipName New value of property popMembershipName.
     *
     */
    public void setPopMembershipName(String popMembershipName) {
        this.popMembershipName = popMembershipName;
    }
    
    /** Getter for property receiptPromoType.
     * @return Value of property receiptPromoType.
     *
     */
    public ReceiptPromoType getReceiptPromoType() {
        return this.receiptPromoType;
    }
    
    /** Setter for property receiptPromoType.
     * @param receiptPromoType New value of property receiptPromoType.
     *
     */
    public void setReceiptPromoType(ReceiptPromoType receiptPromoType) {
        this.receiptPromoType = receiptPromoType;
    }
    
    /** Getter for property alternatePop.
     * @return Value of property alternatePop.
     *
     */
    public boolean isAlternatePop() {
        return this.alternatePop;
    }
    
    /** Setter for property alternatePop.
     * @param alternatePop New value of property alternatePop.
     *
     */
    public void setAlternatePop(boolean alternatePop) {
        this.alternatePop = alternatePop;
    }
    
    /** Getter for property lowestPriceLevel.
     * @return Value of property lowestPriceLevel.
     *
     */
    public int getLowestPriceLevel() {
        return this.lowestPriceLevel;
    }
    
    /** Setter for property lowestPriceLevel.
     * @param lowestPriceLevel New value of property lowestPriceLevel.
     *
     */
    public void setLowestPriceLevel(int lowestPriceLevel) {
        this.lowestPriceLevel = lowestPriceLevel;
    }
    
    /** Getter for property memberIdPrompt.
     * @return Value of property memberIdPrompt.
     *
     */
    public boolean isMemberIdPrompt() {
        return this.memberIdPrompt;
    }
    
    /** Setter for property memberIdPrompt.
     * @param memberIdPrompt New value of property memberIdPrompt.
     *
     */
    public void setMemberIdPrompt(boolean memberIdPrompt) {
        this.memberIdPrompt = memberIdPrompt;
    }
    
    /** Getter for property postPayMemberIdEnable.
     * @return Value of property postPayMemberIdEnable.
     *
     */
    public boolean isPostPayMemberIdEnable() {
        return this.postPayMemberIdEnable;
    }
    
    /** Setter for property postPayMemberIdEnable.
     * @param postPayMemberIdEnable New value of property postPayMemberIdEnable.
     *
     */
    public void setPostPayMemberIdEnable(boolean postPayMemberIdEnable) {
        this.postPayMemberIdEnable = postPayMemberIdEnable;
    }
    
    /** Getter for property cardMemberIdEnable.
     * @return Value of property cardMemberIdEnable.
     *
     */
    public boolean isCardMemberIdEnable() {
        return this.cardMemberIdEnable;
    }
    
    /** Setter for property cardMemberIdEnable.
     * @param cardMemberIdEnable New value of property cardMemberIdEnable.
     *
     */
    public void setCardMemberIdEnable(boolean cardMemberIdEnable) {
        this.cardMemberIdEnable = cardMemberIdEnable;
    }
    
    /** Getter for property scanMemberIdEnable.
     * @return Value of property scanMemberIdEnable.
     *
     */
    public boolean isScanMemberIdEnable() {
        return this.scanMemberIdEnable;
    }
    
    /** Setter for property scanMemberIdEnable.
     * @param scanMemberIdEnable New value of property scanMemberIdEnable.
     *
     */
    public void setScanMemberIdEnable(boolean scanMemberIdEnable) {
        this.scanMemberIdEnable = scanMemberIdEnable;
    }

    /** Getter for property fuelLowLimit.
     * @return Value of property fuelLowLimit.
     *
     */
    public MoneyAmount getFuelLowLimit() {
        return this.fuelLowLimit;
    }

    /** Setter for property fuelLowLimit.
     * @param fuelLowLimit New value of property fuelLowLimit.
     *
     */
    public void setFuelLowLimit(MoneyAmount fuelLowLimit) {
        this.fuelLowLimit = fuelLowLimit;
    }

    /** Method to validate the primary key of the entity object
     * @return true if the primary key of the entity object is valid
     */
    public boolean isPKValid() {
        if (this.pk == null) {
            this.pk = new PopSiteInfoPK();
        }
        return this.pk.isValid();
    }
    
    /** sets the attributes of the new object; this operation is similar to deep
     * cloning
     * @param obj the target object to be written into
     */
    public void setAttributes(IEntityObject obj) {
        PopSiteInfo newPSI = (PopSiteInfo)obj;
        newPSI.popEnable = this.popEnable;
        newPSI.popMode = this.popMode;
        newPSI.daysCodeValid = this.daysCodeValid;
        newPSI.freeCodeDiscountId = this.freeCodeDiscountId;
        newPSI.freeAwardSecurity = this.freeAwardSecurity;
        newPSI.recalcPromptEnable = this.recalcPromptEnable;
        newPSI.popMembershipName = this.popMembershipName;
        newPSI.receiptPromoType = this.receiptPromoType;
        newPSI.alternatePop = this.alternatePop;
        newPSI.lowestPriceLevel = this.lowestPriceLevel;
        newPSI.memberIdPrompt = this.memberIdPrompt;
        newPSI.postPayMemberIdEnable = this.postPayMemberIdEnable;
        newPSI.cardMemberIdEnable = this.cardMemberIdEnable;
        newPSI.scanMemberIdEnable = this.scanMemberIdEnable;
        newPSI.fuelLowLimit = this.fuelLowLimit;
        newPSI.freeAutoAwardSecurity = this.freeAutoAwardSecurity;
    }
    
    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {
    	if (this.daysCodeValid > MAX_DAYS_VALID) {
    		throw new Exception ("Invalid value for daysCodeValid - " + this.daysCodeValid);
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