package com.verifone.isd.vsms2.sys.ent.posfunction;

/**
 * 
 */
public enum POSFunctionTarget {

	DEFAULT("DEFAULT"), MWS("MWS");

	private final String targetName;

	private POSFunctionTarget(String target) {
		this.targetName = target;
	}

	public String getTarget() {
		return targetName;
	}
}
