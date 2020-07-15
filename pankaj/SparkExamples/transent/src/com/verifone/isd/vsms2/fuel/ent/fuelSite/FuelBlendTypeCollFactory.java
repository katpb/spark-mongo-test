package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import com.verifone.isd.vsms2.sys.util.ISapphireCollection;

/**
 *  class to create the singleton Fuel Blend Type Collection.
 *
 *  @author "mailto:bhanu_narayanan@verifone.com"
 *  @see FuelBlendTypeColl
 */
class FuelBlendTypeCollFactory {
    /**
     * this class is a simple wrapper to get the singleton instance of the
     * Fuel blend type collection.
     * @return the ISapphireCollection interface of the fuel blend type collection object.
     */
    public static ISapphireCollection create() {
        return new FuelBlendTypeColl();
    }
}
