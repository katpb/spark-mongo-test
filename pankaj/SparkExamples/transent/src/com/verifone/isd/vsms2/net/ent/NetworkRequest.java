package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.util.MoneyAmount;

public class NetworkRequest implements java.io.Serializable {
    static final long serialVersionUID =  871865991733018234L;
    
    private short registerID;        // Topaz term id 101, ..., 110
    private int employeeID;          // Cashier ID
    private int shiftNum;            // Current shift number
    private NetTransactionTypesBase tranType;		// Transaction Type
    private MoneyAmount	amount;	   	// Transaction amount
    private NetPaymodeTypesBase payMode;// paymode, credit or debit
    private String approvalNumber;      // approval number
    private String pin;			// [MAXPIN+1] PIN block
    private String referenceNumber;     // Reference number from NetworkECPReply
    private short authSource;           // authorization source, host, voice, terminal
    private String authCode;            // Authorization code received from host
    private String restrictionCode;	// Voyager Restriction code
    private short flag;           	// special processing flags
    private short testCard;		// 1 if test card, 0 if not
    private MoneyAmount cashBack;  	// cashback
    private MoneyAmount cashBackFee;  	// cashback fee
    private MoneyAmount debitFee;       // debit fee
    private MoneyAmount	acctBalance;    // Prepaid Card Account Balance
    private long authDateTime;		// Authorization date and time
    private int sequenceNumber;         // Transaction sequence number
    private short pumpNumber;    	// pump number of pre-pay or cat sale
    private long ticketNumber;          // To be used only for auto refund
    private boolean storeAutoRefund;    // Indicates if card data needs to be stored on Gempro after receiving approval
    private int batchNumber;            // Batch number
    private String userData;            // To be used for passing data obtained from Topaz to Gempro.  Implemented for Quick Credit
    private CardData primaryCard;       // To store primary card data in case of dual card swipes (e.g. Manatec)
    private int misc1Index;             // Used to convey Manatec misc prompt code
    private int misc2Index;             // Used to convey Manatec misc prompt code
    private String oriMsgCode;          // Original message code used by Void message
    private String referral;            // Banknet Referral Number (MC only)
    private String settlement;          // Settlement Date (MC only)
    private String epsName;				//Store the eps name for later refund
    
    public NetworkRequest() {
        amount = new MoneyAmount(0);
        payMode = NetPaymodeTypesBase.PAY_CREDIT;
        tranType = NetTransactionTypesBase.TRAN_SALE;
        approvalNumber = "";
        pin = "";
        restrictionCode = "";
        cashBack = new MoneyAmount(0);
        cashBackFee = new MoneyAmount(0);
        debitFee = new MoneyAmount(0);
        acctBalance = new MoneyAmount(0);
        userData = "";
        authCode = "";
        referenceNumber = "";
        primaryCard = new CardData();
        oriMsgCode = "";
        referral = "";
        settlement = "";
    }
    
    public NetworkRequest(short registerID) {
        this();
        setRegisterID(registerID);
    }
    
    public short getRegisterID()  {
        return this.registerID;
    }
    
    public void setRegisterID(short registerID)  {
        this.registerID = registerID;
    }
    
    public int getEmployeeID() {
        return this.employeeID;
    }
    
    public void setEmployeeID(int employee) {
        this.employeeID = employee;
    }
    
    public int getShiftNum() {
        return this.shiftNum;
    }
    
    public void setShiftNum(int shift) {
        this.shiftNum = shift;
    }
    
    public void setTranType(NetTransactionTypesBase tranType) throws NetworkException {
        this.tranType = tranType;
    }
    
    public NetTransactionTypesBase getTranType() {
        return this.tranType;
    }
    
    public void setAmount(MoneyAmount amount) {
        this.amount = amount;
    }
    
    public MoneyAmount getAmount() {
        return this.amount;
    }
    
