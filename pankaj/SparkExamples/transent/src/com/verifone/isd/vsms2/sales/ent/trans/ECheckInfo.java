/*
 * Created on Aug 9, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.verifone.isd.vsms2.sales.ent.trans;

import java.io.Serializable;
import java.util.ArrayList;
import com.verifone.isd.vsms2.sys.util.*;


/**
 * Helper entity for Transaction that holds e-check related info
 * @author Sudesh_s1
 */
public class ECheckInfo implements Serializable {

//    TODO serialVersionUID 
//    static final long serialVersionUID = -5369952706084863095L;
    private MoneyAmount amount;
    private int batchNum;
    private int sequenceNum;
    private String billingControlNumber;
    private String accountNum;
    private String checkNum;
    private String approvalCode;
    private String traceID;
    private ArrayList merchantReceipt;
    private ArrayList customerReceipt;


    public MoneyAmount getAmount() {
        return amount;
    }

    public void setAmount(MoneyAmount amount) {
        this.amount = amount;
    }

    public int getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(int batchNum) {
        this.batchNum = batchNum;
    }

    public int getSequenceNum() {
        return sequenceNum;
    }

    public void setSequenceNum(int sequenceNum) {
        this.sequenceNum = sequenceNum;
    }

    public String getBillingControlNumber() {
        return billingControlNumber;
    }

    public void setBillingControlNumber(String billingControlNumber) {
        this.billingControlNumber = billingControlNumber;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getCheckNum() {
        return checkNum;
    }

    public void setCheckNum(String checkNum) {
        this.checkNum = checkNum;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public String getTraceID() {
        return traceID;
    }

    public void setTraceID(String traceID) {
        this.traceID = traceID;
    }

    public ArrayList getMerchantReceipt() {
        return merchantReceipt;
    }

    public void setMerchantReceipt(ArrayList merchantReceipt) {
        this.merchantReceipt = merchantReceipt;
    }

    public ArrayList getCustomerReceipt() {
        return customerReceipt;
    }

    public void setCustomerReceipt(ArrayList customerReceipt) {
        this.customerReceipt = customerReceipt;
    }

    public void acceptVisitor(TransactionVisitor v) throws Exception {
        v.visit(this);
    }
    
}
