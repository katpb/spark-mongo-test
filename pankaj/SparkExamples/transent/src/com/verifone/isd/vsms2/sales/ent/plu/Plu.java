package com.verifone.isd.vsms2.sales.ent.plu;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import com.verifone.isd.vsms2.sys.util.Quantity;
import com.verifone.isd.vsms2.sales.ent.agevalidn.AgeValidnPK;
import com.verifone.isd.vsms2.sales.ent.bluelaw.BlueLawPK;
import com.verifone.isd.vsms2.sales.ent.fee.FeePK;
import com.verifone.isd.vsms2.sales.ent.tax.TaxPK;
import com.verifone.isd.vsms2.sales.ent.taxablerebate.TaxableRebate;
import com.verifone.isd.vsms2.sales.ent.dept.DepartmentPK;
import com.verifone.isd.vsms2.sales.ent.prodcode.ProdCodePK;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
/** Entity class for PLU
 * @author "mailto:bhanu_n2@verifone.com"
 * @version 1.0
 */
public class Plu extends TaxableRebate implements IEntityObject {
   
	private static final long serialVersionUID = 6056196842315267847L;

	private PluPK ID;
    private String name;
    private MoneyAmount price;
    private DepartmentPK dept;
    private List<FeePK> fees;
    private ProdCodePK prodCode;
    private Set<TaxPK> taxes;
    private Set<BlueLawPK> blueLaws; //if multiple bluelaws, check all to be valid
    private Set<AgeValidnPK> ageValidns; // if multiple id checks, take the largest age
    /** Holds value of property foodStampable. */
    private boolean foodStampable;
    
    /** Holds value of property openPriced. */
    private boolean openPriced;
    
    /** Holds value of property refundable. */
    private boolean refundable;
    
    /** Holds value of property promoEligible. */
    private boolean promoEligible;
    
    /** Holds value of property sellable. */
    private boolean sellable;
    
    /** Holds value of property splDiscEligible. */
    private boolean splDiscEligible;
    
    /** Holds value of property sellingUnit. */
    private Quantity sellingUnit;
    
    /** Holds value of property fractionalQtyAllowed. */
    private boolean fractionalQtyAllowed;

    /** Holds value of property serialNumPromptReqd. */
    private boolean serialNumPromptReqd;
    /** Holds value of property prohibitDiscount. */
    private boolean prohibitDiscount;
    
    
   
	/** Holds value of property itemId (a.k.a. Inventory ID). */
    /* The NAXML Maintenance Request schema calls this piece of data
     * ItemID.  For naming consistency, we have chosen the same name 
     * for the following variable which represents the "ItemID".
     */ 
    private String itemId;
    
    private String groupId;
    private String groupIndex;
    
	/**
	 * Holds value of property maxQtyPerTrans. The NAXML Maintenance Request schema calls this piece
	 * of data SalesRestriction#TransactionLimit.
	 */
    private Quantity maxQtyPerTrans;

    /** No-args constructor
     */    
    public Plu() {
    	super();
    	this.fees = Collections.synchronizedList(new ArrayList<FeePK>());
        this.taxes = Collections.synchronizedSet(new HashSet<TaxPK>());
        this.blueLaws = Collections.synchronizedSet(new HashSet<BlueLawPK>());
        this.ageValidns = Collections.synchronizedSet(new HashSet<AgeValidnPK>());
    }
    
    /** Setter for property name
     * @param name name of the entity
     */    
    public void setName(String name) {
        this.name = name;
    }
    
    /** Getter for property name
     * @return name of the entity
     */    
    public String getName() {
        return this.name;
    }
    
    /** Setter for price
     * @param price plu price
     */    
    public void setPrice(MoneyAmount price) {
        this.price = price;
    }
    
    /** Getter for price
     * @return plu price
     */    
    public MoneyAmount getPrice() {
        return this.price;
    }
    
    /** Setter for product code
     * @param prodCode Product code primary key or null if no product code is to be applied.
     * Note that if no product code is assigned, the item may be invalid in sales
     */    
    public void setProductCode(ProdCodePK prodCode) {
        this.prodCode = prodCode;
    }
    
    /** Getter for product code
     * @return Product code primary key or null if no product code is assigned.
     * Note that if no product code is assigned, the item may be invalid in sales
     */    
    public ProdCodePK getProductCode() {
        return this.prodCode;
    }
    
    /** Getter of the entity object's primary key
     * @return the ID of the entity object
     */
    public IEntityPK getPK() {
        return this.ID;
    }
    
