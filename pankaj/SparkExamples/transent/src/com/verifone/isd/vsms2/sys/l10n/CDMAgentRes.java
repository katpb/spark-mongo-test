package com.verifone.isd.vsms2.sys.l10n;

import java.util.ListResourceBundle;

/**
 * Resource Bundle for CDM Agent
 * @author T_Aswathik1
 *
 */

public class CDMAgentRes extends ListResourceBundle {
	
	
	@Override
	public Object[][] getContents()  {
		return contents;
	}

	
	public static final String INVALID_VALUE	= "INVALID_VALUE";
	
	static private final Object[][] contents = {
		
		{INVALID_VALUE,            "Invalid value for the element "}
		};

}
