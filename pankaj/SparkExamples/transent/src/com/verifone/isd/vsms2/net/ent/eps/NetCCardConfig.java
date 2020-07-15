/* Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
*
* Created on Nov 18, 2009                                     jabbar_p1
*/

package com.verifone.isd.vsms2.net.ent.eps;

import com.verifone.isd.vsms2.net.ent.NetCCardConfigBase;

/**
 * This class holds the information for POP by card type.
 * 
 * @author jabbar_p1
 */
public class NetCCardConfig extends NetCCardConfigBase {
	private static final long serialVersionUID = -8871901328854136013L;
    
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof NetCCardConfig) {
            NetCCardConfig cardRecord = (NetCCardConfig) obj;
            if (this.getPK().equals(cardRecord.getPK())) {
                result = true;
            }
        }
        return result;
    }    
}

