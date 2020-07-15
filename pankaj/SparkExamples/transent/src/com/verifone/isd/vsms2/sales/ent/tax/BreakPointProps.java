/*
 * BreakPointPropsProps.java
 *
 * Created on May 19, 2003, 12:58 PM
 */

package com.verifone.isd.vsms2.sales.ent.tax;

import java.io.Serializable;
import java.util.Comparator;
import java.util.TreeSet;

import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/** Entity to represent break point tax properties
 * @author Bhanu_N2
 */
public class BreakPointProps implements java.io.Serializable {
    static final long serialVersionUID = -191032503000972338L;
    /** Holds value of property minimumTaxableAmount. */
    private MoneyAmount minimumTaxableAmount;
    
    /** Holds value of property repeatStartNum. */
    private int repeatStartNum;
    
    /** Holds value of property repeatEndNum. */
    private int repeatEndNum;
    
    /** Holds value of property applyForAllAmounts. */
    private boolean applyForAllAmounts;
    
    /** Holds value of property breakPoints. */
    private TreeSet<BreakPoint> breakPoints;
    
    /** Creates a new instance of BreakPointPropsProps */
    public BreakPointProps() {
        this.breakPoints = new TreeSet<BreakPoint>(new BreakPointComparator());
    }
    
    /** Getter for property minimumTaxableAmount.
     * @return Value of property minimumTaxableAmount.
     */
    public MoneyAmount getMinimumTaxableAmount() {
        return this.minimumTaxableAmount;
    }
    
    /** Setter for property minimumTaxableAmount.
     * @param minimumTaxableAmount New value of property minimumTaxableAmount.
     */
    public void setMinimumTaxableAmount(MoneyAmount minimumTaxableAmount) {
        this.minimumTaxableAmount = minimumTaxableAmount;
    }
    
    /** Getter for property repeatStartNum.
     * @return Value of property repeatStartNum.
     */
    public int getRepeatStartNum() {
        return this.repeatStartNum;
    }
    
    /** Setter for property repeatStartNum.
     * @param repeatStartNum New value of property repeatStartNum.
     */
    public void setRepeatStartNum(int repeatStartNum) {
        this.repeatStartNum = repeatStartNum;
    }
    
    /** Getter for property repeatEndNum.
     * @return Value of property repeatEndNum.
     */
    public int getRepeatEndNum() {
        return this.repeatEndNum;
    }
    
    /** Setter for property repeatEndNum.
     * @param repeatEndNum New value of property repeatEndNum.
     */
    public void setRepeatEndNum(int repeatEndNum) {
        this.repeatEndNum = repeatEndNum;
    }
    
    /** Getter for property applyForAllAmounts.
     * @return Value of property applyForAllAmounts.
     */
    public boolean isApplyForAllAmounts() {
        return this.applyForAllAmounts;
    }
    
    /** Setter for property applyForAllAmounts.
     * @param applyForAllAmounts New value of property applyForAllAmounts.
     */
    public void setApplyForAllAmounts(boolean applyForAllAmounts) {
        this.applyForAllAmounts = applyForAllAmounts;
    }
    
    /** Getter for a specific break point
     * @param bpID break point number
     * @return requested break point
     */    
    public BreakPoint getBreakPoint(int bpID) {
       BreakPoint[] elems = this.getBreakPoints();
        int len = elems.length;
        BreakPoint reqdElem = null;
        for (int i = 0; i < len; i++) {
            if (elems[i].getBreakPointNum() == bpID) {
                reqdElem = elems[i];
                break;
            }
        }        
        return reqdElem;
    }
    
    /** Add a break point
     * @param bp break point to be added 
     */    
    public void addBreakPoint(BreakPoint bp) {
        this.removeBreakPoint(bp.getBreakPointNum()); //Add does not add if elem already present; remove and add always
        this.breakPoints.add(bp);
    }
    
    /** Remove a break point
     * @param bpID ID of the break point to be removed
     */   
    public void removeBreakPoint(int bpID) {
        BreakPoint bp = this.getBreakPoint(bpID);
        if (bp != null) {
            this.breakPoints.remove(bp);
        }
    }
    
    /**
     * Returns the list of break points for the menu key
     * @return list of break points for the menu key
     */
    public BreakPoint[] getBreakPoints() {
        return this.breakPoints.toArray(new BreakPoint[0]);
    }

    /** Sets the list of break points
     * Clears the existing break points and adds the new items.
     * @param breakPts list of break points
     */    
    public void setBreakPoints(BreakPoint[] breakPts) {
        this.breakPoints.clear();
        if (breakPts != null) {
            int numEl = breakPts.length;
            for(int i = 0; i < numEl; i++) {
                this.breakPoints.add(breakPts[i]);
            }
        }
    }
    
	/**
	 * Method to validate an entity object's attributes.
	 * 
	 * @throws Exception
	 *             if validation fails
	 */
	public void validate() throws Exception {
		BreakPoint[] bps = this.getBreakPoints();

		if (repeatStartNum == 0 && repeatEndNum == 0) {
			throw new Exception("Invalid repeat start or end: start = "+ this.repeatStartNum + " end = " + this.repeatEndNum);
		}

		if (repeatStartNum <= repeatEndNum && repeatStartNum <= bps.length && repeatEndNum <= bps.length) {
			if (bps.length <= BreakPoint.MAX_BREAKPTS) {
				for (int i = 0; i < bps.length; i++) {
					if (bps[i] != null) {
						int diff = bps[i].getAmountDifference();
						int incr = bps[i].getIncrement();
						if (diff < 0 || diff > BreakPoint.MAX_AMOUNT_VALUE) {
							throw new Exception("Invalid amount difference for break point: " + bps[i].getBreakPointNum() + " " + diff);
						}
						if (incr < 0 || incr > BreakPoint.MAX_AMOUNT_VALUE) {
							throw new Exception("Invalid tax increment for break point: " + bps[i].getBreakPointNum() + " " + incr);
						}
					} else {
						throw new Exception("Unassigned break point: " + (i + 1));
					}
				}
			} else {
				throw new Exception("Too many break points: found = " + bps.length + " max allowed = " + BreakPoint.MAX_BREAKPTS);
			}
		} else {
			throw new Exception("Invalid repeat start or end: start = " + this.repeatStartNum + " end = " + this.repeatEndNum);
		}
	}
    
    /** Method to clone this entity's attribute to another
     * @param bpObj object to copy to
     */    
    public void setAttributes(BreakPointProps bpObj) {
        bpObj.applyForAllAmounts = this.applyForAllAmounts;
        bpObj.repeatEndNum = this.repeatEndNum;
        bpObj.repeatStartNum = this.repeatStartNum;
        bpObj.minimumTaxableAmount = this.minimumTaxableAmount;
        bpObj.setBreakPoints(this.getBreakPoints());
    }
    
    private class BreakPointComparator implements Comparator<BreakPoint>, Serializable {
        static final long serialVersionUID = 2139970176283881511L;
        public int compare(BreakPoint o1, BreakPoint o2) {
            /* Arrays.sort calls compare when o1 and o2 are equal.*/
            if (o1 == o2) {
                return 0;
            }
            
            BreakPoint c1 = o1;
            BreakPoint c2 = o2;
            return (c1.getBreakPointNum() - c2.getBreakPointNum());
        }
    }    
}
