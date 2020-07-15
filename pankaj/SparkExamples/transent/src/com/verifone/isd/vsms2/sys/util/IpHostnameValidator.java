package com.verifone.isd.vsms2.sys.util;

import java.util.regex.Pattern;
import com.verifone.isd.xml.vocabulary.IXMLVocabulary;

/**
 *  Utility class to check for validity of IP and Hostname 
 *  @version 1.0
 *  @author suhailj1
 *
 */

public class IpHostnameValidator {
	
	public static void isValidHostnameOrIp(String ipOrHostname) throws InvalidIpHostnameException {
    	Pattern UrlPattern = Pattern.compile(IXMLVocabulary.HOSTNAME_REGEX_PATTERN);
    	Pattern IpPattern = Pattern.compile(IXMLVocabulary.IPADDRESS_REGEX_PATTERN);
		if(!UrlPattern.matcher(ipOrHostname).matches())
		{
			if(!IpPattern.matcher(ipOrHostname).matches())
			{
				throw new InvalidIpHostnameException();
			} 
		}
    }
    
    public static void checkForIpAndHostname(String ipOrHostname) throws InvalidIpHostnameException { 		
    	if(StringUtils.isNotNullNotEmpty(ipOrHostname)) {
    		isValidHostnameOrIp(ipOrHostname);
    	} else {
    		throw new InvalidIpHostnameException();
    	}	
    }
    
    public static boolean isIPValid(String ipAddress) {
    	boolean returnVal = false;
    	if(StringUtils.isNotNullNotEmpty(ipAddress)) {
    		try{
    			isValidHostnameOrIp(ipAddress);
    			returnVal = true;
    		} catch(InvalidIpHostnameException e) {
    			returnVal = false;
    		}		
    	} 
    	return returnVal;
    }
    
}
