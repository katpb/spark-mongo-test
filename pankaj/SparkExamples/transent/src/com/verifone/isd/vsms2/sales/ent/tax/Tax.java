package com.verifone.isd.vsms2.sales.ent.tax;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import com.verifone.isd.vsms2.sys.util.Quantity;
import com.verifone.isd.vsms2.sales.ent.ISalesEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.SalesEntityVisitor;


/** Entity class for Tax
 *  TBD add collect on taxes attribute
 * @author "mailto:bhanu_n2@verifone.com"
 * @version 1.0
 */
public class Tax implements IEntityObject, ISalesEntityVisitable {
   
	/**
	 * 
	 */
	private static final long serialVersionUID = -2824994096176449130L;

	/** Maximum ID value allowed for tax. */    
    public static final int MAX_TAXES = 8;
    
    public static final int TAX1_FLAG      = 0x0001;
    public static final int TAX2_FLAG      = 0x0002;
    public static final int TAX3_FLAG      = 0x0004;
    public static final int TAX4_FLAG      = 0x0008;
    public static final int TAX5_FLAG      = 0x0080;
    public static final int TAX6_FLAG      = 0x0400; 
    public static final int TAX7_FLAG      = 0x0800;    
    public static final int TAX8_FLAG      = 0x1000;
    
    /** Begin of Extended Tax.
     */    
    public static final int START_EXTENDED_TAXES = 5;
    /** NAXML Max Strategy length.
     */     
    public static final int MAX_NAXML_STRATEGY_ID_LEN = 4;    
    /** Maximum # decimals allowed in amount values.
     */     
    public static final int MAX_AMT_DECIMALS = 2;
    /** Maximum  rate values (implied decimals)
     */       
    public static final int MAX_RATE = 99999;
    /** Maximum # decimals allowed in tax rate %
     */         
    public static final int MAX_RATE_DECIMALS = 3;
    
    /** Maximum  amount values (implied decimals)
     */     
    public static final int MAX_START_AMT = 9999999;    
    
    /** Helper object to represent 0% tax rate
     */    
    protected static final Quantity ZERO_PCT = new Quantity(0, 3, "%");    
    /** Helper object to represent 0 amount
     */    
    protected static final MoneyAmount ZERO_AMT = new MoneyAmount(0);        
    private TaxPK ID;
    private String name;

    /** Holds value of property foodStampable. */
    private boolean priceIncludesTax;
    
    /** Holds value of property promptForExemption. */
    private boolean promptForExemption;
    
    /** Holds value of property fuelIncludesTax. */
    private boolean fuelIncludesTax;
    
    /** Holds value of property registrationNum. */
    private String registrationNum;
    
    /** Holds value of property indicator. */
    private String indicator;
    
    /** Holds value of property ratePercent.  */
    private Quantity ratePercent = ZERO_PCT;
    
    /** Holds value of property startAmount.  */
    private MoneyAmount startAmount;
    
    /** Holds value of property breakPoint. */
    private boolean breakPoint;
    
    /** Holds value of property breakPointProps. */
    private BreakPointProps breakPointProps;
    
    /** Holds value of property collectOnTaxes. */
    private int[] collectOnTaxes;    
    
    /** No-args constructor
     */    
    public Tax() {
        collectOnTaxes = new int[0];
    }
    
