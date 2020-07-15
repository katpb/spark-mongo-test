/*
 * EasyIDEntry.java
 *
 * Created on January 15, 2004, 4:35 PM
 */

package com.verifone.isd.vsms2.sales.ent.easyid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.log4j.*;
/** This class holds the validation format string that was obtained from the Gempro gleasyid.wrk (jleasyid.wrk) file. It also
 * has the validation method to validate the byte array input from the MSR.
 *
 * @author Joe_H5
 */
public class EasyIDValidationEntry implements java.io.Serializable {
	
	private static final Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sales.ent.easyid.EasyIDValidationEntry.class);
	private static final long serialVersionUID = 7198670494431409860L;


    private static final byte ASTERISK = 42;
    private static final byte PLUSSIGN = 43;
    private static final byte DOLLARSIGN = 36;

    private static final byte CHAR_D = 68;
    private static final byte CHAR_M = 77;
    private static final byte CHAR_R = 82;
    private static final byte CHAR_Y = 89;
    private static final byte CHAR_d = 100;
    private static final byte CHAR_m = 109;
    private static final byte CHAR_y = 121;

    private static final byte CHAR_0 = 48;
    private static final byte LEFT_BRACE = 91;
    private static final byte RIGHT_BRACE = 93;

    private String state;

    private byte[] format;

    private int validate;

    /** Creates a new instance of EasyIDEntry (Future implementation
     * may require instantiation from SEV or RMI)
     */
    EasyIDValidationEntry() {
    }

    /** Creates a new instance of EasyIDEntry
     * @param state Two letter state code
     * @param format Format string (As found in gleasyid.wrk
     * @param validate Special validation flags (Unknown capabilities at this time)
     */    
    public EasyIDValidationEntry(String state, byte[] format, int validate) {
        this.state = state;
        this.format = format;
        this.validate = validate;
    }

    /** Get the two ltter state code for this validation entry
     * @return Two letter state code
     */    
    public String getState() {
        return state;
    }

    /** Return the format verification string for this entry
     * @return Verification format string
     */    
    public byte[] getFormat() {
        return format;
    }

    /** Retunr the special validate capabilities flags for this entry. Unfortuantely,
     * the Gempro does not use this field either so there is not a definite use, yet.
     * @return Special validation flags
     */    
    public int getValidate() {
        return validate;
    }

    /** Validate scanned input against this entry. If input does validate, fill in
     * the EasyIDData object with scanned data.
     * @param inputData from MSR of scanned card
     * @param easyIDData During succesful validation, expiration and birth info along with two letter
     * state code are stored in this object.
     * @return True if succesful validation. false otherwise
     */    
    public boolean validateInput(byte[] inputData, EasyIDData easyIDData) {
        // Nothing to compare to, validation fails
        //logger.info("Input Buf = " + inputData + " matching with state = "+state);
        if (inputData.length == 0)
            return false;

        WorkingData workArea = new WorkingData(); // New working data area

        workArea.inIndex = 0;

        try {
            while( workArea.fmtIndex < format.length ) {
                if (workArea.inIndex >= inputData.length) {
                    //ran out of input data before processing format string, validation failed

                    if (format[workArea.fmtIndex] == ASTERISK)
                        // But, if format string ends in an asterisk, then we match any or no thing
                        return true;
                    return false;
                }

                // If '*' is in format, skip all characters in input until next character in format is matched
                if (format[workArea.fmtIndex] == ASTERISK) {
                    //System.out.println("Reached *");

                    workArea.fmtIndex++;
                    // Since we're to match anything and we're at end of format string
                    if (workArea.fmtIndex >= format.length) {
                        // input string validates against format string; set to true and break and exit
                        return true;
                    }

                    // Match anything in inputData until character matches next character in format string
                    while ((inputData[workArea.inIndex] != format[workArea.fmtIndex])) {
                        if (workArea.inIndex > inputData.length) {
                            //System.out.println("Could not find a match for the char after *");
                            return false;   // Ran out of input before match
                        }
                        workArea.inIndex++;
                    }
                    workArea.inIndex++;
                    workArea.fmtIndex++;

                } else if (format[workArea.fmtIndex] == PLUSSIGN) {
                    // Match any character in inputData
                    workArea.inIndex++;
                    workArea.fmtIndex++;
                } else if (format[workArea.fmtIndex] == DOLLARSIGN) {
                    // Special handling
                    //System.out.println("Found $ sign go and do special processing");
                    workArea.fmtIndex++;
                    if (!process_special( workArea, inputData, easyIDData ) ) {
                        //System.out.println("Special processing failed");
                        return false;
                    }

                } else {
                    if (inputData[workArea.inIndex] != format[workArea.fmtIndex]) {
                        //System.out.println("Input data mismatch at inIndex ="+String.valueOf(workArea.inIndex));
                        return false;
                    }
                    workArea.inIndex++;
                    workArea.fmtIndex++;
                }

            }
        } catch( IndexOutOfBoundsException iobx) {
            // validation failed, do nothing and return
            //System.out.println("Index out of bounds exception");
        }

        return false;
    }

    private boolean process_special( WorkingData workArea, byte[] inputData, EasyIDData easyIDData ) {
        boolean validated = false;

        byte fmtChar = format[workArea.fmtIndex];
        workArea.fmtIndex++;
        switch( fmtChar ) {
            case CHAR_Y :   // get expiration year
                int len = (int) ( format[workArea.fmtIndex] - CHAR_0 );
                byte[] year = new byte[len];
                System.arraycopy( inputData, workArea.inIndex + (len - 2), year, 0, 2);
                easyIDData.expYear = new String(  year );
                //System.out.println("Found year = "+easyIDData.expYear);
                workArea.fmtIndex++;
                workArea.inIndex += len;
                if ( easyIDData.expYear.length() < 2 )
                    validated = false;
                else 
                    validated = true;
                break;

            case CHAR_M :   // get expiration month
                len = (int) ( format[workArea.fmtIndex] - CHAR_0 );
                byte[] month = new byte[len];
                System.arraycopy( inputData, workArea.inIndex + (len - 2), month, 0, 2);
                easyIDData.expMonth = new String(  month );
                workArea.fmtIndex++;
                workArea.inIndex += len;
                if ( easyIDData.expMonth.length() < 2 )
                    validated = false;
                else 
                    validated = true;
                break;

            case CHAR_y : // get birth year
                len = (int) ( format[workArea.fmtIndex] - CHAR_0 );
                year = new byte[2];
                System.arraycopy( inputData, workArea.inIndex + (len - 2), year, 0, 2);
                easyIDData.birthYear = new String(  year );
                workArea.fmtIndex++;
                workArea.inIndex += len;
                if ( easyIDData.birthYear.length() < 2 )
                    validated = false;
                else 
                    validated = true;
                break;

            case CHAR_m : // get birth month
                len = (int) ( format[workArea.fmtIndex] - CHAR_0 );
                month = new byte[len];
                System.arraycopy( inputData, workArea.inIndex + (len - 2), month, 0, 2);
                easyIDData.birthMonth = new String(  month );
                workArea.fmtIndex++;
                workArea.inIndex += len;
                if ( easyIDData.birthMonth.length() < 2 )
                    validated = false;
                else 
                    validated = true;
                break;

            case CHAR_d : // get birth day
                len = (int) ( format[workArea.fmtIndex] - CHAR_0 );
                byte[] day = new byte[len];
                System.arraycopy( inputData, workArea.inIndex + (len - 2), day, 0, 2);
                easyIDData.birthDay = new String(  day );
                workArea.fmtIndex++;
                workArea.inIndex += len;
                if ( easyIDData.birthDay.length() < 2 )
                    validated = false;
                else 
                    validated = true;
                break;

            case CHAR_R : // Process field range
                len = (int) ( format[workArea.fmtIndex] - CHAR_0 );

                workArea.fmtIndex++;
                // Check range format syntax
                if ((format[workArea.fmtIndex] == LEFT_BRACE) &&
                   (format[workArea.fmtIndex+1+len] == RIGHT_BRACE) &&
                   (format[workArea.fmtIndex+2+len] == LEFT_BRACE) &&
                   (format[workArea.fmtIndex+3+len+len] == RIGHT_BRACE))
                {
                    // Check against minimum of range
                    if (byteArrayCompare(inputData, workArea.inIndex, format, workArea.fmtIndex+1, len) >= 0) {
                        //Check sgainst maximum of range
                        if (byteArrayCompare(inputData, workArea.inIndex, format, workArea.fmtIndex+3+len, len) <= 0) {
                            // Within range, validation is true
                            validated = true;
                            workArea.fmtIndex += len+len+4;
                            workArea.inIndex += len;
                        }
                    }
                }
                break;

            case ASTERISK :
            case PLUSSIGN :
            case DOLLARSIGN :
                if (inputData[workArea.inIndex] == format[workArea.fmtIndex]) {
                    workArea.inIndex++;
                    workArea.fmtIndex++;
                    validated = true;
                }
                break;

            default :
                break;
        }

        return validated;
    }

    /**
     * Compare designated portions two byte arrays
     * @param src First byte array to be compared
     * @param srcPos Starting position in first byte array
     * @param dst Second byte array to be compared
     * @param dstPos Starting position in second byte array
     * @param len Number of bytes to be compared.
     * @return If 0, the arrays matched.  If non-zero, the difference
     * between the non-matching bytes
     */    
    public static int byteArrayCompare( byte[] src, int srcPos, byte[] dst, int dstPos, int len) {

        int rc = 0;

        while( len > 0 ) {
            rc = src[srcPos++] - dst[dstPos++];
            if (rc != 0)
                break;

            --len;
        }

        return rc;
    }

    private class WorkingData {
        int inIndex;
        int fmtIndex;
    }
    
    /**
     * Convert current object to a string
     * @return String representation of this object
     */    
    public String toString() {
        return state + ": " + new String(  format );
    }
}
