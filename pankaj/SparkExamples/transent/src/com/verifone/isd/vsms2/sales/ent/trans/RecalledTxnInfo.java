/*
 * TransactionInfo.java
 *
 * Created on April 21, 2003, 9:57 AM
 */

package com.verifone.isd.vsms2.sales.ent.trans;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import java.util.Date;

/** Helper entity for Transaction that holds secondary/ non-monetary info
 * about the transaction
 * @author Bhanu_N2
 */
public class RecalledTxnInfo implements java.io.Serializable {
    static final long serialVersionUID = -8354248857383163626L;
    
    /** Holds value of property posID. */
    private PosID posID;
    
    private TransNum transNum;
    
    /** Holds value of property beginTime.  */
    private Date beginTime;
    
    /** Holds value of property endTime.  */
    private Date endTime;
    
    /** Holds value of property totalBeforeTax. */
    private MoneyAmount totalBeforeTax;
    
    /**
     * Holds value of property transactionType.
     */
    private TransactionType transactionType;
    
    /** Creates a new instance of TransactionInfo */
    public RecalledTxnInfo() {
    }
    
    /** Getter for property posID.
     * @return Value of property posID.
     */
    public PosID getPosID() {
        return this.posID;
    }
    
    /** Setter for property posID.
     * @param posID New value of property posID.
     */
    public void setPosID(PosID posID) {
        this.posID = posID;
    }
    
    /** Set the transaction number
     * @param transNum transaction number
     */    
    public void setTransNum(TransNum transNum) {
        this.transNum = transNum;
    }
    
    /** Getter for transaction number
     * @return transaction number
     */    
    public TransNum getTransNum() {
        return this.transNum;
    }
    
    /** Getter for property totalBeforeTax.
     * @return Value of property totalBeforeTax.
     */
    public MoneyAmount getTotalBeforeTax() {
        return this.totalBeforeTax;
    }
    
    /** Setter for property totalBeforeTax.
     * @param totalBeforeTax New value of property totalBeforeTax.
     */
    public void setTotalBeforeTax(MoneyAmount totalBeforeTax) {
        this.totalBeforeTax = totalBeforeTax;
    }
    
    /** Getter for property beginTime.
     * @return Value of property beginTime.
     *
     */
    public java.util.Date getBeginTime() {
        return beginTime;
    }
    
    /** Setter for property beginTime.
     * @param beginTime New value of property beginTime.
     *
     */
    public void setBeginTime(java.util.Date beginTime) {
        this.beginTime = beginTime;
    }
    
    /** Getter for property endTime.
     * @return Value of property endTime.
     *
     */
    public java.util.Date getEndTime() {
        return endTime;
    }
    
    /** Setter for property endTime.
     * @param endTime New value of property endTime.
     *
     */
    public void setEndTime(java.util.Date endTime) {
        this.endTime = endTime;
    }
    
    /**
     * Getter for property transactionType.
     * @return Value of property transactionType.
     */
    public TransactionType getTransactionType() {
        return (this.transactionType == null) ? TransactionType.SALE : this.transactionType;
    }
    
    /**
     * Setter for property transactionType.
     * @param transactionType New value of property transactionType.
     */
    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
    
}
