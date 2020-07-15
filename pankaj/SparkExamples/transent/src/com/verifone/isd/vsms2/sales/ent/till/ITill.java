package com.verifone.isd.vsms2.sales.ent.till;

import java.io.Serializable;
import java.util.Date;

import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/**
 * @author MuditS1
 */
public interface ITill extends Serializable {

	/**
	 * Method to get the status of Till.
	 * 
	 * @return status
	 */
	public short getStatus();

	/**
	 * Method to set the current status of Till.
	 * 
	 * @param status
	 */
	public void setStatus(short status);

	/**
	 * Method to set the open date for Till.
	 * 
	 * @param openDate
	 */
	public void setOpenDate(Date dt);

	/**
	 * Method to get the open date for Till
	 * 
	 * @return openDate
	 */
	public Date getOpenDate();

	/**
	 * Method to set the close date for Till.
	 * 
	 * @param closeDate
	 */
	public void setCloseDate(Date dt);

	/**
	 * Method to get the close date for Till
	 * 
	 * @return closeDate
	 */
	public Date getCloseDate();

	/**
	 * Method to get Till number.
	 * 
	 * @return tillNum
	 */
	public int getTillNumber();

	/**
	 * Method to set Till number.
	 * 
	 * @param tillNum
	 */
	public void setTillNumber(int tillNum);

	/**
	 * Returns whether till is open or not.
	 * 
	 * @return
	 */
	public boolean getIsOpen();

	/**
	 * Set whether till is open or not.
	 * 
	 * @param isOpen
	 */
	public void setIsOpen(boolean isOpen);

	/**
	 * Returns the register number for Till.
	 * 
	 * @return
	 */
	public int getRegisterNumber();

	/**
	 * Method to set the register number for Till.
	 * 
	 * @param registerNum
	 */
	public void setRegisterNumber(int registerNum);

	/**
	 * Returns whether PK is valid or not.
	 * 
	 * @return
	 */
	public boolean isPKValid();

	/**
	 * Method to validate the Till
	 * 
	 * @throws java.lang.Exception
	 */
	public void validate() throws java.lang.Exception;

	/**
	 * Return the drawer associated with this Till.
	 * 
	 * @return drawerNum
	 */
	public short getDrawerNumber();

	/**
	 * Method to set Drawer Number associated with this Till.
	 * 
	 * @param drawerNum
	 */
	public void setDrawerNumber(short drawerNum);

	/**
	 * Returns the cashier sequence number for this Till.
	 * 
	 * @return sequenceNumber
	 */
	public int getSeqNr();

	/**
	 * Method to set the cashier sequence number for this Till.
	 * 
	 * @param seqNr
	 */
	public void setSeqNr(int seqNr);

	/**
	 * Returns the begin cash drawer amount.
	 * 
	 * @return beginCashDrawerAmount
	 */
	public long getBeginCashAmt();

	/**
	 * Sets the begin cash drawer amount.
	 * 
	 * @param beginCashDrawerAmount
	 */
	public void setBeginCashAmt(long amt);

	/**
	 * Returns the begin Food stamp amount in drawer.
	 * 
	 * @return
	 */
	public long getBeginFSAmt();

	/**
	 * Sets the begin food stamp amount in drawer.
	 * 
	 * @param amt
	 */
	public void setBeginFSAmt(long amt);

	/**
	 * Returns the begin ticket number.
	 * 
	 * @return
	 */
	public long getBeginTicket();

	/**
	 * Method to set the Begin ticket number.
	 * 
	 * @param tkt
	 */
	public void setBeginTicket(long tkt);

	/**
	 * Returns the End ticket number.
	 * 
	 * @return
	 */
	public long getEndTicket();

	/**
	 * Sets the End ticket number.
	 * 
	 * @param tkt
	 */
	public void setEndTicket(long tkt);

	/**
	 * Returns the total ticket counts
	 * 
	 * @return
	 */
	public int getTicketCount();

	/**
	 * Sets the total ticket count.
	 * 
	 * @param tktCnt
	 */
	public void setTicketCount(int tktCnt);

	/**
	 * Method to get the employee id.
	 * 
	 * @return
	 */
	public int getEmpId();

	/**
	 * Method to set the employee id.
	 * 
	 * @param empId
	 */
	public void setEmpId(int empId);

	/**
	 * Returns the employee name.
	 * 
	 * @return
	 */
	public String getEmpName();

	/**
	 * Sets the employee name.
	 * 
	 * @param empName
	 */
	public void setEmpName(String empName);

	/**
	 * Return the current amount in drawer of a particular mop.
	 * 
	 * @param mopNbr
	 * @return
	 */
	public MoneyAmount getAvailableAmount(int mopNbr);

	/**
	 * Sets the drawer available status.
	 *
	 * @param drawerAvailable
	 *            drawer available status flag.
	 */
	public void setDrawerAvailable(short drawerAvailable);

	/**
	 * Returns the drawer available status.
	 *
	 * @return the drawer available status.
	 */
	public short getDrawerAvailable();

}