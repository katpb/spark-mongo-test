/**
 * 
 */
package com.verifone.isd.vsms2.sys.ent.function;

import com.verifone.isd.vsms2.sys.l10n.FunctionRes;

/**
 * This class loads all functions that are required for coresvcs functionality
 * 
 * @author Raghavendra_R1
 *
 */
public class CoresvcsFunctionHelper extends AbstractFunctionHelper {

	/**
	 * 
	 */
	public CoresvcsFunctionHelper() {
		this.initialize();
	}

	public void initialize() {
    	
		FunctionAttribs	f = new FunctionAttribs(FunctionRes.CMD_VPLU,
				FunctionCmdConstants.CMD_VPLU, FunctionRes.CMD_VPLU,
				Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_UPLU,
				FunctionCmdConstants.CMD_UPLU, FunctionRes.CMD_UPLU_DTL,
				Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VPAYMENTCONFIG,
				FunctionCmdConstants.CMD_VPAYMENTCONFIG,
				FunctionRes.CMD_VPAYMENTCONFIG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UPAYMENTCONFIG,
				FunctionCmdConstants.CMD_UPAYMENTCONFIG,
				FunctionRes.CMD_UPAYMENTCONFIG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VRESTRICTNCONFIG,
				FunctionCmdConstants.CMD_VRESTRICTNCONFIG,
				FunctionRes.CMD_VRESTRICTNCONFIG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_URESTRICTNCONFIG,
				FunctionCmdConstants.CMD_URESTRICTNCONFIG,
				FunctionRes.CMD_URESTRICTNCONFIG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VPOSCONFIG,
				FunctionCmdConstants.CMD_VPOSCONFIG,
				FunctionRes.CMD_VPOSCONFIG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UPOSCONFIG,
				FunctionCmdConstants.CMD_UPOSCONFIG,
				FunctionRes.CMD_UPOSCONFIG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VSALESCFG,
				FunctionCmdConstants.CMD_VSALESCFG,
				FunctionRes.CMD_VSALESCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_USALESCFG,
				FunctionCmdConstants.CMD_USALESCFG,
				FunctionRes.CMD_USALESCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VPOPCFG,
				FunctionCmdConstants.CMD_VPOPCFG, FunctionRes.CMD_VPOPCFG_DTL,
				Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UPOPCFG,
				FunctionCmdConstants.CMD_UPOPCFG, FunctionRes.CMD_UPOPCFG_DTL,
				Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VFEECFG,
				FunctionCmdConstants.CMD_VFEECFG, FunctionRes.CMD_VFEECFG_DTL,
				Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UFEECFG,
				FunctionCmdConstants.CMD_UFEECFG, FunctionRes.CMD_UFEECFG_DTL,
				Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VTAXRATECFG,
				FunctionCmdConstants.CMD_VTAXRATECFG,
				FunctionRes.CMD_VTAXRATECFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UTAXRATECFG,
				FunctionCmdConstants.CMD_UTAXRATECFG,
				FunctionRes.CMD_UTAXRATECFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_NAXML_VMAINT,
				FunctionCmdConstants.CMD_NAXML_VMAINT,
				FunctionRes.CMD_NAXML_VMAINT_DTL, Function.APP_NAXML, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_NAXML_UMAINT,
				FunctionCmdConstants.CMD_NAXML_UMAINT,
				FunctionRes.CMD_NAXML_UMAINT_DTL, Function.APP_NAXML, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_FIND_RPTFILENAME,
				FunctionCmdConstants.CMD_FIND_RPTFILENAME,
				FunctionRes.CMD_FIND_RPTFILENAME_DTL, Function.APP_CGI, false);
		f.setLocalAccessOnly(true);
		this.addFunction(f);
				
		f = new FunctionAttribs(FunctionRes.CMD_VREPORTLIST,
				FunctionCmdConstants.CMD_VREPORTLIST,
				FunctionRes.CMD_VREPORTLIST_DTL, Function.APP_CGI, true);
		this.addFunction(f);
				
		f = new FunctionAttribs(FunctionRes.CMD_UREPORTLIST,
				FunctionCmdConstants.CMD_UREPORTLIST,
				FunctionRes.CMD_UREPORTLIST_DTL, Function.APP_CGI, true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VGROUPLIST,
				FunctionCmdConstants.CMD_VGROUPLIST,
				FunctionRes.CMD_VGROUPLIST_DTL, Function.APP_CGI, true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UGROUPLIST,
				FunctionCmdConstants.CMD_UGROUPLIST,
				FunctionRes.CMD_UGROUPLIST_DTL, Function.APP_CGI, true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VMAINTFPRHT,
				FunctionCmdConstants.CMD_VMAINTFPRHT,
				FunctionRes.CMD_VMAINTFPRHT_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UMAINTFPRHT,
				FunctionCmdConstants.CMD_UMAINTFPRHT,
				FunctionRes.CMD_UMAINTFPRHT_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VRUBYREPT,
				FunctionCmdConstants.CMD_VRUBYREPT,
				FunctionRes.CMD_VRUBYREPT_DTL, Function.APP_CGI, true);
		/**
		 * Setting of the sub functions for the vrubyrept 
		 * command will be done by the function loaders.
		 * Hence, we're not explicitly setting it here
		 */
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VPERIODLIST,
				FunctionCmdConstants.CMD_VPERIODLIST,
				FunctionRes.CMD_VPERIODLIST_DTL, Function.APP_CGI, true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VTLOGPDLIST,
				FunctionCmdConstants.CMD_VTLOGPDLIST,
				FunctionRes.CMD_VTLOGPDLIST_DTL, Function.APP_CGI, true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VREPORTPDLIST,
				FunctionCmdConstants.CMD_VREPORTPDLIST,
				FunctionRes.CMD_VREPORTPDLIST_DTL, Function.APP_CGI, true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VCWPAYPOINTPDLIST,
				FunctionCmdConstants.CMD_VCWPAYPOINTPDLIST,
				FunctionRes.CMD_VCWPAYPOINTPDLIST_DTL, Function.APP_CGI, true);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_CCWPDCLOSE,
				FunctionCmdConstants.CMD_CCWPDCLOSE,
				FunctionRes.CMD_CCWPDCLOSE_DTL, Function.APP_CGI, true);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VREPORTCFG,
				FunctionCmdConstants.CMD_VREPORTCFG,
				FunctionRes.CMD_VREPORTCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UREPORTCFG,
				FunctionCmdConstants.CMD_UREPORTCFG,
				FunctionRes.CMD_UREPORTCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VMOPCFG,
				FunctionCmdConstants.CMD_VMOPCFG, FunctionRes.CMD_VMOPCFG_DTL,
				Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UMOPCFG,
				FunctionCmdConstants.CMD_UMOPCFG, FunctionRes.CMD_UMOPCFG_DTL,
				Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VCURRENCYCFG,
				FunctionCmdConstants.CMD_VCURRENCYCFG,
				FunctionRes.CMD_VCURRENCYCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UCURRENCYCFG,
				FunctionCmdConstants.CMD_UCURRENCYCFG,
				FunctionRes.CMD_UCURRENCYCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VPLUPROMOCFG,
				FunctionCmdConstants.CMD_VPLUPROMOCFG,
				FunctionRes.CMD_VPLUPROMOCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UPLUPROMOCFG,
				FunctionCmdConstants.CMD_UPLUPROMOCFG,
				FunctionRes.CMD_UPLUPROMOCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VIFSFCFG,
				FunctionCmdConstants.CMD_VIFSFCFG,
				FunctionRes.CMD_VIFSFCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UIFSFCFG,
				FunctionCmdConstants.CMD_UIFSFCFG,
				FunctionRes.CMD_UIFSFCFG_DTL, Function.APP_CGI, false);
		f.setOTPRequired(true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VPOLICYCFG,
				FunctionCmdConstants.CMD_VPOLICYCFG,
				FunctionRes.CMD_VPOLICYCFG, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UPOLICYCFG,
				FunctionCmdConstants.CMD_UPOLICYCFG,
				FunctionRes.CMD_UPOLICYCFG, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VSITE_ASSET_DATA,
				FunctionCmdConstants.CMD_VSITE_ASSET_DATA,
				FunctionRes.CMD_VSITE_ASSET_DATA, Function.APP_CGI, false);
		this.addFunction(f);
        
	    //PosPayment Command
	    f = new FunctionAttribs(FunctionRes.CMD_VPOSPAYMENTCONFIG,
	            		FunctionCmdConstants.CMD_VPOSPAYMENT_CFG,
	            		FunctionRes.CMD_VPOSPAYMENTCONFIG_DTL, Function.APP_CGI, false);
        this.addFunction(f);
	    
	    f = new FunctionAttribs(FunctionRes.CMD_UPOSPAYMENTCONFIG,
	                    FunctionCmdConstants.CMD_UPOSPAYMENT_CFG,
	                    FunctionRes.CMD_UPOSPAYMENTCONFIG_DTL, Function.APP_CGI, false); 
        this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_CEXTPOSREQ,
				FunctionCmdConstants.CMD_CEXTPOSREQ,
				FunctionRes.CMD_CEXTPOSREQ_DTL, Function.APP_CGI, false);
		f.setProhibitUserConfig(true);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_CREFRESHCFG,
				FunctionCmdConstants.CMD_CREFRESHCFG,
				FunctionRes.CMD_CREFRESHCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_CCLOSEDAYNOW,	
				FunctionCmdConstants.CMD_CCLOSEDAYNOW,
				FunctionRes.CMD_CCLOSEDAYNOW_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_CCLOSEPDNOW,	
				FunctionCmdConstants.CMD_CCLOSEPDNOW,
				FunctionRes.CMD_CCLOSEPDNOW_DTL, Function.APP_CGI, false);
		this.addFunction(f);

        f = new FunctionAttribs(FunctionRes.CMD_GENERATE_CODES,
                FunctionCmdConstants.CMD_GENERATE_CODES, FunctionRes.CMD_GENERATE_CODES_DTL,
                Function.APP_CGI, false);
        this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_NAXML_VMOVEMENT,
				FunctionCmdConstants.CMD_NAXML_VMOVEMENT,
				FunctionRes.CMD_NAXML_VMOVEMENT_DTL, Function.APP_NAXML, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VTRANSNUMLIST,
				FunctionCmdConstants.CMD_VTRANSNUMLIST,
				FunctionRes.CMD_VTRANSNUMLIST_DTL, Function.APP_CGI,
				false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VTRANSDETAILS,
				FunctionCmdConstants.CMD_VTRANSDETAILS,
				FunctionRes.CMD_VTRANSDETAILS_DTL, Function.APP_CGI,
				false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VCLOUDAGENTPROP,
				FunctionCmdConstants.CMD_VCLOUDAGENTPROP,
				FunctionRes.CMD_VCLOUDAGENTPROP_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UCLOUDAGENTPROP,
				FunctionCmdConstants.CMD_UCLOUDAGENTPROP,
				FunctionRes.CMD_UCLOUDAGENTPROP_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_CPROBE_CCOMMANDER_CONSOLE_HOST,
				FunctionCmdConstants.CMD_CPROBECMDRCONSOLEHOST, FunctionRes.CMD_CPROBE_CCOMMANDER_CONSOLE_HOST_DTL,
				Function.APP_CGI, false);
		this.addFunction(f);	

		f = new FunctionAttribs(FunctionRes.CMD_VCDMAGENTPROP,
				FunctionCmdConstants.CMD_VCDMAGENTPROP,
				FunctionRes.CMD_VCDMAGENTPROP_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UCDMAGENTPROP,
				FunctionCmdConstants.CMD_UCDMAGENTPROP,
				FunctionRes.CMD_UCDMAGENTPROP_DTL, Function.APP_CGI, false);
		this.addFunction(f);


		f = new FunctionAttribs(FunctionRes.CMD_VVPNINFO,
				FunctionCmdConstants.CMD_VVPNINFO,
				FunctionRes.CMD_VVPNINFO, Function.APP_CGI, false);
        f.setProhibitUserConfig(true);
        this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VVPNSTATUS,
				FunctionCmdConstants.CMD_VVPNSTATUS,
				FunctionRes.CMD_VVPNSTATUS, Function.APP_CGI, false);
        f.setProhibitUserConfig(true);
        this.addFunction(f);

//		f = new FunctionAttribs(FunctionRes.CMD_VMNSPDIAG,
//				FunctionCmdConstants.CMD_VMNSPDIAG,
//				FunctionRes.CMD_VMNSPDIAG, Function.APP_CGI, false);
//        f.setProhibitUserConfig(true);
//        this.addFunction(f);
				
	}

}
