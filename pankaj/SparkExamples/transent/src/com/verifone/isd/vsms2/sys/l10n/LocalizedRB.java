/*-
 * Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Valero demonstration version
 * Created April 3, 2003                                      David C. Brown
 *
 */

package com.verifone.isd.vsms2.sys.l10n;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.slf4j.LoggerFactory;


/**
 * The LocalizedRB class is a factory class for retrieving ResourceBundles. This
 * class can be used to get bundles in the default locale or a specific locale
 * as required by the application. A set of getter methods are provided to
 * obtain the standard resources already defined in the application. The
 * ResourceBundles corresponding to resources that could be added in future,
 * could be retrieved using the getResourceBundle method.
 * 
 * @author David C. Brown IV
 * @version 0.1
 */

public class LocalizedRB {

	public static final String TOPAZ_RESOURCE    = "com.verifone.isd.vsms2.sys.l10n.TopazRes";
	public static final String OVERLY_RESOURCE   = "com.verifone.isd.vsms2.sys.l10n.OverlayRes";
	public static final String FUELVIEW_RESOURCE = "com.verifone.isd.vsms2.sys.l10n.FuelViewRes";
	public static final String SALESCFG_RESOURCE = "com.verifone.isd.vsms2.sys.l10n.SalesConfigRes";
	public static final String FUNCTION_RESOURCE = "com.verifone.isd.vsms2.sys.l10n.FunctionRes";
	public static final String POS_FUNCTION_RESOURCE = "com.verifone.isd.vsms2.sys.l10n.POSFunctionRes";
	public static final String CGI_RESOURCE = "com.verifone.isd.vsms2.sys.l10n.CGIConstantsRes";
	public static final String PRICECHANGE_RESOURCE = "com.verifone.isd.vsms2.sys.l10n.PriceChangeRes";
	public static final String UPGRADE_RESOURCE = "com.verifone.isd.vsms2.sys.l10n.UpgradeRes";
	public static final String RSD_RESOURCE = "com.verifone.isd.vsms2.sys.l10n.RSDRes";
	public static final String MODULE_RESOURCE = "com.verifone.isd.vsms2.sys.l10n.ModuleRes";
	public static final String SIGNEDPACKAGEUPDATE_RESOURCE = "com.verifone.isd.vsms2.sys.l10n.SignedPackageUpdateRes";
	public static final String REGISTRATION_RESOURCE = "com.verifone.isd.vsms2.sys.l10n.RegistrationRes";
	//Added as a part of USerAAA Service Implementation
	public static final String USERAAA_RESOURCE = "com.verifone.isd.vsms2.sys.l10n.UserAAARes";
	public static final String FORECOURT_RESOURCE = "com.verifone.isd.vsms2.sys.l10n.ForeCourtRes";	
	public static final String NACSCODES_RESOURCE = "com.verifone.isd.vsms2.sys.l10n.NACSCodeRes";
	public static String NETWORK_RESOURCE = "com.verifone.isd.vsms2.sys.l10n.NetworkRes";
	public static final String EMPLOYEEAAA_RESOURCE = "com.verifone.isd.vsms2.sys.l10n.EmployeeAAARes";
	
	/** securityCtrls Constants **/
	public static final String SECURITYCTRLS_RESOURCE = "com.verifone.isd.vsms2.sys.l10n.SecurityCtrlsRes";
	
	public static final String MOBILE_RESOURCE = "com.verifone.isd.vsms2.sys.l10n.MobileRes";
	
	public static final String MWS_RESOURCE = "com.verifone.isd.vsms2.sys.l10n.MWSRes";
	public static final String MANAGED_UPDATE_RESOURCE = "com.verifone.isd.vsms2.sys.l10n.ManagedUpdateRes";
	public static final String COMMANDER_CONSOLE_RESOURCE="com.verifone.isd.vsms2.sys.l10n.CommanderConsoleRes";
	public static final String CDM_AGENT_RESOURCE="com.verifone.isd.vsms2.sys.l10n.CDMAgentRes";
	public static final String CHALLENGE_QUESTIONS_RES="com.verifone.isd.vsms2.sys.l10n.ChallengeQuestionsRes";

	/** ORder Confirmation Board localized resource bundle */
	public static final String OCB_RESOURCE = "com.verifone.isd.vsms2.sys.l10n.OCBResourceBundle";

