/*
 * NetworkConfig.java
 *
 * Created on Aug 21, 2006, 2:43 PM
 */

package com.verifone.isd.vsms2.net.ent.eps;

import java.io.Serializable;

import com.verifone.isd.vsms2.net.ent.NetworkConfigBase;
import com.verifone.isd.vsms2.net.ent.NetworkConfigPK;
import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;

/**
 *
 * @author  Peder_K1
 */
public class NetworkConfig extends NetworkConfigBase implements Serializable
{
    static final long serialVersionUID = -8525292308056911160L;
    
    public static final int MAX_NETWORK_CONFIG_RECS = 10;
    public static final int MAX_MERCH_ID_LEN = 11;
    private static final int PHONENR_MAXLEN = 40;
     
     static {
        NetworkConfigPK.setMaximumValue(MAX_NETWORK_CONFIG_RECS);
        NetworkConfigBase.setPhoneNrMaxlen(PHONENR_MAXLEN);
        NetworkConfigBase.setMaxMerchIDLen(MAX_MERCH_ID_LEN);
    }

     /** Creates a new instance of NetworkConfig */
     public NetworkConfig() {
         super();
     }
     
    /** Method to validate an entity object's attributes.
     * @throws Exception if validation fails
     */
    public void validate() throws Exception {

        //super.validate();  
    }

    public void setAttributes(IEntityObject obj) {
        NetworkConfig networkConfig = (NetworkConfig)obj;
        super.setAttributes(networkConfig);
    }   
}
