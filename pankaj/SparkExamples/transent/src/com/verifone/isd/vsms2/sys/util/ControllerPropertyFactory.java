/*-
 * Copyright (C) 2005 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Topaz property file synch entity
 * Created July 14, 2005                                      David C. Brown
 *
 */

package com.verifone.isd.vsms2.sys.util;


import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import com.verifone.isd.vsms2.sys.util.contenthandlers.LocaleInfoXMLContentHandler;
import com.verifone.isd.vsms2.sys.util.protocol.VFIHttpURLConnection;
import com.verifone.isd.vsms2.sys.util.protocol.VFIURL;
import com.verifone.isd.vsms2.sys.util.register.RegisterType;
import com.verifone.isd.vsms2.sys.util.sax.SAXFilter;

/**
 * A repository of properties found on the Sapphire controller so that
 * the application can have a local cache.
 *
 * @author	David C. Brown
 * @version	1.0
 * @since	production
 * @see		com.verifone.isd.vsms2.sys.util.SysPropertyFactory
 */

public class ControllerPropertyFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerPropertyFactory.class);
	private static final String HOSTPROPINFO = ControllerConstants.BASE_URL_CGILINK + "cmd=vsapphireprop";

	private static final String HOSTLOCALEINFO =
			ControllerConstants.BASE_URL_CGILINK + "cmd=vlocaleinfo";
	
	private static final boolean controller;

	/**
	 * Enumeration with the expected locale properties and its default values.
	 * No locale property should be modified if is not in this list.
	 */
	private static final Map<String, String> localeProperties;
	static {
		Map<String, String> tmpMap = new HashMap<String, String>();
		tmpMap.put("sys.countryoption", "United States (English)");
		tmpMap.put("sys.money.primary.currency_code", "USD");
		tmpMap.put("locale.default", "en_US");
		tmpMap.put("fiscal.printer.type", "none");
		tmpMap.put("fiscal.printer.enabled", "no");
		tmpMap.put(SysPropertyConstant.FILL_UP_ENABLE, SysPropertyFactory.NO_STRING);
		tmpMap.put(SysPropertyConstant.FISCAL_RECEIPT_ENABLED, SysPropertyFactory.NO_STRING);
		tmpMap.put(SysPropertyConstant.FISCAL_PRNT_DISCOUNTS_SUM, SysPropertyFactory.NO_STRING);
		tmpMap.put(SysPropertyConstant.FISCAL_PRNT_SEP_PRE_TOTAL, SysPropertyFactory.NO_STRING);
		localeProperties = Collections.unmodifiableMap(tmpMap);
		
		RegisterType registerType = RegisterType.getRegisterType();
		if((registerType == RegisterType.CONTROLLER) || (registerType == RegisterType.RUBYCI)) {
			controller = true;
		} else {
			controller = false;
		}
	}

	private static Properties					ctrlrProps;

	private static ControllerPropertyFactory	theInstance;

    private static final String MOCK_PROPERTY_SETTER_CLASSNAME 
            = "com.verifone.isd.vsms2.sys.util.SysPropertySetter";

    /**
	 * Singleton pattern is enforced by keeping the constructor private.
	 *
	 * @see	getInstance()
	 */

	private ControllerPropertyFactory() {
	}

	/**
	 * Request the locale properties from the Site Controller and update them
	 * in the private properties file.
	 */
	public static void syncLocaleProps() {

        Properties newprops = null;
        VFIURL myurl = null;
        VFIHttpURLConnection urlc = null;
        DataOutputStream dos = null;
        InputStream is = null;

        /* Set up CGI POST & get an input stream for the result */

        try {
            myurl = new VFIURL(HOSTLOCALEINFO);
            LOGGER.info("Exercising cgi request '{}'",HOSTLOCALEINFO);
            urlc = myurl.openConnection();
            urlc.setDoOutput(true);
            dos = new DataOutputStream(urlc.getOutputStream());
            is = new BufferedInputStream(urlc.getInputStream());
            InputSource src = new InputSource(is);
            dos.flush();

            /* Point content handler at the input stream */
            XMLSaxer xsx = new XMLSaxer();
            xsx.setInputSource(src);

            SAXParserFactory spf = SecureSAXParserFactory.newSPFInstance();
            SAXParser parser = spf.newSAXParser();
            XMLReader sp = parser.getXMLReader();

            LocaleInfoXMLContentHandler ph = new LocaleInfoXMLContentHandler();
            xsx.setSAXFilter(new SAXFilter(sp, ph));
            xsx.perform();
            newprops = ph.getProperties();
        /* Build a content handler from the SAX parser */
        } catch (MalformedURLException mul) {
        	LOGGER.error("Bad URL given " + myurl);
        } catch (Exception foo) {
        	LOGGER.error("Exception ", foo);
        } finally {
        	
        	if(urlc != null) {
        		try {
					LOGGER.info("'{}' is the response code after URL request {}",urlc.getResponseCode(),HOSTLOCALEINFO);
        		} catch (SocketException nRTHE) {
        			LOGGER.error("Probably there is no controller connected. Can't exercise "+ HOSTLOCALEINFO);
				} catch (IOException e) {
					LOGGER.error("Couldn't close the connection ", e);
				}
        	}
			
            if (null != dos) {
                try {
                    dos.close();
                } catch (IOException ioe) {
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException ioe) {
                }
            }
           	writeLocaleProperties(newprops);

        }
    }
	

	/**
	 * Write only the locale properties in the private property file.
	 * 
	 * @param newLocProp locale properties to be updated
	 */
	private static void writeLocaleProperties(Properties newLocProp){
		Properties privProp = new Properties();
		String path = SysPropertyFactory.makeAbsoluteCommonConfigPath(
				SysPropertyFactory.BASE_PRIVATE_PATH);
		File privPropFile = new File(path);
		if (privPropFile.exists()) {
			InputStream fis = null;
			FileOutputStream fileOut = null;
			try {
				fis = new BufferedInputStream(new FileInputStream(privPropFile));
				privProp.load(fis);
				if ((null != newLocProp) && (!newLocProp.isEmpty())){
					/**
					 * New locale properties are written to the file. The props name
					 * come from the map localeProperties to avoid modification to
					 * other properties. If newLocProp does not have the values the
					 * current value will be persisted.
					 */
					for (String propName:localeProperties.keySet()) {
						privProp.setProperty(propName, newLocProp.getProperty(propName,
								privProp.getProperty(propName)));
					}
				} else {
					/**
					 * If the new locale properties are null default values are written
					 * unless the file already has the properties.
					 */
					for (String propName:localeProperties.keySet()) {
						privProp.setProperty(propName, privProp.getProperty(propName,
								localeProperties.get(propName)));
					}
					
				}
				fileOut = new FileOutputStream(privPropFile);
				privProp.store(fileOut, "");
			} catch (IOException ex) {
				LOGGER.error("Errors updating locale properties.", ex);
			} finally {
				if (null != fis) {
					try {
						fis.close();
					} catch (Exception e) {}
				}
				if (null != fileOut) {
					try {
						fileOut.close();
					} catch (Exception e) {}
				}
			}
		}
	}

	/**
	 * Get the URL (actually a CGI POST) and then associate our content
	 * handler with it.  Once it returns we have populated a property list,
	 * or we have a null instance because we can't reach the host.
	 *
	 */

	public static void synchPropertyWithController() {

            Properties newprops = null;
            VFIURL myurl = null;
            VFIHttpURLConnection urlc = null;
            DataOutputStream dos = null;
            InputStream is = null;

            /* Set up CGI POST & get an input stream for the result */

            try {
                myurl = new VFIURL(HOSTPROPINFO);
                LOGGER.info("Exercising cgi request '{}'",HOSTPROPINFO);
                urlc = myurl.openConnection();
                urlc.setDoOutput(true);
                dos = new DataOutputStream(urlc.getOutputStream());
                is = new BufferedInputStream(urlc.getInputStream());
                InputSource src = new InputSource(is);
                dos.flush();

                /* Point content handler at the input stream */
                XMLSaxer xsx = new XMLSaxer();
                xsx.setInputSource(src);

                SAXParserFactory spf = SecureSAXParserFactory.newSPFInstance();
                SAXParser parser = spf.newSAXParser();
                XMLReader sp = parser.getXMLReader();

                PropHandler ph = new PropHandler();
                xsx.setSAXFilter(new SAXFilter(sp, ph));
                xsx.perform();
                newprops = ph.getProperties();
            /* Build a content handler from the SAX parser */
            } catch (MalformedURLException mul) {
            	LOGGER.error("Bad URL given " + myurl);
            } catch (Exception foo) {
            	LOGGER.error("Exception ", foo);
            } finally {
            	
            	if(urlc != null) {
            		try {
						LOGGER.info("'{}' is the response code after URL request {}",urlc.getResponseCode(),HOSTPROPINFO);
            		} catch (SocketException nRTHE) {
            			LOGGER.error("Probably there is no controller connected. Can't exercise "+ HOSTPROPINFO);
					} catch (IOException e) {
						LOGGER.error("Couldn't close the connection ", e);
					}
            	}
				
                if (newprops != null) {
                    ctrlrProps = newprops;
                }
                if (null != dos) {
                    try {
                        dos.close();
                    } catch (IOException ioe) {
                    }
                }
                if (null != is) {
                    try {
                        is.close();
                    } catch (IOException ioe) {
                    }
                }
            }
        }

	/**
	 * The variation here is that we don't populate any default properties
	 * if we can't communicate with the host.  We also DO NOT PERSIST the
	 * properties.  If all is well there is already an instance of the
	 * properties and we'll use it.  If none exist yet call for a new one.
	 *
	 * @return System properties reported from Sapphire.
	 * @exception	Exception Thrown on any errors getting properties from Sapphire.
	 */

	public static synchronized Properties getInstance() throws Exception {
		if (null == theInstance) {
			theInstance = new ControllerPropertyFactory();
			if(controller) {
				ctrlrProps = SysPropertyFactory.getInstance();
			}else {
				synchPropertyWithController();
			}
		}

		return ctrlrProps;
	}

	/**
	 * Just get the locale base properties and write them, this is
	 * only done at startup when the Topaz is registering with Commander
	 *
	 * @exception	Exception Thrown on any errors getting locale properties from Sapphire.
	 */

	public static synchronized void getLocaleInstance() throws Exception {
		if (null == theInstance) {
			getInstance();
		}
		if(!controller) {
			syncLocaleProps();
		}

		return;
	}

	/**
	 * This method does nothing, but is provided for interface compatibility
	 * with SysPropertyFactory.
	 *
	 * @exception	Exception Thrown on any errors saving properties to a file.
	 */

	public static synchronized void saveInstance() throws Exception {
	}

	/**
	 * Set the given value with the given property.  NOTE that this has
	 * no effect at the Controller and the value is not persisted.  This
	 * method is provided to be interface compatible with SysPropertyFactory.
	 *
	 * @param	n Property name.
	 * @param	val New property value.
	 */

	public static synchronized void setProperty(String n, String val) {
		if (null == ctrlrProps) {
			return;
		}
		ctrlrProps.setProperty(n, val);
	}

	/**
	 * Look up the given property and return it's associated value.   If
	 * no Properties instance exists, or the property wasn't found, return
	 * null.
	 *
	 * @param	propname Property name.
	 * @return	Value of property.
	 */

	public static String getProperty(String propname) {
		if (null == ctrlrProps) {
			return null;
		}
		return ctrlrProps.getProperty(propname);
	}

	/**
	 * Return the property associated with the property name, or the
	 * default value if no such property was found, or if no Properties
	 * instance exists.
	 *
	 * @param	propname Property name.
	 * @param	defvalue Value to return if property undefined.
	 * @return	Value of property.
	 */

	public static String getProperty(String propname, String defvalue) {
		if (null == ctrlrProps) {
			return defvalue;
		}
		return ctrlrProps.getProperty(propname, defvalue);
	}

	/**
	 * Return the enumeration of all properties in the associated Properties
	 * instance.
	 *
	 * @return	Enumeration of property names.
	 */

	public static Enumeration propertyNames() {
		if (null == ctrlrProps) {
			return null;
		}
		return ctrlrProps.propertyNames();
	}
    
    /**
     * Package private method used <u><b>ONLY</b> for unit testing purposes</u>.
     * <p>
     * This method is called by the <i>depricated</i> 'mock' class at<br>
     * <pre><code>
     *      com.verifone.isd.vsms2.sys.util.SysPropertySetter
     * </code></pre>
     * via its method:
     * <pre><code>
     *      public static void initializeControllerPropertyFactory()
     * </code></pre>
     * <p>
     * This method is intentionally package private.  Only the aforementioned class
     * 
     * @deprecated Used only for unit testing purposes. Use SysPropertySetter.initializeControllerPropertyFactory() instead.
     */
    public static void initForUnitTesting()
    {
        try
        {
            // Check for 'mock' sys property setter class before setting the propery.
            // Since mocks are not distributed with the application, if any application code tries to
            // set a private system property with this method, an exception is thrown, caught and logged.
            Class< ? extends SysPropertyFactory.ISysPropertySetter> sysPropSetter = Class.forName(MOCK_PROPERTY_SETTER_CLASSNAME).asSubclass(SysPropertyFactory.ISysPropertySetter.class);
            ctrlrProps = new Properties(SysPropertyFactory.getConfigurableProperties());
        } catch (Exception ex)
        {
            LOGGER.error("Unexpected attempt to try to update controller system properties instance.", ex);
        }
    }

	public static Set<String> getLocaleProperties() {
		return localeProperties.keySet();
	}

	/**
	 * Simple testing interface
	 *
	 * @param	choix
	 */

	public static void main(String[] choix) {
		try {
			getInstance();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
