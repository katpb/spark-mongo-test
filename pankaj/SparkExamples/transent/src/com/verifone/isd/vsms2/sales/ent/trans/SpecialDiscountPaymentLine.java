/*
 * Created on Apr 12, 2006. (c) VeriFone
 *
 * Selva Sabapathy
 * selva_s1@verifone.com
 */
package com.verifone.isd.vsms2.sales.ent.trans;

import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/**
 * @author Selva_S1
 */
public class SpecialDiscountPaymentLine extends PaymentLine {

    static final long serialVersionUID = -1318124832972645048L;

    private MoneyAmount specialDiscountEligibleTotal;
    
    /**
     * 
     */
    public SpecialDiscountPaymentLine() {
        super();
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
    }
    
    /** @return Returns the specialDiscountEligibleTotal */
    public final MoneyAmount getSpecialDiscountEligibleTotal() {
        return specialDiscountEligibleTotal;
    }
    
    /** @param specialDiscountEligibleTotal The specialDiscountEligibleTotal to set */
    public final void setSpecialDiscountEligibleTotal(MoneyAmount specialDiscountEligibleTotal) {
        this.specialDiscountEligibleTotal = specialDiscountEligibleTotal;
    }
}
