/**
 *
 */
package com.verifone.isd.vsms2.sales.ent.trans;

import java.io.Serializable;

/**
 * This class holds mobile SLA specific auth-data to be populated in mobile advice request
 *
 * @author t_shivrajs1
 *
 */
public class MobileSLAData implements Serializable {

	private static final long serialVersionUID = 7031804067586264737L;

	private String transactionRefId;
	private String hostId;
	private String hostName;

	/**
	 * @return the transactionRefId
	 */
	public String getTransactionRefId() {
		return transactionRefId;
	}
	/**
	 * @param transactionRefId the transactionRefId to set
	 */
	public void setTransactionRefId(String transactionRefId) {
		this.transactionRefId = transactionRefId;
	}
	/**
	 * @return the hostId
	 */
	public String getHostId() {
		return hostId;
	}
	/**
	 * @param histId the hostId to set
	 */
	public void setHostId(String hostId) {
		this.hostId = hostId;
	}
	/**
	 * @return the hostName
	 */
	public String getHostName() {
		return hostName;
	}
	/**
	 * @param hostName the hostName to set
	 */
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

}
