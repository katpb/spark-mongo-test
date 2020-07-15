package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import com.verifone.isd.vsms2.sys.util.ISapphireCollection;

/**
 *  class to create the singleton Fuel Tier Collection.
 *
 *  @author "mailto:bhanu_narayanan@verifone.com"
 *  @see FuelTierColl
 */
class FuelTierCollFactory {
    /**
     * this class is a simple wrapper to get the singleton instance of the Fuel tier
     * collection.
     * @return the ISapphireCollection interface of the fuel tier collection object.
     */
    public static ISapphireCollection create() {
        return new FuelTierColl();
    }
}
