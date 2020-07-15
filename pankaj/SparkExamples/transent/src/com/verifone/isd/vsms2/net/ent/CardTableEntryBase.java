package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.l10n.LocalizedRB;
import com.verifone.isd.vsms2.sys.l10n.OverlayRes;
import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class CardTableEntryBase implements Serializable, ICardTableEntry {

	private static final long serialVersionUID = 6740365932645966252L;
	private static final Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.CardTableEntryBase.class);
    protected CardData parsedCard;
    protected INetCCardConfig isoRecord;
    protected NetCCardConfigSet matchSet;
    protected String sessionKey;
    
    public CardTableEntryBase() {
    }
    
    public INetCCardConfig getISORecord() {
        return this.isoRecord;
    }
    
    public NetCCardConfigSet getMatchSet() {
        return this.matchSet;
    }
    
    public void addToMatchSet(INetCCardConfig matchingISO) {
        if (matchSet == null) {
            matchSet = new NetCCardConfigSet();
        }
        matchSet.addRecordToSet(matchingISO);
    }
    
    public void setISORecord(INetCCardConfig isoRecord) {
        this.isoRecord = isoRecord;
    }
    
    public CardData getParsedCard() {
        return this.parsedCard;
    }
    
    public void setParsedCard(CardData parsedCard) {
        this.parsedCard = parsedCard;
    }
    
    public void storeISO(INetCCardConfig netCCard) {
        this.setISORecord(netCCard);
    }
    
    public CardData parseInit(CardData rawData) {
        CardData parsedData = null;
        
        if (rawData.isManualEntry()) {
            parsedData = this.parseManualEntry(rawData);
        }
        else {
            parsedData = this.parseTrackData(rawData);
        }
        
        return parsedData;
    }
    
    public CardData parseManualEntry(CardData inputData) {
        String accountNum = inputData.getAccountNum();
        String expDate = inputData.getExpiryDate();
        int accountLen = accountNum.length();
        int acctType = inputData.getAcctTypeEntry();
        
        inputData.setTrack2Recon(true);
        
        if (accountLen == 7) {
            // Sinclair Thank You Driver Card
            inputData.setAccountNum("707943" + accountNum);
        }
        else
             if (accountLen == 19 && (accountNum.startsWith("690046") || accountNum.startsWith("707138"))) {
                /*
                 *  If the card is 19 digits and has the correct ISO then it is treated as WEX.
                 */
                inputData.setTrack2Data(inputData.getAccountNum() + "=" + inputData.getExpiryDate() + "1000000000000");
            }
            else {
                try {
                    //  For PHH cards, append the 7603 ISO Range
                    String subAcct4 = accountNum.substring(0, 4);
                    if ((accountLen == 14) &&
                    ((subAcct4.compareTo("0050") == 0) || (subAcct4.compareTo("0052") == 0) ||
                    (subAcct4.compareTo("0053") == 0) || (subAcct4.compareTo("0054") == 0) ||
                    (subAcct4.compareTo("0055") == 0) || (subAcct4.compareTo("0056") == 0) ||
                    (subAcct4.compareTo("0057") == 0) || (subAcct4.compareTo("0058") == 0) ||
                    (subAcct4.compareTo("0059") == 0))) {
                        String chkDigit = CardData.getLuhnCheckDigit(new String("7603") + accountNum);
                        inputData.setAccountNum("7603" + accountNum + chkDigit);
                        inputData.setTrack2Data(inputData.getAccountNum() + "=" + expDate + "0000000000000");
                    }
                    else {
                        if (accountNum.substring(0, 6).compareTo("707910") == 0) {
                            // Add IAS card discretionary data
                            inputData.setTrack2Data(accountNum + "=" + expDate + "0000000000000");
                        }
                        else {
                            if ((accountLen == 14) && (accountNum.substring(0, 5).compareTo("00105") == 0)) {
                                // Add ISO Range and check digit for California cards
                                String chkDigit = CardData.getLuhnCheckDigit(new String("7602") + accountNum);
                                inputData.setAccountNum("7602" + accountNum + chkDigit);
                                inputData.setTrack2Data(inputData.getAccountNum() + "=" + expDate + "0000000000000");
                            }
                            else {
                                if ((accountLen == 14) &&
                                (subAcct4.compareTo("0000") >= 0) &&
                                (subAcct4.compareTo("0038") <= 0)) {
                                    // GSA card
                                    String chkDigit = CardData.getLuhnCheckDigit(new String("7601") + accountNum);
                                    inputData.setAccountNum("7601" + accountNum + chkDigit);
                                    inputData.setTrack2Data(inputData.getAccountNum() + "=" + expDate + "1009000000000");
                                }
                                else {
                                    String subAcct2 = accountNum.substring(0, 2);
                                    if ((accountLen == 15) &&
                                    (subAcct2.compareTo("85") >= 0) && (subAcct2.compareTo("89") <= 0)) {
                                        // Append 7088 ISO Range for Voyager cards
                                        inputData.setAccountNum("7088" + accountNum);
                                        inputData.setTrack2Data(inputData.getAccountNum() + "=" + expDate);
                                    }
                                    else {
                                        // Use standard bankcard format
                                        inputData.setServiceCode("000");
                                        inputData.setTrack2Data(accountNum + "=" + expDate + "000");
                                    }
                                }
                            }
                        }
                    }
                }
                catch (Exception e) {
                    logger.error( "parseManualEntry:Exception parsing card."  + e.getMessage());
                }
                
            }
        
        inputData.setDefaultPanLength();
        
        return inputData;
    }
    
    public CardData parseTrackData(CardData rawData) {
        int nameIndex, delimIndex;
        String accountStr = null;
        
        // If track data was decoded by MSR service, we don't need to do it again
        
        if (!rawData.isParseDecode()) {
            
            String track1 = rawData.getTrack1Data();
            String track2 = rawData.getTrack2Data();
            
            // If track 2 is present, derive account number, expiration date and service code from track 2
            if (track2.length() > 0) {
                /**
                 * If this is a fuelman classic card, create the account number
                 * that is embossed on the card.
                 */
                if ((track2.charAt(0) == '6') && (track2.charAt(4) == '=')) {
                    try {
                        if (track2.length() >= 29){
                            accountStr = track2.substring(0,4) + track2.substring(5, 12) + track2.substring(24, 25);
                            accountStr += track2.substring(13, 16) + track2.substring(20, 21) + track2.substring(28, 29);
                            rawData.setAccountNum(accountStr);
                        }
                        else {
                            logger.error(
                            "parseTrackData:Track 2 length fuelman classic card required:29, " +
                            " found:" + track2.length());
                        }
                    }
                    catch (Exception e) {
                        logger.error( "parseTrackData:Invalid parse in fuelman classic card, " + e.getMessage());
                    }
                } else if ((track2.charAt(0) == '=') || (track2.indexOf("=") == -1)) {
					/*
					 * Allow for PropFleet cards that start with '=' and "==" in
					 * front of the iso. The account number will include the
					 * '='s and the '=' signs are part of the ISO. Also consider
					 * the case where there is no delimiter between account
					 * number and expiration date.
					 */
					if (track2.length() >= 23) {
						accountStr = track2.substring(0, 23);
					} else {
						accountStr = track2;
					}
					rawData.setAccountNum(accountStr);
				} else {
                    try {
                        delimIndex = track2.indexOf("=");
                        accountStr = track2.substring(0, delimIndex);
                        rawData.setAccountNum(CardData.getDigitsOnly(accountStr));
                        if (track2.length() >= delimIndex+5){
                            rawData.setExpiryDate(track2.substring(delimIndex+1, delimIndex+5));
                        }
                        else {
                            logger.info( "parseTrackData: Expy data not available on track 2.");
                            rawData.setExpiryDate("");
                        }
                        
                        if (track2.length() >= delimIndex+8){
                            rawData.setServiceCode(track2.substring(delimIndex+5, delimIndex+8));
                        }
                        else {
                            logger.info( "parseTrackData: svc code data not available on track 2.");
                            rawData.setServiceCode("");
                        }
                    } catch (Exception e) {
                        logger.error(
                        "Exception in track 2 preprocessing, expy or svc code not set.  " +
                        e.getMessage());
                    }
                }
                
                if (track2.startsWith("7070")) {
                    if (track2.length() >= 36){
                        rawData.setAccountNum(accountStr + track2.substring(31, 36));
                    }
                    else {
                        logger.error(
                        "parseTrackData: 7070 iso track 2 length insufficient. Required:36, " +
                        " found:" + track2.length());
                    }
                }
                
                // For UDS Fleet, copy 4 digit vehicle or Driver ID to the account number
                if (track2.startsWith("707100")) {
                    if (track2.length() >= 30){
                        rawData.setAccountNum(accountStr + track2.substring(26, 30));
                    }
                    else {
                        logger.error(
                        "parseTrackData: 707100 iso track 2 length insufficient. Required:30, " +
                        " found:" + track2.length());
                    }
                }
                
                // Copy subaccount for future reference
                if (track2.startsWith("7047") && (accountStr != null) && (accountStr.length() == 14)) {
                    if (track2.length() >= 30){
                        rawData.setAccountNum(accountStr + "00" + track2.substring(27, 30));
                    }
                    else {
                        logger.error(
                        "parseTrackData: 7047 iso track 2 length insufficient. Required:30, " +
                        " found:" + track2.length());
                    }
                }
                
                // If track 1 is present, extract account name from track 1.
                if (track1.length() > 0) {
                    this.parseCardName(rawData, track1);
                }
            }
            else {
                /**
                 * If track 1 is present, derive account number, account name, expiration date
                 * and service code from track 1
                 */
                if (track1.length() > 0) {
                    try {
                        delimIndex = track1.indexOf('^');
                        accountStr = track1.substring(0, delimIndex);
                        rawData.setAccountNum(CardData.getDigitsOnly(accountStr));
                        nameIndex = delimIndex + 1;
                        delimIndex = track1.indexOf('^', nameIndex);
                        
                        /*
                         * Check if cardholder's name is present on track 1. Then parse it into
                         * surname, firstname etc.
                         */
                        this.parseCardName(rawData, track1);
                        
                        if (track1.startsWith("7070")) {
                            if (track1.length() >= 51){
                                rawData.setAccountNum(accountStr + track1.substring(46, 51));
                            }
                            else {
                                logger.error(
                                "parseTrackData: 7070 iso track 1 length insufficient. Required:51, " +
                                " found:" + track1.length());
                            }
                        }
                        
                        // Strip "digit" format code from beginning of Voyager account#    
                        if (track1.startsWith("07088")) {
                            rawData.setAccountNum(accountStr.substring(1));
                        }
                        
                        this.setExpiryDate(rawData, track1, delimIndex);
                        this.setServiceCode(rawData, track1, delimIndex);
                        
                    } catch (Exception e) {
                        logger.error( "Exception in track 1 preprocessing" + e.getMessage());
                    }
                }
            }
        }
        
        
        rawData.setDefaultPanLength();
        
        return rawData;
    }
    
    protected void setExpiryDate(CardData rawData, String track1, int delimIndex) {
        if (track1.length() >= delimIndex+5){
            rawData.setExpiryDate(track1.substring(delimIndex+1, delimIndex+5));
        }
        else {
            logger.error(
            "parseTrackData: Expy not found, track 1 length insufficient. Required:" +
            delimIndex+5 + ", " + " found:" + track1.length());
            rawData.setExpiryDate("");
        }
    }
    
    protected void setServiceCode(CardData rawData, String track1, int delimIndex) {
        if (track1.length() >= delimIndex+8){
            rawData.setServiceCode(track1.substring(delimIndex+5, delimIndex+8));
        }
        else {
            logger.error(
            "parseTrackData: Svc code not found, track 1 length insufficient. Required:" +
            delimIndex+8 + ", " + " found:" + track1.length());
            rawData.setServiceCode("");
        }
    }
    
    public void parseCardName(CardData inputData, String track1) {
        
        try {
            int lastIndex = track1.indexOf('^');
            int nameIndex = lastIndex + 1;
            lastIndex = track1.indexOf('^', nameIndex);
            
            /**
             * Check if cardholder's name is present on track 1. Then parse it into
             * surname, firstname etc.
             */
            if ((lastIndex != -1) && (lastIndex > nameIndex)) {
                String cardName = track1.substring(nameIndex, lastIndex);
                
                int index = cardName.indexOf('/');
                if (-1 == index) {
                    // Copy the account name as is from track 1
                    inputData.setAccountName(cardName.trim());
                }
                else {
                    // Parse name into individual fields when it follows the standard
                    inputData.setSurName(cardName.substring(0,index));
                    lastIndex = index;
                    index = cardName.indexOf(' ', lastIndex);
                    if (-1 == index) {
                        inputData.setFirstName(cardName.substring(lastIndex+1, cardName.length()));
                        inputData.setMiddleInitial(null);
                    }
                    else {
                        inputData.setFirstName(cardName.substring(lastIndex+1, index));
                        inputData.setMiddleInitial(cardName.substring(index+1, cardName.length()).trim());
                    }
                }
            }
        } catch (Exception e) {
            logger.error( "Exception in parsing name from track 1" + e.getMessage());
            e.printStackTrace();
        }
        
    }
    
    public void validateCard(boolean accountOnly) throws NetworkException {
      }
    
    public void validateCard() throws NetworkException {
        this.validateCard(false);
    }
    
    public void validateExpirationDate() throws NetworkException {
    }
    
    public void checkAvs() {
    }
    
    public void checkCvv2() {
    }

	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.net.ent.ICardTableEntry#getSessionKey()
	 */
	public String getSessionKey() {
		return sessionKey;
	}

	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.net.ent.ICardTableEntry#setSessionKey(java.lang.String)
	 */
	public void setSessionKey(String sessionKey) {
		this.sessionKey = sessionKey;
	}
    
}