	/** MNSP VPN localized resource bundle */
	public static final String MNSP_VPN_RESOURCE = "com.verifone.isd.vsms2.sys.l10n.MnspVpnRes";

	/** Printer Formats localized resource bundle */
	public static final String PRINTER_FORMAT_RESOURCE = "com.verifone.isd.vsms2.sys.l10n.PrinterFormatRes";

	private static LocalizedRB resInstance;
	private static Locale[] supportedLocales;
	private final HashMap<String, ResourceBundle> bundleMap;

	/**
	 * Constructor
	 */
	private LocalizedRB() {
		this.bundleMap = new HashMap<String, ResourceBundle>();
	}

	public static synchronized LocalizedRB getInstance() {
		if(null == resInstance) {
			resInstance = new LocalizedRB();
		}
		return resInstance;
	}

	/**
	 * Returns user requested resource bundle in the default Locale. If the
	 * requested bundle does not exists then it creates one and returns.
	 * 
	 * @param bundleName name of the resource bundle
	 * @return ResourceBundle
	 */
	public static ResourceBundle getResourceBundle(String bundleName) {
		return getResourceBundle(bundleName, null);
	}

	/**
	 * Returns user requested resource bundle in the requested Locale. If the
	 * requested bundle does not exists then it creates one and returns.
	 * 
	 * @param bundleName name of the resource bundle
	 * @param locale the locale type
	 * @return ResourceBundle
	 */
	public static ResourceBundle getResourceBundle(String bundleName, Locale locale) {
		//Call getInstance to make sure the singleton is created
		LocalizedRB.getInstance();
		ResourceBundle bundle = resInstance.getBundle(bundleName, locale);
		return bundle;
	}

	/**
	 * Returns a resource from the user requested resource bundle in the default Locale. If the
	 * requested bundle does not exists then it creates one and returns.
	 * 
	 * @param bundleName name of the resource bundle
	 * @param resLocator Resource locator
	 * @return ResourceBundle
	 */
	public static String getResource(String bundleName, String resLocator) {
		ResourceBundle res = getResourceBundle(bundleName, null);
		return res.getString(resLocator);
	}

	/**
	 * Returns a resource from the user requested resource bundle in the requested Locale. If the
	 * requested bundle does not exists then it creates one and returns.
	 * 
	 * @param bundleName name of the resource bundle
	 * @param resLocator Resource locator
     * @param locale the locale type
     * @return ResourceBundle
     */
    public static String getResource(String bundleName, String resLocator, Locale locale) {
        ResourceBundle res = getResourceBundle(bundleName, locale);
        return res.getString(resLocator);
    }
    
    /**
     * Returns a resource from Topaz resource bundle in the default Locale. 
     * 
     * @param resLocator key for the resource 
     * @return Resource string 
     */
    public static String getTopazRes(String resLocator) {
        Locale locale = Locale.getDefault();
        ResourceBundle res = getResourceBundle(TOPAZ_RESOURCE, locale);
        return res.getString(resLocator);
    }

    /**
     * Returns a resource from Topaz resource bundle in the requested Locale. 
     * 
     * @param resLocator key for the resource 
     * @param locale the locale for which a resource bundle is desired.
     * @return Resource string
     */
    public static String getTopazRes(String resLocator, Locale locale) {
        ResourceBundle res = getResourceBundle(TOPAZ_RESOURCE, locale);
        return res.getString(resLocator);
    }

    /**
     * Returns a resource from Function resource bundle in the default Locale. 
     * 
     * @param resLocator key for the resource 
     * @return Resource string 
     */
    public static String getFunctionRes(String resLocator) {
        Locale locale = Locale.getDefault();
        ResourceBundle res = getResourceBundle(FUNCTION_RESOURCE, locale);
        return res.getString(resLocator);
    }

    /**
     * Returns a resource from Function resource bundle in the requested Locale. 
     * 
     * @param resLocator key for the resource 
     * @param locale the locale for which a resource bundle is desired.
     * @return Resource string
     */
    public static String getFunctionRes(String resLocator, Locale locale) {
        ResourceBundle res = getResourceBundle(FUNCTION_RESOURCE, locale);
        return res.getString(resLocator);
    }
    
    /**
     * Returns a resource from CGI resource bundle in the default Locale. 
     * 
     * @param resLocator key for the resource 
     * @return Resource string 
     */
    public static String getCgiRes(String resLocator) {
        Locale locale = Locale.getDefault();
        ResourceBundle res = getResourceBundle(CGI_RESOURCE, locale);
        return res.getString(resLocator);
    }
    
