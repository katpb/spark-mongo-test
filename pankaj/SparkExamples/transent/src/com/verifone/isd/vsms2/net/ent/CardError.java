/*
 * CardError.java
 *
 * Created on April 30, 2003, 11:32 AM
 */

package com.verifone.isd.vsms2.net.ent;

/**
 *
 * @author  Anindya_D1
 */
public class CardError {
    
// Note:  This class is prob going to be replaced by some sort of card error exception 
// in the future.  Just left this here til the decision is made.

    // Error codes resulting from parse card
	public static final int CARDERR_OK = 0;
	public static final int CARDERR_INFO = 1;
	public static final int CARDERR_BAD_READ = 2;
	public static final int CARDERR_INVALID = 3;
	public static final int CARDERR_WRONG_TYPE = 4;
	public static final int CARDERR_EXPIRED = 5;
	public static final int CARDERR_NOTALLOWED = 6;
	public static final int CARDERR_ACCT_LEN = 7;
	public static final int CARDERR_LUHN_CHECK = 8;
	public static final int CARDERR_SVC_CODE = 9;
        public static final int CARDERR_NO_MANUAL = 10;

	/** Creates a new instance of CardDef */
	public CardError() {
	}

}
