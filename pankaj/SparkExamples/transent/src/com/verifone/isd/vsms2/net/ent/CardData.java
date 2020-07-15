package com.verifone.isd.vsms2.net.ent;

/** This class holds credit card data entry from user (track 1, track 2, account number, expiration date etc.)
 */
public class CardData implements java.io.Serializable {
    
    static final long serialVersionUID = -2025602574380013526L;
    
    /** Debit MOP being used
     */
    public static final char PAY_CREDIT = 'C';     /* Credit transaction */
    public static final char PAY_DEBIT = 'D';     /* Debit transaction */
    
    private String track1Data;
    private String track2Data;
    private String token;
    private boolean track2Recon;
    private boolean parseDecode;    // whether track data was parsed into individual fields by the MSR service
    private String accountNum;
    private int panLength;
    private String expiryDate;
    private EntryMethodDef entryMethod;
    private NetPaymodeTypesBase payMode;
    private int acctTypeEntry;      // when account type needs to be known for manual entry
    private String firstName;
    private String surName;
    private String middleInitial;
    private String serviceCode;
    private String accountName;
    private String restrictions;
    private String subAcct;
    private String vehicleNumber;
    private String acctExpand;
    private int registerID;
    private boolean debitHWAvailable;
    private String cardCircuit;
    
    /** Creates a new instance of Carddata */
    public CardData() {
        track2Recon = false;
        track1Data = "";
        track2Data = "";
        token= "";
        accountNum = "";
        expiryDate = "";
        firstName = "";
        surName = "";
        middleInitial = "";
        serviceCode = "";
        accountName = null;
        restrictions = "";
        subAcct = "";
        vehicleNumber = "";
        acctExpand = "";
        cardCircuit = "";
    }
    
    public void shallowCopy(CardData clone) {
        clone.track1Data = this.track1Data;
        clone.track2Data = this.track2Data;
        clone.token = this.token;
        clone.track2Recon = this.track2Recon;
        clone.parseDecode = this.parseDecode;
        clone.accountNum = this.accountNum;
        clone.expiryDate = this.expiryDate;
        clone.panLength = this.panLength;
        clone.entryMethod = this.entryMethod;
        clone.payMode = this.payMode;
        clone.restrictions = this.restrictions;
        clone.subAcct = this.subAcct;
        clone.vehicleNumber = this.vehicleNumber;
        clone.acctExpand = this.acctExpand;
        clone.registerID = this.registerID;
    }
    
    /** Getter method for track 1 card data
     * @return Track 1 data String */
    public String getTrack1Data() {
        return track1Data;
    }
    
    /** Getter method for track 1 length of card data
     * @return Track 1 length of card data
     */
    public int getTrack1Len() {
        return track1Data.length();
    }
    
    /** Setter method for track 1 of card data
     * @param track1Data Track 1 of the swiped card
     */
    public void setTrack1Data(String track1Data) {
        this.track1Data = track1Data;
    }
    
    /** Getter method for track 2 of card data
     * @return Track 2 of card data
     */
    public String getTrack2Data() {
        return track2Data;
    }
    
    /** Getter method for track 2 length of card data
     * @return Track 2 length of card data
     */
    public int getTrack2Len() {
        return track2Data.length();
    }
    
    /** Setter method for track 2 of card data
     * @param track2Data Track 2 of swiped card
     */
    public void setTrack2Data(String track2Data) {
        this.track2Data = track2Data;
    }
    
    /**
     * Getter method for payment token
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Setter method for payment token
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/** Getter method for the boolean flag indicating whether track 2 was reconstructed
     * @return true - if track 2 was reconstructed from manual entry;
     * false - if track 2 was received from a card swipe
     */
    public boolean getTrack2Recon() {
        return track2Recon;
    }
    
    /** Setter method for the boolean flag in card data to indicate that track 2 was reconstructed based off a manual entry
     * @param track2Recon boolean flag to indicate whether track 2 was reconstructed
     */
    public void setTrack2Recon(boolean track2Recon) {
        this.track2Recon = track2Recon;
    }
    
