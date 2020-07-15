package com.verifone.isd.vsms2.sales.ent.trans;

import com.verifone.isd.vsms2.sys.db.pres.IEntityPK;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.log4j.*;


public final class PromoDealIDKey implements IEntityPK
{
    private Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sales.ent.trans.PromoDealIDKey.class);
    static final long serialVersionUID = -7394572069941088252L;
    private int dealID;

    /**
     * Construct a PK from the integer dealID passed in.
     */
    public PromoDealIDKey(int dealID) {
        this.dealID = dealID;
    }
    
    public int getID() {
        return this.dealID;
    }

    /**
     * Interface defined equals method.  
     */
    public boolean equals(IEntityPK obj) {
        boolean ret = false;
        
        if (obj != null && (obj.getClass().equals(this.getClass()))) {
            PromoDealIDKey keyObj = (PromoDealIDKey)obj;
            if (this.dealID == keyObj.dealID) {
                ret = true;
            }
        }
        return ret;
    }
    
    public boolean isValid() {
        boolean ret = false;
        if (this.dealID>=0 && this.dealID<=32767) {
            ret=true;
        }
        return ret;
    }
        
    /**
     * Returns the key string.
     */
    public String toString() {
        return Integer.toString(this.dealID);
    }
    
    public int hashCode(){
		return this.dealID;
	}
}
