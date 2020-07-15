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

/** An entity to represent a till adjustment transaction. Some fields are added directly
 *  to this class to avoid subclassing just for a few fields (e.g., payee, serial number
 *  are applicable only to money order payouts)
 * @author David_E3
 */
public class TillAdjustment implements ITransaction {

	private static final long serialVersionUID = 2994384862991967104L;

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
    
    private SoftKeyType softKeyType;
    
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
    
    /** Holds value of property amount. */
    private MoneyAmount amount;
    
    /** Holds value of property mopNum. */
    private int mopNum;
    
    /** Holds value of property mopCode. */
    private int mopCode;
    
    /** Holds value of property desc. */
    private String desc;
    
    /** Holds value of property reference. */
    private String reference;
    
    /** Holds value of property serialNumber. */
    private String serialNumber;
    
    /** Holds value of property payee. */
    private String payee;
    
    /** Holds value of property transactionTime. */
    private long transactionTime;
    
    /** Holds value of property tillID. */
    private TillID tillID;
    
    /** Holds value of property mopName. */
    private String mopName;
    
    /** Holds value of property coinsDispensed. */
    private MoneyAmount coinsDispensed;
	
    //CR3843
    /** Holds the Electronic Safe Device Id */
    private int eSafeId;
    
    private String eSafeDeviceName;
    
    
    /*Unique global txn sequence number, not restricted to the register number*/
    private long uniqueTxnSeqNum;
    
	/** Getter for property e-Safe device Id.
     * @return Id Value of the e-safe device.
     */
    public int getESafeId() {
	return this.eSafeId;
    }

    /** Setter for property e-Safe device Id.
     * @param safeId e-Safe device Id.
     */
    public void setESafeId(int safeId) {
	this.eSafeId = safeId;
    }
    
    /** Getter for property e-Safe device Name.
     * @return Name of the e-safe device.
     */
    public String getESafeDeviceName() {
		return eSafeDeviceName;
	}

    /** Setter for property e-Safe device Name.
     * @param safeName e-Safe device Name.
     */
	public void setESafeDeviceName(String safeDeviceName) {
		eSafeDeviceName = safeDeviceName;
	}
    //CR3843

    /** Holds value of property isPayToInHouseAcct. */
    private boolean payToInHouseAcct;
    
    /** Holds value of optional in-house account name */
    private String inhouseAccountName;
    
    /** Holds value of optional in-house sub account */
    private String inhouseSubAccountNumber;
    
    /** Holds value of in-house account number*/
    private String inhouseAccountNumber;
    
//    code added by tattu for safe drop correction checking
    /** Holds value of property sdrc_amount. */
    private MoneyAmount sdrc_amount;
    /** Creates a new instance of TillAdjustment */
//   code added by tattu for safe drop correction to hold the safe drop ticket value
    private TransNum ticketNum;
    private int periodSeqNum;
    private boolean canCorrectSafeDrop;
    private OriginalSafeDropInfo originalSafeDropInfo;

	private String eSafeOperationType;
	
	// Holds the store number.
	private String storeNumber;

	// Holds the period details.
	private CurrentPeriodInfo[] periodDetails;
	
	 /** The tender code. */
    private String nacsTenderCode;
    
    /** The tender subcode. */
    private String nacsTenderSubcode;
	
    /**
	 * @return the originalSafeDropInfo
	 */
	public OriginalSafeDropInfo getOriginalSafeDropInfo() {
		return originalSafeDropInfo;
	}

	/**
	 * @param originalSafeDropInfo the originalSafeDropInfo to set
	 */
	public void setOriginalSafeDropInfo(OriginalSafeDropInfo originalSafeDropInfo) {
		this.originalSafeDropInfo = originalSafeDropInfo;
	}

	/**
	 * @return the canCorrectSafeDrop
	 */
	public boolean getcanCorrectOriginalSafeDrop() {
		return canCorrectSafeDrop;
	}

