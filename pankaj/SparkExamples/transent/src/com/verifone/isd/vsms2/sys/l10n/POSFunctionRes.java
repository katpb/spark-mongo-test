package com.verifone.isd.vsms2.sys.l10n;

import java.util.ListResourceBundle;

public class POSFunctionRes extends ListResourceBundle {

	@Override
	public Object[][] getContents() {
		return contents;
	}

	public static final String CMD_VCASHIERPDLIST 			= "CMD_VCASHIERPDLIST";
	public static final String CMD_VCASHIERPDLIST_DTL 		= "CMD_VCASHIERPDLIST_DTL";
	public static final String CMD_VMOPCFG					= "CMD_VMOPCFG";
	public static final String CMD_VMOPCFG_DTL 				= "CMD_VMOPCFG_DTL";
	public static final String CMD_UCASHIERRECONDTLS		= "CMD_UCASHIERRECONDTLS";
	public static final String CMD_UCASHIERRECONDTLS_DTL	= "CMD_UCASHIERRECONDTLS_DTL";
	public static final String CMD_VCASHIERDRAWERAMOUNTS 		= "CMD_VCASHIERDRAWERAMOUNTS";
	public static final String CMD_VCASHIERCURRAMTS_DTL 	= "CMD_VCASHIERCURRAMTS_DTL";
		
	static private final Object[][] contents = {
		{ CMD_VCASHIERPDLIST,			"View csr pd list"},
		{ CMD_VCASHIERPDLIST_DTL,		"View Cashier period List"},
		{ CMD_VMOPCFG,          		"View MOP config"},
		{ CMD_VMOPCFG_DTL,      		"View MOP dataset config"},
		{ CMD_UCASHIERRECONDTLS,		"View csr recon details"},
		{ CMD_UCASHIERRECONDTLS_DTL,	"Update csr end drawer amts"},
		{ CMD_VCASHIERDRAWERAMOUNTS,			"View csr currency amts"},
		{ CMD_VCASHIERCURRAMTS_DTL,		"View Cashier Currency Amounts"}
		};
}
