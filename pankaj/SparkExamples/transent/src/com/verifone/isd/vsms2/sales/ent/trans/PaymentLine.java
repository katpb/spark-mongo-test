/*
 * PaymentLine.java
 *
 * Created on April 7, 2003, 2:13 PM
 */

package com.verifone.isd.vsms2.sales.ent.trans;

import java.util.Map;
import java.util.TreeMap;

import com.verifone.isd.vsms2.net.ent.DiscretionaryDataReceiptPreferenceEnum;
import com.verifone.isd.vsms2.sales.ent.currency.Currency;
import com.verifone.isd.vsms2.sales.ent.mop.MopCode;
import com.verifone.isd.vsms2.sys.ent.securityctrl.SecurityLevel;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import com.verifone.isd.vsms2.sys.util.Volume;


/**
 * Class that holds information about a payment line in the transaction.
 * This is the base class for all payment lines. Note that to reduce the
 * object overhead involved, only the primary key's raw form and 
 * any information required to reprint are stored in this class. 
 * It is assumed that the corresponding controller will query for 
 * those entities, if required.
 * @author Bhanu_N2
 */
public class PaymentLine implements java.io.Serializable {
	
	private static final long serialVersionUID = -5841516346868935717L;
	
	protected static final MoneyAmount ZERO_AMOUNT = new MoneyAmount(0);

	/** Holds value of property amount. */
    private MoneyAmount amount;
    
    /** Holds value of property fee. */
    private MoneyAmount fee;
    
    /** Holds value of property cashback. */
    private MoneyAmount cashback;
    
    /** Holds value of property description.  */
    private String description;
    
    /** Holds value of property mopCode.  */
    private MopCode mopCode;
    
    /** Holds value of property mopName */
    private String mopName;
    
    /** Holds value of property mopNum.  */
    private int mopNum;
    
    //	added by sudesh_s1 for coupon scanning
    /** Holds value based on entry type.
     * MANUAL - manual
     * SCAN_CHECKER - scan/checker
     * SCANNER - scanned */
    private EntryMethod entryType;
    
    /** Holds value of property netPayInfo.  */
    private NetPayInfo netPayInfo;
    
    /** Holds value of property foreignCurrency.  */
    private Currency foreignCurrency;
    
    /** Holds value of property foreignCurrencyAmount.  */
    private MoneyAmount foreignCurrencyAmount;
        
    /** Holds value of property preAuthOnly. */
    private boolean preAuthOnly;
    
    /** Holds value of property failedCompletion */
    private boolean failedCompletion;
    
    /** Holds value of property duplicate */
    private boolean duplicate;
    
    /** Holds value of property financialAdvice. */
    private boolean financialAdvice;

    /** Holds original pre-auth amount in case of a credit fuel prepay. */
    private MoneyAmount originalPreauth;
    
    /** The nacs tender code. */
    private String nacsTenderCode ;
    
    /** The nacs tender sub code. */
    private String nacsTenderSubCode ;
    
    /** The flag for fiscal printer, value will come from viper */
    private boolean fiscalReceipt = true;
    
    private boolean signatureOnCompletion = false;
    
    private boolean preauthIsFinal;	// indicates completion amount must be same as pre-auth
    
    private Map<Integer, Volume> volumeLimits = new TreeMap<Integer, Volume>();
    
    /**
    * This parameter records the index of the payment line
    * to keep track of the order of payment lines sent by external POS
    * 
    * The value will default to 0, when not used. 
    * For normal usage(currently from the extPos component), the indices would start from 1
    */
    private int externalPaymentID;

    /** Holds helper Cashier Security Level*/
    private SecurityLevel helperSecurityLevel;
    
    
    /** Creates a new instance of PaymentLine */
    public PaymentLine() {
    }
    
    /** Getter for property amount.
     * @return Value of property amount.
     */
    public MoneyAmount getAmount() {
        return (this.amount == null?ZERO_AMOUNT:this.amount);
    }
    
    /** Setter for property amount.
     * @param amount New value of property amount.
     */
    public void setAmount(MoneyAmount amount) {
        this.amount = amount;
    }
    
    /** Getter for property fee.
     * @return Value of property fee.
     */
    public MoneyAmount getFee() {
        return this.fee;
    }
    
    /** Setter for property fee.
     * @param fee New value of property fee.
     */
    public void setFee(MoneyAmount fee) {
        this.fee = fee;
    }
    
