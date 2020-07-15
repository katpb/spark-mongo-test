/*
 * NetCCardConfigPK.java
 *
 * Created on June 10, 2003, 4:40 PM
 */
package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/** Primary key class for NetCCardConfig
 * @author "mailto:kelvin_f1@verifone.com"
 */
public class NetCCardConfigPK implements IEntityPK {

    static final long serialVersionUID = -668477294830783527L;
	protected String ccName;
    private static int MAXCCNAMELEN = 16;

    /** Creates a new instance of CategoryPK */
    public NetCCardConfigPK() {
    }

    /** Constructor
     * @param ccName card name
     */
    public NetCCardConfigPK(String ccName) {
        this.ccName = ccName;
    }

    /** Getter for primary key record number
     * @return recordNr the data set key
     */
    public String getValue() {
        return this.ccName;
    }

    /** Method to compare two NetCCardConfigPK objects for equality
     * @param obj IEntityPK object to compare with
     * @return true if the current and compared objects represent the same record number
     */
    public boolean equals(IEntityPK obj) {
        if (obj instanceof NetCCardConfigPK) {
            NetCCardConfigPK dObj = (NetCCardConfigPK)obj;
            return (this.ccName.equals(dObj.ccName));
        }
        return false;
    }
    
    /** Method to compare two NetCCardConfigPK objects for equality
     * @param obj Object to compare with
     * @return true if the IEntityPK Objects are equal
     */
    public boolean equals(Object obj) {
        if (obj instanceof IEntityPK) {
            return this.equals((IEntityPK)obj);
        }
        return false;
    }

    /** Returns the objects string representation
     * @return string representation of the record number
     */
    public String toString() {
        return String.valueOf(this.ccName);
    }

    /** Method to validate the record number
     * @return true if the record number is valid
     */
    public boolean isValid() {
		return (this.ccName != null && this.ccName.trim().length() > 0
				&& this.ccName.trim().length() <= MAXCCNAMELEN && !this.ccName
				.trim().equals("*"));
    }
    
    public static void setMaxCCNameLen(int maxNameLen) {
        MAXCCNAMELEN = maxNameLen;
    }
    
    public static int getMaxCCNameLen() {
        return MAXCCNAMELEN;
    }
}
