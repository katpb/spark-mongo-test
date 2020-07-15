package com.verifone.isd.vsms2.sales.ent.mop;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.l10n.LocalizedRB;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/**Entity class for Mop.
 * 
 * @author "mailto:bhanu_n2@verifone.com"
 * @version 1.0
 */

public class Mop implements IEntityObject, ISalesEntityVisitable {
    
    /** The Constant serialVersionUID. */
    static final long serialVersionUID = -708007699441676941L;
    
    /** Maximum ID value allowed for Mop; also max # of mop's allowed. */    
    public static final int MAX_MOPS = 100;
    
    /** Maximum mop codes. */     
    private static final int MAX_MIN_AMT = 999999;
    
    /** The Constant MAX_MAX_AMT. */
    private static final int MAX_MAX_AMT = MAX_MIN_AMT;
    
    /** The Constant MAX_LIM_AMT. */
    private static final int MAX_LIM_AMT = MAX_MIN_AMT;
    
    /** The Constant MAX_RCPT_CPS. */
    private static final int MAX_RCPT_CPS = 3;
    
    /** Number of decimals in MoneyAMount used by this class. */    
    public static final int NUM_DECIMALS = 2;
    
    /** The id. */
    private MopPK ID;
    
    /** Holds value of property minimumAmount. */
    private MoneyAmount minimumAmount;
    
    /** Holds value of property maximumAmount. */
    private MoneyAmount maximumAmount;
    
    /** Holds value of property name. */
    private String name;
    
    /** Holds value of property code. */
    private MopCode code;
    
    /** Holds value of property limit. */
    private MoneyAmount limit;
    
	/** Holds value of property numReceiptCopies. */
	private int numReceiptCopies = 0;

    /** Holds value of property forceSafeDrop. */
    private boolean forceSafeDrop;
    
    /** Holds value of property openDrawerOnSale. */
    private boolean openDrawerOnSale;
    
    /** Holds value of property tenderAmountRequired. */
    private boolean tenderAmountRequired;
    
    /** Holds value of property refundable. */
    private boolean refundable;
    
    /** Holds value of property allowWithoutSale. */
    private boolean allowWithoutSale;
    
    /** Holds value of property allowChange. */
    private boolean allowChange;
    
    /** Holds value of property allowZeroEntry. */
    private boolean allowZeroEntry;
    
    /** Holds value of property allowSafeDrop. */
    private boolean allowSafeDrop;
    
    /** Holds value of property allowMoneyOrderPurchase. */
    private boolean allowMoneyOrderPurchase;
    
    /** Holds value of property forceTicketPrint. */
    private boolean forceTicketPrint;
    
    /** Holds value of property forceFixedAmount. */
    private boolean forceFixedAmount;
    
    /** Holds value of property promptForCashierReport. */
    private boolean promptForCashierReport;
    
    /** The tender code. */
    private String nacsTenderCode = LocalizedRB.getNACSCodeRes(NACSTenderCode.GENERIC.getTenderCode());
    
    /** The tender subcode. */
    private String nacsTenderSubcode = LocalizedRB.getNACSCodeRes(NACSTenderSubCode.GENERIC.getTenderSubCode());
    
        
    /** No-args constructor
     */    
    public Mop() {
        this(null); // PK Not yet established!
    }
    
    /** Constructor
     * @param pk MopPK for the object
     */    
    public Mop(MopPK pk) {
        this.ID = pk;
        this.code = MopCode.CASH;
    }
    
    /**
	 * Getter of the entity object's primary key.
	 * 
	 * @return the ID of the entity object
	 */
    @Override
	public IEntityPK getPK() {
        return this.ID;
    }
    
    /**
	 * Method to validate the primary key of the entity object.
	 * 
	 * @return true if the primary key of the entity object is valid
	 */
    @Override
	public boolean isPKValid() {
        return (this.ID == null) ? false : this.ID.isValid();
    }
    
    /**
	 * Set the primary key of the entity object.
	 * 
	 * @param pk
	 *            primary key for the entity object
	 */
    @Override
	public void setPK(IEntityPK pk) {
        this.ID = (MopPK)pk;        
    }
    