	/**
	 * @param canCorrectSafeDrop the canCorrectSafeDrop to set
	 */
	public void setcanCorrectOriginalSafeDrop(boolean canCorrectSafeDrop) {
		this.canCorrectSafeDrop = canCorrectSafeDrop;
	}
	
	
	/**
	 * @return the periodSeqNum
	 */
	public int getPeriodSeqNum() {
		return periodSeqNum;
	}

	/**
	 * @param periodSeqNum the periodSeqNum to set
	 */
	public void setPeriodSeqNum(int periodSeqNum) {
		this.periodSeqNum = periodSeqNum;
	}

	public TillAdjustment() {
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
    
    /** Getter for property overrideCashierID.
     * @return Value of property overrideCashierID; null if no
     * override cashier is involvd in the transaction
     */
    public CashierID getOverrideCashierID() {
        return this.overrideCashierID;
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
    
    /** Setter for property overrideCashierID.
     * @param overrideCashierID override cashier's ID, if any
     */
    public void setOverrideCashierID(CashierID overrideCashierID) {
        this.overrideCashierID = overrideCashierID;
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
    
    /** Getter for property amount.
     * @return Value of property amount.
     */
    public MoneyAmount getAmount() {
        return this.amount;
    }
    
    /** Setter for property amount.
     * @param amount New value of property amount.
     */
    public void setAmount(MoneyAmount amount) {
        this.amount = amount;
    }
    
    /** Getter for property mopNum.
     * @return Value of property mopNum.
     */
    public int getMopNum() {
        return this.mopNum;
    }
    
    /** Setter for property mopNum.
     * @param mopNum New value of property mopNum.
     */
    public void setMopNum(int mopNum) {
        this.mopNum = mopNum;
    }
    
    /** Getter for property mopCode.
     * @return Value of property mopCode.
     */
    public int getMopCode() {
        return this.mopCode;
    }
    
    /** Setter for property mopCode.
     * @param mopCode New value of property mopCode.
     */
    public void setMopCode(int mopCode) {
        this.mopCode = mopCode;
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
    
    /** Getter for property serialNumber.
     * @return Value of property serialNumber.
     */
    public String getSerialNumber() {
        return this.serialNumber;
    }
    
    /** Setter for property serialNumber.
     * @param serialNumber New value of property serialNumber.
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    
    /** Getter for property payee.
     * @return Value of property payee.
     */
    public String getPayee() {
        return this.payee;
    }
    
    /** Setter for property payee.
     * @param payee New value of property payee.
     */
    public void setPayee(String payee) {
        this.payee = payee;
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
    
    /** Getter for property mopName.
     * @return Value of property mopName.
     *
     */
    public String getMopName() {
        return this.mopName;
    }
    
    /** Setter for property mopName.
     * @param mopName New value of property mopName.
     *
     */
    public void setMopName(String mopName) {
        this.mopName = mopName;
    }
    
    /** Getter for property coinsDispensed.
     * @return Returns the coinsDispensed 
     */
    public MoneyAmount getCoinsDispensed() {
        return (this.coinsDispensed == null) ?
    		new MoneyAmount(0) : this.coinsDispensed;
    }

    /** Setter for property coinsDispensed.
     * @param coinsDispensed The coinsDispensed to set 
     */
    public void setCoinsDispensed(MoneyAmount coinsDispensed) {
        this.coinsDispensed = coinsDispensed;
    }
    
    /**
     * @return Returns the payToInHouseAcct.
     */
    public boolean isPayToInHouseAcct() {
        return payToInHouseAcct;
    }
    /**
     * @param payInToInHouseAcct The payInToInHouseAcct to set.
     */
    public void setPayToInHouseAcct(boolean payToInHouseAcct) {
        this.payToInHouseAcct = payToInHouseAcct;
    }
    
	/**
	 * @return Returns the inhouseAccountName.
	 */
	public String getInhouseAccountName() {
		return inhouseAccountName;
	}
	/**
	 * @param inhouseAccountName The inhouseAccountName to set.
	 */
	public void setInhouseAccountName(String inhouseAccountName) {
		this.inhouseAccountName = inhouseAccountName;
	}
public String getInhouseSubAccountNumber() {
		return inhouseSubAccountNumber;
	}

	public void setInhouseSubAccountNumber(String inhouseSubAccountNumber) {
		this.inhouseSubAccountNumber = inhouseSubAccountNumber;
	}

	public String getInhouseAccountNumber() {
		return inhouseAccountNumber;
	}

	public void setInhouseAccountNumber(String inhouseAccountNumber) {
		this.inhouseAccountNumber = inhouseAccountNumber;
	}

	//    code added by tattu for safe drop correction
    /** Getter for property amount.
     * @return Value of property amount.
     */
    public MoneyAmount getSdrc_Amount() {
        return this.sdrc_amount;
    }
    
    /** Setter for property amount.
     * @param amount New value of property amount.
     */
    public void setSdrc_Amount(MoneyAmount amount) {
        this.sdrc_amount = amount;
    }
    /** Set the transaction number
     * @param transNum transaction number
     */
    public void setTicketNum(TransNum ticketNum) {
        this.ticketNum = ticketNum;
    }
    
    /** Setter for property beginTime.
     * @param begin beginning time for the transaction
     */
    public TransNum getTicketNum() 
    {
        return this.ticketNum;
    }

	public String getESafeOperationType() {
		return eSafeOperationType;
	}

	public void setESafeOperationType(String safeOperationType) {
		eSafeOperationType = safeOperationType;
	}


	/**
	 * @return the uniqueTxnSeqNum
	 */
	public long getUniqueTxnSeqNum() {
		return uniqueTxnSeqNum;
	}

	/**
	 * @param uniqueTxnSeqNum the uniqueTxnSeqNum to set
	 */
	public void setUniqueTxnSeqNum(long uniqueTxnSeqNum) {
		this.uniqueTxnSeqNum = uniqueTxnSeqNum;
	}
	
	/**
	 * Returns additional info for Non-sales transactions
	 * @param txn
	 * @return For SafeDrop : Returns MOP used,
	 * For In-House sales : returns InhouseAccountNumber,
	 * For PAYIN/PAYOUT : returns reference number 
	 * 
	 */
	public String getAddInfoForNonSalesTrans() {
		String addInfo ="";
		if(this.getTransactionType() == TransactionType.SAFEDROP){
			addInfo = ((TillAdjustment)this).getMopName();
		}else if(this.getTransactionType() == TransactionType.PAYIN || 
				this.getTransactionType() == TransactionType.PAYOUT){
			if(((TillAdjustment)this).isPayToInHouseAcct()){
				addInfo = ((TillAdjustment)this).getInhouseAccountNumber();
			}else{
				addInfo = ((TillAdjustment)this).getReference();
			}
		}
		return addInfo;
	}

	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sales.ent.trans.ITransaction#getStoreNumber()
	 */
	@Override
	public String getStoreNumber() {
		return this.storeNumber;
	}
	
	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sales.ent.trans.ITransaction#setStoreNumber(java.lang.String)
	 */
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

	public String getNacsTenderCode() {
		return nacsTenderCode;
	}

	public void setNacsTenderCode(String nacsTenderCode) {
		this.nacsTenderCode = nacsTenderCode;
	}

	public String getNacsTenderSubcode() {
		return nacsTenderSubcode;
	}

	public void setNacsTenderSubcode(String nacsTenderSubcode) {
		this.nacsTenderSubcode = nacsTenderSubcode;
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
		return false;
	}

	@Override
	public void setAttendantTransaction(boolean attendantTransaction) {
		// Till transactions currently not supported for attendants
	}
	
}
