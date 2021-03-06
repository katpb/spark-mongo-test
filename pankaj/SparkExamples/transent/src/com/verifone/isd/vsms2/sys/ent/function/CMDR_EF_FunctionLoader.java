/**
 * 
 */
package com.verifone.isd.vsms2.sys.ent.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This function loader is responsible to load functions 
 * that are relevant for the Commander EF variant
 * 
 * @author Raghavendra_R1
 *
 */
public class CMDR_EF_FunctionLoader extends CMDR_FunctionLoader {
	
	@Override
	public void initialize(String viperReportConfigFileFQN) {
		//Initialize the function helpers
		List<FunctionHelper> functionHelpers = new ArrayList<FunctionHelper>();
		FunctionHelper funcHelper = new CommonFunctionHelper();
		functionHelpers.add(funcHelper);
		
		funcHelper = new CmdrCommonFunctionHelper();
		functionHelpers.add(funcHelper);
		
		funcHelper = new CoresvcsFunctionHelper();
		functionHelpers.add(funcHelper);
		
		funcHelper = new EPSFunctionHelper();
		functionHelpers.add(funcHelper);

		funcHelper = new MobileFunctionHelper();
		functionHelpers.add(funcHelper);
		
		funcHelper = new FCCFunctionHelper();
		functionHelpers.add(funcHelper);
		
		//Initialize the subfunction helpers
		Map<String, SubFunctionHelper> subFunctionHelpers = new HashMap<String, SubFunctionHelper>();
		SubFunctionHelper helper = new RubyReport_CMDR_F_Helper();
		subFunctionHelpers.put(FunctionCmdConstants.CMD_VRUBYREPT, helper);
		
		helper = new ViperReportHelper(viperReportConfigFileFQN);
		subFunctionHelpers.put(FunctionCmdConstants.CMD_VVIPERPREPT, helper);
		
		super.initialize(functionHelpers, subFunctionHelpers);
	}
}
