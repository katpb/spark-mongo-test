
/*
 * NetCCardConfig.java
 *
 * Created on February 13, 2003, 2:49 PM
 */

package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;

import java.io.Serializable;

/**
 *
 * @author  Anindya_D1
 */
public abstract class NetCCardConfigBase implements INetCCardConfig, INetEntityVisitable, Serializable {
    static final long serialVersionUID = 1006645270943260003L;
    
    public static int MAXCCABBREV = 2;
    public static int MAXISOLEN = 19;
    public static final int PHONENR_MAXLEN = 40;
    public static final int MAX_PRT_MASK = 25;
    
    public static final String EXP_DATE_FORMAT_1 = "yymm";
    public static final String EXP_DATE_FORMAT_2 = "mmyy";    
    
    protected boolean primaryEntryForCardType;
    protected String ccAbbrev;
    protected CardTypeDef ccType;
    protected boolean enabled;
    protected int floorLimit;
    protected byte prodRestriction;
    protected String voiceAuthPhone;
    protected String beginISO;
    protected String endISO;
    protected int authNetwork;  // reference to the authorizing network 
    protected String authNetName;   // Auth Network Name used to resolve primary vs proprietary (NET1, NET2)
    protected int voiceAuthNetwork;
    protected AcctValidationIndexDef acctValidationIndex;
    protected int panLength1;
    protected int panLength2;
    protected boolean pinPromptFlag;
    protected int pinPromptIndex;
    protected int terminalTimeout;
    protected boolean disableManual;
    protected MoneyAmount dcrLimit;
    protected MoneyAmount dcrAuthAmt;
    protected boolean dcrEnabled;
    protected boolean dcrHotPump;
    protected boolean dcrFallBack;
    protected boolean dcrMaskAccount;
    protected boolean dcrLast4Digits;
    protected int smallCreditAmt; //refernce to small credit amount
	protected int cashCreditpricing; //refernce to cash credti flag
	
	/* multiple eps */
	protected boolean isPrimary = true;
	
	//Introduced with cr0192.01 
	protected boolean lowFee;

    protected NetCCardConfigPK ID;
    
    /** Holds value of property feeApplied. */
    private boolean feeApplied;
    
    /** Holds value of property promptExpDateOnManualEntry. */
    private boolean promptExpDateOnManualEntry;
    
    /** Holds value of property skipExpDateValidation. */
    private boolean skipExpDateValidation;
    
    /** Holds value of property expiryDateFormat. */
    private String expiryDateFormat;
    
    /** Creates a new instance of NetCCardConfig */
    public NetCCardConfigBase() {
        ccAbbrev = new String("");
        voiceAuthPhone = new String("");
        beginISO = new String("");
        endISO = new String("");
        authNetName = new String("");
        dcrLimit = new MoneyAmount(0);
        dcrAuthAmt = new MoneyAmount(0);
    }
    
    public boolean isPropCard() {
        return (authNetName.equalsIgnoreCase("PROPNET"));
    }
    
    public boolean isPrimaryEntryForCardType() {
        return this.primaryEntryForCardType;
    }
    
    public void setPrimaryEntryForCardType(boolean primaryEntryForCardType) {
        this.primaryEntryForCardType = primaryEntryForCardType;
    }
    
    public String getCCAbbrev() {
        return this.ccAbbrev;
    }
    
    public void setCCAbbrev(String ccAbbrev) {
        this.ccAbbrev = ccAbbrev;
    }
    
    public CardTypeDef getCCTypeObj() {
        return this.ccType;
    }
    
    public void setCCType(CardTypeDef ccType) {
        this.ccType = ccType;
    }
    
    /*
     * (non-Javadoc)
     * @see com.verifone.isd.vsms2.net.ent.INetCCardConfig#getCCTypeValue()
     */
	public int getCCTypeValue() {
		if (ccType != null) {
			return ccType.getValue();
		} else {
			return 0;
		}
	}
    
    public void setCCName(String ccName) {
    	ID = new NetCCardConfigPK(ccName);
    }
    

    public String getCCName() {
        return this.ID.getValue();
    }
    
