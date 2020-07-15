/*
 * Transaction.java
 *
 * Created on February 12, 2003, 2:59 PM
 */

package com.verifone.isd.vsms2.sales.ent.trans;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.net.ent.EntryMethodDef;
import com.verifone.isd.vsms2.net.ent.LoyaltyPreferenceEnum;
import com.verifone.isd.vsms2.sales.ent.fueltax.FuelTaxRcpt;
import com.verifone.isd.vsms2.sales.ent.mop.MopCode;
import com.verifone.isd.vsms2.sales.ent.plu.PluPK;
import com.verifone.isd.vsms2.sales.ent.policy.ReceiptHdr;
import com.verifone.isd.vsms2.sales.ent.policy.ReceiptMessage;
import com.verifone.isd.vsms2.sales.ent.softkey.SoftKeyType;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import com.verifone.isd.vsms2.sys.util.Quantity;


/** An entity to represent a transaction.
 * @author David_E3
 */
public class Transaction implements ITransaction {

	private static final long serialVersionUID = 4576479702206656375L;

	private static final Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sales.ent.trans.Transaction.class);   
	
	/** Holds reference to original fuel prepay transaction */
	private Transaction originalTransaction;

    /** Holds value of property itemLines. */
    private List<ItemLine> itemLines;
    
    /** Holds value of property paymentLines. */
    private List<PaymentLine> paymentLines;
    
    /** Holds value of property changeLines. */
    private Collection<ChangeLine> changeLines;
    
    /** Holds value of property taxLines. */
    private Map<Integer, TaxLine> taxLines;
    
    /** Holds value of property balanceToPay.   */
    private MoneyAmount balanceToPay;
    
    /** Holds value of property totalBeforeTax.   */
    private MoneyAmount totalBeforeTax;
    
	/** Holds value of property totalTax.   */
    private MoneyAmount totalTax;
    
    /** Holds value of property totalWithTax.   */
    private MoneyAmount totalWithTax;
    
    /** Holds value of property preTaxAdjustments.   */
    
    private MoneyAmount preTaxAdjustments;
    
    /** Holds value of property postTaxAdjustments.   */
    
    private MoneyAmount postTaxAdjustments;
    
    /** Holds value of property coinsDispensed.   */
    private MoneyAmount coinsDispensed;
    
    /** Holds value of property transactionType. */
    private TransactionType transactionType;
    
    /** Holds value of property voidTransaction. */
    private boolean voidTransaction;

    /** Holds value of property customerDOB. */
    private Date customerDOB;
    
    /** Customer's age at the time of the transaction */
    private int customerAge;
    
    /** Holds value of property customerDOBSkipped. */
    private boolean customerDOBSkipped;
    
    //DOB masking changes CR6477
    /** Holds value of property ageVerificationPassed. */
    private boolean ageVerificationPassed;
    
    private EntryMethodDef dobEntryMethod;

	/** Holds value of property endTime.   */
    private long endTime;
    
    /** Holds value of property posID.  */
    private PosID posID;
    
    private WorkStationType workStationType;
    
    /** Holds value of property epsWorkstationID.  */
    private PosID epsWorkstationID;
    
    /** Holds value of property drwNum.   */
    private DrawerID drwNum;
    
    private TransNum transNum;
    
    /** Holds value of property CashierID.   */
    private CashierID cashierID;
    
    private Map<SoftKeyType, CashierID> overridenCashierIDMap;
    
    /** Holds value of property beginTime.   */
    private long beginTime;
    
    /** Holds value of property suspended. */
    private boolean suspended;
    
    /** Holds value of property netPayInfoLines. */
    private List<NetPayInfo> netPayInfoLines;
    
    /** Holds value of property svcActInfoLines. */
    private List<SvcActInfo> svcActInfoLines;
    
    /** Utility field holding list of EventListeners. */
    private transient List<ITransactionListener> listenerList;
    
    /* property to indicate if customer copy needs to be printed */
    private boolean prtCCopy;

    /* property to indicate if merchant copy receipt should be printed */
    private boolean prtMerchCopy;

    /* property to indicate the cashier name - required for receipt reprint */
    private String cashierName;
    
    /* property to indicate the cashier period (sequence number) - required for cashier reports */
    private int cashierPeriodSeq;
    
    /** Holds value of property transactionTime. */
    private long transactionTime;
    
    /** Holds value of property tillID. */
    private TillID tillID;
    
    /** Holds value of property carwashValidDays. */
    private int carwashValidDays;
    
    /** Holds value of property cwPaypointNum. */
    private int cwPaypointNum;

    /** Holds value of property popInfo. */
    private PopInfo popInfo;

    /** Holds value of property fiscalInfo. */
    private transient FiscalInfo fiscalInfo;
    
    /** Holds value of property auto codes PopAwardGenDetail */
    private List<PopAwardGenDetail> autoCodeInfo;

    /** Holds value of property auto codes reqCodesNum */
    private int reqCodesNum;

    /** Holds value of property auto codes reqCodesDef */
    private int reqCodesDef;
    
    /** Holds values of property DealInfo */
    private List<DealInfo> dealInfo;
    
    /** Holds values of property spDiscEligibleAmount */
    private MoneyAmount spDiscEligibleAmount;
    
    /** Holds value of property autorefund */
    private boolean autorefund;
    
    /** Holds value of property autoCompleteReceipt */
    private long autoCompleteReceipt;

    /** Holds value of property printed. */
    private boolean printed;

    /** Holds value of property journal printed. */
    private boolean journalPrinted;

    /** Hold value of mobile receipt sent to host*/
    private boolean mobileReceiptProcessed;
    
    /** Holds value of property fastCredit */
    private boolean fastCredit;
    
    /** Holds value of property foodService */
    private boolean foodService;
    
    /** Holds value of property fcMerchSettle */
    private boolean fcMerchSettle;

    /** Holds value of property receiptLines. */
    private List<FuelTaxRcpt> fuelTaxExRcptLines;
    
    private ECheckInfo eCheckInfo;
    
    /**
     * Holds value of property recalledTxnsInfo.
     */
    private List<RecalledTxnInfo> recalledTxnsInfo;    
    
    /**
     * Holds value of property claimedKioskOrders.
     */
    private List<TransNum> claimedKioskOrders;      
    
    /** Holds value of property numCopies. */
    private int numCopies = 0; // Defaults to 0

    private List<PrePaidInfo> prePaidInfoList;

    /** Holds value of property discountInfoList which is used for ticket level discounting. */
    private  List<DiscountInfo> discountInfoList;
    
    /** Merchandise Sales Amount*/
    private int merchandiseSalesCount;
    /** Fuel Sales Amount*/
    private int fuelSalesCount;
    /** Network Loyalty program details */
    private NetLoyaltyData netLoyaltyData;
    
    /** Network secondary Loyalty program details */
    private NetLoyaltyData secNetLoyaltyData;
    /** To link subsequent EPS messages in a transaction */
    private String epsReferenceNumber;
    
    /** this flag is used to determine if a coupon is scanned during the course of a transaction
     It is not persisted as part of transaction commit. */
    private transient boolean couponScanAttempted = false;
    
    /** Ticket reprint security level*/
    private int reprintSecurityLevel;
    
    /* List of fueling messages for a given sequence - before, during, after */
    private Map<FuelingMessageSequence, List<FuelingMessageDetails>> fuelingMessageMap;
    
    /* Collection of conditional discounts that can be removed at a later time */
    private Set<String> conditionalRewards;
    
    /* indicates customer loyalty preference */
    private LoyaltyPreferenceEnum customerLoyaltyPref;
    
    /* indicates receipt messages added by policy feature */
    private Map<String, ReceiptMessage> policyReceiptMessages;

    /* indicates receipt Header added by policy feature */
    private Map<String, ReceiptHdr> policyReceiptHeader;
    
    /* indicates the unpaid transaction that gets completed in background */
    private boolean backgroundCompletion;
    
    /* indicates DOB to be printed on the journal */
    private boolean printDOBonJournal;

	/* indicate if the food service order rung up on the pos will be dine in or not*/
	private DineInDataSet dineInDataSet;

    /*Unique global txn sequence number, not restricted to the register number*/
    private long uniqueTxnSeqNum;

    private boolean placeOrderSuspended = false;

    private List<TransNum> kitchenServiceNums;
    
    /* Indicates reason for a Voided transaction*/
    private VoidReason voidReason;
	
    
    //Holds the canadianGST flag
    private boolean canadianGST;
    
	/** Holds value of property tpppVoucherLines. */
    private List<TpppVoucherInfo> tpppVoucherLines;

    //Holds the VAT flag
    private boolean valueAddedTax;
    
    // Holds the primary currency name.
    private String primaryCurrencyName;
    
    // Holds the store number.
    private String storeNumber;
        
    // Holds the period details data. 
    private CurrentPeriodInfo[] periodDetails;


    /* Signifies this transaction was a 'Drive-Thru' suspended order. */
    private boolean driveThruOrder = false;
	
    private FoodOrderCustomerDetails foodOrderCustomerDetails;
    
    /* Holds the data block of FiscalReceipt  */
    private FiscalReceiptInfo fiscalReceiptInfo;
    
    /* Maximum number of itemLines Supported per transaction*/
    public static final int MAX_ITEM_COUNT = 100;
    public static final int MAX_ITEM_COUNT_WITHOUT_SCANNER = 95;
    /* Receipt flags */
    private boolean printCurrencySymbol = false;
    private boolean itemLineUnitPrice = false;
    private boolean printVerboseTotal = false;
    private boolean printTaxSummary = false;
    private boolean printAllTaxes = false;
    
    private boolean isCRSSent = false;
    
    private boolean totalProcessed = false;
    /**
     * Hold value for Fiscal Tax Exempt Data
     */
    private FiscalTaxExemptInfo fiscalTaxExemptInfo;
    
    private boolean charityPrompted = false;
    
    private boolean attendantTransaction;
    
    private PosID physicalRegisterID;
    
    
    public static enum MANDATORY_PROMPT{
    	DOB,
    	CUSTOMER_NAME,
    	SERIAL_NUMBER;
    }
    
    private Map<MANDATORY_PROMPT, List<ExceptionItem>> promptMap ;
    
    /*Holds the information to enforce ID confirmation when "Force Scan/Swipe Only" flag is set*/
    private IDRestrictionDetails iDRestrictionDetails;
    
    /**
     * Holds PLUs Transaction Quantity Limit
     */
    private Map<PluPK, Quantity> pluMaxQtyPerTransMap;
    /**
     * Holds Departments Transaction Quantity Limit
     */
    private Map<Integer, Quantity> deptMaxQtyPerTransMap;

	/**
	 * Set of departments that are not supposed to mix with departments outside
	 * of this set in the same transaction. Populated by the Restrited Department
	 * action in Rule Manager. It has to be populated at the beginning of the transaction
	 * with the first item.
	 */
	private final Set<Integer> restrictDept;

    public Transaction() {
        this.itemLines = Collections.synchronizedList(new ArrayList<ItemLine>());
        this.paymentLines = Collections.synchronizedList(new ArrayList<PaymentLine>());
        this.changeLines = Collections.synchronizedList(new ArrayList<ChangeLine>());
        this.netPayInfoLines = new ArrayList<NetPayInfo>();
        this.svcActInfoLines = new ArrayList<SvcActInfo>();
        this.taxLines = new ConcurrentHashMap<Integer, TaxLine>();
        this.listenerList = new ArrayList<ITransactionListener>();
        this.prtCCopy = false;
        this.prtMerchCopy = false;
        this.dealInfo = Collections.synchronizedList(new ArrayList<DealInfo>());
        this.autoCodeInfo = Collections.synchronizedList(new ArrayList<PopAwardGenDetail>()); 
        this.recalledTxnsInfo = new ArrayList<RecalledTxnInfo>();
        this.claimedKioskOrders = new ArrayList<TransNum>();
		this.prePaidInfoList = new ArrayList<PrePaidInfo>();
		this.discountInfoList = new ArrayList<DiscountInfo>();
        this.fuelTaxExRcptLines = new ArrayList<FuelTaxRcpt>();
        this.fuelingMessageMap = Collections.synchronizedMap(new EnumMap<FuelingMessageSequence, List<FuelingMessageDetails>>(FuelingMessageSequence.class));
        this.conditionalRewards = new HashSet<String>();
        this.policyReceiptMessages = new HashMap<String, ReceiptMessage>();
        this.policyReceiptHeader = new HashMap<String, ReceiptHdr>();
        this.kitchenServiceNums = new ArrayList<TransNum>();
		this.tpppVoucherLines = new ArrayList<TpppVoucherInfo>(); 
        this.customerLoyaltyPref = LoyaltyPreferenceEnum.UNKNOWN;
        this.foodOrderCustomerDetails = new FoodOrderCustomerDetails();
        this.promptMap =  new EnumMap<MANDATORY_PROMPT, List<ExceptionItem>>(MANDATORY_PROMPT.class);
        this.iDRestrictionDetails = new IDRestrictionDetails();
        this.pluMaxQtyPerTransMap = new ConcurrentHashMap<PluPK, Quantity>();
        this.deptMaxQtyPerTransMap= new ConcurrentHashMap<Integer, Quantity>();
        this.overridenCashierIDMap= new HashMap<>();
        this.restrictDept = new HashSet<>();
	}
    
    /** Getter for property itemLines.
     * @return Value of property itemLines.
     */
    public ItemLine[] getItemLines() {
        return (ItemLine[])this.itemLines.toArray(new ItemLine[0]);
    }
    
	/**
	 * Method to include the sub items (in any and all composite item lines) in the array of item
	 * lines returned.
	 * 
	 * @return array of item lines including any sub items
	 */
	public ItemLine[] getItemsWithSubItems() {
		List<ItemLine> entireList = new ArrayList<ItemLine>();
		ItemLine[] items = this.getItemLines();
		for (ItemLine item: items) {
			entireList.add(item);
			/*
			 * Include sub items from composite item lines
			 */
			ItemLine[] subItems = item.getSubItems();
			for (ItemLine subItem: subItems) {
				entireList.add(subItem);
			}
		}
		return (ItemLine[])entireList.toArray(new ItemLine[0]);
	}
    
    /** Getter for count of itemLines
     * @return number of itemLines. Note that this just returns the
     * collection's length
     */
    public int getItemLineCount() {
        return this.itemLines.size();
    }
    
    /**
     *  Method to return an ItemLine given its index (1 based)
     * @param index index of the ItemLine required
     *  @throws ArrayIndexOutOfBoundsException on invalid index value.
     */
    public ItemLine getItemLineAt(int index) {
        return (ItemLine)this.itemLines.get(index-1);
    }
    
    public int getItemLineIndex(ItemLine obj) {
        int index = this.itemLines.indexOf(obj);
        if (index >= 0)
            index++;
        return index;
    }
    
    /** Add a new item line
     * @param newLine item ine to be added
     */
    public void addItemLine(ItemLine newLine) {
        //Update local total variables
        this.itemLines.add(newLine);
        newLine.setTxnLineIndex(this.itemLines.indexOf(newLine)+1);
        ItemLine voidedLine = newLine.getVoidedItemLine();
        if (voidedLine != null) {
            int voidedIndex = this.itemLines.indexOf(voidedLine);
            if (voidedIndex != -1) {
                newLine.setVoidedLineIndex(voidedIndex+1);
                voidedLine.setVoided(true);
                //Remove any SVC Activation / Recharge tied to the voided line
                Iterator<SvcActInfo> svcNodes = voidedLine.getSvcActLines();
                while (svcNodes.hasNext()) {
                    SvcActInfo svcInfo = svcNodes.next();
                    this.svcActInfoLines.remove(svcInfo);
                }
            }
        } else {
            if (newLine instanceof FuelItemLine) {
                this.fuelSalesCount++;
            } else {
                this.merchandiseSalesCount++;
            }
        }
        
        //Update TransactionInfo's 'total+tax' amount
        this.fireItemChange(TransOperation.ADDITION, newLine);
    }
    
	public void changeItemLine(ItemLine chLine) {
        this.fireItemChange(TransOperation.MODIFICATION, chLine);
	}

	public void changeItemLine(ItemLine[] chLine) {
        this.fireItemChange(TransOperation.MODIFICATION, chLine);
	}

        /** Remove an item line
         * @param remLine item line to be removed
         */
        public void removeItemLine(ItemLine remLine) {
            //Update local total variables 
            boolean itemPresent = this.itemLines.remove(remLine);
            if (itemPresent && (remLine != null)) {
                
				/*
               * If the removed line was not the last line in the transaction, we
               * need to update item line index of the remaining item lines still
               * present in the transaction. Note that the index is 1-based and
               * the item line is no longer in the transaction, hence (count + 1)
               */
              	if (remLine.getTxnLineIndex() != getItemLineCount() + 1) {
                     for (ItemLine item : getItemLines()) {
                           item.setTxnLineIndex(this.itemLines.indexOf(item)+1);
                     }
              	}

                //If the line was a void line, get the original line and mark it un-voided
                ItemLine origVoidedLine = remLine.getVoidedItemLine();
                if (origVoidedLine != null) {
                    origVoidedLine.setVoided(false);
                    
                    /**
                     * If the original item line had SVC activation / recharge items,
                     * add them back to the SvcActInfo collection.
                     */
                    Iterator<SvcActInfo> oldSvcNodes = origVoidedLine.getSvcActLines();
                    while (oldSvcNodes.hasNext()) {
                        SvcActInfo svcInfo =  oldSvcNodes.next();
                        this.svcActInfoLines.add(svcInfo);
                    }
                }   /* voided line */
                else {
                    //Remove any SVC Activation / recharge tied to this line
                    Iterator<SvcActInfo> svcNodes = remLine.getSvcActLines();
                    while (svcNodes.hasNext()) {
                        SvcActInfo svcInfo = svcNodes.next();
                        this.svcActInfoLines.remove(svcInfo);
                    }
                }
                // Update TransactionInfo's 'total+tax' amount
				this.fireItemChange(TransOperation.REMOVAL, remLine);
            }
            if (remLine instanceof FuelItemLine) {
                this.fuelSalesCount--;
            } else {
                this.merchandiseSalesCount--;
            }
        }
    
    /**
	 * Getter for property paymentLines.
	 * 
	 * @return Value of property paymentLines.
	 */
    public PaymentLine[] getPaymentLines() {
        return (PaymentLine[])this.paymentLines.toArray(new PaymentLine[0]);
    }
    
    /** Getter for count of paymentLines
     * @return number of paymentLines. Note that this just returns the
     * collection's length
     */
    public int getPaymentLineCount() {
        return this.paymentLines.size();
    }
    
    /**
     *  Method to return an Payment given its index (1 based)
     * @param index index of the Payment required
     *  @throws ArrayIndexOutOfBoundsException on invalid index value.
     */
    public PaymentLine getPaymentLineAt(int index) {
        return (PaymentLine)this.paymentLines.get(index-1);
    }
    
    public int getPaymentLineIndex(PaymentLine obj) {
        int index = this.paymentLines.indexOf(obj);
        if (index >= 0)
            index++;
        return index;
    }
    
    /** Add new payment line
     * @param newLine New payment lines to be added
     */
    public void addPaymentLine(PaymentLine newLine) {
        //add paymentLine to the list
        this.paymentLines.add(newLine);
        try {
        this.firePaymentChange(TransOperation.ADDITION, newLine);
        } catch (PaymentLineException ple) {
            logger.error( "Payment line addition being vetoed. "
                    + ple.getMessage());
            //remove paymentLine from the list
            this.paymentLines.remove(newLine);
        }
    }
    
    /** Remove a payment line
     * @param remLine payment line to be removed
     */
    public void removePaymentLine(PaymentLine remLine) {
        //remove paymentLine from the list
        this.paymentLines.remove(remLine);
        try {
        this.firePaymentChange(TransOperation.REMOVAL, remLine);
        } catch (PaymentLineException ple) {
            logger.error( "Payment line removal being vetoed. "
                    + ple.getMessage());
            //add paymentLine back to the list
            this.paymentLines.add(remLine);
        }
    }
    
    /** Getter for property changeLines.
     * @return Value of property changeLines.
     */
    public ChangeLine[] getChangeLines() {
        return (ChangeLine[])this.changeLines.toArray(new ChangeLine[0]);
    }
    
    /** Add new change line
     * @param newLine new change line to be added
     */
    public void addChangeLine(ChangeLine newLine) {
        this.changeLines.add(newLine);
        this.fireChangeLineChange(TransOperation.ADDITION, newLine);        
    }
    
    /** Remove a change line
     * @param remLine change line to be removed
     */
    public void removeChangeLine(ChangeLine remLine) {
        this.changeLines.remove(remLine);
        this.fireChangeLineChange(TransOperation.REMOVAL, remLine);        
    }
    
    /** Getter for property taxLines.
     * @return Value of property taxLines.
     */
    public TaxLine[] getTaxLines() {
        return this.taxLines.values().toArray(new TaxLine[0]);
    }
    
    /** Getter for taxLine for the specified tax id.
     * @return taxLine for a given tax id
     */
    public TaxLine getTaxLine(int taxNr) {
        return this.taxLines.get(taxNr);        
    }
    
    /** Add a new taxLine
     * @param taxLine New taxLine to be added
     */
    public void setTaxLine(TaxLine taxLine) {
        this.taxLines.put(taxLine.getTaxNum(), taxLine);
    }
    
    /** Add a new taxLine
     * @param taxLine New taxLine to be added
     */
    public void addTaxLine(TaxLine taxLine) {
    	int key = taxLine.getTaxNum();
        TaxLine curT = (TaxLine) this.taxLines.get(key);
        if (curT == null) {
            this.taxLines.put(key, taxLine);
        }
        else {
            curT.add(taxLine);
        }
    }
    
    /** Remove a taxLine
     * @param taxLine to be removed
     */
    public void removeTaxLine(TaxLine taxLine) {
        int key = taxLine.getTaxNum();
        TaxLine curT = (TaxLine) this.taxLines.get(key);
        if (curT != null) {
            curT.remove(taxLine);
            if (curT.isEmpty()) {
                this.taxLines.remove(key);
            }
        }
    }
    
    /** Getter for property netPayInfoLines.
     * @return Value of property netPayInfoLines.
     */
    public NetPayInfo[] getNetPayInfoLines() {
        return (NetPayInfo[])this.netPayInfoLines.toArray(new NetPayInfo[0]);
    }
    
    /** Getter for count of netPayInfoLines
     * @return number of InfoLines. Note that this just returns the
     * collection's length
     */
    public int getNetPayInfoLineCount() {
        return this.netPayInfoLines.size();
    }
    
    /** Add a new Network Payment Info
     * @param newLine Network Payment Info to be added
     */
    public void addNetPayInfoLine(NetPayInfo newLine) {
        
        this.netPayInfoLines.add(newLine);
    }
    
    /** Remove a Network Payment Info
     * @param remLine Network Payment Info to be removed
     */
    public void removeNetPayInfoLine(NetPayInfo remLine) {
        this.netPayInfoLines.remove(remLine);
    }
    
    /**
     * Method to obtain the number of network payment lines that need to
     * be voided if a split tender is followed by void ticket.
     *
     * @return number of paylines to be voided
     */
    public int getVoidNetPayCount() {
        int count = 0;
        Iterator<NetPayInfo> nodes = this.netPayInfoLines.iterator();
        
        while (nodes.hasNext()) {
            NetPayInfo netInfo = nodes.next();
            if (netInfo.isVoidInVoid()) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Method to obtain the NetPayInfo line at a given array index
     *
     * @param index - array index
     * @return NetPayInfo
     */
    public NetPayInfo getNetPayInfo(int index) {
        NetPayInfo netInfo = null;
        
        if ((index >= 0) && (index < this.netPayInfoLines.size())) {
            netInfo = (NetPayInfo) this.netPayInfoLines.get(index);
        }
        
        return netInfo;
    }
    
    /**
	 * Method to obtain a reference to the next network payment line for which a
	 * void request needs to be sent to the network host. This is primarily used
	 * for generating refunds to SV cards when a transaction involving split
	 * payments and SV cards is cancelled using void ticket.
	 * 
	 * @return NetPayInfo
	 */
	public NetPayInfo getNextVoidNetPay() {
		NetPayInfo netInfo = null;
		NetPayInfo[] netLines = this.getNetPayInfoLines();
		for (int i = 0; i < netLines.length; i++) {
			if (netLines[i].isVoidInVoid()) {
				netInfo = netLines[i];
				break;
			}
		}
		return netInfo;
	}
	
	/**
	 * Return reference to the next payment reversal which is pending due to EPS
	 * being offline.
	 * 
	 * @return reference to first pending payment reversal, null otherwise
	 */
	public NetPayInfo getNextPendingPaymentReversal() {
		NetPayInfo netInfo = null;
		for (NetPayInfo netLine : getNetPayInfoLines()) {
			if (netLine.isReversalPending()) {
				netInfo = netLine;
				break;
			}
		}
		return netInfo;
	}
    
    /**
	 * Getter for property svcActInfoLines.
	 * 
	 * @return Value of property svcActInfoLines.
	 */
    public SvcActInfo[] getSvcActInfoLines() {
        return (SvcActInfo[])this.svcActInfoLines.toArray(new SvcActInfo[0]);
    }
    
    /** Getter for count of svcActInfoLines
     * @return number of InfoLines. Note that this just returns the
     * collection's length
     */
    public int getSvcActInfoLineCount() {
        return this.svcActInfoLines.size();
    }
    
    /**
     * Method to obtain the SvcActInfo line at a given array index
     *
     * @param index - array index
     * @return SvcActInfo
     */
    public SvcActInfo getSvcActInfo(int index) {
        SvcActInfo svcInfo = null;
        
        if ((index >= 0) && (index < this.svcActInfoLines.size())) {
            svcInfo = (SvcActInfo) this.svcActInfoLines.get(index);
        }
        
        return svcInfo;
    }
    
    /**
	 * Return a reference to the next pending primary network<code>SvcActInfo</code> object if there are any in the list or else it returns the 
	 * next pending EPS Prepaid<code>SvcActInfo</code>
	 * which is waiting to be activated / recharged
	 * 
	 * @return The next pending SvcActInfo object
	 */
	public SvcActInfo getNextPendingSvc() {
		SvcActInfo svcInfo = null;
		SvcActInfo firstEps = null;
		SvcActInfo[] svcLines = this.getSvcActInfoLines();
		for (int i = 0; i < svcLines.length; i++) {
			if (svcLines[i].getSvcStatus() == SvcActInfo.SVC_REQ_PENDING) {
				svcInfo = svcLines[i];
				if(!svcInfo.isEpsPrepaid()){
					return svcInfo;
				}else{
					if(firstEps == null){
						firstEps = svcInfo;
					}
				}
			}
		}
		return firstEps;
	}
    /**
	 * Method to obtain the number of SVC Activation / Recharge operations which
	 * are pending within this transaction. This will be used by SALES to
	 * initiate a completion after the transaction is paid for.
     *
     * @return int - number of SVC activation / recharge operations pending
     */
    public int getPendingSvcLineCount() {
        int count = 0;
        Iterator<SvcActInfo> nodes = this.svcActInfoLines.iterator();
        
        while (nodes.hasNext()) {
            SvcActInfo svcInfo =  nodes.next();
            if (svcInfo.getSvcStatus() == SvcActInfo.SVC_REQ_PENDING) {
                count++;
            }
        }
        
        return count;
    }   
    
    /**
	 * Method to obtain the count of successful prepaid activation / recharge in
	 * the transaction. In case of a void ticket triggered by a failed
	 * activation / recharge, we will need to reverse any successful activation /
	 * reachrge prior to that.
	 * 
	 * @return The successful count
	 */
	public int getSvcSuccessCount() {
		int count = 0;
		Iterator<SvcActInfo> nodes = this.svcActInfoLines.iterator();
		while (nodes.hasNext()) {
			SvcActInfo svcInfo = nodes.next();
			if (svcInfo.getSvcStatus() == SvcActInfo.SVC_REQ_SUCCESSFUL) {
				count++;
			}
		}
		return count;
	}
	
    /**
	 * Method to obtain the count of failed prepaid activation / recharge in
	 * the transaction. 
	 * @return The successful count
	 */
	public int getSvcFailureCount() {
		int count = 0;
		Iterator<SvcActInfo> nodes = this.svcActInfoLines.iterator();
		while (nodes.hasNext()) {
			SvcActInfo svcInfo = (SvcActInfo) nodes.next();
			if (svcInfo.getSvcStatus() == SvcActInfo.SVC_REQ_FAILED || (svcInfo.getSvcStatus() == SvcActInfo.SVC_REV_PENDING)) {
				count++;
			}
		}
		return count;
	}
	
	
	
	/**
	 * Return the reference to a successful prepaid activation / recharge item
	 * which needs to be reversed.
	 * 
	 * @return SvcActInfo
	 */
	public SvcActInfo getNextVoidActivation() {
		SvcActInfo svcInfo = null;
		SvcActInfo[] svcLines = this.getSvcActInfoLines();
		for (int i = 0; i < svcLines.length; i++) {
			if (svcLines[i].getSvcStatus() == SvcActInfo.SVC_REQ_SUCCESSFUL) {
				svcInfo = svcLines[i];
				break;
			}
		}
		return svcInfo;
	}
	
	/**
	 * Return the reference to the next pending activation reversal due to EPS
	 * being offline.
	 * 
	 * @return next activation item to reverse, null otherwise
	 */
	public SvcActInfo getNextPendingActivationReversal() {
		SvcActInfo svcInfo = null;
		for (SvcActInfo svcLine : getSvcActInfoLines()) {
			if (svcLine.getSvcStatus() == SvcActInfo.SVC_REV_PENDING) {
				svcInfo = svcLine;
				break;
			}
		}
		return svcInfo;
	}
    
    /**
	 * Add a new SVC Activation line
	 * 
	 * @param newLine
	 *            SVC Activation Info to be added
	 */
    public void addSvcActInfoLine(SvcActInfo newLine) {
    	this.svcActInfoLines.remove(newLine);
        this.svcActInfoLines.add(newLine);
    }
    
    /** Remove an existing SVC activation line
     * @param remLine SVC activation Info to be removed
     */
    public void removeSvcActInfoLine(SvcActInfo remLine) {
        this.svcActInfoLines.remove(remLine);
    }
    
    /** Getter for property balanceToPay.
     * @return Value of property balanceToPay.
     */
    public MoneyAmount getBalanceToPay() {
        return (this.balanceToPay == null) ? new MoneyAmount(0) : this.balanceToPay;
    }
    
	/**
	 * Convenience method to compute balance due amount based on existing fields
	 * 
	 * @return the balance due amount of the transaction
	 */
	public MoneyAmount computeBalanceDueAmount() {
		MoneyAmount balance = new MoneyAmount(getTotalWithTax());
		/*
		 * Ticket level discounts are not part of total with tax
		 */
		balance.add(getAllDiscountTotal());
		/*
		 * Payment fees (e.g. cashback fees) should be added to the balance due
		 */
		balance.add(getPaymentFees());
		/*
		 * Collected payment includes amount from all payment lines minus the
		 * amount from all the change lines
		 */
		balance.sub(getCollectedPayment());
		return balance;
	}
	
	/**
	 * Convenience method to compute balance due amount based on existing fields
	 * 
	 * @return the balance due amount of the transaction
	 */
	public MoneyAmount computeBalanceDueAmountWithPreauth() {
		MoneyAmount balance = new MoneyAmount(getTotalWithTax());
		/*
		 * Ticket level discounts are not part of total with tax
		 */
		balance.add(getAllDiscountTotal());
		/*
		 * Payment fees (e.g. cashback fees) should be added to the balance due
		 */
		balance.add(getPaymentFees());
		/*
		 * Collected payment includes amount from all payment lines minus the
		 * amount from all the change lines
		 */
		balance.sub(getCollectedPaymentWithPreauth());
		return balance;
	}
    
    /** Getter for property totalBeforeTax.
     * @return Value of property totalBeforeTax.
     */
    public MoneyAmount getTotalBeforeTax() {
        return (this.totalBeforeTax == null) ? new MoneyAmount(0) : this.totalBeforeTax;
    }
    
    /** Getter for property totalTax.
     * @return Value of property totalTax.
     */
    public MoneyAmount getTotalTax() {
        return (this.totalTax == null) ? new MoneyAmount(0) : this.totalTax;
    }
    
    /** Getter for property totalWithTax.
     * @return Value of property totalWithTax.
     */
    public MoneyAmount getTotalWithTax() {
        return (this.totalWithTax == null) ? new MoneyAmount(0) : this.totalWithTax;
    }

	/** Getter for property preTaxAdjustments.
	 * @return Value of propert postTaxAdjustments
	 */
    public MoneyAmount getPreTaxAdjustments() {
        return (this.preTaxAdjustments == null) ?
			new MoneyAmount(0) : this.preTaxAdjustments;
    }
    
	/** Getter for property postTaxAdjustments.
	 * @return Value of property postTaxAdjustments.
	 */
    public MoneyAmount getPostTaxAdjustments() {
        return (this.postTaxAdjustments == null) ?
			new MoneyAmount(0) : this.postTaxAdjustments;
    }
    
    /** Getter for property coinsDispensed.
     * @return Returns the coinsDispensed 
     */
    public MoneyAmount getCoinsDispensed() {
        return (this.coinsDispensed == null) ?
    		new MoneyAmount(0) : this.coinsDispensed;
    }
    
    /** Setter for property balanceToPay.
     * @param balanceToPay New value of property balanceToPay.
     */
    public void setBalanceToPay(MoneyAmount balanceToPay) {
        this.balanceToPay = balanceToPay;
    }
    
    /** Setter for property totalBeforeTax.
     * @param totalBeforeTax New value of property totalBeforeTax.
     */
    public void setTotalBeforeTax(MoneyAmount totalBeforeTax) {
        this.totalBeforeTax = totalBeforeTax;
    }
    
    /** Setter for property totalTax.
     * @param totalTax New value of property totalTax.
     */
    public void setTotalTax(MoneyAmount totalTax) {
        this.totalTax = totalTax;
    }
    
    /** Setter for property totalWithTax.
     * @param totalWithTax New value of property totalWithTax.
     */
    public void setTotalWithTax(MoneyAmount totalWithTax) {
        this.totalWithTax = totalWithTax;
    }
    
	/** Setter for property preTaxAdjustments.
	 * @param preTaxAdjustments New value of property preTaxAdjustments.
	 */
    public void setPreTaxAdjustments(MoneyAmount preTaxAdjustments) {
        this.preTaxAdjustments = preTaxAdjustments;
    }
    
	/** Setter for property postTaxAdjustments.
	 * @param postTaxAdjustments New value of property preTaxAdjustments.
	 */
    public void setPostTaxAdjustments(MoneyAmount postTaxAdjustments) {
        this.postTaxAdjustments = postTaxAdjustments;
    }
    
    /** Setter for property coinsDispensed.
     * @param coinsDispensed The coinsDispensed to set 
     */
    public void setCoinsDispensed(MoneyAmount coinsDispensed) {
        this.coinsDispensed = coinsDispensed;
    }

    /** Getter for property transactionType.
     * @return Value of property transactionType.
     */
    @Override
	public TransactionType getTransactionType() {
        return this.transactionType;
    }
    
    /** Setter for property transactionType.
     * @param transactionType New value of property transactionType.
     */
    @Override
	public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
    
    /** Getter for property voidTransaction.
     * @return Value of property voidTransaction.
     */
    public boolean isVoidTransaction() {
        return this.voidTransaction;
    }
    
    /** Setter for property voidTransaction.
     * @param voidTransaction New value of property voidTransaction.
     */
    public void setVoidTransaction(boolean voidTransaction) {
        this.setVoidTransaction(voidTransaction, null);
    }
    
    /** Getter for property customerDOB.
     * @return Value of property customerDOB.
     */
    public Date getCustomerDOB() {
        return this.customerDOB;
    }
    
    /** Setter for property customerDOB.
     * @param customerDOB New value of property customerDOB.
     */
    public void setCustomerDOB(Date customerDOB) {
        this.customerDOB = customerDOB;
        if (customerDOB != null) {
        	this.customerAge = getAge(customerDOB);
        }
    }
    
	/**
	 * Determine customer's age depending on date of birth if available.
	 * Otherwise return the minimum eligible age for purchasing all items in the
	 * transaction.
	 * 
	 * @return customer's age if available, otherwise return minimum age for
	 *         purchase
	 */
    public int getCustomerAge() {
		return (customerAge != 0) ? customerAge : getMinimumAgeForPurchase();
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}

	/** Getter for property customerDOBSkipped.
     * @return Value of property customerDOBSkipped.
     */
    public boolean isCustomerDOBSkipped() {
        return this.customerDOBSkipped;
    }
    
    /** Setter for property customerDOBSkipped.
     * @param customerDOBSkipped New value of property customerDOBSkipped.
     */
    public void setCustomerDOBSkipped(boolean customerDOBSkipped) {
        this.customerDOBSkipped = customerDOBSkipped;
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
    @Override
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
    @Override
	public CashierID getCashierID() {
        return this.cashierID;
    }
    
    /** Setter for property cashierID.
     * @param cashierID ID of the cashier performing the transaction
     */
    @Override
	public void setCashierID(CashierID cashierID) {
        this.cashierID = cashierID;
    }
    
    /** Getter for property posID.
     * @return Value of property posID.
     */
    @Override
	public PosID getPosID() {
        return this.posID;
    }
    
    /** Set the transaction number
     * @param transNum transaction number
     */
    @Override
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
    @Override
	public void setPosID(PosID posID) {
        this.posID = posID;
        this.workStationType = WorkStationType.getWorkstationType(posID.getId());
    }
    
    /** Getter for property WorkStationType.
     * @return Value of property WorkStationType.
     */
    public WorkStationType getWorkStationType() {
		return workStationType;
	}

    /** Setter for property WorkStationType.
     * @param WorkStationType New value of property WorkStationType.
     */
	public void setWorkStationType(WorkStationType workStationType) {
		this.workStationType = workStationType;
	}

    /**
	 * @return the epsWorkstationID
	 */
	public PosID getEpsWorkstationID() {
		return epsWorkstationID;
	}

	/**
	 * @param epsWorkstationID the epsWorkstationID to set
	 */
	public void setEpsWorkstationID(PosID epsWorkstationID) {
		this.epsWorkstationID = epsWorkstationID;
	}

	/** Method left for backward compatibility. Getter for property recalledTxnInfo. 
     * @return the first recalled transaction info from the collection of recalled txn info.
     */
    public RecalledTxnInfo getRecalledTxnInfo() {
        return (this.recalledTxnsInfo.size() > 0) ? (RecalledTxnInfo)this.recalledTxnsInfo.get(0) : null;
    }
    
    /** Method left for backward compatibility. Setter for property recalledTxnInfo.
     * Clears the collection of recalled txn info and adds the passed recalled txn info 
     * as the first entry in the collection.
     * @param recalledTxnInfo New value of property recalledTxnInfo.
     */
    public void setRecalledTxnInfo(RecalledTxnInfo recalledTxnInfo) {
        this.recalledTxnsInfo.clear();
		if (recalledTxnInfo != null) {
        	this.recalledTxnsInfo.add(recalledTxnInfo);
		}
    }
    
    /** Getter for property suspended.
     * @return Value of property suspended.
     */
    @Override
	public boolean isSuspended() {
        return this.suspended;
    }
    
    /** Setter for property suspended.
     * @param suspended New value of property suspended.
     */
    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }
    
    /** Getter for property prtCCopy.
     * @return Value of property prtCCopy.
     */
    public boolean isPrtCCopy() {
    	if(isPrintRequired()){
    		return true;
    	}
    	else{
    		return this.prtCCopy;
    	}
    }
    
    /** Setter for property prtCCopy.
     * @param prtCCopy New value of property prtCCopy.
     */
    public void setPrtCCopy(boolean prtCCopy) {
        this.prtCCopy = prtCCopy;
    }
    
    /** Getter for property prtMerchCopy.
     * @return Value of property prtMerchCopy.
     */
    public boolean getPrtMerchCopy() {
        return this.prtMerchCopy;
    }
    
    /** Setter for property prtMerchCopy.
     * @param prtMerchCopy New value of property prtMerchCopy.
     */
    public void setPrtMerchCopy(boolean prtMerchCopy) {
        this.prtMerchCopy = prtMerchCopy;
    }
    
    @Override
	public int getCashierPeriodSeq() {
        return this.cashierPeriodSeq;
    }
    
    @Override
	public void setCashierPeriodSeq(int cashierPeriodSeq) {
        this.cashierPeriodSeq = cashierPeriodSeq;
    }

    /** Getter for property numCopies.
     * @return Value of property numCopies.
     */
    public int getNumCopies() {
        return this.numCopies;
    }

    /** Setter for property numCopies.
     * @param numCopies New value of property numCopies.
     */
	public void setNumCopies(int numCopies) {
		/*
         * Do not allow a feature to decrement the number of copies required by
         * another feature.
         */

		if (numCopies > this.numCopies) {
			this.numCopies = numCopies;
		}
	}
    
    /** Registers ITransactionListener to receive events.
     * @param listener The listener to register.
     */
    public synchronized void addListener(ITransactionListener listener) {
        if (listenerList == null ) {
            listenerList = new ArrayList<ITransactionListener>();
        }
        listenerList.remove(listener);        
        listenerList.add(listener);
    }
    
    /** Removes ITransactionListener from the list of listeners.
     * @param listener The listener to remove.
     */
    public synchronized void removeListener(ITransactionListener listener) {
        if (listenerList != null ) {
            listenerList.remove(listener);
        }
    }
    
    private void firePaymentChange(TransOperation op, PaymentLine modPmt) throws PaymentLineException {
        if (this.listenerList != null) {
            ITransactionListener[] listnrs = (ITransactionListener[]) this.listenerList
                    .toArray(new ITransactionListener[0]);
            for (int i = 0; i < listnrs.length; i++) {
                try {
                listnrs[i].notifyPaymentLineChange(op, modPmt);
                } catch (PaymentLineException ple) {
                    logger.error( "Payment line change being vetoed. " + ple.getMessage());
                    throw ple;
                }
            }
        }
    }
    
    private void fireChangeLineChange(TransOperation op, ChangeLine modChg) {
        if (this.listenerList != null) {
            ITransactionListener[] listnrs = (ITransactionListener[])this.listenerList.
            toArray(new ITransactionListener[0]);
            for (int i = 0; i < listnrs.length; i++) {
                listnrs[i].notifyChangeLineChange(op, modChg);
            }
        }
    }    
    
    private void fireItemChange(TransOperation op, ItemLine modItem) { 
        if (this.listenerList != null) {
            ITransactionListener[] listnrs = (ITransactionListener[])this.listenerList.
            toArray(new ITransactionListener[0]);
            for (int i = 0; i < listnrs.length; i++) {
                listnrs[i].notifyItemLineChange(op, modItem);
            }
        }
    }
    
    private void fireTransactionDiscountChange(TransOperation op, DiscountInfo discountInfo) {
        if (this.listenerList != null) {
            ITransactionListener[] listnrs = (ITransactionListener[])this.listenerList.
            toArray(new ITransactionListener[0]);
            for (int i = 0; i < listnrs.length; i++) {
                listnrs[i].notifyTransactionDiscountChange(op, discountInfo);
            }
        }
    }
    
    public void fireTransactionDealChange(TransOperation op, DealInfo dealInfo) {
        if (this.listenerList != null) {
            ITransactionListener[] listnrs = (ITransactionListener[])this.listenerList.
            toArray(new ITransactionListener[0]);
            for (int i = 0; i < listnrs.length; i++) {
                listnrs[i].notifyTransactionDealChange(op, dealInfo);
            }
        }
    }
    
    /**
     * Apply post fueling tax adjustments from NAXML deals formed before fueling.
     * For example, tax should be charged on any taxable rebate.
     */
    public void applyDuplicateDealTaxes() {
    	for (DealInfo info : getDealInfo()) {
    		if (info.isDuplicate()) {
    			fireTransactionDealChange(TransOperation.ADDITION, info);
    		}
    	}
    }

    
	/**
	 * Notify observers that several item lines changed -- possibly due to
	 * a discount suddenly applicable to many items in a combination.  This
	 * is helful for expensive operations like tax computations, where the
	 * individual item lines can be accumulated and the operation can be
	 * applied at once over the entire values.
	 *
	 * @param	TranOperation
	 * @param	ItemLine[]
	 * @return	void
	 */

    private void fireItemChange(TransOperation op, ItemLine[] modItems) {
        if (this.listenerList != null) {
            ITransactionListener[] listnrs =
				(ITransactionListener[])this.listenerList.toArray(
					new ITransactionListener[0]);

            for (int i = 0; i < listnrs.length; i++) {
                listnrs[i].notifyItemLineChange(op, modItems);
            }
        }
    }
    
    public void fireItemLineModification(ItemLine modifiedItem, ItemLine originalItem) throws ItemLineException {
        int index = this.getItemLineIndex(modifiedItem);
        if (index >= 0) {
            if (this.listenerList != null) {
                ITransactionListener[] listnrs = (ITransactionListener[])this.listenerList.
                toArray(new ITransactionListener[0]);
                for (int i = 0; i < listnrs.length; i++) {
                    try {
                    	listnrs[i].notifyItemLineChange(TransOperation.MODIFICATION, modifiedItem, originalItem);
                    } catch(ItemLineException ile) {
                        logger.error( "Change of item line " + index + " being vetoed. " + ile.getMessage());
                        //replace the modifiedItem from itemLines list with originalItem 
                        this.itemLines.remove(index-1);
                        if((index-1) <= itemLines.size())
                            this.itemLines.add((index-1), originalItem);
                        else
                            this.itemLines.add(originalItem);
                        throw ile;
                    }
                }
            }   
        }
    }
    
    /**
	 * Notify observers that several item lines changed -- possibly due to
	 * a discount suddenly applicable to many items in a combination.  This
	 * is helful for expensive operations like tax computations, where the
	 * individual item lines can be accumulated and the operation can be
	 * applied at once over the entire values.
	 *
	 * @param	modifiedItems a collection of itemlines
	 * @param	originalItems a collection of itemlines
	 */

    public void fireItemLineModification(ItemLine[] modifiedItems,
		ItemLine[] originalItems) {

		/* Ensure all item lines exist within the transaction */

		for (int i = 0; i < modifiedItems.length; i++) {
        	if (this.getItemLineIndex(modifiedItems[i]) < 0) {
				return;
			}
		}

		/* notify all the observers */

		if (this.listenerList != null) {
			ITransactionListener[] listnrs =
				(ITransactionListener[])this.listenerList.toArray(
					new ITransactionListener[0]);

			for (int i = 0; i < listnrs.length; i++) {
				listnrs[i].notifyItemLineChange(
					TransOperation.MODIFICATION, modifiedItems,
					originalItems);
			}
		}   
    }
    
    private void fireSubItemChange(TransOperation op, ItemLine modCompItem, ItemLine origCompItem, ItemLine subItem) {
        if (this.listenerList != null) {
            ITransactionListener[] listnrs = (ITransactionListener[])this.listenerList.
            toArray(new ITransactionListener[0]);
            for (int i = 0; i < listnrs.length; i++) {
                listnrs[i].notifySubItemChange(op, modCompItem, origCompItem, subItem);
            }
        }
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
    
    /** Getter for property transactionTime.
     * Returns endTime for sales transaction
     * @return Value of property transactionTime.
     */
    @Override
	public long getTransactionTime() {
    	
		if (this.endTime != 0) {
			return endTime;
		}

		return this.transactionTime;
	}
    
    /** Setter for property transactionTime.
     * @param transactionTime New value of property transactionTime.
     */
    @Override
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
    
    /** Getter for property carwashValidDays.
     * @return Value of property carwashValidDays.
     *
     */
    public int getCarwashValidDays() {
        return this.carwashValidDays;
    }
    
    /** Setter for property carwashValidDays.
     * @param carwashValidDays New value of property carwashValidDays.
     *
     */
    public void setCarwashValidDays(int carwashValidDays) {
        this.carwashValidDays = carwashValidDays;
    }
    
    /** Getter for property cwPaypointNum
     * @return Value of property cwPaypointNum.
     *
     */
    public int getCwPaypointNum() {
        return this.cwPaypointNum;
    }
    
    /** Setter for property cwPaypointNum.
     * @param cwPaypointNum New value of property cwPaypointNum.
     *
     */
    public void setCwPaypointNum(int cwPaypointNum) {
        this.cwPaypointNum = cwPaypointNum;
    }
    
    /** Getter for property popInfo.
     * @return Value of property popInfo.
     *
     */
    public PopInfo getPopInfo() {
        return this.popInfo;
    }
    
    /** Setter for property popInfo.
     * @param popInfo New value of property popInfo.
     *
     */
    public void setPopInfo(PopInfo popInfo) {
        this.popInfo = popInfo;
    }

    public FiscalInfo getFiscalInfo() {
        return this.fiscalInfo;
    }
    
    public void setFiscalInfo(FiscalInfo fiscalInfo) {
        this.fiscalInfo = fiscalInfo;
    }
    
    /** Getter for property autoCodeInfo
	 * @return array of all DealInfo entities applied to this transaction.
	 */
	public PopAwardGenDetail[] getAutoCodeInfo() {
		return (PopAwardGenDetail[])autoCodeInfo.toArray(new PopAwardGenDetail[0]);
	}

    /** Getter for property numAutoCodes
	 * @return int of # of auto codes in this transaction.
	 */
	public int getNumAutoCodes() {
		return (autoCodeInfo.size());
	}

    /** Getter for property autoCodeInfo
	 * @return Iterator over autoCodeInfo for all matches applied to
	 * this transaction.
	 */
	public Iterator<PopAwardGenDetail> getAutoCodeInfoIterator() {
		return autoCodeInfo.iterator();
	}

    /** Setter for property autoCodeInfo
	 * @param newdeal particular instance of match added to transaction.
	 */
	public void setAutoCodeInfo(PopAwardGenDetail newAutoCode) {
		autoCodeInfo.add(newAutoCode);
	}

    /** Setter for property autoCodeInfo
	 * @param newAutoCode array of PopAwardGenDetail instances added to transaction.
	 */
	public void setAutoCodeInfo(PopAwardGenDetail[] newAutoCode) {
	    if (newAutoCode != null) {
            for (int i = 0; i < newAutoCode.length; i++) {
                autoCodeInfo.remove(newAutoCode[i]);
            }
		    for (int i = 0; i < newAutoCode.length; i++) {
			    autoCodeInfo.add(newAutoCode[i]);
		    }
        } else {
            autoCodeInfo.clear();
        }
	}

    /** Getter for property reqCodesNum
     * @pararm request Codes Number from user
     */
    public int getReqCodesNum() {
        return this.reqCodesNum;
    }
    
    public void setReqCodesNum(int reqCodesNum) {
        this.reqCodesNum = reqCodesNum;
    }

    /** Getter for property reqCodesDef
     * @pararm request Pop Definition from user
     */
    public int getReqCodesDef() {
        return this.reqCodesDef;
    }

    public void setReqCodesDef(int reqCodesDef) {
        this.reqCodesDef = reqCodesDef;
    }

    public void removeAutoCodeInfo(PopAwardGenDetail oldAutoCode){
		Iterator iterator = autoCodeInfo.iterator();
		while(iterator.hasNext()){
			PopAwardGenDetail autoCodeInfo = (PopAwardGenDetail) iterator.next();
			if( autoCodeInfo.getCodeGenerated().getPopCodeInfo().getCode().equals( 
			    oldAutoCode.getCodeGenerated().getPopCodeInfo().getCode())){
				iterator.remove();
				break;
			}
		}
	}

	/** Getter for property dealInfo
	 * @return array of all DealInfo entities applied to this transaction.
	 */
	public DealInfo[] getDealInfo() {
		return (DealInfo[])dealInfo.toArray(new DealInfo[0]);
	}

	/** Getter for property dealInfo
	 * @return Iterator over dealInfo for all matches applied to
	 * this transaction.
	 */
	public Iterator<DealInfo> getDealInfoIterator() {
		return dealInfo.iterator();
	}

	/** Setter for property dealInfo
	 * @param newdeal particular instance of match added to transaction.
	 */
	public void setDealInfo(DealInfo newdeal) {
	    dealInfo.remove(newdeal);
		dealInfo.add(newdeal);
	}

    
	/** Setter for property dealInfo
	 * @param newdeal array of DealInfo instances added to transaction.
	 */
	public void setDealInfo(DealInfo[] newdeal) {
	    if (newdeal != null) {
            for (int i = 0; i < newdeal.length; i++) {
                dealInfo.remove(newdeal[i]);
            }
		for (int i = 0; i < newdeal.length; i++) {
			dealInfo.add(newdeal[i]);
		}
        } else {
            dealInfo.clear();
        }
	}
	
	public void removeDealInfo(DealInfo oldDeal){
		Iterator iterator = dealInfo.iterator();
		while(iterator.hasNext()){
			DealInfo dealInfo = (DealInfo) iterator.next();
			if(dealInfo.getNaxmlPromoIndex() == oldDeal.getNaxmlPromoIndex()){
				iterator.remove();
				break;
			}
		}
	}
        
    /** @return Returns the spDiscEligibleAmount */
    public MoneyAmount getSpDiscEligibleAmount() {
        return (this.spDiscEligibleAmount == null) ? 
                new MoneyAmount(0) : this.spDiscEligibleAmount;
    }
    
    /** @param spDiscEligibleAmount The spDiscEligibleAmount to set */
	public void setSpDiscEligibleAmount(MoneyAmount spDiscEligibleAmount) {
		this.spDiscEligibleAmount = spDiscEligibleAmount;
	}

	public boolean isAutoRefund() {
		return this.autorefund;
	}

	public void setAutoRefund(boolean refund) {
		this.autorefund = refund;
	}

	public long getAutoCompleteReceipt() {
		return this.autoCompleteReceipt;
	}

	public void setAutoCompleteReceipt(long autoCompleteReceipt) {
		this.autoCompleteReceipt = autoCompleteReceipt;
	}

	public boolean isFastCredit() {
		return this.fastCredit;
	}

	public boolean isFoodService() {
		return this.foodService;
	}
	
	public void setFoodService(boolean fs) {
		this.foodService=fs;
	}
	public void setFastCredit(boolean fc) {
		this.fastCredit = fc;
	}

	public boolean isFcMerchSettle() {
		return this.fcMerchSettle;
	}

	public void setFcMerchSettle(boolean fcms) {
		this.fcMerchSettle = fcms;
	}

	/**
	 * @return the epsReferenceNumber
	 */
	public String getEpsReferenceNumber() {
		return epsReferenceNumber;
	}

	/**
	 * @param epsReferenceNumber the epsReferenceNumber to set
	 */
	public void setEpsReferenceNumber(String epsReferenceNumber) {
		this.epsReferenceNumber = epsReferenceNumber;
	}

	/**
	 * Determine if this transaction has any fuel prepay items with
	 * price-per-gallon (PPG) discount. The discount can be a result of EPS
	 * loyalty or POP discount.
	 * 
	 * @return true if transaction has a fuel prepay item with PPG discount
	 */
	public boolean hasPpgOnPrepay() {
		boolean ppg = false;
		PrepayItemLine prepay = getPrepayItem();
		if (prepay != null) {
			for (DiscountInfo discInfo : prepay.getAllDiscountInfo()) {
				DiscountMode mode = discInfo.getDiscountMode();
				if ((mode == DiscountMode.LOYALTY_PPG_DISCOUNT)
						|| (mode == DiscountMode.POP)) {
					ppg = true;
					break;
				}
			}
		}
		return ppg;
	}

	/**
	 * Method to obtain the fast credit fuel auth item from a transaction.
	 * 
	 * @return the fast credit fuel auth item
	 */
	public PrepayItemLine getFCPrepay() {
		PrepayItemLine theLine = null;
		if (fastCredit) {
			ItemLine[] itemLines = this.getItemLines();
			for (int i = 0; i < itemLines.length; i++) {
				if (itemLines[i] instanceof PrepayItemLine) {
					theLine = (PrepayItemLine) itemLines[i];
					break;
				}
			}
		}

		return theLine;
	}
	/**
	 * 
	 * @return the first fuel item from the transaction
	 */
	public FuelItemLine getFirstFuel() {
		FuelItemLine fuel = null;
		for (ItemLine item : getItemLines()) {
			if (item instanceof FuelItemLine) {
				fuel = (FuelItemLine) item;
				break;
			}
		}
		return fuel;
	}
	
	/**
	 * Return the prepay item line from the transaction
	 * 
	 * @return the first (only) prepay item line from transaction, null if there
	 *         are no prepay items
	 */
	public PrepayItemLine getPrepayItem() {
		PrepayItemLine prepay = null;
		for (ItemLine item : getItemLines()) {
			if (item instanceof PrepayItemLine) {
				prepay = (PrepayItemLine) item;
				break;
			}
		}
		return prepay;
	}
	
	/**
	 * Determine if the transaction is a fuel prepay completion
	 * 
	 * @return true if the transaction is a fuel prepay completion
	 */
	public boolean isFuelPrepayCompletion() {
		boolean completion = false;
		for (ItemLine item : getItemLines()) {
			if ((item instanceof FuelItemLine)
					&& !(item instanceof PrepayItemLine)) {
				FuelItemLine fuelItem = (FuelItemLine) item;
				if (fuelItem.getFuelDeposit().getLongValue() != 0) {
					completion = true;
					break;
				}
			}
		}
		return completion;
	}
	
	/**
	 * Determine if the transaction has an overrun fuel item line
	 * 
	 * @param activeTrans
	 * @return true if the transaction has overrun fuel item line
	 */
	public boolean hasFuelOverrun() {
		return (getOverrunItem() != null);
	}
	
	/**
	 * Return the overrun item line from transaction, if any.
	 * 
	 * @return overrun fuel item if present, null otherwise
	 */
	public OverrunItemLine getOverrunItem() {
		OverrunItemLine overrun = null;
		for (ItemLine item : getItemLines()) {
			if (item instanceof OverrunItemLine) {
				overrun = (OverrunItemLine) item;
				break;
			}
		}
		return overrun;
	}
	
	/**
	 * Determine if a financial advice is pending on the transaction. If the
	 * transaction does not have a PrepayItemLine (this gets replaced by a
	 * FuelItemLine after fueling) but a pre-auth payment line, it indicates a
	 * financial advice needs to be sent for the pre-auth
	 * 
	 * @return true if transaction has a pre-auth payment line after fueling is
	 *         complete
	 */
	public boolean isPendingDcrCompletion() {
		boolean pendingCompletion = false;
		if ((getPrepayItemCount() == 0) && (getFirstPreauthPayment() != null)) {
			pendingCompletion = true;
		}
		return pendingCompletion;
	}
	
	/**
	 * Indicates that the transaction is a continuation of a previous original
	 * transaction (fuel prepay or pay-at-pump). Fuel prepay completions, DCR
	 * overruns and DCR failed completions fall into this category. Note that
	 * this is a convenience method geared for Topaz and the individual parts of
	 * it (fuel prepay completion, overrun, failed completion) should be used
	 * otherwise for those specific scenarios.
	 * 
	 * @return true if transaction cannot be modified at the inside register
	 *         except for tender
	 */
	public boolean isCompletionTransaction() {
		return (isFuelPrepayCompletion() || hasFuelOverrun() || hasFinancialAdvice() || isPendingDcrCompletion());
	}
	
	/**
	 * Determine if any of the payment lines in the transaction is a financial advice
	 * to a previous pre-authorization. In that case, no new items can be added to the
	 * transaction and only tender is allowed.
	 * 
	 * @return true if any of the payment lines indicate a financial advice
	 */
	public boolean hasFinancialAdvice() {
		boolean advice = false;
		for (PaymentLine pLine : getPaymentLines()) {
			if (pLine.isFinancialAdvice()) {
				advice = true;
				break;
			}
		}
		return advice;
	}
	
	/**
	 * Mark pre-existing item lines, payment lines, change lines and discounts
	 * as duplicate in a fuel prepay completion. Create a clone of the fuel
	 * prepay transaction and preserve it as original transaction. This method
	 * is invoked after DCR sales controller is notified about a fuel prepay
	 * completion and before it replaces the prepay item line with a fuel item
	 * line.
	 */
	public void preserveOriginalPrepay() {
		/*
		 * Clone the current transaction into original transaction before
		 * applying any post-fueling changes.
		 */
		this.originalTransaction = getSerializedClone();
		/* Set duplicate attribute on items, payments */
		for (ItemLine item : getItemLines()) {
			if (!(item instanceof FuelItemLine)) {
				item.setDuplicate(true);
				for (DiscountInfo discount : item.getAllDiscountInfo()) {
					discount.setDuplicate(true);
				}
			}
		}
		for (PaymentLine payment : getPaymentLines()) {
			if (!payment.isPreAuthOnly()) {
				payment.setDuplicate(true);
			}
		}
		for (ChangeLine change : getChangeLines()) {
			change.setDuplicate(true);
		}
		for (DiscountInfo discount : getAllDiscountInfo()) {
			discount.setDuplicate(true);
		}
		for (DealInfo dealInform : getDealInfo()) {
			dealInform.setDuplicate(true);
		}
	}
	
	/**
	 * Return a new transaction with the serializable state of the current
	 * transaction. This is primarily used to preserve the original fuel prepay
	 * transaction after fueling is complete.
	 * 
	 * @return a serialized copy of this transaction
	 */
	public Transaction getSerializedClone() {
		Transaction clone = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream objStream = null;
		ObjectInputStream txnObjectStream = null;
		ByteArrayInputStream bis = null;
		try {
			objStream = new ObjectOutputStream(bos);
			objStream.writeObject(this);
			bis = new ByteArrayInputStream(bos.toByteArray());
			txnObjectStream = new ObjectInputStream(bis);
			clone = (Transaction) txnObjectStream.readObject();  
		} catch (Exception e) {
			logger.error("Unable to clone original transaction", e);
		} finally {
			if (objStream != null) {
				try {
					objStream.close();
				} catch (IOException ioe) {
				}
			}
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException ioe) {
				}
			}
			if (txnObjectStream != null) {
				try {
					txnObjectStream.close();
				} catch (IOException ioe) {
				}
			}
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException ioe) {
				}
			}
		}
		return clone;
	}
	
	/**
	 * 
	 * @return number of prepay item lines in the transaction
	 */
	public int getPrepayItemCount() {
		int count = 0;
		ItemLine[] items = this.getItemLines();
		for (int i = 0; i < items.length; i++) {
			if (items[i] instanceof PrepayItemLine) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * 
	 * @return the number of fuel item lines in the transaction
	 */
	public int getFuelItemCount() {
		int count = 0;
		for (ItemLine item : getItemLines()) {
			if (item instanceof FuelItemLine) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Determine if transaction has change due to customer. Exclude duplicate
	 * change lines which were already dispensed. This would be the scenario in
	 * a fuel prepay completion if the original fuel prepay had a change line.
	 * 
	 * @return true if transaction has change due, false otherwise
	 */
	public boolean isChangeDue() {
		boolean changeDue = false;
		for (ChangeLine cl : getChangeLines()) {
			if (!cl.isDuplicate()) {
				changeDue = true;
				break;
			}
		} 
		return changeDue;
	}

	/**
	 * Method to check whether forced customer copy is required to print.
	 * @return
	 */
	public boolean isForceCustomerReceiptPrint(){
		boolean forcedCustomerReceiptPrint = false;
		if(isCarwashTran()){
			forcedCustomerReceiptPrint = true;
		}
		return forcedCustomerReceiptPrint;
	}
	
	public boolean isCarwashTran() {
		boolean carwash = false;
		ItemLine[] items = this.getItemLines();

		for (int i = 0; i < items.length; i++) {
			ItemLine singleItem = items[i];
			if ((singleItem instanceof PluItemLine) && (!singleItem.isVoided())
					&& (singleItem.getVoidedItemLine() == null)) {
				PluItemLine plu = (PluItemLine) singleItem;
				if (plu.isCarwash()) {
					carwash = true;
				}
			}
		}

		return carwash;
	}

	/**
	 * Determine if this ia a force post transaction
	 * 
	 * @return true if there is a payline with FORCE_POST MOP, false otherwise
	 */
	public boolean isForcePost() {
		boolean forcePost = false;
		PaymentLine[] payLines = this.getPaymentLines();
		for (int i = 0; i < payLines.length; i++) {
			if (payLines[i].getMopCode() == MopCode.FORCE_POST) {
				forcePost = true;
				break;
			}
		}
		return forcePost;
	}
	
    /**
    * Method to check MOP is a pumpTest
    * @param curTrans
    * @return TRUE - MOPCODE is PUMP_TEST
    */
    public boolean isPumpTest() {
           boolean isPumpTest = false;
           int numPayLines = this.getPaymentLineCount();
           if (numPayLines > 0) {
                  PaymentLine payLine = this.getPaymentLineAt(numPayLines);
                  if (payLine != null && payLine.getMopCode() != null
                                && payLine.getMopCode() == MopCode.PUMP_TEST) {
                         isPumpTest = true;                         
                  }
           }
           return isPumpTest;
    }

	
	public boolean isPostEntry() {
		boolean postEntry = false;
		PaymentLine[] payLines = this.getPaymentLines();
		for (int i = 0; i < payLines.length; i++) {
			if (payLines[i].getMopCode() == MopCode.POST_ENTRY) {
				postEntry = true;
				break;
			}
		}
		return postEntry;
	}

	public boolean isMobileEntry() {
		boolean mobileEntry = false;
		NetPayInfo[] netPayInfoLines = this.getNetPayInfoLines();
		for (int i = 0; i < netPayInfoLines.length; i++) {
			if (netPayInfoLines[i] != null
					&& netPayInfoLines[i].getPayMode() != null
					&& netPayInfoLines[i].getPayMode().isMobilePayment()) {
				mobileEntry = true;
				break;
			}
		}
		return mobileEntry;
	}
	
	public boolean isMoneyorderPurchase() {
		boolean moneyOrder = false;
		ItemLine[] items = this.getItemLines();

		for (int i = 0; i < items.length; i++) {
			ItemLine singleItem = items[i];
			if ((!singleItem.isVoided())
					&& (singleItem.getVoidedItemLine() == null)
					&& (singleItem.getSoldAsMoneyOrder())) {
				moneyOrder = true;
			}
		}

		return moneyOrder;
	}

	/** Getter for property printed.
	 * @return Value of property printed.
	 *
	 */
	public boolean isPrinted() {
		return this.printed;
	}

	/** Setter for property printed.
	 * @param printed New value of property printed.
	 *
	 */
	public void setPrinted(boolean printed) {
		this.printed = printed;
	}

	/** Getter for property printed.
	 * @return Value of property printed.
	 *
	 */
	public boolean isJournalPrinted() {
		return this.journalPrinted;
	}

	/** Setter for property printed.
	 * @param printed New value of property printed.
	 *
	 */
	public void setJournalPrinted(boolean printed) {
		this.journalPrinted = printed;
	}

	/** Getter for property mobileReceiptProcessed.
	 * @return Value of property mobileReceiptProcessed.
	 *
	 */
	public boolean isMobileReceiptProcessed() {
		return this.mobileReceiptProcessed;
	}

	/** Setter for property mobileReceiptProcessed.
	 * @param mobileReceiptProcessed New value of property mobileReceiptProcessed.
	 *
	 */
	public void setMobileReceiptProcessed(boolean mobileReceiptProcessed) {
		this.mobileReceiptProcessed = mobileReceiptProcessed;
	}
	
	/**
	 * @return Returns the fuelTaxExRcptLines.
	 */
	public List<FuelTaxRcpt> getFuelTaxExRcptLines() {
		return fuelTaxExRcptLines;
	}

	/**
	 * @param fuelTaxExRcptLines The fuelTaxExRcptLines to set.
	 */
	public void setFuelTaxExRcptLines(List<FuelTaxRcpt> fuelTaxExRcptLines) {
		this.fuelTaxExRcptLines = fuelTaxExRcptLines;
	}
    
    /**
     * Getter for property recalledTxnsInfo.
     * @return Value of property recalledTxnsInfo.
     */
    public RecalledTxnInfo[] getRecalledTxnsInfo() {
        return (RecalledTxnInfo[]) this.recalledTxnsInfo.toArray(new RecalledTxnInfo[0]);
    }
    
    /**
     * Add recalled txn info to the recalled list
     * @param newInfo recalled txn info to be added.
     */
    public void addRecalledTxnInfo(RecalledTxnInfo newInfo) {
        this.recalledTxnsInfo.add(newInfo);
    }
    
    /**
     * Remove recalled txn info from the recalled list
     * @param newInfo recalled txn info to be removed.
     */
    public void removeRecalledTxnInfo(RecalledTxnInfo newInfo) {
        this.recalledTxnsInfo.remove(newInfo);
    }  
    
    /**
     * Getter for property claimedKioskOrders.
     * @return Value of property claimedKioskOrders.
     */
    public TransNum[] getClaimedKioskOrders() {
        return (TransNum[]) this.claimedKioskOrders.toArray(new TransNum[0]);
    }
    
    /**
     * Add claimed kiosk order TransNum to the claimedKioskOrders list
     * @param newInfo TransNum of kiosk order that has been claimed.
     */
    public void addClaimedKioskOrder(TransNum newInfo) {
        this.claimedKioskOrders.add(newInfo);
    }
    
    /**
     * Add claimed kiosk order TransNum to the claimedKioskOrders list
     * @param newInfo TransNum of kiosk order that has been claimed.
     */
    public void addClaimedKioskOrders(TransNum[] newInfo) {
        for (int i = 0; i < newInfo.length; i++) {
            this.claimedKioskOrders.add(newInfo[i]);
        }
    }    
    
    /**
     * Remove TransNum from the claimedKioskOrders list
     * @param newInfo TransNum of kiosk order to be removed from claimedKioskOrders.
     */
    public void removeClaimedKioskOrder(TransNum newInfo) {
        this.claimedKioskOrders.remove(newInfo);
    }     
    /** Getter for property eCheckInfo.
     * @return Value of property prePaidInfo - prePaidInfo information and receipt lines.
     *
     */
    public List<PrePaidInfo> getPrePaidInfoList() {
        return prePaidInfoList;
    }

      /** Setter for eCheckInfo.
     * @param prePaidInfo New value of property prePaidInfo -prePaidInfo information and receipt lines..
     */
    public void addPrePaidInfo(PrePaidInfo prePaidInfo) {
        if (prePaidInfoList == null){
            prePaidInfoList = new ArrayList<PrePaidInfo>();
        }
        this.prePaidInfoList.add(prePaidInfo);
    }
    
    /** returns an array of all the ticket discounts */
    public DiscountInfo[] getAllDiscountInfo() {
    	return discountInfoList.toArray(new DiscountInfo[0]);
    }
    
    /** adds a ticket level discount */
    public void addDiscountInfo(DiscountInfo discountInfo) {
    	this.discountInfoList.add(discountInfo);
    	adjustTransaction(discountInfo, true);
    }
    
    /** removes a specific ticket level discount */
    public void removeDiscountInfo(DiscountInfo discountInfo) {
        this.discountInfoList.remove(discountInfo);
        adjustTransaction(discountInfo, false);
    }
    
    private void adjustTransaction(DiscountInfo discountInfo, boolean addition){
    	if(this.postTaxAdjustments == null) {
            this.postTaxAdjustments = new MoneyAmount(0);
    	}
    	if(addition){
	    	this.postTaxAdjustments.add(discountInfo.getDiscountAmount());
	    	//Update TransactionInfo's 'total+tax' amount
	        this.fireTransactionDiscountChange(TransOperation.ADDITION, discountInfo);
    	}
    	else {
            this.postTaxAdjustments.sub(discountInfo.getDiscountAmount());
            //Update TransactionInfo's 'total+tax' amount
            this.fireTransactionDiscountChange(TransOperation.REMOVAL, discountInfo);
    	}
    }
    
    /** removes all ticket level discounts */
    public void removeAllDiscountInfo() {
    	this.discountInfoList.clear();
    }
    
	/** returns the total amount of ticket level discounts */
	public MoneyAmount getAllDiscountTotal() {
		MoneyAmount allDiscTot = new MoneyAmount(0);
		for (DiscountInfo disc : getAllDiscountInfo()) {
			MoneyAmount discAmt = disc.getDiscountAmount();
			if (discAmt != null) {
				allDiscTot.add(discAmt);
			}
		}
		return allDiscTot;
	}
    
	/**
	 * returns the total amount of ticket level discounts of a particular type
	 * (discountMode)
	 */
	public MoneyAmount getDiscountTotal(DiscountMode discountMode) {
		MoneyAmount discTot = new MoneyAmount(0);
		DiscountInfo[] discArray = this.getAllDiscountInfo();
		for (int i = 0, j = discArray.length; i < j; ++i) {
			if (discArray[i].getDiscountMode() != null
					&& discArray[i].getDiscountMode() == discountMode) {
				MoneyAmount discAmt = discArray[i].getDiscountAmount();
				if ((discAmt!=null) && (discAmt.getLongValue() != 0)) {
					discTot.add(discAmt);
				}
			}
		}
		return discTot;
	}
    
	/**
	 * For a sale transaction, calculate total payment already collected. This
	 * excludes pre-auth payment lines but considers change lines which have
	 * already been dispensed. It is typically used to determine the amount to
	 * be collected from network host in a split tender fuel prepay completion.
	 * 
	 * @return total payment already collected for the transaction.
	 */
	public MoneyAmount getCollectedPayment() {
		MoneyAmount collected = new MoneyAmount(0);
		if (transactionType == TransactionType.SALE) {
			for (PaymentLine pLine : getPaymentLines()) {
				if (!pLine.isPreAuthOnly()) {
					collected.add(pLine.getAmount());
				}
			}
			/* Change lines have negative amount */
			for (ChangeLine cLine : getChangeLines()) {
				collected.add(cLine.getAmount());
			}
		}
		return collected;
	}
	
	/**
	 * For a sale transaction, calculate total payment already collected. This
	 * considers change lines which have already been dispensed. 
	 * 
	 * @return total payment already collected for the transaction.
	 */
	public MoneyAmount getCollectedPaymentWithPreauth() {
		MoneyAmount collected = new MoneyAmount(0);
		if (transactionType == TransactionType.SALE) {
			for (PaymentLine pLine : getPaymentLines()) {
				collected.add(pLine.getAmount());
			}
			/* Change lines have negative amount */
			for (ChangeLine cLine : getChangeLines()) {
				collected.add(cLine.getAmount());
			}
		}
		return collected;
	}
		
	/**
	 * Include any fees on the payment line since they do not apply towards
	 * the items in the transaction. For example, cash back fees in a cash back
	 * transaction.
	 * 
	 * @return total fees on payment lines
	 */
	private MoneyAmount getPaymentFees() {
		MoneyAmount fees = new MoneyAmount(0);
		for (PaymentLine pLine : getPaymentLines()) {
			if (pLine.getFee() != null) {
				fees.add(pLine.getFee());
			}
		}
		return fees;
	}
	/**
	 * Get the total collected fees as part of 
	 * financial advices.
	 * @return total collected fees
	 */
	public MoneyAmount getCollectedPaymentFees() {
		MoneyAmount fees = new MoneyAmount(0);
		for (PaymentLine pLine : getPaymentLines()) {
			if (!pLine.isPreAuthOnly() && (pLine.getFee() != null)) {
				fees.add(pLine.getFee());
			}
		}
		return fees;
	}
    
    public void addSubItem(ItemLine compItem, ItemLine subItem) {
        if(!(compItem instanceof CompositeItemLine))
            throw new IllegalArgumentException("Sub item can be added to CompositeItemLine only");
        
        CompositeItemLine origCompItem = new CompositeItemLine();
        compItem.deepCopy(origCompItem);
        ((CompositeItemLine )compItem).addSubItem(subItem);
        this.fireSubItemChange(TransOperation.ADDITION, compItem, origCompItem, subItem);
        
        if (subItem instanceof FuelItemLine) {
            this.fuelSalesCount++;
        } else {
            this.merchandiseSalesCount++;
        }
    }
    
    public void removeSubItem(CompositeItemLine compItem, ItemLine subItem) {
        if(!(compItem instanceof CompositeItemLine))
            throw new IllegalArgumentException("Sub item can be removed from CompositeItemLine only");

        CompositeItemLine origCompItem = new CompositeItemLine();
        ((CompositeItemLine )compItem).deepCopy(origCompItem);
        int retVal = compItem.removeSubItem(subItem);
        if(retVal >= 0)
            this.fireSubItemChange(TransOperation.REMOVAL, compItem, origCompItem, subItem);
        if (subItem instanceof FuelItemLine) {
            this.fuelSalesCount--;
        } else {
            this.merchandiseSalesCount--;
        }
    }
    /**
     * Returns PLU not found item lines. These item lines are printed on 
     * manual adjustment ticket. To avoid redundancy it excludes voided items
     * but includes void lines for reference. 
     * 
     * @return Value of property itemLines.
     */
    public ItemLine[] getPLUNFItems()
    {
    	List<ItemLine> pluNFItems = new ArrayList<ItemLine>();
    	ItemLine [] items = getItemLines();
    	for(int i = 0; i < items.length; i++)
    	{
    		if(items[i] instanceof PluItemLine && ((PluItemLine)items[i]).isPluNotFound())
    		{
    			pluNFItems.add(items[i]);
    		}
    	}
    	return (ItemLine[])pluNFItems.toArray(new ItemLine[0]);
    }

    /** Getter for property eCheckInfo.
     * @return Value of property eCheckInfo - Electronic check transaction information and receipt lines.
     *
     */
    public ECheckInfo getECheckInfo() {
        return eCheckInfo;
    }

    /** Setter for eCheckInfo.
     * @param eCheckInfo New value of property eCheckInfo - Electronic check transaction information and receipt lines..
     * 
     *
     */
    public void setECheckInfo(ECheckInfo eCheckInfo) {
        this.eCheckInfo = eCheckInfo;
    }

    /**
     *  Reset most of the attributes.
     */
    /**
     *  Reset most of the attributes.
     */
    public void reset() {
        this.itemLines.clear();
        this.paymentLines.clear();
        this.changeLines.clear();
        this.netPayInfoLines.clear();
        this.svcActInfoLines.clear();
        this.taxLines.clear();
        this.prtCCopy = false;
        this.prtMerchCopy = false;
        this.dealInfo.clear();
        this.balanceToPay = new MoneyAmount(0);
        this.totalBeforeTax = new MoneyAmount(0);
        this.totalTax = new MoneyAmount(0);
        this.totalWithTax = new MoneyAmount(0);
        this.preTaxAdjustments = new MoneyAmount(0);
        this.postTaxAdjustments = new MoneyAmount(0);
        this.coinsDispensed = new MoneyAmount(0);
        this.voidTransaction = false;
        this.customerDOB = null;
        this.customerAge = 0;
        this.customerDOBSkipped = false;
        this.endTime = 0;
        this.beginTime = 0;
        this.recalledTxnsInfo.clear();
        this.suspended = false;
        this.transactionTime = 0;
        this.carwashValidDays = 0;
        this.popInfo = null;
        this.autoCodeInfo.clear();
        this.reqCodesNum = 0;
        this.reqCodesDef = 0;
        this.dealInfo.clear();
        this.spDiscEligibleAmount = new MoneyAmount(0);
        this.autorefund = false;
        this.printed = false;
        this.journalPrinted = false;
        this.mobileReceiptProcessed = false; 
        this.fastCredit = false;
        this.foodService = false;
        this.fcMerchSettle = false;
        this.fuelTaxExRcptLines.clear();
        this.eCheckInfo = null;
        this.claimedKioskOrders.clear();
        this.numCopies = 0; // Defaults to 0
        this.prePaidInfoList.clear();
        this.discountInfoList.clear();
        this.netLoyaltyData = null;
        this.epsReferenceNumber = null;
        this.fuelingMessageMap.clear();
        this.conditionalRewards.clear();
        this.customerLoyaltyPref = LoyaltyPreferenceEnum.UNKNOWN;
        this.policyReceiptMessages.clear();
        this.backgroundCompletion = false;
		this.dineInDataSet = null;
		this.printDOBonJournal = false;
		this.voidReason = null;
		this.foodOrderCustomerDetails = new FoodOrderCustomerDetails();
		this.dobEntryMethod = null;
		this.promptMap.clear();
		this.isCRSSent = false;
		this.totalProcessed= false;
		this.charityPrompted = false;
		this.printCurrencySymbol = false;
		this.itemLineUnitPrice = false;
		this.printVerboseTotal = false;
		this.iDRestrictionDetails  = new IDRestrictionDetails();
		this.pluMaxQtyPerTransMap.clear();
		this.deptMaxQtyPerTransMap.clear();
		this.printCurrencySymbol = false;
		this.itemLineUnitPrice = false;
		this.printVerboseTotal = false;
		this.printTaxSummary = false;
		this.printAllTaxes = false;
		this.fiscalTaxExemptInfo = null;
		this.overridenCashierIDMap.clear();
		this.restrictDept.clear();
		this.attendantTransaction = false;
		this.physicalRegisterID = null;
	}

    /**
     * @return the fuelSalesCount
     */
    public int getFuelSalesCount() {
        return fuelSalesCount;
    }

    /**
     * @return the merchandiseSalesCount
     */
    public int getMerchandiseSalesCount() {
        return merchandiseSalesCount;
    }

	/**
	 * @return the netLoyaltyData
	 */
	public NetLoyaltyData getNetLoyaltyData() {
		return netLoyaltyData;
	}
    /**
     * @return the couponScanAttempted
     */
    public boolean isCouponScanAttempted() {
        return couponScanAttempted;
    }

	/**
	 * @param netLoyaltyData the netLoyaltyData to set
	 */
	public void setNetLoyaltyData(NetLoyaltyData netLoyaltyData) {
		this.netLoyaltyData = netLoyaltyData;
	}
    /**
     * @param couponScanAttempted the couponScanAttempted to set
     */
    public void setCouponScanAttempted(boolean couponScanAttempted) {
        this.couponScanAttempted = couponScanAttempted;
    }
    
    /** Getter for property ageVerificationPassed
     * @return Value of property ageVerificationPassed.
     */
    public boolean isAgeVerificationPassed() {
		return ageVerificationPassed;
	}

    /** Setter for property ageVerificationPassed
     */    
	public void setAgeVerificationPassed(boolean status ) {
		this.ageVerificationPassed = status;
	}

	/**
	 * @return the originalTransaction
	 */
	public Transaction getOriginalTransaction() {
		return originalTransaction;
	}

	/**
	 * @param originalTransaction the originalTransaction to set
	 */
	public void setOriginalTransaction(Transaction originalTransaction) {
		this.originalTransaction = originalTransaction;
	}
	
	/** Getter for property reprintSecurityLevel
     * @return Value of property reprintSecurityLevel.
     */
	public int getReprintSecurityLevel() {
		return reprintSecurityLevel;
	}
	
	/** Setter for property reprintSecurityLevel
     */ 
	public void setReprintSecurityLevel(int reprintSecurityLevel) {
		if(this.reprintSecurityLevel < reprintSecurityLevel){
			this.reprintSecurityLevel = reprintSecurityLevel;
		}
		 
	}
	
	
    public void setAttrbutes(Transaction inputTrans) {
        this.posID = inputTrans.getPosID();
        this.epsWorkstationID = inputTrans.getEpsWorkstationID();
        this.setBeginTime(inputTrans.getBeginTime());
        this.transactionTime = inputTrans.getTransactionTime();
        this.transactionType = inputTrans.getTransactionType();
        this.setEndTime(inputTrans.getEndTime());
        this.transNum = new TransNum();
        this.transNum.setTransNum(inputTrans.getTransNum().getTransNum());
        this.drwNum = inputTrans.getDrwNum();
        this.cashierID = inputTrans.getCashierID();
        this.preTaxAdjustments = inputTrans.getPreTaxAdjustments();
        this.customerDOB = inputTrans.getCustomerDOB();
        this.customerAge = inputTrans.customerAge;
        this.dobEntryMethod = inputTrans.dobEntryMethod;
        this.customerDOBSkipped = inputTrans.isCustomerDOBSkipped();
        this.ageVerificationPassed = inputTrans.isAgeVerificationPassed();
        
        //copy all ticket-level discounts
        for (DiscountInfo discount : inputTrans.getAllDiscountInfo()) {
            this.addDiscountInfo(discount);
        }
        
		/*
		 * Please do not change this order. This will make sure that post tax
		 * adjustment is copied into cloned transaction object without any
		 * invalid update for each evaluate call.
		 */
        this.postTaxAdjustments = inputTrans.getPostTaxAdjustments();
        
        //copy all ChangeLines
        for (ChangeLine changeLine : inputTrans.getChangeLines()) {
            this.addChangeLine(changeLine);
        }
        //copy all NetPayInfoLines
        for (NetPayInfo netPayInfoLine : inputTrans.getNetPayInfoLines()) {
            this.addNetPayInfoLine(netPayInfoLine);
        }
        //copy all SvcActInfoLines
        for (SvcActInfo svcActInfoLine : inputTrans.getSvcActInfoLines()) {
            this.addSvcActInfoLine(svcActInfoLine);
        }

        this.prtCCopy = inputTrans.isPrtCCopy();
        this.prtMerchCopy = inputTrans.getPrtMerchCopy();
        this.setDealInfo(inputTrans.getDealInfo());
        this.coinsDispensed = inputTrans.getCoinsDispensed();

        //copy all RecalledTxnInfo
        for (RecalledTxnInfo recalledTxnInfo : inputTrans.getRecalledTxnsInfo()) {
            this.addRecalledTxnInfo(recalledTxnInfo);
        }
        
        this.carwashValidDays = inputTrans.getCarwashValidDays();
        this.popInfo = inputTrans.getPopInfo();
        this.reqCodesNum = inputTrans.getReqCodesNum();
        this.reqCodesDef = inputTrans.getReqCodesDef();
        this.spDiscEligibleAmount = inputTrans.getSpDiscEligibleAmount();
        this.autorefund = inputTrans.isAutoRefund();
        this.printed = inputTrans.isPrinted();
        this.journalPrinted = inputTrans.isJournalPrinted();
        this.mobileReceiptProcessed = inputTrans.isMobileReceiptProcessed();
        
        this.fastCredit = inputTrans.isFastCredit();
        this.foodService = inputTrans.isFoodService();
        this.fcMerchSettle = inputTrans.isFcMerchSettle();
        
        //copy all FuelTaxRcptLines
        this.setFuelTaxExRcptLines(inputTrans.getFuelTaxExRcptLines());
        this.eCheckInfo = inputTrans.getECheckInfo();
        
        //copy all claimedKioskOrders
        for (TransNum trans : inputTrans.getClaimedKioskOrders()) {
            this.addClaimedKioskOrder(trans);
        }
        
        this.numCopies = inputTrans.getNumCopies();
        this.netLoyaltyData = inputTrans.getNetLoyaltyData();
        //adding secondary net loyalty data 
        this.secNetLoyaltyData= inputTrans.getSecNetLoyaltyData();
        this.originalTransaction = inputTrans.getOriginalTransaction();
        this.epsReferenceNumber = inputTrans.getEpsReferenceNumber();
        this.fuelingMessageMap.putAll(inputTrans.fuelingMessageMap);
		for (String rewardID : inputTrans.conditionalRewards) {
			this.conditionalRewards.add(rewardID);
		}
		this.customerLoyaltyPref = inputTrans.customerLoyaltyPref;
		this.voidTransaction = inputTrans.voidTransaction;
		for (Map.Entry<String, ReceiptMessage> entry : inputTrans.policyReceiptMessages.entrySet()) {
			this.policyReceiptMessages.put(entry.getKey(), entry.getValue());
		}
		this.backgroundCompletion= inputTrans.backgroundCompletion;

		this.dineInDataSet= inputTrans.dineInDataSet;
		this.printDOBonJournal= inputTrans.printDOBonJournal;
		this.voidReason = inputTrans.voidReason;
		this.foodOrderCustomerDetails = inputTrans.foodOrderCustomerDetails;
		this.promptMap.putAll(inputTrans.promptMap);
		this.isCRSSent = inputTrans.isCRSSent;
		this.totalProcessed =  inputTrans.totalProcessed;
		this.charityPrompted = inputTrans.charityPrompted;
		
		this.iDRestrictionDetails = inputTrans.iDRestrictionDetails;
		for (Map.Entry<Integer, Quantity> entry : inputTrans.deptMaxQtyPerTransMap.entrySet()) {
			this.setDeptMaxQtyPerTrans(entry.getKey(), entry.getValue());
		}
		for (Map.Entry<PluPK, Quantity> entry : inputTrans.pluMaxQtyPerTransMap.entrySet()) {
			this.setPluMaxQtyPerTrans(entry.getKey(), entry.getValue());
		}
		
		this.setPrintCurrencySymbol(inputTrans.isPrintCurrencySymbol());
		this.setItemLineUnitPrice(inputTrans.isItemLineUnitPrice());
		this.setPrintVerboseTotal(inputTrans.isPrintVerboseTotal());
		this.setPrintTaxSummary(inputTrans.isPrintTaxSummary());
		this.setPrintAllTaxes(inputTrans.isPrintAllTaxes());
		this.fiscalTaxExemptInfo = inputTrans.getFiscalTaxExemptInfo();
		this.overridenCashierIDMap = inputTrans.getOverrideCashierIDs();
		this.setRestrictDeptItems(inputTrans.restrictDept);
		this.setAttendantTransaction(inputTrans.isAttendantTransaction());
		this.setPhysicalRegisterID(inputTrans.getPhysicalRegisterID()); 
	}

	/**
	 * Return the first preauth payment line in the transaction
	 * 
	 * @return the first pre-auth payment line in the transaction
	 */
	public PaymentLine getFirstPreauthPayment() {
		PaymentLine preauth = null;
		for (PaymentLine payLine : getPaymentLines()) {
			if (payLine.isPreAuthOnly()) {
				preauth = payLine;
				break;
			}
		}
		return preauth;
	}
	
	/**
	 * Return the first unsettled preauth payment line in the transaction
	 * 
	 * @return the first unsettled pre-auth payment line in the transaction
	 */
	public PaymentLine getFirstUnsettledPreauth() {
		PaymentLine unsettled = null;
		for (PaymentLine payLine : getPaymentLines()) {
			if (payLine.isPreAuthOnly() && !payLine.isFailedCompletion()) {
				unsettled = payLine;
				break;
			}
		}
		return unsettled;
	}
	
	/**
	 * Return a list of failed completions from the transaction that will appear
	 * in the unpaid transaction report.
	 * 
	 * @return a list of failed completions
	 */
	public List<PaymentLine> getFailedCompletions() {
		List<PaymentLine> failedCompletions = new ArrayList<PaymentLine>();
		for (PaymentLine pLine : getPaymentLines()) {
			if (pLine.isFailedCompletion()) {
				failedCompletions.add(pLine);
			}
		}
		return failedCompletions;
	}
	
	/**
	 * Return a list of failed payment reversals from the transaction that will
	 * appear in the unpaid transaction report
	 * 
	 * @return a list of failed payment reversals
	 */
	public List<NetPayInfo> getFailedPaymentReversals() {
		List<NetPayInfo> failedPaymentReversals = new ArrayList<NetPayInfo>();
		for (NetPayInfo netInfo : getNetPayInfoLines()) {
			if (netInfo.isFailedReversal()) {
				failedPaymentReversals.add(netInfo);
			}
		}
		return failedPaymentReversals;
	}
	
	/**
	 * Return a list of failed activation reversals from the transaction that
	 * will appear in the unpaid transaction report.
	 * 
	 * @return a list of failed activation reversals
	 */
	public List<SvcActInfo> getFailedActivationReversals() {
		List<SvcActInfo> failedActivationReversals = new ArrayList<SvcActInfo>();
		for (SvcActInfo svcInfo : getSvcActInfoLines()) {
			if (svcInfo.isFailedreversal()) {
				failedActivationReversals.add(svcInfo);
			}
		}
		return failedActivationReversals;
	}
	
	/**
	 * Return a collection of all EPS applied PPG, line item and ticket level
	 * discounts. Use the newly introduced <code>appliedDiscount</code> field
	 * from LoyaltyInfo as opposed to <code>discountAmount</code> field from
	 * DiscountInfo. For PPG discounts, the DiscountInfo will not have any
	 * amounts and we should not populate it either (will break transaction
	 * calculation on POS). So the effective PPG discount information is
	 * provided in {@link LoyaltyInfo#getAppliedDiscount()}. If appliedDiscount
	 * is null (as in case of a line item or ticket level discount), it always
	 * returns the discount amount from the parent class.
	 * 
	 * @return a collection of EPS applied discounts
	 */
	public List<LoyaltyInfo> getEpsAppliedDiscounts() {
		List<LoyaltyInfo> epsDiscounts = new ArrayList<LoyaltyInfo>();
		List<DiscountInfo> allDiscounts = new ArrayList<DiscountInfo>();
		for (ItemLine item : getItemLines()) {
			for (DiscountInfo discount : item.getAllDiscountInfo()) {
				allDiscounts.add(discount);
			}
		}
		for (DiscountInfo tktDiscount : getAllDiscountInfo()) {
			allDiscounts.add(tktDiscount);
		}
		for (DiscountInfo discount : allDiscounts) {
			if (discount instanceof LoyaltyInfo) {
				LoyaltyInfo lyInfo = (LoyaltyInfo) discount;
				/*
				 * EPS applied discounts have a reward ID (price adjustment ID)
				 * whereas POS discounts do not. Above-site discounts are not
				 * EPS applied site level discounts.
				 */
				if ((lyInfo.getRewardID() != null) && !lyInfo.isAboveSite()) {
					epsDiscounts.add(lyInfo);
				}
			}
		}
		return epsDiscounts;
	}
	
	/**
	 * For a given loyalty program, provide the authorization details if
	 * available. This will only be available for site level loyalty programs
	 * handled via EPS. This will not be available for above site loyalty
	 * programs.
	 * 
	 * @param programID
	 * @return authorization details for the loyalty program if available, null
	 *         otherwise
	 */
	private LoyaltyAuthDetails getLoyaltyAuth(String programID) {
		LoyaltyAuthDetails details = null;
		if (netLoyaltyData != null) {
			details = netLoyaltyData.getLoyaltyAuth(programID);
		}
		if ((details == null) && (secNetLoyaltyData != null)) {
			details = secNetLoyaltyData.getLoyaltyAuth(programID);
		}
		
        /*
        * It is possible that original attendant transaction had a different loyalty
        * program (or current transaction has no loyalty and original transaction had
        * loyalty). We need to provide the detail in the transaction XML.
        */
        if (details == null && originalTransaction != null) {
               details = originalTransaction.getLoyaltyAuth(programID);
        }

		return details;
	}
	
	/**
	 * Provide the loyalty program details from the transaction for the purpose
	 * of XML serialization. This will include above site and site level loyalty
	 * and network payment related discounts. Note that POP discount by card
	 * type is not considered a loyalty discount.
	 * 
	 * @return an array of loyalty program details from the transaction
	 */
	public LoyaltyProgramDetails[] retrieveLoyaltyProgramDetails() {
		Map<String, LoyaltyProgramDetails> allPrograms = new HashMap<String, LoyaltyProgramDetails>();
		/*
		 * Walk through item level loyalty PPG and line item discounts. Provide one program detail entry
		 * for each loyalty program.
		 */
		for (ItemLine item : getItemLines()) {
			for (DiscountInfo discount : item.getAllDiscountInfo()) {
				if (discount instanceof LoyaltyInfo) {
					DiscountMode mode = discount.getDiscountMode();
					if ((mode == DiscountMode.LOYALTY_AUTO) || (mode == DiscountMode.LOYALTY_PPG_DISCOUNT)) {
						LoyaltyInfo lyInfo = (LoyaltyInfo) discount;
						String programName = lyInfo.getProgramName();
						if (!allPrograms.containsKey(programName)) {
							allPrograms.put(programName, createProgramDetail(lyInfo));
						}
					}
				}
			}
		}
		/*
		 * Walk through ticket level loyalty discounts and also accumulate the 
		 * discount amount for a given loyalty program.
		 * 
		 */
		for (DiscountInfo tktDiscount : getAllDiscountInfo()) {
			if (tktDiscount instanceof LoyaltyInfo) {
				DiscountMode mode = tktDiscount.getDiscountMode();
				if (mode == DiscountMode.LOYALTY_AUTO) {
					LoyaltyInfo lyInfo = (LoyaltyInfo) tktDiscount;
					String programName = lyInfo.getProgramName();
					LoyaltyProgramDetails detail = allPrograms.get(programName);
					if (detail == null) {
						detail = createProgramDetail(lyInfo);
						detail.setAutoDiscount(lyInfo.getDiscountAmount());
						allPrograms.put(programName, detail);
					} else {
						detail.addAutoDiscount(lyInfo.getDiscountAmount());
					}
				}
			}
		}
        /*
        * Walk through net loyalty data and secondary net loyalty data to
        * identify site level loyalty programs that did not receive discounts
        * but must be reported for earning purpose
        */
        if (netLoyaltyData != null) {
               for (Map.Entry<String, LoyaltyAuthDetails> auth : netLoyaltyData.getLoyaltyAuthEntries()) {
                     allPrograms.putIfAbsent(auth.getValue().getProgramName(), createProgramDetails(auth.getValue()));
               }
        }
        if (secNetLoyaltyData != null) {
               for (Map.Entry<String, LoyaltyAuthDetails> auth : secNetLoyaltyData.getLoyaltyAuthEntries()) {
                     allPrograms.putIfAbsent(auth.getValue().getProgramName(), createProgramDetails(auth.getValue()));
               }
        }
		return allPrograms.values().toArray(new LoyaltyProgramDetails[0]);
	}
	
    /**
    * Create loyalty program details based on the loyalty authorization
    * received from EPS. In this case there may not be any discount in the
    * transaction, but the valid loyalty token must be reflected in t-log and
    * POS loyalty reports.
    * 
     * @param auth
    *            Loyalty authorization details from EPS
    * @return loyalty program details to be captured in t-log
    */
    private LoyaltyProgramDetails createProgramDetails(LoyaltyAuthDetails auth) {
           LoyaltyProgramDetails detail = new LoyaltyProgramDetails();
           detail.setProgramName(auth.getProgramName());
           detail.setAuthDetail(auth);
           return detail;
    }

	/**
	 * Create loyalty program detail for transaction XML serialization for a
	 * given loyalty discount. If a program gives multiple discounts across item
	 * and ticket level, only one entry will be provided for transaction XML
	 * serialization.
	 * 
	 * @param lyInfo
	 * @return loyalty program detail based on a given loyalty discount
	 */
	private LoyaltyProgramDetails createProgramDetail(LoyaltyInfo lyInfo) {
		LoyaltyProgramDetails detail = new LoyaltyProgramDetails();
		detail.setProgramName(lyInfo.getProgramName());
		detail.setAuthDetail(getLoyaltyAuth(lyInfo.getProgramID()));
		return detail;
	}
	
	/**
	 * Provide the first payment line of the transaction (useful for DCR
	 * transactions where this is the only payment line)
	 * 
	 * @return the first payment line of the transaction
	 */
	public PaymentLine getFirstPayment() {
		PaymentLine payment = null;
		PaymentLine[] pLines = getPaymentLines();
		if (pLines.length > 0) {
			payment = pLines[0];
		}
		return payment;
	}
	
	/**
	 * Return the total amount that customer is required to pay for this
	 * transaction. Account for post tax adjustments such as ticket level
	 * discount.
	 * 
	 * @return the total due amount of the transaction that customer pays
	 */
	public MoneyAmount getTotalDueAmount() {
		MoneyAmount totalDue = new MoneyAmount(getTotalWithTax());
		totalDue.add(getPostTaxAdjustments());
		return totalDue;
	}
	
	/**
	 * Return list of fueling messages to be displayed for the given fueling sequence
	 * (before, during, after)
	 * 
	 * @param sequence
	 * @return list of fueling messages for the given sequence
	 */
	public List<FuelingMessageDetails> getFuelingMessages(FuelingMessageSequence sequence) {
		List<FuelingMessageDetails> details = this.fuelingMessageMap.get(sequence);
		if (details == null) {
			details = new ArrayList<FuelingMessageDetails>();
		}
		return details;
	}

	/**
	 * Add the fueling message to the list of messages for the given fueling
	 * sequence (before, during, after)
	 * 
	 * @param sequence
	 * @param messages
	 */
	public void setFuelingMessages(FuelingMessageSequence sequence, FuelingMessageDetails messages) {
		List<FuelingMessageDetails> details = this.fuelingMessageMap.get(sequence);
		if (details == null) {
			details = new ArrayList<FuelingMessageDetails>();
			this.fuelingMessageMap.put(sequence, details);
		}
		details.add(messages);
	}
	
	/**
	 * Mark a reward as conditional so that it can removed later
	 * 
	 * @param rewardID
	 */
	public void addConditionalReward(String rewardID) {
		conditionalRewards.add(rewardID);
	}
	
	/**
	 * Remove all conditional rewards after a failure is detected. Clear the
	 * reward ID from the conditional list once the corresponding discounts have
	 * been removed.
	 */
	public void removeConditionalRewards() {
		for (String rewardID : conditionalRewards) {
			removeLoyaltyDiscount(rewardID);
		}
		conditionalRewards.clear();
	}
	
	public LoyaltyPreferenceEnum getCustomerLoyaltyPref() {
		return customerLoyaltyPref;
	}

	public void setCustomerLoyaltyPref(LoyaltyPreferenceEnum customerLoyaltyPref) {
		/*
		 * By default, loyalty customer preference is unknown
		 */
		if (customerLoyaltyPref != null) {
			this.customerLoyaltyPref = customerLoyaltyPref;
		}
	}

	/**
	 * Return the policy receipt messages.
	 * 
	 * @return the policy receipt messages
	 */
	public ReceiptMessage[] getPolicyReceiptMessages() {
		return this.policyReceiptMessages.values().toArray(new ReceiptMessage[0]);
	}
	
	/**
	 * 
	 * @param ruleId
	 * @param policyReceiptHeader
	 */
	public void addPolicyReceiptHeader(String ruleId, ReceiptHdr policyReceiptHeader) {
		this.policyReceiptHeader.put(ruleId, policyReceiptHeader);
	}
	
	
	public ReceiptHdr[] getPolicyReceiptHeader() {
		return this.policyReceiptHeader.values().toArray(new ReceiptHdr[0]);
	}
	
	/**
	 * 
	 * @param ruleId
	 * @param policyReceiptMessage
	 */
	public void addPolicyReceiptMessage(String ruleId, ReceiptMessage policyReceiptMessage) {
		this.policyReceiptMessages.put(ruleId, policyReceiptMessage);
	}

	/**
	 * Locate any loyalty discount in the transaction with the same reward ID
	 * and remove it.
	 * 
	 * @param rewardID
	 */
	private void removeLoyaltyDiscount(String rewardID) {
		/*
		 * First walk through item line discounts
		 */
		for (ItemLine item : getItemLines()) {
			LoyaltyInfo itemDiscount = null;
			for (DiscountInfo discount : item.getAllDiscountInfo()) {
				if (discount instanceof LoyaltyInfo) {
					LoyaltyInfo lyInfo = (LoyaltyInfo) discount;
					String priceAdjID = lyInfo.getRewardID();
					if ((priceAdjID != null) && priceAdjID.equals(rewardID)) {
						itemDiscount = (LoyaltyInfo) discount;
						break;
					}
				}
			}

			/*
			 * If a loyalty discount with matching reward ID is found on the
			 * item line, remove the discount and fire item line modification.
			 */
			if (itemDiscount != null) {
				SimpleItemLine originalItem = null;
				try {
					originalItem = (SimpleItemLine) item.getClass().newInstance();
				} catch (Exception e) {
					logger.error("Invalid item line class {}", item.getClass().getName());
					originalItem = new SimpleItemLine();
				}
				item.deepCopy(originalItem);
				item.removeDiscountInfo(itemDiscount);
				try {
					fireItemLineModification(item, originalItem);
				} catch (ItemLineException ile) {
					logger.error(ile.getMessage());
				}
			}
		}
		/*
		 * Walk through ticket level discounts
		 */
		LoyaltyInfo ticketDiscount = null;
		for (DiscountInfo discount : getAllDiscountInfo()) {
			if (discount instanceof LoyaltyInfo) {
				LoyaltyInfo lyInfo = (LoyaltyInfo) discount;
				String priceAdjID = lyInfo.getRewardID();
				if ((priceAdjID != null) && priceAdjID.equals(rewardID)) {
					ticketDiscount = (LoyaltyInfo) discount;
					break;
				}
			}
		}
		if (ticketDiscount != null) {
			removeDiscountInfo(ticketDiscount);
		}
	}

	/**
	 * @return the secNetLoyaltyData
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public NetLoyaltyData getSecNetLoyaltyData() {
		return secNetLoyaltyData;
	}

	/**
	 * @param secNetLoyaltyData the secNetLoyaltyData to set
	 */
	public void setSecNetLoyaltyData(NetLoyaltyData secNetLoyaltyData) {
		this.secNetLoyaltyData = secNetLoyaltyData;
	}
	
	/**
	 * Indicates transaction has unsettled payment / loyalty / activation
	 * requests and will need to be preserved separately for unpaid transaction
	 * report.
	 * 
	 * @return true if transaction has payment / loyalty / activation requests
	 *         which are not finalized yet.
	 */
	public boolean hasUnsettledNetworkRequests() {
		if (suspended) {
            return false;
		}

		boolean unsettled = hasPendingNetworkRequests();
		
		/*
		 * If any financial advice requests to EPS resulted in failure
		 */
		if (!unsettled
				&& (!getFailedCompletions().isEmpty()
					|| !getFailedActivationReversals().isEmpty() 
						|| !getFailedPaymentReversals().isEmpty())) {
			unsettled = true;
		}
		
		/*
		 * Check if loyalty advice failed
		 */
		if(!unsettled && (netLoyaltyData != null)) {
			unsettled = netLoyaltyData.isCompletionProcessed() 
								&& netLoyaltyData.isCompletionFailed();
		}
		
		return unsettled;
	}
	
	/**
	 * Indicates transaction has payment / loyalty / reversal items which we are
	 * still trying to send to EPS.
	 * 
	 * @return true if we should still continue to attempt sending these items
	 *         to EPS
	 */
	public boolean hasPendingNetworkRequests() {
		if (suspended) {
            return false;
		}

		boolean pending = false;
		/*
		 * Ignore any fuel prepay transactions as they will be completed after
		 * fueling. Also ignore any voided transactions before they are actually
		 * completed.
		 */
		if (getPrepayItem() == null || voidTransaction) {
			if (!voidTransaction && getFirstUnsettledPreauth() != null) {
				pending = true;
			} else if ((netLoyaltyData != null)
					&& (!netLoyaltyData.isCompletionProcessed())) {
				pending = true;
			}
		}
		/*
		 * For a void transaction, if any payment or activations are yet to
		 * reversed.
		 */
		if (!pending
				&& ((getNextPendingActivationReversal() != null) || (getNextPendingPaymentReversal() != null))) {
			pending = true;
		}
		
		return pending;
	}
	
	/**
	 * Return the total cash back amount from transaction
	 * 
	 * @return total cash back amount, 0 if there is no cashback
	 */
	public MoneyAmount getCashbackAmount() {
		MoneyAmount cashback = new MoneyAmount(0);
		for (PaymentLine pLine : getPaymentLines()) {
			if (pLine.getCashback() != null) {
				cashback.add(pLine.getCashback());
			}
		}
		return cashback;
	}
	
	/**
	 * Return the total cash back fee amount from transaction
	 * 
	 * @return total cash back fee amount, 0 if there is no cashback fee
	 */
	public MoneyAmount getCashbackFeeAmount() {
		MoneyAmount cashbackFee = new MoneyAmount(0);
		for (PaymentLine pLine : getPaymentLines()) {
			if ((pLine.getCashback() != null) && (pLine.getFee() != null)) {
				cashbackFee.add(pLine.getFee());
			}
		}
		return cashbackFee;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Transaction [originalTransaction=" + originalTransaction
				+ ", itemLines=" + itemLines + ", paymentLines=" + paymentLines
				+ ", changeLines=" + changeLines + ", taxLines=" + taxLines
				+ ", balanceToPay=" + balanceToPay + ", totalBeforeTax="
				+ totalBeforeTax + ", totalTax=" + totalTax + ", totalWithTax="
				+ totalWithTax + ", preTaxAdjustments=" + preTaxAdjustments
				+ ", postTaxAdjustments=" + postTaxAdjustments
				+ ", coinsDispensed=" + coinsDispensed + ", transactionType="
				+ transactionType + ", voidTransaction=" + voidTransaction
				+ ", customerDOB=" + customerDOB + ", customerDOBSkipped="
				+ customerDOBSkipped + ", ageVerificationPassed="
				+ ageVerificationPassed + ", endTime=" + endTime + ", posID="
				+ posID + ", epsWorkstationID=" + epsWorkstationID
				+ ", drwNum=" + drwNum + ", transNum=" + transNum
				+ ", cashierID=" + cashierID +",overridenCashierIDMap="+ overridenCashierIDMap + ", beginTime=" + beginTime
				+ ", suspended=" + suspended + ", netPayInfoLines="
				+ netPayInfoLines + ", svcActInfoLines=" + svcActInfoLines
				+ ", prtCCopy=" + prtCCopy + ", prtMerchCopy=" + prtMerchCopy
				+ ", cashierName=" + cashierName + ", cashierPeriodSeq="
				+ cashierPeriodSeq + ", transactionTime=" + transactionTime
				+ ", tillID=" + tillID + ", carwashValidDays="
				+ carwashValidDays + ", cwPaypointNum=" + cwPaypointNum
				+ ", popInfo=" + popInfo + ", dealInfo=" + dealInfo
				+ ", spDiscEligibleAmount=" + spDiscEligibleAmount
				+ ", autorefund=" + autorefund + ", autoCompleteReceipt="
				+ autoCompleteReceipt + ", printed=" + printed + ", journalPrinted="
				+ journalPrinted  + "mobileReceiptProcessed" + mobileReceiptProcessed
				+ ", fastCredit=" + fastCredit + ",foodService=" + foodService
				+ ", fcMerchSettle=" + fcMerchSettle + ", fuelTaxExRcptLines="
				+ fuelTaxExRcptLines + ", eCheckInfo=" + eCheckInfo + ", recalledTxnsInfo="
				+ recalledTxnsInfo + ", claimedKioskOrders="
				+ claimedKioskOrders + ", numCopies=" + numCopies
				+ ", prePaidInfoList=" + prePaidInfoList
				+ ", discountInfoList=" + discountInfoList
				+ ", merchandiseSalesCount=" + merchandiseSalesCount
				+ ", fuelSalesCount=" + fuelSalesCount + ", netLoyaltyData="
				+ netLoyaltyData + ", secNetLoyaltyData=" + secNetLoyaltyData
				+ ", epsReferenceNumber=" + epsReferenceNumber
				+ ", reprintSecurityLevel=" + reprintSecurityLevel
				+ ", fuelingMessageMap=" + fuelingMessageMap
				+ ", conditionalRewards=" + conditionalRewards 
				+ ", dineInDataSet=" + dineInDataSet +",foodOrderCustomerDetails=" + foodOrderCustomerDetails 
				+",promptMap=" + promptMap +",isCRSSent=" + isCRSSent
				+",totalProcessed=" + totalProcessed
				+",charityPrompted=" + charityPrompted
				+",iDRestrictionDetails=" + iDRestrictionDetails
				+",physicalRegisterID=" + physicalRegisterID
				+",attendantTransaction=" + attendantTransaction
				+"]";
	}

	/**
	 * @return printDOBonJournal
	 */
	public boolean isPrintDOBonJournal() {
		return printDOBonJournal;
	}

	/**
	 * Setter for isPrintDOBonJournal
	 * @param printDOBonJournal
	 */
	public void setPrintDOBonJournal (boolean printDOBonJournal){
		this.printDOBonJournal = printDOBonJournal;
	}
	
	/**
	 * Getter for backgroundCompletion
	 * @return backgroundCompletion
	 */
	public boolean isBackgroundCompletion() {
		return backgroundCompletion;
	}

	/**
	 * Setter for backgroundCompletion
	 * @param backgroundCompletion
	 */
	public void setBackgroundCompletion(boolean backgroundCompletion) {
		this.backgroundCompletion = backgroundCompletion;
	}

	/**
	 * Getter for dineInCustomer
	 * @return dineInCustomer
	 */
	public DineInDataSet getDineInDataSet() {
		return dineInDataSet;
	}

	/**
	 * Setter for dineInCustomer
	 * @param dineInCustomer
	 */
	public void setDineInDataSet(DineInDataSet dineInDataSet) {
		this.dineInDataSet = dineInDataSet;
	}

	/*
	 * @return the uniqueTxnSeqNum
	 */
	@Override
	public long getUniqueTxnSeqNum() {
		return uniqueTxnSeqNum;
	}

	/**
	 * @param uniqueTxnSeqNum the uniqueTxnSeqNum to set
	 */
	@Override
	public void setUniqueTxnSeqNum(long uniqueTxnSeqNum) {
		this.uniqueTxnSeqNum = uniqueTxnSeqNum;
	}

	/**
	 * @return the fiscalReceipt
	 */
	public boolean isFiscalReceipt() {
		/* The result should be true if there are no payLines or  */
		/*  any of the payLines are set to true                   */
		if (paymentLines.size() == 0) {
			return true;
		}
		for(PaymentLine payLine : getPaymentLines()){
			if(payLine.isFiscalReceipt()){
				return true;
			}
		}
		return false;
	}
	/**
	 * It return the value of 'signatureOnFinancialAdvice' received from 
	 * EPS.
	 * 
	 * @return signatureOnCompletion
	 */
	public boolean isSignatureOnCompletion() {
		/* The result should be true if         */
		/*  any of the payLines are set to true */
		for(PaymentLine payLine : getPaymentLines()){
			if(payLine.isSignatureOnCompletion()){
				return true;
			}
		}
		return false;
	}
	
	public boolean isFuelUnderrun(){
		boolean underrun = false;
		for(ItemLine itemLine : getItemLines()){
			if(itemLine instanceof FuelItemLine){
				FuelItemLine fuelItemLine = (FuelItemLine) itemLine;
				if(fuelItemLine.getFuelDeposit().compare(fuelItemLine.getAmount()) > 0){
					underrun = true;
					break;
				}
			}
		}
		return underrun;
	}

	public boolean isPreAuthCompletion() {
		boolean preAuthCompletion = false;
		for (PaymentLine payLine : getPaymentLines()) {
			if (payLine.getOriginalPreauth() != null) {
				preAuthCompletion = true;
				break;
			}
		}
		return preAuthCompletion;
	}
	
	/**
     * Get whether the transaction is suspended by "Place Order".
     * <p>
     * This is used by the the "Food Service" rule set action to determine
     * if processing on the transaction is required to send items to kitchen.
     * @return <code>true</code> if "Place Order" Softkey function was invoked.
     */
	public boolean isPlaceOrderSuspended(){
	    return this.placeOrderSuspended;
    }

    /**
     * Set the property whether the transaction is suspended by "Place Order".
     * <p>
     * When the "Place Order" Softkey is processed, this transaction's <i>placeOrderSuspended</i>
     * is set to true then the normal suspended R/T logic is invoked.
     * <p>
     * This also is used by the the "Food Service" rule set action to determine
     * if processing on the transaction is required to send items to kitchen.
     * When the rule action is invoked, it will reset (false) this <i>property</i>.
     * 
     * @param placeOrderSuspended <code>true</code> if "Place Order" Softkey function was invoked.
     */
    public void setPlaceOrderSuspended(boolean placeOrderSuspended){
        this.placeOrderSuspended=placeOrderSuspended;
    }

    /**
     * Get whether this transaction has kitchen orders sent to the kitchen.
     * @return <code>true</code> if <i>sent</i> kitchen orders are contained in this transaction.
     */
    public boolean isKitchenServiceOrder(){
        return !this.kitchenServiceNums.isEmpty();
    }

    /**
     * Add to this transaction the given Kitchen Order transaction number sent to kitchen. 
     * @param number The transaction number sent.
     */
    public void addKitchenServiceNumber(TransNum number){
        if (!this.kitchenServiceNums.contains(number))
        {
            this.kitchenServiceNums.add(number);
        }
    }

    /**
     * Remove from this transaction the given Kitchen Order transaction number sent to kitchen. 
     * @param number The transaction number to be removed.
     */
    public void removeKitchenServiceNumber(TransNum number){
        this.kitchenServiceNums.remove(number);
    }

    /**
     * Return the collection of kitchen orders number in this transaction that were sent to kitchen.
     * @return The kitchen order numbers.
     */
    public TransNum[] getKitchenServiceOrderNumbers()
    {
        return this.kitchenServiceNums.toArray(new TransNum[this.kitchenServiceNums.size()]);
    }

    /**
     * Get whether this transaction <i><u>does not</u></i> contain any kitchen order numbers.
     * @return <code>true</code> if there are no kitchen orders contained in this transaction.
     */
    public boolean isKitchenServiceNumbersEmpty(){
        return this.kitchenServiceNums.isEmpty();
    }
    
    /**
     * This function return true if transaction contains only one pre-pay item
     * with amount zero, otherwise false.
     * 
     * @return
     */
    public boolean isFillUpTransaction(){
    	return (this.getItemLineCount() == 1 && this.getPrepayItem() != null 
    			&& this.getPrepayItem().getAmount().compare(new MoneyAmount(0)) == 0);
    }

    /**
     * Get whether this transaction was suspended as a driver thru order.
     * <P>
     * Implementations must initialize the 'property' to false.  This then requires some
     * direct action by the application to set the 'property' to true.
     * 
     * @return <code>true</code> if transaction suspended as a 'DriveThru' order.
     *         <code>false</code> for all other transaction types and suspends.
     */
    public boolean isDriveThruOrder()
    {
        return driveThruOrder;
    }

    /**
     * Set this transaction as being suspended as a DriEtHRU ORDER.
     * <P>
     * Implementations must initialize the 'property' to false.  This then requires some
     * direct action by the application to set the 'property' to true.
     * 
     * @param driveThruOrder <code>true</code> if transaction suspended as a 'DriveThru' order.
     */
    public void setDriveThruOrder(boolean driveThruOrder)
    {
        this.driveThruOrder = driveThruOrder;
    }

	
    /**
     * Returns reason for a voided transaction
     * @return
     */
	public VoidReason getVoidReason() {
		return voidReason;
	}

	/**
	 * Marks the transaction as void transaction and also set the reason for Voiding
	 * @param voidTransaction
	 * @param voidReason
	 */
	public void setVoidTransaction(boolean voidTransaction, VoidReason voidReason) {
		this.voidTransaction = voidTransaction;
		this.voidReason = voidReason;
	}
	
    /**
	 * Getter for fiscalReceiptInfo.
	 * 
	 * @return Value of fiscalReceiptInfo.
	 */
	public FiscalReceiptInfo getFiscalReceiptInfo() {
		return fiscalReceiptInfo;
	}

	/**
	 * Setter for fiscalReceiptInfo
	 * @param fiscalReceiptInfo
	 */
	public void setFiscalReceiptInfo(FiscalReceiptInfo fiscalReceiptInfo) {
		this.fiscalReceiptInfo = fiscalReceiptInfo;
	}

    /**
	 * Getter for property tpppVoucherLines.
	 * 
	 * @return Value of property tpppVoucherLines.
	 */
    public TpppVoucherInfo[] getTpppVoucherLines() {
        return (TpppVoucherInfo[])this.tpppVoucherLines.toArray(new TpppVoucherInfo[0]);
    }
    
    /** Getter for count of tpppVoucherLines
     * @return number of InfoLines. Note that this just returns the
     * collection's length
     */
    public int getTpppVoucherLineCount() {
        return this.tpppVoucherLines.size();
    }
    
    /**
     * Method to obtain the TpppVoucherInfo line at a given array index
     *
     * @param index - array index
     * @return TpppVoucherInfo
     */
    public TpppVoucherInfo getTpppVoucherLine(int index) {
    	TpppVoucherInfo tpppVoucherInfo = null;
        
        if ((index >= 0) && (index < this.tpppVoucherLines.size())) {
        	tpppVoucherInfo = (TpppVoucherInfo) this.tpppVoucherLines.get(index);
        }
        
        return tpppVoucherInfo;
    }
	/**
	 * Return a reference to the next pending TpppVoucherInfo object if there are any in the list or else it returns the 
	 * next pending Third Party Product TpppVoucherInfo
	 * 
	 * @return The next pending TpppVoucherInfo object
	 */
	public TpppVoucherInfo getNextPendingTpppVoucher() {
		TpppVoucherInfo thirdPartyProductProviderVoucherInfo = null;
		TpppVoucherInfo firstEps = null;
		TpppVoucherInfo[] tpppVoucherLines = this.getTpppVoucherLines();
		for (int i = 0; i < tpppVoucherLines.length; i++) {
			if (tpppVoucherLines[i].getTpppStatus() == TpppVoucherInfo.INITIAL_REQ_PENDING) {
				thirdPartyProductProviderVoucherInfo = tpppVoucherLines[i];
				if(!thirdPartyProductProviderVoucherInfo.isTpppVoucherItem()){
					return thirdPartyProductProviderVoucherInfo;
				}else{
					if(firstEps == null){
						firstEps = thirdPartyProductProviderVoucherInfo;
					}
				}
			}
		}
		return firstEps;
	}
	
	/**
	 * Add a new Third Party Product line
	 * 
	 * @param newLine
	 *            Third Party Product line to be added
	 */
    public void addTpppVoucherLine(TpppVoucherInfo newLine) {
        this.tpppVoucherLines.add(newLine);
    }
    
    /** Remove an existing Third Party Product line
     * @param remLine Third Party Product line to be removed
     */
    public void removeTpppVoucherLine(TpppVoucherInfo remLine) {
        this.tpppVoucherLines.remove(remLine);
    }
    

    /**
	 * Method to obtain the number of Third Party Product Voucher operations which
	 * are pending within this transaction. This will be used by SALES to
	 * initiate a completion after the transaction is paid for.
     *
     * @return int - number of Third Party Product Vouchers pending
     */
    public int getPendingTpppVoucherLineCount() {
        int count = 0;
        Iterator<TpppVoucherInfo> nodes = this.tpppVoucherLines.iterator();
        
        while (nodes.hasNext()) {
        	TpppVoucherInfo tpppVoucherInfo =  nodes.next();
            if (tpppVoucherInfo.getTpppStatus() == TpppVoucherInfo.INITIAL_VOUCH_REQ_SUCCESSFUL) {
                count++;
            }
        }
        
        return count;
    }
    
    /**
     * Method to check whether to print receipt or not. 
     * 
     * @return true is eligible for Print Receipt otherwise false.
     */
    public boolean isPrintRequired(){
    	return this.netPayInfoLines.stream()
				.anyMatch(netPayInfo -> netPayInfo.isEligibleForPrintReceipt());
    }
    
    /**
     * Method to check whether eligible for Electronic Receipt or not.
     * @return true is eligible for Electronic Receipt otherwise false.
     */
    public boolean isElectronicReceiptEligible(){
    	 return this.netPayInfoLines.stream()
    						.anyMatch(netPayInfo -> netPayInfo.isEligibleForElectronicReceipt());
    }
    
    /**
     * This method will return set of all the STAN which are eligible for
     * Electronic Receipt.
     * @return
     */
    public Set<Integer> getElectronicReceiptStanSet(){
    	return this.netPayInfoLines.stream()
    						.filter(netPayInfo -> netPayInfo.isEligibleForElectronicReceipt())
    						.map(netPayInfoStan -> netPayInfoStan.getSequenceNum())
    						.collect(Collectors.toSet());					 
    }

    /**
	 * If any netpayinfo has customer preference available we will say customer preference available
	 * @return true if customer preference is available for any net pay info line  otherwise false
	 */
	public boolean isCustomerReceiptPreferenceAvailable() {
		return this.netPayInfoLines.stream()
									.anyMatch(netPayInfo -> netPayInfo.getCustomerReceiptPreference() != null);
	}   
	
	/**
	 * If any netpayinfo has customer preference available we will say customer preference available
	 * @return true if customer preference is available for any net pay info line  otherwise false
	 */
	public boolean isCustomerPreferencePrompt() {
		return this.netPayInfoLines.stream()
									.anyMatch(netPayInfo -> netPayInfo.isPreferencePrompt());
	} 

    public EntryMethodDef getDobEntryMethod() {
		return ((dobEntryMethod != null) ? dobEntryMethod : EntryMethodDef.ENTRY_SKIPPED);
	}

	public void setDobEntryMethod(EntryMethodDef dobEntryMethod) {
		this.dobEntryMethod = dobEntryMethod;
	}
	
	/**
	 * Calculate the minimum age required to purchase all items in the current
	 * transaction
	 * 
	 * @return the minimum age to purchase all items in the transaction
	 */
	public int getMinimumAgeForPurchase() {
		return itemLines.stream().filter(item -> item.getMinimumAge() > 0)
				.mapToInt(item -> item.getMinimumAge()).max().orElse(0);
	}
	
	/**
	 * Determine the latest birthday allowed to be able to purchase all items in
	 * the current transaction
	 * 
	 * @return the latest birthday that allows purchase of all items, null if no
	 *         restriction
	 */
	public Date getLatestEligibleDOB() {
		return itemLines.stream().filter(item -> item.getEligibleDOB() != null)
				.map(item -> item.getEligibleDOB()).sorted().findFirst()
				.orElse(new Date());
	}

	/**
	 * Add set of departments that should not mix with items from other departments.
	 * @param depts set of departments 
	 */
	public void setRestrictDeptItems(Set<Integer> depts) {
		restrictDept.clear();
		restrictDept.addAll(depts);
	}

	/**
	 * Determine if the transaction has any item from departments that should not 
	 * mix with other departments.
	 * @return true if it has departments that should not be mixed.
	 */
	public boolean hasRestrictDeptItems(){
		return !restrictDept.isEmpty();
	}

	/**
	 * Departments that should not be mixed with items from other departments out
	 * of this set.
	 * 
	 * @return set of departments.
	 */
	public Set<Integer> getRestrictedDepts() {
		return restrictDept;
	}

	/**
	 * Determine if transaction has any items with transaction limit for the PLU
	 * or department.
	 * 
	 * @return true if there are any restricted PLU or department item in the
	 *         transaction
	 */
	public boolean hasRestrictedQtyItems() {
		return !deptMaxQtyPerTransMap.isEmpty() || !pluMaxQtyPerTransMap.isEmpty();
	}

	/*
     * Getter for the customer name and phone number on the food order. If configured the cashier
     * would be prompted for this info.
     */
	public FoodOrderCustomerDetails getFoodOrderCustomerDetails() {
		return foodOrderCustomerDetails;
	}

	/*
     	* Setter for the customer name and phone number on the food order. If configured the cashier
     	* would be prompted for this info.
     	*/
	public void setFoodOrderCustomerDetails(FoodOrderCustomerDetails foodOrderCustomerDetails) {
		this.foodOrderCustomerDetails = foodOrderCustomerDetails;
	}
	
	/**
	 * @return the canadianGST
	 */
	public boolean isCanadianGST() {
		return canadianGST;
	}

	/**
	 * @param canadianGST
	 */
	public void setCanadianGST(boolean canadianGST) {
		this.canadianGST = canadianGST;
	}

	/**
	 * @return the valueAddedTax
	 */
	public boolean isValueAddedTax() {
		return valueAddedTax;
	}

	/**
	 * @param valueAddedTax the valueAddedTax to set
	 */
	public void setValueAddedTax(boolean valueAddedTax) {
		this.valueAddedTax = valueAddedTax;
	}

	/**
	 * @return the primaryCurrency
	 */
	public String getPrimaryCurrencyName() {
	
		return primaryCurrencyName;
	}

	/**
	 * @param primaryCurrency the primaryCurrency to set
	 */
	public void setPrimaryCurrencyName(String primaryCurrencyName) {
		this.primaryCurrencyName = primaryCurrencyName;
	}

	/**
	 * @return the storeNumber
	 */
	public String getStoreNumber() {
		return storeNumber;
	}

	/**
	 * @param storeNumber the storeNumber to set
	 */
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
	
	/**
	 * Calculate customer's age given date of birth
	 * 
	 * @param dateOfBirth
	 * @return customer's age, 0 if DOB is in future
	 */
	private int getAge(Date dateOfBirth) {
		Calendar birthDate = Calendar.getInstance();
		birthDate.setTime(dateOfBirth);
		LocalDate dob = LocalDate.of(birthDate.get(Calendar.YEAR),
				birthDate.get(Calendar.MONTH) + 1,
				birthDate.get(Calendar.DAY_OF_MONTH));
		int age = Period.between(dob, LocalDate.now()).getYears();
		return (age > 0) ? age : 0;
	}
	/**
	 * Returns the count of sticky label enabled items
	 * in the transaction
	 * @return
	 */
	public int getStickyEnabledItemCount() {
		int count =0;
		for(ItemLine item:this.getItemLines()) {
			if(item.isStickyLabelNeeded() && !item.isVoided() && !item.isVoidLine()) {
				count += (int) item.getQuantity().getLongValue();
			}
			
		}
		
		return count;
		
	}
	/**
	 * Returns the Mandatory prompts sets for this transaction
	 * @return
	 */
	public Map<MANDATORY_PROMPT, List<ExceptionItem>> getPromptMap() {
		return promptMap;
	}
	
	/**
	 * Adds the mandatory prompt to the transaction 
	 * @param promptType
	 * @param ExceptionItem exceptionItem
	 */
	public void addPromptEntry(MANDATORY_PROMPT promptType, ExceptionItem exceptionItem) {
		List<ExceptionItem> exceptionList = promptMap.get(promptType);
		if(null == exceptionList) {
			exceptionList = new ArrayList<ExceptionItem>();
			
		}
		exceptionList.add(exceptionItem);
		this.promptMap.put(promptType,exceptionList);
		
	}
	/**
	 * Removes the specific prompt from the mandatory prompts
	 * @param promptType
	 */
	public void removePromptEntry(MANDATORY_PROMPT promptType) {
			this.promptMap.remove(promptType);
	}
	
	/**
	 * @return the itemLineCurSymbol
	 */
	public boolean isPrintCurrencySymbol() {
		return printCurrencySymbol;
	}

	/**
	 * @param itemLineCurSymbol the itemLineCurSymbol to set
	 */
	public void setPrintCurrencySymbol(boolean itemLineCurSymbol) {
		this.printCurrencySymbol = itemLineCurSymbol;
	}

	/**
	 * @return the itemLineUnitPrice
	 */
	public boolean isItemLineUnitPrice() {
		return itemLineUnitPrice;
	}

	/**
	 * @param itemLineUnitPrice the itemLineUnitPrice to set
	 */
	public void setItemLineUnitPrice(boolean itemLineUnitPrice) {
		this.itemLineUnitPrice = itemLineUnitPrice;
	}

	/**
	 * @return the printVerboseTotal
	 */
	public boolean isPrintVerboseTotal() {
		return printVerboseTotal;
	}

	/**
	 * @param printVerboseTotal the printVerboseTotal to set
	 */
	public void setPrintVerboseTotal(boolean printVerboseTotal) {
		this.printVerboseTotal = printVerboseTotal;
	}

	/**
	 * @return the taxSummaryTable
	 */
	public boolean isPrintTaxSummary() {
		return printTaxSummary;
	}

	/**
	 * @param taxSummaryTable the taxSummaryTable to set
	 */
	public void setPrintTaxSummary(boolean taxSummaryTable) {
		this.printTaxSummary = taxSummaryTable;
	}

	/**
	 * @return the printAllTaxes
	 */
	public boolean isPrintAllTaxes() {
		return printAllTaxes;
	}

	/**
	 * @param printAllTaxes the printAllTaxes to set
	 */
	public void setPrintAllTaxes(boolean printAllTaxes) {
		this.printAllTaxes = printAllTaxes;
	}

	/*
     * Getter for the ID Check Restriction Details.
     */
	public IDRestrictionDetails getIDRestrictionDetails() {
		return iDRestrictionDetails;
	}

	/*
	 * Setter for the ID Check RestrictionDetails.
	 */
	public void setIDRestrictionDetails(IDRestrictionDetails iDRestrictionDetails) {
		this.iDRestrictionDetails = iDRestrictionDetails;
	}

	/**
	 * PLU specific Transaction Quantity Limit
	 *  
	 * @param pluPK
	 * @return The Maximum Transaction Quantity Limit for the PLU
	 */
	public Quantity getPluMaxQtyPerTrans(PluPK pluPK) {
		return pluMaxQtyPerTransMap.get(pluPK);
	}

	/**
	 * Setter for PLU specific Transaction Quantity Limit
	 * 
	 * @param pluPK
	 * @param maxQtyPerTrans
	 */
	public void setPluMaxQtyPerTrans(PluPK pluPK, Quantity maxQtyPerTrans) {
		/*
		 * Assumption - the method is called only when maximum quantity is non-null
		 * and non-zero
		 */
		Quantity applicableQty = pluMaxQtyPerTransMap.get(pluPK);
		if ((applicableQty == null) || (applicableQty.compare(maxQtyPerTrans) > 0)) {
			this.pluMaxQtyPerTransMap.put(pluPK, maxQtyPerTrans);
		}
	}

	/**
	 * PLU specific Transaction Quantity Limit Map
	 * 
	 * @return
	 */
	public Map<PluPK, Quantity> getPluMaxQtyPerTransMap() {
		return pluMaxQtyPerTransMap;
	}

	/**
	 * Department specific Transaction Quantity Limit Map
	 * 
	 * @return
	 */

	public Map<Integer, Quantity> getDeptMaxQtyPerTransMap() {
		return deptMaxQtyPerTransMap;
	}
	
	/**
	 * Department specific Transaction Quantity Limit
	 * 
	 * @param departmentPK
	 * @return The Maximum Transaction Quantity Limit for the department
	 */
	public Quantity getDeptMaxQtyPerTrans(Integer deptNum) {
		return deptMaxQtyPerTransMap.get(deptNum);
	}

	/**
	 * Setter for Department specific Transaction Quantity Limit
	 * 
	 * @param deptNum
	 * @param maxQtyPerTrans
	 */
	public void setDeptMaxQtyPerTrans(Integer deptNum, Quantity maxQtyPerTrans) {
		/*
		 * Assumption - the method is called only when maximum quantity is non-null
		 * and non-zero
		 */
		Quantity applicableQty = deptMaxQtyPerTransMap.get(deptNum);
		if ((applicableQty == null) || (applicableQty.compare(maxQtyPerTrans) > 0)) {
			applicableQty = maxQtyPerTrans;
		}
		this.deptMaxQtyPerTransMap.put(deptNum, applicableQty);
	}

	/**
	 * Returns true, if ChangeCardReaderStatus is already sent for this transaction,
	 * false otherwise
	 * This flag is used in Shell - Thin Client set up.
	 * @return the isCRSSent
	 */
	public boolean isCRSSent() {
		return isCRSSent;
	}

	/**
	 *
	 * @param isCRSSent the isCRSSent to set
	 */
	public void setCRSSent(boolean isCRSSent) {
		this.isCRSSent = isCRSSent;
	}

	/**
	 * @return the totalProcessed
	 */
	public boolean isTotalProcessed() {
		return totalProcessed;
	}

	/**
	 * @param totalProcessed the totalProcessed to set
	 */
	public void setTotalProcessed(boolean totalProcessed) {
		this.totalProcessed = totalProcessed;
	}
	
	 
    /**
     *  Getter for property fiscalTaxExempt
     * @return fiscalTaxExempt
     */
    public FiscalTaxExemptInfo getFiscalTaxExemptInfo() {
		return fiscalTaxExemptInfo;
	}

	
	public boolean isCharityPrompted() {
		return charityPrompted;
	}
	
	public void setCharityPrompted(boolean prompted) {
		this.charityPrompted = prompted;
	}
	
    /**
     * Setter for property fiscalTaxExempt
     * @param fiscalTaxExempt
     */
	public void setFiscalTaxExemptInfo(FiscalTaxExemptInfo fiscalTaxExemptInfo) {
		this.fiscalTaxExemptInfo = fiscalTaxExemptInfo;
	}
	
	
	public Map<SoftKeyType, CashierID> getOverrideCashierIDs() {
		return overridenCashierIDMap;
	}

	public void addOverrideCashierID(SoftKeyType key, CashierID overrideCashierID) {
		this.overridenCashierIDMap.put(key, overrideCashierID);
	}

	public boolean isAttendantTransaction() {
		return attendantTransaction;
	}

	public void setAttendantTransaction(boolean attendantTransaction) {
		this.attendantTransaction = attendantTransaction;
	}

	public PosID getPhysicalRegisterID() {
		if (physicalRegisterID == null) {
			return posID;
		}
		return physicalRegisterID;
	}

	public void setPhysicalRegisterID(PosID physicalRegisterID) {
		this.physicalRegisterID = physicalRegisterID;
	}
}