    /** Constructor
     * @param pk TaxPK for the object
     */    
    public Tax(TaxPK pk) {
        this.ID = pk;
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
    
    /** Getter of the entity object's primary key
     * @return the ID of the entity object
     */
    public IEntityPK getPK() {
        return this.ID;
    }
    
    /** Method to clone this entity's attribute to another
     * @param obj object to copy to
     */    
    public void setAttributes(IEntityObject obj) {
        Tax tObj = (Tax) obj;
        tObj.ID = this.ID;
        tObj.name = this.name;
        tObj.fuelIncludesTax = this.fuelIncludesTax;
        tObj.priceIncludesTax = this.priceIncludesTax;
        tObj.promptForExemption = this.promptForExemption;
        tObj.startAmount = this.startAmount;
        tObj.ratePercent = this.ratePercent;
        tObj.indicator = this.indicator;
        tObj.registrationNum = this.registrationNum;
        tObj.breakPoint = this.breakPoint;
        tObj.collectOnTaxes = this.collectOnTaxes;
        if (this.breakPointProps == null) {
            tObj.breakPointProps = null;
        }
        else {
            if (tObj.breakPointProps == null) {
                tObj.breakPointProps = new BreakPointProps();
            }
            this.breakPointProps.setAttributes(tObj.breakPointProps);
        }
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
        this.ID = (TaxPK)pk;        
    }
    
    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {
        if (!isPKValid()) {
            throw new Exception("Invalid Tax: " +this.ID);            
        }
        if ((this.name == null) || (this.name.trim().equals("")) || 
        (this.name.trim().equals("*"))) {
            throw new Exception("Invalid name for Tax: " +ID);
        }
        long val = 0;
        if (this.ratePercent != null) {
            if (this.ratePercent.getNumDecimals() > MAX_RATE_DECIMALS) {
                throw new Exception("Invalid # decimals in % tax rate: "
                +this.ratePercent.toString());
            }
            else {
                val = this.ratePercent.getLongValue();
                if ((val < 0) || (val > MAX_RATE))
                    throw new Exception("Invalid % tax rate: "
                    +ratePercent.toString());    
            }
        }
        if (this.startAmount != null) {
            if (this.startAmount.getNumDecimals() > MAX_AMT_DECIMALS) {
                throw new Exception("Invalid # decimals in start amount: "
                +this.startAmount.toString());
            }
            else {            
                val = this.startAmount.getLongValue();
                if ((val < 0) || (val > MAX_START_AMT))
                    throw new Exception("Invalid start amount: "
                    +startAmount.toString());
            }
        }
        if (this.isBreakPoint() && this.getBreakPointProps() != null) {
            this.getBreakPointProps().validate();
        }
        
        if(this.collectOnTaxes!=null && this.collectOnTaxes.length>0){
            
            if(this.ID.getValue()>=START_EXTENDED_TAXES){
        	 throw new Exception("Invalid Tax Configuration : On Extended Tax" +this.ID);     
            }else {
            
            for (int i = 0; i < collectOnTaxes.length; i++) {        	
                if ((collectOnTaxes[i] >=START_EXTENDED_TAXES) ) {
                    throw new Exception("Invalid Tax Configuration : Extended Tax Not Allowed" );     
                }
               
            }
            
            }
        }
    }

    /** Getter for property priceIncludesTax.
     * @return Value of property priceIncludesTax.
     */
    public boolean isPriceIncludesTax() {
        return this.priceIncludesTax;
    }
    
    /** Setter for property priceIncludesTax.
     * @param priceIncludesTax true if price includes tax
     */
    public void setPriceIncludesTax(boolean priceIncludesTax) {
        this.priceIncludesTax = priceIncludesTax;
    }
    
    /** Getter for property promptForExemption.
     * @return Value of property promptForExemption.
     */
    public boolean isPromptForExemption() {
        return this.promptForExemption;
    }
    
    /** Setter for property promptForExemption.
     * @param promptForExemption New value of property promptForExemption.
     */
    public void setPromptForExemption(boolean promptForExemption) {
        this.promptForExemption = promptForExemption;
    }
    
    /** Getter for property fuelIncludesTax.
     * @return Value of property fuelIncludesTax.
     */
    public boolean isFuelIncludesTax() {
        return this.fuelIncludesTax;
    }
    
    /** Setter for property fuelIncludesTax.
     * @param fuelIncludesTax New value of property fuelIncludesTax.
     */
    public void setFuelIncludesTax(boolean fuelIncludesTax) {
        this.fuelIncludesTax = fuelIncludesTax;
    }
    
    /** Getter for property registrationNum.
     * @return Value of property registrationNum.
     */
    public String getRegistrationNum() {
        return this.registrationNum;
    }
    
    /** Setter for property registrationNum.
     * @param registrationNum New value of property registrationNum.
     */
    public void setRegistrationNum(String registrationNum) {
        this.registrationNum = registrationNum;
    }
    
    /** Getter for property indicator.
     * @return Value of property indicator.
     */
    public String getIndicator() {
        return this.indicator;
    }
    
    /** Setter for property indicator.
     * @param indicator New value of property indicator.
     */
    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }
    
    /** Getter for property ratePercent.
     * @return Value of property ratePercent.
     */
    public Quantity getRatePercent() {
        return this.ratePercent;
    }
    
    /** Getter for property startAmount.
     * @return Value of property startAmount.
     */
    public MoneyAmount getStartAmount() {
        return this.startAmount;
    }
    
    /** Setter for property ratePercent.
     * @param ratePercent New value of property ratePercent.
     */
    public void setRatePercent(Quantity ratePercent) {
        if (ratePercent == null) {
            this.ratePercent = ZERO_PCT;
        }
        else {
            this.ratePercent = ratePercent;
        }
    }
    
