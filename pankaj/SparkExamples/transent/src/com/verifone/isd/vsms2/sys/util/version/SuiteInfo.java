/*
 * SuiteInfo.java
 * Copyright (C) 2012 Verifone, Inc.                     ALL RIGHTS RESERVED
 */
package com.verifone.isd.vsms2.sys.util.version;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.sys.util.version.SuiteInfoConstants;

import com.verifone.isd.vsms2.sys.util.FileUtil;
import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;

/**
 * Reads suite version information from a file and exposes same via public
 * methods.  Also reads and exposes customer profile selection from a file,
 * and reads and exposes the selected commander variant as an enumerated value. 
 * 
 * Typical "suiteinfo.dat" file content for Site Controller and Topaz with Site
 * Controller:
 * <p>
 * #<br>
 * # Suite Info configuration file<br>
 * #<br>
 * Suite_Name =chevron<br>
 * Suite_Version =6.00.00<br>
 * Base_Level =001.00.00<br>
 * source_hash =62f5bed11803b0d86a332cbfb279a2368a42433b<br>
 * Timestamp =2012-05-... <br>
 * <p>
 * 
 * Note: - This class was moved to sys/util and modified to take fileName for
 * parsing. This was done in order to make it accessible for a web component
 * <p>
 * Updated for Site Controller suite by:
 * 
 * @author David_G3
 */
public class SuiteInfo {
    private Logger logger = LoggerFactory.getLogger(SuiteInfo.class);

    // Customer profile information file and keyword
    public static final String CUSTOMER_PROFILE = "customerProfile.txt";
    private static final String PROFILE_NAME="Profile_Name";
    
    // Commander variant information file and keyword    
    public static final String COMMANDER_VARIANT = "commanderVariant.txt";
    private static final String VARIANT_NAME="Commander_Variant";
    
    /**
     * Code values that describe the possible Commander product variants (including no variant)
     */
    public enum CommanderVariant {
    	/**
    	 * Standard Commander (full functionality, no variant) 
    	 */
    	CMDR("Commander"),
    	
    	/**
    	 * Commander E (EPS functionality only) 
    	 */
    	CMDR_E("Commander E"),

    	/**
    	 * Commander F (Forecourt functionality only) 
    	 */
    	CMDR_F("Commander F"),

    	/**
    	 * Commander EF (EPS and Forecourt functionality only) 
    	 */
    	CMDR_EF("Commander EF");
    
    	private String commanderVariantLongName = null;

		CommanderVariant(String commanderVariantLongName) {
    		this.commanderVariantLongName = commanderVariantLongName;
    	}
    	
		/**
		 * Get the long name of the related Commander variant
		 * @return the long name of the related Commander variant
		 */
    	public String getCommanderVariantLongName() {
			return commanderVariantLongName;
		}
    }
    
    private String suiteVersionLine;
    private String suiteName;
    private String suiteVersion;
    private String baseVersion;
    private String suiteTimeStamp;
	private String sourceHash;
	private String customerProfileName;
    private CommanderVariant commanderVariant;
    
    public SuiteInfo() {
    	String fileName = SysPropertyFactory.makeAbsoluteConfigPath(SuiteInfoConstants.SUITEINFO_FILE_NAME);
        readVersionDetails(fileName);
        readCustomerProfileDetails();
        readCommanderVariantDetails();
    }
    
    public SuiteInfo(String fileName) {
        readVersionDetails(fileName);
        readCustomerProfileDetails();
        readCommanderVariantDetails();
    }
    
    private void readVersionDetails(String fileName) {
    	
        FileReader fileReader = null;
        BufferedReader br = null;
        try {
        	File f = new File(fileName);
            if (f.exists()) {
            	fileReader = new FileReader(f);
                br = new BufferedReader(fileReader);
                String text;
                while ((text = br.readLine()) != null) {
                    this.parseText(text);
                }
            }
            else {
                logger.error(fileName +" file not found");
            }
        }
        catch (Exception e) {
            logger.error("Error reading " + SuiteInfoConstants.SUITEINFO_FILE_NAME +": " +e.toString() +" " +e.getMessage());
        } finally {
        	FileUtil.closeResource(fileReader);
        	FileUtil.closeResource(br);
        }
    }
    
    private void parseText(String text) {
        int index = text.indexOf("=");
        if (index > 0) {
            String value = text.substring(index+1).trim();
            if (text.startsWith(SuiteInfoConstants.SUITE_NAME)) {
                setSuiteName(value);
            }
            else if (text.startsWith(SuiteInfoConstants.SUITE_VER)) {
            	setSuiteVersion(value);
        		this.suiteVersionLine = text.trim();
            }
            else if (text.startsWith(SuiteInfoConstants.BASE_VER)) {
                setBaseVersion(value);
            } 
            else if (text.startsWith(SuiteInfoConstants.TIMESTAMP)) {
                setSuiteTimeStamp(value);
            }       
            else if (text.startsWith(SuiteInfoConstants.SOURCE_HASH)) {
                setSourceHash(value);
            }
        }
    }

