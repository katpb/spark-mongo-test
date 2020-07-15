package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import com.verifone.isd.vsms2.sys.util.ISapphireCollection;

/**
 *  class to create the singleton Fuel Service level Collection.
 *
 *  @author "mailto:bhanu_narayanan@verifone.com"
 *  @see FuelProductColl
 */
class FuelProductCollFactory {
    /**
     * this class is a simple wrapper to get the singleton instance of the Fuel product
     * collection.
     * @return the ISapphireCollection interface of the fuel product collection object.
     */
    public static ISapphireCollection create() {
        return new FuelProductColl();
    }
}
