/*
 * PopAwardGenDetails.java
 *
 * Created on January 5, 2004, 12:08 PM
 */

package com.verifone.isd.vsms2.sales.ent.trans;
import com.verifone.isd.vsms2.sales.ent.popdiscount.IPopDiscountType;
/**
 *
 * @author  Bhanu_N2
 */
public class PopAwardGenDetail implements java.io.Serializable {
    static final long serialVersionUID = -7248193223161995618L;
    /** Holds value of property popDiscountNum. */
    private int popDiscountNum;
    
    /** Holds value of property popDiscountName. */
    private String popDiscountName;
    
    /** Holds value of property qualifier. */
    private IPopDiscountType qualifier;
    
    /** Holds value of property couponGeneration. */
    private boolean couponGeneration;
    
    /** Holds value of property codeGenerated. */
    private GeneratedCodeInfo codeGenerated;
    
    /** Holds value of property couponMsgs. */
    private String[] couponMsgs;
    
    /** Creates a new instance of PopAwardGenDetails */
    public PopAwardGenDetail() {
    }
    
    /** Getter for property popDiscountNum.
     * @return Value of property popDiscountNum.
     */
    public int getPopDiscountNum() {
        return this.popDiscountNum;
    }
    
    /** Setter for property popDiscountNum.
     * @param popDiscountNum New value of property popDiscountNum.
     */
    public void setPopDiscountNum(int popDiscountNum) {
        this.popDiscountNum = popDiscountNum;
    }
    
    /** Getter for property popDiscountName.
     * @return Value of property popDiscountName.
     */
    public String getPopDiscountName() {
        return this.popDiscountName;
    }
    
    /** Setter for property popDiscountName.
     * @param popDiscountName New value of property popDiscountName.
     */
    public void setPopDiscountName(String popDiscountName) {
        this.popDiscountName = popDiscountName;
    }
    
    /** Getter for property qualifier.
     * @return Value of property qualifier.
     */
    public IPopDiscountType getQualifier() {
        return this.qualifier;
    }
    
    /** Setter for property qualifier.
     * @param qualifier New value of property qualifier.
     */
    public void setQualifier(IPopDiscountType qualifier) {
        this.qualifier = qualifier;
    }
    
    /** Getter for property couponGeneration.
     * @return Value of property couponGeneration.
     */
    public boolean isCouponGeneration() {
        return this.couponGeneration;
    }
    
    /** Setter for property couponGeneration.
     * @param couponGeneration New value of property couponGeneration.
     */
    public void setCouponGeneration(boolean couponGeneration) {
        this.couponGeneration = couponGeneration;
    }
    
    /** Getter for property codeGenerated.
     * @return Value of property codeGenerated.
     */
    public GeneratedCodeInfo getCodeGenerated() {
        return this.codeGenerated;
    }
    
    /** Setter for property codeGenerated.
     * @param codeGenerated New value of property codeGenerated.
     */
    public void setCodeGenerated(GeneratedCodeInfo codeGenerated) {
        this.codeGenerated = codeGenerated;
    }
    
    /** Getter for property couponMsgs.
     * @return Value of property couponMsgs.
     *
     */
    public String[] getCouponMsgs() {
        return this.couponMsgs;
    }
    
    /** Setter for property couponMsgs.
     * @param couponMsgs New value of property couponMsgs.
     *
     */
    public void setCouponMsgs(String[] couponMsgs) {
        this.couponMsgs = couponMsgs;
    }
    
}
