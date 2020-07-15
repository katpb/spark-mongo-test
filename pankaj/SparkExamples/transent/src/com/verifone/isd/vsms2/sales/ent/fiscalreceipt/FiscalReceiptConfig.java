package com.verifone.isd.vsms2.sales.ent.fiscalreceipt;

import com.verifone.isd.vsms2.sales.ent.IEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.IEntityVisitor;
import com.verifone.isd.vsms2.sales.ent.trans.FiscalReceiptType;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/** Main class for Fiscal Receipt Configuration
 * @author "mailto:mike_r3@verifone.com"
 * @version 1.0
 */
public class FiscalReceiptConfig implements IEntityVisitable, IEntityObject {
	
	private static final long serialVersionUID = 7066135510652072386L;

	private String merchantTaxIdName;
	private String customerTaxIdName;
	private int customerTaxIdMinLen;
	private int customerTaxIdMaxLen;
	private FiscalReceiptTaxIDCheckDigitType taxIdCheckDigit = FiscalReceiptTaxIDCheckDigitType.NONE;
	private int endSeqAlarmThreshold;
	private int endAuthDateAlarmThreshold = 15;
	private boolean taxIdDatabase;
	private boolean customerName;
	private boolean customerAddress;
	private boolean commonSeqAPT;
	private int commonAPTRegisterId;
	private boolean currencyAllAmounts;
	private boolean printUnitPrice;
	private boolean printWrittenAmount;
	private boolean printTaxSummary;
	private boolean printAllTaxes;
	private Map<Integer, FiscalRegisterData> fiscalRegisterDataMap;

	private FiscalReceiptConfigPK pk;

	public FiscalReceiptConfig() {
		this.fiscalRegisterDataMap = Collections.synchronizedMap(new HashMap<Integer, FiscalRegisterData>());
	}

	public static String getFiscalSequenceName(FiscalReceiptType fsType, int registerNum) {
		return fsType.toString() + Integer.toString(registerNum);
	}

	public String getMerchantTaxIdName() {
		return merchantTaxIdName;
	}

	public void setMerchantTaxIdName(String merchantTaxIdName) {
		this.merchantTaxIdName = merchantTaxIdName;
	}

	public String getCustomerTaxIdName() {
		return customerTaxIdName;
	}

	public void setCustomerTaxIdName(String customerTaxIdName) {
		this.customerTaxIdName = customerTaxIdName;
	}

	public int getCustomerTaxIdMinLen() {
		return customerTaxIdMinLen;
	}

	public void setCustomerTaxIdMinLen(int customerTaxIdMinLen) {
		this.customerTaxIdMinLen = customerTaxIdMinLen;
	}

	public int getCustomerTaxIdMaxLen() {
		return customerTaxIdMaxLen;
	}

	public void setCustomerTaxIdMaxLen(int customerTaxIdMaxLen) {
		this.customerTaxIdMaxLen = customerTaxIdMaxLen;
	}

	public int getEndSeqAlarmThreshold() {
		return endSeqAlarmThreshold;
	}

	public void setEndSeqAlarmThreshold(int endSeqAlarmThreshold) {
		this.endSeqAlarmThreshold = endSeqAlarmThreshold;
	}
    
	public FiscalReceiptTaxIDCheckDigitType getTaxIdCheckDigit() {
		return taxIdCheckDigit;
	}

	public void setTaxIdCheckDigit(FiscalReceiptTaxIDCheckDigitType taxIdCheckDigit) {
		this.taxIdCheckDigit = taxIdCheckDigit;
	}

	public int getEndAuthDateAlarmThreshold() {
		return endAuthDateAlarmThreshold;
	}

	public void setEndAuthDateAlarmThreshold(int endAuthDateAlarmThreshold) {
		this.endAuthDateAlarmThreshold = endAuthDateAlarmThreshold;
	}

	public boolean isTaxIdDatabase() {
		return taxIdDatabase;
	}

	public void setTaxIdDatabase(boolean taxIdDatabase) {
		this.taxIdDatabase = taxIdDatabase;
	}

	public boolean isCustomerName() {
		return customerName;
	}

	public void setCustomerName(boolean customerName) {
		this.customerName = customerName;
	}

	public boolean isCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(boolean customerAddress) {
		this.customerAddress = customerAddress;
	}

	public boolean isCommonSeqAPT() {
		return commonSeqAPT;
	}

	public void setCommonSeqAPT(boolean commonSeqAPT) {
		this.commonSeqAPT = commonSeqAPT;
	}

	public int getCommonAPTRegisterId() {
		return commonAPTRegisterId;
	}

	public void setCommonAPTRegisterId(int commonAPTRegisterId) {
		this.commonAPTRegisterId = commonAPTRegisterId;
	}

	public boolean isCurrencyAllAmounts() {
		return currencyAllAmounts;
	}

	public void setCurrencyAllAmounts(boolean currencyAllAmounts) {
		this.currencyAllAmounts = currencyAllAmounts;
	}

