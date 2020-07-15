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
public class AddlCodeDtls implements java.io.Serializable {
    static final long serialVersionUID = -9043836487123019761L;
    /** Holds value of property codeEligibleGrades. */
    private String codeEligibleGrades;
    
    /** Holds value of property popDiscountName. */
    private String popDiscountName;
    
    /** Creates a new instance of OldCodeDetails */
    public AddlCodeDtls() {
    }
    
    /** Getter for property codeEligibleGrades.
     * @return Value of property codeEligibleGrades.
     *
     */
    public String getCodeEligibleGrades() {
        return this.codeEligibleGrades;
    }
    
    /** Setter for property codeEligibleGrades.
     * @param codeEligibleGrades New value of property codeEligibleGrades.
     *
     */
    public void setCodeEligibleGrades(String codeEligibleGrades) {
        this.codeEligibleGrades = codeEligibleGrades;
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
