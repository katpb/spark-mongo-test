package com.verifone.isd.vsms2.sales.ent.fiscalreceipt;

import com.verifone.isd.vsms2.sales.ent.IEntityVisitable;
import com.verifone.isd.vsms2.sales.ent.IEntityVisitor;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Entity class for Fiscal Receipt Tax-Exempt Config
 * @author T_VaishnaviS1
 *
 */
public class FiscalReceiptTaxExemptConfig implements IEntityObject, IEntityVisitable{
	
	private static final long serialVersionUID = -7369401185915577110L;
	private FiscalReceiptTaxExemptConfigPK pk;
	private String name;
	private String purchaseOrderPrompt;
	private String customerNumberPrompt;
	private boolean exemptMerchandiseTax;
	private boolean exemptFuelTax;
	private boolean exemptFuelFlatTax;
	public static int MAX_NAME_LENGTH = 20;
	public static int MAX_PURCHASE_ORDER_LENGTH = 20;
	public static int MAX_TAX_EXEMPT_CUST_LENGTH = 25;
	public static int MAX_TAX_EXEMPT = 50;
	
	public FiscalReceiptTaxExemptConfig() {
	}
	
	public FiscalReceiptTaxExemptConfig(FiscalReceiptTaxExemptConfigPK pk) {
		this.pk = pk;
	}
	
	@Override
	public void setAttributes(IEntityObject obj) {
		FiscalReceiptTaxExemptConfig config = (FiscalReceiptTaxExemptConfig) obj;
		config.setPK(this.pk);
		config.setName(this.name);
		config.setPurchaseOrderPrompt(this.purchaseOrderPrompt);
		config.setCustomerNumberPrompt(this.customerNumberPrompt);
		config.setExemptMerchandiseTax(this.exemptMerchandiseTax);
		config.setExemptFuelTax(this.exemptFuelTax);
		config.setExemptFuelFlatTax(this.exemptFuelFlatTax);
		
	}
	
	@Override
	public void accept(IEntityVisitor v) throws Exception {
		v.visit(this);
	}
	
	@Override
	public IEntityPK getPK() {
		return pk;
	}
	
	@Override
	public void setPK(IEntityPK pk) {
		this.pk = (FiscalReceiptTaxExemptConfigPK) pk;		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPurchaseOrderPrompt() {
		return purchaseOrderPrompt;
	}

	public void setPurchaseOrderPrompt(String purchaseOrderPrompt) {
		this.purchaseOrderPrompt = purchaseOrderPrompt;
	}

	public String getCustomerNumberPrompt() {
		return customerNumberPrompt;
	}

	public void setCustomerNumberPrompt(String customerNumberPrompt) {
		this.customerNumberPrompt = customerNumberPrompt;
	}

	public boolean isExemptMerchandiseTax() {
		return exemptMerchandiseTax;
	}

	public void setExemptMerchandiseTax(boolean exemptMerchandiseTax) {
		this.exemptMerchandiseTax = exemptMerchandiseTax;
	}

	public boolean isExemptFuelTax() {
		return exemptFuelTax;
	}

	public void setExemptFuelTax(boolean exemptFuelTax) {
		this.exemptFuelTax = exemptFuelTax;
	}

	public boolean isExemptFuelFlatTax() {
		return exemptFuelFlatTax;
	}

	public void setExemptFuelFlatTax(boolean exemptFuelFlatTax) {
		this.exemptFuelFlatTax = exemptFuelFlatTax;
	}

	@Override
	public void validate() throws Exception {
        if (!this.isPKValid()) {
            throw new Exception("Invalid Id for Tax Exempt Config: " +this.pk.getId());            
        }
        if(!(this.name != null && !this.name.isEmpty() && this.name.length() <= MAX_NAME_LENGTH)) {
        	throw new Exception("Invalid name for Tax Exempt Config: " +this.pk.getId()); 
        }
        if(!(this.purchaseOrderPrompt != null && !this.purchaseOrderPrompt.isEmpty() && this.purchaseOrderPrompt.length() <= MAX_PURCHASE_ORDER_LENGTH)) {
        	throw new Exception("Invalid value for Tax-Exempt Purchase Order # Prompt for Tax Exempt Config: " +this.pk.getId()); 
        }
        if(!(this.customerNumberPrompt != null && !this.customerNumberPrompt.isEmpty() && this.customerNumberPrompt.length() <= MAX_TAX_EXEMPT_CUST_LENGTH)) {
        	throw new Exception("Invalid value for Tax-Exempt Customer # Prompt for Tax Exempt Config: " +this.pk.getId()); 
        }
	}

	@Override
	public boolean isPKValid() {
		return (this.pk == null) ? false : this.pk.isValid();
	}

}
