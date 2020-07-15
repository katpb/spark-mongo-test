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
public interface INetDebitConfig extends IEntityObject
{
    static final long serialVersionUID = 8300356937901973091L;
    
    public void setRecordNr(short recordNr);

    public boolean getCashbackEnabled();
    public void setCashbackEnabled(boolean cashbackEnabled);

    public short getCashbackFee();
    public void setCashbackFee(short cashbackFee);

    public short getCashbackLimit();
    public void setCashbackLimit(short cashbackLimit);

    public boolean getEncryptDUKPT();
    public void setEncryptDUKPT(boolean encryptDUKPT);
}