    /**
	 * Method to clone this entity's attribute to another.
	 * 
	 * @param obj
	 *            object to copy to
	 */    
    @Override
	public void setAttributes(IEntityObject obj) {
        Mop mObj = (Mop) obj;
        mObj.ID = this.ID;
        mObj.name = this.name;
        mObj.code = this.code;
        mObj.maximumAmount = this.maximumAmount;
        mObj.minimumAmount = this.minimumAmount;
        mObj.limit = this.limit;
        mObj.numReceiptCopies = this.numReceiptCopies;
        mObj.allowChange = this.allowChange;
        mObj.allowMoneyOrderPurchase = this.allowMoneyOrderPurchase;
        mObj.allowSafeDrop = this.allowSafeDrop;
        mObj.allowWithoutSale = this.allowWithoutSale;
        mObj.allowZeroEntry = this.allowZeroEntry;
        mObj.forceSafeDrop = this.forceSafeDrop;
        mObj.forceTicketPrint = this.forceTicketPrint;
        mObj.forceFixedAmount = this.forceFixedAmount;
        mObj.openDrawerOnSale = this.openDrawerOnSale;
        mObj.promptForCashierReport = this.promptForCashierReport;
        mObj.refundable = this.refundable;        
        mObj.tenderAmountRequired = this.tenderAmountRequired;
        mObj.nacsTenderCode = this.nacsTenderCode;
        mObj.nacsTenderSubcode = this.nacsTenderSubcode;
        
    }
    
    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    @Override
	public void validate() throws Exception {
        if (!this.isPKValid()) {
            throw new Exception("Invalid Mop: " +this.ID);            
        }
        if ((this.name == null) || (this.name.trim().equals("")) || 
        (this.name.trim().equals("*"))) {
            throw new Exception("Invalid name for Mop: " +this.ID);
        }
        this.validateAmounts();
    }

    @SuppressWarnings("deprecation")
	private void validateAmounts() throws Exception {
        long minVal = 0;
        if (this.minimumAmount != null) {
            minVal = this.minimumAmount.getLongValue();
            if ((minVal < 0) || (minVal > MAX_MIN_AMT)) {
				throw new Exception("Invalid minimum amount: "
                +this.minimumAmount.toString() +" for Mop: " +this.ID);
			}
        }
        if (this.maximumAmount != null) {
            long maxVal = this.maximumAmount.getLongValue();
            if ((maxVal < 0) || (maxVal > MAX_MAX_AMT)) {
				throw new Exception("Invalid maximum amount: "
                +this.maximumAmount.toString() +" for Mop: " +this.ID);
			}
            if ((maxVal != 0) && (minVal != 0) && (minVal > maxVal)) {
				throw new Exception("Mismatch between minimum and maximum value for Mop: "
                +this.ID);
			}
        }

		int copiesVal = this.numReceiptCopies;
		if ((copiesVal < 0) || (copiesVal > MAX_RCPT_CPS)) {
			throw new Exception("Invalid number of receipt copies: "
			+this.numReceiptCopies + " for Mop: " +this.ID);
		}
    }

    /** Getter for property minimumAmount.
     * @return Value of property minimumAmount.
     */
    public MoneyAmount getMinimumAmount() {
        return (this.minimumAmount == null ? new MoneyAmount(0, Mop.NUM_DECIMALS) 
        : this.minimumAmount);
    }
    
    /** Setter for property minimumAmount.
     * @param minimumAmount New value of property minimumAmount.
     */
    public void setMinimumAmount(MoneyAmount minimumAmount) {
        this.minimumAmount = minimumAmount;
    }
    
    /** Getter for property maximumAmount.
     * @return Value of property maximumAmount.
     */
    public MoneyAmount getMaximumAmount() {
        return (this.maximumAmount == null ? new MoneyAmount(0, Mop.NUM_DECIMALS) 
        : this.maximumAmount);        
    }
    
    /** Setter for property maximumAmount.
     * @param maximumAmount New value of property maximumAmount.
     */
    public void setMaximumAmount(MoneyAmount maximumAmount) {
        this.maximumAmount = maximumAmount;
    }
    
    /** Getter for property name.
     * @return Value of property name.
     */
    public String getName() {
        return (this.name != null ? this.name : "");
    }
    
    /** Setter for property name.
     * @param name New value of property name.
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /** Getter for property code.
     * @return Value of property code.
     */
    public MopCode getCode() {
        if (this.code == null) {
            this.code = MopCode.CASH;            
        }         
        return this.code;
    }
    
    /** Setter for property code.
     * @param code New value of property code.
     */
    public void setCode(MopCode code) {
        this.code = code;
    }
    