    /**
     * Returns a resource from CGI resource bundle in the requested Locale. 
     * 
     * @param resLocator key for the resource 
     * @param locale the locale for which a resource bundle is desired.
     * @return Resource string
     */
    public static String getCgiRes(String resLocator, Locale locale) {
        ResourceBundle res = getResourceBundle(CGI_RESOURCE, locale);
        return res.getString(resLocator);
    }
    
    /**
     * Returns a resource from Overlay resource bundle in the default Locale. 
     * 
     * @param resLocator key for the resource 
     * @return Resource string 
     */
    public static String getOverlayRes(String resLocator) {
        Locale locale = Locale.getDefault();
        ResourceBundle res = getResourceBundle(OVERLY_RESOURCE, locale);
        return res.getString(resLocator);
    }
    
    /**
     * Returns a resource from Overlay resource bundle in the requested Locale. 
     * 
     * @param resLocator key for the resource 
     * @param locale the locale for which a resource bundle is desired.
     * @return Resource string
     */
    public static String getOverlayRes(String resLocator, Locale locale) {
        ResourceBundle res = getResourceBundle(OVERLY_RESOURCE, locale);
        return res.getString(resLocator);
    }
    
    /**
     * Returns a resource from FuelView resource bundle in the default Locale. 
     * 
     * @param resLocator key for the resource 
     * @return Resource string 
     */
    public static String getFuelViewRes(String resLocator) {
        Locale locale = Locale.getDefault();
        ResourceBundle res = getResourceBundle(FUELVIEW_RESOURCE, locale);
        return res.getString(resLocator);
    }
    
    /**
     * Returns a resource from FuelView resource bundle in the requested Locale. 
     * 
     * @param resLocator key for the resource 
     * @param locale the locale for which a resource bundle is desired.
     * @return Resource string
     */
    public static String getFuelViewRes(String resLocator, Locale locale) {
        ResourceBundle res = getResourceBundle(FUELVIEW_RESOURCE, locale);
        return res.getString(resLocator);
    }
    
    /**
     * Returns a resource from SalesCfg resource bundle in the default Locale. 
     * 
     * @param resLocator key for the resource 
     * @return Resource string 
     */
    public static String getSalesCfgRes(String resLocator) {
        Locale locale = Locale.getDefault();
        ResourceBundle res = getResourceBundle(SALESCFG_RESOURCE, locale);
        return res.getString(resLocator);
    }
    
    
    /**
     * Returns a resource from SalesCfg resource bundle in the requested Locale. 
     * 
     * @param resLocator key for the resource 
     * @param locale the locale for which a resource bundle is desired.
     * @return Resource string
     */
    public static String getSalesCfgRes(String resLocator, Locale locale) {
        ResourceBundle res = getResourceBundle(SALESCFG_RESOURCE, locale);
        return res.getString(resLocator);
    }
    
    /**
     * Returns a resource from securityCtrls resource bundle in the requested Locale. 
     * 
     * @param resLocator key for the resource 
     * @param locale the locale for which a resource bundle is desired.
     * @return Resource string
     */
    public static String getSecurityCtrlsRes(String resLocator, Locale locale) {
        ResourceBundle res = getResourceBundle(SECURITYCTRLS_RESOURCE, locale);
        return res.getString(resLocator);
    }
    
    /**
     * Returns a resource from Network resource bundle in the default Locale. 
     * 
     * @param resLocator key for the resource 
     * @return Resource string 
     */
    public static String getNetworkRes(String resLocator) {
        Locale locale = Locale.getDefault();
        ResourceBundle res = getResourceBundle(NETWORK_RESOURCE, locale);
        return res.getString(resLocator);
    }
    
    /**
     * Returns a resource from PriceChange resource bundle in the default Locale. 
     * 
     * @param resLocator key for the resource 
     * @return Resource string 
     */
    public static String getPriceChangeRes(String resLocator) {
        Locale locale = Locale.getDefault();
        ResourceBundle res = getResourceBundle(PRICECHANGE_RESOURCE, locale);
        return res.getString(resLocator);
    }
    
