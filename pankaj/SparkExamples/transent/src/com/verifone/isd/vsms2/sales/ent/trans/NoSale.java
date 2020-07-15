/*
 * Transaction.java
 *
 * Created on February 12, 2003, 2:59 PM
 */

package com.verifone.isd.vsms2.sales.ent.trans;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.verifone.isd.vsms2.sales.ent.softkey.SoftKeyType;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/** An entity to represent a 'No sale' transaction.
 * @author David_E3
 */
public class NoSale implements ITransaction {

	private static final long serialVersionUID = 1230019151529929309L;

	/** Holds value of property transactionType. */
    private TransactionType transactionType;
    
    private static final MoneyAmount ZERO_AMT = new MoneyAmount(0);
    
    /** Holds value of property endTime.   */
    private long endTime;
    
    /** Holds value of property posID.  */
    private PosID posID;
    
    /** Holds value of property drwNum.   */
    private DrawerID drwNum;
    
    private TransNum transNum;
    
    /** Holds value of property CashierID.   */
    private CashierID cashierID;
    
    /** Holds value of property helpCashierID.  */
    private CashierID overrideCashierID;
    
    /** Holds value of property beginTime.   */
    private long beginTime;
    
    /** Holds value of property suspended. */
    private boolean suspended;
    
    /** Utility field holding list of EventListeners. */
    private transient java.util.ArrayList listenerList;
    
    /* property to indicate if customer copy needs to be printed */
    /* property to indicate the cashier name - required for receipt reprint */
    private String cashierName;
    
    /* property to indicate the cashier period (sequence number) - required for cashier reports */
    private int cashierPeriodSeq;
    
    /** Holds value of property desc. */
    private String desc;
    
    /** Holds value of property reference. */
    private String reference;
    
    /** Holds value of property transactionTime. */
    private long transactionTime;
    
    /** Holds value of property tillID. */
    private TillID tillID;
    
    /*Unique global txn sequence number, not restricted to the register number*/
    private long uniqueTxnSeqNum;

	private String storeNumber;

	private CurrentPeriodInfo[] periodDetails;
    
    /** Creates a new instance of TillAdjustment */
    public NoSale() {
        this.listenerList = new java.util.ArrayList();
    }
    
    /** Getter for property transactionType.
     * @return Value of property transactionType.
     */
    public TransactionType getTransactionType() {
        return this.transactionType;
    }
    
    /** Setter for property transactionType.
     * @param transactionType New value of property transactionType.
     */
    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
    
    /** Getter for property beginTime.
     * @return Value of property beginTime.
     */
    public Date getBeginTime() {
        return new Date(this.beginTime);
    }
    
    /** Getter for transaction number
     * @return transaction number
     */
    public TransNum getTransNum() {
        return this.transNum;
    }
    
    /** Setter for property endTime.
     * @param end ending time for the transaction
     */
    public void setEndTime(Date end) {
        this.endTime = end.getTime();
    }
    
    /** Setter for property drwNum.
     * @param drwNum New value of property drwNum.
     */
    public void setDrwNum(DrawerID drwNum) {
        this.drwNum = drwNum;
    }
    /** Getter for property cashierID.
     * @return Value of property cashierID.
     */
    public CashierID getCashierID() {
        return this.cashierID;
    }
    
    /** Setter for property cashierID.
     * @param cashierID ID of the cashier performing the transaction
     */
    public void setCashierID(CashierID cashierID) {
        this.cashierID = cashierID;
    }
    
    /** Getter for property posID.
     * @return Value of property posID.
     */
    public PosID getPosID() {
        return this.posID;
    }
    
    /** Set the transaction number
     * @param transNum transaction number
     */
    public void setTransNum(TransNum transNum) {
        this.transNum = transNum;
    }
    
    /** Setter for property beginTime.
     * @param begin beginning time for the transaction
     */
    public void setBeginTime(Date begin) {
        this.beginTime = begin.getTime();
        this.transactionTime = this.beginTime;
    }
    
    /** Getter for property drwNum.
     * @return Value of property drwNum.
     */
    public DrawerID getDrwNum() {
        return this.drwNum;
    }
    
    
    /** Getter for property endTime.
     * @return Value of property endTime.
     */
    public Date getEndTime() {
        return new Date(this.endTime);
    }
    
    /** Setter for property posID.
     * @param posID New value of property posID.
     */
    public void setPosID(PosID posID) {
        this.posID = posID;
    }
    
    /** Getter for property suspended. Always returns false. Suspend of this txn not allowed
     * @return Value of property suspended.
     */
    public boolean isSuspended() {
        return false;
    }
    
    public String getCashierName() {
        return this.cashierName;
    }
    
    public void setCashierName(String cashierName) {
        this.cashierName = cashierName;
    }
    
    public int getCashierPeriodSeq() {
        return this.cashierPeriodSeq;
    }
    
    public void setCashierPeriodSeq(int cashierPeriodSeq) {
        this.cashierPeriodSeq = cashierPeriodSeq;
    }
    
    /** Registers ITransactionListener to receive events.
     * @param listener The listener to register.
     */
    public synchronized void addListener(ITransactionListener listener) {
        if (listenerList == null ) {
            listenerList = new java.util.ArrayList();
        }
        listenerList.remove(listener);        
        listenerList.add(listener);
    }
    
    /**
     * Make operations across all entities in a transaction polymorphic with
     * the abstract visitor class -- all we do is call it's visit() method
     * and pass a reference to our actual type.  The visitor will have a
     * method with a signature that matches our type and automatically use it.
     * Different visitor implementations can be created any time to generate
     * new results against all the known entities in a transaction.
     *
     * <B>NOTE</B> that adding a new data type as an argument to the visit()
     * method means the abstract class (TransactionVisitor) and all the
     * visitor implementations must be updated.  We don't expect to be doing
     * this much.
     *
     * @param		v
     * @exception	Exception
     */
    
    public void acceptVisitor(TransactionVisitor v) throws Exception {
        v.visit(this);
    }
    
    /** Getter for property desc.
     * @return Value of property desc.
     */
    public String getDesc() {
        return this.desc;
    }
    
    /** Setter for property desc.
     * @param desc New value of property desc.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    /** Getter for property reference.
     * @return Value of property reference.
     */
    public String getReference() {
        return this.reference;
    }
    
    /** Setter for property reference.
     * @param reference New value of property reference.
     */
    public void setReference(String reference) {
        this.reference = reference;
    }
    
    /** Getter for property transactionTime.
     * @return Value of property transactionTime.
     */
    public long getTransactionTime() {
        return this.transactionTime;
    }
    
    /** Setter for property transactionTime.
     * @param transactionTime New value of property transactionTime.
     */
    public void setTransactionTime(long transactionTime) {
        this.transactionTime = transactionTime;
    }
    
    /** Getter for property tillID.
     * @return Value of property tillID.
     *
     */
    public TillID getTillID() {
        return this.tillID;
    }
    
    /** Setter for property tillID.
     * @param tillID New value of property tillID.
     *
     */
    public void setTillID(TillID tillID) {
        this.tillID = tillID;
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
		overrideCashierIDs.put(SoftKeyType.NO_SALE,overrideCashierID);
		return overrideCashierIDs;
	}

	public void addOverrideCashierID(SoftKeyType key, CashierID overrideCashierID) {
		this.overrideCashierID = overrideCashierID;
	}

	@Override
	public boolean isAttendantTransaction() {
		return false;
	}

	@Override
	public void setAttendantTransaction(boolean attendantTransaction) {
		// NO sale Not supported for attendant
	}
}
