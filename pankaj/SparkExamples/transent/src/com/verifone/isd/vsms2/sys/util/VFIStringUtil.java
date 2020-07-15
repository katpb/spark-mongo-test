package com.verifone.isd.vsms2.sys.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;


/**
 * 
 * @author Murli
 * This is written to save memory while parsing stan files for report generetion.
 *
 */
public class VFIStringUtil {

    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger.
            getLogger(VFIStringUtil.class);
    /**
     * Default and basic XML tags and attributes considered when something goes
     * wrong while retrieving XML tags and attributes from the properties file
     * (Eg, prop file doesn't exist)
     */
    private static final String XML_TAGS_PROP = "xml_tags";
    private static final String XML_ATTRIB_PROP = "xml_attributes";
    private static final String ICC_TAGS_PROP = "icc_tags";
    /**
     * Xml tags which contain sensitive data.
     */
    private final static Set<String> tagsXML;
    /**
     * Xml Attributes which contain sensitive data.
     */
    private final static Set<String> attributesXML;
    /**
     * EMV Tags which contain sensitive data
     */
    private final static Set<String> tagsICC;
    
    private static String propPath = SysPropertyFactory.getPropPath();

    private static final String MASK_VOCAB_PROP = "MaskVocabulary.properties";
    private static final String SECURE_TAG = "SecureTag";
    private static final String SECURE_VALUE = "SecureValue";
    private static final String ICC_PARAMETER = "ICCParameter";
    private static final String ICC_VALUE = "ICCParameterValue";
    private static final String CARD_PAN = "CardPAN";
    
    private static final char COMMA = ',';
    private static final char EQUALS = '=';
    private static final char DOUBLE_QUOTE = '"';
    private static final char OPEN_TAG = '<';
    private static final char CLOSE_TAG = '>';
    private static final char A_SPACE = ' ';
    private static final char SLASH = '/';
    private static final char COLON = ':';

    static
    {

        tagsXML = new HashSet<String>();
        attributesXML = new HashSet<String>();
        tagsICC = new HashSet<String>();

        //  ----  mobile tags and attributes ----
        tagsXML.add("LoyaltyInstrument");
        attributesXML.add("paymentInfoID");
        attributesXML.add("loyaltyID");
        attributesXML.add("loyaltyNumber");
        // --------------------------------------
        
        tagsXML.add("Track1");
        tagsXML.add("Track2");
        tagsXML.add("Track3");
        tagsXML.add("LoyaltyID");
        tagsXML.add("InString");
        tagsXML.add("InNumber");
        tagsXML.add("Barcode");
        tagsXML.add("EmvDataElement");
        tagsXML.add(SECURE_TAG);
        tagsXML.add(SECURE_VALUE);
        tagsXML.add(ICC_PARAMETER);
        tagsXML.add(ICC_VALUE);
        tagsXML.add(CARD_PAN);

        attributesXML.add(CARD_PAN);
        attributesXML.add("CardCircuit");
        attributesXML.add("LoyaltyPAN");
        attributesXML.add("PINData");
        attributesXML.add("AtrData");
        attributesXML.add("TrackData");
        attributesXML.add("PINBlock");
        attributesXML.add("KSN");
        
        tagsICC.add("57");		// Track 2 Equivalent Data
        tagsICC.add("5A");		// PAN
       // tagsICC.add("5F24");	// Application Expiration Date
        tagsICC.add("5F30");	// Service Code
        tagsICC.add("5F20");	// CardHolder Name
        tagsICC.add("9F0B");	// CardHolder Name Extended
        tagsICC.add("ENCIPHEREDPINBLOCK");
        tagsICC.add("C4");		//Debit card
        tagsICC.add("C3");

        VFIStringUtil.getXMLTagsAndAttributes();
    }

    public static Set<String> getSecureICCTagsList(){
    	return tagsICC;
    }
    
	public static String substring(String str, int start, int end,
			boolean intern) {
		String retStr = str;
		if (str != null) {
			int strLen = str.length();
			if (strLen != 0 && start >= 0 && end <= strLen) {
				char[] dst = new char[end - start];
				str.getChars(start, end, dst, 0);
				retStr = new String(dst);
				if (intern) {
					retStr = retStr.intern();
				}
			}
		}

		return retStr;
	}

