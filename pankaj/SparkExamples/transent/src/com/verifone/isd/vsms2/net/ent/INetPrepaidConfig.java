/*
 * NetPrepaidConfig.java
 *
 * Created on February 13, 2003, 2:48 PM
 */

package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;

/**
 *
 * @author  Anindya_D1
 */
public interface INetPrepaidConfig extends IEntityObject
{
    static final long serialVersionUID = -569104773073109416L;
    public void setRecordNr(short recordNr);
    public boolean getPrepaidEnabled();
}
