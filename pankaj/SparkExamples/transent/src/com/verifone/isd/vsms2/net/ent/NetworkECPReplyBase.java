package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import com.verifone.isd.vsms2.net.ent.NetDebitReply;
import com.verifone.isd.vsms2.net.ent.NetEBTReply;
import com.verifone.isd.vsms2.net.ent.prodrest.IProdRestInfo;
import com.verifone.isd.vsms2.net.ent.prodrest.ProdRestrictionException;
import java.io.Serializable;

public class NetworkECPReplyBase implements IProdRestInfo, Serializable {
    
    static final long serialVersionUID = -887162315022444777L;
    
    public static final int APPROVED = 0;           /* network approval stored in status */
    public static final int REJECTED = 1;           /* network reject stored in status */
    
    private int status;
    private int handling;
    private MoneyAmount	amount;
    private MoneyAmount accountBalance;
    private MoneyAmount cashback;
    private int batchNumber;
    private int sequenceNumber;
    private String replyMessage;
    private String approvalNumber;
    private String authCode;
    private String referenceNumber;
    private int authSource;
    private long authDateTime;	// Authorization date and time
    private MoneyAmount fee;
    private boolean secondCardReqd;     // if a 2nd card swipe is needed to process authorization
    private int promptCode;     // Bit mask indicating further prompt data required from customer
    private boolean pinEntryReqd;   // A second authorization request is required with the PIN data
    private int[] productsAllowed;     // Customer needs to be restricted to the given product list
    private NetDebitReply netDebitReply;   
    private NetEBTReply netEBTReply;   
    private int misc1Index;     // Used to convey Manatec misc prompt code
    private int misc2Index;     // Used to convey Manatec misc prompt code
    private String optRcptMsg;	// optional receipt message received from host
    private EncryptReceiptInfo encInfo;	// store encrypted data required for receipt reprint
    private boolean imprintReceipt;	
    
    public NetworkECPReplyBase() {
    }
    
    public int getStatus() {
        return this.status;
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
    
    public int getHandling() {
        return this.handling;
    }
    
    public void setHandling(int handling) {
        this.handling = handling;
    }
    
    public void setAmount(MoneyAmount amount) {
        this.amount = amount;
    }
    
    public MoneyAmount getAmount() {
        return this.amount;
    }
    
    public MoneyAmount getAccountBalance() {
        return this.accountBalance;
    }
    
    public MoneyAmount getCashback() {
        return this.cashback;
    }
    
    public void setCashback(MoneyAmount amount) {
        this.cashback = amount;
    }
    
    public void setAccountBalance(MoneyAmount accountBalance) {
        this.accountBalance = accountBalance;
    }
    
    /**
     * Getter for property fee.
     * @return Value of property fee.
     */
    public MoneyAmount getFee() {
        return this.fee;
    }
    
    /**
     * Setter for property fee.
     * @param fee New value of property fee.
     */
    public void setFee(MoneyAmount fee) {
        this.fee = fee;
    }
    
    /**
     * Getter for property batchNumber.
     * @return Value of property batchNumber.
     */
    public int getBatchNumber() {
        return this.batchNumber;
    }
    
    /**
     * Setter for property batchNumber.
     * @param batchNumber New value of property batchNumber.
     */
    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }
    
