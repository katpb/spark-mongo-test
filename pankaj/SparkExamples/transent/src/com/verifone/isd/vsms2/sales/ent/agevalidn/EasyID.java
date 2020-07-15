/*
 * EasyID.java
 *
 * Created on January 19, 2004, 10:58 AM
 */

package com.verifone.isd.vsms2.sales.ent.agevalidn;

import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.sales.ent.easyid.EasyIDANSIValidator;
import com.verifone.isd.vsms2.sales.ent.easyid.EasyIDData;
import com.verifone.isd.vsms2.sales.ent.easyid.EasyIDValidationEntry;
import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;

/** Easy ID processor. One of two methods are called depending on which input
 * device, MSR or Scanner, generated the data.
 *
 * @author Joe_H5
 */
public class EasyID {

    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sales.ent.agevalidn.EasyID.class);
    private static final String EASY_ID_WORKFILE_PROP = "easyID.workfile";
	private static final String DEFAULT_FILENAME = "easyid.wrk";
    
    private static final int HEADER_SKIP_VALUE = 24;
    
    private static final byte CHAR_AT = '@';
    
    public static final int EID_SUCCESS = 0;
    public static final int EID_TRK2EMPTY = 1;
    public static final int EID_NOTINDATABASE = 2;
    public static final int EID_EXPIREDLICENSE = 3;
    public static final int EID_EXPDATEINVALID = 4;
    public static final int EID_BIRTHDATEINVALID = 5;
    public static final int EID_NOGLOBALFILE = 6;
    
    private static EasyID easyID = null;
    
    private List<EasyIDValidationEntry> validationEntries;

    private EasyID() throws Exception {

        validationEntries = new  ArrayList<EasyIDValidationEntry>();

        String workFileName;
        File workFile;

        // Get the file name to gleasyid.wrk from a property
        try {
            workFileName = SysPropertyFactory.makeAbsoluteConfigPath(SysPropertyFactory.getProperty(EASY_ID_WORKFILE_PROP, DEFAULT_FILENAME));
            workFile = new File( workFileName );
        } catch (Exception e) {
            logger.error( getClass().getName() + ": " + e + " caught! EasyID property for work file does not exist!" );
            throw e;
        }

        // If it does not exist, complain!
        try {
            if (!workFile.exists() || !workFile.isFile()) {
                logger.error( getClass().getName() + ": EasyID '" + workFileName + "' file does not exist!" );
                return;
            }
        } catch (Exception e) {
            logger.error( getClass().getName() + ": " + e + " caught! Unable to access EasyID work file" );
            throw e;
        }

        // Read the work file and populate the validation format entries
        FileInputStream workStream = null;
        try {
            // get ready to read the file data
            workStream = new FileInputStream(workFile);

            int retries = 3;
            int bytesSkipped = 0;
            while( bytesSkipped != HEADER_SKIP_VALUE ) {
            // Skip past Gempro/Gemix header info (16 bytes), the "file magic" number (4 bytes)
            // and the file_address relocatable entry (4 bytes)

                bytesSkipped += workStream.skip(HEADER_SKIP_VALUE - bytesSkipped);
                --retries;
                if ((retries <= 0) || (bytesSkipped < 0)){
                    logger.error( getClass().getName() + ": EasyID '" + workFileName + "' file has header problems!" );
                    return;
                }
            }
            byte[] readState = new byte[3];
            int readValidate;
            byte[] readFormat = new byte[60];

            while (true) {

                //Read the state code
                int bytesRead = workStream.read( readState );
                if ((bytesRead == -1) || (bytesRead < readState.length)) { // EOF?
                    break;
                }

                // read the validation flag
                readValidate = workStream.read( );
                if (readValidate == -1) { // EOF?
                    break;
                }

                // read the validation format string
                bytesRead = workStream.read( readFormat );
                if ((bytesRead == -1) || (bytesRead < readFormat.length)) { // EOF?
                    break;
                }

                for( bytesRead = 0; (bytesRead < readFormat.length) && (readFormat[bytesRead] != 0); bytesRead++) {
                }

                byte[] format = new byte[bytesRead];
                for( bytesRead = 0; bytesRead < format.length; bytesRead++) {
                    format[bytesRead] = readFormat[bytesRead];
                }

                EasyIDValidationEntry anEntry = new EasyIDValidationEntry(new String(readState, 0, 2,"UTF-8"), format, readValidate );
                //logger.error("Adding a new EasyIDValidation entry: State="+readState+" format="+format);   
                this.validationEntries.add( anEntry );
            }
        } catch (Exception e) {
            logger.error( getClass().getName() + ": " + e + " caught! reading EasyID work file" );
            throw e;
        }
        finally {
            try {
                if (workStream != null) {
                    workStream.close();
                }
            } catch( Exception anotherEx) {
            }
        }
    }

    /** Return the single instance of the EasyID processor. Create the instance if
     * not already
     * @throws Exception On any errors trying to initialize itself. This could be due
     * to non existent 'gleasyid.wrk' file or other IO errors.
     * @return The instance of this EasyID processor
     */    
    public static synchronized EasyID getInstance() throws Exception {
        if (easyID == null) {
            easyID = new EasyID();
        }

        return easyID;
    }

    /** Method will validate and parse the data input From the MSR device. If the input
     * is of a valid format the returned EasyIDData is populated with the information.
     * Otherwise, the argument contains empty strings. The input data is the Track2
     * data as read by the MSR.
     * @param inputData The byte array scanned by the MSR. (Must be track2 data).
     * @return The parsed information. Data will be empty strings on failure.
     */    
    public EasyIDData validateAndParseMSR( byte[] inputData ) {

        EasyIDData easyIDData = new EasyIDData();

        Iterator<EasyIDValidationEntry> iter = validationEntries.iterator();
        while( iter.hasNext()) {
            EasyIDValidationEntry anEntry =  iter.next();
            if ( anEntry.validateInput(inputData, easyIDData ) ) {
                easyIDData.setState( anEntry.getState() );
                return easyIDData;
            }
        }

        return null;    // when there are no matching entries
    }

    /** Method will validate and parse the data input From the Scanner device. If the
     * input is of a valid format the returned EasyIDData is populated with the
     * information.
     * Otherwise, the argument contains empty strings.
     * @param inputData The byte array scanned by the Scanner
     * @return The parsed information. Data will be empty strings on failure.
     */    
    public EasyIDData validateAndParseScanner( byte[] inputData ) {

        String aamvaStr = "AAMVA";
        String ansiStr = "ANSI";

        int inputDataIndex = 0;

        // inputData's first element (byte) must be an ASCII 'X' of PDF417
        if ( (inputData.length < 12) || (inputData[inputDataIndex] != CHAR_AT) ) {
            return null;
        }
        EasyIDData easyIDData = null;

        inputDataIndex = 4;

        // Check to see if it is in AAMVA or ANSI complient format

        try {
			if ( (EasyIDValidationEntry.byteArrayCompare(inputData, inputDataIndex, aamvaStr.getBytes("UTF-8"), 0, aamvaStr.length()) == 0) ||
			      (EasyIDValidationEntry.byteArrayCompare(inputData, inputDataIndex, ansiStr.getBytes("UTF-8"), 0, ansiStr.length()) == 0) )
			{
			    easyIDData = validateAndParseAAMVA( inputData, inputDataIndex );
			} else {
			    easyIDData = validateAndParseMSR( inputData );
			}
		} catch (UnsupportedEncodingException e) {
			logger.error("Unsupported Encoding ",e);
		}

        return easyIDData;
    }

    private EasyIDData validateAndParseAAMVA( byte[] inputData, int inputDataIndex ) {

        EasyIDData easyIDdata = new EasyIDData();
        EasyIDANSIValidator.getInstance().validateInput(inputData, easyIDdata);
        return easyIDdata;
    }
    
    /**
     * Method to determine if the expiration date on the driver license is valid.
     *
     * @return boolean - true if expired, false if not expired
     */
    public int validateExpirationDate(EasyIDData parsedEntry) {
        int result = EID_SUCCESS;
        String expDay = null;
        
        if ((parsedEntry.getExpMonth() == null) || (parsedEntry.getExpYear() == null)) {
            // No expiration date, assume good and allow for testing of birth date
            return EID_SUCCESS;
        }
        if ((parsedEntry.getExpMonth().length() == 0) || (parsedEntry.getExpYear().length() == 0)) {
            // No expiration date, assume good and allow for testing of birth date
            return EID_SUCCESS;
        }
        String expMonth = parsedEntry.getExpMonth();
        if ((expMonth != null) && (expMonth.length() > 0)) {
            if (expMonth.startsWith("77")) {
                logger.info("EasyID: Non-expiring driver license");
            }
            else {
                if (expMonth.startsWith("88")) {
                    /**
                     * in this case the expiration date is at the end of the month
                     * one year from the month of birth and year of expiration.
                     */
                    int year = (Integer.parseInt(parsedEntry.getExpYear()) + 1) % 100;
                    StringBuilder modifiedYear = new StringBuilder();
                    if (String.valueOf(year).length() == 1) {
                        modifiedYear.append("0");
                    }
                    modifiedYear.append(year);
                    parsedEntry.setExpYear(modifiedYear.toString());
                    parsedEntry.setExpMonth(parsedEntry.getBirthMonth());
                }
                else {
                    if (expMonth.startsWith("99")) {
                        parsedEntry.setExpMonth(parsedEntry.getBirthMonth());
                        expDay = parsedEntry.getBirthDay();
                    }
                }
                
                result = this.checkForExpiration(parsedEntry.getExpMonth(), parsedEntry.getExpYear(), expDay);
                
                if (result == EID_SUCCESS) {
                    /**
                     * Florida cards can have a "99" in the birth month on
                     * licenses that expire, since the expiration month is the
                     * birth month. To guard against the possibility that other
                     * states may do something similar, but use other values...
                     * we look for a valid month in the birth month field and
                     * just use the expiration month if birth month not valid.
                     * the caller is checking for valid birthdate, so the
                     * need for further checking here does not exist based on
                     * currently known information.
                     */
                    int bMonth = Integer.parseInt(parsedEntry.getBirthMonth());
                    if ((bMonth < 1) || (bMonth > 12)) {
                        parsedEntry.setBirthMonth(parsedEntry.getExpMonth());
                    }
                }
            }
        }
        else {
            result = EID_EXPDATEINVALID;
        }
        
        return result;
    }
    
    private int checkForExpiration(String month, String year, String day) {
        int result = EID_SUCCESS;
        
        Calendar tmpCal = Calendar.getInstance();
        int currentMonth = tmpCal.get(Calendar.MONTH) + 1;
        int currentYear = tmpCal.get(Calendar.YEAR) - 1900;
        int currentDay = tmpCal.get(Calendar.DATE);

        if ((month != null) && (month.length() == 2) 
              && (year != null) && ((year.length() == 4) || (year.length() == 2))) {

            // Validate the expiration date on driver's license
            int cardDay = 0;
            int cardMonth = Integer.parseInt(month);
            int cardYear;
            if (year.length()!=4){
            	cardYear = Integer.parseInt(year);	
            }else{
            	cardYear = Integer.parseInt(year)-1900;
            }
            
            if (cardYear < 100) {
                cardYear += (currentYear - (currentYear % 100));
                if (cardYear > (currentYear + 50)) {
                    cardYear -= 100;  //  i.e. if '99' + '2000' > 2007 + 50  then 2 digit year is actually 1999
                } else if (cardYear < (currentYear - 50)) {
                    cardYear += 100;  //  i.e. if '05' + '2000' < 2099 - 50  then 2 digit year is actually 2105
                    // Hey! It could happen! This code could last well into the next century!
                }
            }

            if ((cardMonth < 1) || (cardMonth > 12)) {
                result = EID_EXPDATEINVALID;
            }
            else {
                if (day != null) {
                    cardDay = Integer.parseInt(day);
                    if (!validDayForMonth(cardDay, cardMonth, cardYear)) {
                        result = EID_EXPDATEINVALID;
                    }
                }
            }
            
            // Compare today's date with the expiration date on Driver's license
            if (result == EID_SUCCESS) {
                // This will work till 2049
                if (cardYear < 50) {
                    cardYear +=100;
                }
                
                if (cardYear < currentYear) {
                    result = EID_EXPIREDLICENSE;
                }
                else {
                    if (cardYear == currentYear) {
                        if (cardMonth < currentMonth) {
                            result = EID_EXPIREDLICENSE;
                        }
                        else {
                            if (cardMonth == currentMonth) {
                                if ((cardDay != 0) && (cardDay < currentDay)) {
                                    result = EID_EXPIREDLICENSE;
                                }
                            }
                        }
                    }
                }
            }
        }
        else {
            result = EID_EXPDATEINVALID;
        }
        
        return result;
    }
    
    private boolean validDayForMonth(int day, int month, int year) {
        boolean valid = true;
        
        switch(month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day > 31) {
                    valid = false;
                }
                break;
                
            case 4:
            case 6:
            case 9:
            case 11:
                if (day > 30) {
                    valid = false;
                }
                break;
                
            case 2:
                if ((year%4 == 0) &&
                ((year%100 != 0) || (year%400 == 0))) {
                    /* leap year */
                    if (day > 29) {
                        valid = false;
                    }
                } else {
                    if (day > 28) {
                        valid = false;
                    }
                }
                break;
                
            default:
                valid = false;
                break;
        }

        return valid;
    }
    
    public static void main(String[] Args){
        EasyID easyId=null;
        try{
        easyId = EasyID.getInstance();
        } catch ( Exception ex){
            LoggerFactory.getLogger(EasyID.class).error("Got an exception while creating EasyID", ex);
            System.exit(1);
        }
//        String inputStr = "6360100430000068462=0912196899220=";
//        String inputStr = "6360100832577059410=0511195999100=";
//        String inputStr = "6006461431866689=0512=19790228";
//        String inputStr = "0636021222222222=051219811231";
//        String inputStr = "1312345678900=19790719=0";
        String inputStr = "636005040140486=150119740101=";
        byte[] inputBuf;
        EasyIDData easyIdData=null;;
		try {
			inputBuf = inputStr.getBytes("UTF-8");
			easyIdData = easyId.validateAndParseMSR(inputBuf);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
        if ( easyIdData != null) {
            easyId.logger.debug( ":-) FOUND a MATCH for state: {}\n{}", easyIdData.getState(), easyIdData.toString() );

            if ( EID_SUCCESS != easyId.validateExpirationDate(easyIdData) ) {
                easyId.logger.error("Errors validating expiration date!");
            } else {
                easyId.logger.info("VALID expiration date!");
            }
        }
        else
            easyId.logger.warn("Found NO MATCH - TRY Again :-(");
        System.exit(0);
    }
}
