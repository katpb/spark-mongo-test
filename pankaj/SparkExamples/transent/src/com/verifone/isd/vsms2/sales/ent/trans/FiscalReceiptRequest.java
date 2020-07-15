package com.verifone.isd.vsms2.sales.ent.trans;

/**
 * Entity class to hold Fiscal receipt request
 * @author Sumith_S1
 *
 */
public class FiscalReceiptRequest implements java.io.Serializable {
	
	private static final long serialVersionUID = -285149157329508379L;
	private int registerID;
	private FiscalReceiptType receiptType;
	

	public int getRegisterID() {
		return registerID;
	}
	public void setRegisterID(int registerID) {
		this.registerID = registerID;
	}

	public FiscalReceiptType getReceiptType() {
		return receiptType;
	}
	public void setReceiptType(FiscalReceiptType receiptType) {
		this.receiptType = receiptType;
	}

}
