/*
 * NetDealerConfig.java
 *
 * Created on February 13, 2003, 2:48 PM
 */

package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;
import com.verifone.isd.vsms2.sys.util.PromptOptionsType;

/**
 *
 * @author  Anindya_D1
 */
public interface INetDealerConfig extends IEntityObject
{
    static final long serialVersionUID = -2375282686836956826L;
    
    public void setRecordNr(short recordNr);
    
    public String getDealerAddress();
    public void setDealerAddress(String dealerAddress);

    public String getDealerName();
    public void setDealerName(String dealerName);

    public int getDispMsgPersist();
    public void setDispMsgPersist(int dispMsgPersist);
    
    public boolean getRefundAllowed();
    public void setRefundAllowed(boolean refundAllowed);
    
    public boolean getPrtCustCopy();
    public void setPrtCustCopy(boolean prtCustCopy);
    
    public PromptOptionsType getPrtPromptCustCopy();
    public void setPrtPromptCustCopy(PromptOptionsType custCopy);
    
    public boolean isPrtMerchCopy();
    public void setPrtMerchCopy(boolean prtMerchCopy);
}
