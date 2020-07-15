/*
 * NetCCardConfig.java
 *
 * Created on February 13, 2003, 2:49 PM
 */

package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;

/** This is the common interface used to imply an ISO record within the credit card configuration dataset.
 * Since ISO records are network specific, each network must implement this interface in their credit card
 * configuration. "NetCCardConfigSet" is a generic class and is a Vector containing all the ISO records of
 * type INetCCardConfig.
 * @author  Anindya_D1
 * @see NetCCardConfigSet
 */
public interface INetCCardConfig extends IEntityObject {
    static final long serialVersionUID = -8797117250449497957L;
    
    public boolean equals(Object obj);
    
    public CardTypeDef getCCTypeObj();
    
    /**
	 * Allow applications to return a unique value for the card type which is
	 * same as the <code>cc_type</code> used in GEMPRO
	 * 
	 * @return card type value
	 */
    public int getCCTypeValue();
    
    public AcctValidationIndexDef getAcctValidationIndexObj();
    
    public String getCCName();
    
    public boolean isPropCard();
    
    public String getCCAbbrev();
    
    public boolean isEnabled();
    
    public boolean isFeeApplied();    
    
    public int getAuthNetwork();
    
    public String getAuthNetName();
    
    public boolean isPrimaryEntryForCardType();
    
    public int getPanLength1();
    
    public int getPanLength2();
    
    public String getBeginISO();
    
    public String getEndISO();
    
    public boolean getPinPromptFlag();
    
    public int getPinPromptIndex();
    
    public void addPinPrompt(int pinMask);
    
    public boolean isPromptExpDateOnManualEntry();
    
    public boolean isSkipExpDateValidation();    
    
    public String getExpiryDateFormat();    
    
    public byte getProdRestriction();
    
    public void setProdRestriction(byte restriction);
    
    public String getVoiceAuthPhone();        
    
    /**
	 * Indicates if the card can be used as Debit at a CAT terminal (e.g. DCR,
	 * car wash paypoint)
	 * 
	 * @return true if card can be used as Debit at a CAT terminal
	 */
	public boolean getDcrDebitSwipe();
    
    public boolean isDebitCard();
    
    public boolean isPrepaidCard();
    
    public void setDebitCard();
    
    public boolean processLikeDebit();
    /**
	 * Based on the card type and / or network host, determine if encrypted track data 
	 * needs to be preserved in the database to generate automatic completion / refund.
	 *  
	 * @return true if encrypted track data can be preserved, false otherwise
	 */
	public boolean preserveEncryptedTrack();
	/**
	 * 
	 * @return the Debit Host ID to be used for Master Session
	 */
	public int getDebitHostID();
}
