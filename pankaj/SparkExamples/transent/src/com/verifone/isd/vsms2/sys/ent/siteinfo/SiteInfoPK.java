/*
 * SiteInfoPK.java
 * Copyright (C) 2012 Verifone, Inc.                     ALL RIGHTS RESERVED
 */
package com.verifone.isd.vsms2.sys.ent.siteinfo;

//
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * Primary key class for SiteInfo entity (SiteInfo is a singleton; implemented only because of interface requirements)
 * @author "mailto:david_g3@verifone.com"
 */
public class SiteInfoPK implements IEntityPK {
    static final long serialVersionUID = -3502698475118774066L;
    
    /** Creates a new instance of SiteInfoPK */
    public SiteInfoPK() {
    }
    
    /** Method to compare two SiteInfoPK objects for equality
     * @param obj SiteInfoPK object to compared with
     * @return true if both objects represent the same product code value
     */    
    @Override
    public boolean equals(IEntityPK obj) {
         if (obj instanceof SiteInfoPK) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof SiteInfoPK) {
            return true;
        }
        return false;
    }
    
    /** 
     * Method override since equals() is implemented
     * @return hash code for the object
     */   
    @Override
    public int hashCode() {
        return 37 * 17;
    }    
    
    /** Validator for the siteinfo PK
     * @return true always
     */    
    @Override
    public boolean isValid() {
        return true;
    } 
}
