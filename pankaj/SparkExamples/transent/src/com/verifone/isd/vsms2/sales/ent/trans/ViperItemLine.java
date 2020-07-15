package com.verifone.isd.vsms2.sales.ent.trans;

public class ViperItemLine extends SimpleItemLine {
	
	private static final long serialVersionUID = 3719804915475819724L;
	private int origStan; // Original STAN - for linking financial advice to pre-auth
	private String origReqID; // Original request ID - for payment reversal linking
	

	/**
	 * Returns the Original STAN number
	 * @return
	 */
	public int getOrigStan() {
		return origStan;
	}
	/**
	 * Sets the STAN number
	 * @param origStan
	 */
	public void setOrigStan(int origStan) {
		this.origStan = origStan;
	}
	/**
	 * Returns the Original request ID
	 * @return
	 */
	public String getOrigReqID() {
		return origReqID;
	}
	/**
	 * Sets the Original request ID
	 * @param origReqID
	 */
	public void setOrigReqID(String origReqID) {
		this.origReqID = origReqID;
	}
	@Override
	public void deepCopy(ItemLine item) {
		super.deepCopy(item);
		ViperItemLine clone = (ViperItemLine) item;
		clone.origStan = this.origStan;
		clone.origReqID = this.origReqID;
		
	}
}
