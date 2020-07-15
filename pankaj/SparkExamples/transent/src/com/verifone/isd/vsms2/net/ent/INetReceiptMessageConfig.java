package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.db.pres.IEntityObject;

public interface INetReceiptMessageConfig extends IEntityObject{    
    
    public void setRecordNr(short recordNr);
    public String getReceiptLine() ;
    public void setReceiptLine(String recieptLine);
    

}
