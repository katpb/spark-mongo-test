/*
 * BreakPoint.java
 *
 * Created on May 19, 2003, 1:09 PM
 */

package com.verifone.isd.vsms2.sales.ent.tax;

/**
 * Break point entry entity. Note that the amount differences 
 * and tax increments are maintained as int's since they are 
 * expressed in smaller denominations (e.g., as cents in US).
 * May need to revisit if we decide to use MoneyAmount instead.
 * 
 * @author  Bhanu_N2
 */
public class BreakPoint implements java.io.Serializable {
    static final long serialVersionUID = 8175649960859719347L;
    /** Maximum allowed breakpoints */    
    public static final int MAX_BREAKPTS = 100;
    /** Maximum value allowed for a breakpoint entry */    
    public static final int MAX_AMOUNT_VALUE = 99999;    
    /** Holds value of property breakPointNum. */
    private int breakPointNum;
    
    /** Holds value of property amountDifference. */
    private int amountDifference;
    
    /** Holds value of property increment. */
    private int increment;
    
    /** Creates a new instance of BreakPoint */
    public BreakPoint() {
    }
    
    /** Creates a new instance of BreakPoint
     * @param breakPointNum break point number
     * @param amountDifference amount difference
     * @param increment increment with respect to previous break point
     */
    public BreakPoint(int breakPointNum, int amountDifference, int increment) {
        this.breakPointNum = breakPointNum;
        this.amountDifference = amountDifference;
        this.increment = increment;
    }    
    
    /** Getter for property breakPointNum.
     * @return Value of property breakPointNum.
     */
    public int getBreakPointNum() {
        return this.breakPointNum;
    }
    
    /** Setter for property breakPointNum.
     * @param breakPointNum New value of property breakPointNum.
     */
    public void setBreakPointNum(int breakPointNum) {
        this.breakPointNum = breakPointNum;
    }
    
    /** Getter for property amountDifference.
     * @return Value of property amountDifference.
     */
    public int getAmountDifference() {
        return this.amountDifference;
    }
    
    /** Setter for property amountDifference.
     * @param amountDifference New value of property amountDifference.
     */
    public void setAmountDifference(int amountDifference) {
        this.amountDifference = amountDifference;
    }
    
    /** Getter for property increment.
     * @return Value of property increment.
     */
    public int getIncrement() {
        return this.increment;
    }
    
    /** Setter for property increment.
     * @param increment New value of property increment.
     */
    public void setIncrement(int increment) {
        this.increment = increment;
    }
    
    /** Method to validate the break point entity
     * @throws Exception in invalid data for break point
     */
    public void validate() throws Exception {
        if ((this.breakPointNum <= 0) || (this.breakPointNum > MAX_BREAKPTS))
            throw new Exception("Invalid break point " +breakPointNum);
        if (!isValidAmount(amountDifference))
            throw new Exception("Invalid amount difference for break point " +breakPointNum);
        if (!isValidAmount(increment))
            throw new Exception("Invalid tax increment for break point " +breakPointNum);
    }
    
    private boolean isValidAmount(int amt) {
        if ((amt < 0) || (amt > MAX_AMOUNT_VALUE))
            return false;
        return true;
    }    
}
