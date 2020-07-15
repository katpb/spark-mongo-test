/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.verifone.isd.vsms2.fuel.ent.util;

import java.io.Serializable;

import com.verifone.isd.vsms2.fuel.ent.fuelSite.FuelProduct;
import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/**
 *
 * @author kelvin_f1
 */
public class FuelProductDiscount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4125449678443264918L;
	private FuelProduct fuelProduct;
    private MoneyAmount discount;

    /**
     *
     * @param fuelProduct
     * @param discount
     */
    public FuelProductDiscount(FuelProduct fuelProduct, MoneyAmount discount) {
        this.fuelProduct = fuelProduct;
        this.discount = discount;
    }

    /**
     * @return the fuelProduct
     */
    public FuelProduct getFuelProduct() {
        return fuelProduct;
    }

    /**
     * @param fuelProduct the fuelProduct to set
     */
    public void setFuelProduct(FuelProduct fuelProduct) {
        this.fuelProduct = fuelProduct;
    }

    /**
     * @return the discount
     */
    public MoneyAmount getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(MoneyAmount discount) {
        this.discount = discount;
    }

}
