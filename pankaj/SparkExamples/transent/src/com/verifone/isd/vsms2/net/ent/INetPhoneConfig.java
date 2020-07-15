/*
 * NetPhoneConfig.java
 *
 * Created on February 13, 2003, 2:46 PM
 */

package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;

/**
 *
 * @author  Anindya_D1
 */
public interface INetPhoneConfig extends IEntityObject
{
    static final long serialVersionUID = -1043288430982291001L;
    
    public void setRecordNr(short recordNr);
}
