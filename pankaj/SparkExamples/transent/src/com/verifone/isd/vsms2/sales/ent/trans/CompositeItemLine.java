/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 21 Mar, 2007                                     Sudesh Srinivasan
 */
package com.verifone.isd.vsms2.sales.ent.trans;

import java.util.ArrayList;

import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/**
 * Class to represent a composite item line in the transaction. This ItemLine
 * represents the primary item and contains a collection of ItemLines that form
 * the sub-items.
 */
public class CompositeItemLine extends PluItemLine {
    

	private static final long serialVersionUID = 7148321507555187481L;
	private ArrayList subItems = null;

    public CompositeItemLine() {
        super();
        subItems = new ArrayList();
    }

    public void deepCopy(CompositeItemLine clone) {
        super.deepCopy(clone);
        int numSubItems = subItems.size();
        if (numSubItems > 0) {
            for (int i = 0; i < numSubItems; i++) {
                PluItemLine subItem = new PluItemLine();
                ((ItemLine) subItems.get(i)).deepCopy(subItem);
                clone.addSubItem(subItem);
            }
        }
    }

    public ItemLine createDeepCopy(){
    	ItemLine origLine = new CompositeItemLine();
    	((CompositeItemLine) this).deepCopy(origLine);
    	return origLine;
    }
    public void deepCopy(ItemLine clone) {
        if (clone instanceof CompositeItemLine) {
            this.deepCopy((CompositeItemLine) clone);
        } else {
            super.deepCopy(clone);
        }
    }

    public void addSubItem(ItemLine subItem) {
        subItems.add(subItem);
    }

    public int removeSubItem(ItemLine subItem) {
        int index = subItems.indexOf(subItem);
        if (index >= 0)
            subItems.remove(subItem);
        return index;
    }
    /**
     * Remove all Sub items from the parent item
     */
    public void removeAllSubItems() {
    		subItems.clear();
    }

    /*
     * (non-Javadoc)
     * @see com.verifone.isd.vsms2.sales.ent.trans.ItemLine#getSubItems()
     */
    public ItemLine[] getSubItems() {
        return (ItemLine[]) subItems.toArray(new PluItemLine[0]);
    }

    public MoneyAmount getSummaryAmt() {
        MoneyAmount totalAmt = this.getSummaryAmtWithoutDiscount();
        ItemLine[] items = this.getSubItems();

        DiscountInfo[] discInfo = this.getAllDiscountInfo();
        if (discInfo != null) {
            for (int i = 0; i < discInfo.length; i++) {
                /* handle deal/mix/match/pop discounts differently: en mass'e */
                if (discInfo[i].getDiscountMode() == DiscountMode.POP) {
                    continue;
                }
                totalAmt.add(discInfo[i].getDiscountAmount());
            }
        }
        for (int i = 0; i < items.length; i++) {
            discInfo = items[i].getAllDiscountInfo();
            if (discInfo != null) {
                for (int j = 0; j < discInfo.length; j++) {
                    // handle deal/mix/match/pop discounts differently: en
                    // mass'e
                    if (discInfo[j].getDiscountMode() == DiscountMode.POP) {
                        continue;
                    }
                    totalAmt.add(discInfo[j].getDiscountAmount());
                }
            }
        }
        return totalAmt;
    }

    /**
     * This method will return the original summary amount without discounts
     * @return
     */
    public MoneyAmount getSummaryAmtWithoutDiscount() {
        MoneyAmount totalAmt = new MoneyAmount(this.getAmount());
        ItemLine[] items = this.getSubItems();

        for (int i = 0; i < items.length; i++)
            totalAmt.add(items[i].getAmount());

        return totalAmt;
    }

    public MoneyAmount getFeeTotals() {
		MoneyAmount ifee;
		MoneyAmount feeTotal = new MoneyAmount(0);
		ItemLine[] items = this.getSubItems();

		if ((ifee = this.getAllFeeTotal()) != null) {
			feeTotal.add(ifee);
		}
		for (int i = 0; i < items.length; i++) {
			if ((ifee = items[i].getAllFeeTotal()) != null)
				feeTotal.add(ifee);
		}
		return feeTotal;
    }
}
