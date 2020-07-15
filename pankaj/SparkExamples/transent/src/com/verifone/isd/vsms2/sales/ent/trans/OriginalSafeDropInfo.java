package com.verifone.isd.vsms2.sales.ent.trans;

import com.verifone.isd.vsms2.sys.util.MoneyAmount;

public class OriginalSafeDropInfo implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5202571582818348313L;
	/**
	 * 
	 */

	
	  	private PosID posID;
	    /** Holds value of property drwNum.   */
	    private DrawerID drwNum;
	    private TransNum transNum;
	    /** Holds value of property CashierID.   */
	    private CashierID cashierID;
	    /* property to indicate the cashier name - required for receipt reprint */
	    private String cashierName;
	    /* property to indicate the cashier period (sequence number) - required for cashier reports */
	    private int cashierPeriodSeq;
	    /** Holds value of property amount. */
	    private MoneyAmount amount;
		/**
		 * @return the amount
		 */
		public MoneyAmount getAmount() {
			return amount;
		}
		/**
		 * @param amount the amount to set
		 */
		public void setAmount(MoneyAmount amount) {
			this.amount = amount;
		}
		/**
		 * @return the cashierID
		 */
		public CashierID getCashierID() {
			return cashierID;
		}
		/**
		 * @param cashierID the cashierID to set
		 */
		public void setCashierID(CashierID cashierID) {
			this.cashierID = cashierID;
		}
		/**
		 * @return the cashierName
		 */
		public String getCashierName() {
			return cashierName;
		}
		/**
		 * @param cashierName the cashierName to set
		 */
		public void setCashierName(String cashierName) {
			this.cashierName = cashierName;
		}
		/**
		 * @return the cashierPeriodSeq
		 */
		public int getCashierPeriodSeq() {
			return cashierPeriodSeq;
		}
		/**
		 * @param cashierPeriodSeq the cashierPeriodSeq to set
		 */
		public void setCashierPeriodSeq(int cashierPeriodSeq) {
			this.cashierPeriodSeq = cashierPeriodSeq;
		}
		/**
		 * @return the drwNum
		 */
		public DrawerID getDrwNum() {
			return drwNum;
		}
		/**
		 * @param drwNum the drwNum to set
		 */
		public void setDrwNum(DrawerID drwNum) {
			this.drwNum = drwNum;
		}
		/**
		 * @return the posID
		 */
		public PosID getPosID() {
			return posID;
		}
		/**
		 * @param posID the posID to set
		 */
		public void setPosID(PosID posID) {
			this.posID = posID;
		}
		/**
		 * @return the transNum
		 */
		public TransNum getTransNum() {
			return transNum;
		}
		/**
		 * @param transNum the transNum to set
		 */
		public void setTransNum(TransNum transNum) {
			this.transNum = transNum;
		}
}
