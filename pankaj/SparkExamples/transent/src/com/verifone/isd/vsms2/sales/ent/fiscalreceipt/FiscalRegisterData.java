package com.verifone.isd.vsms2.sales.ent.fiscalreceipt;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

import com.verifone.isd.vsms2.sales.ent.trans.FiscalReceiptType;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/** Helper class for FiscalReceipts
 * @author "mailto:mike_r3@verifone.com"
 * @version 1.0
 */
public class FiscalRegisterData implements Serializable {

	private static final long serialVersionUID = 5182271706838392231L;

	private int registerNum;
    private boolean fiscalReceiptEnable = false;
    private Map<FiscalReceiptType, FiscalReceiptData> fiscalReceiptMap;

	public FiscalRegisterData() {
		this.fiscalReceiptMap = Collections.synchronizedMap(new EnumMap<FiscalReceiptType, FiscalReceiptData>(FiscalReceiptType.class));
	}

	public int getRegisterNum() {
		return registerNum;
	}

	public void setRegisterNum(int registerNum) {
		this.registerNum = registerNum;
	}

	public boolean isFiscalReceiptEnable() {
		return fiscalReceiptEnable;
	}

	public void setFiscalReceiptEnable(boolean fiscalReceiptEnable) {
		this.fiscalReceiptEnable = fiscalReceiptEnable;
	}

	public FiscalReceiptData getFiscalReceiptData(FiscalReceiptType frType) {
		return fiscalReceiptMap.get(frType);
	}

	public void setFiscalReceiptData(FiscalReceiptData fiscalReceiptData) {
		FiscalReceiptType frType = fiscalReceiptData.getFiscalReceiptType();
		if (frType != null) {
			fiscalReceiptMap.put(frType, fiscalReceiptData);
		}
	}

	public Set<FiscalReceiptType> getfiscalReceiptTypes(){
		return fiscalReceiptMap.keySet();
	}

	@Override
	public String toString() {
		return "FiscalRegisterData [registerNum=" + registerNum
				+ ", fiscalReceiptEnable=" + fiscalReceiptEnable
				+ ", #receiptTypes=" + fiscalReceiptMap.size() + "]";
	}
}