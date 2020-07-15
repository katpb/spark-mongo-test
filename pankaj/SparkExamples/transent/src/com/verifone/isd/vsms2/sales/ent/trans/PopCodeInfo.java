package com.verifone.isd.vsms2.sales.ent.trans;

import java.util.Date;
/**
 *
 * @author  BHANU NARAYANAN
 */
public class PopCodeInfo implements java.io.Serializable {
    static final long serialVersionUID = -5114674742576743515L;
    
    public static final int POPCODE_VALID = 0;
    public static final int POPCODE_INVALID_DATE = 1;
    public static final int POPCODE_INVALID = 2;
    public static final int POPCODE_INVALID_GRADE = 3;
    public static final int POPCODE_USEDUP = 4;
    public static final int POPCODE_INVALID_DISCOUNTDEF = 5;
    
    public static final int POPCODE_LENGTH = 16;
   
    
    /** Holds value of property code. */
    private String code;
       
    /** Holds value of property expiryDate. */
    private Date expiryDate;
    
    /** Holds value of property popDiscountNum. */
    private int popDiscountNum;
    
    /** Holds value of property rejectCause. */
    private int rejectCause;
    
    /** Creates a new instance of PopCodeInfo */
    public PopCodeInfo() {
    	this.code = "0000000000000000";
    }
    
    /** Getter for property redeemedCode.
     * @return Value of property redeemedCode.
     *
     */
    public String getCode() {
        return this.code;
    }
    
    /** Setter for property redeemedCode.
     * @param code New value of property redeemedCode.
     *
     */
    public void setCode(String code) {
        this.code = code;
    }
    
    /** Getter for property expiryDate.
     * @return Value of property expiryDate.
     *
     */
    public Date getExpiryDate() {
        return this.expiryDate;
    }
    
    /** Setter for property expiryDate.
     * @param expiryDate New value of property expiryDate.
     *
     */
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
    
    /** Getter for property popDiscountId.
     * @return Value of property popDiscountId.
     *
     */
    public int getPopDiscountNum() {
        return this.popDiscountNum;
    }
    
    /** Setter for property popDiscountId.
     * @param popDiscountNum New value of property popDiscountId.
     *
     */
    public void setPopDiscountNum(int popDiscountNum) {
        this.popDiscountNum = popDiscountNum;
    }
    
    public int getRejectCause() {
        return this.rejectCause;
    }
    
    public void setRejectCause(int anotherCause) {
        this.rejectCause = anotherCause;
    }

		
	
	public String getFormattedCode() {
		
		return this.code.substring(0, 4) + "-" + 
				this.code.substring(4, 8) + "-" +
				this.code.substring(8,12) + "-" +
				this.code.substring(12);

	}

}
