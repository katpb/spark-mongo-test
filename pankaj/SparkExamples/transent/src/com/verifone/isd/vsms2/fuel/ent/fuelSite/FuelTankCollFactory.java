package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import com.verifone.isd.vsms2.sys.util.ISapphireCollection;

/**
 *  class to create the singleton Fuel Tank Collection.
 *
 *  @author "mailto:bhanu_narayanan@verifone.com"
 *  @see FuelTankColl
 */
class FuelTankCollFactory {
    /**
     * this class is a simple wrapper to get the singleton instance of the Fuel tank
     * collection.
     * @return the ISapphireCollection interface of the fuel tank collection object.
     */
    public static ISapphireCollection create() {
        return new FuelTankColl();
    }
}
