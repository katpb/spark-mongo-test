/**
 * 
 */
package com.verifone.isd.vsms2.sys.ent.function;

import com.verifone.isd.vsms2.sys.l10n.FunctionRes;
import com.verifone.isd.vsms2.sys.util.SysPropertyConstant;
import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;

/**
 * This class loads all functions that are required ONLY 
 * in a regular Commander, but not in any of its variants
 * 
 * @author Raghavendra_R1
 *
 */
public class CmdrSpecificFunctionHelper extends AbstractFunctionHelper {

	/**
	 * 
	 */
	public CmdrSpecificFunctionHelper() {
		this.initialize();
	}

	public void initialize() {

		FunctionAttribs	f = new FunctionAttribs(FunctionRes.CMD_PLUDATTOGEMPRO,
				FunctionCmdConstants.CMD_PLUDATTOGEMPRO,
				FunctionRes.CMD_PLUDATTOGEMPRO_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f =  new FunctionAttribs(FunctionRes.CMD_VPLUUPDATESTATUS,
				FunctionCmdConstants.CMD_VPLUUPDATESTATUS,
				FunctionRes.CMD_VPLUUPDATESTATUS_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VMAINTTOTAL,
				FunctionCmdConstants.CMD_VMAINTTOTAL,
				FunctionRes.CMD_VMAINTTOTAL_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UMAINTTOT,
				FunctionCmdConstants.CMD_UMAINTTOT,
				FunctionRes.CMD_UMAINTTOT_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_NAXML_VPOSJOURNAL,
				FunctionCmdConstants.CMD_NAXML_VPOSJOURNAL,
				FunctionRes.CMD_NAXML_VPOSJOURNAL_DTL, Function.APP_NAXML,
				false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_NAXML_VMWSPOSJOURNAL,
				FunctionCmdConstants.CMD_NAXML_VMWSPOSJOURNAL,
				FunctionRes.CMD_NAXML_VMWSPOSJOURNAL_DTL, Function.APP_NAXML,
				false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_COMMIT_KIOSK_ORDER,
				FunctionCmdConstants.CMD_COMMIT_KIOSK_ORDER,
				FunctionRes.CMD_COMMIT_KIOSK_ORDER_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VCOUPON_FAM,
				FunctionCmdConstants.CMD_VCOUPON_FAM,
				FunctionRes.CMD_VCOUPON_FAM, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UCOUPON_FAM,
				FunctionCmdConstants.CMD_UCOUPON_FAM,
				FunctionRes.CMD_UCOUPON_FAM, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VDISCOUNT_DENOM,
				FunctionCmdConstants.CMD_VDISCOUNT_DENOM,
				FunctionRes.CMD_VDISCOUNT_DENOM, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UDISCOUNT_DENOM,
				FunctionCmdConstants.CMD_UDISCOUNT_DENOM,
				FunctionRes.CMD_UDISCOUNT_DENOM, Function.APP_CGI, false);
		this.addFunction(f);

		// Functions for EPS prepaid configuration.
		f = new FunctionAttribs(FunctionRes.CMD_VEPSPREPAIDCFG,
				FunctionCmdConstants.CMD_VEPSPREPAIDCFG,
				FunctionRes.CMD_VEPSPREPAIDCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UEPSPREPAIDCFG,
				FunctionCmdConstants.CMD_UEPSPREPAIDCFG,
				FunctionRes.CMD_UEPSPREPAIDCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VFOODSRVCFG,
				FunctionCmdConstants.CMD_VFOODSRVCFG,
				FunctionRes.CMD_VFOODSRVCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UFOODSRVCFG,
				FunctionCmdConstants.CMD_UFOODSRVCFG,
				FunctionRes.CMD_UFOODSRVCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VPOSCFGUPDT_CFG,
				 FunctionCmdConstants.CMD_VPOSCFGUPDT,
				 FunctionRes.CMD_VPOSCFGUPDT_CFG_DTL, Function.APP_CGI, false);
		f.setLocalAccessOnly(true);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_UPOSCFGUPDT_CFG,
				 FunctionCmdConstants.CMD_UPOSCFGUPDT,
				 FunctionRes.CMD_UPOSCFGUPDT_CFG_DTL, Function.APP_CGI, false);
		f.setLocalAccessOnly(true);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VAGEVALIDNCFG,
				FunctionCmdConstants.CMD_VAGEVALIDNCFG,
				FunctionRes.CMD_VAGEVALIDNCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UAGEVALIDNCFG,
				FunctionCmdConstants.CMD_UAGEVALIDNCFG,
				FunctionRes.CMD_UAGEVALIDNCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VBLUELAWCFG,
				FunctionCmdConstants.CMD_VBLUELAWCFG,
				FunctionRes.CMD_VBLUELAWCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UBLUELAWCFG,
				FunctionCmdConstants.CMD_UBLUELAWCFG,
				FunctionRes.CMD_UBLUELAWCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_VCHECKLINECFG,
				FunctionCmdConstants.CMD_VCHECKLINECFG,
				FunctionRes.CMD_VCHECKLINECFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UCHECKLINECFG,
				FunctionCmdConstants.CMD_UCHECKLINECFG,
				FunctionRes.CMD_UCHECKLINECFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		//Managed Update
        f = new FunctionAttribs(FunctionRes.CMD_UMANAGED_CONFIGURATION,
                FunctionCmdConstants.CMD_UMANAGED_CONFIGURATION,
                FunctionRes.CMD_UMANAGED_CONFIGURATION, Function.APP_CGI, false);
        this.addFunction(f);
        
        f = new FunctionAttribs(FunctionRes.CMD_VMANAGED_CONFIGURATION_STATUS,
                FunctionCmdConstants.CMD_VMANAGED_CONFIGURATION_STATUS,
                FunctionRes.CMD_VMANAGED_CONFIGURATION_STATUS, Function.APP_CGI, false);
        this.addFunction(f);
        
      //VHQ config
      	f = new FunctionAttribs(FunctionRes.CMD_VVHQCFG,
      			FunctionCmdConstants.CMD_VVHQCFG,
      			FunctionRes.CMD_VVHQCFG_DTL, Function.APP_CGI, false);
      	this.addFunction(f);

      	f = new FunctionAttribs(FunctionRes.CMD_UVHQCFG,
      			FunctionCmdConstants.CMD_UVHQCFG,
      			FunctionRes.CMD_UVHQCFG_DTL, Function.APP_CGI, false);
      	f.setOTPRequired(true);
      	this.addFunction(f);

	//Third Party Product Provider config
      	f = new FunctionAttribs(FunctionRes.CMD_VTHIRDPARTYPRODUCTPROVIDERCFG,
      			FunctionCmdConstants.CMD_VTHIRDPARTYPRODUCTPROVIDERCFG,
      			FunctionRes.CMD_VTHIRDPARTYPRODUCTPROVIDERCFG_DTL, Function.APP_CGI, false);
      	this.addFunction(f);
      	
      	f = new FunctionAttribs(FunctionRes.CMD_UTHIRDPARTYPRODUCTPROVIDERCFG,
      			FunctionCmdConstants.CMD_UTHIRDPARTYPRODUCTPROVIDERCFG,
      			FunctionRes.CMD_UTHIRDPARTYPRODUCTPROVIDERCFG_DTL, Function.APP_CGI, false);
      	this.addFunction(f);

        //APT global config
      	f = new FunctionAttribs(FunctionRes.CMD_APTGLOBALVIEWCFG,
      			FunctionCmdConstants.CMD_VAPT_GLOBAL_CONFIG,
      			FunctionRes.CMD_APTGLOBALVIEWCFG_DTL, Function.APP_CGI, false);
      	this.addFunction(f);
      	
      	f = new FunctionAttribs(FunctionRes.CMD_APTGLOBALUPDATECFG,
      			FunctionCmdConstants.CMD_UAPT_GLOBAL_CONFIG,
      			FunctionRes.CMD_APTGLOBALUPDATECFG_DTL, Function.APP_CGI, false);
      	this.addFunction(f);
      	
        //APT terminal config
      	f = new FunctionAttribs(FunctionRes.CMD_APTTERMINALVIEWCFG,
      			FunctionCmdConstants.CMD_VAPT_TERMINAL_CONFIG,
      			FunctionRes.CMD_APTTERMINALVIEWCFG_DTL, Function.APP_CGI, false);
      	this.addFunction(f);

      	f = new FunctionAttribs(FunctionRes.CMD_APTTERMINALUPDATECFG,
      			FunctionCmdConstants.CMD_UAPT_TERMINAL_CONFIG,
      			FunctionRes.CMD_APTTERMINALUPDATECFG_DTL, Function.APP_CGI, false);
      	this.addFunction(f);

      	// Register Device Config
		f = new FunctionAttribs(FunctionRes.CMD_CREG_MANAGEDDEVICE,
				FunctionCmdConstants.CMD_CREG_MANAGEDDEVICE,
				FunctionRes.CMD_CREG_MANAGEDDEVICE_DTL, Function.APP_CGI, false);
		f.setOTPRequired(true);
		this.addFunction(f);

      	f = new FunctionAttribs(FunctionRes.CMD_VMANAGEDDEVICECFG,
      			FunctionCmdConstants.CMD_VMANAGEDDEVICECFG,
      			FunctionRes.CMD_VMANAGEDDEVICECFG_DTL, Function.APP_CGI, false);
      	this.addFunction(f);
      	
      	f = new FunctionAttribs(FunctionRes.CMD_UMANAGEDDEVICECFG,
      			FunctionCmdConstants.CMD_UMANAGEDDEVICECFG,
      			FunctionRes.CMD_UMANAGEDDEVICECFG_DTL, Function.APP_CGI, false);
      	f.setOTPRequired(true);
      	this.addFunction(f);
      	
        //Vista terminal group
      	f = new FunctionAttribs(FunctionRes.CMD_VISTADEVICEGROUPVIEWCFG,
      			FunctionCmdConstants.CMD_VVISTA_GROUP,
      			FunctionRes.CMD_VISTADEVICEGROUPVIEWCFG_DTL, Function.APP_CGI, false);
      	this.addFunction(f);

      	f = new FunctionAttribs(FunctionRes.CMD_VISTADEVICEGROUPUPDATECFG,
      			FunctionCmdConstants.CMD_UVISTA_GROUP,
      			FunctionRes.CMD_VISTADEVICEGROUPUPDATECFG_DTL, Function.APP_CGI, false);
      	this.addFunction(f);
      	
      	//Vista terminal config
      	f = new FunctionAttribs(FunctionRes.CMD_VISTADEVICETERMINALVIEWCFG,
      			FunctionCmdConstants.CMD_VVISTA_TERMINAL_CONFIG,
      			FunctionRes.CMD_VISTADEVICETERMINALVIEWCFG_DTL, Function.APP_CGI, false);
      	this.addFunction(f);
      	
      	f = new FunctionAttribs(FunctionRes.CMD_VISTADEVICETERMINALUPDATECFG,
      			FunctionCmdConstants.CMD_UVISTA_TERMINAL_CONFIG,
      			FunctionRes.CMD_VISTADEVICETERMINALUPDATECFG_DTL, Function.APP_CGI, false);
      	this.addFunction(f);
      	
        //Vista Item Subset
      	f = new FunctionAttribs(FunctionRes.CMD_VISTADEVICEITEMSUBSETVIEWCFG,
      			FunctionCmdConstants.CMD_VVISTA_ITEM_SUBSET,
      			FunctionRes.CMD_VISTADEVICEITEMSUBSETVIEWCFG_DTL, Function.APP_CGI, false);
      	this.addFunction(f);

      	f = new FunctionAttribs(FunctionRes.CMD_VISTADEVICEITEMSUBSETUPDATECFG,
      			FunctionCmdConstants.CMD_UVISTA_ITEM_SUBSET,
      			FunctionRes.CMD_VISTADEVICEITEMSUBSETUPDATECFG_DTL, Function.APP_CGI, false);
      	this.addFunction(f);
      	
        //Vista Itemset
      	f = new FunctionAttribs(FunctionRes.CMD_VISTADEVICEITEMSETVIEWCFG,
      			FunctionCmdConstants.CMD_VVISTA_ITEMSET,
      			FunctionRes.CMD_VISTADEVICEITEMSETVIEWCFG_DTL, Function.APP_CGI, false);
      	this.addFunction(f);

      	f = new FunctionAttribs(FunctionRes.CMD_VISTADEVICEITEMSETUPDATECFG,
      			FunctionCmdConstants.CMD_UVISTA_ITEMSET,
      			FunctionRes.CMD_VISTADEVICEITEMSETUPDATECFG_DTL, Function.APP_CGI, false);
      	this.addFunction(f);
      	
        //Vista Terminal Preview
      	f = new FunctionAttribs(FunctionRes.CMD_VISTADEVICETERMINALPREVIEWVIEWCFG,
      			FunctionCmdConstants.CMD_VVISTA_TERMINAL_PREVIEW,
      			FunctionRes.CMD_VISTADEVICETERMINALPREVIEWVIEWCFG_DTL, Function.APP_CGI, false);
      	this.addFunction(f);

      	f = new FunctionAttribs(FunctionRes.CMD_VISTADEVICETERMINALPREVIEWUPDATECFG,
      			FunctionCmdConstants.CMD_UVISTA_TERMINAL_PREVIEW,
      			FunctionRes.CMD_VISTADEVICETERMINALPREVIEWUPDATECFG_DTL, Function.APP_CGI, false);
      	this.addFunction(f);
      	
        //Image Configuration
      	f = new FunctionAttribs(FunctionRes.CMD_IMAGEVIEWCFG,
      			FunctionCmdConstants.CMD_VIMAGE_CFG,
      			FunctionRes.CMD_IMAGEVIEWCFG_DTL, Function.APP_CGI, false);
      	this.addFunction(f);

      	f = new FunctionAttribs(FunctionRes.CMD_IMAGEUPDATECFG,
      			FunctionCmdConstants.CMD_UIMAGE_CFG,
      			FunctionRes.CMD_IMAGEUPDATECFG_DTL, Function.APP_CGI, false);
      	this.addFunction(f);
      	
      	/*
      	 * Following commands are deprecated and used only for AU Restore from Base 51 to higher version
      	 * Only for AU backward compatibility
      	 */
      	f = new FunctionAttribs(FunctionRes.CMD_CARBONTERMINALGROUPUPDATECFG,
      			FunctionCmdConstants.CMD_UCARBON_TERMINAL_GROUP,
      			FunctionRes.CMD_CARBONTERMINALGROUPUPDATECFG_DTL, Function.APP_CGI, false);
      	f.setProhibitUserConfig(true);
      	f.setLocalAccessOnly(true);
      	this.addFunction(f);
      	
      	f = new FunctionAttribs(FunctionRes.CMD_CARBONTERMINALUPDATECFG,
      			FunctionCmdConstants.CMD_UCARBON_TERMINAL_CONFIG,
      			FunctionRes.CMD_CARBONTERMINALUPDATECFG_DTL, Function.APP_CGI, false);
      	f.setProhibitUserConfig(true);
      	f.setLocalAccessOnly(true);
      	this.addFunction(f);
      	
      	f = new FunctionAttribs(FunctionRes.CMD_CARBONITEMSUBSETUPDATECFG,
      			FunctionCmdConstants.CMD_UCARBON_ITEM_SUBSET,
      			FunctionRes.CMD_CARBONITEMSUBSETUPDATECFG_DTL, Function.APP_CGI, false);
      	f.setProhibitUserConfig(true);
      	f.setLocalAccessOnly(true);
      	this.addFunction(f);
      	
      	f = new FunctionAttribs(FunctionRes.CMD_CARBONITEMSETUPDATECFG,
      			FunctionCmdConstants.CMD_UCARBON_ITEMSET,
      			FunctionRes.CMD_CARBONITEMSETUPDATECFG_DTL, Function.APP_CGI, false);
      	f.setProhibitUserConfig(true);
      	f.setLocalAccessOnly(true);
      	this.addFunction(f);
      	
      	f = new FunctionAttribs(FunctionRes.CMD_CARBONTERMINALPREVIEWUPDATECFG,
      			FunctionCmdConstants.CMD_UCARBON_TERMINAL_PREVIEW,
      			FunctionRes.CMD_CARBONTERMINALPREVIEWUPDATECFG_DTL, Function.APP_CGI, false);
      	f.setProhibitUserConfig(true);
      	f.setLocalAccessOnly(true);
      	this.addFunction(f);

    	String fiscalReceiptEnabled = SysPropertyFactory.
    			getProperty(SysPropertyConstant.FISCAL_RECEIPT_ENABLED, SysPropertyFactory.NO_STRING);
    	if(SysPropertyFactory.YES_STRING.equalsIgnoreCase(fiscalReceiptEnabled)) {
    		//Fiscal Receipt
    		f = new FunctionAttribs(FunctionRes.CMD_VFISCALRECEIPTCFG,
    				FunctionCmdConstants.CMD_VFISCALRECEIPTCFG,
    				FunctionRes.CMD_VFISCALRECEIPTCFG_DTL, Function.APP_CGI, false);
    		this.addFunction(f);

    		f = new FunctionAttribs(FunctionRes.CMD_UFISCALRECEIPTCFG,
    				FunctionCmdConstants.CMD_UFISCALRECEIPTCFG,
    				FunctionRes.CMD_UFISCALRECEIPTCFG_DTL, Function.APP_CGI, false);
    		this.addFunction(f);
    		
          	//Fuel flat tax
          	f = new FunctionAttribs(FunctionRes.CMD_VFUELFLATTAXCFG,
          			FunctionCmdConstants.CMD_VFUELFLATTAXCFG,
          			FunctionRes.CMD_VFUELFLATTAXCFG_DTL, Function.APP_CGI, false);
          	this.addFunction(f);
          	
          	f = new FunctionAttribs(FunctionRes.CMD_UFUELFLATTAXCFG,
          			FunctionCmdConstants.CMD_UFUELFLATTAXCFG,
          			FunctionRes.CMD_UFUELFLATTAXCFG_DTL, Function.APP_CGI, false);
          	this.addFunction(f);
          	
          	//Tax Exemption
          	f = new FunctionAttribs(FunctionRes.CMD_VTAXEXEMPTCFG,
          			FunctionCmdConstants.CMD_VTAXEXEMPTCFG,
          			FunctionRes.CMD_VTAXEXEMPTCFG_DTL, Function.APP_CGI, false);
          	this.addFunction(f);
          	
          	f = new FunctionAttribs(FunctionRes.CMD_UTAXEXEMPTCFG,
          			FunctionCmdConstants.CMD_UTAXEXEMPTCFG,
          			FunctionRes.CMD_UTAXEXEMPTCFG_DTL, Function.APP_CGI, false);
          	this.addFunction(f);
          //Fiscal customer Tax Information
			f = new FunctionAttribs(FunctionRes.CMD_VCUSTOMERTAXINFO,
					FunctionCmdConstants.CMD_VCUSTOMERTAXINFO,
					FunctionRes.CMD_VCUSTOMERTAXINFO_DTL, Function.APP_CGI, false);
			this.addFunction(f);

			f = new FunctionAttribs(FunctionRes.CMD_UCUSTOMERTAXINFO,
					FunctionCmdConstants.CMD_UCUSTOMERTAXINFO,
					FunctionRes.CMD_UCUSTOMERTAXINFO_DTL, Function.APP_CGI, false);
			this.addFunction(f);
    	}
    	
      	//Charity
		f = new FunctionAttribs(FunctionRes.CMD_VCHARITY,
				FunctionCmdConstants.CMD_VCHARITY,
				FunctionRes.CMD_VCHARITY_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UCHARITY,
				FunctionCmdConstants.CMD_UCHARITY,
				FunctionRes.CMD_UCHARITY_DTL, Function.APP_CGI, false);
		this.addFunction(f);    	

		// Sales Functions Security Config
		f = new FunctionAttribs(FunctionRes.CMD_VSOFTKEYTYPESECURITY_CFG,
				FunctionCmdConstants.CMD_VSOFTKEYTYPESECURITY_CFG,
				FunctionRes.CMD_VSOFTKEYTYPESECURITY_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_USOFTKEYTYPESECURITY_CFG,
				FunctionCmdConstants.CMD_USOFTKEYTYPESECURITY_CFG,
				FunctionRes.CMD_USOFTKEYTYPESECURITY_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
			
    	}

}