    /**
     * Returns a resource from PriceChange resource bundle in the requested Locale. 
     * 
     * @param resLocator key for the resource 
     * @param locale the locale for which a resource bundle is desired.
     * @return Resource string
     */
    public static String getPriceChangeRes(String resLocator, Locale locale) {
        ResourceBundle res = getResourceBundle(PRICECHANGE_RESOURCE, locale);
        return res.getString(resLocator);
    }
    
    /**
     * Returns a resource from ForeCourt resource bundle in the default Locale. 
     * 
     * @param resLocator key for the resource 
     * @return Resource string 
     */
    public static String getForeCourtRes(String resLocator) {
        Locale locale = Locale.getDefault();
        ResourceBundle res = getResourceBundle(FORECOURT_RESOURCE, locale);
        return res.getString(resLocator);
    }
    
    /**
     * Returns a resource from ForeCourt resource bundle in the requested Locale. 
     * 
     * @param resLocator key for the resource 
     * @return Resource string 
     */
    public static String getForeCourtRes(String resLocator, Locale locale) {
        ResourceBundle res = getResourceBundle(FORECOURT_RESOURCE, locale);
        return res.getString(resLocator);
    }
    
    /**
     * Returns a resource from NACSCodes resource bundle in the default Locale. 
     * 
     * @param resLocator key for the resource 
     * @return Resource string 
     */
    public static String getNACSCodeRes(String resLocator) {
        Locale locale = Locale.getDefault();
        ResourceBundle res = getResourceBundle(NACSCODES_RESOURCE, locale);
        return res.getString(resLocator);
    }
    
    /**
     * Returns a resource from NACSCodes resource bundle in the requested Locale. 
     * 
     * @param resLocator key for the resource 
     * @return Resource string 
     */
    public static String getNACSCodeRes(String resLocator, Locale locale) {
        ResourceBundle res = getResourceBundle(NACSCODES_RESOURCE, locale);
        return res.getString(resLocator);
    }
    
    //Added for as a part of UserAAA service implementation.
    
    /**
     * Returns a resource from UserAAA resource bundle in the default Locale. 
     * @author T_PankajM2
     * 
     * @param resLocator key for the resource 
     */
    public static String getUSerAAARes(String resLocator) {
    	Locale locale = Locale.getDefault();
        ResourceBundle res = getResourceBundle(USERAAA_RESOURCE, locale);
        return res.getString(resLocator);
    }
    
    /**
     * Returns a resource from UserAAA resource bundle in the requested Locale. 
     * 
     * @param resLocator key for the resource 
     * @return Resource string 
     */
    public static String getUSerAAARes(String resLocator, Locale locale) {
        ResourceBundle res = getResourceBundle(USERAAA_RESOURCE, locale);
        return res.getString(resLocator);
    }
 
    /**
     * Returns a resource from Module resource bundle in the default Locale.
     *
     * @param resLocator key for the resource
     * @return Resource string
     */
    public static String getModuleRes(String resLocator) {
        Locale locale = Locale.getDefault();
        ResourceBundle res = getResourceBundle(MODULE_RESOURCE, locale);
        return res.getString(resLocator);
    }
    
    /**
     * Returns a resource from Mobile resource bundle in the default Locale. 
     * 
     * @param resLocator key for the resource 
     * @return Resource string 
     */
    public static String getMobileRes(String resLocator) {
        Locale locale = Locale.getDefault();
        ResourceBundle res = getResourceBundle(MOBILE_RESOURCE, locale);
        return res.getString(resLocator);
    }
    
    /**
     * Returns a resource from Mobile resource bundle in the requested Locale. 
     * 
     * @param resLocator key for the resource 
     * @return Resource string 
     */
    public static String getMobileRes(String resLocator, Locale locale) {
        ResourceBundle res = getResourceBundle(MOBILE_RESOURCE, locale);
        return res.getString(resLocator);
    }
    
    
    /**
     * Returns a resource from MWS resource bundle in the default Locale. 
     * 
     * @param resLocator key for the resource 
     * @return Resource string 
     */
    public static String getMWSRes(String resLocator) {
        Locale locale = Locale.getDefault();
        ResourceBundle res = getResourceBundle(MWS_RESOURCE, locale);
        return res.getString(resLocator);
    }
    
    /**
     * Returns a resource from MWS resource bundle in the requested Locale. 
     * 
     * @param resLocator key for the resource 
     * @return Resource string 
     */
    public static String getMWSRes(String resLocator, Locale locale) {
        ResourceBundle res = getResourceBundle(MWS_RESOURCE, locale);
        return res.getString(resLocator);
    }
    
