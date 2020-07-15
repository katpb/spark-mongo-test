package com.verifone.isd.vsms2.sys.util.version;

public class SuiteInfoConstants {
	
    public static final String UTF8_CHARSET_STR = "UTF-8";
    public static final String SUITEINFO_FILE_NAME = "suiteinfo.dat";    
    public static final String SUITE_NAME = "Suite_Name";
    public static final String SUITE_VER = "Suite_Version";
	public static final String BASE_VER = "Base_Level";          // was "Base_Ver" on Sapphire
	public static final String SOURCE_HASH = "Source_Hash";
    public static final String TIMESTAMP = "Timestamp";    
    public static final String KIOSK_INSTALLED_VER_FILE_PROP = "kiosk.installed.version.file";
    public static final String KIOSK_INSTALLED_VER_FILE = "/home/coresvcs/config/kioskSuiteInfo.dat";	// TODO: Use AbsoluteConfigPath
    public static final String SUITE_INFO_CONFIGURATION_FILE = "Suite Info configuration file";
    public static final int MASTER_KIOSK_SYS_ID = 151;
    
        //Make sure no one tries to instantiate this class
	protected SuiteInfoConstants() {}
}
