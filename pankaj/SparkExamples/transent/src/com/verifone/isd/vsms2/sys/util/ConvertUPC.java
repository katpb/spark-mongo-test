/*
 * ConvertUPC.java
 *
 * Created on February 17, 2004, 1:10 PM
 */

package com.verifone.isd.vsms2.sys.util;


/** This class contains the methods to convert UPC-A, UPC-E, and EAN-8 to EAN-13
 * PLU codes for proper lookup of resultant PLU into the database.
 * @author Joe_H5
 *
 * @since BUY4.05.07 MOVED from topaz to vsmsV2 component
 * @see com.verifone.isd.topaz.sys.util.ConvertUPC
 */
public class ConvertUPC {

    /** A PLU whose characters are all zeroes
     */    
    public final static String ZeroPLU = "00000000000000";

    /** The length of a UPC-E symbol
     */    
    public static final int UPCE_LENGTH = 8;

    /** The length of a UPC-A symbol
     */    
    public static final int UPCA_LENGTH = 12;

    /** The length of an EAN-8 symbol
     */    
    public static final int EAN8_LENGTH = 8;

    /** The length of an EAN-13 symbol
     */    
    public static final int EAN13_LENGTH = 13;

    /** The length of a touch screen symbol
     */    
    public static final int SCREEN14_LENGTH = 14;

    /** Creates a new instance of ConvertUPC */
    protected ConvertUPC() {
    }

    /** This method is called from any keyboard input when a string of numeric
     * characters were entered (or expected to be entered) and assumed to be
     * a PLU.
     * For keyboard input, UPC-E will always be entered without the check
     * digit (the eight digit). All others will include check digit.
     * @param inString Numeric string entered from keyboard
     * @return The converted string to EAN13 format
     * @throws InvalidUPCCodeException Thrown when input is determined not to be a valid UPC type
     */    
    public static String getPLUfromKeyboard( String inString ) throws InvalidUPCCodeException {
        
        StringBuilder result = new StringBuilder();

        int inLength = inString.length();
        if ((inLength < 1) || (inLength > ZeroPLU.length()))
            throw new InvalidUPCCodeException( "Not a valid UPC; bad length - (" + inLength + ")" );

        // Valid digits are 0 thru 9 (both inclusive)
        try {
            Long.parseLong(inString);
        } catch (NumberFormatException nfe) {
            throw new InvalidUPCCodeException( "Non-Parsable UPC - (" + inString + ")" );
        }
        
        switch (inLength) {

            // For length = 6 and 7, assume UPC-E without a check digit
            case UPCE_LENGTH-2:
                inString = "0" + inString;
            case UPCE_LENGTH-1:
                inString = convertUPCE( inString );
                break;
                
            // For length = 8, assume EAN8 that includes check digit
            case EAN8_LENGTH :
            // For length = 12, assume UPCA that includes check digit
            case UPCA_LENGTH :
            // For length = 13, assume EAN13 that includes check digit
            case EAN13_LENGTH :           	
            	String ibuff = inString.substring(0, inLength - 1);
                StringBuilder tmpPLU = new StringBuilder();
                tmpPLU.append(ZeroPLU.substring(0, ZeroPLU.length() - inLength));
                tmpPLU.append(ibuff);
                
                // Validate if provided PLU contains check digit, if not then append check digit                
                if(!(createCheckDigit(tmpPLU.toString()) == inString.charAt(inLength - 1))){
                	inString = appendCheckDigit(inString, inLength);
                }
                break;
                // For length = 14, assume touch screen that includes check digit
            case SCREEN14_LENGTH :
                break;
            default :
                //Other lengths do not include check digit, which needs to be
                //computed and appended.
            	inString = appendCheckDigit(inString, inLength);
                break;
        }

        // If input length is less than that required for PLU lookup, prepend with zeroes to make it so
        if ( inString.length() < ZeroPLU.length() ) {
            result.append( ZeroPLU.substring(0, ZeroPLU.length() - inString.length()) );
        }

        result.append( inString );       
        return result.toString();
    }
	
	
	/** This method will convert a scanncode to the string required for proper
	 * database lookups of PLU's.
	 * @param scanType The scan type returned from the JPOS scanner service. Will also be found in the ScannerLexDataEvent.
	 * @param barcode The barcode that was scanned and presented by the JPOS service. Also will be found from
	 * ScannerLexDataEvent.
	 * @return The converted PLU lookup ready string.
	 * @throws InvalidUPCCodeException Thrown when input is determined not to be a valid UPC type
	 */
	public static String getPLUfromScancode( ScannerConst scanType, String barcode ) throws InvalidUPCCodeException {

		String pluString = barcode;
		StringBuilder pluBuffer = new StringBuilder();     

		// Valid digits are 0 thru 9 (both inclusive)
		try {
			Long.parseLong(pluString);
		} catch (NumberFormatException nfe) {
			throw new InvalidUPCCodeException( "Non-Parsable UPC - (" + pluString + ")" );
		}

		switch( scanType.getScannerConstNumberber() ) {
		case ScannerConst.SCAN_SDT_UPCE:
			pluString = ConvertUPC.convertUPCE( pluString );
			// The UPC-E is now converted to UPCA, fall through to UPC-A handling
		case ScannerConst.SCAN_SDT_UPCA:
			pluBuffer.append( ZeroPLU.substring(0, ZeroPLU.length() - pluString.length() ) );    // Prepend UPC-A with zeroes
			pluBuffer.append( pluString );
			break;

		case ScannerConst.SCAN_SDT_EAN8:
		case ScannerConst.SCAN_SDT_EAN13:
			pluBuffer.append( ZeroPLU.substring(0, ZeroPLU.length() - pluString.length() ) );
			pluBuffer.append( pluString );
			break;

		default :
			throw new InvalidUPCCodeException( "Not a valid UPC; bad type reported from scanner - (" + scanType + ")" );
		}		      
		return pluBuffer.toString();
    }