    public boolean isEnabled() {
        return this.enabled;
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    public int getFloorLimit() {
        return this.floorLimit;
    }
    
    public void setFloorLimit(int floorLimit) {
        this.floorLimit = floorLimit;
    }
    
    public byte getProdRestriction() {
        return this.prodRestriction;
    }
    
    public void setProdRestriction(byte prodRestriction) {
        this.prodRestriction = prodRestriction;
    }
    
    public String getVoiceAuthPhone() {
        return this.voiceAuthPhone;
    }
    
    public void setVoiceAuthPhone(String voiceAuthPhone) {
        this.voiceAuthPhone = voiceAuthPhone;
    }
    
    public String getBeginISO() {
        return this.beginISO;
    }
    
    public void setBeginISO(String beginISO) {
        this.beginISO = beginISO;
    }
    
    public String getEndISO() {
        return this.endISO;
    }
    
    public void setEndISO(String endISO) {
        this.endISO = endISO;
    }
    
    /**
	 * @return the isPrimary
	 */
	public boolean isPrimary() {
		return isPrimary;
	}

	/**
	 * @param isPrimary the isPrimary to set
	 */
	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public int getAuthNetwork() {
        return this.authNetwork;
    }
    
    public void setAuthNetwork(int authNetwork) {
        this.authNetwork = authNetwork;
    }
    
    public String getAuthNetName() {
        return this.authNetName;
    }
    
    public void setAuthNetName(String name) {
        this.authNetName = name;
    }
    
    public int getVoiceAuthNetwork() {
        return this.voiceAuthNetwork;
    }
    
    public void setVoiceAuthNetwork(int voiceAuthNetwork) {
        this.voiceAuthNetwork = voiceAuthNetwork;
    }
    
    public AcctValidationIndexDef getAcctValidationIndexObj() {
        return this.acctValidationIndex;
    }
    
    public void setAcctValidationIndex(AcctValidationIndexDef acctValidationIndex) {
        this.acctValidationIndex = acctValidationIndex;
    }
    
    public int getPanLength1() {
        return this.panLength1;
    }
    
    public void setPanLength1(int panLength1) {
        this.panLength1 = panLength1;
    }
    
    public int getPanLength2() {
        return this.panLength2;
    }
    
    public void setPanLength2(int panLength2) {
        this.panLength2 = panLength2;
    }
    
    public boolean getPinPromptFlag() {
        return this.pinPromptFlag;
    }
    
    public void setPinPromptFlag(boolean pinPromptFlag) {
        this.pinPromptFlag = pinPromptFlag;
    }
    
    public void setDisableManual(boolean disableManual){
        this.disableManual = disableManual;
    }
    
    public boolean getDisableManual(){
        return this.disableManual;
    }
    
    public int getPinPromptIndex() {
        return this.pinPromptIndex;
    }
    
    public void setPinPromptIndex(int pinPromptIndex) {
        this.pinPromptIndex = pinPromptIndex;
    }
    
    public void addPinPrompt(int pinMask) {
        this.pinPromptIndex |= pinMask;
    }
    
    public int getTerminalTimeout() {
        return this.terminalTimeout;
    }
    
    public void setTerminalTimeout(int terminalTimeout) {
        this.terminalTimeout = terminalTimeout;
    }
    
    /**
	 * @return the dcrAuthAmt
	 */
	public MoneyAmount getDcrAuthAmt() {
		return dcrAuthAmt;
	}

	/**
	 * @param dcrAuthAmt the dcrAuthAmt to set
	 */
	public void setDcrAuthAmt(MoneyAmount dcrAuthAmt) {
		if (dcrAuthAmt != null) {
        this.dcrAuthAmt = dcrAuthAmt;
    }
	}

	/**
	 * @return the dcrLimit
	 */
	public MoneyAmount getDcrLimit() {
		return dcrLimit;
	}

	/**
	 * @param dcrLimit the dcrLimit to set
	 */
	public void setDcrLimit(MoneyAmount dcrLimit) {
		if (dcrLimit != null) {
			this.dcrLimit = dcrLimit;
		}
	}
    
    public boolean getDcrEnabled() {
        return this.dcrEnabled;
    }
    
    public void setDcrEnabled(boolean dcrEnabled) {
        this.dcrEnabled = dcrEnabled;
    }
    
    public boolean getDcrHotPump() {
        return this.dcrHotPump;
    }
    
    public void setDcrHotPump(boolean dcrHotPump) {
        this.dcrHotPump = dcrHotPump;
    }
    
    public boolean getDcrFallBack() {
        return this.dcrFallBack;
    }
    
    public void setDcrFallBack(boolean dcrFallBack) {
        this.dcrFallBack = dcrFallBack;
    }
    
    public boolean getDcrMaskAccount() {
        return this.dcrMaskAccount;
    }
    
    public void setDcrMaskAccount(boolean dcrMaskAccount) {
        this.dcrMaskAccount = dcrMaskAccount;
    }
    
    public boolean getDcrLast4Digits() {
        return this.dcrLast4Digits;
    }
    
    public void setDcrLast4Digits(boolean dcrLast4Digits) {
        this.dcrLast4Digits = dcrLast4Digits;
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
        this.ID = (NetCCardConfigPK)pk;
    }
    
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof NetCCardConfigBase) {
            NetCCardConfigBase cardRecord = (NetCCardConfigBase) obj;
            if ((this.beginISO.equals(cardRecord.getBeginISO())) &&
            (this.ccType == cardRecord.getCCTypeObj()))
                result = true;
        }
        return result;
    }
    
    public int hashCode() {
        int result = 17;
        result = 37*result + this.beginISO.hashCode();
        result = 37*result + this.ccType.hashCode();
        return result;
    }
    
    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {
        
        if (!isPKValid()) {
            throw new Exception("validate:Invalid NetCCardConfig name: " +this.getPK());
        }        
        
        if ((this.ccAbbrev != null) && (this.ccAbbrev.length() > MAXCCABBREV)) {
            throw new Exception("validate:Invalid ccAbbrev: " + this.ccAbbrev +" for NetCCardConfig: " +this.getPK());
        }
    }
    
    /** Method to validate the primary key of the entity object
     * @return true if the primary key of the entity object is valid
     */
    public boolean isPKValid() {
        return (this.getPK() == null) ? false : this.getPK().isValid();
    }
    
    public void setAttributes(IEntityObject obj) {
        NetCCardConfigBase NetCCardConfig = (NetCCardConfigBase)obj;
        
        NetCCardConfig.ID = this.ID;
        NetCCardConfig.primaryEntryForCardType = this.primaryEntryForCardType;
        NetCCardConfig.setEnabled(this.enabled);
        NetCCardConfig.setFeeApplied(this.feeApplied);
        NetCCardConfig.setCCType(this.ccType);
        NetCCardConfig.setCCAbbrev(this.ccAbbrev);
        NetCCardConfig.setBeginISO(this.beginISO);
        NetCCardConfig.setEndISO(this.endISO);
        NetCCardConfig.setVoiceAuthPhone(this.voiceAuthPhone);
        NetCCardConfig.setAuthNetwork(this.authNetwork);
        NetCCardConfig.setAuthNetName(this.authNetName);
        NetCCardConfig.setVoiceAuthNetwork(this.voiceAuthNetwork);
        NetCCardConfig.setFloorLimit(this.floorLimit);
        NetCCardConfig.setProdRestriction(this.prodRestriction);
        NetCCardConfig.setAcctValidationIndex(this.acctValidationIndex);
        NetCCardConfig.setPanLength1(this.panLength1);
        NetCCardConfig.setPanLength2(this.panLength2);
        NetCCardConfig.promptExpDateOnManualEntry = this.promptExpDateOnManualEntry;
        NetCCardConfig.skipExpDateValidation = this.skipExpDateValidation;
        NetCCardConfig.expiryDateFormat = this.expiryDateFormat;
        NetCCardConfig.setPinPromptIndex(this.pinPromptIndex);
        NetCCardConfig.setTerminalTimeout(this.terminalTimeout);
        NetCCardConfig.setDcrLimit((MoneyAmount) this.dcrLimit.clone());
        NetCCardConfig.setDcrAuthAmt((MoneyAmount) this.dcrAuthAmt.clone());
        NetCCardConfig.setDisableManual(this.disableManual);
        NetCCardConfig.setPinPromptFlag(this.pinPromptFlag);
        NetCCardConfig.setDcrEnabled(this.dcrEnabled);
        NetCCardConfig.setDcrHotPump(this.dcrHotPump);
        NetCCardConfig.setDcrFallBack(this.dcrFallBack);
        NetCCardConfig.setDcrMaskAccount(this.dcrMaskAccount);
        NetCCardConfig.setDcrLast4Digits(this.dcrLast4Digits);
	  NetCCardConfig.setSmallCreditAmt(this.smallCreditAmt);
	  NetCCardConfig.setCashCreditpricing(this.cashCreditpricing);

    }
    
    /** Implementation method for visitor pattern
     * @param v visitor instance
     * @throws Exception propagates exceptions thrown by the visitor class
     * in its visit() method implementation
     */
    public void accept(NetEntityVisitor v) throws Exception {
        v.visit(this);
    }      
    
    /** Getter for property feeApplied.
     * @return Value of property feeApplied.
     *
     */
    public boolean isFeeApplied() {
        return this.feeApplied;
    }
    
    /** Setter for property feeApplied.
     * @param feeApplied New value of property feeApplied.
     *
     */
    public void setFeeApplied(boolean feeApplied) {
        this.feeApplied = feeApplied;
    }
    
    /** Getter for property promptExpDateOnManualEntry.
     * @return Value of property promptExpDateOnManualEntry.
     *
     */
    public boolean isPromptExpDateOnManualEntry() {
        return this.promptExpDateOnManualEntry;
    }
    
    /** Setter for property promptExpDateOnManualEntry.
     * @param promptExpDateOnManualEntry New value of property promptExpDateOnManualEntry.
     *
     */
    public void setPromptExpDateOnManualEntry(boolean promptExpDateOnManualEntry) {
        this.promptExpDateOnManualEntry = promptExpDateOnManualEntry;
    }
    
    /** Getter for property skipExpDateValidation.
     * @return Value of property skipExpDateValidation.
     *
     */
    public boolean isSkipExpDateValidation() {
        return this.skipExpDateValidation;
    }
    
    /** Setter for property skipExpDateValidation.
     * @param skipExpDateValidation New value of property skipExpDateValidation.
     *
     */
    public void setSkipExpDateValidation(boolean skipExpDateValidation) {
        this.skipExpDateValidation = skipExpDateValidation;
    }
    
    /** Getter for property expiryDateFormat.
     * @return Value of property expiryDateFormat.
     *
     */
    public String getExpiryDateFormat() {
        return this.expiryDateFormat;
    }
    
    /** Setter for property expiryDateFormat.
     * @param expiryDateFormat New value of property expiryDateFormat.
     *
     */
    public void setExpiryDateFormat(String expiryDateFormat) {
        if (expiryDateFormat == null) {
            this.expiryDateFormat = null;
        }
        else {
            if (EXP_DATE_FORMAT_1.equals(expiryDateFormat)) {
                this.expiryDateFormat = EXP_DATE_FORMAT_1;
            }
            else if (EXP_DATE_FORMAT_2.equals(expiryDateFormat)) {
                this.expiryDateFormat = EXP_DATE_FORMAT_2;
            }            
        }
    }
    
    public static void setMaxIsoLen(int maxLen) {
        MAXISOLEN = maxLen;
    }
    
    public static int getMaxIsoLen() {
        return MAXISOLEN;
    }
    
    public static void setMaxCCAbbrev(int maxAbbrev) {
        MAXCCABBREV = maxAbbrev;
    }
    public static int getMaxCCAbbrev() {
        return MAXCCABBREV;
    }

    /*
	 * (non-Javadoc)
	 * 
	 * @see com.verifone.isd.vsms2.net.ent.INetCCardConfig#getDcrDebitSwipe()
	 */
	public boolean getDcrDebitSwipe() {
		return false;
	}
    
    /**
     * Applications can determine what is a debit card
     */
    public boolean isDebitCard() {
		if (CardTypeDef.CARDTYPE_DEBIT == ccType) {
			return true;
		} else {
			return false;
		}
	}
    
    /**
     * Applications can override this behavior and determine
     * what is a prepaid card.
     */
    public boolean isPrepaidCard() {
    	boolean prepaid = false;
    	if (this.ccType == CardTypeDef.CARDTYPE_PREPAID) {
    		prepaid = true;
    	}
    	
    	return prepaid;
    }
    
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verifone.isd.vsms2.net.ent.INetCCardConfig#setDebitCard()
	 */
	public void setDebitCard() {
		this.ccType = CardTypeDef.CARDTYPE_DEBIT;
		this.pinPromptFlag = true;
	}
	
	
	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.net.ent.INetCCardConfig#processLikeDebit()
	 */
	public boolean processLikeDebit() {
		if ((this.isDebitCard()) || (ccType == CardTypeDef.CARDTYPE_EBT_FS)
				|| (ccType == CardTypeDef.CARDTYPE_EBT_CASH)
				|| (ccType == CardTypeDef.CARDTYPE_EBT)) {
			return true;
		} else {
			return false;
		}
	}




	/* (non-Javadoc)
	 * getSmallCreditAmt method 
	 */
	
	public int getSmallCreditAmt() {
		
        return this.smallCreditAmt;
        
    }
	/* (non-Javadoc)
	 * setSmallCreditAmt method  
	 */
    
    public void setSmallCreditAmt(int smallCreditAmt) {
    	this.smallCreditAmt = smallCreditAmt;
    }

	/* (non-Javadoc)	 
	 * @see com.verifone.isd.vsms2.net.ent.INetCCardConfig#preserveEncryptedTrack()	 
	 */	
	public boolean preserveEncryptedTrack() {		
		return (isPrepaidCard());	
	}
	
	/*
	 * @ returns boolean value cashCreditpricing
	 */
	public int getCashCreditpricing() {
		return this.cashCreditpricing;
    }
	
	/* 
	 * @ param boolean cashCreditpricing
	 */
    public void setCashCreditpricing(int cashCreditpricing) {
    	this.cashCreditpricing = cashCreditpricing;
    }

	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.net.ent.INetCCardConfig#getDebitHostID()
	 */
	public int getDebitHostID() {
		return 0;
	}

	public boolean isLowFee() {
		return lowFee;
	}

	public void setLowFee(boolean lowFee) {
		this.lowFee = lowFee;
	}
}