    public void setPayMode(NetPaymodeTypesBase payMode) {
        this.payMode = payMode;
    }
    
    public NetPaymodeTypesBase getPayMode() {
        return this.payMode;
    }
    
    public String getApprovalNumber() {
        return this.approvalNumber;
    }
    
    public void setApprovalNumber(String approvalNumber) {
        this.approvalNumber = approvalNumber;
    }
    
    public String getPin() {
        return this.pin;
    }
    
    public void setPin(String pin) {
        this.pin = pin;
    }
    
    public String getReferenceNumber() {
        return this.referenceNumber;
    }
    
    public void setReferenceNumber(String ref) {
        this.referenceNumber = ref;
    }
    
    public short getAuthSource() {
        return this.authSource;
    }
    
    public void setAuthSource(short authSource) {
        this.authSource = authSource;
    }
    
    public void setRestrictionCode(String restrictionCode) {
        this.restrictionCode = restrictionCode;
    }
    
    public String getRestrictionCode() {
        return this.restrictionCode;
    }
    
    public void setFlag(short flag) {
        this.flag = flag;
    }
    
    public short getFlag() {
        return this.flag;
    }
    
    public void setTestCard(short testCard) {
        this.testCard = testCard;
    }
    
    public short getTestCard() {
        return this.testCard;
    }
    
    public void setCashBack(MoneyAmount cashBack) {
        this.cashBack = cashBack;
    }
    
    public MoneyAmount getCashBack() {
        return this.cashBack;
    }
    
    public void setCashBackFee(MoneyAmount cashBackFee) {
        this.cashBackFee = cashBackFee;
    }
    
    public MoneyAmount getCashBackFee() {
        return this.cashBackFee;
    }
    
    public void setDebitFee(MoneyAmount debitFee) {
        this.debitFee = debitFee;
    }
    
    public MoneyAmount getDebitFee() {
        return this.debitFee;
    }
    
    public void setAcctBalance(MoneyAmount acctBalance) {
        this.acctBalance = acctBalance;
    }
    
    public MoneyAmount getAcctBalance() {
        return this.acctBalance;
    }
    
    public void setAuthDateTime(long authDateTime) {
        this.authDateTime = authDateTime;
    }
    
    public long getAuthDateTime() {
        return this.authDateTime;
    }
    
    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
    
    public String getAuthCode() {
        return this.authCode;
    }
    
    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }
    
    public int getSequenceNumber() {
        return this.sequenceNumber;
    }
    
    public void setPumpNumber(short pumpNumber) {
        this.pumpNumber = pumpNumber;
    }
    
    public short getPumpNumber() {
        return this.pumpNumber;
    }
    
    public void setTicketNumber(long ticket) {
        this.ticketNumber = ticket;
    }
    
    public long getTicketNumber() {
        return this.ticketNumber;
    }
    
    public boolean isStoreAutoRefund() {
        return this.storeAutoRefund;
    }
    
    public void setStoreAutoRefund(boolean autoRefund) {
        this.storeAutoRefund = autoRefund;
    }
    
    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }
    
    public int getBatchNumber() {
        return this.batchNumber;
    }
    
    public void setUserData(String userData) {
        this.userData = userData;
    }
    
    public String getUserData() {
        return this.userData;
    }
    
    public void setPrimaryCard(CardData primary) {
        this.primaryCard = primary;
    }
    
    public CardData getPrimaryCard() {
        return this.primaryCard;
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
    
    public String getOriMsgCode() {
        return this.oriMsgCode;
    }
    
    public void setOriMsgCode(String oriMsgCode) {
        this.oriMsgCode = oriMsgCode;
    }
    
    public String getReferral() {
        return this.referral;
    }
    
    public void setReferral(String referral) {
        this.referral = referral;
    }
    
    public String getSettlement() {
        return this.settlement;
    }
    
    public void setSettlement(String settlement) {
        this.settlement = settlement;
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
}
