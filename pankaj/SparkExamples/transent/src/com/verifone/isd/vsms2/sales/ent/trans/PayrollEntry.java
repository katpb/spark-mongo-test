/*
 * PayrollEntry.java
 *
 * Created on December 15, 2003, 11:20 AM
 */

package com.verifone.isd.vsms2.sales.ent.trans;


import java.util.HashMap;
import java.util.Map;

import com.verifone.isd.vsms2.sales.ent.softkey.SoftKeyType;
import com.verifone.isd.vsms2.sys.ent.payroll.JobCode;
/**
 * Transaction to represent payroll entries (clock in and clock out).
 * This transaction does not support suspend/ recall. TransactionType.CLOCKIN and
 * TransactionType.CLOCKOUT are the only two valid transaction types for this class.
 * The onus of constraining the TransactionType assigned to this class lies with the
 * controller object (since it is expensive to limit values in the bean methods by
 * throwing exceptions).
 * @author  Bhanu_N2
 */
public class PayrollEntry implements ITransaction {

	private static final long serialVersionUID = -5909288066142253942L;
	private long transactionTime;
    private CashierID cashierID;
    private CashierID employeeID;
    private PosID posID;
    private TransNum transNum;
    private TransactionType transactionType;
    private int cashierPeriodSeq;
    
	private CashierID overrideCashierID;

	private SoftKeyType softKeyType;
    /**
     * Holds value of property jobCode.
     */
    private JobCode jobCode;
    
    /**
     * Holds value of property autoGenerated.
     */
    private boolean autoGenerated;
    
    /**
     * Holds value of property additionalInfo.
     */
    private PayrollEntryInfo additionalInfo;
    
    /*Unique global txn sequence number, not restricted to the register number*/
    private long uniqueTxnSeqNum;

	private String storeNumber;

	private CurrentPeriodInfo[] periodDetails;
	
	private boolean attendantTransaction;
    
    /** Creates a new instance of PayrollEntry */
    public PayrollEntry() {
    }

    public int getCashierPeriodSeq() {
      return this.cashierPeriodSeq;
    }

    public void setCashierPeriodSeq(int cashierPeriodSeq) {
      this.cashierPeriodSeq = cashierPeriodSeq;
    }

    /** Getter for property transactionTime.
     * @return Value of property transactionTime.
     */
    public long getTransactionTime() {
        return this.transactionTime;
    }

    /** Getter for property cashierID.
     * @return Value of property cashierID.
     */
    public CashierID getCashierID() {
        return this.cashierID;
    }

    /** Getter for property posID.
     * @return Value of property posID.
     */
    public PosID getPosID() {
        return this.posID;
    }

    /** Getter for transaction number
     * @return transaction number
     */
    public TransNum getTransNum() {
        return this.transNum;
    }

    /** Getter for property transactionType.
     * @return Value of property transactionType.
     */
    public TransactionType getTransactionType() {
        return this.transactionType;
    }

    /** Getter for property suspended. This txn DOES not support suspend/ recall
     * Sales app should explicitly limit suspend to certain transaction types
     * @return Value of property suspended.
     */
    public boolean isSuspended() {
        return false;
    }

    /** Setter for property transactionTime.
     * @param dateTime timestamp for the transaction
     */
    public void setTransactionTime(long dateTime) {
        this.transactionTime = dateTime;
    }

    /** Setter for property cashierID.
     * @param cashierID ID of the cashier performing the transaction
     */
    public void setCashierID(CashierID cashierID) {
        this.cashierID = cashierID;
    }

    /** Setter for property cashierID.
     * @param cashierID ID of the cashier performing the transaction
     */
    public void setEmployeeID(CashierID cashierID) {
        this.employeeID = cashierID;
    }

    public CashierID getEmployeeID() {
      return this.employeeID;
    }

    /** Setter for property posID.
     * @param posID New value of property posID.
     */
    public void setPosID(PosID posID) {
        this.posID = posID;
    }

    /** Set the transaction number
     * @param transNum transaction number
     */
    public void setTransNum(TransNum transNum) {
        this.transNum = transNum;
    }

    /** Setter for property transactionType.
     * @param transactionType New value of property transactionType.
     */
    public void setTransactionType(TransactionType transactionType) {
        this.transactionType= transactionType;
    }
    
    /**
     * Getter for property jobCode.
     * @return Value of property jobCode.
     */
    public JobCode getJobCode() {
        return this.jobCode;
    }
    
    /**
     * Setter for property jobCode.
     * @param jobCode New value of property jobCode.
     */
    public void setJobCode(JobCode jobCode) {
        this.jobCode = jobCode;
    }
    
    /**
     * Getter for property autoGenerated.
     * @return Value of property autoGenerated.
     */
    public boolean isAutoGenerated() {
        return this.autoGenerated;
    }
    
    /**
     * Setter for property autoGenerated.
     * @param autoGenerated New value of property autoGenerated.
     */
    public void setAutoGenerated(boolean autoGenerated) {
        this.autoGenerated = autoGenerated;
    }
    
    /**
     * Getter for property additionalInfo.
     * @return Value of property additionalInfo.
     */
    public PayrollEntryInfo getAdditionalInfo() {
        return this.additionalInfo;
    }
    
    /**
     * Setter for property additionalInfo.
     * @param additionalInfo New value of property additionalInfo.
     */
    public void setAdditionalInfo(PayrollEntryInfo additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

	@Override
	public long getUniqueTxnSeqNum() {
		return this.uniqueTxnSeqNum;
	}

	@Override
	public void setUniqueTxnSeqNum(long uniqueTxnSeqNum) {
		this.uniqueTxnSeqNum = uniqueTxnSeqNum;
	}

	@Override
	public String getStoreNumber() {
		return this.storeNumber;
	}

	@Override
	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
		
	}
	
	@Override
	public CurrentPeriodInfo[] getPeriodDetails() {
		return this.periodDetails;
	}

	@Override
	public void setPeriodDetails(CurrentPeriodInfo[] periodDetails) {
		this.periodDetails = periodDetails;
	}

	public Map<SoftKeyType, CashierID> getOverrideCashierIDs() {
		Map<SoftKeyType, CashierID> overrideCashierIDs = new HashMap<>();
		overrideCashierIDs.put(softKeyType, overrideCashierID);
		return overrideCashierIDs;
	}

	public void addOverrideCashierID(SoftKeyType key, CashierID overrideCashierID) {
		this.softKeyType = key;
		this.overrideCashierID = overrideCashierID;
	}

	@Override
	public boolean isAttendantTransaction() {
		return attendantTransaction;
	}

	@Override
	public void setAttendantTransaction(boolean attendantTransaction) {
		this.attendantTransaction = attendantTransaction;
	}
}
