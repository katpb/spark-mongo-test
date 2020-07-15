/*
 * PopDiscDetails.java
 *
 * Created on January 5, 2004, 11:49 AM
 */

package com.verifone.isd.vsms2.sales.ent.trans;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import com.verifone.isd.vsms2.sales.ent.popdiscount.IPopDiscountType;

/**
 *
 * @author  Bhanu_N2
 */
public class PopDiscDetail implements java.io.Serializable {
    static final long serialVersionUID = 3602891857097418930L;
    
    /** Holds value of property discountAmount. */
    private MoneyAmount discountAmount;
    
    /** Holds value of property unitDiscount. */
    private MoneyAmount unitDiscount;
    
    /** Holds value of property popDiscountName. */
    private String popDiscountName;
    
    /** Holds value of property popDiscountNum. */
    private int popDiscountNum;
    
    /** Holds value of property qualifier. */
    private IPopDiscountType qualifier;
    
    /** Holds value of property discountBasis. */
    private DiscountBasis discountBasis;
    
    /** Holds value of property fuelUOM. */
    private String fuelUOM;
    
    /** Creates a new instance of PopDiscDetails */
    public PopDiscDetail() {
    }
    
    /** Getter for property discountAmount.
     * @return Value of property discountAmount.
     */
    public MoneyAmount getDiscountAmount() {
        return this.discountAmount;
    }
    
    /** Setter for property discountAmount.
     * @param discountAmount New value of property discountAmount.
     */
    public void setDiscountAmount(MoneyAmount discountAmount) {
        this.discountAmount = discountAmount;
    }
    
    /** Getter for property unitDiscount.
     * @return Value of property unitDiscount.
     */
    public MoneyAmount getUnitDiscount() {
        return this.unitDiscount;
    }
    
    /** Setter for property unitDiscount.
     * @param unitDiscount New value of property unitDiscount.
     */
    public void setUnitDiscount(MoneyAmount unitDiscount) {
        this.unitDiscount = unitDiscount;
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
    
    /** Getter for property discountBasis.
     * @return Value of property discountBasis.
     */
    public DiscountBasis getDiscountBasis() {
        return this.discountBasis;
    }
    
    /** Setter for property discountBasis.
     * @param discountBasis New value of property discountBasis.
     */
    public void setDiscountBasis(DiscountBasis discountBasis) {
        this.discountBasis = discountBasis;
    }
    
    /** Getter for property fuelUOM.
     * @return Value of property fuelUOM.
     *
     */
    public String getFuelUOM() {
        return this.fuelUOM;
    }
    
    /** Setter for property fuelUOM.
     * @param fuelUOM New value of property fuelUOM.
     *
     */
    public void setFuelUOM(String fuelUOM) {
        this.fuelUOM = fuelUOM;
    }
    
}
