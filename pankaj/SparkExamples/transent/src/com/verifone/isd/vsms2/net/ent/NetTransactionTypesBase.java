/*-
 * Copyright (C) 2005 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * BASE version
 * A serializeable, extensible typesafe enum
 *
 * Created January 17, 2005                            Aaron Sorgius
 *
 */

package com.verifone.isd.vsms2.net.ent;

import java.io.Serializable;
import java.io.ObjectStreamException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.SysPropertyFactory;

/* Constants taken from netdef.h */
import java.io.InputStream;
public class NetTransactionTypesBase implements Serializable {
	
	private static final Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.NetTransactionTypesBase.class);
	private static final long serialVersionUID = 5858187222697684747L;
    private transient int number;
    private transient String name;
    private static Properties prop = null;

    static {
        String propFile = "NetTranType.prop";
        prop = new Properties();

        InputStream inStream = null;
        // Read properties file.
        try {
            inStream = new FileInputStream(SysPropertyFactory.makeAbsoluteConfigPath(propFile));
            prop.load(inStream);
        } catch (IOException e) {
            LoggerFactory.getLogger(com.verifone.isd.vsms2.net.ent.NetTransactionTypesBase.class)
			              .error( "Error loading NetTranType.properties file:" + propFile + " " + e.getMessage());
        }
        finally {
            if (null != inStream) {
                try {
                    inStream.close();
                }
                catch (IOException ioe) {}
            }
        }
    }
    /** Constructor to allow subclassing
     * @param name Transaction Type's name
     */
    protected NetTransactionTypesBase(String name) {
        String value = prop.getProperty(name);
        
        if (value != null && value.length() > 0){
             this.number = Integer.parseInt(value.trim());      // From properties file.
        }
        this.name = name;
    }
    
    public static NetTransactionTypesBase TRAN_SALE = new NetTransactionTypesBase("TRAN_SALE");  	/* Sale Transaction */
    public static NetTransactionTypesBase TRAN_CANCEL = new NetTransactionTypesBase("TRAN_CANCEL");       /* Cancel a transaction */
    public static NetTransactionTypesBase TRAN_UPDATE_PUMP = new NetTransactionTypesBase("TRAN_UPDATE_PUMP");       /* Update pump command/fast credit */
    public static NetTransactionTypesBase TRAN_CLOSE = new NetTransactionTypesBase("TRAN_CLOSE");       /* Close the shift */
    public static NetTransactionTypesBase TRAN_VERIFY = new NetTransactionTypesBase("TRAN_VERIFY");       /* Preauthorization - card verify */
    public static NetTransactionTypesBase TRAN_DELETE = new NetTransactionTypesBase("TRAN_DELETE");       /* Delete transaction */
    public static NetTransactionTypesBase TRAN_DOWN = new NetTransactionTypesBase("TRAN_DOWN");       /* Down Line Load Request */
    public static NetTransactionTypesBase TRAN_PARMDOWN = new NetTransactionTypesBase("TRAN_PARMDOWN");       /* Parameter Download Request */
    public static NetTransactionTypesBase TRAN_CHKAUTH = new NetTransactionTypesBase("TRAN_CHKAUTH");       /* Check Authorization */
    public static NetTransactionTypesBase TRAN_REFUND = new NetTransactionTypesBase("TRAN_REFUND");       /* Refund Request */
    public static NetTransactionTypesBase TRAN_DIAG = new NetTransactionTypesBase("TRAN_DIAG");      /* Diagnostic Request */
    public static NetTransactionTypesBase TRAN_RMAIL = new NetTransactionTypesBase("TRAN_RMAIL");      /* Read Electronic Mail */
    public static NetTransactionTypesBase TRAN_COLLECT = new NetTransactionTypesBase("TRAN_COLLECT");      /* Data collect for preauth or voice auth */
    public static NetTransactionTypesBase TRAN_LOCAL = new NetTransactionTypesBase("TRAN_LOCAL");      /* Local collect for auth only */
    public static NetTransactionTypesBase TRAN_PEND = new NetTransactionTypesBase("TRAN_PEND");      /* retrieve pending messages */
    public static NetTransactionTypesBase TRAN_SEND_REFUND = new NetTransactionTypesBase("TRAN_SEND_REFUND");      /* Refund Req - dc sent immediately */
    public static NetTransactionTypesBase TRAN_DBSALE = new NetTransactionTypesBase("TRAN_DBSALE");      /* Debit purchase */
    public static NetTransactionTypesBase TRAN_DBREFUND = new NetTransactionTypesBase("TRAN_DBREFUND");      /* Debit refund */
    public static NetTransactionTypesBase TRAN_DBVERIFY = new NetTransactionTypesBase("TRAN_DBVERIFY");      /* Debit pre-authorization */
    public static NetTransactionTypesBase TRAN_DBRESERVE = new NetTransactionTypesBase("TRAN_DBRESERVE");      /* Debit reserve funds */
    public static NetTransactionTypesBase TRAN_DBKEY = new NetTransactionTypesBase("TRAN_DBKEY");      /* Debit session key request */
    public static NetTransactionTypesBase TRAN_DBDCSALE = new NetTransactionTypesBase("TRAN_DBDCSALE");      /* Debit sale data collect */
    public static NetTransactionTypesBase TRAN_DBREVERSAL = new NetTransactionTypesBase("TRAN_DBREVERSAL");      /* Debit purchase/refund reversal */
    public static NetTransactionTypesBase TRAN_DBDCREFUND = new NetTransactionTypesBase("TRAN_DBDCREFUND"); /* Debit refund data collect */
    public static NetTransactionTypesBase TRAN_SVC_BALINQ = new NetTransactionTypesBase("TRAN_SVC_BALINQ");          /* Prepaid Balance Inquiry */
    public static NetTransactionTypesBase TRAN_SVC_ACTIVATE = new NetTransactionTypesBase("TRAN_SVC_ACTIVATE");        /* Prepaid Activation */
    public static NetTransactionTypesBase TRAN_SVC_DEACTIVATE	= new NetTransactionTypesBase("TRAN_SVC_DEACTIVATE");    /* Prepaid Deactivation */
    public static NetTransactionTypesBase TRAN_SVC_RECHARGE = new NetTransactionTypesBase("TRAN_SVC_RECHARGE");     /* Prepaid Recharge */
    public static NetTransactionTypesBase TRAN_SVC_VOID_ACTIVATE = new NetTransactionTypesBase("TRAN_SVC_VOID_ACTIVATE");  /* Prepaid Void Activation */
    public static NetTransactionTypesBase TRAN_SVC_VOID_RECHARGE = new NetTransactionTypesBase("TRAN_SVC_VOID_RECHARGE");  /* Prepaid Void Recharge */
    public static NetTransactionTypesBase TRAN_QUICKCRED = new NetTransactionTypesBase("TRAN_QUICKCRED");      /* Quick credit/honor all transtype */
    public static NetTransactionTypesBase TRAN_EBSALE = new NetTransactionTypesBase("TRAN_EBSALE");      /* EBT purchase */
    public static NetTransactionTypesBase TRAN_EBVOUCHER = new NetTransactionTypesBase("TRAN_EBVOUCHER");      /* EBT voucher purchase clear */
    public static NetTransactionTypesBase TRAN_EBREFUND = new NetTransactionTypesBase("TRAN_EBREFUND");     /* EBT return */
    public static NetTransactionTypesBase TRAN_EBVOUCHERREF = new NetTransactionTypesBase("TRAN_EBVOUCHERREF");     /* EBT voucher refund clear */
    public static NetTransactionTypesBase TRAN_EBBALINQ = new NetTransactionTypesBase("TRAN_EBBALINQ");     /* EBT balance inquiry */
    public static NetTransactionTypesBase TRAN_EBREVERSAL = new NetTransactionTypesBase("TRAN_EBREVERSAL");     /* EBT reversal */
    public static NetTransactionTypesBase TRAN_BALINQ = new NetTransactionTypesBase("TRAN_BALINQ");                     /* Balance Inquiry */
    public static NetTransactionTypesBase TRAN_VOID = new NetTransactionTypesBase("TRAN_VOID");                         /* VOID Partial credit sale*/
    public static NetTransactionTypesBase TRAN_VOID_PREAUTH = new NetTransactionTypesBase("TRAN_VOID_PREAUTH");         /* VOID Partial credit pre-auth */
    public static NetTransactionTypesBase TRAN_PARTIAL_AUTH = new NetTransactionTypesBase("TRAN_PARTIAL_AUTH");         /* Partial Credit sale */
    public static NetTransactionTypesBase TRAN_PARTIAL_PREAUTH = new NetTransactionTypesBase("TRAN_PARTIAL_PREAUTH");   /* Partial credit pre-auth */    
    public static NetTransactionTypesBase TRAN_CARDLOAD=new NetTransactionTypesBase("TRAN_CARDLOAD");  /* ReadyLink card load */

    /** Override toString() method to provide the Transaction Type's name
     * @return Transaction type's name
     */    
    public String toString() {
        return this.name;
    }
    
    /** Getter for Trantype number
     * @return Trantype number
     */    
    public int getNumber() {
        return this.number;
    }


    /** Prevent subclasses from overriding Object.equals to ensure
     * the following contract of typesafe enum:
     * "All equal objects of the enumerated type are also
     * identical i.e., a.equals(b) iff a==b".
     * Thus, it is enough to do an == instead of the expensive
     * Object.equals method
     * @param that Object to be compared for equality
     * @return true if the compared instance satisfies == test
     */    
    public final boolean equals(Object that) {
        return super.equals(that);
    }
    /** Prevent subclasses from overriding Object.hashCode() to ensure
     * the following contract of typesafe enum:
     * "All equal objects of the enumerated type are also
     * identical i.e., a.equals(b) iff a==b".
     * Thus, it is enough to do an == instead of the expensive
     * Object.equals method
     * @return Value returned by super class's hashCode() method
     */    
    public final int hashCode() {
        return super.hashCode();
    }
    
    // The 4 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++;
    private static final NetTransactionTypesBase[] VALUES = {TRAN_SALE, TRAN_CANCEL, TRAN_UPDATE_PUMP, TRAN_CLOSE, TRAN_VERIFY, TRAN_DELETE,
                            TRAN_DOWN, TRAN_PARMDOWN, TRAN_CHKAUTH, TRAN_REFUND, TRAN_DIAG, TRAN_RMAIL, TRAN_COLLECT, TRAN_LOCAL, TRAN_PEND,
                            TRAN_SEND_REFUND, TRAN_DBSALE, TRAN_DBREFUND, TRAN_DBVERIFY, TRAN_DBRESERVE, TRAN_DBKEY, TRAN_DBDCSALE, TRAN_DBREVERSAL, 
                            TRAN_DBDCREFUND, TRAN_SVC_BALINQ, TRAN_SVC_ACTIVATE, TRAN_SVC_DEACTIVATE, TRAN_SVC_RECHARGE, 
							TRAN_SVC_VOID_ACTIVATE, TRAN_SVC_VOID_RECHARGE, TRAN_QUICKCRED,
							TRAN_EBSALE, TRAN_EBVOUCHER, TRAN_EBREFUND, TRAN_EBVOUCHERREF,
                                                        TRAN_EBBALINQ, TRAN_EBREVERSAL,TRAN_BALINQ,TRAN_VOID,TRAN_VOID_PREAUTH,
                                                        TRAN_PARTIAL_AUTH,TRAN_PARTIAL_PREAUTH,TRAN_CARDLOAD};
    /** Method to prevent duplicate constants from coexisting as a
     * result of deserialization (ensures that only a single object
     * represents each enum constant. This method is automatically
     * invoked by the serialization mechanism. Without this method,
     * Object.equals() method would be more involved and not a
     * straightforward super.equals() which does just a == check.
     * @throws java.io.ObjectStreamException on serialization system issues
     * @return the enum array
     */
    Object readResolve() throws ObjectStreamException {
        return VALUES[ordinal];  // Canonicalize
    }
    
    /** Method to get the NetTransactionTypesBase object for a specified 
     * tran type number.
     * @param number tran type number represented by the object
     * @return NetTransactionTypesBase object representing the number
     */
    protected static NetTransactionTypesBase getObject(int number) {
        NetTransactionTypesBase tranTypeObj = null;
        for (int i = 0; i < VALUES.length; i++) {
            if (VALUES[i].getNumber() == number) {
                tranTypeObj = VALUES[i];
                break;
            }
        }
        return tranTypeObj;
    }
    
    /** Getter for all the NetTransactionTypesBase objects
     * @return array of NetTransactionTypesBase
     */    
    protected static NetTransactionTypesBase[] getObjects() {
        NetTransactionTypesBase[] types = new NetTransactionTypesBase[VALUES.length];
        System.arraycopy(VALUES, 0, types, 0, VALUES.length);
        return types;
    }
}
