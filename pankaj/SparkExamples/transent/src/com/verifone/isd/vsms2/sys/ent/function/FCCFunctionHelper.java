/**
 * 
 */
package com.verifone.isd.vsms2.sys.ent.function;

import com.verifone.isd.vsms2.sys.l10n.FunctionRes;

/**
 * This class loads all functions that are required for FCC functionality
 * 
 * @author Raghavendra_R1
 *
 */
public class FCCFunctionHelper extends AbstractFunctionHelper {

	/**
	 * 
	 */
	public FCCFunctionHelper() {
		this.initialize();
	}

	public void initialize() {
		
		FunctionAttribs	f = new FunctionAttribs(FunctionRes.CMD_VFUELCFG,
				FunctionCmdConstants.CMD_VFUELCFG,
				FunctionRes.CMD_VFUELCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VFUELRTCFG,
				FunctionCmdConstants.CMD_VFUELRTCFG,
				FunctionRes.CMD_VFUELRTCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UFUELCFG,
				FunctionCmdConstants.CMD_UFUELCFG,
				FunctionRes.CMD_UFUELCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VFUELRTPRICES,
				FunctionCmdConstants.CMD_VFUELRTPRICES,
				FunctionRes.CMD_VFUELRTPRICES_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VFUELPRICES,
				FunctionCmdConstants.CMD_VFUELPRICES,
				FunctionRes.CMD_VFUELPRICES_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UFUELPRICES,
				FunctionCmdConstants.CMD_UFUELPRICES,
				FunctionRes.CMD_UFUELPRICES_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VPSCDCRCONFIG,
				FunctionCmdConstants.CMD_VPSCDCRCONFIG,
				FunctionRes.CMD_VPSCDCRCONFIG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UPSCDCRCONFIG,
				FunctionCmdConstants.CMD_UPSCDCRCONFIG,
				FunctionRes.CMD_UPSCDCRCONFIG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VPSCDCRKEYCONFIG,
				FunctionCmdConstants.CMD_VPSCDCRKEYCONFIG,
				FunctionRes.CMD_VPSCDCRKEYCONFIG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UPSCDCRKEYCONFIG,
				FunctionCmdConstants.CMD_UPSCDCRKEYCONFIG,
				FunctionRes.CMD_UPSCDCRKEYCONFIG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VCARWASHCFG,
				FunctionCmdConstants.CMD_VCARWASHCFG,
				FunctionRes.CMD_VCARWASHCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UCARWASHCFG,
				FunctionCmdConstants.CMD_UCARWASHCFG,
				FunctionRes.CMD_UCARWASHCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VCWPAYPOINTCFG,
				FunctionCmdConstants.CMD_VCWPAYPOINTCFG,
				FunctionRes.CMD_VCWPAYPOINTCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UCWPAYPOINTCFG,
				FunctionCmdConstants.CMD_UCWPAYPOINTCFG,
				FunctionRes.CMD_UCWPAYPOINTCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VTLSSITE,
				FunctionCmdConstants.CMD_VTLSSITE,
				FunctionRes.CMD_VTLSSITE_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UTLSSITE,
				FunctionCmdConstants.CMD_UTLSSITE,
				FunctionRes.CMD_UTLSSITE_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VCASHACCSITE,
				FunctionCmdConstants.CMD_VCASHACCSITE,
				FunctionRes.CMD_VCASHACCSITE_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UCASHACCSITE,
				FunctionCmdConstants.CMD_UCASHACCSITE,
				FunctionRes.CMD_UCASHACCSITE_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VDCRHEADERCFG,
				FunctionCmdConstants.CMD_VDCRHEADERCFG,
				FunctionRes.CMD_VDCRHEADERCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UDCRHEADERCFG,
				FunctionCmdConstants.CMD_UDCRHEADERCFG,
				FunctionRes.CMD_UDCRHEADERCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VDCRMESSAGECFG,
				FunctionCmdConstants.CMD_VDCRMESSAGECFG,
				FunctionRes.CMD_VDCRMESSAGECFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UDCRMESSAGECFG,
				FunctionCmdConstants.CMD_UDCRMESSAGECFG,
				FunctionRes.CMD_UDCRMESSAGECFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VDCRTRAILERCFG,
				FunctionCmdConstants.CMD_VDCRTRAILERCFG,
				FunctionRes.CMD_VDCRTRAILERCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UDCRTRAILERCFG,
				FunctionCmdConstants.CMD_UDCRTRAILERCFG,
				FunctionRes.CMD_UDCRTRAILERCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VFUELTOTALS,
				FunctionCmdConstants.CMD_VFUELTOTALS,
				FunctionRes.CMD_VFUELTOTALS_DTL, Function.APP_CGI, true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VFUELTOTALSZ,
				FunctionCmdConstants.CMD_VFUELTOTALSZ,
				FunctionRes.CMD_VFUELTOTALSZ_DTL, Function.APP_CGI, true);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_CCWPAYPOINT_INIT,
				FunctionCmdConstants.CMD_CCWPAYPOINT_INIT,
				FunctionRes.CMD_CCWPAYPOINT_INIT_DTL, Function.APP_CGI, true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VCWPAYPOINT_PD_REPORT,
				FunctionCmdConstants.CMD_VCWPAYPOINT_PD_REPORT,
				FunctionRes.CMD_VCWPAYPOINT_PD_REPORT_DTL, Function.APP_CGI,
				true);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_CFUELINIT,
				FunctionCmdConstants.CMD_CFUELINIT,
				FunctionRes.CMD_CFUELINIT_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_CDCRINIT,
				FunctionCmdConstants.CMD_CDCRINIT,
				FunctionRes.CMD_CDCRINIT_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_CDCRDRIVERINIT,
				FunctionCmdConstants.CMD_CDCRDRIVERINIT,
				FunctionRes.CMD_CDCRDRIVERINIT_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_CCARWASH_ENABLE,
				FunctionCmdConstants.CMD_CCARWASH_ENABLE,
				FunctionRes.CMD_CCARWASH_ENABLE_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_CCARWASH_DISABLE,
				FunctionCmdConstants.CMD_CCARWASH_DISABLE,
				FunctionRes.CMD_CCARWASH_DISABLE_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_CREGISTER_DCR,
				FunctionCmdConstants.CMD_CREGISTER_DCR,
				FunctionRes.CMD_CREGISTER_DCR_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_CINCREMENT_DCR_KEY,
				FunctionCmdConstants.CMD_CINCREMENT_DCR_KEY,
				FunctionRes.CMD_CINCREMENT_DCR_KEY_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_CUPDATE_DCR_SETTINGS,
				FunctionCmdConstants.CMD_CUPDATE_DCR_SETTINGS,
				FunctionRes.CMD_CUPDATE_DCR_SETTINGS_DTL, Function.APP_CGI, false);
		this.addFunction(f);		

		f = new FunctionAttribs(FunctionRes.CMD_CUNATTENDED_ENABLE,
						FunctionCmdConstants.CMD_CUNATTENDED_ENABLE,
						FunctionRes.CMD_CUNATTENDED_ENABLE_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_CUNATTENDED_DISABLE,
						FunctionCmdConstants.CMD_CUNATTENDED_DISABLE,
						FunctionRes.CMD_CUNATTENDED_DISABLE_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VDCRUNATTENDED_CFG,
						FunctionCmdConstants.CMD_VDCRUNATTENDED_CFG,
						FunctionRes.CMD_VDCRUNATTENDED_CFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UDCRUNATTENDED_CFG,
						FunctionCmdConstants.CMD_UDCRUNATTENDED_CFG,
						FunctionRes.CMD_UDCRUNATTENDED_CFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_CUNATTENDED_SCHEDULE,
				FunctionCmdConstants.CMD_CUNATTENDED_SCHEDULE,
				FunctionRes.CMD_CUNATTENDED_SCHEDULE_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_CFUEL_DRVINIT,
				FunctionCmdConstants.CMD_CFUEL_DRVINIT,
				FunctionRes.CMD_CFUEL_DRVINIT_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_CFUELPRICES,
				FunctionCmdConstants.CMD_CFUELPRICES,
				FunctionRes.CMD_CFUELPRICES_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VFUELTAXEXCFG,
				FunctionCmdConstants.CMD_VFUELTAXEXCFG,
				FunctionRes.CMD_VFUELTAXEXCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UFUELTAXEXCFG,
				FunctionCmdConstants.CMD_UFUELTAXEXCFG,
				FunctionRes.CMD_UFUELTAXEXCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_RCFVIEWCFG,
				FunctionCmdConstants.CMD_RCFVIEWCFG,
				FunctionRes.CMD_RCFVIEWCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_RCFUPDATECFG,
				FunctionCmdConstants.CMD_RCFUPDATECFG,
				FunctionRes.CMD_RCFUPDATECFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_RCFINITCFG,
				FunctionCmdConstants.CMD_RCFINITCFG,
				FunctionRes.CMD_RCFINITCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_FPDVIEWCFG,
				FunctionCmdConstants.CMD_FPDVIEWCFG,
				FunctionRes.CMD_FPDVIEWCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_FPDUPDATECFG,
				FunctionCmdConstants.CMD_FPDUPDATECFG,
				FunctionRes.CMD_FPDUPDATECFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_FPDINITCFG,
				FunctionCmdConstants.CMD_FPDINITCFG,
				FunctionRes.CMD_FPDINITCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_CFDCPOSREQ,
				FunctionCmdConstants.CMD_CFDCPOSREQ,
				FunctionRes.CMD_CFDCPOSREQ_DTL, Function.APP_CGI, false);
		f.setRestrictJournaling(true);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VDCRIDLESCREENCONFIG,
		         FunctionCmdConstants.CMD_VPSCDCRIDLESCREENCONFIG,
		         FunctionRes.CMD_VDCRIDLESCREENCONFIG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_UDCRIDLESCREENCONFIG,
		         FunctionCmdConstants.CMD_UPSCDCRIDLESCREENCONFIG,
		         FunctionRes.CMD_UDCRIDLESCREENCONFIG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VVENDINGMACHINECONFIG,
		         FunctionCmdConstants.CMD_VVENDINGMACHINECONFIG,
		         FunctionRes.CMD_VVENDINGMACHINECONFIG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_UVENDINGMACHINECONFIG,
		         FunctionCmdConstants.CMD_UVENDINGMACHINECONFIG,
		         FunctionRes.CMD_UVENDINGMACHINECONFIG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
	}

}
