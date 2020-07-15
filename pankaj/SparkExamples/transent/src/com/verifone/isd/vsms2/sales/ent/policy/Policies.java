/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 28 Aug, 2006                                     Sudesh Srinivasan
 */
package com.verifone.isd.vsms2.sales.ent.policy;

import java.io.Serializable;


/**
 * This is a Value Object class containing an array each of restrictive and regular
 * policies.
 * 
 * @author Sudesh_S1.
 * @version 1.0
 */
public class Policies implements Serializable {
    
    static final long serialVersionUID = -6846842112793307864L;

    public static final String RULES_FILENAME = "rules.xml";
    private Policy[] restrictivePolicies = null;
    private Policy[] regularPolicies = null;
    private Policy[] addItemPolicies = null;

    public Policies() {
        restrictivePolicies = new Policy[0];
        regularPolicies = new Policy[0];
        addItemPolicies = new Policy[0];
    }
    /**
     * @return Returns the regularPolicies.
     */
    public Policy[] getRegularPolicies() {
        return regularPolicies;
    }
    /**
     * @param regularPolicies The regularPolicies to set.
     */
    public void setRegularPolicies(Policy[] regularPolicies) {
        this.regularPolicies = regularPolicies;
    }
    /**
     * @return Returns the restrictivePolicies.
     */
    public Policy[] getRestrictivePolicies() {
        return restrictivePolicies;
    }
    /**
     * @param restrictivePolicies The restrictivePolicies to set.
     */
    public void setRestrictivePolicies(Policy[] restrictivePolicies) {
        this.restrictivePolicies = restrictivePolicies;
    }
    
   /**
    * Setter for addItemPolicies
    * @param addItemPolicies
    */
    public void setAddItemPolicies(Policy[] addItemPolicies) {
        this.addItemPolicies = addItemPolicies;
    }
    
  /**
   * Returns addItemPolicies
   * @return addItemPolicies
   */
    public Policy[] getAddItemPolicies() {
       return  addItemPolicies;
    }
    
}
