package com.verifone.isd.vsms2.sys.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**  Class to manage custom properties database
 *  All the methods in this class are static.
 *  For transparent read access to properties, clients should
 *  use CustomPropertyFactory#getProperty method.
 * @version 1.0
 * @author David Ezell "mailto:david_ezell@verifone.com"
 */
public class CustomPropertyFactory
{
    private static final String customPropPath = "config/custom.prop";    
    private static Properties customInstance = null;
    
    static {
        try {
            getInstance();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private CustomPropertyFactory()    // can't create an instance, static only
    {
    }
    
    /**  return the one instance of configurable custom properties database.
     * @return the configurable Properties object
     * @see java.lang.System#getProperties()
     * @see java.util.Properties
     * @exception Exception thrown on error
     */
    public static synchronized Properties getInstance() throws Exception
    {
        InputStream stream = null;
        if (customInstance == null) {
            String path = SysPropertyFactory.makeAbsolutePath(customPropPath);
            File customPropFile = new File(path);
            if (customPropFile.exists()) {
                try {
                    Properties tmp = new Properties();
                    stream = new BufferedInputStream(new FileInputStream(customPropFile));
                    tmp.load(stream);
                    customInstance = tmp;
                }
                catch (Exception e)
                {
                    // because SysLog uses SysPropertyFactory, we can't rely on SysLog if
                    // there's an error here!
                    System.err.println("Can't open property file "+path);
                    throw e;
                }
                finally {
                    if (null != stream) {
                        try {
                            stream.close();
                        }
                        catch (Exception e) {}
                        stream = null;
                    }
                }
            }
        }
        return customInstance;
    }

    /**  save the active configurable properties to the database
     * @exception Exception thrown on error
     */
    public static synchronized void saveInstance() throws Exception
    {
        if (customInstance != null)
        {
            FileOutputStream fout = new FileOutputStream(SysPropertyFactory.makeAbsolutePath(customPropPath));
            BufferedOutputStream out = new BufferedOutputStream(fout);
            try {
            	customInstance.store(out, "Custom System Properties");
                out.flush();
            } finally {
                try {
                    out.close();
                }
                catch (IOException ioe) {}
                try {
                    fout.close();
                }
                catch (IOException ioe) {}                    
            }
        }
    }
    
    /** Sets custom property value
     * @param propName property name
     * @param propValue property value
     */    
    public static synchronized void setProperty(String propName, String propValue) {
    	if( propValue != null ) propValue = propValue.trim();
        if ((null != customInstance) && customInstance.containsKey(propName)) {
        	customInstance.setProperty(propName, propValue);
        }
    }
    
    /** Gets custom property value
     * @param propName property name
     * @return property value
     */    
    public static String getProperty(String propName) {
        String propValue = null;
        if (null != customInstance) {
            propValue = customInstance.getProperty(propName).trim();
        }
        return propValue;
    }
    
    /** Gets custom property value
     * @param propName property name
     * @param defaultValue default value to be returned, if the property does not exist
     * @return property value
     */    
    public static String getProperty(String propName, String defaultValue) {
        String propValue = CustomPropertyFactory.getProperty(propName);
        return (propValue != null) ? propValue : defaultValue;
    }
}