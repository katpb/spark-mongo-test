package com.verifone.isd.vsms2.sys.ent.report;

import java.io.Serializable;

/**
 * System Entry for Manager Workstation
 * @author T_ShailendraP1
 *
 */
public class MWS implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6407476024899855714L;
	private boolean enableMWS;
	private int autoApproveLimit;
	
	public boolean isEnableMWS() {
		return enableMWS;
	}
	public void setEnableMWS(boolean enableMWS) {
		this.enableMWS = enableMWS;
	}
	public int getAutoApproveLimit() {
		return autoApproveLimit;
	}
	public void setAutoApproveLimit(int autoApproveLimit) {
		this.autoApproveLimit = autoApproveLimit;
	}
	
	
}