	public static String substring(String str, int start, boolean intern) {
		return substring(str, start, str.length(), intern);
	}

    /**
     * Reads and loads the sensitive XML tags and XML attributes from the
     * properties file (MaskVocabulary.properties)
     */
    private static void getXMLTagsAndAttributes()
    {

        Properties prop = new Properties();
        String propFile = propPath + File.separator + MASK_VOCAB_PROP;

        FileInputStream inputStream = null;

        try
        {
            inputStream = new FileInputStream(propFile);
            prop.load(inputStream);

            String xmlTags = prop.getProperty(XML_TAGS_PROP);
            String xmlAttributes = prop.getProperty(XML_ATTRIB_PROP);
            String iccTags = prop.getProperty(ICC_TAGS_PROP);

            if (xmlTags != null)
            {
                String[] tagArray = xmlTags.split(String.valueOf(COMMA));

                for (int i = 0; i < tagArray.length; i++)
                {
                    tagsXML.add(tagArray[i].trim());
                }
            }

            if (xmlAttributes != null)
            {
                String[] attributeArray = xmlAttributes.split(String.valueOf(
                        COMMA));

                for (int i = 0; i < attributeArray.length; i++)
                {
                    attributesXML.add(attributeArray[i].trim());
                }
            }
            
            if (iccTags != null)
            {
            	String[] tagArray = iccTags.split(String.valueOf(COMMA));

            	for (int i = 0; i < tagArray.length; i++)
            	{
            		if(!tagArray[i].isEmpty()) {
            			tagsICC.add(tagArray[i].trim().toUpperCase());
            		}
            	}
            }

        } catch (IOException e)
        {
            LOG.error("Could not load the properties file : " + e.getMessage(),
                      e);
            LOG.info(
                    "Problem in loading MaskVocabulary, using default XML tags and attributes");
        } finally
        {
            try
            {
                if (inputStream != null)
                {
                    inputStream.close();
                }
            } catch (IOException e)
            {
                LOG.
                        error("Failed to close the input stream : " + e.
                        getMessage());
            }
        }
    }

    /**
     * Masks the sensitive data based on sensitive XML tags and attributes
     * present in the log message
     *
     * @param logMessage A string which may or may not contain
     * sensitive data as part of XML tags and attributes
     * @return Masked string if there were any sensitive data. Otherwise, the
     *         same string is returned.
     */
    public static String getMaskedMessage(String logMessage)
    {

        char[] logChars = processTags(logMessage.toCharArray());

        logChars = processAttributes(logChars);

        return String.valueOf(logChars);
    }

    /**
     * This method reads an antire log message and asks all sensitive data
     * present within the attributes which are considered as sensitive
     *
     * @param originalChars Entire log message which will be parsed to search
     * and mask any sensitive data
     * @return masked log message
     */
    static char[] processAttributes(char[] originalChars)
    {

        char[] logChars = originalChars;
        boolean isSpaceFound = false, isDataBeingRead = false;
        int startAttrIndex = -1, endAttrIndex;
        int startDataIndex = -1, endDataIndex;
        int attrbLength;

        for (int index = 0; index < logChars.length; index++)
        {

            char currentChar = logChars[index];

            if (isSpaceFound && startAttrIndex != -1 && currentChar == A_SPACE)
            {
                startAttrIndex = -1;
                isDataBeingRead = false;
                startDataIndex = -1;
                isSpaceFound = true;
            }

            if ((currentChar == A_SPACE || isSpaceFound) && !isDataBeingRead)
            {

                isSpaceFound = true;
                if (startAttrIndex == -1)
                {
                    startAttrIndex = index + 1;
                }
            } else if (isDataBeingRead && currentChar == DOUBLE_QUOTE)
            {

                endDataIndex = index;
                int dataLength = endDataIndex - startDataIndex - 1;
                char[] sensitiveData = new char[dataLength];
                System.arraycopy(logChars, startDataIndex + 1, sensitiveData, 0,
                                 dataLength);

                // take the sensitive data and mask it.
             	char[] maskedSensitiveData = SensitiveDataMasker.mask(sensitiveData);

                // copy the whole sensitive data, staring at the beginning (0), over the unmasked data in
             	// the logChars array where it appears in the tag (startDataIndex)      
           	    //
                System.arraycopy(maskedSensitiveData, 0, logChars, startDataIndex, dataLength);   
                
                
               // logChars = getMaskedChars(logChars, sensitiveData);
                isSpaceFound = true;
                isDataBeingRead = false;
                startDataIndex = -1;
            }
            if (isSpaceFound && startAttrIndex != -1 && currentChar == EQUALS)
            {
                endAttrIndex = index;
                attrbLength = endAttrIndex - startAttrIndex;
                char[] attributeName = new char[attrbLength];
                System.arraycopy(logChars, startAttrIndex, attributeName, 0,
                                 attrbLength);
                if (isSensitiveAttrb(attributeName))
                {

                    startAttrIndex = -1;
                    isDataBeingRead = true;
                    index += 1;
                    startDataIndex = index;
                } else
                {
                    startAttrIndex = -1;
                    isSpaceFound = false;
                }
            }
        }

        return logChars;
    }

