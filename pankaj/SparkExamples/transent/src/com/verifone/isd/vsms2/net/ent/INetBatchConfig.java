/*
 * NetDebitConfig.java
 *
 * Created on February 13, 2003, 2:47 PM
 */

package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;

/**
 *
 * @author  Anindya_D1
 */
public interface INetBatchConfig extends IEntityObject
{
    static final long serialVersionUID = 1928613900247303379L;
    
    public void setRecordNr(short recordNr);
    public int getBatchClosePeriod();
}
