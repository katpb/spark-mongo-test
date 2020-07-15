/*
 * NetEBTReply.java
 *
 * Created on March 21, 2005, 2:29 PM
 */

package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/**
 *
 * @author  Brenda_W
 */
public class NetEBTReply implements java.io.Serializable{
    static final long serialVersionUID =  4707467244617302302L;
    
    private MoneyAmount foodStampBalance;
    private MoneyAmount cashBenefitBalance;
	private MoneyAmount foodStampLedgerBalance;
    private MoneyAmount cashBenefitLedgerBalance;
	private String ebtAuthorizer;
	private String ebtAccountType;
	private String ebtTraceNumber;

    
    /** Creates a new instance of NetEBTReply */
    public NetEBTReply() {
		foodStampBalance = new MoneyAmount(0);
		cashBenefitBalance = new MoneyAmount(0);
		foodStampLedgerBalance = new MoneyAmount(0);
		cashBenefitLedgerBalance = new MoneyAmount(0);
		ebtAuthorizer = new String("");
		ebtAccountType = new String("");
		ebtTraceNumber = new String("");
    }
    
    public String getEBTAuthorizer() {
        return this.ebtAuthorizer;
    }
    
    public void setEBTAuthorizer(String ebtAuthorizer) {
        this.ebtAuthorizer = ebtAuthorizer;
    }
    
    public String getEBTAccountType() {
        return this.ebtAccountType;
    }
    
    public void setEBTAccountType(String ebtAccountType) {
        this.ebtAccountType = ebtAccountType;
    }
    
    public String getEBTTraceNumber() {
        return this.ebtTraceNumber;
    }
    
    public void setEBTTraceNumber(String ebtTraceNumber) {
        this.ebtTraceNumber = ebtTraceNumber;
    }
    
    public MoneyAmount getFoodStampAccountBalance() {
        return this.foodStampBalance;
    }
    
    public void setFoodStampAccountBalance(MoneyAmount accountBalance) {
        this.foodStampBalance = accountBalance;
    }
    
    public MoneyAmount getCashBenefitAccountBalance() {
        return this.cashBenefitBalance;
    }
    
    public void setCashBenefitAccountBalance(MoneyAmount accountBalance) {
        this.cashBenefitBalance = accountBalance;
    }

	public MoneyAmount getFoodStampLedgerBalance() {
        return this.foodStampLedgerBalance;
    }
    
    public void setFoodStampLedgerBalance(MoneyAmount ledgerBalance) {
        this.foodStampLedgerBalance = ledgerBalance;
    }
    
    public MoneyAmount getCashBenefitLedgerBalance() {
        return this.cashBenefitLedgerBalance;
    }
    
    public void setCashBenefitLedgerBalance(MoneyAmount ledgerBalance) {
        this.cashBenefitLedgerBalance = ledgerBalance;
    }
    
    
}