    /**
     * This method checks whether the attributeName is considered as a sensitive
     * attribute, true if yes, false otherwise
     *
     * @param attributeName
     * @return
     */
    private static boolean isSensitiveAttrb(char[] attributeName)
    {
        return attributesXML.contains(String.valueOf(attributeName));
    }

    /**
     * This method reads an antire log message and asks all sensitive data
     * present within the XML tags which are considered as sensitive
     *
     * @param originalChars Entire log message which will be parsed to search
     * and mask any sensitive data
     * @return masked log message
     */
    static char[] processTags(char[] originalChars)
    {

        char[] logChars = originalChars;
        boolean isOpenTagFound = false, isDataBeingRead = false;
        int startTagIndex = -1, endTagIndex = -1;
        int startDataIndex = -1, endDataIndex = -1;
        int taglength = -1;
        String currentTag = null;
        String lastICCTag = null;

        for (int index = 0; index < logChars.length; index++)
        {
			int tempIndex = index;
            char currentChar = logChars[index];

            if ((currentChar == OPEN_TAG || isOpenTagFound) && !isDataBeingRead
                && (index != logChars.length - 1 && logChars[index + 1] != SLASH))
            {
                /**
                 * Comes here when the fresh open tag is found
                 */
                isOpenTagFound = true;
                if (startTagIndex == -1)
                {
                    startTagIndex = index;
                }
            } else if (isDataBeingRead && startDataIndex == -1)
            {
                /**
                 * Comes here when the data inside an XML tags is about to be
                 * read
                 */
                startDataIndex = index;
            } else if (isDataBeingRead && startDataIndex != -1 && endDataIndex == -1 && currentChar == OPEN_TAG)
            {
                /**
                 * Comes here when the data inside an XML tags is read
                 * completely
                 */
                endDataIndex = index;
                int sensitivedataLen = (endDataIndex - startDataIndex);
                char[] sensitiveData = new char[sensitivedataLen];

                System.arraycopy(logChars, startDataIndex, sensitiveData, 0,
                                 sensitivedataLen);
                
                if(currentTag.equalsIgnoreCase(SECURE_TAG) 
                		|| currentTag.equalsIgnoreCase(ICC_PARAMETER)) {
                	lastICCTag = String.valueOf(sensitiveData);
                } else if(currentTag.equalsIgnoreCase(SECURE_VALUE) 
                		|| currentTag.equalsIgnoreCase(ICC_VALUE)) {
                	if(lastICCTag!=null && tagsICC.contains(lastICCTag.toUpperCase())) {
                		logChars = getMaskedChars(logChars, sensitiveData,startDataIndex,endDataIndex);
                	}
                }else if(currentTag.equalsIgnoreCase("EmvDataElement")) { // Line has tag EMVDataElement
                	Iterator<String> tagsIcc = tagsICC.iterator();			// loop for tagsICC Strings
                	while(tagsIcc.hasNext()) {								// while loop for tagsICC Hashset<String>
                		Pattern pattern = Pattern.compile(tagsIcc.next(), Pattern.CASE_INSENSITIVE);
                		Matcher match = pattern.matcher(String.copyValueOf(sensitiveData));
                		if(match.lookingAt()) { //if tagsICC String matches with EmvDataElement tag data then mask the numbers.
                			logChars = getMaskedChars(logChars, sensitiveData,startDataIndex,endDataIndex);
                		}
                	}
                	
                }else {
                	
                	 // take the sensitive data and mask it.
                  	 char[] maskedSensitiveData = SensitiveDataMasker.mask(sensitiveData);

                     // copy the whole sensitive data, staring at the beginning (0), over the unmasked data in
                	 // the logChars array where it appears in the tag (startDataIndex)      
                	 //
                     System.arraycopy(maskedSensitiveData, 0, logChars, startDataIndex, sensitivedataLen);                     
                }
                
                isOpenTagFound = false;
                isDataBeingRead = false;
                
				index = tempIndex - 1;
				startDataIndex = -1;
				endDataIndex = -1;
				startTagIndex = -1; 
				endTagIndex = -1;
				taglength = -1;

            } else if (!isOpenTagFound)
            {
                /**
                 * Default, when no interesting thing is found
                 */
                continue;
            }

            if (isOpenTagFound && !isDataBeingRead)
            {

                if (currentChar == CLOSE_TAG && endTagIndex == -1)
                {
                    endTagIndex = index;
                    taglength = endTagIndex - startTagIndex;
                    char[] tagNameBuffer = new char[taglength - 1];

                    System.arraycopy(logChars, startTagIndex + 1, tagNameBuffer,
                                     0, taglength - 1);
                    
                    tagNameBuffer = removeSpace(removeNameSpace(tagNameBuffer));
                   
                    if (isSensitiveTag(tagNameBuffer))
                    {
                        currentTag = String.valueOf(tagNameBuffer);
                        startTagIndex = -1;
                        endTagIndex = -1;
                        isDataBeingRead = true;

                    } else
                    {
                        startTagIndex = -1;
                        endTagIndex = -1;
                        isOpenTagFound = false;
                    }
                }
            }
        }

        return logChars;
    }