    /**
     * Returns a resource from Managed Update resource bundle in the default Locale. 
     * 
     * @param resLocator key for the resource 
     * @return Resource string 
     */
    public static String getManagedUpdateRes(String resLocator) {
        Locale locale = Locale.getDefault();
        ResourceBundle res = getResourceBundle(MANAGED_UPDATE_RESOURCE, locale);
        return res.getString(resLocator);
    }
    
    /**
     * Returns a resource from Managed Update resource bundle in the requested Locale. 
     * @param resLocator
     * @param locale
     * @return Resource string
     */
    public static String getManagedUpdateRes(String resLocator, Locale locale) {
        ResourceBundle res = getResourceBundle(MANAGED_UPDATE_RESOURCE, locale);
        return res.getString(resLocator);
    }
    
    /**
     * Returns a resource from Commander Console resource bundle in the default Locale. 
     * 
     * @param resLocator key for the resource 
     * @return Resource string 
     */
    public static String getCommanderConsoleRes(String resLocator) {
        Locale locale = Locale.getDefault();
        ResourceBundle res = getResourceBundle(COMMANDER_CONSOLE_RESOURCE, locale);
        return res.getString(resLocator);
    }
    
    /**
     * Returns a resource from Commander Console resource bundle in the requested Locale. 
     *
     * @param resLocator the res locator
     * @param locale the locale
     * @return Resource string
     */
    public static String getCommanderConsoleRes(String resLocator, Locale locale) {
        ResourceBundle res = getResourceBundle(COMMANDER_CONSOLE_RESOURCE, locale);
        return res.getString(resLocator);
    }

	public static String getChallengeQuestionsRes(String resLocator) {
		Locale locale = Locale.getDefault();
		ResourceBundle res = getResourceBundle(CHALLENGE_QUESTIONS_RES, locale);
		return res.getString(resLocator);
	}

	public static String getChallengeQuestionsRes(String resLocator, Locale locale) {
		ResourceBundle res = getResourceBundle(CHALLENGE_QUESTIONS_RES, locale);
		return res.getString(resLocator);
	}

    /**
     * Gets the CDM agent res.
     *
     * @param resLocator the res locator
     * @return the CDM agent res
     */
    public static String getCDMAgentRes(String resLocator) {
        Locale locale = Locale.getDefault();
        ResourceBundle res = getResourceBundle(CDM_AGENT_RESOURCE, locale);
        return res.getString(resLocator);
    }
    
    
    /**
     * Gets the CDM agent res.
     *
     * @param resLocator the res locator
     * @param locale the locale
     * @return the CDM agent res
     */
    public static String getCDMAgentRes(String resLocator, Locale locale) {
        ResourceBundle res = getResourceBundle(CDM_AGENT_RESOURCE, locale);
        return res.getString(resLocator);
    }
    
    
    
    /**
     * Returns a resource from SignedPackageUpdate resource bundle in the default Locale.
     *
     * @param resLocator key for the resource
     * @return Resource string
     */
    public static String getSignedPackageUpdateRes(String resLocator) {
        Locale locale = Locale.getDefault();
        ResourceBundle res = getResourceBundle(SIGNEDPACKAGEUPDATE_RESOURCE, locale);
        return res.getString(resLocator);
    }

    /**
     * Returns a resource from OCBResourceBundle resource bundle in the default Locale.
     *
     * @param resLocator key for the resource
     * @return Resource string
     */
    public static String getOCBResourceBundle(String resLocator) {
        return getOCBResourceBundle(resLocator, Locale.getDefault());
    }

    /**
     * Returns a resource from OCBResourceBundle resource bundle in the default Locale.
     *
     * @param resLocator key for the resource
     * @param locale The locale to use for resource look up.
     * @return Resource string
     */
    public static String getOCBResourceBundle(String resLocator, Locale locale) {
        ResourceBundle res = getResourceBundle(OCB_RESOURCE, locale);
        return res.getString(resLocator);
    }

    /**
     * Returns a resource from MnspVpnRes resource bundle in the default Locale.
     *
     * @param resLocator key for the resource
     * @return Resource string
     */
    public static String getVpnResourceBundle(String resLocator) {
        ResourceBundle res = getResourceBundle(MNSP_VPN_RESOURCE, Locale.getDefault());
        return res.getString(resLocator);
    }

