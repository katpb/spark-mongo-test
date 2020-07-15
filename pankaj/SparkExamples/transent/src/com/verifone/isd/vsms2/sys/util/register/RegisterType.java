package com.verifone.isd.vsms2.sys.util.register;

import com.verifone.isd.os.SystemInfo;
import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;
import com.verifone.isd.xml.vocabulary.IXMLVocabulary;
import java.util.Locale;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Enum for defining register type constants.
 * 
 * @author T_Deepak_S2
 *
 */
public enum RegisterType {
	CONTROLLER(IXMLVocabulary.CONTROLLER, "Site Controller"),
	RUBYCI(IXMLVocabulary.RUBYCI, "Ruby Ci"),
	RUBY(IXMLVocabulary.RUBY, "ruby"),
	TOPAZ(IXMLVocabulary.TOPAZ, "topaz-410"), 	
	RUBY2(IXMLVocabulary.RUBY2, "emerald"),
    /** Register type for all Python products.
     *  For model specific type, like 18 inch display Python, see {@link ModelInfo}.
     **/
	PYTHON_C15(IXMLVocabulary.PYTHON_C15, "C15"),
    PYTHON_C18(IXMLVocabulary.PYTHON_C18, "C18");
	
    private static final String PYTHON_PRODUCT_NAME = "python";
    
    public static final String REGISTER_TYPE_DEFAULT_NAME = "sys.ent.registerType.default";
    
    /** Overriding property declaring default detected python platform type - one of 'C15' or 'C18'.
     * @see #DEFAULT_PYTHON_TYPE
     */
    public static final String PYTHON_TYPE_DEFAULT_NAME = "sys.ent.registerType.pythonDefault";

    /** The register type of the system.
     * <p>
     * If the platform libraries do not exists, the type will be set to
     * {@value #REGISTER_TYPE_DEFAULT_NAME}.
     * 
     * @see #REGISTER_TYPE_DEFAULT_NAME
     * @see RegisterType#getRegisterType()
     */
    public static RegisterType REGISTER_TYPE;

    /** Default register type if it cannot be determined by platform library calls.
     * <p>
     * If the platform libraries do not exists, this default can be set by using
     * or adding the application property name {@value #REGISTER_TYPE_DEFAULT_NAME}
     * and setting its value to one of this enum's names<br>
     * <ul>
     *  <li>{@link #CONTROLLER}</li>
     *  <li>{@link #PYTHON_C15}</li>
     *  <li>{@link #PYTHON_C18}</li>
     *  <li>{@link #RUBY}</li>
     *  <li>{@link #RUBY2}</li>
     *  <li>{@link #RUBYCI}</li>
     *  <li>{@link #TOPAZ}</li>
     * </ul>
     * 
     * @see RegisterType#getRegisterType()
     */
    public static final RegisterType DEFAULT_REGISTER_TYPE;

    /** Default Python register type if it cannot be determined by platform library calls.
     * <p>
     * If the platform libraries do not exists, this default can be set by using
     * or adding the application property name {@value #PYTHON_TYPE_DEFAULT_NAME}
     * and setting its value to one of the following enum names<br>
     * <ul>
     *  <li>{@link #PYTHON_C15}</li>
     *  <li>{@link #PYTHON_C18}</li>
     * </ul>
     * 
     * @see RegisterType#getRegisterType()
     */
    public static final RegisterType DEFAULT_PYTHON_TYPE;
    static
    {
        // Use the following register type as default if property not set!
        RegisterType regType = RegisterType.CONTROLLER;
        String platformTypeValue = SysPropertyFactory.getProperty(REGISTER_TYPE_DEFAULT_NAME, regType.name());
        try
        {
            regType = RegisterType.valueOf(platformTypeValue);
        } catch (IllegalArgumentException iaex)
        {
            regType = RegisterType.CONTROLLER;
        }
        DEFAULT_REGISTER_TYPE = regType;
        
        RegisterType pythonType = RegisterType.PYTHON_C18;
        platformTypeValue = SysPropertyFactory.getProperty(PYTHON_TYPE_DEFAULT_NAME, pythonType.name());
        try
        {
            pythonType = RegisterType.valueOf(platformTypeValue);
        } catch (IllegalArgumentException iaex)
        {
            pythonType = RegisterType.PYTHON_C18;
        }
        DEFAULT_PYTHON_TYPE = pythonType;
        
        try
        {
            SystemInfo sysInfo = new SystemInfo();
            Properties sysProps = sysInfo.getSysInfo();
            String productName = sysProps.getProperty("product.name", DEFAULT_REGISTER_TYPE.prodName);
            if (PYTHON_PRODUCT_NAME.equals(productName.toLowerCase(Locale.getDefault())))
            {
                regType = DEFAULT_PYTHON_TYPE;
                String displaySize = sysProps.getProperty("display.size", DEFAULT_REGISTER_TYPE.prodName);
                if (displaySize.contains("15"))
                {
                    regType = PYTHON_C15;
                } else if (displaySize.contains("18"))
                {
                    regType = PYTHON_C18;
                }
            } else
            {
                for (RegisterType aType : RegisterType.values())
                {
                    if (aType.getProdName().equals(productName))
                    {
                        regType = aType;
                    }
                }
            }
        } catch (Throwable t)
        {
            Logger logger = LoggerFactory.getLogger(RegisterType.class);
            logger.warn("Errors encountered getting platform type!", t);
            regType = DEFAULT_REGISTER_TYPE;
        }
        
        REGISTER_TYPE = regType;
    }

	/** The register type. */
	private String regType;
	
	/** The product name. */
	private String prodName;
	
	/**
	 * Constructor.
	 * 
	 * @param registerType
	 *            the register type
	 * @param productName
	 *            the product name
	 */
	RegisterType(String registerType, String productName) {
		this.regType = registerType;
		this.prodName = productName;
	}
	
	/**
	 * Gets the register type.
	 * 
	 * @return register type
	 */
	public String getRegType() {
		return this.regType;
	}
	
	/**
	 * Gets the product name.
	 * 
	 * @return product name
	 */
	public String getProdName() {
		return this.prodName;
	}
	
    /**
	 * Gets the register type of this platform application is running on.
	 * 
	 * @return the register type
     * 
     * @see #REGISTER_TYPE
	 */
	public static RegisterType getRegisterType() {
        
        /* cr2213.03-998
            Since a platform's product would NEVER change during runtime, return static value assigned to
            REGISTER_TYPE in 'static' section.
        */
        return REGISTER_TYPE;
	}
}