    public int getSequenceNumber() {
        return this.sequenceNumber;
    }
    
    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }
    
    public String getReplyMessage() {
        return this.replyMessage;
    }
    
    public void setReplyMessage(String replyMessage) {
        this.replyMessage = replyMessage;
    }
    
    public String getApprovalNumber() {
        return this.approvalNumber;
    }
    
    public void setApprovalNumber(String approvalNumber) {
        this.approvalNumber = approvalNumber;
    }
    
    public String getAuthCode() {
        return this.authCode;
    }
    
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
    
    public String getReferenceNumber() {
        return this.referenceNumber;
    }
    
    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }
    
    public int getAuthSource() {
        return this.authSource;
    }
    
    public void setAuthSource(int authSource) {
        this.authSource = authSource;
    }
    
    public void setAuthDateTime(long authDateTime) {
        this.authDateTime = authDateTime;
    }
    
    public long getAuthDateTime() {
        return this.authDateTime;
    }
    
    public boolean isSecondCardReqd() {
        return this.secondCardReqd;
    }
    
    public void setSecondCardReqd(boolean reqd) {
        this.secondCardReqd = reqd;
    }
    
    public int getPromptCode() {
        return this.promptCode;
    }
    
    public void setPromptCode(int mask) {
        this.promptCode = mask;
    }
    
    public boolean isPinEntryReqd() {
        return this.pinEntryReqd;
    }
    
    public void setPinEntryReqd(boolean reqd) {
        this.pinEntryReqd = reqd;
    }
    
    public int[] getProductsAllowed() {
        return this.productsAllowed;
    }
    
    public void setProductsAllowed(int[] allowed) {
        this.productsAllowed = allowed;
    }
    
    public NetDebitReply getNetDebitReply() {
        return this.netDebitReply;
    }
    
    public void setNetDebitReply(NetDebitReply netDebitReply) {
        this.netDebitReply = netDebitReply;
    }
    
    public NetEBTReply getNetEBTReply() {
        return this.netEBTReply;
    }
    
    public void setNetEBTReply(NetEBTReply netEBTReply) {
        this.netEBTReply = netEBTReply;
    }
    
    public int getMisc1Index() {
        return this.misc1Index;
    }
    
    public void setMisc1Index(int index) {
        this.misc1Index = index;
    }
    
    public int getMisc2Index() {
        return this.misc2Index;
    }
    
    public void setMisc2Index(int index) {
        this.misc2Index = index;
    }
    
    /**
	 * @return Returns the optRcptMsg.
	 */
	public String getOptRcptMsg() {
		return optRcptMsg;
	}
	/**
	 * @param optRcptMsg The optRcptMsg to set.
	 */
	public void setOptRcptMsg(String optRcptMsg) {
		this.optRcptMsg = optRcptMsg;
	}
    /**
	 * App-specific extensions will define the behavior when the credit card
	 * needs to be manually imprinted.
	 * 
	 * @return true if imprint credit card, false otherwise
	 */
    public boolean isImprintReceipt() {
        return this.imprintReceipt;
    }
    
	/**
	 * @param imprintReceipt The imprintReceipt to set.
	 */
	public void setImprintReceipt(boolean imprintReceipt) {
		this.imprintReceipt = imprintReceipt;
    }

	/**
	 * For backward compatibility
	 * 
	 * @return Returns the encrypted account number
	 */
	public String getEncryptedAccountNum() {
		if (encInfo != null) {
			return encInfo.getEncAccountNum();
		} else {
			return null;
		}
	}

	/**
	 * For backward compatibility. Store the encrypted account number.
	 * 
	 * @param encryptedAccountNum
	 *            the encrypted account number to set.
	 */
	public void setEncryptedAccountNum(String encryptedAccountNum) {
		if (encInfo == null) {
			encInfo = new EncryptReceiptInfo();
		}
		encInfo.setEncAccountNum(encryptedAccountNum);
	}

	/**
	 * @return the encInfo
	 */
	public EncryptReceiptInfo getEncInfo() {
		return encInfo;
	}

	/**
	 * @param encInfo the encInfo to set
	 */
	public void setEncInfo(EncryptReceiptInfo encInfo) {
		this.encInfo = encInfo;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verifone.isd.vsms2.net.ent.prodrest.IProdRestInfo#getRestrictionType()
	 */
	public String getRestrictionType() {
		/**
		 * Currently implements only "Refer" type product restriction that a
		 * list of allowed product codes will be available from the network
		 * host. In future, we may implement "Fuel Only" type of restriction
		 * based on additional information received from host.
		 */
		if ((this.productsAllowed == null)
				|| (this.productsAllowed.length == 0)) {
			return null;
		} else {
			return IProdRestInfo.REFER_RESTRICTION_TYPE;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verifone.isd.vsms2.net.ent.prodrest.IProdRestInfo#isValidProd(int)
	 */
	public boolean isValidProd(int productCode) throws ProdRestrictionException {
		boolean valid = false;
		if ((productsAllowed != null) && (productsAllowed.length > 0)) {
			for (int i = 0; i < productsAllowed.length; i++) {
				if (this.productsAllowed[i] == productCode) {
					valid = true;
					break;
				}
			}
		} else {
			valid = true;
		}
		return valid;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.verifone.isd.vsms2.net.ent.prodrest.IProdRestInfo#isValidProd(com.verifone.isd.vsms2.net.ent.NetProduct)
	 */
	public boolean isValidProd(NetProduct product)
			throws ProdRestrictionException {
		return this.isValidProd(product.getProdCode());
	}

    /* (non-Javadoc)
     * @see com.verifone.isd.vsms2.net.ent.prodrest.IProdRestInfo#getDefaultWarningDisplayMsg()
     */
    public String getDefaultWarningDisplayMsg() {
        // TODO Auto-generated method stub -- IProdRestInfo contract
        return null;
    }

    /* (non-Javadoc)
     * @see com.verifone.isd.vsms2.net.ent.prodrest.IProdRestInfo#getDefaultWarningPrintMsg()
     */
    public String getDefaultWarningPrintMsg() {
        // TODO Auto-generated method stub -- IProdRestInfo contract
        return null;
    }
}
