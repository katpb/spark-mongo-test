/*
 * PluItemLine.java
 *
 * Created on May 30, 2003, 4:16 PM
 */

package com.verifone.isd.vsms2.sales.ent.trans;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.verifone.isd.vsms2.sales.ent.plu.PluPK;
import com.verifone.isd.vsms2.sales.ent.menu.MenuPK;
import com.verifone.isd.vsms2.sales.ent.salescfg.DiscountType;
import com.verifone.isd.vsms2.sales.ent.tax.TaxPK;
import com.verifone.isd.vsms2.sales.ent.trans.TransNum;
import com.verifone.isd.vsms2.sales.ent.plupromo.CarWashPromoProperties;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import com.verifone.isd.vsms2.sys.util.Quantity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PLU item line
 * @author  Bhanu_N2
 */
public class PluItemLine extends SimpleItemLine {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8475987706972985869L;

	private static final Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sales.ent.trans.PluItemLine.class);
    
    private static final MoneyAmount ZERO_AMT = new MoneyAmount(0);
    private static final Quantity DEFAULT_SELL_UNIT = new Quantity(1, "");
    
    /** Holds value of property pluNum. */
    private PluPK pluNum;
    
    /** Set to show CSR used PRICE OVERRIDE on item sale */
    private boolean	priceOverride;
    
    /** Holds value of the overriden price of the item   */
    private MoneyAmount	overriddenPrice;
    
    /** 
     * If this PLU is not found in the DB, this flag helps to determine 
     * whether to add the item to the exception items or to assign 
     * this to the configured PluNotFoundDepartment  
     * */
    private boolean	allowPluNotFound;
    
    /** Set to show PLU was not found in course of sale */
    private boolean	pluNotFound;
    
    /** Holds value of property entryMethod. */
    private EntryMethod entryMethod;
    
    /** Holds value of property carwashCode. */
    private String carwashCode;
    
    /** 
     * Set to indicate carwash has been processed for the carwash PLU
     * This is to prevent attempts to get code again when 
     * adding to transaction model from RainCheckController 
     * 
     * */
    private boolean carwashProcessed;
    
    /** Holds value of property carwashPromo. */
    private MoneyAmount carwashPromo;
    
    /** Holds value of property priceOverrideReason. */
    private String priceOverrideReason;
    
    /** Holds value of property carwashPromoProps. */
    private CarWashPromoProperties carwashPromoProps;
    
    /** Holds value of property carwashDiscountType. */
    private DiscountType carwashDiscountType;
    
    /** Holds value of property carwashKeyNum. */
    private int carwashKeyNum;
    
    //added by sudesh_s1 for coupon scanning
	/** Holds boolean value to denote whether a coupon was
	 * redeemed against this PLU item. */
	private boolean couponRedeemed = false;

	private boolean isKioskInitiated= false;
	
	/** Holds value of property kioskOrderNumber.*/
	private TransNum kioskOrderNumber;


	/** Holds value of property sellingUnit. */
    private Quantity sellingUnit; 
    
    /** Holds value of property itemId. */
    /* The NAXML Maintenance Request schema calls this piece of data
     * ItemID.  For naming consistency, we have chosen the same name 
     * for the following variable which represents the "ItemID".
     */
    private String itemId;
    
    private MoneyAmount taxableRebateAmount;
    
    /**
     * Holds value of property scannedRWAmount. Required to compute package 'qty' across suspend/ recall if 'Change Qty' is also applied.
     */
    private MoneyAmount scannedRWAmount;
    
    /**
     * Will store the extended UPC information.
     */
    private String extendedUpc;
    
    /**
     * Flag to indicate the item added by cashier temporarily during price check.
     */
    private boolean isPriceCheckItem;
    
    /** Holds the collection of tax PKs applied to this item for taxable rebate. */
    private Set<TaxPK>	rebateTaxpks;

    /**
     * If non-null, it is the 'kitchen' order number this PLU was sent with.
     */
    private TransNum kitchenOrderNumber = null;

	/* Holds the main menu number for the item if the item is in a menu and was added to the transaction */
	private MenuPK mainMenuNumberPK = null;

	/* Holds the menu number for the item if the item is in a menu and was added to the transaction */
	private MenuPK menuNumberPK = null;

	/* Holds the menuSelectIndex for the item if the item is in a menu and was added to the transaction*/
	private int menuSelectIndex = -1;

	/* Holds the  for the first choosen menu item. Needed to edit food order*/
	private int firstSelectedMenuUnpender = -1;

  
    /** Creates a new instance of PluItemLine */
    public PluItemLine() {
    	super();
    	this.rebateTaxpks = Collections.synchronizedSet(new HashSet<TaxPK>());
    }
    
	/**
	 * Override interface so we can test for subclass & properly init
	 *
	 * @param	param an ItemLine object
	 */

    public void deepCopy(ItemLine param) {
   		if (param instanceof PluItemLine) {
			this.deepCopy((PluItemLine)param);
		} else {
        super.deepCopy(param);
		}
	}
    
	/**
	 * Override base class so we can test for subclass & properly init
	 *
	 * @param	clone a SimpleItemLine
	 */

    public void deepCopy(SimpleItemLine clone) {
		if (clone instanceof PluItemLine) {
			this.deepCopy((PluItemLine)clone);
		} else {
			super.deepCopy(clone);
		}
	}

	/**
	 * Ensure we init all the required fields for the subclass, in
	 * particular get the discount info correct.
	 *
	 * @param	clone a PLuItemLine
	 */

    public void deepCopy(PluItemLine clone) {
		PluDiscountInfo clonedPluDisc = null;

		try {
			DiscountInfo[] pdisc = this.getAllDiscountInfo();
			for (int i = 0; i < pdisc.length; i++) {
				clonedPluDisc = new PluDiscountInfo();

				pdisc[i].deepCopy(clonedPluDisc);
				clone.addDiscountInfo(clonedPluDisc);
			}
		} catch (ClassCastException ccx) {
			logger.error(
				"PluItemLine.deepCopy() caused ClassCastException cloning " +
				((clonedPluDisc != null) ?
					clonedPluDisc.getClass().toString() : "null"));
		}

        super.deepCopy(clone);
        clone.carwashCode = this.carwashCode;
        clone.carwashPromo = this.carwashPromo;
        clone.carwashDiscountType=this.carwashDiscountType;
        clone.allowPluNotFound = this.allowPluNotFound;
        clone.pluNotFound = this.pluNotFound;
        clone.priceOverride = this.priceOverride;
        clone.overriddenPrice = this.overriddenPrice;
        clone.pluNum = new PluPK();
        clone.pluNum.setValue(this.pluNum.getValue());
        clone.carwashKeyNum = this.carwashKeyNum;
        clone.isKioskInitiated = this.isKioskInitiated;
		clone.kioskOrderNumber = this.kioskOrderNumber;
        clone.sellingUnit = (Quantity)(this.sellingUnit.clone());
        clone.isPriceCheckItem = this.isPriceCheckItem;
        clone.taxableRebateAmount = (this.taxableRebateAmount == null || this.taxableRebateAmount == ZERO_AMOUNT) ?
				this.taxableRebateAmount : (MoneyAmount)this.taxableRebateAmount.clone();
        clone.itemId = this.itemId;
        
        clone.rebateTaxpks.clear();
		if (this.rebateTaxpks != null) {				// Transient field restored?
			clone.rebateTaxpks.addAll(this.rebateTaxpks);	// else clone has empty vector
		}
        if (this.kitchenOrderNumber != null) {
            clone.kitchenOrderNumber = this.kitchenOrderNumber;
        }
    }
    
    /** Getter for property pluNum.
     * @return Value of property pluNum.
     */
    public PluPK getPluNum() {
        return this.pluNum;
    }
    
    /** Setter for property pluNum.
     * @param pluNum New value of property pluNum.
     */
    public void setPluNum(PluPK pluNum) {
        this.pluNum = pluNum;
    }
    
    /**
     * Set during a PRICE OVERRIDE sale to properly track use/abuse of the
     * function by CSR.
     *
     * @param	priceOverride a boolean
      */
    
    public void setPriceOverride(boolean priceOverride) {
        this.priceOverride = priceOverride;
    }
    
    /**
     * Allows memo item tallies, etc to track the use of the PRICE OVERRIDE
     * function
     *
      * @return	boolean
     */
    
    public boolean isPriceOverride() {
        return priceOverride;
    }
    
    /**
     * Set during a PRICE OVERRIDE sale
     *
     * @param	overriddenPrice a MoneyAmount
      */
    
    public void setOverriddenPrice(MoneyAmount overriddenPrice) {
        this.overriddenPrice = overriddenPrice;
    }
    
    /**
      * @return	MoneyAmount
     */
    public MoneyAmount getOverriddenPrice() {
        return overriddenPrice;
    }
    
    /**
	 * @return the allowPluNotFound
	 */
	public boolean isAllowPluNotFound() {
		return allowPluNotFound;
	}

	/**
	 * @param allowPluNotFound the allowPluNotFound to set
	 */
	public void setAllowPluNotFound(boolean allowPluNotFound) {
		this.allowPluNotFound = allowPluNotFound;
	}

	/**
     * Set when PLU Not Found during sale so receiving system can track
     * price book issues
     *
     * @param	pluNotFound a boolean
     */
    
    public void setPluNotFound(boolean pluNotFound) {
        this.pluNotFound = pluNotFound;
    }
    
    /**
     * The only way the receiving entity can tell we didn't find a PLU from
     * this item and the CSR intervened.
     *
     * @return	boolean
     */
    
    public boolean isPluNotFound() {
        return pluNotFound;
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
    
    /** Getter for property entryMethod.
     * @return Value of property entryMethod.
     */
    public EntryMethod getEntryMethod() {
        return (this.entryMethod == null) ? EntryMethod.MANUAL : this.entryMethod;
    }
    
    /** Setter for property entryMethod.
     * @param entryMethod New value of property entryMethod.
     */
    public void setEntryMethod(EntryMethod entryMethod) {
        this.entryMethod = entryMethod;
    }
    
    /** Getter for property carwash.
     * @return Value of property carwash.
     */
    public boolean isCarwash() {
        return (this.carwashKeyNum > 0);
    }

    
    /** Getter for property carwashCode.
     * @return Value of property carwashCode.
     */
    public String getCarwashCode() {
        return this.carwashCode;
    }
    
    /** Setter for property carwashCode.
     * @param carwashCode New value of property carwashCode.
     */
    public void setCarwashCode(String carwashCode) {
        this.carwashCode = carwashCode;
    }
    
    /**
	 * @return the carwashProcessed
	 */
	public boolean isCarwashProcessed() {
		return carwashProcessed;
	}

	/**
	 * @param carwashProcessed the carwashProcessed to set
	 */
	public void setCarwashProcessed(boolean carwashProcessed) {
		this.carwashProcessed = carwashProcessed;
	}

	/** Getter for property carwashPromo. Note that this field is used ONLY
     *  to compute carwash promo. However, it is in the entity object to support
     * suspend/ recall of carwash promos that were eligible when the transaction
     * was suspended (based on date/time). Use ItemLine#getAllDiscountInfo to
     * find the actual discounts (including carwash promo applied to this item).
     * @return Value of property carwashPromo.
     */
    public MoneyAmount getCarwashPromo() {
        return (this.carwashPromo == null) ? ZERO_AMT : this.carwashPromo;
    }
    
    /** Setter for property carwashPromo. Note that this field is used ONLY
     *  to compute carwash promo. However, it is in the entity object to support
     * suspend/ recall of carwash promos that were eligible when the transaction
     * was suspended (based on date/time). Use ItemLine#addDiscountInfo to
     * set the actual discounts (including carwash promo applied to this item).
     *
      * @param carwashPromo New value of property carwashPromo.
     */
    public void setCarwashPromo(MoneyAmount carwashPromo) {
        this.carwashPromo = carwashPromo;
    }
    
    /** Getter for property priceOverrideReason.
     * @return Value of property priceOverrideReason.
     */
    public String getPriceOverrideReason() {
        return this.priceOverrideReason;
    }
    
    /** Setter for property priceOverrideReason.
     * @param priceOverrideReason New value of property priceOverrideReason.
     */
    public void setPriceOverrideReason(String priceOverrideReason) {
        this.priceOverrideReason = priceOverrideReason;
    }
    
    /** Getter for property carwashPromoProps.
     * @return Value of property carwashPromoProps.
     *
     */
    public CarWashPromoProperties getCarwashPromoProps() {
        return this.carwashPromoProps;
    }
    
    /** Setter for property carwashPromoProps.
     * @param carwashPromoProps New value of property carwashPromoProps.
     *
     */
    public void setCarwashPromoProps(CarWashPromoProperties carwashPromoProps) {
        this.carwashPromoProps = carwashPromoProps;
    }
    
    /** Getter for property carwashDiscountType.
     * @return Value of property carwashDiscountType.
     *
     */
    public DiscountType getCarwashDiscountType() {
        return this.carwashDiscountType;
    }
    
    /** Setter for property carwashDiscountType.
     * @param carwashDiscountType New value of property carwashDiscountType.
     *
     */
    public void setCarwashDiscountType(DiscountType carwashDiscountType) {
        this.carwashDiscountType = carwashDiscountType;
    }
    
    /** Getter for property carwashKeyNum.
     * @return Value of property carwashKeyNum.
     *
     */
    public int getCarwashKeyNum() {
        return this.carwashKeyNum;
    }
    
    /** Setter for property carwashKeyNum.
     * @param carwashKeyNum New value of property carwashKeyNum.
     *
     */
    public void setCarwashKeyNum(int carwashKeyNum) {
        this.carwashKeyNum = carwashKeyNum;
    }
    
    /**
     * @return boolean
     */
    public boolean isCouponRedeemed() {
        return couponRedeemed;
    }

    /**
     * @param b
     */
    public void setCouponRedeemed(boolean b) {
        couponRedeemed = b;
    }

    /** Getter for property sellingUnit.
     * @return Value of property sellingUnit.
     *
     */
    public Quantity getSellingUnit() {
        return (this.sellingUnit == null) ? DEFAULT_SELL_UNIT : this.sellingUnit;
    }
    
    /** Setter for property sellingUnit.
     * @param sellingUnit New value of property sellingUnit.
     *
     */
    public void setSellingUnit(Quantity sellingUnit) {
        this.sellingUnit = sellingUnit;
    }
    
    /**
     * Getter for property scannedRWAmount.
     * @return Value of property scannedRWAmount.
     */
    public MoneyAmount getScannedRWAmount() {
        return this.scannedRWAmount;
    }
    
    /**
     * Setter for property scannedRWAmount.
     * @param scannedRWAmount New value of property scannedRWAmount.
     */
    public void setScannedRWAmount(MoneyAmount scannedRWAmount) {
        this.scannedRWAmount = scannedRWAmount;
    }
    
    /** Getter for property itemId.
     * @return Value of property itemId.
     *
     */
    public String getItemId() {
    	return this.itemId;
    }
    
    /** Setter for property itemId.
     * @param itemId New value of property itemId.
     *
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    /** Getter for extendedUpc.
    * @return Value of extendedUpc.
    *
    */
	public String getExtendedUpc() {
		return extendedUpc;
	}

	 /** Setter for extendedUpc.
     * @param itemId New value of extendedUpc.
     *
     */
	public void setExtendedUpc(String extendedUpc) {
		this.extendedUpc = extendedUpc;
	}

	public boolean isPriceCheckItem()
	{
		return isPriceCheckItem;
	}

	public void setPriceCheckItem(boolean isPriceCheckItem)
	{
		this.isPriceCheckItem = isPriceCheckItem;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "PluItemLine [carwashCode=" + carwashCode + ", carwashDiscountType=" + carwashDiscountType 
				+ ", carwashKeyNum=" + carwashKeyNum + ", carwashPromo=" + carwashPromo + ", carwashPromoProps=" 
				+ carwashPromoProps + ", couponRedeemed=" + couponRedeemed + ", entryMethod=" + entryMethod 
				+ ", extendedUpc=" + extendedUpc + ", isPriceCheckItem=" + isPriceCheckItem + ", itemId=" + itemId 
				+ ", pluNotFound=" + pluNotFound + ", pluNum=" + pluNum + ", priceOverride=" + priceOverride 
				+ ", overridenPrice=" + overriddenPrice + ", allowPluNotFound=" + allowPluNotFound 
				+ ", priceOverrideReason=" + priceOverrideReason + ", scannedRWAmount=" + scannedRWAmount 
				+ ", sellingUnit=" + sellingUnit + ",isKioskPlu=" + isKioskInitiated + ", kioskOrderNumber=" + kioskOrderNumber 
				+ "]";
	}
	
	public MoneyAmount getTaxableRebateAmount() {
		return taxableRebateAmount;
	}

	public void setTaxableRebateAmount(MoneyAmount taxableRebateAmount) {
		this.taxableRebateAmount = taxableRebateAmount;
	}
	
	/** Add tax  NOTE: nothing prevents duplicate PK's.  The interface
	 * is just a convenience to pass tax info across components.  The
	 * components that create the ItemLine must enforce unique TaxPK entries.
	 * @param tax TaxPK to be applied to this department
	 */
	public void addTaxableRebateTaxPK(TaxPK tax) {
		if (null == this.rebateTaxpks) {
			this.rebateTaxpks = Collections.synchronizedSet(new HashSet<TaxPK>());
		}
		this.rebateTaxpks.add(tax);
	}

	/** Remove tax
	 * @param tax tax be be removed from this department
	 */
	public void removeTaxableRebateTaxPK(TaxPK tax) {
		if (this.rebateTaxpks != null) {
			this.rebateTaxpks.remove(tax);
		}
	}

	/** Get all applicable taxes
	 * @return iterator of TaxPK objects assigned to this department
	 */
	public Iterator<TaxPK> getTaxableRebateTaxPKs() {
		if (null == this.rebateTaxpks) {
			this.rebateTaxpks = Collections.synchronizedSet(new HashSet<TaxPK>());
		}
		return this.rebateTaxpks.iterator();
	}
	
    public ItemLine createDeepCopy(){
    	ItemLine origLine = new PluItemLine();
    	((PluItemLine) this).deepCopy(origLine);
    	return origLine;
    }
    
    public boolean isKioskInitiated() {
		return isKioskInitiated;
	}

	public void setKioskInitiated(boolean isKioskInitiated) {
		this.isKioskInitiated = isKioskInitiated;
	}

	/** Getter for property mainMenuNumberPK.
     * @return Value of property mainMenuNumberPK.
     *
     */
    public MenuPK getMainMenuNumberPK() {
        return this.mainMenuNumberPK; 
    }
    
    /** Setter for property mainMenuNumberPK.
     * @param menuNumberPK New value of property mainMenuNumberPK.
     *
     */
    public void setMainMenuNumberPK(MenuPK mainMenuNumberPK) {
        this.mainMenuNumberPK = mainMenuNumberPK;
    }

	/** Getter for property menuNumberPK.
     * @return Value of property menuNumberPK.
     *
     */
    public MenuPK getMenuNumberPK() {
        return this.menuNumberPK; 
    }
    
    /** Setter for property menuNumberPK.
     * @param menuNumberPK New value of property menuNumberPK.
     *
     */
    public void setMenuNumberPK(MenuPK menuNumberPK) {
        this.menuNumberPK = menuNumberPK;
    }

	/** Getter for property menuSelectIndex.
     * @return Value of property menuSelectIndex.
     *
     */
    public int getMenuSelectIndex() {
        return this.menuSelectIndex;
    }
    
    /** Setter for property menuSelectIndex.
     * @param menuSelectIndex New value of property menuSelectIndex.
     *
     */
    public void setMenuSelectIndex(int menuSelectIndex) {
        this.menuSelectIndex = menuSelectIndex;
    }

	/** Getter for property firstSelectedMenuUnpender.
     * @return Value of property firstSelectedMenuUnpender.
     *
     */
    public int getFirstSelectedMenuUnpender() {
        return this.firstSelectedMenuUnpender;
    }
    
    /** Setter for property firstSelectedMenuUnpender.
     * @param firstSelectedMenuUnpender New value of property firstSelectedMenuUnpender.
     *
     */
    public void setFirstSelectedMenuUnpender(int firstSelectedMenuUnpender) {
        this.firstSelectedMenuUnpender = firstSelectedMenuUnpender;
    }

	/** Setter for property kioskOrderNumber.
     * @param kioskOrderNumber New value of property kioskOrderNumber.
     *
     */
	public void setKioskOrderNumber(TransNum kioskOrderNumber) {
        this.kioskOrderNumber = kioskOrderNumber;
	}

	/** Getter for kioskOrderNumber.
    * @return Value of kioskOrderNumber.
    *
    */
	public TransNum getKioskOrderNumber () {
        return this.kioskOrderNumber;
	}

    /**
     * Get the 'kitchen order' transaction number this ItemLine was sent with.
     * @return If <code>null</code>, ItemLine was sent in any &quot;kitchen order&quot;.
     *         Otherwise, the &quot;kitchen order&quot; number the ItemLine was with is returned.
     */
    public TransNum getKitchenOrderNumber()
    {
        return kitchenOrderNumber;
    }

    /**
     * Set the 'kitchen order' transaction number this ItemLine was sent with.
     * <p>
     * The <i>setting</i> of the 'kitchen order' transaction number will performed
     * by the sales feature policy handler for &quot;Kitchen/iOrder&quot; found in the
     * component at <b>isdApps/vsmsV2/salesengine/policy<b> and the class at:<br>
     * <pre><code>
     *     com.verifone.isd.vsms2.salesengine.features.policy.action.FoodServiceBO
     * </code></pre>
     * 
     * @param kitchenOrderNumber the 'kitchen order' transaction number to set.
     */
    public void setKitchenOrderNumber(TransNum kitchenOrderNumber)
    {
        this.kitchenOrderNumber = kitchenOrderNumber;
    }

}
