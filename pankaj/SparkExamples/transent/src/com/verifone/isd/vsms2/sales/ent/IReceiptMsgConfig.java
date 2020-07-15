package com.verifone.isd.vsms2.sales.ent;


public interface IReceiptMsgConfig {
	
	public static final int MAX_LINES = 5;
	public static final int MAX_TEXT_LENGTH = 40;
	
	/**
	 * 
	 * @return the line number
	 */
	public int getLineNumber() ;
	/**
	 * 
	 * @return returns the message text
	 */
	public String getText();
	/**
	 * 
	 * @return  message alignment
	 */
	public AlignmentEnum getAlign();

}
