/* 
 * Copyright (C) 2012 VeriFone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 27 August, 2012                                       Mohamed Faisal
 */
package com.verifone.isd.vsms2.sales.ent.salescfg;

import java.util.Locale;
import java.util.ResourceBundle;

import com.verifone.isd.vsms2.sales.ent.dept.DepartmentPK;
import com.verifone.isd.vsms2.sys.l10n.LocalizedRB;
import com.verifone.isd.vsms2.sys.l10n.SalesConfigRes;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import com.verifone.isd.vsms2.sys.util.Quantity;
import com.verifone.isd.xml.vocabulary.IXMLVocabulary;

/**
 * Enum for Sales Config Codes.
 * 
 * @author T_mohamedf1
 */
public enum SalesConfigItem {
	RFD("RFD") { // Fuel discount
		@Override
		public String getValue(SalesConfig sc) {
			return sc.getReferDiscount().toString();
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setReferDiscount(new Quantity(value, DEFAULT_NUMDECIMALS, IXMLVocabulary.EMPTY_STRING));
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.REFER_DISC);
		}
	},
	MAD("MAD") { // Maximum discount
		@Override
		public String getValue(SalesConfig sc) {
			return sc.getMaximumDiscount().toString();
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setMaximumDiscount(new Quantity(value, DEFAULT_NUMDECIMALS, IXMLVocabulary.EMPTY_STRING));
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.MAXIMUM_DISC);
		}
	},
	DFR("DFR") { // Fixed Discount rate
		@Override
		public String getValue(SalesConfig sc) {
			return sc.getFixedDiscountRate().toString();
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setFixedDiscountRate(new Quantity(value, DEFAULT_NUMDECIMALS, IXMLVocabulary.EMPTY_STRING));
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.FIXED_DISC_RATE);
		}
	},
	MID("MID") { // Minimum discount
		@Override
		public String getValue(SalesConfig sc) {
			return sc.getMinimumDiscount().toString();
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setMinimumDiscount(new Quantity(value, DEFAULT_NUMDECIMALS, IXMLVocabulary.EMPTY_STRING));
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.MINIMUM_DISC);
		}
	},
	
	MAA("MAA") { // Maximum amount
		@Override
		public String getValue(SalesConfig sc) {
			return sc.getMaximumAmount().toString();
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setMaximumAmount(new MoneyAmount(value));
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.MAXIMUM_AMT);
		}
	},
	MIA("MIA") { // Minimum amount
		@Override
		public String getValue(SalesConfig sc) {
			return sc.getMinimumAmount().toString();
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setMinimumAmount(new MoneyAmount(value));
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.MINIMUM_AMT);
		}
	},
	PNF("PNF") { // PLU not found department
		@Override
		public String getValue(SalesConfig sc) {
			return String.valueOf(sc.getPluNotFoundDept().getValue());
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setPluNotFoundDept(new DepartmentPK(Integer.parseInt(value)));
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.PLU_NOT_FND_DEPT);
		}
	},
	PPA("PPA") { // Prepaid Card Activate Department
		@Override
		public String getValue(SalesConfig sc) {
			return String.valueOf(sc.getPrepaidActivateDept());
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setPrepaidActivateDept(new DepartmentPK(Integer.parseInt(value)));
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.PPD_ACTIVATE_DEPT);
		}
	},
	PPR("PPR") { // Prepaid Card Recharge Department
		@Override
		public String getValue(SalesConfig sc) {
			return String.valueOf(sc.getPrepaidRechargeDept());
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setPrepaidRechargeDept(new DepartmentPK(Integer.parseInt(value)));
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.PPD_RECHARGE_DEPT);
		}
	},
	FDS("FDS") { // Fuel Discount Title
		@Override
		public String getValue(SalesConfig sc) {
			return sc.getFuelDiscountTitle() == null ? IXMLVocabulary.EMPTY_STRING : sc.getFuelDiscountTitle();
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setFuelDiscountTitle((value != null && value.length() == 0) ? IXMLVocabulary.EMPTY_STRING : value);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.FUEL_DISCOUNT_TITLE);
		}
	},
	TSD("TSD") { // Cash drawers connected
		@Override
		public String getValue(SalesConfig sc) {
			return String.valueOf(sc.getCashDrawers());
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setCashDrawers(Integer.parseInt(value));
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.NUM_CASH_DRWS);
		}
	},
	MOL("MOL") { // Money order low
		@Override
		public String getValue(SalesConfig sc) {
			return String.valueOf(sc.getMoneyOrderLow());
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setMoneyOrderLow(Integer.parseInt(value));
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.MONEY_ORDER_LOW);
		}
	},
	MAQ("MAQ") { // Maximum quantity
		@Override
		public String getValue(SalesConfig sc) {
			return sc.getMaximumQuantity().toString();
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setMaximumQuantity(new Quantity(value, IXMLVocabulary.EMPTY_STRING));
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.MAXIMUM_QTY);
		}
	},
	DTO("DTO") { // Reset display timeout value
		@Override
		public String getValue(SalesConfig sc) {
			return String.valueOf(sc.getResetDisplayTimeout());
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setResetDisplayTimeout(Integer.parseInt(value));
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.RESET_DISP_TIME);
		}
	},
	EMT("EMT") { // Error Message Prompt Timer
		@Override
		public String getValue(SalesConfig sc) {
			return String.valueOf(sc.getErrorMsgPromptTimer());
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setErrorMsgPromptTimer(Integer.parseInt(value));
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.ERR_PROMPT_TIME);
		}
	},
	RTT("RTT") { // Register Time-Out Timer
		@Override
		public String getValue(SalesConfig sc) {
			return String.valueOf(sc.getRegisterTimeout());
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setRegisterTimeout(Integer.parseInt(value));
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.REG_TIMEOUT);
		}
	},
	DTP("DTP") { // Discount type - Pct or Amt
		@Override
		public String getValue(SalesConfig sc) {
			return sc.getDiscountType() == DiscountType.PERCENT ? IXMLVocabulary.PERCENT_STR : IXMLVocabulary.AMOUNT_STR;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setDiscountType(IXMLVocabulary.PERCENT_STR.equals(value.trim()) ? DiscountType.PERCENT : DiscountType.AMOUNT);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.DISCOUNT_TYPE);
		}
	},
	DFX("DFX") { // Is fixed Discount
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isFixedDiscount() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setFixedDiscount((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.IS_FIXED_DISC);
		}
	},
	CSR("CSR") { // Is cashier # required for each sale
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isCashierNumForEachSale() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setCashierNumForEachSale((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.CSR_PROMPT_SALE);
		}
	},
	TDB("TDB") { // Is total in double
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isTotalInDouble() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setTotalInDouble((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.TOTAL_IN_DBL);
		}
	},
	JRN("JRN") { // Print receipt
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isPrintReceipt() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setPrintReceipt((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.PRINT_RCPT);
		}
	},
	VLP("VLP") { // Force void line print
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isVoidLinePrintForced() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setVoidLinePrintForced((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.VOID_LINE_PRINT);
		}
	},
	VTP("VTP") { // Force void transaction print
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isVoidTicketPrintForced() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setVoidTicketPrintForced((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.VOID_TXN_PRINT);
		}
	},
	NSP("NSP") { // Force no sale print
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isNoSalePrintForced() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setNoSalePrintForced((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.NO_SALE_PRINT);
		}
	},
	RFP("RFP") { // Force refund print
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isRefundPrintForced() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setRefundPrintForced((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.REFUND_PRINT);
		}
	},
	DDS("DDS") { // Idle prompt displays due sale
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isDueSalesPrompt() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setDueSalesPrompt((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.DUE_SALES_PROMPT);
		}
	},
	DOP("DOP") { // Drawer open during sale
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isDrawOpenInSaleAllowed() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setDrawOpenInSaleAllowed((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.DRW_OPEN_SALE);
		}
	},
	DRH("DRH") { // Reset display on drawer close
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isResetDisplayOnDrawClose() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setResetDisplayOnDrawClose((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.RESET_DISP_DRWC);
		}
	},
	DRC("DRC") { // Reset display on timeout
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isResetDisplayOnTimeout() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setResetDisplayOnTimeout((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.RESET_DISP_ON_TO);
		}
	},
	GST("GST") { // Canadian GST
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isCanadianGST() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setCanadianGST((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.IS_GST);
		}
	},
	VAT("VAT") { // Value added tax (VAT)
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isValueAddedTax() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setValueAddedTax((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.IS_VAT);
		}
	},
	STB("STB") { // Store number
		@Override
		public String getValue(SalesConfig sc) {
			return sc.getStoreNumber();
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setStoreNumber(value);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.STORE_NUMBER);
		}
	},
	ASO("ASO") { // Enable auto settle overrun
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isAutoSettleOverrunEnabled() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setAutoSettleOverrunEnabled((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.ENABLE_AUTO_SETTLE_OVERRUN);
		}
	},
	DEC("DEC") { // Disable Error Correct Key
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isDisableErrorCorrectKey() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}
		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setDisableErrorCorrectKey((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.DISABLE_ERROR_CORRECT_KEY);
		}
	},
	CDA("CDA") { // Check drawer amount on safe drop
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isAmountCheckedOnSafeDrop() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setAmountCheckedOnSafeDrop((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.CHECK_DRWAMT_SD);
		}
	},
	OCD("OCD") { // One Cashier per Drawer
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isOneCSRPerDrawerForced() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setOneCSRPerDrawerForced((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.ONE_CSR_PER_DRW);
		}
	},
	FDC("FDC") { // Force DOB on ID Check
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isDobCheckForced() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setDobCheckForced((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.FORCE_DOB_CHECK);
		}
	},
	PMC("PMC") { // Prevent Modify Key Cycling
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isModifyKeyCyclingDisabled() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setModifyKeyCyclingDisabled((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.NO_MODIF_CYCLE);
		}
	},
	DAT("DAT") { // Drawer Alarm Timer
		@Override
		public String getValue(SalesConfig sc) {
			return String.valueOf(sc.getDrawerAlarmTimer());
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setDrawerAlarmTimer(Integer.parseInt(value));
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.DRAWER_ALARM_TIMER);
		}
	},
	RTC("RTC") { // Release Terminal During Close
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isReleaseTerminalDuringClose() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setReleaseTerminalDuringClose((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.RELEASE_TERMINAL_DURING_CLOSE);
		}
	},
	IMP("IMP") { // Reminder to use Imprinter
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isforceImprinterEnable()? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setforceImprinterEnable((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.FORCE_IMPRINTER);
		}
	},
	RLL("RLL") { // Cardload Recharge Dept
		@Override
		public String getValue(SalesConfig sc) {
			return String.valueOf(sc.getCardLoadRechargeDept());
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setCardLoadRechargeDept(new DepartmentPK(Integer.parseInt(value)));
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.CARDLOAD_RECHARGE_DEPT);
		}
	},
	DPN("DPN") { // Display PLU not found Department List
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isDisplayPLUNotFoundDeptList() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setDisplayPLUNotFoundDeptList((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.DISP_PNF_DEP_LIST);
		}
	},
	MTA("MTA") { // Maximum Till Transaction Amount
		@Override
		public String getValue(SalesConfig sc) {
			return sc.getMaximumTillTransAmount().toString();
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setMaximumTillTransAmount(new MoneyAmount(value));
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.MAX_TILL_TRANS_AMT);
		}
	},
	SBT("SBT") { // Is sub-total required
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isSubTotalRequired() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setSubTotalRequired((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.SUBTOTAL_REQD);
		}
	},
	PDR("PDR") { // Print DOB on Receipt
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isPrintDOBonReceipt() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setPrintDOBonReceipt((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.PRINT_DOB_RECEIPT);
		}
	},
	PDJ("PDJ") { // Print DOB on Journal
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isPrintDOBonJournal() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setPrintDOBonJournal((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.PRINT_DOB_JOURNAL);
		}
	},
	LPN("LPN") { // Prompt Loyalty for PLU Not Found
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isPromptLoyaltyForPluNF() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setPromptLoyaltyForPluNF((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.PROMPT_LOY_PLU_NF);
		}
	},
	CAR("CAR") { // Cash under run auto refund
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isCashUnderRunAutoRefund() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setCashUnderRunAutoRefund((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.CASH_AUTO_REFUND);
		}
	},
	OCC("OCC"){

		@Override
		public String getValue(SalesConfig sc) {
			return sc.isOpenDrawerCashierClose() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setOpenDrawerCashierClose((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);			
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.OPEN_DRW_CSR_CLOSE);
		}		
	},
	EMU("EMU") { // Enable Managed Update 
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isEnableManagedUpdate() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setEnableManagedUpdate((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);			
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.ENABLE_MANAGED_UPDATE);
		}
	},
	ETR("ETR"){

		@Override
		public String getValue(SalesConfig sc) {
			return sc.isReceiptTaxDetailEnabled() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setReceiptTaxDetailEnabled((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);			
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.ENABLE_RECEIPT_TAX_DETAIL);
		}
	},
    PUC("PUC"){	//Print UPC Code
        @Override
        public String getValue(SalesConfig sc) {
            return sc.isUPCDetailEnabled() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
        }

        @Override
        public void setValue(SalesConfig sc, String value) {
            sc.setUPCDetailEnabled((IXMLVocabulary.TRUE_STRING.equals(value) ||
                    IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);			
        }

        @Override
        public String getDescription() {
            return rb.getString(SalesConfigRes.PRINT_UPC_RECEIPT);
        }
 	},
    DEN("DEN"){
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isDiscountDenomEnabled() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setDiscountDenomEnabled((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);			
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.ENABLE_DISC_DENOMINATION);
		}		
	},
    SMD("SMD"){
        @Override
        public String getValue(SalesConfig sc) {
            return sc.isStackManualDiscountEnabled() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
        }

        @Override
        public void setValue(SalesConfig sc, String value) {
            sc.setStackManualDiscountEnabled((IXMLVocabulary.TRUE_STRING.equals(value) ||
                    IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);			
        }

        @Override
        public String getDescription() {
            return rb.getString(SalesConfigRes.ENABLE_STACK_MANUAL_DISC);
        }
    },
	CUC("CUC"){ // Count Underrun Customers in Summary report for Corner Store

		@Override
		public String getValue(SalesConfig sc) {
			return sc.isCntUnderrunCustsEnabled() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setCntUnderrunCustsEnabled((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);			
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.COUNT_UNDERRUN_CUSTS);
		}
 	},
 	AEF("AEF"){ // Allow amount entry for refund 

		@Override
		public String getValue(SalesConfig sc) {
			return sc.isAllowAmountEntryForRefund() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setAllowAmountEntryForRefund((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);			
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.ALLOW_AMOUNT_ENTRY_FOR_REFUND);
		}
 	},
	PDI("PDI"){ //cr1045.01 Food Service Dine In prompt
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isPromptDineIn() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setPromptDineIn((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);			
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.PROMPT_DINE_IN);
		}		
	},
	RPN("RPN") { // Receipt Print Program Name Type
		@Override
		public String getValue(SalesConfig sc) {
			switch(sc.getReceiptPrintProgramNameType().getCode()) {
				case "Yes":
					return IXMLVocabulary.YES_STR;
				case "Detailed":
					return IXMLVocabulary.DETAILED_STR;
				case "No":
				default:
					return IXMLVocabulary.NO_STR;
			}
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setReceiptPrintProgramNameType(ReceiptPrintProgramNameType.getEnumTypeByValue(value));
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.RECEIPT_PRINT_PROGRAM_NAME_TYPE);
		}
		
	},
	PFN("PFN"){ //CR1670.01 Name and Phone Number on Food Order
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isFoodOrderCustomerNameprompt() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setFoodOrderCustomerNameprompt((IXMLVocabulary.TRUE_STRING.equals(value) ||
							IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.PROMPT_FOOD_ORDER_NAME);
		}		
	},
	PFP("PFP"){ //CR1670.01 Name and Phone Number on Food Order
		@Override
		public String getValue(SalesConfig sc) {
			return sc.isFoodOrderCustomerPhoneNumberprompt() ? IXMLVocabulary.TRUE_STRING : IXMLVocabulary.FALSE_STRING;
		}

		@Override
		public void setValue(SalesConfig sc, String value) {
			sc.setFoodOrderCustomerPhoneNumberprompt((IXMLVocabulary.TRUE_STRING.equals(value) ||
					IXMLVocabulary.TRUE_STR_STRING.equals(value)) ? true : false);			
		}

		@Override
		public String getDescription() {
			return rb.getString(SalesConfigRes.PROMPT_FOOD_ORDER_PHONE_NUMBER);
		}		
	}
	;
	

	private String code;
	private static final int DEFAULT_NUMDECIMALS = 2;
	private static final ResourceBundle rb = LocalizedRB.getResourceBundle(
			LocalizedRB.SALESCFG_RESOURCE, Locale.getDefault());

	/**
	 * Constructor.
	 * @param code - code
	 */
	private SalesConfigItem(String code) {
		this.code = code;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @param sc the SalesConfig object to get the value
	 * @return the value
	 */
	public abstract String getValue(SalesConfig sc);

	/**
	 * @param sc the SalesConfig object on which to set the value
	 * @param value the ResultSet value to set on SalesConfig Object
	 */
	public abstract void setValue(SalesConfig sc, String value);

	/**
	 * @return description of the SalesConfigItem
	 */
	public abstract String getDescription();
}
