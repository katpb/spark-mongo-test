/*
 * ChangeLine.java
 *
 * Created on April 23, 2003, 10:15 AM
 */

package com.verifone.isd.vsms2.sales.ent.trans;
import com.verifone.isd.vsms2.sys.l10n.LocalizedRB;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import com.verifone.isd.vsms2.sales.ent.mop.MopCode;
import com.verifone.isd.vsms2.sales.ent.mop.NACSTenderCode;
import com.verifone.isd.vsms2.sales.ent.mop.NACSTenderSubCode;

/** An entity to represent the change to be given to the customer.
 * This is explicitly called out since computing the change has
 * certain business rules (e.g., the MOP's that can be used to
 * given change: Cash and foodstamp with a pre-determined minimum
 * denomination). We may find out that PaymentLine is sufficient
 * to handle change with different MOPs!.
 * @author Bhanu_N2
 */
public class ChangeLine implements java.io.Serializable {
	private static final long serialVersionUID = -1906638186349677134L;

	private MoneyAmount amount;
    
    /** Holds value of property description.  */
    private String description;
    
    /** Holds value of property mopCode.  */
    private MopCode mopCode;
    
    /** Holds value of property mopNum.  */
    private int mopNum;
    
    /** Holds value of property duplicate */
    private boolean duplicate;
    
    /** Hold Cash Back flag */
    private boolean cashBack;
    
    /** The tender code. */
    private String nacsTenderCode;
    
    /** The tender subcode. */
    private String nacsTenderSubcode;
    
    /** Creates a new instance of ChangeLine */
    public ChangeLine() {
    }
    
    /** Getter for property amount.
     * @return Value of property amount.
     */
    public MoneyAmount getAmount() {
        return this.amount;
    }
    
    /** Setter for property amount.
     * @param amount New value of property amount.
     */
    public void setAmount(MoneyAmount amount) {
        this.amount = amount;
    }    
    
    /** Getter for property description.
     * @return Value of property description.
     */
    public String getDescription() {
        return this.description;
    }
    
    /** Getter for property mopCode.
     * @return Value of property mopCode.
     */
    public MopCode getMopCode() {
        return this.mopCode;
    }
    
    /** Getter for property mopNum.
     * @return Value of property mopNum.
     */
    public int getMopNum() {
        return this.mopNum;
    }
    
    /** Setter for property description.
     * @param description New value of property description.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /** Setter for property mopCode.
     * @param mopCode New value of property mopCode.
     */
    public void setMopCode(MopCode mopCode) {
        this.mopCode = mopCode;
    }
    
    /** Setter for property mopNum.
     * @param mopNum New value of property mopNum.
     */
    public void setMopNum(int mopNum) {
        this.mopNum = mopNum;
    }

	/**
	 * @return the duplicate
	 */
	public boolean isDuplicate() {
		return duplicate;
	}

	/**
	 * @param duplicate the duplicate to set
	 */
	public void setDuplicate(boolean duplicate) {
		this.duplicate = duplicate;
	}

	public boolean isCashBack() {
		return cashBack;
	}

	public void setCashBack(boolean cashBack) {
		this.cashBack = cashBack;
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
	 * @param v the Transaction Visitor object
	 * @exception	Exception
	 */

	public void acceptVisitor(TransactionVisitor v) throws Exception {
		v.visit(this);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChangeLine [amount=" + amount + ", description=" + description
				+ ", mopCode=" + mopCode + ", mopNum=" + mopNum
				+ ", duplicate=" + duplicate + "]";
	}

	/**
	 * @return the nacsTenderCode
	 */
	public String getNacsTenderCode() {
		return nacsTenderCode;
	}

	/**
	 * @param nacsTenderCode the nacsTenderCode to set
	 */
	public void setNacsTenderCode(String nacsTenderCode) {
		this.nacsTenderCode = nacsTenderCode;
	}

	/**
	 * @return the nacsTenderSubcode
	 */
	public String getNacsTenderSubcode() {
		return nacsTenderSubcode;
	}

	/**
	 * @param nacsTenderSubcode the nacsTenderSubcode to set
	 */
	public void setNacsTenderSubcode(String nacsTenderSubcode) {
		this.nacsTenderSubcode = nacsTenderSubcode;
	}
}
