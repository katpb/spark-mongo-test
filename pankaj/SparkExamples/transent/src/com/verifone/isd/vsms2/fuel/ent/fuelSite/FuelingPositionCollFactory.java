package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import com.verifone.isd.vsms2.sys.util.ISapphireCollection;

/**
 *  class to create the singleton Fueling position Collection.
 *
 *  @author "mailto:bhanu_narayanan@verifone.com"
 *  @see FuelingPositionColl
 */
class FuelingPositionCollFactory {
    /**
     * this class is a simple wrapper to get the singleton instance of the Fueling
     * position collection.
     * @return the ISapphireCollection interface of the fueling position collection object.
     */
    public static ISapphireCollection create() {
        return new FuelingPositionColl();
    }
}