    /** Convert UPC-E without a check digit to UPC-A without a check digit
     * @param upce Seven character (digit) UPC-E string to convert
     * @return a UPC-A string
     * @throws InvalidUPCCodeException Thrown when input is determined not to be a valid UPC-E type
     */
    protected static String convertUPCE( String upce) throws InvalidUPCCodeException {

        if ( upce.length() != UPCE_LENGTH-1 ) {
            throw new InvalidUPCCodeException( "ConvertUPC:convertUPCE - Invalid UPC-E; bad length - (" + upce.length() + " != " + String.valueOf(UPCE_LENGTH-1) + ")" );
        }

        StringBuilder upca = new StringBuilder();

        switch ( upce.charAt(6) ) {

            case '0' :   // If last character is a '0'
            case '1' :   // '1'
            case '2' :   // '2'
                upca.append( upce.substring(0,3));
                upca.append( upce.charAt(6) );
                upca.append( ZeroPLU.substring(0,4));
                upca.append( upce.substring(3,6));
                break;

            case '3' :   // '3'
                upca.append( upce.substring(0,4));
                upca.append( ZeroPLU.substring(0,5));
                upca.append( upce.substring(4,6));
                break;

            case '4' :   // '4'
                upca.append( upce.substring(0,5));
                upca.append( ZeroPLU.substring(0,5));
                upca.append( upce.charAt(5) );
                break;

            default :
                upca.append( upce.substring(0,6));
                upca.append( ZeroPLU.substring(0,4));
                upca.append( upce.charAt(6) );
                break;
        }       
        upca.append( createCheckDigit( upca.toString() ) );
        
        return upca.toString();
    }

    private static char createCheckDigit( final String upc ) {
        
        int checkDigit = 0;
        for( int i = 0; i < upc.length(); i++ ) {
            int val = Integer.parseInt(upc.substring(i, i+1));
            if ( (i & 0x0001) != 0 ) {
                checkDigit += val;
            } else {
                checkDigit += val * 3;
            }
        }
        checkDigit = 10 - (checkDigit %= 10);
        if(checkDigit == 10)
            checkDigit = 0;
        
        //LOGGER.debug( "ConvertUPC:createCheckDigit UPC - " + upc +", Check digit - " + Character.forDigit( checkDigit, 10 ));
        return Character.forDigit( checkDigit, 10 );
    }
    
    public static void main(String[] args) {
        
        /*String upce = "04918202";
        
        if (args.length > 0) {
            upce = args[0];
        }

        try {
            String upca = convertUPCE( upce );
            System.out.println("Upc-E '" + upce + "' converts Upc-A '" + upca + "'");
        } catch ( InvalidUPCCodeException iuce ) {
            System.out.println("Invalid upce symbol '" + upce + "'");
        }*/
        
        String upca1 = "31";
        String upca2 = "085239081778";
        String upca3 = "08523908177";
        String upca4 = "8523908177";

        try {
            System.out.println("14 digit PLU " + getPLUfromKeyboard(upca1));
            System.out.println("14 digit PLU " + getPLUfromKeyboard(upca2));
            System.out.println("14 digit PLU " + getPLUfromKeyboard(upca3));
            System.out.println("14 digit PLU " + getPLUfromKeyboard(upca4));

        } catch ( InvalidUPCCodeException iuce ) {
            System.out.println(iuce.getMessage());
        }
        
    }
    
    private static String appendCheckDigit(String inString, int inLength){
    	StringBuilder tmpPLU = new StringBuilder();
        tmpPLU.append(ZeroPLU.substring(0, ZeroPLU.length() - (inLength + 1))); //allow a check digit to
                                             // be added
        tmpPLU.append(inString);
        tmpPLU.append(String.valueOf(createCheckDigit(tmpPLU.toString())));
        return tmpPLU.toString();
    }
}
