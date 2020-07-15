/*
 * NetworkConfig.java
 *
 * Created on February 13, 2003, 2:43 PM
 */

package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;

/**
 *
 * @author  Anindya_D1
 */
public interface INetworkConfig	extends IEntityObject
{
    static final long serialVersionUID = 3700673075049373274L;
    
	public boolean equals(Object obj);

	public int getNetworkNum();
	public String getNetworkName();
	public void setNetworkName(String networkName);
    public void setRecordNr(short recordNr);
    public String getMerchantNum();
    public void setMerchantNum(String merchantNum);
     
}
