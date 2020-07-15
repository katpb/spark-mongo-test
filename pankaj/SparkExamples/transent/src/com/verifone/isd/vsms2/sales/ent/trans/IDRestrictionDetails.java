package com.verifone.isd.vsms2.sales.ent.trans;

import java.util.Date;

/*
 * File used to be 'IDForceScanLegitDetails'.  
 * Encompasses additional features besides forceScanLegit
 */
public class IDRestrictionDetails implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1742258829942302018L;


	public IDRestrictionDetails(){
	}
	
	/*
	* ForceScanNeeded will be set when item rung up that has a restriction that has 
	* "Force Scan/Swipe Only" flag set.
	*/
	private boolean forceScanNeeded  = false;
	/*
	* ForceScanDone will be set when item successfully done a swipe or scan of the ID.
	*/
	private boolean forceScanDone  = false;
	/*
	* IDLegitimacyCheckNeeded will be set when item rung up that has a restriction that has 
	* "Perform ID Legitimacy Check" flag set.
	*/
	private boolean idLegitimacyCheckNeeded  = false;
	/*
	* IDLegitimacyCheckDone will be set when the ID successfully been confirmed by the cashier.
	*/
	private boolean idLegitimacyCheckDone  = false;
	
	// Bypass IDCheck
	private boolean bypassIDCheck = false;
	
	// Manual Entry Override
	private boolean manEntryOverride = false;
	
	// Manual Entry Override customer
	private boolean manEntryOverrideCustomer = false;
	
	// Military
	private boolean military = false;
	
	// Military customer
	private boolean militaryCustomer = false;
	
	// Grandfather Date Based
	private boolean grandfather = false;
	

	// Bypass ID Check customer
	private boolean bypassIDCustomer = false;
	
	// Bypass ID Check Security Level
	private int bypassIDSecLevel = 0;
	
	// Manual Entry Override Security Level
	private int manEntryOverrideSecLevel = 0;
	
	// Military Min Age
	private int militaryMinAge = 0;
	
	// Grandfather Min Age (date based)
	private int grandfatherMinAge = 0;
	
	// Bypass ID Confirmation Prompt
	private String bypassIDConfirmPrompt = null;
	
	// Grandfather Min Age Date (date based)
	private Date grandfatherMinAgeDate = null;
	

	
	public boolean isForceScanNeeded() {
		return forceScanNeeded;
	}
	public void setForceScanNeeded(boolean forceScanNeeded) {
		this.forceScanNeeded = forceScanNeeded;
	}
	public boolean isForceScanDone() {
		return forceScanDone;
	}
	public void setForceScanDone(boolean forceScanDone) {
		this.forceScanDone = forceScanDone;
	}
	public boolean isIDLegitimacyCheckNeeded() {
		return idLegitimacyCheckNeeded;
	}
	public void setIDLegitimacyCheckNeeded(boolean iDLegitimacyCheckNeeded) {
		this.idLegitimacyCheckNeeded = iDLegitimacyCheckNeeded;
	}
	public boolean isIDLegitimacyCheckDone() {
		return idLegitimacyCheckDone;
	}
	public void setIDLegitimacyCheckDone(boolean iDLegitimacyCheckDone) {
		this.idLegitimacyCheckDone = iDLegitimacyCheckDone;
	}
	
	/////////////////// CR2452.01 ////////////////////
	public boolean isBypassIDCustomer() {
		return bypassIDCustomer;
	}
	public void setBypassIDCustomer( boolean bypassIDCustomer) {
		this.bypassIDCustomer = bypassIDCustomer;
	}
	
	public boolean isBypassIDCheck() {
		return bypassIDCheck;
	}
	public void setBypassIDCheck( boolean bypassIDCheck) {
		this.bypassIDCheck = bypassIDCheck;
	}
	
	public boolean isManEntryOverride() {
		return manEntryOverride;
	}
	public void setManEntryOverride( boolean manEntryOverride) {
		this.manEntryOverride = manEntryOverride;
	}
	
	public boolean isManEntryOverrideCustomer() {
		return manEntryOverrideCustomer;
	}
	public void setManEntryOverrideCustomer( boolean manEntryOverrideCustomer) {
		this.manEntryOverrideCustomer = manEntryOverrideCustomer;
	}
	
	public boolean isMilitary() {
		return military;
	}
	public void setMilitary( boolean military) {
		this.military = military;
	}
	
	public boolean isMilitaryCustomer() {
		return militaryCustomer;
	}
	public void setMilitaryCustomer( boolean militaryCustomer) {
		this.militaryCustomer = militaryCustomer;
	}
	
	public boolean isGrandfather() {
		return grandfather;
	}
	public void setGrandfather( boolean grandfather) {
		this.grandfather = grandfather;
	}
	
	public int getBypassIDSecLevel() {
		return bypassIDSecLevel;
	}
	public void setBypassIDSecLevel( int bypassIDSecLevel) {
		this.bypassIDSecLevel = bypassIDSecLevel;
	}
	
	public int getManEntryOverrideSecLevel() {
		return manEntryOverrideSecLevel;
	}
	public void setManEntryOverrideSecLevel( int manEntryOverrideSecLevel) {
		this.manEntryOverrideSecLevel = manEntryOverrideSecLevel;
	}
	
	public int getMilitaryMinAge() {
		return militaryMinAge;
	}
	public void setMilitaryMinAge( int militaryMinAge) {
		this.militaryMinAge = militaryMinAge;
	}
	
	public int getGrandfatherMinAge() {
		return grandfatherMinAge;
	}
	public void setGrandfatherMinAge( int grandfatherMinAge) {
		this.grandfatherMinAge = grandfatherMinAge;
	}
	
	public String getBypassIDConfirmPrompt() {
		return bypassIDConfirmPrompt;
	}
	public void setBypassIDConfirmPrompt( String bypassIDConfirmPrompt) {
		this.bypassIDConfirmPrompt = bypassIDConfirmPrompt;
	}
	
	public Date getGrandfatherDate() {
		return grandfatherMinAgeDate;
	}
	public void setGrandfatherDate( Date grandfatherMinAgeDate) {
		this.grandfatherMinAgeDate = grandfatherMinAgeDate;
	}
	
}
