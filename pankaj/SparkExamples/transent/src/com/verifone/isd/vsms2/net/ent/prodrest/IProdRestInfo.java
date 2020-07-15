/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 26 Jul, 2005                                     Sudesh Srinivasan
 */
package com.verifone.isd.vsms2.net.ent.prodrest;

import com.verifone.isd.vsms2.net.ent.NetProduct;
import com.verifone.isd.vsms2.net.ent.NetworkException;

/**
 * The IProdRestInfo interface represents an entity that determines whether a
 * given product is restricted or not.
 * 
 * @author Sudesh_s1
 *  
 */
public interface IProdRestInfo {
    public static final String FUEL_RESTRICTION_TYPE = "FuelOnly";
    public static final String REFER_RESTRICTION_TYPE = "Refer";

    /**
     * Returns the restriction type.
     */
    public String getRestrictionType();
    
    /**
     * @param product The <code>NetProduct</code> object to test for validity.
     * @return boolean. Returns true if the product is not restricted. Returns
     *         false if the product is restricted. Returns false if the arg is
     *         null.
     * @throws NetworkException. Throws an exception if the product is allowed
     *         with a warning.
     */
    public boolean isValidProd(NetProduct product) throws ProdRestrictionException;
    
    /**
     * 
     * @param productCode integer product code number
     * @return true if product is not restricted, false otherwise
     * @throws ProdRestrictionException
     */
    public boolean isValidProd(int productCode) throws ProdRestrictionException;
}