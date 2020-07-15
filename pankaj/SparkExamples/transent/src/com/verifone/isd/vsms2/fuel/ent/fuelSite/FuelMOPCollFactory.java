package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import com.verifone.isd.vsms2.sys.util.ISapphireCollection;

/**
 *  class to create the singleton Fuel MOP Collection.
 *
 *  @author "mailto:bhanu_narayanan@verifone.com"
 *  @see FuelMOPColl
 */
class FuelMOPCollFactory {
    /**
     * this class is a simple wrapper to get the singleton instance of the Fuel MOP
     * collection.
     * @return the ISapphireCollection interface of the fuel MOP collection object.
     */
    public static ISapphireCollection create() {
        return new FuelMOPColl();
    }
}