    /** Setter for property startAmount.
     * @param startAmount New value of property startAmount.
     */
    public void setStartAmount(MoneyAmount startAmount) {
        this.startAmount = startAmount;
    }

    /**
     * Return actual taxable amount (excluding tax amount)
     * 
     * @param taxable
     * @return
     */
    public MoneyAmount getTaxableInclusiveTax(MoneyAmount taxable){
    	if(priceIncludesTax){
    		MoneyAmount taxableInclusive = new MoneyAmount(taxable);
    		taxableInclusive.sub(computeTax(taxable));
    		return taxableInclusive;
    	}
    	return taxable;
    }
    
    /**
     *  Returns base amount
     * 
     *  Base Amount = ((A * 100 * 100) / ((100 * (100 + P1 + P2 + ...+Pn)) + ((Pn1 * Pm1) + (Pn2 * Pm2) + ... + (Pnn * Pmn)))
     *  
     *  Where 
     *  A = Amount of the PLU
     *  P1, P2, Pn are rate of price include taxes applied on PLU
     *  Pn1, Pn2, Pnn is rate of tax on which tax on tax has been applied.
     *  Pm1, Pm2, Pmn is rate of tax which is applied tax on tax on pnn
     *  
     * @param amount inclusive taxes 
     * @param inclusive taxes 
     * @return base price
     */
    public static MoneyAmount computeBasePrice(MoneyAmount inclusiveAmount, Tax...taxes){
    	
    	Quantity devident = inclusiveAmount.multiplyByAnything(new Quantity(100 * 100, inclusiveAmount.getUOM()), inclusiveAmount.getNumDecimals());
    	long totalRate = 0, totalTaxOnTaxRate = 0;
    	Quantity result = ZERO_AMT;
    	int numDec = taxes[0].ratePercent.getNumDecimals();
    	long qty = 100;
    	for (int i = 0; i < numDec; i++) {
    		qty *= 10;
    	}
    	for(Tax tax : taxes){
    		if(tax != null && tax.isPriceIncludesTax()){
    			totalRate += tax.ratePercent.getLongValue();
    		}
    	}
    	
    	for(int index = taxes.length - 1; index > 0; --index){
    		int[] taxOnTaxes = taxes[index].getCollectOnTaxes();
    		for(int taxOnTaxIndex : taxOnTaxes){
    			for (Tax tempTax : taxes){
    				if(tempTax != null && tempTax.isPriceIncludesTax()){
    					TaxPK taxPK = (TaxPK) tempTax.getPK();
    					if(taxOnTaxIndex == taxPK.getValue()){
    						totalTaxOnTaxRate += (tempTax.getRatePercent().getLongValue() * taxes[index].getRatePercent().getLongValue());
    					}
    				}
    			}
    		}
    	}
    	Quantity divisor = new Quantity(((qty + totalRate) * 100) + (totalTaxOnTaxRate/1000), numDec, "");
    	result = devident.divideByAnything(divisor, inclusiveAmount.getNumDecimals());
    	return new MoneyAmount(result.getLongValue(), inclusiveAmount.getNumDecimals(), inclusiveAmount.getUOM()); 
    }
    
    
    /**
     * Returns rounded base price
     * 
     * @param amount inclusive taxes 
     * @param inclusive taxes 
     * @return rounded base price
     */
    public static MoneyAmount computeRoundedBasePrice(MoneyAmount inclusiveAmount, Tax...taxes){
    	MoneyAmount basePrice = computeBasePrice(inclusiveAmount, taxes);
    	MoneyAmount totalTax = Tax.computeFlatTax(basePrice, taxes);
    	MoneyAmount totalTaxOnTax = getTotalTaxOnTax(basePrice, taxes);
    	long result = inclusiveAmount.getLongValue() - (totalTax.getLongValue() + totalTaxOnTax.getLongValue());
    	return new MoneyAmount(result, inclusiveAmount.getNumDecimals(),
                inclusiveAmount.getCurrencyCode()); 
    }
    
    /**
     * Calculates total tax amount collected from tax on tax. 
     * @param basePrice
     * @param taxes
     * @return total tax computed from tax on tax
     */
    private static MoneyAmount getTotalTaxOnTax(MoneyAmount basePrice, Tax...taxes){

    	long totalTaxOnTax = 0;
    	for(int index = taxes.length - 1; index > 0; --index){
    		if(taxes[index] != null){
    			int[] taxOnTaxes = taxes[index].getCollectOnTaxes();
    			for(int taxOnTaxIndex : taxOnTaxes){
    				for (Tax tempTax : taxes){
    					if(tempTax != null){
    						TaxPK taxPK = (TaxPK) tempTax.getPK();
    						if(taxOnTaxIndex == taxPK.getValue()){
    							MoneyAmount taxAmount = Tax.computeFlatTax(basePrice, tempTax);
    							totalTaxOnTax += Tax.computeFlatTax(taxAmount, taxes[index]).getLongValue();
    						}
    					}
    				}
    			}
    		}
    	}

    	return new MoneyAmount(totalTaxOnTax);
    }
    
