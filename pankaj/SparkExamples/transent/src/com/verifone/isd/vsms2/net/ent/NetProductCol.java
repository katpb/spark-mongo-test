/*
 * NetProductCol.java
 *
 * Created on May 02, 2003, 6:40 PM
 */
package com.verifone.isd.vsms2.net.ent;

import java.util.HashMap;

/** NetProductCol represents a collection network products buckets that will be sent to
 *  the credit card host.  Each product bucket can contain one or more products.
 *  The product bucket collection is indexed by the POS product code.
 * @author kelvin_f1
 * @version 1.0
 */
public class NetProductCol implements java.io.Serializable {
    static final long serialVersionUID = -346767209624910438L;

    private HashMap netProductCol;
    
    /** No argument constructor method that creates a collection of product buckets.
     * MAXPRODS determines the number of product buckets created.
     */
    public NetProductCol() {
        this.netProductCol = new HashMap();
    }
    
    /** Return the collection of product buckets as an array of network products.
     * @return An array of network products.
     */
    public NetProduct[] getNetProducts() {
        return (NetProduct[]) this.netProductCol.values().toArray(new NetProduct[0]);
    }
    
    /** Returns the actual number of filled product buckets in the product collection.
     * @return The number of filled product buckets.
     */
    public short getNumProducts() {
        return (short) this.netProductCol.size();
    }

    /** Add a new product bucket to the product collection.  If a product of the same
     * POS network product code exists in the collection add the new product to the existing
     * product bucket.  If this is the first product for this POS product code just store
     * the product bucket by POS product code and increment the number of filled buckets.
     * @param netProduct The new product bucket to be added to the collection.
     */
    public void addNetProduct(NetProduct netProduct) {
        Integer prodCode = new Integer(netProduct.getProdCode());
        
        if (!this.netProductCol.containsKey(prodCode)) {
            /**
             * This is a new product in the collection that contains this
             * POS network product code.  Add to the collection and increment
             * the number of filled buckets.
             */
            this.netProductCol.put(prodCode, netProduct);
        }
        else {
            /**
             * The product bucket contains an existing product.
             * Add the amount, quantity,  and gallons.
             */
            NetProduct existingProd = (NetProduct) this.netProductCol.get(prodCode);
            existingProd.getAmount().add(netProduct.getAmount());
            existingProd.getQuantity().add(netProduct.getQuantity());
            existingProd.getGallons().add(netProduct.getGallons());
        }
    }
    
    /**
	 * Allow the item line description (or any other string) to be used as
	 * the key instead of the product code. Some applications may want to
	 * distinguish between different items even if they are configured for
	 * the same product code
	 * @param netProduct
	 * @param description
	 */
	public void addNetProduct(NetProduct netProduct, String description) {
		/**
		 * If the description is not valid, use the product code as key
		 */
		if ((description == null) || (description.length() == 0)) {
			this.addNetProduct(netProduct);
			return;
		}

		if (!this.netProductCol.containsKey(description)) {
			this.netProductCol.put(description, netProduct);
		} else {
			NetProduct existingProd = (NetProduct) this.netProductCol
					.get(description);
			existingProd.getAmount().add(netProduct.getAmount());
			existingProd.getQuantity().add(netProduct.getQuantity());
			existingProd.getGallons().add(netProduct.getGallons());
		}
	}
}
