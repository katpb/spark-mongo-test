package com.verifone.isd.vsms2.sales.ent.plupromo;

import com.verifone.isd.vsms2.sys.util.MoneyAmount;
import com.verifone.isd.vsms2.sys.util.Volume;
import com.verifone.isd.vsms2.sys.util.Quantity;
import com.verifone.isd.vsms2.fuel.ent.fuelSite.IFuelSite;
import java.io.Serializable;
import org.xml.sax.SAXException;

/** Helper class for PLU Promo for carwash PLUs
 * @author "mailto:bhanu_n2@verifone.com"
 */
public class CarWashPromoProperties implements  Serializable { //IDataSetDomainVisitable
    static final long serialVersionUID = 1258313069516062807L;
    //Max Ruby value 999.99
    private static final int MAX_CWPURCH_QUAL = 99999;
    /** Number of decimals in Quantity / MoneyAmount classes used */    
    public static final int NUM_DECIMALS = 2;// to be removed later and use constant from Money Amount.
    private Quantity minPurchase;
    private int restriction;
    
    /** Constructor
     * @param minPurch minimum purchase
     * @param restriction product code restriction
     */    
    public CarWashPromoProperties(Quantity minPurch, int restriction) {
        this.minPurchase = minPurch;
        this.restriction = restriction;
    }
    
    /** Getter for minimumPurchase property
     * @return minimumPurchase property
     */    
    public Quantity getMinimumPurchase() {
        return this.minPurchase;
    }
    
    /** Setter for minimumPurchase property
     * @param minP new minimumPurchase value
     */    
    public void setMinimumPurchase(Quantity minP) {
        this.minPurchase = minP;
    }
    
    /** Getter for product code restriction
     * @return product code restriction
     */    
    public int getRestriction() {
        return this.restriction;
    }
    
    /** Setter for product code restriction
     * @param restriction new product code restriction
     */    
    public void setRestriction(int restriction) {
        this.restriction = restriction;
    }
    
    /** Validator for entity attributes
     * @throws Exception if validation fails
     */    
    public void validate() throws Exception {
    	if (this.minPurchase == null) {
            this.minPurchase = new MoneyAmount(0, NUM_DECIMALS);
        }
    	if (this.minPurchase instanceof Volume) {
    		// For Volume, restriction id should not be available and should be '0' always by default.
    		if (restriction != 0) {
    			throw new Exception("Fuel Product qualifier not applicable for Volume based promo");
    		}
    	} else if (this.restriction < 0 || this.restriction > IFuelSite.MAX_PRODUCTS) {
    		/*
    		 * Actually '0' is not a valid Fuel Product ID.
    		 * But from the Content handler by default sends '0' 
    		 * if the CW Discount type is anything other than Minimum Fuel Product Amount.
    		 * So just to avoid the exception in case of Min Ticket Purchase Amount,
    		 * we are including '0' in this condition
    		 */
    		throw new Exception("Invalid Fuel Product for Carwash PLU Promo");
    	}
        long minPurchVal = this.minPurchase.getLongValue();
        if ((minPurchVal < 0) || (minPurchVal > MAX_CWPURCH_QUAL)) {
            throw new Exception("Invalid minimum purchase for Carwash PLU Promo ");
        }
    }
}