    /**
     * Returns tax amount calculated on taxable.
     * 
     * @param taxable
     * @param taxes
     * @return Tax amount 
     */
    public static MoneyAmount computeFlatTax(MoneyAmount taxable, Tax...taxes){
    	
    	long totalRate = 0;
    	for(Tax tax : taxes){
    		if(tax != null){
    			totalRate += tax.ratePercent.getLongValue();
    		}
    	}
    	Quantity tmp = taxable.multiplyByAnything(new Quantity(totalRate, taxes[0].ratePercent.getNumDecimals(), ""), taxable.getNumDecimals());
        Quantity result = ZERO_AMT;
        result = tmp.divideByAnything(new Quantity(100,0,""), taxable.getNumDecimals());
        return new MoneyAmount(result.getLongValue(), taxable.getNumDecimals(),
                taxable.getCurrencyCode()); 
    }
    
    /** Strategy to compute tax given the amount on which to compute the tax
     * @param taxable amount to compute tax
     * @return computed tax
     */
    public MoneyAmount computeTax(MoneyAmount taxable) {
        boolean isNegative = false;
        MoneyAmount taxAmt = new MoneyAmount(0);
        long val = 0;
        if (taxable != null) {
            val = taxable.getLongValue();
            if (val != 0) {
                MoneyAmount absTaxable = taxable;
                if (val < 0) {
                    absTaxable = new MoneyAmount(-val, taxable.getNumDecimals());
                    isNegative = true;
                }
                if (this.breakPoint) { 
                    if (this.breakPointProps != null) {
                        long startAmtVal = (this.startAmount == null) ? 0 : this.startAmount.getLongValue();
                        if (this.breakPointProps.isApplyForAllAmounts()) {
                            taxAmt = computeBreakPtTax(absTaxable);
                        }
                        else if (absTaxable.getLongValue() >= startAmtVal) {
                            taxAmt = computeFlatTax(absTaxable);
                        }
                        else {
                            taxAmt = computeBreakPtTax(absTaxable);
                        }
                    }
                    else {
                        taxAmt = computeFlatTax(absTaxable);
                    }
                }
                else {
                    taxAmt = computeFlatTax(absTaxable);                    
                }
            }
        }
        if (isNegative && taxAmt.getLongValue() != 0) {
            long taxV = taxAmt.getLongValue();
            taxAmt = new MoneyAmount(-taxV, taxAmt.getNumDecimals());
        }
        return taxAmt;
    }
    
    /**
     * Return the tax after calculating on taxable.
     * @param taxable
     * @return tax.
     */
    public MoneyAmount computeFlatTax(MoneyAmount taxable) {
        Quantity tmp = taxable.multiplyByAnything(this.ratePercent, taxable.getNumDecimals());
        Quantity result = ZERO_AMT;
        if (this.priceIncludesTax) {
            int numDec = this.ratePercent.getNumDecimals();
            long qty = 100;
            for (int i = 0; i < numDec; i++) {
                qty *= 10;
            }
            Quantity divisor = new Quantity(qty + this.ratePercent.getLongValue(), numDec, "");
            result = tmp.divideByAnything(divisor, taxable.getNumDecimals());
        }
        else {
            result = tmp.divideByAnything(new Quantity(100,0,""), taxable.getNumDecimals());
        }
        return new MoneyAmount(result.getLongValue(), taxable.getNumDecimals(),
                taxable.getCurrencyCode()); 
    }
    
