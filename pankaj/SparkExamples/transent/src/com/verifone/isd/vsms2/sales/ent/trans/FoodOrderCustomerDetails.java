package com.verifone.isd.vsms2.sales.ent.trans;

public class FoodOrderCustomerDetails implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3330220249558120409L;

	private String customerName = null;
	
	private String customerPhoneNumber = null;
	
	private Boolean isFoodOrderTicketPrinted  = false;
	/* 
	** isFoodOrderChitTicketPrinted: Will be set when the we print one of the "Chit Paid" receipt
	** which will happen if we set "Notify via Receipt" flag in food service configuration
	** Because of how rules manager work we will hit the same code one or many times but only one 
	** Chit receipt is needed per transaction.
	*/
	private Boolean isFoodOrderChitTicketPrinted = false;
	
	/** Creates a new instance of FoodOrderCustomerDetails */
    public FoodOrderCustomerDetails() {
    }

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}

	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}

	public Boolean getIsFoodOrderTicketPrinted() {
		return isFoodOrderTicketPrinted;
	}

	public void setIsFoodOrderTicketPrinted(Boolean isFoodOrderTicketPrinted) {
		this.isFoodOrderTicketPrinted = isFoodOrderTicketPrinted;
	}
	
	public Boolean getIsFoodOrderChitTicketPrinted() {
		return isFoodOrderChitTicketPrinted;
	}

	public void setIsFoodOrderChitTicketPrinted(Boolean isFoodOrderChitTicketPrinted) {
		this.isFoodOrderChitTicketPrinted = isFoodOrderChitTicketPrinted;
	}
}
