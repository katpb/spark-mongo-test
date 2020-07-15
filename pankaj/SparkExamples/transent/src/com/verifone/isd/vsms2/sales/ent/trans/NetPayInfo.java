/*
 * NetPayInfo.java
 *
 * Created on June 25, 2003, 2:57 PM
 */

package com.verifone.isd.vsms2.sales.ent.trans;

import java.io.Serializable;

import com.verifone.isd.vsms2.net.ent.AcctPrintInfo;
import com.verifone.isd.vsms2.net.ent.DiscretionaryDataReceiptPreferenceEnum;
import com.verifone.isd.vsms2.net.ent.EncryptReceiptInfo;
import com.verifone.isd.vsms2.net.ent.EntryMethodDef;
import com.verifone.isd.vsms2.net.ent.NetPaymodeTypesBase;
import com.verifone.isd.vsms2.sys.util.FormattedLine;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/** Helper entity for Transaction that holds credit card related info
 * when a Network MOP (Debit, Credit) is used
 * @author Anindya_D1
 */
public class NetPayInfo implements Serializable {
	private static final long serialVersionUID = -7371254647517564165L;

	private static final String EMPTY_STRING = "";
    private String accountNum;
    private String maskedAcctNum;
    private String expiryDate;
    private long authDateTime;  // Auth date and time of transaction
    private NetPaymodeTypesBase payMode;       // Debit or Credit
    private int cardType;       // Card type from ISO record
    private String ccType;      // Card type name (VISA) from ISO record
    private String ccName;      // Card Holder's name
    private String svcCode;
    private String track1;
    private String track2;
    private String hostID;
    private String authCode;
    private String ticket;
    private String tranType;        // Will print on receipt... either SALE, REFUND, or VOID
    private EntryMethodDef entryMethod;
    private int batchNum;
    private int sequenceNum;
    private MoneyAmount fee;
    private String replyMsg;
    private String refNum;
    private String origInvoice;
    private String merchantID;
    private String terminalID;
    private boolean refundable;     // Indicates if this network payment may be saved for prepay autorefund
    private boolean voidInVoid;     // Indicates if this payment is to be voided if split tender is followed by void ticket
    private MoneyAmount payment;    // Stores the amount for this pay line to be used for voids
    private MoneyAmount acctBalance;    // Account balance - for prepaid cards only
    private MoneyAmount prevAcctBal;    // Previous account balance - for prepaid cards only
    private String traceNum;        // Trace number for prepaid card and ebt transactions
    private String authSource;      // Debit/EBT authorizer
    private String accountType;     // Debit/EBT account type
    private MoneyAmount ebtCashBalance;  // Cash balance for EBT transactions
    private MoneyAmount ebtFSBalance;    // Food Stamp balance for EBT transactions
	private MoneyAmount ebtCashLedgerBalance; // Cash Benefit Ledger balance for EBT transactions
    private MoneyAmount ebtFSLedgerBalance; // Food Stamp Ledger balance for EBT transactions
    private int handling;                // handling code from network transaction
    private FormattedLine[] merchTextLines;		// receipt message for merchant copy
    private FormattedLine[] custTextLines;		// receipt message for customer copy
    private FormattedLine[] custSupplementTextLines; //receipt message for supplement receipt
    private String[] hostMessages;      // Messages from the host that need to be printed on the receipt
    private boolean preserveReceiptText;        // Indicates we need to preserve declined receipt text
    private boolean forcePostPayment;	// to indicate force post type of payment
    private AcctPrintInfo acctPrintInfo;
    private EncryptReceiptInfo encData;	// store encrypted data for receipt reprint    
    private boolean smallCreditAmount=false; //Holds Small credit flag
    private String sigCapture;	// to hold the signature
    private String sigFileName;
    private String sigMimeType;
    private int cashCreditPricingLvl = 0;
    private String optionalReceiptMessage; /** Holds network receipt message **/	
    private int acquirerBatchNum;   /* Acquirer batch from network host */
    private boolean proprietary;	// indicates if authorized by a proprietary payment network
    private boolean preauth;		// indicates if this is associated with a pre-auth payment line
    private boolean reversalPending;	// indicates reversal needs to be attempted from background
    private boolean failedReversal;	// indicates payment reversal failed for this payment line
    private String epsName;		// EPS name for payment
    private String failureResult;	// indicates OverallResult for a failed reversal or advice
    private MobileSLAData mobileSLAData; // holds the mobile SLA auth data(transRefId, hostId and hostName) to be populated in mobile advice
   
