package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import com.verifone.isd.vsms2.sys.util.ISapphireCollection;

/**
 *  class to create the singleton NAX Fuel Product Collection.
 *
 *  @see NAXFuelProductColl
 */
class NAXFuelProductCollFactory {
    /**
     * this class is a simple wrapper to get the singleton instance of the NAX Fuel product
     * collection.
     * @return the ISapphireCollection interface of the NAX fuel product collection object.
     */
    public static ISapphireCollection create() {
        return new NAXFuelProductColl();
    }
}
