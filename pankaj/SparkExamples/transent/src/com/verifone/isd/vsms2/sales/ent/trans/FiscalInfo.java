package com.verifone.isd.vsms2.sales.ent.trans;

public class FiscalInfo implements java.io.Serializable
{
	static final long serialVersionUID =  5208626272149384867L;
	
    private String vsrCustomerTaxNum 	= "";	// Value for sale and refund
    private String vsrCustomerName		= "";	// Value for sale and refund
    
    private String vsCustomerAddr		= "";	// Value for sale only

   	// COO
	// It's the printer's internal counter to track its ticket numbers.
    private String vrOriginalCOO		= "";	// Value for refund only
    
    private String vrOriginalPrtNum		= "";	// Value for refund only
    private String vrOriginalDate		= "";	// Value for refund only
    private String vrOriginalTime		= "";	// Value for refund only
    
	public String getVsrCustomerTaxNum() {
		return vsrCustomerTaxNum;
	}
	
	public void setVsrCustomerTaxNum(String vsrCustomerTaxNum) {
		this.vsrCustomerTaxNum = vsrCustomerTaxNum;
	}
	
	public String getVsrCustomerName() {
		return vsrCustomerName;
	}
	
	public void setVsrCustomerName(String vsrCustomerName) {
		this.vsrCustomerName = vsrCustomerName;
	}
	
	public String getVsCustomerAddr() {
		return vsCustomerAddr;
	}
	
	public void setVsCustomerAddr(String vsCustomerAddr) {
		this.vsCustomerAddr = vsCustomerAddr;
	}
	
	public String getVrOriginalCOO() {
		return vrOriginalCOO;
	}
	
	public void setVrOriginalCOO(String vrOriginalCOO) {
		this.vrOriginalCOO = vrOriginalCOO;
	}
	
	public String getVrOriginalPrtNum() {
		return vrOriginalPrtNum;
	}
	
	public void setVrOriginalPrtNum(String vrOriginalPrtNum) {
		this.vrOriginalPrtNum = vrOriginalPrtNum;
	}
	
	public String getVrOriginalDate() {
		return vrOriginalDate;
	}
	
	public void setVrOriginalDate(String vrOriginalDate) {
		this.vrOriginalDate = vrOriginalDate;
	}
	
	public String getVrOriginalTime() {
		return vrOriginalTime;
	}
	
	public void setVrOriginalTime(String vrOriginalTime) {
		this.vrOriginalTime = vrOriginalTime;
	}
 
}
