/**
 * 
 */
package com.verifone.isd.vsms2.sys.ent.function;

import com.verifone.isd.vsms2.sys.l10n.FunctionRes;

/**
 * This class loads all functions that are required for our POS functionality
 * 
 * @author Raghavendra_R1
 *
 */
public class POSFunctionHelper extends AbstractFunctionHelper {

	/**
	 * 
	 */
	public POSFunctionHelper() {
		this.initialize();
	}

	public void initialize() {
		
		FunctionAttribs f = new FunctionAttribs(FunctionRes.CMD_VREGISTERCONFIG,
				FunctionCmdConstants.CMD_VREGISTERCONFIG,
				FunctionRes.CMD_VREGISTERCONFIG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UREGISTERCONFIG,
				FunctionCmdConstants.CMD_UREGISTERCONFIG,
				FunctionRes.CMD_UREGISTERCONFIG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VPOSSECURITY,
				FunctionCmdConstants.CMD_VPOSSECURITY,
				FunctionRes.CMD_VPOSSECURITY_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UPOSSECURITY,
				FunctionCmdConstants.CMD_UPOSSECURITY,
				FunctionRes.CMD_UPOSSECURITY_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VBANNERCFG,
				FunctionCmdConstants.CMD_VBANNERCFG,
				FunctionRes.CMD_VBANNERCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UBANNERCFG,
				FunctionCmdConstants.CMD_UBANNERCFG,
				FunctionRes.CMD_UBANNERCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VLOGOCFG,
				FunctionCmdConstants.CMD_VLOGOCFG,
				FunctionRes.CMD_VLOGOCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_ULOGOCFG,
				FunctionCmdConstants.CMD_ULOGOCFG,
				FunctionRes.CMD_ULOGOCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VSLOGANCFG,
				FunctionCmdConstants.CMD_VSLOGANCFG,
				FunctionRes.CMD_VSLOGANCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_USLOGANCFG,
				FunctionCmdConstants.CMD_USLOGANCFG,
				FunctionRes.CMD_USLOGANCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VSOFTKEYCFG,
				FunctionCmdConstants.CMD_VSOFTKEYCFG,
				FunctionRes.CMD_VSOFTKEYCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_USOFTKEYCFG,
				FunctionCmdConstants.CMD_USOFTKEYCFG,
				FunctionRes.CMD_USOFTKEYCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VMENUCFG,
				FunctionCmdConstants.CMD_VMENUCFG,
				FunctionRes.CMD_VMENUCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UMENUCFG,
				FunctionCmdConstants.CMD_UMENUCFG,
				FunctionRes.CMD_UMENUCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VINHOUSEACCTCFG,
				FunctionCmdConstants.CMD_VINHOUSEACCTCFG,
				FunctionRes.CMD_VINHOUSEACCTCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UINHOUSEACCTCFG,
				FunctionCmdConstants.CMD_UINHOUSEACCTCFG,
				FunctionRes.CMD_UINHOUSEACCTCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VTHEMECFG,
				FunctionCmdConstants.CMD_VTHEMECFG,
				FunctionRes.CMD_VTHEMECFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_USCREENCFG,
				FunctionCmdConstants.CMD_USCREENCFG,
				FunctionRes.CMD_USCREENCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VMWSLOG,
				FunctionCmdConstants.CMD_VMWSLOG,
				FunctionRes.CMD_VMWSLOG_DTL, Function.APP_CGI, true);
		/**
		 * This cgi command is processed straight by Apache CGI program and
		 * therefore, does not look at the prop file.Setting a command specific
		 * timeout value for this cgi command will not be honoured.
		 **/
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VPAYROLLPDLIST,
				FunctionCmdConstants.CMD_VPAYROLLPDLIST,
				FunctionRes.CMD_VPAYROLLPDLIST_DTL, Function.APP_CGI, true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VPAYROLLPDLIST2,
				FunctionCmdConstants.CMD_VPAYROLLPDLIST2,
				FunctionRes.CMD_VPAYROLLPDLIST2_DTL, Function.APP_CGI, true);
		this.addFunction(f);
		f = new FunctionAttribs(FunctionRes.CMD_VPAYROLLREPT,
				FunctionCmdConstants.CMD_VPAYROLLREPT,
				FunctionRes.CMD_VPAYROLLREPT_DTL, Function.APP_CGI, true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VPAYROLLREPT2,
				FunctionCmdConstants.CMD_VPAYROLLREPT2,
				FunctionRes.CMD_VPAYROLLREPT2_DTL, Function.APP_CGI, true);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_CAMBERALERT,
				FunctionCmdConstants.CMD_AMBER_NOTIFY,
				FunctionRes.CMD_CAMBERALERT_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VCSHR_TRACKING_CONFIG,
				FunctionCmdConstants.CMD_VCSHR_TRACKING_CONFIG,
				FunctionRes.CMD_VCSHR_TRACKING_CONFIG_DTL, Function.APP_CGI,
				false);
		f.setAccessWithoutLoginFromVFIDevice(true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UCSHR_TRACKING_CONFIG,
				FunctionCmdConstants.CMD_UCSHR_TRACKING_CONFIG,
				FunctionRes.CMD_UCSHR_TRACKING_CONFIG_DTL, Function.APP_CGI,
				false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VATTENDANTREPT,
				FunctionCmdConstants.CMD_VATTENDANTREPT,
				FunctionRes.CMD_VATTENDANTREPT_DTL, Function.APP_CGI, true);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VCASHIERREPT,
				FunctionCmdConstants.CMD_VCASHIERREPT,
				FunctionRes.CMD_VCASHIERREPT_DTL, Function.APP_CGI, true);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VCASHIERPDLIST,
				FunctionCmdConstants.CMD_VCASHIERPDLIST,
				FunctionRes.CMD_VCASHIERPDLIST_DTL, Function.APP_CGI, true);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VATTENDANTPDLIST,
				FunctionCmdConstants.CMD_VATTENDANTPDLIST,
				FunctionRes.CMD_VATTENDANTPDLIST_DTL, Function.APP_CGI, true);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VCSHR_TRACKING_REPORT,
				FunctionCmdConstants.CMD_VCSHR_TRACKING_REPORT,
				FunctionRes.CMD_VCSHR_TRACKING_REPORT_DTL, Function.APP_CGI,
				false);
		this.addFunction(f);
		
	    f = new FunctionAttribs(FunctionRes.CMD_VPROPRIETARYNETWORKMENU,
        		FunctionCmdConstants.CMD_VPROPRIETARYNETWORKMENU, 
        		FunctionRes.CMD_VPROPRIETARYNETWORKMENU_DTL, Function.APP_CGI, false);
	    this.addFunction(f);
	    
	    f = new FunctionAttribs(FunctionRes.CMD_VNETWORKMENU,
        		FunctionCmdConstants.CMD_VNETWORKMENU, 
        		FunctionRes.CMD_VNETWORKMENU_DTL, Function.APP_CGI, false);
	    this.addFunction(f);
        
	    f = new FunctionAttribs(FunctionRes.CMD_VSALESNETWORKMENU,
    		FunctionCmdConstants.CMD_VSALESNETWORKMENU, 
    		FunctionRes.CMD_VSALESNETWORKMENU_DTL, Function.APP_CGI, false);
	    this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_ALLCSR_RPTS,
				FunctionCmdConstants.CMD_ALLCSR_RPTS,
				FunctionRes.CMD_ALLCSR_RPTS_DTL, Function.APP_RUNTIME, true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_OPEN_CSR_RPTS,
				FunctionCmdConstants.CMD_OPEN_CSR_RPTS,
				FunctionRes.CMD_OPEN_CSR_RPTS_DTL, Function.APP_RUNTIME, true);
		this.addFunction(f);
        
        //Manager WorkStation Commands
        f = new FunctionAttribs(FunctionRes.CMD_UCASHIERENDDRAWERAMOUNTS,
                FunctionCmdConstants.CMD_UCASHIERENDDRAWERAMOUNTS,
                FunctionRes.CMD_UCASHIERENDDRAWERAMOUNTS, Function.APP_CGI, false);
	    this.addFunction(f);

        f = new FunctionAttribs(FunctionRes.CMD_VMWSCASHIERDRAWERAMOUNTS,
                FunctionCmdConstants.CMD_VMWSCASHIERDRAWERAMOUNTS,
                FunctionRes.CMD_VMWSCASHIERDRAWERAMOUNTS, Function.APP_CGI, false);
	    this.addFunction(f);

        f = new FunctionAttribs(FunctionRes.CMD_VREPORTSTATUS,
                FunctionCmdConstants.CMD_VREPORTSTATUS,
                FunctionRes.CMD_VREPORTSTATUS, Function.APP_CGI, false);
	    this.addFunction(f);

        f = new FunctionAttribs(FunctionRes.CMD_UREPORTSTATUS,
                FunctionCmdConstants.CMD_UREPORTSTATUS,
                FunctionRes.CMD_UREPORTSTATUS, Function.APP_CGI, false);
	    this.addFunction(f);

        f = new FunctionAttribs(FunctionRes.CMD_UCASHIERREPORTREVIEWSTATUS,
                FunctionCmdConstants.CMD_UCASHIERREPORTREVIEWSTATUS,
                FunctionRes.CMD_UCASHIERREPORTREVIEWSTATUS, Function.APP_CGI, false);
	    this.addFunction(f);

        f = new FunctionAttribs(FunctionRes.CMD_VTILLEVENTREPORTS,
                FunctionCmdConstants.CMD_VTILLEVENTREPORTS,
                FunctionRes.CMD_VTILLEVENTREPORTS, Function.APP_CGI, false);
	    this.addFunction(f);

        f = new FunctionAttribs(FunctionRes.CMD_UMANAGERADJUSTMENT,
                FunctionCmdConstants.CMD_UMANAGERADJUSTMENT,
                FunctionRes.CMD_UMANAGERADJUSTMENT, Function.APP_CGI, false);
	    this.addFunction(f);

        f = new FunctionAttribs(FunctionRes.CMD_UMANAGERCORRECTION,
                FunctionCmdConstants.CMD_UMANAGERCORRECTION,
                FunctionRes.CMD_UMANAGERCORRECTION, Function.APP_CGI, false);
	    this.addFunction(f);


        f = new FunctionAttribs(FunctionRes.CMD_VMWSCASHMOVEMENTREPORT,
                FunctionCmdConstants.CMD_VMWSCASHMOVEMENTREPORT,
                FunctionRes.CMD_VMWSCASHMOVEMENTREPORT, Function.APP_CGI, false);
	    this.addFunction(f);


        f = new FunctionAttribs(FunctionRes.CMD_UMWSCASHMOVEMENTREPORT,
                FunctionCmdConstants.CMD_UMWSCASHMOVEMENTREPORT,
                FunctionRes.CMD_UMWSCASHMOVEMENTREPORT, Function.APP_CGI, false);
	    this.addFunction(f);
        
        
        f = new FunctionAttribs(FunctionRes.CMD_VMWSLOGPDLIST,
                FunctionCmdConstants.CMD_VMWSLOGPDLIST,
                FunctionRes.CMD_VMWSLOGPDLIST_DTL, Function.APP_CGI, false);
	    this.addFunction(f);
	    
		f = new FunctionAttribs(FunctionRes.CMD_VSCREENCFGV2,
				FunctionCmdConstants.CMD_VSCREENCFGV2,
				FunctionRes.CMD_VSCREENCFGV2_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_USCREENCFGV2,
				FunctionCmdConstants.CMD_USCREENCFGV2,
				FunctionRes.CMD_USCREENCFGV2_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VPANELCFG,
				FunctionCmdConstants.CMD_VPANELCFG,
				FunctionRes.CMD_VPANELCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UPANELCFG,
				FunctionCmdConstants.CMD_UPANELCFG,
				FunctionRes.CMD_UPANELCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VPOSSCREENCFG,
				FunctionCmdConstants.CMD_VPOSSCREENCFG,
				FunctionRes.CMD_VPOSSCREENCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_UPOSSCREENCFG,
				FunctionCmdConstants.CMD_UPOSSCREENCFG,
				FunctionRes.CMD_UPOSSCREENCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UEMPPREFSCONFIG,
				FunctionCmdConstants.CMD_UEMPPREFCONFIG,
				FunctionRes.CMD_UEMPPREFCONFIG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VEMPPREFSCONFIG,
				FunctionCmdConstants.CMD_VEMPPREFCONFIG,
				FunctionRes.CMD_VEMPPREFCONFIG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
	}
}
