package com.verifone.isd.vsms2.fuel.ent.fuelSite;

import com.verifone.isd.vsms2.sys.error.VFIException;
import com.verifone.isd.vsms2.sys.l10n.LocalizedRB;
import java.util.ArrayList;

/**
 *  Designates an error within the Fuel subsystem.
 *  Extends the VFIException so the existing Fuel POS interface does not need to be changed.
 */

public class FuelException extends  VFIException {

     /**
     * constructor
     * @param errorKey key for the error resource
     * @param source Source exception as a Throwable object.
     */
    public FuelException(String errorKey, Throwable source) {
        super(errorKey, LocalizedRB.FUELVIEW_RESOURCE, source);
    }

    /**
     * constructor
     * @param errorKey key for the error resource
     * @param bundleName name of the resource bundle
     */
    public FuelException(String errorKey, String bundleName) {
        super(errorKey, bundleName);
    }

    /**
     * constructor
     *
     * @param errorKey Key for the error resource
     * @param bundleName name of the resource bundle
     * @param source Source exception as a Throwable object.
     */
    public FuelException(String errorKey, String bundleName, Throwable source) {
        super(errorKey, bundleName, source);
    }

    /**
     *
     * @param errorKey
     * @param bundleName
     * @param errorParams
     */
    public FuelException(String errorKey, String bundleName, ArrayList errorParams) {
        super(errorKey, bundleName, errorParams);
    }

    public FuelException(String errorKey, String bundleName, ArrayList errorParams, Throwable source) {
        super(errorKey, bundleName, errorParams, source);
    }


}

