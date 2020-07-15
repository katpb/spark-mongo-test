package com.verifone.isd.vsms2.sales.ent.fee;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sales.ent.dept.DepartmentPK;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import com.verifone.isd.vsms2.sys.util.Quantity;
import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;

/** Entity class for fee
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class Fee implements IEntityObject, ISalesEntityVisitable {
    static final long serialVersionUID = -1751868813671320204L;
    /** Maximum fees
     */    
    public static final int MAX_FEES = 300;
    /** Maximum ranges in a fee
     */    
    public static final int MAX_FEE_RANGES = 4;
    private static final int MAX_RANGE_AMT = 999999;
    private static final int MAX_FEE_AMT = 9999;
    /** Number of decimals in a fee amount/ fee range end amount
     */    
    public static final int NUM_DECIMALS = 2;
    
    public static final int MAX_FEE_PERCENT_DECIMALS = 3;
    
    protected static final Quantity ZERO_PCT = new Quantity(0, 3, "%");    
    
    private FeePK ID;
    private String name;
    
    /** Holds value of property refundable. */
    private boolean refundable;
    
    /** Holds value of property depnr. */
    private DepartmentPK dep;
    private FeeRange[] rangeDetails;
    
    /** Holds value of property outOfRangeFee. */
    private MoneyAmount outOfRangeFee;
    private String feeIdentifier;
    
    public static enum FEEType {
    	RANGEAMOUNT(0),PERCENTAGE(1);
    	private int value;  
    	private FEEType(int value){  
    		this.value=value;  
    	}  
    	/**
    	 * Returns value of FeeType enum.
    	 * @return
    	 */
    	public int getValue(){
    		return this.value;
    	}
    	/**
    	 * Returns the FEEType enum corresponding to the
    	 *  value passed.
    	 * @param feeType
    	 * @return
    	 */
    	public static FEEType fromValue(int feeType){
    	    for (FEEType ft : FEEType.values())
    	    {
    	      if (ft.getValue() == feeType) {
    	        return ft;
    	      }
    	    }
    	    return null;
    	  }

    }
    
    private FEEType feeType;
    
   
    /** Holds value of property fee percentage.  */
    private Quantity percentageFee = ZERO_PCT;

	
	/** No-args constructor
     */    
    public Fee() {
    }
    
    /** Constructor
     * @param pk Primary key for the entity
     */    
    public Fee (FeePK pk) {
        this.ID = pk;
    }
    
    /** Setter for property name
     * @param name name of the entity
     */    
    public void setName(String name) {
        this.name = name;
    }
    
    /** Getter for property name
     * @return name of the entity */    
    public String getName() {
        return this.name;
    }
    /** Getter of the entity object's primary key
     * @return the ID of the entity object
     */
    public IEntityPK getPK() {
        return this.ID;
    }
    
    /** Set the primary key of the entity object
     * @param pk primary key for the entity object
     */
    public void setPK(IEntityPK pk) {
        this.ID = (FeePK)pk;
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
    
    /** Getter for property depNr.
     * @return DepartmentPK for the fee or null if no department is assigned
     */
    public DepartmentPK getDepartment() {
        return this.dep;
    }
    
    /** Setter for property dep
     * @param dep DepartmentPK for the fee or null if no department is to be assigned
     */
    public void setDepartment(DepartmentPK dep) {
        this.dep = dep;
    }
   
    
    /** Getter for property feeIdentifier.
     * @return feeIdentifier for the fee
     */
    public String getFeeIdentifier() {
		return feeIdentifier;
	}
    /** setter for property feeIdentifier.
     * @param feeIdentifier feeIdentifier for the fee
     */
	public void setFeeIdentifier(String feeIdentifier) {
		this.feeIdentifier = feeIdentifier;
	}
	/**
	 * Getter for Fee Type
	 * @return FEEType
	 */
	public FEEType getFeeType() {
		return feeType;
	}
	/**
	 * Setter for Fee Type
	 * @param feeType
	 */
	public void setFeeType(FEEType feeType) {
		this.feeType = feeType;
	}
    /**
     * Getter for Percentage Fee
     * @return Quantity 
     * 		Percentage of Fee 
     */
	public Quantity getPercentageFee() {
		return percentageFee;
	}

	/**
	 * Setter for Percentage Fee
	 * @param Quantity percentageFee
	 */
	public void setPercentageFee(Quantity percentageFee) {
		this.percentageFee = percentageFee;
	}

    /** Getter for fee ranges
     * @return fee ranges
     */    
    public FeeRange[] getRangeDetails() {
        if (this.rangeDetails == null)
            this.rangeDetails = new FeeRange[0];
        return this.rangeDetails;
    }
    
    /** Setter for fee ranges
     * @param rangeDtls fee ranges for the fee
     * @throws Exception on invalid range values
     */    
    public void setRangeDetails(FeeRange[] rangeDtls) throws Exception {
        FeeRange prevRange = null;
        for (int i = 0; i < rangeDtls.length; i++) {
            MoneyAmount curFee = rangeDtls[i].getFeeAmount();
            MoneyAmount curEnd = rangeDtls[i].getFeeRangeEnd();
            long curRangeEnd = 0;
            long curRangeFee = 0;
            if (curFee != null) {
                curRangeFee = curFee.getLongValue();
                if ((curRangeFee < 0) || (curRangeFee > MAX_FEE_AMT)) {
                    StringBuffer msg = new StringBuffer();
                    msg.append("Invalid fee amount ");
                    msg.append(curFee.toString());
                    msg.append("for Fee: " +this.ID);
                    msg.append(" Range: " +(i+1));
                    msg.append(" cur: " +curRangeEnd);
                    throw new Exception(msg.toString());                    
                }
            }
            if (curEnd != null) {
                curRangeEnd = curEnd.getLongValue();
                if ((curRangeEnd < 0) || (curRangeEnd > MAX_RANGE_AMT)) {
                    StringBuffer msg = new StringBuffer();
                    msg.append("Invalid range end amount ");
                    if (null != curFee) {
                        msg.append(curFee.toString());
                    }
                    msg.append("for Fee: " +this.ID);
                    msg.append(" Range: " +(i+1));
                    throw new Exception(msg.toString());     
                }
            }
            if (curRangeEnd == 0) //last fee or end marker; discard ranges that follow
            {
                // this.rangeDetails = new FeeRange[i];
                // System.arraycopy(rangeDtls, 0, this.rangeDetails, 0, i);   
            	if (curRangeFee != 0) {
            		if ( null != this.outOfRangeFee && this.outOfRangeFee.getLongValue() != 0 && this.outOfRangeFee.getLongValue() != curRangeFee) {
            			StringBuffer msg = new StringBuffer();
            			msg.append("Can only have one out of range fee: ");
            			msg.append(this.ID);
            			msg.append("out of range fee 1: " +this.outOfRangeFee.toString());
                                if (null != curFee) {
                                    msg.append(" out of range fee 2: " + curFee.toString());
                                }
            			throw new Exception(msg.toString());
            		}	                  
            	    this.outOfRangeFee = curFee;
                }
            }
            if (prevRange != null) {
                long prevRangeEnd = prevRange.getFeeRangeEnd().getLongValue();
                if (prevRangeEnd > curRangeEnd && curRangeEnd != 0) {
                    StringBuffer msg = new StringBuffer();
                    msg.append("Invalid range end amount for Fee: ");
                    msg.append(this.ID);
                    msg.append("prev: " +prevRangeEnd);
                    msg.append(" cur: " +curRangeEnd);
                    throw new Exception(msg.toString());
                }
            }
            prevRange = rangeDtls[i];
        }
        // All ranges exist and are valid
        this.rangeDetails = rangeDtls;
        
    }
    
    /** Concrete method to validate the primary key of the entity object
     * @return true if the primary key is valid
     */
    public boolean isPKValid() {
        return (this.ID == null) ? false : this.ID.isValid();
    }
    
    /** Validator for the object properties
     * @throws Exception on error in the object's property values
     */    
    public void validate() throws Exception {
        if (!isPKValid()) {
            throw new Exception("Invalid Fee: " +this.ID);            
        }
        if ((this.name == null) || (this.name.trim().equals("")) || 
        (this.name.trim().equals("*"))) {
            throw new Exception("Invalid name for Fee: " +ID);
        }
        this.validateDepartment();
    }
    
    private void validateDepartment() throws Exception {
        if ((dep != null) && (!dep.isValid())) {
            // Check against Department obj's ID range
            throw new Exception("Invalid department: " +dep.toString()
            +" for Fee: " +this.ID);
        }
    }
    
    /** sets the attributes of the new object; this operation is similar to deep
     * cloning
     * @param obj the target object to be written into
     */
    public void setAttributes(IEntityObject obj) {
        Fee fObj = (Fee) obj;
        fObj.ID = this.ID;
        fObj.name = this.name;
        fObj.dep = this.dep;
        fObj.refundable = this.refundable;
        fObj.rangeDetails = this.rangeDetails;
        fObj.outOfRangeFee = this.outOfRangeFee;
        fObj.feeType = this.feeType;
        fObj.percentageFee = this.percentageFee;
    }    
    
    /** Getter for property outOfRangeFee.
     * @return Value of property outOfRangeFee.
     */
    public MoneyAmount getOutOfRangeFee() {
        return ((this.outOfRangeFee == null) ? new MoneyAmount(0) : this.outOfRangeFee);
    }
    
    /** Setter for property outOfRangeFee.
     * @param outOfRangeFee New value of property outOfRangeFee.
     */
    public void setOutOfRangeFee(MoneyAmount outOfRangeFee) {
        this.outOfRangeFee = outOfRangeFee;
    }
    
    /** Implementation method for visitable in visitor pattern
     * @param v visitor
     * @throws Exception on exception in visitor's visit method
     */    
    public void accept(SalesEntityVisitor v) throws Exception {
        v.visit(this);
    }   
    
    /**
     * Computes the Fee based on the Fee Type and Item base price
     * 
     * @param price
     * @return
     */
    public MoneyAmount computeFee(MoneyAmount price){
    	MoneyAmount absPrice = price.abs();
    	MoneyAmount feeAmount = new MoneyAmount(0);
    	switch(this.getFeeType()){

    	case RANGEAMOUNT:
    		feeAmount = computeRangeBasedFee(absPrice);
    		break;

    	case PERCENTAGE:
    		feeAmount = computePercentageFee(absPrice);
    		break;
    	}
    	return feeAmount;
    }
    
    /**
	 * Returns the percentage Fee amount calculated
	 * based on item price and the percentage fee configuration
	 * @param price : base selling price of the Item
	 * @return feeAmount calculated
	 */
	public MoneyAmount computePercentageFee(MoneyAmount price){
		 Quantity tmpRes = price.multiplyByAnything(this.percentageFee, price.getNumDecimals());
		 Quantity result = tmpRes.divideByAnything(new Quantity(100,0,""), price.getNumDecimals());
		 
		 return new MoneyAmount(result.getLongValue(), price.getNumDecimals(),
			price.getCurrencyCode());
	}
	/**
	 * Returns the fee amount calculated based on range/amount
	 * and Item's base selling price.
	 * @param price : base selling price of the Item
	 * @return
	 */
	public MoneyAmount computeRangeBasedFee(MoneyAmount price){
		MoneyAmount feeAmount = new MoneyAmount(0);
		FeeRange[] rdtls = this.getRangeDetails();
		boolean feeApplied=false;
		if(rdtls!=null){
			for (int r = 0; r < rdtls.length; r++) {
        		if (null == rdtls[r])
        			continue;

        		 long rangeEnd = rdtls[r].getFeeRangeEnd().getLongValue();
        		 long rangeBegin = 0;
        		 long priceValue = price.getLongValue();
        		if (rangeEnd > 0) {
        			if (priceValue > rangeBegin
        					&& priceValue <= rangeEnd){
        				feeAmount = rdtls[r].getFeeAmount();
        				feeApplied = true;
        				break;
        			} else {
        				rangeBegin = rangeEnd;
        				continue;
        			}
        		} else {
        			if (priceValue > rangeBegin)
        				feeAmount = rdtls[r].getFeeAmount();
        			break;
        		}
        	}
        	if (!feeApplied)
        		feeAmount = this.getOutOfRangeFee();
		}
		
		return feeAmount;
	}
}