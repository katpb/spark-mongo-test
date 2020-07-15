package com.verifone.isd.vsms2.sales.ent.dept;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;
import com.verifone.isd.vsms2.sales.ent.agevalidn.AgeValidnPK;
import com.verifone.isd.vsms2.sales.ent.bluelaw.BlueLawPK;
import com.verifone.isd.vsms2.sales.ent.category.Category;
import com.verifone.isd.vsms2.sales.ent.category.CategoryPK;
import com.verifone.isd.vsms2.sales.ent.fee.FeePK;
import com.verifone.isd.vsms2.sales.ent.prodcode.ProdCodePK;
import com.verifone.isd.vsms2.sales.ent.tax.TaxPK;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import com.verifone.isd.vsms2.sys.util.Quantity;

/** Entity class for Department
 * @author "mailto:bhanu_n2@verifone.com"
 * @version 1.0
 */
public class Department implements IEntityObject, ISalesEntityVisitable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7883655174436494007L;
	private Logger logger
            = LoggerFactory.getLogger(Department.class);
    /** Maximum ID value allowed for department. Note: # of departments is not enforced
     */    
    public static final int MAX_DEPT_ID = 9999;
    private static final int MAX_MIN_AMT = 999999;
    private static final int MAX_MAX_AMT = MAX_MIN_AMT;
    public static final int MAX_QTY_PER_TRANS_LIMIT = 9999;
    
    private static final DepartmentPK FUEL_DEPOSIT_PK;

    public static final int FUEL_DEPOSIT_NR = 9999;    
    public static final int EPS_FUEL_DISCOUNT_NR = 9990;
    public static final int EPS_NON_FUEL_DISCOUNT_NR = 9991;
    public static final int EPS_FEE_NR = 9992;
	
    static {
        FUEL_DEPOSIT_PK = new DepartmentPK(FUEL_DEPOSIT_NR);
    }
    
    private DepartmentPK ID;
    private String name;
    private List<FeePK> fees;
    private ProdCodePK prodCode;
    private Set<TaxPK> taxes;
    private Set blueLaws; //if multiple bluelaws, check all to be valid
    private Set ageValidns; // if multiple id checks, take the largest age
    /** Holds value of property foodStampable. */
    private boolean foodStampable;
    
    /** Holds value of property refundable. */
    private boolean refundable;
    
    /** Holds value of property splDiscEligible. */
    private boolean splDiscEligible;
    
    /** Holds value of property minimumAmount. */
    private MoneyAmount minimumAmount;
    
    /** Holds value of property maximumAmount. */
    private MoneyAmount maximumAmount;
    
    /** Holds value of property category. */
    private CategoryPK category;
    
    /** Holds value of property negative. */
    private boolean negative;
    
    /** Holds value of property fuel. */
    private boolean fuel;
    
	/**
	 * Holds value of property hidden. CDepartmentTbl would hidden records
	 * inserted via startup script .This attribute basically prevent updates/
	 * deletion of hidden departments that are critical for system's functioning.
	 * Fuel deposit dept is of that kind
	 */
    private boolean hidden;
    
    /** Holds value of property fractionalQtyAllowed. */
    private boolean fractionalQtyAllowed;

    /** Holds value of property prohibitDiscount */
    private boolean prohibitDiscount;
    
    /** Holds value of property moneyOrder. */
    private boolean moneyOrder;
    
    private boolean serialNumPromptReqd;
    
	/**
	 * Holds value of property maxQtyPerTrans. The NAXML Maintenance Request schema calls this piece
	 * of data SalesRestriction#TransactionLimit.
	 */
	private Quantity maxQtyPerTrans;

	public boolean isSerialNumPromptReqd() {
		return serialNumPromptReqd;
	}

	public void setSerialNumPromptReqd(boolean serialNumPromptReqd) {
		this.serialNumPromptReqd = serialNumPromptReqd;
	}

	/** Holds fuel tax adjustment index number */
	private short fuelTaxAdj;
    
    /** No-args constructor
     */    
    public Department() {
        this(null); // PK Not yet established!
    }
    
    /** Constructor
     * @param pk DepartmentPK for the object
     */    
    public Department(DepartmentPK pk) {
        this.ID = pk;
        this.fees = Collections.synchronizedList(new ArrayList<FeePK>());
        this.taxes = Collections.synchronizedSet(new HashSet<TaxPK>());
        this.blueLaws = Collections.synchronizedSet(new HashSet());
        this.ageValidns = Collections.synchronizedSet(new HashSet());
    }
    
    /** Static method to return the Fuel deposit department
     * (this department is read-only)
     * @return fuel deposit department
     */    
    public static final DepartmentPK getFuelDeposit() {
        return FUEL_DEPOSIT_PK;
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
    
    /** Setter for fuel tax adjustment number
     * @param fuelTaxAdj fuel tax adjustment number
     */    
    public void setFuelTaxAdj(short fuelTaxAdj) {
        this.fuelTaxAdj = fuelTaxAdj;
    }
    
    /** Getter for fuel tax adjustment number
     * @return fuelTaxAdj fuel tax adjustment number
     */    
    public short getFuelTaxAdj() {
        return this.fuelTaxAdj;
    }
    
    /** Setter for product code
     * @param prodCode Product code primary key or null if no product code is to be applied.
     * Note that if no product code is assigned, the department may not be
     * sellable
     */    
    public void setProductCode(ProdCodePK prodCode) {
        this.prodCode = prodCode;
    }
    
    /** Getter for product code
     * @return Product code primary key or null if no product code is assigned.
     * Note that if no product code is assigned, the department may not be
     * sellable
     */    
    public ProdCodePK getProductCode() {
        return this.prodCode;
    }
    
    /** Getter of the entity object's primary key
     * @return the ID of the entity object
     */
    @Override
	public IEntityPK getPK() {
        return this.ID;
    }
    
    /** Method to clone this entity's attribute to another
     * @param obj object to copy to
     */    
    @Override
	public void setAttributes(IEntityObject obj) {
        Department dObj = (Department) obj;
        dObj.ID = this.ID;
        dObj.name = this.name;
        dObj.category = this.category;
        dObj.fees = this.fees;
        dObj.prodCode = this.prodCode;
        dObj.blueLaws = this.blueLaws;
        dObj.ageValidns = this.ageValidns;
        dObj.taxes = this.taxes;     
        dObj.fuel = this.fuel;
        dObj.hidden = this.hidden;
        dObj.negative = this.negative;
        dObj.refundable = this.refundable;        
        dObj.foodStampable = this.foodStampable;
        dObj.fractionalQtyAllowed = this.fractionalQtyAllowed;
        dObj.prohibitDiscount = this.prohibitDiscount;
        dObj.moneyOrder = this.moneyOrder;
        dObj.splDiscEligible = this.splDiscEligible;
        dObj.maximumAmount = this.maximumAmount;
        dObj.minimumAmount = this.minimumAmount;
        dObj.fuelTaxAdj = this.fuelTaxAdj;
        dObj.serialNumPromptReqd = this.serialNumPromptReqd;
        dObj.maxQtyPerTrans = this.maxQtyPerTrans;
    }
    
    /** Method to validate the primary key of the entity object
     * @return true if the primary key of the entity object is valid
     */
    @Override
	public boolean isPKValid() {
        return (this.ID == null) ? false : this.ID.isValid();
    }
    
    /** Set the primary key of the entity object
     * @param pk primary key for the entity object
     */
    @Override
	public void setPK(IEntityPK pk) {
        this.ID = (DepartmentPK)pk;        
    }
    
    private void fixFuelDepositAttribs() {
        this.foodStampable = this.prohibitDiscount = this.fractionalQtyAllowed = this.moneyOrder = this.negative = this.refundable = this.splDiscEligible = this.serialNumPromptReqd = false;
        this.fuel = this.hidden = true;
        this.fuelTaxAdj = 0;
        this.fees.clear();
        this.prodCode = null;
        this.category = Category.getFuelDeposit();
        this.maximumAmount = this.minimumAmount = null;
        this.ageValidns.clear();
        this.blueLaws.clear();
        this.taxes.clear();
        this.maxQtyPerTrans = null;
    }
    
    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    @Override
	public void validate() throws Exception {
        if (!isPKValid()) {
            throw new Exception("Invalid Department: " +this.ID);            
        }
        if (this.ID.equals(FUEL_DEPOSIT_PK)) {
            this.fixFuelDepositAttribs();
        }
        if ((this.category != null) && (this.category.getValue() != 0) &&
            (!this.category.isValid())) {
            // Check against category obj's ID range
            throw new Exception("Invalid category: " +category.toString()
            +" for Department: " +this.ID);
        }        
        if ((this.prodCode != null) && (!this.prodCode.isValid())) {
            // Check against product code obj's ID range
            throw new Exception("Invalid product code: " +prodCode.toString()
            +" for Department: " +this.ID);
        }     
        this.validateFees();     
        this.validateAmounts();
        this.validateTaxes();
        this.validateAgeValidns();
        this.validateBlueLaws();
        this.validateMaxQtyPerTrans();
    }

    /**
    * First fee in the fees list is allowed to be null to accommodate for fee sysid 0. So do not check
    * for FeePK validity if first fee is null else check.
    * 
    * @throws Exception
    */
    private void validateFees() throws Exception {
    	Iterator<FeePK> elems = this.fees.iterator();
    	int k=0;
    	while (elems.hasNext()) {
    		FeePK fee = elems.next();
    		if(k==0 && fee==null){
    			continue;
    		}
    		if ((fee != null) && (!fee.isValid())) {
    			throw new Exception("Invalid fee : " +fee
    					+" for PLU: " +this.ID);
    		}
    		k++;
    	}
    }

    private void validateAmounts() throws Exception {
        long minVal = 0;
        if (this.minimumAmount != null) {
            minVal = this.minimumAmount.getLongValue();
            if ((minVal < 0) || (minVal > MAX_MIN_AMT))
                throw new Exception("Invalid minimum amount: "
                +minimumAmount.toString() +" for department: " +this.ID);
        }
        if (this.maximumAmount != null) {
            long maxVal = this.maximumAmount.getLongValue();
            if ((maxVal < 0) || (maxVal > MAX_MAX_AMT))
                throw new Exception("Invalid maximum amount: "
                +maximumAmount.toString() +" for department: " +this.ID);
            if ((maxVal != 0) && (minVal != 0) && (minVal > maxVal))
                throw new Exception("Mismatch between minimum and maximum value for department: "
                +this.ID);
        }
    }
    
    private void validateTaxes() throws Exception {
        Iterator<TaxPK> elems = this.taxes.iterator();
        while (elems.hasNext()) {
            TaxPK tr = elems.next();
            if ((tr != null) && (!tr.isValid())) {
                throw new Exception("Invalid tax rate: " +tr
                +" for department: " +this.ID);
            }
        }
    }
    
    private void validateAgeValidns() throws Exception {
        Iterator elems = this.ageValidns.iterator();
        while (elems.hasNext()) {
            AgeValidnPK av = (AgeValidnPK)elems.next();
            if ((av != null) && (!av.isValid())) {
                throw new Exception("Invalid age validation: " +av
                +" for department: " +this.ID);
            }
        }
    }
    
    private void validateBlueLaws() throws Exception {
        Iterator elems = this.blueLaws.iterator();
        while (elems.hasNext()) {
            BlueLawPK bl = (BlueLawPK)elems.next();
            if ((bl != null) && (!bl.isValid())) {
                throw new Exception("Invalid blue law: " +bl
                +" for department: " +this.ID);
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
    
    /** Getter for property splDiscEligible.
     * @return Value of property splDiscEligible.
     */
    public boolean isSpecialDiscAllowed() {
        return this.splDiscEligible;
    }
    
    /** Setter for property splDiscEligible.
     * @param splDiscEligible New value of property splDiscEligible.
     */
    public void setSpecialDiscAllowed(boolean splDiscEligible) {
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
    
    /** Set taxes from the iterator
     * @param items iterator of TaxPK objects to assign to this department
     */    
    public void setTaxes(Iterator items) {
        this.taxes.clear();
        while(items.hasNext()) {
            TaxPK item = (TaxPK)items.next();
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
    public Iterator getAgeValidations() {
        return this.ageValidns.iterator();
    }
    
    /** Set age validations from the iterator
     * @param ageVs iterator of AgeValidnPK objects assigned to this department
     */    
    public void setAgeValidations(Iterator ageVs) {
        this.ageValidns.clear();
        while(ageVs.hasNext()) {
            AgeValidnPK item = (AgeValidnPK)ageVs.next();
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
    public Iterator getBlueLaws() {
        return this.blueLaws.iterator();
    }
    
    /** Set blue laws from the iterator
     * @param newBLs iterator of BlueLawPK objects to assign to this department
     */    
    public void setBlueLaws(Iterator newBLs) {
        this.blueLaws.clear();
        while(newBLs.hasNext()) {
            BlueLawPK item = (BlueLawPK)newBLs.next();
            this.blueLaws.add(item);
        }
    }    

    /** Getter for property minimumAmount.
     * @return Value of property minimumAmount.
     */
    public MoneyAmount getMinimumAmount() {
        return this.minimumAmount;
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
        return this.maximumAmount;
    }
    
    /** Setter for property maximumAmount.
     * @param maximumAmount New value of property maximumAmount.
     */
    public void setMaximumAmount(MoneyAmount maximumAmount) {
        this.maximumAmount = maximumAmount;
    }
    
    /** Getter for property category.
     * @return Value of property category.
     */
    public CategoryPK getCategory() {
        return this.category;
    }
    
    /** Setter for property category.
     * @param category New value of property category.
     */
    public void setCategory(CategoryPK category) {
        this.category = category;
    }
    
    /** Getter for property negative.
     * @return Value of property negative.
     */
    public boolean isNegative() {
        return this.negative;
    }
    
    /** Setter for property negative.
     * @param negative New value of property negative.
     */
    public void setNegative(boolean negative) {
        this.negative = negative;
    }
    
    /** Getter for property fuel.
     * @return Value of property fuel.
     */
    public boolean isFuel() {
        return this.fuel;
    }
    
    /** Setter for property fuel.
     * @param fuel New value of property fuel.
     */
    public void setFuel(boolean fuel) {
        this.fuel = fuel;
    }
    
    /** Getter for property hidden.
     * @return Value of property hidden.
     */
    public boolean isHidden() {
        return this.hidden;
    }
    
    /** Setter for property hidden.
     * @param hidden New value of property hidden.
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
    
    /** Getter for property fractionalQtyAllowed.
     * @return Value of property fractionalQtyAllowed.
     */
    public boolean isFractionalQtyAllowed() {
        return this.fractionalQtyAllowed;
    }
    
    /** Setter for property fractionalQtyAllowed.
     * @param fractionalQtyAllowed New value of property fractionalQtyAllowed.
     */
    public void setFractionalQtyAllowed(boolean fractionalQtyAllowed) {
        this.fractionalQtyAllowed = fractionalQtyAllowed;
    }

    /** Getter for property prohibitDiscount.
     * @return Value of property prohibitDiscount.
     */
    public boolean isProhibitDiscount() {
        return this.prohibitDiscount;
    }
    
    /** Setter for property prohibitDiscount.
     * @param prohibitDiscount New value of property prohibitDiscount.
     */
    public void setProhibitDiscount(boolean prohibitDiscount) {
        this.prohibitDiscount = prohibitDiscount;
    }
    
    /** Getter for property moneyOrder.
     * @return Value of property moneyOrder.
     */
    public boolean isMoneyOrder() {
        return this.moneyOrder;
    }
    
    /** Setter for property moneyOrder.
     * @param moneyOrder New value of property moneyOrder.
     */
    public void setMoneyOrder(boolean moneyOrder) {
        this.moneyOrder = moneyOrder;
    }
    
    /** Get all applicable fees. It retrieves only the non-null fee elements.
     * @return iterator of FeePK objects assigned to this department
     */  
	public Iterator<FeePK> getFees() {
		ArrayList<FeePK> validFees = new ArrayList<FeePK>();
		Iterator<FeePK> feesIterator = this.fees.iterator();
		while(feesIterator.hasNext()){
			FeePK fee = feesIterator.next();
			if(fee!=null){
				validFees.add(fee);
			}
		}
		/** sort the fee list based on fee number */
		Collections.sort(validFees, new Comparator<FeePK>() {
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
		return validFees.iterator();
	}
    /** Set fees from the iterator
     * @param items iterator of FeePK objects to assign to this department
     */   
	public void setFees(Iterator<FeePK> items) {
        this.fees.clear();
        while(items.hasNext()) {
            this.fees.add(items.next());
        }
	}
    /** Add fee
     * @param fee FeePK to be applied to this department
     */   
	public void addFee(FeePK fee){
		this.fees.add(fee);
	}
    /** Remove fee
     * @param fee FeePK be be removed from this department
     */   
	public void removeFee(FeePK fee){
		this.fees.remove(fee);
	}
    
    
    /** Implementation method for visitable in visitor pattern
     * @param v visitor
     * @throws Exception on exception in visitor's visit method
     */    
    @Override
	public void accept(SalesEntityVisitor v) throws Exception {
        v.visit(this);
    }
    
    /**
     * It retrieves all the fees present in Department. This function is used for configuration purpose.
     * @return
     */
    public Iterator<FeePK> getFeesIterator(){
    	return this.fees.iterator();
    }
    
    public void setFee(int position, FeePK feePK){
    	if(this.fees.size() > position){
    		this.fees.remove(position);
    	}
    	this.fees.add(position, feePK);
    }

    /**
     * Getter for Max QTY Per Transaction
     * @return maxQtyPerTrans
     */
	public Quantity getMaxQtyPerTrans() {
		if (this.maxQtyPerTrans == null) {
			this.maxQtyPerTrans = new Quantity(0, 2, "");
		}		
		return maxQtyPerTrans;
	}

	/**
	 * Setter for Max QTY Per Transaction
	 * @param maxQtyPerTrans
	 */
	public void setMaxQtyPerTrans(Quantity maxQtyPerTrans) {
		this.maxQtyPerTrans = maxQtyPerTrans;
	}
	
	/**
	 * Validates the Max QTY Per Transaction against Zero Quantity
	 * @throws Exception
	 */
	private void validateMaxQtyPerTrans() throws Exception {
		if (this.maxQtyPerTrans != null && (this.maxQtyPerTrans.compareWithZero() < 0 || this.maxQtyPerTrans.getLongValue() > Integer.MAX_VALUE)) {
				throw new Exception("Invalid maximum quantity: " + maxQtyPerTrans.toString() + " for department: " + this.ID);
		}
	}

}
