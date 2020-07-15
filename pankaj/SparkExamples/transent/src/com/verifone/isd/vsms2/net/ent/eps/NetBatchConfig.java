/*
 * NetBatchConfig.java
 *
 * Created on August 17, 2006, 08:06 AM
 */

package com.verifone.isd.vsms2.net.ent.eps;

import com.verifone.isd.vsms2.net.ent.INetBatchConfig;
import com.verifone.isd.vsms2.net.ent.NetBatchConfigBase;
import com.verifone.isd.vsms2.net.ent.NetBatchConfigPK;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;

import java.io.Serializable;

/**
 *
 * @author  Peder_K1
 */
public class NetBatchConfig extends NetBatchConfigBase implements Serializable
{
    static final long serialVersionUID =  8953987814174948283L;

    public static final int MAX_BATCH_CONFIG_RECS = 1;
    private static final int MAX_BATCH_CLOSE_PERIOD = 2;

    static {
        NetBatchConfigPK.setMaximumValue(MAX_BATCH_CONFIG_RECS);
        NetBatchConfigBase.setMaxBatchClosePeriod(MAX_BATCH_CLOSE_PERIOD);
    }

     /** Creates a new instance of NetBatchConfig */
    public NetBatchConfig()
    {
        super();
    }


    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {

        super.validate();
        
    }

    public void setAttributes(IEntityObject obj) {
        NetBatchConfig netBatchConfig = (NetBatchConfig)obj;

        super.setAttributes(obj);
    }

}
