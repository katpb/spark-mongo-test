package com.verifone.isd.vsms2.sys.ent.function;

import java.io.Serializable;
/**
 * Holds the config change origin details
 * @author PravijaK1
 *
 */

public class ActionOriginDetails implements Serializable {
	
	
	private static final long serialVersionUID = 6826468203499292683L;
	
	private String changedBy;
	private String changedFrom;
	
	public ActionOriginDetails(String changedBy,String changedFrom){
		this.changedBy = changedBy;
		this.changedFrom = changedFrom;
	}
	
	/**
	 * returns from where the change happened
	 * - registerId if the change update happens from register via RMI call
	 * - ipAddress if the change triggered via CGI request
	 * @return
	 */
	public String getChangedFrom() {
		return changedFrom;
	}
	
	/**
	 * sets the change origin
	 * 
	 * @param changedFrom
	 */
	public void setChangedFrom(String changedFrom) {
		this.changedFrom = changedFrom;
	}
	
	/**
	 * sets who changed the config
	 * - User name is the chnage done via CGI request
	 * - Cashier Id if the change update happens from POS register via RMI APIs
	 * 
	 * @param changedBy
	 */
	public void setChangedBy(String changedBy) {
		this.changedBy = changedBy;
	}
	
	/**
	 * Returns who triggered the change
	 * - User name is the chnage done via CGI request
	 * - Cashier Id if the change update happens from POS register via RMI APIs
	 * 
	 * @return
	 */
	public String getChangedBy() {
		return changedBy;
	}

}
