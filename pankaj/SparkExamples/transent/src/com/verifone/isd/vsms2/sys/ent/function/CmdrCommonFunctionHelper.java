/**
 * 
 */
package com.verifone.isd.vsms2.sys.ent.function;

import com.verifone.isd.vsms2.sys.l10n.FunctionRes;

/**
 * This class loads all functions that are required in all Commander variants
 * 
 * @author Raghavendra_R1
 *
 */
public class CmdrCommonFunctionHelper extends AbstractFunctionHelper {

	/**
	 * 
	 */
	public CmdrCommonFunctionHelper() {
		this.initialize();
	}

	public void initialize() {
		FunctionAttribs f = new FunctionAttribs(FunctionRes.CMD_UDATETIME,
				FunctionCmdConstants.CMD_UDATETIME,
				FunctionRes.CMD_UDATETIME_DTL, Function.APP_CGI, false);
		f.setOTPRequired(true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VDATETIME,
				FunctionCmdConstants.CMD_VDATETIME,
				FunctionRes.CMD_VDATETIME_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VLOCALEINFO,
				FunctionCmdConstants.CMD_VLOCALEINFO,
				FunctionRes.CMD_VLOCALEINFO_DTL, Function.APP_CGI, false);
//				f.setLocalAccessOnly(true);
		this.addFunction(f);
		f = new FunctionAttribs(FunctionRes.CMD_CREBOOT, 
				FunctionCmdConstants.CMD_CREBOOT, 
				FunctionRes.CMD_CREBOOT_DTL, Function.APP_CGI, false);
		f.setOTPRequired(true);
		this.addFunction(f);
		f = new FunctionAttribs(FunctionRes.CMD_VLYNXPS,
				FunctionCmdConstants.CMD_VLYNXPS, FunctionRes.CMD_VLYNXPS_DTL,
				Function.APP_CGI, true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VLYNXSYSLOG,
				FunctionCmdConstants.CMD_VLYNXSYSLOG,
				FunctionRes.CMD_VLYNXSYSLOG_DTL, Function.APP_CGI, true);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_CENABLE_LOGIN,
				FunctionCmdConstants.CMD_CENABLE_LOGIN,
				FunctionRes.CMD_CENABLE_LOGIN_DTL, Function.APP_CGI, false);
                f.setProhibitUserConfig(true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_CDISABLE_LOGIN,
				FunctionCmdConstants.CMD_CDISABLE_LOGIN,
				FunctionRes.CMD_CDISABLE_LOGIN_DTL, Function.APP_CGI, false);
                f.setProhibitUserConfig(true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VSAPPHIREPROP,
				FunctionCmdConstants.CMD_VSAPPHIREPROP,
				FunctionRes.CMD_VSAPPHIREPROP_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_USAPPHIREPROP,
				FunctionCmdConstants.CMD_USAPPHIREPROP,
				FunctionRes.CMD_USAPPHIREPROP_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_LOADCLASS,
				FunctionCmdConstants.CMD_LOADCLASS,
				FunctionRes.CMD_LOADCLASS_DTL, Function.APP_CGI, true);
				f.setLocalAccessOnly(true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_RUNCLASS,
				FunctionCmdConstants.CMD_RUNCLASS,
				FunctionRes.CMD_RUNCLASS_DTL, Function.APP_CGI, true);
		f.setLocalAccessOnly(true);
		this.addFunction(f);		

