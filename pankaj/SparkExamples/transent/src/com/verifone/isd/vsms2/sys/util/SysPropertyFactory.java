package com.verifone.isd.vsms2.sys.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**  
 * Class to manage application properties database (private and configurable
 * properties). All the methods in this class are static.
 * This class now supports a fluent API -- please refer to
 * {@link PropParser#getProp(String propName)} and friends, below.
 * For transparent read access to properties, clients should use
 * SysPropertyFactory#getProperty method.
 * Overall precedence: Private properties -> Config properties
 * Private properties precedence:
 * $HOME/config/app_private -> COMMON/config/app_private ->
 * HOME/config/private -> $COMMON/config/private
 * Config properties precedence:
 * $COMMON/config/app_config -> $COMMON/config/config
 * @version 1.0
 * @author David Ezell "mailto:david_ezell@verifone.com"
 */
public class SysPropertyFactory
{
    static final String APP_CONFIG_FILE = "app_config_system.prop";
    static final String BASE_CONFIG_FILE = "config_system.prop";
    static final String APP_PRIVATE_PATH = "app_private_system.prop";
    static final String BASE_PRIVATE_PATH = "private_system.prop";

    //Begin Properties passed in via System properties (-D option)
    static final String USER_DIR_PROPNAME = "user.dir";
    static final String COMMON_HOME_DIR_PROPNAME = "home.common.dir";
    static final String CORESVCS_HOME_DIR_PROPNAME = "home.coresvcs.dir";
    static final String STC_HOME_DIR_PROPNAME = "home.stc.dir";
    static final String FCC_HOME_DIR_PROPNAME = "home.fcc.dir";
    static final String PMC_HOME_DIR_PROPNAME = "home.pmc.dir";
    private static final String CONFIG_DIR_PROPNAME = "config.dir";
    //End Properties passed in via System properties (-D option)

    private static final String DEFAULT_COMMON_HOME_DIR = "/home/common";
    private static final String DEFAULT_CONFIG_DIR = "config";
    
    private static final String DATA_DIR_PROPNAME = "data.dir";
    private static final String DEFAULT_DATA_DIR = "data";
    private static final String LIB_DIR_PROPNAME = "lib.dir";
    private static final String DEFAULT_LIB_DIR = "lib";
    private static final String BIN_DIR_PROPNAME = "bin.dir";
    private static final String DEFAULT_BIN_DIR = "bin";
    private static final String DEFAULT_PROP_DIR = "prop";
    private static final String SECURITY_DIR_PROPNAME = "security.dir";
    private static final String DEFAULT_SECURITY_DIR = "security";
	
    private static boolean configurablePropRefreshNeeded = false;
    private static Properties appConfigurableInstance = null;
    private static Properties baseConfigurableInstance = null;
    private static Properties privateInstance = null;
    private static Properties allConfigurableProps;
    private static final Logger theLogger;
    private static final String COMMON_HOME_DIR;
    public static final String CONFIG_DIR;

    private static final String USER_NAME_PROPNAME = "user.name";
    private static final String USER_HOME_PROPNAME = "user.home";
    private static final String DEFAULT_VIPER_USER = "jade";
    static {
        theLogger = LoggerFactory.getLogger(SysPropertyFactory.class);
        allConfigurableProps = new Properties();
       
        if (isViperPlatform()) 
        {
        	COMMON_HOME_DIR = System.getProperty(USER_DIR_PROPNAME);
        }else
        {          	
           COMMON_HOME_DIR = System.getProperty(COMMON_HOME_DIR_PROPNAME, DEFAULT_COMMON_HOME_DIR);
        }
        CONFIG_DIR = System.getProperty(CONFIG_DIR_PROPNAME, DEFAULT_CONFIG_DIR);
        try {
            getInstance();
        }
        catch (Exception e) {
            theLogger.error("Error loading SysPropertyFactory", e);
        }
    }
    
    private SysPropertyFactory()    // can't create an instance, static only
    {
    }

    public static boolean isViperPlatform()
    {
    	boolean IS_WINDOWS = System.getProperty("os.name").toLowerCase().startsWith("windows");
    	return (DEFAULT_VIPER_USER.equals(System.getProperty(USER_NAME_PROPNAME)) || IS_WINDOWS); 
    }
     
    private static void loadPropsFromFile(String absolutePath, Properties props) throws Exception {
        String path = correctSeparator(absolutePath);
        File propFile = new File(path);
        InputStream stream = null;
        if (propFile.exists()) {
            try {
                stream = new BufferedInputStream(new FileInputStream(propFile));
                props.load(stream);
            }
            finally {
                if (null != stream) {
                    try {
                        stream.close();
                    }
                    catch (Exception e) {}
                }
            }
        }
    }

    private static void savePropsToFile(String absolutePath, Properties props, String comment) throws Exception {
        String path = correctSeparator(absolutePath);
        FileOutputStream fout = new FileOutputStream(path);
        BufferedOutputStream out = new BufferedOutputStream(fout);
        try {
            props.store(out, comment);
            out.flush();
        } finally {
            try {
                out.close();
            } catch (IOException ioe) {
            }
            try {
                fout.close();
            } catch (IOException ioe) {
            }
        }
    }
    
    /**
     * Tell the system to force reload of config_system and app_config_system props upon next getInstance().
     */
    public static synchronized void forceConfigSystemPropertiesReload() {
    	configurablePropRefreshNeeded = true;
    }
    
    /**  return the one instance of configurable application properties database.
     * @return the configurable Properties object
     * @see java.lang.System#getProperties()
     * @see java.util.Properties
     * @exception Exception thrown on error
     */
    public static synchronized Properties getInstance() throws Exception
    {
        try {
            if (privateInstance == null) {
                Properties tmp = new Properties();
                String path = makeAbsoluteCommonConfigPath(BASE_PRIVATE_PATH);
                loadPropsFromFile(path, tmp);
                privateInstance = tmp;
                path = makeAbsoluteConfigPath(BASE_PRIVATE_PATH);
                loadPropsFromFile(path, privateInstance);
                path = makeAbsoluteCommonConfigPath(APP_PRIVATE_PATH);
                loadPropsFromFile(path, privateInstance);
                path = makeAbsoluteConfigPath(APP_PRIVATE_PATH);
                loadPropsFromFile(path, privateInstance);
                trimPropertyValues(privateInstance);
            }
            boolean cleanupConfigProps = false;
            if ((baseConfigurableInstance == null) || (configurablePropRefreshNeeded)) {
            	if (configurablePropRefreshNeeded)
            		theLogger.info("Re-reading configurable properties...");
                Properties tmp = new Properties();
                String path = makeAbsoluteCommonConfigPath(BASE_CONFIG_FILE);
                loadPropsFromFile(path, tmp);
                baseConfigurableInstance = tmp;
                trimPropertyValues(baseConfigurableInstance);
                allConfigurableProps.putAll(tmp);
                trimPropertyValues(allConfigurableProps);
                cleanupConfigProps = true;
            }
            if ((appConfigurableInstance == null) || (configurablePropRefreshNeeded)) {
            	configurablePropRefreshNeeded = false;
                Properties tmp = new Properties();
                String path = makeAbsoluteCommonConfigPath(APP_CONFIG_FILE);
                loadPropsFromFile(path, tmp);
                appConfigurableInstance = tmp;
                trimPropertyValues(appConfigurableInstance);
                allConfigurableProps.putAll(tmp);
                trimPropertyValues(allConfigurableProps);
                cleanupConfigProps = true;
            }
            /* Do not allow private props to be eclipsed by config - they are 
             * private for a reason.
             * This is ensured by eliminating such overlapping properties from configurable entries.
             */
            if (cleanupConfigProps) {
                Iterator <String> privatePropNames = privateInstance.stringPropertyNames().iterator();  
                while (privatePropNames.hasNext()) {
                    String nextVal = privatePropNames.next();
                    allConfigurableProps.remove(nextVal);
                    baseConfigurableInstance.remove(nextVal);
                    appConfigurableInstance.remove(nextVal);
                }
            }
        }
        catch (Exception e) {
            theLogger.error("Error in SysPropertyFactory#getInstance", e);
            throw e;
        }
        return allConfigurableProps;
    }
    
    /**  save the active configurable properties to the database
     * @exception Exception thrown on error
     */
    public static synchronized void saveInstance() throws Exception
    {
        if (appConfigurableInstance != null) {
            String path = makeAbsoluteCommonConfigPath(APP_CONFIG_FILE);
            savePropsToFile(path, appConfigurableInstance, "Application System Control Properties");
        }
        if (baseConfigurableInstance != null) {
            String path = makeAbsoluteCommonConfigPath(BASE_CONFIG_FILE);
            savePropsToFile(path, baseConfigurableInstance, "Base System Control Properties");
        }
    }
    
    /** Sets configurable property value
     * @param propName property name
     * @param propValue property value
     */    
    public static synchronized void setProperty(String propName, String propValue) {
        //Private props must not be made configurable by mere addition of the entry in config prop file(s).
        if (null != privateInstance && privateInstance.containsKey(propName)) {
            return;
        }
    	if( propValue != null ) propValue = propValue.trim();
        if ((null != appConfigurableInstance) && appConfigurableInstance.containsKey(propName)) {
            appConfigurableInstance.setProperty(propName, propValue);
            allConfigurableProps.setProperty(propName, propValue);
        } else if ((null != baseConfigurableInstance) && baseConfigurableInstance.containsKey(propName)) {
            baseConfigurableInstance.setProperty(propName, propValue);
            allConfigurableProps.setProperty(propName, propValue);            
        }
    }
    
    /** Transparently gets configurable/ private property value
     * @param propName property name
     * @return property value
     */    
    public static synchronized String getProperty(String propName) {
        String propValue = null;
        if (null != privateInstance) {
            propValue = privateInstance.getProperty(propName);
        }
        if ((null == propValue) && (null != appConfigurableInstance)) {
            propValue = appConfigurableInstance.getProperty(propName);
        }
        if ((null == propValue) && (null != baseConfigurableInstance)) {
            propValue = baseConfigurableInstance.getProperty(propName);
        }
        return propValue;
    }
    
    /** Transparently gets configurable/ private property value
     * @param propName property name
     * @param defaultValue default value to be returned, if the property does not exist
     * @return property value
     */    
    public static String getProperty(String propName, String defaultValue) {
        String propValue = SysPropertyFactory.getProperty(propName);
        return (propValue != null) ? propValue : defaultValue;
    }
    
    /** Enumerate all property names
     * @return enumeration of all property names
     */    
    public static synchronized String[] propertyNames() {
        TreeSet <String> propSet = new TreeSet<String>();
        if (privateInstance != null) {
            Set <String> propNames = privateInstance.stringPropertyNames();
            propSet.addAll(propNames);
        }
        if (allConfigurableProps != null) {
            Set <String> propNames = allConfigurableProps.stringPropertyNames();
            propSet.addAll(propNames);
        }        
        return propSet.toArray(new String[0]);
    }
    /**
     *  correct the path separators to the one expected by the OS.
     *  the properties file stores the separator as '/', and this
     *  must be corrected for Win32 systems.
     *  @param srcpath the path to correct
     *  @return the corrected path
     */
    public static String correctSeparator(String srcpath)
    {
        return srcpath.replace('/',File.separatorChar);
    }
    
    /**
     *  make absolute path
     *  absolutize a path with the "user.dir" property and correct
     *  the separator character.
     *  @param srcpath the original path
     *  @return the absolutized path
     */
    public static String makeAbsolutePath(String srcpath) 
    {
        return correctSeparator( System.getProperty(USER_DIR_PROPNAME)+File.separator+srcpath );
    }
	
    public static String makeAbsoluteCommonPath(String srcpath)
    {
        return correctSeparator(COMMON_HOME_DIR +File.separator+srcpath);
    }

    public static String makeAbsoluteCommonConfigPath(String srcpath)
    {
        return makeAbsoluteCommonPath(CONFIG_DIR +File.separator+srcpath);
    }

    public static String makeAbsoluteCommonDataPath(String srcpath)
    {
        return makeAbsoluteCommonPath(getProperty(DATA_DIR_PROPNAME, DEFAULT_DATA_DIR) +File.separator+srcpath);
    }

    public static String makeAbsoluteCommonLibPath(String srcpath)
    {
        return makeAbsoluteCommonPath(getProperty(LIB_DIR_PROPNAME, DEFAULT_LIB_DIR) +File.separator+srcpath);
    }

    public static String makeAbsoluteCommonBinPath(String srcpath)
    {
        return makeAbsoluteCommonPath(getProperty(BIN_DIR_PROPNAME, DEFAULT_BIN_DIR) +File.separator+srcpath);
    }
	
    public static String makeAbsoluteConfigPath(String srcpath)
    {
        return makeAbsolutePath(CONFIG_DIR +File.separator+srcpath);
    }
	
    public static String makeAbsoluteDataPath(String srcpath)
    {
        return makeAbsolutePath(getProperty(DATA_DIR_PROPNAME, DEFAULT_DATA_DIR) +File.separator+srcpath);
    }

    public static String makeAbsoluteLibPath(String srcpath)
    {
        return makeAbsolutePath(getProperty(LIB_DIR_PROPNAME, DEFAULT_LIB_DIR) +File.separator+srcpath);
    }

    public static String makeAbsoluteBinPath(String srcpath)
    {
        return makeAbsolutePath(getProperty(BIN_DIR_PROPNAME, DEFAULT_BIN_DIR) +File.separator+srcpath);
    }
    
    /**
     *  check for simple equality, returning false if the property doesn't exist.
     *  @param propName the name of the property to check
     *  @param val the value to check against
     *  @return true if they match, false if they don't or property doesn't exist.
     */
    public static boolean checkEquals(String propName,String val)
    {
        String propVal = null;
        try {
            propVal = SysPropertyFactory.getProperty(propName);
        }
        catch (Exception e)
        {
        }
        if (propVal != null)
        {
            if (propVal.compareTo(val) == 0)
                return true;
        }
        return false;
    }
    
    
    /**
     *  a very fast way to check whether finalizers should report to the SysLog for debugging purposes.
     *  @return true if the finalizers should be reported
     *  uses the "util.reportFinalizers" property
     */
    private static boolean rptFinalizers = false;
    private static boolean rptIsInitialized = false;
    /** Returns global flag used to turn on/ off finalize method
     * call logging
     * @return true if value for property 'util.reportFinalizers' is 'yes'
     */    
    public static boolean reportFinalizers()
    {
        if (!rptIsInitialized)
        {
            rptFinalizers = checkEquals("util.reportFinalizers","yes");
            rptIsInitialized = true;
        }
        return rptFinalizers;
    }
    
    /**
     *  ask for a path to be built using a system property, prepending
     *  the current working directory and correcting the separator character
     *  @param srcpathProp the property identifier for the path
     *  @return the absolutized path
     */
    public static String getAbsolutePathProperty(String srcpathProp) 
    {
        return getAbsolutePathProperty(srcpathProp, null);
    }
    /**
     *  ask for a path to be built using a system property, prepending
     *  the current working directory and correcting the separator character
     *  @param srcpathProp the property identifier for the path
     *  @param defaultPathProp default value of srcpathProp
     *  @return the absolutized path
     */
    public static String getAbsolutePathProperty(String srcpathProp, String defaultPathProp) 
    {
        return makeAbsolutePath(SysPropertyFactory.getProperty(srcpathProp, defaultPathProp));
    }
    
 	/**
 	 * Removes the white spaces around the property values
 	 * @param properties
 	 */
    private static void trimPropertyValues(Properties properties){
    	if( properties == null ) return;
    	Iterator<?> itr = properties.keySet().iterator();
    	String key, val;
    	while( itr.hasNext() ){ 
    		key = (String)itr.next();
    		val = ((String)properties.get(key)).trim();
    		properties.setProperty(key, val);
    	}
    }    
    
    /**
     * This method returns the data/prop path of machine. Calling methods need to 
     * take care if this location does not exist.
     * @return
     */
    public static String getPropPath()
    {
       String homeDir;
    if(isViperPlatform())
    {
       homeDir= System.getProperty(USER_HOME_PROPNAME);
    }else
    {
       homeDir = System.getProperty(USER_DIR_PROPNAME);
    }
       return correctSeparator(homeDir+File.separator+DEFAULT_DATA_DIR+File.separator+DEFAULT_PROP_DIR);
    }

	/*
	 * The following methods and inner class provide a fluent API for reading property values.
	 */
    
    /**
     * Property value string that indicates Boolean <code>TRUE</code>.
     */
	public static final String YES_STRING = "yes";
	public static final String NO_STRING = "no";

	/**
	 * Inner class that supports use of the fluent API -- please refer to
	 * {@link PropParser#getProp(String propName)} and friends, below..  Although
	 * it must be public to work, it is not intended to be seen or used outside
	 * of the {@link SysPropertyFactory} class.
	 * @author David_G3
	 */
	public static class PropParser {
		private String propName;
		private String propValue;

		/**
		 * Constructor for inner class that supports use of the fluent API.
		 * Although it must be public to work, it is not intended to be seen
		 * or used outside of the {@link SysPropertyFactory} class.
		 * @param propName property name that has been retrieved
		 * @param propValue raw property value that has been retrieved
		 */
		public PropParser(String propName, String propValue) {
			if (propName == null)
				throw new IllegalArgumentException("propName cannot be null");
			if (propValue == null)
				throw new IllegalArgumentException("propValue cannot be null");
			this.propName = propName;
			this.propValue = propValue;
		}
		
		/**
		 * Parse the retrieved property value as a boolean.
		 * <p>Example: <code>boolean b = SysPropertyFactory.getProp("myprop", "no").asBoolean();</code>
		 * @return <code>true</code> if property value is "<code>yes</code>" (case-insensitive), <code>false</code> otherwise
		 */
		public boolean asBoolean() {
			return propValue.equalsIgnoreCase(YES_STRING);
		}
		
		/**
		 * Parse the retrieved property value as an integer.
		 * <p>Example: <code>int i = SysPropertyFactory.getProp("myprop", "0").asInt();</code>
		 * @return integer value of property if property value represents an integer, <code>0</code> otherwise
		 */
		public int asInt() {
			try {
				if (propValue.trim().length() == 0)
					return 0;
				return Integer.parseInt(propValue);
			}
			catch (NumberFormatException e) {
				theLogger.warn("Integer value expected for property {}={}", propName, propValue);
				return 0;
			}
		}
		
		/**
		 * Return the retrieved property value as a String.
		 * <p>Example: <code>String s = SysPropertyFactory.getProp("myprop", "foo").asString();</code>
		 * @return the raw value of the property
		 */
		public String asString() {
			return propValue;
		}
		
		/**
		 * Return the retrieved property value as a String (otherwise a printable reference to the PropParser object would be returned).
		 * <p>Example: <code>String s = SysPropertyFactory.getProp("myprop", "foo");</code>
		 * @return the raw value of the property
		 */		
                @Override
		public String toString() {
			return propValue;
		}
	}
	
	private PropParser newPropParser(String propName, String propValue) {
		return new PropParser(propName, propValue);
	}
	
	/**
	 * Retrieve a property with the specified name in a form that can be parsed by one of
	 * the {@link PropParser} methods.
	 * @param propName property to retrieve
	 * @return class that provides parsing methods
	 */
	public static PropParser getProp(String propName) {
		String propVal = SysPropertyFactory.getProperty(propName);
		if (propVal == null)
			propVal = "";
		return new SysPropertyFactory().newPropParser(propName, propVal);
	}
	
	/**
	 * Retrieve a property with the specified name and default value in a form
	 * that can be parsed by one of the {@link PropParser} methods.
	 * @param propName property to retrieve
	 * @param defValue default value to use for the property
	 * @return class that provides parsing methods
	 */	
	public static PropParser getProp(String propName, String defValue) {
		String propVal = SysPropertyFactory.getProperty(propName, defValue);
		if (propVal == null)
			propVal = "";
		return new SysPropertyFactory().newPropParser(propName, propVal);
	}
		
	/**
	 * Re-read the configurable property files and retrieve a property
	 * with the specified name in a form that can be parsed by one of
	 * the {@link PropParser} methods.
	 * @param propName property to retrieve
	 * @return class that provides parsing methods
	 */
	public static PropParser getFreshProp(String propName) {
		SysPropertyFactory.forceConfigSystemPropertiesReload();
		try {
			SysPropertyFactory.getInstance();
		} catch (Exception e) {
			// ignored
		}
		String propVal = SysPropertyFactory.getProperty(propName);
		if (propVal == null)
			propVal = "";
		return new SysPropertyFactory().newPropParser(propName, propVal);
	}
	
	/**
	 * Re-read the configurable property files and retrieve a property
	 * with the specified name and default value in a form
	 * that can be parsed by one of the {@link PropParser} methods.
	 * @param propName property to retrieve
	 * @param defValue default value to use for the property
	 * @return class that provides parsing methods
	 */	
	public static PropParser getFreshProp(String propName, String defValue) {
		SysPropertyFactory.forceConfigSystemPropertiesReload();
		try {
			SysPropertyFactory.getInstance();
		} catch (Exception e) {
			// ignored
		}
		String propVal = SysPropertyFactory.getProperty(propName, defValue);
		if (propVal == null)
			propVal = "";
		return new SysPropertyFactory().newPropParser(propName, propVal);
	}
    
    // test main
    /** Test method
     * @param args
     * @throws Exception
     */    
    public static void main(String[] args) throws Exception 
    {
        System.out.println("Begin test");
        Properties p = SysPropertyFactory.getInstance();
        p.list(System.out);
        
        String[] names = SysPropertyFactory.propertyNames();
        for (String name1 : names) {
            String name = (String) name1;
            System.out.println("Name = " +name +" value = " +SysPropertyFactory.getProperty(name));
        }
        SysPropertyFactory.setProperty("ruby.fuelsys.drive", "false");
        
        System.out.println("<===========After setProp==========>");
        names = SysPropertyFactory.propertyNames();
        for (String name1 : names) {
            String name = (String) name1;
            System.out.println("Name = " +name +" value = " +SysPropertyFactory.getProperty(name));
        }
        SysPropertyFactory.setProperty("moptr.installed", "true");        
        System.out.println("<===========After setProp==========>");
        names = SysPropertyFactory.propertyNames();
        for (String name1 : names) {
            String name = (String) name1;
            System.out.println("Name = " +name +" value = " +SysPropertyFactory.getProperty(name));
        }
        SysPropertyFactory.saveInstance();
        System.out.println("value = " +SysPropertyFactory.getProperty("ruby.fuelsys.drive"));     
    }

    /**
     * This method returns the data/security path of the system.
     * 
     * @return
     */
    public static String getAbsoluteSecurityPath() {
        return correctSeparator(System.getProperty(USER_DIR_PROPNAME) +File.separator+ getProperty(DATA_DIR_PROPNAME, DEFAULT_DATA_DIR)
        		+File.separator+ getProperty(SECURITY_DIR_PROPNAME, DEFAULT_SECURITY_DIR));
   }
    
    static synchronized void reload() throws Exception
    {
         try {
            Properties tmp = new Properties();
            String path = makeAbsoluteCommonConfigPath(BASE_PRIVATE_PATH);
            loadPropsFromFile(path, tmp);
            privateInstance = tmp;
            trimPropertyValues(privateInstance);
            path = makeAbsoluteConfigPath(BASE_PRIVATE_PATH);
            loadPropsFromFile(path, privateInstance);
            trimPropertyValues(privateInstance);
            path = makeAbsoluteCommonConfigPath(APP_PRIVATE_PATH);
            loadPropsFromFile(path, privateInstance);
            trimPropertyValues(privateInstance);
            path = makeAbsoluteConfigPath(APP_PRIVATE_PATH);
            loadPropsFromFile(path, privateInstance);
            trimPropertyValues(privateInstance);

            tmp = new Properties();
            path = makeAbsoluteCommonConfigPath(BASE_CONFIG_FILE);
            loadPropsFromFile(path, tmp);
            baseConfigurableInstance = tmp;
            trimPropertyValues(baseConfigurableInstance);
            allConfigurableProps.putAll(tmp);
            trimPropertyValues(allConfigurableProps);

            tmp = new Properties();
            path = makeAbsoluteCommonConfigPath(APP_CONFIG_FILE);
            loadPropsFromFile(path, tmp);
            appConfigurableInstance = tmp;
            trimPropertyValues(appConfigurableInstance);
            allConfigurableProps.putAll(tmp);
            trimPropertyValues(allConfigurableProps);
        }
        catch (Exception e) {
            throw new Exception("Errors reloading system properties", e);
        }

    }

    private static final String MOCK_PROPERTY_SETTER_CLASSNAME 
            = "com.verifone.isd.vsms2.sys.util.SysPropertySetter";

    /**
     * NOT FOR USE BY APPLICATION.
     * <p>
     * This method is &quot;package private&quot; in scope.
     * Its purpose is for unit testing, <u>only</u>.
     * <p>
     * Use the <code>SysPropertySetter</code> class
     * in the 'mock' directory of this component to manage private properties.
     * <p>
     *  
     * @return The collection of private system properties.
     */
    static synchronized Properties getPrivateProperties()
    {
        try
        {
            // Check for 'mock' sys property setter class before setting the propery.
            // Since mocks are not distributed with the application, if any application code tries to
            // set a private system property with this method, an exception is thrown, caught and logged.
            Class< ? extends ISysPropertySetter> sysPropSetter = Class.forName(MOCK_PROPERTY_SETTER_CLASSNAME).asSubclass(ISysPropertySetter.class);
            if (privateInstance == null)
            {
                privateInstance = new Properties();
            }
            return privateInstance;
        } catch (Exception ex)
        {
            theLogger.error("Unexpected attempt to try to get private system properties instance.", ex);
            return new Properties();
        }
    }
    
    /**
     * NOT FOR USE BY APPLICATION.
     * <p>
     * This method is &quot;package private&quot; in scope.
     * Its purpose is for unit testing, <u>only</u>.
     * <p>
     * Use the <code>SysPropertySetter</code> class in
     * the 'mock' directory of this component to manage base configurable properties.
     * <p>
     * 
     * @return the collection instance of configurable properties.
     */
    static synchronized Properties getConfigurableProperties()
    {
        try
        {
            // Check for 'mock' sys property setter class before setting the propery.
            // Since mocks are not distributed with the application, if any application code tries to
            // add a base configurable system property with this method, an exception is thrown, caught and logged.
            Class< ? extends ISysPropertySetter> sysPropSetter = Class.forName(MOCK_PROPERTY_SETTER_CLASSNAME).asSubclass(ISysPropertySetter.class);
            return allConfigurableProps;
        } catch (Exception ex)
        {
            theLogger.error("Unexpected attempt to try to get configurable system properties instance '{}'", ex);
            return new Properties();
        }
    }

    /**
     * NOT FOR USE BY APPLICATION.
     * <p>
     * This method is &quot;package private&quot; in scope.
     * Its purpose is for unit testing, <u>only</u>.
     * <p>
     * Use the <code>SysPropertySetter</code> class in
     * the 'mock' directory of this component to manage base configurable properties.
     * <p>
     * 
     * @param updateProps The collection of properties to use to update the configurable collection(s);
     */
    static synchronized void updateConfigurableProperties(Properties updateProps)
    {
        try
        {
            // Check for 'mock' sys property setter class before setting the propery.
            // Since mocks are not distributed with the application, if any application code tries to
            // add a base configurable system property with this method, an exception is thrown, caught and logged.
            Class< ? extends ISysPropertySetter> sysPropSetter = Class.forName(MOCK_PROPERTY_SETTER_CLASSNAME).asSubclass(ISysPropertySetter.class);
            if (baseConfigurableInstance == null)
            {
                baseConfigurableInstance = new Properties();
            }
            baseConfigurableInstance.putAll(updateProps);
            allConfigurableProps.putAll(updateProps);
        } catch (Exception ex)
        {
            theLogger.error("Unexpected attempt to try to set configurable system properties instance.", ex);
        }
    }

    /**
     * NOT FOR USE BY APPLICATION.
     * <p>
     * Defines an interface that a 'mock' implementation implements to that allows it 
     * to set or create system properties in SysPropertyFactory.
     * <p>
     * For example the method {@link #setPrivateProperty(java.lang.String, java.lang.String)}
     * is package private in scope, the implementation must also be in the same package
     * of SysPropertyFactory.
     * <p>
     * Please see the class in this component's 'mock' directory:<br>
     * com.verifone.isd.vsms2.sys.util.SysPropertySetter
     * <p>
     * Developers of unit test and mocks of dependent components should
     * only use SysPropertySetter class and its static methods to manage adding or removing system properties
     * for unit testing purposes only.
     * <p>
     * A major reason for using this mechanism to manage the set of properties is to preclude the
     * use of the config/*.prop files <i>before</i> having to run unit tests or for each of the test methods.
     * Through experience, there has been flakiness regarding O/S management of removing and recreating files
     * during unit tests.
     * 
     * @see SysPropertyFactory#setPrivateProperty(java.lang.String, java.lang.String) 
     * @see SysPropertyFactory#addAppConfigurableProperty(java.lang.String, java.lang.String)
     * @see SysPropertyFactory#addBaseConfigurableProperty(java.lang.String, java.lang.String) 
     */
    static interface ISysPropertySetter
    {
    }
   
}