    /** Getter method for the boolean flag indicating whether track data was decoded by MSR service
     * @return true - if track data was decoded into individual fields like account number, expiration date etc.;
     * false - if track data was not decoded by MSR service
     */
    public boolean isParseDecode() {
        return parseDecode;
    }
    
    /** Setter method for the boolean flag indicating whether track data was decoded by MSR service
     * @param parseDecode boolean flag to indicate whether track data was decoded
     */
    public void setParseDecode(boolean parseDecode) {
        this.parseDecode = parseDecode;
    }
    
    
    /** Getter method for the credit card account number within card data
     * @return Credit card account number
     */
    public String getAccountNum() {
        return this.accountNum;
    }
    
    /** Setter method to set the credit card account number within card data
     * @param accountNum Credit card account number
     */
    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }
    
    /** Getter method for the PAN length of the card data
     * @return The length of the actual credit card account number which should be compared with the ISO record
     */
    public int getPanLength() {
        return this.panLength;
    }
    
    /** Setter method for the PAN length of the card data
     * @param panLength The length of the actual account number which should be compared with the ISO record
     */
    public void setPanLength(int panLength) {
        this.panLength = panLength;
    }
    
    /** This method sets the PAN length of the card data to its default which is the string length of the credit card account number
     */
    public void setDefaultPanLength() {
        this.panLength = this.accountNum.length();
    }
    
    /** Getter method for the expiration date of the credit card
     * @return Expiration date string (MMYY or YYMM)
     */
    public String getExpiryDate() {
        return this.expiryDate;
    }
    
    /** Setter method for the expiration date of the credit card
     * @param expiryDate Expiration date of credit card (MMYY or YYMM)
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    
    /** Getter method for the credit card entry method
     * @return Entry method (swipe/manual/island) of credit card
     */
    public EntryMethodDef getEntryMethod() {
        return this.entryMethod;
    }
    
    /** Setter method for credit card entry method
     * @param entryMethod Credit card entry method (swipe/manual/island)
     */
    public void setEntryMethod(EntryMethodDef entryMethod) {
        this.entryMethod = entryMethod;
    }
    
    /** Boolean to know if card data was entered manually
     * @return true - if card entry method is manual; false - otherwise
     */
    public boolean isManualEntry() {
        return (entryMethod == EntryMethodDef.ENTRY_MANUAL);
    }
    
    public boolean isDcrSale() {
        if ((entryMethod == EntryMethodDef.ENTRY_ISLAND) ||
        (entryMethod == EntryMethodDef.ENTRY_ISLAND_TRACK1) ||
        (entryMethod == EntryMethodDef.ENTRY_ISLAND_TRACK2)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Description for the card entry method - used for receipt printing
     *
     * @return String entry method description
     */
    public String getEntryMethodDescription() {
        return this.entryMethod.getDescription();
    }
    
    /** Getter method for the credit-based MOP (Debit/Credit) used in the transaction
     * @return Method of payment used in this transaction (Credit/Debit)
     */
    public NetPaymodeTypesBase getPaymode() {
        return this.payMode;
    }
    
    /** Setter method for the credit-based MOP (Debit/Credit) used in this transaction
     * @param payMode MOP (Credit/Debit) used in the transaction
     */
    public void setPaymode(NetPaymodeTypesBase payMode) {
        this.payMode = payMode;
    }
    
    /** Getter method for the credit card account type entered by the customer.
     * This may be required when multiple ISO records would match the manually entered account number and
     * the customer is prompted to select the appropriate card type used.
     * @return The credit card type entered by customer
     */
    public int getAcctTypeEntry() {
        return this.acctTypeEntry;
    }
    
    /** Setter method for the credit card account type entered by the customer
     * @param acctTypeEntry Credit card type as entered by the customer
     */
    public void setAcctTypeEntry(int acctTypeEntry) {
        this.acctTypeEntry = acctTypeEntry;
    }
    
    /** Boolean to indicate if Debit MOP was used in the transaction
     * @return true - if Debit MOP was used; false - otherwise
     */
    public boolean isDebitMop() {
        return (payMode == NetPaymodeTypesBase.PAY_DEBIT);
    }
    
    public boolean isEbtFsMop() {
        return (payMode == NetPaymodeTypesBase.PAY_EBT_FS);
    }
    
    public boolean isEbtCbMop() {
        return (payMode == NetPaymodeTypesBase.PAY_EBT_CASH);
    }
    
    /** Getter method to obtain the owner's firstname from the track data
     * @return First Name string from card track data
     */
    public String getFirstName() {
        return this.firstName;
    }
    
    /** Setter method for first name string within card data
     * @param firstName First Name string from card track data
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    /** Getter method for the card owner's surname
     * @return Surname string from card track data
     */
    public String getSurName() {
        return this.surName;
    }
    
    /** setter method for surname string within card data
     * @param surName Surname string in card track data
     */
    public void setSurName(String surName) {
        this.surName = surName;
    }
    
    /** Getter method to obtain owner's middle initial from card data
     * @return Middle initial string
     */
    public String getMiddleInitial() {
        return this.middleInitial;
    }
    
    /** Setter method for owner's middle initial in card data
     * @param middleInitial Middle initial string
     */
    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }
    
    /** Method to construct owner's name (first name + middle initial + surname) from card data
     * @return Name on the account
     */
    public String getAccountName() {
        String concatName = null;
        
        if (this.accountName == null) {
            /** 
             * Concatenate firstname, middle initial and surname to form
             * the cardholder's name in printable format.
             */
            concatName = this.firstName;
            
            if ((this.middleInitial != null) && (this.middleInitial.length() > 0)) {
                concatName = concatName + " " + this.middleInitial;
            }
            
            if ((this.surName != null) && (this.surName.length() > 0)) {
                concatName = concatName + " " + this.surName;
            }
        }
        else {
            /**
             * If the account name does not follow the standard, it will be copied as is from
             * track 1 without the leading and trailing whitespaces.
             */
            concatName = accountName;
        }
        
        return concatName;
    }
    
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
    
    
    

    public String getCardCircuit() {
		return cardCircuit;
	}

	public void setCardCircuit(String issuerID) {
		this.cardCircuit = issuerID;
	}

	/** Getter method to obtain the acctExpand from card data
     * @return acctExpand read from track data
     */
    public String getAcctExpand() {
        return this.acctExpand;
    }
    
    /**
	 * Setter method to set the acctExpand from card data
	 * 
	 * @param acctExpand
	 *            The string representing the acctExpand on the track data.
	 */
    public void setAcctExpand(String acctExpand) {
        this.acctExpand = acctExpand;
    }
    
    /** Getter method to obtain the vehicleNumber from card data
     * @return vehicleNumber read from track data
     */
    public String getVehicleNumber() {
        return this.vehicleNumber;
    }
    
    /**
	 * Setter method to set the vehicleNumber from card data
	 * 
	 * @param vehicleNumber
	 *            The string representing the vehicleNumber on the track data.
	 */
    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }
    
    /** Getter method to obtain the subAcct from card data
     * @return subAcct code read from track data
     */
    public String getSubAcct() {
        return this.subAcct;
    }
    
    /**
	 * Setter method to set the subAcct code from card data
	 * 
	 * @param subAcct
	 *            The string representing the subAcct on the track data.
	 */
    public void setSubAcct(String subAcct) {
        this.subAcct = subAcct;
    }
    
    /** Getter method to obtain the restrictions code from card data
     * @return restrictions code read from track data
     */
    public String getRestrictions() {
        return this.restrictions;
    }
    
    /**
	 * Setter method to set the restrictions code from card data
	 * 
	 * @param restrictions
	 *            The string representing the restrictions coded on the track
	 *            data.
	 */
    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }
    
    /** Getter method to obtain the service code from card data
     * @return Service code read from track data
     */
    public String getServiceCode() {
        return this.serviceCode;
    }
    
    /** Setter method for service code within card data
     * @param serviceCode Service code obtained from card track data
     */
    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }
    
    /**
	 * @return the registerID
	 */
	public int getRegisterID() {
		return registerID;
	}

	/**
	 * @param registerID the registerID to set
	 */
	public void setRegisterID(int registerID) {
		this.registerID = registerID;
	}

	
    /**
	 * @return the debitHWAvailable
	 */
	public boolean isDebitHWAvailable() {
		return debitHWAvailable;
	}

	/**
	 * @param debitHWAvailable the debitHWAvailable to set
	 */
	public void setDebitHWAvailable(boolean debitHWAvailable) {
		this.debitHWAvailable = debitHWAvailable;
	}

	/** Method to determine if a string contains only digits.
     * @param s input string
     * @return true - if all digits, false - if non-digit char present
     */
    public static boolean isDigitsOnly(String s) {
        boolean digits = true;
        
        if (s.length() == 0) {
            digits = false;
        }
        
        for (int i = 0; ((i < s.length()) && (digits)); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                digits = false;
            }
        }
        
        return digits; 
    }
    

    /** Method to remove non-digit characters from a string and generate a all-digit string.
     * This may be required sometimes to construct the account number from the card track data in order to skip spaces etc.
     * @param s String containing digits and non-digits
     * @return Filtered string containing digits only
     */
    public static String getDigitsOnly(String s) {
        StringBuffer digitsOnly = new StringBuffer();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (Character.isDigit(c)) {
                digitsOnly.append(c);
            }
        }
        return digitsOnly.toString();
    }
    
    /** This method performs Luhn check validation of the given credit card account number.
     * @param cardNumber Any given credit card account number
     * @return true - Luhn check passes; false - Luhn check fails
     */
    public static boolean luhnCheck(String cardNumber) {
        int sum = 0;
        int digit = 0;
        int addend = 0;
        boolean timesTwo = false;
        
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            digit = Integer.parseInt(cardNumber.substring(i, i + 1));
            if (timesTwo) {
                addend = digit * 2;
                if (addend > 9) {
                    addend -= 9;
                }
            }
            else {
                addend = digit;
            }
            sum += addend;
            timesTwo = !timesTwo;
        }
        
        int modulus = sum % 10;
        return modulus == 0;
    }
    
    /** This method performs Luhn check validation of the account number contained in this class
     * @return true - Luhn check passes; false - Luhn check fails
     */
    public boolean luhnCheck() {
        
        return luhnCheck(this.accountNum);
    }
    
    /** This method performs Luhn check validation of the account number starting at the given index
     * @return true - Luhn check passes; false - Luhn check fails
     */
    public boolean luhnCheck(int acctIndex) {
        
        return luhnCheck(this.accountNum.substring(acctIndex));
    }

    /** This method computes the Luhn check digit on a given credit card account number
     * @param cardNumber Credit card account number
     * @return Single digit string containing the Luhn check digit
     */
    public static String getLuhnCheckDigit(String cardNumber) {
        int sum = 0;
        int digit = 0;
        int addend = 0;
        int checkDigit = 0;
        boolean timesTwo = true;
        
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            digit = Integer.parseInt(cardNumber.substring(i, i + 1));
            if (timesTwo) {
                addend = digit * 2;
                if (addend > 9) {
                    addend -= 9;
                }
            }
            else {
                addend = digit;
            }
            sum += addend;
            timesTwo = !timesTwo;
        }
        
        int modulus = sum % 10;
        
        if (modulus > 0) {
            checkDigit = 10 - modulus;
        }
        
        return (Integer.toString(checkDigit));
    }
    
}

