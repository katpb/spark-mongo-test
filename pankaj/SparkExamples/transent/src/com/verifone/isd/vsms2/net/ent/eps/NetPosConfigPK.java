/*
 * Verifone Copyright (c) All rights reserved.
 * Author: HimanshuY1
 * Created on Apr 23, 2012
 */
package com.verifone.isd.vsms2.net.ent.eps;

import com.verifone.isd.vsms2.net.ent.NetBatchConfigPK;
import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;

/**
 * @author HimanshuY1
 */
public class NetPosConfigPK implements IEntityPK {

	private static final long serialVersionUID = -7217256110641678216L;
	private short recordNr;

	public NetPosConfigPK(short recordNr) {
		this.recordNr = recordNr;
	}

	/**
	 * Getter for primary key record number
	 * 
	 * @return recordNr the data set key
	 */
	public short getValue() {
		return this.recordNr;
	}

	@Override
	public boolean equals(IEntityPK obj) {
		if (obj instanceof NetPosConfigPK) {
			NetPosConfigPK dObj = (NetPosConfigPK) obj;
			return (this.recordNr == dObj.recordNr);
		}
		return false;
	}
	
	/** 
	 * Method override since equals() is implemented
     * @return hash code for the object
     */
	@Override	 
    public int hashCode() {
        int hc = 98765 * 17;
        return (hc + (int)this.recordNr);
    }
	
	@Override
	public boolean isValid() {
		return (this.recordNr > 0);
	}

}
