package com.verifone.isd.vsms2.sales.ent.taxablerebate;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.verifone.isd.vsms2.sales.ent.tax.TaxPK;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;

public abstract class TaxableRebate implements java.io.Serializable {
	
	private MoneyAmount taxableRebateAmount;
    private Set<TaxPK> taxableRebateTaxes;
    
    public TaxableRebate(){
    	 this.taxableRebateTaxes = Collections.synchronizedSet(new HashSet<TaxPK>());
    }
    
    public void setAttribute(TaxableRebate obj) {
    	obj.setTaxableRebateTaxes(this.getTaxableRebateTaxes());
    	obj.setTaxableRebateAmount(this.taxableRebateAmount);
    }
    
    protected void validateTaxableRebatesTaxes() throws Exception {
    	for(TaxPK taxPk : taxableRebateTaxes){
    		if ((taxPk != null) && (!taxPk.isValid())) {
                throw new Exception("Invalid tax rate");
            }
    	}
    }
    
    public MoneyAmount getTaxableRebateAmount() {
		return taxableRebateAmount;
	}

    public void setTaxableRebateAmount(MoneyAmount taxableRebateAmount) {
		this.taxableRebateAmount = taxableRebateAmount;
	}
    
    /** Add Taxable Rebates tax
     * @param tax TaxPK to be applied to this PLU
     */    
    public void addTaxableRebateTax(TaxPK tax) {
        this.taxableRebateTaxes.add(tax);
    }
    
    /** Remove Taxable Rebates tax
     * @param tax tax be be removed from this PLU
     */    
    public void removeTaxableRebateTax(TaxPK tax) {
        this.taxableRebateTaxes.remove(tax);
    }
    
    /** Get all applicable Taxable Rebates taxes
     * @return iterator of TaxPK objects assigned to this PLU
     */    
    public Iterator<TaxPK> getTaxableRebateTaxes() {
        return this.taxableRebateTaxes.iterator();
    }
    
    /** Set Taxable Rebates taxes from the iterator
     * @param items iterator of TaxPK objects to assign to this PLU
     */    
    public void setTaxableRebateTaxes(Iterator<TaxPK> items) {
        this.taxableRebateTaxes.clear();
        while(items.hasNext()) {
            this.taxableRebateTaxes.add(items.next());
        }
    }
	
}
