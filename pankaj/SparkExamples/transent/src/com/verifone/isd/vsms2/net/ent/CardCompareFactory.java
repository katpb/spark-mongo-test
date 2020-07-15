/*
 * MopCodeFactory.java
 *
 * Created on December 20, 2004, 12:53 PM
 */

package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.log4j.*;

public class CardCompareFactory implements ICardCompare {
    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.CardCompareFactory.class);
    private static CardCompareFactory theInstance;
    private static final ICardCompare FACTORY;
    
    static {
        ICardCompare tempFactory = new CardCompareBase();
        try {
            String clzName = SysPropertyFactory.getProperty("cardcompare.class");
            LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.CardCompareFactory.class)
                        .debug( "ISO Record Comparison class name from prop file = " +clzName);
            if (clzName != null && clzName.length() > 4) {
                tempFactory = (ICardCompare) Class.forName(clzName).newInstance();
            }
        }
        catch (Exception e) {
            LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.CardCompareFactory.class)
                    .info("No application specific ISO Record comparison factory");
        }
        finally {
            FACTORY = tempFactory;
        }
    }
    
    /** Creates a new instance of Main */
    private CardCompareFactory() {
    }
    
    public static CardCompareFactory getInstance() {
        if (theInstance == null) {
            theInstance = new CardCompareFactory();
        }
        return theInstance;
    }
    
    
    public boolean compareIsoRec(CardData parsedCard, INetCCardConfig isoRecord) {
        boolean compare = true;
        if (FACTORY != null) {
            compare = FACTORY.compareIsoRec(parsedCard, isoRecord);
        }
        return compare;
    }
    
    public boolean matchCardEntry(CardData initialParse, INetCCardConfig cardEntry) {
        boolean compare = false;
        if (FACTORY != null) {
            compare = FACTORY.matchCardEntry(initialParse, cardEntry);
        }
        return compare;
    }
    
	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.net.ent.ICardCompare#checkCatchAllEntry(com.verifone.isd.vsms2.net.ent.NetCCardConfigSet)
	 */
	public void checkCatchAllISOEntry(NetCCardConfigSet theSet) {
		if (FACTORY != null) {
			FACTORY.checkCatchAllISOEntry(theSet);
		}
	}

	/* (non-Javadoc)
	 * @see com.verifone.isd.vsms2.net.ent.ICardCompare#isCatchAllISOEntry(com.verifone.isd.vsms2.net.ent.INetCCardConfig)
	 */
	public boolean isCatchAllISOEntry(INetCCardConfig cardEntry) {
		boolean catchAll = false;
		if (FACTORY != null) {
			catchAll = FACTORY.isCatchAllISOEntry(cardEntry);
		}
		return catchAll;
	}
}
