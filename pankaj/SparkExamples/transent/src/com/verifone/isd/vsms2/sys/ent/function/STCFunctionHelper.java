/**
 * 
 */
package com.verifone.isd.vsms2.sys.ent.function;

import com.verifone.isd.vsms2.sys.l10n.FunctionRes;

/**
 * This class loads all functions that are required for STC functionality
 * 
 * @author Raghavendra_R1
 *
 */
public class STCFunctionHelper extends AbstractFunctionHelper {

	/**
	 * 
	 */
	public STCFunctionHelper() {
		this.initialize();
	}

	public void initialize() {
		
		FunctionAttribs f = new FunctionAttribs(FunctionRes.CMD_VESAFECFG,
				FunctionCmdConstants.CMD_VESAFECFG,
				FunctionRes.CMD_VESAFECFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UESAFECFG,
				FunctionCmdConstants.CMD_UESAFECFG,
				FunctionRes.CMD_UESAFECFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VECHECKCFG,
				FunctionCmdConstants.CMD_VECHECKCFG,
				FunctionRes.CMD_VECHECKCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);

		f = new FunctionAttribs(FunctionRes.CMD_UECHECKCFG,
				FunctionCmdConstants.CMD_UECHECKCFG,
				FunctionRes.CMD_UECHECKCFG_DTL, Function.APP_CGI, false);
		this.addFunction(f);
		
		f = new FunctionAttribs(FunctionRes.CMD_VESAFECASHIERREPT,
				FunctionCmdConstants.CMD_VESAFECASHIERREPT,
				FunctionRes.CMD_VESAFECASHIERREPT_DTL, Function.APP_CGI, true);
		this.addFunction(f);
	}

}