    /** Helper method to clone the entity's attributes to another entity
     * @param obj object to copy to
     */    
    public void setAttributes(IEntityObject obj) {
    	super.setAttribute((TaxableRebate)obj);
        Plu pObj = (Plu) obj;
        pObj.ID = this.ID;
        pObj.name = this.name;
        pObj.dept = this.dept;
        pObj.fees = this.fees;
        pObj.prodCode = this.prodCode;
        pObj.price = this.price;
        pObj.blueLaws = this.blueLaws;
        pObj.ageValidns = this.ageValidns;
        pObj.taxes = this.taxes;        
        pObj.foodStampable = this.foodStampable;
        pObj.openPriced = this.openPriced;
        pObj.promoEligible = this.promoEligible;
        pObj.refundable = this.refundable;
        pObj.sellable = this.sellable;
        pObj.splDiscEligible = this.splDiscEligible;
        pObj.sellingUnit = this.sellingUnit;
        pObj.fractionalQtyAllowed = this.fractionalQtyAllowed;
        pObj.prohibitDiscount = this.prohibitDiscount;
        pObj.itemId = this.itemId;
        pObj.serialNumPromptReqd = this.serialNumPromptReqd;
        pObj.groupId = this.groupId;
        pObj.groupIndex = this.groupIndex;
        pObj.maxQtyPerTrans = this.maxQtyPerTrans;
    }
    
    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Plu [ID=" + ID + ", ageValidns=" + ageValidns + ", blueLaws=" + blueLaws + ", dept=" + dept + ", fee=" + fees + ", foodStampable=" + foodStampable + ", fractionalQtyAllowed=" + fractionalQtyAllowed + ", prohibitDiscount=" + prohibitDiscount + ", itemId=" + itemId + ", name=" + name + ", openPriced=" + openPriced + ", price=" + price + ", prodCode=" + prodCode + ", promoEligible=" + promoEligible + ", refundable=" + refundable + ", sellable=" + sellable + ", sellingUnit=" + sellingUnit + ", splDiscEligible=" + splDiscEligible + ", taxes=" + taxes + "]" + ", txblAmt=" + this.getTaxableRebateAmount() + "]" + ", txblRbtTaxes=" + this.getTaxableRebateTaxes() + ", maxQtyPerTrans="+ this.maxQtyPerTrans +"]";
	}
	/** Method to validate the primary key of the entity object
     * @return true if the primary key of the entity object is valid
     */
    public boolean isPKValid() {
        return (this.ID == null) ? false : this.ID.isValid();  
    }
    
    /** Set the primary key of the entity object
     * @param pk primary key for the entity object
     */
	public void setPK(IEntityPK pk) {
		this.ID = (PluPK) pk;
	}
    
    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {
        if (!isPKValid()) {
            throw new Exception("Invalid PLU: " +this.ID);            
        }
        if ((this.name == null) || (this.name.trim().equals("")) || 
        (this.name.trim().equals("*"))) {
            throw new Exception("Invalid name for PLU: " +ID);
        }   
        if ((this.dept != null) && (!this.dept.isValid())) {
            // Check against Department obj's ID range
            throw new Exception("Invalid department: " +dept.toString()
            +" for PLU: " +this.ID);
        }        
        if ((this.prodCode != null) && (!this.prodCode.isValid())) {
            // Check against product code obj's ID range
            throw new Exception("Invalid product code: " +prodCode.toString()
            +" for PLU: " +this.ID);
        }     
        if((this.itemId != null) && (this.itemId.length() > 10)) {
        	// Validate the length of itemId
        	throw new Exception("Invalid itemId: " + itemId
                    +" for PLU: " +this.ID);
        }
        this.validateFees();
        this.validateTaxes();
        this.validateAgeValidns();
        this.validateBlueLaws();
        this.validateMaxQtyPerTrans();
        super.validateTaxableRebatesTaxes();
    }
    
    private void validateFees() throws Exception {
        Iterator<FeePK> elems = this.fees.iterator();
        while (elems.hasNext()) {
            FeePK tr = elems.next();
            if ((tr != null) && (!tr.isValid())) {
                throw new Exception("Invalid fee : " +tr
                +" for PLU: " +this.ID);
            }
        }
    }

    private void validateTaxes() throws Exception {
        Iterator<TaxPK> elems = this.taxes.iterator();
        while (elems.hasNext()) {
            TaxPK tr = elems.next();
            if ((tr != null) && (!tr.isValid())) {
                throw new Exception("Invalid tax rate: " +tr
                +" for PLU: " +this.ID);
            }
        }
    }
    
    
    
    private void validateAgeValidns() throws Exception {
        Iterator<AgeValidnPK> elems = this.ageValidns.iterator();
        while (elems.hasNext()) {
            AgeValidnPK av = elems.next();
            if ((av != null) && (!av.isValid())) {
                throw new Exception("Invalid age validation: " +av
                +" for PLU: " +this.ID);
            }
        }
    }
    
    private void validateBlueLaws() throws Exception {
        Iterator<BlueLawPK> elems = this.blueLaws.iterator();
        while (elems.hasNext()) {
            BlueLawPK bl = elems.next();
            if ((bl != null) && (!bl.isValid())) {
                throw new Exception("Invalid blue law: " +bl
                +" for PLU: " +this.ID);
            }
        }
    }    
    
    /** Getter for property foodStampable.
     * @return Value of property foodStampable.
     */
    public boolean isFoodStampable() {
        return this.foodStampable;
    }
    
    /** Setter for property foodStampable.
     * @param foodStampable New value of property foodStampable.
     */
    public void setFoodStampable(boolean foodStampable) {
        this.foodStampable = foodStampable;
    }
    
    /** Getter for property openPriced.
     * @return Value of property openPriced.
     */
    public boolean isOpenPriced() {
        return this.openPriced;
    }
    
    /** Setter for property openPriced.
     * @param openPriced New value of property openPriced.
     */
    public void setOpenPriced(boolean openPriced) {
        this.openPriced = openPriced;
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
    
    /** Getter for property promoEligible.
     * @return Value of property promoEligible.
     */
    public boolean isPromoEligible() {
        return this.promoEligible;
    }
    
    /** Setter for property promoEligible.
     * @param promoEligible New value of property promoEligible.
     */
    public void setPromoEligible(boolean promoEligible) {
        this.promoEligible = promoEligible;
    }
    
    /** Getter for property sellable.
     * @return Value of property sellable.
     */
    public boolean isSellable() {
        return this.sellable;
    }
    
    /** Setter for property sellable.
     * @param sellable New value of property sellable.
     */
    public void setSellable(boolean sellable) {
        this.sellable = sellable;
    }
    
    /** Getter for property splDiscEligible.
     * @return Value of property splDiscEligible.
     */
    public boolean isSpecialDiscount() {
        return this.splDiscEligible;
    }
    
    /** Setter for property splDiscEligible.
     * @param splDiscEligible New value of property splDiscEligible.
     */
    public void setSpecialDiscount(boolean splDiscEligible) {
        this.splDiscEligible = splDiscEligible;
    }
    
    /** Add tax
     * @param tax TaxPK to be applied to this department
     */    
    public void addTax(TaxPK tax) {
        this.taxes.add(tax);
    }
    
    /** Remove tax
     * @param tax tax be be removed from this department
     */    
    public void removeTax(TaxPK tax) {
        this.taxes.remove(tax);
    }
    
    /** Get all applicable taxes
     * @return iterator of TaxPK objects assigned to this department
     */    
    public Iterator<TaxPK> getTaxes() {
        return this.taxes.iterator();
    }
    
	/**
	 * Set taxes from the iterator
	 * 
	 * @param items
	 *            iterator of TaxPK objects to assign to this department
	 */
    public void setTaxes(Iterator<TaxPK> items) {
        this.taxes.clear();
        while(items.hasNext()) {
            TaxPK item = items.next();
            this.taxes.add(item);
        }
    }
    
    /** Add age validation
     * @param newAV age validation to be added
     */    
    public void addAgeValidation(AgeValidnPK newAV) {
        this.ageValidns.add(newAV);
    }
    
    /** Remove age validation
     * @param remAV age validation to be removed
     */    
    public void removeAgeValidation(AgeValidnPK remAV) {
        this.ageValidns.remove(remAV);
    }
    
    /** Getter for all age validations assigned for the department
     * @return iterator of AgeValidnPK objects assigned to this department
     */    
    public Iterator<AgeValidnPK> getAgeValidations() {
        return this.ageValidns.iterator();
    }
    
    /** Set age validations from the iterator
     * @param ageVs iterator of AgeValidnPK objects assigned to this department
     */    
    public void setAgeValidations(Iterator<AgeValidnPK> ageVs) {
        this.ageValidns.clear();
        while(ageVs.hasNext()) {
            AgeValidnPK item = ageVs.next();
            this.ageValidns.add(item);
        }
    }
    
    /** Add blue law
     * @param newBL blue law to be added
     */    
    public void addBlueLaw(BlueLawPK newBL) {
        this.blueLaws.add(newBL);
    }
    
    /** Remove blue law
     * @param remBL blue law to be removed
     */    
    public void removeBlueLaw(BlueLawPK remBL) {
        this.blueLaws.remove(remBL);
    }
    
    /** Getter for all blue laws assigned to the department
     * @return iterator of BlueLawPK objects assigned to this department
     */    
    public Iterator<BlueLawPK> getBlueLaws() {
        return this.blueLaws.iterator();
    }
    
    /** Set blue laws from the iterator
     * @param newBLs iterator of BlueLawPK objects to assign to this department
     */    
    public void setBlueLaws(Iterator<BlueLawPK> newBLs) {
        this.blueLaws.clear();
        while(newBLs.hasNext()) {
            BlueLawPK item = newBLs.next();
            this.blueLaws.add(item);
        }
    }    
    
    /** Getter for property dept.
     * @return Value of property dept.
     */
    public DepartmentPK getDepartment() {
        return this.dept;
    }
    
    /** Setter for property dept.
     * @param dep plu's department (if set to null, the item cannot be sold)
     */
    public void setDepartment(DepartmentPK dep) {
        this.dept = dep;
    }    
    
    /** Getter for property sellingUnit.
     * @return Value of property sellingUnit.
     */
    public Quantity getSellingUnit() {
        if (this.sellingUnit == null) {
            this.sellingUnit = new Quantity(1000, 3, "") ;
        }
        return this.sellingUnit;
    }
    
    /** Setter for property sellingUnit.
     * @param sellingUnit New value of property sellingUnit.
     */
    public void setSellingUnit(Quantity sellingUnit) {
        this.sellingUnit = sellingUnit;
    }
    
    /** Getter for property fractionalQtyAllowed.
     * @return Returns the fractionalQtyAllowed 
     */
    public boolean isFractionalQtyAllowed() {
        return fractionalQtyAllowed;
    }
    
    /** Setter for property fractionalQtyAllowed. 
     * @param fractionalQtyAllowed The fractionalQtyAllowed to set 
     */
    public void setFractionalQtyAllowed(boolean fractionalQuantity) {
        this.fractionalQtyAllowed = fractionalQuantity;
    }

    /** Getter for property prohibitDiscount.
     * @return Returns the prohibitDiscount 
     */
    public boolean isProhibitDiscount() {
        return prohibitDiscount;
    }

    /** Setter for property prohitDiscount. 
     * @param prohibitDiscount The prohibitDiscount to set 
     */
    public void setProhibitDiscount(boolean prohibitDiscount) {
        this.prohibitDiscount = prohibitDiscount;
    }
    
    /** Getter for property itemId.
     * @return Value of property itemId.
     */
    public String getItemId() {
        return this.itemId;
    }
    
    /** Setter for property itemId.
     * @param itemId New value of property itemId.
     */
    public void setItemId(String itemId) {
    	this.itemId = itemId;
    }
    /** Get all applicable fees
     * @return iterator of FeePK objects assigned to this Plu
     */  
    public Iterator<FeePK> getFees() {
    	/** sort the fee based on fee number */ 
    	Collections.sort(this.fees, new Comparator<FeePK>() {
			public int compare(FeePK fistFee, FeePK secondFee) {
				if(fistFee.getValue() > secondFee.getValue()){
					return 1;
				}else if(fistFee.getValue() < secondFee.getValue()){
					return -1;
				}else{
					return 0;
				}
			}
		});
    	
    	return this.fees.iterator();
    }
    /** Set fees from the iterator
     * @param items iterator of FeePK objects to assign to this Plu
     */   
    public void setFees(Iterator<FeePK> items) {
    	this.fees.clear();
    	while(items.hasNext()) {
    		this.fees.add(items.next());
    	}
    }
    /** Add fee
     * @param fee FeePK to be applied to this Plu
     */   
    public void addFee(FeePK fee){
    	this.fees.add(fee);
    }
    /** Remove fee
     * @param fee FeePK be be removed from this Plu
     */   
    public void removeFee(FeePK fee){
    	this.fees.remove(fee);
    }
    
    public boolean isSerialNumPromptReqd() {
		return serialNumPromptReqd;
	}

	public void setSerialNumPromptReqd(boolean serialNumPromptReqd) {
		this.serialNumPromptReqd = serialNumPromptReqd;
	}
	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupIndex() {
		return groupIndex;
	}

	public void setGroupIndex(String groupIndex) {
		this.groupIndex = groupIndex;
	}

	/**
	 * Getter for Max QTY per Transaction
	 * 
	 * @return the maxQtyPerTrans
	 */
	public Quantity getMaxQtyPerTrans() {
		if (this.maxQtyPerTrans == null) {
			this.maxQtyPerTrans = new Quantity(0, 2, "");
		}
		return maxQtyPerTrans;
	}

	/**
	 * Setter for Max QTY per Transaction
	 * @param maxQtyPerTrans the maxQtyPerTrans to set
	 */
	public void setMaxQtyPerTrans(Quantity maxQtyPerTrans) {
		this.maxQtyPerTrans = maxQtyPerTrans;
	}
	
	/**
	 * Validates the Max QTY Per Transaction against Zero Quantity
	 * 
	 * @throws Exception
	 */
	private void validateMaxQtyPerTrans() throws Exception {
		if (this.maxQtyPerTrans != null && (this.maxQtyPerTrans.compareWithZero() < 0 || this.maxQtyPerTrans.getLongValue() > Integer.MAX_VALUE)) {
			throw new Exception("Invalid maximum quantity: " + maxQtyPerTrans.toString() + " for PLU: " + this.ID);
		}
	}	
}



