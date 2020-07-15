package com.verifone.isd.vsms2.sales.ent.trans;

public class SpecialDiscountItemLine extends SimpleItemLine {

	private static final long serialVersionUID = 6984727105494237080L;
	/**
	 * This is the class is to hold the special discount item details 
	 * @author Shanavas_P1
	 */	
	
	private String discountDetails;
	
	public SpecialDiscountItemLine(){
		super();
	}
	/*
	 * (non-Javadoc)
	 * @see com.verifone.isd.vsms2.sales.ent.trans.SimpleItemLine#acceptVisitor(com.verifone.isd.vsms2.sales.ent.trans.TransactionVisitor)
	 */
	public void acceptVisitor(TransactionVisitor v) throws Exception {
		v.visit(this);
	}
	public String getDiscountDetails() {
		return discountDetails;
	}
	public void setDiscountDetails(String discountDetails) {
		this.discountDetails = discountDetails;
	}

    public ItemLine createDeepCopy(){
    	ItemLine origLine = new SpecialDiscountItemLine();
    	((SpecialDiscountItemLine) this).deepCopy(origLine);
    	return origLine;
    }
}
