/*
 * NetDebitReply.java
 *
 * Created on March 21, 2005, 2:29 PM
 */

package com.verifone.isd.vsms2.net.ent;

import com.verifone.isd.vsms2.sys.util.MoneyAmount;

/**
 *
 * @author  Brenda_W
 */
public class NetDebitReply implements java.io.Serializable{
    static final long serialVersionUID =   -2289110315102094221L;
    
	private String debitAuthorizer;
	private String debitAccountType;
	private String debitTraceNumber;

    
    /** Creates a new instance of NetDebitReply */
    public NetDebitReply() {
		debitAuthorizer = new String("");
		debitAccountType = new String("");
		debitTraceNumber = new String("");
    }
    
    public String getDebitAuthorizer() {
        return this.debitAuthorizer;
    }
    
    public void setDebitAuthorizer(String debitAuthorizer) {
        this.debitAuthorizer = debitAuthorizer;
    }
    
    public String getDebitAccountType() {
        return this.debitAccountType;
    }
    
    public void setDebitAccountType(String debitAccountType) {
        this.debitAccountType = debitAccountType;
    }
    
    public String getDebitTraceNumber() {
        return this.debitTraceNumber;
    }
    
    public void setDebitTraceNumber(String debitTraceNumber) {
        this.debitTraceNumber = debitTraceNumber;
    }
    
}
