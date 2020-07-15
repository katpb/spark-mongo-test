package com.verifone.isd.vsms2.sales.ent.trans;

import com.verifone.isd.vsms2.sales.ent.customerTax.CustomerTax;

/**
 * Entity class to hold Fiscal receipt details
 * @author Sumith_S1
 *
 */
public class FiscalReceiptInfo implements java.io.Serializable {
	
	private static final long serialVersionUID = -7866438504332928815L;

	private FiscalReceiptResponse fiscalReceiptResponse;
	
	private FiscalReceiptType fiscalReceiptType;
	
	private String merchantTaxIDName;
	private String merchantTaxIDNumber;
	
	private String receiptName;

	private String originalReceiptPrompt;
	private String originalTxnFiscalNumber;

	private String customerTaxIDName;
	private CustomerTax customerTaxInfo;

	private String voucherNumber;
	private String voucherCustomerNumber;
	

	public FiscalReceiptResponse getFiscalReceiptResponse() {
		return fiscalReceiptResponse;
	}
	public void setFiscalReceiptResponse(FiscalReceiptResponse fiscalReceiptResponse) {
		this.fiscalReceiptResponse = fiscalReceiptResponse;
	}

	public FiscalReceiptType getFiscalReceiptType() {
		return fiscalReceiptType;
	}
	public void setFiscalReceiptType(FiscalReceiptType fiscalReceiptType) {
		this.fiscalReceiptType = fiscalReceiptType;
	}

	public String getMerchantTaxIDName() {
		return merchantTaxIDName;
	}
	public void setMerchantTaxIDName(String merchantTaxIDName) {
		this.merchantTaxIDName = merchantTaxIDName;
	}

	public String getMerchantTaxIDNumber() {
		return merchantTaxIDNumber;
	}
	public void setMerchantTaxIDNumber(String merchantTaxIDNumber) {
		this.merchantTaxIDNumber = merchantTaxIDNumber;
	}

	public String getReceiptName() {
		return receiptName;
	}
	public void setReceiptName(String receiptName) {
		this.receiptName = receiptName;
	}
	
	public String getOriginalReceiptPrompt() {
		return originalReceiptPrompt;
	}
	public void setOriginalReceiptPrompt(String originalReceiptPrompt) {
		this.originalReceiptPrompt = originalReceiptPrompt;
	}
	public String getOriginalTxnFiscalNumber() {
		return originalTxnFiscalNumber;
	}
	public void setOriginalTxnFiscalNumber(String originalTxnFiscalNumber) {
		this.originalTxnFiscalNumber = originalTxnFiscalNumber;
	}

	public String getCustomerTaxIDName() {
		return customerTaxIDName;
	}

	public void setCustomerTaxIDName(String customerTaxIDName) {
		this.customerTaxIDName = customerTaxIDName;
	}

	public CustomerTax getCustomerTaxInfo() {
		return customerTaxInfo;
	}

	public void setCustomerTaxInfo(CustomerTax customerTaxInfo) {
		this.customerTaxInfo = customerTaxInfo;
	}

	public String getVoucherNumber() {
		return voucherNumber;
	}
	public void setVoucherNumber(String voucherNumber) {
		this.voucherNumber = voucherNumber;
	}

	public String getVoucherCustomerNumber() {
		return voucherCustomerNumber;
	}
	public void setVoucherCustomerNumber(String voucherCustomerNumber) {
		this.voucherCustomerNumber = voucherCustomerNumber;
	}
	
	@Override
	public String toString() {
		return "FiscalReceiptInfo {" + fiscalReceiptResponse
				+ ", fiscalReceiptType=" + fiscalReceiptType
				+ ", merchantTaxIDName=" + merchantTaxIDName
				+ ", merchantTaxIDNumber=" + merchantTaxIDNumber
				+ ", receiptName=" + receiptName
				+ ", originalReceiptPrompt=" + originalReceiptPrompt
				+ ", originalTxnFiscalNumber=" + originalTxnFiscalNumber
				+ ", customerTaxIDName=" + customerTaxIDName
				+ ", customerTaxInfo=" + customerTaxInfo
				+ ", voucherNumber=" + voucherNumber
				+ ", voucherCustomerNumber=" + voucherCustomerNumber + "}";
	}
}
