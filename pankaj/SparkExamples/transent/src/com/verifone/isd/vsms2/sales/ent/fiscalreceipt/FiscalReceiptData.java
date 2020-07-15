package com.verifone.isd.vsms2.sales.ent.fiscalreceipt;

import java.io.Serializable;
import java.util.Date;

import com.verifone.isd.vsms2.sales.ent.trans.FiscalReceiptType;
import com.verifone.isd.xml.vocabulary.IXMLVocabulary;

/** Helper class for FiscalReceipts
 * @author "mailto:mike_r3@verifone.com"
 * @version 1.0
 */
public class FiscalReceiptData implements Serializable {

	private static final long serialVersionUID = -6286826337629805036L;

	private FiscalReceiptType fiscalReceiptType;
    private String receiptName;
    private String receiptPrefix;
    private String beginSequence;
    private String endSequence;
    private String nextSequence;
    private boolean updateNextSequence = false;
    private String merchantTaxIdNumber;
    private String authName;
    private String authNumber;
    private String startAuthDateLabel;
    private Date startAuthDate;
    private String endAuthDateLabel;
    private Date endAuthDate;
    private FiscalReceiptFinalConsumerPromptType finalConsumerPrompt = FiscalReceiptFinalConsumerPromptType.DEFAULT;
    private boolean enableCustomerDataPrompt = false;
    private boolean enableOriginalReceiptPrompt = false;
    private String originalReceiptPrompt;
    private boolean enableVoucherNumPrompt = false;

	public FiscalReceiptData() {
	}

	public FiscalReceiptType getFiscalReceiptType() {
		return fiscalReceiptType;
	}

	public void setFiscalReceiptType(FiscalReceiptType fiscalReceiptType) {
		this.fiscalReceiptType = fiscalReceiptType;
	}

	public String getReceiptName() {
		return receiptName;
	}

	public void setReceiptName(String receiptName) {
		this.receiptName = receiptName;
	}

	public String getReceiptPrefix() {
		return receiptPrefix;
	}

	public void setReceiptPrefix(String receiptPrefix) {
		this.receiptPrefix = receiptPrefix;
	}

	public String getBeginSequence() {
		return beginSequence;
	}

	public void setBeginSequence(String beginSequence) {
		this.beginSequence = beginSequence;
	}

	public String getEndSequence() {
		return endSequence;
	}

	public void setEndSequence(String endSequence) {
		this.endSequence = endSequence;
	}

	public String getNextSequence() {
		return nextSequence;
	}

	public void setNextSequence(String nextSequence) {
		this.nextSequence = nextSequence;
	}

	public boolean isUpdateNextSequence() {
		return updateNextSequence;
	}

	public void setUpdateNextSequence(boolean updateNextSequence) {
		this.updateNextSequence = updateNextSequence;
	}

	public String getMerchantTaxIdNumber() {
		return merchantTaxIdNumber;
	}

	public void setMerchantTaxIdNumber(String merchantTaxIdNumber) {
		this.merchantTaxIdNumber = merchantTaxIdNumber;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public String getAuthNumber() {
		return authNumber;
	}

	public void setAuthNumber(String authNumber) {
		this.authNumber = authNumber;
	}

	public String getStartAuthDateLabel() {
		return startAuthDateLabel;
	}

	public void setStartAuthDateLabel(String startAuthDateLabel) {
		this.startAuthDateLabel = startAuthDateLabel;
	}

	public Date getStartAuthDate() {
		return startAuthDate;
	}

	public void setStartAuthDate(Date startAuthDate) {
		this.startAuthDate = startAuthDate;
	}

	public String getEndAuthDateLabel() {
		return endAuthDateLabel;
	}

	public void setEndAuthDateLabel(String endAuthDateLabel) {
		this.endAuthDateLabel = endAuthDateLabel;
	}

	public Date getEndAuthDate() {
		return endAuthDate;
	}

	public void setEndAuthDate(Date endAuthDate) {
		this.endAuthDate = endAuthDate;
	}

	public FiscalReceiptFinalConsumerPromptType getFinalConsumerPrompt() {
		return finalConsumerPrompt;
	}

	public void setFinalConsumerPrompt(FiscalReceiptFinalConsumerPromptType finalConsumerPrompt) {
		this.finalConsumerPrompt = finalConsumerPrompt;
	}

	public boolean isEnableCustomerDataPrompt() {
		return enableCustomerDataPrompt;
	}

	public void setEnableCustomerDataPrompt(boolean enableCustomerDataPrompt) {
		this.enableCustomerDataPrompt = enableCustomerDataPrompt;
	}

	public boolean isEnableOriginalReceiptPrompt() {
		return enableOriginalReceiptPrompt;
	}

	public void setEnableOriginalReceiptPrompt(boolean enableOriginalReceiptPrompt) {
		this.enableOriginalReceiptPrompt = enableOriginalReceiptPrompt;
	}

	public String getOriginalReceiptPrompt() {
		return originalReceiptPrompt;
	}

	public void setOriginalReceiptPrompt(String originalReceiptPrompt) {
		this.originalReceiptPrompt = originalReceiptPrompt;
	}

	public boolean isEnableVoucherNumPrompt() {
		return enableVoucherNumPrompt;
	}

	public void setEnableVoucherNumPrompt(boolean enableVoucherNumPrompt) {
		this.enableVoucherNumPrompt = enableVoucherNumPrompt;
	}

	@Override
	public String toString() {
		return "FiscalReceiptData [fiscalReceiptType=" + fiscalReceiptType + ", receiptName=" + receiptName
				+ ", receiptPrefix=" + receiptPrefix + ", beginSequence=" + beginSequence + ", endSequence="
				+ endSequence + ", nextSequence=" + nextSequence + ", updateNextSequence=" + updateNextSequence
				+ ", merchantTaxIdNumber=" + merchantTaxIdNumber + ", authName=" + authName + ", authNumber="
				+ authNumber + ", startAuthDateLabel=" + startAuthDateLabel + ", startAuthDate=" + startAuthDate
				+ ", endAuthDateLabel=" + endAuthDateLabel + ", endAuthDate=" + endAuthDate + ", finalConsumerPrompt="
				+ finalConsumerPrompt + ", enableCustomerDataPrompt=" + enableCustomerDataPrompt
				+ ", enableOriginalReceiptPrompt=" + enableOriginalReceiptPrompt + ", originalReceiptPrompt="
				+ originalReceiptPrompt + ", enableVoucherNumPrompt=" + enableVoucherNumPrompt + "]";
	}
}