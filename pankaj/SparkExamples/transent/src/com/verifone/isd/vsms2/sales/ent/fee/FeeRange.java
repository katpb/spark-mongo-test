package com.verifone.isd.vsms2.sales.ent.fee;

import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import java.io.Serializable;

 /**
  * Helper class for Fee; stores the fee range details
  * @author "mailto:bhanu_n2@verifone.com"
  */
public class FeeRange implements Serializable
{
    static final long serialVersionUID = 2469631982590584385L;
    private MoneyAmount feeAmount;
    private MoneyAmount rangeEnd;
    
    /** Constructor
     * @param feeAmount fee amount
     * @param rangeEnd fee range end amount
     */    
    public FeeRange(MoneyAmount feeAmount, MoneyAmount rangeEnd)
    {
        this.feeAmount = feeAmount;
        this.rangeEnd = rangeEnd;
    }
    
    /** Getter for fee amount for the range
     * @return fee amount for the range
     */    
    public MoneyAmount getFeeAmount()
    {
        return this.feeAmount;
    }
    
    /** Getter for fee range end
     * @return fee range end amount
     */    
    public MoneyAmount getFeeRangeEnd()
    {
        return this.rangeEnd;
    }
    
    /** Setter for fee amount
     * @param feeAmount fee amount for the range
     */    
    public void setFeeAmount(MoneyAmount feeAmount)
    {
        this.feeAmount = feeAmount;
    }
    
    /** Setter for the fee range end
     * @param rangeEnd fee range end amount
     */    
    public void setFeeRangeEnd(MoneyAmount rangeEnd)
    {
        this.rangeEnd = rangeEnd;
    }
}