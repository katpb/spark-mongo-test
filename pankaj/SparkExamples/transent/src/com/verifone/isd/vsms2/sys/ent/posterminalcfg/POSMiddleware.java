/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 08 June, 2009                                     Ganesh Kumar
 */
package com.verifone.isd.vsms2.sys.ent.posterminalcfg;

import com.verifone.isd.vsms2.sys.ent.middlewareversion.MiddlewareVersionInfo;


/** Entity class for POSMiddleware.
 * @author ganesh_k1
 * @version 1.0
 */
public class POSMiddleware implements java.io.Serializable {

    private static final long serialVersionUID = -3756025245513580419L;
    private long versionInfoID;
    private MiddlewareVersionInfo versionInfo;

    /**
     * default constructor
     */
    public POSMiddleware() {
    }    

    /**
     * @return the versionInfoID
     */
    public long getVersionInfoID() {
	return versionInfoID;
    }

    /**
     * @param versionInfoID the versionInfoID to set
     */
    public void setVersionInfoID(long versionInfoID) {
	this.versionInfoID = versionInfoID;
    }

    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {
	if (this.versionInfoID < 0) {
	    throw new Exception("Invalid versionInfoID for posmiddleware : " +versionInfoID);
	}
    }

    /** String representation of the entity
     * @return String representation of the entity
     */    
    public String toString() {
	return "versionInfoID:" + versionInfoID;
    }

    /**
     * @return the versionInfo
     */
    public MiddlewareVersionInfo getVersionInfo() {
        return versionInfo;
    }

    /**
     * @param versionInfo the versionInfo to set
     */
    public void setVersionInfo(MiddlewareVersionInfo versionInfo) {
        this.versionInfo = versionInfo;
    }
}

