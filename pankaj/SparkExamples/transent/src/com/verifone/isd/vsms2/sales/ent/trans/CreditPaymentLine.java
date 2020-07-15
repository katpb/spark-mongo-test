/*
 * CreditPaymentLine.java
 *
 * Created on May 29, 2003, 3:34 PM
 */

package com.verifone.isd.vsms2.sales.ent.trans;

import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/**
 * Payment line for credit MOP
 * @author  Bhanu_N2
 */
public class CreditPaymentLine extends PaymentLine {
    static final long serialVersionUID = -4487827229995242911L;
    
    /** Holds value of property status. */
    private int status;
    
    /** Holds value of property accountBalance. */
    private MoneyAmount accountBalance;
    
    /** Holds value of property approvalNumber. */
    private String approvalNumber;
    
    /** Holds value of property replyMessage. */
    private String replyMessage;
    
    /** Creates a new instance of CreditPaymentLine */
    public CreditPaymentLine() {
    }
    
    /** Getter for property status.
     * @return Value of property status.
     */
    public int getStatus() {
        return this.status;
    }
    
    /** Setter for property status.
     * @param status New value of property status.
     */
    public void setStatus(int status) {
        this.status = status;
    }
    
    /** Getter for property accountBalance.
     * @return Value of property accountBalance.
     */
    public MoneyAmount getAccountBalance() {
        return this.accountBalance;
    }
    
    /** Setter for property accountBalance.
     * @param accountBalance New value of property accountBalance.
     */
    public void setAccountBalance(MoneyAmount accountBalance) {
        this.accountBalance = accountBalance;
    }
    
    /** Getter for property approvalNumber.
     * @return Value of property approvalNumber.
     */
    public String getApprovalNumber() {
        return this.approvalNumber;
    }
    
    /** Setter for property approvalNumber.
     * @param approvalNumber New value of property approvalNumber.
     */
    public void setApprovalNumber(String approvalNumber) {
        this.approvalNumber = approvalNumber;
    }
    
    /** Getter for property replyMessage.
     * @return Value of property replyMessage.
     */
    public String getReplyMessage() {
        return this.replyMessage;
    }
    
    /** Setter for property replyMessage.
     * @param replyMessage New value of property replyMessage.
     */
    public void setReplyMessage(String replyMessage) {
        this.replyMessage = replyMessage;
    }

	/**
	 * Make operations across all entities in a transaction polymorphic with
	 * the abstract visitor class -- all we do is call it's visit() method
	 * and pass a reference to our actual type.  The visitor will have a
	 * method with a signature that matches our type and automatically use it.
	 * Different visitor implementations can be created any time to generate
	 * new results against all the known entities in a transaction.
	 *
	 * <B>NOTE</B> that adding a new data type as an argument to the visit()
	 * method means the abstract class (TransactionVisitor) and all the
	 * visitor implementations must be updated.  We don't expect to be doing
	 * this much.
	 *
	 * @param		v
	 * @exception	Exception
	 */

	public void acceptVisitor(TransactionVisitor v) throws Exception {
		v.visit(this);
	}
}
