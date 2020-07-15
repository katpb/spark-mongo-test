/*
 * SiteInfo.java
 * Copyright (C) 2012 Verifone, Inc.                     ALL RIGHTS RESERVED
 */
package com.verifone.isd.vsms2.sys.ent.siteinfo;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.ent.ISystemEntityVisitable;
import com.verifone.isd.vsms2.sys.ent.ISystemEntityVisitor;
import com.verifone.isd.vsms2.sys.util.DateTransformer;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  entity class for SiteInfo
 *  @author "mailto:david_g3@verifone.com"
 */
public class SiteInfo implements IEntityObject, ISystemEntityVisitable {
    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sys.ent.siteinfo.SiteInfo.class);
    static final long serialVersionUID = -7285675504120477639L;
    
    private SiteInfoPK ID;
    private String postalCode;
    private String telephoneNumber;
    private String enteredGemkey;
    private String registrationDateTime;
    private String helpdeskNumber;
    
    public static final int MAX_POSTALCODE_SIZE = 12;
    public static final int MAX_TELEPHONENUMBER_SIZE = 40;
    public static final int MAX_ENTEREDGEMKEY_SIZE = 10;
    public static final int MAX_REGISTRATIONDATETIME_SIZE = 26;
    
    // Default constructor...
    public SiteInfo() {
        this.ID = new SiteInfoPK();
    }

    /**
     * @return the postalCodeString
     */
    public String getPostalCode() {
        return (postalCode == null) ? "" : postalCode;
    }

    /** Set the site postal code after forcing to uppercase
     * @param postalCodeString the postalCodeString to set
     */
    public void setPostalCode(String postalCodeString) {
        this.postalCode = postalCodeString.toUpperCase().trim();
    }

    /**
     * @return the telephoneNumber
     */
    public String getTelephoneNumber() {
        return (telephoneNumber == null) ? "" : telephoneNumber;
    }

    /** Set the site telephone number after removing any embedded hyphens, periods, or spaces
     * @param telephoneNumber the telephoneNumber to set
     */
    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber.replaceAll("-", "").replaceAll("\\.", "").replaceAll(" ", "").trim();
    }

    /**
     * @return the enteredGemkey
     */
    public String getEnteredGemkey() {
        return (enteredGemkey == null) ? "" : enteredGemkey;
    }

    /** Set the site Gemkey after removing any embedded hyphens, periods, or spaces.
     * Also fill in the date/time of when the Gemkey was entered.
     * <br>
     * NOTE: SiteInfoPersistState will override the registration date/time populated here
     * by calling setRegistrationDateTime() to fill in the date/time from the database.
     * @param enteredGemkey the enteredGemkey to set
     */
    public void setEnteredGemkey(String enteredGemkey) {
        this.enteredGemkey = enteredGemkey.replaceAll("-", "").replaceAll("\\.", "").replaceAll(" ", "").trim();

        try {
            String ISODate = new DateTransformer().transformToISODate(new Date());
            setRegistrationDateTime(ISODate);
        }
        catch (Exception e) {
            logger.error("Exception setting registration date/time: {}", e.getMessage());            
        }
    }

    /**
     * @return the registrationDateTime
     */
    public String getRegistrationDateTime() {
        return (registrationDateTime == null) ? "" : registrationDateTime;
    }

    /**
     * @param registrationDateTime the registrationDateTime to set
     * <br>
     * NOTE: SiteInfoPersistState will override the registration date/time populated by setEnteredGemkey()
     * by calling setRegistrationDateTime() to fill in the date/time obtained from the database.
     * <i>Use this setter by any other class must be avoided.</i>
     */
    public void setRegistrationDateTime(String registrationDateTime) {
        this.registrationDateTime = registrationDateTime;
    }
    
    @Override
    /** Ensure the validity of the data fields, if given.
     *  <li>Postal code must have no control characters and must not exceed allowed length</li>
     *  <li>Telephone number must have no control characters, must consist of digits only, and must not exceed allowed length</li>
     *  <li>Gemkey must have no control characters, must consist of digits only, and must not exceed allowed length</li>
     * @exception java.lang.Exception contains error message for user
     */
    public void validate() throws Exception {
        if (!isPKValid()) {
            throw new Exception("Invalid siteinfo: " +ID);
        }
        
        if ((this.postalCode != null) &&
            ((this.postalCode.matches(".*\\p{Cntrl}.*")) ||
             (this.postalCode.length() > SiteInfo.MAX_POSTALCODE_SIZE)))
        {
            throw new Exception("Invalid site postal code: " + this.postalCode);
        }

        if ((this.telephoneNumber != null) &&
            ((this.telephoneNumber.matches(".*\\p{Cntrl}.*")) ||
             (!this.telephoneNumber.matches("([0-9]*)")) ||
             (this.telephoneNumber.length() > SiteInfo.MAX_TELEPHONENUMBER_SIZE)))
        {
            throw new Exception("Invalid site telephone number: " + this.telephoneNumber);
        }

        if ((this.enteredGemkey != null) &&
            ((this.enteredGemkey.matches(".*\\p{Cntrl}.*")) ||
             (!this.enteredGemkey.matches("([0-9]*)")) ||
             (this.enteredGemkey.length() > SiteInfo.MAX_ENTEREDGEMKEY_SIZE)))
        {
            throw new Exception("Invalid site registration key (Gemkey): " + this.enteredGemkey);
        }
        
        if ((this.helpdeskNumber != null) &&
           ((this.helpdeskNumber.matches(".*\\p{Cntrl}.*")) ||
           (!this.helpdeskNumber.matches("([0-9]*)")) ||
           (this.helpdeskNumber.length() > SiteInfo.MAX_TELEPHONENUMBER_SIZE)))
           {
                throw new Exception("Invalid site help desk number: " + this.helpdeskNumber);
           }
    }
    
    /** Getter of the entity object's primary key
     * @return the ID of the entity object
     */
    @Override
    public IEntityPK getPK() {
        return ID;
    }
    
    /** Method to validate the primary key of the entity object
     * @return true if the primary key of the entity object is valid
     */
    @Override
    public boolean isPKValid() {
        return (ID == null) ? false : ID.isValid();
    }
    
    /** sets the attributes of the new object; this operation is similar to deep
     * cloning
     * @param obj the target object to be written into
     */
    @Override
    public void setAttributes(IEntityObject obj) {
        SiteInfo eObj = (SiteInfo) obj;
        eObj.setPK(this.getPK());
        eObj.setPostalCode(this.getPostalCode());
        eObj.setTelephoneNumber(this.getTelephoneNumber());
        eObj.setEnteredGemkey(this.getEnteredGemkey());
        eObj.setRegistrationDateTime(this.getRegistrationDateTime());
        eObj.setHelpdeskNumber(this.getHelpdeskNumber());
    }
    
    /** Set the primary key of the entity object
     * @param pk primary key for the entity object
     */
    @Override
    public void setPK(IEntityPK pk) {
        this.ID = (SiteInfoPK)pk;
    }
    
    @Override
    public void accept(ISystemEntityVisitor v) throws Exception {
        // This class is not directly visitable.
    }

	public String getHelpdeskNumber() {
		return (this.helpdeskNumber == null) ? "" : helpdeskNumber;
	}

	public void setHelpdeskNumber(String helpdeskNumber) {
		this.helpdeskNumber = helpdeskNumber.replaceAll("-", "").replaceAll("\\.", "").replaceAll(" ", "").trim();
	}
}
