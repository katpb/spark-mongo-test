/*
 * KioskInfo.java
 * Copyright (C) 2016 Verifone, Inc.                     ALL RIGHTS RESERVED
 */
package com.verifone.isd.vsms2.sys.util.version;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.sys.util.FileUtil;
import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;

/**
 * Reads kiosk version information from a file and exposes same via public
 * methods.
 * 
 * Typical "kioskinfo.dat" file content for Commander:
 * <p>
 * #<br>
 * # Kiosk Info configuration file<br>
 * #<br>
 * Kiosk_Name =Kiosk<br>
 * Kiosk_Version =1.22.33<br>
 * <p>
 * 
 * @author David_G3
 */
public class KioskInfo {
    private Logger logger = LoggerFactory.getLogger(KioskInfo.class);
    
    private String kioskSuiteFile;
    private String kioskVersionLine;
    private String kioskName;
    private String kioskVersion;
    private String kioskTimestamp;

	public KioskInfo() {
    	kioskSuiteFile = SysPropertyFactory.getProperty(SuiteInfoConstants.KIOSK_INSTALLED_VER_FILE_PROP, SuiteInfoConstants.KIOSK_INSTALLED_VER_FILE);    	
        readKioskSuiteVersionDetails(kioskSuiteFile);
    }
    
    public KioskInfo(String fileName) {
        readKioskSuiteVersionDetails(fileName);
    }

    private void readMasterKioskVersionDetails() {
    	KioskVersionDetails verDetails = new KioskDetailsProcessor().getMasterKioskDetails();
    	if (verDetails != null) {
    		ArrayList<KioskModuleDetails> moduleList = verDetails.getModulesList();
    		if (moduleList != null) {
    			if (!moduleList.isEmpty()) {
		    		// Assumption made per email of 15-Feb-2017 "RE: CR1141.01 design document review" with AU team: the list contains only one module, which represents the package
    				if (moduleList.size() == 1) {
		    			try {
				    		KioskModuleDetails moduleDetails = moduleList.get(0);
				    		String moduleName = moduleDetails.getModuleName();
				    		if ((moduleName != null) && (moduleName.length() != 0)) {
					    		String moduleVersion = moduleDetails.getModuleVer();
					    		if ((moduleVersion != null) && (moduleVersion.length() != 0)) {
					                setKioskName(moduleName);
					                setKioskVersion(moduleVersion);
						    		String moduleTimestamp = moduleDetails.getTimeStamp();
						    		setKioskTimestamp(moduleTimestamp);
					    		} else {
			    					logger.error("Kiosk module version is null or empty");				    								    			
					    		}
				    		} else {
		    					logger.error("Kiosk module name is null or empty");				    			
				    		}
		    			}
		    			catch (IndexOutOfBoundsException e) {
	    					logger.error("Unable to get Kiosk module list", e);		    				
		    			}
    				} else {
    					logger.error("Kiosk module list is ambiguous, contains more than a single entry");
    				}
    			} else {
    				logger.error("Kiosk module list is empty");
    			}
    		} else {
        		logger.error("Unable to get Kiosk module list (is null)");    			
    		}
    	} else {
    		logger.warn("Unable to get master Kiosk version, is Kiosk installed and communicating?");
    	}
    }
    
    private void readKioskSuiteVersionDetails(String fileName) {
    	
        InputStreamReader streamReader = null;
        BufferedReader br = null;
        boolean isAbleToRead = false;
        try {
        	File f = new File(fileName);
            if (f.exists()) {
            	streamReader = new InputStreamReader(new FileInputStream(f), SuiteInfoConstants.UTF8_CHARSET_STR);
                br = new BufferedReader(streamReader);
                String text;
                while ((text = br.readLine()) != null) {
                    this.parseText(text);
                }
                isAbleToRead = true;
            }
        }
        catch (Exception e) {
            logger.error("Error reading " + kioskSuiteFile +": " +e.toString() +" " +e.getMessage());
        } finally {
        	FileUtil.closeResource(streamReader);
        	FileUtil.closeResource(br);
        }
        
        if (!isAbleToRead) {
            logger.info(fileName +" file not found, will attempt read from master kiosk XML file...");
            readMasterKioskVersionDetails();        	
        }
    }
    
    private void parseText(String text) {
        int index = text.indexOf("=");
        if (index > 0) {
            String value = text.substring(index+1).trim();
            if (text.startsWith(SuiteInfoConstants.SUITE_NAME)) {
                setKioskName(value);
            }
            else if (text.startsWith(SuiteInfoConstants.SUITE_VER)) {
            	setKioskVersion(value);
        		this.kioskVersionLine = text.trim();
            }
            else if (text.startsWith(SuiteInfoConstants.TIMESTAMP)) {
            	setKioskTimestamp(value);
            }
        }
    }
    
	public String getKioskName() {
		return kioskName;
	}

	void setKioskName(String suiteName) {
		this.kioskName = suiteName;
	}

	public String getKioskVersion() {
		return kioskVersion;
	}

	void setKioskVersion(String suiteVersion) {
		this.kioskVersion = suiteVersion;
	}

	public String getKioskVersionLine() {
		return kioskVersionLine;
	}
    
    public String getKioskTimestamp() {
		return kioskTimestamp;
	}

	void setKioskTimestamp(String kioskTimestamp) {
		this.kioskTimestamp = kioskTimestamp;
	}
}