    /** Getter for property limit.
     * @return Value of property limit.
     */
    public MoneyAmount getLimit() {
        return (this.limit == null ? new MoneyAmount(0, Mop.NUM_DECIMALS) 
        : this.limit);     
    }
    
    /** Setter for property limit.
     * @param limit New value of property limit.
     */
    public void setLimit(MoneyAmount limit) {
        this.limit = limit;
    }
    
    /** Getter for property forceSafeDrop.
     * @return Value of property forceSafeDrop.
     */
    public boolean isForceSafeDrop() {
        return this.forceSafeDrop;
    }
    
    /** Setter for property forceSafeDrop.
     * @param forceSafeDrop New value of property forceSafeDrop.
     */
    public void setForceSafeDrop(boolean forceSafeDrop) {
        this.forceSafeDrop = forceSafeDrop;
    }
    
    /** Getter for property openDrawerOnSale.
     * @return Value of property openDrawerOnSale.
     */
    public boolean isOpenDrawerOnSale() {
        return this.openDrawerOnSale;
    }
    
    /** Setter for property openDrawerOnSale.
     * @param openDrawerOnSale New value of property openDrawerOnSale.
     */
    public void setOpenDrawerOnSale(boolean openDrawerOnSale) {
        this.openDrawerOnSale = openDrawerOnSale;
    }
    
    /** Getter for property tenderAmountRequired.
     * @return Value of property tenderAmountRequired.
     */
    public boolean isTenderAmountRequired() {
        return this.tenderAmountRequired;
    }
    
    /** Setter for property tenderAmountRequired.
     * @param tenderAmountRequired New value of property tenderAmountRequired.
     */
    public void setTenderAmountRequired(boolean tenderAmountRequired) {
        this.tenderAmountRequired = tenderAmountRequired;
    }
    
    /** Getter for property refundable.
     * @return Value of property refundable.
     */
    public boolean isRefundable() {
        return this.refundable;
    }
    
    /** Setter for property refundable.
     * @param refundable New value of property refundable.
     */
    public void setRefundable(boolean refundable) {
        this.refundable = refundable;
    }
    
    /** Getter for property allowWithoutSale.
     * @return Value of property allowWithoutSale.
     */
    public boolean isAllowWithoutSale() {
        return this.allowWithoutSale;
    }
    
    /** Setter for property allowWithoutSale.
     * @param allowWithoutSale New value of property allowWithoutSale.
     */
    public void setAllowWithoutSale(boolean allowWithoutSale) {
        this.allowWithoutSale = allowWithoutSale;
    }
    
    /** Getter for property allowChange.
     * @return Value of property allowChange.
     */
    public boolean isAllowChange() {
        return this.allowChange;
    }
    
    /** Setter for property allowChange.
     * @param allowChange New value of property allowChange.
     */
    public void setAllowChange(boolean allowChange) {
        this.allowChange = allowChange;
    }
    
    /** Getter for property allowZeroEntry.
     * @return Value of property allowZeroEntry.
     */
    public boolean isAllowZeroEntry() {
        return this.allowZeroEntry;
    }
    
    /** Setter for property allowZeroEntry.
     * @param allowZeroEntry New value of property allowZeroEntry.
     */
    public void setAllowZeroEntry(boolean allowZeroEntry) {
        this.allowZeroEntry = allowZeroEntry;
    }
    
    /** Getter for property allowSafeDrop.
     * @return Value of property allowSafeDrop.
     */
    public boolean isAllowSafeDrop() {
        return this.allowSafeDrop;
    }
    
    /** Setter for property allowSafeDrop.
     * @param allowSafeDrop New value of property allowSafeDrop.
     */
    public void setAllowSafeDrop(boolean allowSafeDrop) {
        this.allowSafeDrop = allowSafeDrop;
    }
    
    /** Getter for property allowMoneyOrderPurchase.
     * @return Value of property allowMoneyOrderPurchase.
     */
    public boolean isAllowMoneyOrderPurchase() {
        return this.allowMoneyOrderPurchase;
    }
    
    /** Setter for property allowMoneyOrderPurchase.
     * @param allowMoneyOrderPurchase New value of property allowMoneyOrderPurchase.
     */
    public void setAllowMoneyOrderPurchase(boolean allowMoneyOrderPurchase) {
        this.allowMoneyOrderPurchase = allowMoneyOrderPurchase;
    }
    
