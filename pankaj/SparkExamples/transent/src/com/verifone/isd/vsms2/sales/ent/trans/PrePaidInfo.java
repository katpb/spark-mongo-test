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
public class PrePaidInfo implements Serializable {
    

//    TODO serialVersionUID 
//    static final long serialVersionUID = -5369952706084863095L;
    private MoneyAmount amount;
    private String accountNumber;
    private String status;
    private String refNumber;
    private String approvalCode;
    private String transactionID;
    
    private ArrayList trailerText;
    private ArrayList instructionText;
    private ArrayList promotionText;
    private ArrayList termsAndConditionText; 

    public MoneyAmount getAmount() {
        return amount;
    }

    public void setAmount(MoneyAmount amount) {
        this.amount = amount;
    }


    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public ArrayList getTrailerText() {
        return trailerText;
    }

    public void setTrailerText(ArrayList trailerText) {
        this.trailerText = trailerText;
    }

    public ArrayList getInstructionText() {
        return instructionText;
    }

    public void setInstructionText(ArrayList instructionText) {
        this.instructionText = instructionText;
    }

    public ArrayList getPromotionText() {
        return promotionText;
    }

    public void setPromotionText(ArrayList promotionText) {
        this.promotionText = promotionText;
    }

    public ArrayList getTermsAndConditionText() {
        return termsAndConditionText;
    }

    public void setTermsAndConditionText(ArrayList termsAndConditionText) {
        this.termsAndConditionText = termsAndConditionText;
    }
    
}