    /**
     * Returns a resource from MnspVpnRes resource bundle in the given Locale.
     *
     * @param resLocator key for the resource
     * @param locale The locale to use for resource look up.
     * @return Resource string
     */
    public static String getVpnResourceBundle(String resLocator, Locale locale) {
        ResourceBundle res = getResourceBundle(MNSP_VPN_RESOURCE, locale);
        return res.getString(resLocator);
    }

    /**
     * Returns a resource from PrinterFormatRes resource bundle in the default Locale.
     *
     * @param resLocator key for the resource
     * @return Resource string
     */
    public static String getPrinterFormatRes(String resLocator) {
        ResourceBundle res = getResourceBundle(PRINTER_FORMAT_RESOURCE, Locale.getDefault());
        return res.getString(resLocator);
    }

    /**
     * Returns a resource from PrinterFormatRes resource bundle in the given Locale.
     *
     * @param resLocator key for the resource
     * @param locale The locale to use for resource look up.
     * @return Resource string
     */
    public static String getPrinterFormatRes(String resLocator, Locale locale) {
        ResourceBundle res = getResourceBundle(PRINTER_FORMAT_RESOURCE, locale);
        return res.getString(resLocator);
    }

    /**
     * Returns a resource from Registration resource bundle in the default Locale.
     *
     * @param resLocator key for the resource
     * @return Resource string
     */
    public static String getRegistrationRes(String resLocator) {
        Locale locale = Locale.getDefault();
        ResourceBundle res = getResourceBundle(REGISTRATION_RESOURCE, locale);
        return res.getString(resLocator);
    }

    public static Locale[] getSupportedLocales(String resourceName) {
        LoggerFactory.getLogger(LocalizedRB.class).debug( "LocalizedRB:getSupportedLocales begin");
        if (null == supportedLocales) {
            try {
                LocaleFactory factory = LocaleFactory.getInstance();
                supportedLocales = factory.getSupportedLocales();
            } catch (Exception e) {
                LoggerFactory.getLogger(LocalizedRB.class).error(
                        "error while getting supported locales. "
                                + e.getMessage());
            }

            LoggerFactory.getLogger(LocalizedRB.class).debug(
                    "LocalizedRB:getSupportedLocales end");
        }
        return supportedLocales;
    }

    private ResourceBundle getBundle(String bundleName, Locale locale) {
        ResourceBundle bundle = null;
        String key = null;

        if(locale == null) {
			key = bundleName;
		} else {
			key = this.formatKey(bundleName, locale.getLanguage(), locale.getCountry());
		}

        bundle = this.bundleMap.get(key);

        if(bundle == null) {
            if(locale == null) {
				bundle = ResourceBundle.getBundle(bundleName, new UTF8Control());
			} else {
				bundle = ResourceBundle.getBundle(bundleName, locale, new UTF8Control());
			}
            
            this.bundleMap.put(key, bundle);
        }
        return bundle;
    }

    private String formatKey(String name, String language, String country) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(name);
        buffer.append("_");
        buffer.append(language);
        buffer.append("_");
        buffer.append(country);
        
        return buffer.toString();
    }
}
class UTF8Control extends ResourceBundle.Control {
	private static final String DEFAULT_CHARSET = "UTF-8";
	private static final String PROPERTIES = "properties";

	@Override
	public ResourceBundle newBundle
		(String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
		throws IllegalAccessException, InstantiationException, IOException
	{
		if (format.equals("java.properties")) {
			// The below is a copy of the default implementation.
			String bundleName = toBundleName(baseName, locale);
			String resourceName = toResourceName(bundleName, PROPERTIES);
			ResourceBundle bundle = null;
			InputStream stream = null;
			if (reload) {
				URL url = loader.getResource(resourceName);
				if (url != null) {
					URLConnection connection = url.openConnection();
					if (connection != null) {
						connection.setUseCaches(false);
						stream = connection.getInputStream();
					}
				}
			} else {
				stream = loader.getResourceAsStream(resourceName);
			}
			if (stream != null) {
				try {
					// Only this line is changed to make it to read properties files as UTF-8.
					bundle = new PropertyResourceBundle(new InputStreamReader(stream, DEFAULT_CHARSET));
				} finally {
					stream.close();
				}
			}
			return bundle;
		} else {
			return super.newBundle(baseName, locale, format, loader, reload);
		}
	}
}
