package com.verifone.isd.vsms2.sales.ent.popdiscount;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.log4j.*;

/**
 * Class to contain settings and logic pertaining to POP by BIN range.
 * This class handles both bin masks and bin ranges.  If the mask value
 * is set the class will do mask matches in "acctQualifies", otherwise
 * if begin and end values are set a range check will be done.  If neither 
 * of these conditions are met, the "acctQualifies" method will return 
 * false by default. 
 */
public class CardBinDiscount implements java.io.Serializable 
{
	private static final Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sales.ent.popdiscount.CardBinDiscount.class);
	private static final long serialVersionUID = -3882817566817872570L;

    private static int maxBinLen = 6 ;
    private String mask;
    private String binBegin;
    private String binEnd;
    
    /**
     * Constructor
     */    
    public CardBinDiscount() {
        this.mask = new String();
        this.binBegin = new String();
        this.binEnd = new String();
    }

    /**
     * Constructor - Sets mask value only
     */    
    public CardBinDiscount(String mask) {
        this.mask = mask;
        this.binBegin = new String();
        this.binEnd = new String();
    }

    /**
     * Constructor - Sets bin begin and end ranges.
     */    
    public CardBinDiscount(String begin, String end) {
        this.mask = new String();
        this.binBegin = begin;
        this.binEnd = end;
    }

    /**
     * Convenience method to determine gempro style binType from state of object.
     * This method is designed to be used primarly by the convertToPS method in the
     * PopDiscountPersistState class when passing a binType back to gempro.
     * @return BIN Type.  Valid values are 0=No pop by bin, 1=pop by bin mask, 
     * 2=pop by bin range, as specified in the PopDiscount class.
     */    
    public int getBinType() {
        int binType = PopDiscount.BIN_TYPE_NONE;    // no pop by bin
        
        if (this.mask != null && this.mask.length() > 0) {
            binType = PopDiscount.BIN_TYPE_MASK;
        } else if (this.binBegin != null && this.binBegin.length() > 0) {   // Range
            binType = PopDiscount.BIN_TYPE_RANGE;
        }
        
        return binType;
    }

    /**
     * Setter for BIN mask
     * @param binMask String of digits, max len - 6.
     */    
    public void setMask(String binMask) {
        if (binMask.length() > maxBinLen) {
            logger.error( "CardBasedDiscount-invalid binMask length, limit is "+maxBinLen+" chars:"+binMask);
            this.mask = binMask.substring(0, maxBinLen);
        } else {
            this.mask = binMask;
        }
    }
    
    /**
     * Getter for BIN Mask
     * @return BIN Mask
     */    
    public String getMask() {
        return this.mask;
    }

    /**
     * Setter for Beginning BIN range
     * @param binBegin String of digits, max len maxBinLen.
     */    
    public void setBinBegin(String binBegin) {
        if (binBegin.length() > maxBinLen) {
            logger.error( "CardBasedDiscount-invalid beginning bin range specified, limit is "+maxBinLen+" chars:"+binBegin);
            this.binBegin = binBegin.substring(0, maxBinLen);
        } else {
            this.binBegin = binBegin;
        }
    }
    
    /**
     * Getter for Beginning BIN Range
     * @return Beginning BIN Range
     */    
    public String getBinBegin() {
        return this.binBegin;
    }

    /**
     * Setter for Ending BIN range.
     * @param binEnd String of digits, max len maxBinLen.
     */    
    public void setBinEnd(String binEnd) {
        if (binEnd.length() > maxBinLen) {
            logger.error( "CardBasedDiscount-invalid ending bin range specified, limit is "+maxBinLen+" chars:"+binEnd);
            this.binEnd = binEnd.substring(0, maxBinLen);
        } else {
            this.binEnd = binEnd;
        }
    }

    /**
     * Getter for Ending BIN Range
     * @return Ending BIN Range
     */    
    public String getBinEnd() {
        return this.binEnd;
    }


    /** Check to see if the passed account number qualifies, based on the bin type.
	 * 
     * @param acctNo number to be tested
     */    
    public boolean acctQualifies(String acctNo) 
	{
        boolean ret;

		switch (getBinType())
		{
			case PopDiscount.BIN_TYPE_NONE:
				ret = true;
				break;

			case PopDiscount.BIN_TYPE_MASK:
				ret = binMatchMask(acctNo);
				break;

			case PopDiscount.BIN_TYPE_RANGE:
				ret = binMatchRange(acctNo);
				break;

			default: // invalid bin type
				ret = false; 
				break;
		}
        return ret;
    }

	/**
	 * Test the incoming account number against this object's BIN mask
	 */
	private boolean binMatchMask(String accountNumber)
	{
		boolean match;
		int i;

		for (i = 0, match = true; i < maxBinLen; ++i)
		{
			if ((i >= accountNumber.length()) || (i >= mask.length()))
				break;
			if (mask.charAt(i) == '*')
				continue;
			if (accountNumber.charAt(i) != mask.charAt(i))
				match = false;
		}
		return match;
	}

	/**
	 * Test the incoming account number against this object's BIN range
	 */
	private boolean binMatchRange(String accountNumber)
	{
		try {
			long account, start, end;
			String s;
	
			s = accountNumber;
			if (s.length() > maxBinLen)
				s = s.substring(0, maxBinLen);
			while (s.length() < maxBinLen)
				s = s + "0";
			account = Long.parseLong(s);
	
			s = digitsOnly(binBegin);
			if (s.length() > maxBinLen)
				s = s.substring(0, maxBinLen);
			while (s.length() < maxBinLen)
				s = s + "0";
			start = Long.parseLong(s);
	
			s = digitsOnly(binEnd);
			if (s.length() > maxBinLen)
				s = s.substring(0, maxBinLen);
			while (s.length() < maxBinLen)
				s = s + "9";
			end = Long.parseLong(s);
	
			return ((start <= account) && (account <= end));
		} catch(NumberFormatException nfe) {
			logger.error("BIN range cannot have non-numeric values ", nfe);
			return false;
		}
	}

	/**
	 * Convenient method to remove non-digit mask characters 
	 * from the BIN range string. It is assumed that masking
	 * characters will be at the end of a BIN range definition.
	 *
	 * @param bin BIN range begin or end definition string
	 * @return BIN range definition without masking characters
	 */
	private String digitsOnly(String bin) {
		StringBuffer buf = new StringBuffer();
		int binLen = bin.length();
		for (int i = 0; i < binLen; i++) {
			char c = bin.charAt(i);
			if (Character.isDigit(c)) {
				buf.append(c);
			}
		}
		return buf.toString();
	}
}
