/*
 * SvcActInfo.java
 *
 * Created on December 8, 2003, 11:30 AM
 */

package com.verifone.isd.vsms2.sales.ent.trans;

import java.io.Serializable;

import com.verifone.isd.vsms2.net.ent.AcctPrintInfo;
import com.verifone.isd.vsms2.sales.ent.plu.PluPK;
import com.verifone.isd.vsms2.sales.ent.prodcode.ProdCode;
import com.verifone.isd.vsms2.sys.l10n.LocalizedRB;
import com.verifone.isd.vsms2.sys.l10n.NetworkRes;
import com.verifone.isd.vsms2.sys.l10n.TopazRes;
import com.verifone.isd.vsms2.sys.util.FormattedLine;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/**
 * Helper entity for Transaction that holds information related to
 * SVC activation / recharge when it is part of a sale.
 * @author Anindya_D1
 */
public class SvcActInfo implements Serializable {
    
	static final long serialVersionUID = 5978062565389305985L;
	public static final int SVC_REQ_PENDING = 1;
    public static final int SVC_REQ_SUCCESSFUL = 2;
    public static final int SVC_REQ_FAILED = 3;
    public static final int SVC_REQ_REVERSED = 4;
    public static final int SVC_REQ_VOIDED = 5;
    public static final int SVC_REV_PENDING = 6;
    
    public static final int SVC_ACTIVATION_ITEM = 1;
    public static final int SVC_RECHARGE_ITEM = 2;
    
    public static final int SVC_VOID_ACTIVATION_ITEM = 1;
    public static final int SVC_VOID_RECHARGE_ITEM = 2;

	private String description;
    private String track1Data;
    private String track2Data;
    private String accountNum;
    private String expiryDate;
    private String ccType;      // Card type name (VISA) from ISO record
    private String ccName;      // Card Holder's name
    private String authCode;
	private String authSrc;
    private String ticket;
    private boolean bActivation;     // Activation or Recharge
    private String entryMethod;
    private int batchNum;
    private int sequenceNum;
    private int handling;
    private int svcStatus;          // Pending, successful or failed
    private String replyMsg;
    private String refNum;
    private MoneyAmount reqAmt;     // Activation or recharge amount requested 
    private MoneyAmount balance;    // SVC card balance to be printed on receipt
    private String rejectCause;     // If the SVC operation was rejected locally
    private String traceNum;        // Trace number for prepaid activation / recharge
    private long timeDateAuth;      // Activation/Recharge timestamp from Network
    private boolean manEntryRestricted;	// If manual entry of payment cards not allowed
    private AcctPrintInfo acctPrintInfo;
    private boolean isCardLoadItem;
    private FormattedLine[] merchTextLines;		// receipt message for merchant copy
    private FormattedLine[] custTextLines;		// receipt message for customer copy
	private FormattedLine[] custSupplementTextLines; //receipt message for customer gift copy (chit)
	private FormattedLine[] custSupplementHeader;
	
	
	private String[] hostMessages;      // Messages from the host that need to be printed on the receipt
	
	private PluPK pluNumber;
	private ProdCode productCode; // Product code of the item line.
	private String networkName; // Network in which the EPSPrepaid item is configured.
	private String extendedUpc; // Extended UPC information coming with EPSPrepaid extended UPC items.
	private boolean failedreversal;	// reversal failed for this activation
    
	
	private boolean voidActivation;//type of refund - VOID ACTIVATION
	private boolean voidRecharge;//type of refund - VOID RECHARGE

	
    /** Creates a new instance of SvcActInfo */
    public SvcActInfo() {
        this.merchTextLines = new FormattedLine[0];
        this.custTextLines = new FormattedLine[0];
		this.hostMessages = new String[0];
		this.custSupplementTextLines = new FormattedLine[0];
		this.custSupplementHeader = new FormattedLine[0];

    }
    
    public String getTrack1Data() {
        return track1Data;
    }
    
    public void setTrack1Data(String track1Data) {
        this.track1Data = track1Data;
    }
    
    public String getTrack2Data() {
        return track2Data;
    }

    public void setTrack2Data(String track2Data) {
        this.track2Data = track2Data;
    }