    /**
     * This method gets the entire log message in
     * <code>logChars</code> and finds
     * <code>sensitiveData</code> present in it. If it is present, it replaces
     * <code>sensitiveData</code> present in
     * <code>logChars</code> with a masked sensitive data appending
     * <code>prefix</code> and
     * <code>suffix</code> at the start and ent respectively.
     *
     * @param logChars Entire log message
     * @param sensitiveData Sensitive data to be searched and masked
     * @return
     */
	public static char[] getMaskedChars(char[] logChars, char[] sensitiveData) {
		char[] unMaskedData = new char[sensitiveData.length];
		System.arraycopy(sensitiveData, 0, unMaskedData, 0, sensitiveData.length);
		return replaceCharacters(logChars, unMaskedData, SensitiveDataMasker.mask(sensitiveData));
	}
	
	/**
	 * This method gets the log message and finds sensitive data present in it and replaced with masked data from the startIndex
	 * 
	 * NOTE:  THIS METHOD REPLACES THE FIRST OCCURENCE OF THE UNMASKED DATA.   -->This is not always correct.<--  
	 * 
	 * There is a case where the sensitive data occurrs first in an attribute, then in a tag. 
	 * The processTags() method will then mask the attribute (since it occurs first) and leave the sensitive data alone in the tag.
	 * 
	 * 
	 * @param logChars
	 * @param sensitiveData
	 * @param startIndex
	 * @return
	 */
	static char[] getMaskedChars(char[] logChars, char[] sensitiveData, int startIndex, int endIndex) {
		StringBuilder sb = new StringBuilder();
		sb.append(logChars);
		char[] maskedChars = sb.replace(startIndex, endIndex, new String(SensitiveDataMasker.mask(sensitiveData))).toString().toCharArray(); 
		return maskedChars;
	}

