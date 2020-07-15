/*
 * PosID.java
 *
 * Created on February 12, 2003, 2:35 PM
 */

package com.verifone.isd.vsms2.sales.ent.trans;

import com.verifone.isd.vsms2.sys.ent.securityctrl.SecurityLevel;

/**
 * Class to identify a POS Workstation
 *
 * @author  mailto:david_e3@verifone.com
 * @version 1.0
 */
public class CashierID implements java.io.Serializable,Cloneable {
	private static final long serialVersionUID = 6934540648068869674L;
	private long id = 0L;
    private SecurityLevel securityLevel;
    private String name = null;
    private String employeeNum = "";
    private String attendantID;
    
    /** Creates a new instance of PosID */
    public CashierID() {
    }
    
    /** Set the cashier ID
     * @param id a long identifying the cashier
     */
    public void setId(long id) {
        this.id = id;
    }
    
    /** Get the cashier ID
     * @return a long identifying the cashier, or 0L if the value has not been set.
     */
    public long getId() {
        return this.id;
    }

    /**
     * get the Security Level
     * @return securityLevel
     */
	public SecurityLevel getSecurityLevel() {
		return securityLevel;
	}
	
	/**
	 * set the Security Level
	 * @param securityLevel
	 */
	public void setSecurityLevel(SecurityLevel securityLevel) {
		this.securityLevel = securityLevel;
	}
    /** Get the cashier name
     * @return a string name representing the cashier name.
    */    
	public String getName() {
		return (this.name != null ? this.name : "");
	}

	/** Set the cashier name
     * @param id a long identifying the cashier
    */
	public void setName(String name) {
		this.name = name;
	}

	public String getEmployeeNum() {
		return this.employeeNum != null ? this.employeeNum : "";
	}

	public void setEmployeeNum(String employeeNum) {
		this.employeeNum = employeeNum;
	}
	@Override
	public Object clone() {
		CashierID clonedCID = null;
		try {
			clonedCID = (CashierID)super.clone();
		} catch (CloneNotSupportedException badclone) {
			throw new InternalError(badclone.toString());
		}
		clonedCID.id = this.id;
		clonedCID.securityLevel = this.securityLevel;
		clonedCID.name = this.name;
		clonedCID.employeeNum = this.employeeNum;
		return clonedCID;
	}

	public String getAttendantID() {
		return attendantID;
	}

	public void setAttendantID(String attendantID) {
		this.attendantID = attendantID;
	}
}