	public boolean isPrintUnitPrice() {
		return printUnitPrice;
	}

	public void setPrintUnitPrice(boolean printUnitPrice) {
		this.printUnitPrice = printUnitPrice;
	}

	public boolean isPrintWrittenAmount() {
		return printWrittenAmount;
	}

	public void setPrintWrittenAmount(boolean printWrittenAmoun) {
		this.printWrittenAmount = printWrittenAmoun;
	}

	public boolean isPrintTaxSummary() {
		return printTaxSummary;
	}

	public void setPrintTaxSummary(boolean printTaxSummary) {
		this.printTaxSummary = printTaxSummary;
	}

	public boolean isPrintAllTaxes() {
		return printAllTaxes;
	}

	public void setPrintAllTaxes(boolean printAllTaxes) {
		this.printAllTaxes = printAllTaxes;
	}
	
	public void setFiscalRegisterData(FiscalRegisterData fiscalRegisterData) {
		fiscalRegisterDataMap.put(fiscalRegisterData.getRegisterNum(), fiscalRegisterData);
	}

	public FiscalRegisterData getFiscalRegisterData(int registerNum) {
		return fiscalRegisterDataMap.get(registerNum);
	}

	public Map<Integer, FiscalRegisterData> getFiscalRegisters(){
		return fiscalRegisterDataMap;
	}

	@Override
	public void accept(IEntityVisitor v) throws Exception {
		v.visit(this);
	}

	@Override
	public String toString() {
		return "FiscalReceiptConfig [merchantTaxIdName=" + merchantTaxIdName + ", customerTaxIdName="
				+ customerTaxIdName + ", customerTaxIdMinLen=" + customerTaxIdMinLen + ", customerTaxIdMaxLen="
				+ customerTaxIdMaxLen + ", taxIdCheckDigit=" + taxIdCheckDigit + ", endSeqAlarmThreshold="
				+ endSeqAlarmThreshold + ", endAuthDateAlarmThreshold=" + endAuthDateAlarmThreshold + ", taxIdDatabase="
				+ taxIdDatabase + ", customerName=" + customerName + ", customerAddress=" + customerAddress
				+ ", commonSeqAPT=" + commonSeqAPT + ", commonAPTRegisterId="+ commonAPTRegisterId 
				+", currencyAllAmounts=" + currencyAllAmounts + ", printUnitPrice="
				+ printUnitPrice + ", printWrittenAmoun=" + printWrittenAmount 
				+ ", printTaxSummary=" + printTaxSummary + ", printAllTaxes=" + printAllTaxes
				+ ", #registers=" + fiscalRegisterDataMap.size() + "]";
	}

	@Override
	public void setPK(IEntityPK pk) {
		this.pk = (FiscalReceiptConfigPK) pk;
	}

	@Override
	public IEntityPK getPK() {
		return this.pk;
	}

	@Override
	public void setAttributes(IEntityObject obj) {
		FiscalReceiptConfig cfgObj = (FiscalReceiptConfig) obj;
		cfgObj.setMerchantTaxIdName(this.getMerchantTaxIdName());
		cfgObj.setCustomerTaxIdName(this.getCustomerTaxIdName());
		cfgObj.setCustomerTaxIdMinLen(this.getCustomerTaxIdMinLen());
		cfgObj.setCustomerTaxIdMinLen(this.getCustomerTaxIdMinLen());
		cfgObj.setCustomerTaxIdMaxLen(this.getCustomerTaxIdMaxLen());
		cfgObj.setEndSeqAlarmThreshold(this.getEndSeqAlarmThreshold());
		cfgObj.setEndAuthDateAlarmThreshold(this.endAuthDateAlarmThreshold);
		cfgObj.setTaxIdCheckDigit(this.taxIdCheckDigit);
		cfgObj.setTaxIdDatabase(this.taxIdDatabase);
		cfgObj.setCustomerName(this.customerName);
		cfgObj.setCustomerAddress(this.customerAddress);
		cfgObj.setCommonSeqAPT(this.commonSeqAPT);
		cfgObj.setCommonAPTRegisterId(this.commonAPTRegisterId);
		cfgObj.setCurrencyAllAmounts(this.currencyAllAmounts);
		cfgObj.setPrintUnitPrice(this.printUnitPrice);
		cfgObj.setPrintWrittenAmount(this.printWrittenAmount);
		cfgObj.setPrintTaxSummary(this.printTaxSummary);
		cfgObj.setPrintAllTaxes(this.printAllTaxes);
		cfgObj.getFiscalRegisters().clear();
		this.getFiscalRegisters().values().forEach((data) -> {
			cfgObj.setFiscalRegisterData(data);
		});
	}

	@Override
	public void validate() throws Exception {
		if (!isPKValid()) {
			throw new Exception("Invalid Data: " + this.pk);
		}
	}

	@Override
	public boolean isPKValid() {
		return (this.pk == null) ? false : this.pk.isValid();
	}
}