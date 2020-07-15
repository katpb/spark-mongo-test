/*
 * PluDiscountInfo.java
 *
 * Created on January 19, 2004, 3:56 PM
 */

package com.verifone.isd.vsms2.sales.ent.trans;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;

import java.io.Serializable;

/**
 * Derived from DiscountInfo helper class to support more diverse discount
 * info PluItemLines enjoy.  In particular, allows lookup of deal/mix/match
 * info to track contributions of each item in a deal.
 *
 * @author  Bhanu_N2
 * @version	1.0
 * @since	beta
 */

public class PluDiscountInfo extends DiscountInfo {

	private static final long serialVersionUID = -8594158034777494417L;

	/** Holds value for Naxml promo PluItemLine in sale */
	private IEntityPK   naxmlPromoIndex;

	/** Holds value for Item List using this PluItemLine in sale */
	private IEntityPK   itemListID;
    
        private MoneyAmount newPrice;
        
        private MoneyAmount pkgAdjustmentAmount;
    
        private String naxmlPromoID;
    
        private String naxmlPromoName;
        

	/** Holds value of quantity of this PluItemLine used for a deal */
	private int		qmatch;

	/** Holds required qty of this PLU defined to qualify for a deal */
	private int		dfnQmatch;

	/** Holds defined number of PLU item lines to complete this deal */
	private int		numMixesThisDisc;

	/**
	 * This class organizes information about all item lines of this mix in a
	 * match.  The containing class supplies information related more to the
	 * match definition affecting the item line.
	 */

	public class PeerDiscInfo implements Serializable {
		static final long serialVersionUID = 1737407062287590378L;

		/** Holds the count of item lines furnishing mix items to this match */
		private int numLinesThisDisc;

		/** Holds the number of complete matchs this item line satisfied */
		private int numDiscsThisDisc;

		/** Holds the pricing and rouding amounts for the discounted item */
		private MoneyAmount[] pricing;
		//		private final PluDiscountInfo this$0;

		/**
		 * This class does not make sense outside the context of an item line's
		 * discount.  Nor is there need to update it's info outside the context
		 * of a deal/mix/match feature handler operation.  It should be a
		 * permanent one-to-one association with it's contaning instance.
		 */
		private PeerDiscInfo() {
			pricing = new MoneyAmount[2];
		}


		/** Setter of property match mixes
		 * @param number of item lines filling this mix
		 */
		public void setMatchMixes(int i) {
			numLinesThisDisc = i;
			return;
		}


		/** Getter of property match mixes
		 * @return number of item lines filling this mix
		 */
		public int getMatchMixes() {
			return (numLinesThisDisc);
		}


		/** Setter of property match mixes
		 * @param number of item lines filling this mix
		 */
		public void setMatchMatches(int i) {
			numDiscsThisDisc = i;
			return;
		}


		/** Getter of property matched matches
		 * @return number of complete mixes this item line filled
		 */
		public int getMatchMatches() {
			return (numDiscsThisDisc);
		}


		/** Setter of property discount base price
		 * @param unit discount price
		 */
		public void setDiscBasePr(MoneyAmount moneyamount) {
			pricing[0] = moneyamount;
			return;
		}


		/** Getter of property discount base price
		 * @return the discounted unit price
		 */
		public MoneyAmount getDiscBasePr() {
			return (pricing[0]);
		}


		/** Setter of property rounding amount
		 * @param rounding amount applied to last item in discount
		 */
		public void setAdjDiscAmt(MoneyAmount moneyamount) {
			pricing[1] = moneyamount;
			return;
		}


		/** Getter of property rounding amount
		 * @return amount rounded to last item in discount or null
		 */
		public MoneyAmount getAdjDiscAmt() {
			return (pricing[1]);
		}

	}

	private final PeerDiscInfo associatedLines;

	public PluDiscountInfo() {
		super();
		this.associatedLines = this.new PeerDiscInfo();
		return;
	}


	/** Setter for property qmatch
	 * @param qmatch quantity of this PluItemLine applied to given deal
	 */
	public void setQtyMatched(int qmatch) {
		this.setQmatch(qmatch);
	}

	/** Getter for property qmatch
	 * @return quantity used of this PluItemLine for a deal
	 */
	public int getQtyMatched() {
		return getQmatch();
	}

	/** Setter for property dfnQmatch
	 * @param dfnQmatch quantity of this PluItemLine required per deal defn
	 */
	public void setDfnQtyMatched(int dfnQmatch) {
		this.dfnQmatch = dfnQmatch;
	}

	/** Getter for property dfnQmatch
	 * @return quantity required of this PluItemLine per deal definition
	 */
	public int getDfnQtyMatched() {
		return dfnQmatch;
	}

	/** Setter for property numMixesThisDisc
	 * @param number of PLU items lines completing this deal.
	 */
	public void setTotMixes(int numMM) {
		numMixesThisDisc = numMM;
	}

	/** Getter for property numMixesThisDisc
	 * @return number of PLU item lines completing this deal. 
	 */
	public int getTotMixes() {
		return numMixesThisDisc;
	}

	/** Getter for per-instance discount details
	 * @return transaction-level match information
	 */
	public PeerDiscInfo getPeerDiscInfo() {
		return (associatedLines);
	}

	/** Ensure no slicing occurs when cloning
	 * @param	clonePDI
	 */
/*	public void deepCopy(PluDiscountInfo clonePDI) {
		super.deepCopy(clonePDI);
		clonePDI.setQtyMatched(this.getQmatch());
		clonePDI.setDfnQtyMatched(this.dfnQmatch);

		PeerDiscInfo pdi = clonePDI.getPeerDiscInfo();

		pdi.setMatchMixes(associatedLines.getMatchMixes());
		pdi.setMatchMatches(associatedLines.getMatchMatches());
		pdi.setDiscBasePr(associatedLines.getDiscBasePr());
		pdi.setAdjDiscAmt(associatedLines.getAdjDiscAmt());

		return;
	}
*/
    public IEntityPK getNaxmlPromoIndex() {
        return naxmlPromoIndex;
    }

    public void setNaxmlPromoIndex(IEntityPK naxmlPromoIndex) {
        this.naxmlPromoIndex = naxmlPromoIndex;
    }

    public IEntityPK getItemListID() {
        return itemListID;
    }

    public void setItemListID(IEntityPK itemListID) {
        this.itemListID = itemListID;
    }

    public MoneyAmount getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(MoneyAmount newPrice) {
        this.newPrice = newPrice;
    }
    
    public MoneyAmount getPkgAdjustmentAmount() {
        return pkgAdjustmentAmount;
    }

    public void setPkgAdjustmentAmount(MoneyAmount pkgAdjustmentAmount) {
        this.pkgAdjustmentAmount = pkgAdjustmentAmount;
    }

    public String getNaxmlPromoID() {
        return naxmlPromoID;
    }

    public void setNaxmlPromoID(String naxmlPromoID) {
        this.naxmlPromoID = naxmlPromoID;
    }

    public String getNaxmlPromoName() {
        return naxmlPromoName;
    }

    public void setNaxmlPromoName(String naxmlPromoName) {
        this.naxmlPromoName = naxmlPromoName;
    }


    public int getQmatch() {
        return qmatch;
    }

    public void setQmatch(int qmatch) {
        this.qmatch = qmatch;
	}
}
