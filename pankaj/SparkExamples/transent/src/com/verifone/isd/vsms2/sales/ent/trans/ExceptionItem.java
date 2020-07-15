package com.verifone.isd.vsms2.sales.ent.trans;

import java.io.Serializable;

/**
 * ExceptionItem is a wrapper class to identify an itemLine that was not added
 * to the transaction as part of an evaluateSale request. This class would also
 * contain the error condition as an ExceptionType.
 * @author Sudesh_S1
 * 
 */
public class ExceptionItem implements Serializable {
    
    static final long serialVersionUID = -4245549963961064831L;
    
    private ItemLine itemLine;
    private ExceptionType exceptionType;
    private String promptMsg;


    /**
     * @param itemLine
     * @param exceptionType
     */
    public ExceptionItem(ItemLine itemLine, ExceptionType exceptionType) {
        super();
        this.itemLine = itemLine;
        this.exceptionType = exceptionType;
    }
    
    /**
     * @param itemLine
     * @param exceptionType
     * @param promptMsg
     */
    public ExceptionItem(ItemLine itemLine, ExceptionType exceptionType,String promptMsg) {
        super();
        this.itemLine = itemLine;
        this.exceptionType = exceptionType;
        this.promptMsg = promptMsg;
    }

    /**
     * @return the itemLine
     */
    public ItemLine getItemLine() {
        return itemLine;
    }

    /**
     * @param itemLine the itemLine to set
     */
    public void setItemLine(ItemLine itemLine) {
        this.itemLine = itemLine;
    }

    /**
     * @return the exceptionType
     */
    public ExceptionType getExceptionType() {
        return exceptionType;
    }

    /**
     * @param exceptionType the exceptionType to set
     */
    public void setExceptionType(ExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }
    /**
     * 
     * @return The display message set
     */
	public String getPromptMsg() {
		return promptMsg;
	}
	/**
	 * Sets the messages to display
	 * @param promptMsg
	 */
	public void setPromptMsg(String promptMsg) {
		this.promptMsg = promptMsg;
	}
}
