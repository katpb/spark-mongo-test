/*
 * EasyIDANSIValidator.java
 *
 * Created on June 1, 2007, 3:27 PM
 *
 * Copyright (C) 2006 Verifone, Inc.                     ALL RIGHTS RESERVED.
 */

package com.verifone.isd.vsms2.sales.ent.easyid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.log4j.*;
import java.util.Calendar;
/**
 * Provides for validating scanned 2D barcodes from Drivers Licenses.
 * <p>
 * The validation is coded to the specification found in
 * <a href="http://www.aamva.org/NR/rdonlyres/66260AD6-64B9-45E9-A253-B8AA32241BE0/0/2005DLIDCardSpecV2FINAL.pdf">
 * 2005DLIDCardSpecV2FINAL.pdf</a>
 */
public class EasyIDANSIValidator {

    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sales.ent.easyid.EasyIDANSIValidator.class);
    private static EasyIDANSIValidator myInstance = null;

    /** Creates a new instance of EasyIDANSIValidator */
    private EasyIDANSIValidator() {
    }

    /**
     * Provides the 'singleton' instance of this class. Creates it if the single
     * instance hasn;t been created, yet.
     * @return The only instance of this class.
     */
    public static synchronized EasyIDANSIValidator getInstance() {
        if (myInstance == null) {
            myInstance = new EasyIDANSIValidator();
        }

        return myInstance;
    }

    /**
     * Validates the bytes received from scanned 2D bar code. Updates the
     * birth date and expiration date properties in the <code>easyIDData</code>
     * parameter.
     *
     * @param inputData The 2D data scanned.
     * @param easyIDData The value object to update with the fields from <code>input data</code>.
     * @return <code>true</code> if <code>easyIDData</code> birth date info was updated.
     */
    public boolean validateInput(byte[] inputData, EasyIDData easyIDData) {

		boolean parsedDate = false;

        String str = new String(inputData);

        // Find Document Expiration field
        int index = str.indexOf("DBA");
		if ( index >= 0 ) {
			parsedDate = this.getDateFormat(str, index, easyIDData, 'E');
		}

        // Find document birth information
        index = str.indexOf("DBB");
		if ( index >= 0 ) {
			parsedDate = this.getDateFormat(str, index, easyIDData, 'B');
		}

        // Find document state ID info
        index = str.indexOf("DAJ");
        if ((index >= 0) && ((index + 3 + 2) <= str.length()) ) {
			easyIDData.state = str.substring(index + 3, index + 3 + 2);
        }
        
        index = str.indexOf("DAC");
        if(index >=0) {
        	easyIDData.firstName = findSubString("\\\n", str.substring(index + 3));
        }
        
        index = str.indexOf("DAD");
        if(index >=0) {
        	easyIDData.middleName = findSubString("\\\n", str.substring(index + 3));
        }
        
        index = str.indexOf("DCS");
        if(index >=0) {
        	easyIDData.lastName = findSubString("\\\n", str.substring(index + 3));
        }
        
        index = str.indexOf("DAQ");
        if(index >=0) {
        	easyIDData.driverId = findSubString("\\\n", str.substring(index + 3));
        }
        
        index = str.indexOf("DAA");
        if(index >=0) {
        	String tempString = findSubString("\\\n", str.substring(index + 3));
        	easyIDData.lastName = tempString.replace(",", " ");
        }
		
        return parsedDate;
    }
    
    public String findSubString(String prefix, String str){
    	String[] tempStrings = new String[40];
    	tempStrings = str.split(prefix);
    	return tempStrings[0]; 
    }

	/**
     * Retrieve the date from the data element in scanned 2D bar code. Update the
     * date properties in the <code>easyIDData</code> object based on the <code>type</code>
     * parameter.
     *
     * @param str The scanned data starting with the data element that has the date 
     * @param easyIDData The value object to update with the fields from <code>str</code>
	 * @param index The index at which the data element begins in <code>str</code>  
	 * @param type The type of date format to retrieve, currently expiration and birth date
     * @return <code>true</code> if <code>easyIDData</code> date was successfully updated
     */
	private boolean getDateFormat(String str, int index, EasyIDData easyIDData, char type){
        
        boolean parsedDate = false;
        String year = "";
        String month = "";
        String day = "";
        char delimiter = 0;
        
        // The three characters after the record type in PDF417 data represent the delimiters
        // used in the record
        char firstDelimiter = str.charAt(1);
        char secondDelimiter = str.charAt(2);
        char thirdDelimiter = str.charAt(3);
      
        try {
            int i = index + 3;
            int strLength = str.length();

            while ( (i < index + 13) && (i < strLength) ) {
                delimiter = str.charAt(i);
                if ( delimiter != firstDelimiter && delimiter != secondDelimiter 
                        && delimiter != thirdDelimiter ) {
                    i++;
                } else {
                    break;
                }
            } 
            
            String date = str.substring(index + 3, i);
			if (date.length() <= 3 )
                return parsedDate;
            
            switch (date.length()){
                
                // YYMM
                case 4:
                    year = date.substring(0, 2);
                    month = date.substring(2, 4);
                    day = null;
                    parsedDate = true;
                    break;
                    
                // YYMMDD
                case 6:
                    year = date.substring(0, 2);
                    month = date.substring(2, 4);
                    day = date.substring(4, 6);
                    parsedDate = true;
                    break;
                    
                // YYYYMMDD or MMDDYYYY
                case 8:
                    if ( date.startsWith("19") || date.startsWith("20")){
                        year = date.substring(0, 4);
                        month = date.substring(4, 6);
                        day = date.substring(6, 8);
                    } else {
                        year = date.substring(4, 8);
                        month = date.substring(0, 2);
                        day = date.substring(2, 4);
                    }
                    parsedDate = true;
                    break;
                    
                // MM-DD-YYYY
                case 10:
                    year = date.substring(6, 10);
                    month = date.substring(0, 2);
                    day = date.substring(3, 5);
                    parsedDate = true;
                    break;
                    
                default:
                    parsedDate = false;
                    break;
            }
            
            if ( type == 'E' ) {
                easyIDData.expYear = year;
                easyIDData.expMonth = month;
            } else if ( type == 'B') {
               
                try {
	                Calendar dateOfBirth = Calendar.getInstance();
							
					dateOfBirth.clear();
					dateOfBirth.setLenient(false);
					dateOfBirth.set(Calendar.YEAR, Integer.parseInt(year));
					dateOfBirth.set(Calendar.MONTH, Integer.parseInt(month)- 1);
					if ( day == null) // For YYMM license format where day is irrelevant
						day = "1";
					dateOfBirth.set(Calendar.DATE, Integer.parseInt(day));
					dateOfBirth.getTime();

					easyIDData.birthYear = year;
					easyIDData.birthMonth = month;
					easyIDData.birthDay = day;

				} catch ( Exception e ) {
					logger.error("Invalid birth date : " +e);					
					parsedDate = false;
					return parsedDate;
				}				
            }
            
        } catch(Exception e) {
            logger.error("Error in parsing date format: " +e);            
        }
        
        logger.debug( "EasyIDANSIValidator - EasyIDData : "
                + easyIDData.toString());
        
        return parsedDate;
    }

    private String getSubfield( byte[] inputData, int startIndex, int subfieldLength) {
        String subfield = null;

        if (startIndex + subfieldLength < inputData.length) {
            subfield = new String(inputData, startIndex, subfieldLength);
        }

        return subfield;
    }
}
