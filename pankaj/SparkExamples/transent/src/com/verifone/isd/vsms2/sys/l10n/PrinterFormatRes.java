/*
 * LocalizedRBTest.java
 * Created by: joswillp1
 *
 * COPYRIGHT (c) 2020 by VeriFone Inc., All Rights Reserved.
 *
 *                       N O T I C E
 *
 * Under Federal copyright law, neither the software nor accompanying
 * documentation may be copied, photocopied, reproduced, translated,
 * or reduced to any electronic medium or machine-readable form, in
 * whole or in part, without the prior written consent of VeriFone Inc.,
 * except in the manner described in the documentation.
 */
package com.verifone.isd.vsms2.sys.l10n;

import java.util.ListResourceBundle;

/**
 *
 * @author JoswillP1
 */
public class PrinterFormatRes extends ListResourceBundle {
	public static final String	TKT_TAX_SUMMARY_RATE_FMT="TKT_TAX_SUMMARY_RATE_FMT";
	public static final String	TKT_TAX_SUMMARY_TBL_FMT="TKT_TAX_SUMMARY_TBL_FMT";
	public static final String	TKT_INCLUDES_TAX_INFO_FMT="TKT_INCLUDES_TAX_INFO_FMT";
	
	static private final Object[][] contents = {
		{ TKT_TAX_SUMMARY_RATE_FMT, "%1$1.1s %2$5.5s%%"},
		{ TKT_TAX_SUMMARY_TBL_FMT, "%1$-9.9s %2$9.9s %3$9.9s %4$10.10s"},
		{ TKT_INCLUDES_TAX_INFO_FMT, "%1$1.1s %2$s %3$6.6s%% %4$-9.9s"}
	};

	/**
	 * Accessor for the actual strings that have been internationalized.
	 */
	@Override
	public Object[][] getContents() {
		return contents;
	}
}