    public String getAccountNum() {
        return this.accountNum;
    }
    
    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }
    
    public String getExpiryDate() {
        return this.expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
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
    
    public String getAuthCode() {
        return this.authCode;
    }
    
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

	public String getAuthSrc() {
        return this.authSrc;
    }
    
    public void setAuthSrc(String authSrc) {
        this.authSrc = authSrc;
    }
    
    public String getTicket() {
        return this.ticket;
    }
    
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
    
    public boolean isActivation() {
        return this.bActivation;
    }
    
    public void setActivation(boolean bActivation) {
        this.bActivation = bActivation;
    }
    
    public String getEntryMethod() {
        return this.entryMethod;
    }
    
    public void setEntryMethod(String entryMethod) {
        this.entryMethod = entryMethod;
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
    
    public int getHandling() {
        return this.handling;
    }
    
    public void setHandling(int handling) {
        this.handling = handling;
    }
    
    public int getSvcStatus() {
        return this.svcStatus;
    }
    
    public void setSvcStatus(int svcStatus) {
        this.svcStatus = svcStatus;
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
    
    public MoneyAmount getReqAmt() {
        return this.reqAmt;
    }
    
    public void setReqAmt(MoneyAmount amount) {
        this.reqAmt = amount;
    }
    
    public MoneyAmount getBalance() {
        return this.balance;
    }
    
    public void setBalance(MoneyAmount balance) {
        this.balance = balance;
    }
    
    public String getRejectCause() {
        return this.rejectCause;
    }
    
    public void setRejectCause(String someCause) {
        this.rejectCause = someCause;
    }
    
    public String getTraceNum() {
        return this.traceNum;
    }
    
    public void setTraceNum(String someNum) {
        this.traceNum = someNum;
    }
    
    public void setTimeDateAuth(long timeDateAuth) {
        this.timeDateAuth = timeDateAuth;
    }
    
    public long getTimeDateAuth() {
        return this.timeDateAuth;
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
	 * @return Returns the manEntryRestricted.
	 */
	public boolean isManEntryRestricted() {
		return manEntryRestricted;
	}
	
	/**
	 * @param manEntryRestricted The manEntryRestricted to set.
	 */
	public void setManEntryRestricted(boolean manEntryRestricted) {
		this.manEntryRestricted = manEntryRestricted;
	}

   /**
     * @return the isCardLoadItem
     */
    public boolean isCardLoadItem() {
        return isCardLoadItem;
    }

    /**
     * @param isCardLoadItem the isCardLoadItem to set
     */
    public void setCardLoadItem(boolean isCardLoadItem) {
        this.isCardLoadItem = isCardLoadItem;
    }

	/**
	 * @return Returns the custCopyText.
	 */
	public String[] getCustCopyText() {
		String[] lines = new String[custTextLines.length];
		for (int i = 0; i < custTextLines.length; i++) {
			if (custTextLines[i] != null) {
				lines[i] = custTextLines[i].getLine();
			}
		}
		return lines;
	}
	/**
	 * @param custCopyText The custCopyText to set.
	 */
	public void setCustCopyText(String[] custCopyText) {
		this.custTextLines = new FormattedLine[custCopyText.length];
		for (int i = 0; i < custCopyText.length; i++) {
			this.custTextLines[i] = new FormattedLine();
			this.custTextLines[i].setLine(custCopyText[i]);
		}
	}
	/**
	 * @return Returns the custSupplementText.
	 */
	public String[] getCustSupplementText() {
		String[] lines = null;
		if(custSupplementTextLines != null){
			lines = new String[custSupplementTextLines.length];
			for (int i = 0; i < custSupplementTextLines.length; i++) {
				if (custSupplementTextLines[i] != null) {
					lines[i] = custSupplementTextLines[i].getLine();
				}
			}
		}
		return lines;
	}
	/**
	 * @param custSupplementText The custSupplementText to set.
	 */
	public void setCustSupplementText(String[] custSupplementTex) {
		if(custSupplementTex != null){
			this.custSupplementTextLines = new FormattedLine[custSupplementTex.length];
			for (int i = 0; i < custSupplementTex.length; i++) {
				this.custSupplementTextLines[i] = new FormattedLine();
				this.custSupplementTextLines[i].setLine(custSupplementTex[i]);
			}
		}
	}
	
    public FormattedLine[] getCustSupplementHeader() {
		return custSupplementHeader;
	}

	public void setCustSupplementHeader(FormattedLine[] custSupplementHeader) {
		this.custSupplementHeader = custSupplementHeader;
	}
	
	
	/**
	 * @return Returns the merchCopyText.
	 */
	public String[] getMerchCopyText() {
		String[] lines = new String[merchTextLines.length];
		for (int i = 0; i < merchTextLines.length; i++) {
			if (merchTextLines[i] != null) {
				lines[i] = merchTextLines[i].getLine();
			}
		}
		return lines;
	}
	
	/**
	 * @param merchCopyText The merchCopyText to set.
	 */
	public void setMerchCopyText(String[] merchCopyText) {
		this.merchTextLines = new FormattedLine[merchCopyText.length];
		for (int i = 0; i < merchCopyText.length; i++) {
			this.merchTextLines[i] = new FormattedLine();
			this.merchTextLines[i].setLine(merchCopyText[i]);
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
		this.custTextLines = custTextLines;
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
		this.merchTextLines = merchTextLines;
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

	public String getNetworkName() {
		return networkName;
	}

	public void setNetworkName(String networkName) {
		this.networkName = networkName;
	}

	public String getExtendedUpc() {
		return extendedUpc;
	}

	public void setExtendedUpc(String extendedUpc) {
		this.extendedUpc = extendedUpc;
	}

	public ProdCode getProductCode() {
		return productCode;
	}

	public void setProductCode(ProdCode productCode) {
		this.productCode = productCode;
	}

	public PluPK getPluNumber() {
		return pluNumber;
	}

	public void setPluNumber(PluPK pluNumber) {
		this.pluNumber = pluNumber;
	}

	public FormattedLine[] getCustSupplementTextLines() {
		return custSupplementTextLines;
	}

	public void setCustSupplementTextLines(FormattedLine[] custSupplementTextLines) {
		this.custSupplementTextLines = custSupplementTextLines;
	}
	
	/**
	 * @return the failedreversal
	 */
	public boolean isFailedreversal() {
		return failedreversal;
	}

	/**
	 * @param failedreversal the failedreversal to set
	 */
	public void setFailedreversal(boolean failedreversal) {
		this.failedreversal = failedreversal;
	}

	/**
	 * This method will check the SvcActInfo is an EPSPrepaid type by checking the networkName 
	 * present or not.
	 * @return : Is EPSPrepaid item or not.
	 */
	
	public boolean isEpsPrepaid(){
		boolean isEpsPrepaidItem = false;
		if(networkName!= null && networkName.trim().length() > 0) {
			isEpsPrepaidItem = true;
		}
		return isEpsPrepaidItem;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isVoidActivation() {
		return voidActivation;
	}

	public void setVoidActivation(boolean voidActivation) {
		this.voidActivation = voidActivation;
	}

	public boolean isVoidRecharge() {
		return voidRecharge;
	}

	public void setVoidRecharge(boolean voidRecharge) {
		this.voidRecharge = voidRecharge;
	}
	
	/**
	 * This method returns the error Message when SVC Refund fails.
	 * This error Message is used either to print on receipt 
	 * or display a flash error message on Topaz.
	 * 
	 * @param isRcptMsg - will error message be used to print on receipt or not?
	 * @return errorMsg - the error message
	 */	
	public String getSVCRefundErrorMsg(boolean isRcptMsg)
	{
		String errorMsg = LocalizedRB.getNetworkRes(NetworkRes.REFUND_OP_FAILED);


		if(this.isEpsPrepaid() && isRcptMsg)
		{
			errorMsg = LocalizedRB.getNetworkRes(NetworkRes.EPSPREPAID_REFUND_FAILED);							
		}
		else if(this.isEpsPrepaid() && !isRcptMsg)
		{
			errorMsg = TopazRes.REFUND_FAILED;	
		}
		else if(this.isVoidActivation())
		{
			errorMsg = LocalizedRB.getNetworkRes(NetworkRes.VOID_ACT_FAILED);							
		}
		else if(this.isVoidRecharge())
		{
			errorMsg = LocalizedRB.getNetworkRes(NetworkRes.VOID_RECH_FAILED);
		}


		return errorMsg;
	}	

}
 