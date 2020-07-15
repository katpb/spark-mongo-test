/*
 * ITransaction.java
 *
 * Created on December 13, 2003, 4:36 PM
 */

package com.verifone.isd.vsms2.sales.ent.trans;

import java.util.Map;

import com.verifone.isd.vsms2.sales.ent.softkey.SoftKeyType;

/**
 *
 * @author  Bhanu_N2
 */
public interface ITransaction extends java.io.Serializable {
    static final long serialVersionUID = -4305635434009065353L;
    /** Getter for property transactionType.
     * @return Value of property transactionType.
     */
    public TransactionType getTransactionType();
    
    /** Setter for property transactionType.
     * @param transactionType New value of property transactionType.
     */
    public void setTransactionType(TransactionType transactionType);
    
    /** Getter for transaction number
     * @return transaction number
     */
    public TransNum getTransNum();
    
    /** Set the transaction number
     * @param transNum transaction number
     */
    public void setTransNum(TransNum transNum);    
    
    /** Getter for property endTime.
     * @return Value of property endTime.
     */
    public long getTransactionTime();
        
    /** Setter for property endTime.
     * @param end ending time for the transaction
     */
    public void setTransactionTime(long end);

    /** Getter for property posID.
     * @return Value of property posID.
     */
    public PosID getPosID();
        
    /** Setter for property posID.
     * @param posID New value of property posID.
     */
    public void setPosID(PosID posID);
    
    /** Getter for property cashierID.
     * @return Value of property cashierID.
     */
    public CashierID getCashierID();
    
    /** Setter for property cashierID.
     * @param cashierID ID of the cashier performing the transaction
     */
    public void setCashierID(CashierID cashierID);    
    
    /** Getter for property suspended. 
     * Sales app should explicitly limit suspend to certain transaction types
     * @return Value of property suspended.
     */
    public boolean isSuspended();    
    
    /** Getter for property cashierPeriodSeq.
     * @return Value of property cashierPeriodSeq.
     *
     */
    public int getCashierPeriodSeq();
    
    /** Setter for property cashierPeriodSeq.
     * @param cashierPeriodSeq New value of property cashierPeriodSeq.
     *
     */
    public void setCashierPeriodSeq(int cashierPeriodSeq);

	/**
	 * @return the uniqueTxnSeqNum
	 */
	public long getUniqueTxnSeqNum();

	/**
	 * @param uniqueTxnSeqNum the uniqueTxnSeqNum to set
	 */
	public void setUniqueTxnSeqNum(long uniqueTxnSeqNum);
	
	/**
	 * @return the storeNumber
	 */
	public String getStoreNumber();

	/**
	 * @param storeNumber the storeNumber to set
	 */
	public void setStoreNumber(String storeNumber);

	CurrentPeriodInfo[] getPeriodDetails();

	void setPeriodDetails(CurrentPeriodInfo[] periodDetails);
	
	/**
	 * Returns SoftKeyType related cashier override IDs
	 * 
	 * @return
	 */
	public Map<SoftKeyType, CashierID> getOverrideCashierIDs();
	
	/**
	 * adds override cashier ID for the given SoftKeyType
	 * @param key
	 * @param overrideCashierID
	 */
	public void addOverrideCashierID(SoftKeyType key, CashierID overrideCashierID);
	
	public boolean isAttendantTransaction();
	
	public void setAttendantTransaction(boolean attendantTransaction);
	
}