    /** Getter for property cashback.
     * @return Value of property cashback.
     */
    public MoneyAmount getCashback() {
        return this.cashback;
    }
    
    /** Setter for property cashback.
     * @param cashback New value of property cashback.
     */
    public void setCashback(MoneyAmount cashback) {
        this.cashback = cashback;
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
    
    /** Getter for property netPayInfo.
     * @return Value of property netPayInfo.
     */
    public NetPayInfo getNetPayInfo() {
        return this.netPayInfo;
    }
    
    /** Setter for property netPayInfo.
     * @param netPayInfo New value of property netPayInfo.
     */
    public void setNetPayInfo(NetPayInfo netPayInfo) {
        this.netPayInfo = netPayInfo;
    }

    /** Getter for property foreignCurrency.
     * @return Value of property foreignCurrency.
     */
    public Currency getForeignCurrency() {
        return this.foreignCurrency;
    }
    /** Setter for property foreignCurrency.
     * @param foreignCurrency New value of property foreignCurrency.
     */
    public void setForeignCurrency(Currency foreignCurrency) {
        this.foreignCurrency = foreignCurrency;
    }
    
    /** Getter for property foreignCurrAmt.
     * @return Value of property foreignCurrAmt.
     */
    public MoneyAmount getForeignCurrencyAmount() {
        return this.foreignCurrencyAmount;
    }
    /** Setter for property foreignCurrAmt.
     * @param foreignCurrencyAmount New value of property foreignCurrAmt.
     */
    public void setForeignCurrencyAmount(MoneyAmount foreignCurrencyAmount) {
        this.foreignCurrencyAmount = foreignCurrencyAmount;
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
        
        /**
		 * Gets the holds value based on entry type.
		 * 
		 * @return EntryMethod
		 */
        public EntryMethod getEntryType() {
            return this.entryType;
        }
        
        /**
		 * Sets the holds value based on entry type.
		 * 
		 * @param em
		 *            the new holds value based on entry type
		 */
        public void setEntryType(EntryMethod em) {
            this.entryType = em;
        }
        
        
        /**
		 * Checks if is holds value of property preAuthOnly.
		 * 
		 * @return the holds value of property preAuthOnly
		 */
        public boolean isPreAuthOnly() {
            return this.preAuthOnly;
        }
        
        /**
		 * Sets the holds value of property preAuthOnly.
		 * 
		 * @param pre
		 *            the new holds value of property preAuthOnly
		 */
        public void setPreAuthOnly(boolean pre) {
            this.preAuthOnly = pre;
        }

        /**
         * Tests the duplicate attribute of this paymentLine. If a paymentLine is
         * marked as duplicate within a DCR-initiated transaction, any operation
         * relating to this paymentLine would not be notified to any of the
         * salesengine-related features.
         * @return true if the paymentLine is marked as duplicate and false
         *         otherwise
         */
        public boolean isDuplicate() {
            return this.duplicate;
        }

        /** Sets the duplicate attribute of this paymentLine.
         * @param duplicate true if features should not be notified;false otherwise
         */
        public void setDuplicate(boolean duplicate) {
            this.duplicate = duplicate;
        }
		
		/**
		 * Gets the holds original pre-auth amount in case of a credit fuel
		 * prepay.
		 * 
		 * @return the originalPreauth
		 */
		public MoneyAmount getOriginalPreauth() {
			return this.originalPreauth;
		}
		
		/**
		 * Sets the holds original pre-auth amount in case of a credit fuel
		 * prepay.
		 * 
		 * @param originalPreauth
		 *            the originalPreauth to set
		 */
		public void setOriginalPreauth(MoneyAmount originalPreauth) {
			this.originalPreauth = originalPreauth;
		}

		/**
		 * Checks if is holds value of property financialAdvice.
		 * 
		 * @return the financialAdvice
		 */
		public boolean isFinancialAdvice() {
			return this.financialAdvice;
		}

		/**
		 * Sets the holds value of property financialAdvice.
		 * 
		 * @param financialAdvice
		 *            the financialAdvice to set
		 */
		public void setFinancialAdvice(boolean financialAdvice) {
			this.financialAdvice = financialAdvice;
		}

		/**
		 * @return the failedCompletion
		 */
		public boolean isFailedCompletion() {
			return failedCompletion;
		}

		/**
		 * @param failedCompletion the failedCompletion to set
		 */
		public void setFailedCompletion(boolean failedCompletion) {
			this.failedCompletion = failedCompletion;
		}

		/**
		 * @return the mopName
		 */
		public String getMopName() {
			/*
			 * If MOP name was not explicitly set on payment line, use description
			 * to maintain backward compatibility with existing code
			 */
			if ((mopName == null) || mopName.isEmpty()) {
				return description;
			}
			return mopName;
		}

		/**
		 * @param mopName the mopName to set
		 */
		public void setMopName(String mopName) {
			this.mopName = mopName;
		}		
		/** Gets the NACS tender code.
		 * 
		 * @return the nacsTenderCode
		 */
		public String getNacsTenderCode() {
			return this.nacsTenderCode;
		}

		/**
		 * Gets the NACS tender sub code.
		 * 
		 * @return the nacsTenderSubCode
		 */
		public String getNacsTenderSubCode() {
			return this.nacsTenderSubCode;
		}

		/**
		 * Sets the NACS tender code.
		 * 
		 * @param nacsTenderCode
		 *            the nacsTenderCode to set
		 */
		public void setNacsTenderCode(String nacsTenderCode) {
			this.nacsTenderCode = nacsTenderCode;
		}

		/**
		 * Sets the NACS tender sub code.
		 * 
		 * @param nacsTenderSubCode
		 *            the nacsTenderSubCode to set
		 */
		public void setNacsTenderSubCode(String nacsTenderSubCode) {
			this.nacsTenderSubCode = nacsTenderSubCode;
		}

		/**
		 * @return the fiscalReceipt
		 */
		public boolean isFiscalReceipt() {
			return fiscalReceipt;
		}

		/**
		 * @param fiscalReceipt the fiscalReceipt to set
		 */
		public void setFiscalReceipt(boolean fiscalReceipt) {
			this.fiscalReceipt = fiscalReceipt;
		}

		/**
		 * @return the signatureOnCompletion
		 */
		public boolean isSignatureOnCompletion() {
			return signatureOnCompletion;
		}

		/**
		 * @param signatureOnCompletion the signatureOnCompletion to set
		 */
		public void setSignatureOnCompletion(boolean signatureOnCompletion) {
			this.signatureOnCompletion = signatureOnCompletion;
		}


		public int getExternalPaymentID() {
			return externalPaymentID;
		}

		public void setExternalPaymentID(int externalPaymentID) {
			this.externalPaymentID = externalPaymentID;
		}
		public boolean isPreauthIsFinal() {
			return preauthIsFinal;
		}

		public void setPreauthIsFinal(boolean preauthIsFinal) {
			this.preauthIsFinal = preauthIsFinal;
		}
		
		
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "PaymentLine [amount=" + this.amount + ", fee=" + this.fee
					+ ", cashback=" + this.cashback + ", description=" + this.description
					+ ", mopCode=" + this.mopCode + ", mopNum=" + this.mopNum
					+ ", entryType=" + this.entryType + ", netPayInfo=" + this.netPayInfo
					+ ", foreignCurrency=" + this.foreignCurrency
					+ ", foreignCurrencyAmount=" + this.foreignCurrencyAmount
					+ ", preAuthOnly=" + this.preAuthOnly + ", duplicate="
					+ this.duplicate + ", financialAdvice=" + this.financialAdvice
					+ ", originalPreauth=" + this.originalPreauth
					+ ", nacsTenderCode=" + this.nacsTenderCode
					+ ", nacsTenderSubCode=" + this.nacsTenderSubCode 
					+ "fiscalReceipt=" + this.fiscalReceipt
					+ "signatureOnCompletion=" + this.signatureOnCompletion
					+ "externalPaymentID=" + this.externalPaymentID
					+ "helperSecurityLevel=" + this.helperSecurityLevel 
					+ "]";

		}
		
	public Map<Integer, Volume> getVolumeLimits() {
		return volumeLimits;
	}

	public SecurityLevel getHelperSecurityLevel() {
		return helperSecurityLevel;
	}

	public void setHelperSecurityLevel(SecurityLevel helperSecurityLevel) {
		this.helperSecurityLevel = helperSecurityLevel;
	}
	
	public boolean isEZReceiptOnly() {
		if (this.netPayInfo!=null && this.netPayInfo.getCustomerReceiptPreference()!=null ) {
		    return true;
		}
		return false;
	}
	
}
