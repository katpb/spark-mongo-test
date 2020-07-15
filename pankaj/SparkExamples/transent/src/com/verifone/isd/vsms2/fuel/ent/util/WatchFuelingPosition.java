/*
 * WatchFuelingPosition.java
 *
 * Created on August 20, 2004
 */

package com.verifone.isd.vsms2.fuel.ent.util;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author  D. Michael Barton
 */
public class WatchFuelingPosition implements Serializable {
    
    static final long VersionUID = -3602398625371233969L;
    
    private short fuelingPosition = 0;
    private short terminalID = 0;

    /** Creates a new instance of StopFuelingPosition */
    public WatchFuelingPosition(short fuelingPosition, short terminalID) {

        this.fuelingPosition = fuelingPosition;
        this.terminalID = terminalID;
    }
    
    public short getFuelingPosition() {
        return(fuelingPosition);
    }

    public short getTerminalID() {
	return(terminalID);
    }
}
