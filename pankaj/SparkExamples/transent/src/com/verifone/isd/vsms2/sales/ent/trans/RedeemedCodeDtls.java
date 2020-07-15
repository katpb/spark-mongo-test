/*
 * OldCodeDetails.java
 *
 * Created on January 12, 2004, 9:35 PM
 */

package com.verifone.isd.vsms2.sales.ent.trans;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
/**
 *
 * @author  BHANU NARAYANAN
 */
public class RedeemedCodeDtls implements java.io.Serializable {
    static final long serialVersionUID = 8141524197571985051L;
    /** Holds value of property unitDiscount. */
    private MoneyAmount unitDiscount;
    
    /** Holds value of property discountAmount. */
    private MoneyAmount discountAmount;
    
    /** Holds value of property fuelUOM. */
    private String fuelUOM;
    
    /** Holds value of property popDiscountName. */
    private String popDiscountName;
    
    /** Creates a new instance of OldCodeDetails */
    public RedeemedCodeDtls() {
    }
    
    /** Getter for property unitDiscount.
     * @return Value of property unitDiscount.
     *
     */
    public MoneyAmount getUnitDiscount() {
        return this.unitDiscount;
    }
    
    /** Setter for property unitDiscount.
     * @param unitDiscount New value of property unitDiscount.
     *
     */
    public void setUnitDiscount(MoneyAmount unitDiscount) {
        this.unitDiscount = unitDiscount;
    }
    
    /** Getter for property discountAmount.
     * @return Value of property discountAmount.
     *
     */
    public MoneyAmount getDiscountAmount() {
        return this.discountAmount;
    }
    
    /** Setter for property discountAmount.
     * @param discountAmount New value of property discountAmount.
     *
     */
    public void setDiscountAmount(MoneyAmount discountAmount) {
        this.discountAmount = discountAmount;
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
    
    /** Getter for property popDiscountName.
     * @return Value of property popDiscountName.
     *
     */
    public String getPopDiscountName() {
        return this.popDiscountName;
    }
    
    /** Setter for property popDiscountName.
     * @param popDiscountName New value of property popDiscountName.
     *
     */
    public void setPopDiscountName(String popDiscountName) {
        this.popDiscountName = popDiscountName;
    }
    
}