		f = new FunctionAttribs(FunctionRes.CMD_DELETECLASS,
				FunctionCmdConstants.CMD_DELETECLASS,
				FunctionRes.CMD_DELETECLASS_DTL, Function.APP_CGI, true);
		f.setLocalAccessOnly(true);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_EVENT_REPEAT,
				FunctionCmdConstants.CMD_EVENT_REPEAT,
				FunctionRes.CMD_EVENT_REPEAT_DTL, Function.APP_CGI, false);
		f.setAccessWithoutLogin(true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_EVENT_REG,
				FunctionCmdConstants.CMD_EVENT_REG,
				FunctionRes.CMD_EVENT_REG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_EVENT_UNREG,
				FunctionCmdConstants.CMD_EVENT_UNREG,
				FunctionRes.CMD_EVENT_UNREG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VEVENTCFG,
				FunctionCmdConstants.CMD_VEVENTCFG,
				FunctionRes.CMD_VEVENTCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UEVENTCFG,
				FunctionCmdConstants.CMD_UEVENTCFG,
				FunctionRes.CMD_UEVENTCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VEVENTHISTORY,
				FunctionCmdConstants.CMD_VEVENTHISTORY,
				FunctionRes.CMD_VEVENTHISTORY_DTL, Function.APP_CGI, false);
		f.setAccessWithoutLoginFromVFIDevice(true);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VPOSDIAGNOSTICS,
				FunctionCmdConstants.CMD_VPOSDIAGNOSTICS,
				FunctionRes.CMD_VPOSDIAGNOSTICS_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VFORECOURTDIAGNOSTICS,
				FunctionCmdConstants.CMD_VFORECOURTDIAGNOSTICS,
				FunctionRes.CMD_VFORECOURTDIAGNOSTICS_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VMNSPDIAG,
				FunctionCmdConstants.CMD_VMNSPDIAG,
				FunctionRes.CMD_VMNSPDIAG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VUPGSUMMARYCFG,
				FunctionCmdConstants.CMD_VUPGSUMMARYCFG,
				FunctionRes.CMD_VUPGSUMMARYCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_CBEGINUPGRADE,
				FunctionCmdConstants.CMD_CBEGINUPGRADE,
				FunctionRes.CMD_CBEGINUPGRADE, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_CAUTOUPGRADE,
				FunctionCmdConstants.CMD_CAUTOUPGRADE,
				FunctionRes.CMD_CAUTOUPGRADE_DTL, Function.APP_CGI, false);
		f.setProhibitUserConfig(true);
		f.setAccessWithoutLogin(true);
		this.addFunction(f);
		
		//kiosk upgrade commands
		f = new FunctionAttribs(FunctionRes.CMD_UKIOSKVERSION,
				FunctionCmdConstants.CMD_UKIOSKVERSION,
				FunctionRes.CMD_UKIOSKVERSION, Function.APP_CGI, false);
		f.setLocalAccessOnly(true);
		f.setAccessWithoutLogin(true);
		f.setProhibitUserConfig(true);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_UKIOSKUPGSTATUS,
				FunctionCmdConstants.CMD_UKIOSKUPGSTATUS,
				FunctionRes.CMD_UKIOSKUPGSTATUS, Function.APP_CGI, false);
		f.setLocalAccessOnly(true);
		f.setAccessWithoutLogin(true);
		f.setProhibitUserConfig(true);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_CSENDKIOSKPACKAGE,
				FunctionCmdConstants.CMD_CSENDKIOSKPACKAGE,
				FunctionRes.CMD_CSENDKIOSKPACKAGE, Function.APP_CGI, false);
		f.setLocalAccessOnly(true);
		f.setAccessWithoutLogin(true);
		f.setProhibitUserConfig(true);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VKIOSKUPGSUMMARYCFG,
				FunctionCmdConstants.CMD_VKIOSKUPGSUMMARYCFG,
				FunctionRes.CMD_VKIOSKUPGSUMMARYCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VFEATURELIST,
				FunctionCmdConstants.CMD_VFEATURELIST,
				FunctionRes.CMD_VFEATURELIST_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_CREGSYSUPDATES,
				FunctionCmdConstants.CMD_CREGSYSUPDATES,
				FunctionRes.CMD_CREGSYSUPDATES_DTL, Function.APP_CGI,
				false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_CPING,
				FunctionCmdConstants.CMD_CPING, FunctionRes.CMD_CPING_DTL,
				Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_CFEATUREENABLEMENT,
				FunctionCmdConstants.CMD_CFEATUREENABLEMENT,
				FunctionRes.CMD_CFEATUREENABLEMENT_DTL, Function.APP_CGI, false);
		f.setAccessWithoutLogin(true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_CSWUPGRADEPKG,
				FunctionCmdConstants.CMD_CSWUPGRADEPKG,
				FunctionRes.CMD_CSWUPGRADEPKG_DTL, Function.APP_CGI, false);
		f.setAccessWithoutLogin(true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VNETWORKCFG,
				FunctionCmdConstants.CMD_VNETWORKCFG,
				FunctionRes.CMD_VNETWORKCFG_DTL, Function.APP_CGI, false);
		f.setOTPRequired(true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UNETWORKCFG,
				FunctionCmdConstants.CMD_UNETWORKCFG,
				FunctionRes.CMD_UNETWORKCFG_DTL, Function.APP_CGI, false);
		f.setOTPRequired(true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UNETWORKPARTCFG,
				FunctionCmdConstants.CMD_UNETWORKPARTCFG,
				FunctionRes.CMD_UNETWORKPARTCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VMAINTREGIS,
				FunctionCmdConstants.CMD_VMAINTREGIS,
				FunctionRes.CMD_VMAINTREGIS_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VMAINTTELEP,
				FunctionCmdConstants.CMD_VMAINTTELEP,
				FunctionRes.CMD_VMAINTTELEP_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VMAINTPOSTL,
				FunctionCmdConstants.CMD_VMAINTPOSTL,
				FunctionRes.CMD_VMAINTPOSTL_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UMAINTREGKEY,
				FunctionCmdConstants.CMD_UMAINTREGKEY,
				FunctionRes.CMD_UMAINTREGKEY_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UMAINTPHONE,
				FunctionCmdConstants.CMD_UMAINTPHONE,
				FunctionRes.CMD_UMAINTPHONE_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UMAINTPOSTAL,
				FunctionCmdConstants.CMD_UMAINTPOSTAL,
				FunctionRes.CMD_UMAINTPOSTAL_DTL, Function.APP_CGI, false);
		this.addFunction(f);
	    
	    f = new FunctionAttribs(FunctionRes.CMD_VAPP_CFG,
	            		FunctionCmdConstants.CMD_VAPP_CFG, 
	            		FunctionRes.CMD_VAPP_CFG_DTL, Function.APP_CGI, false); 
        this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VNETPOSCFG,
				FunctionCmdConstants.CMD_VNETPOSCFG,
				FunctionRes.CMD_VNETPOSCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UNETPOSCFG,
				FunctionCmdConstants.CMD_UNETPOSCFG,
				FunctionRes.CMD_UNETPOSCFG_DTL, Function.APP_CGI, false);
		f.setOTPRequired(true);
		this.addFunction(f);
	    
	    //HostedManagers Command
	    f = new FunctionAttribs(FunctionRes.CMD_VHOSTEDMANAGERS,
	            		FunctionCmdConstants.CMD_VHOSTEDMANAGERS, 
	            		FunctionRes.CMD_VHOSTEDMANAGERS_DTL, Function.APP_CGI, false); 
        this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VMODULECFGREF,
				FunctionCmdConstants.CMD_VMODULECFGREF,
				FunctionRes.CMD_VMODULECFGREF_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VRMODULECFGREF,
				FunctionCmdConstants.CMD_VRMODULECFGREF,
				FunctionRes.CMD_VRMODULECFGREF_DTL, Function.APP_CGI, false);
		f.setProhibitUserConfig(true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VMANAGEDMODULECFG,
				FunctionCmdConstants.CMD_VMANAGEDMODULECFG,
				FunctionRes.CMD_VMANAGEDMODULECFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VRMANAGEDMODULECFG,
				FunctionCmdConstants.CMD_VRMANAGEDMODULECFG,
				FunctionRes.CMD_VRMANAGEDMODULECFG_DTL, Function.APP_CGI, false);
		f.setProhibitUserConfig(true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_CDELETEPENDMDLCFG,
				FunctionCmdConstants.CMD_CDELETEPENDMDLCFG,
				FunctionRes.CMD_CDELETEPENDMDLCFG_DTL, Function.APP_CGI, false);
		f.setProhibitUserConfig(true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VPENDMDLCFG,
				FunctionCmdConstants.CMD_VPENDMDLCFG,
				FunctionRes.CMD_VPENDMDLCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VRPENDMDLCFG,
				FunctionCmdConstants.CMD_VRPENDMDLCFG,
				FunctionRes.CMD_VRPENDMDLCFG_DTL, Function.APP_CGI, false);
		f.setProhibitUserConfig(true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VSYSRESOURCESMAP,
				FunctionCmdConstants.CMD_VSYSRESOURCESMAP,
				FunctionRes.CMD_VSYSRESOURCESMAP_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UMANAGEDMODULECFG,
				FunctionCmdConstants.CMD_UMANAGEDMODULECFG,
				FunctionRes.CMD_UMANAGEDMODULECFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_URMANAGEDMODULECFG,
				FunctionCmdConstants.CMD_URMANAGEDMODULECFG,
				FunctionRes.CMD_URMANAGEDMODULECFG_DTL, Function.APP_CGI, false);
		f.setProhibitUserConfig(true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VMODULECFG,
				FunctionCmdConstants.CMD_VMODULECFG,
				FunctionRes.CMD_VMODULECFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VAPPMODULES,
				FunctionCmdConstants.CMD_VAPPMODULES,
				FunctionRes.CMD_VAPPMODULES_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VRMODULECFG,
				FunctionCmdConstants.CMD_VRMODULECFG,
				FunctionRes.CMD_VRMODULECFG_DTL, Function.APP_CGI, false);
		f.setProhibitUserConfig(true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VMODDESCMAP,
				FunctionCmdConstants.CMD_VMODDESCMAP,
				FunctionRes.CMD_VMODDESCMAP_DTL, Function.APP_CGI, false);
		this.addFunction(f);
				 
	    f = new FunctionAttribs(FunctionRes.CMD_CREFRESHEPSCONFIG,
	            		FunctionCmdConstants.CMD_CREFRESHEPSCONFIG, 
	            		FunctionRes.CMD_CREFRESHEPSCONFIG_DTL, Function.APP_CGI, false); 
        this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VTRANSSET,
				FunctionCmdConstants.CMD_VTRANSSET,
				FunctionRes.CMD_VTRANSSET_DTL, Function.APP_CGI, true);
		/**
		 * This cgi command is processed straight by Apache CGI program and
		 * therefore, does not look at the prop file.Setting a command specific
		 * timeout value for this cgi command will not be honoured.
		 **/
		f.setAccessWithoutLoginFromVFIDevice(true);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VTRANSSETZ,
				FunctionCmdConstants.CMD_VTRANSSETZ,
				FunctionRes.CMD_VTRANSSETZ_DTL, Function.APP_CGI, true);
		/**
		 * This cgi command is processed straight by Apache CGI program and
		 * therefore, does not look at the prop file.Setting a command specific
		 * timeout value for this cgi command will not be honoured.
		 **/
		this.addFunction(f);
        
        f = new FunctionAttribs(FunctionRes.BYPASS_EMPLOYEE_ID,
				FunctionCmdConstants.BYPASS_EMPLOYEE_ID,
				FunctionRes.BYPASS_EMPLOYEE_ID_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.BYPASS_ALL_CHECKS,
				FunctionCmdConstants.BYPASS_ALL_CHECKS,
				FunctionRes.BYPASS_ALL_CHECKS_DTL, Function.APP_CGI, false);
		f.setLocalAccessOnly(true);// DO NOT ALLOW EXTERNAL ACCESS
		this.addFunction(f);		
	    
	}

	
}
