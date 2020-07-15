/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
*
* Created 31 Aug, 2005                                     Sudesh Srinivasan
*/
package com.verifone.isd.vsms2.net.ent.prodrest;

import com.verifone.isd.vsms2.net.ent.NetworkException;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import com.verifone.isd.vsms2.sys.util.Quantity;

/**
 * The ProdRestrictionException class is used by the IProdRestInfo object if the
 * product is allowed with a warning.
 * 
 * @author Sudesh_s1
 *  
 */
public class ProdRestrictionException extends NetworkException {
    
    private Quantity quantityLimit;
    private MoneyAmount amountLimit;
    
    private String printMsg;
    private String displayMsg;
    
    /**
     * Default constructor 
     */
    public ProdRestrictionException() {
        super();
    }
    
    /**
     * Overloaded constructor
     * @param qty Quantity
     * @param amt MoneyAmount
     */
    public ProdRestrictionException(Quantity qty, MoneyAmount amt) {
        super();
        this.quantityLimit = qty;
        this.amountLimit = amt;
    }
    
    /**
     * Overloaded constructor
     * @param s
     * @param qty Quantity
     * @param amt MoneyAmount
     */
    public ProdRestrictionException(String s, Quantity qty, MoneyAmount amt) {
        super(s);
        this.quantityLimit = qty;
        this.amountLimit = amt;
    }
    
    /**
     * @return Returns the amountLimit.
     */
    public MoneyAmount getAmountLimit() {
        return amountLimit;
    }
    /**
     * @param amountLimit The amountLimit to set.
     */
    public void setAmountLimit(MoneyAmount amountLimit) {
        this.amountLimit = amountLimit;
    }
    /**
     * @return Returns the quantityLimit.
     */
    public Quantity getQuantityLimit() {
        return quantityLimit;
    }
    /**
     * @param quantityLimit The quantityLimit to set.
     */
    public void setQuantityLimit(Quantity quantityLimit) {
        this.quantityLimit = quantityLimit;
    }

    /** 
     * @return Returns the displayMsg (Warning) 
     */
    public String getDisplayMsg() {
        return displayMsg;
    }
    
    /** 
     * @param displayMsg The displayMsg (Warning) to set  
     */
    public void setDisplayMsg(String displayMsg) {
        this.displayMsg = displayMsg;
    }
    
    /** 
     * @return Returns the printMsg (Warning)
     */
    public String getPrintMsg() {
        return printMsg;
    }

    /** 
     * @param printMsg The printMsg (Warning) to set 
     */
    public void setPrintMsg(String printMsg) {
        this.printMsg = printMsg;
    }
}