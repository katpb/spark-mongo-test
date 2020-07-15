/*
 * INetTransactionTypeFactory.java
 *
 * Created on January 21, 2005, 12:56 PM
 */

package com.verifone.isd.vsms2.net.ent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.log4j.*;

import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author  Anindya_D1
 */
public class CardCompareBase implements ICardCompare {
    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.CardCompareBase.class);
    
    public CardCompareBase() {
    }
    
    /**
	 * Method to determine a preliminary match based on ISO 1, ISO 2 and PAN
	 * length. In most cases, this will be sufficient to find out the matching
	 * card table entry. Apps can override this method to perform additional
	 * checks as they traverse the card table. If the initial match is
	 * successful, we have an opportunity to confirm the ISO record in the
	 * <code>compareISORec<\code> method before a perfect match 
	 * could be returned.
	 * 
	 * @param initialParse
	 * @param cardEntry
	 * @return true if a match is found
	 *
	 */
    public boolean matchCardEntry(CardData initialParse, INetCCardConfig cardEntry) {
        boolean matchFound = false;
        CardTypeDef cardObj = cardEntry.getCCTypeObj();
        
        if (!cardEntry.isEnabled()) {
            matchFound = false;
        }
        else {
            if (initialParse.isDebitMop()) {
                if (cardEntry.isDebitCard()) {
                    matchFound = true;
                }
                else {
                    matchFound = false;
                }
            }
            else if (initialParse.isEbtFsMop()) {
                if ((CardTypeDef.CARDTYPE_EBT_FS == cardObj) ||
                (CardTypeDef.CARDTYPE_EBT == cardObj)) {
                    matchFound = true;
                }
                else {
                    matchFound = false;
                }
            }
            else if (initialParse.isEbtCbMop()) {
                if ((CardTypeDef.CARDTYPE_EBT_CASH == cardObj) ||
                (CardTypeDef.CARDTYPE_EBT == cardObj)) {
                    matchFound = true;
                }
                else {
                    matchFound = false;
                }
            }
            else if ((initialParse.isManualEntry()) && (cardEntry.isPropCard())) {
            	/**
            	 * Add all manatec entries to the match set for manual entry. There
            	 * will be no perfect match. CSR will have to choose from a list of
            	 * ISO records
            	 */
            	matchFound = true;
            } else {
                String accountNumber = initialParse.getAccountNum();
                String isoPart1 = cardEntry.getBeginISO();
                String isoPart2 = cardEntry.getEndISO();
                
                // logger.info("NetCCardConfigSet: ISO 1 " + isoPart1 + " ISO 2 " + isoPart2);
                
				/*
				 * Do not continue if either of ISO 1 or ISO 2 are not present.
				 * This is possible in EPSPAK where primary entries don't have
				 * ISO ranges defined.
				 */
				if ((isoPart1 == null) || (isoPart1.length() == 0)
						|| (isoPart2 == null) || (isoPart2.length() == 0)) {
					matchFound = false;
				} else if (accountNumber.charAt(0) != isoPart1.charAt(0)) {
                    matchFound = false;
                } else {
                    try {
                        if ((isoPart1.compareTo(accountNumber.substring(0, isoPart1.length())) <= 0) &&
                        (isoPart2.compareTo(accountNumber.substring(0, isoPart2.length())) >= 0)) {
                            if (cardEntry.getPanLength1() > 0) {
                                if ((accountNumber.length() == cardEntry.getPanLength1()) ||
                                (accountNumber.length() == cardEntry.getPanLength2())) {
                                    // logger.info("NetCCardConfigSet: ISO record PAN length match");
                                    matchFound = true;
                                } else {
                                    logger.info("Pan Match failed pan1:"+cardEntry.getPanLength1() +
                                    ", pan2:" +cardEntry.getPanLength2() + " acc len:" +
                                    accountNumber.length());
                                }
                            }
                            else {
                                // logger.info("NetCCardConfigSet: ISO match without PAN length");
                                matchFound = true;
                            }
                        }
                    } catch (Exception e) {
                        matchFound = false;
                    }
                }
            }
        }
        
        return matchFound;
    }
    
    /**
     * Method to perform a finer comparison before a perfect match could be returned. In case of m
     * multiple matching ISO records, CSR will need to choose a single ISO record.
     *
     * @param parsedCard
     * @param isoRecord
     * @return true if a perfect match is confirmed, false otherwise
     */
    public boolean compareIsoRec(CardData parsedCard, INetCCardConfig isoRecord) {
        boolean result = true;
        if ((parsedCard.isManualEntry()) && (isoRecord.isPropCard())) {
            result = false;
        }
        return result;
    }

	/**
	 * In base (following Shell's implementation), this method is a no-op.
	 * Unknown card type is a valid recognized card type which also serves as a
	 * catch-all entry at the bottom of the card table. Applications without a
	 * notion of card type (exxonmobil, chevron) should go through the entire
	 * set and determine which one is the catch-all ISO record.
	 * 
	 * @see com.verifone.isd.vsms2.net.ent.ICardCompare#checkCatchAllISOEntry(com.verifone.isd.vsms2.net.ent.NetCCardConfigSet)
	 */
	public void checkCatchAllISOEntry(NetCCardConfigSet theSet) {
	}
	
	/**
	 * (non-Javadoc) In base (following Shell's implementation), the unknown
	 * card type serves as a catch-all entry which is expected at the bottom of
	 * the card table.
	 * 
	 * @see com.verifone.isd.vsms2.net.ent.ICardCompare#isCatchAllISOEntry(com.verifone.isd.vsms2.net.ent.INetCCardConfig)
	 */
	public boolean isCatchAllISOEntry(INetCCardConfig cardEntry) {
		return (cardEntry.getCCTypeObj() == CardTypeDef.CARDTYPE_UNKNOWN);
	}
}