    /**
     * method to read the customer profile name
     */
    private void readCustomerProfileDetails() {
    	String fileName = SysPropertyFactory.makeAbsoluteConfigPath(CUSTOMER_PROFILE);
        BufferedReader br = null;
        FileInputStream fileInputStream = null;
        try {
        	File profile = new File(fileName);
            if (profile.exists()) {            	
            	fileInputStream = new FileInputStream(profile);
            	br = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));		
                String text;
                while ((text = br.readLine()) != null) {
                	StringTokenizer tokenizer = new StringTokenizer(text, "=");
            		if (tokenizer.countTokens() == 2) {
            			String key = tokenizer.nextToken();
            			String value = tokenizer.nextToken();            			
            			if (key.equalsIgnoreCase(PROFILE_NAME) && value!= null){
            				setCustomerProfileName(value.trim());
            			}
            		}
                }
            }
            else {
                logger.info(fileName +" file not found");
            }
        }
        catch (Exception e) {
            logger.error("Error reading " +CUSTOMER_PROFILE +": " +e.toString() +" " +e.getMessage());
        } finally {
        	FileUtil.closeResource(fileInputStream);
        	FileUtil.closeResource(br);
        }
    }

    /**
     * method to read the Commander variant
     */
    private void readCommanderVariantDetails() {
    	String fileName = SysPropertyFactory.makeAbsoluteCommonDataPath(COMMANDER_VARIANT);
        BufferedReader br = null;
        FileInputStream fileInputStream = null;
        try {
        	File profile = new File(fileName);
            if (profile.exists()) {            	
            	fileInputStream = new FileInputStream(profile);
            	br = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));		
                String text;
                while ((text = br.readLine()) != null) {
                	StringTokenizer tokenizer = new StringTokenizer(text, "=");
            		if (tokenizer.countTokens() == 2) {
            			String key = tokenizer.nextToken();
            			String value = tokenizer.nextToken();            			
            			if (key.equalsIgnoreCase(VARIANT_NAME) && value!= null){
            				setCommanderVariant(CommanderVariant.valueOf(value.trim()));
            			}
            		}
                }
            }
            else {
                logger.info(fileName +" file not found");
            }
        }
        catch (Exception e) {
            logger.error("Error reading " +COMMANDER_VARIANT +": " +e.toString() +" " +e.getMessage());
        } finally {
        	FileUtil.closeResource(fileInputStream);
        	FileUtil.closeResource(br);
        }
    }
    
	public String getBaseVersion() {
		return baseVersion;
	}

	void setBaseVersion(String baseVersion) {
		this.baseVersion = baseVersion;
	}

	public String getSuiteName() {
		return suiteName;
	}

	void setSuiteName(String suiteName) {
		this.suiteName = suiteName;
	}

	public String getSuiteVersion() {
		return suiteVersion;
	}

	void setSuiteVersion(String suiteVersion) {
		this.suiteVersion = suiteVersion;
	}

	public String getSuiteVersionLine() {
		return suiteVersionLine;
	}

	public String getSuiteTimeStamp() {
		return suiteTimeStamp;
	}

	void setSuiteTimeStamp(String suiteTimeStamp) {
		this.suiteTimeStamp = suiteTimeStamp;
	}
	
	private void setSourceHash(String value) {
		this.sourceHash = value;
	}
	
	public String getSourceHash() {
		return this.sourceHash;
	}

	/**
	 * Get the customer profile that was selected during installation
	 * @return Customer profile that is in effect (might be null if could not be read from file)
	 */
	public String getCustomerProfileName() {
		return customerProfileName;
	}

	void setCustomerProfileName(String customerProfileName) {
		this.customerProfileName = customerProfileName;		// TODO: Unclear if we should allow run with a null customer profile
	}

	/**
	 * Get the Commander product variant that was selected during installation.
	 * If we have auto-upgraded from a previous version that had no such selection made
	 * (i.e., the commanderVariant.txt file does not exist) then the "no variant" enumeration
	 * will be reported.
	 * @return Commander product variant that is in effect (will never be null)
	 */
	public CommanderVariant getCommanderVariant() {
		if (commanderVariant == null)
			return CommanderVariant.CMDR;
		return commanderVariant;
	}

	void setCommanderVariant(CommanderVariant commanderVariant) {
		this.commanderVariant = commanderVariant;
	}
}
