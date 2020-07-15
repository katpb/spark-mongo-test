/*-
 * Copyright (C) 2003 Verifone, Inc.                     ALL RIGHTS RESERVED
 *
 * Valero demonstration version
 * Created September 30, 2004                            Anindya Datta
 *
 * Describe the buypass network specific product codes which
 * will be used by the app-specific card transactions controller
 * on Topaz to form the product data based on the item and payment
 * lines in the transaction entity object
 *
 */

package com.verifone.isd.vsms2.net.ent;

public class ProdCodeConstants {
	
    /**
	 * The maximum number of product buckets in the collection.
	 */
	public static final short MAXPRODS = 999;

	/**
	 * The product is not sold. Represents a blank network product bucket.
	 */
	public static final short PRODNOTSOLD = 0;

	/**
	 * A non fuel product. The product bucket contains a non fuel item.
	 */
	public static final short NONFUELPROD = 1;

	/**
	 * A fuel product. Product bucket contains a fuel item.
	 */
	public static final short FUELPROD = 2;

	/**
	 * Product bucket represents a method of payment.
	 */
	public static final short MOPPROD = 3;
    
    public static final short FUELPCODE = 4;
    public static final short KEROPCODE = 5;
    public static final short DSLPCODE = 6;
    public static final short MDSEPCODE = 7;
    public static final short BATTACCPCODE = 8;
    public static final short LABORPCODE = 9;
    public static final short TIRESPCODE = 10;
    public static final short OILPCODE = 14;
    public static final short LUBEPCODE = 15;
    
    /** POS Coupon Tax product code. Not really a product but
     * reported to the network as a special bucket.
     */
    public static final short COUPONPCODE = 18;
    
    public static final short CNGPCODE = 19;
    
    /** POS Tax product code. Not a product but reported to
     * the network as a special bucket.
     */
    public static final short TAXPCODE = 20;
    
    public static final short WASHPCODE = 21;
    public static final short TOWPCODE = 22;
    public static final short REPAIRPCODE = 23;
    public static final short AUTOPARTSPCODE = 24;
    public static final short AUTOMDSEPCODE = 29;
    public static final short DSLFSPCODE = 32;
	public static final short CIGSPCODE	= 35;
	public static final short TOBACCOPCODE = 36;	
	public static final short BEERPCODE = 37;	
	public static final short WINEPCODE = 38;	
	public static final short LIQOURPCODE = 39;	
	public static final short PREPAIDPCODE = 40;
	public static final short ANTIFREZPCODE	= 41;		
    
	/** POS product code for a positive fuel tax adustment. 
	 * Not really a product code but this is reported to certain networks.
     */
    public static final short FUELADJPOS = 43;
	
    /** POS Network product code for a negative fuel tax adjustment.
     * Not really a product but repored to certain networks.
     */
    public static final short FUELADJNEG = 44;
    
    public ProdCodeConstants() {
    }
}
