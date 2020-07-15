/*
 * 2017-04-19
 *
 * COPYRIGHT (c) 2017 by VeriFone Inc., All Rights Reserved.
 *
 *                       N O T I C E
 *
 * Under Federal copyright law, neither the software nor accompanying
 * documentation may be copied, photocopied, reproduced, translated,
 * or reduced to any electronic medium or machine-readable form, in
 * whole or in part, without the prior written consent of VeriFone Inc.,
 * except in the manner described in the documentation.
 */

package com.verifone.isd.vsms2.sales.ent.currency;

import com.ibm.icu.text.PluralRules;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPersistAdmin;
import com.verifone.isd.vsms2.sys.db.pres.IReferenceDataSystem;
import com.verifone.isd.vsms2.sys.db.pres.ReferenceDataSystemFactory;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author JoswillP1 <joswillp1@verifone.com>
 */
public class CurrencySymbolUpdater {
	private Logger logger
			= LoggerFactory.getLogger(CurrencySymbolUpdater.class);

	protected IReferenceDataSystem		refDataSystem = null;
	protected IEntityPersistAdmin		currencyPA = null;

	private CurrencySymbolUpdater(){
		// Get the reference data factory
		try{
			refDataSystem = ReferenceDataSystemFactory.getInstance();
			currencyPA=refDataSystem.getPersistAdmin(IReferenceDataSystem.CURRENCY);
		} catch (Exception ex) {
			logger.error("Exception getting Currency Persist Admin"+ex.getMessage());
		}
	}

	public void loadCurrencySymbols() {
		Currency[] currencies = new Currency[Currency.MAX_CURRENCIES];
		for (int i = 0; i < Currency.MAX_CURRENCIES; i++) {
			CurrencyPK cpk=new CurrencyPK(i+1);
			currencies[i] = new Currency();
			currencies[i].setPK(cpk);
			try {
				currencyPA.retrieve(currencies[i]);
				if ((currencies[i].getCode()!= null)
						&& (!currencies[i].getCode().isEmpty())) {
					MoneyAmount.setCurrencySymbols(currencies[i].getCode(),
							currencies[i].getSymbol());
					MoneyAmount.setPrintName(currencies[i].getCode(),
						PluralRules.KEYWORD_ONE,
						currencies[i].getPrintNamePluralOne());
					MoneyAmount.setPrintName(currencies[i].getCode(),
						PluralRules.KEYWORD_OTHER,
						currencies[i].getPrintNamePluralOther());
				}
			} catch (Exception e) {
				logger.error("Exception loading Currency Symbols"
						+ e.getMessage());
			}
		}
	}

	public static CurrencySymbolUpdater getInstance() {
		return InstanceHolder.instance;
	}

	private static class InstanceHolder{
		private static CurrencySymbolUpdater instance = new CurrencySymbolUpdater();
	}
}
