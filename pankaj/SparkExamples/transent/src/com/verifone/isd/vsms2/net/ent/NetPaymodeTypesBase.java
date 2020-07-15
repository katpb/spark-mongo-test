/*
 * NetPaymodeTypesBase.java
 *
 * Created on January 19, 2005, 3:12 PM
 */

package com.verifone.isd.vsms2.net.ent;

import java.io.Serializable;
import java.io.ObjectStreamException;

/**
 *
 * @author  Aaron_S1
 */
public class NetPaymodeTypesBase implements Serializable {
    
    private final transient String name;
    private transient boolean epsPayment = true;	// if approved by EPS
    private transient boolean mobilePayment = false;	// if approved by Mobile Service

    /** Creates a new instance of NetPaymodeTypesBase */
    protected NetPaymodeTypesBase(String name) {
        this.name = name;
    }

    /**
	 * @param name
	 * @param epsPayment
	 */
	protected NetPaymodeTypesBase(String name, boolean epsPayment) {
		this.name = name;
		this.epsPayment = epsPayment;
	}
	
	protected NetPaymodeTypesBase(String name, boolean epsPayment, boolean mobilePayment) {
		this.name = name;
		this.epsPayment = epsPayment;
		this.mobilePayment = mobilePayment;
	}

	public static NetPaymodeTypesBase PAY_CREDIT = new NetPaymodeTypesBase("C");  	/* Credit transaction */
    public static NetPaymodeTypesBase PAY_DEBIT = new NetPaymodeTypesBase("D");  	/* Debit transaction */
    public static NetPaymodeTypesBase PAY_STORE = new NetPaymodeTypesBase("S");  	/* Store Commercial */
    public static NetPaymodeTypesBase PAY_FAST_CREDIT = new NetPaymodeTypesBase("F");  	/* Fast Credit transaction */
    public static NetPaymodeTypesBase PAY_FAST_DEBIT = new NetPaymodeTypesBase("G");  	/* Fast Debit transaction */
    public static NetPaymodeTypesBase PAY_FORCE_CREDIT = new NetPaymodeTypesBase("K");  /* Forced Credit transaction - */
    public static NetPaymodeTypesBase PAY_PREPAID = new NetPaymodeTypesBase("P");  	/* Prepaid transaction */
    public static NetPaymodeTypesBase PAY_EBT_FS = new NetPaymodeTypesBase("E");        /* EBT Foodstamp payment */
    public static NetPaymodeTypesBase PAY_EBT_CASH = new NetPaymodeTypesBase("H");      /* EBT Cash Benefit payment */
    public static NetPaymodeTypesBase PAY_SPEEDPASS = new NetPaymodeTypesBase("SP");	/*Speedpass Transaction*///TODO get value for PAY_SPEEDPASS
    public static NetPaymodeTypesBase PAY_MOBILE = new NetPaymodeTypesBase("M", false, true);	/*Mobile Transaction, does not use EPS */
    public static NetPaymodeTypesBase PAY_SLA_MOBILE = new NetPaymodeTypesBase("MS", true, true);	/*Mobile SLA Transaction, uses EPS */
    public static NetPaymodeTypesBase PAY_RING = new NetPaymodeTypesBase("R");	/* Avi Transaction */

    
    public String toString() {
        return this.name;
    }
    
    // Prevent subclasses from overrideing Object.equals and Object.hashCode
    public final boolean equals(Object that) {
        return super.equals(that);
    }
    public final int hashCode() {
        return super.hashCode();
    }
    
    // The 4 declarations below are necessary for serialization
    private static int nextOrdinal = 0;
    private final int ordinal = nextOrdinal++;
    private static final NetPaymodeTypesBase[] VALUES = {PAY_CREDIT, PAY_DEBIT, PAY_STORE, PAY_FAST_CREDIT, PAY_FAST_DEBIT, PAY_FORCE_CREDIT, PAY_PREPAID, PAY_EBT_FS, PAY_EBT_CASH, PAY_SPEEDPASS, PAY_MOBILE, PAY_SLA_MOBILE};
    Object readResolve() throws ObjectStreamException {
        return VALUES[ordinal];  // Canonicalize
    }
    
    /** Method to get the NetPayModeTypesBase object for a specified 
     * pay mode String.
     * @param paymode pay mode String represented by the object
     * @return NetPaymodeTypesBase object representing the pay mode
     */
    public static NetPaymodeTypesBase getObject(String paymode) {
        NetPaymodeTypesBase paymodeTypeObj = null;
        for (int i = 0; i < VALUES.length; i++) {
            if (VALUES[i].toString().equalsIgnoreCase(paymode)) {
                paymodeTypeObj = VALUES[i];
                break;
            }
        }
        return paymodeTypeObj;
    }

	/**
	 * @return the epsPayment
	 */
	public boolean isEpsPayment() {
		return epsPayment;
	}
	
	/**
	 * @return the epsPayment
	 */
	public boolean isMobilePayment() {
		return mobilePayment;
	}
}
