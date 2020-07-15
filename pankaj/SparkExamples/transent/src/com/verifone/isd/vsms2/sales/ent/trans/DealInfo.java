/*-
 * Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Topaz Beta Version
 * Created January 19, 2004                                   David C. Brown
 *
 * Summarize deal quantity and pricing to update XML and print receipts
 * after the completed sale -- Deal/mix/match entity will have flushed
 * all the info so we can't query it.
 */

package com.verifone.isd.vsms2.sales.ent.trans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.verifone.isd.vsms2.sales.ent.tax.TaxPK;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/**
 * Provide summary information of matches used in a transaction
 * that will be serialized into XML.
 *
 * This is a breakdown of match instance based on qty and price.
 * Several of the same match PK can be in a transaction but if PLU
 * pricing is in effect they will all have different prices.
 *
 * @author  David C. Brown
 * @version	1.0
 * @since	beta
 */

public class DealInfo implements java.io.Serializable {

	private static final long serialVersionUID = 9170891274591665357L;

	private boolean duplicate;

	/**
	 * The PK used to recover the info about this match from the
	 * persist layer.
	 */

	private IEntityPK   naxmlPromoIndex;

	/**
	 * Avoid lookup of entire persist object just for a string name
	 */

	private String naxmlPromoName;


	/**
	 * The amount charged to a transaction for a single instance of
	 * match in a transaction -- per match definition.
	 */

	private MoneyAmount naxmlPromoPrice;

	/**
	 * The difference between the baseSellingPrice * mixQty and
	 * assigned mix/match price * mixQty for all items in this match.
	 */

	private MoneyAmount discount;


	/**
	 * Collection of all ItemLines that contributed something to the
	 * total collection of instances of this match in a transaction.
	 */

	private ArrayList itemLines;

	private String naxmlPromoID;
	
	private MoneyAmount taxableRebateAmount;
	
	/** Holds the collection of tax PKs applied to this item for taxable rebate. */
	private Set<TaxPK> rebateTaxpks;


	/**
	 * Create a new instance with no utilization information, just
	 * storage for the ItemLine vectors.
	 */

	public DealInfo() {
		this.setItemLines(new ArrayList());
		this.rebateTaxpks = Collections.synchronizedSet(new HashSet<TaxPK>());
	}

    public IEntityPK getNaxmlPromoIndex() {
        return naxmlPromoIndex;
    }

    public void setNaxmlPromoIndex(IEntityPK naxmlPromoIndex) {
        this.naxmlPromoIndex = naxmlPromoIndex;
    }

    public String getNaxmlPromoName() {
        return naxmlPromoName;
    }

    public void setNaxmlPromoName(String naxmlPromoName) {
        this.naxmlPromoName = naxmlPromoName;
    }

    public MoneyAmount getNaxmlPromoPrice() {
        return naxmlPromoPrice;
    }

    public void setNaxmlPromoPrice(MoneyAmount naxmlPromoPrice) {
        this.naxmlPromoPrice = naxmlPromoPrice;
    }

    public void setItemLines(ArrayList itemLines) {
        this.itemLines = itemLines;
    }

    public MoneyAmount getDiscount() {
        return discount;
    }

	public void setDiscount(MoneyAmount discount) {
        this.discount = discount;
	}

    public ArrayList getItemLines() {
        return itemLines;
 
   }
   public int[] getItemLineIndices()
   {
        return new int[0];
   }
   public MoneyAmount getTaxableRebateAmount() {
		return taxableRebateAmount;
	}

	public void setTaxableRebateAmount(MoneyAmount taxableRebateAmount) {
		this.taxableRebateAmount = taxableRebateAmount;
	}
	
	/** Add tax  NOTE: nothing prevents duplicate PK's.  The interface
	 * is just a convenience to pass tax info across components.  The
	 * components that create the ItemLine must enforce unique TaxPK entries.
	 * @param tax TaxPK to be applied to this department
	 */
	public void addTaxableRebateTaxPK(TaxPK tax) {
		if (null == this.rebateTaxpks) {
			this.rebateTaxpks = Collections.synchronizedSet(new HashSet<TaxPK>());
		}
		this.rebateTaxpks.add(tax);
	}

	/** Remove tax
	 * @param tax tax be be removed from this department
	 */
	public void removeTaxableRebateTaxPK(TaxPK tax) {
		if (this.rebateTaxpks != null) {
			this.rebateTaxpks.remove(tax);
		}
	}

	/** Get all applicable taxes
	 * @return iterator of TaxPK objects assigned to this department
	 */
	public Iterator<TaxPK> getTaxableRebateTaxPKs() {
		if (null == this.rebateTaxpks) {
			this.rebateTaxpks = Collections.synchronizedSet(new HashSet<TaxPK>());
		}
		return this.rebateTaxpks.iterator();
	}
	
	public void setTaxableRebateTaxes(Iterator<TaxPK> items) {
		if (null == this.rebateTaxpks) {
			this.rebateTaxpks = Collections.synchronizedSet(new HashSet<TaxPK>());
		}
       this.rebateTaxpks.clear();
       while(items.hasNext()) {
           TaxPK item = (TaxPK)items.next();
           this.rebateTaxpks.add(item);
       }
   }

	public String getNaxmlPromoID() {
		return naxmlPromoID;
	}

	public void setNaxmlPromoID(String naxmlPromoID) {
		this.naxmlPromoID = naxmlPromoID;
	}
	
	public boolean isDuplicate() {
		return duplicate;
	}
	
	public void setDuplicate(boolean duplicate) {
		this.duplicate = duplicate;
	}
}

