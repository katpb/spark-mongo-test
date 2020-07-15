/* Copyright (C) 2013 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 10 June, 2013                                      David C. Brown
 */

package com.verifone.isd.vsms2.sys.util.register;

import com.verifone.isd.os.SystemInfo;
import com.verifone.isd.xml.vocabulary.IXMLVocabulary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class to access hardware info using JNI calls
 */

public enum ModelInfo {

	CONTROLLER(RegisterType.CONTROLLER),
	RUBYCI(RegisterType.RUBYCI),
	RUBY(RegisterType.RUBY),
	TOPAZ(RegisterType.TOPAZ), 	
	RUBY2(RegisterType.RUBY2),
	PYTHON_C15(IXMLVocabulary.PYTHON_C15, RegisterType.PYTHON_C15),
	PYTHON_C18(IXMLVocabulary.PYTHON_C18, RegisterType.PYTHON_C15);

    private static final ModelInfo modelInfo;

    static {
        
        modelInfo = getModelInfoFromRegisterType(RegisterType.getRegisterType());
	}
    
    private final String modelName;
    private final RegisterType registerType;
    
    private ModelInfo(RegisterType registerType)
    {
        this(registerType.getProdName(), registerType);
    }
    
    private ModelInfo(String modelName, RegisterType registerType)
    {
        this.modelName = modelName;
        this.registerType = registerType;
    }
    
    /**
     * Get model information for this platform.
     * 
     * @return model information as determined by SystemInfo datum.
     */
    public static ModelInfo getModelInfo()
    {
        return modelInfo;
    }

    /**
     * Get displayable model name for this system.
     * 
     * @return Human friendly string.
     */
    public String getModelName()
    {
        return modelName;
    }
    
	/**
	 *	@return	The particular RegisterType defined for the product this
	 *		platform is supporting (e.g. "ruby2" if no keyboard is present,
	 *		"topaz", "controller", etc.)
	 */

	public static RegisterType getRegType() {
		return modelInfo.registerType;
	}

	/**
	 *	@return	A string that describes the product this platform is supporting
	 *		(e.g. "ruby2" if no keyboard is present, "topaz", "controller",
	 * 		etc.)
	 */

	public static String getRegTypeStr() {
		return modelInfo.modelName;
	}
    
    public static ModelInfo getModelInfoFromRegisterType(RegisterType registerType)
    {
        ModelInfo retVal = ModelInfo.CONTROLLER;
        
        for (ModelInfo anInfo : ModelInfo.values())
        {
            if (registerType == anInfo.registerType)
            {
                retVal = anInfo;
                break;
            }
        }

        return retVal;
    }
}