    /** Getter for property forceTicketPrint.
     * @return Value of property forceTicketPrint.
     */
    public boolean isForceTicketPrint() {
        return this.forceTicketPrint;
    }
    
    /** Setter for property forceTicketPrint.
     * @param forceTicketPrint New value of property forceTicketPrint.
     */
    public void setForceTicketPrint(boolean forceTicketPrint) {
        this.forceTicketPrint = forceTicketPrint;
    }
    
    /** Getter for property forceFixedAmount.
     * @return Value of property forceFixedAmount.
     */
    public boolean isForceFixedAmount() {
        return this.forceFixedAmount;
    }
    
    /** Setter for property forceFixedAmount.
     * @param forceFixedAmount New value of property forceFixedAmount.
     */
    public void setForceFixedAmount(boolean forceFixedAmount) {
        this.forceFixedAmount = forceFixedAmount;
    }
    
    
    
    
    
    /** Getter for property promptForCashierReport.
     * @return Value of property promptForCashierReport.
     */
    public boolean isPromptForCashierReport() {
        return this.promptForCashierReport;
    }
    
    /** Setter for property promptForCashierReport.
     * @param promptForCashierReport New value of property promptForCashierReport.
     */
    public void setPromptForCashierReport(boolean promptForCashierReport) {
        this.promptForCashierReport = promptForCashierReport;
    }

    /** Getter for property numReceiptCopies.
     * @return Value of property numReceiptCopies.
     */
    public int getNumReceiptCopies() {
        return this.numReceiptCopies;
    }

    /** Setter for property numReceiptCopies.
     * @param numReceiptCopies New value of property numReceiptCopies.
     */
    public void setNumReceiptCopies(int numReceiptCopies) {
        this.numReceiptCopies = numReceiptCopies;
    }
   

	/**
	 * Gets the tender code.
	 * 
	 * @return the nacsTenderCode
	 */
	public String getNacsTenderCode() {
		return this.nacsTenderCode;
	}

	/**
	 * Gets the tender subcode.
	 * 
	 * @return the nacsTenderSubcode
	 */
	public String getNacsTenderSubcode() {
		return this.nacsTenderSubcode;
	}

	/**
	 * Sets the tender code.
	 * 
	 * @param nacsTenderCode
	 *            the nacsTenderCode to set
	 */
	public void setNacsTenderCode(String nacsTenderCode) {
		if(null != nacsTenderCode)
			this.nacsTenderCode = nacsTenderCode;
	}

	/**
	 * Sets the tender subcode.
	 * 
	 * @param nacsTenderSubcode
	 *            the nacsTenderSubcode to set
	 */
	public void setNacsTenderSubcode(String nacsTenderSubcode) {
		if(null != nacsTenderSubcode)
			this.nacsTenderSubcode = nacsTenderSubcode;
	}

