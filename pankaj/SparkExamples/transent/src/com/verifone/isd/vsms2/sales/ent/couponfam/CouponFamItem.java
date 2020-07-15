package com.verifone.isd.vsms2.sales.ent.couponfam;

import java.io.Serializable;
import com.verifone.isd.vsms2.sales.ent.plu.PluPK;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.verifone.isd.vsms2.sys.util.log4j.*;

/**
 * This class is a representation of a coupon family item containing a 
 * coupon family code and a PLU number.
 * @author tom_s5
 * @version 1.0
 */
public class CouponFamItem implements Serializable {
    private transient Logger logger
            = LoggerFactory.getLogger(com.verifone.isd.vsms2.sales.ent.couponfam.CouponFamItem.class);
	static final long serialVersionUID = -2703736108133889289L;
	private String famCode;
	private PluPK pluNum;

	/**
	 * Default no-arguments constructor.
	 */
	public CouponFamItem() {
	}

	/**
	 * Constructor that set family code and PLU number.
	 */
	public CouponFamItem(String famCode, String pluNum) {
		this.famCode = famCode;
//		int length = pluNum.length();
		try {
//			this.pluNum = new PluPK(pluNum.substring(0, length - 3),
//					pluNum.substring(length - 3, length));
			this.pluNum = new PluPK(pluNum);
		}
		catch (Exception e) {
			logger.error("CouponFamItem ERROR invalid PLU " + e.toString());
		}
	}

	/**
	 * Gets the family code for this instance.
	 * @return The family code.
	 */
	public String getFamCode() {
		return this.famCode;
	}

	/**
	 * Sets the family code for this instance.
	 * @param famCode  The family code.
	 */
	public void setFamCode(String famCode) {
		this.famCode = famCode;
	}

	/**
	 * Gets the PLU number for this instance.
	 * @return The PLU number.
	 */
	public String getPLUNum() {
		return this.pluNum.getUpc() + this.pluNum.getModifier();
	}

	/**
	 * Sets the PLU number for this instance.
	 * @param pluNum  The PLU number.
	 */
	public void setPLUNum(String pluNum) {
		this.pluNum = new PluPK(pluNum);
	}
}

