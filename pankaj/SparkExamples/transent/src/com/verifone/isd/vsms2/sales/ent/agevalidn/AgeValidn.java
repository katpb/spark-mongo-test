package com.verifone.isd.vsms2.sales.ent.agevalidn;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import java.util.Date;

/** Entity class for age validation
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class AgeValidn implements IEntityObject, ISalesEntityVisitable {
    static final long serialVersionUID = -4248231662155323811L;
    /** Maximum age validations
     */
                
    public static final int MAX_AGE_VALIDNS = 6;
    private static final int MIN_AGE_VALUE = 1;
    private static final int MAX_AGE_VALUE = 200; // !!
    
    private AgeValidnPK ID;
    private String name;
    private int minimumAge;
    private boolean scanOrSwipeOnly;
    private boolean legitimacyCheckRequired;

    /** KKB - CR2452.01 */
    private boolean bypassIDCheck;
    private boolean manualEntryOverride;
    private boolean military;
    private boolean grandfatherDateBased;
    private int bypassSecurityLevel;
    private int manEntryOverrideSecurityLevel;
    private int militaryMinAge;
    private int grandfatherMinAge;
    private String bypassConfirmPrompt;
    private Date grandfatherDateMinAge;
    

   
    /** No-args constructor
     */    
    public AgeValidn() {
    }
    
    /** Constructor
     * @param pk primary key for the entity
     */    
    public AgeValidn(AgeValidnPK pk) {
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

    /** Setter for property confirmPrompt
     * @param name confirmation prompt
     */    
    public void setBypassConfirmPrompt(String bypassConfirmPrompt) {
        this.bypassConfirmPrompt = bypassConfirmPrompt;
    }
    
    /** Getter for property 'confirmPrompt'
     * @return confirmPrompt of the entity
     */    
    public String getBypassConfirmPrompt() {
        return this.bypassConfirmPrompt;
    }

    /** Setter for property confirmPrompt
     * @param name confirmation prompt
     */    
    public void setGrandfatherDateMinAge(Date grandfatherDateMinAge) {
        this.grandfatherDateMinAge = grandfatherDateMinAge;
    }
    
    /** Getter for property 'grandfatherDateMinAge'
     * @return grandfatherDateMinAge of the entity
     */    
    public Date getGrandfatherDateMinAge() {
        return this.grandfatherDateMinAge;
    }
    
    /** Getter for property minimumAge
     * @return minimum age
     */    
    public int getMinimumAge() {
        return this.minimumAge;
    }
    
    /** Setter for minimumAge property
     * @param minimumAge minimum age for the validation to succeed
     */    
    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    /** Getter for property bypassSecurityLevel
     * @return bypassSecurityLevel
     */    
    public int getBypassSecLevel() {
        return this.bypassSecurityLevel;
    }
    
    /** Setter for bypassSecurityLevel property
     * @param bypassSecurityLevel
     */    
    public void setBypassSecLevel(int bypassSecurityLevel) {
        this.bypassSecurityLevel = bypassSecurityLevel;
    }

    /** Getter for property manualEntrySecurityLevel
     * @return manualEntrySecurityLevel
     */    
    public int getManEntryOverrideSecLevel() {
        return this.manEntryOverrideSecurityLevel;
    }
    
    /** Setter for manEntryOverrideSecurityLevel property
     * @param manEntryOverrideSecurityLevel
     */    
    public void setManEntryOverrideSecLevel(int manEntryOverrideSecurityLevel) {
        this.manEntryOverrideSecurityLevel = manEntryOverrideSecurityLevel;
    }

    /** Getter for property militaryMinAge
     * @return militaryMinAge
     */    
    public int getMilitaryMinAge() {
        return this.militaryMinAge;
    }

    /** Setter for property exceptionMilitaryMinAge
     * @return exceptionMilitaryMinAge
     */    
    public void setMilitaryMinAge(int militaryMinAge) {
        this.militaryMinAge = militaryMinAge;
    }


    /**
     * Getter for grandfatherDateBased property    
     * @return grandfatherDateBased - enabled/disabled
     */
    public boolean isGrandfatherDateBased() {
		return grandfatherDateBased;
	}

    /**
     * Setter for grandfatherDateBased property
     * @param grandfatherDateBased 
     */
	public void setGrandfatherDateBased(boolean grandfatherDateBased) {
		this.grandfatherDateBased = grandfatherDateBased;
	}

    /** Getter for property grandfatherMinAge
     * @return grandfatherMinAge
     */    
    public int getGrandfatherMinAge() {
        return this.grandfatherMinAge;
    }

    /** Setter for grandfatherMinAge property
     * @param grandfatherMinAge
     */    
    public void setGrandfatherMinAge(int grandfatherMinAge) {
        this.grandfatherMinAge = grandfatherMinAge;
    }

    /**
     * Getter for manualEntryOverride property    
     * @return manualEntryOverride - enabled/disabled
     */
    public boolean isManualEntryOverride() {
		return manualEntryOverride;
	}

    /**
     * Setter for manualEntryOverride property
     * @param manualEntryOverride 
     */
	public void setManualEntryOverride(boolean manualEntryOverride) {
		this.manualEntryOverride = manualEntryOverride;
	}

    /**
     * Getter for bypassIDCheck property    
     * @return bypassIDCheck - enabled/disabled
     */
    public boolean isBypassIDCheck() {
		return bypassIDCheck;
	}

    /**
     * Setter for Bypass ID Check property
     * @param bypassIDCheck 
     */
	public void setBypassIDCheck(boolean bypassIDCheck) {
		this.bypassIDCheck = bypassIDCheck;
	}

    /**
     * Getter for military property    
     * @return military - enabled/disabled
     */
    public boolean isMilitary() {
		return military;
	}

    /**
     * Setter for military property
     * @param military 
     */
	public void setMilitary(boolean military) {
		this.military = military;
	}
   
    /**
     * Getter for Force swipe/scan property    
     * @return scanOrSwipeOnly - Force scan/swipe enabled/disabled
     */
    public boolean isScanOrSwipeOnly() {
		return scanOrSwipeOnly;
	}

    /**
     * Setter for Force Scan/Swipe property
     * @param scanOrSwipeOnly 
     */
	public void setScanOrSwipeOnly(boolean scanOrSwipeOnly) {
		this.scanOrSwipeOnly = scanOrSwipeOnly;
	}

	/**
	 * Getter for ID Legitimacy Check property
	 * @return legitimacyCheckRequired - ID Legitimacy Check enabled/disabled
	 */	
	public boolean isLegitimacyCheckRequired() {
		return legitimacyCheckRequired;
	}

	/**
	 * Setter for ID Legitimacy Check property
	 * @param legitimacyCheckRequired
	 */	
	public void setLegitimacyCheckRequired(boolean legitimacyCheckRequired) {
		this.legitimacyCheckRequired = legitimacyCheckRequired;
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
        AgeValidn aObj = (AgeValidn) obj;
        aObj.ID = this.ID;
        aObj.name = this.name;
        aObj.minimumAge = this.minimumAge;
        aObj.scanOrSwipeOnly = this.scanOrSwipeOnly;
        aObj.legitimacyCheckRequired = this.legitimacyCheckRequired;
        aObj.bypassIDCheck = this.bypassIDCheck;
        aObj.manualEntryOverride = this.manualEntryOverride;
        aObj.military = this.military;
        aObj.grandfatherDateBased = this.grandfatherDateBased;
        aObj.bypassSecurityLevel = this.bypassSecurityLevel;
        aObj.manEntryOverrideSecurityLevel = this.manEntryOverrideSecurityLevel;
        aObj.bypassConfirmPrompt = this.bypassConfirmPrompt;
        aObj.militaryMinAge = this.militaryMinAge;
        aObj.grandfatherMinAge = this.grandfatherMinAge;
        aObj.grandfatherDateMinAge = this.grandfatherDateMinAge;
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
        this.ID = (AgeValidnPK)pk;        
    }
    
    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {
    	
        if (!isPKValid()) {
            throw new Exception("Invalid age validation: " +this.ID);            
        }
        if ((this.name == null) || (this.name.trim().equals("")) || 
        (this.name.trim().equals("*"))) {
            throw new Exception("Invalid name for age validation: " +ID);
        }     
        if ((this.minimumAge < MIN_AGE_VALUE) || (this.minimumAge > MAX_AGE_VALUE)) {
            throw new Exception("Invalid minimum age: " +this.minimumAge
            +" for age validation: " +ID);
        }

        if ((this.militaryMinAge < MIN_AGE_VALUE) || (this.militaryMinAge > MAX_AGE_VALUE)) {
            throw new Exception("Invalid military minimum age: " +this.militaryMinAge
            +" for age validation: " +ID);
        }
        if ((this.grandfatherMinAge < MIN_AGE_VALUE) || (this.grandfatherMinAge > MAX_AGE_VALUE)) {
            throw new Exception("Invalid date based minimum age: " +this.grandfatherMinAge
            +" for age validation: " +ID);
        }
    }
    
    /** Implementation method for visitor pattern
     * @param v visitor instance
     * @throws Exception propagates exceptions thrown by the visitor class
     * in its visit() method implementation
     */    
    public void accept(SalesEntityVisitor v) throws Exception {
        v.visit(this);
    }
}



