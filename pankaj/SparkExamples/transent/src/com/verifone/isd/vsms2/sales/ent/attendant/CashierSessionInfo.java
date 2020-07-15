package com.verifone.isd.vsms2.sales.ent.attendant;

import java.io.Serializable;

import com.verifone.isd.vsms2.sales.ent.till.ITill;

/**
 * 
 * @author BaishampayM1
 *
 */
public class CashierSessionInfo implements Serializable{

	private static final long serialVersionUID = 7239369856816425769L;
	private String attendantID;
	private String cashierNum;
	private short registerNum;
	private short sequenceNum;
	private int drawerNum;
	private String cashierName;
	private ITill csrTill;
	private CashierSessionStatus csrStatus;
	private String openedDate;
	private short cashierSysId;

	
	public ITill getCsrTill() {
		return csrTill;
	}

	public void setCsrTill(ITill csrTill) {
		this.csrTill = csrTill;
	}

	public CashierSessionStatus getCsrStatus() {
		return csrStatus;
	}

	public void setCsrStatus(CashierSessionStatus csrStatus) {
		this.csrStatus = csrStatus;
	}

	public String getAttendantID() {
		return attendantID;
	}

	public void setAttendantID(String attendantID) {
		this.attendantID = attendantID;
	}

	public String getCashierNum() {
		return cashierNum;
	}

	public void setCashierNum(String cashierNum) {
		this.cashierNum = cashierNum;
	}

	public short getRegisterNum() {
		return registerNum;
	}

	public void setRegisterNum(short registerNum) {
		this.registerNum = registerNum;
	}

	public short getSequenceNum() {
		return sequenceNum;
	}

	public void setSequenceNum(short sequenceNum) {
		this.sequenceNum = sequenceNum;
	}

	public int getDrawerNum() {
		return drawerNum;
	}

	public void setDrawerNum(int drawerNum) {
		this.drawerNum = drawerNum;
	}

	public String getCashierName() {
		return cashierName;
	}

	public void setCashierName(String cashierName) {
		this.cashierName = cashierName;
	}


	public String getOpenedDate() {
		return openedDate;
	}


	public void setOpenedDate(String openedDate) {
		this.openedDate = openedDate;
	}

	public short getCashierSysId() {
		return cashierSysId;
	}

	public void setCashierSysId(short cashierSysId) {
		this.cashierSysId = cashierSysId;
	}
}
