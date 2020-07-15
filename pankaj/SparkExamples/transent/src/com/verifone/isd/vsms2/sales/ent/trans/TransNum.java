/*
 * TransNum.java
 *
 * Created on February 10, 2003, 12:55 PM
 */

package com.verifone.isd.vsms2.sales.ent.trans;

/**
 * A number uniquely identifying a transaction to the system.
 *
 * @author  mailto:David_E3@verifone.com
 * @version 1.0
 */
public class TransNum implements java.io.Serializable , Comparable<TransNum>{
    
    static final long serialVersionUID = -2190522806578361794L;
    
    private String transNum = null;
    
    /** Creates a new instance of TransNum */
    public TransNum() {
    }
    
    /**
     * @return a String identifying the transaction
     */
    public String getTransNum() {
        return this.transNum;
    }
    
    /**
     * @param transNum a String to identify the transaction
     */
    public void setTransNum(String transNum) {
        this.transNum = transNum;
    }

	@Override
	public int compareTo(TransNum transNum) {
		return this.transNum.compareTo(transNum.transNum);
	}
	
	@Override
	public final int hashCode() {
		return this.transNum.hashCode();
	}
	
	@Override
	public final boolean equals(Object obj) {
		if(obj instanceof TransNum){
			return (this.transNum.equals(((TransNum) obj).transNum));
		}
		return false;
	}
}
