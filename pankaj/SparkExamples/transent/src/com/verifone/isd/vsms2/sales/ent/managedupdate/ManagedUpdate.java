package com.verifone.isd.vsms2.sales.ent.managedupdate;


/**
 * ManagedUpdate Data
 * @author T_ShailendraP1
 *
 */
public class ManagedUpdate implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7909298212425552591L;
	
    private String  timeStamp;
    private String dataSet;
    
	public ManagedUpdate() {
		super();
	}
	public ManagedUpdate(String timeStamp, String dataSet) {
		super();
		this.timeStamp = timeStamp;
		this.dataSet = dataSet;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getDataSet() {
		return dataSet;
	}
	public void setDataSet(String dataSet) {
		this.dataSet = dataSet;
	}
	
	@Override
	public String toString() {
		return "ManagedUpdate [timeSatmp=" + timeStamp + ", dataSet="
				+ dataSet + "]";
	}
    

}
