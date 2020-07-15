/*
 * AuthorizingTerminal.java
 *
 * Created on February 14, 2003, 9:49 PM
 */

package com.verifone.isd.vsms2.fuel.ent.util;

import java.io.Serializable;

/**
 *
 * @author  D. Michael Barton
 */
public class AuthorizingTerminal implements Serializable {
    
    static final long VersionUID = 8933914700192829512L;
    
    private short terminalID = 0;
    private int transactionNumber = 0;

    
    /** Creates a new instance of AuthorizingTerminal */
    public AuthorizingTerminal() {
    }

    /**
     * Getter method for "Terminal Id"
     * @return short
     */
    public short getTerminalID() {
        return this.terminalID;
    }
    
    /**
     * Setter method for "Terminal Id"
     * @param terminalID
     */
    public void setTerminalID(short terminalID) {
        this.terminalID = terminalID;
    }

    /**
     * Getter method for "Transaction Number"
     * @return int
     */
    public int getTransactionNumber() {
        return this.transactionNumber;
    }
    
    /**
     * Setter method for "Transaction Number"
     * @param transactionNumber
     */
    public void setTransactionNumber(int transactionNumber) {
        this.transactionNumber = transactionNumber;
    }
}