	/** Impelmentation method for visitable in visitor pattern
     * @param v visitor
     * @throws Exception on exception in visitor's visit method
     */    
    @Override
	public void accept(SalesEntityVisitor v) throws Exception {
        v.visit(this);
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.ID == null) ? 0 : this.ID.hashCode());
		result = (prime * result) + (this.allowChange ? 1231 : 1237);
		result = (prime * result) + (this.allowMoneyOrderPurchase ? 1231 : 1237);
		result = (prime * result) + (this.allowSafeDrop ? 1231 : 1237);
		result = (prime * result) + (this.allowWithoutSale ? 1231 : 1237);
		result = (prime * result) + (this.allowZeroEntry ? 1231 : 1237);
		result = (prime * result) + ((this.code == null) ? 0 : this.code.hashCode());
		result = (prime * result) + (this.forceSafeDrop ? 1231 : 1237);
		result = (prime * result) + (this.forceTicketPrint ? 1231 : 1237);
		result = (prime * result) + (this.forceFixedAmount ? 1231 : 1237);
		result = (prime * result) + ((this.limit == null) ? 0 : this.limit.hashCode());
		result = (prime * result)
				+ ((this.maximumAmount == null) ? 0 : this.maximumAmount.hashCode());
		result = (prime * result)
				+ ((this.minimumAmount == null) ? 0 : this.minimumAmount.hashCode());
		result = (prime * result)
				+ ((this.nacsTenderCode == null) ? 0 : this.nacsTenderCode.hashCode());
		result = (prime
				* result)
				+ ((this.nacsTenderSubcode == null) ? 0 : this.nacsTenderSubcode
						.hashCode());
		result = (prime * result) + ((this.name == null) ? 0 : this.name.hashCode());
		result = (prime * result) + this.numReceiptCopies;
		result = (prime * result) + (this.openDrawerOnSale ? 1231 : 1237);
		result = (prime * result) + (this.promptForCashierReport ? 1231 : 1237);
		result = (prime * result) + (this.refundable ? 1231 : 1237);
		result = (prime * result) + (this.tenderAmountRequired ? 1231 : 1237);
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Mop)) {
			return false;
		}
		Mop other = (Mop) obj;
		if (this.ID == null) {
			if (other.ID != null) {
				return false;
			}
		} else if (!this.ID.equals(other.ID)) {
			return false;
		}
		if (this.allowChange != other.allowChange) {
			return false;
		}
		if (this.allowMoneyOrderPurchase != other.allowMoneyOrderPurchase) {
			return false;
		}
		if (this.allowSafeDrop != other.allowSafeDrop) {
			return false;
		}
		if (this.allowWithoutSale != other.allowWithoutSale) {
			return false;
		}
		if (this.allowZeroEntry != other.allowZeroEntry) {
			return false;
		}
		if (this.code == null) {
			if (other.code != null) {
				return false;
			}
		} else if (!this.code.equals(other.code)) {
			return false;
		}
		if (this.forceSafeDrop != other.forceSafeDrop) {
			return false;
		}
		if (this.forceTicketPrint != other.forceTicketPrint) {
			return false;
		}
		if (this.forceFixedAmount != other.forceFixedAmount) {
			return false;
		}
		if (this.limit == null) {
			if (other.limit != null) {
				return false;
			}
		} else if (!this.limit.equals(other.limit)) {
			return false;
		}
		if (this.maximumAmount == null) {
			if (other.maximumAmount != null) {
				return false;
			}
		} else if (!this.maximumAmount.equals(other.maximumAmount)) {
			return false;
		}
		if (this.minimumAmount == null) {
			if (other.minimumAmount != null) {
				return false;
			}
		} else if (!this.minimumAmount.equals(other.minimumAmount)) {
			return false;
		}
		if (this.nacsTenderCode == null) {
			if (other.nacsTenderCode != null) {
				return false;
			}
		} else if (!this.nacsTenderCode.equals(other.nacsTenderCode)) {
			return false;
		}
		if (this.nacsTenderSubcode == null) {
			if (other.nacsTenderSubcode != null) {
				return false;
			}
		} else if (!this.nacsTenderSubcode.equals(other.nacsTenderSubcode)) {
			return false;
		}
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		if (this.numReceiptCopies != other.numReceiptCopies) {
			return false;
		}
		if (this.openDrawerOnSale != other.openDrawerOnSale) {
			return false;
		}
		if (this.promptForCashierReport != other.promptForCashierReport) {
			return false;
		}
		if (this.refundable != other.refundable) {
			return false;
		}
		if (this.tenderAmountRequired != other.tenderAmountRequired) {
			return false;
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Mop [ID=" + this.ID + ", minimumAmount=" + this.minimumAmount
				+ ", maximumAmount=" + this.maximumAmount + ", name=" + this.name
				+ ", code=" + this.code + ", limit=" + this.limit + ", numReceiptCopies="
				+ this.numReceiptCopies + ", forceSafeDrop=" + this.forceSafeDrop
				+ ", openDrawerOnSale=" + this.openDrawerOnSale
				+ ", tenderAmountRequired=" + this.tenderAmountRequired
				+ ", refundable=" + this.refundable + ", allowWithoutSale="
				+ this.allowWithoutSale + ", allowChange=" + this.allowChange
				+ ", allowZeroEntry=" + this.allowZeroEntry + ", allowSafeDrop="
				+ this.allowSafeDrop + ", allowMoneyOrderPurchase="
				+ this.allowMoneyOrderPurchase + ", forceTicketPrint="
				+ this.forceTicketPrint + ", forceFixedAmount="
				+ this.forceFixedAmount + ", promptForCashierReport="
				+ this.promptForCashierReport + ", nacsTenderCode=" + this.nacsTenderCode
				+ ", nacsTenderSubcode=" + this.nacsTenderSubcode + "]";
	}
}