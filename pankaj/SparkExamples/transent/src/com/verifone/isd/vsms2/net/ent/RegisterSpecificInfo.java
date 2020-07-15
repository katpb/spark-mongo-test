package com.verifone.isd.vsms2.net.ent;

/**
 * Entity class to hold POS Terminal details
 * @author Sumith_S1
 *
 */
public class RegisterSpecificInfo {

	private String applicationType;
	private String workStationID;
	private OperatorModel operatorModel;
	private String activePopId;
	private String popIdForSession;
	
	private RegisterSpecificInfo() {
	}
	
	/**
	 * Constructor 
	 * @param workStationID
	 */
	public RegisterSpecificInfo(String workStationID){
		this();
		this.workStationID = workStationID;
	}
	
	/**
	 * Getter for Application Type.
	 * @return applicationType
	 */
	public String getApplicationType() {
		return applicationType;
	}
	
	/**
	 * Setter for Application Type.
	 * @param applicationType
	 */
	public void setApplicationType(String applicationType) {
		this.applicationType = applicationType;
	}
	
	/**
	 * Getter for Operator Model.
	 * @return operatorModel
	 */
	public OperatorModel getOperatorModel() {
		return operatorModel;
	}
	
	/**
	 * Setter for Operator Model.
	 * @param operatorModel
	 */
	public void setOperatorModel(OperatorModel operatorModel) {
		this.operatorModel = operatorModel;
	}
	
	/**
	 * Getter for WorkStation ID.
	 * @return workStationID
	 */
	public String getWorkStationID() {
		return workStationID;
	}

	/**
	 * Getter for POP ID.
	 * @return popId
	 */
	public String getActivePopId() {
		return activePopId;
	}

	/**
	 * Setter for POP ID.
	 * @param activePopId
	 */
	public void setActivePopId(String activePopId) {
		this.activePopId = activePopId;
	}

	/**
	 * Getter for Pinpad ID for Session.
	 * @return pinpadForSession
	 */
	public String getPopIdForSession() {
		return popIdForSession;
	}

	/**
	 * Setter for Pinpad ID for Session.
	 * @param popIdForSession
	 */
	public void setPopIdForSession(String popIdForSession) {
		this.popIdForSession = popIdForSession;
	}
	
}