    /**
     *
     * @param mainChar Original entire characters
     * @param subChar characters which are sensitive and that is to be masked.
     * This should be present in <code>mainChar</code>
     * @param replaceChar Character set which is the replacement
     * of <code>subChar</code> , probably a masked character set
     * @return
     */
    private static char[] replaceCharacters(char[] mainChar, char[] subChar,
                                     char[] replaceChar)
    {

        int mainStart = -1, mainEnd = -1;

        int subCharIndex = 0;
        if ((mainChar.length >= subChar.length) && subChar.length > 0)
        {
            for (int i = 0; i < mainChar.length; i++, subCharIndex++)
            {

                char mainCh = mainChar[i];
                char subCh = subChar[subCharIndex];

                if (mainCh == subCh)
                {
                    if (mainStart == -1)
                    {
                        mainStart = i;
                    }
                } else
                {
                    subCharIndex = -1;
                    mainStart = -1;
                    mainEnd = -1;
                }

                if (subCharIndex == subChar.length - 1 && mainStart != -1 && mainEnd == -1)
                {
                    mainEnd = i;
                    break;
                }
            }
        }

        char[] resultArr =
               new char[mainChar.length - subChar.length + replaceChar.length];

        resultArr = replace(resultArr, mainChar, replaceChar, mainStart, mainEnd);
        return resultArr;
    }
 
    /**
     * 
     * @param resultArr
     * @param mainChar
     * @param replaceChar
     * @param mainStart
     * @param mainEnd
     * @return
     */
    private static char[] replace(char[] resultArr, char[] mainChar, char[] replaceChar, int mainStart, int mainEnd) {
    	int mainIndex;
    	for (mainIndex = 0; mainIndex < mainStart; mainIndex++)
    	{
    		resultArr[mainIndex] = mainChar[mainIndex];
    	}

    	int replaceCharIndex = 0;
    	for (int i = mainIndex; i < mainIndex + replaceChar.length; i++, replaceCharIndex++)
    	{
    		if (replaceCharIndex == replaceChar.length)
    		{

    			break;
    		}
    		resultArr[i] = replaceChar[replaceCharIndex];
    		mainIndex = i;
    	}

    	++mainEnd;

    	for (int i = mainIndex + 1; i < resultArr.length; i++)
    	{
    		resultArr[i] = mainChar[mainEnd++];
    	}
    	return resultArr;
    }
    /**
     * Checks whether the inputTag is considered as a sensitive XML tag, true if
     * yes, false otherwise
     *
     * @param attributeName
     * @return
     */
    private static boolean isSensitiveTag(char[] inputTag)
    {
        String inputTagStr = String.valueOf(inputTag);
        return tagsXML.contains(String.valueOf(inputTagStr));
    }
    
    private static char[] removeSpace(char[] inputTag)
    {

        int spaceIndex = getSpaceIndex(inputTag);

        if (spaceIndex != -1)
        {
            char[] modifiedTag = new char[spaceIndex];
            System.arraycopy(inputTag, 0, modifiedTag, 0, spaceIndex);
            inputTag = modifiedTag;
        }

        return inputTag;
    }

    /**
     * This method is used to get the space index after the XML tag. Eg: <MyTag
     * MyAttribute="someData"></MyTag> for this, it will return the index if the
     * space present after the start tag "<MyTag"
     *

     *
     * @param inputTag
     * @return
     */
    private static int getSpaceIndex(char[] inputTag)
    {

        int spaceIndex = -1;

        for (int i = 0; i < inputTag.length; i++)
        {

            if (inputTag[i] == A_SPACE && spaceIndex == -1)
            {
                spaceIndex = i;
                break;
            }
        }

        return spaceIndex;
    }

    /**
     * This method is used to remove the name spance present in an XML tag.
     *
     * @param inputTag
     * @return
     */
    private static char[] removeNameSpace(char[] inputTag)
    {

        char[] newChar = inputTag;

        for (int i = 0; i < inputTag.length; i++)
        {

            if (inputTag[i] == COLON)
            {
                newChar = new char[inputTag.length - i - 1];
                System.arraycopy(inputTag, i + 1, newChar, 0, newChar.length);
                break;
            }
        }
        return newChar;
    }

}
