package com.verifone.isd.vsms2.sales.ent.trans;

/**
 * Entity class to hold Fiscal Tax Exempt Data for receipts
 * @author Medha_K1
 *
 */
public class FiscalTaxExemptInfo implements java.io.Serializable {

	private static final long serialVersionUID = -3759286727062560782L;
	
	private String exemptType;
	private String purchaseOrderNum;
	private String customerNum;
	
	public String getTaxType() {
		return exemptType;
	}

	public void setTaxType(String taxType) {
		this.exemptType = taxType;
	}

	public String getPurchaseOrderNum() {
		return purchaseOrderNum;
	}

	public void setPurchaseOrderNum(String purchaseOrderNum) {
		this.purchaseOrderNum = purchaseOrderNum;
	}

	public String getCustomerNum() {
		return customerNum;
	}

	public void setCustomerNum(String customerNum) {
		this.customerNum = customerNum;
	}

}
