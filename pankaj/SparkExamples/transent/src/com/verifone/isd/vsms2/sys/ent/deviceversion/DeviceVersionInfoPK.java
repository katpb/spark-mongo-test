/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Created 08 June, 2009                                     Ganesh Kumar
 */

package com.verifone.isd.vsms2.sys.ent.deviceversion;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
/** Primary key class for DeviceVersionInfo.
 * @author ganesh_k1
 * @version 1.0
 */
public class DeviceVersionInfoPK implements IEntityPK {

    private static final long serialVersionUID = 4638813322328633812L;
    private long versionInfoID;
    
    /** Creates a new instance of DeviceVersionInfoPK */
    public DeviceVersionInfoPK() {
    }

    /** Constructor
     * @param versionInfoID Device version info number
     */    
    public DeviceVersionInfoPK(long versionInfoID) {
        this.versionInfoID = versionInfoID;
    }
    
    /** Getter for versionInfoID
     * @return versionInfoID Device version info number
     */    
    public long getValue() {
        return this.versionInfoID;
    }

    /** Setter for property value.
     * @param value New value of property value.
     */
    public void setValue(long value) {
        this.versionInfoID = value;
    }
    
    /** Method to compare two DeviceVersionInfoPK objects for equality
     * @param obj object to compare with
     * @return true if the current and compared objects represent the same versionInfoID
     */    
    public boolean equals(IEntityPK obj) {
        if (obj instanceof DeviceVersionInfoPK) {
            DeviceVersionInfoPK mObj = (DeviceVersionInfoPK)obj;
            return (this.versionInfoID == mObj.versionInfoID);
        }
        return false;
    }
    
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof IEntityPK) {
            return this.equals((IEntityPK) obj);
        }
        return false;
    } 
    
    /** Method override since equals() is implemented
     * @return hash code for the object
     */   
    public int hashCode() {
        int hc = 37 * 17;
        return (hc + (int)this.versionInfoID);
    }
    
    /** Returns the objects string representation
     * @return string representation of the versionInfoID
     */    
    public String toString() {
        return String.valueOf(this.versionInfoID);
    }
    
     /** Method to valiate the versionInfoID
     * @return true if the versionInfoID is valid
     */    
    public boolean isValid() {
        return (this.versionInfoID > 0);
    }
}