	private String aboveSiteCardType; // above site card type 

	private DiscretionaryDataReceiptPreferenceEnum customerReceiptPreference;
    
    
    /** Creates a new instance of NetPayInfo */
    public NetPayInfo() {
        this.hostMessages = new String[0];
        this.merchTextLines = new FormattedLine[0];
        this.custTextLines = new FormattedLine[0];
        this.custSupplementTextLines = new FormattedLine[0];
    }
    
    public String getAccountNum() {
    	if (accountNum == null){
    		// logger.info("NetPayInfo returning null account number");
    	    return EMPTY_STRING;
    	}
        return this.accountNum;
    }
    
    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }
    
    /**
	 * @return the maskedAcctNum
	 */
	public String getMaskedAcctNum() {
		return maskedAcctNum;
	}

	/**
	 * @param maskedAcctNum the maskedAcctNum to set
	 */
	public void setMaskedAcctNum(String maskedAcctNum) {
		this.maskedAcctNum = maskedAcctNum;
	}

	public String getExpiryDate() {
        return this.expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    
    public long getAuthDateTime() {
        return this.authDateTime;
    }

    public void setAuthDateTime(long authDateTime) {
        this.authDateTime = authDateTime;
    }
    
    public NetPaymodeTypesBase getPayMode() {
		return this.payMode != null ? this.payMode
				: NetPaymodeTypesBase.PAY_CREDIT;
    }
    
    public void setPayMode(NetPaymodeTypesBase payMode) {
        this.payMode = payMode;
    }
    
    public String getCCName() {
        return this.ccName;
    }
    
    public void setCCName(String ccName) {
        this.ccName = ccName;
    }
    
    public String getCCType() {
        return this.ccType;
    }
    
    public void setCCType(String ccType) {
        this.ccType = ccType;
    }
    
    public int getCardType() {
        return this.cardType;
    }
    
    public void setCardType(int cardType) {
        this.cardType = cardType;
    }
    
    public String getSvcCode() {
        return this.svcCode;
    }
    
    public void setSvcCode(String svcCode) {
        this.svcCode = svcCode;
    }
    
    public String getTrack1() {
        return this.track1;
    }
    
    public void setTrack1(String track1) {
        this.track1 = track1;
    }
    
    public String getTrack2() {
        return this.track2;
    }
    
    public void setTrack2(String track2) {
        this.track2 = track2;
    }
    
    /**
     * In order to be backward compatible with old network implementations, we provide
     * a way to retrieve index-based fleet prompts from the HashMap.
     * @param index
     * @return The prompt string
     */
    public String getPinData(int index) {
		return null;
	}
    
    /** Getter method that returns the PIN data at that key.  The key is
     *  usually the prompt label as specified by the host.
     * @param label identifier of the data to be retrieved.
     * @return The PIN data as determined by the prompt label
     */
    public String getPinData(String label) {
        return null;
    }
    
    /**
	 * In order to be backward compatible with old network implementations, we
	 * provide a way to store index-based fleet prompts from the HashMap.
	 * 
	 * @param index
	 * @param pinEntry
	 */
    public void setPinData(int index, String pinEntry) {
	}
	
    /**
	 * Setter method that stores the fleet data in the pinprompt area. It is
	 * stored by its prompt label as identified by a host or card table entry.
	 * 
	 * @param pinData
	 *            The fleet data obtained from the PIN Pad or keyboard
	 * @param label
	 *            Key to store the fleet data. This key is typically the prompt
	 *            label as specified by the host.
	 */
	public void setPinData(String pinData, String label) {
	}
	
    /**
	 * Get an array of all the pindata label strings contained. This will be
	 * used only by networks which receive a prompt label (or ID) from the host
	 * or card table.
	 */
	public String[] getPinDataLabels() {
		return new String[0];
    }
	
	/**
	 * Return the fleet data entries in an array of strings. This can be used by
	 * networks that use index-based fleet prompts as well as the networks that
	 * use the ID (String) based fleet prompts. We need to have a standard way
	 * to populate the fleet data entries in the transaction XML.
	 * 
	 * @return Fleet Data entry strings.
	 */
	public String[] getPinDataEntries() {
		return new String[0];
	}
    
    public String getHostID() {
        return this.hostID;
    }
    
    public void setHostID(String hostID) {
        this.hostID = hostID;
    }
    
    public String getAuthCode() {
        return this.authCode;
    }
    
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
    
    public String getTicket() {
        return this.ticket;
    }
    
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
    
    public String getTranType() {
        return this.tranType;
    }
    
    public void setTranType(String tranType) {
        this.tranType = tranType;
    }
    
    public String getEntryMethod() {
        return this.entryMethod.getDescription();
    }
    
    public void setEntryMethod(EntryMethodDef entryMethod) {
        this.entryMethod = entryMethod;
    }
    
    public EntryMethodDef getEntryMethodObj() {
    	return this.entryMethod;
    }
    
    public int getBatchNum() {
        return this.batchNum;
    }
    
    public void setBatchNum(int batchNum) {
        this.batchNum = batchNum;
    }
    
    public int getSequenceNum() {
        return this.sequenceNum;
    }
    
    public void setSequenceNum(int sequenceNum) {
        this.sequenceNum = sequenceNum;
    }
    
    public MoneyAmount getFee() {
        return this.fee;
    }
    
    public void setFee(MoneyAmount fee) {
        this.fee = fee;
    }
    
    public String getReplyMsg() {
        return this.replyMsg;
    }
    
    public void setReplyMsg(String replyMsg) {
        this.replyMsg = replyMsg;
    }
    
    public String getRefNum() {
        return this.refNum;
    }
    
    public void setRefNum(String refNum) {
        this.refNum = refNum;
    }
    
    public String getOrigInvoice() {
        return this.origInvoice;
    }
    
    public void setOrigInvoice(String origInvoice) {
        this.origInvoice = origInvoice;
    }
    
    public String getMerchantID() {
        return this.merchantID;
    }
    
    public void setMerchantID(String merchantID) {
        this.merchantID = merchantID;
    }
    
    public String getTerminalID() {
        return this.terminalID;
    }
    
    public void setTerminalID(String terminalID) {
        this.terminalID = terminalID;
    }
    
    public boolean isRefundable() {
        return this.refundable;
    }
    
    public void setRefundable(boolean bRefund) {
        this.refundable = bRefund;
    }
    
    public boolean isVoidInVoid() {
        return this.voidInVoid;
    }
    
    public void setVoidInVoid(boolean yesNo) {
        this.voidInVoid = yesNo;
    }
    
    public MoneyAmount getPayment() {
        return this.payment;
    }
    
    public void setPayment(MoneyAmount money) {
        this.payment = money;
    }
    
    public MoneyAmount getAcctBalance() {
        return this.acctBalance;
    }
    
    public void setAcctBalance(MoneyAmount money) {
        this.acctBalance = money;
    }
    
    public MoneyAmount getPrevAcctBal() {
        return this.prevAcctBal;
    }
    
    public void setPrevAcctBal(MoneyAmount money) {
        this.prevAcctBal = money;
    }
    
    public String getTraceNum() {
        return this.traceNum;
    }
    
    public void setTraceNum(String someNum) {
        this.traceNum = someNum;
    }
    
    public String getAuthSource() {
        return this.authSource;
    }
    
    public void setAuthSource(String authSrc) {
        this.authSource = authSrc;
    }
    
    public String getAccountType() {
        return this.accountType;
    }
    
    public void setAccountType(String acctType) {
        this.accountType = acctType;
    }
    
    public MoneyAmount getEbtCashBalance() {
        return this.ebtCashBalance;
    }
    
    public void setEbtCashBalance(MoneyAmount ebtCB) {
        this.ebtCashBalance = ebtCB;
    }
    
    public MoneyAmount getEbtFSBalance() {
        return this.ebtFSBalance;
    }
    
    public void setEbtFSBalance(MoneyAmount ebtFS) {
        this.ebtFSBalance = ebtFS;
    }
    
	public MoneyAmount getEbtCashLedgerBalance() {
        return this.ebtCashLedgerBalance;
    }
    
    public void setEbtCashLedgerBalance(MoneyAmount ebtCB) {
        this.ebtCashLedgerBalance = ebtCB;
    }
    
    public MoneyAmount getEbtFSLedgerBalance() {
        return this.ebtFSLedgerBalance;
    }
    
    public void setEbtFSLedgerBalance(MoneyAmount ebtFS) {
        this.ebtFSLedgerBalance = ebtFS;
    }
    
    public int getHandling() {
        return this.handling;
    }
    
    public void setHandling(int handling) {
        this.handling = handling;
    }
	/**
	 * @return Returns the custCopyText.
	 */
	public String[] getCustCopyText() {
		String[] lines = new String[custTextLines.length];
		for (int i = 0; i < custTextLines.length; i++) {
			if (custTextLines[i] != null) {
				lines[i] = custTextLines[i].getLine();
			} else {
				lines[i] = EMPTY_STRING;
			}
		}
		return lines;
	}
	/**
	 * @param custCopyText The custCopyText to set.
	 */
	public void setCustCopyText(String[] custCopyText) {
		this.custTextLines = new FormattedLine[0];
		if (custCopyText != null) {
			this.custTextLines = new FormattedLine[custCopyText.length];
			for (int i = 0; i < custCopyText.length; i++) {
				this.custTextLines[i] = new FormattedLine();
				this.custTextLines[i].setLine(custCopyText[i]);
			}
		}
	}
	/**
	 * @return Returns the merchCopyText.
	 */
	public String[] getMerchCopyText() {
		String[] lines = new String[merchTextLines.length];
		for (int i = 0; i < merchTextLines.length; i++) {
			if (merchTextLines[i] != null) {
				lines[i] = merchTextLines[i].getLine();
			} else {
				lines[i] = EMPTY_STRING;
			}
		}
		return lines;
	}
	/**
	 * @param merchCopyText The merchCopyText to set.
	 */
	public void setMerchCopyText(String[] merchCopyText) {
		this.merchTextLines = new FormattedLine[0];
		if (merchCopyText != null) {
			this.merchTextLines = new FormattedLine[merchCopyText.length];
			for (int i = 0; i < merchCopyText.length; i++) {
				this.merchTextLines[i] = new FormattedLine();
				this.merchTextLines[i].setLine(merchCopyText[i]);
			}
		}
	}
    
    /**
	 * @return the custTextLines
	 */
	public FormattedLine[] getCustTextLines() {
		return custTextLines;
	}

	/**
	 * @param custTextLines the custTextLines to set
	 */
	public void setCustTextLines(FormattedLine[] custTextLines) {
		if (custTextLines != null) {
			this.custTextLines = custTextLines;
		}
	}

	/**
	 * @return the merchTextLines
	 */
	public FormattedLine[] getMerchTextLines() {
		return merchTextLines;
	}

	/**
	 * @param merchTextLines the merchTextLines to set
	 */
	public void setMerchTextLines(FormattedLine[] merchTextLines) {
		if (merchTextLines != null) {
			this.merchTextLines = merchTextLines;
		}
	}

	public String[] getHostMessages() {
        return this.hostMessages;
    }
    
    public void setHostMessages(String[] hostMessages) {
        this.hostMessages = hostMessages;
    }
    
    public String getHostMessage(int index) {
        if ((index >= 0) && (index < this.hostMessages.length)) {
            return this.hostMessages[index];
        }
        else {
            return null;
        }
    }
    
    public void setHostMessage(int index, String hostMessage) {
        if ((index >= 0) && (index < this.hostMessages.length)) {
            this.hostMessages[index] = hostMessage;
        }
    }
    
    /**
	 * @return the preserveReceiptText
	 */
	public boolean isPreserveReceiptText() {
		return preserveReceiptText;
	}

	/**
	 * @param preserveReceiptText the preserveReceiptText to set
	 */
	public void setPreserveReceiptText(boolean preserveReceiptText) {
		this.preserveReceiptText = preserveReceiptText;
	}

	/**
	 * @return Returns the forcePostPayment.
	 */
	public boolean isForcePostPayment() {
		return forcePostPayment;
	}
	/**
	 * @param forcePostPayment The forcePostPayment to set.
	 */
	public void setForcePostPayment(boolean forcePostPayment) {
		this.forcePostPayment = forcePostPayment;
	}
    /**
     * @return Returns the acctPrintInfo.
     */
    public AcctPrintInfo getAcctPrintInfo() {
        return acctPrintInfo;
    }
    /**
     * @param acctPrintInfo The acctPrintInfo to set.
     */
    public void setAcctPrintInfo(AcctPrintInfo acctPrintInfo) {
        this.acctPrintInfo = acctPrintInfo;
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
     * @param		TransactionVisitor
     * @return		void
        * @exception	Exception
     */
    
    public void acceptVisitor(TransactionVisitor v) throws Exception {
        v.visit(this);
    }

	/**
	 * Preserve backward compatibility
	 * 
	 * @return Returns the encrypted account number
	 */
	public String getEncryptedAccountNum() {
		if (this.encData != null) {
			return encData.getEncAccountNum();
		} else {
			return null;
		}
	}

	/**
	 * Preserve backward compatibilty. Store the encrypted account number.
	 * 
	 * @param encryptedAccountNum
	 *            the encrypted account number to be stored
	 */
	public void setEncryptedAccountNum(String encryptedAccountNum) {
		if (encData == null) {
			encData = new EncryptReceiptInfo();
		}
		encData.setEncAccountNum(encryptedAccountNum);
	}

	/**
	 * @return the encData
	 */
	public EncryptReceiptInfo getEncData() {
		return encData;
	}

	/**
	 * @param encData the encData to set
	 */
	public void setEncData(EncryptReceiptInfo encData) {
		this.encData = encData;
    }

/**
	 * 
	 * @return Returns SmallCredit flag
	 */
	 public boolean isSmallCreditAmt() {
		 
		 return smallCreditAmount;
	    }
	 
    /**
	 * @param smallCreditFlag  flag
	 */
	public void setSmallCreditAmt(boolean smallCreditFlag){
		
		this.smallCreditAmount=smallCreditFlag;
    }
	/**
	 * 
	 * @return Signature String
	 */
	public String getSigCapture() {
		return sigCapture;
	}

	/**
	 * 
	 * @param Signature String
	 */
	public void setSigCapture(String sigCapture) {
		this.sigCapture = sigCapture;
	}

	/**
	 * @return the signature File Name
	 */
	public String getSigFileName() {
		return sigFileName;
	}

	/**
	 * @param sigFileName the signature File Name to set
	 */
	public void setSigFileName(String sigFileName) {
		this.sigFileName = sigFileName;
	}

	/**
	 * @return the signature MimeType
	 */
	public String getSigMimeType() {
		return sigMimeType;
	}

	/**
	 * @param sigMimeType the signature MimeType to set
	 */
	public void setSigMimeType(String sigMimeType) {
		this.sigMimeType = sigMimeType;
    }
    
	/**
	 * 
	 * @return Returns cashCreditPricing value
	 */
	 public int getCashCreditPricingLvl() {
		 
		 return cashCreditPricingLvl;
	    }
	 
    /**
	 * @param cashCreditPricing value
	 */
	public void setCashCreditPricingLvl(int cashCreditPricingLvl){
		
		this.cashCreditPricingLvl=cashCreditPricingLvl;
    }
    
    /**
     * @param optionalReceiptMessage
     */
	public void setOptionalReceiptMessage(String optionalReceiptMessage){
		
		this.optionalReceiptMessage=optionalReceiptMessage;
    }
	
	/**
	 * @return optionalReceiptMessage
	 */
	public String getOptionalReceiptMessage(){
		
		return this.optionalReceiptMessage;
    }

	/**
	 * @return the acquirerBatchNum
	 */
	public int getAcquirerBatchNum() {
		return acquirerBatchNum;
	}

	/**
	 * @param acquirerBatchNum the acquirerBatchNum to set
	 */
	public void setAcquirerBatchNum(int acquirerBatchNum) {
		this.acquirerBatchNum = acquirerBatchNum;
	}
	
	/**
	 * @return the proprietary
	 */
	public boolean isProprietary() {
		return proprietary;
	}

	/**
	 * @param proprietary the proprietary to set
	 */
	public void setProprietary(boolean proprietary) {
		this.proprietary = proprietary;
	}

	/**
	 * @return the preauth
	 */
	public boolean isPreauth() {
		return preauth;
	}

	/**
	 * @param preauth the preauth to set
	 */
	public void setPreauth(boolean preauth) {
		this.preauth = preauth;
	}

	/**
	 * @return the failedReversal
	 */
	public boolean isFailedReversal() {
		return failedReversal;
	}

	/**
	 * @param failedReversal the failedReversal to set
	 */
	public void setFailedReversal(boolean failedReversal) {
		this.failedReversal = failedReversal;
	}

	/**
	 * @return the epsName
	 */
	public String getEpsName() {
		return epsName;
	}

	/**
	 * @param epsName the epsName to set
	 */
	public void setEpsName(String epsName) {
		this.epsName = epsName;
	}

	/**
	 * @return the failureResult
	 */
	public String getFailureResult() {
		return failureResult;
	}

	/**
	 * @param failureResult the failureResult to set
	 */
	public void setFailureResult(String failureResult) {
		this.failureResult = failureResult;
	}

	/**
	 * @return the reversalPending
	 */
	public boolean isReversalPending() {
		return reversalPending;
	}

	/**
	 * @param reversalPending the reversalPending to set
	 */
	public void setReversalPending(boolean reversalPending) {
		this.reversalPending = reversalPending;
	}

	/**
	 * 
	 * @return text for supplement receipt
	 */
	public FormattedLine[] getCustSupplementTextLines() {
		return custSupplementTextLines;
	}

	/**
	 * 
	 * @param custSupplementTextLines
	 */
	public void setCustSupplementTextLines(FormattedLine[] custSupplementTextLines) {
		this.custSupplementTextLines = custSupplementTextLines;
	}

	/**
	 * @return the mobileSLAData
	 */
	public MobileSLAData getMobileSLAData() {
		if(mobileSLAData == null){
			mobileSLAData = new MobileSLAData();
		}
		return mobileSLAData;
	}

	/**
	 * @param mobileSLAData the mobileSLAData to set
	 */
	public void setMobileSLAData(MobileSLAData mobileSLAData) {
		this.mobileSLAData = mobileSLAData;
	}
	
	/**
	 * @return ASA Above Site CardType
	 */
	public String getAboveSiteCardType() {
		return aboveSiteCardType;
	}
	/**
	 * @param aboveSiteCardType
	 */
	public void setAboveSiteCardType(String hostCardType) {
		this.aboveSiteCardType = hostCardType;
	}

	/** Getter for customerReceiptPreference.
	 * 
	 * @return customerReceiptPreference
	 */
	public DiscretionaryDataReceiptPreferenceEnum getCustomerReceiptPreference() {
		return customerReceiptPreference;
	}

	/**
	 * Setter for customerReceiptPreference.
	 * @param receiptPreference
	 */
	public void setCustomerReceiptPreference(DiscretionaryDataReceiptPreferenceEnum receiptPreference) {
		this.customerReceiptPreference = receiptPreference;
	}
	
	/**
	 * Method to return whether the eligible for electronic receipt or not.
	 * @return
	 */
	public boolean isEligibleForElectronicReceipt(){
		boolean eligible = false;
		if(this.customerReceiptPreference != null 
				&& this.customerReceiptPreference.isElectronicReceipt()
				&& !this.isPreserveReceiptText()){
			eligible = true;
		}
		return eligible;
	}
	
	/**
	 * Method to return whether the eligible for printing the receipt or not.
	 */
	public boolean isEligibleForPrintReceipt(){
		boolean eligible = false;
		if(this.customerReceiptPreference != null 
				&& this.customerReceiptPreference.isPrintReceipt()
				&& !this.isPreserveReceiptText()){
			eligible = true;
		}
		return eligible;
	}
	/**
	 * Method to return whether the Prompt is the preference.
	 */
	public boolean isPreferencePrompt(){
		boolean prompt = false;
		if(this.customerReceiptPreference != null 
				&& this.customerReceiptPreference.isPromptReceipt()
				&& !this.isPreserveReceiptText()){
			prompt = true;
		}
		return prompt;
	}
	
    /**
    * Determine if EPS sent receipt details in a payment transaction. This will
    * be used to offer receipt choices at the DCR when a payment card is declined.
    * 
     * @return true if EPS provided payment receipt information 
     */
    public boolean hasEpsReceipt() {
           boolean epsReceipt = false;
           if ((merchTextLines != null && merchTextLines.length > 0)
                        || (custTextLines != null && custTextLines.length > 0)
                        || (custSupplementTextLines != null && custSupplementTextLines.length > 0)) {
                  epsReceipt = true;
           }
           return epsReceipt;
    }

	
}