    private MoneyAmount computeBreakPtTax(MoneyAmount taxable) {
        long taxableVal = 0;
        long taxValue = 0;        
        if (this.breakPointProps != null && taxable != null) { 
            taxableVal = taxable.getLongValue();
            MoneyAmount minTaxable = this.breakPointProps.getMinimumTaxableAmount();
            long tableTaxableVal = (minTaxable == null) ? 0 : minTaxable.getLongValue();
            if (taxableVal >= tableTaxableVal) {
                BreakPoint[] breakPts = this.breakPointProps.getBreakPoints();
                int nonRepIndexEnd = this.breakPointProps.getRepeatStartNum() -1;
                if (nonRepIndexEnd < 0) {
                    nonRepIndexEnd = breakPts.length;
                }
                if (nonRepIndexEnd > breakPts.length) {
                    nonRepIndexEnd = breakPts.length;                    
                }
                /*
                 ** Compute tax for non repeat portion of the break point table
                 */
                boolean matchFound = false;
                for (int i = 0; i < nonRepIndexEnd; i++) {
                    //Update taxable and tax values for each non-repetitive break point value
                    tableTaxableVal += breakPts[i].getAmountDifference();
                    taxValue += breakPts[i].getIncrement();
                    if (tableTaxableVal >= taxableVal) { //Found a match
                        matchFound = true;
                        break;
                    }
                    tableTaxableVal++;
                }
                if (!matchFound) {
                    long loopAmount = 0, loopTax = 0;
                    int loopBeginIndex = this.breakPointProps.getRepeatStartNum() -1;
                    int loopEndNum = this.breakPointProps.getRepeatEndNum();
                    
                    if (loopBeginIndex >= 0 && loopEndNum > 0 && loopBeginIndex < loopEndNum 
                    && loopBeginIndex < breakPts.length && loopEndNum <= breakPts.length) {
                        //Compute the amounts for a single execution of the loop.                        
                        for (int i = loopBeginIndex; i < loopEndNum ; i++) {
                            loopAmount += breakPts[i].getAmountDifference()+ 1;
                            loopTax += breakPts[i].getIncrement();
                        }
                        //Find # loops required to reach the required taxable value
                        long temp = (taxableVal - tableTaxableVal) / loopAmount;
                        taxValue += temp * loopTax;
                        
                        tableTaxableVal += (temp * loopAmount);
                        /*
                         ** Iterate over the repeat portion to account for the modulo from (taxableVal - tableTaxableVal) % loopAmount
                         */
                        for (int i = loopBeginIndex; i < loopEndNum; i++) {
                            tableTaxableVal += breakPts[i].getAmountDifference();
                            taxValue += breakPts[i].getIncrement();
                            if (tableTaxableVal >= taxableVal) { //Found a match
                                matchFound = true;
                                break;
                            }
                            tableTaxableVal++; // Increment to account for next iteration begin value (e.g., 20 - 39, 40 - 59, 60 - 79 etc)
                        }
                    }
                }
            }
        }
        MoneyAmount rtn = null;
        if (null == taxable) {
            rtn = new MoneyAmount(taxValue);
        }
        else {
            rtn = new MoneyAmount(taxValue, taxable.getNumDecimals(), taxable.getUOM()); 
        }
        return rtn;
    }    
    
    /** Getter for property breakPoint.
     * @return Value of property breakPoint.
     */
    public boolean isBreakPoint() {
        return this.breakPoint;
    }
    
    /** Setter for property breakPoint.
     * @param breakPoint New value of property breakPoint.
     */
    public void setBreakPoint(boolean breakPoint) {
        this.breakPoint = breakPoint;
    }
    
    /** Getter for property breakPointProps.
     * @return Value of property breakPointProps.
     */
    public BreakPointProps getBreakPointProps() {
        return this.breakPointProps;
    }
    
    /** Setter for property breakPointProps.
     * @param breakPointProps New value of property breakPointProps.
     * @throws Exception on invalid parameters
     */
    public void setBreakPointProps(BreakPointProps breakPointProps) throws Exception {
        this.breakPointProps = breakPointProps;
    }
    
    /** Get the list of taxes on which the current tax has to be collected
     * @return list of taxes to collect tax on
     */    
    public int[] getCollectOnTaxes() {
        if (this.collectOnTaxes == null)
            this.collectOnTaxes = new int[0];
        return this.collectOnTaxes;
    }
    
    /** Set the list of taxes on which the current tax has to be collected
     * @param newTaxes list of taxes to collect tax on
     */    
    public void setCollectOnTaxes(int[] newTaxes) {
        this.collectOnTaxes = newTaxes;
    }
    
    /** Test method
     * @param args params
     */    
    public static void main(String[] args) {
        TaxPK pk = new TaxPK(1);
        Tax tax = new Tax(pk);
        tax.setRatePercent(new Quantity(7000, 3, "%"));
        tax.setPriceIncludesTax(false);
        MoneyAmount cval = tax.computeTax(new MoneyAmount(-100, 2));
        System.out.println(cval.toString());
    }
    
    /** Implementation method for visitable in visitor pattern
     * @param v visitor
     * @throws Exception on exception in visitor's visit method
     */    
    public void accept(SalesEntityVisitor v) throws Exception {
        v.visit(this);
    }      
}



